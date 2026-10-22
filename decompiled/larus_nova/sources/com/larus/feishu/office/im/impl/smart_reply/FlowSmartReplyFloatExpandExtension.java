package com.larus.feishu.office.im.impl.smart_reply;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.im.bean.message.Message;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.keyboard.biz.p012float.inject.FloatExpandPlugin$floatExpandActionHandler$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
public final class FlowSmartReplyFloatExpandExtension implements aya.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f343280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlowSmartReplyAIContainerView f343281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public aya.a f343282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public aya.b f343283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f343284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f343285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f343286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s f343287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SmartReplyBundleDataProvider f343288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l0 f343289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f343290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f343291l;

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowSmartReplyFloatExpandExtension f343292a;

        @Override // com.larus.feishu.office.im.impl.smart_reply.v
        public final void a() {
            FlowSmartReplyAIContainerView r100 = this.f343292a.f343281b;
            if (r100 == null) goto L8;
            LinearLayout r101 = r100.f343266d.f343204a;
            if (r101 == null) goto L9;
            r101.setVisibility(4);
            return;
        L9:
            return;
        }

        public a(FlowSmartReplyFloatExpandExtension r100) {
            this.f343292a = r100;
        }

        @Override // com.larus.feishu.office.im.impl.smart_reply.v
        public final void b(int r100) {
            FlowSmartReplyAIContainerView r101 = this.f343292a.f343281b;
            if (r101 == null) goto L10;
            LinearLayout r102 = r101.f343266d.f343204a;
            if (r102 == null) goto L10;
            if (r100 <= 0) goto L8;
            int r103 = 4;
        L9:
            r102.setVisibility(r103);
            goto L10
        L8:
            r103 = 0;
        L10:
            FlowSmartReplyFloatExpandExtension.d(this.f343292a, r100);
        }

        @Override // com.larus.feishu.office.im.impl.smart_reply.v
        public final void onTransitionEnd(int r100) {
            FlowSmartReplyFloatExpandExtension.d(this.f343292a, r100);
            FlowSmartReplyAIContainerView r101 = this.f343292a.f343281b;
            if (r101 == null) goto L8;
            LinearLayout r102 = r101.f343266d.f343204a;
            if (r102 == null) goto L9;
            r102.setVisibility(0);
            return;
        L9:
            return;
        }
    }

    public static final class b implements aya.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowSmartReplyFloatExpandExtension f343293a;

        public b(FlowSmartReplyFloatExpandExtension r100) {
            this.f343293a = r100;
        }

        @Override // aya.f
        public final void l(boolean r100) {
            if (r100 == false) goto L12;
            FlowSmartReplyAIContainerView r101 = this.f343293a.f343281b;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f343268f == null) goto L14;
            Message r102 = r101.f343267e;
            if (r102 == null) goto L10;
            ExposureTrackerExtKt.a(r101, new d(r102, r101));
            return;
        L10:
            r101.f343269g = true;
            return;
        L14:
            return;
        }
    }

    @Override // aya.c
    public final FlowSmartReplyAIContainerView b() {
        Context r100 = this.f343280a.getContext();
        AttributeSet r101 = null;
        if (r100 != null) goto L6;
        FLogger.f375446a.e("FlowFloatExpandExtensionFactory", "takeFloatExpandBriefView context is empty");
        return null;
    L6:
        final FlowSmartReplyAIContainerView r102 = new FlowSmartReplyAIContainerView(r100, r101, 6, 0);
        this.f343281b = r102;
        r102.setOnExpandClickListener(new e(this, r102));
        r102.setOnMessageBindSuccessListener(new f(this));
        r102.setOnGestureListener(new k(this));
        return r102;
    }

    @Override // aya.c
    public final void onDestroy() {
        FLogger.f375446a.i("FlowFloatExpandExtensionFactory", "onDestroy calls");
        FlowSmartReplyAIContainerView r100 = this.f343281b;
        if (r100 == null) goto L7;
        LinearLayout r101 = r100.f343266d.f343204a;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        FlowSmartReplyAIContainerView r102 = this.f343281b;
        if (r102 == null) goto L10;
        r102.setOnExpandClickListener(null);
    L10:
        FlowSmartReplyAIContainerView r103 = this.f343281b;
        if (r103 == null) goto L13;
        r103.setOnGestureListener(null);
    L13:
        FlowSmartReplyAIContainerView r104 = this.f343281b;
        if (r104 == null) goto L16;
        r104.setOnMessageBindSuccessListener(null);
    L16:
        FlowSmartReplyAIContainerView r105 = this.f343281b;
        if (r105 == null) goto L19;
        r105.setBindMessage(null);
    L19:
        FlowSmartReplyAIContainerView r106 = this.f343281b;
        if (r106 == null) goto L24;
        Context r107 = r106.getContext();
        if (r107 == null) goto L24;
        ExposureTrackerExtKt.d(r107);
    L24:
        Job r108 = this.f343285f;
        boolean r109 = true;
        if (r108 == null) goto L27;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L27:
        this.f343285f = null;
        this.f343286g = null;
        this.f343289j.a();
        this.f343287h.a();
        SmartReplyBundleDataProvider r110 = this.f343288i;
        r110.f343295b = null;
        r110.f343296c = null;
        u r111 = this.f343290k;
        l r112 = r111.f343415n;
        if (r112 == null) goto L30;
        r112.PK(r111.f343406e);
    L30:
        Fragment r113 = r111.f343411j;
        if (r113 == null) goto L37;
        t1a.b r114 = s1a.a.g(r113);
        if (r114 == null) goto L37;
        mi8.b r115 = (mi8.b) r114.getAbility(mi8.b.class);
        if (r115 == null) goto L37;
        r115.qY(null);
    L37:
        r111.f343415n = null;
        va8.g0 r116 = r111.f343413l;
        if (r116 == null) goto L40;
        r116.Zh(r111.f343414m);
    L40:
        r111.f343413l = null;
        r111.f343412k = null;
        Fragment r117 = r111.f343411j;
        if (r117 != null) goto L78;
        r117 = r111.f343402a.getChildFragmentManager().findFragmentByTag(r111.f343405d);
    L78:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L53
        if (r117 != null) goto L46;
    L48:
        r109 = false;
    L49:
        if (r109 == false) goto L51;
        r111.f343402a.getChildFragmentManager().beginTransaction().remove(r117).commitNowAllowingStateLoss();     // Catch: Throwable -> L53
    L51:
        Object r119 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L58;
        FLogger.f375446a.e(r111.f343403b, "clearFloatChatFragmentAndContainer remove fragment failed", r120);
    L58:
        FrameLayout r121 = r111.f343410i;
        if (r121 != null) goto L64;
        View r122 = r111.f343402a.getView();
        if (r122 == null) goto L63;
        r121 = (FrameLayout) r122.findViewWithTag(r111.f343404c);
        goto L64
    L63:
        r121 = null;
    L64:
        if (r121 == null) goto L66;
        ViewParent r123 = r121.getParent();
    L68:
        if ((r123 instanceof ViewGroup) == false) goto L70;
        ViewGroup r124 = (ViewGroup) r123;
    L71:
        if (r124 == null) goto L73;
        r124.removeView(r121);
    L73:
        r111.f343411j = null;
        r111.f343410i = null;
        this.f343281b = null;
        this.f343283d = null;
        aya.a r125 = this.f343282c;
        if (r125 == null) goto L76;
        r125.c(null);
    L76:
        this.f343282c = null;
        this.f343284e = false;
        return;
    L70:
        r124 = null;
        goto L71
    L66:
        r123 = null;
        goto L68
    L46:
        if (r117.isAdded() != true) goto L48;
    L53:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.feishu.office.im.impl.smart_reply.h] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.feishu.office.im.impl.smart_reply.i] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.feishu.office.im.impl.smart_reply.j] */
    public FlowSmartReplyFloatExpandExtension(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f343280a = r100;
        this.f343287h = new s();
        this.f343288i = new SmartReplyBundleDataProvider();
        this.f343289j = new l0();
        this.f343290k = new u(r100, new a(this), new h(this), new i(this), new j(this));
        this.f343291l = new b(this);
    }

    @Override // aya.c
    public final void a(FloatExpandPlugin$floatExpandActionHandler$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "actionHandler");
        FLogger.f375446a.i("FlowFloatExpandExtensionFactory", "init calls, actionHandler: " + r100);
        this.f343282c = r100;
        r100.f428379a.f428354v = this.f343291l;
    }

    @Override // aya.c
    public final void c(aya.b r110) {
        Intrinsics.checkNotNullParameter(r110, "floatExpandContext");
        FLogger.f375446a.i("FlowFloatExpandExtensionFactory", "updateFloatExpandContext calls, floatExpandContext: " + r110);
        this.f343289j.a();
        Job r100 = this.f343285f;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f343285f = null;
        this.f343286g = null;
        this.f343283d = r110;
        FlowSmartReplyAIContainerView r101 = this.f343281b;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.f343267e = null;
        r101.f343268f = r110;
        int r102 = r101.f343270h + 1;
        r101.f343270h = r102;
        LifecycleOwner r103 = ViewTreeLifecycleOwner.get(r101);
        if (r103 == null) goto L12;
        LifecycleCoroutineScope r104 = LifecycleOwnerKt.getLifecycleScope(r103);
        if (r104 == null) goto L12;
        BuildersKt.launch$default(r104, null, null, new FlowSmartReplyAIContainerView$bind$1(r110, r102, r101, null), 3, null);
    L12:
        FlowSmartReplyAIContainerView r111 = this.f343281b;
        if (r111 == null) goto L17;
        LinearLayout r112 = r111.f343266d.f343204a;
        if (r112 == null) goto L17;
        r112.setVisibility(0);
    L17:
        this.f343287h.a();
    }

    public final void g(Message r100) {
        if (r100 != null) goto L6;
        FLogger.f375446a.e("FlowFloatExpandExtensionFactory", "prepareDragBundleData message is null");
        return;
    L6:
        String r101 = n.b(r100);
        if (r101 != null) goto L11;
        FLogger.f375446a.e("FlowFloatExpandExtensionFactory", "prepareDragBundleData messageKey is null");
        return;
    L11:
        if (this.f343288i.a(r101) != null) goto L17;
        s r102 = this.f343287h;
        if (r102.f343396a == true) goto L18;
        r102.f343396a = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f343280a), Dispatchers.getMain().getImmediate(), null, new FlowSmartReplyFloatExpandExtension$prepareDragBundleData$1(this, r101, r100, null), 2, null);
        return;
    L18:
        return;
    }

    public static final void d(FlowSmartReplyFloatExpandExtension r110, int r111) {
        l0 r100 = r110.f343289j;
        u r101 = r110.f343290k;
        Fragment r102 = r101.f343411j;
        FlowSmartReplyAIContainerView r103 = r110.f343281b;
        FrameLayout r104 = r101.f343410i;
        View r105 = r110.f343280a.getView();
        ViewGroup r106 = null;
        if ((r105 instanceof ViewGroup) == false) goto L5;
        ViewGroup r107 = (ViewGroup) r105;
    L6:
        ImageView r108 = r100.f343384m;
        FrameLayout r109 = r100.f343383l;
        if (r109 == null) goto L91;
        if (r104 == null) goto L91;
        if (r107 == null) goto L91;
        ViewGroup.LayoutParams r112 = r109.getLayoutParams();
        if ((r112 instanceof FrameLayout.LayoutParams) == false) goto L16;
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r112;
    L17:
        if (r113 == null) goto L91;
        if (r102 == null) goto L21;
        View r114 = r102.getView();
    L23:
        if (r114 != null) goto L25;
        Integer r115 = null;
    L61:
        if (r115 == null) goto L63;
        int r116 = r115.intValue();
    L68:
        if (r113.topMargin != r116) goto L71;
        if (r108 == null) goto L91;
    L72:
        if (r108 == null) goto L74;
        ViewGroup.LayoutParams r117 = r108.getLayoutParams();
    L76:
        if ((r117 instanceof FrameLayout.LayoutParams) == false) goto L78;
        FrameLayout.LayoutParams r118 = (FrameLayout.LayoutParams) r117;
    L79:
        if (r118 == null) goto L91;
        ViewParent r119 = r108.getParent();
        if ((r119 instanceof ViewGroup) == false) goto L84;
        r106 = (ViewGroup) r119;
    L84:
        if (r106 == null) goto L87;
        r107 = r106;
    L87:
        int[] r120 = new int[2];
        int[] r121 = new int[2];
        r104.getLocationOnScreen(r120);
        r107.getLocationOnScreen(r121);
        int r122 = ((r116 + r120[1]) - r121[1]) + r100.f343382k;
        if (r118.topMargin == r122) goto L91;
        r118.topMargin = r122;
        r108.setLayoutParams(r118);
        goto L91
    L78:
        r118 = null;
        goto L79
    L74:
        r117 = null;
        goto L76
    L71:
        r113.topMargin = r116;
        r109.setLayoutParams(r113);
        goto L72
    L63:
        int[] r123 = new int[2];
        int[] r124 = new int[2];
        r104.getLocationOnScreen(r123);
        if (r103 == null) goto L66;
        r103.getLocationOnScreen(r124);
    L66:
        r116 = RangesKt.coerceAtLeast(r124[1] - r123[1], 0);
        goto L68
    L25:
        ViewGroup.LayoutParams r125 = r114.getLayoutParams();
        if ((r125 instanceof FrameLayout.LayoutParams) == false) goto L28;
        FrameLayout.LayoutParams r126 = (FrameLayout.LayoutParams) r125;
    L29:
        if (r126 == null) goto L38;
        Integer r127 = Integer.valueOf(r126.height);
        if (r127.intValue() <= 0) goto L33;
        boolean r128 = true;
    L34:
        if (r128 == true) goto L37;
        r127 = null;
    L37:
        if (r127 == null) goto L38;
    L45:
        Integer r129 = Integer.valueOf(r104.getHeight());
        if (r129.intValue() <= 0) goto L48;
        boolean r130 = true;
    L49:
        if (r130 == true) goto L52;
        r129 = null;
    L52:
        if (r127 == null) goto L59;
        if (r129 == null) goto L59;
        int r131 = r129.intValue() - r127.intValue();
        if (r126 == null) goto L57;
        int r132 = r126.bottomMargin;
    L58:
        r115 = Integer.valueOf(r131 - r132);
        goto L61
    L57:
        r132 = 0;
    L59:
        r115 = Integer.valueOf(r114.getTop());
        goto L61
    L48:
        r130 = false;
        goto L49
    L33:
        r128 = false;
    L38:
        r127 = Integer.valueOf(r114.getHeight());
        if (r127.intValue() <= 0) goto L41;
        boolean r133 = true;
    L42:
        if (r133 == true) goto L45;
        r127 = null;
        goto L45
    L41:
        r133 = false;
        goto L42
    L28:
        r126 = null;
        goto L29
    L21:
        r114 = null;
        goto L23
    L16:
        r113 = null;
    L91:
        r110.f343289j.c(r111);
        FrameLayout r134 = r110.f343289j.f343383l;
        if (r134 == null) goto L95;
        r134.bringToFront();
        return;
    L95:
        return;
    L5:
        r107 = null;
        goto L6
    }

    public static final void f(Message r100, FlowSmartReplyFloatExpandExtension r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getMessageId();
    L6:
        if (r100 == null) goto L8;
        String r104 = com.larus.feishu.office.im.impl.smart_reply.a.a(r100);
    L9:
        aya.b r105 = r101.f343283d;
        if (r105 == null) goto L13;
        String r106 = Long.valueOf(r105.f16773b).toString();
        if (r106 == null) goto L13;
    L16:
        aya.b r107 = r101.f343283d;
        if (r107 == null) goto L19;
        r102 = r107.f16774c;
    L19:
        y99.a.b("expand_details", r104, r103, r102, r106);
        return;
    L13:
        if (r100 == null) goto L15;
        r106 = r100.getReplyId();
        goto L16
    L15:
        r106 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final void e(Bundle r100, String r110, String r111) {
        if (r100 != null) goto L7;
        FLogger.f375446a.e("FlowFloatExpandExtensionFactory", "expandFloatChat bundleData is null");
        return;
    L7:
        if (this.f343284e == false) goto L9;
        return;
    L9:
        View r101 = this.f343280a.getView();
        if ((r101 instanceof ViewGroup) == false) goto L12;
        ViewGroup r102 = (ViewGroup) r101;
    L13:
        ViewGroup r103 = r102;
        if (r103 != null) goto L17;
        FLogger.f375446a.e("FlowFloatExpandExtensionFactory", "expandFloatChat host root is invalid");
        return;
    L17:
        this.f343284e = true;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L20
        this.f343290k.e(r103, r100, r110, r111, this.f343281b);     // Catch: Throwable -> L20
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L25;
        FLogger.f375446a.e("FlowFloatExpandExtensionFactory", "expandFloatChat failed", r106);
    L25:
        this.f343284e = false;
        this.f343287h.a();
        return;
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L12:
        r102 = null;
        goto L13
    }

    public final void h(Bundle r100, String r101, int r102) {
        View r103 = this.f343280a.getView();
        if ((r103 instanceof ViewGroup) == false) goto L5;
        ViewGroup r104 = (ViewGroup) r103;
    L6:
        if (r104 != null) goto L9;
        FLogger.f375446a.e("FlowFloatExpandExtensionFactory", "previewFloatChatHeight host root is invalid");
        return;
    L9:
        u r105 = this.f343290k;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "hostRoot");
        Intrinsics.checkNotNullParameter(r100, "bundleData");
        Intrinsics.checkNotNullParameter(r101, "messageKey");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L22
        if (r105.d(r104, r100, r101) == null) goto L20;
        FrameLayout r107 = r105.f343410i;     // Catch: Throwable -> L22
        if (r107 == null) goto L16;
        r107.bringToFront();     // Catch: Throwable -> L22
    L16:
        l r108 = r105.f343415n;     // Catch: Throwable -> L22
        if (r108 != null) goto L19;
        FLogger.f375446a.e(r105.f343403b, "updateDragPreview dragAbility is null");     // Catch: Throwable -> L22
        goto L20
    L19:
        r108.Uj(r102);     // Catch: Throwable -> L22
    L20:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L30;
        FLogger.f375446a.e(r105.f343403b, "updateDragPreview failed", r110);
        return;
    L30:
        return;
    L22:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L5:
        r104 = null;
        goto L6
    }
}
