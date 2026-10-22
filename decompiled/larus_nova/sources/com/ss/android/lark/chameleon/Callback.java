package com.ss.android.lark.chameleon;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/Callback;", "", "success", "", "param", "error", "Lcom/ss/android/lark/chameleon/LKAPIError;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Callback {
    void error(LKAPIError r100);

    void success(Object r100);
}
