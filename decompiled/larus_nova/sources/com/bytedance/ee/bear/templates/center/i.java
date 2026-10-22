package com.bytedance.ee.bear.templates.center;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateCenterView f238937a;

    public i(TemplateCenterView r100) {
        this.f238937a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FolderSortStrategy r101 = (FolderSortStrategy) r100;
        Intrinsics.checkNotNullParameter(r101, "folderSortStrategy");
        if (Intrinsics.areEqual(r101.f227680a, "template_v4") == false) goto L6;
        sbb.e r102 = sbb.e.d(r101.getType());
        TemplateCenterView r103 = this.f238937a;
        Intrinsics.checkNotNull(r102);
        r103.k(r102);
        return;
    }
}
