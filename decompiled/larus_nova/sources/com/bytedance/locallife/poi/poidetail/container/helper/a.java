package com.bytedance.locallife.poi.poidetail.container.helper;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/helper/a;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/locallife/poi/poidetail/container/helper/c;", "Lkotlin/collections/HashMap;", "reportRule", "Ljava/util/HashMap;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/HashMap;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("report_rule")
    private final HashMap<String, c> reportRule;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.reportRule, ((a) r100).reportRule) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.reportRule.hashCode();
    }

    public final String toString() {
        return "CardPerfReportConfig(reportRule=" + this.reportRule + ')';
    }

    public a() {
        HashMap<String, c> r100 = new HashMap();
        Intrinsics.checkNotNullParameter(r100, "reportRule");
        this.reportRule = r100;
    }

    public final HashMap<String, c> a() {
        return this.reportRule;
    }
}
