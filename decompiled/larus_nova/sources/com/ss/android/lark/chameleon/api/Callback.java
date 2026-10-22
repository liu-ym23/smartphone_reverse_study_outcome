package com.ss.android.lark.chameleon.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/api/Callback;", "", "error", "", "Lcom/ss/android/lark/chameleon/api/LarkAPIError;", "success", "param", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Callback {
    void error(LarkAPIError r100);

    void success(Object r100);
}
