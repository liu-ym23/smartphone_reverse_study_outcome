package wy3;

import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<Object> f561869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f561870b;

    public b(Object r100, boolean r101) {
        if (r101 == false) goto L7;
        if (r100 != null) goto L6;
        MutableLiveData<Object> r102 = new MutableLiveData();
    L8:
        this.f561869a = r102;
        this.f561870b = r100;
        return;
    L6:
        r102 = new MutableLiveData();
        r102.setValue(r100);
        goto L8
    L7:
        r102 = null;
        goto L8
    }
}
