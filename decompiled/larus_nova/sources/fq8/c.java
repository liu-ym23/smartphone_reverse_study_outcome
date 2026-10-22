package fq8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.instruction.repo.InspireMethod;
import com.larus.bmhome.instruction.repo.InspireScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/instruction/repo/CreativityInspireRequest;", "", "scene", "", com.alipay.sdk.m.p.e.f25671s, "botId", "", "language", "featureSet", "Lcom/larus/bmhome/instruction/repo/FeatureSet;", "<init>", "(IILjava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/instruction/repo/FeatureSet;)V", "getScene", "()I", "getMethod", "getBotId", "()Ljava/lang/String;", "getLanguage", "getFeatureSet", "()Lcom/larus/bmhome/instruction/repo/FeatureSet;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("feature_set")
    private final d featureSet;

    @SerializedName("language_code")
    private final String language;

    @SerializedName(com.alipay.sdk.m.p.e.f25671s)
    private final int method;

    @SerializedName("scene")
    private final int scene;

    public c() {
        this(0, 0, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.scene == r101.scene) goto L12;
        return false;
    L12:
        if (this.method == r101.method) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.featureSet, r101.featureSet) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.scene * 31) + this.method) * 31;
        String r101 = this.botId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.language;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        d r108 = this.featureSet;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreativityInspireRequest(scene=" + this.scene + ", method=" + this.method + ", botId=" + this.botId + ", language=" + this.language + ", featureSet=" + this.featureSet + ')';
    }

    public final String a() {
        return this.botId;
    }

    public final String b() {
        return this.language;
    }

    public final int c() {
        return this.scene;
    }

    public c(@InspireScene int r100, @InspireMethod int r101, String r102, String r103, d r104) {
        this.scene = r100;
        this.method = r101;
        this.botId = r102;
        this.language = r103;
        this.featureSet = r104;
    }
}
