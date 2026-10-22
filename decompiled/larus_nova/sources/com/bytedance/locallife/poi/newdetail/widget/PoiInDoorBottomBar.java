package com.bytedance.locallife.poi.newdetail.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.utils.e;
import com.bytedance.locallife.dito.utils.o;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.model.poi.resp.PoiStruct;
import com.bytedance.locallife.model.poi.resp.PoiUgcBottomBarIconStruct;
import com.bytedance.locallife.model.poi.resp.PoiUgcBottomBarStruct;
import com.bytedance.locallife.poi.newdetail.k;
import com.bytedance.locallife.poi.newdetail.s;
import com.bytedance.locallife.poi.poidetail.container.mob.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/PoiInDoorBottomBar;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "getLineView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiInDoorBottomBar extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f263317m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PoiUgcBottomBarStruct f263318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PoiBundle f263319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PoiDetail f263320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f263321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f263322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f263323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f263324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SimpleDraweeView f263325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DuxTextView f263326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f263327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f263328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f263329l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f263330a = null;

        static {
            f263330a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiInDoorBottomBar f263331a;

        public c(PoiInDoorBottomBar r100) {
            this.f263331a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PoiInDoorBottomBar r100 = this.f263331a;     // Catch: Throwable -> L4
            r100.setTranslationY(r100.getHeight());     // Catch: Throwable -> L4
            this.f263331a.setVisibility(0);     // Catch: Throwable -> L4
            this.f263331a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiInDoorBottomBar f263332a;

        public d(PoiInDoorBottomBar r100) {
            this.f263332a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f263332a.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public PoiInDoorBottomBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiInDoorBottomBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final View getLineView() {
        View r100 = new View(getContext());
        r100.setLayoutParams(new FrameLayout.LayoutParams(e.b(Double.valueOf(0.5d)), e.b(28)));
        r100.setBackgroundColor(ContextCompat.getColor(r100.getContext(), R.color.POILinePrimary));
        return r100;
    }

    public final void a() {
        if (this.f263327j == false) goto L5;
        return;
    L5:
        this.f263327j = true;
        this.f263328k.removeCallbacks(this.f263329l);
        setVisibility(0);
        ViewPropertyAnimator r100 = animate();
        if (r100 == null) goto L13;
        ViewPropertyAnimator r101 = r100.translationY(0.0f);
        if (r101 == null) goto L14;
        ViewPropertyAnimator r102 = r101.setDuration(300);
        if (r102 == null) goto L15;
        r102.start();
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void c(String r100) {
        int r101 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r102 = new mq6.c();
        mq6.a r103 = mq6.c.a.f514894a;
        r102.g("enter_from", "poi_page");
        PoiBundle r104 = this.f263319b;
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.sessionId;
    L6:
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r102.g("poi_enter_id", r106);
        PoiBundle r107 = this.f263319b;
        if (r107 == null) goto L11;
        String r108 = r107.poiId;
    L12:
        r102.g("poi_id", r108);
        PoiBundle r109 = this.f263319b;
        if (r109 == null) goto L15;
        r105 = r109.backendType;
    L15:
        r102.g("poi_backend_type", r105);
        com.bytedance.locallife.biz.mob.a.C3646a.c(r100, r102.f514893a);
        return;
    L11:
        r108 = null;
        goto L12
    L5:
        r106 = null;
        goto L6
    }

    public final void d(String r100) {
        int r101 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r102 = new mq6.c();
        mq6.a r103 = mq6.c.a.f514894a;
        r102.g("enter_from", "poi_page");
        r102.g("entrance_name", "at_poi_button");
        r102.a("source_type", 7);
        r102.g("creation_id", this.f263321d);
        if (this.f263322e == false) goto L5;
        String r104 = "0";
    L6:
        r102.g("if_ratable", r104);
        com.bytedance.locallife.biz.mob.a.C3646a.c(r100, r102.f514893a);
        return;
    L5:
        r104 = "1";
        goto L6
    }

    public PoiInDoorBottomBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263321d = HostServiceUtilsKt.f0().b();
        this.f263328k = new Handler(Looper.getMainLooper());
        this.f263329l = new d(this);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.saas_poi_layout_in_door_bottom, this, true);
        r103.setVisibility(0);
        this.f263323f = r103.findViewById(R.id.container);
        this.f263324g = (LinearLayout) r103.findViewById(R.id.poi_in_door_bottom_container);
        this.f263325h = (SimpleDraweeView) r103.findViewById(R.id.poi_in_door_bottom_background);
        this.f263326i = (DuxTextView) r103.findViewById(R.id.poi_in_door_bottom_text);
    }

    public /* synthetic */ PoiInDoorBottomBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(PoiUgcBottomBarStruct r100, PoiStruct r110, PoiBundle r111, PoiDetail r112, k r113) {
        Intrinsics.checkNotNullParameter(r100, "bottomBarStruct");
        this.f263318a = r100;
        this.f263319b = r111;
        this.f263320c = r112;
        this.f263322e = r100.getHasUserRated();
        DuxTextView r114 = this.f263326i;
        if (r114 == null) goto L7;
        r114.setText(r100.getTitle());
    L7:
        if (r113 == null) goto L11;
        com.bytedance.locallife.poi.newdetail.c r115 = r113.f263276c;
        if (r115 == null) goto L11;
        String r116 = r115.f();
    L13:
        if (TextUtils.isEmpty(r116) == true) goto L22;
        DuxTextView r117 = this.f263326i;
        if (r117 == null) goto L25;
        if (r113 == null) goto L20;
        com.bytedance.locallife.poi.newdetail.c r118 = r113.f263276c;
        if (r118 == null) goto L20;
        String r119 = r118.f();
    L21:
        r117.setTextColor(ColorProtector.parseColor(r119));
    L20:
        r119 = null;
    L25:
        DuxTextView r120 = this.f263326i;
        if (r120 == null) goto L28;
        h.a(r120, 13.0f);
    L28:
        if (r113 == null) goto L32;
        s r121 = r113.f263277d;
        if (r121 == null) goto L32;
        String r122 = r121.a();
    L34:
        if (TextUtils.isEmpty(r122) == true) goto L41;
        if (r113 == null) goto L39;
        s r123 = r113.f263277d;
        if (r123 == null) goto L39;
        String r124 = r123.a();
    L40:
        final int r125 = ColorProtector.parseColor(r124);
    L42:
        View r126 = this.f263323f;
        if (r126 == null) goto L46;
        r126.setBackground(o.a(new PoiInDoorBottomBar$bind$1(this, r125)));
    L46:
        View r127 = this.f263323f;
        if (r127 == null) goto L49;
        r127.setOnClickListener(b.f263330a);
    L49:
        SimpleDraweeView r128 = this.f263325h;
        PoiImageUrlModel r129 = r100.getBackgroundImageUrl();
        if (r129 == null) goto L54;
        List<String> r130 = r129.getUrlList();
        if (r130 == null) goto L54;
        String r131 = (String) ListProtector.get(r130, 0);
    L55:
        rp6.a.b(r128, r131, -1, -1);
        LinearLayout r132 = this.f263324g;
        if (r132 == null) goto L58;
        r132.removeAllViews();
    L58:
        List<PoiUgcBottomBarIconStruct> r101 = r100.getIconList();
        if (r101 != null) goto L61;
        r101 = new ArrayList();
    L61:
        Iterator<PoiUgcBottomBarIconStruct> r102 = r101.iterator();
        View r133 = null;
    L63:
        if (r102.hasNext() == false) goto L88;
        PoiUgcBottomBarIconStruct r134 = r102.next();
        if (r134 == null) goto L63;
        LinearLayout r135 = this.f263324g;
        if (r135 == null) goto L85;
        int r103 = r134.getType();
        if (r103 == 1) goto L77;
        if (r103 != 2) goto L73;
        c("show_shoot_button");
    L78:
        DuxTextView r104 = new DuxTextView(getContext(), null, 6, 0);
        r104.setTextSize(12.0f);
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), R.color.POITextPrimary));
        r104.setText(r134.getText());
        r104.setGravity(17);
        r104.setPadding(0, e.b(2), 0, 0);
        h.a(r104, 12.0f);
        SimpleDraweeView r105 = new SimpleDraweeView(getContext());
        r105.setLayoutParams(new LinearLayout.LayoutParams(e.b(24), e.b(24)));
        PoiImageUrlModel r106 = r134.getIconImageUrl();
        if (r106 == null) goto L83;
        List<String> r107 = r106.getUrlList();
        if (r107 == null) goto L83;
        String r108 = (String) ListProtector.get(r107, 0);
    L84:
        rp6.a.b(r105, r108, -1, -1);
        LinearLayout r109 = new LinearLayout(getContext());
        r109.setOrientation(1);
        LinearLayout.LayoutParams r136 = new LinearLayout.LayoutParams(0, -1);
        r136.weight = 1.0f;
        r109.setLayoutParams(r136);
        r109.setGravity(17);
        r109.addView(r105);
        r109.addView(r104);
        r109.setOnClickListener(new com.bytedance.locallife.poi.newdetail.widget.b(this, r134));
        r135.addView(r109);
    L83:
        r108 = null;
        goto L84
    L73:
        if (r103 != 3) goto L78;
        c("show_upload_image_button");
        goto L78
    L77:
        c("show_rate_button");
        d("show_to_comment_entrance");
    L85:
        r133 = getLineView();
        LinearLayout r137 = this.f263324g;
        if (r137 == null) goto L63;
        r137.addView(r133);
        goto L63
    L88:
        LinearLayout r138 = this.f263324g;
        if (r138 == null) goto L91;
        r138.removeView(r133);
    L91:
        post(new c(this));
        return;
    L54:
        r131 = null;
    L39:
        r124 = null;
        goto L40
    L41:
        r125 = ColorProtector.parseColor("#57FE2C55");
    L32:
        r122 = null;
        goto L34
    L22:
        DuxTextView r139 = this.f263326i;
        if (r139 == null) goto L25;
        r139.setTextColor(ContextCompat.getColor(getContext(), R.color.POIPrimary));
    L11:
        r116 = null;
        goto L13
    }
}
