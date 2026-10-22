package com.larus.im.internal.jni.media;

import com.larus.im.internal.jni.logger.OmniLinkLogger;
import com.larus.im.internal.jni.session.OmniAudioFrameSlicer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006J)\u0010\u0016\u001a\u00020\n2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005J)\u0010\u0018\u001a\u00020\n2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005J\u001e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAVFrameDataCenter;", "", "<init>", "()V", "onDequeueRecordFrame", "Lkotlin/Function1;", "Lcom/larus/im/internal/jni/media/OmniAudioFrame;", "Lkotlin/ParameterName;", "name", "frame", "", "recordSlicer", "Lcom/larus/im/internal/jni/session/OmniAudioFrameSlicer;", "onDequeuePlayFrame", "value", "", "isRecording", "setRecording", "(Z)V", "dispatchRecordFrame", "setIsRecording", "enqueuePlayFrame", "setOnDequeueRecordFrame", "callback", "setOnDequeuePlayFrame", "setRecordConfig", "sampleRate", "", "channel", "perCallMs", "enqueueRecordFrame", "enqueuePlayedFrame", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAVFrameDataCenter {
    public static final Companion Companion = null;
    private static final String TAG = "OmniAVFrameDataCenter";
    private boolean isRecording;
    private Function1<? super OmniAudioFrame, Unit> onDequeuePlayFrame;
    private Function1<? super OmniAudioFrame, Unit> onDequeueRecordFrame;
    private OmniAudioFrameSlicer recordSlicer;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAVFrameDataCenter$Companion;", "", "<init>", "()V", "TAG", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniAVFrameDataCenter() {
    }

    private final void dispatchRecordFrame(OmniAudioFrame r110) {
        Function1<? super OmniAudioFrame, Unit> r100 = this.onDequeueRecordFrame;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.isRecording == false) goto L8;
        r100.invoke(r110);
        return;
    L8:
        r100.invoke(OmniAudioFrame.copy$default(r110, new byte[r110.getData().length], null, null, 0.0f, 0, null, true, 62, null));
    }

    private final void setRecording(boolean r100) {
        if (this.isRecording == r100) goto L6;
        this.isRecording = r100;
        OmniLinkLogger.INSTANCE.i(TAG, "set isRecording: " + r100);
        return;
    }

    public final void enqueuePlayFrame(OmniAudioFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Function1<? super OmniAudioFrame, Unit> r101 = this.onDequeuePlayFrame;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.invoke(r100);
    }

    public final void enqueuePlayedFrame(OmniAudioFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        OmniLinkLogger.INSTANCE.d(TAG, "Played frame enqueued, size: " + r100.getData().length);
    }

    public final void enqueueRecordFrame(OmniAudioFrame r110) {
        Intrinsics.checkNotNullParameter(r110, "frame");
        OmniAudioFrameSlicer r100 = this.recordSlicer;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.sliceData(r110.getData()).iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        dispatchRecordFrame(OmniAudioFrame.copy$default(r110, (byte[]) r101.next(), null, null, 0.0f, 0, null, false, 126, null));
        goto L6
    L11:
        return;
    L8:
        dispatchRecordFrame(r110);
    }

    public final void setIsRecording(boolean r100) {
        setRecording(r100);
    }

    public final void setOnDequeuePlayFrame(Function1<? super OmniAudioFrame, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.onDequeuePlayFrame = r100;
    }

    public final void setOnDequeueRecordFrame(Function1<? super OmniAudioFrame, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.onDequeueRecordFrame = r100;
    }

    public final void setRecordConfig(int r100, int r101, int r102) {
        this.recordSlicer = new OmniAudioFrameSlicer(r102, r100, r101);
    }
}
