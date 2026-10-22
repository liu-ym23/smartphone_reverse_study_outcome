package com.ss.android.lark.feed.shared.page.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.data.ICache$Operation;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.adapter.exception.FeedCardFactoryNotFoundException;
import com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.FeedCommonViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes35.dex */
public class FeedListAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, UIFeedCard> implements ueb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f421280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final veb.a f421281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final teb.f f421282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f421283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zeb.a f421284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zeb.b f421285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f421286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f421287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final yeb.a f421288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final reb.a<com.ss.android.lark.feed.export.feedcard.e> f421289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public seb.b f421290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f421291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f421292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UpdateRecord f421293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f421294o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.ss.android.lark.feed.shared.page.a f421295p;

    public class a implements veb.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedListAdapter f421296a;

        public a(FeedListAdapter r100) {
            this.f421296a = r100;
        }

        @Override // veb.a.b
        public final void a(DiffUtil.DiffResult r100, UpdateRecord r101) {
            c r102 = this.f421296a.f421291l;
            if (r102 == null) goto L5;
            r102.a(r101);
        L5:
            FeedListAdapter.y2(this.f421296a, r101.f421128b);
            r100.dispatchUpdatesTo(this.f421296a);
            c r103 = this.f421296a.f421291l;
            if (r103 == null) goto L9;
            r103.b(r101);
            return;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421297a = null;

        static {
            int[] r100 = new int[ICache$Operation.Type.values().length];
            f421297a = r100;
            r100[ICache$Operation.Type.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f421297a[ICache$Operation.Type.ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f421297a[ICache$Operation.Type.REMOVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f421297a[ICache$Operation.Type.MOVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f421297a[ICache$Operation.Type.UPDATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface c {
        void a(UpdateRecord r100);

        void b(UpdateRecord r100);
    }

    public final class d implements com.ss.android.lark.feed.export.feedcard.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedListAdapter f421298a;

        public d(FeedListAdapter r100) {
            this.f421298a = r100;
        }

        public final void a(String r100, Function1<? super UIFeedCard, Boolean> r101) {
            List r102 = FeedListAdapter.z2(this.f421298a);
            if (CollectionUtils.isEmpty(r102) == true) goto L11;
            int r103 = 0;
        L6:
            if (r103 >= r102.size()) goto L11;
            UIFeedCard r104 = (UIFeedCard) ListProtector.get(r102, r103);
            if (y0.a(r104.getId(), r100) == true) goto L13;
            r103 = r103 + 1;
        L13:
            if (r101.invoke(r104).booleanValue() == false) goto L21;
            if (r103 >= 0) goto L16;
            return;
        L16:
            if (r103 >= r102.size()) goto L23;
            this.f421298a.notifyItemChanged(r103);
            return;
        L23:
            return;
        L21:
            return;
        L11:
            r104 = null;
            r103 = -1;
            goto L13
        }
    }

    public interface e {
        void a();
    }

    public interface f {
        void a();
    }

    public interface g {
        void a(int r100, UIFeedCard r101);
    }

    public interface h {
    }

    public final void B2() {
        boolean r100 = false;
        this.f421294o = false;
        StringBuilder r101 = new StringBuilder("resume update,  has_pending_record = ");
        if (this.f421293n == null) goto L5;
        r100 = true;
    L5:
        r101.append(r100);
        Log.i("FeedListAdapter", r101.toString());
        UpdateRecord r102 = this.f421293n;
        if (r102 == null) goto L9;
        update(r102);
        this.f421293n = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        return true;
    }

    @Override // ueb.a
    public final boolean y() {
        return true;
    }

    @Override // ueb.a
    public final List<FeedActionType> D1() {
        ArrayList r100 = new ArrayList();
        ((com.ss.android.lark.integrator.im.feed_shared.dependency.f) heb.a.f484903a.getFeedDependency()).getClass();
        FeedFolderCompat r101 = FeedFolderCompat.INSTANCE;
        if (r101.getMESSAGE_WITHOUT_DOUBAO().isSameFolderWith(r101.getDONE()) == false) goto L5;
        r100.add(FeedActionType.DONE);
    L5:
        return r100;
    }

    @Override // ueb.a
    public final List<FeedActionType> w0() {
        return new ArrayList();
    }

    @Override // ueb.a
    public final f c1() {
        return this.f421283d;
    }

    @Override // ueb.a
    public final zeb.b f2() {
        return this.f421285f;
    }

    @Override // ueb.a
    public final zeb.a z() {
        return this.f421284e;
    }

    public static teb.a A2(ViewGroup r100) {
        View r101 = new View(r100.getContext());
        r101.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        return new teb.a(r101);
    }

    public static /* synthetic */ List z2(FeedListAdapter r100) {
        return r100.items;
    }

    @Override // ueb.a
    public final void G1(e r100) {
        this.f421287h = r100;
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        String r101 = ((UIFeedCard) ListProtector.get(this.items, r100)).getId();
        long r102 = CastLongProtector.parseLong(((UIFeedCard) ListProtector.get(this.items, r100)).getId());     // Catch: Throwable -> L5
    L8:
        if (r102 != (-1)) goto L18;
        return UUID.fromString(r101).getMostSignificantBits();
    L11:
        e = move-exception;
        Log.e("FeedListAdapter", "invalid uuid:" + r101, e);
        return r102;
    L18:
        return r102;
    L5:
        th = move-exception;
        Log.e("SafeParseUtils", th.getMessage());
        r102 = -1;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        UIFeedCard r101 = getItem(r100);
        if (r101 != null) goto L7;
        Log.e("FeedListAdapter", "get item view type, getItem is empty");
        return -1;
    L7:
        if (this.f421289j.a(r101.getType(), r101.getBizType()) == null) goto L15;
        if (r101.getType() != FeedCard.Type.APP_FEED) goto L13;
        return r101.getBizType().getValue() + 2000;
    L13:
        return r101.getType().getNumber() + 1000;
    L15:
        if (DevEnvUtil.isDebugMode(this.f421288i.getHost().getContext()) == true) goto L19;
        Log.e("FeedListAdapter", "not registered in the feed card factory");
        return -1;
    L19:
        throw new FeedCardFactoryNotFoundException(r101.getClass());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        r100.getContext();
        this.f421280a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        super.onViewRecycled(r100);
        if ((r100 instanceof BaseFeedSwipeableViewHolder) == false) goto L6;
        ((BaseFeedSwipeableViewHolder) r100).onViewRecycled();
        return;
    }

    public void update(UpdateRecord r100) {
        if (this.f421294o == false) goto L7;
        Log.w("FeedListAdapter", "update isPauseUpdate");
        this.f421293n = r100;
        return;
    L7:
        if (CollectionUtils.isEmpty(r100.f421132f) == true) goto L13;
        this.items = r100.f421128b;
        Iterator<ICache$Operation> r101 = r100.f421132f.iterator();
        if (r101.hasNext() == true) goto L11;
        return;
    L11:
        ICache$Operation r102 = r101.next();
        int[] r103 = b.f421297a;
        r102.getClass();
        throw null;
    L13:
        veb.a r104 = this.f421281b;
        if (r104.f554536d != null) goto L16;
        r104.f554534b = false;
        r104.f554535c = null;
        ArrayList r105 = new ArrayList();
        r105.addAll(r104.f554537e.getItems());
        veb.a.RunnableC7995a r106 = new veb.a.RunnableC7995a(r104, r105, r100);
        r104.f554536d = r106;
        r104.f554538f.execute(r106);
        return;
    L16:
        Log.i("FeedSharedModule_DiffHelper", "[FeedItems] start diff, has pendingRunnable, pending update, items size=" + ((ArrayList) r100.f421128b).size());
        r104.f554535c = r100;
    }

    public static /* synthetic */ void y2(FeedListAdapter r100, List r101) {
        r100.items = r101;
    }

    public void C2(int r100, int r101) {
        if (r100 > (-1)) goto L5;
        return;
    L5:
        if (r100 >= getItemCount()) goto L9;
        ((LinearLayoutManager) this.f421280a.getLayoutManager()).scrollToPositionWithOffset(r100, r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        UIFeedCard r100 = getItem(r111);
        if (r100 != null) goto L6;
        Log.e("FeedListAdapter", "bind view holder, get item is empty");
        return;
    L6:
        r100.setDataObserver(this.f421282c);
        g r101 = this.f421292m;
        if (r101 == null) goto L10;
        r101.a(r111, r100);
    L10:
        if ((r110 instanceof FeedCommonViewHolder) == false) goto L41;
        FeedCommonViewHolder r112 = (FeedCommonViewHolder) r110;
        com.ss.android.lark.feed.export.feedcard.e r113 = this.f421289j.a(r112.A, r112.B);
        boolean r102 = false;
        if (r112.f421331y == null) goto L32;
        if (r113 == null) goto L32;
        r112.f421332z = r113.c(this.f421288i);
        com.ss.android.lark.feed.shared.page.a r114 = this.f421295p;
        yeb.a r103 = this.f421288i;
        Intrinsics.checkNotNullParameter(r100, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r114, "paramsFactory");
        Intrinsics.checkNotNullParameter(this, "itemContainer");
        Intrinsics.checkNotNullParameter(r103, "feedCardContext");
        r112.H = r100;
        Job r104 = r112.C;
        if (r104 == null) goto L17;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L17:
        r112.f421325s.setSelected(false);
        com.ss.android.lark.feed.export.feedcard.h r105 = r112.f421331y;
        if (r105 == null) goto L20;
        r105.b(r112.itemView, r100, r114, r103);
    L20:
        r112.V3(r100, this);
        seb.b r115 = this.f421290k;
        yeb.a r106 = this.f421288i;
        Intrinsics.checkNotNullParameter(r100, "uiFeedCard");
        Intrinsics.checkNotNullParameter(this, "itemContainer");
        Intrinsics.checkNotNullParameter(r106, "feedCardContext");
        com.ss.android.lark.feed.shared.page.binder2.e r107 = new com.ss.android.lark.feed.shared.page.binder2.e(r112, r115);
        r112.H = r100;
        r112.I = r115;
        r112.f421318J = this;
        r112.K = r107;
        r112.f421316k = r100.isSwipedLeftPinned();
        boolean r108 = r100.isSwipeRightPinned();
        r112.f421317l = r108;
        r112.f421329w = false;
        if (r112.f421316k == true) goto L29;
        if (r108 == true) goto L29;
        if (r112.f276058e != 0.0f) goto L26;
        r102 = true;
    L26:
        if (r102 == true) goto L29;
        r112.f276058e = 0.0f;
    L29:
        if ((!((ArrayList) r112.f421327u).isEmpty()) == false) goto L31;
        ((ArrayList) r112.f421327u).clear();
        r112.X3();
    L31:
        r112.f421325s.setOnLongClickListener(new com.ss.android.lark.feed.shared.page.binder2.f(r112, r100, r115, this, r107));
        r112.f421325s.setOnClickListener(new com.ss.android.lark.feed.shared.page.binder2.d(r106, r100, r112));
        return;
    L32:
        StringBuilder r109 = new StringBuilder("FeedCommonViewHolder bindView error occurs! openFeedCell is null?");
        if (r112.f421331y != null) goto L35;
        boolean r116 = true;
    L36:
        r109.append(r116);
        r109.append(", factory is null?");
        if (r113 != null) goto L39;
        r102 = true;
    L39:
        r109.append(r102);
        r109.append(", feedId:");
        r109.append(r100.getId());
        Log.e("FeedListAdapter", r109.toString());
        return;
    L35:
        r116 = false;
        goto L36
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 < 1000) goto L28;
        AppFeedCardType r102 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        if (r101 < 2000) goto L7;
        r102 = AppFeedCardType.fromValue(r101 - 2000);
        FeedCard.Type r103 = FeedCard.Type.APP_FEED;
    L8:
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_feed_list, r100, false);
        if (r103 != null) goto L12;
        Log.e("FeedListAdapter", "onCreateViewHolder feedType is null, inflate empty view holder!");
        return A2(r100);
    L12:
        com.ss.android.lark.feed.export.feedcard.e r105 = this.f421289j.a(r103, r102);
        if (r105 != null) goto L16;
        Log.e("FeedListAdapter", "onCreateViewHolder factory is empty, inflate empty view holder!");
        return A2(r100);
    L16:
        com.ss.android.lark.feed.export.feedcard.h r106 = r105.b(r104);
        FeedCommonViewHolder r107 = new FeedCommonViewHolder(r104, this.f421288i);
        r107.f421331y = r106;
        if (r106 == null) goto L26;
        View r108 = r107.itemView;
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.ViewGroup");
        com.ss.android.lark.feed.export.feedcard.a r109 = r106.a((ViewGroup) r108);
        View r110 = r109.f420998a;
        if (r110 == null) goto L22;
        r107.f421325s.addView(r110);
        goto L26
    L22:
        n r111 = FeedCommonViewHolder.M;
        if (r111 == null) goto L25;
        r111.b(r107.f421320n, r107.f421325s, r109);
        goto L26
    L25:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "layoutStrategy is empty");
    L26:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r107.A = r103;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r107.B = r102;
        return r107;
    L7:
        r103 = FeedCard.Type.forNumber(r101 - 1000);
        goto L8
    L28:
        Log.e("FeedListAdapter", "bind error, inflate empty view holder!");
        return A2(r100);
    }

    public FeedListAdapter(reb.a<com.ss.android.lark.feed.export.feedcard.e> r100, com.ss.android.lark.feed.export.feedcard.d r101, bw7.b r102) {
        a r103 = new a(this);
        this.f421295p = new com.ss.android.lark.feed.shared.page.a();
        veb.a r104 = new veb.a(this);
        this.f421281b = r104;
        r104.f554533a = r103;
        this.f421282c = new teb.f(this);
        this.f421289j = r100;
        this.f421288i = new yeb.a(r101, new d(this), r102);
    }
}
