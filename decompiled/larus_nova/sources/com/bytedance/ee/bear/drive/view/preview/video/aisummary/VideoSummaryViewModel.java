package com.bytedance.ee.bear.drive.view.preview.video.aisummary;

import androidx.lifecycle.ViewModel;
import fa5.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/video/aisummary/VideoSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_isImmersive", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isImmersive", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_isSummaryCollapsed", "isSummaryCollapsed", "_eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bytedance/ee/bear/drive/view/preview/video/aisummary/VideoSummaryEvent;", "eventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "enterImmersive", "", "exitImmersive", "collapseSummary", "expandSummary", "isSummaryExpand", "sendEvent", "event", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSummaryViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "VideoSummaryViewModel";
    private final MutableSharedFlow<c> _eventFlow;
    private final z0<Boolean> _isImmersive;
    private final z0<Boolean> _isSummaryCollapsed;
    private final d1<c> eventFlow;
    private final i1<Boolean> isImmersive;
    private final i1<Boolean> isSummaryCollapsed;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final void collapseSummary() {
        Boolean r100 = this._isSummaryCollapsed.getValue();
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
        return;
    L5:
        this._isSummaryCollapsed.setValue(r101);
    }

    public final void enterImmersive() {
        if (this._isImmersive.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        this._isImmersive.setValue(Boolean.TRUE);
    }

    public final void exitImmersive() {
        if (this._isImmersive.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        this._isImmersive.setValue(Boolean.FALSE);
    }

    public final void expandSummary() {
        Boolean r100 = this._isSummaryCollapsed.getValue();
        Boolean r101 = Boolean.FALSE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
        return;
    L5:
        this._isSummaryCollapsed.setValue(r101);
    }

    public final boolean isSummaryExpand() {
        return Intrinsics.areEqual(this._isSummaryCollapsed.getValue(), Boolean.FALSE);
    }

    public VideoSummaryViewModel() {
        StateFlowImpl r100 = j1.a(Boolean.FALSE);
        this._isImmersive = r100;
        this.isImmersive = e.b(r100);
        StateFlowImpl r101 = j1.a(null);
        this._isSummaryCollapsed = r101;
        this.isSummaryCollapsed = e.b(r101);
        MutableSharedFlow<c> r102 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 4, null);
        this._eventFlow = r102;
        this.eventFlow = e.a(r102);
    }

    public final d1<c> getEventFlow() {
        return this.eventFlow;
    }

    public final i1<Boolean> isImmersive() {
        return this.isImmersive;
    }

    public final i1<Boolean> isSummaryCollapsed() {
        return this.isSummaryCollapsed;
    }

    public final void sendEvent(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        tt5.a.h(TAG, "sendEvent: " + r100);
        this._eventFlow.tryEmit(r100);
    }
}
