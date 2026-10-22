package kvb;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUserGuideResponse;", "", "openFeature", "", "hasOwnerMM", "guideList", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/String;)V", "getOpenFeature", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasOwnerMM", "getGuideList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "equals", "other", "hashCode", "", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUserGuideResponse;", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("guide_list")
    private final String[] guideList;

    @SerializedName("has_owner_mm")
    private final Boolean hasOwnerMM;

    @SerializedName("open_feature")
    private final Boolean openFeature;

    public final String toString() {
        return "MmUserGuideResponse(openFeature=" + this.openFeature + ", hasOwnerMM=" + this.hasOwnerMM + ", guideList=" + Arrays.toString(this.guideList) + ')';
    }

    public final int hashCode() {
        Boolean r100 = this.openFeature;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hasOwnerMM;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String[] r107 = this.guideList;
        if (r107 == null) goto L14;
        r101 = Arrays.hashCode(r107);
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public a() {
        this.openFeature = null;
        this.hasOwnerMM = null;
        this.guideList = null;
    }

    public final String[] a() {
        return this.guideList;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmUserGuideResponse");
        a r102 = (a) r100;
        if (Intrinsics.areEqual(this.openFeature, r102.openFeature) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hasOwnerMM, r102.hasOwnerMM) == true) goto L18;
        return false;
    L18:
        String[] r103 = this.guideList;
        if (r103 == null) goto L27;
        String[] r104 = r102.guideList;
        if (r104 != null) goto L24;
        return false;
    L24:
        if (Arrays.equals(r103, r104) == true) goto L29;
        return false;
    L29:
        return true;
    L27:
        if (r102.guideList == null) goto L29;
        return false;
    L8:
        r101 = null;
        goto L10
    }
}
