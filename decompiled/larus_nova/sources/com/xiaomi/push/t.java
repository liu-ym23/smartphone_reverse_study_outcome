package com.xiaomi.push;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public abstract class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f464366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private File f1157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Runnable f1158a;

    public abstract void a(Context r100);

    public final void com_xiaomi_push_t__run$___twin___() {
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
            this = this;
            r0 = 0
            java.io.File r1 = r4.f1157a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            if (r1 != 0) goto L14
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r1 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            android.content.Context r2 = r4.f464366a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.lang.String r3 = "default_locker"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r4.f1157a = r1     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
        L14:
            android.content.Context r1 = r4.f464366a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.io.File r2 = r4.f1157a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            com.xiaomi.push.s r0 = com.xiaomi.push.s.a(r1, r2)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.lang.Runnable r1 = r4.f1158a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            if (r1 == 0) goto L23
            r1.run()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
        L23:
            android.content.Context r1 = r4.f464366a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r4.a(r1)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            if (r0 == 0) goto L36
            goto L33
        L2b:
            r1 = move-exception
            goto L37
        L2d:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L36
        L33:
            r0.a()
        L36:
            return
        L37:
            if (r0 == 0) goto L3c
            r0.a()
        L3c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.t.com_xiaomi_push_t__run$___twin___():void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        com_xiaomi_push_t_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_xiaomi_push_t_com_larus_apm_impl_protector_RunnableLancet_run(t r100) {
        r100.com_xiaomi_push_t__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private t(Context r100, File r101) {
        this.f464366a = r100;
        this.f1157a = r101;
    }

    public /* synthetic */ t(Context r100, File r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    public static void a(final Context r100, final File r101, final Runnable r102) {
        new AnonymousClass1(r100, r101, r102).run();
    }
}
