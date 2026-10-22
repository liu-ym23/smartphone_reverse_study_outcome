package com.bytedance.ee.bear.document.comment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v2<T> extends MutableLiveData {
    public v2() {
    }

    public final void setValue(Object r3) {
        super.setValue(r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        iu5.d.a("Comment#SecureLiveData", e);
        Field r4 = LiveData.class.getDeclaredField("mDispatchingValue");     // Catch: Exception -> L11
        r4.setAccessible(true);     // Catch: Exception -> L11
        if (r4.getBoolean(this) == false) goto L9;
        r4.setBoolean(this, false);     // Catch: Exception -> L11
    L9:
        tt5.a.h("Comment#SecureLiveData", "clearDispatchStatus success");     // Catch: Exception -> L11
        return;
    L11:
        tt5.a.d("Comment#SecureLiveData", "clearDispatchStatus error");
    }
}
