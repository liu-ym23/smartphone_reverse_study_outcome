package com.bytedance.ee.bear.content.common.morepanel;

import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements hw4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonMorePanelFragment f216796a;

    public b(CommonMorePanelFragment r100) {
        this.f216796a = r100;
    }

    @Override // hw4.d
    public final void a(int r100, CommonMorePanelItemData r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        CommonMorePanelViewModel r102 = this.f216796a.f216777f;
        if (r102 == null) goto L7;
        MutableLiveData<CommonMorePanelItemData> r103 = r102.getSelectData();
        if (r103 == null) goto L7;
        r103.postValue(r101);
    L7:
        a.InterfaceC3091a r104 = this.f216796a.f216779h;
        if (r104 == null) goto L11;
        ((hw4.a) r104).a();
        return;
    }
}
