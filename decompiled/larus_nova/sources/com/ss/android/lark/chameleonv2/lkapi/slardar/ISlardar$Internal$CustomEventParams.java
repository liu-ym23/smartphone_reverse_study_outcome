package com.ss.android.lark.chameleonv2.lkapi.slardar;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\u0005¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J%\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J)\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J%\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\u0005HÆ\u0003J©\u0001\u0010\u0015\u001a\u00020\u00002(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R1\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR1\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/slardar/ISlardar$Internal$CustomEventParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "category", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", PerfLog.PARAM_KEY_CONTEXT_ID, "extra", "metric", "", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getCategory", "()Ljava/util/HashMap;", "getContext", "getExtra", "getMetric", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ISlardar$Internal$CustomEventParams implements NonProguard {
    private final HashMap<String, String> category;
    private final HashMap<String, String> context;
    private final HashMap<String, String> extra;
    private final HashMap<String, Double> metric;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ISlardar$Internal$CustomEventParams copy$default(ISlardar$Internal$CustomEventParams r100, HashMap r101, HashMap r102, HashMap r103, HashMap r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.category;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.context;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.metric;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final HashMap<String, String> component1() {
        return this.category;
    }

    public final HashMap<String, String> component2() {
        return this.context;
    }

    public final HashMap<String, String> component3() {
        return this.extra;
    }

    public final HashMap<String, Double> component4() {
        return this.metric;
    }

    public final ISlardar$Internal$CustomEventParams copy(HashMap<String, String> r100, HashMap<String, String> r101, HashMap<String, String> r102, HashMap<String, Double> r103) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "metric");
        return new ISlardar$Internal$CustomEventParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ISlardar$Internal$CustomEventParams) == true) goto L8;
        return false;
    L8:
        ISlardar$Internal$CustomEventParams r101 = (ISlardar$Internal$CustomEventParams) r100;
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.metric, r101.metric) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        HashMap<String, String> r100 = this.category;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.context.hashCode()) * 31;
        HashMap<String, String> r104 = this.extra;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.metric.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CustomEventParams(category=" + this.category + ", context=" + this.context + ", extra=" + this.extra + ", metric=" + this.metric + ')';
    }

    public final HashMap<String, String> getCategory() {
        return this.category;
    }

    public final HashMap<String, String> getContext() {
        return this.context;
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final HashMap<String, Double> getMetric() {
        return this.metric;
    }

    public ISlardar$Internal$CustomEventParams(HashMap<String, String> r100, HashMap<String, String> r101, HashMap<String, String> r102, HashMap<String, Double> r103) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "metric");
        this.category = r100;
        this.context = r101;
        this.extra = r102;
        this.metric = r103;
    }
}
