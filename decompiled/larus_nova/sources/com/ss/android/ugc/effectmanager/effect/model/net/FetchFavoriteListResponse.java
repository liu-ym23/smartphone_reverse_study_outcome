package com.ss.android.ugc.effectmanager.effect.model.net;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate;
import com.ss.ugc.effectplatform.model.Effect;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0016J\u0016\u0010\"\u001a\u00020#2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/net/FetchFavoriteListResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchFavoriteListResponseTemplate;", "Ljava/io/Serializable;", "kFavoriteModel", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;", "(Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;)V", "value", "", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "data", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getKFavoriteModel", "()Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "", "status_code", "getStatus_code", "()I", "setStatus_code", "(I)V", "getBindEffects", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getCollectEffects", "getEffects", "getType", "getUrlPrefix", "setEffects", "", "Data", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class FetchFavoriteListResponse extends FetchFavoriteListResponseTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse kFavoriteModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR0\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/net/FetchFavoriteListResponse$Data;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchFavoriteListResponseTemplate$DataTemplate;", "Ljava/io/Serializable;", "kData", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "(Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;)V", "value", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "bind_effects", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "collection", "getCollection", "setCollection", KFFeature.EFFECT_JSON_FIELD, "getEffects", "setEffects", "getKData", "()Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "", "type", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "url_prefix", "getUrl_prefix", "setUrl_prefix", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Data extends FetchFavoriteListResponseTemplate.DataTemplate implements Serializable {
        private final transient com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data kData;

        /* JADX WARN: Multi-variable type inference failed */
        public Data() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public List<Effect> getBind_effects() {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            List<Effect> r101 = r100.getBind_effects();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getBind_effects();
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public List<Effect> getCollection() {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            List<Effect> r101 = r100.getCollection();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getCollection();
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public List<Effect> getEffects() {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            List<Effect> r101 = r100.getEffects();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getEffects();
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public String getType() {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            String r101 = r100.getType();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getType();
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public List<String> getUrl_prefix() {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            List<String> r101 = r100.getUrl_prefix();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getUrl_prefix();
        }

        @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate.DataTemplate
        public com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data getKData() {
            return this.kData;
        }

        public Data(com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r100) {
            super(r100);
            this.kData = r100;
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r101 = getKData();
            if (r101 == null) goto L20;
            List<Effect> r102 = r101.getBind_effects();
            if (r102 == null) goto L7;
            super.setBind_effects(r102);
        L7:
            List<Effect> r103 = r101.getCollection();
            if (r103 == null) goto L10;
            super.setCollection(r103);
        L10:
            List<Effect> r104 = r101.getEffects();
            if (r104 == null) goto L13;
            super.setEffects(r104);
        L13:
            String r105 = r101.getType();
            if (r105 == null) goto L16;
            super.setType(r105);
        L16:
            List<String> r106 = r101.getUrl_prefix();
            if (r106 == null) goto L21;
            super.setUrl_prefix(r106);
            return;
        L21:
            return;
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public void setBind_effects(List<? extends Effect> r100) {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setBind_effects(r100);
        L5:
            super.setBind_effects(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public void setCollection(List<? extends Effect> r100) {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setCollection(r100);
        L5:
            super.setCollection(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public void setEffects(List<? extends Effect> r100) {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setEffects(r100);
        L5:
            super.setEffects(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public void setType(String r100) {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setType(r100);
        L5:
            super.setType(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data
        public void setUrl_prefix(List<String> r100) {
            com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setUrl_prefix(r100);
        L5:
            super.setUrl_prefix(r100);
        }

        public /* synthetic */ Data(com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchFavoriteListResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate
    public List<com.ss.android.ugc.effectmanager.effect.model.Effect> getBindEffects() {
        return super.getBindEffects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate
    public List<com.ss.android.ugc.effectmanager.effect.model.Effect> getCollectEffects() {
        return super.getCollectEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse
    public List<com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data> getData() {
        com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data> r101 = r100.getData();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getData();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate
    public List<com.ss.android.ugc.effectmanager.effect.model.Effect> getEffects() {
        return super.getEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse
    public String getMessage() {
        com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L8;
        String r101 = r100.getMessage();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse
    public int getStatus_code() {
        com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L6;
        return r100.getStatus_code();
    L6:
        return super.getStatus_code();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate
    public String getType() {
        return super.getType();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate
    public List<String> getUrlPrefix() {
        return super.getUrlPrefix();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate
    public com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse getKFavoriteModel() {
        return this.kFavoriteModel;
    }

    public FetchFavoriteListResponse(com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r100) {
        super(r100);
        this.kFavoriteModel = r100;
        com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r101 = getKFavoriteModel();
        if (r101 == null) goto L18;
        List<Effect> r102 = r101.getCollection_effects();
        if (r102 == null) goto L7;
        super.setCollection_effects(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data> r103 = r101.getData();
        if (r103 == null) goto L10;
        super.setData(r103);
    L10:
        List<Effect> r104 = r101.getEffect_list();
        if (r104 == null) goto L13;
        super.setEffect_list(r104);
    L13:
        String r105 = r101.getMessage();
        if (r105 == null) goto L16;
        super.setMessage(r105);
    L16:
        super.setStatus_code(r101.getStatus_code());
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse
    public void setData(List<? extends com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse.Data> r100) {
        com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r101 = getKFavoriteModel();
        if (r101 == null) goto L5;
        r101.setData(r100);
    L5:
        super.setData(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchFavoriteListResponseTemplate
    public void setEffects(List<? extends com.ss.android.ugc.effectmanager.effect.model.Effect> r100) {
        super.setEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse
    public void setMessage(String r100) {
        com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r101 = getKFavoriteModel();
        if (r101 == null) goto L5;
        r101.setMessage(r100);
    L5:
        super.setMessage(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse
    public void setStatus_code(int r100) {
        com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r101 = getKFavoriteModel();
        if (r101 == null) goto L5;
        r101.setStatus_code(r100);
    L5:
        super.setStatus_code(r100);
    }

    public /* synthetic */ FetchFavoriteListResponse(com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
