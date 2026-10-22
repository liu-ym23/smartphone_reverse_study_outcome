package com.bytedance.android.shopping.commentv3.action;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/action/ActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "GROUP", "TRACKER", "FETCH", "ALERT", "TOAST", "REFRESH", "OPEN_SCHEMA", "SLICE_UPDATE", "STORE_UPDATE", "CACHE_UPDATE", "FETCH_COMMENT", "FILTER_EXPAND", "ENTER_BIG_PIC", "COMMENT_REPLY", "ENTER_PRODUCT_DETAIL", "ENTER_MEANINGLESS", "OPEN_SHEET_PANEL", "AUDIO_CONTROL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType ALERT = null;
    public static final ActionType AUDIO_CONTROL = null;
    public static final ActionType CACHE_UPDATE = null;
    public static final ActionType COMMENT_REPLY = null;
    public static final ActionType ENTER_BIG_PIC = null;
    public static final ActionType ENTER_MEANINGLESS = null;
    public static final ActionType ENTER_PRODUCT_DETAIL = null;
    public static final ActionType FETCH = null;
    public static final ActionType FETCH_COMMENT = null;
    public static final ActionType FILTER_EXPAND = null;
    public static final ActionType GROUP = null;
    public static final ActionType OPEN_SCHEMA = null;
    public static final ActionType OPEN_SHEET_PANEL = null;
    public static final ActionType REFRESH = null;
    public static final ActionType SLICE_UPDATE = null;
    public static final ActionType STORE_UPDATE = null;
    public static final ActionType TOAST = null;
    public static final ActionType TRACKER = null;
    public static final /* synthetic */ ActionType[] a = null;
    private final String type;

    public static ActionType valueOf(String r1) {
        return (ActionType) a.a(ActionType.class, r1);
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    static {
        ActionType r1 = new ActionType("GROUP", 0, "Group");
        GROUP = r1;
        ActionType r2 = new ActionType("TRACKER", 1, "Tracker");
        TRACKER = r2;
        ActionType r3 = new ActionType("FETCH", 2, "Fetch");
        FETCH = r3;
        ActionType r4 = new ActionType("ALERT", 3, "Alert");
        ALERT = r4;
        ActionType r5 = new ActionType("TOAST", 4, "Toast");
        TOAST = r5;
        ActionType r6 = new ActionType("REFRESH", 5, "Refresh");
        REFRESH = r6;
        ActionType r7 = new ActionType("OPEN_SCHEMA", 6, "OpenSchema");
        OPEN_SCHEMA = r7;
        ActionType r8 = new ActionType("SLICE_UPDATE", 7, "SliceUpdate");
        SLICE_UPDATE = r8;
        ActionType r9 = new ActionType("STORE_UPDATE", 8, "StoreUpdate");
        STORE_UPDATE = r9;
        ActionType r10 = new ActionType("CACHE_UPDATE", 9, "CacheUpdate");
        CACHE_UPDATE = r10;
        ActionType r11 = new ActionType("FETCH_COMMENT", 10, "FetchComment");
        FETCH_COMMENT = r11;
        ActionType r12 = new ActionType("FILTER_EXPAND", 11, "ExpandAnim");
        FILTER_EXPAND = r12;
        ActionType r13 = new ActionType("ENTER_BIG_PIC", 12, "EnterBigPic");
        ENTER_BIG_PIC = r13;
        ActionType r14 = new ActionType("COMMENT_REPLY", 13, "OpenReplyPanel");
        COMMENT_REPLY = r14;
        ActionType r15 = new ActionType("ENTER_PRODUCT_DETAIL", 14, "EnterProductDetail");
        ENTER_PRODUCT_DETAIL = r15;
        ActionType r16 = new ActionType("ENTER_MEANINGLESS", 15, "EnterMeaninglessPage");
        ENTER_MEANINGLESS = r16;
        ActionType r17 = new ActionType("OPEN_SHEET_PANEL", 16, "OpenSheetPanel");
        OPEN_SHEET_PANEL = r17;
        ActionType r18 = new ActionType("AUDIO_CONTROL", 17, "AudioControl");
        AUDIO_CONTROL = r18;
        a = new ActionType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public final String getType() {
        return this.type;
    }

    public ActionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
