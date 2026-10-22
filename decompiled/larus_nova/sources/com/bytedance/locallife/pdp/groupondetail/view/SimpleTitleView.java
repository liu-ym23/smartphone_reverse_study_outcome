package com.bytedance.locallife.pdp.groupondetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import bx6.a;
import com.bytedance.dux.text.DuxTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import dx6.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/view/SimpleTitleView;", "Landroid/widget/LinearLayout;", "Ldx6/i;", "vo", "", "setVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SimpleTitleView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxTextView f261431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f261432b;

    public SimpleTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SimpleTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setVO(i r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        this.f261431a.setText(r100.e());
        this.f261432b.setText(r100.d());
    }

    public SimpleTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.life_pdp_groupon_detail_simple_title_view, this, true);
        setOrientation(0);
        DuxTextView r103 = (DuxTextView) findViewById(R.id.title);
        this.f261431a = r103;
        a.f(r103, 600);
        a.e(r103, 14.0f);
        DuxTextView r104 = (DuxTextView) findViewById(R.id.sub_title);
        this.f261432b = r104;
        a.f(r104, 600);
        a.e(r104, 13.0f);
    }

    public /* synthetic */ SimpleTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
