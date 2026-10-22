package com.ss.android.lark.officesdk.minutes.ui.record.widget.more;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import bwb.b;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView2;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmMoreActionView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f436788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f436789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f436790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f436791d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmMoreActionView f436792a;

        public a(MmMoreActionView r100) {
            this.f436792a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f436792a.f436788a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = b.f21271a;
        b.g(MmUiLogScene.FOUNDATION, "onAttachedToWindow", null, null, 12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = b.f21271a;
        b.g(MmUiLogScene.FOUNDATION, "onDetachedFromWindow", null, null, 12);
    }

    public MmMoreActionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, null, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmMoreActionView(Context r110, Function0<Unit> r111, Function1<? super View, Unit> r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "title");
        super(r110, null);
        this.f436788a = r111;
        this.f436789b = r112;
        LayoutInflater.from(r110).inflate(R.layout.office_sdk_mm_view_more_action_doubao, this, true);
        int r114 = jwb.a.f500742a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r115 = zvb.a.f573774b;
        setBackground(zvb.a.C8496a.d(r110, Integer.valueOf(R.color.flow_ud_bg_base_3), 12, 12, null, null, 240));
        MmTitleBarView2 r116 = (MmTitleBarView2) findViewById(R.id.titleBar);
        View r117 = findViewById(R.id.feedbackIcon);
        this.f436790c = r117;
        View r100 = findViewById(R.id.mmFeedbackLayout);
        this.f436791d = r100;
        r116.setCloseClickListener(new a(this));
        if ((true ^ StringsKt.isBlank(r113)) == false) goto L5;
        r116.setTitle(r113);
    L5:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r117.setBackground(zvb.a.C8496a.c(r110, Integer.valueOf(R.color.flow_ud_bg_base_4_overlay), 14, null, null, 52));
        h.a(r100, new AnonymousClass2(this));
    }
}
