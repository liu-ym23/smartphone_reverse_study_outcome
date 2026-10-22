package com.bytedance.ee.bear.bitable.app.chameleon;

import android.content.Context;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OfficeBaseAppLoadingLayout$1 extends FunctionReferenceImpl implements Function1<FrameLayout, com.bytedance.ee.bear.document.loading.d> {
    public OfficeBaseAppLoadingLayout$1(Object r100) {
        super(1, r100, h.a.class, "createLegacyWrapper", "createLegacyWrapper(Landroid/widget/FrameLayout;)Lcom/bytedance/ee/bear/document/loading/ILoadingWrapper;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.ee.bear.document.loading.d invoke2(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((h.a) this.receiver).getClass();
        Context r101 = r100.getContext();
        FrameLayout r102 = new FrameLayout(r101);
        r102.setBackgroundColor(0);
        FrameLayout r103 = new FrameLayout(r101);
        r103.setId(R.id.doc_webview_cover);
        r103.setBackgroundColor(r101.getColor(R.color.bg_body));
        ViewStub r104 = new ViewStub(r101);
        r104.setId(R.id.loading);
        r104.setInflatedId(R.id.loading);
        r104.setLayoutResource(R.layout.doc_stub_web_loading);
        r102.addView(r103, new FrameLayout.LayoutParams(-1, -1));
        r102.addView(r104, new FrameLayout.LayoutParams(-1, -1));
        r100.addView(r102, new FrameLayout.LayoutParams(-1, -1));
        return new po4.b(r102, sbb.e.f541298i.getType());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.ee.bear.document.loading.d invoke(FrameLayout r100) {
        return invoke2(r100);
    }
}
