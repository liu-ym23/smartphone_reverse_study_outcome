package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u008f\u0001\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\t¢\u0006\u0004\b1\u00102J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\f\u001a\u00020\u0007H\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0014R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0014R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0014R*\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0014¨\u00063"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/EffectListPreloadResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "getResponseMessage", "getResponseData", "", "getStatusCode", "", "checkValue", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "getPreloadEffectList", "verifySign", "preloading_effect_id_list", "Ljava/util/List;", "getPreloading_effect_id_list", "()Ljava/util/List;", "data", "getData", "setData", "(Ljava/util/List;)V", "collection", "getCollection", "setCollection", "bind_effects", "getBind_effects", "setBind_effects", "url_prefix", "getUrl_prefix", "setUrl_prefix", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "preloading_model_list", "getPreloading_model_list", "setPreloading_model_list", "Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "arithmetics", "getArithmetics", "setArithmetics", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class EffectListPreloadResponse extends e<EffectListPreloadResponse> {
    private List<? extends ModelInfo> arithmetics;
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private List<? extends Effect> data;
    private String message;
    private final List<String> preloading_effect_id_list;
    private List<String> preloading_model_list;
    private int status_code;
    private List<String> url_prefix;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public EffectListPreloadResponse getResponseData() {
        return this;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        return !this.data.isEmpty();
    }

    public final List<Effect> getPreloadEffectList() {
        ArrayList r100 = new ArrayList();
        List<? extends Effect> r101 = this.data;
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        List<? extends Effect> r102 = this.collection;
        if (r102 == null) goto L8;
        r100.addAll(r102);
    L8:
        List<? extends Effect> r103 = this.bind_effects;
        if (r103 == null) goto L11;
        r100.addAll(r103);
    L11:
        return r100;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        List<? extends Effect> r100 = this.data;
        if (r100 == null) goto L10;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        if (b.a((Effect) r101.next()) == true) goto L6;
        return false;
    L10:
        List<? extends Effect> r102 = this.collection;
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        if (b.a((Effect) r103.next()) == true) goto L14;
        return false;
    L18:
        List<? extends Effect> r104 = this.bind_effects;
        if (r104 == null) goto L26;
        Iterator<T> r105 = r104.iterator();
    L22:
        if (r105.hasNext() == false) goto L37;
        if (b.a((Effect) r105.next()) == true) goto L22;
        return false;
    L37:
        return true;
    L26:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ EffectListPreloadResponse getResponseData() {
        return getResponseData();
    }

    public final List<ModelInfo> getArithmetics() {
        return this.arithmetics;
    }

    public final List<Effect> getBind_effects() {
        return this.bind_effects;
    }

    public final List<Effect> getCollection() {
        return this.collection;
    }

    public final List<Effect> getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<String> getPreloading_effect_id_list() {
        return this.preloading_effect_id_list;
    }

    public final List<String> getPreloading_model_list() {
        return this.preloading_model_list;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public final List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public final void setArithmetics(List<? extends ModelInfo> r100) {
        this.arithmetics = r100;
    }

    public final void setBind_effects(List<? extends Effect> r100) {
        this.bind_effects = r100;
    }

    public final void setCollection(List<? extends Effect> r100) {
        this.collection = r100;
    }

    public final void setData(List<? extends Effect> r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setPreloading_model_list(List<String> r100) {
        this.preloading_model_list = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public final void setUrl_prefix(List<String> r100) {
        this.url_prefix = r100;
    }

    public EffectListPreloadResponse(List<String> r100, List<? extends Effect> r101, List<? extends Effect> r102, List<? extends Effect> r103, List<String> r104, int r105, String r106, List<String> r107, List<? extends ModelInfo> r108) {
        this.preloading_effect_id_list = r100;
        this.data = r101;
        this.collection = r102;
        this.bind_effects = r103;
        this.url_prefix = r104;
        this.status_code = r105;
        this.message = r106;
        this.preloading_model_list = r107;
        this.arithmetics = r108;
    }

    public /* synthetic */ EffectListPreloadResponse(List r110, List r111, List r112, List r113, List r114, int r115, String r116, List r117, List r118, int r119, DefaultConstructorMarker r210) {
        if ((r119 & 2) == 0) goto L5;
        List r100 = new ArrayList();
    L7:
        if ((r119 & 4) == 0) goto L9;
        List r101 = new ArrayList();
    L11:
        if ((r119 & 8) == 0) goto L13;
        List r102 = new ArrayList();
    L15:
        if ((r119 & 16) == 0) goto L17;
        List r103 = new ArrayList();
    L19:
        if ((r119 & 32) == 0) goto L21;
        int r104 = 0;
    L22:
        List r105 = null;
        if ((r119 & 64) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r119 & 128) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r119 & 256) != 0) goto L34;
        r105 = r118;
    L34:
        this(r110, r100, r101, r102, r103, r104, r106, r107, r105);
        return;
    L29:
        r107 = r117;
        goto L31
    L25:
        r106 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
