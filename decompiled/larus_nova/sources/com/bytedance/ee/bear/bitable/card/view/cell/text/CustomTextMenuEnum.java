package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/text/CustomTextMenuEnum;", "", "id", "", "titleResId", "<init>", "(Ljava/lang/String;III)V", "getId", "()I", "getTitleResId", "COPY", "DELETE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CustomTextMenuEnum extends Enum<CustomTextMenuEnum> {
    public static final CustomTextMenuEnum COPY = null;
    public static final CustomTextMenuEnum DELETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomTextMenuEnum[] f208218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f208219b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f208220id;
    private final int titleResId;

    public static EnumEntries<CustomTextMenuEnum> getEntries() {
        return f208219b;
    }

    static {
        CustomTextMenuEnum r100 = new CustomTextMenuEnum("COPY", 0, R.id.copy, com.larus.nova.R.string.Doc_Comment_Copy);
        COPY = r100;
        CustomTextMenuEnum r101 = new CustomTextMenuEnum("DELETE", 1, 101, com.larus.nova.R.string.Bitable_Common_ClearButton);
        DELETE = r101;
        CustomTextMenuEnum[] r102 = {r100, r101};
        f208218a = r102;
        f208219b = EnumEntriesKt.enumEntries(r102);
    }

    public static CustomTextMenuEnum[] values() {
        return (CustomTextMenuEnum[]) f208218a.clone();
    }

    public final int getId() {
        return this.f208220id;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public static CustomTextMenuEnum valueOf(String r100) {
        return (CustomTextMenuEnum) r27.a.a(CustomTextMenuEnum.class, r100);
    }

    public CustomTextMenuEnum(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.f208220id = r102;
        this.titleResId = r103;
    }
}
