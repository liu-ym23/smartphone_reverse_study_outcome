package com.ss.ugc.effectplatform.model.net;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFFeature;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001(B-\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R0\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u0006)"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "checkValue", "", "getStatusCode", "verifySign", "", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "value", "getEffect_list", "setEffect_list", "effect_list", "getCollection_effects", "setCollection_effects", "collection_effects", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "Data", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class FetchFavoriteListResponse extends e<FetchFavoriteListResponse> {
    private List<? extends Data> data;
    private String message;
    private int status_code;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0017\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\nR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "", "type", "", KFFeature.EFFECT_JSON_FIELD, "", "Lcom/ss/ugc/effectplatform/model/Effect;", "collection", "bind_effects", "url_prefix", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "getCollection", "setCollection", "getEffects", "setEffects", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getUrl_prefix", "setUrl_prefix", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
    public static class Data {
        private List<? extends Effect> bind_effects;
        private List<? extends Effect> collection;
        private List<? extends Effect> effects;
        private String type;
        private List<String> url_prefix;

        public Data() {
            this(null, null, null, null, null, 31, null);
        }

        public List<Effect> getBind_effects() {
            return this.bind_effects;
        }

        public List<Effect> getCollection() {
            return this.collection;
        }

        public List<Effect> getEffects() {
            return this.effects;
        }

        public String getType() {
            return this.type;
        }

        public List<String> getUrl_prefix() {
            return this.url_prefix;
        }

        public void setBind_effects(List<? extends Effect> r100) {
            this.bind_effects = r100;
        }

        public void setCollection(List<? extends Effect> r100) {
            this.collection = r100;
        }

        public void setEffects(List<? extends Effect> r100) {
            this.effects = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }

        public void setUrl_prefix(List<String> r100) {
            this.url_prefix = r100;
        }

        public Data(String r100, List<? extends Effect> r101, List<? extends Effect> r102, List<? extends Effect> r103, List<String> r104) {
            this.type = r100;
            this.effects = r101;
            this.collection = r102;
            this.bind_effects = r103;
            this.url_prefix = r104;
        }

        public /* synthetic */ Data(String r100, List r101, List r102, List r103, List r104, int r105, DefaultConstructorMarker r110) {
            if ((r105 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r105 & 2) == 0) goto L8;
            r101 = new ArrayList();
        L8:
            List r111 = r101;
            if ((r105 & 4) == 0) goto L11;
            r102 = new ArrayList();
        L11:
            List r106 = r102;
            if ((r105 & 8) == 0) goto L14;
            r103 = new ArrayList();
        L14:
            List r107 = r103;
            if ((r105 & 16) == 0) goto L17;
            r104 = new ArrayList();
        L17:
            String r108 = r100;
            this(r108, r111, r106, r107, r104);
        }
    }

    public FetchFavoriteListResponse() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public FetchFavoriteListResponse getResponseData() {
        return this;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        List<Data> r100 = getData();
        if (r100 != null) goto L5;
        return false;
    L5:
        return !r100.isEmpty();
    }

    public final List<Effect> getCollection_effects() {
        List<Data> r100 = getData();
        if (r100 == null) goto L7;
        return ((Data) ListProtector.get(r100, 0)).getCollection();
    L7:
        return new ArrayList();
    }

    public final List<Effect> getEffect_list() {
        List<Data> r100 = getData();
        if (r100 == null) goto L7;
        return ((Data) ListProtector.get(r100, 0)).getEffects();
    L7:
        return new ArrayList();
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ FetchFavoriteListResponse getResponseData() {
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

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        List<Data> r100 = getData();
        if (r100 == null) goto L31;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L46;
        Data r102 = (Data) r101.next();
        List<Effect> r103 = r102.getBind_effects();
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        if (b.a((Effect) r104.next()) == true) goto L11;
        return false;
    L15:
        List<Effect> r105 = r102.getEffects();
        if (r105 == null) goto L23;
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        if (b.a((Effect) r106.next()) == true) goto L19;
        return false;
    L23:
        List<Effect> r107 = r102.getCollection();
        if (r107 == null) goto L6;
        Iterator<T> r108 = r107.iterator();
    L27:
        if (r108.hasNext() == false) goto L6;
        if (b.a((Effect) r108.next()) == true) goto L27;
        return false;
    L46:
        return true;
    L31:
        return true;
    }

    public List<Data> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public final void setCollection_effects(List<? extends Effect> r110) {
        List<Data> r100 = getData();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        setData(CollectionsKt.arrayListOf(new Data[]{new Data(null, null, null, null, null, 31, null)}));
    L11:
        ((Data) ListProtector.get(getData(), 0)).setCollection(r110);
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public void setData(List<? extends Data> r100) {
        this.data = r100;
    }

    public final void setEffect_list(List<? extends Effect> r110) {
        List<Data> r100 = getData();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        setData(CollectionsKt.arrayListOf(new Data[]{new Data(null, null, null, null, null, 31, null)}));
    L11:
        ((Data) ListProtector.get(getData(), 0)).setEffects(r110);
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public FetchFavoriteListResponse(List<? extends Data> r100, String r101, int r102) {
        this.data = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ FetchFavoriteListResponse(List r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
