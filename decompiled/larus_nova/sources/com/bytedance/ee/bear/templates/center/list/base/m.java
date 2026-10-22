package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import com.ss.ttvideoengine.model.VideoRef;
import dd5.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListView f239018a;

    public m(BaseTemplateListView r100) {
        this.f239018a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        BaseTemplateListView r102 = this.f239018a;
        int r103 = w0.f468013a;
        Intrinsics.checkNotNull(r101);
        int r104 = r101.intValue() - com.bytedance.ee.util.ui.n.d(16);
        int r105 = com.bytedance.ee.util.ui.n.d(16);
        int r106 = 2;
        int r107 = (r104 - (r105 * 2)) / 2;
        int r108 = com.bytedance.ee.util.ui.n.d(VideoRef.VALUE_VIDEO_REF_CATEGORY);
        int r109 = com.bytedance.ee.util.ui.n.d(138);
        if (r107 < r109) goto L8;
    L5:
        if (r107 < r109) goto L10;
        if (r107 <= r108) goto L8;
    L10:
        r106 = r106 + 1;
        r107 = (r104 - (r105 * r106)) / r106;
    L8:
        r102.D(r106);
    }
}
