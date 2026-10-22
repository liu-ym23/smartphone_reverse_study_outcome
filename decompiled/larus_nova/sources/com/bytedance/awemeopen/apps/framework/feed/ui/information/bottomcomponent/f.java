package com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<c, d> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f196037e;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        View r100 = this.f196037e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentView");
        r100 = null;
    L5:
        TextView r101 = (TextView) r100.findViewById(R.id.information_lb_button_text);
        j54.a r102 = ((d) this.f195898c).f196035a.invoke();
        r101.setText("");
        r101.setOnClickListener(new e(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.aos_common_feed_bottom_left_component, r100, false);
        this.f196037e = r101;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("componentView");
        return null;
    L6:
        return r101;
    }

    public f(Context r100, c r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
