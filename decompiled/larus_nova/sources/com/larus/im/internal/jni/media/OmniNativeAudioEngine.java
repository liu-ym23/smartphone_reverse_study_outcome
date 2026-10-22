package com.larus.im.internal.jni.media;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0082\b¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00182\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0082\bJ\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bj\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniNativeAudioEngine;", "Lcom/larus/im/internal/jni/media/OmniAudioEngineProtocol;", "nativeAudioPlayer", "Lcom/larus/im/internal/jni/media/OmniAudioPlayerProtocol;", "nativeAudioRecorder", "Lcom/larus/im/internal/jni/media/OmniAudioRecorderProtocol;", "<init>", "(Lcom/larus/im/internal/jni/media/OmniAudioPlayerProtocol;Lcom/larus/im/internal/jni/media/OmniAudioRecorderProtocol;)V", "destroyed", "", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "listeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/im/internal/jni/media/OmniAudioEngineDelegate;", "Lkotlin/collections/LinkedHashSet;", "withActive", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", "action", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runIfActive", "", "destroyEngine", "addListener", "delegate", "removeListener", "getPlayAmplitude", "", "startPlayer", "stopPlayer", "pausePlayer", "resumePlayer", "mutePlayer", "enable", "duck", ITTVideoEngineEventSource.KEY_VOLUME, "playFrame", "frame", "Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "clearPlayerBuffer", "getRecordAmplitude", "startRecorder", "stopRecorder", "setBluetoothForceToMedia", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniNativeAudioEngine implements OmniAudioEngineProtocol {
    private boolean destroyed;
    private final LinkedHashSet<OmniAudioEngineDelegate> listeners;
    private final Object lock;
    private final OmniAudioPlayerProtocol nativeAudioPlayer;
    private final OmniAudioRecorderProtocol nativeAudioRecorder;

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void clearPlayerBuffer() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == true) goto L15;
        this.nativeAudioPlayer.clearPlayerBuffer();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioEngineProtocol
    public void destroyEngine() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.destroyed == false) goto L7;
        List r101 = CollectionsKt.emptyList();     // Catch: Throwable -> L27
        boolean r102 = false;
    L8:
        monitor-exit(r100);
        if (r102 == true) goto L11;
        return;
    L11:
        Iterator r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        OmniAudioEngineDelegate r104 = (OmniAudioEngineDelegate) r103.next();
        this.nativeAudioPlayer.removeListener(r104);
        this.nativeAudioRecorder.removeListener(r104);
        goto L13
    L15:
        OmniAudioPlayerProtocol r105 = this.nativeAudioPlayer;
        OmniNativeAudioHandle r106 = null;
        if ((r105 instanceof OmniNativeAudioHandle) == false) goto L18;
        OmniNativeAudioHandle r107 = (OmniNativeAudioHandle) r105;
    L19:
        if (r107 == null) goto L21;
        r107.destroyHandle();
    L21:
        OmniAudioRecorderProtocol r108 = this.nativeAudioRecorder;
        if ((r108 instanceof OmniNativeAudioHandle) == false) goto L24;
        r106 = (OmniNativeAudioHandle) r108;
    L24:
        if (r106 == null) goto L32;
        r106.destroyHandle();
        return;
    L32:
        return;
    L18:
        r107 = null;
        goto L19
    L7:
        r102 = true;
        this.destroyed = true;     // Catch: Throwable -> L27
        r101 = CollectionsKt.toList(this.listeners);     // Catch: Throwable -> L27
        this.listeners.clear();     // Catch: Throwable -> L27
        goto L8
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public float getPlayAmplitude() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == false) goto L9;
        return 0.0f;
    L9:
        return this.nativeAudioPlayer.getPlayAmplitude();
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public float getRecordAmplitude() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == false) goto L9;
        return 0.0f;
    L9:
        return this.nativeAudioRecorder.getRecordAmplitude();
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void pausePlayer() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == true) goto L15;
        this.nativeAudioPlayer.pausePlayer();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void resumePlayer() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == true) goto L15;
        this.nativeAudioPlayer.resumePlayer();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void startPlayer() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == true) goto L15;
        this.nativeAudioPlayer.startPlayer();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public void startRecorder() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == true) goto L15;
        this.nativeAudioRecorder.startRecorder();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void stopPlayer() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == true) goto L15;
        this.nativeAudioPlayer.stopPlayer();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public void stopRecorder() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r100);
        if (r101 == true) goto L15;
        this.nativeAudioRecorder.stopRecorder();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void runIfActive(Function0<Unit> r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        boolean r102 = this.destroyed;     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        monitor-exit(r101);
        InlineMarker.finallyEnd(1);
        if (r102 == false) goto L11;
        return;
    L11:
        r100.invoke();
        return;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioEngineProtocol
    public void addListener(OmniAudioEngineDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Object r101 = this.lock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.destroyed == false) goto L7;
        boolean r102 = false;
    L8:
        monitor-exit(r101);
        if (r102 == false) goto L17;
        this.nativeAudioPlayer.addListener(r100);
        this.nativeAudioRecorder.addListener(r100);
        return;
    L17:
        return;
    L7:
        r102 = this.listeners.add(r100);     // Catch: Throwable -> L12
        goto L8
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void duck(float r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        boolean r102 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r101);
        if (r102 == true) goto L15;
        this.nativeAudioPlayer.duck(r100);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void mutePlayer(boolean r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        boolean r102 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r101);
        if (r102 == true) goto L15;
        this.nativeAudioPlayer.mutePlayer(r100);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void playFrame(OmniAudioFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Object r101 = this.lock;
        monitor-enter(r101);
        boolean r102 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r101);
        if (r102 == true) goto L15;
        this.nativeAudioPlayer.playFrame(r100);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioEngineProtocol
    public void removeListener(OmniAudioEngineDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Object r101 = this.lock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.destroyed == false) goto L7;
        boolean r102 = false;
    L8:
        monitor-exit(r101);
        if (r102 == false) goto L17;
        this.nativeAudioPlayer.removeListener(r100);
        this.nativeAudioRecorder.removeListener(r100);
        return;
    L17:
        return;
    L7:
        r102 = this.listeners.remove(r100);     // Catch: Throwable -> L12
        goto L8
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public void setBluetoothForceToMedia(boolean r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        boolean r102 = this.destroyed;     // Catch: Throwable -> L10
        monitor-exit(r101);
        if (r102 == true) goto L15;
        this.nativeAudioRecorder.setBluetoothForceToMedia(r100);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void addListener(OmniAudioPlayerDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.addListener(this, r100);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioPlayerProtocol
    public void removeListener(OmniAudioPlayerDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.removeListener(this, r100);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public void addListener(OmniAudioRecorderDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.addListener(this, r100);
    }

    @Override // com.larus.im.internal.jni.media.OmniAudioRecorderProtocol
    public void removeListener(OmniAudioRecorderDelegate r100) {
        OmniAudioEngineProtocol.DefaultImpls.removeListener(this, r100);
    }

    public OmniNativeAudioEngine(OmniAudioPlayerProtocol r100, OmniAudioRecorderProtocol r101) {
        Intrinsics.checkNotNullParameter(r100, "nativeAudioPlayer");
        Intrinsics.checkNotNullParameter(r101, "nativeAudioRecorder");
        this.nativeAudioPlayer = r100;
        this.nativeAudioRecorder = r101;
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    private final <T> T withActive(T r100, Function0<? extends T> r101) {
        Object r102 = this.lock;
        monitor-enter(r102);
        boolean r103 = this.destroyed;     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        monitor-exit(r102);
        InlineMarker.finallyEnd(1);
        if (r103 == false) goto L12;
        return r100;
    L12:
        return r101.invoke();
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
