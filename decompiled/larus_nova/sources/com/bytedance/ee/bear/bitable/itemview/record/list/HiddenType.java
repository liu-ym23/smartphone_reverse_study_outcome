package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/HiddenType;", "", "value", "", "resId", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getResId", "Hidden", "FieldGroup", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HiddenType extends Enum<HiddenType> {
    public static final a Companion = null;
    public static final HiddenType FieldGroup = null;
    public static final HiddenType Hidden = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HiddenType[] f214091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214092b = null;
    private final int resId;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<HiddenType> getEntries() {
        return f214092b;
    }

    static {
        HiddenType r100 = new HiddenType("Hidden", 0, 1, R.drawable.ud_icon_invisible_outlined);
        Hidden = r100;
        HiddenType r101 = new HiddenType("FieldGroup", 1, 2, R.drawable.ud_icon_group_bitable_outlined);
        FieldGroup = r101;
        HiddenType[] r102 = {r100, r101};
        f214091a = r102;
        f214092b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static HiddenType[] values() {
        return (HiddenType[]) f214091a.clone();
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getValue() {
        return this.value;
    }

    public static HiddenType valueOf(String r100) {
        return (HiddenType) r27.a.a(HiddenType.class, r100);
    }

    public HiddenType(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.resId = r103;
    }
}
