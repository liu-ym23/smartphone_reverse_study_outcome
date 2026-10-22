package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.utils.l;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<d, f> {

    public static final class a extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImageView f196714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f196715e;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            l.a(this.f196714d);
            ((d) this.f196715e.f195897b).f196716a.b(Unit.INSTANCE);
        }

        public a(ImageView r100, c r101) {
            this.f196714d = r100;
            this.f196715e = r101;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        LinearLayout r100 = (LinearLayout) b().findViewById(R.id.share_view_layout);
        ImageView r101 = (ImageView) b().findViewById(R.id.share_image);
        final TextView r102 = (TextView) b().findViewById(R.id.share_text);
        r100.setOnClickListener(new a(r101, this));
        f r103 = (f) this.f195898c;
        Observer<Long> r104 = new b(r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f196718a.a(r104);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_common_feed_layout_video_share, r100, false);
    }

    public c(Context r100, d r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
