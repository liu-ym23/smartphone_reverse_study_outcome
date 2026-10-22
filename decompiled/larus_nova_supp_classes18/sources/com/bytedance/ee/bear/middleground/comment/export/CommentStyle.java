package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CommentStyle;", "", "style", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStyle", "()Ljava/lang/String;", "FLOAT", "HALF_SCREEN", "ASIDE", "ASIDE_IN_PICTURE", "isAside", "", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentStyle extends Enum<CommentStyle> {
    public static final CommentStyle ASIDE = null;
    public static final CommentStyle ASIDE_IN_PICTURE = null;
    public static final CommentStyle FLOAT = null;
    public static final CommentStyle HALF_SCREEN = null;
    public static final /* synthetic */ CommentStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String style;

    public static EnumEntries<CommentStyle> getEntries() {
        return b;
    }

    static {
        CommentStyle r0 = new CommentStyle("FLOAT", 0, "card");
        FLOAT = r0;
        CommentStyle r1 = new CommentStyle("HALF_SCREEN", 1, "half_screen");
        HALF_SCREEN = r1;
        CommentStyle r2 = new CommentStyle("ASIDE", 2, "embed");
        ASIDE = r2;
        CommentStyle r4 = new CommentStyle("ASIDE_IN_PICTURE", 3, "embed_in_picture");
        ASIDE_IN_PICTURE = r4;
        CommentStyle[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static CommentStyle[] values() {
        return (CommentStyle[]) a.clone();
    }

    public final boolean isAside() {
        if (this != ASIDE) goto L5;
    L8:
        return true;
    L5:
        if (this == ASIDE_IN_PICTURE) goto L8;
        return false;
    }

    public final String getStyle() {
        return this.style;
    }

    public static CommentStyle valueOf(String r1) {
        return (CommentStyle) r27.a.a(CommentStyle.class, r1);
    }

    public CommentStyle(String r1, int r2, String r3) {
        super(r1, r2);
        this.style = r3;
    }
}
