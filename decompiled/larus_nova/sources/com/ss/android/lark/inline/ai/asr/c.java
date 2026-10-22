package com.ss.android.lark.inline.ai.asr;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.asr.subprompt.SubPromptRecyclerView;
import com.ss.android.lark.inline.ai.logic.InlineAIStatus;
import com.ss.android.lark.inline.ai.logic.h;
import com.ss.android.lark.inline.ai.ui.richtext.AIPreviewData;
import com.ss.android.lark.inline.ai.ui.richtext.RichtextPreviewWebview;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import slb.j;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final slb.g f426872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wlb.e f426873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f426874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nsb.b f426875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1<Boolean> f426876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StateFlowImpl f426877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f426878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RichtextPreviewWebview f426879h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f426880a = null;

        static {
            int[] r100 = new int[InlineAIStatus.values().length];
            r100[InlineAIStatus.Init.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[InlineAIStatus.Waiting.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[InlineAIStatus.Writing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[InlineAIStatus.Finished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[InlineAIStatus.Closed.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f426880a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.asr.c$c, reason: collision with other inner class name */
    public static final class C5052c implements com.ss.android.lark.inline.ai.ui.richtext.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f426881a;

        public C5052c(c r100) {
            this.f426881a = r100;
        }

        @Override // com.ss.android.lark.inline.ai.ui.richtext.b
        public final void a(RenderProcessGoneDetail r100) {
            if (Build.VERSION.SDK_INT < 26) goto L8;
            if (r100 == null) goto L6;
            Boolean r101 = Boolean.valueOf(r100.didCrash());
        L7:
            String r102 = String.valueOf(r101);
        L9:
            Log.i("InlineAIPanelController", "onRenderProcessGone== crash: ".concat(r102));
            this.f426881a.a();
            int r103 = zlb.a.f572823d;
            zlb.a.C8475a.e(406, "render gone, crash: " + r102 + '}', 0);
            return;
        L6:
            r101 = null;
            goto L7
        L8:
            r102 = "unknown";
            goto L9
        }
    }

    static {
    }

    public final void a() {
        RichtextPreviewWebview r100 = this.f426879h;
        if (r100 == null) goto L17;
        ViewParent r101 = r100.getParent();     // Catch: Exception -> L12
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L12
    L7:
        RichtextPreviewWebview r102 = this.f426879h;     // Catch: Exception -> L12
        if (r102 == null) goto L10;
        r102.destroy();     // Catch: Exception -> L12
    L10:
        this.f426879h = null;     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.i("InlineAIAsrView", "destroyRichtextPreviewWebview== e: " + e);
        return;
    }

    public final void b() {
        a();
        ((LinearLayout) this.f426874c.findViewById(R.id.operates_rv)).removeAllViews();
        ((SubPromptRecyclerView) this.f426874c.findViewById(R.id.subprompt_rv)).setData(null);
        ((LKUILottieAnimationView) this.f426874c.findViewById(R.id.input_icon_thinking)).cancelAnimation();
        ViewParent r100 = this.f426874c.getParent();
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 != null) goto L8;
    L11:
        BuildersKt.launch$default(this.f426878g, null, null, new InlineAIAsrView$removeFromContainer$2(this, null), 3, null);
        return;
    L8:
        if (Intrinsics.areEqual(r101.getFocusedChild(), this.f426874c) == false) goto L10;
        r101.clearFocus();
    L10:
        r101.removeView(this.f426874c);
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public final void d(com.ss.android.lark.inline.ai.logic.f r110) {
        String r100 = null;
        if (((Boolean) this.f426877f.getValue()).booleanValue() == true) goto L11;
        this.f426874c.getViewTreeObserver().addOnPreDrawListener(new d(this));
        ViewGroup r101 = this.f426872a.f542517d;
        if (r101 == null) goto L7;
        r101.addView(this.f426874c, new ViewGroup.LayoutParams(-1, -1));
    L7:
        c((FrameLayout) this.f426874c.findViewById(R.id.content_container), "...", null, null, null);
        ViewGroup r102 = this.f426872a.f542517d;
        if (r102 == null) goto L10;
        r102.requestChildFocus(this.f426874c, null);
    L10:
        BuildersKt.launch$default(this.f426878g, null, null, new InlineAIAsrView$addToContainer$2(this, null), 3, null);
    L11:
        h r103 = com.ss.android.lark.inline.ai.logic.g.a(r110);
        AppCompatTextView r104 = (AppCompatTextView) this.f426874c.findViewById(R.id.drag_text);
        String r105 = "";
        if (r103 == null) goto L18;
        j r106 = r103.f427300f;
        if (r106 == null) goto L18;
        String r107 = r106.f542537d;
        if (r107 == null) goto L18;
    L19:
        r104.setText(r107);
        FrameLayout r108 = (FrameLayout) this.f426874c.findViewById(R.id.content_container);
        if (r103 == null) goto L22;
        r100 = r103.f427298d;
    L22:
        if (r100 == null) goto L26;
        r105 = r100;
    L26:
        if (r105.length() != 0) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == false) goto L31;
        String r111 = "...";
    L32:
        c(r108, r111, r110.f427289b, com.ss.android.lark.inline.ai.logic.g.b(r110), r110.f427288a);
        return;
    L31:
        r111 = r105;
        goto L32
    L28:
        r109 = false;
    L18:
        r107 = "";
        goto L19
    }

    public c(slb.g r100, InlineAIAsrController.d r101, InlineAIAsrController.c r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "subPromptClickListener");
        this.f426872a = r100;
        this.f426873b = r101;
        View r103 = LayoutInflater.from(r100.getActivity()).inflate(R.layout.inline_ai_asr_panel, r100.f542517d, false);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.f426874c = (ConstraintLayout) r103;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = null;
    L10:
        nsb.b r106 = (nsb.b) r105;
        if (r106 != null) goto L13;
        Log.w("InlineAIAsrView", "MyAIApi SPI not bound, fallback to degraded behavior");
    L13:
        this.f426875d = r106;
        Boolean r107 = Boolean.FALSE;
        i1<Boolean> r108 = j1.a(r107);
        if (r106 == null) goto L19;
        i1<Boolean> r109 = r106.isEnable();
        if (r109 == null) goto L19;
        r108 = r109;
    L19:
        this.f426876e = r108;
        this.f426877f = j1.a(r107);
        this.f426878g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        ((LKUIRoundedImageView2) this.f426874c.findViewById(R.id.drag_icon)).setOnClickListener(new e(this));
        ((AppCompatImageView) this.f426874c.findViewById(R.id.input_stop_icon)).setOnClickListener(new f(this));
        return;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void c(FrameLayout r210, String r211, String r212, String r213, InlineAIStatus r214) {
        if (this.f426879h != null) goto L7;
        FragmentActivity r100 = this.f426872a.getActivity();
        FragmentActivity r101 = this.f426872a.getActivity();
        ScenarioType r110 = ScenarioType.VoiceInput;
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r110, "scenario");
        RichtextPreviewWebview r102 = new RichtextPreviewWebview(r100, new wlb.h(r101, null, this.f426872a.f542517d, new wlb.j(r101), null, null, -1, false, r110, null, true), this.f426873b, new C5052c(this));
        FragmentActivity r103 = this.f426872a.getActivity();
        com.ss.android.lark.storage.a r104 = com.ss.android.lark.inline.ai.logic.b.f427283a;
        r102.setBackgroundColor(ContextCompat.getColor(r103, R.color.bg_float));
        this.f426879h = r102;
        r102.q();
        RichtextPreviewWebview r105 = this.f426879h;
        if (r105 == null) goto L7;
        r105.r(Integer.toHexString(ContextCompat.getColor(this.f426872a.getActivity(), R.color.bg_body_overlay)).substring(2).toUpperCase(Locale.ROOT), "0,16,0,16", "fullscreen");
    L7:
        RichtextPreviewWebview r106 = this.f426879h;
        String r107 = null;
        if (r106 == null) goto L10;
        ViewParent r108 = r106.getParent();
    L12:
        if (Intrinsics.areEqual(r108, r210) == true) goto L16;
        if (r108 == null) goto L15;
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r108).removeView(this.f426879h);
    L15:
        r210.removeAllViews();
        r210.addView(this.f426879h, new FrameLayout.LayoutParams(-1, -1));
    L16:
        boolean r109 = h18.f.a(this.f426872a.getActivity());
        RichtextPreviewWebview r111 = this.f426879h;
        if (r111 != null) goto L19;
        return;
    L19:
        if (r109 == false) goto L21;
        String r112 = "dark";
    L22:
        String r113 = r112;
        String r114 = Integer.toHexString(ContextCompat.getColor(this.f426872a.getActivity(), R.color.bg_body_overlay)).substring(2).toUpperCase(Locale.ROOT);
        if (r214 != InlineAIStatus.Finished) goto L25;
        r107 = VideoEventOneOutSync.END_TYPE_FINISH;
    L25:
        AIPreviewData r115 = new AIPreviewData(r211, null, r212, r213, r113, r114, r107, null, 130, null);
        com.ss.android.lark.inline.ai.ui.richtext.g r116 = r111.S;
        if (r116 == null) goto L30;
        amb.d r117 = r116.f427639g;
        if (r117 == null) goto L30;
        r117.b();
    L30:
        com.ss.android.lark.inline.ai.ui.richtext.g r118 = r111.S;
        if (r118 == null) goto L35;
        r118.a(r115);
        return;
    L35:
        return;
    L21:
        r112 = "light";
        goto L22
    L10:
        r108 = null;
        goto L12
    }
}
