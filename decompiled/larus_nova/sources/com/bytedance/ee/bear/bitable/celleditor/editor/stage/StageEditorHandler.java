package com.bytedance.ee.bear.bitable.celleditor.editor.stage;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.c;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class StageEditorHandler extends c<StageEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f209552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f209553e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<StageEditorModel> c() {
        return StageEditorModel.class;
    }

    public StageEditorHandler(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f209552d = r100;
        this.f209553e = LazyKt.lazy(new StageEditorHandler$lottieSuccess$2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((StageEditorModel) r100, "data");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final void f(String r100, CommonEditorModel r101) {
        Intrinsics.checkNotNullParameter((StageEditorModel) r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (Intrinsics.areEqual(r100, "StageStrewFlowers") == false) goto L6;
        ((BearLottieView) this.f209553e.getValue()).setVisibility(0);
        ((BearLottieView) this.f209553e.getValue()).playAnimation();
        return;
    }
}
