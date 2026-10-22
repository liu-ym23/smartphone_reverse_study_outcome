package com.bytedance.livesdk.preview.base;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.bytedance.livesdk.preview.viewmodel.VHPreviewContext;
import com.lynx.tasm.LynxError;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/preview/base/VHWidget;", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "", "<init>", "()V", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class VHWidget extends AbsMergeWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<ViewGroup> f256408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VHPreviewContext f256409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f256410d;

    public static final class a implements AbsMergeWidget.a {
        public a() {
        }

        @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget.a
        public final void a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            ALogger.e("VHWidget", r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.livesdk.preview.base.VHWidget$isInnerPreviewNeedUnbind$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(VHWidget r100) {
            super(r100, VHWidget.class, "previewContext", "getPreviewContext()Lcom/bytedance/livesdk/preview/viewmodel/VHPreviewContext;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((VHWidget) this.receiver).xq();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            VHWidget r101 = (VHWidget) this.receiver;
            VHPreviewContext r102 = (VHPreviewContext) r100;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f256409c = r102;
        }
    }

    public abstract void Iq();

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public final boolean isPreviewWidget() {
        return true;
    }

    public void wq() {
    }

    public void Aq() {
        final int r100 = 0;
        Gq(new VHWidget$onHolderResumeP$1(this, r100));
    }

    public void Bq() {
        Gq(new VHWidget$onLoad$1(this));
    }

    public void Cq() {
        Gq(new VHWidget$onStopPreview$1(this));
    }

    public void Fq() {
        Gq(new VHWidget$onViewHolderSelect$1(this));
    }

    public void Jq() {
        Gq(new VHWidget$unLoad$1(this));
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public final AbsMergeWidget.a getSubService() {
        return new a();
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public final boolean isInnerPreviewNeedUnbind() {
        VHPreviewContext r100 = this.f256409c;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("previewContext");
    L6:
        r100.isInnerPreview();
    L7:
        return false;
    }

    public final VHPreviewContext xq() {
        VHPreviewContext r100 = this.f256409c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("previewContext");
    L5:
        return r100;
    }

    public void zq() {
        final int r100 = 0;
        Gq(new VHWidget$onHolderPauseP$1(this, r100));
    }

    public VHWidget() {
        this.f256407a = "VHWidget";
        this.f256408b = new LinkedList();
        this.f256410d = LazyKt.lazy(VHWidget$subWidgetMap$2.INSTANCE);
    }

    public void Eq() {
        Iq();
        wq();
        Gq(new VHWidget$onUnBind$1(this));
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();
    }

    public final void Gq(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ALOG);
        VHPreviewContext r101 = this.f256409c;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("previewContext");
    L6:
        if (r101.getAlogOpt() == true) goto L9;
        r100.invoke();
        return;
    }

    @Override // com.bytedance.livesdk.preview.merge.AbsMergeWidget
    public final void handleLifeEvent(com.bytedance.livesdk.preview.event.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.a) == false) goto L6;
        ((com.bytedance.livesdk.preview.event.b.a) r100).getClass();
        return;
    L6:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.g) == false) goto L9;
        Eq();
        return;
    L9:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.f) == false) goto L11;
        Fq();
        return;
    L11:
        final int r101 = 0;
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.d) == false) goto L15;
        ((com.bytedance.livesdk.preview.event.b.d) r100).getClass();
        Gq(new VHWidget$onHolderResume$1(this, r101));
        return;
    L15:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.C3642b) == false) goto L18;
        ((com.bytedance.livesdk.preview.event.b.C3642b) r100).getClass();
        Gq(new VHWidget$onHolderPause$1(this, r101));
        return;
    L18:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.e) == false) goto L21;
        ((com.bytedance.livesdk.preview.event.b.e) r100).getClass();
        Aq();
        return;
    L21:
        if ((r100 instanceof com.bytedance.livesdk.preview.event.b.c) == false) goto L30;
        ((com.bytedance.livesdk.preview.event.b.c) r100).getClass();
        zq();
        return;
    }

    public final <T extends DataContext> T yq(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$inst");
        Intrinsics.throwUninitializedPropertyAccessException("vmManager");
        throw null;
    }
}
