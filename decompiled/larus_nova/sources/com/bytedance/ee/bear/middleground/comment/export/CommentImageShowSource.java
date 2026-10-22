package com.bytedance.ee.bear.middleground.comment.export;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CommentImageShowSource;", "", "<init>", "(Ljava/lang/String;I)V", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "DRIVE", "BITABLE_DISCUSS_PANEL", "WEB", "UNKNOWN", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentImageShowSource extends Enum<CommentImageShowSource> {
    public static final CommentImageShowSource BITABLE_DISCUSS_PANEL = null;
    public static final CommentImageShowSource DOCX = null;
    public static final CommentImageShowSource DRIVE = null;
    public static final CommentImageShowSource UNKNOWN = null;
    public static final CommentImageShowSource WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentImageShowSource[] f231334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f231335b = null;

    public static EnumEntries<CommentImageShowSource> getEntries() {
        return f231335b;
    }

    static {
        CommentImageShowSource r100 = new CommentImageShowSource(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 0);
        DOCX = r100;
        CommentImageShowSource r101 = new CommentImageShowSource("DRIVE", 1);
        DRIVE = r101;
        CommentImageShowSource r102 = new CommentImageShowSource("BITABLE_DISCUSS_PANEL", 2);
        BITABLE_DISCUSS_PANEL = r102;
        CommentImageShowSource r103 = new CommentImageShowSource("WEB", 3);
        WEB = r103;
        CommentImageShowSource r104 = new CommentImageShowSource("UNKNOWN", 4);
        UNKNOWN = r104;
        CommentImageShowSource[] r105 = {r100, r101, r102, r103, r104};
        f231334a = r105;
        f231335b = EnumEntriesKt.enumEntries(r105);
    }

    public static CommentImageShowSource[] values() {
        return (CommentImageShowSource[]) f231334a.clone();
    }

    public static CommentImageShowSource valueOf(String r100) {
        return (CommentImageShowSource) r27.a.a(CommentImageShowSource.class, r100);
    }

    public CommentImageShowSource(String r100, int r101) {
        super(r100, r101);
    }
}
