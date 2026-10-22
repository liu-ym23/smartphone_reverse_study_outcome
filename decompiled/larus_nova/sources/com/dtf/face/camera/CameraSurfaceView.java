package com.dtf.face.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import baseverify.a;
import com.dtf.face.config.DeviceSetting;
import is7.d;
import is7.e;
import js7.b;

/* JADX INFO: loaded from: classes22.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static e f273632e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SurfaceHolder f273633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f273634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f273635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DeviceSetting f273636d;

    public static String getCameraName() {
        return "Android";
    }

    public static synchronized e getCameraImpl() {
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
            java.lang.Class<com.dtf.face.camera.CameraSurfaceView> r0 = com.dtf.face.camera.CameraSurfaceView.class
            monitor-enter(r0)
            is7.e r1 = com.dtf.face.camera.CameraSurfaceView.f273632e     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L1e
            java.lang.Class<baseverify.a> r1 = baseverify.a.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L22
            baseverify.a r2 = baseverify.a.f18453a     // Catch: java.lang.Throwable -> L1b
            if (r2 != 0) goto L15
            baseverify.a r2 = new baseverify.a     // Catch: java.lang.Throwable -> L1b
            r2.<init>()     // Catch: java.lang.Throwable -> L1b
            baseverify.a.f18453a = r2     // Catch: java.lang.Throwable -> L1b
        L15:
            baseverify.a r2 = baseverify.a.f18453a     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L22
            com.dtf.face.camera.CameraSurfaceView.f273632e = r2     // Catch: java.lang.Throwable -> L22
            goto L1e
        L1b:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L22
            throw r2     // Catch: java.lang.Throwable -> L22
        L1e:
            is7.e r1 = com.dtf.face.camera.CameraSurfaceView.f273632e     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return r1
        L22:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dtf.face.camera.CameraSurfaceView.getCameraImpl():is7.e");
    }

    public e getCameraInterface() {
        return f273632e;
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.f273633a;
    }

    public void setCameraCallback(d r100) {
        this.f273635c = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        e r101 = f273632e;
        if (r101 == null) goto L5;
        r101.setCallback(this.f273635c);
    L5:
        e r102 = f273632e;
        if (r102 == null) goto L8;
        r102.startCamera();
    L8:
        d r103 = this.f273635c;
        if (r103 == null) goto L12;
        r103.a();
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        e r101 = f273632e;
        if (r101 == null) goto L5;
        r101.stopCamera();
        f273632e.setCallback(null);
        f273632e.releaseCamera();
    L5:
        d r102 = this.f273635c;
        if (r102 == null) goto L9;
        r102.onSurfaceDestroyed();
        return;
    }

    public CameraSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f273634b = b.e(r100.getApplicationContext());
        SurfaceHolder r102 = getHolder();
        this.f273633a = r102;
        r102.setFormat(-2);
        r102.setType(3);
        r102.addCallback(this);
        setTag(getClass().getSimpleName() + ":" + getClass());
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        e r104 = f273632e;
        if (r104 == null) goto L18;
        r104.startPreview(this.f273633a, this.f273634b, r102, r103);
        if (this.f273635c == null) goto L19;
        int r105 = f273632e.getCameraViewRotation();
        if (r105 != 90) goto L9;
    L15:
        r102 = f273632e.getPreviewHeight();
        r103 = f273632e.getPreviewWidth();
    L16:
        this.f273635c.b(r102, r103);
        return;
    L9:
        if (r105 == 270) goto L15;
        if (r105 != 0) goto L13;
    L14:
        r102 = f273632e.getPreviewWidth();
        r103 = f273632e.getPreviewHeight();
        goto L16
    L13:
        if (r105 != 180) goto L16;
    L19:
        return;
    }
}
