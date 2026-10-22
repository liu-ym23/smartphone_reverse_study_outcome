package com.bytedance.ee.bear.document.doccomponent.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003RC\u0010\u0004\u001a4\u00120\u0012.\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006j\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u0001`\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/doccomponent/impl/DoComponentConfigVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "livePatchDocComponentConfig", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/HashMap;", "", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "getLivePatchDocComponentConfig", "()Landroidx/lifecycle/MutableLiveData;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoComponentConfigVM extends ViewModel {
    private final MutableLiveData<HashMap<String, ? extends Serializable>> livePatchDocComponentConfig;

    public DoComponentConfigVM() {
        this.livePatchDocComponentConfig = new MutableLiveData();
    }

    public final MutableLiveData<HashMap<String, ? extends Serializable>> getLivePatchDocComponentConfig() {
        return this.livePatchDocComponentConfig;
    }
}
