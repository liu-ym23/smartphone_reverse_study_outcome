package vr3;

import bs3.l;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$a implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ b b;

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
            java.lang.String r0 = "ChargingStatusChange:"
            java.lang.Object r1 = vr3.b.C
            monitor-enter(r1)
            boolean r2 = com.bytedance.apm.d.j()     // Catch: java.lang.Throwable -> L48
            r3 = 0
            if (r2 == 0) goto L22
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L48
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L48
            boolean r0 = r5.a     // Catch: java.lang.Throwable -> L48
            r4.append(r0)     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L48
            r2[r3] = r0     // Catch: java.lang.Throwable -> L48
            ps3.b.a(r2)     // Catch: java.lang.Throwable -> L48
        L22:
            vr3.b r0 = r5.b     // Catch: java.lang.Throwable -> L48
            boolean r0 = r0.l(r3)     // Catch: java.lang.Throwable -> L48
            vr3.b r2 = r5.b     // Catch: java.lang.Throwable -> L48
            java.util.Map r2 = r2.g     // Catch: java.lang.Throwable -> L48
            java.util.concurrent.ConcurrentHashMap r2 = (java.util.concurrent.ConcurrentHashMap) r2     // Catch: java.lang.Throwable -> L48
            java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L48
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L48
        L36:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L4e
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L48
            bs3.l r3 = (bs3.l) r3     // Catch: java.lang.Throwable -> L48
            boolean r4 = r5.a     // Catch: java.lang.Throwable -> L48
            r3.c(r4, r0)     // Catch: java.lang.Throwable -> L48
            goto L36
        L48:
            r0 = move-exception
            java.lang.String r2 = "ChargingStatusChange"
            com.bytedance.services.apm.api.EnsureManager.ensureNotReachHere(r0, r2)     // Catch: java.lang.Throwable -> L56
        L4e:
            vr3.b r0 = r5.b     // Catch: java.lang.Throwable -> L56
            boolean r2 = r5.a     // Catch: java.lang.Throwable -> L56
            r0.z = r2     // Catch: java.lang.Throwable -> L56
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
            return
        L56:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: vr3.b$a.a():void");
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

    public b$a(b r1, boolean r2) {
        this.b = r1;
        this.a = r2;
    }
}
