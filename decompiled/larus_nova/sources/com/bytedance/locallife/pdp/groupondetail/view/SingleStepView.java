package com.bytedance.locallife.pdp.groupondetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import bx6.a;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.utils.e;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import dx6.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/view/SingleStepView;", "Landroid/widget/LinearLayout;", "Ldx6/k;", "vo", "", "setVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SingleStepView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxTextView f261433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f261434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f261435c;

    public SingleStepView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SingleStepView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setVO(k r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        Integer r101 = r100.f470429a;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        if (r102 <= 0) goto L8;
        this.f261433a.setVisibility(0);
        this.f261433a.setText(String.valueOf(r100.f470429a));
    L9:
        this.f261434b.setText(r100.a());
        this.f261435c.removeAllViews();
        List<String> r103 = r100.b();
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        String r105 = (String) r104.next();
        DuxTextView r106 = new DuxTextView(getContext(), null, 6, 0);
        r106.setText(r105);
        a.e(r106, 11.0f);
        r106.setTextColor(ColorProtector.parseColor("#80161823"));
        LinearLayout r107 = this.f261435c;
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-1, -2);
        r108.setMargins(0, e.b(2), 0, 0);
        Unit r109 = Unit.INSTANCE;
        r107.addView(r106, r108);
        goto L13
    L17:
        return;
    L15:
        return;
    L8:
        this.f261433a.setVisibility(8);
        goto L9
    L5:
        r102 = 0;
        goto L6
    }

    public SingleStepView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.life_pdp_groupon_detail_single_step_view, this, true);
        setOrientation(1);
        DuxTextView r103 = (DuxTextView) findViewById(R.id.step);
        this.f261433a = r103;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        r104.width = a.c(e.b(12));
        r104.height = a.c(e.b(12));
        r103.setLayoutParams(r104);
        a.e(r103, 7.0f);
        DuxTextView r105 = (DuxTextView) findViewById(R.id.content);
        this.f261434b = r105;
        a.e(r105, 13.0f);
        LinearLayout r106 = (LinearLayout) findViewById(R.id.desc_container);
        this.f261435c = r106;
        r106.setPadding(a.c(e.b(12)) + e.b(6), 0, 0, 0);
    }

    public /* synthetic */ SingleStepView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
