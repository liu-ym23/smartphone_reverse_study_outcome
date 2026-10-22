package com.ss.android.lark.chameleon.container.webcontainer.preload;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadStatus;", "", "(Ljava/lang/String;I)V", ErrorCode.INIT, "PRELOADING", "PRELOAD_SUCCESS", "PRELOAD_FAILED", "NOT_PRELOAD", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PreloadStatus extends Enum<PreloadStatus> {
    private static final /* synthetic */ PreloadStatus[] $VALUES = null;
    public static final PreloadStatus INIT = null;
    public static final PreloadStatus NOT_PRELOAD = null;
    public static final PreloadStatus PRELOADING = null;
    public static final PreloadStatus PRELOAD_FAILED = null;
    public static final PreloadStatus PRELOAD_SUCCESS = null;

    private static final /* synthetic */ PreloadStatus[] $values() {
        return new PreloadStatus[]{INIT, PRELOADING, PRELOAD_SUCCESS, PRELOAD_FAILED, NOT_PRELOAD};
    }

    public static PreloadStatus valueOf(String r100) {
        return (PreloadStatus) a.a(PreloadStatus.class, r100);
    }

    public static PreloadStatus[] values() {
        return (PreloadStatus[]) $VALUES.clone();
    }

    static {
        INIT = new PreloadStatus(ErrorCode.INIT, 0);
        PRELOADING = new PreloadStatus("PRELOADING", 1);
        PRELOAD_SUCCESS = new PreloadStatus("PRELOAD_SUCCESS", 2);
        PRELOAD_FAILED = new PreloadStatus("PRELOAD_FAILED", 3);
        NOT_PRELOAD = new PreloadStatus("NOT_PRELOAD", 4);
        $VALUES = $values();
    }

    private PreloadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
