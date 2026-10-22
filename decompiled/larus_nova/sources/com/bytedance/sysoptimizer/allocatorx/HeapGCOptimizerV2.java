package com.bytedance.sysoptimizer.allocatorx;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class HeapGCOptimizerV2 {
    private static final long KB = 1024;
    private static final long MB = 1048576;
    private static final String TAG = "HeapGCOptimizerV2";
    private static boolean sInited = false;
    private static int sMaxAPISupport = 33;

    public HeapGCOptimizerV2() {
    }

    private static native boolean disable_native_alloc_gc(int r100);

    private static native boolean disable_request_trim(int r100);

    private static native boolean optimize(long r100, long r101, long r102, long r103);

    private static native boolean optimize_gc_step(long r100, long r101);

    private static native boolean reuse_partial_tlab();

    private static native boolean sched_heap_task_daemon(int r100, int r101);

    private static native boolean set_gc_step_diff_value(long r100);

    private static native boolean set_max_heap_usage_add_gcdiff(float r100);

    private static native boolean set_next_gc_type(int r100);

    private static native boolean set_values(long r100, long r101, long r102);

    public static synchronized void reusePartialTLAB(Context r100) {
        monitor-enter(HeapGCOptimizerV2.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L8;
        ShadowHook.access$000();     // Catch: Throwable -> L10
        ShadowHook.access$100();     // Catch: Throwable -> L10
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L10
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: Throwable -> L10
        r102.f270294a = r101;     // Catch: Throwable -> L10
        r102.f270295b = true;     // Catch: Throwable -> L10
        r102.f270296c = false;     // Catch: Throwable -> L10
        r102.f270297d = false;     // Catch: Throwable -> L10
        ShadowHook.init(r102);     // Catch: Throwable -> L10
        reuse_partial_tlab();     // Catch: Throwable -> L13 Throwable -> L10
    L8:
        monitor-exit(HeapGCOptimizerV2.class);
    }

    public static synchronized void setHeapOptMaxAPISupport(int r100) {
        monitor-enter(HeapGCOptimizerV2.class);
        sMaxAPISupport = r100;     // Catch: Throwable -> L7
        monitor-exit(HeapGCOptimizerV2.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void disableNativeAllocGC(Context r100, int r101) {
        monitor-enter(HeapGCOptimizerV2.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L8;
        ShadowHook.access$000();     // Catch: Throwable -> L10
        ShadowHook.access$100();     // Catch: Throwable -> L10
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L10
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L10
        r103.f270294a = r102;     // Catch: Throwable -> L10
        r103.f270295b = true;     // Catch: Throwable -> L10
        r103.f270296c = false;     // Catch: Throwable -> L10
        r103.f270297d = false;     // Catch: Throwable -> L10
        ShadowHook.init(r103);     // Catch: Throwable -> L10
        disable_native_alloc_gc(r101);     // Catch: Throwable -> L13 Throwable -> L10
    L8:
        monitor-exit(HeapGCOptimizerV2.class);
    }

    public static synchronized void disableRequestTrim(Context r100, int r101) {
        monitor-enter(HeapGCOptimizerV2.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L8;
        ShadowHook.access$000();     // Catch: Throwable -> L10
        ShadowHook.access$100();     // Catch: Throwable -> L10
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L10
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L10
        r103.f270294a = r102;     // Catch: Throwable -> L10
        r103.f270295b = true;     // Catch: Throwable -> L10
        r103.f270296c = false;     // Catch: Throwable -> L10
        r103.f270297d = false;     // Catch: Throwable -> L10
        ShadowHook.init(r103);     // Catch: Throwable -> L10
        disable_request_trim(r101);     // Catch: Throwable -> L13 Throwable -> L10
    L8:
        monitor-exit(HeapGCOptimizerV2.class);
    }

    public static synchronized void setGCStepDiff(Context r100, int r101) {
        monitor-enter(HeapGCOptimizerV2.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT <= sMaxAPISupport) goto L9;
        monitor-exit(HeapGCOptimizerV2.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L14;
        ShadowHook.access$000();     // Catch: Throwable -> L16
        ShadowHook.access$100();     // Catch: Throwable -> L16
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L16
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L16
        r103.f270294a = r102;     // Catch: Throwable -> L16
        r103.f270295b = true;     // Catch: Throwable -> L16
        r103.f270296c = false;     // Catch: Throwable -> L16
        r103.f270297d = false;     // Catch: Throwable -> L16
        ShadowHook.init(r103);     // Catch: Throwable -> L16
        if (sInited == false) goto L14;
        set_gc_step_diff_value(((long) r101) * 1048576);     // Catch: Throwable -> L19 Throwable -> L16
    L14:
        monitor-exit(HeapGCOptimizerV2.class);
    }

    public static synchronized void setMaxHeapUsageAddGCDiff(Context r100, float r101) {
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
            java.lang.Class<com.bytedance.sysoptimizer.allocatorx.HeapGCOptimizerV2> r1 = com.bytedance.sysoptimizer.allocatorx.HeapGCOptimizerV2.class
            monitor-enter(r1)
            boolean r0 = com.bytedance.sysoptimizer.allocatorx.HeapGCOptimizerV2.sInited     // Catch: java.lang.Throwable -> Lb java.lang.Exception -> Ld
            if (r0 == 0) goto L11
            set_max_heap_usage_add_gcdiff(r2)     // Catch: java.lang.Throwable -> Lb java.lang.Exception -> Ld
            goto L11
        Lb:
            r2 = move-exception
            goto L13
        Ld:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lb
        L11:
            monitor-exit(r1)
            return
        L13:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sysoptimizer.allocatorx.HeapGCOptimizerV2.setMaxHeapUsageAddGCDiff(android.content.Context, float):void");
    }

    public static synchronized void setNextGCType(Context r100, int r101) {
        monitor-enter(HeapGCOptimizerV2.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT <= sMaxAPISupport) goto L9;
        monitor-exit(HeapGCOptimizerV2.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L14;
        ShadowHook.access$000();     // Catch: Throwable -> L16
        ShadowHook.access$100();     // Catch: Throwable -> L16
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L16
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L16
        r103.f270294a = r102;     // Catch: Throwable -> L16
        r103.f270295b = true;     // Catch: Throwable -> L16
        r103.f270296c = false;     // Catch: Throwable -> L16
        r103.f270297d = false;     // Catch: Throwable -> L16
        ShadowHook.init(r103);     // Catch: Throwable -> L16
        if (sInited == false) goto L14;
        set_next_gc_type(r101);     // Catch: Throwable -> L19 Throwable -> L16
    L14:
        monitor-exit(HeapGCOptimizerV2.class);
    }

    public static synchronized void optimizeOnGCStep(Context r100, int r101, int r102) {
        monitor-enter(HeapGCOptimizerV2.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT <= sMaxAPISupport) goto L9;
        monitor-exit(HeapGCOptimizerV2.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L13;
        ShadowHook.access$000();     // Catch: Throwable -> L15
        ShadowHook.access$100();     // Catch: Throwable -> L15
        int r103 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L15
        ShadowHook.b r104 = new ShadowHook.b();     // Catch: Throwable -> L15
        r104.f270294a = r103;     // Catch: Throwable -> L15
        r104.f270295b = true;     // Catch: Throwable -> L15
        r104.f270296c = false;     // Catch: Throwable -> L15
        r104.f270297d = false;     // Catch: Throwable -> L15
        ShadowHook.init(r104);     // Catch: Throwable -> L15
        optimize_gc_step(((long) r101) * 1048576, ((long) r102) * 1048576);     // Catch: Throwable -> L18 Throwable -> L15
    L13:
        monitor-exit(HeapGCOptimizerV2.class);
    }

    public static synchronized void schedHeapTaskDaemon(Context r100, int r101, int r102) {
        monitor-enter(HeapGCOptimizerV2.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L13;
    L7:
        monitor-exit(HeapGCOptimizerV2.class);
        return;
    L13:
        sched_heap_task_daemon(r101, r102);     // Catch: Throwable -> L12 Throwable -> L9
        goto L7
    }

    public static boolean shouldSkipHeapOptimize(int r100, int r101, int r102) {
        if (Build.VERSION.SDK_INT <= sMaxAPISupport) goto L6;
        return true;
    L6:
        if (r100 <= 400) goto L8;
    L14:
        return true;
    L8:
        if (r101 > 32) goto L14;
        if (r100 < 0) goto L14;
        if (r102 < 0) goto L14;
        return false;
    }

    public static synchronized void optimize(Context r110, int r111, int r210, int r211) {
        monitor-enter(HeapGCOptimizerV2.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (shouldSkipHeapOptimize(r111, r210, r211) == false) goto L9;
        monitor-exit(HeapGCOptimizerV2.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r110) == false) goto L20;
        ShadowHook.access$000();     // Catch: Throwable -> L22
        ShadowHook.access$100();     // Catch: Throwable -> L22
        int r100 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L22
        ShadowHook.b r101 = new ShadowHook.b();     // Catch: Throwable -> L22
        r101.f270294a = r100;     // Catch: Throwable -> L22
        r101.f270295b = true;     // Catch: Throwable -> L22
        r101.f270296c = false;     // Catch: Throwable -> L22
        r101.f270297d = false;     // Catch: Throwable -> L22
        ShadowHook.init(r101);     // Catch: Throwable -> L22
        if (sInited == false) goto L16;
        set_values(((long) r111) * 1048576, ((long) r210) * 1048576, ((long) r211) * 1048576);     // Catch: Throwable -> L25 Throwable -> L22
        monitor-exit(HeapGCOptimizerV2.class);
        return;
    L16:
        long r112 = ((long) r111) * 1048576;
        long r113 = ((long) r210) * 1048576;
        long r114 = ((long) r211) * 1048576;
        if (optimize(r112, r113, r114, Runtime.getRuntime().maxMemory()) == false) goto L20;
        sInited = true;     // Catch: Throwable -> L25 Throwable -> L25 Throwable -> L22
    L20:
        monitor-exit(HeapGCOptimizerV2.class);
    }
}
