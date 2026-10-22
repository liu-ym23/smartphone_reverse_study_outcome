package com.larus.bmhome.chat.resp;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/resp/NoticeButtonStyle;", "", "style", "", "<init>", "(Ljava/lang/String;II)V", "getStyle", "()I", "IMAGE", CardAdapter.TEXT, "RIGHT_ARROW", "JSON", "None", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NoticeButtonStyle extends Enum<NoticeButtonStyle> {
    public static final NoticeButtonStyle IMAGE = null;
    public static final NoticeButtonStyle JSON = null;
    public static final NoticeButtonStyle None = null;
    public static final NoticeButtonStyle RIGHT_ARROW = null;
    public static final NoticeButtonStyle TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoticeButtonStyle[] f308554a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308555b = null;
    private final int style;

    public static EnumEntries<NoticeButtonStyle> getEntries() {
        return f308555b;
    }

    static {
        NoticeButtonStyle r100 = new NoticeButtonStyle("IMAGE", 0, 1);
        IMAGE = r100;
        NoticeButtonStyle r101 = new NoticeButtonStyle(CardAdapter.TEXT, 1, 2);
        TEXT = r101;
        NoticeButtonStyle r102 = new NoticeButtonStyle("RIGHT_ARROW", 2, 3);
        RIGHT_ARROW = r102;
        NoticeButtonStyle r103 = new NoticeButtonStyle("JSON", 3, 4);
        JSON = r103;
        NoticeButtonStyle r104 = new NoticeButtonStyle("None", 4, 5);
        None = r104;
        NoticeButtonStyle[] r110 = {r100, r101, r102, r103, r104};
        f308554a = r110;
        f308555b = EnumEntriesKt.enumEntries(r110);
    }

    public static NoticeButtonStyle[] values() {
        return (NoticeButtonStyle[]) f308554a.clone();
    }

    public final int getStyle() {
        return this.style;
    }

    public static NoticeButtonStyle valueOf(String r100) {
        return (NoticeButtonStyle) a.a(NoticeButtonStyle.class, r100);
    }

    public NoticeButtonStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.style = r102;
    }
}
