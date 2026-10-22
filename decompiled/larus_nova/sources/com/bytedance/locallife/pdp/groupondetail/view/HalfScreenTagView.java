package com.bytedance.locallife.pdp.groupondetail.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import bx6.a;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.utils.e;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import dx6.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/view/HalfScreenTagView;", "Landroid/widget/LinearLayout;", "Ldx6/f;", "vo", "", "setVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class HalfScreenTagView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f261425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f261426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f261427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxTextView f261428d;

    public HalfScreenTagView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HalfScreenTagView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setVO(f r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        this.f261426b.setText(r100.d());
        if (TextUtils.isEmpty(r100.e()) == false) goto L5;
        this.f261427c.setVisibility(8);
        return;
    L5:
        this.f261428d.setText(r100.e());
        TextPaint r101 = this.f261428d.getPaint();
        if (r101 == null) goto L8;
        float r102 = r101.measureText(r100.e());
    L10:
        if (r102 <= 0) goto L12;
        int r103 = a.c(e.b(Double.valueOf(12.5d)));
        this.f261426b.setMaxWidth(MathKt.roundToInt(((com.bytedance.locallife.biz.common.utils.e.b() - e.b(48)) - r103) - (r102 + e.b(8))) - 1);
    L12:
        this.f261427c.setVisibility(0);
        return;
    L8:
        r102 = 0.0f;
        goto L10
    }

    public HalfScreenTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.life_pdp_groupon_detail_half_screen_tag_view, this, true);
        setOrientation(0);
        setGravity(16);
        View r103 = findViewById(R.id.dot);
        this.f261425a = r103;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Double r105 = Double.valueOf(3.5d);
        r104.width = a.c(e.b(r105));
        r104.height = a.c(e.b(r105));
        r103.setLayoutParams(r104);
        DuxTextView r106 = (DuxTextView) findViewById(R.id.content);
        this.f261426b = r106;
        a.e(r106, 13.0f);
        FrameLayout r107 = (FrameLayout) findViewById(R.id.tag_container);
        this.f261427c = r107;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        r108.height = a.c(e.b(16));
        r107.setLayoutParams(r108);
        DuxTextView r109 = (DuxTextView) findViewById(R.id.tag);
        this.f261428d = r109;
        a.e(r109, 10.0f);
    }

    public /* synthetic */ HalfScreenTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
