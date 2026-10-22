package com.bytedance.ee.bear.bitable.fieldedit.model;

import com.bytedance.ee.bear.bitable.filter.model.EFilterConjunction;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000f¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldQueryOptionsModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "rangeRuleType", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldQueryOptionsModel$RangeRuleType;", "getRangeRuleType", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldQueryOptionsModel$RangeRuleType;", "setRangeRuleType", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldQueryOptionsModel$RangeRuleType;)V", "conjunction", "", "getConjunction", "()Ljava/lang/String;", "setConjunction", "(Ljava/lang/String;)V", "conditions", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "Lkotlin/collections/ArrayList;", "getConditions", "()Ljava/util/ArrayList;", "setConditions", "(Ljava/util/ArrayList;)V", "filterOptions", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions;", "getFilterOptions", "()Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions;", "setFilterOptions", "(Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions;)V", "tableId", "getTableId", "setTableId", "setFilterInfo", "", "filterInfo", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterInfo;", "RangeRuleType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldQueryOptionsModel implements NonProguard {
    private ArrayList<FilterCondition> conditions;
    private String conjunction;
    private FilterOptions filterOptions;
    private RangeRuleType rangeRuleType;
    private String tableId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldQueryOptionsModel$RangeRuleType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RANGE_RULE_TYPE_ALL", "RANGE_RULE_TYPE_PORTION", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RangeRuleType extends Enum<RangeRuleType> {
        public static final a Companion = null;
        public static final RangeRuleType RANGE_RULE_TYPE_ALL = null;
        public static final RangeRuleType RANGE_RULE_TYPE_PORTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RangeRuleType[] f211138a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211139b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RangeRuleType> getEntries() {
            return f211139b;
        }

        static {
            RangeRuleType r100 = new RangeRuleType("RANGE_RULE_TYPE_ALL", 0, 0);
            RANGE_RULE_TYPE_ALL = r100;
            RangeRuleType r101 = new RangeRuleType("RANGE_RULE_TYPE_PORTION", 1, 1);
            RANGE_RULE_TYPE_PORTION = r101;
            RangeRuleType[] r102 = {r100, r101};
            f211138a = r102;
            f211139b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static RangeRuleType[] values() {
            return (RangeRuleType[]) f211138a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RangeRuleType valueOf(String r100) {
            return (RangeRuleType) r27.a.a(RangeRuleType.class, r100);
        }

        public RangeRuleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public FieldQueryOptionsModel() {
        this.rangeRuleType = RangeRuleType.RANGE_RULE_TYPE_ALL;
    }

    public final ArrayList<FilterCondition> getConditions() {
        return this.conditions;
    }

    public final String getConjunction() {
        return this.conjunction;
    }

    public final FilterOptions getFilterOptions() {
        return this.filterOptions;
    }

    public final RangeRuleType getRangeRuleType() {
        return this.rangeRuleType;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final void setConditions(ArrayList<FilterCondition> r100) {
        this.conditions = r100;
    }

    public final void setConjunction(String r100) {
        this.conjunction = r100;
    }

    public final void setFilterInfo(FilterInfo r100) {
        if (r100 == null) goto L6;
        FilterCondition[] r101 = r100.getConditions();
        if (r101 == null) goto L6;
        List r102 = ArraysKt.filterNotNull(r101);
    L7:
        if (r102 == null) goto L9;
        boolean r103 = r102.isEmpty();
    L10:
        if (r103 == false) goto L12;
        RangeRuleType r104 = RangeRuleType.RANGE_RULE_TYPE_ALL;
    L13:
        this.rangeRuleType = r104;
        if (r100 == null) goto L17;
        String r105 = r100.getConjunction();
        if (r105 == null) goto L17;
    L18:
        this.conjunction = r105;
        ArrayList<FilterCondition> r106 = new ArrayList();
        if (r102 == null) goto L24;
        Iterator r107 = r102.iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        r106.add((FilterCondition) r107.next());
    L24:
        this.conditions = r106;
        return;
    L17:
        r105 = EFilterConjunction.And.getValue();
        goto L18
    L12:
        r104 = RangeRuleType.RANGE_RULE_TYPE_PORTION;
        goto L13
    L9:
        r103 = true;
    L6:
        r102 = null;
        goto L7
    }

    public final void setFilterOptions(FilterOptions r100) {
        this.filterOptions = r100;
    }

    public final void setRangeRuleType(RangeRuleType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rangeRuleType = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }
}
