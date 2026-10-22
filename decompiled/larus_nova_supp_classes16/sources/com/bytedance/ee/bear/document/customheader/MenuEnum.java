package com.bytedance.ee.bear.document.customheader;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/MenuEnum;", "", "imageResId", "", "imageResTint", "<init>", "(Ljava/lang/String;III)V", "getImageResId", "()I", "getImageResTint", "doc_embedded_mindnote_exit", "appeal_exit", "smartable_fullscreen_exit", "smartable_fullscreen_more", "smartable_fullscreen_undo", "smartable_fullscreen_redo", "Close", "back_to_original_doc", "copy_link", "editing_state", "UNDO", "REDO", "SEARCH", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MenuEnum extends Enum<MenuEnum> {
    public static final MenuEnum Close = null;
    public static final MenuEnum REDO = null;
    public static final MenuEnum SEARCH = null;
    public static final MenuEnum UNDO = null;
    public static final /* synthetic */ MenuEnum[] a = null;
    public static final MenuEnum appeal_exit = null;
    public static final /* synthetic */ EnumEntries b = null;
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
        return b;
    }

    static {
        MenuEnum r0 = new MenuEnum("doc_embedded_mindnote_exit", 0, 2131254998);
        doc_embedded_mindnote_exit = r0;
        MenuEnum r1 = new MenuEnum("appeal_exit", 1, 2131254998);
        appeal_exit = r1;
        MenuEnum r3 = new MenuEnum("smartable_fullscreen_exit", 2, 2131237943);
        smartable_fullscreen_exit = r3;
        MenuEnum r4 = new MenuEnum("smartable_fullscreen_more", 3, 2131255147);
        smartable_fullscreen_more = r4;
        MenuEnum r7 = new MenuEnum("smartable_fullscreen_undo", 4, 2131256063);
        smartable_fullscreen_undo = r7;
        MenuEnum r9 = new MenuEnum("smartable_fullscreen_redo", 5, 2131255522);
        smartable_fullscreen_redo = r9;
        MenuEnum r12 = new MenuEnum("Close", 6, 2131254123);
        Close = r12;
        MenuEnum r10 = new MenuEnum("back_to_original_doc", 7, 2131254502);
        back_to_original_doc = r10;
        MenuEnum r8 = new MenuEnum("copy_link", 8, 2131255013);
        copy_link = r8;
        MenuEnum r6 = new MenuEnum("editing_state", 9, 2131254251);
        editing_state = r6;
        MenuEnum r5 = new MenuEnum("UNDO", 10, 2131256063);
        UNDO = r5;
        MenuEnum r11 = new MenuEnum("REDO", 11, 2131255522);
        REDO = r11;
        MenuEnum r14 = new MenuEnum("SEARCH", 12, 2131255617);
        SEARCH = r14;
        MenuEnum[] r2 = {r0, r1, r3, r4, r7, r9, r12, r10, r8, r6, r5, r11, r14};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static MenuEnum[] values() {
        return (MenuEnum[]) a.clone();
    }

    public final int getImageResId() {
        return this.imageResId;
    }

    public final int getImageResTint() {
        return this.imageResTint;
    }

    public static MenuEnum valueOf(String r1) {
        return (MenuEnum) r27.a.a(MenuEnum.class, r1);
    }

    public MenuEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.imageResId = r3;
        this.imageResTint = 2131101926;
    }
}
