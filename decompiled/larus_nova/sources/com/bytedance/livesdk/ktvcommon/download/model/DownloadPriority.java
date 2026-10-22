package com.bytedance.livesdk.ktvcommon.download.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/download/model/DownloadPriority;", "", "LOW", EffectConstants.NORMAL, "HIGH", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DownloadPriority extends Enum<DownloadPriority> {
    public static final DownloadPriority HIGH = null;
    public static final DownloadPriority LOW = null;
    public static final DownloadPriority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadPriority[] f255938a = null;

    static {
        DownloadPriority r100 = new DownloadPriority("LOW", 0);
        LOW = r100;
        DownloadPriority r101 = new DownloadPriority(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        DownloadPriority r102 = new DownloadPriority("HIGH", 2);
        HIGH = r102;
        f255938a = new DownloadPriority[]{r100, r101, r102};
    }

    public static DownloadPriority valueOf(String r100) {
        return (DownloadPriority) r27.a.a(DownloadPriority.class, r100);
    }

    public static DownloadPriority[] values() {
        return (DownloadPriority[]) f255938a.clone();
    }

    public DownloadPriority(String r100, int r101) {
        super(r100, r101);
    }
}
