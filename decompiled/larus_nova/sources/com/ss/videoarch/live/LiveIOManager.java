package com.ss.videoarch.live;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class LiveIOManager extends com.ss.videoarch.live.a implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.videoarch.live.a.InterfaceC5509a f458544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.videoarch.live.a.c f458545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.videoarch.live.a.d f458546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.videoarch.live.a.e f458547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f458548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f458549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f458550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public rmc.d f458551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f458552i;

    public final class a {
    }

    private native void _close();

    private native int _create();

    private native long _getLongValue(int r100);

    private native long _getLongValueByStr(String r100, int r101);

    private native String _getStringValue(int r100);

    private native String _getStringValueByStr(String r100, int r101);

    private native String _getStringValueByStr2(String r100, int r101, String r102);

    private native void _loadDemuxer(String r100, String r101);

    private native void _notifyFnish(String r100, String r101);

    private native void _preConnect(String r100, String r101);

    private native void _prepare(String r100, String r101);

    private native void _setConfig(int r100, String r101);

    private native void _setInt64Value(int r100, long r101);

    private native void _setInt64ValueByStrKey(int r100, String r101, long r102);

    private native void _setIntValue(int r100, int r101);

    private native void _setStringValue(int r100, String r101);

    private native void _setStringValueByStr(int r100, String r101, String r102);

    private native int _start();

    private native void _unloadDemuxer(String r100, String r101);

    @Override // com.ss.videoarch.live.a
    public final String c() {
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
            int r0 = r3.f458552i
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L7
            return r2
        L7:
            monitor-enter(r3)
            boolean r0 = r3.f458550g     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L17
            r0 = 1100(0x44c, float:1.541E-42)
            java.lang.String r2 = r3._getStringValue(r0)     // Catch: java.lang.Throwable -> L13
            goto L17
        L13:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L19
        L17:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L19
            return r2
        L19:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L19
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.c():java.lang.String");
    }

    @Override // com.ss.videoarch.live.a
    public final boolean e() {
        if (this.f458552i == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public LiveIOManager() {
        this.f458544a = null;
        this.f458545b = null;
        this.f458546c = null;
        this.f458547d = null;
        this.f458548e = null;
        this.f458549f = null;
        this.f458550g = false;
        this.f458551h = null;
        this.f458552i = 0;
    }

    @Override // com.ss.videoarch.live.a
    public final long a(int r100) {
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
            boolean r0 = r2.f458550g     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto Le
            long r0 = r2._getLongValue(r3)     // Catch: java.lang.Throwable -> La
            goto L10
        La:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L14
        Le:
            r0 = -1
        L10:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            return r0
        L14:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.a(int):long");
    }

    @Override // com.ss.videoarch.live.a
    public final void g(String r100) {
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
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L7
            return
        L7:
            monitor-enter(r1)
            boolean r0 = r1.f458550g     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L15
            r0 = 0
            r1._notifyFnish(r2, r0)     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            return
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.g(java.lang.String):void");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1137) goto L5;
        com.ss.videoarch.live.a.d r102 = this.f458546c;
        if (r102 == null) goto L65;
        String r103 = r102.g();
        if (TextUtils.isEmpty(r103) == true) goto L65;
        o(1136, r103);
    L65:
        return true;
    L5:
        if (r101 != 1149) goto L7;
        String r104 = (String) r100.obj;     // Catch: Exception -> L58
        String r105 = this.f458547d.b(r104);     // Catch: Exception -> L58
        if (r105 == null) goto L65;
        o(1150, r105);     // Catch: Exception -> L58
    L58:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L7:
        if (r101 != 1161) goto L9;
        com.ss.videoarch.live.a.d r106 = this.f458546c;
        if (r106 == null) goto L65;
        String r107 = r106.c(402, null).toString();     // Catch: Exception -> L52
        if (TextUtils.isEmpty(r107) == true) goto L65;
        o(1162, r107);     // Catch: Exception -> L52
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L9:
        if (r101 == 1163) goto L40;
        if (r101 != 1170) goto L13;
        String r108 = (String) r100.obj;     // Catch: Exception -> L37
        List<String> r109 = this.f458547d.d(r108);     // Catch: Exception -> L37
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L37
        JSONArray r111 = new JSONArray();     // Catch: Exception -> L37
        if (r109 == null) goto L35;
        Iterator<String> r112 = r109.iterator();     // Catch: Exception -> L37
    L33:
        if (r112.hasNext() == false) goto L35;
        r111.put(r112.next());     // Catch: Exception -> L37
    L35:
        r110.put("host", r108);     // Catch: Exception -> L37
        r110.put("ips", r111);     // Catch: Exception -> L37
        o(1171, r110.toString());     // Catch: Exception -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L13:
        if (r101 == 1178) goto L74;
        switch(r101) {
            case 3000: goto L22;
            case 3001: goto L19;
            case 3002: goto L16;
            default: goto L65;
        };
    L16:
        com.ss.videoarch.live.a.d r113 = this.f458546c;
        if (r113 == null) goto L65;
        r113.e((String) r100.obj);
        goto L65
    L19:
        com.ss.videoarch.live.a.c r114 = this.f458545b;
        if (r114 == null) goto L65;
        ((a) r100.obj).getClass();
        r114.a();
        goto L65
    L22:
        com.ss.videoarch.live.a.InterfaceC5509a r115 = this.f458544a;
        if (r115 == null) goto L65;
        r115.f((String) r100.obj);
        goto L65
    L74:
        l(1179, this.f458547d.getEffectiveConnectionType());     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L40:
        if (this.f458546c == null) goto L65;
        JSONObject r116 = new JSONObject();     // Catch: Exception -> L43
        r116.put("needAccess", 1);     // Catch: Exception -> L43
        this.f458546c.c(403, r116);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L65
    }

    @Override // com.ss.videoarch.live.a
    public final void j(String r100) {
        monitor-enter(this);
        this.f458548e = r100;     // Catch: Throwable -> L5 Exception -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        goto L9
    }

    @Override // com.ss.videoarch.live.a
    public final int q(Looper r100) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.f458548e) == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L31
        return -1;
    L7:
        s(this.f458548e);     // Catch: Throwable -> L31
        int r101 = 1;
        if (this.f458550g == false) goto L37;
    L16:
        _setConfig(1000, this.f458548e);     // Catch: Throwable -> L31
        if (r100 != null) goto L19;
        rmc.d r102 = new rmc.d(this, this);     // Catch: Throwable -> L31
        this.f458551h = r102;     // Catch: Throwable -> L31
        ThreadMethodProxy.setName(r102, "LiveIO_Java_Loop");     // Catch: Throwable -> L31
        ThreadMethodProxy.start(this.f458551h);     // Catch: Throwable -> L31
    L35:
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
        th.toString();     // Catch: Throwable -> L31
        return -1;
    L21:
        if (_start() == 0) goto L24;
        r101 = 0;
    L24:
        this.f458552i = r101;     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L31
        return 0;
    L19:
        new Handler(r100, this);     // Catch: Throwable -> L31
        goto L35
    L37:
        _create();     // Catch: Throwable -> L12
        this.f458550g = true;     // Catch: Throwable -> L31
        goto L16
    L12:
        th = move-exception;
        this.f458550g = false;     // Catch: Throwable -> L31
        this.f458552i = 0;     // Catch: Throwable -> L31
        th.printStackTrace();     // Catch: Throwable -> L31
        th.toString();     // Catch: Throwable -> L31
        return -1;
    }

    @Override // com.ss.videoarch.live.a
    public final void r(String r100) {
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
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L7
            return
        L7:
            monitor-enter(r1)
            boolean r0 = r1.f458550g     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L15
            r0 = 0
            r1._unloadDemuxer(r2, r0)     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            return
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.r(java.lang.String):void");
    }

    public final void s(String r100) {
    L18:
        e = move-exception;
        e.toString();
        return;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L18
        if (r101.isNull("cache_dir") == true) goto L10;
        this.f458549f = JSONObjectProtectorUtils.getString(r101, "cache_dir");     // Catch: Exception -> L18
    L10:
        if (TextUtils.isEmpty(this.f458549f) == true) goto L23;
        String r102 = this.f458549f;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r102) == true) goto L24;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);     // Catch: Exception -> L18
        if (r103.exists() == true) goto L25;
        r103.mkdirs();     // Catch: Exception -> L18
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // com.ss.videoarch.live.a
    public final long b(String r100, int r101) {
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
            int r0 = r4.f458552i
            r1 = 1
            r2 = -1
            if (r0 == r1) goto L8
            return r2
        L8:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto Lf
            return r2
        Lf:
            monitor-enter(r4)
            boolean r0 = r4.f458550g     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1d
            long r2 = r4._getLongValueByStr(r5, r6)     // Catch: java.lang.Throwable -> L19
            goto L1d
        L19:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1f
        L1d:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1f
            return r2
        L1f:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1f
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.b(java.lang.String, int):long");
    }

    @Override // com.ss.videoarch.live.a
    public final String d(String r100, int r101) {
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
            int r0 = r3.f458552i
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L7
            return r2
        L7:
            monitor-enter(r3)
            boolean r0 = r3.f458550g     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L15
            java.lang.String r2 = r3._getStringValueByStr(r4, r5)     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L17
            return r2
        L17:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L17
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.d(java.lang.String, int):java.lang.String");
    }

    @Override // com.ss.videoarch.live.a
    public final void f(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        monitor-enter(this);
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f458550g == false) goto L14;
        _loadDemuxer(r100, r101);     // Catch: Throwable -> L12
    }

    @Override // com.ss.videoarch.live.a
    public final void h(String r100, String r101) {
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
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L7
            return
        L7:
            monitor-enter(r1)
            boolean r0 = r1.f458550g     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto L14
            r1._preConnect(r2, r3)     // Catch: java.lang.Throwable -> L10
            goto L14
        L10:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L16
        L14:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L16
            return
        L16:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L16
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.h(java.lang.String, java.lang.String):void");
    }

    @Override // com.ss.videoarch.live.a
    public final void i(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        monitor-enter(this);
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f458550g == false) goto L14;
        _prepare(r100, r101);     // Catch: Throwable -> L12
    }

    @Override // com.ss.videoarch.live.a
    public final void l(int r100, int r101) {
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
            monitor-enter(r1)
            boolean r0 = r1.f458550g     // Catch: java.lang.Throwable -> L9
            if (r0 == 0) goto Ld
            r1._setIntValue(r2, r3)     // Catch: java.lang.Throwable -> L9
            goto Ld
        L9:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lf
        Ld:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lf
            return
        Lf:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lf
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.l(int, int):void");
    }

    @Override // com.ss.videoarch.live.a
    public final void m(int r100, com.ss.videoarch.live.a.b r101) {
        monitor-enter(this);
        switch(r100) {
            case 2000: goto L15;
            case 2001: goto L12;
            case 2002: goto L9;
            case 2003: goto L6;
            default: goto L19;
        };
    L19:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L6:
        if ((r101 instanceof com.ss.videoarch.live.a.e) == false) goto L19;
        this.f458547d = (com.ss.videoarch.live.a.e) r101;     // Catch: Throwable -> L17
        goto L19
    L9:
        if ((r101 instanceof com.ss.videoarch.live.a.d) == false) goto L19;
        this.f458546c = (com.ss.videoarch.live.a.d) r101;     // Catch: Throwable -> L17
        goto L19
    L12:
        if ((r101 instanceof com.ss.videoarch.live.a.c) == false) goto L19;
        this.f458545b = (com.ss.videoarch.live.a.c) r101;     // Catch: Throwable -> L17
        goto L19
    L15:
        if ((r101 instanceof com.ss.videoarch.live.a.InterfaceC5509a) == false) goto L19;
        this.f458544a = (com.ss.videoarch.live.a.InterfaceC5509a) r101;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.videoarch.live.a
    public final void n(int r100, long r101) {
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
            int r0 = r2.f458552i
            r1 = 1
            if (r0 == r1) goto L6
            return
        L6:
            monitor-enter(r2)
            boolean r0 = r2.f458550g     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L13
            r2._setInt64Value(r3, r4)     // Catch: java.lang.Throwable -> Lf
            goto L13
        Lf:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L15
        L13:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L15
            return
        L15:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.n(int, long):void");
    }

    @Override // com.ss.videoarch.live.a
    public final void o(int r100, String r101) {
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
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L7
            return
        L7:
            int r0 = r2.f458552i
            r1 = 1
            if (r0 == r1) goto Ld
            return
        Ld:
            monitor-enter(r2)
            boolean r0 = r2.f458550g     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            r2._setStringValue(r3, r4)     // Catch: java.lang.Throwable -> L16
            goto L1a
        L16:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1c
        L1a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            return
        L1c:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.o(int, java.lang.String):void");
    }

    @Override // com.ss.videoarch.live.a
    public final void p(String r100, String r101) {
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
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L7
            return
        L7:
            int r0 = r2.f458552i
            r1 = 1
            if (r0 == r1) goto Ld
            return
        Ld:
            monitor-enter(r2)
            boolean r0 = r2.f458550g     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            r0 = 1104(0x450, float:1.547E-42)
            r2._setStringValueByStr(r0, r3, r4)     // Catch: java.lang.Throwable -> L18
            goto L1c
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1e
        L1c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
            return
        L1e:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.p(java.lang.String, java.lang.String):void");
    }

    @Override // com.ss.videoarch.live.a
    public final void k(int r100, String r101, long r102) {
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
            int r0 = r2.f458552i
            r1 = 1
            if (r0 == r1) goto L6
            return
        L6:
            monitor-enter(r2)
            boolean r0 = r2.f458550g     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L13
            r2._setInt64ValueByStrKey(r3, r4, r5)     // Catch: java.lang.Throwable -> Lf
            goto L13
        Lf:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L15
        L13:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L15
            return
        L15:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.live.LiveIOManager.k(int, java.lang.String, long):void");
    }
}
