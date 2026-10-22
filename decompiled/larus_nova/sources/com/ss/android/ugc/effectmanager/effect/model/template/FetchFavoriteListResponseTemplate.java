package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchFavoriteListResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;", "kFavoriteModel", "(Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;)V", "getKFavoriteModel", "()Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;", "getBindEffects", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getCollectEffects", "getEffects", "getType", "", "getUrlPrefix", "setEffects", "", "value", "DataTemplate", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class FetchFavoriteListResponseTemplate extends FetchFavoriteListResponse {
    private final transient FetchFavoriteListResponse kFavoriteModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchFavoriteListResponseTemplate$DataTemplate;", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "kData", "(Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;)V", "getKData", "()Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse$Data;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static class DataTemplate extends FetchFavoriteListResponse.Data {
        private final transient FetchFavoriteListResponse.Data kData;

        /* JADX WARN: Multi-variable type inference failed */
        public DataTemplate() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public FetchFavoriteListResponse.Data getKData() {
            return this.kData;
        }

        public DataTemplate(FetchFavoriteListResponse.Data r100) {
            super(null, null, null, null, null, 31, null);
            this.kData = r100;
        }

        public /* synthetic */ DataTemplate(FetchFavoriteListResponse.Data r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchFavoriteListResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<Effect> getBindEffects() {
        FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L12;
        List<FetchFavoriteListResponse.Data> r101 = r100.getData();
        if (r101 == null) goto L12;
        FetchFavoriteListResponse.Data r102 = (FetchFavoriteListResponse.Data) ListProtector.get(r101, 0);
        if (r102 == null) goto L12;
        List r103 = r102.getBind_effects();
        List r104 = r103;
        if (r103 == null) goto L12;
    L15:
        if (r104 == null) goto L36;
        if ((!r104.isEmpty()) == false) goto L36;
        if ((ListProtector.get(r104, 0) instanceof Effect) == true) goto L39;
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L23:
        if (r107.hasNext() == false) goto L25;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L23
    L25:
        if (r100 == null) goto L32;
        List<FetchFavoriteListResponse.Data> r108 = r100.getData();
        if (r108 == null) goto L32;
        FetchFavoriteListResponse.Data r109 = (FetchFavoriteListResponse.Data) ListProtector.get(r108, 0);
        if (r109 == null) goto L32;
        r109.setBind_effects(r106);
    L32:
        if ((!super.getData().isEmpty()) == false) goto L38;
        ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).setBind_effects(r106);
    L38:
        return r106;
    L39:
        return r104;
    L36:
        return new ArrayList();
    L12:
        if ((!super.getData().isEmpty()) == false) goto L14;
        r104 = ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).getBind_effects();
        goto L15
    L14:
        r104 = null;
        goto L15
    }

    public List<Effect> getCollectEffects() {
        FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L12;
        List<FetchFavoriteListResponse.Data> r101 = r100.getData();
        if (r101 == null) goto L12;
        FetchFavoriteListResponse.Data r102 = (FetchFavoriteListResponse.Data) ListProtector.get(r101, 0);
        if (r102 == null) goto L12;
        List r103 = r102.getCollection();
        List r104 = r103;
        if (r103 == null) goto L12;
    L15:
        if (r104 == null) goto L36;
        if ((!r104.isEmpty()) == false) goto L36;
        if ((ListProtector.get(r104, 0) instanceof Effect) == true) goto L39;
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L23:
        if (r107.hasNext() == false) goto L25;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L23
    L25:
        if (r100 == null) goto L32;
        List<FetchFavoriteListResponse.Data> r108 = r100.getData();
        if (r108 == null) goto L32;
        FetchFavoriteListResponse.Data r109 = (FetchFavoriteListResponse.Data) ListProtector.get(r108, 0);
        if (r109 == null) goto L32;
        r109.setCollection(r106);
    L32:
        if ((!super.getData().isEmpty()) == false) goto L38;
        ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).setCollection(r106);
    L38:
        return r106;
    L39:
        return r104;
    L36:
        return new ArrayList();
    L12:
        if ((!super.getData().isEmpty()) == false) goto L14;
        r104 = ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).getCollection();
        goto L15
    L14:
        r104 = null;
        goto L15
    }

    public List<Effect> getEffects() {
        FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L12;
        List<FetchFavoriteListResponse.Data> r101 = r100.getData();
        if (r101 == null) goto L12;
        FetchFavoriteListResponse.Data r102 = (FetchFavoriteListResponse.Data) ListProtector.get(r101, 0);
        if (r102 == null) goto L12;
        List r103 = r102.getEffects();
        List r104 = r103;
        if (r103 == null) goto L12;
    L15:
        if (r104 == null) goto L36;
        if ((!r104.isEmpty()) == false) goto L36;
        if ((ListProtector.get(r104, 0) instanceof Effect) == true) goto L39;
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L23:
        if (r107.hasNext() == false) goto L25;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L23
    L25:
        if (r100 == null) goto L32;
        List<FetchFavoriteListResponse.Data> r108 = r100.getData();
        if (r108 == null) goto L32;
        FetchFavoriteListResponse.Data r109 = (FetchFavoriteListResponse.Data) ListProtector.get(r108, 0);
        if (r109 == null) goto L32;
        r109.setEffects(r106);
    L32:
        if ((!super.getData().isEmpty()) == false) goto L38;
        ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).setEffects(r106);
    L38:
        return r106;
    L39:
        return r104;
    L36:
        return new ArrayList();
    L12:
        if ((!super.getData().isEmpty()) == false) goto L14;
        r104 = ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).getEffects();
        goto L15
    L14:
        r104 = null;
        goto L15
    }

    public String getType() {
        FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L12;
        List<FetchFavoriteListResponse.Data> r101 = r100.getData();
        if (r101 == null) goto L12;
        FetchFavoriteListResponse.Data r102 = (FetchFavoriteListResponse.Data) ListProtector.get(r101, 0);
        if (r102 == null) goto L12;
        String r103 = r102.getType();
        if (r103 == null) goto L12;
        return r103;
    L12:
        return ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).getType();
    }

    public List<String> getUrlPrefix() {
        FetchFavoriteListResponse r100 = getKFavoriteModel();
        if (r100 == null) goto L12;
        List<FetchFavoriteListResponse.Data> r101 = r100.getData();
        if (r101 == null) goto L12;
        FetchFavoriteListResponse.Data r102 = (FetchFavoriteListResponse.Data) ListProtector.get(r101, 0);
        if (r102 == null) goto L12;
        List<String> r103 = r102.getUrl_prefix();
        if (r103 == null) goto L12;
        return r103;
    L12:
        if ((!super.getData().isEmpty()) == false) goto L15;
        return ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).getUrl_prefix();
    L15:
        return new ArrayList();
    }

    public FetchFavoriteListResponse getKFavoriteModel() {
        return this.kFavoriteModel;
    }

    public FetchFavoriteListResponseTemplate(FetchFavoriteListResponse r100) {
        super(null, null, 0, 7, null);
        this.kFavoriteModel = r100;
    }

    public void setEffects(List<? extends Effect> r100) {
        FetchFavoriteListResponse r101 = getKFavoriteModel();
        if (r101 == null) goto L10;
        List<FetchFavoriteListResponse.Data> r102 = r101.getData();
        if (r102 == null) goto L10;
        FetchFavoriteListResponse.Data r103 = (FetchFavoriteListResponse.Data) ListProtector.get(r102, 0);
        if (r103 == null) goto L10;
        r103.setEffects(r100);
    L10:
        if ((!super.getData().isEmpty()) == false) goto L13;
        ((FetchFavoriteListResponse.Data) ListProtector.get(super.getData(), 0)).setEffects(r100);
        return;
    }

    public /* synthetic */ FetchFavoriteListResponseTemplate(FetchFavoriteListResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
