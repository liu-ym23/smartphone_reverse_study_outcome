package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u001b\u0010\u0006\u001a\u00020\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiDouDiscountResStruct;", "Ljava/io/Serializable;", "", "Lcom/bytedance/locallife/model/poi/resp/PoiDouDiscountTabStruct;", "component1", "tabs", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getTabs", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDouDiscountResStruct implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("tabs")
    private final List<PoiDouDiscountTabStruct> tabs;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PoiDouDiscountResStruct() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiDouDiscountResStruct copy$default(PoiDouDiscountResStruct r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.tabs;
    L6:
        return r100.copy(r101);
    }

    public final List<PoiDouDiscountTabStruct> component1() {
        return this.tabs;
    }

    public final PoiDouDiscountResStruct copy(List<PoiDouDiscountTabStruct> r100) {
        return new PoiDouDiscountResStruct(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDouDiscountResStruct) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.tabs, ((PoiDouDiscountResStruct) r100).tabs) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<PoiDouDiscountTabStruct> r100 = this.tabs;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "PoiDouDiscountResStruct(tabs=" + this.tabs + ')';
    }

    public final List<PoiDouDiscountTabStruct> getTabs() {
        return this.tabs;
    }

    public PoiDouDiscountResStruct(List<PoiDouDiscountTabStruct> r100) {
        this.tabs = r100;
    }

    public /* synthetic */ PoiDouDiscountResStruct(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
