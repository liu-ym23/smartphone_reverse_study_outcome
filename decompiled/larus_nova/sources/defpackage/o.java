package defpackage;

import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;

/* JADX INFO: loaded from: classes42.dex */
public final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f521565a = null;

    static {
        int[] r100 = new int[DownloadState.values().length];
        f521565a = r100;
        r100[DownloadState.SUCCESS.ordinal()] = 1;
        r100[DownloadState.FAILED.ordinal()] = 2;
    }
}
