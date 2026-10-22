package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes41.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f462530c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f462531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f462532b;

    private synchronized byte[] a() {
        monitor-enter(this);
        byte[] r100 = this.f462531a;     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
    L7:
        this.f462531a = ad.c().d();     // Catch: Throwable -> L11
    L8:
        byte[] r101 = this.f462531a;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L6:
        if (r100.length > 0) goto L8;
    L11:
        th = move-exception;
        throw th;
    }

    private synchronized byte[] b() {
        monitor-enter(this);
        byte[] r100 = this.f462532b;     // Catch: Throwable -> L13
        if (r100 != null) goto L6;
    L10:
        byte[] r101 = ad.c().e();     // Catch: Throwable -> L13
        this.f462532b = r101;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r101;
    L6:
        if (r100.length <= 0) goto L10;
        monitor-exit(this);
        return r100;
    L13:
        th = move-exception;
        throw th;
    }

    private a(Context r100) {
        ad.c().a(ContextDelegate.getContext(r100));
    }

    public final String a(String r100) throws Exception {
        String r101 = j.a(a());
        String r102 = j.a(b());
        byte[] r103 = Base64.decode(r100, 2);
        SecretKeySpec r104 = new SecretKeySpec(r102.getBytes(XML.CHARSET_UTF8), CryptoConst.ALGORITHM_AES);
        Cipher r105 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r105.init(2, r104, new IvParameterSpec(r101.getBytes(XML.CHARSET_UTF8)));
        return new String(r105.doFinal(r103), XML.CHARSET_UTF8);
    }

    public static synchronized a a(Context r100) {
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
            java.lang.Class<com.vivo.push.util.a> r0 = com.vivo.push.util.a.class
            monitor-enter(r0)
            com.vivo.push.util.a r1 = com.vivo.push.util.a.f462530c     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L1e
            java.lang.Class<com.vivo.push.util.a> r1 = com.vivo.push.util.a.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L22
            com.vivo.push.util.a r2 = com.vivo.push.util.a.f462530c     // Catch: java.lang.Throwable -> L1b
            if (r2 != 0) goto L19
            com.vivo.push.util.a r2 = new com.vivo.push.util.a     // Catch: java.lang.Throwable -> L1b
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Throwable -> L1b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1b
            com.vivo.push.util.a.f462530c = r2     // Catch: java.lang.Throwable -> L1b
        L19:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1b
            goto L1e
        L1b:
            r3 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L22
            throw r3     // Catch: java.lang.Throwable -> L22
        L1e:
            com.vivo.push.util.a r3 = com.vivo.push.util.a.f462530c     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return r3
        L22:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.a.a(android.content.Context):com.vivo.push.util.a");
    }
}
