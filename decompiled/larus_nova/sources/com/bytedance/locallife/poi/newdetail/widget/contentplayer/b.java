package com.bytedance.locallife.poi.newdetail.widget.contentplayer;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/b;", "", "", "badgeImageUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "badgeBackgroundImageUrl", "c", "schema", "e", "", "backgroundBlur", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "actionParams", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("action_params")
    private final Map<String, String> actionParams;

    @SerializedName("background_blur")
    private final Boolean backgroundBlur;

    @SerializedName("badge_background_image_url")
    private final String badgeBackgroundImageUrl;

    @SerializedName("badge_image_url")
    private final String badgeImageUrl;

    @SerializedName("schema")
    private final String schema;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.badgeImageUrl, r101.badgeImageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.badgeBackgroundImageUrl, r101.badgeBackgroundImageUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backgroundBlur, r101.backgroundBlur) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionParams, r101.actionParams) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.badgeImageUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.badgeBackgroundImageUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.backgroundBlur;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.actionParams;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CrushPoiRank(badgeImageUrl=" + this.badgeImageUrl + ", badgeBackgroundImageUrl=" + this.badgeBackgroundImageUrl + ", schema=" + this.schema + ", backgroundBlur=" + this.backgroundBlur + ", actionParams=" + this.actionParams + ')';
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        this.badgeImageUrl = null;
        this.badgeBackgroundImageUrl = null;
        this.schema = null;
        this.backgroundBlur = r100;
        this.actionParams = null;
    }

    public final Map<String, String> a() {
        return this.actionParams;
    }

    public final Boolean b() {
        return this.backgroundBlur;
    }

    public final String c() {
        return this.badgeBackgroundImageUrl;
    }

    public final String d() {
        return this.badgeImageUrl;
    }

    public final String e() {
        return this.schema;
    }
}
