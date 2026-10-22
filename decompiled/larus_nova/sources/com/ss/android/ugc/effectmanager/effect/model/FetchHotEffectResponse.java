package com.ss.android.ugc.effectmanager.effect.model;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.effect.model.template.FetchHotEffectResponseTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002)*B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001eH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001eH\u0016J\u0016\u0010'\u001a\u00020(2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020%0\u001eH\u0016R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/FetchHotEffectResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchHotEffectResponseTemplate;", "Ljava/io/Serializable;", "kFetchHotModel", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;)V", "value", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "data", "getData", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;)V", "getKFetchHotModel", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "recId", "getRecId", "setRecId", "", "status_code", "getStatus_code", "()I", "setStatus_code", "(I)V", "", "urlPrefix", "getUrlPrefix", "()Ljava/util/List;", "setUrlPrefix", "(Ljava/util/List;)V", "getCollection", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getEffects", "setEffects", "", "Data", "Extra", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class FetchHotEffectResponse extends FetchHotEffectResponseTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse kFetchHotModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/FetchHotEffectResponse$Data;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchHotEffectResponseTemplate$DataTemplate;", "Ljava/io/Serializable;", "kData", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;)V", "value", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "collection", "getCollection", "()Ljava/util/List;", "setCollection", "(Ljava/util/List;)V", KFFeature.EFFECT_JSON_FIELD, "getEffects", "setEffects", "getKData", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "", "recId", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "url_prefix", "getUrl_prefix", "setUrl_prefix", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Data extends FetchHotEffectResponseTemplate.DataTemplate implements Serializable {
        private final transient com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data kData;

        /* JADX WARN: Multi-variable type inference failed */
        public Data() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public List<com.ss.ugc.effectplatform.model.Effect> getCollection() {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getCollection();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getCollection();
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public List<com.ss.ugc.effectplatform.model.Effect> getEffects() {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getEffects();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getEffects();
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public String getRecId() {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            String r101 = r100.getRecId();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getRecId();
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public List<String> getUrl_prefix() {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r100 = getKData();
            if (r100 == null) goto L8;
            List<String> r101 = r100.getUrl_prefix();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getUrl_prefix();
        }

        @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchHotEffectResponseTemplate.DataTemplate
        public com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data getKData() {
            return this.kData;
        }

        public Data(com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r100) {
            super(r100);
            this.kData = r100;
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r101 = getKData();
            if (r101 == null) goto L17;
            List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getCollection();
            if (r102 == null) goto L7;
            super.setCollection(r102);
        L7:
            List<com.ss.ugc.effectplatform.model.Effect> r103 = r101.getEffects();
            if (r103 == null) goto L10;
            super.setEffects(r103);
        L10:
            String r104 = r101.getRecId();
            if (r104 == null) goto L13;
            super.setRecId(r104);
        L13:
            List<String> r105 = r101.getUrl_prefix();
            if (r105 == null) goto L18;
            super.setUrl_prefix(r105);
            return;
        L18:
            return;
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public void setCollection(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setCollection(r100);
        L5:
            super.setCollection(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public void setEffects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setEffects(r100);
        L5:
            super.setEffects(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public void setRecId(String r100) {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setRecId(r100);
        L5:
            super.setRecId(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data
        public void setUrl_prefix(List<String> r100) {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r101 = getKData();
            if (r101 == null) goto L5;
            r101.setUrl_prefix(r100);
        L5:
            super.setUrl_prefix(r100);
        }

        public /* synthetic */ Data(com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/FetchHotEffectResponse$Extra;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchHotEffectResponseTemplate$ExtraTemplate;", "Ljava/io/Serializable;", "kData", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;)V", "getKData", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;", "value", "", "rec_id", "getRec_id", "()Ljava/lang/String;", "setRec_id", "(Ljava/lang/String;)V", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Extra extends FetchHotEffectResponseTemplate.ExtraTemplate implements Serializable {
        private final transient com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra kData;

        /* JADX WARN: Multi-variable type inference failed */
        public Extra() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra
        public String getRec_id() {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra r100 = getKData();
            if (r100 == null) goto L8;
            String r101 = r100.getRec_id();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getRec_id();
        }

        @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchHotEffectResponseTemplate.ExtraTemplate
        public com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra getKData() {
            return this.kData;
        }

        public Extra(com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra r100) {
            super(r100);
            this.kData = r100;
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra r101 = getKData();
            if (r101 == null) goto L8;
            String r102 = r101.getRec_id();
            if (r102 == null) goto L9;
            super.setRec_id(r102);
            return;
        L9:
            return;
        }

        @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra
        public void setRec_id(String r100) {
            com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra r101 = getKData();
            if (r101 == null) goto L5;
            r101.setRec_id(r100);
        L5:
            super.setRec_id(r100);
        }

        public /* synthetic */ Extra(com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Extra r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchHotEffectResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchHotEffectResponseTemplate
    public List<Effect> getCollection() {
        return super.getCollection();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data getData() {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r100 = getKFetchHotModel();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r101 = r100.getData();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getData();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchHotEffectResponseTemplate
    public List<Effect> getEffects() {
        return super.getEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public String getMessage() {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r100 = getKFetchHotModel();
        if (r100 == null) goto L8;
        String r101 = r100.getMessage();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMessage();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public String getRecId() {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r100 = getKFetchHotModel();
        if (r100 == null) goto L8;
        String r101 = r100.getRecId();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRecId();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public int getStatus_code() {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r100 = getKFetchHotModel();
        if (r100 == null) goto L6;
        return r100.getStatus_code();
    L6:
        return super.getStatus_code();
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public List<String> getUrlPrefix() {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r100 = getKFetchHotModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrlPrefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrlPrefix();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchHotEffectResponseTemplate
    public com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse getKFetchHotModel() {
        return this.kFetchHotModel;
    }

    public FetchHotEffectResponse(com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r100) {
        super(r100);
        this.kFetchHotModel = r100;
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r101 = getKFetchHotModel();
        if (r101 == null) goto L23;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getCollection_list();
        if (r102 == null) goto L7;
        super.setCollection_list(r102);
    L7:
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r103 = r101.getData();
        if (r103 == null) goto L10;
        super.setData(r103);
    L10:
        List<com.ss.ugc.effectplatform.model.Effect> r104 = r101.getEffect_list();
        if (r104 == null) goto L13;
        super.setEffect_list(r104);
    L13:
        super.setFromCache(r101.isFromCache());
        String r105 = r101.getMessage();
        if (r105 == null) goto L16;
        super.setMessage(r105);
    L16:
        String r106 = r101.getRecId();
        if (r106 == null) goto L19;
        super.setRecId(r106);
    L19:
        super.setStatus_code(r101.getStatus_code());
        List<String> r107 = r101.getUrlPrefix();
        if (r107 == null) goto L24;
        super.setUrlPrefix(r107);
        return;
    L24:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public void setData(com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse.Data r100) {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r101 = getKFetchHotModel();
        if (r101 == null) goto L5;
        r101.setData(r100);
    L5:
        super.setData(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.FetchHotEffectResponseTemplate
    public void setEffects(List<? extends Effect> r100) {
        super.setEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public void setMessage(String r100) {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r101 = getKFetchHotModel();
        if (r101 == null) goto L5;
        r101.setMessage(r100);
    L5:
        super.setMessage(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public void setRecId(String r100) {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r101 = getKFetchHotModel();
        if (r101 == null) goto L5;
        r101.setRecId(r100);
    L5:
        super.setRecId(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public void setStatus_code(int r100) {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r101 = getKFetchHotModel();
        if (r101 == null) goto L5;
        r101.setStatus_code(r100);
    L5:
        super.setStatus_code(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse
    public void setUrlPrefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r101 = getKFetchHotModel();
        if (r101 == null) goto L5;
        r101.setUrlPrefix(r100);
    L5:
        super.setUrlPrefix(r100);
    }

    public /* synthetic */ FetchHotEffectResponse(com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
