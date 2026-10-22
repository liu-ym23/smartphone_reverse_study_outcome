package com.larus.bot.impl.feature.edit.feature.bio;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextWatcher;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.n;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bot.impl.databinding.LarusLayoutBotBioEditBinding;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutBotBioEditBinding f319101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f319102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f319103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleCoroutineScope f319104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f319105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f319106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f319107g;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f319108a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(f r100) {
            this.f319108a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            i r104 = this.f319108a.f319102b;
            if (r100 == null) goto L5;
            String r105 = r100.toString();
        L6:
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            r104.dispatchUIAction(new com.larus.bot.impl.feature.edit.feature.bio.a.b(r105));
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public final void a() {
        this.f319102b.dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bio.a.C4134a.f319092a);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        int r100 = com.larus.utils.i.d(this.f319103c) - c7.b(64);
        String r101 = this.f319103c.getResources().getString(R.string.larus_create_bot_settings_toggle_off);
        StaticLayout r102 = com.larus.bot.impl.common.util.j.b(this.f319101a.f317831b, r101 + '\n' + r101, r100);
        StaticLayout r103 = com.larus.bot.impl.common.util.j.b(this.f319101a.f317831b, r101 + '\n' + r101 + '\n' + r101 + '\n' + r101, r100);
        this.f319106f = r102.getHeight();
        this.f319107g = r103.getHeight();
        this.f319101a.f317831b.setMinHeight(this.f319106f);
        this.f319101a.f317831b.setMaxHeight(this.f319107g);
    L6:
        com.larus.bot.impl.common.util.j.a(this.f319101a.f317831b);
        this.f319101a.f317831b.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(this.f319103c.getResources().getInteger(R.integer.larus_bot_bio_max_length), new e(this))});
        this.f319101a.f317831b.addTextChangedListener(new a(this));
        this.f319101a.f317832c.f317714a.setOnTouchListener(new n());
        BuildersKt.launch$default(this.f319104d, null, null, new BotBioEditView$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(this.f319102b.getUiEvent(), new BotBioEditView$bindObservers$2(this, null)), this.f319104d);
        this.f319102b.dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bio.a.c.f319094a);
    }

    public f(TraceFragment r100, LarusLayoutBotBioEditBinding r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "binding");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f319101a = r101;
        this.f319102b = r102;
        this.f319103c = r101.f317830a.getContext();
        this.f319104d = LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner());
        this.f319106f = c7.b(52);
        this.f319107g = c7.b(100);
    }
}
