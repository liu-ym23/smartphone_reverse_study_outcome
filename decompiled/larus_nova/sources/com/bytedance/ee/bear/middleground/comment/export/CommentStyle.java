package com.bytedance.ee.bear.middleground.comment.export;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CommentStyle;", "", "style", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStyle", "()Ljava/lang/String;", "FLOAT", "HALF_SCREEN", "ASIDE", "ASIDE_IN_PICTURE", "isAside", "", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentStyle extends Enum<CommentStyle> {
    public static final CommentStyle ASIDE = null;
    public static final CommentStyle ASIDE_IN_PICTURE = null;
    public static final CommentStyle FLOAT = null;
    public static final CommentStyle HALF_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentStyle[] f231336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f231337b = null;
    private final String style;

    public static EnumEntries<CommentStyle> getEntries() {
        return f231337b;
    }

    static {
        CommentStyle r100 = new CommentStyle("FLOAT", 0, BrowserDependency.UrlClickType.CARD);
        FLOAT = r100;
        CommentStyle r101 = new CommentStyle("HALF_SCREEN", 1, "half_screen");
        HALF_SCREEN = r101;
        CommentStyle r102 = new CommentStyle("ASIDE", 2, "embed");
        ASIDE = r102;
        CommentStyle r103 = new CommentStyle("ASIDE_IN_PICTURE", 3, "embed_in_picture");
        ASIDE_IN_PICTURE = r103;
        CommentStyle[] r104 = {r100, r101, r102, r103};
        f231336a = r104;
        f231337b = EnumEntriesKt.enumEntries(r104);
    }

    public static CommentStyle[] values() {
        return (CommentStyle[]) f231336a.clone();
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

    public static CommentStyle valueOf(String r100) {
        return (CommentStyle) r27.a.a(CommentStyle.class, r100);
    }

    public CommentStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.style = r102;
    }
}
