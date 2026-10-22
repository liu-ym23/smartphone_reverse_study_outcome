package com.ss.android.ugc.effectmanager;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/effectmanager/IFetchResourceListener;", "", "onFailure", "", a.KEY_EXCEPTION, "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "effectHandle", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public interface IFetchResourceListener {
    void onFailure(Exception r100);

    void onSuccess(long r100);
}
