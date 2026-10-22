package com.bytedance.ee.bear.document.comment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes16.dex */
public final class v2<T> extends MutableLiveData {
    public v2() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(Object r100) {
        super.setValue(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.a("Comment#SecureLiveData", e);
        Field r101 = LiveData.class.getDeclaredField("mDispatchingValue");     // Catch: Exception -> L11
        r101.setAccessible(true);     // Catch: Exception -> L11
        if (r101.getBoolean(this) == false) goto L9;
        r101.setBoolean(this, false);     // Catch: Exception -> L11
    L9:
        tt5.a.h("Comment#SecureLiveData", "clearDispatchStatus success");     // Catch: Exception -> L11
        return;
    L11:
        tt5.a.d("Comment#SecureLiveData", "clearDispatchStatus error");
    }
}
