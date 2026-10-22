package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchHotEffectResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;", "kFetchHotModel", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;)V", "getKFetchHotModel", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;", "getCollection", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getEffects", "setEffects", "", "value", "DataTemplate", "ExtraTemplate", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class FetchHotEffectResponseTemplate extends FetchHotEffectResponse {
    private final transient FetchHotEffectResponse kFetchHotModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchHotEffectResponseTemplate$DataTemplate;", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "kData", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;)V", "getKData", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Data;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static class DataTemplate extends FetchHotEffectResponse.Data {
        private final transient FetchHotEffectResponse.Data kData;

        /* JADX WARN: Multi-variable type inference failed */
        public DataTemplate() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public FetchHotEffectResponse.Data getKData() {
            return this.kData;
        }

        public DataTemplate(FetchHotEffectResponse.Data r100) {
            super(null, null, null, 7, null);
            this.kData = r100;
        }

        public /* synthetic */ DataTemplate(FetchHotEffectResponse.Data r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/FetchHotEffectResponseTemplate$ExtraTemplate;", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;", "kData", "(Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;)V", "getKData", "()Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse$Extra;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static class ExtraTemplate extends FetchHotEffectResponse.Extra {
        private final transient FetchHotEffectResponse.Extra kData;

        /* JADX WARN: Multi-variable type inference failed */
        public ExtraTemplate() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public FetchHotEffectResponse.Extra getKData() {
            return this.kData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ExtraTemplate(FetchHotEffectResponse.Extra r100) {
            super(null, 1, 0 == true ? 1 : 0);
            this.kData = r100;
        }

        public /* synthetic */ ExtraTemplate(FetchHotEffectResponse.Extra r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchHotEffectResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<Effect> getCollection() {
        FetchHotEffectResponse r100 = getKFetchHotModel();
        if (r100 == null) goto L7;
        List r101 = r100.getCollection_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setCollection_list(r104);
    L22:
        super.setCollection_list(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getCollection_list();
        goto L9
    }

    public List<Effect> getEffects() {
        FetchHotEffectResponse r100 = getKFetchHotModel();
        if (r100 == null) goto L7;
        List r101 = r100.getEffect_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setEffect_list(r104);
    L22:
        super.setEffect_list(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getEffect_list();
        goto L9
    }

    public FetchHotEffectResponse getKFetchHotModel() {
        return this.kFetchHotModel;
    }

    public FetchHotEffectResponseTemplate(FetchHotEffectResponse r100) {
        super(null, null, 0, 7, null);
        this.kFetchHotModel = r100;
    }

    public void setEffects(List<? extends Effect> r100) {
        FetchHotEffectResponse r101 = getKFetchHotModel();
        if (r101 == null) goto L5;
        r101.setEffect_list(r100);
    L5:
        super.setEffect_list(r100);
    }

    public /* synthetic */ FetchHotEffectResponseTemplate(FetchHotEffectResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
