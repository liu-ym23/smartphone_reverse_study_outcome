package com.larus.bot.impl.feature.edit.feature.firstmet;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextWatcher;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.audio.IAudioService;
import com.larus.bot.impl.databinding.LarusLayoutBotFirstMetEditBinding;
import com.larus.bot.impl.feature.edit.feature.firstmet.sugget.BotSuggestsEditPanel;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotFirstMetEditTtsPlayer;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotFirstMetEditTtsPlayer$init$1;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TraceFragment f319160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusLayoutBotFirstMetEditBinding f319161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f319162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dv8.b f319163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f319164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f319165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleCoroutineScope f319166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BotFirstMetEditTtsPlayer f319167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f319168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BotSuggestsEditPanel f319169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ObjectAnimator f319170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f319171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f319172m;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f319173a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(h r100) {
            this.f319173a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            p r104 = this.f319173a.f319162c;
            if (r100 == null) goto L5;
            String r105 = r100.toString();
        L6:
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            r104.dispatchUIAction(new l.e(r105));
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public final void a() {
        this.f319162c.dispatchUIAction(new l.b(this.f319160a.getArguments()));
        p r100 = this.f319162c;
        final BotFirstMetEditTtsPlayer r101 = this.f319167h;
        LifecycleOwner r102 = this.f319160a.getViewLifecycleOwner();
        g r103 = this.f319168i;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r101.f319217a = r103;
        IAudioService r104 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r104 == null) goto L5;
        r104.s0(r103);
    L5:
        r101.f319220d = new WeakReference(r102);
        r102.getLifecycle().addObserver(new BotFirstMetEditTtsPlayer$init$1(r101));
        r100.dispatchUIAction(new l.g());
        if (Build.VERSION.SDK_INT < 28) goto L9;
        int r105 = com.larus.utils.i.d(this.f319165f) - c7.b(64);
        String r106 = this.f319165f.getResources().getString(R.string.larus_create_bot_settings_toggle_off);
        StaticLayout r107 = com.larus.bot.impl.common.util.j.b(this.f319161b.f317864b, r106 + '\n' + r106, r105);
        StaticLayout r108 = com.larus.bot.impl.common.util.j.b(this.f319161b.f317864b, r106 + '\n' + r106 + '\n' + r106 + '\n' + r106, r105);
        this.f319171l = r107.getHeight();
        this.f319172m = r108.getHeight();
        this.f319161b.f317864b.setMinHeight(this.f319171l);
        this.f319161b.f317864b.setMaxHeight(this.f319172m);
    L9:
        com.larus.bot.impl.common.util.j.a(this.f319161b.f317864b);
        this.f319161b.f317864b.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(this.f319165f.getResources().getInteger(R.integer.larus_bot_first_met_edit_prologue_max_length), new b(this))});
        this.f319161b.f317864b.addTextChangedListener(new a(this));
        final dv8.b r109 = this.f319163d;
        if (r109 == null) goto L12;
        this.f319161b.f317864b.setOnFocusChangeListener(new c(r109, this));
    L12:
        this.f319161b.f317869g.setOnClickListener(new d(this));
        e1.d(this.f319161b.f317868f, new e(this));
        this.f319160a.getLifecycle().addObserver(new f(this));
        this.f319161b.f317865c.f317714a.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.n());
        BuildersKt.launch$default(this.f319166g, null, null, new BotFirstMetEditView$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(this.f319162c.getUiEvent(), new BotFirstMetEditView$bindObservers$2(this, null)), this.f319166g);
        this.f319162c.dispatchUIAction(l.h.f319183a);
    }

    public h(TraceFragment r100, LarusLayoutBotFirstMetEditBinding r101, p r102, dv8.b r103, Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "binding");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        Intrinsics.checkNotNullParameter(r104, "showVoiceChoosePage");
        this.f319160a = r100;
        this.f319161b = r101;
        this.f319162c = r102;
        this.f319163d = r103;
        this.f319164e = r104;
        this.f319165f = r101.f317863a.getContext();
        this.f319166g = LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner());
        this.f319167h = new BotFirstMetEditTtsPlayer();
        this.f319168i = new g(this);
        this.f319171l = c7.b(52);
        this.f319172m = c7.b(100);
    }
}
