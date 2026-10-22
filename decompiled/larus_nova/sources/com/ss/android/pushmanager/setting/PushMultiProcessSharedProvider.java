package com.ss.android.pushmanager.setting;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class PushMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f449548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Uri f449549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static UriMatcher f449550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f449551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static b f449552i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f449553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f449554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f449555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f449556d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f449557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ContentValues f449558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SharedPreferences f449559c;

        public final synchronized void a() {
            monitor-enter(this);
        L34:
            th = move-exception;
            throw th;
        L4:
            if (PushMultiProcessSharedProvider.a(this.f449557a) == true) goto L38;
            SharedPreferences.Editor r100 = this.f449559c.edit();     // Catch: Throwable -> L34
            Set<String> r101 = this.f449558b.keySet();     // Catch: Throwable -> L34
            if (r101 == null) goto L32;
            Object[] r102 = r101.toArray();     // Catch: Throwable -> L34
            if (r102 != null) goto L13;
            monitor-exit(this);
            return;
        L13:
            int r103 = r102.length;     // Catch: Throwable -> L34
            int r104 = 0;
        L14:
            if (r104 >= r103) goto L31;
            String r105 = (String) r102[r104];     // Catch: Throwable -> L34
            Object r106 = this.f449558b.get(r105);     // Catch: Throwable -> L34
            if ((r106 instanceof String) == false) goto L19;
            r100.putString(r105, (String) r106);     // Catch: Throwable -> L34
        L30:
            r104 = r104 + 1;     // Catch: Throwable -> L34
            goto L14
        L19:
            if ((r106 instanceof Long) == false) goto L22;
            r100.putLong(r105, ((Long) r106).longValue());     // Catch: Throwable -> L34
            goto L30
        L22:
            if ((r106 instanceof Boolean) == false) goto L25;
            r100.putBoolean(r105, ((Boolean) r106).booleanValue());     // Catch: Throwable -> L34
            goto L30
        L25:
            if ((r106 instanceof Integer) == false) goto L28;
            r100.putInt(r105, ((Integer) r106).intValue());     // Catch: Throwable -> L34
            goto L30
        L28:
            if ((r106 instanceof Float) == false) goto L30;
            r100.putFloat(r105, ((Float) r106).floatValue());     // Catch: Throwable -> L34
            goto L30
        L31:
            r100.apply();     // Catch: Throwable -> L34
        L32:
            monitor-exit(this);
            return;
        L38:
            b(this.f449557a.getContentResolver(), PushMultiProcessSharedProvider.c(this.f449557a, "key", "type"), this.f449558b);     // Catch: Throwable -> L37
            goto L32
        }

        public a(Context r100) {
            this.f449558b = new ContentValues();
            Context r101 = r100.getApplicationContext();
            this.f449557a = r101;
            this.f449559c = r101.getApplicationContext().getSharedPreferences("push_multi_process_config", 4);
        }

        public static void b(ContentResolver r110, Uri r111, ContentValues r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111, r210};
            f06.b r112 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(240017);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L20;
            Uri r108 = (Uri) r107.f474983b;
            return;
        L20:
            r110.insert(r111, r210);
            return;
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f449560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SharedPreferences f449561b;

        public final a b() {
            return new a(this.f449560a);
        }

        public b(Context r100) {
            Context r101 = r100.getApplicationContext();
            this.f449560a = r101;
            this.f449561b = r101.getApplicationContext().getSharedPreferences("push_multi_process_config", 4);
            if (f.f267065a == false) goto L6;
            f.b("PushService", "MultiProcessShared create");
            return;
        }

        public final String e(String r100) {
        L21:
            return "";
        L4:
            if (PushMultiProcessSharedProvider.f449551h == true) goto L20;
            if (PushMultiProcessSharedProvider.a(this.f449560a) == false) goto L20;
            Cursor r101 = a(this.f449560a.getContentResolver(), PushMultiProcessSharedProvider.c(this.f449560a, r100, "string"));     // Catch: Throwable -> L21
            if (r101 == null) goto L29;
            if (r101.moveToFirst() == false) goto L15;
            String r102 = r101.getString(0);     // Catch: Throwable -> L23
        L26:
            r101.close();     // Catch: Exception -> L22 Throwable -> L21
        L18:
            return r102;
        L15:
            r102 = "";
            goto L26
        L29:
            return "";
        L20:
            return this.f449561b.getString(r100, "");
        }

        public static Cursor a(ContentResolver r110, Uri r111) {
            c r100 = new c();
            Object[] r101 = {r111, null, null, null, null};
            f06.b r112 = new f06.b();
            d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
            if (r113.f474982a == false) goto L6;
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
            return (Cursor) r113.f474983b;
        L6:
            Cursor r114 = r110.query(r111, null, null, null, null);
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
            return r114;
        }

        public final boolean c(String r100, boolean r101) {
        L21:
            return r101;
        L3:
            if (PushMultiProcessSharedProvider.f449551h == true) goto L20;
            if (PushMultiProcessSharedProvider.a(this.f449560a) == false) goto L20;
            Cursor r102 = a(this.f449560a.getContentResolver(), PushMultiProcessSharedProvider.c(this.f449560a, r100, "boolean"));     // Catch: Throwable -> L21
            if (r102 == null) goto L29;
            if (r102.moveToFirst() == false) goto L15;
            boolean r103 = false;
            if (r102.getInt(0) <= 0) goto L26;
            r103 = true;
        L26:
            r102.close();     // Catch: Exception -> L22 Throwable -> L21
        L18:
            return r103;
        L15:
            r103 = r101;
            goto L26
        L29:
            return r101;
        L20:
            return this.f449561b.getBoolean(r100, r101);
        }

        public final int d(String r100, int r101) {
        L20:
            return r101;
        L3:
            if (PushMultiProcessSharedProvider.f449551h == true) goto L19;
            if (PushMultiProcessSharedProvider.a(this.f449560a) == false) goto L19;
            Cursor r102 = a(this.f449560a.getContentResolver(), PushMultiProcessSharedProvider.c(this.f449560a, r100, "integer"));     // Catch: Throwable -> L20
            if (r102 == null) goto L28;
            if (r102.moveToFirst() == false) goto L14;
            int r103 = r102.getInt(0);     // Catch: Throwable -> L22
        L24:
            r102.close();     // Catch: Exception -> L21 Throwable -> L20
        L17:
            return r103;
        L14:
            r103 = r101;
            goto L24
        L28:
            return r101;
        L19:
            return this.f449561b.getInt(r100, r101);
        }
    }

    public final synchronized SharedPreferences d() {
        monitor-enter(this);
        SharedPreferences r100 = this.f449553a;     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        SharedPreferences r101 = getContext().getApplicationContext().getSharedPreferences("push_multi_process_config", 4);     // Catch: Throwable -> L10
        this.f449553a = r101;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        f449551h = true;
        Context r100 = getContext();
        if (r100 == null) goto L6;
        AppProvider.initApp((Application) r100.getApplicationContext());
    L6:
        if (f449550g != null) goto L17;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (f.f267065a == false) goto L10;
        f.b("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L12
    L10:
        f(r100);     // Catch: Exception -> L12
        return true;
    L17:
        return true;
    }

    public static boolean g() {
        if (TextUtils.isEmpty(f449548e) == false) goto L6;
        return true;
    L6:
        if (f449550g == null) goto L10;
        return false;
    L10:
        return true;
    }

    public final void b() {
        if (this.f449555c == true) goto L24;
        Object r100 = this.f449556d;
        monitor-enter(r100);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (this.f449555c == true) goto L19;
        SharedPreferences r101 = d();     // Catch: Throwable -> L21
        if (r101 == null) goto L18;
        Iterator<Map.Entry<String, ?>> r102 = r101.getAll().entrySet().iterator();     // Catch: Throwable -> L21
    L13:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, ?> r103 = r102.next();     // Catch: Throwable -> L21
        String r104 = r103.getKey();     // Catch: Throwable -> L21
        Object r105 = r103.getValue();     // Catch: Throwable -> L21
        if (r104 == null) goto L13;
        if (r105 == null) goto L13;
        ((ConcurrentHashMap) this.f449554b).put(r104, r105);     // Catch: Throwable -> L21
    L18:
        this.f449555c = true;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    }

    public PushMultiProcessSharedProvider() {
        this.f449554b = new ConcurrentHashMap();
        this.f449555c = false;
        this.f449556d = new Object();
    }

    public static boolean a(Context r100) {
        boolean r101 = ToolUtils.isSmpProcess(r100);
        f.b("PushMultiProcessSP", "mAllowStartOthersProcess  is false isSmpProcess is " + r101);
        if (r101 == true) goto L5;
        return true;
    L5:
        Boolean r102 = ToolUtils.isMainProcessStart(r100);
        f.b("PushMultiProcessSP", "isMainProcessStartEd is " + r102);
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.booleanValue() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static synchronized b e(Context r100) {
        monitor-enter(PushMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f449552i != null) goto L7;
        f449552i = new b(r100);     // Catch: Throwable -> L10
    L7:
        b r101 = f449552i;     // Catch: Throwable -> L10
        monitor-exit(PushMultiProcessSharedProvider.class);
        return r101;
    }

    public static void f(Context r100) throws IllegalStateException {
        if (TextUtils.isEmpty(f449548e) == false) goto L20;
        String r101 = PushMultiProcessSharedProvider.class.getName();
        f.b("MultiProcessSharedProvider", "getProviderAuthority:".concat(r101));
        if (r100 != null) goto L7;
    L17:
        String r102 = null;
    L18:
        f449548e = r102;
        goto L20
    L7:
        if (StringUtils.isEmpty(r101) == true) goto L17;
        ProviderInfo[] r103 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L28
        int r104 = r103.length;     // Catch: Exception -> L28
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L16;
        ProviderInfo r106 = r103[r105];     // Catch: Exception -> L28
        if (r101.equals(r106.name) == true) goto L13;
        r105 = r105 + 1;
        goto L10
    L13:
        r102 = r106.authority;     // Catch: Exception -> L28
    L16:
        r102 = r100.getPackageName() + ".push.SHARE_PROVIDER_AUTHORITY";
    L20:
        if (TextUtils.isEmpty(f449548e) == true) goto L27;
        if (f.f267065a == false) goto L24;
        f.b("MultiProcessSharedProvider", f449548e);
    L24:
        UriMatcher r107 = new UriMatcher(-1);
        f449550g = r107;
        r107.addURI(f449548e, "*/*", 65536);
        f449549f = UriProtector.parse("content://" + f449548e);
        return;
    L27:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        f.b("MultiProcessSharedProvider", "getType:" + r100.toString());
        f449551h = true;
        b();
        return "vnd.android.cursor.item/vnd." + f449548e + ".item";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        if (r101 == null) goto L4;
        f449548e = r101.authority;
    L4:
        f449551h = true;
        super.attachInfo(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r110, ContentValues r111) {
        f.b("MultiProcessSharedProvider", "delete:" + r110.toString());
        f449551h = true;
        b();
        if (g() == false) goto L6;
        return null;
    L6:
        if (f449550g.match(r110) != 65536) goto L66;
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L62
        Iterator<Map.Entry<String, Object>> r112 = r111.valueSet().iterator();     // Catch: Exception -> L62
        SharedPreferences.Editor r101 = null;
    L9:
        if (r112.hasNext() == false) goto L55;
        Map.Entry<String, Object> r102 = r112.next();     // Catch: Exception -> L62
        Object r103 = r102.getValue();     // Catch: Exception -> L62
        String r104 = r102.getKey();     // Catch: Exception -> L62
        if (f.f267065a == false) goto L14;
        f.b("PushService", "MultiProcessShareProvider insert key = " + r104 + " value = " + r103.toString());     // Catch: Exception -> L62
    L14:
        if (r103 != null) goto L17;
        ((ConcurrentHashMap) this.f449554b).remove(r104);     // Catch: Exception -> L62
    L16:
        boolean r105 = true;
    L24:
        if (r105 == false) goto L9;
        if (f.f267065a == true) goto L28;
    L32:
        if (r101 != null) goto L34;
        r101 = d().edit();     // Catch: Exception -> L62
    L34:
        if (r103 != null) goto L37;
        r101.remove(r104);     // Catch: Exception -> L62
        bgc.a r106 = null;
    L51:
        if (r106 == null) goto L9;
        r100.add(r106);     // Catch: Exception -> L62
        goto L9
    L37:
        if ((r103 instanceof String) == false) goto L40;
        r101.putString(r104, (String) r103);     // Catch: Exception -> L62
        r106 = new bgc.a(this, r104, "string");     // Catch: Exception -> L62
        goto L51
    L40:
        if ((r103 instanceof Boolean) == false) goto L43;
        r101.putBoolean(r104, ((Boolean) r103).booleanValue());     // Catch: Exception -> L62
        r106 = new bgc.a(this, r104, "boolean");     // Catch: Exception -> L62
        goto L51
    L43:
        if ((r103 instanceof Long) == false) goto L46;
        r101.putLong(r104, ((Long) r103).longValue());     // Catch: Exception -> L62
        r106 = new bgc.a(this, r104, "long");     // Catch: Exception -> L62
        goto L51
    L46:
        if ((r103 instanceof Integer) == false) goto L49;
        r101.putInt(r104, ((Integer) r103).intValue());     // Catch: Exception -> L62
        r106 = new bgc.a(this, r104, "integer");     // Catch: Exception -> L62
        goto L51
    L49:
        if ((r103 instanceof Float) == false) goto L54;
        r101.putFloat(r104, ((Float) r103).floatValue());     // Catch: Exception -> L62
        r106 = new bgc.a(this, r104, "float");     // Catch: Exception -> L62
        goto L51
    L54:
        throw new IllegalArgumentException("Unsupported type " + r110);     // Catch: Exception -> L62
    L28:
        if (("MultiProcessShareProvider reallly insert key = " + r104 + " value = " + r103) == null) goto L30;
        String r107 = r103.toString();     // Catch: Exception -> L62
    L31:
        f.b("PushService", r107);     // Catch: Exception -> L62
        goto L32
    L30:
        r107 = "null";
        goto L31
    L17:
        Object r108 = ((ConcurrentHashMap) this.f449554b).get(r104);     // Catch: Exception -> L62
        if (r108 != null) goto L20;
    L23:
        ((ConcurrentHashMap) this.f449554b).put(r104, r103);     // Catch: Exception -> L62
        goto L16
    L20:
        if (r108.equals(r103) == false) goto L23;
        r105 = false;
        goto L24
    L55:
        if (r101 != null) goto L57;
        return null;
    L57:
        r101.apply();     // Catch: Exception -> L62
        Iterator r113 = r100.iterator();     // Catch: Exception -> L62
    L59:
        if (r113.hasNext() == false) goto L64;
        ((Runnable) r113.next()).run();     // Catch: Exception -> L62
    L64:
        return null;
    L62:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L66:
        throw new IllegalArgumentException("Unsupported uri " + r110);
    }

    public static final synchronized Uri c(Context r100, String r101, String r102) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider> r0 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.f449549f     // Catch: java.lang.Throwable -> L31
            if (r1 != 0) goto L1d
            boolean r1 = com.bytedance.push.utils.f.f267065a     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L31
            if (r1 == 0) goto L12
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.push.utils.f.b(r1, r2)     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L31
        L12:
            f(r3)     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L31
            goto L1d
        L16:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L31
            monitor-exit(r0)
            r3 = 0
            return r3
        L1d:
            android.net.Uri r3 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.f449549f     // Catch: java.lang.Throwable -> L31
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L31
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L31
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L31
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L31
            monitor-exit(r0)
            return r3
        L31:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.c(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        f.b("MultiProcessSharedProvider", "delete:" + r100.toString() + " " + r101);
        f449551h = true;
        b();
        if (g() == false) goto L6;
        return 0;
    L6:
        if (f449550g.match(r100) != 65536) goto L9;
        return 0;
    L9:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        f449551h = true;
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        f.b("MultiProcessSharedProvider", "query:" + r100.toString());
        int r105 = 1;
        f449551h = true;
        b();
        Object r106 = null;
        String r107 = null;
        if (g() == false) goto L6;
        return null;
    L6:
        if (f449550g.match(r100) != 65536) goto L67;
        if ("all".equals((String) ListProtector.get(r100.getPathSegments(), 1)) == false) goto L36;
        Map<String, ?> r108 = d().getAll();     // Catch: Exception -> L68
        MatrixCursor r109 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L68
        Iterator<Map.Entry<String, ?>> r110 = r108.entrySet().iterator();     // Catch: Exception -> L35
    L11:
        r106 = r107;
        if (r110.hasNext() == false) goto L73;
        Map.Entry<String, ?> r111 = r110.next();     // Catch: Exception -> L35
        String r112 = r111.getKey();     // Catch: Exception -> L35
        Object r113 = r111.getValue();     // Catch: Exception -> L35
        MatrixCursor.RowBuilder r114 = r109.newRow();     // Catch: Exception -> L35
        String r115 = "string";
        if ((r113 instanceof String) == true) goto L33;
        if ((r113 instanceof Boolean) == false) goto L25;
        r115 = "boolean";
        if (((Boolean) r113).booleanValue() == false) goto L22;
        int r116 = 1;
    L23:
        r113 = Integer.valueOf(r116);     // Catch: Exception -> L35
        goto L33
    L22:
        r116 = 0;
        goto L23
    L25:
        if ((r113 instanceof Integer) == false) goto L28;
        r115 = "integer";
        goto L33
    L28:
        if ((r113 instanceof Long) == false) goto L31;
        r115 = "long";
        goto L33
    L31:
        if ((r113 instanceof Float) == false) goto L33;
        r115 = "float";
    L33:
        r114.add(r112);     // Catch: Exception -> L35
        r114.add(r113);     // Catch: Exception -> L35
        r114.add(r115);     // Catch: Exception -> L35
        r107 = r112;
    L73:
        return r109;
    L35:
        r106 = r109;
        goto L82
    L36:
        String r117 = (String) ListProtector.get(r100.getPathSegments(), 0);     // Catch: Exception -> L68
        boolean r118 = StringUtils.equal(r117, "current_app_state");     // Catch: Exception -> L68
        boolean r119 = StringUtils.equal(r117, "current_app_foreground");     // Catch: Exception -> L68
        if (((ConcurrentHashMap) this.f449554b).containsKey(r117) == true) goto L41;
        if (r118 == true) goto L41;
        if (r119 == true) goto L41;
        return null;
    L41:
        MatrixCursor r120 = new MatrixCursor(new String[]{r117});     // Catch: Exception -> L68
        if (r118 == false) goto L45;
        Object r121 = Boolean.valueOf(ActivityLifecycleObserver.getIns().isApplicationActive());     // Catch: Exception -> L44
    L52:
        MatrixCursor.RowBuilder r122 = r120.newRow();     // Catch: Exception -> L44
        if ((r121 instanceof Boolean) == false) goto L60;
        if (((Boolean) r121).booleanValue() == true) goto L58;
        r105 = 0;
    L58:
        r121 = Integer.valueOf(r105);     // Catch: Exception -> L44
    L60:
        if (f.f267065a == false) goto L62;
        f.b("PushService", "MultiProcessShareProvider reallly get key = " + r117 + " value = " + r121.toString());     // Catch: Exception -> L44
    L62:
        r122.add(r121);     // Catch: Exception -> L44
        r109 = r120;
        r106 = r122;
        goto L73
    L45:
        if (r119 == true) goto L47;
        r121 = ((ConcurrentHashMap) this.f449554b).get(r117);     // Catch: Exception -> L44
        goto L52
    L47:
        if (ActivityLifecycleObserver.getIns().isBackGround() == true) goto L49;
        boolean r123 = true;
    L50:
        r121 = Boolean.valueOf(r123);     // Catch: Exception -> L44
        goto L52
    L49:
        r123 = false;
    L44:
        r106 = r120;
    L82:
        return r106;
    L67:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }
}
