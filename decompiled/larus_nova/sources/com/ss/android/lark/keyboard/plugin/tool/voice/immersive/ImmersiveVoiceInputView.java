package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImmersiveVoiceInputView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f430111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f430112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f430113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IVoiceFaceDependency f430114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioPopupWindowImpl f430115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b0 f430116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GradientDrawable f430117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f430118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> f430119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f430120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f430121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f430122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f430123m;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmersiveVoiceInputView f430124a;

        public a(ImmersiveVoiceInputView r100) {
            this.f430124a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            KeyboardUtils.hideKeyboard(this.f430124a.f430111a);
        L10:
            return false;
        L5:
            if (r101.getAction() != 0) goto L7;
            r102 = true;
            goto L8
        }
    }

    public static final class b implements com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f430125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImmersiveVoiceInputView f430126b;

        public b(Fragment r100, ImmersiveVoiceInputView r101) {
            this.f430125a = r100;
            this.f430126b = r101;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d
        public final ViewGroup a() {
            Fragment r100 = this.f430125a;
            if (r100 == null) goto L7;
            View r101 = r100.getView();
            if (r101 == null) goto L7;
            return gac.a.a(r101, ContextsKt.findActivity(this.f430126b.f430111a));
        L7:
            return null;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmersiveVoiceInputView f430127a;

        public c(ImmersiveVoiceInputView r100) {
            this.f430127a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L5;
            return;
        L5:
            if (this.f430127a.c().isCancelingSession() == false) goto L7;
            return;
        L7:
            if (this.f430127a.c().getImmersiveVoiceMode().b() == false) goto L9;
            this.f430127a.c().updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.m());
            return;
        L9:
            this.f430127a.c().updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.o());
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmersiveVoiceInputView f430128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f430129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> f430130c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(ImmersiveVoiceInputView r100, Function0<Unit> r101, Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r102) {
            this.f430128a = r100;
            this.f430129b = r101;
            this.f430130c = r102;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ImmersiveVoiceInputView r102 = this.f430128a;
            Intrinsics.checkNotNull(r101);
            r102.b(r101.booleanValue(), this.f430129b, this.f430130c);
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmersiveVoiceInputView f430131a;

        public e(ImmersiveVoiceInputView r100) {
            this.f430131a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            ImmersiveVoiceInputView r101 = this.f430131a;
            ImmersiveVoiceInputView.a(r101, r101.f430121k, r101.f430122l);
            return;
        L5:
            ImmersiveVoiceInputView r102 = this.f430131a;
            ImmersiveVoiceInputView.a(r102, r102.f430122l, r102.f430121k);
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmersiveVoiceInputView f430132a;

        public f(ImmersiveVoiceInputView r100) {
            this.f430132a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            x r102 = this.f430132a.f430112b;
            Activity r103 = r102.f430717d;
            Fragment r104 = r102.f430718e;
            if (r103 == null) goto L6;
            if (r104 == null) goto L6;
            return;
        L6:
            Log.e("ImmersiveVoiceKeyboardKey", "activity or fragment is null");
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmersiveVoiceInputView f430133a;

        public g(ImmersiveVoiceInputView r100) {
            this.f430133a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue();
            GradientDrawable r103 = this.f430133a.f430117g;
            if (r103 == null) goto L6;
            r103.setAlpha(r102);
            return;
        }
    }

    public final ImmersiveVoiceViewModel c() {
        return (ImmersiveVoiceViewModel) this.f430123m.getValue();
    }

    public final void e() {
        Fragment r100 = this.f430112b.f430718e;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d r101 = this.f430113c.f430609n;
        if (r101 != null) goto L5;
        this.f430120j = false;
        r101 = new b(r100, this);
    L5:
        AudioPopupWindowImpl r102 = new AudioPopupWindowImpl(this.f430111a, r101);
        float[] r103 = {0.0f, 0.65f, 0.75f};
        GradientDrawable r104 = new GradientDrawable();
        r104.setGradientType(0);
        r104.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r104.setColors(this.f430121k);
        r104.setGradientCenter(r103[0], r103[1]);
        Intrinsics.checkNotNullParameter(r104, "drawable");
        r102.f429947f = r104;
        this.f430117g = r104;
        a r105 = new a(this);
        Intrinsics.checkNotNullParameter(r105, "listener");
        r102.f429944c.setOnTouchListener(r105);
        this.f430115e = r102;
    }

    public final boolean g(Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "afterTrigger");
        int r100 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.g(this.f430111a) == true) goto L36;
        Activity r111 = this.f430112b.f430717d;
        if (r111 == null) goto L7;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.j(r111, ImmersiveVoiceInputView$triggerVoiceRecordIfNeed$1$1.INSTANCE);
    L7:
        return false;
    L36:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        Map<String, com.ss.android.lark.audio.f> r102 = com.ss.android.lark.audio.f.f408976e;     // Catch: Throwable -> L15
        Context r103 = this.f430111a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L15
        com.ss.android.lark.audio.f r104 = (com.ss.android.lark.audio.f) ((ConcurrentHashMap) com.ss.android.lark.audio.f.f408976e).get(r103.toString());     // Catch: Throwable -> L15
        if (r104 == null) goto L12;
        r104.d();     // Catch: Throwable -> L15
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        Log.e("ImmersiveVoiceKeyboardKey", "stop playing audio message failed", r107);
    L20:
        c().setBeforeVoiceEditAsrResult(null);
        ImmersiveVoiceViewModel r108 = c();
        com.ss.android.lark.audio.voiceinput.p r109 = this.f430113c.f430599d;
        int r112 = AudioAsrLanguageSwitcher.f429841i;
        if (r108.startVoiceRecord(r109, AudioAsrLanguageSwitcher.a.a(), "") == true) goto L23;
        return false;
    L23:
        c().setMaxRecordTime(AudioRecordSettings.d().getAudio2TextMaxDuration());
        c().whenVoiceInputStart();
        AudioPopupWindowImpl r113 = this.f430115e;
        if (r113 == null) goto L35;
        AudioPopupWindowImpl.b r114 = r113.f429944c;
        r114.setClickable(true);
        if (this.f430116f != null) goto L28;
        Context r115 = r114.getContext();
        this.f430112b.getClass();
        x r116 = this.f430112b;
        Fragment r117 = r116.f430718e;
        Activity r118 = r116.f430717d;
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity r119 = (FragmentActivity) r118;
        w r120 = this.f430113c;
        b0 r121 = new b0(r115, r114, r117, r119, r120.f430608m, this.f430114d, new ImmersiveVoiceInputView$triggerVoiceRecordIfNeed$2$1(this), r120.f430614s);
        this.f430116f = r121;
        r113.b(r121);
    L28:
        r114.setAlpha(1.0f);
        r113.c();
        if (this.f430117g == null) goto L31;
        ValueAnimator r122 = ObjectAnimator.ofInt(new int[]{0, 255});
        r122.setDuration(150);
        r122.setInterpolator(new LinearInterpolator());
        r122.addUpdateListener(new g(this));
        r122.start();
    L31:
        AudioPopupWindowImpl r123 = this.f430115e;
        if (r123 == null) goto L34;
        r110.invoke(r123);
    L34:
        return true;
    L35:
        return false;
    L12:
        r105 = null;
    L15:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final void d(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "motionEvent");
        int r102 = r101.getAction() & 255;
        if (r102 == 1) goto L6;
        if (r102 == 3) goto L6;
    L8:
        MediatorLiveData<Boolean> r103 = c().getShouldHandleTouchEvent();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (Intrinsics.areEqual(r103.getValue(), Boolean.TRUE) == false) goto L13;
        b0 r104 = this.f430116f;
        if (r104 == null) goto L18;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "motionEvent");
        Log.i(r104.f430267e, "handleTouchEvent:" + r101.getAction());
        r104.f430268f.Y5(r100, r101);
        return;
    L18:
        return;
    L13:
        if (r102 == 1) goto L16;
        if (r102 == 3) goto L16;
        return;
    L16:
        c().whenReleaseOrCancelTouch();
        return;
    L6:
        if (c().isBackgroundAsrKeepSessionMode() == false) goto L8;
        c().requestHidePopupKeepSession();
        goto L8
    }

    public final void f(Function0<Unit> r100, Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "whenPopupWindowDismiss");
        Intrinsics.checkNotNullParameter(r101, "afterPopupWindowDismiss");
        this.f430118h = r100;
        this.f430119i = r101;
        MediatorLiveData<Boolean> r102 = c().getShouldHandleTouchEvent();
        Fragment r103 = this.f430112b.f430718e;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r102.observe(r103, new c(this));
        MutableLiveData<Boolean> r104 = c().getPopupWindowVisible();
        Fragment r105 = this.f430112b.f430718e;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r104.observe(r105, new d(this, r100, r101));
        MutableLiveData<Boolean> r106 = c().getAsrResultFocused();
        Fragment r107 = this.f430112b.f430718e;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r106.observe(r107, new e(this));
        MutableLiveData<String> r108 = c().getStartMention();
        Fragment r109 = this.f430112b.f430718e;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r108.observe(r109, new f(this));
    }

    public static final void a(ImmersiveVoiceInputView r100, int[] r101, int[] r102) {
        r100.getClass();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(200);
        r103.setInterpolator(new LinearInterpolator());
        r103.addUpdateListener(new y(r100, r101, r102));
        r103.start();
    }

    public final void b(boolean r100, Function0<Unit> r101, final Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> r102) {
        if (r100 == true) goto L21;
        final boolean r103 = c().consumeKeepSessionOnPopupHide$keyboard_biz_voice_release();
        AudioPopupWindowImpl r104 = this.f430115e;
        if (r104 != null) goto L6;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L19;
        if (r103 == true) goto L24;
        c().updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.j());
        ImmersiveVoiceViewModel.resetLiveData$default(c(), false, 1, null);
        return;
    L24:
        return;
    L19:
        if (r104 == null) goto L21;
        Function0<Unit> r106 = new ImmersiveVoiceInputView$dismissPopupWindow$1(this, r103, r102);
        r104.f429948g = true;
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r107.setDuration(150);
        r107.setInterpolator(new LinearInterpolator());
        r107.addUpdateListener(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.a(r104));
        Intrinsics.checkNotNull(r107);
        r107.addListener(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.b(r106, r104));
        r107.start();
        goto L21
    L6:
        if (r104.f429948g == false) goto L8;
    L11:
        boolean r108 = true;
    L12:
        if (r108 != true) goto L14;
        r105 = true;
        goto L15
    L8:
        if (r104.f429949h == false) goto L11;
        r108 = false;
    L21:
        if (r101 == null) goto L25;
        r101.invoke();
        return;
    }

    public ImmersiveVoiceInputView(Context r100, x r101, w r102, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "voiceInputDependency");
        Intrinsics.checkNotNullParameter(r102, "voiceInputConfig");
        this.f430111a = r100;
        this.f430112b = r101;
        this.f430113c = r102;
        this.f430114d = r103;
        this.f430120j = true;
        if (h18.f.a(r100) == false) goto L5;
        int[] r104 = {UIUtils.getColor(r100, R.color.voice_popup_background_top_night), UIUtils.getColor(r100, R.color.voice_popup_background_middle_night), UIUtils.getColor(r100, R.color.voice_popup_background_bottom_night)};
    L6:
        this.f430121k = r104;
        if (h18.f.a(r100) == false) goto L9;
        int[] r105 = {UIUtils.getColor(r100, R.color.voice_popup_background_bottom_night), UIUtils.getColor(r100, R.color.voice_popup_background_bottom_night), UIUtils.getColor(r100, R.color.voice_popup_background_bottom_night)};
    L10:
        this.f430122l = r105;
        this.f430123m = LazyKt.lazy(new ImmersiveVoiceInputView$immersiveVoiceViewModel$2(this));
        return;
    L9:
        r105 = new int[]{UIUtils.getColor(r100, R.color.voice_popup_background_bottom_light), UIUtils.getColor(r100, R.color.voice_popup_background_bottom_light), UIUtils.getColor(r100, R.color.voice_popup_background_bottom_light)};
        goto L10
    L5:
        r104 = new int[]{UIUtils.getColor(r100, R.color.voice_popup_background_top_light), UIUtils.getColor(r100, R.color.voice_popup_background_middle_light), UIUtils.getColor(r100, R.color.voice_popup_background_bottom_light)};
        goto L6
    }
}
