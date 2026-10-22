package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bwb.b;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingTranslateLanguageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingViewModel f436381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingUILaunchMode f436382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f436383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f436384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmNormalHintSwitchView f436385e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingTranslateLanguageView f436386a;

        public a(MmRecordingTranslateLanguageView r100) {
            this.f436386a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f436386a.f436383c;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner r100 = ViewTreeLifecycleOwner.get(this);
        if (r100 == null) goto L8;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r100);
        if (r101 == null) goto L9;
        int r102 = b.f21271a;
        b.g(MmUiLogScene.LANGUAGE, "onAttachedToWindow", "onAttachedToWindow scope=" + r101, null, 8);
        this.f436381a.selectSubscribe(r101, MmRecordingTranslateLanguageView$onAttachedToWindow$1$1.INSTANCE, new MmRecordingTranslateLanguageView$onAttachedToWindow$1$2(this, null));
        this.f436381a.selectSubscribe(r101, MmRecordingTranslateLanguageView$onAttachedToWindow$1$3.INSTANCE, MmRecordingTranslateLanguageView$onAttachedToWindow$1$4.INSTANCE, new MmRecordingTranslateLanguageView$onAttachedToWindow$1$5(this, null));
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = b.f21271a;
        b.g(MmUiLogScene.LANGUAGE, "onDetachedFromWindow", null, null, 12);
    }

    public MmRecordingTranslateLanguageView(Context r100, MmRecordingViewModel r101, MmRecordingUILaunchMode r102, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        super(r100, null);
        this.f436381a = r101;
        this.f436382b = r102;
        this.f436383c = r110;
        e.f436896a.getClass();
        e.b(r102).getLayout().A(LayoutInflater.from(c.c(r100, r102)), this);
        MmTitleBarView r103 = (MmTitleBarView) findViewById(R.id.titleBar);
        RecyclerView r104 = (RecyclerView) findViewById(R.id.rvLanguageList);
        this.f436384d = r104;
        MmNormalHintSwitchView r105 = (MmNormalHintSwitchView) findViewById(R.id.mmBilingualSwitch);
        this.f436385e = r105;
        ((LinearLayout) findViewById(R.id.mmTranslateBilingualLayout)).setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r100).k(r100));
        MmRecordingViewModel.trackPageView$default(r101, "translation_language_view", null, 2, null);
        r103.setCloseClickListener(new a(this));
        r104.setLayoutManager(new LinearLayoutManager(r100));
        r105.setOnCheckedChangeListener(new AnonymousClass2(this));
        int r106 = uvb.b.f551863a;
        uvb.a.b(this, uvb.c.K);
        uvb.b.a(this, R.id.ivClose, uvb.c.M);
        uvb.b.a(this, R.id.rvLanguageList, uvb.c.L);
        View r107 = findViewById(R.id.mmBilingualSwitch);
        if (r107 == null) goto L6;
        uvb.b.a(r107, R.id.setting_item_switch, uvb.c.N);
        return;
    }
}
