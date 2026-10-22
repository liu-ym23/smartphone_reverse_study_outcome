package com.bytedance.ee.bear.bitable.itemview;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/ItemViewMode;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", EffectConstants.NORMAL, "LINK", "SHARE_RECORD", "ADD_RECORD", "ADD_LINK", "DRILL_DOWN", "FORM", "STAGE_VIEW", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemViewMode extends Enum<ItemViewMode> {
    public static final ItemViewMode ADD_LINK = null;
    public static final ItemViewMode ADD_RECORD = null;
    public static final ItemViewMode DRILL_DOWN = null;
    public static final ItemViewMode FORM = null;
    public static final ItemViewMode LINK = null;
    public static final ItemViewMode NORMAL = null;
    public static final ItemViewMode SHARE_RECORD = null;
    public static final ItemViewMode STAGE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemViewMode[] f213762a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213763b = null;
    private final int number;

    public static EnumEntries<ItemViewMode> getEntries() {
        return f213763b;
    }

    static {
        ItemViewMode r100 = new ItemViewMode(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ItemViewMode r101 = new ItemViewMode("LINK", 1, 1);
        LINK = r101;
        ItemViewMode r102 = new ItemViewMode("SHARE_RECORD", 2, 2);
        SHARE_RECORD = r102;
        ItemViewMode r103 = new ItemViewMode("ADD_RECORD", 3, 3);
        ADD_RECORD = r103;
        ItemViewMode r104 = new ItemViewMode("ADD_LINK", 4, 4);
        ADD_LINK = r104;
        ItemViewMode r105 = new ItemViewMode("DRILL_DOWN", 5, 6);
        DRILL_DOWN = r105;
        ItemViewMode r110 = new ItemViewMode("FORM", 6, 7);
        FORM = r110;
        ItemViewMode r111 = new ItemViewMode("STAGE_VIEW", 7, 8);
        STAGE_VIEW = r111;
        ItemViewMode[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f213762a = r112;
        f213763b = EnumEntriesKt.enumEntries(r112);
    }

    public static ItemViewMode[] values() {
        return (ItemViewMode[]) f213762a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static ItemViewMode valueOf(String r100) {
        return (ItemViewMode) r27.a.a(ItemViewMode.class, r100);
    }

    public ItemViewMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
