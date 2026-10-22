package vr3;

import as3.b;
import bs3.l;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ b a;

    public final void a() {
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
            java.lang.Object r0 = vr3.b.C
            monitor-enter(r0)
            r1 = 1
            boolean r2 = com.bytedance.apm.d.j()     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L13
            java.lang.String r2 = "onChangeToFront, record data"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L37
            ps3.b.a(r2)     // Catch: java.lang.Throwable -> L37
        L13:
            vr3.b r2 = r5.a     // Catch: java.lang.Throwable -> L37
            boolean r2 = r2.l(r1)     // Catch: java.lang.Throwable -> L37
            vr3.b r3 = r5.a     // Catch: java.lang.Throwable -> L37
            java.util.Map r3 = r3.g     // Catch: java.lang.Throwable -> L37
            java.util.concurrent.ConcurrentHashMap r3 = (java.util.concurrent.ConcurrentHashMap) r3     // Catch: java.lang.Throwable -> L37
            java.util.Collection r3 = r3.values()     // Catch: java.lang.Throwable -> L37
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L37
        L27:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L3d
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L37
            bs3.l r4 = (bs3.l) r4     // Catch: java.lang.Throwable -> L37
            r4.h(r2)     // Catch: java.lang.Throwable -> L37
            goto L27
        L37:
            r2 = move-exception
            java.lang.String r3 = "recordFrontData"
            com.bytedance.services.apm.api.EnsureManager.ensureNotReachHere(r2, r3)     // Catch: java.lang.Throwable -> L4f
        L3d:
            as3.b r2 = as3.b.a.a     // Catch: java.lang.Throwable -> L4f
            com.bytedance.apm.core.ActivityLifeObserver r3 = com.bytedance.apm.core.ActivityLifeObserver.getInstance()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = r3.getTopActivityClassName()     // Catch: java.lang.Throwable -> L4f
            r2.a = r3     // Catch: java.lang.Throwable -> L4f
            vr3.b r2 = r5.a     // Catch: java.lang.Throwable -> L4f
            r2.i = r1     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            return
        L4f:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: vr3.e.a():void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(b r1) {
        this.a = r1;
    }
}
