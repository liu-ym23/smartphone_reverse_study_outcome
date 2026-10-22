package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/preload/PreloadStatus;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "PRELOADING", "PRELOAD_SUCCESS", "PRELOAD_FAILED", "NOT_PRELOAD", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreloadStatus extends Enum<PreloadStatus> {
    public static final PreloadStatus INIT = null;
    public static final PreloadStatus NOT_PRELOAD = null;
    public static final PreloadStatus PRELOADING = null;
    public static final PreloadStatus PRELOAD_FAILED = null;
    public static final PreloadStatus PRELOAD_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadStatus[] f411255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411256b = null;

    public static EnumEntries<PreloadStatus> getEntries() {
        return f411256b;
    }

    static {
        PreloadStatus r100 = new PreloadStatus(ErrorCode.INIT, 0);
        INIT = r100;
        PreloadStatus r101 = new PreloadStatus("PRELOADING", 1);
        PRELOADING = r101;
        PreloadStatus r102 = new PreloadStatus("PRELOAD_SUCCESS", 2);
        PRELOAD_SUCCESS = r102;
        PreloadStatus r103 = new PreloadStatus("PRELOAD_FAILED", 3);
        PRELOAD_FAILED = r103;
        PreloadStatus r104 = new PreloadStatus("NOT_PRELOAD", 4);
        NOT_PRELOAD = r104;
        PreloadStatus[] r105 = {r100, r101, r102, r103, r104};
        f411255a = r105;
        f411256b = EnumEntriesKt.enumEntries(r105);
    }

    public static PreloadStatus[] values() {
        return (PreloadStatus[]) f411255a.clone();
    }

    public static PreloadStatus valueOf(String r100) {
        return (PreloadStatus) r27.a.a(PreloadStatus.class, r100);
    }

    public PreloadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
