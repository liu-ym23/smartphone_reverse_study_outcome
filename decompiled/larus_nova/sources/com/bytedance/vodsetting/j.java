package com.bytedance.vodsetting;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f272575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f272576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f272577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f272578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f272579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SharedPreferences f272580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f272581g;

    public final JSONObject b() {
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
            android.content.Context r0 = r2.f272577c
            r2.g(r0)
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r2.f272575a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            org.json.JSONObject r0 = r2.f272576b     // Catch: java.lang.Throwable -> L1e org.json.JSONException -> L20
            if (r0 == 0) goto L2a
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1e org.json.JSONException -> L20
            org.json.JSONObject r1 = r2.f272576b     // Catch: java.lang.Throwable -> L1e org.json.JSONException -> L20
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L1e org.json.JSONException -> L20
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L1e org.json.JSONException -> L20
            goto L2b
        L1e:
            r0 = move-exception
            goto L35
        L20:
            r0 = move-exception
            java.lang.String r1 = "Storage"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1e
            com.bytedance.vodsetting.e.a(r1, r0)     // Catch: java.lang.Throwable -> L1e
        L2a:
            r0 = 0
        L2b:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r2.f272575a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            return r0
        L35:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r2.f272575a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.vodsetting.j.b():org.json.JSONObject");
    }

    public final void f() {
        this.f272575a.writeLock().lock();
        if (this.f272576b == null) goto L6;
        this.f272576b = new JSONObject();
    L6:
        if ((this.f272579e & 2) <= 0) goto L10;
        SharedPreferences r100 = this.f272580f;
        if (r100 == null) goto L10;
        SharedPreferences.Editor r101 = r100.edit();
        r101.clear();
        r101.apply();
    L10:
        this.f272575a.writeLock().unlock();
    }

    public final synchronized boolean g(Context r100) {
        monitor-enter(this);
    L45:
        th = move-exception;
        throw th;
    L6:
        if (this.f272578d != 2) goto L9;
        monitor-exit(this);
        return true;
    L9:
        this.f272577c = r100;     // Catch: Throwable -> L45
        if (r100 != null) goto L14;
        e.a("Storage", "try to load local. Context is null");     // Catch: Throwable -> L45
        monitor-exit(this);
        return false;
    L14:
        this.f272578d = 1;     // Catch: Throwable -> L45
        e.b("Storage", "loading local settings, name = " + this.f272581g);     // Catch: Throwable -> L45
        if ((this.f272579e & 2) <= 0) goto L38;
        SharedPreferences r101 = this.f272577c.getSharedPreferences("com.bd.vod.ST.settings." + this.f272581g, 0);     // Catch: Throwable -> L45
        this.f272580f = r101;     // Catch: Throwable -> L45
        if ((this.f272579e & 1) <= 0) goto L34;
        if (r101 == null) goto L34;
        String r102 = r101.getString(this.f272581g + "_whole", "");     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r102) == true) goto L42;
        this.f272575a.writeLock().lock();     // Catch: Throwable -> L45
        this.f272576b = new JSONObject(r102);     // Catch: Throwable -> L25 JSONException -> L27
        this.f272575a.writeLock().unlock();     // Catch: Throwable -> L45
        goto L42
    L25:
        th = move-exception;
        this.f272575a.writeLock().unlock();     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L27:
        e = move-exception;
        e.a("Storage", e.toString());     // Catch: Throwable -> L25
        this.f272578d = 0;     // Catch: Throwable -> L25
        this.f272575a.writeLock().unlock();     // Catch: Throwable -> L45
        return false;
    L42:
        this.f272578d = 2;     // Catch: Throwable -> L45
        e.b("Storage", "load local settings, name = " + this.f272581g);     // Catch: Throwable -> L45
        monitor-exit(this);
        return true;
    L34:
        this.f272575a.writeLock().lock();     // Catch: Throwable -> L45
        if (this.f272576b != null) goto L37;
        this.f272576b = new JSONObject();     // Catch: Throwable -> L45
    L37:
        this.f272575a.writeLock().unlock();     // Catch: Throwable -> L45
        goto L42
    L38:
        this.f272575a.writeLock().lock();     // Catch: Throwable -> L45
        if (this.f272576b != null) goto L41;
        this.f272576b = new JSONObject();     // Catch: Throwable -> L45
    L41:
        this.f272575a.writeLock().unlock();     // Catch: Throwable -> L45
        goto L42
    }

    public j(String r100, int r101) {
        this.f272575a = new ReentrantReadWriteLock();
        this.f272576b = null;
        this.f272577c = null;
        this.f272578d = 0;
        this.f272580f = null;
        this.f272581g = r100;
        this.f272579e = r101;
    }

    public final int a(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        g(this.f272577c);
        int r102 = 0;
        if ((this.f272579e & 1) <= 0) goto L14;
        this.f272575a.readLock().lock();
        JSONObject r103 = this.f272576b;
        if (r103 != null) goto L10;
    L12:
        int r104 = r101;
    L13:
        this.f272575a.readLock().unlock();
    L15:
        if (r102 == 0) goto L17;
        return r104;
    L17:
        if ((this.f272579e & 2) <= 0) goto L24;
        if (r104 != r101) goto L25;
        SharedPreferences r105 = this.f272580f;
        if (r105 == null) goto L26;
        int r106 = r105.getInt(r100, r101);
        e.b("Storage", "get int from SP, key = " + r100 + ", retValue = " + r106);
        return r106;
    L26:
        return r104;
    L25:
        return r104;
    L24:
        return r104;
    L10:
        if (r103.isNull(r100) == true) goto L12;
        r104 = this.f272576b.optInt(r100);
        r102 = this.f272576b.length();
        goto L13
    L14:
        r104 = r101;
        goto L15
    }

    public final long c(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        g(this.f272577c);
        if ((this.f272579e & 1) <= 0) goto L14;
        this.f272575a.readLock().lock();
        JSONObject r102 = this.f272576b;
        if (r102 != null) goto L10;
    L12:
        long r103 = r101;
        int r104 = 0;
    L13:
        this.f272575a.readLock().unlock();
    L15:
        if (r104 == 0) goto L17;
        return r103;
    L17:
        if (r103 == r101) goto L19;
        return r103;
    L19:
        if ((this.f272579e & 2) <= 0) goto L26;
        SharedPreferences r105 = this.f272580f;
        if (r105 == null) goto L27;
        long r106 = r105.getLong(r100, r101);
        e.b("Storage", "get long from SP, key = " + r100 + ", retValue = " + r106);
        return r106;
    L27:
        return r103;
    L26:
        return r103;
    L10:
        if (r102.isNull(r100) == true) goto L12;
        r103 = this.f272576b.optLong(r100);
        r104 = this.f272576b.length();
        goto L13
    L14:
        r103 = r101;
        r104 = 0;
        goto L15
    }

    public final void d(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        g(this.f272577c);
        if ((this.f272579e & 1) <= 0) goto L20;
        this.f272575a.writeLock().lock();
        JSONObject r102 = this.f272576b;     // Catch: Throwable -> L12 JSONException -> L14
        if (r102 == null) goto L16;
        r102.put(r100, r101);     // Catch: Throwable -> L12 JSONException -> L14
    L16:
        this.f272575a.writeLock().unlock();
    L12:
        th = move-exception;
        this.f272575a.writeLock().unlock();
        throw th;
    L14:
        e = move-exception;
        e.a("Storage", e.toString());     // Catch: Throwable -> L12
    L20:
        if ((this.f272579e & 2) <= 0) goto L28;
        SharedPreferences r103 = this.f272580f;
        if (r103 == null) goto L29;
        SharedPreferences.Editor r104 = r103.edit();
        r104.putInt(r100, r101);
        r104.apply();
        return;
    L29:
        return;
    }

    public final void e(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        g(this.f272577c);
        if ((this.f272579e & 1) <= 0) goto L20;
        this.f272575a.writeLock().lock();
        JSONObject r102 = this.f272576b;     // Catch: Throwable -> L12 JSONException -> L14
        if (r102 == null) goto L16;
        r102.put(r100, r101);     // Catch: Throwable -> L12 JSONException -> L14
    L16:
        this.f272575a.writeLock().unlock();
    L12:
        th = move-exception;
        this.f272575a.writeLock().unlock();
        throw th;
    L14:
        e = move-exception;
        e.a("Storage", e.toString());     // Catch: Throwable -> L12
    L20:
        if ((this.f272579e & 2) <= 0) goto L28;
        SharedPreferences r103 = this.f272580f;
        if (r103 == null) goto L29;
        SharedPreferences.Editor r104 = r103.edit();
        r104.putLong(r100, r101);
        r104.apply();
        return;
    L29:
        return;
    }
}
