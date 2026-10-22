package com.ss.android.ugc.effectmanager.effect.model.template;

import com.ss.ugc.effectplatform.model.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/DownloadEffectExtraTemplate;", "Lcom/ss/ugc/effectplatform/model/a;", "kDownloadEffect", "Lcom/ss/ugc/effectplatform/model/a;", "getKDownloadEffect", "()Lcom/ss/ugc/effectplatform/model/a;", "<init>", "(Lcom/ss/ugc/effectplatform/model/a;)V", "effectmanager_release"}, k = 1, mv = {1, 4, 0})
public class DownloadEffectExtraTemplate extends a {
    private final transient a kDownloadEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadEffectExtraTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a getKDownloadEffect() {
        return this.kDownloadEffect;
    }

    public DownloadEffectExtraTemplate(a r100) {
        super(null, 1, null);
        this.kDownloadEffect = r100;
    }

    public /* synthetic */ DownloadEffectExtraTemplate(a r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
