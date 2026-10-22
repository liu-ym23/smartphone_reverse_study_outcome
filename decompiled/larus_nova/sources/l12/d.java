package l12;

import com.facebook.keyframes.model.KFImage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001a¨\u0006'"}, d2 = {"Ll12/d;", "", "", "resultType", "Ljava/lang/Integer;", "getResultType", "()Ljava/lang/Integer;", "Lcom/google/gson/JsonObject;", KFImage.FEATURES_JSON_FIELD, "Lcom/google/gson/JsonObject;", SystemAppletMethod.METHOD_GET_FEATURES, "()Lcom/google/gson/JsonObject;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "sceneExtra", "getSceneExtra", "clientFeature", "getClientFeature", "", "Ll12/c;", "giftListChangeRule", "Ljava/util/List;", "getGiftListChangeRule", "()Ljava/util/List;", "Lcom/google/gson/JsonElement;", "strategyInfo", "getStrategyInfo", "roomLiveScene", "getRoomLiveScene", "Ll12/a;", "eventTrack", "Ll12/a;", "getEventTrack", "()Ll12/a;", "receiverType", "getReceiverType", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("client_feature")
    private final String clientFeature;

    @SerializedName("event_track")
    private final a eventTrack;

    @SerializedName(KFImage.FEATURES_JSON_FIELD)
    private final JsonObject features;

    @SerializedName("gift_list_change_rule")
    private final List<c> giftListChangeRule;

    @SerializedName("receiver_type")
    private final List<Integer> receiverType;

    @SerializedName("result_type")
    private final Integer resultType;

    @SerializedName("room_live_scene")
    private final String roomLiveScene;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("scene_extra")
    private final String sceneExtra;

    @SerializedName("strategy_info")
    private final List<JsonElement> strategyInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L26;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.resultType, r101.resultType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.features, r101.features) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneExtra, r101.sceneExtra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.clientFeature, r101.clientFeature) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.giftListChangeRule, r101.giftListChangeRule) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.strategyInfo, r101.strategyInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.roomLiveScene, r101.roomLiveScene) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.eventTrack, r101.eventTrack) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.receiverType, r101.receiverType) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.resultType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.features;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.scene;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sceneExtra;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.clientFeature;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<c> r116 = this.giftListChangeRule;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<JsonElement> r119 = this.strategyInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.roomLiveScene;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        a r125 = this.eventTrack;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<Integer> r128 = this.receiverType;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftSortMessageModel(resultType=" + this.resultType + ", features=" + this.features + ", scene=" + this.scene + ", sceneExtra=" + this.sceneExtra + ", clientFeature=" + this.clientFeature + ", giftListChangeRule=" + this.giftListChangeRule + ", strategyInfo=" + this.strategyInfo + ", roomLiveScene=" + this.roomLiveScene + ", eventTrack=" + this.eventTrack + ", receiverType=" + this.receiverType + ")";
    }

    public d() {
        this.resultType = null;
        this.features = null;
        this.scene = null;
        this.sceneExtra = null;
        this.clientFeature = null;
        this.giftListChangeRule = null;
        this.strategyInfo = null;
        this.roomLiveScene = null;
        this.eventTrack = null;
        this.receiverType = null;
    }
}
