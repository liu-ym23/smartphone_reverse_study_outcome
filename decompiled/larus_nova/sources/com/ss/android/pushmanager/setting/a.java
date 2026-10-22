package com.ss.android.pushmanager.setting;

import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.f;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.ss.android.common.applog.AppLog;
import com.ss.android.message.AppProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f449562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f449563c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PushMultiProcessSharedProvider.b f449564a;

    static {
        f449563c = new HashMap();
    }

    public static synchronized a b() {
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
            java.lang.Class<com.ss.android.pushmanager.setting.a> r0 = com.ss.android.pushmanager.setting.a.class
            monitor-enter(r0)
            com.ss.android.pushmanager.setting.a r1 = com.ss.android.pushmanager.setting.a.f449562b     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L1a
            java.lang.Class<com.ss.android.pushmanager.setting.a> r1 = com.ss.android.pushmanager.setting.a.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L1e
            com.ss.android.pushmanager.setting.a r2 = com.ss.android.pushmanager.setting.a.f449562b     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L15
            com.ss.android.pushmanager.setting.a r2 = new com.ss.android.pushmanager.setting.a     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            com.ss.android.pushmanager.setting.a.f449562b = r2     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2     // Catch: java.lang.Throwable -> L1e
        L1a:
            com.ss.android.pushmanager.setting.a r1 = com.ss.android.pushmanager.setting.a.f449562b     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L1e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.pushmanager.setting.a.b():com.ss.android.pushmanager.setting.a");
    }

    public final String a() {
        HashMap r100 = new HashMap();
        c(r100);
        return (String) r100.get("device_id");
    }

    public final boolean d() {
        PushMultiProcessSharedProvider.b r100 = this.f449564a;
        r100.getClass();
        if (PushMultiProcessSharedProvider.f449551h == true) goto L9;
        if (PushMultiProcessSharedProvider.a(r100.f449560a) == false) goto L9;
        return r100.c("current_app_foreground", false);
    L9:
        return !ActivityLifecycleObserver.getIns().isBackGround();
    }

    public a() {
        this.f449564a = PushMultiProcessSharedProvider.e(AppProvider.getApp());
    }

    public final void c(Map<String, String> r100) {
        if (f.f267065a == false) goto L15;
        f.b("PushService", "getSSIDs start");
    L15:
        String r101 = this.f449564a.e(MultiProcessFileUtils.KEY_SSIDS);     // Catch: Exception -> L12
        f.b("PushService", "getSSIDs result is " + r101);     // Catch: Exception -> L12
        if (StringUtils.isEmpty(r101) == true) goto L13;
        StringUtils.stringToMap(r101, r100);     // Catch: Exception -> L12
        return;
    L13:
        f.b("PushService", "backup getSSIDs by TeaAgent");     // Catch: Throwable -> L11
        AppLog.f408004g0.g(r100);     // Catch: Throwable -> L11
        return;
    L17:
        return;
    }
}
