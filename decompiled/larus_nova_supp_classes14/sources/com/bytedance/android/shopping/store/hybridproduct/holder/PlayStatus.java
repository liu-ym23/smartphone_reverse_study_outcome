package com.bytedance.android.shopping.store.hybridproduct.holder;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/PlayStatus;", "", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "PLAY", "STOP", "PAUSE", "READY", "FINISH", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayStatus extends Enum<PlayStatus> {
    public static final PlayStatus FINISH = null;
    public static final PlayStatus PAUSE = null;
    public static final PlayStatus PLAY = null;
    public static final PlayStatus READY = null;
    public static final PlayStatus STOP = null;
    public static final /* synthetic */ PlayStatus[] a = null;
    private final String status;

    static {
        PlayStatus r1 = new PlayStatus("PLAY", 0, "play");
        PLAY = r1;
        PlayStatus r2 = new PlayStatus("STOP", 1, "stop");
        STOP = r2;
        PlayStatus r3 = new PlayStatus("PAUSE", 2, "pause");
        PAUSE = r3;
        PlayStatus r4 = new PlayStatus("READY", 3, "ready");
        READY = r4;
        PlayStatus r5 = new PlayStatus("FINISH", 4, "finish");
        FINISH = r5;
        a = new PlayStatus[]{r1, r2, r3, r4, r5};
    }

    public static PlayStatus valueOf(String r1) {
        return (PlayStatus) r27.a.a(PlayStatus.class, r1);
    }

    public static PlayStatus[] values() {
        return (PlayStatus[]) a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public PlayStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.status = r3;
    }
}
