package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/settings/DoraGOnboardingOpenRemark;", "", "aiLiveScene", "", "queryScene", "queryGuide", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAiLiveScene", "()Ljava/lang/String;", "getQueryScene", "getQueryGuide", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingOpenRemark {

    @SerializedName("ailive_scene")
    private final String aiLiveScene;

    @SerializedName("query_guide")
    private final String queryGuide;

    @SerializedName("query_scene")
    private final String queryScene;

    public DoraGOnboardingOpenRemark() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DoraGOnboardingOpenRemark copy$default(DoraGOnboardingOpenRemark r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.aiLiveScene;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.queryScene;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.queryGuide;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.aiLiveScene;
    }

    public final String component2() {
        return this.queryScene;
    }

    public final String component3() {
        return this.queryGuide;
    }

    public final DoraGOnboardingOpenRemark copy(String r100, String r101, String r102) {
        return new DoraGOnboardingOpenRemark(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraGOnboardingOpenRemark) == true) goto L8;
        return false;
    L8:
        DoraGOnboardingOpenRemark r101 = (DoraGOnboardingOpenRemark) r100;
        if (Intrinsics.areEqual(this.aiLiveScene, r101.aiLiveScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryScene, r101.queryScene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryGuide, r101.queryGuide) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.aiLiveScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.queryScene;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.queryGuide;
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

    public String toString() {
        return "DoraGOnboardingOpenRemark(aiLiveScene=" + this.aiLiveScene + ", queryScene=" + this.queryScene + ", queryGuide=" + this.queryGuide + ')';
    }

    public final String getAiLiveScene() {
        return this.aiLiveScene;
    }

    public final String getQueryGuide() {
        return this.queryGuide;
    }

    public final String getQueryScene() {
        return this.queryScene;
    }

    public DoraGOnboardingOpenRemark(String r100, String r101, String r102) {
        this.aiLiveScene = r100;
        this.queryScene = r101;
        this.queryGuide = r102;
    }

    public /* synthetic */ DoraGOnboardingOpenRemark(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
