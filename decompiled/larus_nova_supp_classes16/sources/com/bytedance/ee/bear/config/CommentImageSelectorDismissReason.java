package com.bytedance.ee.bear.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/config/CommentImageSelectorDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE_SELECT_SUCCESS", "ACTIVE_CLOSE", "PASSIVE_INPUT_HOST_CLOSE", "PASSIVE_INPUT_OTHER_ACTION", "UNKNOWN", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentImageSelectorDismissReason extends Enum<CommentImageSelectorDismissReason> {
    public static final CommentImageSelectorDismissReason ACTIVE_CLOSE = null;
    public static final CommentImageSelectorDismissReason ACTIVE_SELECT_SUCCESS = null;
    public static final CommentImageSelectorDismissReason PASSIVE_INPUT_HOST_CLOSE = null;
    public static final CommentImageSelectorDismissReason PASSIVE_INPUT_OTHER_ACTION = null;
    public static final CommentImageSelectorDismissReason UNKNOWN = null;
    public static final /* synthetic */ CommentImageSelectorDismissReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CommentImageSelectorDismissReason> getEntries() {
        return b;
    }

    static {
        CommentImageSelectorDismissReason r0 = new CommentImageSelectorDismissReason("ACTIVE_SELECT_SUCCESS", 0);
        ACTIVE_SELECT_SUCCESS = r0;
        CommentImageSelectorDismissReason r1 = new CommentImageSelectorDismissReason("ACTIVE_CLOSE", 1);
        ACTIVE_CLOSE = r1;
        CommentImageSelectorDismissReason r3 = new CommentImageSelectorDismissReason("PASSIVE_INPUT_HOST_CLOSE", 2);
        PASSIVE_INPUT_HOST_CLOSE = r3;
        CommentImageSelectorDismissReason r5 = new CommentImageSelectorDismissReason("PASSIVE_INPUT_OTHER_ACTION", 3);
        PASSIVE_INPUT_OTHER_ACTION = r5;
        CommentImageSelectorDismissReason r7 = new CommentImageSelectorDismissReason("UNKNOWN", 4);
        UNKNOWN = r7;
        CommentImageSelectorDismissReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static CommentImageSelectorDismissReason[] values() {
        return (CommentImageSelectorDismissReason[]) a.clone();
    }

    public static CommentImageSelectorDismissReason valueOf(String r1) {
        return (CommentImageSelectorDismissReason) a.a(CommentImageSelectorDismissReason.class, r1);
    }

    public CommentImageSelectorDismissReason(String r1, int r2) {
        super(r1, r2);
    }
}
