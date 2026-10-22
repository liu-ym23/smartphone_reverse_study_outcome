package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ LiveData c;

    public d0(MediatorLiveData r1, Function2 r2, MutableLiveData r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r4) {
        this.a.setValue(this.b.invoke(r4, this.c.getValue()));
    }
}
