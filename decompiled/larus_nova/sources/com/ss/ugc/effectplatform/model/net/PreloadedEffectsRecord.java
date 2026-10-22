package com.ss.ugc.effectplatform.model.net;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PreloadedEffectsRecord;", "", "effect_list", "", "Lcom/ss/ugc/effectplatform/model/net/PreloadDataModel;", "model_list", "(Ljava/util/List;Ljava/util/List;)V", "getEffect_list", "()Ljava/util/List;", "setEffect_list", "(Ljava/util/List;)V", "getModel_list", "setModel_list", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PreloadedEffectsRecord {
    private List<PreloadDataModel> effect_list;
    private List<PreloadDataModel> model_list;

    /* JADX WARN: Multi-variable type inference failed */
    public PreloadedEffectsRecord() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final List<PreloadDataModel> getEffect_list() {
        return this.effect_list;
    }

    public final List<PreloadDataModel> getModel_list() {
        return this.model_list;
    }

    public final void setEffect_list(List<PreloadDataModel> r100) {
        this.effect_list = r100;
    }

    public final void setModel_list(List<PreloadDataModel> r100) {
        this.model_list = r100;
    }

    public PreloadedEffectsRecord(List<PreloadDataModel> r100, List<PreloadDataModel> r101) {
        this.effect_list = r100;
        this.model_list = r101;
    }

    public /* synthetic */ PreloadedEffectsRecord(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
