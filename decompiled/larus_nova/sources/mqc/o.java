package mqc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.MethodUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ArrayList<String> f514962a;

    public o() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.webkit.WebViewFactory");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.webkit.WebViewFactory");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.webkit.WebViewFactory");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.webkit.WebViewFactory");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.webkit.WebViewFactory");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.webkit.WebViewFactory");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.webkit.WebViewFactory");
    }

    public static synchronized List<String> e() {
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
            java.lang.Class<mqc.o> r0 = mqc.o.class
            monitor-enter(r0)
            java.util.ArrayList<java.lang.String> r1 = mqc.o.f514962a     // Catch: java.lang.Throwable -> La7
            if (r1 != 0) goto La3
            java.lang.Class<mqc.o> r1 = mqc.o.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> La7
            java.util.ArrayList<java.lang.String> r2 = mqc.o.f514962a     // Catch: java.lang.Throwable -> La0
            if (r2 != 0) goto L9e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La0
            r2.<init>()     // Catch: java.lang.Throwable -> La0
            mqc.o.f514962a = r2     // Catch: java.lang.Throwable -> La0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La0
            r3 = 23
            r4 = 1
            r5 = 0
            if (r2 > r3) goto L1f
            r6 = 1
            goto L20
        L1f:
            r6 = 0
        L20:
            if (r6 == 0) goto L55
            android.app.Application r2 = com.volcengine.zeus.Zeus.getAppApplication()     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            java.lang.String r3 = "android:string/config_webViewPackageName"
            java.lang.String r4 = "string"
            java.lang.String r6 = "android"
            int r3 = r2.getIdentifier(r3, r4, r6)     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            java.util.ArrayList<java.lang.String> r4 = mqc.o.f514962a     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            android.app.Application r6 = com.volcengine.zeus.Zeus.getAppApplication()     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            java.lang.String r2 = r2.getString(r3)     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            android.content.Context r2 = r6.createPackageContext(r2, r5)     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            java.lang.String r2 = r2.sourceDir     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            r4.add(r2)     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> La0
            goto L9e
        L4c:
            r2 = move-exception
            java.lang.String r3 = "Zeus/load_zeus"
            java.lang.String r4 = "getWebViewPaths1 failed."
            com.volcengine.zeus.log.ZeusLogger.w(r3, r4, r2)     // Catch: java.lang.Throwable -> La0
            goto L9e
        L55:
            if (r2 <= r3) goto L59
            r3 = 1
            goto L5a
        L59:
            r3 = 0
        L5a:
            if (r3 == 0) goto L9e
            java.lang.Class r3 = a()     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            java.lang.String r6 = "getWebViewContextAndSetProvider"
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            java.lang.Object r3 = com.volcengine.zeus.util.MethodUtils.invokeStaticMethod(r3, r6, r7)     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            r6 = 29
            if (r2 >= r6) goto L76
            r6 = 28
            if (r2 != r6) goto L75
            int r2 = android.os.Build.VERSION.PREVIEW_SDK_INT     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            if (r2 <= 0) goto L75
            goto L76
        L75:
            r4 = 0
        L76:
            if (r4 == 0) goto L88
            java.util.ArrayList<java.lang.String> r2 = mqc.o.f514962a     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            java.lang.String[] r3 = b(r3)     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            java.util.Collections.addAll(r2, r3)     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            goto L9e
        L88:
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            android.content.pm.ApplicationInfo r2 = r3.getApplicationInfo()     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            java.lang.String r2 = r2.sourceDir     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            java.util.ArrayList<java.lang.String> r3 = mqc.o.f514962a     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            r3.add(r2)     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> La0
            goto L9e
        L96:
            r2 = move-exception
            java.lang.String r3 = "Zeus/load_zeus"
            java.lang.String r4 = "getWebViewPaths2 failed."
            com.volcengine.zeus.log.ZeusLogger.w(r3, r4, r2)     // Catch: java.lang.Throwable -> La0
        L9e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La0
            goto La3
        La0:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La0
            throw r2     // Catch: java.lang.Throwable -> La7
        La3:
            java.util.ArrayList<java.lang.String> r1 = mqc.o.f514962a     // Catch: java.lang.Throwable -> La7
            monitor-exit(r0)
            return r1
        La7:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: mqc.o.e():java.util.List");
    }

    public static String[] b(ApplicationInfo r100) {
        String[] r101 = (String[]) aqc.a.a(ApplicationInfo.class, "resourceDirs").get(r100);     // Catch: Throwable -> L5
    L7:
        String[][] r102 = {r100.splitSourceDirs, r100.sharedLibraryFiles, r101};
        ArrayList r103 = new ArrayList(10);
        String r104 = r100.sourceDir;
        if (r104 == null) goto L10;
        r103.add(r104);
    L10:
        int r105 = 0;
    L11:
        if (r105 >= 3) goto L17;
        String[] r106 = r102[r105];
        if (r106 == null) goto L15;
        r103.addAll(Arrays.asList(r106));
    L15:
        r105 = r105 + 1;
        goto L11
    L17:
        return (String[]) r103.toArray(new String[0]);
    L5:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
        r101 = new String[0];
        goto L7
    }

    public static List<String> c(AssetManager r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L25;
        return r101;
    L25:
    L21:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
    L23:
        return r101;
    L6:
        if (m.a() == false) goto L14;
        Object[] r102 = (Object[]) MethodUtils.invokeMethod(r100, "getApkAssets", new Object[0]);     // Catch: Throwable -> L21
        if (r102 == null) goto L23;
        if (r102.length <= 0) goto L23;
        int r103 = r102.length;     // Catch: Throwable -> L21
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L23;
        r101.add((String) MethodUtils.invokeMethod(r102[r104], "getAssetPath", new Object[0]));     // Catch: Throwable -> L21
        r104 = r104 + 1;     // Catch: Throwable -> L21
        goto L12
    L14:
        int r105 = ((Integer) MethodUtils.invokeMethod(r100, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L21
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L23;
        String r107 = (String) MethodUtils.invokeMethod(r100, "getCookieName", new Object[]{Integer.valueOf(r106 + 1)});     // Catch: IndexOutOfBoundsException -> L24 Throwable -> L21
        if (TextUtils.isEmpty(r107) == true) goto L20;
        r101.add(r107);     // Catch: IndexOutOfBoundsException -> L24 Throwable -> L21
    L20:
        r106 = r106 + 1;
        goto L16
    }

    public static String d(AssetManager r100) {
        List<String> r101 = c(r100);
        StringBuilder r102 = new StringBuilder("[");
        ArrayList r103 = (ArrayList) r101;
        if (r103.size() <= 0) goto L9;
        Iterator r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r102.append((String) r104.next());
        r102.append(" , ");
        goto L6
    L8:
        r102.delete(r102.lastIndexOf(" , "), r102.length());
    L9:
        r102.append("]");
        return r102.toString();
    }
}
