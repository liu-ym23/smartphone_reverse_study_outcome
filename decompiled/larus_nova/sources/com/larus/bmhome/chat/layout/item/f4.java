package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.databinding.LarusLayoutFileCardBinding;
import com.larus.bmhome.view.FileNameView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f4 extends xc8.h {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f304358s = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f304359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CircleProgressBarView f304360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LarusLayoutFileCardBinding f304361r;

    public f4(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        FrameLayout r100 = new FrameLayout(r110);
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r100.setBackgroundColor(ContextCompat.getColor(r110, R.color.larus_static_black_transparent_1));
        this.f304359p = r100;
        int r101 = r110.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_20, r110, R.dimen.larus_dp_20));
        CircleProgressBarView r102 = new CircleProgressBarView(r110, null, 6, 0);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(r101, r101);
        r103.gravity = 17;
        r102.setLayoutParams(r103);
        r102.a(10.0f, 2.5f);
        this.f304360q = r102;
        View r111 = LayoutInflater.from(r110).inflate(R.layout.larus_layout_file_card, this, false);
        addView(r111);
        int r104 = R.id.file_name;
        FileNameView r105 = (FileNameView) ViewBindings.findChildViewById(r111, R.id.file_name);
        if (r105 == null) goto L15;
        r104 = R.id.image_container;
        CardView r106 = (CardView) ViewBindings.findChildViewById(r111, R.id.image_container);
        if (r106 == null) goto L15;
        r104 = R.id.image_view;
        AppCompatImageView r107 = (AppCompatImageView) ViewBindings.findChildViewById(r111, R.id.image_view);
        if (r107 == null) goto L15;
        r104 = R.id.ll_upload_file;
        LinearLayout r108 = (LinearLayout) ViewBindings.findChildViewById(r111, R.id.ll_upload_file);
        if (r108 == null) goto L15;
        RelativeLayout r109 = (RelativeLayout) r111;
        r104 = R.id.tvTips;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r111, R.id.tvTips);
        if (r112 == null) goto L15;
        this.f304361r = new LarusLayoutFileCardBinding(r109, r105, r106, r107, r108, r112);
        r106.addView(r100);
        r106.addView(r102);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r104)));
    }

    public final void setProcess(long r100) {
        this.f304360q.setProgress(r100);
    }

    public final void n(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        if (r100 == false) goto L24;
        LarusLayoutFileCardBinding r102 = this.f304361r;
        if (r102 == null) goto L9;
        CardView r103 = r102.f311022c;
        if (r103 == null) goto L9;
        com.larus.utils.e1.o(r103);
    L9:
        LarusLayoutFileCardBinding r104 = this.f304361r;
        if (r104 == null) goto L14;
        FileNameView r105 = r104.f311021b;
        if (r105 == null) goto L14;
        com.larus.utils.e1.o(r105);
    L14:
        LarusLayoutFileCardBinding r106 = this.f304361r;
        if (r106 == null) goto L19;
        LinearLayout r107 = r106.f311024e;
        if (r107 == null) goto L19;
        com.larus.utils.e1.x(r107);
    L19:
        LarusLayoutFileCardBinding r108 = this.f304361r;
        if (r108 == null) goto L40;
        TextView r109 = r108.f311025f;
        if (r109 == null) goto L41;
        r109.setText(r101);
        return;
    L41:
        return;
    L40:
        return;
    L24:
        LarusLayoutFileCardBinding r110 = this.f304361r;
        if (r110 == null) goto L29;
        CardView r111 = r110.f311022c;
        if (r111 == null) goto L29;
        com.larus.utils.e1.x(r111);
    L29:
        LarusLayoutFileCardBinding r112 = this.f304361r;
        if (r112 == null) goto L34;
        FileNameView r113 = r112.f311021b;
        if (r113 == null) goto L34;
        com.larus.utils.e1.x(r113);
    L34:
        LarusLayoutFileCardBinding r114 = this.f304361r;
        if (r114 == null) goto L43;
        LinearLayout r115 = r114.f311024e;
        if (r115 == null) goto L44;
        com.larus.utils.e1.o(r115);
        return;
    L44:
        return;
    }
}
