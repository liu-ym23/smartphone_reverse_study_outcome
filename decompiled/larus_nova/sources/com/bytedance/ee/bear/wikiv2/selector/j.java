package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements FolderSelectAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f241187a;

    public j(e r100) {
        this.f241187a = r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.FolderSelectAdapter.a
    public final void a(View r100, int r101, Document r102) {
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        tt5.a.h("FolderSelectView", "on item click, position = " + r101);
        m.a r103 = (m.a) this.f241187a.f285682a;
        if (r103 == null) goto L6;
        r103.f3(r101, r102);
        return;
    }
}
