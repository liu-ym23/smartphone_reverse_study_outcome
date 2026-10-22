package com.bytedance.awemeopen.apps.framework.feed.ui.information.camera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import r14.w;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, h> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f196051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AoImageView f196052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DmtTextView f196053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DmtTextView f196054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DmtTextView f196055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<w> f196056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public w f196057k;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        h r100 = (h) this.f195898c;
        Observer<List<w>> r101 = new d(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f196060a.a(r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(getContext()).inflate(R.layout.aos_common_feed_camera_anchor, r100, false);
    }

    public f(Context r100, g r101, h r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r103, "contentScene");
        super(r100, r101, r102);
    }
}
