package com.bytedance.ee.bear.bitable.ddui.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/FilterValueUIType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INPUT_AREA", "INPUT_NUMBER", "INPUT_PHONE", "DATE_PICKER", "CHECK_LIST", "CHATTER_CHECK_LIST", "LINK_CHECK_LIST", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FilterValueUIType extends Enum<FilterValueUIType> {
    public static final FilterValueUIType CHATTER_CHECK_LIST = null;
    public static final FilterValueUIType CHECK_LIST = null;
    public static final a Companion = null;
    public static final FilterValueUIType DATE_PICKER = null;
    public static final FilterValueUIType INPUT_AREA = null;
    public static final FilterValueUIType INPUT_NUMBER = null;
    public static final FilterValueUIType INPUT_PHONE = null;
    public static final FilterValueUIType LINK_CHECK_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterValueUIType[] f211091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211092b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FilterValueUIType> getEntries() {
        return f211092b;
    }

    static {
        FilterValueUIType r100 = new FilterValueUIType("INPUT_AREA", 0, "inputArea");
        INPUT_AREA = r100;
        FilterValueUIType r101 = new FilterValueUIType("INPUT_NUMBER", 1, "inputNumber");
        INPUT_NUMBER = r101;
        FilterValueUIType r102 = new FilterValueUIType("INPUT_PHONE", 2, "inputPhone");
        INPUT_PHONE = r102;
        FilterValueUIType r103 = new FilterValueUIType("DATE_PICKER", 3, "datePicker");
        DATE_PICKER = r103;
        FilterValueUIType r104 = new FilterValueUIType("CHECK_LIST", 4, "checkList");
        CHECK_LIST = r104;
        FilterValueUIType r105 = new FilterValueUIType("CHATTER_CHECK_LIST", 5, "chatterCheckList");
        CHATTER_CHECK_LIST = r105;
        FilterValueUIType r110 = new FilterValueUIType("LINK_CHECK_LIST", 6, "linkCheckList");
        LINK_CHECK_LIST = r110;
        FilterValueUIType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f211091a = r111;
        f211092b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static FilterValueUIType[] values() {
        return (FilterValueUIType[]) f211091a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static FilterValueUIType valueOf(String r100) {
        return (FilterValueUIType) r27.a.a(FilterValueUIType.class, r100);
    }

    public FilterValueUIType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
