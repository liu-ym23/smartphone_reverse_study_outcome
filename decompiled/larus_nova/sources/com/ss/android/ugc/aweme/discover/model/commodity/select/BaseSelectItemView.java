package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BaseSelectItemView;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseSelectItemView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderItem f450505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f450506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f450507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ItemSelectStatusChangeObserver> f450508d;

    public void b(RenderItem r100) {
        Intrinsics.checkNotNullParameter(r100, "renderItem");
    }

    public void c() {
    }

    public void d(SelectItemStatus r100) {
    }

    public void j(RenderItem r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "renderItem");
    }

    public abstract void k();

    public BaseSelectItemView() {
        this.f450508d = new ArrayList();
    }

    public final void g() {
        a("selectItem");
        h(true);
        k();
    }

    public final void i() {
        a("unselectItem");
        h(false);
        k();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        RenderItem r101 = this.f450505a;
        if (r101 == null) goto L5;
        r101.getDataId();
    L5:
        RenderItem r102 = this.f450505a;
        if (r102 == null) goto L9;
        r102.getText();
        return;
    }

    public void e(List<? extends SelectItemStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "subSelectItemStatus");
        a("onChildrenSelectStatusChanged");
    }

    public void f(RenderItem r100) {
        Intrinsics.checkNotNullParameter(r100, "renderItem");
        a("renderUIView");
        this.f450505a = r100;
        a(MiPushClient.COMMAND_REGISTER);
        RenderItem r101 = this.f450505a;
        if (r101 == null) goto L6;
        r101.setRenderView(this);
        return;
    }

    public final void h(boolean r100) {
        if (r100 == this.f450506b) goto L8;
        this.f450506b = r100;
        Iterator r101 = ((ArrayList) this.f450508d).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((ItemSelectStatusChangeObserver) r101.next()).a(this);
        goto L6
    L10:
        return;
    }
}
