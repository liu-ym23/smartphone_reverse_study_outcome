package com.larksuite.component.ui.layout.plus;

import android.graphics.Canvas;
import com.larksuite.component.ui.layout.ILKUILayout;
import com.larksuite.component.ui.layout.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/ui/layout/plus/PerMonitorRenderLKUIPlus;", "Lcom/larksuite/component/ui/layout/plus/BaseInnerPlus;", "layout", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "<init>", "(Lcom/larksuite/component/ui/layout/ILKUILayout;)V", "getPlusType", "Lcom/larksuite/component/ui/layout/plus/InnerPlusType;", "isMeasured", "", "isRendered", "mCallback", "Lcom/larksuite/component/ui/layout/plus/PerMonitorRenderLKUIPlus$MonitorCallback;", "onDelegateMeasureStart", "", "onMeasureData", "Lcom/larksuite/component/ui/layout/OnMeasureData;", "onDelegateDispatchDrawEnd", "canvas", "Landroid/graphics/Canvas;", "setMonitorCallback", "callback", "MonitorCallback", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerMonitorRenderLKUIPlus extends BaseInnerPlus {
    private boolean isMeasured;
    private boolean isRendered;
    private a mCallback;

    public interface a {
        void a();

        void b();
    }

    @Override // com.larksuite.component.ui.layout.plus.BaseInnerPlus
    public InnerPlusType getPlusType() {
        return InnerPlusType.PER_MONITOR_RENDER;
    }

    public PerMonitorRenderLKUIPlus(ILKUILayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        super(r100);
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateDispatchDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDelegateDispatchDrawEnd(r100);
        if (this.isRendered == true) goto L9;
        a r101 = this.mCallback;
        if (r101 == null) goto L7;
        r101.b();
    L7:
        this.isRendered = true;
        return;
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateMeasureStart(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
        if (this.isMeasured == true) goto L8;
        a r101 = this.mCallback;
        if (r101 == null) goto L7;
        r101.a();
    L7:
        this.isMeasured = true;
    L8:
        super.onDelegateMeasureStart(r100);
    }

    public final void setMonitorCallback(a r100) {
        this.mCallback = r100;
    }
}
