package com.bytedance.reparo.core;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends WandTrick {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<ClassLoader> f267367j;

    public f() {
        this.f267367j = new ArrayList();
    }

    @Override // com.bytedance.reparo.core.WandTrick
    public final WandTrick.a b(Application r210, boolean r211, Map<Class, h> r212, List<String> r213, List<String> r214, List<Object> r215, d97.b r216, d97.d r217) throws Exception {
        Method r100 = n.b().getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Exception -> L7
        String r101 = (String) r100.invoke(null, new Object[]{"ro.yunos.version"});     // Catch: Exception -> L7
        String r102 = (String) r100.invoke(null, new Object[]{"java.vm.name"});     // Catch: Exception -> L6
    L8:
        if (r102 != null) goto L10;
    L11:
        if (r101 != null) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L19;
        b97.a.b("device not supported");
        return WandTrick.a.f267324b;
    L19:
        r216.b("createPatchClassLoader");
        ArrayList r104 = new ArrayList();
        HashMap r105 = (HashMap) r212;
        Iterator r106 = r105.values().iterator();
    L21:
        if (r106.hasNext() == false) goto L27;
        h r107 = (h) r106.next();
        if (r107 == null) goto L21;
        String r108 = r107.f267368a;
        if (TextUtils.isEmpty(r108) == true) goto L21;
        r104.add(r108);
        goto L21
    L27:
        ClassLoader r109 = WandTrick.class.getClassLoader();
        ArrayList r110 = new ArrayList();
        File r111 = new PolarisFileWrapper((String) ListProtector.get(r104, 0)).getParentFile();
        r111.listFiles(new d(r110));
        int r112 = r104.size() / 99;
        if ((r104.size() % 99) == 0) goto L31;
        r112 = r112 + 1;
    L31:
        if (r110.size() == r112) goto L59;
        int r113 = 0;
    L33:
        if (r113 >= r112) goto L59;
        int r114 = r113 * 99;
        int r115 = r113 + 1;
        int r116 = Math.min(r115 * 99, r104.size());     // Catch: Exception -> L54
        PolarisFileWrapper r117 = new PolarisFileWrapper(r111, "tmp" + r113);     // Catch: Exception -> L54
        if (r117.exists() == true) goto L38;
        r117.mkdirs();     // Catch: Exception -> L54
    L38:
        int r118 = 0;
    L39:
        if (r114 >= r116) goto L45;
        if (r118 != 0) goto L43;
        String r119 = "classes.dex";
    L44:
        w87.b.b(new PolarisFileWrapper((String) ListProtector.get(r104, r114)), new PolarisFileWrapper(r117, r119));     // Catch: Exception -> L54
        r114 = r114 + 1;     // Catch: Exception -> L54
        r118 = r118 + 1;     // Catch: Exception -> L54
        r112 = r112;
        goto L39
    L43:
        r119 = "classes" + (r118 + 1) + Dex2OatHelper.DEX_SUFFIX;     // Catch: Exception -> L54
        goto L44
    L45:
        int r218 = r112;
        PolarisFileWrapper r120 = new PolarisFileWrapper(r111, "patch" + r113 + ".zip");     // Catch: Exception -> L54
        r110.add(r120);     // Catch: Exception -> L54
        ZipOutputStream r121 = new ZipOutputStream(new PolarisFileOutputStreamWrapper(r120));     // Catch: Exception -> L54
        File[] r122 = r117.listFiles();     // Catch: Exception -> L54
        int r123 = r122.length;     // Catch: Exception -> L54
        int r124 = 0;
    L46:
        if (r124 >= r123) goto L52;
        File r125 = r122[r124];     // Catch: Exception -> L54
        r121.putNextEntry(new ZipEntry(r125.getName()));     // Catch: Exception -> L54
        PolarisFileInputStreamWrapper r126 = new PolarisFileInputStreamWrapper(r125);     // Catch: Exception -> L54
        byte[] r127 = new byte[4096];     // Catch: Exception -> L54
    L48:
        int r128 = r126.read(r127);     // Catch: Exception -> L54
        ArrayList r129 = r104;
        if ((-1) == r128) goto L51;
        r121.write(r127, 0, r128);     // Catch: Exception -> L54
        r122 = r122;
        r104 = r129;
        goto L48
    L51:
        w87.c.a(r126);     // Catch: Exception -> L54
        r124 = r124 + 1;     // Catch: Exception -> L54
        r122 = r122;
        r104 = r129;
        goto L46
    L52:
        ArrayList r130 = r104;
        w87.c.a(r121);     // Catch: Exception -> L54
        w87.b.delete(r117);     // Catch: Exception -> L54
        r112 = r218;
        r113 = r115;
        r104 = r130;
    L54:
        e = move-exception;
        b97.a.b("make patch.zip failed");
        e.printStackTrace();
        Iterator r131 = r110.iterator();
    L57:
        if (r131.hasNext() == false) goto L68;
        w87.b.delete((File) r131.next());
    L68:
        j r132 = null;
    L70:
        r216.a("createPatchClassLoader");
        if (r132 == null) goto L73;
        Set r133 = r105.keySet();
        c r134 = new c();
        HashMap r135 = new HashMap();
        r216.b("loadPatchClasses");
        Iterator r136 = r133.iterator();
    L76:
        if (r136.hasNext() == false) goto L126;
        Class r137 = (Class) r136.next();
        ClassModifier.c(r137, false);
        if (Build.VERSION.SDK_INT >= 26) goto L84;
        Field[] r138 = e97.g.d(r137);
        int r139 = r138.length;
        int r140 = 0;
    L81:
        if (r140 >= r139) goto L84;
        WandTrick.e().changeFieldToPublic(r138[r140]);
        r140 = r140 + 1;
    L84:
        if (Build.VERSION.SDK_INT >= 26) goto L89;
        Constructor<?>[] r141 = r137.getDeclaredConstructors();
        int r142 = r141.length;
        int r143 = 0;
    L87:
        if (r143 >= r142) goto L89;
        WandTrick.e().changeConstructorToPublic(r141[r143]);
        r143 = r143 + 1;
    L89:
        ClassModifier.d(r137);
        ClassModifier.b(r137.getSuperclass());
        Class<?>[] r144 = r137.getInterfaces();
        if (r144 == null) goto L94;
        int r145 = r144.length;
        int r146 = 0;
    L92:
        if (r146 >= r145) goto L94;
        ClassModifier.b(r144[r146]);
        r146 = r146 + 1;
    L94:
        Class<?> r147 = r132.a(r137.getName());
        if (r147 == null) goto L76;
        ClassModifier.c(r147, true);
        if (Build.VERSION.SDK_INT >= 26) goto L103;
        Field[] r148 = e97.g.d(r147);
        int r149 = r148.length;
        int r150 = 0;
    L100:
        if (r150 >= r149) goto L103;
        WandTrick.e().changeFieldToPublic(r148[r150]);
        r150 = r150 + 1;
    L103:
        if (Build.VERSION.SDK_INT >= 26) goto L108;
        Constructor<?>[] r151 = r147.getDeclaredConstructors();
        int r152 = r151.length;
        int r153 = 0;
    L106:
        if (r153 >= r152) goto L108;
        WandTrick.e().changeConstructorToPublic(r151[r153]);
        r153 = r153 + 1;
    L108:
        ClassModifier.d(r147);
        r134.f267339a.add(c.f267338b.get(r147));
        r135.put(r137, r147);
        ArrayList r154 = new ArrayList(Arrays.asList(e97.g.f(r137).f562915b));
        ArrayList r155 = WandTrick.d(r147);
        if (r154.size() != r155.size()) goto L124;
        if (e97.g.d(r147).length != e97.g.d(r137).length) goto L124;
        LinkedHashMap r156 = new LinkedHashMap();
        int r157 = 0;
    L114:
        if (r157 >= r154.size()) goto L116;
        Method r158 = (Method) ListProtector.get(r154, r157);
        r156.put(r158.getName() + n.d(r158), r158);
        r157 = r157 + 1;
        goto L114
    L116:
        int r159 = 0;
    L118:
        if (r159 >= r155.size()) goto L76;
        Method r160 = (Method) ListProtector.get(r155, r159);
        if (r156.containsKey(r160.getName() + n.d(r160)) == false) goto L123;
        r159 = r159 + 1;
        goto L118
    L123:
        throw new Exception("Structure changed in: ".concat(r147.getName()));
    L124:
        b97.a.b("structure changed in " + r147 + ", abort.");
        throw new Exception("Structure changed in: ".concat(r147.getName()));
    L126:
        Iterator r161 = r134.f267339a.iterator();
    L128:
        if (r161.hasNext() == false) goto L212;
        Object r162 = r161.next();
        if (r162 == null) goto L211;
        Object r163 = e97.g.a(r162.getClass(), "resolvedTypes").get(r162);
        if (Build.VERSION.SDK_INT < 24) goto L134;
        int r164 = e97.g.a(r162.getClass(), "numResolvedTypes").getInt(r162);
        char r165 = 0;
        Method r166 = e97.g.b(r162, "setResolvedType", new Class[]{Integer.TYPE, Class.class});
        int r167 = 0;
    L145:
        if (r167 >= r164) goto L147;
        Object[] r168 = new Object[2];
        r168[r165] = Integer.valueOf(r167);
        r168[1] = null;
        r166.invoke(r162, r168);
        r167 = r167 + 1;
        r165 = 0;
        goto L145
    L147:
        b97.a.a("clearDexCacheResolveTypes:" + r164);
    L149:
        if (Build.VERSION.SDK_INT >= 24) goto L174;
        Object r169 = e97.g.a(r162.getClass(), "resolvedFields").get(r162);
        if (r169 == null) goto L180;
        if ((r169 instanceof Object[]) == false) goto L161;
        Object[] r170 = (Object[]) r169;
        int r171 = 0;
    L157:
        if (r171 >= r170.length) goto L159;
        r170[r171] = null;
        r171 = r171 + 1;
        goto L157
    L159:
        b97.a.a("clearDexCacheResolveFields:" + r170.length);
        goto L180
    L161:
        if ((r169 instanceof int[]) == false) goto L168;
        int[] r172 = (int[]) r169;
        int r173 = 0;
    L164:
        if (r173 >= r172.length) goto L166;
        r172[r173] = 0;
        r173 = r173 + 1;
        goto L164
    L166:
        b97.a.a("clearDexCacheResolveFields:" + r172.length);
        goto L180
    L168:
        if ((r169 instanceof long[]) == false) goto L180;
        long[] r174 = (long[]) r169;
        int r175 = 0;
    L171:
        if (r175 >= r174.length) goto L173;
        r174[r175] = 0;
        r175 = r175 + 1;
        goto L171
    L173:
        b97.a.a("clearDexCacheResolveFields:" + r174.length);
    L180:
        if (Build.VERSION.SDK_INT < 24) goto L181;
        long r176 = e97.g.a(r162.getClass(), "resolvedMethods").getLong(r162);
        int r177 = e97.g.a(r162.getClass(), "numResolvedMethods").getInt(r162);
        if (r176 == 0) goto L128;
        if (r177 == 0) goto L128;
        WandTrick.e().clearPointerArrayMemory(r176, r177);
        b97.a.a("clearDexCacheResolveMethods:" + r177);
        goto L128
    L181:
        Object r178 = e97.g.a(r162.getClass(), "resolvedMethods").get(r162);
        if (r178 == null) goto L128;
        if ((r178 instanceof Object[]) == true) goto L186;
        if ((r178 instanceof int[]) == true) goto L193;
        if ((r178 instanceof long[]) == false) goto L128;
        long[] r179 = (long[]) r178;
        int r180 = 0;
    L202:
        if (r180 >= r179.length) goto L204;
        r179[r180] = 0;
        r180 = r180 + 1;
        goto L202
    L204:
        b97.a.a("clearDexCacheResolveMethods:" + r179.length);
        goto L128
    L193:
        int[] r181 = (int[]) r178;
        int r182 = 0;
    L195:
        if (r182 >= r181.length) goto L197;
        r181[r182] = 0;
        r182 = r182 + 1;
        goto L195
    L197:
        b97.a.a("clearDexCacheResolveMethods:" + r181.length);
        goto L128
    L186:
        Object[] r183 = (Object[]) r178;
        int r184 = 0;
    L188:
        if (r184 >= r183.length) goto L190;
        r183[r184] = null;
        r184 = r184 + 1;
        goto L188
    L190:
        b97.a.a("clearDexCacheResolveMethods:" + r183.length);
        goto L128
    L174:
        long r185 = e97.g.a(r162.getClass(), "resolvedFields").getLong(r162);
        int r186 = e97.g.a(r162.getClass(), "numResolvedFields").getInt(r162);
        if (r185 == 0) goto L180;
        if (r186 == 0) goto L180;
        WandTrick.e().clearPointerArrayMemory(r185, r186);
        b97.a.a("clearDexCacheResolveFields:" + r186);
        goto L180
    L134:
        if ((r163 instanceof Class[]) == false) goto L143;
        Class[] r187 = (Class[]) r163;
        if (r187 == null) goto L141;
        int r188 = 0;
    L139:
        if (r188 >= r187.length) goto L141;
        r187[r188] = null;
        r188 = r188 + 1;
    L141:
        b97.a.a("clearDexCacheResolveTypes:" + r187.length);
        goto L149
    L143:
        throw new Exception("DexCache resolvedTypes is not Class[] type!");
    L211:
        throw new Exception("DexCache is null!");
    L212:
        r134.f267339a.clear();
        String[] r189 = new String[r135.size()];
        Iterator r190 = r135.values().iterator();
        int r191 = 0;
    L214:
        if (r190.hasNext() == false) goto L216;
        r189[r191] = ((Class) r190.next()).getName();
        r191 = r191 + 1;
        goto L214
    L216:
        WandTrick.removeClassesFromClassLinker(r189, r132);
        r216.a("loadPatchClasses");
        r216.b("preparePatchMethods");
        ArrayList r192 = new ArrayList();
        ArrayList r193 = new ArrayList();
        ArrayList r194 = new ArrayList();
        Iterator r195 = r133.iterator();
    L218:
        if (r195.hasNext() == false) goto L287;
        Class r196 = (Class) r195.next();
        Class<?> r197 = (Class) r135.get(r196);
        if (r197 == null) goto L285;
        if (r196 == null) goto L285;
        ClassLoader r198 = r196.getClassLoader();
        Field r199 = ClassModifier.f267308a;
        monitor-enter(r197);
        ClassModifier.f267308a.set(r197, r198);     // Catch: Throwable -> L282
        monitor-exit(r197);     // Catch: Throwable -> L282
        h r200 = (h) r105.get(r196);
        if (r200 == null) goto L229;
        List<Method> r1100 = r200.f267370c;
        List<Constructor> r201 = r200.f267369b;
    L230:
        if (r1100 != null) goto L232;
    L234:
        Method[] r1101 = null;
    L235:
        if (r201 != null) goto L237;
    L239:
        Constructor[] r202 = null;
    L240:
        if (r1101 != null) goto L245;
        if (r202 != null) goto L245;
        throw new Exception("Unspecified target in class: ".concat(r196.getSimpleName()));
    L245:
        r194.add(r197);
        if (r1101 == null) goto L266;
        int r203 = 0;
    L249:
        if (r203 >= r1101.length) goto L266;
        Method r204 = r1101[r203];
        Method[] r205 = e97.g.f(r197).f562915b;
        int r1102 = r205.length;
        int r1103 = 0;
    L251:
        if (r1103 >= r1102) goto L261;
        Method r1104 = r205[r1103];
        Iterator r219 = r195;
        if (r1104.getDeclaringClass() != r197) goto L259;
        HashMap r1105 = r135;
        if (r1104.getName().equals(r204.getName()) == false) goto L260;
        if (n.d(r1104).equals(n.d(r204)) == false) goto L260;
        Method r206 = r1104;
    L262:
        if (r206 == null) goto L265;
        r192.add(r204);
        r193.add(r206);
        r203 = r203 + 1;
        r195 = r219;
        r135 = r1105;
        goto L249
    L265:
        throw new NoSuchMethodException(r204.getName() + " " + Arrays.toString(r204.getParameterTypes()));
    L260:
        r1103 = r1103 + 1;
        r195 = r219;
        r135 = r1105;
        goto L251
    L259:
        r1105 = r135;
        goto L260
    L261:
        r219 = r195;
        r1105 = r135;
        r206 = null;
    L266:
        Iterator r220 = r195;
        HashMap r1106 = r135;
        if (r202 == null) goto L286;
        int r207 = 0;
    L270:
        if (r207 >= r202.length) goto L286;
        Constructor r208 = r202[r207];
        Constructor<?>[] r209 = r197.getDeclaredConstructors();
        int r221 = r209.length;
        int r222 = 0;
    L272:
        if (r222 >= r221) goto L277;
        Constructor<?> r1107 = r209[r222];
        if (n.c(r208).equals(n.c(r1107)) == true) goto L278;
        r222 = r222 + 1;
    L278:
        if (r1107 == null) goto L281;
        r192.add(r208);
        PatchConstructorHelper.collectConstructorClass(r208);
        r193.add(r1107);
        r207 = r207 + 1;
        goto L270
    L281:
        throw new NoSuchMethodException(r208.getName() + " " + Arrays.toString(r208.getParameterTypes()));
    L277:
        r1107 = null;
    L286:
        r195 = r220;
        r135 = r1106;
        goto L218
    L237:
        if (r201.isEmpty() == true) goto L239;
        r202 = new Constructor[r201.size()];
        r201.toArray(r202);
        goto L240
    L232:
        if (r1100.isEmpty() == true) goto L234;
        Method[] r223 = new Method[r1100.size()];
        r1100.toArray(r223);
        r1101 = r223;
        goto L235
    L229:
        r201 = null;
        r1100 = null;
    L282:
        th = move-exception;
        throw th;
    L285:
        r220 = r195;
        r1106 = r135;
        goto L286
    L287:
        r216.a("preparePatchMethods");
        return new e(this, r217, r215, r192, r193, r210, r211, r105, r213, r214, r216, r194);
    L73:
        return WandTrick.a.f267324b;
    L59:
        StringBuilder r224 = new StringBuilder(((File) ListProtector.get(r110, 0)).getAbsolutePath());
        int r225 = 1;
    L61:
        if (r225 >= r110.size()) goto L63;
        r224.append(":");
        r224.append(((File) ListProtector.get(r110, r225)).getAbsolutePath());
        r225 = r225 + 1;
        goto L61
    L63:
        r132 = new j(r224.toString(), this.f267319c.getApplicationInfo().nativeLibraryDir, r109);
        Object r226 = e97.g.a(j.class, "pathList").get(r109);
        IOException[] r227 = (IOException[]) e97.g.a(r226.getClass(), "dexElementsSuppressedExceptions").get(r226);
        if (r227 != null) goto L66;
    L69:
        this.f267367j.add(r132);
        goto L70
    L66:
        if (r227.length <= 0) goto L69;
        b97.a.b("create patchClassLoader failed");
        goto L68
    L13:
        if (r101.trim().length() <= 0) goto L15;
    L14:
        r103 = true;
        goto L16
    L10:
        if (r102.toLowerCase().contains("lemur") == true) goto L14;
    L6:
        r102 = null;
    L7:
        r102 = null;
        r101 = null;
        goto L8
    }
}
