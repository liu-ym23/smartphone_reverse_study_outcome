package com.bytedance.ee.bear.bitable.panel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/ExtendItemEnum;", "", "key", "", "viewType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getViewType", "()I", "ITEM_COMMON_PANEL_ITEM", "ITEM_DOC_USER_LIST", "ITEM_SWITCH", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExtendItemEnum extends Enum<ExtendItemEnum> {
    public static final a Companion = null;
    public static final ExtendItemEnum ITEM_COMMON_PANEL_ITEM = null;
    public static final ExtendItemEnum ITEM_DOC_USER_LIST = null;
    public static final ExtendItemEnum ITEM_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExtendItemEnum[] f214831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214832b = null;
    private final String key;
    private final int viewType;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ExtendItemEnum> getEntries() {
        return f214832b;
    }

    static {
        ExtendItemEnum r100 = new ExtendItemEnum("ITEM_COMMON_PANEL_ITEM", 0, "item_common_panel_item", 1);
        ITEM_COMMON_PANEL_ITEM = r100;
        ExtendItemEnum r101 = new ExtendItemEnum("ITEM_DOC_USER_LIST", 1, "userList", 2);
        ITEM_DOC_USER_LIST = r101;
        ExtendItemEnum r102 = new ExtendItemEnum("ITEM_SWITCH", 2, "item_switch", 3);
        ITEM_SWITCH = r102;
        ExtendItemEnum[] r103 = {r100, r101, r102};
        f214831a = r103;
        f214832b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ExtendItemEnum[] values() {
        return (ExtendItemEnum[]) f214831a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public static ExtendItemEnum valueOf(String r100) {
        return (ExtendItemEnum) r27.a.a(ExtendItemEnum.class, r100);
    }

    public ExtendItemEnum(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.key = r102;
        this.viewType = r103;
    }
}
