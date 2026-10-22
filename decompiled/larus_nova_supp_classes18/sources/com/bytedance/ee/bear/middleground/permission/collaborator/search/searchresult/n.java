package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ m a;

    public n(m r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        SearchUserResult r5 = (SearchUserResult) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        if (TextUtils.equals("", this.a.e) == false) goto L13;
        List<UserInfo> r0 = this.a.d;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        r5.list.addAll(0, this.a.d);
        goto L13
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
    L13:
        return r5;
    }
}
