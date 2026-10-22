package com.bytedance.vcloud.networkpredictor;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorJniLoader {
    public static volatile String exception = "";
    public static volatile boolean isLibraryLoaded;
    private static LibraryLoaderProxy mLibraryLoader;

    /* JADX INFO: renamed from: com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DefaultLoader implements LibraryLoaderProxy {
        private DefaultLoader() {
        }

        public static /* synthetic */ void access$000(String r100) {
            System.loadLibrary(r100);
        }

        public /* synthetic */ DefaultLoader(AnonymousClass1 r100) {
            this();
        }

        @JvmStatic
        public static void INVOKESTATIC_com_bytedance_vcloud_networkpredictor_SpeedPredictorJniLoader$DefaultLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }

        @Override // com.bytedance.vcloud.networkpredictor.LibraryLoaderProxy
        public boolean loadLibrary(String r100) {
            INVOKESTATIC_com_bytedance_vcloud_networkpredictor_SpeedPredictorJniLoader$DefaultLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: Throwable -> L4
            return true;
        L4:
            return false;
        }
    }

    public SpeedPredictorJniLoader() {
    }

    public static synchronized boolean loadLibrary() {
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
            java.lang.Class<com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader> r0 = com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.class
            monitor-enter(r0)
            boolean r1 = com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.isLibraryLoaded     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L24
            com.bytedance.vcloud.networkpredictor.LibraryLoaderProxy r1 = com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.mLibraryLoader     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L11
            com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader$DefaultLoader r1 = new com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader$DefaultLoader     // Catch: java.lang.Throwable -> L1a
            r2 = 0
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1a
        L11:
            java.lang.String r2 = "networkpredictor"
            boolean r1 = r1.loadLibrary(r2)     // Catch: java.lang.Throwable -> L1a
            com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.isLibraryLoaded = r1     // Catch: java.lang.Throwable -> L1a
            goto L24
        L1a:
            r1 = move-exception
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L28
            com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.exception = r1     // Catch: java.lang.Throwable -> L28
            r1 = 0
            com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.isLibraryLoaded = r1     // Catch: java.lang.Throwable -> L28
        L24:
            boolean r1 = com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.isLibraryLoaded     // Catch: java.lang.Throwable -> L28
            monitor-exit(r0)
            return r1
        L28:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.vcloud.networkpredictor.SpeedPredictorJniLoader.loadLibrary():boolean");
    }

    public static void setLoadProxy(LibraryLoaderProxy r100) {
        mLibraryLoader = r100;
    }
}
