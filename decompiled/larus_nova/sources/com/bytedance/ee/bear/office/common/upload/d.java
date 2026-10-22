package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f235346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f235347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f235348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f235349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f235350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f235351f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f235352a;

        public a(d r100) {
            this.f235352a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f235352a.f235351f;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f235353a;

        public b(Function0<Unit> r100) {
            this.f235353a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f235353a.invoke();
        }
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ProgressBar r101 = new ProgressBar(r100);
        r101.setIndeterminate(true);
        this.f235346a = r101;
        ImageView r102 = new ImageView(r100);
        r102.setImageResource(R.drawable.office_ic_upload_success);
        this.f235347b = r102;
        ImageView r103 = new ImageView(r100);
        r103.setImageResource(R.drawable.office_ic_upload_warning);
        this.f235348c = r103;
        TextView r104 = new TextView(r100);
        r104.setTextColor(ContextCompat.getColor(r100, R.color.office_upload_text_primary));
        r104.setTextSize(16.0f);
        r104.setTypeface(Typeface.DEFAULT_BOLD);
        r104.setIncludeFontPadding(false);
        r104.setMaxLines(1);
        this.f235349d = r104;
        ImageView r105 = new ImageView(r100);
        r105.setImageResource(R.drawable.office_ic_upload_close);
        r105.setContentDescription(null);
        this.f235350e = r105;
        setBackground(ContextCompat.getDrawable(r100, R.drawable.office_bg_upload_banner));
        setElevation(e.a(r100, 2));
        setVisibility(8);
        setClickable(true);
        addView(r101, a(18, 19));
        addView(r102, a(24, 16));
        addView(r103, a(24, 16));
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.gravity = 16;
        r106.leftMargin = e.a(r100, 48);
        r106.rightMargin = e.a(r100, 48);
        Unit r107 = Unit.INSTANCE;
        addView(r104, r106);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(e.a(r100, 20), e.a(r100, 20));
        r108.gravity = 8388629;
        r108.rightMargin = e.a(r100, 16);
        addView(r105, r108);
        r105.setOnClickListener(new a(this));
    }

    public final void setOnBannerClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        setOnClickListener(new b(r100));
    }

    public final void setOnCloseClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f235351f = r100;
    }

    public final FrameLayout.LayoutParams a(int r100, int r101) {
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(e.a(getContext(), r100), e.a(getContext(), r100));
        r102.gravity = 16;
        r102.leftMargin = e.a(getContext(), r101);
        return r102;
    }
}
