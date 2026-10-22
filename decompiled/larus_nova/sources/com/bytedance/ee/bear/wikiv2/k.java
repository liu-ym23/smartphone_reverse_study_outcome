package com.bytedance.ee.bear.wikiv2;

import com.bytedance.ee.bear.wikiv2.home.api.GetSpacePuller;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f240974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f240975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f240976c;

    public k(l r100, boolean r101, boolean r102) {
        this.f240974a = r100;
        this.f240975b = r101;
        this.f240976c = r102;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        GetSpacePuller.Result r101 = (GetSpacePuller.Result) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        l r102 = this.f240974a;
        r102.f240978b = r101.last_label;
        r102.f240977a = r101.has_more;
        if (this.f240975b == false) goto L5;
        ArrayList r103 = new ArrayList();
    L11:
        List r104 = r101.spaces;
        if (r104 != null) goto L14;
        r104 = new ArrayList();
    L14:
        r103.addAll(r104);
        this.f240974a.f240979c = r103;
        if (this.f240976c == false) goto L17;
        int r105 = zp5.f.f573192a;
        zp5.f.b(r104, new ce5.a());
    L17:
        return r104;
    L5:
        List<? extends SpaceBean> r106 = r102.f240979c;
        if ((r106 instanceof ArrayList) == false) goto L8;
        r103 = (ArrayList) r106;
    L9:
        if (r103 != null) goto L11;
        r103 = new ArrayList();
        goto L11
    L8:
        r103 = null;
        goto L9
    }
}
