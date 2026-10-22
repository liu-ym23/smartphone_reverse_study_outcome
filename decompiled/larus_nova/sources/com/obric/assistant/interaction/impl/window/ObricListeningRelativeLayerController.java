package com.obric.assistant.interaction.impl.window;

import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.surface.ObricRootSurfaceEvent;
import com.obric.assistant.voice.IObricVoiceService;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002CDB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020 J\u0010\u0010%\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u001cH\u0016J\"\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020 H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u000eH\u0016J(\u00102\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020'H\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00105\u001a\u00020\u0016H\u0002J\u0010\u00108\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002J\u0012\u00109\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010:\u001a\u0004\u0018\u00010\u0016*\u00020\u0014H\u0002J\b\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020 H\u0002J\u0012\u0010>\u001a\u00020 2\b\b\u0002\u0010?\u001a\u00020'H\u0002J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020'H\u0002J\b\u0010B\u001a\u00020 H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricListeningRelativeLayerController;", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceListener;", "Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceListener;", "<init>", "()V", "voiceService", "Lcom/obric/assistant/voice/IObricVoiceService;", "decorView", "Landroid/view/View;", "rootObservation", "Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceObservation;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "source", "", "mainWindowType", "", "mainRoot", "Landroid/view/SurfaceControl;", "snapshot", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceSnapshot;", "linkedKey", "Lcom/obric/assistant/interaction/impl/window/ObricListeningRelativeLayerController$SurfaceKey;", "linkedChildRoot", "linkedMainRoot", "lastBlockedKey", "pendingRemovalKey", "pendingRemovalCompletion", "Ljava/lang/Runnable;", "mainHandler", "Landroid/os/Handler;", "prepareForShow", "", "view", "windowType", "showSource", BasicTestActionHandler.TEST_ACTION_RESET, "onChildListeningSurfaceChanged", "prepareForChildListeningSurfaceRemoval", "", "onReadyToRemove", "onRootSurfaceAvailable", "surface", "event", "Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceEvent;", "transaction", "Landroid/view/SurfaceControl$Transaction;", "onRootSurfaceDestroyed", "onRootSurfaceUnavailable", "reason", "appendRelativeLayer", "currentMainRoot", "childRoot", "key", "queueRelativeLayerOnDrawIfReady", "acknowledgeLinked", "installPreDrawBarrier", "isCompatibleCurrentSurface", "surfaceKey", "mainExecutor", "Ljava/util/concurrent/Executor;", "finishPendingRemoval", "clearLinkedRelativeLayer", "preferOnDraw", "resetDialog", "completePendingRemoval", "releaseChildLink", "SurfaceKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningRelativeLayerController implements aba.a, hba.f {
    private static final Companion Companion = null;
    public static final String TAG = "SVA-ObricListeningDebug";
    private View decorView;
    private SurfaceKey lastBlockedKey;
    private SurfaceControl linkedChildRoot;
    private SurfaceKey linkedKey;
    private SurfaceControl linkedMainRoot;
    private final Handler mainHandler;
    private SurfaceControl mainRoot;
    private int mainWindowType;
    private Runnable pendingRemovalCompletion;
    private SurfaceKey pendingRemovalKey;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private hba.g rootObservation;
    private aba.b snapshot;
    private String source;
    private IObricVoiceService voiceService;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricListeningRelativeLayerController$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricListeningRelativeLayerController$SurfaceKey;", "", "generation", "", "<init>", "(I)V", "getGeneration", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SurfaceKey {
        private final int generation;

        public static /* synthetic */ SurfaceKey copy$default(SurfaceKey r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.generation;
        L6:
            return r100.copy(r101);
        }

        public final int component1() {
            return this.generation;
        }

        public final SurfaceKey copy(int r100) {
            return new SurfaceKey(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SurfaceKey) == true) goto L9;
            return false;
        L9:
            if (this.generation == ((SurfaceKey) r100).generation) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.generation;
        }

        public String toString() {
            return "SurfaceKey(generation=" + this.generation + ')';
        }

        public final int getGeneration() {
            return this.generation;
        }

        public SurfaceKey(int r100) {
            this.generation = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ObricListeningRelativeLayerController r100, Runnable r101) {
        mainExecutor$lambda$10(r100, r101);
    }

    public static /* synthetic */ boolean b(ObricListeningRelativeLayerController r100) {
        return installPreDrawBarrier$lambda$9(r100);
    }

    public static /* synthetic */ void c(ObricListeningRelativeLayerController r100, SurfaceKey r101) {
        prepareForChildListeningSurfaceRemoval$lambda$2(r100, r101);
    }

    public static /* synthetic */ void d(Runnable r100, Runnable r101) {
        prepareForChildListeningSurfaceRemoval$lambda$1(r100, r101);
    }

    public static /* synthetic */ void e(ObricListeningRelativeLayerController r100, SurfaceKey r101) {
        appendRelativeLayer$lambda$4$lambda$3(r100, r101);
    }

    public static /* synthetic */ void f(ObricListeningRelativeLayerController r100, SurfaceKey r101) {
        queueRelativeLayerOnDrawIfReady$lambda$6(r100, r101);
    }

    @Override // hba.f
    public void onRootSurfaceDestroyed() {
        clearLinkedRelativeLayer(false);
        releaseChildLink();
        this.mainRoot = null;
        this.linkedKey = null;
        this.lastBlockedKey = null;
        finishPendingRemoval();
    }

    public final void reset() {
        resetDialog(true);
        IObricVoiceService r100 = this.voiceService;
        if (r100 == null) goto L5;
        r100.k(this);
    L5:
        this.voiceService = null;
        this.snapshot = aba.b.f2514f;
    }

    private final void finishPendingRemoval() {
        Runnable r100 = this.pendingRemovalCompletion;
        this.pendingRemovalKey = null;
        this.pendingRemovalCompletion = null;
        if (r100 == null) goto L6;
        r100.run();
        return;
    }

    private final Executor mainExecutor() {
        return new s(this);
    }

    private final boolean queueRelativeLayerOnDrawIfReady() {
        View r100 = this.decorView;
        if (r100 != null) goto L5;
        return false;
    L5:
        SurfaceControl r101 = this.mainRoot;
        if (r101 != null) goto L8;
        return false;
    L8:
        aba.b r102 = this.snapshot;
        SurfaceControl r103 = r102.f2519e;
        if (r103 != null) goto L11;
        return false;
    L11:
        final SurfaceKey r104 = surfaceKey(r102);
        if (r104 != null) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.linkedKey, r104) == false) goto L19;
        return true;
    L19:
        if (isCompatibleCurrentSurface(r103) == true) goto L21;
        return false;
    L21:
        SurfaceControl.Transaction r105 = new SurfaceControl.Transaction();
        hba.e.f484506a.getClass();     // Catch: Throwable -> L30 RuntimeException -> L32
        if (hba.e.b(r105, r103, r101) == true) goto L26;
        r105.close();
        return false;
    L26:
        r105.addTransactionCommittedListener(mainExecutor(), new t(this, r104));     // Catch: Throwable -> L30 RuntimeException -> L32
        boolean r106 = hba.e.d(r100, r105);     // Catch: Throwable -> L30 RuntimeException -> L32
        if (r106 == false) goto L29;
        this.linkedKey = r104;     // Catch: Throwable -> L30 RuntimeException -> L32
        this.linkedChildRoot = r103;     // Catch: Throwable -> L30 RuntimeException -> L32
        this.linkedMainRoot = r101;     // Catch: Throwable -> L30 RuntimeException -> L32
        this.lastBlockedKey = null;     // Catch: Throwable -> L30 RuntimeException -> L32
        FLogger.f375446a.i(TAG, "link_queued: side=main stage=surface path=on_draw generation=" + r104.getGeneration() + " source=" + this.source);     // Catch: Throwable -> L30 RuntimeException -> L32
    L29:
        r105.close();
        return r106;
    L32:
        e = move-exception;
        FLogger.f375446a.w(TAG, "link_failed: side=main stage=surface path=on_draw error=".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L30
        r105.close();
        return false;
    L30:
        th = move-exception;
        r105.close();
        throw th;
    }

    private final void releaseChildLink() {
        SurfaceKey r100 = surfaceKey(this.snapshot);
        if (r100 != null) goto L5;
        return;
    L5:
        IObricVoiceService r101 = this.voiceService;
        if (r101 == null) goto L9;
        r101.o(r100.getGeneration());
        return;
    }

    public ObricListeningRelativeLayerController() {
        this.source = "unknown";
        this.snapshot = aba.b.f2514f;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private final void acknowledgeLinked(SurfaceKey r100) {
        if (Intrinsics.areEqual(this.linkedKey, r100) == true) goto L5;
    L13:
        FLogger.f375446a.i(TAG, "link_commit_drop: side=main stage=surface generation=" + r100.getGeneration() + " current=" + surfaceKey(this.snapshot) + " source=" + this.source);
        return;
    L5:
        if (Intrinsics.areEqual(surfaceKey(this.snapshot), r100) == false) goto L13;
        if (this.mainRoot == null) goto L13;
        FLogger.f375446a.i(TAG, "link_committed: side=main stage=surface generation=" + r100.getGeneration() + " current=" + surfaceKey(this.snapshot) + " source=" + this.source);
        IObricVoiceService r101 = this.voiceService;
        if (r101 == null) goto L15;
        r101.c(r100.getGeneration());
        return;
    }

    private final void clearLinkedRelativeLayer(boolean r100) {
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
            java.lang.String r0 = "clear_failed: side=main stage=surface error="
            android.view.SurfaceControl r1 = r5.linkedMainRoot
            if (r1 != 0) goto L7
            return
        L7:
            hba.e r2 = hba.e.f484506a
            r2.getClass()
            boolean r2 = hba.e.e(r1)
            r3 = 0
            if (r2 != 0) goto L1a
            r5.linkedMainRoot = r3
            r5.linkedChildRoot = r3
            r5.linkedKey = r3
            return
        L1a:
            android.view.SurfaceControl$Transaction r2 = new android.view.SurfaceControl$Transaction
            r2.<init>()
            boolean r1 = hba.e.c(r2, r1)     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            if (r1 != 0) goto L29
            r2.close()
            return
        L29:
            r1 = 0
            if (r6 == 0) goto L41
            android.view.View r6 = r5.decorView     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            r4 = 1
            if (r6 == 0) goto L3d
            boolean r6 = hba.e.d(r6, r2)     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            if (r6 != r4) goto L3d
            r6 = 1
            goto L3e
        L39:
            r6 = move-exception
            goto L76
        L3b:
            r6 = move-exception
            goto L4d
        L3d:
            r6 = 0
        L3e:
            if (r6 == 0) goto L41
            r1 = 1
        L41:
            if (r1 != 0) goto L46
            r2.apply()     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
        L46:
            r5.linkedMainRoot = r3     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            r5.linkedChildRoot = r3     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            r5.linkedKey = r3     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            goto L72
        L4d:
            com.larus.utils.logger.FLogger r1 = com.larus.utils.logger.FLogger.f375446a     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "SVA-ObricListeningDebug"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.Class r6 = r6.getClass()     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r6.getSimpleName()     // Catch: java.lang.Throwable -> L39
            r4.append(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = " source="
            r4.append(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r5.source     // Catch: java.lang.Throwable -> L39
            r4.append(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L39
            r1.w(r3, r6)     // Catch: java.lang.Throwable -> L39
        L72:
            r2.close()
            return
        L76:
            r2.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.assistant.interaction.impl.window.ObricListeningRelativeLayerController.clearLinkedRelativeLayer(boolean):void");
    }

    private final void installPreDrawBarrier(View r100) {
        ViewTreeObserver.OnPreDrawListener r101 = this.preDrawListener;
        if (r101 == null) goto L10;
        ViewTreeObserver r102 = r100.getViewTreeObserver();
        if (r102.isAlive() == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r102.removeOnPreDrawListener(r101);
    L10:
        ViewTreeObserver.OnPreDrawListener r103 = new u(this);
        this.preDrawListener = r103;
        r100.getViewTreeObserver().addOnPreDrawListener(r103);
    }

    private static final boolean installPreDrawBarrier$lambda$9(ObricListeningRelativeLayerController r100) {
        SurfaceKey r101 = r100.surfaceKey(r100.snapshot);
        aba.b r102 = r100.snapshot;
        boolean r103 = r102.f2518d;
        int r104 = r102.f2515a;
        SurfaceKey r105 = r100.linkedKey;
        if (r105 == null) goto L5;
        Integer r106 = Integer.valueOf(r105.getGeneration());
    L6:
        boolean r107 = ObricListeningRelativeLayerControllerKt.shouldAllowListeningMainDraw(r103, r104, r106);
        if (r107 == false) goto L9;
    L15:
        if (r107 == true) goto L17;
    L19:
        return r107;
    L17:
        if (r100.lastBlockedKey == null) goto L19;
        FLogger.f375446a.i(TAG, "barrier_release: side=main stage=surface generation=" + r100.snapshot.f2515a + " source=" + r100.source);
        r100.lastBlockedKey = null;
        goto L19
    L9:
        if (Intrinsics.areEqual(r100.lastBlockedKey, r101) == true) goto L15;
        r100.lastBlockedKey = r101;
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("barrier_block: side=main stage=surface generation=");
        r109.append(r100.snapshot.f2515a);
        r109.append(" hasChild=");
        if (r100.snapshot.f2519e == null) goto L13;
        boolean r110 = true;
    L14:
        r109.append(r110);
        r109.append(" source=");
        r109.append(r100.source);
        r108.i(TAG, r109.toString());
        goto L19
    L13:
        r110 = false;
        goto L14
    L5:
        r106 = null;
        goto L6
    }

    private final boolean isCompatibleCurrentSurface(SurfaceControl r100) {
        View r101 = this.decorView;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (this.snapshot.f2518d == false) goto L20;
        hba.e.f484506a.getClass();
        if (hba.e.e(r100) == false) goto L23;
        Display r102 = r101.getDisplay();
        if (r102 == null) goto L13;
        int r103 = r102.getDisplayId();
    L14:
        aba.b r104 = this.snapshot;
        if (r104.f2516b == r103) goto L17;
        return false;
    L17:
        if (r104.f2517c != this.mainWindowType) goto L22;
        return true;
    L22:
        return false;
    L13:
        r103 = 0;
        goto L14
    L23:
        return false;
    L20:
        return false;
    }

    private final void resetDialog(boolean r100) {
        if (r100 == false) goto L4;
        finishPendingRemoval();
    L4:
        clearLinkedRelativeLayer(false);
        releaseChildLink();
        hba.g r101 = this.rootObservation;
        if (r101 == null) goto L7;
        r101.close();
    L7:
        this.rootObservation = null;
        ViewTreeObserver.OnPreDrawListener r102 = this.preDrawListener;
        if (r102 == null) goto L19;
        View r103 = this.decorView;
        if (r103 == null) goto L19;
        ViewTreeObserver r104 = r103.getViewTreeObserver();
        if (r104 == null) goto L19;
        if (r104.isAlive() == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L19;
        r104.removeOnPreDrawListener(r102);
    L19:
        this.preDrawListener = null;
        this.decorView = null;
        this.mainRoot = null;
        this.linkedKey = null;
        this.linkedChildRoot = null;
        this.linkedMainRoot = null;
        this.lastBlockedKey = null;
    }

    private final SurfaceKey surfaceKey(aba.b r100) {
        int r101 = r100.f2515a;
        if (r101 >= 0) goto L7;
        return null;
    L7:
        return new SurfaceKey(r101);
    }

    @Override // aba.a
    public void onChildListeningSurfaceChanged(aba.b r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L23;
        SurfaceKey r101 = surfaceKey(this.snapshot);
        this.snapshot = r100;
        SurfaceKey r102 = surfaceKey(r100);
        SurfaceKey r103 = this.linkedKey;
        if (r103 == null) goto L10;
        if (Intrinsics.areEqual(r103, r102) == true) goto L10;
        this.linkedKey = null;
    L10:
        if (Intrinsics.areEqual(r101, r102) == true) goto L13;
        this.lastBlockedKey = null;
    L13:
        if (r100.f2518d == true) goto L18;
        clearLinkedRelativeLayer$default(this, false, 1, null);
        finishPendingRemoval();
        View r104 = this.decorView;
        if (r104 == null) goto L24;
        r104.invalidate();
        return;
    L24:
        return;
    L18:
        queueRelativeLayerOnDrawIfReady();
        View r105 = this.decorView;
        if (r105 == null) goto L25;
        r105.invalidate();
        return;
    L25:
        return;
    L23:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // hba.f
    public void onRootSurfaceUnavailable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        clearLinkedRelativeLayer(false);
        this.mainRoot = null;
        this.linkedKey = null;
        FLogger.f375446a.w(TAG, "observe_unavailable: side=main stage=surface reason=" + r100 + " source=" + this.source);
        View r101 = this.decorView;
        if (r101 == null) goto L6;
        r101.invalidate();
        return;
    }

    private static final void appendRelativeLayer$lambda$4$lambda$3(ObricListeningRelativeLayerController r100, SurfaceKey r101) {
        r100.acknowledgeLinked(r101);
    }

    private static final void mainExecutor$lambda$10(ObricListeningRelativeLayerController r100, Runnable r101) {
        View r102 = r100.decorView;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r101.run();
        return;
    L5:
        if (r102 != null) goto L7;
    L9:
        r100.mainHandler.post(r101);
        return;
    L7:
        if (r102.isAttachedToWindow() == false) goto L9;
        r102.post(r101);
    }

    private static final void prepareForChildListeningSurfaceRemoval$lambda$1(Runnable r100, Runnable r101) {
        if (r100 == null) goto L4;
        r100.run();
    L4:
        r101.run();
    }

    private static final void prepareForChildListeningSurfaceRemoval$lambda$2(ObricListeningRelativeLayerController r100, SurfaceKey r101) {
        if (Intrinsics.areEqual(r100.pendingRemovalKey, r101) == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i(TAG, "unlink_committed: side=main stage=surface generation=" + r101.getGeneration() + " source=" + r100.source);
        r100.linkedKey = null;
        r100.linkedChildRoot = null;
        r100.linkedMainRoot = null;
        r100.finishPendingRemoval();
    }

    private static final void queueRelativeLayerOnDrawIfReady$lambda$6(ObricListeningRelativeLayerController r100, SurfaceKey r101) {
        r100.acknowledgeLinked(r101);
    }

    @Override // aba.a
    public boolean prepareForChildListeningSurfaceRemoval(aba.b r110, final Runnable r111) {
        Intrinsics.checkNotNullParameter(r110, "snapshot");
        Intrinsics.checkNotNullParameter(r111, "onReadyToRemove");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L63;
        final SurfaceKey r112 = surfaceKey(r110);
        if (r112 != null) goto L7;
        return false;
    L7:
        View r100 = this.decorView;
        if (r100 != null) goto L10;
        return false;
    L10:
        SurfaceControl r101 = this.mainRoot;
        if (r101 != null) goto L13;
        return false;
    L13:
        SurfaceControl r102 = this.linkedChildRoot;
        if (r102 != null) goto L16;
        return false;
    L16:
        SurfaceControl r103 = this.linkedMainRoot;
        if (r103 != null) goto L19;
        return false;
    L19:
        int r104 = this.snapshot.f2515a;
        SurfaceKey r105 = this.linkedKey;
        if (r105 == null) goto L22;
        Integer r106 = Integer.valueOf(r105.getGeneration());
    L24:
        if (ObricListeningRelativeLayerControllerKt.isExactLinkedSurface(r104, r106, r112.getGeneration()) == false) goto L61;
        if (r101 != r103) goto L61;
        hba.e.f484506a.getClass();
        if (hba.e.e(r101) == false) goto L61;
        if (hba.e.e(r102) == false) goto L61;
        if (hba.e.e(r103) == false) goto L61;
        SurfaceKey r107 = this.pendingRemovalKey;
        if (r107 != null) goto L36;
        SurfaceControl.Transaction r108 = new SurfaceControl.Transaction();
        this.pendingRemovalKey = r112;     // Catch: Throwable -> L53 RuntimeException -> L55
        this.pendingRemovalCompletion = r111;     // Catch: Throwable -> L53 RuntimeException -> L55
        r108.setAlpha(r102, 0.0f);     // Catch: Throwable -> L53 RuntimeException -> L55
        if (hba.e.c(r108, r103) == true) goto L46;
        this.pendingRemovalKey = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        this.pendingRemovalCompletion = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        r108.close();
        return false;
    L46:
        r108.addTransactionCommittedListener(mainExecutor(), new w(this, r112));     // Catch: Throwable -> L53 RuntimeException -> L55
        if (hba.e.d(r100, r108) == true) goto L51;
        this.pendingRemovalKey = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        this.pendingRemovalCompletion = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        r108.close();
        return false;
    L51:
        r100.invalidate();     // Catch: Throwable -> L53 RuntimeException -> L55
        FLogger.f375446a.i(TAG, "unlink_queued: side=main stage=surface path=on_draw generation=" + r112.getGeneration() + " source=" + this.source);     // Catch: Throwable -> L53 RuntimeException -> L55
        r108.close();
        return true;
    L53:
        th = move-exception;
        r108.close();
        throw th;
    L55:
        e = move-exception;
        this.pendingRemovalKey = null;     // Catch: Throwable -> L53
        this.pendingRemovalCompletion = null;     // Catch: Throwable -> L53
        FLogger.f375446a.w(TAG, "unlink_failed: side=main stage=surface generation=" + r112.getGeneration() + " error=" + e.getClass().getSimpleName());     // Catch: Throwable -> L53
        r108.close();
        return false;
    L36:
        if (Intrinsics.areEqual(r107, r112) == true) goto L38;
        return false;
    L38:
        final Runnable r113 = this.pendingRemovalCompletion;
        this.pendingRemovalCompletion = new v(r113, r111);
        return true;
    L61:
        return false;
    L22:
        r106 = null;
        goto L24
    L63:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // hba.f
    public void onRootSurfaceAvailable(SurfaceControl r100, ObricRootSurfaceEvent r101, SurfaceControl.Transaction r102) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L19;
        this.mainRoot = r100;
        this.linkedKey = null;
        aba.b r103 = this.snapshot;
        SurfaceControl r104 = r103.f2519e;
        if (r104 != null) goto L7;
        return;
    L7:
        SurfaceKey r105 = surfaceKey(r103);
        if (r105 != null) goto L11;
        return;
    L11:
        if (isCompatibleCurrentSurface(r104) == true) goto L13;
        return;
    L13:
        if (r102 == null) goto L15;
        boolean r106 = appendRelativeLayer(r102, r100, r104, r105);
    L16:
        FLogger.f375446a.i(TAG, "root: side=main stage=surface source=" + r101 + " relationQueued=" + r106 + " generation=" + r105.getGeneration() + " showSource=" + this.source);
        return;
    L15:
        r106 = queueRelativeLayerOnDrawIfReady();
        goto L16
    L19:
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void prepareForShow(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "showSource");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L20;
        this.source = r102;
        this.mainWindowType = r101;
        if (this.decorView == r100) goto L7;
        resetDialog(true);
        this.decorView = r100;
        hba.e.f484506a.getClass();
        this.rootObservation = hba.e.f(r100, this);
    L7:
        installPreDrawBarrier(r100);
        if (this.voiceService != null) goto L17;
        IObricVoiceService.f394360a.getClass();
        IObricVoiceService r103 = IObricVoiceService.a.a();
        this.voiceService = r103;
        if (r103 == null) goto L13;
        aba.b r104 = r103.p();
        if (r104 == null) goto L13;
    L14:
        this.snapshot = r104;
        IObricVoiceService r105 = this.voiceService;
        if (r105 == null) goto L17;
        r105.l(this);
    L13:
        r104 = aba.b.f2514f;
    L17:
        r100.invalidate();
        return;
    L20:
        throw new IllegalStateException("listening relative-layer must run on main thread".toString());
    }

    private final boolean appendRelativeLayer(SurfaceControl.Transaction r100, SurfaceControl r101, SurfaceControl r102, final SurfaceKey r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        hba.e.f484506a.getClass();     // Catch: Throwable -> L9
        if (hba.e.b(r100, r102, r101) == true) goto L7;
        return false;
    L7:
        r100.addTransactionCommittedListener(mainExecutor(), new x(this, r103));     // Catch: Throwable -> L9
        this.linkedKey = r103;     // Catch: Throwable -> L9
        this.linkedChildRoot = r102;     // Catch: Throwable -> L9
        this.linkedMainRoot = r101;     // Catch: Throwable -> L9
        this.lastBlockedKey = null;     // Catch: Throwable -> L9
        FLogger.f375446a.i(TAG, "link_queued: side=main stage=surface path=callback generation=" + r103.getGeneration() + " source=" + this.source);     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L16;
        FLogger.f375446a.w(TAG, "link_failed: side=main stage=surface path=callback error=".concat(r106.getClass().getSimpleName()));
        r105 = Boolean.FALSE;
    L16:
        return ((Boolean) r105).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static /* synthetic */ void clearLinkedRelativeLayer$default(ObricListeningRelativeLayerController r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = true;
    L5:
        r100.clearLinkedRelativeLayer(r101);
    }
}
