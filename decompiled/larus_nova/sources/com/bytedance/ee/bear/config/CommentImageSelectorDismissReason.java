package com.bytedance.ee.bear.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/config/CommentImageSelectorDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE_SELECT_SUCCESS", "ACTIVE_CLOSE", "PASSIVE_INPUT_HOST_CLOSE", "PASSIVE_INPUT_OTHER_ACTION", "UNKNOWN", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentImageSelectorDismissReason extends Enum<CommentImageSelectorDismissReason> {
    public static final CommentImageSelectorDismissReason ACTIVE_CLOSE = null;
    public static final CommentImageSelectorDismissReason ACTIVE_SELECT_SUCCESS = null;
    public static final CommentImageSelectorDismissReason PASSIVE_INPUT_HOST_CLOSE = null;
    public static final CommentImageSelectorDismissReason PASSIVE_INPUT_OTHER_ACTION = null;
    public static final CommentImageSelectorDismissReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentImageSelectorDismissReason[] f216700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216701b = null;

    public static EnumEntries<CommentImageSelectorDismissReason> getEntries() {
        return f216701b;
    }

    static {
        CommentImageSelectorDismissReason r100 = new CommentImageSelectorDismissReason("ACTIVE_SELECT_SUCCESS", 0);
        ACTIVE_SELECT_SUCCESS = r100;
        CommentImageSelectorDismissReason r101 = new CommentImageSelectorDismissReason("ACTIVE_CLOSE", 1);
        ACTIVE_CLOSE = r101;
        CommentImageSelectorDismissReason r102 = new CommentImageSelectorDismissReason("PASSIVE_INPUT_HOST_CLOSE", 2);
        PASSIVE_INPUT_HOST_CLOSE = r102;
        CommentImageSelectorDismissReason r103 = new CommentImageSelectorDismissReason("PASSIVE_INPUT_OTHER_ACTION", 3);
        PASSIVE_INPUT_OTHER_ACTION = r103;
        CommentImageSelectorDismissReason r104 = new CommentImageSelectorDismissReason("UNKNOWN", 4);
        UNKNOWN = r104;
        CommentImageSelectorDismissReason[] r105 = {r100, r101, r102, r103, r104};
        f216700a = r105;
        f216701b = EnumEntriesKt.enumEntries(r105);
    }

    public static CommentImageSelectorDismissReason[] values() {
        return (CommentImageSelectorDismissReason[]) f216700a.clone();
    }

    public static CommentImageSelectorDismissReason valueOf(String r100) {
        return (CommentImageSelectorDismissReason) a.a(CommentImageSelectorDismissReason.class, r100);
    }

    public CommentImageSelectorDismissReason(String r100, int r101) {
        super(r100, r101);
    }
}
