package com.bytedance.ee.bear.bitable.ddui.model;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/FilterPanelAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "POP", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "REFRESH", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FilterPanelAction extends Enum<FilterPanelAction> {
    public static final FilterPanelAction POP = null;
    public static final FilterPanelAction PUSH = null;
    public static final FilterPanelAction REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterPanelAction[] f211087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211088b = null;
    private final String value;

    public static EnumEntries<FilterPanelAction> getEntries() {
        return f211088b;
    }

    static {
        FilterPanelAction r100 = new FilterPanelAction("POP", 0, "pop");
        POP = r100;
        FilterPanelAction r101 = new FilterPanelAction(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 1, "push");
        PUSH = r101;
        FilterPanelAction r102 = new FilterPanelAction("REFRESH", 2, "refresh");
        REFRESH = r102;
        FilterPanelAction[] r103 = {r100, r101, r102};
        f211087a = r103;
        f211088b = EnumEntriesKt.enumEntries(r103);
    }

    public static FilterPanelAction[] values() {
        return (FilterPanelAction[]) f211087a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static FilterPanelAction valueOf(String r100) {
        return (FilterPanelAction) a.a(FilterPanelAction.class, r100);
    }

    public FilterPanelAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
