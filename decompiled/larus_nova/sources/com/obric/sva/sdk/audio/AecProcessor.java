package com.obric.sva.sdk.audio;

import android.os.SystemClock;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J \u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/sva/sdk/audio/AecProcessor;", "", "<init>", "()V", "TAG", "", "AEC_MAX_SRC_CHUNK_BYTES", "", "processBacktraceAecIfNeeded", "Lcom/obric/sva/sdk/audio/AecProcessor$ProcessedBuffer;", "aecModel", "Lcom/obric/sva/sdk/audio/AecModel;", "buffer", "", "curBytesRead", "bufferReadResult", "processAecWithChunking", "src", TemplateNodeType.REF, "ProcessedBuffer", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AecProcessor {
    private static final int AEC_MAX_SRC_CHUNK_BYTES = 6400;
    public static final AecProcessor INSTANCE = null;
    private static final String TAG = "AecProcessor";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/audio/AecProcessor$ProcessedBuffer;", "", "buffer", "", "startPos", "", "size", "<init>", "([BII)V", "getBuffer", "()[B", "getStartPos", "()I", "getSize", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProcessedBuffer {
        private final byte[] buffer;
        private final int size;
        private final int startPos;

        public final byte[] getBuffer() {
            return this.buffer;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getStartPos() {
            return this.startPos;
        }

        public ProcessedBuffer(byte[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "buffer");
            this.buffer = r100;
            this.startPos = r101;
            this.size = r102;
        }
    }

    static {
        INSTANCE = new AecProcessor();
    }

    private AecProcessor() {
    }

    private final byte[] processAecWithChunking(AecModel r110, byte[] r111, byte[] r112) {
        r110.reset();
        int r100 = Math.min(r111.length, r112.length);
        int r101 = r100 - (r100 % 2);
        if (r101 > 0) goto L6;
        return r111;
    L6:
        if (r101 > 6400) goto L12;
        SAMICoreVoiceAssistantAudioData r102 = new SAMICoreVoiceAssistantAudioData();
        r102.data = r111;
        r102.refData = r112;
        byte[] r113 = r110.processAndGet(r102);
        if (r113 != null) goto L11;
        return r111;
    L11:
        return r113;
    L12:
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(r101);
        int r104 = 0;
    L13:
        if (r104 >= r101) goto L29;
        int r105 = Math.min(6400, r101 - r104);
        int r106 = r105 - (r105 % 2);
        if (r106 <= 0) goto L29;
        byte[] r107 = new byte[r106];
        byte[] r108 = new byte[r106];
        System.arraycopy(r111, r104, r107, 0, r106);
        System.arraycopy(r112, r104, r108, 0, r106);
        SAMICoreVoiceAssistantAudioData r109 = new SAMICoreVoiceAssistantAudioData();
        r109.data = r107;
        r109.refData = r108;
        byte[] r114 = r110.processAndGet(r109);
        if (r114 != null) goto L20;
    L26:
        r103.write(r107, 0, r106);
    L27:
        r104 = r104 + r106;
        goto L13
    L20:
        if (r114.length != 0) goto L22;
        boolean r115 = true;
    L24:
        if ((!r115) == false) goto L26;
        r103.write(r114, 0, r114.length);
        goto L27
    L22:
        r115 = false;
    L29:
        return r103.toByteArray();
    }

    private static final ProcessedBuffer processBacktraceAecIfNeeded$finish(long r100, Ref.LongRef r101, ProcessedBuffer r102) {
        LogUtils.i(TAG, "AEC cost=" + (SystemClock.elapsedRealtime() - r100) + "ms audioLen=" + r101.element + "ms", new Object[0]);
        return r102;
    }

    @JvmStatic
    public static final ProcessedBuffer processBacktraceAecIfNeeded(AecModel r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "aecModel");
        Intrinsics.checkNotNullParameter(r101, "buffer");
        return new ProcessedBuffer(r101, r102, r103);
    }
}
