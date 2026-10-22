package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import bwb.b;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmNormalHintSwitchView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
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
public final class MmRecordingLanguageChooseView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingViewModel f436362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f436363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f436364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f436365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f436366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmNormalHintSwitchView f436367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MmNormalHintSwitchView f436368g;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner r100 = ViewTreeLifecycleOwner.get(this);
        if (r100 == null) goto L8;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r100);
        if (r101 == null) goto L9;
        int r102 = b.f21271a;
        b.g(MmUiLogScene.LANGUAGE, "onAttachedToWindow", "onAttachedToWindow scope=" + r101, null, 8);
        this.f436362a.selectSubscribe(r101, MmRecordingLanguageChooseView$onAttachedToWindow$1$1.INSTANCE, new MmRecordingLanguageChooseView$onAttachedToWindow$1$2(this, null));
        this.f436362a.selectSubscribe(r101, MmRecordingLanguageChooseView$onAttachedToWindow$1$3.INSTANCE, new MmRecordingLanguageChooseView$onAttachedToWindow$1$4(this, null));
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

    public MmRecordingLanguageChooseView(Context r100, MmRecordingViewModel r101, MmRecordingUILaunchMode r102, Function0 r103, Function0 r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        super(r100, null);
        this.f436362a = r101;
        this.f436363b = r103;
        this.f436364c = null;
        this.f436365d = r104;
        this.f436366e = r105;
        e.f436896a.getClass();
        e.b(r102).getLayout().b(LayoutInflater.from(c.c(r100, r102)), this);
        MmTitleBarView r106 = (MmTitleBarView) findViewById(R.id.titleBar);
        LinearLayout r107 = (LinearLayout) findViewById(R.id.languageSettingLayout);
        MmNormalHintSwitchView r108 = (MmNormalHintSwitchView) findViewById(R.id.mmSpokenLanguage);
        this.f436367f = r108;
        MmNormalHintSwitchView r109 = (MmNormalHintSwitchView) findViewById(R.id.mmTranslateLanguage);
        this.f436368g = r109;
        r107.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r100).k(r100));
        r106.setCloseClickListener(new a(this));
        h.a(r108, new AnonymousClass2(this));
        h.a(r109, new AnonymousClass3(this));
        int r110 = uvb.b.f551863a;
        uvb.b.a(this, R.id.languageSettingLayout, uvb.c.f551893x);
        uvb.b.a(this, R.id.ivClose, uvb.c.f551894y);
        View r111 = findViewById(R.id.mmSpokenLanguage);
        if (r111 == null) goto L5;
        uvb.b.a(r111, R.id.setting_item_content, uvb.c.f551895z);
        uvb.b.a(r111, R.id.setting_item_icon_desc, uvb.c.A);
    L5:
        View r112 = findViewById(R.id.mmTranslateLanguage);
        if (r112 == null) goto L9;
        uvb.b.a(r112, R.id.setting_item_content, uvb.c.D);
        uvb.b.a(r112, R.id.setting_item_icon_desc, uvb.c.E);
        return;
    }
}
