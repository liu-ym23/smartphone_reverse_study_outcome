package com.bytedance.ee.bear.templates.topic;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTopicView f239432a;

    public b(BaseTopicView r100) {
        this.f239432a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FolderSortStrategy r101 = (FolderSortStrategy) r100;
        Intrinsics.checkNotNullParameter(r101, "folderSortStrategy");
        if (Intrinsics.areEqual(r101.f227680a, "template_topic") == false) goto L13;
        sbb.e r102 = sbb.e.d(r101.getType());
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.template_docx", false) == true) goto L7;
    L9:
        BaseTopicView r103 = this.f239432a;
        Intrinsics.checkNotNull(r102);
        r103.o(r102);
        BaseTopicView r104 = this.f239432a;
        e.a r105 = r104.f239416f;
        if (r105 == null) goto L14;
        r105.P2(r104.f239414d, r102.f541317b);
        return;
    L14:
        return;
    L7:
        if (r102.f541317b != sbb.e.f541296g.f541317b) goto L9;
        r102 = sbb.e.f541304o;
        goto L9
    }
}
