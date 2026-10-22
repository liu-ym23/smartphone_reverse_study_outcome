package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jf\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006,"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppBadgeNode;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", "", "appId", "feature", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;", "needShow", "", UserInfo.UPDATE_TIME, "badgeNum", "", "extra", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;Ljava/lang/Boolean;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getAppId", "getFeature", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;", "getNeedShow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUpdateTime", "getBadgeNum", "()I", "getExtra", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppFeatureType;Ljava/lang/Boolean;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyOpenAppBadgeNode;", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyOpenAppBadgeNode implements NonProguard {
    private final String appId;
    private final int badgeNum;
    private final String extra;
    private final MyOpenAppFeatureType feature;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f411460id;
    private final Boolean needShow;
    private final String updateTime;
    private final String version;

    public static /* synthetic */ MyOpenAppBadgeNode copy$default(MyOpenAppBadgeNode r100, String r110, String r111, MyOpenAppFeatureType r112, Boolean r113, String r114, int r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.f411460id;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.appId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        MyOpenAppFeatureType r103 = r100.feature;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = r100.needShow;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.updateTime;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.badgeNum;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.extra;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.version;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.f411460id;
    }

    public final String component2() {
        return this.appId;
    }

    public final MyOpenAppFeatureType component3() {
        return this.feature;
    }

    public final Boolean component4() {
        return this.needShow;
    }

    public final String component5() {
        return this.updateTime;
    }

    public final int component6() {
        return this.badgeNum;
    }

    public final String component7() {
        return this.extra;
    }

    public final String component8() {
        return this.version;
    }

    public final MyOpenAppBadgeNode copy(String r110, String r111, MyOpenAppFeatureType r112, Boolean r113, String r114, int r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r117, "version");
        return new MyOpenAppBadgeNode(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MyOpenAppBadgeNode) == true) goto L8;
        return false;
    L8:
        MyOpenAppBadgeNode r101 = (MyOpenAppBadgeNode) r100;
        if (Intrinsics.areEqual(this.f411460id, r101.f411460id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L15;
        return false;
    L15:
        if (this.feature == r101.feature) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.needShow, r101.needShow) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L24;
        return false;
    L24:
        if (this.badgeNum == r101.badgeNum) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.f411460id.hashCode() * 31) + this.appId.hashCode()) * 31;
        MyOpenAppFeatureType r101 = this.feature;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.needShow;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.updateTime;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.badgeNum) * 31;
        String r111 = this.extra;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return ((r110 + r102) * 31) + this.version.hashCode();
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MyOpenAppBadgeNode(id=" + this.f411460id + ", appId=" + this.appId + ", feature=" + this.feature + ", needShow=" + this.needShow + ", updateTime=" + this.updateTime + ", badgeNum=" + this.badgeNum + ", extra=" + this.extra + ", version=" + this.version + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getBadgeNum() {
        return this.badgeNum;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final MyOpenAppFeatureType getFeature() {
        return this.feature;
    }

    public final String getId() {
        return this.f411460id;
    }

    public final Boolean getNeedShow() {
        return this.needShow;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getVersion() {
        return this.version;
    }

    public MyOpenAppBadgeNode(String r100, String r101, MyOpenAppFeatureType r102, Boolean r103, String r104, int r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r107, "version");
        this.f411460id = r100;
        this.appId = r101;
        this.feature = r102;
        this.needShow = r103;
        this.updateTime = r104;
        this.badgeNum = r105;
        this.extra = r106;
        this.version = r107;
    }
}
