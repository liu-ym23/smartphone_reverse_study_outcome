package com.bytedance.android.shopping.deepfeed.slice.service;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSlcCommonService implements b {
    public final List<a> a;
    public final int[] b;
    public final int[] c;
    public WeakReference<View> d;
    public WeakReference<View> e;
    public String f;
    public boolean g;
    public final DeepFeedProductSlcVH h;
    public final wc3.a i;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.service.DeepFeedSlcCommonService$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"com/bytedance/android/shopping/deepfeed/slice/service/DeepFeedSlcCommonService$1", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onStop", "onDestroy", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class AnonymousClass1 implements LifecycleObserver {
        public final /* synthetic */ DeepFeedSlcCommonService a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            Iterator r0 = CollectionsKt.toList(this.a.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((a) r0.next()).onDestroy();
            goto L4
        L6:
            ((ArrayList) this.a.a).clear();
            DeepFeedSlcCommonService r1 = this.a;
            WeakReference<View> r2 = r1.d;
            if (r2 == null) goto L9;
            r2.clear();
        L9:
            WeakReference<View> r3 = r1.e;
            if (r3 == null) goto L12;
            r3.clear();
        L12:
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = false;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            Iterator r0 = CollectionsKt.toList(this.a.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((a) r0.next()).onPause();
            goto L4
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            Iterator r0 = CollectionsKt.toList(this.a.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((a) r0.next()).onResume();
            goto L4
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public final void onStop() {
            Iterator r0 = CollectionsKt.toList(this.a.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((a) r0.next()).onStop();
            goto L4
        }

        public AnonymousClass1(DeepFeedSlcCommonService r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void H() {
        this.h.i4().reportVideoPlay(this.h.m, true);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final int L() {
        this.h.getClass();
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void Q() {
        DeepFeedProductEventTracker r0 = this.h.i4().getEventTracker();
        if (r0 == null) goto L6;
        int r1 = this.h.i4().requireReportCardIndex(this.h.m);
        DeepFeedProductSlcVH r2 = this.h;
        r0.doEventAction("slide_deep_feed_video", r0.g(r1, r2.m, r2.n));
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final LifecycleOwner k() {
        this.h.getClass();
        return null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void I(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.h.I4(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void K(final a r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleObserver");
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new DeepFeedSlcCommonService$registerLifeCycleObserver$1(this, r2));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void M(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.i.a(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void N(boolean r5) {
        DeepFeedProductEventTracker r0 = this.h.i4().getEventTracker();
        if (r0 == null) goto L10;
        int r1 = this.h.i4().requireReportCardIndex(this.h.m);
        InFeedProductV2 r2 = this.h.m;
        int r3 = DeepFeedProductEventTracker.d;
        Map<String, Object> r4 = r0.g(r1, r2, null);
        if (r5 == false) goto L7;
        String r6 = "1";
    L8:
        r4.put("state", r6);
        r0.doEventAction("deep_feed_video_state_change", r4);
        return;
    L7:
        r6 = "0";
        goto L8
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void P(final a r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleObserver");
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new DeepFeedSlcCommonService$removeLifeCycleObserver$1(this, r2));
    }

    public DeepFeedSlcCommonService(DeepFeedProductSlcVH r2, com.bytedance.android.shopping.deepfeed.slice.c r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "sliceDataContainer");
        this.h = r2;
        this.i = r3;
        this.a = new ArrayList();
        this.b = new int[2];
        this.c = new int[2];
        r2.getClass();
        throw null;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void O(String r2, Map<String, ? extends Object> r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        this.h.F4(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void J(int r8, int r9, boolean r10, boolean r11) {
        com.bytedance.android.shopping.deepfeed.action.d r0 = this.h.i4().getActionHelper();
        if (r0 == null) goto L7;
        int r1 = this.h.i4().requireReportCardIndex(this.h.m);
        Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r2 = r0.c;
        if (r2 == null) goto L7;
        Unit r12 = (Unit) r2.invoke(Integer.valueOf(r1), Integer.valueOf(r8), Integer.valueOf(r9), Boolean.valueOf(r11));
    L7:
        DeepFeedProductEventTracker r3 = this.h.i4().getEventTracker();
        if (r3 == null) goto L11;
        int r4 = this.h.i4().requireReportCardIndex(this.h.m);
        DeepFeedProductSlcVH r13 = this.h;
        r3.C(r4, r8, r10, r13.q, ((RecyclerView.ViewHolder) r13).itemView, r13.m);
    L11:
        if (this.g == false) goto L17;
        if (r8 != 0) goto L14;
        String r14 = "main_video";
    L15:
        this.f = r14;
        return;
    L14:
        r14 = "main_image";
        goto L15
    }
}
