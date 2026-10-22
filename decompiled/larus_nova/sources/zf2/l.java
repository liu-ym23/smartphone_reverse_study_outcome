package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioReportMode;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571729a = null;

    static {
        int[] r100 = new int[LiveWrappedAudioReportMode.values().length];
        f571729a = r100;
        r100[LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_NORMAL.ordinal()] = 1;
        r100[LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_DISCONNECT.ordinal()] = 2;
        r100[LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_RESET.ordinal()] = 3;
    }
}
