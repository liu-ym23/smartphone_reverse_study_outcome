package com.ss.android.lark.feed.shared.page.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.data.expired_fold.FeedExpiredFoldThresholdConfig;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;
import com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.FeedCommonViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.FeedExpiredFoldHintViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.l;
import com.ss.android.lark.feed.shared.page.binder2.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import teb.g;
import z5c.y3;
import zdc.h;

/* JADX INFO: loaded from: classes35.dex */
public class LarkFeedInBoxListAdapter extends FeedListAdapter implements bw7.e<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f421299q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f421300r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public UIFeedCard f421301s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f421302t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f421303u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public teb.d f421304v;

    public class a implements veb.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkFeedInBoxListAdapter f421305a;

        public a(LarkFeedInBoxListAdapter r100) {
            this.f421305a = r100;
        }

        @Override // veb.a.b
        public final void a(DiffUtil.DiffResult r100, UpdateRecord r101) {
            LarkFeedInBoxListAdapter.E2(this.f421305a, r101.f421128b);
            FeedListAdapter.c r102 = this.f421305a.f421291l;
            if (r102 == null) goto L5;
            r102.a(r101);
        L5:
            r100.dispatchUpdatesTo(this.f421305a);
            FeedListAdapter.c r103 = this.f421305a.f421291l;
            if (r103 == null) goto L9;
            r103.b(r101);
            return;
        }
    }

    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkFeedInBoxListAdapter f421306a;

        public b(LarkFeedInBoxListAdapter r100) {
            this.f421306a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r101) {
            super.onScrollStateChanged(r100, r101);
            this.f421306a.getClass();
        }
    }

    public interface c {
        void a();

        void b();
    }

    public class d extends cw7.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LarkFeedInBoxListAdapter f421307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f421308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LarkFeedInBoxListAdapter f421309d;

        @Override // cw7.a
        public final void a() {
            this.f421307b = null;
        }

        @Override // cw7.a
        public final void c() {
        }

        @Override // cw7.a
        public final void b() {
            UIFeedCard r100 = this.f421307b.G2(this.f421308c);
            UIFeedCard r101 = this.f421309d.f421301s;
            if (r101 == null) goto L5;
            r101.setSwipedLeftPinned(false);
            this.f421307b.notifyItemChanged(this.f421309d.f421301s);
        L5:
            this.f421309d.f421301s = r100;
            r100.setSwipedLeftPinned(true);
            this.f421307b.notifyItemChanged(r100);
            FeedHitPointNew.b(FeedHitPointNew.FeedMainClickParam.FEED_LEFTSLIDE, null, null, neb.e.a(r100));
        }

        public d(LarkFeedInBoxListAdapter r100, LarkFeedInBoxListAdapter r101, int r102) {
            this.f421309d = r100;
            this.f421307b = r101;
            this.f421308c = r102;
        }
    }

    public class e extends cw7.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView.ViewHolder f421310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f421311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LarkFeedInBoxListAdapter f421312d;

        @Override // cw7.a
        public final void b() {
            UIFeedCard r100 = this.f421312d.G2(this.f421311c);
            UIFeedCard r101 = this.f421312d.f421301s;
            if (r101 == null) goto L5;
            r101.setSwipedLeftPinned(false);
        L5:
            this.f421312d.f421301s = r100;
            FeedHitPointNew.b(FeedHitPointNew.FeedMainClickParam.FEED_RIGHTSLIDE, null, null, neb.e.a(r100));
            r100.setSwipeRightPinned(true);
        }

        @Override // cw7.a
        public final void c() {
            RecyclerView.ViewHolder r100 = this.f421310b;
            if ((r100 instanceof BaseFeedSwipeableViewHolder) == false) goto L6;
            ((BaseFeedSwipeableViewHolder) r100).f421317l = true;
            return;
        }

        public e(LarkFeedInBoxListAdapter r100, RecyclerView.ViewHolder r101, int r102) {
            this.f421312d = r100;
            this.f421310b = r101;
            this.f421311c = r102;
        }
    }

    public class f extends cw7.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LarkFeedInBoxListAdapter f421313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f421314c;

        @Override // cw7.a
        public final void a() {
            this.f421313b = null;
        }

        @Override // cw7.a
        public final void c() {
        }

        @Override // cw7.a
        public final void b() {
            UIFeedCard r100 = this.f421313b.G2(this.f421314c);
            r100.setSwipedLeftPinned(false);
            r100.setSwipeRightPinned(false);
            this.f421313b.notifyItemChanged(r100);
        }

        public f(LarkFeedInBoxListAdapter r100, int r101) {
            this.f421313b = r100;
            this.f421314c = r101;
        }
    }

    public final void F2() {
        this.f421283d = null;
        this.f421284e = null;
        this.f421285f = null;
        this.f421286g = null;
        this.f421287h = null;
        this.f421291l = null;
        this.f421292m = null;
        veb.a r100 = this.f421281b;
        r100.f554533a = null;
        r100.f554538f.shutdown();
        r100.f554535c = null;
    }

    public final void I2() {
        UIFeedCard r100 = this.f421301s;
        if (r100 == null) goto L6;
        r100.setSwipedLeftPinned(false);
        this.f421301s.setSwipeRightPinned(false);
        notifyItemChanged(this.f421301s);
        return;
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public static void D2(LarkFeedInBoxListAdapter r100) {
        Object r101 = r100.f421299q;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (CollectionUtils.isEmpty(r100.items) == false) goto L7;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L7:
        if (r100.items.get(0) == null) goto L11;
        if (((UIFeedCard) r100.items.get(0)).getIsExpiredFoldHint() == false) goto L11;
        r100.items.remove(0);     // Catch: Throwable -> L13
        r100.notifyItemRemoved(0);     // Catch: Throwable -> L13
        goto L11
    }

    public UIFeedCard G2(int r100) {
        if (r100 < getItemCount()) goto L7;
        return null;
    L7:
        return (UIFeedCard) ListProtector.get(this.items, r100);
    }

    public final void H2(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
    L6:
        if (r101 >= this.items.size()) goto L18;
        UIFeedCard r102 = (UIFeedCard) ListProtector.get(this.items, r101);
        if (r102 == null) goto L12;
        if (r102.getId().equals(r100) == false) goto L12;
        notifyItemChanged(r102);
        return;
    L12:
        r101 = r101 + 1;
        goto L6
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter
    public /* bridge */ /* synthetic */ UIFeedCard getItem(int r100) {
        return G2(r100);
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter, com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        UIFeedCard r101 = G2(r100);
        if (r101 != null) goto L5;
    L16:
        return -1;
    L5:
        if (r101.getIsExpiredFoldHint() == true) goto L16;
        long r102 = CastLongProtector.parseLong(r101.getId());     // Catch: Throwable -> L10
    L13:
        if (r102 == (-1)) goto L15;
        return r102;
    L15:
        return r101.getId().hashCode();
    L10:
        th = move-exception;
        Log.e("SafeParseUtils", th.getMessage());
        r102 = -1;
        goto L13
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        UIFeedCard r101 = G2(r100);
        if (r101 == null) goto L9;
        if (r101.getIsExpiredFoldHint() == false) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return super.getItemViewType(r100);
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        this.f421280a.addOnScrollListener(new b(this));
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public void update(UpdateRecord r100) {
        super.update(r100);
        teb.d r101 = this.f421304v;
        if (r101 == null) goto L6;
        r101.f545647b.postOnAnimation(r101.f545651f);
        return;
    }

    public static /* synthetic */ void E2(LarkFeedInBoxListAdapter r100, List r101) {
        r100.items = r101;
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public final void C2(int r100, int r101) {
        ((LinearLayoutManager) this.f421280a.getLayoutManager()).scrollToPositionWithOffset(r100, r101);
    }

    @Override // bw7.e
    public final void H(RecyclerView.ViewHolder r100, int r101) {
        this.f421302t = true;
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (getItemViewType(r101) == Integer.MAX_VALUE) goto L5;
        super.onBindViewHolder(r100, r101);
        return;
    L5:
        if ((r100 instanceof FeedExpiredFoldHintViewHolder) == false) goto L27;
        FeedExpiredFoldHintViewHolder r102 = (FeedExpiredFoldHintViewHolder) r100;
        r102.f421334b.setVisibility(0);
        int r103 = com.ss.android.lark.feed.shared.hitpoint.a.f421203a;
        s5c.a r104 = y3.f570424p;
        r104.getClass();
        Statistics.sendEvent("feed_msg_guidance_view", s5c.d.b.c(r104));
        TextView r105 = r102.f421337e;
        keb.a.f503130a.getClass();
        peb.b r106 = heb.a.f484903a;
        Locale r107 = r106.getSettingDependency().getCacheLanguageSetting();
        Intrinsics.checkNotNull(r107);
        Map<String, keb.b> r108 = ((FeedExpiredFoldThresholdConfig) SettingManager.getInstance().get(FeedExpiredFoldThresholdConfig.class)).b();
        keb.b r109 = null;
        if (r108 == null) goto L9;
        keb.b r110 = r108.get("Lark_IM_FilterClutter_Onboard_Title");
    L10:
        String r111 = keb.a.a(r107, r110);
        if (r111 != null) goto L13;
        r111 = UIHelper.getString(R.string.Lark_IM_FilterClutter_Onboard_Title);
    L13:
        r105.setText(r111);
        TextView r112 = r102.f421338f;
        Locale r113 = r106.getSettingDependency().getCacheLanguageSetting();
        Intrinsics.checkNotNull(r113);
        Map<String, keb.b> r114 = ((FeedExpiredFoldThresholdConfig) SettingManager.getInstance().get(FeedExpiredFoldThresholdConfig.class)).b();
        if (r114 == null) goto L16;
        r109 = r114.get("Lark_IM_FilterClutter_Onboard_Desc");
    L16:
        String r115 = keb.a.a(r113, r109);
        if (r115 != null) goto L23;
        String r116 = UIHelper.getString(R.string.Lark_IM_FilterClutter_Onboard_Desc);
        ICUUtils.FormatArgsBuilder r117 = new ICUUtils.FormatArgsBuilder();
        Integer r118 = ((FeedExpiredFoldThresholdConfig) SettingManager.getInstance().get(FeedExpiredFoldThresholdConfig.class)).a();
        if (r118 == null) goto L21;
        int r119 = r118.intValue();
    L22:
        r117.a(Integer.valueOf(r119));
        r115 = ICUUtils.icuFormat(r116, r117.f285892a);
        goto L23
    L21:
        r119 = 14;
    L23:
        r112.setText(r115);
        r102.f421335c.setOnClickListener(new l(r102));
        r102.f421336d.setOnClickListener(new m(r102));
        return;
    L9:
        r110 = null;
        goto L10
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != Integer.MAX_VALUE) goto L7;
        return new FeedExpiredFoldHintViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.feed_expired_fold_hint, r100, false), new g(this));
    L7:
        return super.onCreateViewHolder(r100, r101);
    }

    public LarkFeedInBoxListAdapter(reb.a<com.ss.android.lark.feed.export.feedcard.e> r100, com.ss.android.lark.feed.export.feedcard.d r101, bw7.b r102) {
        super(r100, r101, r102);
        this.f421299q = new Object();
        a r103 = new a(this);
        this.f421303u = true;
        this.f421281b.f554533a = r103;
        setHasStableIds(true);
    }

    public final void J2(RecyclerView.ViewHolder r100, int r101, boolean r102) {
        if (this.f421302t == false) goto L22;
        this.f421302t = false;
        c r103 = this.f421300r;
        if (r103 == null) goto L8;
        r103.b();
    L8:
        if ((r100 instanceof FeedCommonViewHolder) == false) goto L23;
        UIFeedCard r104 = G2(r101);
        if (r104 == null) goto L24;
        aeb.f r105 = ((FeedCommonViewHolder) r100).f421332z;
        if (r105 == null) goto L25;
        if (r102 == true) goto L15;
    L17:
        if (r102 == false) goto L19;
        return;
    L19:
        if (r104.isSwipeRightPinned() == true) goto L28;
        r105.l(r104);
        return;
    L28:
        return;
    L15:
        if (r104.isSwipedLeftPinned() == true) goto L17;
        r105.g(r104);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // bw7.e
    public final void b0(RecyclerView.ViewHolder r100, int r101, int r102) {
        if (r102 != 3) goto L6;
        J2(r100, r101, false);
        return;
    L6:
        if (r102 != 1) goto L10;
        J2(r100, r101, true);
        return;
    }

    @Override // bw7.e
    public final cw7.a q2(RecyclerView.ViewHolder r100, int r101, int r102) {
        if (r102 != 1) goto L5;
    L29:
        c r103 = this.f421300r;
        if (r103 == null) goto L32;
        r103.a();
    L32:
        I2();
        return null;
    L5:
        if (r102 == 2) goto L22;
        if (r102 == 4) goto L9;
        return null;
    L9:
        UIFeedCard r104 = G2(r101);
        if (r104.isSwipedLeftPinned() == false) goto L14;
        return new f(this, r101);
    L14:
        if ((r100 instanceof BaseFeedSwipeableViewHolder) == false) goto L22;
        if (((BaseFeedSwipeableViewHolder) r100).f421317l == false) goto L20;
        return new dfb.g(this, r100, r104, this.f421286g);
    L20:
        return new e(this, r100, r101);
    L22:
        if ((r100 instanceof BaseFeedSwipeableViewHolder) == false) goto L29;
        if (((BaseFeedSwipeableViewHolder) r100).f421317l == false) goto L28;
        return new f(this, r101);
    L28:
        return new d(this, this, r101);
    }

    @Override // bw7.e
    public final int Q1(RecyclerView.ViewHolder r100, int r101, int r110, int r111) {
        int r102 = 0;
        if (this.f421303u == true) goto L5;
        return 0;
    L5:
        int r103 = dfb.a.f468330a;
        Intrinsics.checkNotNullParameter(r100, "holder");
        boolean r104 = true;
        if ((r100 instanceof FeedCommonViewHolder) == true) goto L8;
        ((com.ss.android.lark.integrator.im.feed_shared.dependency.f) heb.a.f484903a.getFeedDependency()).getClass();
        Intrinsics.checkNotNullParameter(r100, "holder");
        boolean r105 = false;
    L10:
        if (r105 == false) goto L27;
        if (G2(r101).getType() == FeedCard.Type.BOX) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L27;
        int r107 = seb.b.f541664d;
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof BaseFeedSwipeableViewHolder) == false) goto L21;
        BaseFeedSwipeableViewHolder r108 = (BaseFeedSwipeableViewHolder) r100;
        if (h.c(r108.r1(), r110, r111) == false) goto L21;
        r102 = r108.T3();
    L21:
        if (r102 == 8194) goto L23;
    L25:
        return r102;
    L23:
        if (G2(r101).equals(this.f421301s) == true) goto L25;
        I2();
        this.f421301s = null;
        goto L25
    L14:
        r106 = false;
    L27:
        if ((r100 instanceof AbstractSwipeableItemViewHolder) == true) goto L29;
    L39:
        return 0;
    L29:
        if (G2(r101).getType() != FeedCard.Type.BOX) goto L32;
        r104 = false;
    L32:
        if (r104 == false) goto L39;
        if (h.c(((AbstractSwipeableItemViewHolder) r100).r1(), r110, r111) == false) goto L39;
        if (G2(r101).equals(this.f421301s) == true) goto L38;
        I2();
        this.f421301s = null;
    L38:
        return 8194;
    L8:
        r105 = true;
        goto L10
    }
}
