package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class PlatformApiIDLIpcWrapper implements IPlatformApiIDL {
    boolean log;
    final IPlatformApiIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public PlatformApiIDLIpcWrapper(IPlatformApiIDL r100) throws RemoteException {
        this(r100, true);
    }

    public PlatformApiIDLIpcWrapper(IPlatformApiIDL r100, boolean r101) throws RemoteException {
        this.origin = r100;
        this.log = r101;
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public boolean moveTaskToDisplay(int r210, int r211, boolean r212) throws RemoteException {
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
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aiagent.assistant.idl.PlatformApiIDLIpcWrapper.moveTaskToDisplay(int, int, boolean):boolean");
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public List<String> getTasksPackages(int r210, boolean r211, boolean r212, int r213) throws RemoteException {
        long r110 = SystemClock.elapsedRealtimeNanos();
        List<String> r111 = null;
    L19:
        e = e;
    L20:
        int r100 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.b("IPlatformApiIDLIPC", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")", e);     // Catch: Throwable -> L22
        IPCException r101 = new IPCException(e);     // Catch: Throwable -> L22
        long r214 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L22
        long r112 = Math.max(0, r214 - r110) / 1000;     // Catch: Throwable -> L22
        int r102 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.i.a("IPlatformApiIDLIPC", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = fail", r101, r112);     // Catch: Throwable -> L22
        IPCAnomalyTrace r103 = IPCAnomalyTrace.f384709a;     // Catch: Throwable -> L22
        IPCAnomalyTrace.b("IPlatformApiIDLIPC", "getTasksPackages", r101, r112, r214);     // Catch: Throwable -> L22
        return r111;
    L4:
        if (this.log == false) goto L7;
        int r113 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L19 Throwable -> L22
        com.obric.aiagent.ipc.utils.h.a("IPlatformApiIDLIPC", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L19 Throwable -> L22
    L7:
        if (this.log == false) goto L9;
        int r114 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L19 Throwable -> L22
        com.obric.aiagent.ipc.utils.h.a("IPlatformApiIDLIPC", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ")");     // Catch: Exception -> L19 Throwable -> L22
    L9:
        List<String> r115 = this.origin.getTasksPackages(r210, r211, r212, r213);     // Catch: Exception -> L19 Throwable -> L22
    L15:
        e = e;
        r111 = r115;
        goto L20
    L11:
        if (this.log == false) goto L13;
        int r116 = com.obric.aiagent.ipc.utils.h.f384747a;     // Catch: Exception -> L15 Throwable -> L17
        com.obric.aiagent.ipc.utils.h.d("IPlatformApiIDLIPC", "getTasksPackages = " + r115);     // Catch: Exception -> L15 Throwable -> L17
    L13:
        long r215 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L17
        long r104 = Math.max(0, r215 - r110) / 1000;     // Catch: Exception -> L15 Throwable -> L17
        int r117 = com.obric.aiagent.ipc.utils.i.f384748a;     // Catch: Exception -> L15 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IPlatformApiIDLIPC", "getTasksPackages(" + r210 + ", " + r211 + ", " + r212 + ", " + r213 + ") = " + r115, r104);     // Catch: Exception -> L15 Throwable -> L17
        IPCAnomalyTrace.f384709a.c("IPlatformApiIDLIPC", "getTasksPackages", r104, r215);     // Catch: Exception -> L15 Throwable -> L17
        return r115;
    L27:
        return r115;
    L28:
        return null;
    }
}
