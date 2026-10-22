package com.ss.ugc.effectplatform.model.net;

import com.facebook.keyframes.model.KFFeature;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u000256B'\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010)\u001a\b\u0012\u0004\u0012\u00020#0\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010,\u001a\b\u0012\u0004\u0012\u00020#0\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R(\u0010/\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR0\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\"8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(¨\u00067"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "checkValue", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "verifySign", "isFromCache", "Z", "()Z", "setFromCache", "(Z)V", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "data", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;)V", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "value", "getCollection_list", "()Ljava/util/List;", "setCollection_list", "(Ljava/util/List;)V", "collection_list", "getEffect_list", "setEffect_list", "effect_list", "getRecId", "setRecId", "recId", "getUrlPrefix", "setUrlPrefix", "urlPrefix", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;Ljava/lang/String;I)V", "Data", "Extra", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class FetchHotEffectResponse extends e<FetchHotEffectResponse> {
    private Data data;
    private boolean isFromCache;
    private String message;
    private int status_code;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "", "category_effects", "Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "extra", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;", "url_prefix", "", "", "(Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;Ljava/util/List;)V", "value", "Lcom/ss/ugc/effectplatform/model/Effect;", "collection", "getCollection", "()Ljava/util/List;", "setCollection", "(Ljava/util/List;)V", KFFeature.EFFECT_JSON_FIELD, "getEffects", "setEffects", "recId", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "getUrl_prefix", "setUrl_prefix", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
    public static class Data {
        private final CategoryEffectModel category_effects;
        private final Extra extra;
        private List<String> url_prefix;

        public Data() {
            this(null, null, null, 7, null);
        }

        public List<Effect> getCollection() {
            return this.category_effects.getCollection();
        }

        public List<Effect> getEffects() {
            return this.category_effects.getCategory_effects();
        }

        public String getRecId() {
            Extra r100 = this.extra;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getRec_id();
        }

        public List<String> getUrl_prefix() {
            return this.url_prefix;
        }

        public void setCollection(List<? extends Effect> r100) {
            this.category_effects.setCollection(r100);
        }

        public void setEffects(List<? extends Effect> r100) {
            this.category_effects.setCategory_effects(r100);
        }

        public void setRecId(String r100) {
            Extra r101 = this.extra;
            if (r101 == null) goto L6;
            r101.setRec_id(r100);
            return;
        }

        public void setUrl_prefix(List<String> r100) {
            this.url_prefix = r100;
        }

        public Data(CategoryEffectModel r100, Extra r101, List<String> r102) {
            this.category_effects = r100;
            this.extra = r101;
            this.url_prefix = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Data(CategoryEffectModel r110, Extra r111, List r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 1) == 0) goto L5;
            CategoryEffectModel r100 = new CategoryEffectModel(null, null, false, 0, 0, null, null, null, 255, null);
        L7:
            if ((r113 & 2) == 0) goto L9;
            Extra r101 = new Extra(null, 1, 0 == true ? 1 : 0);
        L11:
            if ((r113 & 4) == 0) goto L13;
            List r102 = new ArrayList();
        L14:
            this(r100, r101, r102);
            return;
        L13:
            r102 = r112;
            goto L14
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;", "", "rec_id", "", "(Ljava/lang/String;)V", "getRec_id", "()Ljava/lang/String;", "setRec_id", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
    public static class Extra {
        private String rec_id;

        /* JADX WARN: Multi-variable type inference failed */
        public Extra() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public String getRec_id() {
            return this.rec_id;
        }

        public Extra(String r100) {
            this.rec_id = r100;
        }

        public void setRec_id(String r100) {
            this.rec_id = r100;
        }

        public /* synthetic */ Extra(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    public FetchHotEffectResponse() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public FetchHotEffectResponse getResponseData() {
        return this;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        List<Effect> r100 = getEffect_list();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r100.isEmpty()) == false) goto L7;
        return true;
    }

    public final List<Effect> getCollection_list() {
        return getData().getCollection();
    }

    public final List<Effect> getEffect_list() {
        return getData().getEffects();
    }

    public String getRecId() {
        Data r100 = getData();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRecId();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ FetchHotEffectResponse getResponseData() {
        return getResponseData();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return getStatus_code();
    }

    public List<String> getUrlPrefix() {
        return getData().getUrl_prefix();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        Data r100 = getData();
        if (r100 == null) goto L12;
        List<Effect> r101 = r100.getCollection();
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        if (b.a((Effect) r102.next()) == true) goto L8;
        return false;
    L12:
        Data r103 = getData();
        if (r103 == null) goto L22;
        List<Effect> r104 = r103.getEffects();
        if (r104 == null) goto L30;
        Iterator<T> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L31;
        if (b.a((Effect) r105.next()) == true) goto L18;
        return false;
    L31:
        return true;
    L30:
        return true;
    L22:
        return true;
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public final boolean isFromCache() {
        return this.isFromCache;
    }

    public final void setCollection_list(List<? extends Effect> r100) {
        getData().setCollection(r100);
    }

    public void setData(Data r100) {
        this.data = r100;
    }

    public final void setEffect_list(List<? extends Effect> r100) {
        getData().setEffects(r100);
    }

    public final void setFromCache(boolean r100) {
        this.isFromCache = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setRecId(String r100) {
        Data r101 = getData();
        if (r101 == null) goto L6;
        r101.setRecId(r100);
        return;
    }

    public void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public void setUrlPrefix(List<String> r100) {
        Data r101 = getData();
        if (r101 == null) goto L6;
        r101.setUrl_prefix(r100);
        return;
    }

    public FetchHotEffectResponse(Data r100, String r101, int r102) {
        this.data = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ FetchHotEffectResponse(Data r100, String r101, int r102, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = new Data(null, null, null, 7, null);
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
