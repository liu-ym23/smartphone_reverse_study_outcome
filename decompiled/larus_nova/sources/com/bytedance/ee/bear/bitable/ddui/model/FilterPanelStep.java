package com.bytedance.ee.bear.bitable.ddui.model;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/FilterPanelStep;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FIELD", "OPERATOR", "SUB_SCOPE", "VALUE", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FilterPanelStep extends Enum<FilterPanelStep> {
    public static final a Companion = null;
    public static final FilterPanelStep FIELD = null;
    public static final FilterPanelStep OPERATOR = null;
    public static final FilterPanelStep SUB_SCOPE = null;
    public static final FilterPanelStep VALUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterPanelStep[] f211089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211090b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FilterPanelStep> getEntries() {
        return f211090b;
    }

    static {
        FilterPanelStep r100 = new FilterPanelStep("FIELD", 0, "field");
        FIELD = r100;
        FilterPanelStep r101 = new FilterPanelStep("OPERATOR", 1, OnekeyLoginConstants.CU_KEY_OPERATOR);
        OPERATOR = r101;
        FilterPanelStep r102 = new FilterPanelStep("SUB_SCOPE", 2, "subScope");
        SUB_SCOPE = r102;
        FilterPanelStep r103 = new FilterPanelStep("VALUE", 3, "value");
        VALUE = r103;
        FilterPanelStep[] r104 = {r100, r101, r102, r103};
        f211089a = r104;
        f211090b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static FilterPanelStep[] values() {
        return (FilterPanelStep[]) f211089a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static FilterPanelStep valueOf(String r100) {
        return (FilterPanelStep) r27.a.a(FilterPanelStep.class, r100);
    }

    public FilterPanelStep(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
