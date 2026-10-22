package com.ss.ugc.effectplatform.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/ugc/effectplatform/model/GifProviderEffectModel;", "", "search_tips", "", "gifs", "Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "(Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;)V", "getGifs", "()Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "setGifs", "(Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;)V", "getSearch_tips", "()Ljava/lang/String;", "setSearch_tips", "(Ljava/lang/String;)V", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class GifProviderEffectModel {
    private ProviderEffectModel gifs;
    private String search_tips;

    /* JADX WARN: Multi-variable type inference failed */
    public GifProviderEffectModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public ProviderEffectModel getGifs() {
        return this.gifs;
    }

    public String getSearch_tips() {
        return this.search_tips;
    }

    public void setGifs(ProviderEffectModel r100) {
        this.gifs = r100;
    }

    public void setSearch_tips(String r100) {
        this.search_tips = r100;
    }

    public GifProviderEffectModel(String r100, ProviderEffectModel r101) {
        this.search_tips = r100;
        this.gifs = r101;
    }

    public /* synthetic */ GifProviderEffectModel(String r100, ProviderEffectModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
