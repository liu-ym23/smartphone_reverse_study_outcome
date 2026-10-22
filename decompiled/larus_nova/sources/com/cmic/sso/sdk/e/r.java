package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static r f273523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConnectivityManager f273524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Network f273525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f273526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f273527e;

    /* JADX INFO: loaded from: classes22.dex */
    public interface a {
        void a(Network r100);
    }

    public synchronized void b() {
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
            monitor-enter(r2)
            android.net.ConnectivityManager r0 = r2.f273524b     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L7
            monitor-exit(r2)
            return
        L7:
            android.net.ConnectivityManager$NetworkCallback r0 = r2.f273526d     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L28
            if (r0 != 0) goto Ld
            monitor-exit(r2)
            return
        Ld:
            java.lang.String r0 = "WifiNetworkUtils"
            java.lang.String r1 = "unregisterNetwork"
            com.cmic.sso.sdk.e.c.b(r0, r1)     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L28
            android.net.ConnectivityManager r0 = r2.f273524b     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L28
            android.net.ConnectivityManager$NetworkCallback r1 = r2.f273526d     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L28
            r0.unregisterNetworkCallback(r1)     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L28
            r0 = 0
            r2.f273526d = r0     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L28
            r2.f273525c = r0     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L28
            goto L26
        L22:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L28
        L26:
            monitor-exit(r2)
            return
        L28:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.e.r.b():void");
    }

    public boolean a() {
        if (this.f273525c == null) goto L5;
        return true;
    L5:
        return false;
    }

    private r(Context r100) {
        this.f273524b = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ ConnectivityManager.NetworkCallback b(r r100) {
        return r100.f273526d;
    }

    public synchronized void a(final a r100) {
        monitor-enter(this);
        ConnectivityManager r101 = this.f273524b;     // Catch: Throwable -> L33
        if (r101 != null) goto L8;
        c.a("WifiNetworkUtils", "mConnectivityManager 为空");     // Catch: Throwable -> L33
        r100.a(null);     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L8:
        Network r102 = this.f273525c;     // Catch: Throwable -> L33
        if (r102 != null) goto L11;
    L19:
        ConnectivityManager.NetworkCallback r103 = this.f273526d;     // Catch: Throwable -> L33
        if (r103 != null) goto L36;
    L26:
        NetworkRequest r104 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();     // Catch: Throwable -> L33
        ConnectivityManager.NetworkCallback r105 = new AnonymousClass1(this, r100);     // Catch: Throwable -> L33
        this.f273526d = r105;     // Catch: Throwable -> L33
        this.f273524b.requestNetwork(r104, r105);     // Catch: Exception -> L29 Throwable -> L33
    L31:
        monitor-exit(this);
        return;
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        r100.a(null);     // Catch: Throwable -> L33
        goto L31
    L36:
        this.f273524b.unregisterNetworkCallback(r103);     // Catch: Exception -> L23 Throwable -> L33
    L25:
        c.a("HttpUtils", "clear: ");     // Catch: Throwable -> L33
        goto L26
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        this.f273526d = null;     // Catch: Throwable -> L33
        goto L25
    L11:
        if (this.f273527e == true) goto L19;
        NetworkInfo r106 = r101.getNetworkInfo(r102);     // Catch: Throwable -> L33
        if (r106 == null) goto L19;
        if (r106.isAvailable() == false) goto L19;
        c.a("HttpUtils", "reuse network: ");     // Catch: Throwable -> L33
        r100.a(this.f273525c);     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L33:
        th = move-exception;
        throw th;
    }

    public static r a(Context r100) {
        if (f273523a != null) goto L15;
        monitor-enter(r.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273523a != null) goto L9;
        f273523a = new r(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r.class);     // Catch: Throwable -> L11
    L15:
        return f273523a;
    }

    public static /* synthetic */ ConnectivityManager a(r r100) {
        return r100.f273524b;
    }

    public static /* synthetic */ Network a(r r100, Network r101) {
        r100.f273525c = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(r r100, boolean r101) {
        r100.f273527e = r101;
        return r101;
    }
}
