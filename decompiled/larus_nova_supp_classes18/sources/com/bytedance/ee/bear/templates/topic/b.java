package com.bytedance.ee.bear.templates.topic;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ BaseTopicView a;

    public b(BaseTopicView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        FolderSortStrategy r5 = (FolderSortStrategy) r4;
        Intrinsics.checkNotNullParameter(r5, "folderSortStrategy");
        if (Intrinsics.areEqual(r5.a, "template_topic") == false) goto L13;
        sbb.e r6 = sbb.e.d(r5.getType());
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == true) goto L7;
    L9:
        BaseTopicView r0 = this.a;
        Intrinsics.checkNotNull(r6);
        r0.o(r6);
        BaseTopicView r1 = this.a;
        e.a r2 = r1.f;
        if (r2 == null) goto L14;
        r2.P2(r1.d, r6.b);
        return;
    L14:
        return;
    L7:
        if (r6.b != sbb.e.g.b) goto L9;
        r6 = sbb.e.o;
        goto L9
    }
}
