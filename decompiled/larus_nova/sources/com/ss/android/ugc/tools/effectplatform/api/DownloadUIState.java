package com.ss.android.ugc.tools.effectplatform.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/tools/effectplatform/api/DownloadUIState;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DOWNLOADED", "NOT_DOWNLOAD", "DOWNLOADING", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum DownloadUIState extends Enum<DownloadUIState> {
    public static final a Companion = null;
    public static final DownloadUIState DOWNLOADED = null;
    public static final DownloadUIState DOWNLOADING = null;
    public static final DownloadUIState NOT_DOWNLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadUIState[] f454820a = null;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.ugc.tools.effectplatform.api.DownloadUIState$a] */
    static {
        DownloadUIState r100 = new DownloadUIState("DOWNLOADED", 0);
        DOWNLOADED = r100;
        DownloadUIState r101 = new DownloadUIState("NOT_DOWNLOAD", 1);
        NOT_DOWNLOAD = r101;
        DownloadUIState r102 = new DownloadUIState("DOWNLOADING", 2);
        DOWNLOADING = r102;
        f454820a = new DownloadUIState[]{r100, r101, r102};
        Companion = new a();
    }

    public static DownloadUIState valueOf(String r100) {
        return (DownloadUIState) r27.a.a(DownloadUIState.class, r100);
    }

    public static DownloadUIState[] values() {
        return (DownloadUIState[]) f454820a.clone();
    }

    public DownloadUIState(String r100, int r101) {
        super(r100, r101);
    }
}
