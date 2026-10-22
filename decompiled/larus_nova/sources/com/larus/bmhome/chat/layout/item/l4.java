package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.OSurfaceView;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IVideoController;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l4 extends xc8.h {
    public IVideoController A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f304489p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SimpleDraweeView f304490q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SimpleDraweeView f304491r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final OSurfaceView f304492s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f304493t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f304494u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f304495v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<MediaEntity> f304496w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Message f304497x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public MediaEntityContainer f304498y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f304499z;

    public static final class a {
    }

    public static final class b implements com.larus.platform.api.l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l4 f304500a;

        public b(l4 r100) {
            this.f304500a = r100;
        }

        @Override // com.larus.platform.api.l4
        public final void a(String r100, com.larus.video.impl.sdk.a r101) {
            ArrayList<MediaEntity> r102 = this.f304500a.f304496w;
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            return;
        L11:
            ArrayList<MediaEntity> r104 = this.f304500a.f304496w;
            Intrinsics.checkNotNull(r104);
            MediaEntity r105 = (MediaEntity) ListProtector.get(r104, 0);
            if (r105 == null) goto L14;
            String r106 = r105.getVideo_model();
        L16:
            if (Intrinsics.areEqual(r106, r100) == false) goto L21;
            Lazy r107 = com.larus.platform.service.q3.f365794a;
            com.larus.platform.api.z3 r108 = com.larus.platform.service.q3.a();
            if (r108 == null) goto L22;
            com.larus.platform.api.z3.a.a(r108, r101, null, 0, null, 30);
            return;
        L22:
            return;
        L21:
            return;
        L14:
            r106 = null;
            goto L16
        L5:
            if (r102.isEmpty() == true) goto L8;
            r103 = false;
            goto L9
        }
    }

    static {
    }

    public final void n() {
        ArrayList<MediaEntity> r100 = this.f304496w;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        Lazy r102 = com.larus.platform.service.q3.f365794a;
        com.larus.platform.api.z3 r103 = com.larus.platform.service.q3.a();
        if (r103 == null) goto L19;
        ArrayList<MediaEntity> r104 = this.f304496w;
        Intrinsics.checkNotNull(r104);
        MediaEntity r105 = (MediaEntity) ListProtector.get(r104, 0);
        if (r105 == null) goto L16;
        String r106 = r105.getVideo_model();
    L17:
        r103.f(r106, new b(this));
        return;
    L16:
        r106 = null;
        goto L17
    L19:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L8;
        com.larus.platform.api.r2 r101 = r100.A0();
        if (r101 == null) goto L9;
        r101.l(getContext());
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IVideoController r100 = this.A;
        if (r100 == null) goto L8;
        r100.I(false);
        if (r100.isReleased() == true) goto L9;
        r100.release();
        return;
    L9:
        return;
    }

    public l4(Context r100) {
        super(r100);
        this.f304494u = (int) UIUtils.dip2Px(r100, 190.0f);
        this.f304495v = (int) UIUtils.dip2Px(r100, 286.0f);
        this.f304496w = new ArrayList();
        OSurfaceView r101 = null;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_video_card, null);
        this.f304493t = r102;
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(this.f304494u, -2);
        if (r102 == null) goto L5;
        ImageView r104 = (ImageView) r102.findViewById(R.id.play_image);
    L5:
        if (r102 == null) goto L7;
        TextView r105 = (TextView) r102.findViewById(R.id.video_source_title);
    L8:
        this.f304489p = r105;
        if (r102 == null) goto L11;
        SimpleDraweeView r106 = (SimpleDraweeView) r102.findViewById(R.id.cover_image);
    L12:
        this.f304490q = r106;
        if (r102 == null) goto L15;
        SimpleDraweeView r107 = (SimpleDraweeView) r102.findViewById(R.id.app_from_icon);
    L16:
        this.f304491r = r107;
        if (r102 == null) goto L19;
        r101 = (OSurfaceView) r102.findViewById(R.id.video_surface);
    L19:
        this.f304492s = r101;
        addView(r102, r103);
        return;
    L15:
        r107 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L7:
        r105 = null;
        goto L8
    }
}
