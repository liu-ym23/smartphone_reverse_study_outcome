package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0006\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/SameUserRate;", "Ljava/io/Serializable;", "", "component1", "component2", "hasSameUserRate", "isSameUserRate", "copy", "", "toString", "", "hashCode", "", "other", "equals", "Z", "getHasSameUserRate", "()Z", "<init>", "(ZZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class SameUserRate implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("has_same_user_rate")
    private final boolean hasSameUserRate;

    @SerializedName("is_same_user_rate")
    private final boolean isSameUserRate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SameUserRate() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ SameUserRate copy$default(SameUserRate r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.hasSameUserRate;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isSameUserRate;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.hasSameUserRate;
    }

    public final boolean component2() {
        return this.isSameUserRate;
    }

    public final SameUserRate copy(boolean r100, boolean r101) {
        return new SameUserRate(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SameUserRate) == true) goto L8;
        return false;
    L8:
        SameUserRate r101 = (SameUserRate) r100;
        if (this.hasSameUserRate == r101.hasSameUserRate) goto L12;
        return false;
    L12:
        if (this.isSameUserRate == r101.isSameUserRate) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.hasSameUserRate == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isSameUserRate == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "SameUserRate(hasSameUserRate=" + this.hasSameUserRate + ", isSameUserRate=" + this.isSameUserRate + ')';
    }

    public final boolean getHasSameUserRate() {
        return this.hasSameUserRate;
    }

    public final boolean isSameUserRate() {
        return this.isSameUserRate;
    }

    public SameUserRate(boolean r100, boolean r101) {
        this.hasSameUserRate = r100;
        this.isSameUserRate = r101;
    }

    public /* synthetic */ SameUserRate(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
