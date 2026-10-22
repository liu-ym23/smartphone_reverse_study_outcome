package com.vivo.push.util;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
public class ContextDelegate {
    private static final String TAG = "ContextDelegate";
    private static Context mContext;
    private static volatile Method mCreateCredentialProtectedStorageContext;
    private static volatile Method mCreateDeviceProtectedStorageContext;
    private static boolean mDelegateEnable;
    private static volatile Boolean mIsFbeProject;
    private static volatile Boolean mIsFdeProject;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ContextDelegate f462529a;

        static {
            f462529a = new ContextDelegate();
        }

        public static /* synthetic */ ContextDelegate a() {
            return f462529a;
        }
    }

    public ContextDelegate() {
    }

    public static synchronized boolean isFBEProject() {
        monitor-enter(ContextDelegate.class);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (mIsFbeProject != null) goto L16;
    L13:
        e = move-exception;
        t.a(TAG, "mIsFbeProject = " + e.getMessage());     // Catch: Throwable -> L22
        goto L16
    L8:
        if ("file".equals(m.a("ro.crypto.type", "unknow")) == false) goto L10;
        boolean r100 = true;
    L11:
        mIsFbeProject = Boolean.valueOf(r100);     // Catch: Exception -> L13 Throwable -> L22
        t.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());     // Catch: Exception -> L13 Throwable -> L22
    L10:
        r100 = false;
    L16:
        if (mIsFbeProject != null) goto L19;
        monitor-exit(ContextDelegate.class);
        return false;
    L19:
        boolean r101 = mIsFbeProject.booleanValue();     // Catch: Throwable -> L22
        monitor-exit(ContextDelegate.class);
        return r101;
    }

    private static synchronized boolean isFDEProject() {
        monitor-enter(ContextDelegate.class);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (mIsFdeProject != null) goto L16;
    L13:
        e = move-exception;
        t.a(TAG, "mIsFdeProject = " + e.getMessage());     // Catch: Throwable -> L22
        goto L16
    L8:
        if ("block".equals(m.a("ro.crypto.type", "unknow")) == false) goto L10;
        boolean r100 = true;
    L11:
        mIsFdeProject = Boolean.valueOf(r100);     // Catch: Exception -> L13 Throwable -> L22
        t.b(TAG, "mIsFdeProject = " + mIsFdeProject.toString());     // Catch: Exception -> L13 Throwable -> L22
    L10:
        r100 = false;
    L16:
        if (mIsFdeProject != null) goto L19;
        monitor-exit(ContextDelegate.class);
        return false;
    L19:
        boolean r101 = mIsFdeProject.booleanValue();     // Catch: Throwable -> L22
        monitor-exit(ContextDelegate.class);
        return r101;
    }

    private static void setAppContext() {
        Context r100 = mContext;
        if (r100 != null) goto L5;
        return;
    L5:
        setContext(r100);
    }

    public static ContextDelegate getInstance() {
        return a.a();
    }

    private static synchronized Context createCredentialProtectedStorageContext(Context r100) {
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
            java.lang.Class<com.vivo.push.util.ContextDelegate> r0 = com.vivo.push.util.ContextDelegate.class
            monitor-enter(r0)
            java.lang.reflect.Method r1 = com.vivo.push.util.ContextDelegate.mCreateCredentialProtectedStorageContext     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            r2 = 0
            if (r1 != 0) goto L14
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            java.lang.String r3 = "createCredentialProtectedStorageContext"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            com.vivo.push.util.ContextDelegate.mCreateCredentialProtectedStorageContext = r1     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
        L14:
            java.lang.reflect.Method r1 = com.vivo.push.util.ContextDelegate.mCreateCredentialProtectedStorageContext     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.lang.Object r1 = r1.invoke(r5, r2)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            android.content.Context r1 = (android.content.Context) r1     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            monitor-exit(r0)
            return r1
        L20:
            r5 = move-exception
            goto L28
        L22:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L20
            monitor-exit(r0)
            return r5
        L28:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ContextDelegate.createCredentialProtectedStorageContext(android.content.Context):android.content.Context");
    }

    private static synchronized Context createDeviceProtectedStorageContext(Context r100) {
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
            java.lang.Class<com.vivo.push.util.ContextDelegate> r0 = com.vivo.push.util.ContextDelegate.class
            monitor-enter(r0)
            java.lang.reflect.Method r1 = com.vivo.push.util.ContextDelegate.mCreateDeviceProtectedStorageContext     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            r2 = 0
            if (r1 != 0) goto L14
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            java.lang.String r3 = "createDeviceProtectedStorageContext"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            com.vivo.push.util.ContextDelegate.mCreateDeviceProtectedStorageContext = r1     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
        L14:
            java.lang.reflect.Method r1 = com.vivo.push.util.ContextDelegate.mCreateDeviceProtectedStorageContext     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            java.lang.Object r1 = r1.invoke(r5, r2)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            android.content.Context r1 = (android.content.Context) r1     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            monitor-exit(r0)
            return r1
        L20:
            r5 = move-exception
            goto L28
        L22:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L20
            monitor-exit(r0)
            return r5
        L28:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.ContextDelegate.createDeviceProtectedStorageContext(android.content.Context):android.content.Context");
    }

    public static Context getContext(Context r100) {
        if (isFBEProject() == false) goto L5;
    L6:
        if (r100 != null) goto L8;
    L7:
        return r100;
    L8:
        Context r101 = mContext;
        if (r101 == null) goto L11;
        return r101;
    L11:
        setContext(r100);
        return mContext;
    L5:
        if (isFDEProject() == false) goto L7;
        goto L6
    }

    private static void setContext(Context r100) {
        if (mDelegateEnable == true) goto L6;
        mContext = createCredentialProtectedStorageContext(r100);
        return;
    L6:
        mContext = createDeviceProtectedStorageContext(r100);
    }

    public static void setEnable(boolean r100) {
        mDelegateEnable = r100;
        setAppContext();
    }
}
