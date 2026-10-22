package com.bytedance.ee.bear.basesdk.apiimpl;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/apiimpl/TemplateImpl$HorizontalSelectTemplateCallback;", "Lcom/bytedance/ee/bear/basesdk/apiimpl/TemplateImpl$SelectTemplateCallback;", "paramCallback", "Lcom/bytedance/ee/bear/basesdk/api/ITemplate$TemplateSelectedCallBack;", "bundle", "Landroid/os/Bundle;", "<init>", "(Lcom/bytedance/ee/bear/basesdk/api/ITemplate$TemplateSelectedCallBack;Landroid/os/Bundle;)V", "onTemplateCenterDestroy", "", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateImpl$HorizontalSelectTemplateCallback extends TemplateImpl$SelectTemplateCallback {
    @Override // com.bytedance.ee.bear.basesdk.apiimpl.TemplateImpl$SelectTemplateCallback, com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback.Stub, com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
    public void onTemplateCenterDestroy() {
        tt5.a.h("TemplateImpl", "HorizontalSelectTemplateCallback onTemplateCenterDestroy()");
    }

    public TemplateImpl$HorizontalSelectTemplateCallback(final pn4.l r100, final Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "paramCallback");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        super(r100, r101);
    }
}
