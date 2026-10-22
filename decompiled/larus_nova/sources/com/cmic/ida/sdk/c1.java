package com.cmic.ida.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes22.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.cmic.ida.sdk.b.a f273092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f273093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f273094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f273095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CountDownLatch f273096e;

    public class a extends d1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1 f273097a;

        public a(c1 r100) {
            this.f273097a = r100;
        }

        @Override // com.cmic.ida.sdk.d1
        public void a(int r100, long r101, boolean r102, float r103, double r104, String r105) {
        }

        @Override // com.cmic.ida.sdk.d1
        public void a(int r100, Bundle r101) {
            Objects.toString(r101);
            if (r100 == 0) goto L21;
        L16:
            c1.a(this.f273097a);
            return;
        L21:
            com.cmic.ida.sdk.b.a r102 = this.f273097a.f273092a;     // Catch: Throwable -> L9 Exception -> L11
            if (r102 != null) goto L7;
        L18:
            goto L16
        L7:
            r102.f273076a = r101.getString("oa_id_flag");     // Catch: Throwable -> L9 Exception -> L11
        L11:
            e = move-exception;
            e.getMessage();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            c1.a(this.f273097a);
            throw th;
        }
    }

    public class b extends d1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1 f273098a;

        public b(c1 r100) {
            this.f273098a = r100;
        }

        @Override // com.cmic.ida.sdk.d1
        public void a(int r100, long r101, boolean r102, float r103, double r104, String r105) {
        }

        @Override // com.cmic.ida.sdk.d1
        public void a(int r100, Bundle r101) {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.util.Objects.toString(r3)
                if (r2 != 0) goto L2b
                com.cmic.ida.sdk.c1 r2 = r1.f273098a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                com.cmic.ida.sdk.b$a r2 = r2.f273092a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                if (r2 == 0) goto L2b
                java.lang.String r2 = "oa_id_limit_state"
                boolean r2 = r3.getBoolean(r2)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                com.cmic.ida.sdk.c1 r3 = r1.f273098a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                com.cmic.ida.sdk.b$a r3 = r3.f273092a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                r3.f273077b = r2     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
                goto L2b
            L1c:
                r2 = move-exception
                goto L25
            L1e:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
                r2.getMessage()     // Catch: java.lang.Throwable -> L1c
                goto L2b
            L25:
                com.cmic.ida.sdk.c1 r3 = r1.f273098a
                com.cmic.ida.sdk.c1.a(r3)
                throw r2
            L2b:
                com.cmic.ida.sdk.c1 r2 = r1.f273098a
                com.cmic.ida.sdk.c1.a(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cmic.ida.sdk.c1.b.a(int, android.os.Bundle):void");
        }
    }

    public c1() {
        this.f273094c = new a(this);
        this.f273095d = new b(this);
        this.f273096e = new CountDownLatch(2);
    }

    public final void a() {
        this.f273096e.countDown();     // Catch: Exception -> L4
        this.f273096e.countDown();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.getMessage();
    }

    public boolean a(Context r100) {
        PackageManager r101 = r100.getPackageManager();     // Catch: Exception -> L6
        r101.getPackageInfo("com.hihonor.id", 0);     // Catch: Exception -> L6
        Intent r102 = new Intent("com.hihonor.id.HnOaIdService");     // Catch: Exception -> L6
        r102.setPackage("com.hihonor.id");     // Catch: Exception -> L6
        return !r101.queryIntentServices(r102, 0).isEmpty();
    L9:
        return false;
    }

    public static void a(c1 r100) {
        r100.getClass();
        r100.f273096e.countDown();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.getMessage();
    }
}
