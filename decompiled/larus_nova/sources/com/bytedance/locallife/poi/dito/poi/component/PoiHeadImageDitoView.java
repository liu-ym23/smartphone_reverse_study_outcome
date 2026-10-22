package com.bytedance.locallife.poi.dito.poi.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.ability.model.AbilityEnum;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.widget.SimpleLynxView;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.interact.AbstractInteractBehavior;
import com.bytedance.locallife.dito.interact.BounceBehavior;
import com.bytedance.locallife.dito.interact.BounceExpandBehavior;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.model.poi.resp.PoiExtension;
import com.bytedance.locallife.model.poi.resp.PoiServerAbmap;
import com.bytedance.locallife.poi.dito.poi.ui.HeaderImageMaskView;
import com.bytedance.locallife.poi.newdetail.widget.PoiDetailBgView;
import com.bytedance.locallife.poi.newdetail.widget.PoiHeartbeatBadgeView;
import com.bytedance.locallife.poi.newdetail.widget.contentplayer.PoiContentPlayerView;
import com.bytedance.locallife.poi.newdetail.widget.lynx.PoiSimpleLynxView;
import com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder;
import com.bytedance.locallife.poi.newdetail.widget.trip.TripPoiHeadAdapter;
import com.bytedance.locallife.poi.newdetail.widget.trip.TripPoiHeadTagsWidget;
import com.bytedance.locallife.poi.newdetail.widget.trip.TripPoiHeadWidget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.dito.poi.player.ui.HorizontalOverScrollLayout;
import com.ss.android.ugc.aweme.poi.event.PoiClickHeaderInfoEvent;
import com.ss.android.ugc.aweme.poi.event.PoiClickNaviBlankEvent;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.HeadVideoStrict;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/PoiHeadImageDitoView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/poi/dito/poi/component/w;", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/d;", "getPoiContentPlayerCallback", "Lcom/ss/android/ugc/aweme/poi/event/PoiClickHeaderInfoEvent;", "event", "", "onEvent", "Lcom/ss/android/ugc/aweme/poi/event/PoiClickNaviBlankEvent;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiHeadImageDitoView extends BaseDitoView<w> {
    public static final /* synthetic */ int V0 = 0;
    public String A;
    public boolean B;
    public FrameLayout C;
    public TripPoiHeadWidget D;
    public PoiSimpleLynxView E;
    public FrameLayout F;
    public SmartImageView G;
    public HeaderImageMaskView H;
    public final h H0;
    public PoiDetailBgView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public PoiContentPlayerView f262458J;
    public boolean K;
    public boolean L;
    public JSONObject L0;
    public PoiPhoto M;
    public int N;
    public int O;
    public int P;
    public final b P0;
    public int Q;
    public boolean R;
    public int S;
    public int T;
    public final d U;
    public final e V;
    public final f W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final g f262459k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f262460p0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PoiBundle f262461y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PoiDetail f262462z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeadImageDitoView f262463a;

        public b(PoiHeadImageDitoView r100) {
            this.f262463a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            PoiBundle r102 = this.f262463a.f262461y;
            if (r102 == null) goto L5;
            String r103 = r102.poiId;
        L7:
            if (TextUtils.equals(r103, r101.optString("poi_id")) == false) goto L10;
            this.f262463a.L0 = r101;
            return;
        L10:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class c extends com.bytedance.locallife.poi.newdetail.component.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PoiHeadImageDitoView f262464e;

        @Override // com.bytedance.locallife.poi.newdetail.widget.contentplayer.d
        public final void a() {
            PoiHeadImageDitoView.c0(this.f262464e, 1, "slide", k(), 0, false, false, PoiHeadImageDitoView.a0(this.f262464e), null, null, Boolean.TRUE, 49024);
        }

        public c(PoiHeadImageDitoView r100) {
            this.f262464e = r100;
        }

        @Override // com.bytedance.locallife.poi.newdetail.component.a, com.bytedance.locallife.poi.newdetail.widget.contentplayer.d
        public final void b(com.bytedance.locallife.poi.newdetail.widget.contentplayer.i r110) {
            Intrinsics.checkNotNullParameter(r110, "tagItem");
            super.b(r110);
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r100 = r110.b();
            String r101 = null;
            if (r100 == null) goto L5;
            String r111 = r100.e();
        L6:
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r112 = r110.b();
            if (r112 == null) goto L9;
            r101 = r112.a();
        L9:
            String r113 = r101;
            JSONObject r102 = k();
            if (r113 == null) goto L12;
            boolean r103 = true;
        L13:
            PoiHeadImageDitoView.c0(this.f262464e, 1, "click_photo", r102, 0, false, r103, PoiHeadImageDitoView.a0(this.f262464e), r113, r111, Boolean.TRUE, 48384);
            return;
        L12:
            r103 = false;
            goto L13
        L5:
            r111 = null;
            goto L6
        }

        @Override // com.bytedance.locallife.poi.newdetail.component.a, com.bytedance.locallife.poi.newdetail.widget.contentplayer.d
        public final void j(int r110, List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r111) {
            Intrinsics.checkNotNullParameter(r111, "tabList");
            super.j(r110, r111);
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r100 = ((com.bytedance.locallife.poi.newdetail.widget.contentplayer.i) ListProtector.get(r111, r110)).b();
            String r101 = null;
            if (r100 == null) goto L5;
            String r112 = r100.e();
        L6:
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r102 = ((com.bytedance.locallife.poi.newdetail.widget.contentplayer.i) ListProtector.get(r111, r110)).b();
            if (r102 == null) goto L9;
            r101 = r102.a();
        L9:
            String r113 = r101;
            JSONObject r103 = k();
            if (r113 == null) goto L12;
            boolean r114 = true;
        L13:
            PoiHeadImageDitoView.c0(this.f262464e, 1, "click_arrow", r103, 0, false, r114, PoiHeadImageDitoView.a0(this.f262464e), r113, r112, Boolean.TRUE, 48384);
            return;
        L12:
            r114 = false;
            goto L13
        L5:
            r112 = null;
            goto L6
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeadImageDitoView f262465a;

        public d(PoiHeadImageDitoView r100) {
            this.f262465a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.t r101 = (com.bytedance.locallife.dito.data.t) r100;
            PoiHeadImageDitoView r102 = this.f262465a;
            TripPoiHeadWidget r103 = r102.D;
            if (r103 == null) goto L5;
            r103.d();
        L5:
            PoiContentPlayerView r104 = r102.f262458J;
            if (r104 == null) goto L9;
            r104.c();
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeadImageDitoView f262466a;

        public e(PoiHeadImageDitoView r100) {
            this.f262466a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.t r101 = (com.bytedance.locallife.dito.data.t) r100;
            PoiHeadImageDitoView r102 = this.f262466a;
            TripPoiHeadWidget r103 = r102.D;
            if (r103 == null) goto L5;
            r103.e();
        L5:
            PoiContentPlayerView r104 = r102.f262458J;
            if (r104 == null) goto L9;
            r104.d();
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeadImageDitoView f262467a;

        public f(PoiHeadImageDitoView r100) {
            this.f262467a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            com.bytedance.locallife.dito.data.u r111 = (com.bytedance.locallife.dito.data.u) r110;
            PoiHeadImageDitoView r100 = this.f262467a;
            int r101 = PoiHeadImageDitoView.V0;
            r100.getClass();
            int r102 = r111.f258259e;
            if (r100.B == false) goto L7;
            PoiSimpleLynxView r103 = r100.E;
            if (r103 == null) goto L135;
            r103.i(r111);
        L135:
            if (r102 < 0) goto L140;
            FrameLayout r112 = r100.C;
            if (r112 == null) goto L144;
            r112.setTranslationY(-r102);
        L144:
            PoiDetailBgView r113 = r100.I;
            if (r113 == null) goto L153;
            r113.setBgTop(r100.O - r102);
            return;
        L153:
            return;
        L140:
            FrameLayout r114 = r100.C;
            if (r114 == null) goto L144;
            r114.setTranslationY(0.0f);
            goto L144
        L7:
            w r104 = r100.getModel();
            if (r104 == null) goto L14;
            n r105 = r104.c();
            if (r105 == null) goto L14;
            if (r105.o() != true) goto L14;
            boolean r106 = true;
        L16:
            if (r106 == false) goto L39;
            PoiContentPlayerView r115 = r100.f262458J;
            if (r115 == null) goto L20;
            r115.e(r102);
        L20:
            PoiContentPlayerView r116 = r100.f262458J;
            if (r116 == null) goto L23;
            int r117 = r116.getPageTopOffset();
        L24:
            if (r102 >= 0) goto L28;
            if (r117 <= 0) goto L135;
        L28:
            if (r102 <= (r117 / 2)) goto L35;
            if (r100.K == false) goto L135;
            r100.K = false;
            PoiContentPlayerView r118 = r100.f262458J;
            if (r118 == null) goto L135;
            r118.f();
            goto L135
        L35:
            if (r100.K == true) goto L135;
            r100.K = true;
            PoiContentPlayerView r119 = r100.f262458J;
            if (r119 == null) goto L135;
            r119.g();
            goto L135
        L23:
            r117 = 0;
            goto L24
        L39:
            ViewGroup.LayoutParams r107 = null;
            FrameLayout.LayoutParams r108 = null;
            if (r100.T <= 0) goto L125;
            TripPoiHeadWidget r120 = r100.D;
            if (r120 == null) goto L105;
            if (r102 > 0) goto L105;
            int r109 = r120.f263653k;
            if (r109 == 0) goto L105;
            if (r109 != 1) goto L49;
            ViewGroup.LayoutParams r121 = r120.getLayoutParams();
            r121.height = r120.f263655l - r102;
            r120.setLayoutParams(r121);
        L54:
            Integer r122 = r120.F;
            if (r122 != null) goto L58;
        L78:
            TripPoiHeadTagsWidget r123 = r120.f263667w;
            if (r123 == null) goto L88;
            r120.f263661q = r120.f263659p - r102;
            ViewGroup.LayoutParams r124 = r123.getLayoutParams();
            if ((r124 instanceof FrameLayout.LayoutParams) == false) goto L83;
            FrameLayout.LayoutParams r125 = (FrameLayout.LayoutParams) r124;
        L84:
            if (r125 == null) goto L87;
            r125.topMargin = r120.f263661q;
        L87:
            r123.setLayoutParams(r125);
            goto L88
        L83:
            r125 = null;
        L88:
            PoiHeartbeatBadgeView r126 = r120.I;
            if (r126 == null) goto L97;
            r120.f263661q = r120.f263659p - r102;
            ViewGroup.LayoutParams r127 = r126.getLayoutParams();
            if ((r127 instanceof FrameLayout.LayoutParams) == false) goto L93;
            r108 = (FrameLayout.LayoutParams) r127;
        L93:
            if (r108 == null) goto L96;
            r108.topMargin = ((r120.f263661q + ((int) (UIUtils.dip2Px(r120.getContext(), 32.0f) + 0.5f))) + ((int) xo6.b.a(12))) - r108.height;
        L96:
            r126.setLayoutParams(r108);
        L97:
            TripPoiHeadAdapter r128 = r120.f263664t;
            if (r128 == null) goto L105;
            int r129 = r120.f263653k;
            Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r130 = r128.f263535k.entrySet().iterator();
        L101:
            if (r130.hasNext() == false) goto L105;
            PoiHeadViewHolder r131 = r130.next().getValue().get();
            if (r131 == null) goto L101;
            r131.a4(r102, r129);
            goto L101
        L58:
            if (r122.intValue() != 1) goto L78;
            HeadVideoStrict r132 = r120.G;
            if (r132 == null) goto L66;
            String r133 = r132.getEntryDesc();
            if (r133 == null) goto L66;
            if (com.bytedance.locallife.common.utils.j.a(r133) != true) goto L66;
            boolean r134 = true;
        L67:
            if (r134 == false) goto L78;
            ConstraintLayout r135 = r120.f263670z;
            if (r135 == null) goto L88;
            r120.f263661q = r120.f263659p - r102;
            ViewGroup.LayoutParams r136 = r135.getLayoutParams();
            if ((r136 instanceof FrameLayout.LayoutParams) == false) goto L73;
            FrameLayout.LayoutParams r137 = (FrameLayout.LayoutParams) r136;
        L74:
            if (r137 == null) goto L77;
            r137.topMargin = r120.f263661q - ((int) xo6.b.a(28));
        L77:
            r135.setLayoutParams(r137);
            goto L88
        L73:
            r137 = null;
        L66:
            r134 = false;
            goto L67
        L49:
            if (r109 != 2) goto L54;
            HorizontalOverScrollLayout r138 = r120.f263662r;
            if (r138 == null) goto L54;
            r138.setTranslationY(r120.f263656m - (r102 / 2));
        L105:
            TripPoiHeadWidget r139 = r100.D;
            if (r139 == null) goto L108;
            int r140 = r139.getPageTopOffset();
        L109:
            if (r102 >= 0) goto L113;
            if (r140 <= 0) goto L135;
        L113:
            if (r102 <= (r140 / 2)) goto L120;
            if (r100.K == false) goto L135;
            r100.K = false;
            TripPoiHeadWidget r141 = r100.D;
            if (r141 == null) goto L135;
            r141.f();
            goto L135
        L120:
            if (r100.K == true) goto L135;
            r100.K = true;
            TripPoiHeadWidget r142 = r100.D;
            if (r142 == null) goto L135;
            r142.g();
            goto L135
        L108:
            r140 = 0;
            goto L109
        L125:
            if (r111.f258259e >= 0) goto L135;
            FrameLayout r143 = r100.C;
            if (r143 == null) goto L129;
            r107 = r143.getLayoutParams();
        L129:
            if (r107 == null) goto L154;
            r107.height = r100.N - r102;
            FrameLayout r144 = r100.F;
            if (r144 == null) goto L135;
            r144.setLayoutParams(r107);
            goto L135
        L154:
            return;
        L14:
            r106 = false;
            goto L16
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeadImageDitoView f262468a;

        public g(PoiHeadImageDitoView r100) {
            this.f262468a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            PoiHeadImageDitoView r102 = this.f262468a;
            if (r102.B == false) goto L7;
            PoiSimpleLynxView r103 = r102.E;
            if (r103 == null) goto L26;
            r103.j(r101.intValue());
            return;
        L26:
            return;
        L7:
            w r104 = r102.getModel();
            if (r104 == null) goto L14;
            n r105 = r104.c();
            if (r105 == null) goto L14;
            boolean r106 = true;
            if (r105.o() != true) goto L14;
        L15:
            if (r106 == false) goto L19;
            PoiContentPlayerView r107 = this.f262468a.f262458J;
            if (r107 == null) goto L28;
            r107.b(r101);
            return;
        L28:
            return;
        L19:
            TripPoiHeadWidget r108 = this.f262468a.D;
            if (r108 == null) goto L30;
            if (r101 == null) goto L31;
            PoiHeartbeatBadgeView r109 = r108.I;
            if (r109 == null) goto L32;
            r109.b(r101.intValue());
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L14:
            r106 = false;
            goto L15
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeadImageDitoView f262469a;

        public h(PoiHeadImageDitoView r100) {
            this.f262469a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            Integer r111 = (Integer) r110;
            w r112 = this.f262469a.getModel();
            boolean r100 = false;
            if (r112 == null) goto L9;
            n r113 = r112.c();
            if (r113 == null) goto L9;
            if (r113.o() != true) goto L9;
            boolean r114 = true;
        L10:
            if (r114 == true) goto L29;
            PoiHeadImageDitoView r101 = this.f262469a;
            if (r101.f262460p0 == true) goto L28;
            r101.f262460p0 = true;
            PoiPhoto r102 = r101.M;
            Pair[] r115 = new Pair[2];
            if (r101.L == false) goto L17;
            String r103 = "1";
        L18:
            r115[0] = TuplesKt.to("is_video", r103);
            PoiPhoto r104 = this.f262469a.M;
            if (r104 != null) goto L21;
        L23:
            if (r100 == false) goto L25;
            String r105 = "video";
        L26:
            r115[1] = TuplesKt.to("pull_down_type", r105);
            PoiHeadImageDitoView.f0(r101, "pull_down_enlarge_poi_pic", null, null, r102, 0, 0, MapsKt.mapOf(r115), 54);
            return;
        L25:
            r105 = "pic";
            goto L26
        L21:
            if (r104.mediaType != 1) goto L23;
            r100 = true;
            goto L23
        L17:
            r103 = "0";
            goto L18
        L28:
            return;
        L29:
            return;
        L9:
            r114 = false;
            goto L10
        }
    }

    static {
    }

    private final com.bytedance.locallife.poi.newdetail.widget.contentplayer.d getPoiContentPlayerCallback() {
        c r100 = new c(this);
        r100.f263129c = this.L;
        r100.f263127a = this.f262461y;
        r100.f263128b = getDataCenter();
        return r100;
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        com.bytedance.locallife.poi.perf.timing.a.c("bind背景", new Pair[0]);
        Object r100 = getDitoViewModel().A.get("poi_bundle");
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r110 = null;
        if ((r100 instanceof PoiBundle) == false) goto L5;
        PoiBundle r101 = (PoiBundle) r100;
    L6:
        this.f262461y = r101;
        Object r102 = getDitoViewModel().A.get("poi_detail");
        if ((r102 instanceof PoiDetail) == false) goto L9;
        PoiDetail r103 = (PoiDetail) r102;
    L10:
        this.f262462z = r103;
        Object r104 = getDitoViewModel().A.get("poi_detail_str");
        if ((r104 instanceof String) == false) goto L13;
        String r105 = (String) r104;
    L14:
        this.A = r105;
        Object r106 = getDitoViewModel().A.get("card_style");
        if ((r106 instanceof com.bytedance.locallife.poi.newdetail.e) == false) goto L17;
        com.bytedance.locallife.poi.newdetail.e r107 = (com.bytedance.locallife.poi.newdetail.e) r106;
    L17:
        PoiDetail r108 = this.f262462z;
        if (r108 == null) goto L24;
        PoiServerAbmap r109 = r108.abMap;
        if (r109 == null) goto L24;
        if (r109.getHeaderPhotoStyle() != 1) goto L24;
        boolean r111 = true;
    L26:
        if (r111 == false) goto L28;
        this.Q = 2;
    L41:
        PoiDetail r112 = this.f262462z;
        if (r112 == null) goto L46;
        PoiServerAbmap r113 = r112.abMap;
        if (r113 == null) goto L46;
        int r114 = r113.getJumpAlbumPageMode();
    L47:
        this.S = r114;
        w r115 = getModel();
        if (r115 == null) goto L54;
        n r116 = r115.c();
        if (r116 == null) goto L54;
        Integer r117 = r116.n();
        if (r117 == null) goto L54;
        int r118 = r117.intValue();
    L55:
        this.T = r118;
        w r119 = getModel();
        if (r119 == null) goto L62;
        n r120 = r119.c();
        if (r120 == null) goto L62;
        if (r120.o() != true) goto L62;
        boolean r121 = true;
    L63:
        int r122 = -1;
        String r123 = "";
        if (r121 == false) goto L173;
        PoiContentPlayerView r124 = this.f262458J;
        if (r124 == null) goto L69;
        r124.setVisibility(0);
    L69:
        int r125 = com.bytedance.locallife.poi.newdetail.h.f263265d;
        if (r125 <= 0) goto L72;
        int r126 = r125 / 2;
        float r127 = UIUtils.dip2Px(getContext(), 12.0f);
    L73:
        int r128 = r126 - ((int) r127);
        AbstractInteractBehavior<? extends View> r129 = getDitoViewModel().f258035a.Da0();
        if (r129 != null) goto L76;
        int r130 = r128;
        int r131 = 0;
    L91:
        w r132 = getModel();
        if (r132 == null) goto L96;
        n r133 = r132.c();
        if (r133 == null) goto L96;
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r134 = r133.b();
    L97:
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r135 = r134;
        if (r135 != null) goto L100;
    L103:
        boolean r136 = true;
    L104:
        if (r136 == true) goto L117;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r137 = ((com.bytedance.locallife.poi.newdetail.widget.contentplayer.i) ListProtector.get(r134, 0)).b();
        if (r137 == null) goto L114;
        List<PoiPhoto> r138 = r137.d();
        if (r138 == null) goto L114;
        PoiPhoto r139 = (PoiPhoto) ListProtector.get(r138, 0);
        if (r139 == null) goto L114;
        if (r139.mediaType != 1) goto L114;
        boolean r140 = true;
    L115:
        if (r140 == false) goto L117;
        this.L = true;
    L114:
        r140 = false;
    L117:
        PoiContentPlayerView r141 = this.f262458J;
        if (r141 == null) goto L121;
        r141.setVisibility(0);
    L121:
        PoiContentPlayerView r142 = this.f262458J;
        if (r142 == null) goto L153;
        w r143 = getModel();
        if (r143 == null) goto L129;
        n r144 = r143.c();
        if (r144 == null) goto L129;
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r145 = r144.b();
        if (r145 == null) goto L129;
    L130:
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r146 = r145;
        w r147 = getModel();
        if (r147 == null) goto L136;
        n r148 = r147.c();
        if (r148 == null) goto L136;
        List<AlbumTabListModel> r149 = r148.g();
        if (r149 == null) goto L136;
    L137:
        List<AlbumTabListModel> r150 = r149;
        PoiBundle r151 = this.f262461y;
        if (r151 == null) goto L140;
        String r152 = r151.enterId;
    L141:
        if (r151 == null) goto L143;
        String r153 = r151.sessionId;
    L144:
        if (r153 != null) goto L146;
        String r154 = "";
    L147:
        w r155 = getModel();
        if (r155 == null) goto L152;
        n r156 = r155.c();
        if (r156 == null) goto L152;
        r110 = r156.c();
    L152:
        r142.h(this, false, r130, r131, r146, r150, r152, r154, r110, getPoiContentPlayerCallback());
        goto L153
    L146:
        r154 = r153;
        goto L147
    L143:
        r153 = null;
        goto L144
    L140:
        r152 = null;
    L136:
        r149 = CollectionsKt.emptyList();
    L129:
        r145 = CollectionsKt.emptyList();
    L153:
        PoiContentPlayerView r157 = this.f262458J;
        if (r157 == null) goto L156;
        r157.g();
    L156:
        TripPoiHeadWidget r158 = this.D;
        if (r158 == null) goto L160;
        r158.setVisibility(8);
    L160:
        PoiSimpleLynxView r159 = this.E;
        if (r159 == null) goto L164;
        r159.setVisibility(8);
    L164:
        FrameLayout r160 = this.F;
        if (r160 == null) goto L168;
        r160.setVisibility(8);
    L168:
        PoiDetailBgView r161 = this.I;
        if (r161 == null) goto L481;
        r161.setVisibility(8);
        return;
    L481:
        return;
    L100:
        if (r135.isEmpty() == true) goto L103;
        r136 = false;
    L96:
        r134 = null;
        goto L97
    L76:
        if ((r129 instanceof BounceBehavior) == false) goto L79;
        r128 = ((BounceBehavior) r129).f258333o;
    L88:
        r122 = 0;
    L89:
        r130 = r128;
        r131 = r122;
        goto L91
    L79:
        if ((r129 instanceof BounceExpandBehavior) == false) goto L88;
        BounceExpandBehavior r162 = (BounceExpandBehavior) r129;
        r128 = r162.f258362o;
        boolean r163 = r162.f258365r;
        if (r163 == false) goto L83;
        int r164 = r162.f258367t;
    L84:
        if (r164 <= 0) goto L87;
        if (r163 == false) goto L89;
        r122 = r162.f258367t;
        goto L89
    L87:
        r122 = r128;
        goto L89
    L83:
        r164 = -1;
        goto L84
    L72:
        r126 = UIUtils.getScreenWidth(getContext()) / 2;
        r127 = UIUtils.dip2Px(getContext(), 12.0f);
        goto L73
    L173:
        w r165 = getModel();
        if (r165 == null) goto L180;
        n r166 = r165.c();
        if (r166 == null) goto L180;
        if (r166.l() == true) goto L180;
        boolean r167 = true;
    L182:
        if (r167 == false) goto L184;
    L185:
        w r168 = getModel();
        if (r168 == null) goto L190;
        n r169 = r168.c();
        if (r169 == null) goto L190;
        boolean r170 = Intrinsics.areEqual(r169.j(), Boolean.TRUE);
    L191:
        if (r170 == true) goto L200;
        FrameLayout r171 = this.C;
        if (r171 == null) goto L196;
        r171.setVisibility(4);
    L196:
        this.O = 0;
        PoiDetailBgView r172 = this.I;
        if (r172 == null) goto L474;
        r172.setBgTop(0);
    L474:
        PoiBundle r173 = this.f262461y;
        if (r173 == null) goto L479;
        String r174 = r173.sessionId;
        if (r174 == null) goto L479;
        HostServiceUtilsKt.f0().c(r174, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("favourite_75_full_flag", "full"), TuplesKt.to("now_75_full_flag", "full")}), null);
    L479:
        com.bytedance.locallife.poi.perf.timing.a.a("bind背景", new Pair[0]);
        return;
    L200:
        if (this.T < 1) goto L313;
        PoiDetailBgView r175 = this.I;
        if (r175 == null) goto L205;
        r175.setVisibility(0);
    L205:
        TripPoiHeadWidget r176 = this.D;
        if (r176 == null) goto L209;
        r176.setVisibility(0);
    L209:
        PoiSimpleLynxView r177 = this.E;
        if (r177 == null) goto L213;
        r177.setVisibility(4);
    L213:
        FrameLayout r178 = this.F;
        if (r178 == null) goto L217;
        r178.setVisibility(4);
    L217:
        int r179 = com.bytedance.locallife.poi.newdetail.h.f263265d;
        if (r179 <= 0) goto L220;
        int r180 = r179 / 2;
        float r181 = UIUtils.dip2Px(getContext(), 12.0f);
    L221:
        int r182 = r180 - ((int) r181);
        AbstractInteractBehavior<? extends View> r183 = getDitoViewModel().f258035a.Da0();
        if (r183 != null) goto L224;
        int r184 = 0;
    L234:
        PoiDetail r185 = this.f262462z;
        if (r185 == null) goto L239;
        PoiExtension r186 = r185.poiExtension;
        if (r186 == null) goto L239;
        List<PoiPhoto> r187 = r186.photos;
    L240:
        if (r185 == null) goto L244;
        PoiExtension r188 = r185.poiExtension;
        if (r188 == null) goto L244;
        int r189 = r188.picTotalCount;
    L245:
        if (r187 != null) goto L247;
    L251:
        TripPoiHeadWidget r190 = this.D;
        if (r190 == null) goto L258;
        PoiBundle r191 = this.f262461y;
        if (r191 == null) goto L256;
        String r192 = r191.enterId;
    L257:
        r190.setPoiEnterId(r192);
        goto L258
    L256:
        r192 = null;
    L258:
        TripPoiHeadWidget r193 = this.D;
        if (r193 == null) goto L270;
        w r194 = getModel();
        if (r194 == null) goto L268;
        n r195 = r194.c();
        if (r195 == null) goto L268;
        Boolean r196 = r195.k();
        if (r196 == null) goto L268;
        boolean r197 = r196.booleanValue();
    L269:
        r193.setShowAlbumText(r197);
    L268:
        r197 = false;
    L270:
        TripPoiHeadWidget r198 = this.D;
        if (r198 == null) goto L282;
        w r199 = getModel();
        if (r199 == null) goto L280;
        n r200 = r199.c();
        if (r200 == null) goto L280;
        Boolean r201 = r200.d();
        if (r201 == null) goto L280;
        boolean r202 = r201.booleanValue();
    L281:
        r198.setHeadImageTagOpt(r202);
    L280:
        r202 = false;
    L282:
        TripPoiHeadWidget r1100 = this.D;
        if (r1100 == null) goto L303;
        Integer r210 = Integer.valueOf(r189);
        PoiDetail r203 = this.f262462z;
        if (r203 == null) goto L289;
        PoiExtension r204 = r203.poiExtension;
        if (r204 == null) goto L289;
        HeadVideoStrict r211 = r204.headVideo;
    L290:
        w r205 = getModel();
        if (r205 == null) goto L295;
        n r206 = r205.c();
        if (r206 == null) goto L295;
        Integer r212 = r206.h();
    L296:
        w r207 = getModel();
        if (r207 == null) goto L301;
        n r208 = r207.c();
        if (r208 == null) goto L301;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r213 = r208.c();
    L302:
        r1100.h(false, r182, r184, r187, r210, r211, r212, r213, new t(this, r189), new u(this, r189), this.f262461y);
    L301:
        r213 = null;
    L295:
        r212 = null;
    L289:
        r211 = null;
    L303:
        TripPoiHeadWidget r209 = this.D;
        if (r209 == null) goto L307;
        r209.setListener(new v(this));
    L307:
        TripPoiHeadWidget r214 = this.D;
        if (r214 == null) goto L310;
        r214.g();
    L310:
        int r215 = r182 + ((int) UIUtils.dip2Px(getContext(), 12.0f));
        this.O = r215;
        PoiDetailBgView r216 = this.I;
        if (r216 == null) goto L474;
        r216.setBgTop(r215);
        goto L474
    L247:
        if ((!r187.isEmpty()) == false) goto L251;
        if (((PoiPhoto) ListProtector.get(r187, 0)).mediaType != 1) goto L251;
        this.L = true;
    L244:
        r189 = 0;
    L239:
        r187 = null;
        goto L240
    L224:
        if ((r183 instanceof BounceBehavior) == false) goto L227;
        r182 = ((BounceBehavior) r183).f258333o;
    L231:
        r122 = 0;
    L232:
        r184 = r122;
        goto L234
    L227:
        if ((r183 instanceof BounceExpandBehavior) == false) goto L231;
        BounceExpandBehavior r217 = (BounceExpandBehavior) r183;
        r182 = r217.f258362o;
        if (r217.f258365r == false) goto L232;
        r122 = r217.f258367t;
        goto L232
    L220:
        r180 = UIUtils.getScreenWidth(getContext()) / 2;
        r181 = UIUtils.dip2Px(getContext(), 12.0f);
        goto L221
    L313:
        w r218 = getModel();
        if (r218 == null) goto L318;
        n r219 = r218.c();
        if (r219 == null) goto L318;
        String r1101 = r219.f();
    L320:
        if (TextUtils.isEmpty(r1101) == true) goto L362;
        this.B = true;
        PoiDetailBgView r220 = this.I;
        if (r220 == null) goto L325;
        r220.setVisibility(4);
    L325:
        TripPoiHeadWidget r221 = this.D;
        if (r221 == null) goto L329;
        r221.setVisibility(4);
    L329:
        PoiSimpleLynxView r222 = this.E;
        if (r222 == null) goto L333;
        r222.setVisibility(0);
    L333:
        FrameLayout r223 = this.F;
        if (r223 == null) goto L337;
        r223.setVisibility(4);
    L337:
        PoiSimpleLynxView r224 = this.E;
        if (r224 == null) goto L340;
        r224.l(this, false);
    L340:
        PoiSimpleLynxView r1102 = this.E;
        if (r1102 == null) goto L474;
        w r225 = getModel();
        if (r225 == null) goto L352;
        n r226 = r225.c();
        if (r226 == null) goto L352;
        JsonObject r227 = r226.e();
        if (r227 == null) goto L352;
        String r228 = r227.toString();
        if (r228 == null) goto L352;
        String r1103 = r228;
    L353:
        PoiBundle r229 = this.f262461y;
        if (r229 == null) goto L356;
        String r1104 = r229.sessionId;
    L357:
        Pair[] r230 = new Pair[2];
        String r231 = getDitoViewModel().f258060z.get("dito_trace_session_id");
        if (r231 == null) goto L361;
        r123 = r231;
    L361:
        r230[0] = TuplesKt.to(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, r123);
        r230[1] = TuplesKt.to("font_scale", String.valueOf(HostServiceUtilsKt.z().getCurrentFontScale()));
        SimpleLynxView.b(r1102, r1101, r1103, r1104, MapsKt.mapOf(r230), new o());
        goto L474
    L356:
        r1104 = null;
    L352:
        r1103 = "";
        goto L353
    L362:
        PoiDetailBgView r232 = this.I;
        if (r232 == null) goto L366;
        r232.setVisibility(0);
    L366:
        TripPoiHeadWidget r233 = this.D;
        if (r233 == null) goto L370;
        r233.setVisibility(4);
    L370:
        PoiSimpleLynxView r234 = this.E;
        if (r234 == null) goto L374;
        r234.setVisibility(4);
    L374:
        FrameLayout r235 = this.F;
        if (r235 == null) goto L378;
        r235.setVisibility(0);
    L378:
        PoiDetail r236 = this.f262462z;
        if (r236 == null) goto L408;
        PoiExtension r237 = r236.poiExtension;
        if (r237 == null) goto L408;
        List<PoiPhoto> r238 = r237.photos;
        List<PoiPhoto> r239 = r238;
        if (r239 != null) goto L386;
    L389:
        boolean r240 = true;
    L390:
        if (r240 == false) goto L404;
        rp6.a.b(this.G, "https://lf3-static.bytednsdoc.com/obj/eden-cn/nulojubfbvs/native/header_bg_recommend_enhance_light.png", -1, -1);
        w r241 = getModel();
        if (r241 == null) goto L398;
        n r242 = r241.c();
        if (r242 == null) goto L398;
        if (r242.getType() != 0) goto L398;
        boolean r243 = true;
    L399:
        if (r243 == false) goto L408;
        HeaderImageMaskView r244 = this.H;
        if (r244 == null) goto L408;
        r244.setVisibility(4);
    L398:
        r243 = false;
        goto L399
    L404:
        df6.u r245 = df6.q.c(new ef6.a(((PoiPhoto) ListProtector.get(r238, 0)).picMedium.getUrlList()));
        r245.f468277c = getContext();
        r245.b("poi_head_image");
        r245.f468294t = this.G;
        r245.c();
        SmartImageView r246 = this.G;
        r r247 = new r(this);
        if (r246 == null) goto L408;
        ViewCompat.setAccessibilityDelegate(r246, new com.bytedance.locallife.biz.utils.a(r247));
        goto L408
    L386:
        if (r239.isEmpty() == true) goto L389;
        r240 = false;
    L408:
        w r248 = getModel();
        if (r248 == null) goto L415;
        n r249 = r248.c();
        if (r249 == null) goto L415;
        if (r249.getType() != 1) goto L415;
        boolean r250 = true;
    L416:
        if (r250 == false) goto L438;
        FrameLayout r251 = this.F;
        if (r251 == null) goto L420;
        ViewGroup.LayoutParams r252 = r251.getLayoutParams();
        com.bytedance.locallife.poi.newdetail.h r253 = com.bytedance.locallife.poi.newdetail.h.f263262a;
        r252.height = com.bytedance.locallife.poi.newdetail.h.d();
        r251.setLayoutParams(r252);
        this.N = com.bytedance.locallife.poi.newdetail.h.d();
    L420:
        com.bytedance.locallife.poi.newdetail.h r254 = com.bytedance.locallife.poi.newdetail.h.f263262a;
        int r255 = com.bytedance.locallife.poi.newdetail.h.d();
        this.O = r255;
        PoiDetailBgView r256 = this.I;
        if (r256 == null) goto L423;
        r256.setBgTop(r255);
    L423:
        HeaderImageMaskView r257 = this.H;
        if (r257 == null) goto L426;
        r257.a();
    L426:
        w r258 = getModel();
        if (r258 == null) goto L433;
        n r259 = r258.c();
        if (r259 == null) goto L433;
        if (r259.i() != true) goto L433;
        boolean r260 = true;
    L434:
        if (r260 == false) goto L442;
        HeaderImageMaskView r261 = this.H;
        if (r261 == null) goto L442;
        r261.setHalfMaskHeight((int) UIUtils.dip2Px(getContext(), 29.0f));
    L442:
        if (this.R == true) goto L474;
        this.R = true;
        PoiDetail r262 = this.f262462z;
        if (r262 == null) goto L450;
        PoiExtension r263 = r262.poiExtension;
        if (r263 == null) goto L450;
        List<PoiPhoto> r264 = r263.photos;
        if (r264 == null) goto L450;
        int r265 = r264.size();
    L452:
        if (this.B == true) goto L474;
        w r266 = getModel();
        if (r266 == null) goto L460;
        n r267 = r266.c();
        if (r267 == null) goto L460;
        if (r267.l() == true) goto L460;
        boolean r268 = true;
    L461:
        if (r268 == true) goto L474;
        if (this.P >= 3) goto L474;
        if (r265 <= 0) goto L474;
        PoiDetail r269 = this.f262462z;
        if (r269 == null) goto L472;
        PoiExtension r270 = r269.poiExtension;
        if (r270 == null) goto L472;
        List<PoiPhoto> r271 = r270.photos;
        if (r271 == null) goto L472;
        PoiPhoto r272 = (PoiPhoto) ListProtector.get(r271, 0);
    L473:
        f0(this, "show_poi_pic_operation", null, "pic", r272, r265, 1, null, 64);
    L472:
        r272 = null;
    L460:
        r268 = false;
    L450:
        r265 = 0;
    L433:
        r260 = false;
        goto L434
    L438:
        FrameLayout r273 = this.C;
        if (r273 == null) goto L442;
        r273.setOnClickListener(new s(r273, this));
    L415:
        r250 = false;
    L318:
        r1101 = null;
    L190:
        r170 = false;
        goto L191
    L184:
        if (this.P < 3) goto L200;
    L180:
        r167 = false;
    L62:
        r121 = false;
    L54:
        r118 = 0;
    L46:
        r114 = 0;
        goto L47
    L28:
        PoiDetail r274 = this.f262462z;
        if (r274 == null) goto L33;
        PoiServerAbmap r275 = r274.abMap;
        if (r275 == null) goto L33;
        int r276 = r275.getPoiDetailHeadOptV2();
    L34:
        this.P = r276;
        if (r276 > 1) goto L37;
        int r277 = 1;
    L40:
        this.Q = r277;
        goto L41
    L37:
        if (r276 != 2) goto L39;
        r277 = 2;
        goto L40
    L39:
        r277 = 3;
    L33:
        r276 = 0;
    L24:
        r111 = false;
        goto L26
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        com.bytedance.locallife.poi.newdetail.t.b(this);
        setTag(com.bytedance.locallife.biz.fmp.a.f256694b, Boolean.TRUE);
        Object r100 = getDitoViewModel().A.get("inflater_manager");
        PoiContentPlayerView r101 = null;
        if ((r100 instanceof sy6.b) == false) goto L5;
        sy6.b r102 = (sy6.b) r100;
    L6:
        if (r102 == null) goto L8;
        View r103 = r102.a(getContext(), R.layout.saas_poi_detail_head_image, this);
    L9:
        addView(r103);
        if (r103 == null) goto L12;
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.poi_head_image_container);
    L13:
        this.C = r104;
        if (r103 == null) goto L16;
        TripPoiHeadWidget r105 = (TripPoiHeadWidget) r103.findViewById(R.id.poi_trip_head_image_widget);
    L17:
        this.D = r105;
        if (r103 == null) goto L20;
        PoiSimpleLynxView r106 = (PoiSimpleLynxView) r103.findViewById(R.id.poi_lynx_head_image);
    L21:
        this.E = r106;
        if (r103 == null) goto L24;
        FrameLayout r107 = (FrameLayout) r103.findViewById(R.id.poi_native_head_image);
    L25:
        this.F = r107;
        if (r103 == null) goto L28;
        SmartImageView r108 = (SmartImageView) r103.findViewById(R.id.poi_head_image);
    L29:
        this.G = r108;
        if (r103 == null) goto L32;
        HeaderImageMaskView r109 = (HeaderImageMaskView) r103.findViewById(R.id.poi_head_image_mask);
    L33:
        this.H = r109;
        if (r103 == null) goto L36;
        PoiDetailBgView r110 = (PoiDetailBgView) r103.findViewById(R.id.poi_head_bg_view);
    L37:
        this.I = r110;
        if (r103 == null) goto L40;
        r101 = (PoiContentPlayerView) r103.findViewById(R.id.poi_content_player_view);
    L40:
        this.f262458J = r101;
        vn6.b.b(this);
        getDataCenter().m0().observe(this, this.U);
        getDataCenter().n0().observe(this, this.V);
        getDataCenter().v().observe(this, this.W);
        getDataCenter().S().observe(this, this.f262459k0);
        getDataCenter().L().observe(this, this.H0);
        getDataCenter().a0("poi_bottom_bar_service_button_info", 1).observe(this, this.P0);
        DitoDataCenter r111 = getDataCenter();
        int r112 = DitoDataCenter.f258004d;
        r111.a0("click_header_image", 1).observe(this, new p(this));
        getDataCenter().a0("click_placeholder_trans", 1).observe(this, new q(this));
        return;
    L36:
        r110 = null;
        goto L37
    L32:
        r109 = null;
        goto L33
    L28:
        r108 = null;
        goto L29
    L24:
        r107 = null;
        goto L25
    L20:
        r106 = null;
        goto L21
    L16:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onDestroy() {
        super.onDestroy();
        if (this.B == false) goto L7;
        PoiSimpleLynxView r100 = this.E;
        if (r100 == null) goto L7;
        r100.h();
    L7:
        vn6.b.c(this);
    }

    public static final JSONObject a0(PoiHeadImageDitoView r100) {
        JSONObject r101 = r100.L0;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        w r102 = r100.getModel();
        if (r102 == null) goto L16;
        n r103 = r102.c();
        if (r103 == null) goto L16;
        JsonObject r104 = r103.a();
        if (r104 == null) goto L16;
        Iterator<T> r105 = r104.entrySet().iterator();     // Catch: Exception -> L17
    L13:
        if (r105.hasNext() == false) goto L16;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Exception -> L17
        r101.put((String) r106.getKey(), tv5.a.c((JsonElement) r106.getValue()));     // Catch: Exception -> L17
    L16:
        return r101;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiClickHeaderInfoEvent r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        PoiBundle r100 = this.f262461y;
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r210.f451330b, r100.sessionId) == false) goto L9;
        b0(r210.f451331c, "click_top_pic", r210.f451332d, r210.f451329a, false, r210.f451333e, r210.f451334f, r210.f451338j, r210.f451335g, r210.f451336h, r210.f451337i, r210.f451339k, r210.f451340l, r210.f451341m, r210.f451342n, r210.f451343o);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiClickNaviBlankEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f262461y != null) goto L6;
        return;
    L6:
        throw null;
    }

    public PoiHeadImageDitoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.K = true;
        int r103 = com.bytedance.locallife.poi.newdetail.h.f263262a.e();
        this.N = r103;
        this.O = r103;
        this.Q = 1;
        this.U = new d(this);
        this.V = new e(this);
        this.W = new f(this);
        this.f262459k0 = new g(this);
        this.H0 = new h(this);
        this.P0 = new b(this);
    }

    public final void d0(String r100, String r101, String r110, PoiPhoto r111, int r112, int r113, Map<String, String> r114) {
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r103 = new mq6.c();
        mq6.a r104 = mq6.c.a.f514894a;
        r103.g("enter_from", "poi_page");
        PoiBundle r105 = this.f262461y;
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.backendType;
    L6:
        r103.g("poi_backend_type", r107);
        PoiBundle r108 = this.f262461y;
        if (r108 == null) goto L9;
        String r109 = r108.poiId;
    L10:
        r103.g("poi_id", r109);
        kt6.f r115 = HostServiceUtilsKt.s();
        PoiBundle r116 = this.f262461y;
        if (r116 == null) goto L13;
        String r117 = r116.cityCode;
    L14:
        boolean r118 = r115.b(r117);
        String r119 = "1";
        if (r118 == false) goto L17;
        String r120 = "1";
    L18:
        r103.g("poi_device_samecity", r120);
        PoiBundle r121 = this.f262461y;
        if (r121 == null) goto L21;
        String r122 = r121.enterId;
    L22:
        r103.g("poi_enter_id", r122);
        PoiBundle r123 = this.f262461y;
        if (r123 == null) goto L25;
        String r124 = r123.from;
    L26:
        r103.g("poi_enter_page", r124);
        PoiBundle r125 = this.f262461y;
        if (r125 == null) goto L29;
        String r126 = r125.enterMethod;
    L30:
        r103.g(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r126);
        r103.a("poi_pic_mode", this.Q);
        r103.g("75_full_flag", "full");
        PoiDetail r127 = this.f262462z;
        Object r128 = "";
        if (r127 == null) goto L40;
        PoiExtension r129 = r127.poiExtension;
        if (r129 == null) goto L40;
        HeadVideoStrict r130 = r129.headVideo;
        if (r130 == null) goto L40;
        Integer r131 = r130.getUserCnt();
        if (r131 == null) goto L40;
        String r132 = r131.toString();
        if (r132 == null) goto L40;
    L41:
        r103.g("check_in_nums", r132);
        PoiDetail r133 = this.f262462z;
        if (r133 == null) goto L48;
        PoiExtension r134 = r133.poiExtension;
        if (r134 == null) goto L48;
        HeadVideoStrict r135 = r134.headVideo;
        if (r135 == null) goto L48;
        String r136 = r135.getEntryDesc();
    L49:
        if (r136 != null) goto L51;
    L54:
        boolean r137 = true;
    L55:
        if (r137 == false) goto L57;
        r119 = "0";
    L57:
        r103.g("is_check_in_video", r119);
        if (r101 == null) goto L60;
        r103.d("enter_method", r101);
    L60:
        if (r110 == null) goto L62;
        r103.d("section_type", r110);
    L62:
        if (r111 == null) goto L72;
        Float r138 = r111.picScore;
        if (r138 != null) goto L66;
        r138 = Float.valueOf(0.0f);
    L66:
        r103.d("pic_score", String.valueOf(r138.floatValue()));
        String r139 = r111.picSource;
        if (r139 != null) goto L69;
        r139 = "";
    L69:
        r103.d("pic_source", r139);
        if (TextUtils.isEmpty(r111.tabName) == true) goto L72;
        r103.d(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r111.tabName);
    L72:
        if (r112 <= 0) goto L74;
        r103.d("pic_cnt", String.valueOf(r112));
    L74:
        if (r113 <= 0) goto L76;
        r103.d("pic_location", String.valueOf(r113));
    L76:
        if (r114 == null) goto L83;
        Set<Map.Entry<String, String>> r140 = r114.entrySet();
        if (r140 == null) goto L83;
        Iterator<T> r141 = r140.iterator();
    L81:
        if (r141.hasNext() == false) goto L83;
        Map.Entry r142 = (Map.Entry) r141.next();
        r103.d((String) r142.getKey(), (String) r142.getValue());
    L83:
        Unit r143 = Unit.INSTANCE;
        if (r111 == null) goto L86;
        r106 = r111.getMedium();
    L86:
        r103.d("uri", r106);
        r103.d("module_location", "top_collection");
        FrameLayout r144 = this.F;
        if (r144 == null) goto L89;
        Object r145 = Integer.valueOf(r144.getHeight());
    L90:
        r103.c("pic_length", r145);
        FrameLayout r146 = this.F;
        if (r146 == null) goto L93;
        r128 = Integer.valueOf(r146.getWidth());
    L93:
        r103.c("pic_width", r128);
        com.bytedance.locallife.biz.mob.a.C3646a.c(r100, r103.f514893a);
        return;
    L89:
        r145 = "";
        goto L90
    L51:
        if (r136.length() == 0) goto L54;
        r137 = false;
    L48:
        r136 = null;
    L40:
        r132 = "";
        goto L41
    L29:
        r126 = null;
        goto L30
    L25:
        r124 = null;
        goto L26
    L21:
        r122 = null;
        goto L22
    L17:
        r120 = "0";
        goto L18
    L13:
        r117 = null;
        goto L14
    L9:
        r109 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f0(PoiHeadImageDitoView r110, String r111, String r112, String r113, PoiPhoto r114, int r115, int r116, Map r117, int r118) {
        if ((r118 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r118 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r118 & 8) == 0) goto L13;
        PoiPhoto r102 = null;
    L15:
        if ((r118 & 16) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r118 & 32) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r118 & 64) == 0) goto L25;
        Map r105 = null;
    L26:
        r110.d0(r111, r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r117;
        goto L26
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static /* synthetic */ void c0(PoiHeadImageDitoView r210, int r211, String r212, JSONObject r213, int r214, boolean r215, boolean r216, JSONObject r217, String r218, String r219, Boolean r310, int r311) {
        if ((r311 & 8) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r311 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r311 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r311 & 64) == 0) goto L17;
        JSONObject r110 = null;
    L19:
        if ((r311 & 128) == 0) goto L21;
        String r111 = null;
    L23:
        if ((r311 & 256) == 0) goto L25;
        Boolean r112 = Boolean.FALSE;
    L27:
        if ((r311 & 512) == 0) goto L29;
        String r113 = "photo";
    L31:
        if ((r311 & 1024) == 0) goto L33;
        Boolean r114 = Boolean.FALSE;
    L35:
        if ((r311 & 4096) == 0) goto L37;
        Boolean r115 = Boolean.FALSE;
    L39:
        if ((r311 & 8192) == 0) goto L41;
        Boolean r116 = Boolean.FALSE;
    L43:
        if ((r311 & 16384) == 0) goto L45;
        Boolean r117 = Boolean.FALSE;
    L46:
        r210.b0(r211, r212, r213, r100, r101, r102, r110, r111, r112, r113, r114, null, r115, r116, r117, null);
        return;
    L45:
        r117 = r310;
        goto L46
    L41:
        r116 = null;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = r219;
        goto L31
    L25:
        r112 = null;
        goto L27
    L21:
        r111 = r218;
        goto L23
    L17:
        r110 = r217;
        goto L19
    L13:
        r102 = r216;
        goto L15
    L9:
        r101 = r215;
        goto L11
    L5:
        r100 = r214;
        goto L7
    }

    public final void b0(int r210, String r211, JSONObject r212, int r213, boolean r214, boolean r215, JSONObject r216, String r217, Boolean r218, String r219, Boolean r310, List<AlbumTabListModel> r311, Boolean r312, Boolean r313, Boolean r314, String r315) {
        boolean r100 = HostServiceUtilsKt.y0();
        boolean r101 = HostServiceUtilsKt.h().b(AbilityEnum.ALBUM_SERVICE);
        if (r100 == false) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        String r102 = null;
        if (r311 != null) goto L14;
        w r103 = getModel();
        if (r103 == null) goto L13;
        n r104 = r103.c();
        if (r104 == null) goto L13;
        List<AlbumTabListModel> r110 = r104.g();
    L15:
        PoiBundle r105 = this.f262461y;
        if (r105 != null) goto L18;
        return;
    L18:
        HashMap<String, String> r106 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("75_full_flag", "full"), TuplesKt.to("enter_from", "poi_page"), TuplesKt.to("enter_method", r211), TuplesKt.to("poi_pic_mode", String.valueOf(this.Q))});
        if (r212 == null) goto L27;
        Iterator<String> r107 = r212.keys();
        if (r107 == null) goto L27;
    L23:
        if (r107.hasNext() == false) goto L27;
        String r108 = r107.next();
        String r109 = r212.optString(r108);
        if (com.bytedance.locallife.dito.utils.j.i(r109) == false) goto L23;
        r106.put(r108, r109);
    L27:
        com.bytedance.locallife.host.photo.b r111 = HostServiceUtilsKt.W();
        String r112 = this.A;
        if (r216 == null) goto L30;
        r102 = r216.toString();
    L30:
        String r113 = r102;
        w r114 = getModel();
        if (r114 == null) goto L37;
        n r115 = r114.c();
        if (r115 == null) goto L37;
        Boolean r116 = r115.m();
        if (r116 == null) goto L37;
        boolean r117 = r116.booleanValue();
    L38:
        if (r117 == true) goto L45;
        if (r310 == null) goto L41;
        boolean r118 = r310.booleanValue();
    L42:
        if (r118 == true) goto L45;
        boolean r119 = false;
    L46:
        if (r218 == null) goto L48;
        boolean r120 = r218.booleanValue();
    L49:
        if (r219 != null) goto L51;
        String r121 = "photo";
    L52:
        r111.O(this, r105, r112, r210, r213, r214, r106, r215, r113, r217, r119, r120, r121, r110, r312, r313, r314, r315);
        return;
    L51:
        r121 = r219;
        goto L52
    L48:
        r120 = false;
        goto L49
    L41:
        r118 = false;
    L45:
        r119 = true;
    L37:
        r117 = false;
    L13:
        r110 = null;
        goto L15
    L14:
        r110 = r311;
        goto L15
    }
}
