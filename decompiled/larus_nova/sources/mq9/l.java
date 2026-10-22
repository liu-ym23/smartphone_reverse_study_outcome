package mq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006#"}, d2 = {"Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfig;", "", "mediaHeightRatio", "", "titleText", "", "subtitleText", "privacyAgreeText", "createButtonTitle", "createButtonBackground", "<init>", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMediaHeightRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTitleText", "()Ljava/lang/String;", "getSubtitleText", "getPrivacyAgreeText", "getCreateButtonTitle", "getCreateButtonBackground", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfig;", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("createButtonBackground")
    private final String createButtonBackground;

    @SerializedName("createButtonTitle")
    private final String createButtonTitle;

    @SerializedName("mediaHeightRatio")
    private final Float mediaHeightRatio;

    @SerializedName("privacyAgreeText")
    private final String privacyAgreeText;

    @SerializedName("subtitleText")
    private final String subtitleText;

    @SerializedName("titleText")
    private final String titleText;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.mediaHeightRatio, r101.mediaHeightRatio) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleText, r101.titleText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitleText, r101.subtitleText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.privacyAgreeText, r101.privacyAgreeText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createButtonTitle, r101.createButtonTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createButtonBackground, r101.createButtonBackground) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Float r100 = this.mediaHeightRatio;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.titleText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.subtitleText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.privacyAgreeText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.createButtonTitle;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.createButtonBackground;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "UserAvatarAuthStyleConfig(mediaHeightRatio=" + this.mediaHeightRatio + ", titleText=" + this.titleText + ", subtitleText=" + this.subtitleText + ", privacyAgreeText=" + this.privacyAgreeText + ", createButtonTitle=" + this.createButtonTitle + ", createButtonBackground=" + this.createButtonBackground + ')';
    }

    public final String a() {
        return this.createButtonBackground;
    }

    public final String b() {
        return this.createButtonTitle;
    }

    public final Float c() {
        return this.mediaHeightRatio;
    }

    public final String d() {
        return this.privacyAgreeText;
    }

    public final String e() {
        return this.subtitleText;
    }

    public final String f() {
        return this.titleText;
    }

    public /* synthetic */ l(int r100) {
        this(Float.valueOf(1.0f), null, null, null, null, null);
    }

    public l(Float r100, String r101, String r102, String r103, String r104, String r105) {
        this.mediaHeightRatio = r100;
        this.titleText = r101;
        this.subtitleText = r102;
        this.privacyAgreeText = r103;
        this.createButtonTitle = r104;
        this.createButtonBackground = r105;
    }
}
