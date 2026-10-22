package com.bytedance.locallife.groupon.guesslike.data;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u00010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR2\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R*\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R$\u0010*\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/bytedance/locallife/groupon/guesslike/data/GuessLikeNode;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "subType", "getSubType", "setSubType", "updateType", "getUpdateType", "setUpdateType", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "Lcom/bytedance/locallife/groupon/guesslike/data/c;", "style", "Lcom/bytedance/locallife/groupon/guesslike/data/c;", "getStyle", "()Lcom/bytedance/locallife/groupon/guesslike/data/c;", "setStyle", "(Lcom/bytedance/locallife/groupon/guesslike/data/c;)V", "Lcom/bytedance/locallife/groupon/guesslike/data/a;", "config", "Lcom/bytedance/locallife/groupon/guesslike/data/a;", "getConfig", "()Lcom/bytedance/locallife/groupon/guesslike/data/a;", "", ThumbGlideUrl.SOURCE_TEMPLATE, "getTemplate", "setTemplate", "trackParams", "getTrackParams", "transTrackParams", "getTransTrackParams", "rawData", "Ljava/lang/Object;", "getRawData", "()Ljava/lang/Object;", "setRawData", "(Ljava/lang/Object;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class GuessLikeNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Integer f258800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Lazy f258801b;

    @SerializedName("config")
    private final com.bytedance.locallife.groupon.guesslike.data.a config;

    @SerializedName("data")
    private Map<String, Object> data;
    private Object rawData;

    @SerializedName("style")
    private c style;

    @SerializedName("subType")
    private String subType;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private Map<String, String> template;

    @SerializedName("trackParams")
    private final Map<String, Object> trackParams;

    @SerializedName("transTrackParams")
    private final Map<String, Object> transTrackParams;

    @SerializedName("type")
    private String type;

    @SerializedName("updateType")
    private String updateType;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GuessLikeNode) == true) goto L8;
        return false;
    L8:
        GuessLikeNode r101 = (GuessLikeNode) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.updateType, r101.updateType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.transTrackParams, r101.transTrackParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.rawData, r101.rawData) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f258800a, r101.f258800a) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.subType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.updateType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.data;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        c r113 = this.style;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        com.bytedance.locallife.groupon.guesslike.data.a r116 = this.config;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.template;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.trackParams;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, Object> r125 = this.transTrackParams;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Object r128 = this.rawData;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f258800a;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "GuessLikeNode(type=" + this.type + ", subType=" + this.subType + ", updateType=" + this.updateType + ", data=" + this.data + ", style=" + this.style + ", config=" + this.config + ", template=" + this.template + ", trackParams=" + this.trackParams + ", transTrackParams=" + this.transTrackParams + ", rawData=" + this.rawData + ", fromPullType=" + this.f258800a + ')';
    }

    public GuessLikeNode() {
        this.type = null;
        this.subType = null;
        this.updateType = "refresh";
        this.data = null;
        this.style = null;
        this.config = null;
        this.template = null;
        this.trackParams = null;
        this.transTrackParams = null;
        this.rawData = null;
        this.f258800a = null;
        this.f258801b = LazyKt.lazy(GuessLikeNode$runtimeState$2.INSTANCE);
    }

    public final String getType() {
        return this.type;
    }
}
