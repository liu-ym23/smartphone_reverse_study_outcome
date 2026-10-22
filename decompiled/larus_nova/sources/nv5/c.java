package nv5;

import android.webkit.WebView;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f520873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterceptorModel f520874b;

    @Override // java.lang.Runnable
    public final void run() {
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
            rv5.d r0 = rv5.d.f539484c     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L17
            java.lang.Class<rv5.d> r0 = rv5.d.class
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L28
            rv5.d r1 = rv5.d.f539484c     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L12
            rv5.d r1 = new rv5.d     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            rv5.d.f539484c = r1     // Catch: java.lang.Throwable -> L14
        L12:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            goto L17
        L14:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Throwable -> L28
        L17:
            rv5.d r0 = rv5.d.f539484c     // Catch: java.lang.Throwable -> L28
            android.webkit.WebView r1 = r5.f520873a     // Catch: java.lang.Throwable -> L28
            com.bytedance.falconx.statistic.InterceptorModel r2 = r5.f520874b     // Catch: java.lang.Throwable -> L28
            java.util.concurrent.Executor r3 = r0.f539485a     // Catch: java.lang.Throwable -> L28
            rv5.e r4 = new rv5.e     // Catch: java.lang.Throwable -> L28
            r4.<init>(r0, r1, r2)     // Catch: java.lang.Throwable -> L28
            r3.execute(r4)     // Catch: java.lang.Throwable -> L28
            goto L2f
        L28:
            r0 = move-exception
            boolean r1 = com.larus.apm.impl.protector.RunnableProtector.intercept(r0)
            if (r1 == 0) goto L30
        L2f:
            return
        L30:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: nv5.c.run():void");
    }

    public c(WebView r100, InterceptorModel r101) {
        this.f520873a = r100;
        this.f520874b = r101;
    }
}
