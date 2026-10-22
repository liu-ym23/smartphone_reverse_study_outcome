package com.ss.android.newmedia.redbadge;

import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.redbadge.IRedBadgeService;

/* JADX INFO: loaded from: classes38.dex */
public class RedBadgerManager implements IRedBadgeService {
    private static volatile RedBadgerManager sInstance;

    public static synchronized RedBadgerManager inst() {
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
            java.lang.Class<com.ss.android.newmedia.redbadge.RedBadgerManager> r0 = com.ss.android.newmedia.redbadge.RedBadgerManager.class
            monitor-enter(r0)
            com.ss.android.newmedia.redbadge.RedBadgerManager r1 = com.ss.android.newmedia.redbadge.RedBadgerManager.sInstance     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L1a
            java.lang.Class<com.ss.android.newmedia.redbadge.RedBadgerManager> r1 = com.ss.android.newmedia.redbadge.RedBadgerManager.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L1e
            com.ss.android.newmedia.redbadge.RedBadgerManager r2 = com.ss.android.newmedia.redbadge.RedBadgerManager.sInstance     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L15
            com.ss.android.newmedia.redbadge.RedBadgerManager r2 = new com.ss.android.newmedia.redbadge.RedBadgerManager     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            com.ss.android.newmedia.redbadge.RedBadgerManager.sInstance = r2     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2     // Catch: java.lang.Throwable -> L1e
        L1a:
            com.ss.android.newmedia.redbadge.RedBadgerManager r1 = com.ss.android.newmedia.redbadge.RedBadgerManager.sInstance     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L1e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.newmedia.redbadge.RedBadgerManager.inst():com.ss.android.newmedia.redbadge.RedBadgerManager");
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean isSupportGetCurRedBadgeNumber() {
        return PushServiceManager.get().getIRedBadgeExternalService().isSupportGetCurRedBadgeNumber();
    }

    private RedBadgerManager() {
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public int getCurRedBadgeNumber(Context r100) {
        return PushServiceManager.get().getIRedBadgeExternalService().getCurRedBadgeNumber(r100);
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean isSupportAddRedBadgeNumber(int r100) {
        return PushServiceManager.get().getIRedBadgeExternalService().isSupportAddRedBadgeNumber(r100);
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean isSupportReduceRedBadgeNumber(int r100) {
        return PushServiceManager.get().getIRedBadgeExternalService().isSupportReduceRedBadgeNumber(r100);
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean removeCount(Context r100) {
        return PushServiceManager.get().getIRedBadgeExternalService().removeCount(r100);
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean addRedBadgeNumber(Context r100, int r101) {
        return PushServiceManager.get().getIRedBadgeExternalService().addRedBadgeNumber(r100, r101);
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean applyCount(Context r100, int r101) {
        return PushServiceManager.get().getIRedBadgeExternalService().applyCount(r100, r101);
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean reduceRedBadgeNumber(Context r100, int r101) {
        return PushServiceManager.get().getIRedBadgeExternalService().reduceRedBadgeNumber(r100, r101);
    }
}
