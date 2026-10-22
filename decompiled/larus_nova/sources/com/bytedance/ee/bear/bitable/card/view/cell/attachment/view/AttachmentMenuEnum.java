package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.util.SparseArray;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final enum AttachmentMenuEnum extends Enum<AttachmentMenuEnum> {
    public static final AttachmentMenuEnum DELETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<AttachmentMenuEnum> f207440a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AttachmentMenuEnum[] f207441b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f207442id;
    private int titleResId;

    static {
        AttachmentMenuEnum r100 = new AttachmentMenuEnum();
        DELETE = r100;
        int r101 = 0;
        f207441b = new AttachmentMenuEnum[]{r100};
        f207440a = new SparseArray();
        AttachmentMenuEnum[] r102 = values();
        int r103 = r102.length;
    L3:
        if (r101 >= r103) goto L5;
        AttachmentMenuEnum r104 = r102[r101];
        f207440a.put(r104.f207442id, r104);
        r101 = r101 + 1;
        goto L3
    }

    public AttachmentMenuEnum() {
        super("DELETE", 0);
        this.f207442id = 0;
        this.titleResId = R.string.Doc_Facade_Delete;
    }

    public static AttachmentMenuEnum[] values() {
        return (AttachmentMenuEnum[]) f207441b.clone();
    }

    public int getId() {
        return this.f207442id;
    }

    public int getTitleResId() {
        return this.titleResId;
    }

    public static AttachmentMenuEnum valueOf(int r100) {
        return f207440a.get(r100);
    }

    public static AttachmentMenuEnum valueOf(String r100) {
        return (AttachmentMenuEnum) r27.a.a(AttachmentMenuEnum.class, r100);
    }
}
