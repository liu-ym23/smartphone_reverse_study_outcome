package com.obric.sva.sdk.audio;

import com.obric.sva.sdk.utils.LogUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/sva/sdk/audio/AudioUtils;", "", "<init>", "()V", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioUtils {
    public static final Companion Companion = null;
    private static final String TAG = "AudioUtils";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/sva/sdk/audio/AudioUtils$Companion;", "", "<init>", "()V", "TAG", "", "splitMicAndRefAudioTo2Mic2Ref", "", "Lcom/obric/sva/sdk/audio/RecordAudioData;", "audioData", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final List<RecordAudioData> splitMicAndRefAudioTo2Mic2Ref(RecordAudioData r110) {
            Intrinsics.checkNotNullParameter(r110, "audioData");
            byte[] r100 = r110.getData();
            int r111 = r110.getReadSize();
            if (r111 > 0) goto L7;
            LogUtils.e(AudioUtils.TAG, "Original audio data size is invalid: " + r111, new Object[0]);
            return null;
        L7:
            if ((r111 % 8) == 0) goto L10;
            LogUtils.e(AudioUtils.TAG, "Received audio data size (" + r111 + ") is not a multiple of 8, cannot separate channels.", new Object[0]);
            return null;
        L10:
            int r101 = r111 / 4;
            byte[] r102 = new byte[r101];
            byte[] r103 = new byte[r101];
            byte[] r104 = new byte[r101];
            byte[] r105 = new byte[r101];
            IntProgression r112 = RangesKt.step(RangesKt.until(0, r111), 8);
            int r106 = r112.getFirst();
            int r107 = r112.getLast();
            int r113 = r112.getStep();
            if (r113 <= 0) goto L13;
            if (r106 > r107) goto L13;
        L15:
            int r114 = 0;
        L16:
            r102[r114] = r100[r106];
            int r115 = r114 + 1;
            r102[r115] = r100[r106 + 1];
            r103[r114] = r100[r106 + 2];
            r103[r115] = r100[r106 + 3];
            r104[r114] = r100[r106 + 4];
            r104[r115] = r100[r106 + 5];
            r105[r114] = r100[r106 + 6];
            r105[r115] = r100[r106 + 7];
            r114 = r114 + 2;
            if (r106 == r107) goto L20;
            r106 = r106 + r113;
        L20:
            return CollectionsKt.listOf(new RecordAudioData[]{new RecordAudioData(r101, r102), new RecordAudioData(r101, r103), new RecordAudioData(r101, r104), new RecordAudioData(r101, r105)});
        L13:
            if (r113 >= 0) goto L20;
            if (r107 > r106) goto L20;
            goto L15
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AudioUtils() {
    }
}
