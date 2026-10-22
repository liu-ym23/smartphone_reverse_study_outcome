package tm6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001a\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001a\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b¨\u0006\u001e"}, d2 = {"Ltm6/a;", "", "", "appId", "Ljava/lang/Integer;", "getAppId", "()Ljava/lang/Integer;", "", "lifesdkAppVersion", "Ljava/lang/String;", "getLifesdkAppVersion", "()Ljava/lang/String;", "lifeClientVersion", "I", "getLifeClientVersion", "()I", "lifeSaasSdkVersion", "getLifeSaasSdkVersion", "lifesdkIsomorphicSaasVersion", "getLifesdkIsomorphicSaasVersion", "devicePlatform", "getDevicePlatform", "appVersion", "getAppVersion", "deviceId", "getDeviceId", "channel", "getChannel", "bulletVersion", "getBulletVersion", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("app_id")
    private final Integer appId;

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("bullet_version")
    private final String bulletVersion;

    @SerializedName("channel")
    private final String channel;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("device_platform")
    private final String devicePlatform;

    @SerializedName("life_client_version")
    private final int lifeClientVersion;

    @SerializedName("life_saas_sdk_version")
    private final String lifeSaasSdkVersion;

    @SerializedName("lifesdk_app_version")
    private final String lifesdkAppVersion;

    @SerializedName("lifesdk_isomorphic_saas_version")
    private final String lifesdkIsomorphicSaasVersion;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lifesdkAppVersion, r101.lifesdkAppVersion) == true) goto L15;
        return false;
    L15:
        if (this.lifeClientVersion == r101.lifeClientVersion) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lifeSaasSdkVersion, r101.lifeSaasSdkVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lifesdkIsomorphicSaasVersion, r101.lifesdkIsomorphicSaasVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.devicePlatform, r101.devicePlatform) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bulletVersion, r101.bulletVersion) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.appId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.lifesdkAppVersion.hashCode()) * 31) + this.lifeClientVersion) * 31;
        String r104 = this.lifeSaasSdkVersion;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lifesdkIsomorphicSaasVersion;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((((((((((r106 + r101) * 31) + this.devicePlatform.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.bulletVersion.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DolphinParamsJson(appId=" + this.appId + ", lifesdkAppVersion=" + this.lifesdkAppVersion + ", lifeClientVersion=" + this.lifeClientVersion + ", lifeSaasSdkVersion=" + this.lifeSaasSdkVersion + ", lifesdkIsomorphicSaasVersion=" + this.lifesdkIsomorphicSaasVersion + ", devicePlatform=" + this.devicePlatform + ", appVersion=" + this.appVersion + ", deviceId=" + this.deviceId + ", channel=" + this.channel + ", bulletVersion=" + this.bulletVersion + ')';
    }

    public a(int r110) {
        Integer r111 = Integer.valueOf(HostServiceUtilsKt.E().getAppId());
        zt6.a r100 = HostServiceUtilsKt.c0();
        if (r100 == null) goto L5;
        r100.j();
        long r101 = 11100;
    L6:
        String r102 = String.valueOf(r101);
        int r103 = CastIntegerProtector.parseInt("390200");
        String r104 = HostServiceUtilsKt.E().getAppVersion();
        String r105 = HostServiceUtilsKt.E().getDeviceId();
        String r106 = HostServiceUtilsKt.E().getChannel();
        Intrinsics.checkNotNullParameter(r102, "lifesdkAppVersion");
        Intrinsics.checkNotNullParameter("android", "devicePlatform");
        Intrinsics.checkNotNullParameter(r104, "appVersion");
        Intrinsics.checkNotNullParameter(r105, "deviceId");
        Intrinsics.checkNotNullParameter(r106, "channel");
        Intrinsics.checkNotNullParameter("9.0.0", "bulletVersion");
        this.appId = r111;
        this.lifesdkAppVersion = r102;
        this.lifeClientVersion = r103;
        this.lifeSaasSdkVersion = "390200";
        this.lifesdkIsomorphicSaasVersion = "39.2.0";
        this.devicePlatform = "android";
        this.appVersion = r104;
        this.deviceId = r105;
        this.channel = r106;
        this.bulletVersion = "9.0.0";
        return;
    L5:
        r101 = 0;
        goto L6
    }
}
