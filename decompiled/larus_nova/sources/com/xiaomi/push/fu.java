package com.xiaomi.push;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes41.dex */
public class fu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static fu f463621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, Object> f593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Object> f463622b;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private fu() {
        this.f593a = new ConcurrentHashMap();
        this.f463622b = new ConcurrentHashMap();
        m9107a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9107a() {
        ClassLoader[] r100 = m9105a();     // Catch: Exception -> L49
        int r101 = r100.length;     // Catch: Exception -> L49
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L73;
        Enumeration<URL> r103 = r100[r102].getResources("META-INF/smack.providers");     // Catch: Exception -> L49
    L6:
        if (r103.hasMoreElements() == false) goto L48;
        InputStream r104 = r103.nextElement().openStream();     // Catch: Throwable -> L44
        XmlPullParser r105 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Throwable -> L42
        r105.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);     // Catch: Throwable -> L42
        r105.setInput(r104, "UTF-8");     // Catch: Throwable -> L42
        int r106 = r105.getEventType();     // Catch: Throwable -> L42
    L11:
        if (r106 == 2) goto L13;
    L38:
        r106 = r105.next();     // Catch: Throwable -> L42
        if (r106 != 1) goto L11;
        r104.close();     // Catch: Exception -> L52
        goto L6
    L13:
        if (r105.getName().equals("iqProvider") == false) goto L26;
        r105.next();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        String r107 = r105.nextText();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        String r108 = r105.nextText();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        String r109 = r105.nextText();     // Catch: Throwable -> L42
        String r110 = a(r107, r108);     // Catch: Throwable -> L42
        if (this.f463622b.containsKey(r110) == true) goto L38;
        Class r111 = INVOKESTATIC_com_xiaomi_push_fu_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r109);     // Catch: ClassNotFoundException -> L23 Throwable -> L42
        if (fs.class.isAssignableFrom(r111) == false) goto L20;
        this.f463622b.put(r110, r111.newInstance());     // Catch: ClassNotFoundException -> L23 Throwable -> L42
        goto L38
    L20:
        if (fl.class.isAssignableFrom(r111) == false) goto L38;
        this.f463622b.put(r110, r111);     // Catch: ClassNotFoundException -> L23 Throwable -> L42
        goto L38
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L42
        goto L38
    L26:
        if (r105.getName().equals("extensionProvider") == false) goto L38;
        r105.next();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        String r112 = r105.nextText();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        String r113 = r105.nextText();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        r105.next();     // Catch: Throwable -> L42
        String r114 = r105.nextText();     // Catch: Throwable -> L42
        String r115 = a(r112, r113);     // Catch: Throwable -> L42
        if (this.f593a.containsKey(r115) == true) goto L38;
        Class r116 = INVOKESTATIC_com_xiaomi_push_fu_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r114);     // Catch: ClassNotFoundException -> L36 Throwable -> L42
        if (ft.class.isAssignableFrom(r116) == false) goto L33;
        this.f593a.put(r115, r116.newInstance());     // Catch: ClassNotFoundException -> L36 Throwable -> L42
        goto L38
    L33:
        if (fo.class.isAssignableFrom(r116) == false) goto L38;
        this.f593a.put(r115, r116);     // Catch: ClassNotFoundException -> L36 Throwable -> L42
        goto L38
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L42
    L42:
        th = th;
    L62:
        r104.close();     // Catch: Exception -> L53
    L47:
        throw th;     // Catch: Exception -> L49
    L44:
        th = th;
        r104 = null;
        goto L62
    L48:
        r102 = r102 + 1;
        goto L3
    L73:
        return;
    L49:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private ClassLoader[] m9105a() {
        int r100 = 0;
        ClassLoader[] r101 = {fu.class.getClassLoader(), ThreadMethodProxy.currentThread().getContextClassLoader()};
        ArrayList r102 = new ArrayList();
    L3:
        if (r100 >= 2) goto L9;
        ClassLoader r103 = r101[r100];
        if (r103 == null) goto L7;
        r102.add(r103);
    L7:
        r100 = r100 + 1;
        goto L3
    L9:
        return (ClassLoader[]) r102.toArray(new ClassLoader[r102.size()]);
    }

    public static synchronized fu a() {
        monitor-enter(fu.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f463621a != null) goto L7;
        f463621a = new fu();     // Catch: Throwable -> L10
    L7:
        fu r100 = f463621a;     // Catch: Throwable -> L10
        monitor-exit(fu.class);
        return r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_xiaomi_push_fu_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private String a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder("<");
        r102.append(r100);
        r102.append("/>");
        if (r100 == null) goto L6;
        r102.append("<");
        r102.append(r101);
        r102.append("/>");
    L6:
        return r102.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Object m9106a(String r100, String r101) {
        String r102 = a(r100, r101);
        return this.f593a.get(r102);
    }

    public void a(String r100, String r101, Object r102) {
        if ((r102 instanceof ft) == false) goto L5;
    L9:
        String r103 = a(r100, r101);
        this.f593a.put(r103, r102);
        return;
    L5:
        if ((r102 instanceof Class) == true) goto L9;
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }
}
