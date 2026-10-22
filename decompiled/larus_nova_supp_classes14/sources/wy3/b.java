package wy3;

import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public MutableLiveData<Object> a;
    public Object b;

    public b(Object r1, boolean r2) {
        if (r2 == false) goto L7;
        if (r1 != null) goto L6;
        MutableLiveData<Object> r3 = new MutableLiveData();
    L8:
        this.a = r3;
        this.b = r1;
        return;
    L6:
        r3 = new MutableLiveData();
        r3.setValue(r1);
        goto L8
    L7:
        r3 = null;
        goto L8
    }
}
