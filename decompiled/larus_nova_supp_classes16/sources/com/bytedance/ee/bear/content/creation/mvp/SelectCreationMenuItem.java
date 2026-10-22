package com.bytedance.ee.bear.content.creation.mvp;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SelectCreationMenuItem {
    public final ItemType a;
    public final CharSequence b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final gj5.c g;
    public final PermissionResponse h;

    public static final enum ItemType extends Enum<ItemType> {
        public static final ItemType ADD_BITABLE = null;
        public static final ItemType ADD_DOC = null;
        public static final ItemType ADD_DOCX = null;
        public static final ItemType ADD_FOLDER = null;
        public static final ItemType ADD_MINDNOTE = null;
        public static final ItemType ADD_SHEET = null;
        public static final ItemType ADD_SURVEY = null;
        public static final ItemType CANCEL = null;
        public static final ItemType UPLOAD_FILE = null;
        public static final ItemType UPLOAD_PHOTOS = null;
        public static final /* synthetic */ ItemType[] a = null;
        String tag;
        public int type;

        static {
            ItemType r0 = new ItemType("CANCEL", 0, -1, "CANCEL");
            CANCEL = r0;
            ItemType r1 = new ItemType("ADD_DOC", 1, 1, "ADD_DOC");
            ADD_DOC = r1;
            ItemType r2 = new ItemType("ADD_SHEET", 2, 2, "ADD_SHEET");
            ADD_SHEET = r2;
            ItemType r5 = new ItemType("ADD_MINDNOTE", 3, 3, "ADD_MIND_NOTE");
            ADD_MINDNOTE = r5;
            ItemType r7 = new ItemType("ADD_FOLDER", 4, 4, "ADD_FOLDER");
            ADD_FOLDER = r7;
            ItemType r8 = new ItemType("UPLOAD_PHOTOS", 5, 5, "UPLOAD_PHOTOS");
            UPLOAD_PHOTOS = r8;
            ItemType r11 = new ItemType("UPLOAD_FILE", 6, 6, "UPLOAD_FILE");
            UPLOAD_FILE = r11;
            ItemType r13 = new ItemType("ADD_BITABLE", 7, 10, "ADD_BITABLE");
            ADD_BITABLE = r13;
            ItemType r16 = new ItemType("ADD_DOCX", 8, 11, "ADD_DOCX");
            ADD_DOCX = r16;
            ItemType r10 = new ItemType("ADD_SURVEY", 9, 12, "ADD_SURVEY");
            ADD_SURVEY = r10;
            a = new ItemType[]{r0, r1, r2, r5, r7, r8, r11, r13, r16, r10};
        }

        public static ItemType[] values() {
            return (ItemType[]) a.clone();
        }

        public String getTag() {
            return this.tag;
        }

        public int getType() {
            return this.type;
        }

        public static ItemType valueOf(String r1) {
            return (ItemType) r27.a.a(ItemType.class, r1);
        }

        public ItemType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.type = r3;
            this.tag = r4;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, Integer.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public ItemType getType() {
        return this.a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (SelectCreationMenuItem.class != r5.getClass()) goto L21;
        SelectCreationMenuItem r6 = (SelectCreationMenuItem) r5;
        if (this.b == r6.b) goto L13;
    L19:
        return false;
    L13:
        if (this.c != r6.c) goto L19;
        if (this.d != r6.d) goto L19;
        if (this.a != r6.a) goto L19;
        return true;
    }

    public SelectCreationMenuItem(ItemType r2, CharSequence r3, int r4, boolean r5, boolean r6, PermissionResponse r7) {
        this.h = null;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = r5;
        this.f = r6;
        this.h = r7;
        boolean r8 = true;
        if (r7.getDenySource() != null) goto L5;
    L11:
        boolean r9 = false;
    L12:
        if (r5 == false) goto L18;
        if (r6 == false) goto L18;
        if (r7.getAllow() == true) goto L19;
        if (r9 == false) goto L18;
    L19:
        this.d = r8;
        return;
    L18:
        r8 = false;
        goto L19
    L5:
        if (r7.getDenySource().getUiType() == null) goto L11;
        if (r7.getAllow() == true) goto L11;
        if (r7.getDenySource().getUiType() == UiType.DISABLED) goto L11;
        r9 = true;
        goto L12
    }

    public SelectCreationMenuItem(ItemType r2, CharSequence r3, int r4, boolean r5, boolean r6, gj5.c r7) {
        this.h = null;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        if (r5 == false) goto L8;
        if (r6 == false) goto L8;
        if (r7.a == false) goto L8;
        boolean r8 = true;
    L9:
        this.d = r8;
        return;
    L8:
        r8 = false;
        goto L9
    }
}
