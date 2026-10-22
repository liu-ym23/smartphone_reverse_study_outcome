package org.jnius;

import java.lang.reflect.InvocationHandler;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: larus_nova_base.apk:assets/zeus_p/com.obric.memorydata.plugin_150200101:assets/pap/packages/pyjnius-1.7.0-cp313-cp313-linux_android.whl:jnius/src/org/jnius/NativeInvocationHandler.class */
public class NativeInvocationHandler implements InvocationHandler {
    static boolean DEBUG;
    private long ptr;

    native int getLastIndex(List r100);

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
        	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
        	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
        */
    static java.lang.Object ifEmpty(java.util.Collection r2, kotlin.jvm.functions.Function0 r3) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
            r0 = 0
            org.jnius.NativeInvocationHandler.DEBUG = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jnius.NativeInvocationHandler.ifEmpty(java.util.Collection, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeInvocationHandler(Collection r100, Collection r101) {
        super/*J.N*/.M$Y37M6J(this);
        this.ptr = r100;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed. Error: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because the return value of "jadx.core.dex.nodes.InsnNode.getResult()" is null
    	at jadx.core.dex.visitors.typeinference.AbstractTypeConstraint.collectRelatedVars(AbstractTypeConstraint.java:31)
    	at jadx.core.dex.visitors.typeinference.AbstractTypeConstraint.<init>(AbstractTypeConstraint.java:19)
    	at jadx.core.dex.visitors.typeinference.TypeSearch$1.<init>(TypeSearch.java:376)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.makeMoveConstraint(TypeSearch.java:376)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.makeConstraint(TypeSearch.java:361)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.collectConstraints(TypeSearch.java:341)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:60)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x003b: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:5:0x003a */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0012: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:4:0x0006 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x003c: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:5:0x003a */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x001b: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:4:0x0006 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x003d: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:5:0x003a */
    /* JADX WARN: Type inference failed for: r0v10, types: [J.N, void] */
    /* JADX WARN: Type inference failed for: r0v11, types: [J.N, void] */
    /* JADX WARN: Type inference failed for: r0v13, types: [J.N, int, java.io.PrintStream, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v14, types: [J.N, java.io.PrintStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v15, types: [J.N, java.io.PrintStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List, long, void] */
    /* JADX WARN: Type inference failed for: r0v5, types: [J.N, int, java.io.PrintStream, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6, types: [J.N, java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [J.N, int, java.lang.String, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v8, types: [J.N, void] */
    /* JADX WARN: Type inference failed for: r0v9, types: [J.N, int, java.lang.String, void] */
    /* JADX WARN: Type inference failed for: r5v0, types: [J.N, org.jnius.NativeInvocationHandler] */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v7 ??, still in use, count: 7, list:
          (r0v7 ?? I:java.lang.String) from 0x000a: INVOKE (r0v7 ?? I:J.N), (r0v7 ?? I:java.lang.String), (r0v7 ?? I:java.lang.String) SUPER call: J.N.M5yUVmrW(java.lang.String, java.lang.String):void A[MD:(java.lang.String, java.lang.String):void (m)]
          (r0v7 ?? I:java.lang.String) from 0x000a: INVOKE (r0v7 ?? I:J.N), (r0v7 ?? I:java.lang.String), (r0v7 ?? I:java.lang.String) SUPER call: J.N.M5yUVmrW(java.lang.String, java.lang.String):void A[MD:(java.lang.String, java.lang.String):void (m)]
          (r0v7 ?? I:J.N) from 0x000f: INVOKE (r0v8 ?? I:void) = (r0v7 ?? I:J.N), ("+ java:invoke(<proxy>, "), (r0v7 ?? I:java.lang.String), (r0v7 ?? I:int), (r0v7 ?? I:int) VIRTUAL call: J.N.M6WZ7Wt0(long, java.lang.String, int, int):void A[MD:(long, java.lang.String, int, int):void (m)]
          (r0v7 ?? I:java.lang.String) from 0x000f: INVOKE (r0v8 ?? I:void) = (r0v7 ?? I:J.N), ("+ java:invoke(<proxy>, "), (r0v7 ?? I:java.lang.String), (r0v7 ?? I:int), (r0v7 ?? I:int) VIRTUAL call: J.N.M6WZ7Wt0(long, java.lang.String, int, int):void A[MD:(long, java.lang.String, int, int):void (m)]
          (r0v7 ?? I:int) from 0x000f: INVOKE (r0v8 ?? I:void) = (r0v7 ?? I:J.N), ("+ java:invoke(<proxy>, "), (r0v7 ?? I:java.lang.String), (r0v7 ?? I:int), (r0v7 ?? I:int) VIRTUAL call: J.N.M6WZ7Wt0(long, java.lang.String, int, int):void A[MD:(long, java.lang.String, int, int):void (m)]
          (r0v7 ?? I:int) from 0x000f: INVOKE (r0v8 ?? I:void) = (r0v7 ?? I:J.N), ("+ java:invoke(<proxy>, "), (r0v7 ?? I:java.lang.String), (r0v7 ?? I:int), (r0v7 ?? I:int) VIRTUAL call: J.N.M6WZ7Wt0(long, java.lang.String, int, int):void A[MD:(long, java.lang.String, int, int):void (m)]
          (r0v7 ?? I:J.N) from 0x000a: INVOKE (r0v7 ?? I:J.N), (r0v7 ?? I:java.lang.String), (r0v7 ?? I:java.lang.String) SUPER call: J.N.M5yUVmrW(java.lang.String, java.lang.String):void A[MD:(java.lang.String, java.lang.String):void (m)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public java.util.List emptyList() {
        boolean r0 = org.jnius.NativeInvocationHandler.DEBUG;
        if (r0 == false) goto L5;
        super/*J.N*/.M5yUVmrW(r0, r0);
        ?? r0 = r0.M6WZ7Wt0("+ java:invoke(<proxy>, ", r0, r0, r0);
        ?? r0 = r0.M8F7L$JR();
        ?? r0 = r0.M6WZ7Wt0(", ", r0, r0, r0);
        ?? r0 = r0.M8F7L$JR();
        boolean r0 = r0.MBEGQVWX(r8);
        ?? r0 = java.lang.System.out;
        long r0 = r0 ? 1 : 0;
        r0.MH0muaR3(r0, r0, r0, r0, r0, r0);
        ?? r0 = java.lang.System.out;
        r0.MK0SE_Ub(")", r0);
        ?? r0 = java.lang.System.out;
        r0.MKRYs$fc(")", r0);
    L5:
        ?? r0 = MKlPFTpb(r6, r7);
        boolean r0 = org.jnius.NativeInvocationHandler.DEBUG;
        if (r0 == false) goto L9;
        ?? r0 = java.lang.System.out;
        r0.MH0muaR3("+ java:invoke returned: ", r8, r0, r0, r0, r0);
        ?? r0 = java.lang.System.out;
        r0.MLLAskZ0(r0, r8);
    L9:
        return r0;
    }

    /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
        java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
        	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:123)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:57)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:44)
        */
    public kotlin.ranges.IntRange getIndices(java.util.Collection r4) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
            r3 = this;
            r0 = r3
            long r0 = r0.ptr
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jnius.NativeInvocationHandler.getIndices(java.util.Collection):kotlin.ranges.IntRange");
    }
}
