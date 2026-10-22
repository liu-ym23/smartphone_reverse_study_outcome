package com.bytedance.pia.core.setting;

import android.net.Uri;
import com.amap.api.col.s.ce;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.j;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.facebook.keyframes.model.KFImage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/pia/core/setting/Config;", "", "", "", "expectedFeatures", "Ljava/util/Set;", "d", "()Ljava/util/Set;", "version", "Ljava/lang/String;", "f", "()Ljava/lang/String;", SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING, "e", "", "isFromMock", "Z", ce.f26391f, "()Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class Config {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Config f266282c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Config f266283d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GsonUtils.Exclude
    public final Lazy f266284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GsonUtils.Exclude
    public Set<String> f266285b;

    @SerializedName(KFImage.FEATURES_JSON_FIELD)
    private final Set<String> expectedFeatures;

    @SerializedName("isMocked")
    private final boolean isFromMock;

    @SerializedName(SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING)
    private final String streaming;

    @SerializedName("version")
    private final String version;

    public static final class a {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Config() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Set r100 = null;
        Object[] r101 = 0 == true ? 1 : 0;
        f266282c = new Config(r100, r101, 15);
        Object[] r102 = 0 == true ? 1 : 0;
        f266283d = new Config(SetsKt.setOf(new String[]{ErrorType.PREFETCH, "nsr", "snapshot", "cache", SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING, "preload"}), r102, 14);
    }

    public final Config a() {
        Config r100 = new Config(CollectionsKt.toMutableSet(this.expectedFeatures), this.version, this.streaming, this.isFromMock);
        Set<String> r101 = this.f266285b;
        if (r101 == null) goto L5;
        Set<String> r102 = CollectionsKt.toMutableSet(r101);
    L6:
        r100.f266285b = r102;
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public final Set<String> b() {
        Set<String> r100 = this.f266285b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L13;
        Set r102 = (Set) this.f266284a.getValue();
        Set<String> r103 = this.f266285b;
        Intrinsics.checkNotNull(r103);
        return SetsKt.minus(r102, r103);
    L13:
        return (Set) this.f266284a.getValue();
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean h() {
        if (this.version.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        return b().contains("nsr");
    }

    public final boolean j() {
        return b().contains("snapshot");
    }

    public final boolean k() {
        if (b().contains(SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING) == true) goto L5;
        return false;
    L5:
        if (this.streaming.length() <= 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(GsonUtils.b(), this);
    }

    public final Set<String> d() {
        return this.expectedFeatures;
    }

    public final String e() {
        return this.streaming;
    }

    public final String f() {
        return this.version;
    }

    public final boolean g() {
        return this.isFromMock;
    }

    @JvmStatic
    public static final Config c(Uri r110) {
        String r100 = null;
        if (r110 == null) goto L72;
        boolean r101 = false;
        if (r110.getBooleanQueryParameter("_pia_", false) == false) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L15;
        Lazy<Settings> r103 = Settings.f266286f;
        if (Settings.f266288h == true) goto L15;
        return f266283d;
    L15:
        Config r104 = com.bytedance.pia.core.setting.a.f266295a.b(r110);
        if (r104 != null) goto L68;
        g.f266303a.getClass();
        long r105 = System.currentTimeMillis();
        if (r110.getBooleanQueryParameter("_pia_", false) == false) goto L73;
        String r106 = j.g(r110, null);
        int r107 = 14;
        if (CollectionsKt.contains(g.f266314l, r106) == true) goto L69;
        Keva r108 = g.f266304b;
        if (r108 != null) goto L28;
        return null;
    L28:
        if (r108.contains(r106) == false) goto L75;
        Keva r109 = g.f266304b;
        if (r109 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("settings");
        r109 = null;
    L33:
        String r111 = "";
        String r112 = r109.getString(r106, "");
        if (r112 != null) goto L36;
    L37:
        r101 = true;
    L38:
        if (r101 == true) goto L76;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L59
        JsonObject r114 = GsonUtils.f266372c.parse(r112).getAsJsonObject();     // Catch: Throwable -> L59
        Set r115 = (Set) GsonUtils.b().fromJson(r114.get(KFImage.FEATURES_JSON_FIELD), Set.class);     // Catch: Throwable -> L59
        String r116 = r114.get("version").getAsString();     // Catch: Throwable -> L59
        String r117 = g.f266313k;     // Catch: Throwable -> L59
        if (r117 != null) goto L43;
    L45:
        JsonElement r118 = r114.get("manifestVersion");     // Catch: Throwable -> L59
        if (r118 != null) goto L48;
        String r119 = null;
    L54:
        if (r119 == null) goto L57;
        r111 = r119;
    L57:
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");     // Catch: Throwable -> L59
        Object r120 = Result.m9449constructorimpl(new Config(r115, r111, 12));     // Catch: Throwable -> L59
    L62:
        if (Result.m9452exceptionOrNullimpl(r120) != null) goto L71;
        Config r121 = (Config) r120;
        com.bytedance.pia.core.utils.d.l("[PIASettings] Finish create setting. Cost Time: " + (System.currentTimeMillis() - r105) + ". (URL: " + r110 + ", pageSetting: " + r121 + ')', null, 14);
        return r121;
    L71:
        return null;
    L48:
        if (r118.isJsonPrimitive() == true) goto L50;
    L52:
        r119 = "";
        goto L54
    L50:
        if (r118.getAsJsonPrimitive().isString() == false) goto L52;
        r119 = r118.getAsString();     // Catch: Throwable -> L59
        goto L54
    L43:
        if (Intrinsics.areEqual(r117, r116) == true) goto L45;
        return null;
    L59:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L62
    L76:
        return null;
    L36:
        if (r112.length() != 0) goto L38;
    L75:
        return null;
    L69:
        return new Config(SetsKt.setOf(new String[]{"nsr", ErrorType.PREFETCH, "snapshot", "cache"}), r100, r107);
    L73:
        return null;
    L68:
        return r104;
    L8:
        if (r110.getBooleanQueryParameter("__pia_manifest__", false) == false) goto L10;
        r102 = true;
        goto L11
    L72:
        return null;
    }

    public /* synthetic */ Config(Set r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = SetsKt.emptySet();
    L5:
        String r103 = "";
        if ((r102 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r102 & 4) != 0) goto L12;
        r103 = null;
    L12:
        this(r100, r101, r103, false);
    }

    public Config(Set<String> r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "expectedFeatures");
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING);
        this.expectedFeatures = r100;
        this.version = r101;
        this.streaming = r102;
        this.isFromMock = r103;
        this.f266284a = LazyKt.lazy(new Config$enabledFeatures$2(this));
    }
}
