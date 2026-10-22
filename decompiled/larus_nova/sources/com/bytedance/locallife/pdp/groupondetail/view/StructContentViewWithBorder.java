package com.bytedance.locallife.pdp.groupondetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import bx6.a;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.utils.e;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import dx6.c;
import dx6.j;
import dx6.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/view/StructContentViewWithBorder;", "Landroid/widget/LinearLayout;", "Ldx6/o;", "vo", "", "setVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class StructContentViewWithBorder extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxTextView f261442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f261443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f261444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxTextView f261445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f261446e;

    public StructContentViewWithBorder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StructContentViewWithBorder(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setVO(o r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        this.f261442a.setText(r100.g());
        this.f261443b.setText(r100.h());
        if (TextUtils.isEmpty(r100.f()) == false) goto L5;
        this.f261444c.setVisibility(8);
        this.f261445d.setVisibility(8);
    L6:
        this.f261446e.removeAllViews();
        List<j> r101 = r100.d();
        if (r101 == null) goto L26;
        Iterator<T> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L32;
        j r103 = (j) r102.next();
        View r104 = a.a(r103, getContext());
        if (r104 == null) goto L10;
        LinearLayout r105 = this.f261446e;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-1, -2);
        c r107 = a.d(r103);
        if (r107 == null) goto L18;
        Integer r108 = r107.c();
        if (r108 == null) goto L18;
        int r109 = r108.intValue();
    L19:
        int r110 = e.b(Integer.valueOf(r109));
        c r111 = a.d(r103);
        if (r111 == null) goto L24;
        Integer r112 = r111.b();
        if (r112 == null) goto L24;
        int r113 = r112.intValue();
    L25:
        r106.setMargins(0, r110, 0, e.b(Integer.valueOf(r113)));
        Unit r114 = Unit.INSTANCE;
        r105.addView(r104, r106);
    L24:
        r113 = 0;
    L18:
        r109 = 0;
        goto L19
    L32:
        return;
    L26:
        return;
    L5:
        this.f261444c.setVisibility(0);
        this.f261445d.setVisibility(0);
        this.f261444c.setText(r100.e());
        this.f261445d.setText(r100.f());
        goto L6
    }

    public StructContentViewWithBorder(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.life_pdp_groupon_detail_struct_content_view_with_border, this, true);
        setOrientation(1);
        setBackgroundResource(R.drawable.life_pdp_groupon_detail_border_view_bg);
        DuxTextView r103 = (DuxTextView) findViewById(R.id.title);
        this.f261442a = r103;
        a.e(r103, 14.0f);
        a.f(r103, 500);
        DuxTextView r104 = (DuxTextView) findViewById(R.id.unit);
        this.f261443b = r104;
        a.f(r104, 500);
        a.e(r104, 11.0f);
        DuxTextView r105 = (DuxTextView) findViewById(R.id.price_prefix);
        this.f261444c = r105;
        a.f(r105, 500);
        a.e(r105, 12.0f);
        DuxTextView r106 = (DuxTextView) findViewById(R.id.price);
        this.f261445d = r106;
        a.f(r106, 500);
        a.e(r106, 15.0f);
        this.f261446e = (LinearLayout) findViewById(R.id.container);
    }

    public /* synthetic */ StructContentViewWithBorder(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
