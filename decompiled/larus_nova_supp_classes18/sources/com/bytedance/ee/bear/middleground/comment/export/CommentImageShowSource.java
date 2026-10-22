package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CommentImageShowSource;", "", "<init>", "(Ljava/lang/String;I)V", "DOCX", "DRIVE", "BITABLE_DISCUSS_PANEL", "WEB", "UNKNOWN", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentImageShowSource extends Enum<CommentImageShowSource> {
    public static final CommentImageShowSource BITABLE_DISCUSS_PANEL = null;
    public static final CommentImageShowSource DOCX = null;
    public static final CommentImageShowSource DRIVE = null;
    public static final CommentImageShowSource UNKNOWN = null;
    public static final CommentImageShowSource WEB = null;
    public static final /* synthetic */ CommentImageShowSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CommentImageShowSource> getEntries() {
        return b;
    }

    static {
        CommentImageShowSource r0 = new CommentImageShowSource("DOCX", 0);
        DOCX = r0;
        CommentImageShowSource r1 = new CommentImageShowSource("DRIVE", 1);
        DRIVE = r1;
        CommentImageShowSource r3 = new CommentImageShowSource("BITABLE_DISCUSS_PANEL", 2);
        BITABLE_DISCUSS_PANEL = r3;
        CommentImageShowSource r5 = new CommentImageShowSource("WEB", 3);
        WEB = r5;
        CommentImageShowSource r7 = new CommentImageShowSource("UNKNOWN", 4);
        UNKNOWN = r7;
        CommentImageShowSource[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static CommentImageShowSource[] values() {
        return (CommentImageShowSource[]) a.clone();
    }

    public static CommentImageShowSource valueOf(String r1) {
        return (CommentImageShowSource) r27.a.a(CommentImageShowSource.class, r1);
    }

    public CommentImageShowSource(String r1, int r2) {
        super(r1, r2);
    }
}
