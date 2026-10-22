package com.bytedance.locallife.live.goodsshelves.topbar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f259959f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f259960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DmtTextView f259961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f259962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f259963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f259964e;

    public interface a {
        void a();
    }

    public h(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f259960a = r101;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.saas_live_local_life_top_bar_pop_more, this, true);
        DmtTextView r103 = (DmtTextView) r102.findViewById(R.id.consult);
        DmtTextView r104 = (DmtTextView) r102.findViewById(R.id.member);
        this.f259961b = r104;
        this.f259962c = r102.findViewById(R.id.divider);
        r103.setOnClickListener(new LiveLocalLifeTopBarPopMore$1(this));
        r104.setOnClickListener(new LiveLocalLifeTopBarPopMore$2(this));
    }
}
