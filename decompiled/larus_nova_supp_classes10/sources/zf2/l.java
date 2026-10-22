package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioReportMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedAudioReportMode.values().length];
        a = r0;
        r0[LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_NORMAL.ordinal()] = 1;
        r0[LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_DISCONNECT.ordinal()] = 2;
        r0[LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_RESET.ordinal()] = 3;
    }
}
