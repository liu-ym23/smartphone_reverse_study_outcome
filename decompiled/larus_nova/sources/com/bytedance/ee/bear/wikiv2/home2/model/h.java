package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.bear.wikiv2.home.api.GetSpaceClassificationPuller;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T, R> f240932a = null;

    static {
        f240932a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        GetSpaceClassificationPuller.Result r101 = (GetSpaceClassificationPuller.Result) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        List r102 = r101.class_list;
        if (r102 != null) goto L6;
        r102 = new ArrayList();
    L6:
        if ((!r102.isEmpty()) == false) goto L8;
        ListProtector.add(r102, 0, new WikiSpaceClassification("all", eu5.b.f474075a.getString(R.string.LarkCCM_Wiki_CategoryMgmt_All_Button)));
    L8:
        return r102;
    }
}
