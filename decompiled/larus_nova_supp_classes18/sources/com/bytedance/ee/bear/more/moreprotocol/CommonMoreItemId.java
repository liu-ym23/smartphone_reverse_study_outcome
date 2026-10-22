package com.bytedance.ee.bear.more.moreprotocol;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/CommonMoreItemId;", "", ResourceData.KEY_ID, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "RENAME", "MOVE", "SHORT_CUT", "STAR", "PIN", "MANUAL_CACHE", "DELETE", "ADD_SHORT_CUT", "PERMISSION", "MAKE_COPY", "CONTACT_SERVICE", "REPORT", "SUBSCRIBE", "SUBSCRIBE_COMMENT", "APPLY_EDIT_PERMISSION", "COPY_LINK", "MULTI_TASK", "OPERATION_RECORD", "TEMPLATE", "TEMPLATE_SWITCH", "RETENTION_LABEL", "ADD_TO_WORKBENCH", "BROWSER_VIEW", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
    public static final /* synthetic */ CommonMoreItemId[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String id;

    public static EnumEntries<CommonMoreItemId> getEntries() {
        return b;
    }

    static {
        CommonMoreItemId r0 = new CommonMoreItemId("RENAME", 0, "rename");
        RENAME = r0;
        CommonMoreItemId r1 = new CommonMoreItemId("MOVE", 1, "moveV2");
        MOVE = r1;
        CommonMoreItemId r2 = new CommonMoreItemId("SHORT_CUT", 2, "shortcut");
        SHORT_CUT = r2;
        CommonMoreItemId r4 = new CommonMoreItemId("STAR", 3, "star");
        STAR = r4;
        CommonMoreItemId r6 = new CommonMoreItemId("PIN", 4, "pin");
        PIN = r6;
        CommonMoreItemId r8 = new CommonMoreItemId("MANUAL_CACHE", 5, "manual_cache");
        MANUAL_CACHE = r8;
        CommonMoreItemId r10 = new CommonMoreItemId("DELETE", 6, "delete");
        DELETE = r10;
        CommonMoreItemId r12 = new CommonMoreItemId("ADD_SHORT_CUT", 7, "add_shortcut");
        ADD_SHORT_CUT = r12;
        CommonMoreItemId r14 = new CommonMoreItemId("PERMISSION", 8, "permission");
        PERMISSION = r14;
        CommonMoreItemId r13 = new CommonMoreItemId("MAKE_COPY", 9, "make_copy");
        MAKE_COPY = r13;
        CommonMoreItemId r11 = new CommonMoreItemId("CONTACT_SERVICE", 10, "contact_service");
        CONTACT_SERVICE = r11;
        CommonMoreItemId r9 = new CommonMoreItemId("REPORT", 11, "report");
        REPORT = r9;
        CommonMoreItemId r7 = new CommonMoreItemId("SUBSCRIBE", 12, "subscribe");
        SUBSCRIBE = r7;
        CommonMoreItemId r5 = new CommonMoreItemId("SUBSCRIBE_COMMENT", 13, "subscribe_comment");
        SUBSCRIBE_COMMENT = r5;
        CommonMoreItemId r3 = new CommonMoreItemId("APPLY_EDIT_PERMISSION", 14, "apply_edit_permission");
        APPLY_EDIT_PERMISSION = r3;
        CommonMoreItemId r15 = new CommonMoreItemId("COPY_LINK", 15, "copy_link");
        COPY_LINK = r15;
        CommonMoreItemId r16 = new CommonMoreItemId("MULTI_TASK", 16, "multi_task");
        MULTI_TASK = r16;
        CommonMoreItemId r17 = new CommonMoreItemId("OPERATION_RECORD", 17, "operation_record");
        OPERATION_RECORD = r17;
        CommonMoreItemId r18 = new CommonMoreItemId("TEMPLATE", 18, ThumbGlideUrl.SOURCE_TEMPLATE);
        TEMPLATE = r18;
        CommonMoreItemId r19 = new CommonMoreItemId("TEMPLATE_SWITCH", 19, "template_switch");
        TEMPLATE_SWITCH = r19;
        CommonMoreItemId r20 = new CommonMoreItemId("RETENTION_LABEL", 20, "retention_label");
        RETENTION_LABEL = r20;
        CommonMoreItemId r21 = new CommonMoreItemId("ADD_TO_WORKBENCH", 21, "add_to_workbench");
        ADD_TO_WORKBENCH = r21;
        CommonMoreItemId r22 = new CommonMoreItemId("BROWSER_VIEW", 22, "browser_view");
        BROWSER_VIEW = r22;
        CommonMoreItemId[] r23 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22};
        a = r23;
        b = EnumEntriesKt.enumEntries(r23);
    }

    public static CommonMoreItemId[] values() {
        return (CommonMoreItemId[]) a.clone();
    }

    public final String getId() {
        return this.id;
    }

    public static CommonMoreItemId valueOf(String r1) {
        return (CommonMoreItemId) a.a(CommonMoreItemId.class, r1);
    }

    public CommonMoreItemId(String r1, int r2, String r3) {
        super(r1, r2);
        this.id = r3;
    }
}
