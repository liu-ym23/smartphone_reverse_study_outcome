package com.larus.dora.impl.onboarding.lite;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraOnboardingMusicPanelBinding;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2WakeupBinding;
import com.larus.dora.impl.onboarding.DoraOnboardingNestedScrollView;
import com.larus.dora.impl.onboarding.ext.AnimViewType;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.settings.f1;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\nH\u0002J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingWakeupFragment;", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2WakeupBinding;", "currentUiState", "Lcom/larus/dora/impl/onboarding/lite/WakeupQueryUiState;", "enterPageTracedMap", "", "", "", "mainHandler", "Landroid/os/Handler;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupAvatar", "onDestroyView", "onSkipButtonClicked", "updateUiState", "uiState", "gotoNextStep", "autoLogEnterPage", "", "autoLogExitPage", "getCurrentPageName", "reportPageShow", "page", "reportPageStay", "nextPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingWakeupFragment extends DoraLiteOnboardingBaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f336916s = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LarusDoraOnboardingV2WakeupBinding f336917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public y0 f336918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, Long> f336919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f336920r;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment f336921a;

        public a(DoraLiteOnboardingWakeupFragment r100) {
            this.f336921a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r110, Continuation r111) {
            y0 r112 = (y0) r110;
            final DoraLiteOnboardingWakeupFragment r113 = this.f336921a;
            final LarusDoraOnboardingV2WakeupBinding r100 = r113.f336917o;
            if (r100 == null) goto L125;
            r113.f336920r.removeCallbacksAndMessages(null);
            String r101 = r112.f337019a;
            boolean r102 = true;
            if (r101.length() <= 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == false) goto L21;
            Map<String, Long> r104 = r113.f336919q;
            if (r104.isEmpty() == true) goto L18;
            Iterator r105 = ((LinkedHashMap) r104).entrySet().iterator();
        L14:
            if (r105.hasNext() == false) goto L18;
            if (Intrinsics.areEqual(((Map.Entry) r105.next()).getKey(), r101) == false) goto L14;
            boolean r106 = false;
        L19:
            if (r106 == false) goto L21;
            r113.f336919q.put(r101, Long.valueOf(SystemClock.elapsedRealtime()));
            int r107 = com.larus.dora.impl.onboarding.m0.f337029a;
            com.larus.dora.impl.onboarding.m0.g(r101, r113.f336546g, null);
        L18:
            r106 = true;
        L21:
            r113.fa0(r113.f336918p.f337019a, r112.f337019a);
            boolean r108 = !Intrinsics.areEqual(r113.f336918p, r112);
            r113.f336918p = r112;
            DoraOnboardingNestedScrollView r109 = r100.f332830a;
            boolean r114 = r112 instanceof y0.g;
            if (r114 == false) goto L24;
        L29:
            boolean r115 = true;
        L30:
            r109.setScrollEnabled(r115);
            if (r108 == false) goto L33;
            r100.f332830a.post(new i0(r100));
        L33:
            long r116 = 15000;
            if (r114 == false) goto L42;
            b69.w.l(r100.f332831b, false, 2);
            b69.w.l(r100.f332835f, false, 2);
            b69.w.l(r100.f332837h, false, 2);
            b69.w.l(r100.f332839j, false, 2);
            e1.x(r100.f332844o);
            r100.f332844o.setText(f69.b.a(r112));
            e1.x(r100.f332843n);
            e1.o(r100.f332841l);
            e1.o(r100.f332842m);
            b69.w.i(r100.f332840k);
            TextView r117 = r113.f336547h;
            if (r117 == null) goto L38;
            r117.setText(R.string.larus_dora_btn_retry_later_cn);
            e1.d(r117, new j0(r113));
        L38:
            Handler r118 = r113.f336920r;
            if (((y0.g) r112).f337026b == false) goto L41;
            r116 = 3000;
        L41:
            r118.postDelayed(new r0(r113), r116);
            goto L125
        L42:
            y0.e r119 = y0.e.f337024b;
            if (Intrinsics.areEqual(r112, r119) == false) goto L45;
        L103:
            b69.w.k(r100.f332831b, AnimViewType.AVATAR);
            RelativeLayout r120 = r100.f332837h;
            AnimViewType r121 = AnimViewType.BUBBLE;
            b69.w.k(r120, r121);
            b69.w.k(r100.f332839j, r121);
            b69.w.k(r100.f332835f, AnimViewType.BUBBLE_BACKGROUND);
            e1.o(r100.f332844o);
            e1.o(r100.f332843n);
            if (Intrinsics.areEqual(r112, r119) == false) goto L106;
            b69.w.m(r100.f332840k);
        L107:
            DoraTextView r122 = r100.f332841l;
            r122.setText(f69.b.a(r112));
            Intrinsics.checkNotNull(r122);
            b69.w.a(r122);
            b69.w.a(r100.f332842m);
            if (r108 == false) goto L113;
            TextView r123 = r113.f336547h;
            if (r123 == null) goto L113;
            e1.o(r123);
        L113:
            if (Intrinsics.areEqual(r112, r119) == false) goto L116;
            r113.f336920r.postDelayed(new s0(r113), 3000);
            goto L125
        L116:
            if ((r112 instanceof y0.d) == false) goto L125;
            TextView r124 = r113.f336547h;
            if (r124 == null) goto L120;
            r124.setText(R.string.larus_dora_btn_retry_later_cn);
            e1.d(r124, new k0(r113));
        L120:
            Handler r125 = r113.f336920r;
            if (((y0.d) r112).f337023b == false) goto L123;
            r116 = 3000;
        L123:
            r125.postDelayed(new t0(r113), r116);
            goto L125
        L106:
            b69.w.i(r100.f332840k);
            goto L107
        L45:
            if ((r112 instanceof y0.d) == true) goto L103;
            if ((r112 instanceof y0.b) == false) goto L72;
            b69.w.l(r100.f332831b, false, 3);
            ImageView r126 = r100.f332835f;
            if (r126.getVisibility() != 0) goto L52;
            boolean r127 = true;
        L53:
            b69.w.l(r126, r127, 2);
            RelativeLayout r128 = r100.f332837h;
            if (r128.getVisibility() != 0) goto L56;
            boolean r129 = true;
        L57:
            b69.w.l(r128, r129, 2);
            LottieAdapterView r130 = r100.f332839j;
            if (r130.getVisibility() == 0) goto L61;
            r102 = false;
        L61:
            b69.w.l(r130, r102, 2);
            e1.o(r100.f332842m);
            e1.o(r100.f332841l);
            e1.o(r100.f332844o);
            e1.o(r100.f332843n);
            b69.w.n(r100.f332840k, ((y0.b) r112).f337021b);
            TextView r131 = r113.f336547h;
            if (r131 == null) goto L64;
            r131.setText(R.string.larus_dora_btn_continue_cn);
            e1.d(r131, new l0(r113));
        L64:
            if (r108 == false) goto L69;
            TextView r132 = r113.f336547h;
            if (r132 == null) goto L68;
            e1.o(r132);
        L68:
            r113.f336920r.postDelayed(new u0(r113), 2000);
            goto L125
        L69:
            TextView r133 = r113.f336547h;
            if (r133 == null) goto L125;
            e1.x(r133);
            goto L125
        L56:
            r129 = false;
            goto L57
        L52:
            r127 = false;
            goto L53
        L72:
            y0.c r134 = y0.c.f337022b;
            if (Intrinsics.areEqual(r112, r134) == false) goto L75;
        L84:
            b69.w.l(r100.f332831b, false, 3);
            ImageView r135 = r100.f332835f;
            if (r135.getVisibility() != 0) goto L87;
            boolean r136 = true;
        L88:
            b69.w.l(r135, r136, 2);
            RelativeLayout r137 = r100.f332837h;
            if (r137.getVisibility() != 0) goto L91;
            boolean r138 = true;
        L92:
            b69.w.l(r137, r138, 2);
            LottieAdapterView r139 = r100.f332839j;
            if (r139.getVisibility() == 0) goto L96;
            r102 = false;
        L96:
            b69.w.l(r139, r102, 2);
            e1.o(r100.f332842m);
            e1.o(r100.f332841l);
            if (Intrinsics.areEqual(r112, r134) == false) goto L99;
            b69.w.b(r100.f332840k);
        L100:
            DoraTextView r140 = r100.f332844o;
            r140.setText(f69.b.a(r112));
            Intrinsics.checkNotNull(r140);
            b69.w.a(r140);
            DoraUrlSpanTextView r141 = r100.f332843n;
            int r142 = com.larus.utils.j0.f375426a;
            r141.setUrlSpannedText(com.larus.utils.j0.d(R.string.larus_dora_onboarding_query_hint_cn));
            Intrinsics.checkNotNull(r141);
            b69.w.a(r141);
            TextView r143 = r113.f336547h;
            if (r143 == null) goto L125;
            r143.setText(R.string.larus_dora_btn_continue_cn);
            e1.x(r143);
            e1.d(r143, new m0(r113));
            goto L125
        L99:
            b69.w.i(r100.f332840k);
            goto L100
        L91:
            r138 = false;
            goto L92
        L87:
            r136 = false;
            goto L88
        L75:
            if (Intrinsics.areEqual(r112, y0.a.f337020b) == true) goto L84;
            if (Intrinsics.areEqual(r112, y0.f.f337025b) == false) goto L83;
            b69.w.k(r100.f332831b, AnimViewType.AVATAR);
            RelativeLayout r144 = r100.f332837h;
            AnimViewType r145 = AnimViewType.BUBBLE;
            b69.w.k(r144, r145);
            b69.w.k(r100.f332839j, r145);
            b69.w.k(r100.f332835f, AnimViewType.BUBBLE_BACKGROUND);
            e1.o(r100.f332844o);
            e1.o(r100.f332843n);
            b69.w.i(r100.f332840k);
            b69.w.a(r100.f332842m);
            DoraTextView r146 = r100.f332841l;
            r146.setText(f69.b.a(r112));
            Intrinsics.checkNotNull(r146);
            b69.w.a(r146);
            TextView r147 = r113.f336547h;
            if (r147 == null) goto L125;
            r147.setText(R.string.larus_dora_btn_continue_cn);
            e1.x(r147);
            e1.d(r147, new n0(r113));
            goto L125
        L83:
            throw new NoWhenBranchMatchedException();
        L24:
            if (Intrinsics.areEqual(r112, y0.c.f337022b) == true) goto L29;
            if (Intrinsics.areEqual(r112, y0.a.f337020b) == true) goto L29;
            r115 = false;
            goto L30
        L7:
            r103 = false;
        L125:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment f336922a;

        public b(DoraLiteOnboardingWakeupFragment r100) {
            this.f336922a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            byte[] r102 = (byte[]) r100;
            LarusDoraOnboardingV2WakeupBinding r103 = this.f336922a.f336917o;
            if (r103 == null) goto L8;
            CustomBarCountAudioVisualizer r104 = r103.f332834e;
            if (r104 == null) goto L8;
            r104.post(new o0(r104, r102));
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment f336923a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f336924a = null;

            static {
                int[] r100 = new int[AvatarUiState.values().length];
                r100[AvatarUiState.WAITING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[AvatarUiState.THINKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[AvatarUiState.SPEAKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f336924a = r100;
            }
        }

        public c(DoraLiteOnboardingWakeupFragment r100) {
            this.f336923a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            int r102 = a.f336924a[((AvatarUiState) r100).ordinal()];
            if (r102 != 1) goto L5;
            LarusDoraOnboardingV2WakeupBinding r103 = this.f336923a.f336917o;
            if (r103 == null) goto L20;
            e1.q(r103.f332839j);
            e1.q(r103.f332837h);
            e1.q(r103.f332835f);
        L20:
            return Unit.INSTANCE;
        L5:
            if (r102 != 2) goto L7;
            LarusDoraOnboardingV2WakeupBinding r104 = this.f336923a.f336917o;
            if (r104 == null) goto L20;
            r104.f332839j.playAnimation();
            e1.q(r104.f332837h);
            e1.x(r104.f332839j);
            e1.x(r104.f332835f);
            goto L20
        L7:
            if (r102 != 3) goto L12;
            LarusDoraOnboardingV2WakeupBinding r105 = this.f336923a.f336917o;
            if (r105 == null) goto L20;
            e1.q(r105.f332839j);
            e1.x(r105.f332837h);
            e1.x(r105.f332835f);
            goto L20
        L12:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment f336925a;

        public d(DoraLiteOnboardingWakeupFragment r100) {
            this.f336925a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            boolean r102 = ((Boolean) r100).booleanValue();
            if (Intrinsics.areEqual(this.f336925a.f336918p, y0.f.f337025b) == false) goto L21;
            LarusDoraOnboardingV2WakeupBinding r103 = this.f336925a.f336917o;
            if (r103 == null) goto L21;
            DoraTextView r104 = r103.f332841l;
            if (r104 == null) goto L21;
            if (r102 == false) goto L14;
            String r105 = (String) CollectionsKt.getOrNull(f69.b.b(), 1);
            if (r105 != null) goto L19;
            r105 = (String) CollectionsKt.getOrNull(f1.f338029b, 1);
            if (r105 != null) goto L19;
        L18:
            r105 = "";
        L19:
            r104.setText(r105);
            goto L21
        L14:
            r105 = (String) CollectionsKt.getOrNull(f69.b.b(), 3);
            if (r105 != null) goto L19;
            r105 = (String) CollectionsKt.getOrNull(f1.f338029b, 3);
            if (r105 != null) goto L19;
        L21:
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment f336926a;

        public e(DoraLiteOnboardingWakeupFragment r100) {
            this.f336926a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            boolean r102 = ((Boolean) r100).booleanValue();
            LarusDoraOnboardingV2WakeupBinding r103 = this.f336926a.f336917o;
            if (r103 == null) goto L13;
            LarusDoraOnboardingMusicPanelBinding r104 = r103.f332840k;
            if (r104 == null) goto L13;
            ImageView r105 = r104.f332808e;
            if (r105 == null) goto L13;
            if (r102 == false) goto L10;
            int r106 = R.drawable.larus_dora_onboarding_ic_music_pause;
        L11:
            r105.setImageResource(r106);
            goto L13
        L10:
            r106 = R.drawable.larus_dora_onboarding_ic_music_play;
        L13:
            return Unit.INSTANCE;
        }
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return this.f336918p.f337019a;
    }

    public DoraLiteOnboardingWakeupFragment() {
        this.f336918p = new y0.g(false);
        this.f336919q = new LinkedHashMap();
        this.f336920r = new Handler(Looper.getMainLooper());
    }

    @Override // com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        da0();
        ca0().stopTTS("onSkipButtonClicked");
    }

    public final void ea0() {
        ca0().getDoraOnboardingDevice();
        ca0().stopTTS("gotoNextStep");
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L7;
        SessionService r101 = r100.d();
        if (r101 == null) goto L7;
        r101.q(200);
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraLiteOnboardingWakeupFragment$gotoNextStep$1(this, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f336920r.removeCallbacksAndMessages(null);
        fa0(this.f336918p.f337019a, "");
        com.larus.dora.impl.onboarding.d.c(null);
    }

    public final void fa0(String r100, String r101) {
        boolean r102 = false;
        if (r100.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r100, r101) == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r100, "voice_wakeup_guidance") == false) goto L12;
    L13:
        TextView r104 = this.f336547h;
        if (r104 != null) goto L16;
    L21:
        Long r105 = (Long) ((LinkedHashMap) this.f336919q).get(r100);
        if (r105 == null) goto L24;
        long r106 = r105.longValue();
    L25:
        long r107 = SystemClock.elapsedRealtime() - r106;
        int r108 = com.larus.dora.impl.onboarding.m0.f337029a;
        com.larus.dora.impl.onboarding.m0.h(r100, r107, r102);
        return;
    L24:
        r106 = 0;
        goto L25
    L16:
        if (r104.getVisibility() != 0) goto L18;
        boolean r109 = true;
    L19:
        if (r109 != true) goto L21;
        r102 = true;
        goto L21
    L18:
        r109 = false;
        goto L19
    L12:
        if (Intrinsics.areEqual(r100, "first_conversation_guidance") == false) goto L21;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        TextView r100 = this.f336547h;
        if (r100 == null) goto L5;
        e1.o(r100);
    L5:
        boolean r101 = com.larus.dora.impl.onboarding.d.f336616a;
        LarusDoraOnboardingV2WakeupBinding r102 = this.f336917o;
        if (r102 == null) goto L8;
        CustomBarCountAudioVisualizer r103 = r102.f332834e;
    L9:
        com.larus.dora.impl.onboarding.d.c(new WeakReference(r103));
        ca0().fetchAvatarUrl();
        Lifecycle.State r104 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$setupAvatar$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r104, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r104, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r104, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r104, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r104, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r104, null, this), 3, null);
        ca0().enterVoiceOnlyMode();
        ca0().playOpeningRemarksTTS();
        return;
    L8:
        r103 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        LarusDoraOnboardingV2WakeupBinding r103 = LarusDoraOnboardingV2WakeupBinding.a(r100, r101);
        DoraUrlSpanTextView r104 = r103.f332843n;
        int r105 = com.larus.utils.j0.f375426a;
        r104.setUrlSpannedText(com.larus.utils.j0.d(R.string.larus_dora_onboarding_wakeup_hint_cn));
        CustomBarCountAudioVisualizer r106 = r103.f332834e;
        r106.setMaxSampleData(0.8d);
        r106.setColor(ColorProtector.parseColor("#00B2FF"));
        r103.f332839j.setAnimation(R.raw.larus_realtime_call_thinking);
        r103.f332838i.setAnimation(R.raw.larus_realtime_call_speaking);
        this.f336917o = r103;
        return r103.f332830a;
    }
}
