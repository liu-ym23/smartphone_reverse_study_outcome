package com.bytedance.ee.bear.document.customheader;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/MenuEnum;", "", "imageResId", "", "imageResTint", "<init>", "(Ljava/lang/String;III)V", "getImageResId", "()I", "getImageResTint", "doc_embedded_mindnote_exit", "appeal_exit", "smartable_fullscreen_exit", "smartable_fullscreen_more", "smartable_fullscreen_undo", "smartable_fullscreen_redo", "Close", "back_to_original_doc", "copy_link", "editing_state", "UNDO", "REDO", "SEARCH", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MenuEnum extends Enum<MenuEnum> {
    public static final MenuEnum Close = null;
    public static final MenuEnum REDO = null;
    public static final MenuEnum SEARCH = null;
    public static final MenuEnum UNDO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MenuEnum[] f219445a = null;
    public static final MenuEnum appeal_exit = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f219446b = null;
    public static final MenuEnum back_to_original_doc = null;
    public static final MenuEnum copy_link = null;
    public static final MenuEnum doc_embedded_mindnote_exit = null;
    public static final MenuEnum editing_state = null;
    public static final MenuEnum smartable_fullscreen_exit = null;
    public static final MenuEnum smartable_fullscreen_more = null;
    public static final MenuEnum smartable_fullscreen_redo = null;
    public static final MenuEnum smartable_fullscreen_undo = null;
    private final int imageResId;
    private final int imageResTint;

    public static EnumEntries<MenuEnum> getEntries() {
        return f219446b;
    }

    static {
        MenuEnum r100 = new MenuEnum("doc_embedded_mindnote_exit", 0, R.drawable.ud_icon_left_outlined);
        doc_embedded_mindnote_exit = r100;
        MenuEnum r101 = new MenuEnum("appeal_exit", 1, R.drawable.ud_icon_left_outlined);
        appeal_exit = r101;
        MenuEnum r102 = new MenuEnum("smartable_fullscreen_exit", 2, R.drawable.icon_fullscreen_exit_nor);
        smartable_fullscreen_exit = r102;
        MenuEnum r103 = new MenuEnum("smartable_fullscreen_more", 3, R.drawable.ud_icon_more_outlined);
        smartable_fullscreen_more = r103;
        MenuEnum r104 = new MenuEnum("smartable_fullscreen_undo", 4, R.drawable.ud_icon_undo_outlined);
        smartable_fullscreen_undo = r104;
        MenuEnum r105 = new MenuEnum("smartable_fullscreen_redo", 5, R.drawable.ud_icon_redo_outlined);
        smartable_fullscreen_redo = r105;
        MenuEnum r110 = new MenuEnum("Close", 6, R.drawable.ud_icon_close_outlined);
        Close = r110;
        MenuEnum r111 = new MenuEnum("back_to_original_doc", 7, R.drawable.ud_icon_file_link_docx_outlined);
        back_to_original_doc = r111;
        MenuEnum r106 = new MenuEnum("copy_link", 8, R.drawable.ud_icon_link_copy_outlined);
        copy_link = r106;
        MenuEnum r107 = new MenuEnum("editing_state", 9, R.drawable.ud_icon_done_outlined);
        editing_state = r107;
        MenuEnum r108 = new MenuEnum("UNDO", 10, R.drawable.ud_icon_undo_outlined);
        UNDO = r108;
        MenuEnum r112 = new MenuEnum("REDO", 11, R.drawable.ud_icon_redo_outlined);
        REDO = r112;
        MenuEnum r113 = new MenuEnum("SEARCH", 12, R.drawable.ud_icon_search_outlined);
        SEARCH = r113;
        MenuEnum[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r106, r107, r108, r112, r113};
        f219445a = r109;
        f219446b = EnumEntriesKt.enumEntries(r109);
    }

    public static MenuEnum[] values() {
        return (MenuEnum[]) f219445a.clone();
    }

    public final int getImageResId() {
        return this.imageResId;
    }

    public final int getImageResTint() {
        return this.imageResTint;
    }

    public static MenuEnum valueOf(String r100) {
        return (MenuEnum) r27.a.a(MenuEnum.class, r100);
    }

    public MenuEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.imageResId = r102;
        this.imageResTint = R.color.facade_selector_icon_n1;
    }
}
