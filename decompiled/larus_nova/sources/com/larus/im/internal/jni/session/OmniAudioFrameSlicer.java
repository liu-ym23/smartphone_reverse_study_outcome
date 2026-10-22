package com.larus.im.internal.jni.session;

import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.jni.media.OmniAudioKtxKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/jni/session/OmniAudioFrameSlicer;", "", "capturePerCallMs", "", "sampleRate", "channel", "<init>", "(III)V", "frameBuffer", "", "bufferedSize", "sliceData", "", "data", "targetFrameSize", "ensureCapacity", "", "frameSize", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAudioFrameSlicer {
    public static final Companion Companion = null;
    private static final String TAG = "OmniAudioFrameSlicer";
    private int bufferedSize;
    private final int capturePerCallMs;
    private final int channel;
    private byte[] frameBuffer;
    private final int sampleRate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/jni/session/OmniAudioFrameSlicer$Companion;", "", "<init>", "()V", "TAG", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    private final int targetFrameSize() {
        return OmniAudioKtxKt.audioSizePerMs$default(this.sampleRate, this.channel, 0, 4, null) * this.capturePerCallMs;
    }

    private final void ensureCapacity(int r100) {
        byte[] r101 = this.frameBuffer;
        if (r101.length != r100) goto L5;
        return;
    L5:
        this.frameBuffer = new byte[r100];
        int r102 = Math.min(this.bufferedSize, r100);
        ArraysKt.copyInto$default(r101, this.frameBuffer, 0, 0, r102, 6, null);
        this.bufferedSize = r102;
    }

    public final List<byte[]> sliceData(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = targetFrameSize();
        boolean r102 = true;
        if (r101 <= 0) goto L19;
        if (r100.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L19;
        ensureCapacity(r101);
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L12:
        if (r105 >= r100.length) goto L17;
        int r106 = Math.min(r101 - this.bufferedSize, r100.length - r105);
        int r107 = r105 + r106;
        ArraysKt.copyInto(r100, this.frameBuffer, this.bufferedSize, r105, r107);
        int r108 = this.bufferedSize + r106;
        this.bufferedSize = r108;
        if (r108 != r101) goto L16;
        r104.add(Arrays.copyOf(this.frameBuffer, r101));
        this.bufferedSize = 0;
    L16:
        r105 = r107;
        goto L12
    L17:
        return r104;
    L7:
        r103 = false;
    L19:
        if (r100.length == 0) goto L22;
        r102 = false;
    L22:
        if (r102 == false) goto L25;
        return CollectionsKt.emptyList();
    L25:
        return CollectionsKt.listOf(r100);
    }

    public OmniAudioFrameSlicer(int r100, int r101, int r102) {
        this.capturePerCallMs = r100;
        this.sampleRate = r101;
        this.channel = r102;
        this.frameBuffer = new byte[0];
        c0.f348199b.i(TAG, "init called, perCallMs: " + r100 + ", sampleRate: " + r101 + ", channel: " + r102);
    }

    public /* synthetic */ OmniAudioFrameSlicer(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r100 = 20;
    L5:
        this(r100, r101, r102);
    }
}
