package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/RefreshConfig;", "", "", "component1", "", "component2", "()Ljava/lang/Integer;", "refreshScene", "refreshFirstPullScene", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/RefreshConfig;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getRefreshScene", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getRefreshFirstPullScene", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class RefreshConfig {
    public static final a Companion = null;
    public static final String PAY_FULFILLED_NEED_REFRESH = "pay_fulfilled_need_refresh";

    @SerializedName("refresh_first_pull_scene")
    private final Integer refreshFirstPullScene;

    @SerializedName("refresh_scene")
    private final String refreshScene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RefreshConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RefreshConfig copy$default(RefreshConfig r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.refreshScene;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.refreshFirstPullScene;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.refreshScene;
    }

    public final Integer component2() {
        return this.refreshFirstPullScene;
    }

    public final RefreshConfig copy(String r100, Integer r101) {
        return new RefreshConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RefreshConfig) == true) goto L8;
        return false;
    L8:
        RefreshConfig r101 = (RefreshConfig) r100;
        if (Intrinsics.areEqual(this.refreshScene, r101.refreshScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.refreshFirstPullScene, r101.refreshFirstPullScene) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.refreshScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.refreshFirstPullScene;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RefreshConfig(refreshScene=" + this.refreshScene + ", refreshFirstPullScene=" + this.refreshFirstPullScene + ')';
    }

    public final Integer getRefreshFirstPullScene() {
        return this.refreshFirstPullScene;
    }

    public final String getRefreshScene() {
        return this.refreshScene;
    }

    public RefreshConfig(String r100, Integer r101) {
        this.refreshScene = r100;
        this.refreshFirstPullScene = r101;
    }

    public /* synthetic */ RefreshConfig(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
