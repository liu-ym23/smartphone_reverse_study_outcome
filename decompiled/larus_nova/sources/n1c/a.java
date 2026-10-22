package n1c;

import android.os.Build;
import com.larksuite.framework.thread.n;
import com.larksuite.framework.thread.p;
import com.larksuite.framework.utils.Reflect;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f516682h = 0;

    /* JADX INFO: renamed from: n1c.a$a, reason: collision with other inner class name */
    public static final class C6882a {
        public static a a(int r100, int r101) {
            Intrinsics.checkNotNullParameter("PreloadTaskManager", "threadPoolName");
            return new a(r100, r101, new PriorityBlockingQueue(256), new n("lk-ssc-PreloadTaskManager"));
        }
    }

    static {
        f516682h = Runtime.getRuntime().availableProcessors();
    }

    @Override // com.larksuite.framework.thread.p, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
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
            com.larksuite.framework.utils.Reflect r0 = new com.larksuite.framework.utils.Reflect
            r0.<init>(r8)
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]
            java.lang.Class<java.util.concurrent.locks.ReentrantLock> r3 = java.util.concurrent.locks.ReentrantLock.class
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "mainLock"
            com.larksuite.framework.utils.Reflect r0 = r0.e(r3, r2)
            java.lang.Object r0 = r0.f285916a
            java.util.concurrent.locks.ReentrantLock r0 = (java.util.concurrent.locks.ReentrantLock) r0
            r0.lock()
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r3 = 37
            if (r2 >= r3) goto L2a
            com.larksuite.framework.utils.Reflect r2 = new com.larksuite.framework.utils.Reflect     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r3 = "checkShutdownAccess"
            r2.call(r3)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
        L2a:
            com.larksuite.framework.utils.Reflect r2 = new com.larksuite.framework.utils.Reflect     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r3 = "advanceRunState"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r5[r4] = r6     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r7 = 536870912(0x20000000, float:1.0842022E-19)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r6[r4] = r7     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r2.call(r3, r5, r6)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            com.larksuite.framework.utils.Reflect r2 = new com.larksuite.framework.utils.Reflect     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r3 = "interruptIdleWorkers"
            r2.call(r3)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.util.List r1 = r8.h()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r0.unlock()
            goto L64
        L56:
            r1 = move-exception
            goto L6f
        L58:
            r2 = move-exception
            java.lang.String r3 = "SingleScheduledExecutorService"
            java.lang.String r4 = "shutdownNow failed!"
            com.ss.android.lark.log.Log.e(r3, r4, r2, r1)     // Catch: java.lang.Throwable -> L56
            r0.unlock()
            r1 = 0
        L64:
            com.larksuite.framework.utils.Reflect r0 = new com.larksuite.framework.utils.Reflect
            r0.<init>(r8)
            java.lang.String r2 = "tryTerminate"
            r0.call(r2)
            return r1
        L6f:
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n1c.a.shutdownNow():java.util.List");
    }

    public final List<Runnable> h() {
        BlockingQueue<Runnable> r100 = getQueue();
        ArrayList r101 = new ArrayList();
        r100.drainTo(r101);
        if (r100.isEmpty() == true) goto L10;
        Intrinsics.checkNotNull(r100);
        int r102 = 0;
        Runnable[] r103 = (Runnable[]) r100.toArray(new Runnable[0]);
        int r104 = r103.length;
    L5:
        if (r102 >= r104) goto L10;
        Runnable r105 = r103[r102];
        if (r100.remove(r105) == false) goto L9;
        r101.add(r105);
    L9:
        r102 = r102 + 1;
    L10:
        return r101;
    }

    public a(int r100, int r110, BlockingQueue r111, n r112) {
        Intrinsics.checkNotNullParameter(r111, "queue");
        super("PreloadTaskManager", r100, r110, 30, r111, r112);
    }
}
