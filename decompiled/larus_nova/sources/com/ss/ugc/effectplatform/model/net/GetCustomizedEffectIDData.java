package com.ss.ugc.effectplatform.model.net;

import com.ss.android.ugc.effectmanager.MobConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDData;", "", MobConstants.EFFECT_ID, "", "(Ljava/lang/String;)V", "getEffect_id", "()Ljava/lang/String;", "setEffect_id", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public class GetCustomizedEffectIDData {
    private String effect_id;

    /* JADX WARN: Multi-variable type inference failed */
    public GetCustomizedEffectIDData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public String getEffect_id() {
        return this.effect_id;
    }

    public GetCustomizedEffectIDData(String r100) {
        this.effect_id = r100;
    }

    public void setEffect_id(String r100) {
        this.effect_id = r100;
    }

    public /* synthetic */ GetCustomizedEffectIDData(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
