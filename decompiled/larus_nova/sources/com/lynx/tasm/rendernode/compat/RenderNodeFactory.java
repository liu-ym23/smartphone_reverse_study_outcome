package com.lynx.tasm.rendernode.compat;

import android.os.Build;

/* JADX INFO: loaded from: classes32.dex */
public class RenderNodeFactory {
    static volatile RenderNodeFactory mInstance;

    public RenderNodeFactory() {
    }

    public static RenderNodeFactory getInstance() {
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
            com.lynx.tasm.rendernode.compat.RenderNodeFactory r0 = com.lynx.tasm.rendernode.compat.RenderNodeFactory.mInstance     // Catch: java.lang.Exception -> L17
            if (r0 != 0) goto L1b
            java.lang.Class<com.lynx.tasm.rendernode.compat.RenderNodeFactory> r0 = com.lynx.tasm.rendernode.compat.RenderNodeFactory.class
            monitor-enter(r0)     // Catch: java.lang.Exception -> L17
            com.lynx.tasm.rendernode.compat.RenderNodeFactory r1 = com.lynx.tasm.rendernode.compat.RenderNodeFactory.mInstance     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L12
            com.lynx.tasm.rendernode.compat.RenderNodeFactory r1 = new com.lynx.tasm.rendernode.compat.RenderNodeFactory     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            com.lynx.tasm.rendernode.compat.RenderNodeFactory.mInstance = r1     // Catch: java.lang.Throwable -> L14
        L12:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            goto L1b
        L14:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Exception -> L17
        L17:
            r0 = move-exception
            r0.printStackTrace()
        L1b:
            com.lynx.tasm.rendernode.compat.RenderNodeFactory r0 = com.lynx.tasm.rendernode.compat.RenderNodeFactory.mInstance
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lynx.tasm.rendernode.compat.RenderNodeFactory.getInstance():com.lynx.tasm.rendernode.compat.RenderNodeFactory");
    }

    public RenderNodeCompat createRenderNodeCompat() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 29) goto L6;
        RenderNodeCompat r101 = new RenderNodeImpl();
    L9:
        r101.init();
        return r101;
    L6:
        if (r100 < 23) goto L8;
        r101 = new RenderNodeV23Impl();
        goto L9
    L8:
        r101 = new RenderNodeV21Impl();
        goto L9
    }
}
