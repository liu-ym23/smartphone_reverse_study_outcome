package com.ss.bytertc.base.media.screen;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Build;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.VideoSink;
import com.ss.bytertc.base.media.camera.CameraSession;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenCapturerAndroid implements VideoCapturer, VideoSink {
    private static final String TAG = "ScreenCaptureAndroid";
    private CapturerObserver capturerObserver;
    private Context mContext;
    private CountDownLatch mCountDownLatch;
    private boolean needStartService;

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void dispose() {
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
            monitor-enter(r4)
            boolean r0 = r4.needStartService     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L47
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L50
            r1 = 28
            if (r0 > r1) goto Lc
            goto L47
        Lc:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L50
            r0.<init>()     // Catch: java.lang.Throwable -> L50
            java.util.concurrent.CountDownLatch r1 = r4.mCountDownLatch     // Catch: java.lang.Throwable -> L50
            int r1 = r1.hashCode()     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = "hc"
            r0.putExtra(r2, r1)     // Catch: java.lang.Throwable -> L50
            java.util.concurrent.atomic.AtomicBoolean r1 = com.ss.bytertc.base.media.screen.RXScreenCaptureService.serviceStarted     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L2f java.lang.Throwable -> L50
            boolean r1 = r1.get()     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L2f java.lang.Throwable -> L50
            if (r1 == 0) goto L38
            android.content.Context r1 = r4.mContext     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L2f java.lang.Throwable -> L50
            r2 = 5
            android.content.Intent r0 = com.ss.bytertc.base.media.screen.RXScreenCaptureService.getServiceIntent(r1, r2, r0)     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L2f java.lang.Throwable -> L50
            r1.startForegroundService(r0)     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L2f java.lang.Throwable -> L50
            goto L38
        L2f:
            com.ss.bytertc.base.media.CapturerObserver r0 = r4.capturerObserver     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L38
            java.lang.String r1 = "Start foreground service failed."
            r0.onCapturerError(r1)     // Catch: java.lang.Throwable -> L50
        L38:
            java.util.concurrent.CountDownLatch r0 = r4.mCountDownLatch     // Catch: java.lang.InterruptedException -> L42 java.lang.Throwable -> L50
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.InterruptedException -> L42 java.lang.Throwable -> L50
            r2 = 1500(0x5dc, double:7.41E-321)
            r0.await(r2, r1)     // Catch: java.lang.InterruptedException -> L42 java.lang.Throwable -> L50
            goto L4e
        L42:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L50
            goto L4e
        L47:
            com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager r0 = com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager.INSTANCE()     // Catch: java.lang.Throwable -> L50
            r0.dispose()     // Catch: java.lang.Throwable -> L50
        L4e:
            monitor-exit(r4)
            return
        L50:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.bytertc.base.media.screen.ScreenCapturerAndroid.dispose():void");
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableCameraAutoExposureFaceMode(boolean r100) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableFollowGravity(boolean r100) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public float getCameraZoomMaxRatio() {
        return 1.0f;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraExposurePointSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraFocusPointSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraTorchSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraZoomSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isScreencast() {
        return true;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposureCompensation(float r100) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposurePoint(float r100, float r101) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraFocusPoint(float r100, float r101) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraZoomRatio(float r100) {
        return 0;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void stopCapture() {
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
            monitor-enter(r3)
            boolean r0 = r3.needStartService     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L2a
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L33
            r1 = 28
            if (r0 > r1) goto Lc
            goto L2a
        Lc:
            java.util.concurrent.atomic.AtomicBoolean r0 = com.ss.bytertc.base.media.screen.RXScreenCaptureService.serviceStarted     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L20 java.lang.Throwable -> L33
            boolean r0 = r0.get()     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L20 java.lang.Throwable -> L33
            if (r0 == 0) goto L31
            android.content.Context r0 = r3.mContext     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L20 java.lang.Throwable -> L33
            r1 = 2
            r2 = 0
            android.content.Intent r1 = com.ss.bytertc.base.media.screen.RXScreenCaptureService.getServiceIntent(r0, r1, r2)     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L20 java.lang.Throwable -> L33
            r0.startForegroundService(r1)     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L20 java.lang.Throwable -> L33
            goto L31
        L20:
            com.ss.bytertc.base.media.CapturerObserver r0 = r3.capturerObserver     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L31
            java.lang.String r1 = "Start foreground service failed."
            r0.onCapturerError(r1)     // Catch: java.lang.Throwable -> L33
            goto L31
        L2a:
            com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager r0 = com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager.INSTANCE()     // Catch: java.lang.Throwable -> L33
            r0.stopCapture()     // Catch: java.lang.Throwable -> L33
        L31:
            monitor-exit(r3)
            return
        L33:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.bytertc.base.media.screen.ScreenCapturerAndroid.stopCapture():void");
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOffFlashLight() {
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOnFlashLight() {
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void disableDoOrientation() {
        ScreenCaptureAndroidManager.INSTANCE().disableDoOrientation();
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int getDeviceOrientation() {
        return CameraSession.CC.getDeviceUIOrientation(ContextUtils.getApplicationContext());
    }

    public MediaProjection getMediaProjection() {
        return ScreenCaptureAndroidManager.INSTANCE().getMediaProjection();
    }

    @Override // com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame r100) {
        if (this.needStartService == true) goto L5;
    L15:
        ScreenCaptureAndroidManager.INSTANCE().onFrame(r100);
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 28) goto L15;
        int r101 = ScreenCaptureAndroidManager.INSTANCE().addFrame(r100);
        Intent r102 = new Intent();
        r102.putExtra(RXScreenCaptureService.KEY_INDEX, r101);
    L12:
        CapturerObserver r103 = this.capturerObserver;
        if (r103 == null) goto L20;
        r103.onCapturerError("Start foreground service failed.");
        return;
    L20:
        return;
    L9:
        if (RXScreenCaptureService.serviceStarted.get() == false) goto L19;
        Context r104 = this.mContext;     // Catch: ForegroundServiceStartNotAllowedException -> L12
        r104.startForegroundService(RXScreenCaptureService.getServiceIntent(r104, 4, r102));     // Catch: ForegroundServiceStartNotAllowedException -> L12
        return;
    }

    public ScreenCapturerAndroid(Intent r100, MediaProjection.Callback r101) {
        this(r100, r101, true);
    }

    public ScreenCapturerAndroid(Intent r100, MediaProjection.Callback r101, boolean r102) {
        this.mCountDownLatch = new CountDownLatch(1);
        this.needStartService = true;
        this.capturerObserver = null;
        ScreenCaptureAndroidManager.INSTANCE().addLock(this.mCountDownLatch.hashCode(), this.mCountDownLatch);
        ScreenCaptureAndroidManager.INSTANCE().setData(r100, r101);
        this.needStartService = r102;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void changeCaptureFormat(int r100, int r101, int r102) {
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
            boolean r0 = r2.needStartService     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L3e
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L47
            r1 = 28
            if (r0 > r1) goto Lc
            goto L3e
        Lc:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L47
            r0.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = "w"
            r0.putExtra(r1, r3)     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = "h"
            r0.putExtra(r3, r4)     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = "if"
            r0.putExtra(r3, r5)     // Catch: java.lang.Throwable -> L47
            java.util.concurrent.atomic.AtomicBoolean r3 = com.ss.bytertc.base.media.screen.RXScreenCaptureService.serviceStarted     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L34 java.lang.Throwable -> L47
            boolean r3 = r3.get()     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L34 java.lang.Throwable -> L47
            if (r3 == 0) goto L45
            android.content.Context r3 = r2.mContext     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L34 java.lang.Throwable -> L47
            r4 = 3
            android.content.Intent r4 = com.ss.bytertc.base.media.screen.RXScreenCaptureService.getServiceIntent(r3, r4, r0)     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L34 java.lang.Throwable -> L47
            r3.startForegroundService(r4)     // Catch: android.app.ForegroundServiceStartNotAllowedException -> L34 java.lang.Throwable -> L47
            goto L45
        L34:
            com.ss.bytertc.base.media.CapturerObserver r3 = r2.capturerObserver     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L45
            java.lang.String r4 = "Start foreground service failed."
            r3.onCapturerError(r4)     // Catch: java.lang.Throwable -> L47
            goto L45
        L3e:
            com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager r0 = com.ss.bytertc.base.media.screen.ScreenCaptureAndroidManager.INSTANCE()     // Catch: java.lang.Throwable -> L47
            r0.changeCaptureFormat(r3, r4, r5)     // Catch: java.lang.Throwable -> L47
        L45:
            monitor-exit(r2)
            return
        L47:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.bytertc.base.media.screen.ScreenCapturerAndroid.changeCaptureFormat(int, int, int):void");
    }

    public synchronized void initialize(EglBase.Context r100, Context r101, CapturerObserver r102) {
        monitor-enter(this);
        this.mContext = r101;     // Catch: Throwable -> L6
        this.capturerObserver = r102;     // Catch: Throwable -> L6
        ScreenCaptureAndroidManager.INSTANCE().initialize(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(int r100, int r101, int r102) {
        monitor-enter(this);
        startCapture(r100, r101, r102, 4);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper r100, Context r101, CapturerObserver r102) {
        monitor-enter(this);
        this.mContext = r101;     // Catch: Throwable -> L6
        this.capturerObserver = r102;     // Catch: Throwable -> L6
        ScreenCaptureAndroidManager.INSTANCE().initialize(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(int r100, int r101, int r102, int r103) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.needStartService == true) goto L6;
    L33:
        ScreenCaptureAndroidManager.INSTANCE().startCapture(r100, r101, r102, r103);     // Catch: Throwable -> L36
    L34:
        monitor-exit(this);
        return;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L33;
        Intent r104 = new Intent();     // Catch: Throwable -> L36
        r104.putExtra("w", r100);     // Catch: Throwable -> L36
        r104.putExtra("h", r101);     // Catch: Throwable -> L36
        r104.putExtra("if", r102);     // Catch: Throwable -> L36
        if (r103 > 0) goto L12;
        r103 = 4;
    L12:
        r104.putExtra(RXScreenCaptureService.KEY_MIN_FRAMERATE, r103);     // Catch: Throwable -> L36
        int r105 = 20;
    L42:
    L30:
        CapturerObserver r106 = this.capturerObserver;     // Catch: Throwable -> L36
        if (r106 == null) goto L34;
        r106.onCapturerError("Start foreground service failed.");     // Catch: Throwable -> L36
        goto L34
    L15:
        if (RXScreenCaptureService.serviceStarted.get() == true) goto L26;
        int r107 = r105 - 1;
        if (r105 <= 0) goto L24;
        Thread.sleep(50);     // Catch: InterruptedException -> L21 ForegroundServiceStartNotAllowedException -> L30 Throwable -> L36
    L23:
        r105 = r107;
    L21:
        e = move-exception;
        RXLogging.w(TAG, "[ScreenCapture] sleep exception");     // Catch: ForegroundServiceStartNotAllowedException -> L30 Throwable -> L36
        e.printStackTrace();     // Catch: ForegroundServiceStartNotAllowedException -> L30 Throwable -> L36
        goto L23
    L24:
        r105 = r107;
    L26:
        if (r105 <= 0) goto L28;
        RXLogging.w(TAG, String.format("[ScreenCapture]  call RXScreenCaptureService.COMMAND_START success, wait times:%d ms", new Object[]{Integer.valueOf((3 - r105) * 50)}));     // Catch: ForegroundServiceStartNotAllowedException -> L30 Throwable -> L36
        Context r108 = this.mContext;     // Catch: ForegroundServiceStartNotAllowedException -> L30 Throwable -> L36
        r108.startForegroundService(RXScreenCaptureService.getServiceIntent(r108, 1, r104));     // Catch: ForegroundServiceStartNotAllowedException -> L30 Throwable -> L36
        goto L34
    L28:
        RXLogging.w(TAG, String.format("[ScreenCapture] wait start service timeout", new Object[0]));     // Catch: ForegroundServiceStartNotAllowedException -> L30 Throwable -> L36
        goto L34
    }
}
