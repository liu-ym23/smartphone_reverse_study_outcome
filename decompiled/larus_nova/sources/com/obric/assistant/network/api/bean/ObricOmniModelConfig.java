package com.obric.assistant.network.api.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vea.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0003J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0003J}\u0010\u001f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\tHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006&"}, d2 = {"Lcom/obric/assistant/network/api/bean/ObricOmniModelConfig;", "", "models", "", "Lcom/obric/assistant/network/api/bean/ObricOmniModel;", "defaultModel", "Lcom/obric/assistant/network/api/bean/ObricOmniModelItemIndex;", "supportModels", "omniTaskTagText", "", "modelMap", "", "modeMap", "<init>", "(Ljava/util/List;Lcom/obric/assistant/network/api/bean/ObricOmniModelItemIndex;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getModels", "()Ljava/util/List;", "getDefaultModel", "()Lcom/obric/assistant/network/api/bean/ObricOmniModelItemIndex;", "getSupportModels", "getOmniTaskTagText", "()Ljava/lang/String;", "getModelMap", "()Ljava/util/Map;", "getModeMap", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOmniModelConfig {

    @SerializedName("default_model")
    private final k defaultModel;

    @SerializedName("mode_map")
    private final Map<String, String> modeMap;

    @SerializedName("model_map")
    private final Map<String, String> modelMap;

    @SerializedName("models")
    private final List<ObricOmniModel> models;

    @SerializedName("omni_task_tag_text")
    private final String omniTaskTagText;

    @SerializedName("support_models")
    private final List<k> supportModels;

    public ObricOmniModelConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricOmniModelConfig copy$default(ObricOmniModelConfig r100, List r101, k r102, List r103, String r104, Map r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.models;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.defaultModel;
    L8:
        k r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.supportModels;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.omniTaskTagText;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.modelMap;
    L17:
        Map r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.modeMap;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final List<ObricOmniModel> component1() {
        return this.models;
    }

    public final k component2() {
        return this.defaultModel;
    }

    public final List<k> component3() {
        return this.supportModels;
    }

    public final String component4() {
        return this.omniTaskTagText;
    }

    public final Map<String, String> component5() {
        return this.modelMap;
    }

    public final Map<String, String> component6() {
        return this.modeMap;
    }

    public final ObricOmniModelConfig copy(List<ObricOmniModel> r100, k r110, List<k> r111, String r112, Map<String, String> r113, Map<String, String> r114) {
        return new ObricOmniModelConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricOmniModelConfig) == true) goto L8;
        return false;
    L8:
        ObricOmniModelConfig r101 = (ObricOmniModelConfig) r100;
        if (Intrinsics.areEqual(this.models, r101.models) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultModel, r101.defaultModel) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.supportModels, r101.supportModels) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.omniTaskTagText, r101.omniTaskTagText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.modelMap, r101.modelMap) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.modeMap, r101.modeMap) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        List<ObricOmniModel> r100 = this.models;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        k r104 = this.defaultModel;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<k> r107 = this.supportModels;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.omniTaskTagText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.modelMap;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.modeMap;
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

    public String toString() {
        return "ObricOmniModelConfig(models=" + this.models + ", defaultModel=" + this.defaultModel + ", supportModels=" + this.supportModels + ", omniTaskTagText=" + this.omniTaskTagText + ", modelMap=" + this.modelMap + ", modeMap=" + this.modeMap + ')';
    }

    public final k getDefaultModel() {
        return this.defaultModel;
    }

    public final Map<String, String> getModeMap() {
        return this.modeMap;
    }

    public final Map<String, String> getModelMap() {
        return this.modelMap;
    }

    public final List<ObricOmniModel> getModels() {
        return this.models;
    }

    public final String getOmniTaskTagText() {
        return this.omniTaskTagText;
    }

    public final List<k> getSupportModels() {
        return this.supportModels;
    }

    public ObricOmniModelConfig(List<ObricOmniModel> r100, k r101, List<k> r102, String r103, Map<String, String> r104, Map<String, String> r105) {
        this.models = r100;
        this.defaultModel = r101;
        this.supportModels = r102;
        this.omniTaskTagText = r103;
        this.modelMap = r104;
        this.modeMap = r105;
    }

    public /* synthetic */ ObricOmniModelConfig(List r100, k r101, List r102, String r103, Map r110, Map r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        List r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        k r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        List r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Map r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Map r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
