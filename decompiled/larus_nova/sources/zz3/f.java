package zz3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.utils.l;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, h> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f574077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f574078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f574079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f574080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f574081i;

    public static final class a extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f574082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g f574083e;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ImageView r100 = this.f574082d.f574079g;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("commentImage");
            r100 = null;
        L5:
            l.a(r100);
            this.f574083e.f574084a.b(Boolean.FALSE);
        }

        public a(f r100, g r101) {
            this.f574082d = r100;
            this.f574083e = r101;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.f574077e = (LinearLayout) b().findViewById(R.id.comment_view_layout);
        this.f574078f = (FrameLayout) b().findViewById(R.id.comment_container);
        this.f574079g = (ImageView) b().findViewById(R.id.comment_image);
        this.f574080h = (TextView) b().findViewById(R.id.tv_comment_count);
        FrameLayout r100 = null;
        LinearLayout r101 = null;
        if (AosExtConfig.f193138b.getCommentConfig().f1845e == false) goto L9;
        LinearLayout r102 = this.f574077e;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
    L8:
        r101.setOnClickListener(this.f574081i);
    L14:
        h r103 = (h) this.f195898c;
        Observer<Long> r104 = new e(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f574085a.a(r104);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        FrameLayout r105 = this.f574078f;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
    L13:
        r100.setOnClickListener(this.f574081i);
        goto L14
    L12:
        r100 = r105;
        goto L13
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_common_feed_layout_video_comment_count, r100, false);
    }

    public f(Context r100, g r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f574081i = new a(this, r101);
    }
}
