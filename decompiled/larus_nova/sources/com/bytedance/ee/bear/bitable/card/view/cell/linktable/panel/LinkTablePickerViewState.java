package com.bytedance.ee.bear.bitable.card.view.cell.linktable.panel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/panel/LinkTablePickerViewState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "DATA_LOADED", "VIEW_LOADED", "ERROR", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LinkTablePickerViewState extends Enum<LinkTablePickerViewState> {
    public static final LinkTablePickerViewState DATA_LOADED = null;
    public static final LinkTablePickerViewState ERROR = null;
    public static final LinkTablePickerViewState LOADING = null;
    public static final LinkTablePickerViewState VIEW_LOADED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkTablePickerViewState[] f207841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207842b = null;

    public static EnumEntries<LinkTablePickerViewState> getEntries() {
        return f207842b;
    }

    static {
        LinkTablePickerViewState r100 = new LinkTablePickerViewState("LOADING", 0);
        LOADING = r100;
        LinkTablePickerViewState r101 = new LinkTablePickerViewState("DATA_LOADED", 1);
        DATA_LOADED = r101;
        LinkTablePickerViewState r102 = new LinkTablePickerViewState("VIEW_LOADED", 2);
        VIEW_LOADED = r102;
        LinkTablePickerViewState r103 = new LinkTablePickerViewState("ERROR", 3);
        ERROR = r103;
        LinkTablePickerViewState[] r104 = {r100, r101, r102, r103};
        f207841a = r104;
        f207842b = EnumEntriesKt.enumEntries(r104);
    }

    public static LinkTablePickerViewState[] values() {
        return (LinkTablePickerViewState[]) f207841a.clone();
    }

    public static LinkTablePickerViewState valueOf(String r100) {
        return (LinkTablePickerViewState) a.a(LinkTablePickerViewState.class, r100);
    }

    public LinkTablePickerViewState(String r100, int r101) {
        super(r100, r101);
    }
}
