package com.bytedance.ee.bear.more.moreprotocol;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/CommonMoreItemId;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "RENAME", "MOVE", "SHORT_CUT", "STAR", "PIN", "MANUAL_CACHE", "DELETE", "ADD_SHORT_CUT", "PERMISSION", "MAKE_COPY", "CONTACT_SERVICE", OpenNetMethod.REPORT, "SUBSCRIBE", "SUBSCRIBE_COMMENT", "APPLY_EDIT_PERMISSION", "COPY_LINK", "MULTI_TASK", "OPERATION_RECORD", "TEMPLATE", "TEMPLATE_SWITCH", "RETENTION_LABEL", "ADD_TO_WORKBENCH", "BROWSER_VIEW", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonMoreItemId extends Enum<CommonMoreItemId> {
    public static final CommonMoreItemId ADD_SHORT_CUT = null;
    public static final CommonMoreItemId ADD_TO_WORKBENCH = null;
    public static final CommonMoreItemId APPLY_EDIT_PERMISSION = null;
    public static final CommonMoreItemId BROWSER_VIEW = null;
    public static final CommonMoreItemId CONTACT_SERVICE = null;
    public static final CommonMoreItemId COPY_LINK = null;
    public static final CommonMoreItemId DELETE = null;
    public static final CommonMoreItemId MAKE_COPY = null;
    public static final CommonMoreItemId MANUAL_CACHE = null;
    public static final CommonMoreItemId MOVE = null;
    public static final CommonMoreItemId MULTI_TASK = null;
    public static final CommonMoreItemId OPERATION_RECORD = null;
    public static final CommonMoreItemId PERMISSION = null;
    public static final CommonMoreItemId PIN = null;
    public static final CommonMoreItemId RENAME = null;
    public static final CommonMoreItemId REPORT = null;
    public static final CommonMoreItemId RETENTION_LABEL = null;
    public static final CommonMoreItemId SHORT_CUT = null;
    public static final CommonMoreItemId STAR = null;
    public static final CommonMoreItemId SUBSCRIBE = null;
    public static final CommonMoreItemId SUBSCRIBE_COMMENT = null;
    public static final CommonMoreItemId TEMPLATE = null;
    public static final CommonMoreItemId TEMPLATE_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonMoreItemId[] f234660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f234661b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f234662id;

    public static EnumEntries<CommonMoreItemId> getEntries() {
        return f234661b;
    }

    static {
        CommonMoreItemId r100 = new CommonMoreItemId("RENAME", 0, "rename");
        RENAME = r100;
        CommonMoreItemId r101 = new CommonMoreItemId("MOVE", 1, "moveV2");
        MOVE = r101;
        CommonMoreItemId r102 = new CommonMoreItemId("SHORT_CUT", 2, "shortcut");
        SHORT_CUT = r102;
        CommonMoreItemId r103 = new CommonMoreItemId("STAR", 3, ScoreTags.SCORE_TYPE_STAR);
        STAR = r103;
        CommonMoreItemId r104 = new CommonMoreItemId("PIN", 4, "pin");
        PIN = r104;
        CommonMoreItemId r105 = new CommonMoreItemId("MANUAL_CACHE", 5, "manual_cache");
        MANUAL_CACHE = r105;
        CommonMoreItemId r110 = new CommonMoreItemId("DELETE", 6, "delete");
        DELETE = r110;
        CommonMoreItemId r111 = new CommonMoreItemId("ADD_SHORT_CUT", 7, "add_shortcut");
        ADD_SHORT_CUT = r111;
        CommonMoreItemId r112 = new CommonMoreItemId("PERMISSION", 8, "permission");
        PERMISSION = r112;
        CommonMoreItemId r113 = new CommonMoreItemId("MAKE_COPY", 9, "make_copy");
        MAKE_COPY = r113;
        CommonMoreItemId r114 = new CommonMoreItemId("CONTACT_SERVICE", 10, "contact_service");
        CONTACT_SERVICE = r114;
        CommonMoreItemId r106 = new CommonMoreItemId(OpenNetMethod.REPORT, 11, "report");
        REPORT = r106;
        CommonMoreItemId r107 = new CommonMoreItemId("SUBSCRIBE", 12, "subscribe");
        SUBSCRIBE = r107;
        CommonMoreItemId r108 = new CommonMoreItemId("SUBSCRIBE_COMMENT", 13, "subscribe_comment");
        SUBSCRIBE_COMMENT = r108;
        CommonMoreItemId r109 = new CommonMoreItemId("APPLY_EDIT_PERMISSION", 14, "apply_edit_permission");
        APPLY_EDIT_PERMISSION = r109;
        CommonMoreItemId r115 = new CommonMoreItemId("COPY_LINK", 15, "copy_link");
        COPY_LINK = r115;
        CommonMoreItemId r116 = new CommonMoreItemId("MULTI_TASK", 16, "multi_task");
        MULTI_TASK = r116;
        CommonMoreItemId r117 = new CommonMoreItemId("OPERATION_RECORD", 17, "operation_record");
        OPERATION_RECORD = r117;
        CommonMoreItemId r118 = new CommonMoreItemId("TEMPLATE", 18, ThumbGlideUrl.SOURCE_TEMPLATE);
        TEMPLATE = r118;
        CommonMoreItemId r119 = new CommonMoreItemId("TEMPLATE_SWITCH", 19, "template_switch");
        TEMPLATE_SWITCH = r119;
        CommonMoreItemId r120 = new CommonMoreItemId("RETENTION_LABEL", 20, "retention_label");
        RETENTION_LABEL = r120;
        CommonMoreItemId r121 = new CommonMoreItemId("ADD_TO_WORKBENCH", 21, "add_to_workbench");
        ADD_TO_WORKBENCH = r121;
        CommonMoreItemId r122 = new CommonMoreItemId("BROWSER_VIEW", 22, "browser_view");
        BROWSER_VIEW = r122;
        CommonMoreItemId[] r123 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122};
        f234660a = r123;
        f234661b = EnumEntriesKt.enumEntries(r123);
    }

    public static CommonMoreItemId[] values() {
        return (CommonMoreItemId[]) f234660a.clone();
    }

    public final String getId() {
        return this.f234662id;
    }

    public static CommonMoreItemId valueOf(String r100) {
        return (CommonMoreItemId) a.a(CommonMoreItemId.class, r100);
    }

    public CommonMoreItemId(String r100, int r101, String r102) {
        super(r100, r101);
        this.f234662id = r102;
    }
}
