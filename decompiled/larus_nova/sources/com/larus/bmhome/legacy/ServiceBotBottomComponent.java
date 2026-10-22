package com.larus.bmhome.legacy;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import k1a.b;
import kotlin.Metadata;
import vq8.z0;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/legacy/ServiceBotBottomComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", WidgetCostModule.TYPE_ON_CREATE, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServiceBotBottomComponent extends BaseContentWidget {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f312466n = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f312467m;

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        b.b(this, new z0(this));
    }

    public ServiceBotBottomComponent() {
        this.f312467m = R.id.chat_root;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f312467m;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f312467m = r100;
    }
}
