package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f233577a;

    public n(m r100) {
        this.f233577a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SearchUserResult r101 = (SearchUserResult) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        if (TextUtils.equals("", this.f233577a.f233568e) == false) goto L13;
        List<UserInfo> r102 = this.f233577a.f233567d;
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        r101.list.addAll(0, this.f233577a.f233567d);
        goto L13
    L7:
        if (r102.isEmpty() == true) goto L10;
        r103 = false;
    L13:
        return r101;
    }
}
