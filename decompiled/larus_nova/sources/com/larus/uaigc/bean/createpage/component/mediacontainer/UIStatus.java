package com.larus.uaigc.bean.createpage.component.mediacontainer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/UIStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STATUS_INIT", "STATUS_FINISH", "STATUS_UPLOAD_FINISH", "STATUS_INSPECT_FAILED", "STATUS_PARSE_FAILED", "STATUS_REFRESH_PROGRESS", "STATUS_UPLOAD_FAIL", "STATUS_DELETE", "STATUS_COMPRESS_SUCCESS", "STATUS_UPDATE_VIDEO_COVER", "STATUS_UPDATE_RESOURCE_BAR_UI", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UIStatus extends Enum<UIStatus> {
    public static final UIStatus STATUS_COMPRESS_SUCCESS = null;
    public static final UIStatus STATUS_DELETE = null;
    public static final UIStatus STATUS_FINISH = null;
    public static final UIStatus STATUS_INIT = null;
    public static final UIStatus STATUS_INSPECT_FAILED = null;
    public static final UIStatus STATUS_PARSE_FAILED = null;
    public static final UIStatus STATUS_REFRESH_PROGRESS = null;
    public static final UIStatus STATUS_UPDATE_RESOURCE_BAR_UI = null;
    public static final UIStatus STATUS_UPDATE_VIDEO_COVER = null;
    public static final UIStatus STATUS_UPLOAD_FAIL = null;
    public static final UIStatus STATUS_UPLOAD_FINISH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UIStatus[] f370364a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370365b = null;

    public static EnumEntries<UIStatus> getEntries() {
        return f370365b;
    }

    static {
        UIStatus r100 = new UIStatus("STATUS_INIT", 0);
        STATUS_INIT = r100;
        UIStatus r101 = new UIStatus("STATUS_FINISH", 1);
        STATUS_FINISH = r101;
        UIStatus r102 = new UIStatus("STATUS_UPLOAD_FINISH", 2);
        STATUS_UPLOAD_FINISH = r102;
        UIStatus r103 = new UIStatus("STATUS_INSPECT_FAILED", 3);
        STATUS_INSPECT_FAILED = r103;
        UIStatus r104 = new UIStatus("STATUS_PARSE_FAILED", 4);
        STATUS_PARSE_FAILED = r104;
        UIStatus r105 = new UIStatus("STATUS_REFRESH_PROGRESS", 5);
        STATUS_REFRESH_PROGRESS = r105;
        UIStatus r110 = new UIStatus("STATUS_UPLOAD_FAIL", 6);
        STATUS_UPLOAD_FAIL = r110;
        UIStatus r111 = new UIStatus("STATUS_DELETE", 7);
        STATUS_DELETE = r111;
        UIStatus r112 = new UIStatus("STATUS_COMPRESS_SUCCESS", 8);
        STATUS_COMPRESS_SUCCESS = r112;
        UIStatus r113 = new UIStatus("STATUS_UPDATE_VIDEO_COVER", 9);
        STATUS_UPDATE_VIDEO_COVER = r113;
        UIStatus r114 = new UIStatus("STATUS_UPDATE_RESOURCE_BAR_UI", 10);
        STATUS_UPDATE_RESOURCE_BAR_UI = r114;
        UIStatus[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f370364a = r115;
        f370365b = EnumEntriesKt.enumEntries(r115);
    }

    public static UIStatus[] values() {
        return (UIStatus[]) f370364a.clone();
    }

    public static UIStatus valueOf(String r100) {
        return (UIStatus) a.a(UIStatus.class, r100);
    }

    public UIStatus(String r100, int r101) {
        super(r100, r101);
    }
}
