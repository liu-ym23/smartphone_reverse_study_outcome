package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.PlaylistTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.CommonMineFirstLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CustomSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.DialogLoadingView;
import com.bytedance.android.live.ktv.common.ordersong.view.SongTextSwitcher;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.skin.KtvDressWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/firstleveltab/MineFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/CommonMineFirstLevelTabFragment;", "<init>", "()V", "a", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MineFirstLevelTabFragment extends CommonMineFirstLevelTabFragment {
    public static final /* synthetic */ int G = 0;
    public final Lazy A;
    public DialogLoadingView B;
    public b C;
    public final ArrayList<String> D;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d E;
    public final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a F;
    public boolean x;
    public WidgetManager y;
    public long z;

    public static final class a {
    }

    public static final class b extends ka0.a {
        public final String c;
        public final WeakReference<FrameLayout> d;

        public final void a(HybridCard r4, String r5) {
            StringCompanionObject r6 = StringCompanionObject.INSTANCE;
            ALogger.e("BannerWidget", String.format("initYourselfInfoView, onLoadFailed failed, infoLynxUrl: %s, errMsg: %s", Arrays.copyOf(new Object[]{this.c, r5}, 2)));
            FrameLayout r7 = this.d.get();
            if (r7 == null) goto L6;
            r7.setVisibility(8);
            return;
        }

        public final void b(HybridCard r3, View r4, int r5) {
            StringCompanionObject r6 = StringCompanionObject.INSTANCE;
            ALogger.i("BannerWidget", String.format("initYourselfInfoView, onViewCreated success, infoLynxUrl: %s", Arrays.copyOf(new Object[]{this.c}, 1)));
            FrameLayout r7 = this.d.get();
            if (r7 == null) goto L5;
            r7.removeAllViews();
        L5:
            if (r7 == null) goto L7;
            r7.addView(r3);
        L7:
            if (r7 == null) goto L10;
            r7.setVisibility(0);
            return;
        }

        public b(Context r2, Uri r3, int r4, String r5, WeakReference<FrameLayout> r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "originUri");
            Intrinsics.checkNotNullParameter(r5, "infoLynxUrl");
            Intrinsics.checkNotNullParameter(r6, "lynxContainer");
            super(r2, r3, r4);
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MineFirstLevelTabFragment a;

        public static final class a<T> implements Observer {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                String r3 = (String) r2;
                MineFirstLevelTabFragment r0 = this.a.a;
                if (r3 != null) goto L5;
                r3 = "";
            L5:
                MineFirstLevelTabFragment.ga0(r0, r3);
            }
        }

        public c(MineFirstLevelTabFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.a.E;     // Catch: Throwable -> L11
            if (r0 == null) goto L5;
            r0.syncHighScoreSongList(true);     // Catch: Throwable -> L11
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = this.a.E;     // Catch: Throwable -> L11
            if (r1 == null) goto L14;
            MutableLiveData<vb0.a> r2 = r1.getOrderSongUiState();     // Catch: Throwable -> L11
            if (r2 == null) goto L18;
            com.bytedance.android.livesdk.ktvapi.util.d.a(r2, this.a, MineFirstLevelTabFragment$initData$1$1.INSTANCE, new a(this));     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ MineFirstLevelTabFragment a;

        public d(MineFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            MineFirstLevelTabFragment r0 = this.a;
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            MineFirstLevelTabFragment.ga0(r0, r3);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ MineFirstLevelTabFragment a;

        public e(MineFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            MineFirstLevelTabFragment r0 = this.a;
            int r1 = MineFirstLevelTabFragment.G;
            if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) r0).q, FirstLevelTab.MySongTab) == false) goto L8;
            DialogLoadingView r2 = this.a.B;
            if (r2 == null) goto L9;
            r2.a(Intrinsics.areEqual(r4, Boolean.TRUE));
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ MineFirstLevelTabFragment a;

        public f(MineFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            if (r4 == null) goto L14;
            int r5 = ((Number) r4.component1()).intValue();
            this.a.getClass();
            FirstLevelTab r0 = FirstLevelTab.MySongTab;
            if (r5 != r0.getValue()) goto L13;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r6 = ((BaseFirstLevelTabFragment) this.a).q;
            if (r6 == null) goto L10;
            y r7 = r6.getSelectedSecondLevelTabData(r0.getValue());
        L11:
            this.a.ca0(r7);
            return;
        L10:
            r7 = null;
            goto L11
        L13:
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ MineFirstLevelTabFragment a;

        public g(MineFirstLevelTabFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            MineFirstLevelTabFragment r12 = this.a;
            if (r12.z > 0) goto L5;
        L7:
            r12.z = System.currentTimeMillis();
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) r12).q;
            if (r0 == null) goto L10;
            y r1 = r0.getSelectedSecondLevelTabData(FirstLevelTab.MySongTab.getValue());
        L11:
            if (r1 == null) goto L14;
            List r2 = r1.h;
            if (r2 == null) goto L14;
        L16:
            if (r2.isEmpty() == false) goto L18;
            f2.b(2131918492, 0);
            return;
        L18:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = r12.E;
            if (r3 != null) goto L21;
        L48:
            f2.b(2131918497, 0);
            return;
        L21:
            if (r3.canSelectMore() != true) goto L48;
            ArrayList r4 = new ArrayList();
            Iterator r5 = r2.iterator();
        L25:
            if (r5.hasNext() == false) goto L30;
            MusicPanel r6 = (MusicPanel) r5.next();
            if (r6.b != 1) goto L25;
            r4.add(r6);
            goto L25
        L30:
            if (r4.isEmpty() == false) goto L32;
            f2.b(2131918492, 0);
            return;
        L32:
            com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.l;
            if (((Boolean) r7.getValue()).booleanValue() == false) goto L45;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = r12.E;
            if (r8 == null) goto L45;
            if (r8.isAudienceEnableSing() != true) goto L45;
            Context r9 = r12.getContext();
            x0.d r10 = new x0.d();
            r10.b = r9;
            r10.a = 0;
            r10.a = 7;
            r10.c = s1.B(2131918496);
            r10.d = s1.B(2131918495);
            r10.m = Float.valueOf(2.0f);
            String r13 = s1.B(2131918493);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.c r14 = com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.c.a;
            x0.c[] r15 = r10.g;
            x0.c r16 = r15[1];
            if (r16 != null) goto L41;
            r16 = new x0.c();
            r15[1] = r16;
        L41:
            r16.a = r13;
            r16.b = r14;
            String r17 = s1.B(2131918494);
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.d r18 = new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.d(r12, r4, r1);
            x0.c[] r19 = r10.g;
            x0.c r20 = r19[0];
            if (r20 != null) goto L44;
            r20 = new x0.c();
            r19[0] = r20;
        L44:
            r20.a = r17;
            r20.b = r18;
            r10.k = true;
            x0.b.g(new x0(r10.b, r10));
            com.bytedance.android.livesdk.sharedpref.f.d(r7, Boolean.FALSE);
            return;
        L45:
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r110 = r12.E;
            if (r110 == null) goto L59;
            r110.orderPlayAllSong(r4, r1);
            return;
        L59:
            return;
        L14:
            r2 = new ArrayList();
            goto L16
        L10:
            r1 = null;
            goto L11
        L5:
            if ((System.currentTimeMillis() - r12.z) >= 3000) goto L7;
            f2.b(2131918498, 0);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.MineFirstLevelTabFragment$initData$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(vb0.a.class, "infoLynxUrl", "getInfoLynxUrl()Ljava/lang/String;", 0);
        }

        public Object get(Object r1) {
            return ((vb0.a) r1).g;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.MineFirstLevelTabFragment$initData$4, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass4 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(vb0.a.class, "isRequestRecommendApi", "isRequestRecommendApi()Ljava/lang/Boolean;", 0);
        }

        public Object get(Object r1) {
            return ((vb0.a) r1).i;
        }
    }

    static {
    }

    public MineFirstLevelTabFragment() {
        this(null, null, null, null);
    }

    public final Function1<Context, CustomViewTab> W90() {
        return KSongOrderSongUtilKt.a();
    }

    public final void initData() {
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment*/.initData();
        SongTextSwitcher r0 = ((CommonMineFirstLevelTabFragment) this).t;
        if (r0 == null) goto L5;
        KtvOrderSongThemeManager.d(r0, 10);
    L5:
        SongTextSwitcher r1 = ((CommonMineFirstLevelTabFragment) this).t;
        if (r1 == null) goto L8;
        r1.setSwitcherTextList(this.D);
    L8:
        SongTextSwitcher r2 = ((CommonMineFirstLevelTabFragment) this).t;
        if (r2 == null) goto L15;
        String r3 = (String) CollectionsKt.firstOrNull(this.D);
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r2.y(r3);
    L15:
        if (KtvUtilsKt.v() == true) goto L39;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L39;
        if (jc0.a.c() == true) goto L39;
        t61 r4 = com.bytedance.android.livesdk.ktvimpl.base.util.f.a();
        if (r4 != null) goto L23;
    L31:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = this.E;
        if (r5 == null) goto L34;
        r5.syncHighScoreSongList(true);
    L34:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.E;
        if (r6 == null) goto L39;
        MutableLiveData<vb0.a> r7 = r6.getOrderSongUiState();
        if (r7 == null) goto L39;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r7, this, AnonymousClass2.INSTANCE, new d(this));
        goto L39
    L23:
        if (u61.a(r4) != true) goto L31;
        FrameLayout r8 = ((BaseFirstLevelTabFragment) this).g;
        if (r8 == null) goto L39;
        c r9 = new c(this);
        t61 r10 = com.bytedance.android.livesdk.ktvimpl.base.util.f.a();
        if (r10 == null) goto L29;
        long r11 = r10.a3();
    L30:
        r8.postDelayed(r9, r11);
        goto L39
    L29:
        r11 = 1000;
    L39:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r12 = this.E;
        if (r12 == null) goto L44;
        MutableLiveData<vb0.a> r13 = r12.getOrderSongUiState();
        if (r13 == null) goto L44;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r13, this, AnonymousClass4.INSTANCE, new e(this));
    L44:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r14 = ((BaseFirstLevelTabFragment) this).q;
        if (r14 == null) goto L47;
        r14.observeSelectedFirstLevelTabValueChange(this, new f(this));
    L47:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r15 = this.E;
        if (r15 == null) goto L50;
        r15.observeCurOrderedMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.a(this));
    L50:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r16 = this.E;
        if (r16 == null) goto L53;
        r16.observeCurFavoriteMusic(this, new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.b(this));
    L53:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r17 = ((BaseFirstLevelTabFragment) this).q;
        ModeType r18 = null;
        if (r17 == null) goto L56;
        y r19 = r17.getSelectedSecondLevelTabData(FirstLevelTab.MySongTab.getValue());
    L57:
        ConstraintLayout r20 = ((CommonMineFirstLevelTabFragment) this).u;
        TextView r21 = ((CommonMineFirstLevelTabFragment) this).v;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r22 = this.E;
        if (r22 == null) goto L60;
        r18 = r22.getModeType();
    L60:
        KSongOrderSongUtilKt.g(r19, r20, r21, r18);
        ha0(r19);
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L63;
    L64:
        FrameLayout r23 = ((CommonMineFirstLevelTabFragment) this).s;
        if (r23 == null) goto L69;
        r23.setVisibility(8);
        return;
    L69:
        return;
    L63:
        if (jc0.a.c() == true) goto L64;
        return;
    L56:
        r19 = null;
        goto L57
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment*/.onDestroy();
        WidgetManager r0 = this.y;
        if (r0 == null) goto L5;
        r0.unload((KtvDressWidget) this.A.getValue());
    L5:
        FrameLayout r1 = ((CommonMineFirstLevelTabFragment) this).s;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        b r2 = this.C;
        if (r2 == null) goto L11;
        r2.release();
    L11:
        this.C = null;
    }

    public final com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r9) {
        Intrinsics.checkNotNullParameter(r9, "secondLevelTabData");
        if (r9.g != PlaylistTabType.TAB_TYPE_DRESS_LIST.getValue()) goto L6;
        int r1 = CustomSecondLevelTabFragment.k;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = ((BaseFirstLevelTabFragment) this).q;
        Function3<Fragment, FrameLayout, View, Unit> r5 = new MineFirstLevelTabFragment$createSecondLevelTabFragment$1(this);
        Function2<Integer, String, Unit> r7 = new MineFirstLevelTabFragment$createSecondLevelTabFragment$2(this);
        Intrinsics.checkNotNullParameter(r9, "secondLevelTabData");
        return new CustomSecondLevelTabFragment(r3, r9, r5, null, r7);
    L6:
        int r2 = MusicListSecondLevelTabFragment.x;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4 = ((BaseFirstLevelTabFragment) this).q;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.E;
        Intrinsics.checkNotNullParameter(r9, "secondLevelTabData");
        return new MusicListSecondLevelTabFragment(r9, r4, r6);
    }

    public final void U50(boolean r8) {
        if (r8 == false) goto L14;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r9 = this.E;
        if (r9 == null) goto L6;
        ModeType r10 = r9.getModeType();
    L7:
        KSongOrderSongUtilKt.o(r10, ((BaseFirstLevelTabFragment) this).q, FirstLevelTab.MySongTab, null, false, null, 56);
        if (KtvUtilsKt.v() == true) goto L15;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r11 = this.E;
        if (r11 == null) goto L12;
        r11.syncHighScoreSongList(false);
    L12:
        int r12 = com.bytedance.android.live.ktv.common.util.i.a;
        JSONObject r13 = new JSONObject();
        r13.put("eventName", "event_ktv_personal_card_show");
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r13);
        return;
    L15:
        return;
    L6:
        r10 = null;
        goto L7
    }

    public final y X90(String r8) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = ((BaseFirstLevelTabFragment) this).q;
        boolean r1 = true;
        y r3 = null;
        Object r4 = null;
        r3 = null;
        if (r0 == null) goto L16;
        List r2 = r0.getSecondLevelTabDataList(FirstLevelTab.MySongTab.getValue());
        if (r2 == null) goto L16;
        Iterator r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        if (((y) r6).g != PlaylistTabType.TAB_TYPE_DRESS_LIST.getValue()) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
        r4 = r6;
        goto L15
    L12:
        r7 = false;
    L15:
        r3 = (y) r4;
    L16:
        if (r3 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r9 = this.F;
        if (r9 != null) goto L20;
    L22:
        r1 = false;
    L23:
        if (r1 == false) goto L26;
        return r3;
    L20:
        if (r9.hasNewKtvDress() != true) goto L22;
    L26:
        return super/*com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment*/.X90(r8);
    }

    public final void ca0(y r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        if (ea0(r18) == false) goto L8;
        return;
    L8:
        if (r18.g != PlaylistTabType.TAB_TYPE_DRESS_LIST.getValue()) goto L12;
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r1 = this.F;
        if (r1 == null) goto L12;
        r1.getPageDressList();
    L12:
        ModeType r16 = null;
        if (Intrinsics.areEqual(r18.c, "recently") == false) goto L15;
    L16:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.E;
        if (r2 == null) goto L21;
        MutableLiveData<vb0.a> r3 = r2.getOrderSongUiState();
        if (r3 == null) goto L21;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r3, MineFirstLevelTabFragment$onSecondLevelTabSelected$1.INSTANCE);
    L21:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r4 = ((BaseFirstLevelTabFragment) this).q;
        if (r4 == null) goto L28;
        long r5 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.E;
        if (r6 == null) goto L26;
        ModeType r7 = r6.getModeType();
    L27:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b.a.b(r4, r5, true, 0, KSongOrderSongUtilKt.f(r7), r18, 0, 0, null, new MineFirstLevelTabFragment$onSecondLevelTabSelected$2(this), 228);
        goto L28
    L26:
        r7 = null;
    L28:
        ConstraintLayout r8 = ((CommonMineFirstLevelTabFragment) this).u;
        TextView r9 = ((CommonMineFirstLevelTabFragment) this).v;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r10 = this.E;
        if (r10 == null) goto L31;
        r16 = r10.getModeType();
    L31:
        KSongOrderSongUtilKt.g(r18, r8, r9, r16);
        ha0(r18);
        return;
    L15:
        if (Intrinsics.areEqual(r18.c, "favorite") == false) goto L28;
        goto L16
    }

    public final void da0(y r5) {
        Intrinsics.checkNotNullParameter(r5, "secondLevelTabData");
        if (r5.k == FirstLevelTab.MySongTab.getValue()) goto L5;
        return;
    L5:
        y r0 = KSongOrderSongUtilKt.c(((BaseFirstLevelTabFragment) this).q);
        ModeType r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.c;
    L10:
        if (Intrinsics.areEqual(r2, r5.c) == false) goto L16;
        ConstraintLayout r3 = ((CommonMineFirstLevelTabFragment) this).u;
        TextView r4 = ((CommonMineFirstLevelTabFragment) this).v;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r6 = this.E;
        if (r6 == null) goto L14;
        r1 = r6.getModeType();
    L14:
        KSongOrderSongUtilKt.g(r5, r3, r4, r1);
    L16:
        if (this.x == true) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r5.c, "recently") == false) goto L22;
        this.x = false;
        ha0(r5);
        return;
    L22:
        return;
    L8:
        r2 = null;
        goto L10
    }

    public final void ha0(final y r4) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.E;
        String r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.checkMidiDataInRecentlyLabel(r4));
    L6:
        if (r4 == null) goto L9;
        r1 = r4.c;
    L9:
        if (Intrinsics.areEqual(r1, "recently") == true) goto L11;
    L25:
        SongTextSwitcher r5 = ((CommonMineFirstLevelTabFragment) this).t;
        if (r5 == null) goto L31;
        r5.setVisibility(8);
        return;
    L31:
        return;
    L11:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L25;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = this.E;
        if (r3 == null) goto L19;
        String r6 = r3.getCurSortType();
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r7 = this.E;
        if (r7 == null) goto L19;
        r7.sortSecondLevelTabByType(r6, r4);
    L19:
        SongTextSwitcher r8 = ((CommonMineFirstLevelTabFragment) this).t;
        if (r8 == null) goto L22;
        r8.setOnTextSelectedListener(new MineFirstLevelTabFragment$checkMidiDataChange$2(this, r4));
    L22:
        SongTextSwitcher r9 = ((CommonMineFirstLevelTabFragment) this).t;
        if (r9 == null) goto L29;
        r9.setVisibility(0);
        return;
    L29:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void initView(View r5) {
        super.initView(r5);
        SongTextSwitcher r6 = ((CommonMineFirstLevelTabFragment) this).t;
        if (r6 == null) goto L5;
        r6.setOnWindowStateListener(new AnonymousClass1(this));
    L5:
        ConstraintLayout r7 = ((CommonMineFirstLevelTabFragment) this).u;
        if (r7 == null) goto L8;
        r7.setOnClickListener(new g(this));
    L8:
        ViewGroup.LayoutParams r3 = null;
        DialogLoadingView r8 = new DialogLoadingView(requireContext(), null, 6, 0);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -1);
        r0.gravity = 17;
        r8.setLayoutParams(r0);
        FrameLayout r1 = ((BaseFirstLevelTabFragment) this).g;
        if (r1 == null) goto L12;
        r1.addView(r8);
    L12:
        if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) this).q, FirstLevelTab.MySongTab) == false) goto L22;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.E;
        if (r2 == null) goto L20;
        MutableLiveData<vb0.a> r4 = r2.getOrderSongUiState();
        if (r4 == null) goto L20;
        vb0.a r9 = (vb0.a) r4.getValue();
        if (r9 == null) goto L20;
        Boolean r10 = r9.i;
    L21:
        r8.a(Intrinsics.areEqual(r10, Boolean.TRUE));
    L20:
        r10 = null;
    L22:
        Unit r11 = Unit.INSTANCE;
        this.B = r8;
        FrameLayout r12 = ((CommonMineFirstLevelTabFragment) this).s;
        if (r12 == null) goto L25;
        r3 = r12.getLayoutParams();
    L25:
        if (r3 == null) goto L27;
        r3.height = (int) (((s1.y() - s1.e(32.0f)) / 343) * 80);
    L27:
        FrameLayout r13 = ((CommonMineFirstLevelTabFragment) this).s;
        if (r13 == null) goto L31;
        r13.setLayoutParams(r3);
        return;
    }

    public static final void ga0(MineFirstLevelTabFragment r7, String r8) {
        r7.getClass();
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L5;
        return;
    L5:
        if (jc0.a.c() == true) goto L13;
        Context r2 = r7.getContext();
        if (r2 == null) goto L12;
        b r0 = new b(r2, x6.a.d(r8), s1.y(), r8, new WeakReference(((CommonMineFirstLevelTabFragment) r7).s));
        r7.C = r0;
        r0.loadUrl(r8);
        return;
    L12:
        return;
    }

    public MineFirstLevelTabFragment(String r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3, com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r4) {
        super(r1, r2);
        this.E = r3;
        this.F = r4;
        this.x = true;
        this.A = LazyKt.lazy(new MineFirstLevelTabFragment$mKtvDressWidget$2(this));
        ArrayList<String> r5 = new ArrayList();
        r5.add(com.bytedance.android.live.ktv.common.util.f.b);
        r5.add(com.bytedance.android.live.ktv.common.util.f.a);
        Unit r6 = Unit.INSTANCE;
        this.D = r5;
    }
}
