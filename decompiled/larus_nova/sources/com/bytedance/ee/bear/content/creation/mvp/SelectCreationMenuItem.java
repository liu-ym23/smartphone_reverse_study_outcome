package com.bytedance.ee.bear.content.creation.mvp;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public final class SelectCreationMenuItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemType f216848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f216849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f216850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f216851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f216852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f216853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final gj5.c f216854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PermissionResponse f216855h;

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ItemType[] f216856a = null;
        String tag;
        public int type;

        static {
            ItemType r100 = new ItemType("CANCEL", 0, -1, "CANCEL");
            CANCEL = r100;
            ItemType r101 = new ItemType("ADD_DOC", 1, 1, "ADD_DOC");
            ADD_DOC = r101;
            ItemType r102 = new ItemType("ADD_SHEET", 2, 2, "ADD_SHEET");
            ADD_SHEET = r102;
            ItemType r103 = new ItemType("ADD_MINDNOTE", 3, 3, "ADD_MIND_NOTE");
            ADD_MINDNOTE = r103;
            ItemType r104 = new ItemType("ADD_FOLDER", 4, 4, "ADD_FOLDER");
            ADD_FOLDER = r104;
            ItemType r105 = new ItemType("UPLOAD_PHOTOS", 5, 5, "UPLOAD_PHOTOS");
            UPLOAD_PHOTOS = r105;
            ItemType r110 = new ItemType("UPLOAD_FILE", 6, 6, "UPLOAD_FILE");
            UPLOAD_FILE = r110;
            ItemType r111 = new ItemType("ADD_BITABLE", 7, 10, "ADD_BITABLE");
            ADD_BITABLE = r111;
            ItemType r112 = new ItemType("ADD_DOCX", 8, 11, "ADD_DOCX");
            ADD_DOCX = r112;
            ItemType r113 = new ItemType("ADD_SURVEY", 9, 12, "ADD_SURVEY");
            ADD_SURVEY = r113;
            f216856a = new ItemType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static ItemType[] values() {
            return (ItemType[]) f216856a.clone();
        }

        public String getTag() {
            return this.tag;
        }

        public int getType() {
            return this.type;
        }

        public static ItemType valueOf(String r100) {
            return (ItemType) r27.a.a(ItemType.class, r100);
        }

        public ItemType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.type = r102;
            this.tag = r103;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f216848a, this.f216849b, Integer.valueOf(this.f216850c), Boolean.valueOf(this.f216851d)});
    }

    public ItemType getType() {
        return this.f216848a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (SelectCreationMenuItem.class != r100.getClass()) goto L21;
        SelectCreationMenuItem r101 = (SelectCreationMenuItem) r100;
        if (this.f216849b == r101.f216849b) goto L13;
    L19:
        return false;
    L13:
        if (this.f216850c != r101.f216850c) goto L19;
        if (this.f216851d != r101.f216851d) goto L19;
        if (this.f216848a != r101.f216848a) goto L19;
        return true;
    }

    public SelectCreationMenuItem(ItemType r100, CharSequence r101, int r102, boolean r103, boolean r104, PermissionResponse r105) {
        this.f216855h = null;
        this.f216848a = r100;
        this.f216849b = r101;
        this.f216850c = r102;
        this.f216852e = r103;
        this.f216853f = r104;
        this.f216855h = r105;
        boolean r106 = true;
        if (r105.getDenySource() != null) goto L5;
    L11:
        boolean r107 = false;
    L12:
        if (r103 == false) goto L18;
        if (r104 == false) goto L18;
        if (r105.getAllow() == true) goto L19;
        if (r107 == false) goto L18;
    L19:
        this.f216851d = r106;
        return;
    L18:
        r106 = false;
        goto L19
    L5:
        if (r105.getDenySource().getUiType() == null) goto L11;
        if (r105.getAllow() == true) goto L11;
        if (r105.getDenySource().getUiType() == UiType.DISABLED) goto L11;
        r107 = true;
        goto L12
    }

    public SelectCreationMenuItem(ItemType r100, CharSequence r101, int r102, boolean r103, boolean r104, gj5.c r105) {
        this.f216855h = null;
        this.f216848a = r100;
        this.f216849b = r101;
        this.f216850c = r102;
        this.f216852e = r103;
        this.f216853f = r104;
        this.f216854g = r105;
        if (r103 == false) goto L8;
        if (r104 == false) goto L8;
        if (r105.f481503a == false) goto L8;
        boolean r106 = true;
    L9:
        this.f216851d = r106;
        return;
    L8:
        r106 = false;
        goto L9
    }
}
