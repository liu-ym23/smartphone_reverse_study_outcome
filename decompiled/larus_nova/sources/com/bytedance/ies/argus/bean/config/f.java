package com.bytedance.ies.argus.bean.config;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/f;", "Lcom/bytedance/ies/argus/bean/config/a;", "", "Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem;", "rules", "Ljava/util/List;", "c", "()Ljava/util/List;", "", VideoSurfaceTexture.KEY_TIME, "Ljava/lang/Long;", "getTimeStamp", "()Ljava/lang/Long;", "", "ruleVersion", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class f extends a {

    @SerializedName(BaseSwitches.V)
    private final Integer ruleVersion;

    @SerializedName("rules")
    private final List<ContentVerifyRuleItem> rules;

    @SerializedName("timestamp")
    private final Long timeStamp;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timeStamp, r101.timeStamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ruleVersion, r101.ruleVersion) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<ContentVerifyRuleItem> r100 = this.rules;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.timeStamp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.ruleVersion;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContentVerifyRulesModel(rules=" + this.rules + ", timeStamp=" + this.timeStamp + ", ruleVersion=" + this.ruleVersion + ')';
    }

    public f() {
        this.rules = null;
        this.timeStamp = null;
        this.ruleVersion = null;
    }

    public final Integer b() {
        return this.ruleVersion;
    }

    public final List<ContentVerifyRuleItem> c() {
        return this.rules;
    }
}
