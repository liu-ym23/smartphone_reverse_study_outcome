package com.bytedance.locallife.pdp.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.locallife.biz.common.ui.LocalLifeLoadingLayout;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.dito.common.data.DitoPageStatusData;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.pdp.container.GoodsDetailPage;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003 !\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/pdp/view/NewGoodsDetailStatusView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/dito/common/model/b;", "Landroid/os/Handler$Callback;", "", "getRawData", "Lcom/bytedance/ies/dmt/ui/widget/DmtStatusView$a;", "getDefaultPageStatusViewBuilder", "Landroid/view/View;", "getSkeletonView", "getSkeletonViewNative", "Lcom/bytedance/locallife/pdp/view/NewGoodsDetailStatusView$SkeletonViewType;", "D", "Lcom/bytedance/locallife/pdp/view/NewGoodsDetailStatusView$SkeletonViewType;", "getSkeletonViewType", "()Lcom/bytedance/locallife/pdp/view/NewGoodsDetailStatusView$SkeletonViewType;", "skeletonViewType", "Ljava/lang/Runnable;", "O", "Ljava/lang/Runnable;", "getDismissCallback", "()Ljava/lang/Runnable;", "setDismissCallback", "(Ljava/lang/Runnable;)V", "dismissCallback", "", "<set-?>", "P", "Z", "getDismissed", "()Z", "dismissed", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HideLoadingViewType", "SkeletonViewType", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class NewGoodsDetailStatusView extends BaseDitoView<com.bytedance.locallife.dito.common.model.b> implements Handler.Callback {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f261853k0 = 0;
    public final DitoPageStatusData A;
    public final Function0<HashMap<String, String>> B;
    public final int C;
    public final SkeletonViewType D;
    public final HideLoadingViewType E;
    public final ww6.i F;
    public View G;
    public View H;
    public View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public LocalLifeLoadingLayout f261854J;
    public long K;
    public final boolean L;
    public boolean M;
    public final g0 N;
    public Runnable O;
    public boolean P;
    public IPoiLynxKitDelegate Q;
    public IPoiLynxKitDelegate R;
    public long S;
    public final AtomicInteger T;
    public final AtomicBoolean U;
    public final Handler V;
    public final NewGoodsDetailStatusView$pageStatusObserver$1 W;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final GoodsDetailPage f261855y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.container.j0 f261856z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/pdp/view/NewGoodsDetailStatusView$HideLoadingViewType;", "", "LYNX_REND_FINISH", "LYNX_SEND_BROADCAST", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum HideLoadingViewType extends Enum<HideLoadingViewType> {
        public static final HideLoadingViewType LYNX_REND_FINISH = null;
        public static final HideLoadingViewType LYNX_SEND_BROADCAST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HideLoadingViewType[] f261857a = null;

        public static HideLoadingViewType valueOf(String r100) {
            return (HideLoadingViewType) r27.a.a(HideLoadingViewType.class, r100);
        }

        public static HideLoadingViewType[] values() {
            return (HideLoadingViewType[]) f261857a.clone();
        }

        static {
            HideLoadingViewType r100 = new HideLoadingViewType("LYNX_REND_FINISH", 0);
            LYNX_REND_FINISH = r100;
            HideLoadingViewType r101 = new HideLoadingViewType("LYNX_SEND_BROADCAST", 1);
            LYNX_SEND_BROADCAST = r101;
            f261857a = new HideLoadingViewType[]{r100, r101};
        }

        public HideLoadingViewType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/pdp/view/NewGoodsDetailStatusView$SkeletonViewType;", "", UserProfileEvent.POSITION_NONE, "LYNX", "NATIVE", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum SkeletonViewType extends Enum<SkeletonViewType> {
        public static final SkeletonViewType LYNX = null;
        public static final SkeletonViewType NATIVE = null;
        public static final SkeletonViewType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SkeletonViewType[] f261858a = null;

        public static SkeletonViewType valueOf(String r100) {
            return (SkeletonViewType) r27.a.a(SkeletonViewType.class, r100);
        }

        public static SkeletonViewType[] values() {
            return (SkeletonViewType[]) f261858a.clone();
        }

        static {
            SkeletonViewType r100 = new SkeletonViewType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            SkeletonViewType r101 = new SkeletonViewType("LYNX", 1);
            LYNX = r101;
            SkeletonViewType r102 = new SkeletonViewType("NATIVE", 2);
            NATIVE = r102;
            f261858a = new SkeletonViewType[]{r100, r101, r102};
        }

        public SkeletonViewType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.LinkedHashMap] */
        public static void a(ww6.i r100, String r101, Map r102) {
            Intrinsics.checkNotNullParameter(r100, "bizContext");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "params");
            List r103 = CollectionsKt.listOf(new String[]{"poi_id", "detail_enter_page", "detail_enter_method", "product_id", "activity_id"});
            Map<String, String> r104 = r100.getInfo().f261056g1;
            if (r104 == null) goto L10;
            ?? r105 = new LinkedHashMap();
            Iterator r106 = ((LinkedHashMap) r104).entrySet().iterator();
        L6:
            if (r106.hasNext() == false) goto L11;
            Map.Entry r107 = (Map.Entry) r106.next();
            if (r103.contains((String) r107.getKey()) == false) goto L6;
            r105.put(r107.getKey(), r107.getValue());
        L11:
            Map r108 = MapsKt.toMutableMap(r105);
            String r109 = (String) r108.get("product_id");
            if (r109 != null) goto L14;
            r109 = (String) r108.get("activity_id");
        L14:
            r108.put("product_id", r109);
            int r110 = com.bytedance.locallife.biz.mob.a.f256703c;
            com.bytedance.locallife.biz.mob.a.C3646a.c(r101, MapsKt.plus(r102, r108));
            return;
        L10:
            r105 = MapsKt.emptyMap();
            goto L11
        }
    }

    public static final class b implements ViewStub.OnInflateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewStub f261860b;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NewGoodsDetailStatusView f261861a;

            public a(NewGoodsDetailStatusView r100) {
                this.f261861a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                DitoDataCenter r101 = this.f261861a.getDataCenter();
                int r102 = DitoDataCenter.f258004d;
                r101.a0("dito_fmp_is_retry", 1).setValue(new JSONObject());
                this.f261861a.getDataCenter().w0().setValue(Boolean.TRUE);
            }
        }

        public b(NewGoodsDetailStatusView r100, ViewStub r101) {
            this.f261859a = r100;
            this.f261860b = r101;
        }

        @Override // android.view.ViewStub.OnInflateListener
        public final void onInflate(ViewStub r100, View r101) {
            ((DuxTextView) r101.findViewById(R.id.tv_retry)).setOnClickListener(new a(this.f261859a));
            if (Intrinsics.areEqual(this.f261859a.A.getForceNight(), Boolean.TRUE) == false) goto L6;
            ((DuxTextView) r101.findViewById(R.id.tv_retry)).setTextColor(ColorProtector.parseColor("#E6FFFFFF"));
            ((DuxTextView) r101.findViewById(R.id.tv_desc)).setTextColor(ColorProtector.parseColor("#80FFFFFF"));
            ((DuxTextView) r101.findViewById(R.id.tv_title)).setTextColor(ColorProtector.parseColor("#E6FFFFFF"));
            ((ImageView) r101.findViewById(R.id.iv_empty)).setBackground(HostServiceUtilsKt.f().a(this.f261860b.getContext()));
        L6:
            if (Intrinsics.areEqual(this.f261859a.A.getForceNight(), Boolean.FALSE) == false) goto L8;
            ((DuxTextView) r101.findViewById(R.id.tv_retry)).setTextColor(ColorProtector.parseColor("#161823"));
            ((DuxTextView) r101.findViewById(R.id.tv_desc)).setTextColor(ColorProtector.parseColor("#80161823"));
            ((DuxTextView) r101.findViewById(R.id.tv_title)).setTextColor(ColorProtector.parseColor("#161823"));
            ((ImageView) r101.findViewById(R.id.iv_empty)).setBackground(HostServiceUtilsKt.f().b(this.f261860b.getContext()));
        L8:
            r101.setId(R.id.poi_dynamic_default_status_view_empty_view);
            this.f261859a.P();
        }
    }

    public static final class c extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261862a;

        public c(NewGoodsDetailStatusView r100, Context r101) {
            this.f261862a = r100;
            super(r101);
        }

        @Override // android.view.View
        public final void onVisibilityChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "changedView");
            super.onVisibilityChanged(r100, r101);
            if (r101 != 0) goto L10;
            View r102 = this.f261862a.H;
            if (r102 == null) goto L11;
            if (r102 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            r102 = null;
        L8:
            r102.setVisibility(r101);
            return;
        L11:
            return;
        }
    }

    public static final class d extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261863a;

        public d(NewGoodsDetailStatusView r100, Context r101) {
            this.f261863a = r100;
            super(r101);
        }

        @Override // android.view.View
        public final void onVisibilityChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "changedView");
            if (this.f261863a.T.get() == 2) goto L5;
            return;
        L5:
            super.onVisibilityChanged(r100, r101);
            if (r101 != 0) goto L13;
            View r102 = this.f261863a.G;
            if (r102 == null) goto L14;
            if (r102 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("errorView");
            r102 = null;
        L11:
            r102.setVisibility(r101);
            return;
        L14:
            return;
        }
    }

    public static final class e extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261864a;

        public e(NewGoodsDetailStatusView r100, Context r101) {
            this.f261864a = r100;
            super(r101);
        }

        @Override // android.view.View
        public final void onVisibilityChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "changedView");
            super.onVisibilityChanged(r100, r101);
            if (r101 != 0) goto L10;
            View r102 = this.f261864a.I;
            if (r102 == null) goto L11;
            if (r102 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("skeletonView");
            r102 = null;
        L8:
            r102.setVisibility(r101);
            return;
        L11:
            return;
        }
    }

    public static final class f implements ViewStub.OnInflateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261865a;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f261866a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NewGoodsDetailStatusView f261867b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f261868c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f261869d;

            public a(Ref.BooleanRef r100, NewGoodsDetailStatusView r101, String r102, String r103) {
                this.f261866a = r100;
                this.f261867b = r101;
                this.f261868c = r102;
                this.f261869d = r103;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                Ref.BooleanRef r101 = this.f261866a;
                if (r101.element == true) goto L6;
                r101.element = true;
                long r102 = System.currentTimeMillis();
                JSONObject r103 = new JSONObject();
                String r104 = this.f261868c;
                String r105 = this.f261869d;
                r103.put("product_id", r104);
                r103.put("gd_pre_shelf_id", r105);
                Unit r106 = Unit.INSTANCE;
                EventCenter.enqueueEvent(new Event("gd_skeleton_on_click_confirm_btn", r102, new ReadableMapImpl(r103)));
                int r107 = NewGoodsDetailStatusView.f261853k0;
                a.a(this.f261867b.F, "gd_skeleton_click_confirm", MapsKt.emptyMap());
                return;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f261870a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NewGoodsDetailStatusView f261871b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f261872c;

            public b(String r100, NewGoodsDetailStatusView r101, Ref.BooleanRef r102) {
                this.f261870a = r100;
                this.f261871b = r101;
                this.f261872c = r102;
            }

            public final void a() {
                if (df6.q.f468229c == true) goto L5;
                df6.c r100 = null;
            L6:
                boolean r101 = r100.c(UriProtector.parse(this.f261870a));
                int r102 = NewGoodsDetailStatusView.f261853k0;
                ww6.i r103 = this.f261871b.F;
                Pair[] r104 = new Pair[2];
                String r105 = "1";
                if (r101 == false) goto L9;
                Object r106 = "1";
            L10:
                r104[0] = TuplesKt.to("hit_image_cache", r106);
                if (this.f261872c.element == true) goto L14;
                r105 = "0";
            L14:
                r104[1] = TuplesKt.to("show_confirm_btn", r105);
                a.a(r103, "gd_skeleton_setup", MapsKt.mapOf(r104));
                return;
            L9:
                r106 = "0";
                goto L10
            L5:
                r100 = df6.q.f468227a.getCache();
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public f(NewGoodsDetailStatusView r100) {
            this.f261865a = r100;
        }

        @Override // android.view.ViewStub.OnInflateListener
        public final void onInflate(ViewStub r100, View r101) {
            Map<String, String> r102 = this.f261865a.F.getInfo().f261056g1;
            String r103 = null;
            if (r102 == null) goto L5;
            String r104 = (String) ((LinkedHashMap) r102).get("skeleton_head_img_url");
        L6:
            ImageView r105 = (ImageView) r101.findViewById(R.id.poi_goods_detail_status_view_skeleton_view_native_image);
            if (r105 == null) goto L9;
            r105.getLayoutParams().height = (int) (com.bytedance.locallife.biz.common.utils.e.b() * (MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME / 375.0f));
            df6.u r106 = df6.q.d(r104);
            r106.f468295u = r105;
            r106.c();
        L9:
            View r107 = r101.findViewById(R.id.poi_goods_detail_status_view_skeleton_view_native_view);
            if (r107 == null) goto L12;
            r107.getLayoutParams().height = com.bytedance.locallife.biz.common.utils.e.a();
        L12:
            TextView r108 = (TextView) r101.findViewById(R.id.poi_goods_detail_status_view_skeleton_view_native_footer);
            if (r108 == null) goto L42;
            NewGoodsDetailStatusView r109 = this.f261865a;
            Map<String, String> r110 = r109.F.getInfo().f261056g1;
            if (r110 == null) goto L17;
            String r111 = (String) ((LinkedHashMap) r110).get("gd_enable_route_to_confirm");
        L18:
            Ref.BooleanRef r112 = new Ref.BooleanRef();
            if (Intrinsics.areEqual(r111, "1") == false) goto L39;
            Map<String, String> r113 = r109.F.getInfo().f261056g1;
            if (r113 == null) goto L23;
            String r114 = (String) ((LinkedHashMap) r113).get("product_id");
        L24:
            Map<String, String> r115 = r109.F.getInfo().f261056g1;
            if (r115 == null) goto L27;
            String r116 = (String) ((LinkedHashMap) r115).get("activity_id");
        L28:
            if (r114 != null) goto L30;
            r114 = r116;
        L30:
            Map<String, String> r117 = r109.F.getInfo().f261056g1;
            if (r117 == null) goto L34;
            r103 = (String) ((LinkedHashMap) r117).get("gd_pre_shelf_id");
        L34:
            if (com.bytedance.locallife.dito.utils.j.i(r114) == false) goto L39;
            if (com.bytedance.locallife.dito.utils.j.i(r103) == false) goto L39;
            r112.element = true;
            r108.setOnClickListener(new a(new Ref.BooleanRef(), r109, r114, r103));
            r108.setText("立即购买");
            r108.setAlpha(1.0f);
            goto L39
        L27:
            r116 = null;
            goto L28
        L23:
            r114 = null;
        L39:
            if (r112.element == true) goto L41;
            r108.setText("");
            r108.setAlpha(0.5f);
        L41:
            ThreadPoolHelper.c().submit(new b(r104, r109, r112));
            goto L42
        L17:
            r111 = null;
        L42:
            this.f261865a.P();
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class g extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261873a;

        public g(NewGoodsDetailStatusView r100, Context r101) {
            this.f261873a = r100;
            super(r101);
        }

        @Override // android.view.View
        public final void onVisibilityChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "changedView");
            super.onVisibilityChanged(r100, r101);
            if (r101 != 0) goto L10;
            View r102 = this.f261873a.I;
            if (r102 == null) goto L11;
            if (r102 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("skeletonView");
            r102 = null;
        L8:
            r102.setVisibility(r101);
            return;
        L11:
            return;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261876a;

        public h(NewGoodsDetailStatusView r100) {
            this.f261876a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewGoodsDetailStatusView r100 = this.f261876a;     // Catch: Throwable -> L4
            int r101 = NewGoodsDetailStatusView.f261853k0;     // Catch: Throwable -> L4
            r100.c0();     // Catch: Throwable -> L4
            a.a(this.f261876a.F, "gd_skeleton_remove", MapsKt.emptyMap());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewGoodsDetailStatusView f261877a;

        public i(NewGoodsDetailStatusView r100) {
            this.f261877a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewGoodsDetailStatusView r100 = this.f261877a;     // Catch: Throwable -> L4
            int r101 = NewGoodsDetailStatusView.f261853k0;     // Catch: Throwable -> L4
            r100.c0();     // Catch: Throwable -> L4
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
        new a();
    }

    public NewGoodsDetailStatusView() {
        throw null;
    }

    public final void b0() {
        this.U.set(true);
        this.V.removeMessages(123);
        this.f261856z.c(this.N);
        if (this.D != SkeletonViewType.NATIVE) goto L7;
        this.V.postDelayed(new h(this), 20);
        return;
    L7:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L10;
        c0();
        return;
    L10:
        this.V.post(new i(this));
    }

    public final void c0() {
        if (this.T.get() != 2) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L17;
        DmtStatusView r101 = (DmtStatusView) findViewById(R.id.status_view);
        if (r101 == null) goto L13;
        r101.c();
    L13:
        setVisibility(8);
        IPoiLynxKitDelegate r102 = this.R;
        if (r102 == null) goto L17;
        r102.sendEvent("skeleton_view_dismiss", new JSONObject());
    L17:
        if (this.T.get() == 1) goto L32;
    L27:
        Runnable r103 = this.O;
        if (r103 == null) goto L30;
        r103.run();
    L30:
        this.P = true;
        return;
    L32:
        ViewParent r104 = getParent();     // Catch: Exception -> L25
        if ((r104 instanceof ViewGroup) == false) goto L21;
        ViewGroup r105 = (ViewGroup) r104;     // Catch: Exception -> L25
    L22:
        if (r105 == null) goto L27;
        r105.removeView(this);     // Catch: Exception -> L25
        goto L27
    L21:
        r105 = null;
    L25:
        e = move-exception;
        HostServiceUtilsKt.c().b(e);
        goto L27
    L5:
        if (this.T.get() == 3) goto L8;
        r100 = false;
        goto L9
    }

    private final DmtStatusView.a getDefaultPageStatusViewBuilder() {
        d r100 = new d(this, getContext());
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r100.setGravity(80);
        r100.setOrientation(1);
        r100.setVisibility(8);
        ViewStub r101 = new ViewStub(getContext());
        r101.setLayoutResource(R.layout.saas_poi_goods_detail_status_view_error_view);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.setOnInflateListener(new NewGoodsDetailStatusView$getDefaultPageStatusViewBuilder$1$1(this));
        this.G = r101;
        r100.addView(r101);
        c r102 = new c(this, getContext());
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r102.setGravity(80);
        r102.setOrientation(1);
        r102.setVisibility(8);
        ViewStub r103 = new ViewStub(getContext());
        r103.setLayoutResource(R.layout.saas_poi_dynamic_empty);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r103.setOnInflateListener(new b(this, r103));
        this.H = r103;
        r102.addView(r103);
        SkeletonViewType r104 = this.D;
        if (r104 != SkeletonViewType.LYNX) goto L7;
        DmtStatusView.a r105 = new DmtStatusView.a(getContext());
        r105.f(getSkeletonView());
        r105.b(r102);
        r105.d(r100);
        return r105;
    L7:
        if (r104 != SkeletonViewType.NATIVE) goto L10;
        DmtStatusView.a r106 = new DmtStatusView.a(getContext());
        r106.f(getSkeletonViewNative());
        r106.b(r102);
        r106.d(r100);
        return r106;
    L10:
        HashMap<String, String> r107 = this.B.invoke();
        this.f261854J = new LocalLifeLoadingLayout(getContext(), null, 6, 0);
        if (qx6.m.a(r107) == false) goto L14;
        DmtStatusView.a r108 = new DmtStatusView.a(getContext());
        r108.f(this.f261854J);
        r108.b(r102);
        r108.d(r100);
        return r108;
    L14:
        DmtStatusView.a r109 = DmtStatusView.a.a(getContext());
        r109.b(r102);
        r109.d(r100);
        return r109;
    }

    private final Object getRawData() {
        Object r100 = getDitoViewModel().A.get("response_info_for_error_view");
        if ((r100 instanceof yw6.n) == false) goto L5;
        Object r101 = (yw6.n) r100;
    L6:
        if (r101 != null) goto L26;
        r101 = "";
    L26:
        JSONObject r102 = tv5.a.a(com.bytedance.locallife.common.utils.d.b(), r101);     // Catch: JSONException -> L10
    L28:
    L20:
        e = move-exception;
        qs6.b r103 = HostServiceUtilsKt.k();
        if (r103 == null) goto L24;
        r103.e("NewGDSV", "exception when judge network state", e);
    L24:
        return r102;
    L30:
        NetworkInfo r104 = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L25
        if (r104 == null) goto L17;
        if (r104.isConnected() == false) goto L17;
        boolean r105 = true;
    L18:
        r102.put("is_net_available", r105);     // Catch: Exception -> L20
    L17:
        r105 = false;
    L10:
        r102 = new JSONObject();
        goto L28
    L5:
        r101 = null;
        goto L6
    }

    private final View getSkeletonView() {
        e r100 = new e(this, getContext());
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r100.setGravity(80);
        r100.setOrientation(1);
        r100.setVisibility(0);
        ViewStub r101 = new ViewStub(getContext());
        r101.setLayoutResource(R.layout.saas_poi_goods_detail_status_view_skeleton_view);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.setOnInflateListener(new NewGoodsDetailStatusView$getSkeletonView$1$1(this));
        this.I = r101;
        r100.addView(r101);
        return r100;
    }

    private final View getSkeletonViewNative() {
        g r100 = new g(this, getContext());
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r100.setGravity(80);
        r100.setOrientation(1);
        r100.setVisibility(0);
        ViewStub r101 = new ViewStub(getContext());
        r101.setLayoutResource(R.layout.saas_poi_goods_detail_status_view_skeleton_view_native);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.setOnInflateListener(new f(this));
        this.I = r101;
        r100.addView(r101);
        return r100;
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        DmtStatusView r100 = (DmtStatusView) findViewById(R.id.status_view);
        DitoPageStatusData r101 = this.A;
        View r102 = findViewById(R.id.poi_dynamic_default_status_view_empty_view);
        if (r102 == null) goto L33;
        String r103 = r101.getEmptyTitle();
        boolean r104 = true;
        if (r103 != null) goto L7;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L18;
        DuxTextView r106 = (DuxTextView) r102.findViewById(R.id.tv_title);
        if (r106 == null) goto L18;
        r106.setText(r101.getEmptyTitle());
    L18:
        String r107 = r101.getEmptySubTitle();
        if (r107 != null) goto L21;
    L26:
        r104 = false;
    L27:
        if (r104 == false) goto L34;
        DuxTextView r108 = (DuxTextView) r102.findViewById(R.id.tv_desc);
        if (r108 == null) goto L35;
        r108.setText(r101.getEmptySubTitle());
        return;
    L35:
        return;
    L34:
        return;
    L21:
        if (r107.length() <= 0) goto L23;
        boolean r109 = true;
    L24:
        if (r109 != true) goto L26;
    L23:
        r109 = false;
        goto L24
    L7:
        if (r103.length() <= 0) goto L9;
        boolean r110 = true;
    L10:
        if (r110 != true) goto L12;
        r105 = true;
        goto L13
    L9:
        r110 = false;
        goto L10
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void S() {
        super.S();
        if (this.L == true) goto L7;
        LocalLifeLoadingLayout r100 = this.f261854J;
        if (r100 == null) goto L7;
        r100.b();
    L7:
        kp6.a<ICubeGlobalListener> r101 = Cube.f257155a;
        Cube.k(this.Q);
        Cube.k(this.R);
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        ht6.a r100 = this.f261855y.fU();
        if (r100 != null) goto L32;
    L8:
        addView(LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_goods_detail_status_view_new, this, false));
        if (this.f261855y.ab().getPopupHeight() <= 0) goto L20;
        DmtStatusView r101 = (DmtStatusView) findViewById(R.id.status_view);
        FrameLayout.LayoutParams r102 = null;
        if (r101 == null) goto L13;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L15:
        if ((r103 instanceof FrameLayout.LayoutParams) == false) goto L17;
        r102 = (FrameLayout.LayoutParams) r103;
    L17:
        if (r102 == null) goto L20;
        r102.height = this.f261855y.ab().getPopupHeight();
        goto L20
    L13:
        r103 = null;
    L20:
        if (this.C <= 0) goto L24;
        DmtStatusView r104 = (DmtStatusView) findViewById(R.id.status_view);
        if (r104 == null) goto L24;
        r104.setOutlineProvider(new r0(this.C));
        r104.setClipToOutline(true);
    L24:
        DmtStatusView r105 = (DmtStatusView) findViewById(R.id.status_view);
        if (r105 == null) goto L27;
        r105.setBuilder(getDefaultPageStatusViewBuilder());
    L27:
        this.f261856z.d(this.N);
        DmtStatusView r106 = (DmtStatusView) findViewById(R.id.status_view);
        if (r106 == null) goto L30;
        Context r107 = getContext();
        int r108 = com.bytedance.locallife.pdp.container.g0.f261152a;
        r106.setBackgroundColor(ContextCompat.getColor(r107, R.color.ConstBGPanelReverse));
    L30:
        getDataCenter().t0().observe(this, this.W);
        return;
    L32:
        r100.getView();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        HostServiceUtilsKt.c().b(e);
        goto L8
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onDestroy() {
        super.onDestroy();
        if (this.L == true) goto L7;
        LocalLifeLoadingLayout r100 = this.f261854J;
        if (r100 == null) goto L7;
        r100.b();
    L7:
        this.f261856z.c(this.N);
        kp6.a<ICubeGlobalListener> r101 = Cube.f257155a;
        Cube.k(this.Q);
        Cube.k(this.R);
        this.V.removeCallbacksAndMessages(null);
    }

    public final Runnable getDismissCallback() {
        return this.O;
    }

    public final boolean getDismissed() {
        return this.P;
    }

    public final SkeletonViewType getSkeletonViewType() {
        return this.D;
    }

    public static final /* synthetic */ Object a0(NewGoodsDetailStatusView r100) {
        return r100.getRawData();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.what != 123) goto L10;
        qs6.b r101 = HostServiceUtilsKt.k();
        if (r101 == null) goto L7;
        r101.w("NewGDSV", "in timeout logic,reset status_view now");
    L7:
        b0();
        return true;
    L10:
        return true;
    }

    public final void setDismissCallback(Runnable r100) {
        this.O = r100;
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.bytedance.locallife.pdp.view.NewGoodsDetailStatusView$pageStatusObserver$1] */
    public NewGoodsDetailStatusView(Context r100, GoodsDetailPage r101, com.bytedance.locallife.pdp.container.a r102, DitoPageStatusData r103, Function0 r104, int r105, SkeletonViewType r106, HideLoadingViewType r110, ww6.i r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "renderStateManager");
        Intrinsics.checkNotNullParameter(r103, "statusData");
        Intrinsics.checkNotNullParameter(r104, "getMobData");
        Intrinsics.checkNotNullParameter(r106, "skeletonViewType");
        Intrinsics.checkNotNullParameter(r110, "hideLoadingViewType");
        Intrinsics.checkNotNullParameter(r111, "bizContext");
        super(r100, null, 0);
        this.f261855y = r101;
        this.f261856z = r102;
        this.A = r103;
        this.B = r104;
        this.C = r105;
        this.D = r106;
        this.E = r110;
        this.F = r111;
        if (r106 == SkeletonViewType.NONE) goto L5;
        boolean r107 = true;
    L6:
        this.L = r107;
        this.N = new g0(this);
        this.S = System.currentTimeMillis();
        this.T = new AtomicInteger(0);
        this.U = new AtomicBoolean(false);
        this.V = new Handler(Looper.getMainLooper(), this);
        this.W = new NewGoodsDetailStatusView$pageStatusObserver$1(this);
        return;
    L5:
        r107 = false;
        goto L6
    }
}
