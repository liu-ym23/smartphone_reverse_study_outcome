package com.larus.larkfeed.impl.lark.holder.content;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ixigua.lib.track.FrozenTrackNode;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.larkfeed.impl.gallery.Message2GalleryItemExtKt;
import com.larus.larkfeed.impl.lark.holder.content.longpress.DouBaoMenuScene;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.log.Log;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kc8.j0;
import kc8.k0;
import kc8.v0;
import kc8.x0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
public final class DouBaoBlockContent implements com.ss.android.lark.blueprint.i<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f355326h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f355327i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f355328j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f355329k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f355330l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f355331m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.blueprint.g f355332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IMMessageKeys$Blocks f355333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e5 f355334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f355335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.bmhome.chat.service.e f355336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public kh8.a f355337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f355338g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f355339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.blueprint.m<y6b.a<?>> f355340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y6b.a<?> f355341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Block> f355342d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f355339a, r101.f355339a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f355340b, r101.f355340b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f355341c, r101.f355341c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f355342d, r101.f355342d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Message r100 = this.f355339a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            com.ss.android.lark.blueprint.m<y6b.a<?>> r104 = this.f355340b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            y6b.a<?> r107 = this.f355341c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f355342d.hashCode();
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "BlockState(currentMessage=" + this.f355339a + ", currentCell=" + this.f355340b + ", currentData=" + this.f355341c + ", filteredBlocks=" + this.f355342d + ')';
        }

        public a(Message r100, com.ss.android.lark.blueprint.m<y6b.a<?>> r101, y6b.a<?> r102, List<Block> r103) {
            Intrinsics.checkNotNullParameter(r103, "filteredBlocks");
            this.f355339a = r100;
            this.f355340b = r101;
            this.f355341c = r102;
            this.f355342d = r103;
        }
    }

    public static final class b {
    }

    public static final class c extends wza.a<y6b.a<?>, Object> {
        public c() {
            super(IMMessageKeys$Blocks.DOUBAO_CONTENT);
        }

        @Override // wza.a
        public final com.ss.android.lark.blueprint.i<y6b.a<?>, Object> b(com.ss.android.lark.blueprint.g r100) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
            return new DouBaoBlockContent(r100);
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final Class<Object> b() {
        return null;
    }

    static {
        int r100 = i5.h();
        int r101 = i5.q();
        f355326h = r100;
        f355327i = r100;
        f355328j = r101;
        f355329k = r101;
        f355330l = r100;
        f355331m = r100;
    }

    public static BotModel i() {
        wc9.e r100 = AuthModelDelegate.f297134b.y().getValue();
        if (r100 == null) goto L7;
        String r101 = r100.f559198a;
        if (r101 == null) goto L7;
        return (BotModel) BotInfoCache.INSTANCE.get(r101);
    L7:
        return null;
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f355333b;
    }

    public DouBaoBlockContent(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f355332a = r100;
        this.f355333b = IMMessageKeys$Blocks.DOUBAO_CONTENT;
        z2 r101 = z2.f365865a;
        this.f355334c = new e5(r101.enableMdWidgetsMixedArrangement(), r101.enableDataTagOptimize(), r101.enableTypingAsyncOptimize(), r101.enableTrackerOptimize(), r101.getMarkdownTableRenderConfig().c());
        List<Integer> r102 = r101.getLarkSocialBlockConfig().a();
        if (r102 == null) goto L6;
        List<Integer> r103 = CollectionsKt.filterNotNull(r102);
        if (r103 == null) goto L6;
    L7:
        this.f355335d = r103;
        return;
    L6:
        r103 = CollectionsKt.emptyList();
        goto L7
    }

    public static t1a.b f(Fragment r100) {
        if (r100 == null) goto L8;
        FragmentManager r101 = r100.getChildFragmentManager();
        if (r101 == null) goto L8;
        Fragment r102 = r101.findFragmentByTag("ComponentAdapterFragment");
        if (r102 == null) goto L8;
        return s1a.a.g(r102);
    L8:
        return null;
    }

    public static boolean j(a r100) {
        if (r100 == null) goto L9;
        Message r101 = r100.f355339a;
        if (r101 == null) goto L9;
        if (com.larus.im.bean.message.a.k0(r101) != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
    L36:
        return true;
    L12:
        if (r100 == null) goto L14;
        List<Block> r103 = r100.f355342d;
    L15:
        if (r103 != null) goto L17;
        r103 = CollectionsKt.emptyList();
    L17:
        List<Block> r104 = r103;
        if ((r104 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r105 = r104.iterator();
    L24:
        if (r105.hasNext() == false) goto L34;
        BlockContent r106 = ((Block) r105.next()).getContent();
        if (r106 == null) goto L28;
        MusicCreationContentList r107 = r106.getLyricsToSongsMusicBlock();
    L29:
        if (r107 == null) goto L31;
        boolean r108 = true;
    L32:
        if (r108 == false) goto L24;
        boolean r109 = true;
    L35:
        if (r109 == true) goto L36;
        return false;
    L31:
        r108 = false;
        goto L32
    L28:
        r107 = null;
    L34:
        r109 = false;
        goto L35
    L20:
        if (r104.isEmpty() == false) goto L22;
    L14:
        r103 = null;
    L9:
        r102 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r10v16, types: [com.larus.larkfeed.impl.lark.holder.content.n] */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.larkfeed.impl.lark.holder.content.b] */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.larus.larkfeed.impl.lark.holder.content.h] */
    public final kc8.b g(final View r310) {
        i3b.d r100 = (i3b.d) this.f355332a.f410652c.a(i3b.d.class);
        if (r100 == null) goto L60;
        m2b.a r101 = r100.a();
        if (r101 == null) goto L60;
        int r102 = o3b.a.C7008a.a(r101.H8(), this.f355332a.getContext(), f3b.b.a(r101));
        final int r103 = (r102 - f355326h) - f355327i;
        FLogger r104 = FLogger.f375446a;
        r104.i("yyytest!!", "maxWidth = " + r102 + ", markdownContainerWidth = " + r103);
        s r105 = new s(r310, this, DouBaoMenuScene.GENERIC_CARD);
        s r106 = new s(r310, this, DouBaoMenuScene.PURE_VIDEO);
        int r107 = v0.f502580p;
        v0.a r108 = new v0.a();
        Boolean r109 = Boolean.TRUE;
        r108.f502596a = r109;
        r108.f502598c = true;
        r108.f502599d = true;
        r108.f502601f = r109;
        r108.f502597b = Integer.valueOf(r103);
        r108.f502602g = new RectF(f355328j, f355330l, f355329k, f355331m);
        r108.f502607l = new jh8.a(new k());
        r108.f502605j = new l(this);
        r108.f502603h = new m(r310);
        v0 r110 = r108.a();
        Log.i("yyytest!!", "generateBlockDependConfig");
        int r111 = kc8.b.f502424y;
        kc8.b.a r112 = new kc8.b.a();
        mza.a r113 = (mza.a) this.f355332a.f410652c.a(mza.a.class);
        if (r113 == null) goto L10;
        final RecyclerView r114 = r113.getRecyclerView();
    L11:
        mza.a r115 = (mza.a) this.f355332a.f410652c.a(mza.a.class);
        if (r115 == null) goto L14;
        final Fragment r116 = r115.getFragment();
    L15:
        i3b.d r117 = (i3b.d) this.f355332a.f410652c.a(i3b.d.class);
        if (r117 == null) goto L22;
        m2b.a r118 = r117.a();
        if (r118 == null) goto L22;
        Chat r119 = r118.getChat();
        if (r119 == null) goto L22;
        final String r120 = r119.getId();
    L23:
        int r121 = kc8.y.f502619J;
        kc8.y.a r122 = new kc8.y.a();
        r122.f502653h = new o(this, r116);
        r122.f502654i = new p(this, r116);
        r122.f502656k = new q(this, r116);
        r122.f502657l = new r(this);
        r122.f502659n = new kc8.j(new com.larus.larkfeed.impl.lark.holder.content.b(this, r310), UnixStat.PERM_MASK);
        if (r116 == null) goto L26;
        FrozenTrackNode r123 = by7.h.d(r116);
    L27:
        r122.f502651f = r123;
        t1a.b r124 = f(r116);
        if (r124 == null) goto L32;
        de8.c r125 = (de8.c) r124.a(de8.c.class);
        if (r125 == null) goto L32;
        Long r126 = Long.valueOf(de8.d.a(r125));
    L33:
        r122.f502650e = r126;
        r122.f502652g = r114;
        r122.C = r116;
        r122.H = new com.larus.larkfeed.impl.lark.holder.content.c(r103);
        r122.f502661p = new d(r120);
        Function2<? super Integer, ? super Integer, Unit> r127 = new e(r114);
        Intrinsics.checkNotNullParameter(r127, "value");
        r122.E = r127;
        Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> r128 = new f(r114);
        Intrinsics.checkNotNullParameter(r128, "value");
        r122.F = r128;
        r122.I = new g(this, r310);
        r122.D = r105;
        r112.f502450b = r122.a();
        mza.a r129 = (mza.a) this.f355332a.f410652c.a(mza.a.class);
        if (r129 == null) goto L36;
        Fragment r130 = r129.getFragment();
    L37:
        if (r130 == null) goto L39;
        final LifecycleCoroutineScope r131 = LifecycleOwnerKt.getLifecycleScope(r130);
    L40:
        r104.i("DouBaoBlockContent", "buildCreateBlockConfig: fragment=" + r130 + ", scope=" + r131 + ", creationVideoManager=" + this.f355337f);
        if (this.f355337f != null) goto L54;
        if (r131 == null) goto L54;
        this.f355337f = IUgcAIGCService.f373945a.V(r131);
        r104.i("DouBaoBlockContent", "buildCreateBlockConfig: creationVideoManager 创建成功=" + this.f355337f);
        if (this.f355338g == true) goto L54;
        mza.a r132 = (mza.a) this.f355332a.f410652c.a(mza.a.class);
        if (r132 == null) goto L49;
        RecyclerView r133 = r132.getRecyclerView();
    L50:
        r104.i("DouBaoBlockContent", "bindScrollObserver: recyclerView=" + r133);
        if (r133 == null) goto L54;
        this.f355338g = true;
        r133.addOnScrollListener(new DouBaoBlockContent$bindScrollObserver$1(r131, this));
        goto L54
    L49:
        r133 = null;
    L54:
        u r134 = new u(this);
        x r135 = new x(r310);
        kh8.a r136 = this.f355337f;
        if (r136 == null) goto L57;
        y r210 = new y(r136, r130);
    L58:
        r112.f502460l = new kc8.q(null, null, r134, null, r131, r210, null, null, r135, null, null, new n(this, r310), 3479);
        r112.f502449a = r110;
        r112.f502453e = new k0(ExpandCardViewMode.NORMAL, r106, r106, new j0(Integer.valueOf(c7.b(12)), Integer.valueOf(c7.b(12)), Integer.valueOf(c7.b(8)), Integer.valueOf(c7.b(8)), 6));
        r112.f502451c = new kc8.o(false);
        r112.f502468t = new x0(new kc8.n(c7.b(16), c7.b(12), c7.b(16), c7.b(12)), new h(r310), r105, null, null, 24);
        return r112.a();
    L57:
        r210 = null;
        goto L58
    L39:
        r131 = null;
        goto L40
    L36:
        r130 = null;
    L32:
        r126 = null;
        goto L33
    L26:
        r123 = null;
    L22:
        r120 = null;
        goto L23
    L14:
        r116 = null;
        goto L15
    L10:
        r114 = null;
    L60:
        int r137 = kc8.b.f502424y;
        return new kc8.b.a().a();
    }

    public final kc8.f h(Message r510) {
        if (r510 != null) goto L5;
        Message r100 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L6:
        Boolean r110 = Boolean.TRUE;
        kc8.f r101 = new kc8.f(r100, r110, true, false, new t(this), null, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_MC_REUSE);
        String r102 = null;
        if (r510 == null) goto L9;
        String r111 = r510.getMessageId();
    L10:
        if (r510 == null) goto L12;
        String r112 = r510.getSenderId();
    L13:
        if (r510 == null) goto L15;
        r102 = r510.getConversationId();
    L15:
        String r113 = r102;
        if (r510 == null) goto L18;
        boolean r114 = com.larus.bmhome.chat.bean.d.Q0(r510);
    L19:
        ra8.b r103 = new ra8.b(r111, r112, r113, r114, r110, null, 96);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f502482h = r103;
        return r101;
    L18:
        r114 = false;
        goto L19
    L12:
        r112 = null;
        goto L13
    L9:
        r111 = null;
        goto L10
    L5:
        r100 = r510;
        goto L6
    }

    public final void l(hk9.a r100) {
        i3b.d r101 = (i3b.d) this.f355332a.f410652c.a(i3b.d.class);
        cd8.a r102 = null;
        if (r101 == null) goto L5;
        m2b.a r103 = r101.a();
    L6:
        if (r103 == null) goto L10;
        o3b.a r104 = r103.H8();
        if (r104 == null) goto L10;
        r102 = new cd8.a(0, o3b.a.C7008a.a(r104, this.f355332a.getContext(), f3b.b.a(r103)));
    L10:
        r100.b(cd8.a.class, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        IMMessageKeys$Blocks r102 = this.f355333b;
        IMMessageKeys$Slots r103 = IMMessageKeys$Slots.CONTENT;
        com.ss.android.lark.blueprint.k<?> r104 = r101.f(r102, r103);
        if (r104 == null) goto L9;
        hk9.a r105 = null;
        r104.getView().setTag(null);
        this.f355336e = null;
        View r106 = r104.getView();
        if ((r106 instanceof hk9.a) == false) goto L7;
        r105 = (hk9.a) r106;
    L7:
        if (r105 == null) goto L9;
        r105.a();
    L9:
        r101.o(this.f355333b, r103);
    }

    public final void k(View r100, int r101) {
        Object r102 = r100.getTag();
        Message r103 = null;
        if ((r102 instanceof a) == false) goto L5;
        a r104 = (a) r102;
    L6:
        if (r104 == null) goto L8;
        y6b.a<?> r105 = r104.f355341c;
    L9:
        Object r106 = r100.getTag();
        if ((r106 instanceof a) == false) goto L12;
        a r107 = (a) r106;
    L13:
        if (r107 == null) goto L15;
        r103 = r107.f355339a;
    L15:
        if (r105 == null) goto L18;
        String r108 = r105.getId();
        if (r108 == null) goto L18;
    L19:
        com.larus.larkfeed.impl.gallery.n r109 = Message2GalleryItemExtKt.a(r108, r103, r101);
        i3b.d r110 = (i3b.d) this.f355332a.f410652c.a(i3b.d.class);
        if (r110 == null) goto L25;
        b3b.f r111 = r110.g();
        if (r111 == null) goto L26;
        r111.n(r100, r108, r109.f355254a, r109.f355255b);
        return;
    L26:
        return;
    L25:
        return;
    L18:
        r108 = "";
        goto L19
    L12:
        r107 = null;
        goto L13
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    public static void d(View r100, String r101, List r102) {
        String r103 = null;
        if ((r100 instanceof hk9.a) == false) goto L5;
        hk9.a r104 = (hk9.a) r100;
    L6:
        if (r104 == null) goto L19;
        Object r105 = r104.getTag();
        if ((r105 instanceof a) == false) goto L10;
        a r106 = (a) r105;
    L11:
        if (r106 == null) goto L16;
        Message r107 = r106.f355339a;
        if (r107 == null) goto L16;
        r103 = r107.getMessageId();
    L16:
        if (Intrinsics.areEqual(r103, r101) == false) goto L19;
        ((ArrayList) r102).add(r104);
        goto L19
    L10:
        r106 = null;
    L19:
        if ((r100 instanceof ViewGroup) == true) goto L21;
        return;
    L21:
        ViewGroup r108 = (ViewGroup) r100;
        int r109 = r108.getChildCount();
        int r110 = 0;
    L22:
        if (r110 >= r109) goto L24;
        d(r108.getChildAt(r110), r101, r102);
        r110 = r110 + 1;
        goto L22
    L24:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static int e(View r100, RecyclerView r101, String r102) {
        Object r103 = r100.getTag();
        Integer r104 = null;
        if ((r103 instanceof a) == false) goto L5;
        a r105 = (a) r103;
    L6:
        if (r105 == null) goto L10;
        Message r106 = r105.f355339a;
        if (r106 == null) goto L10;
        String r107 = r106.getMessageId();
    L11:
        int r108 = 0;
        if (Intrinsics.areEqual(r107, r102) == false) goto L24;
        RecyclerView.ViewHolder r109 = r101.findContainingViewHolder(r100);
        if (r109 == null) goto L35;
        Integer r110 = Integer.valueOf(r109.getBindingAdapterPosition());
        if (r110.intValue() == (-1)) goto L18;
        r108 = 1;
    L18:
        if (r108 == 0) goto L20;
        r104 = r110;
    L20:
        if (r104 != null) goto L22;
        return -1;
    L22:
        return r104.intValue();
    L35:
        return -1;
    L24:
        if ((r100 instanceof ViewGroup) == true) goto L26;
        return -1;
    L26:
        ViewGroup r111 = (ViewGroup) r100;
        int r112 = r111.getChildCount();
    L27:
        if (r108 >= r112) goto L32;
        int r113 = e(r111.getChildAt(r108), r101, r102);
        if (r113 != (-1)) goto L30;
        r108 = r108 + 1;
        goto L27
    L30:
        return r113;
    L32:
        return -1;
    L10:
        r107 = null;
        goto L11
    L5:
        r105 = null;
        goto L6
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r110, com.ss.android.lark.blueprint.q<y6b.a<?>> r111, y6b.a<?> r112) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r112, "data");
        Object r100 = r112.b();
        com.larus.bmhome.chat.service.e r101 = null;
        if ((r100 instanceof a0) == false) goto L5;
        a0 r102 = (a0) r100;
    L6:
        if (r102 != null) goto L9;
        r111.o(this.f355333b, IMMessageKeys$Slots.CONTENT);
        return;
    L9:
        int r103 = com.larus.larkfeed.impl.utils.a.f355547a;
        Message r104 = (Message) com.larus.larkfeed.impl.utils.a.a(new DouBaoBlockContent$update$message$1(r102, this, null));
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("update currentMessage id = ");
        if (r104 == null) goto L12;
        String r107 = r104.getMessageId();
    L13:
        r106.append(r107);
        r106.append(", larkMessageId = ");
        r106.append(((DouBaoContent) r102.f553338a).getLarkMessageId());
        r106.append(", logid = ");
        if (r104 == null) goto L16;
        String r108 = com.larus.im.bean.message.a.x(r104);
    L17:
        r106.append(r108);
        r106.append(", isLike = ");
        if (r104 == null) goto L20;
        Boolean r109 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.q0(r104));
    L21:
        r106.append(r109);
        r106.append(" , isDisLike = ");
        if (r104 == null) goto L24;
        Boolean r113 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.h0(r104));
    L25:
        r106.append(r113);
        r106.append(", message content block size = ");
        if (r104 == null) goto L30;
        List<Block> r114 = r104.getContentBlock();
        if (r114 == null) goto L30;
        Integer r115 = Integer.valueOf(r114.size());
    L31:
        r106.append(r115);
        r105.i("yyytest!!", r106.toString());
        StringBuilder r116 = new StringBuilder("update currentMessage id = ");
        if (r104 == null) goto L34;
        String r117 = r104.getMessageId();
    L35:
        r116.append(r117);
        r116.append(", ");
        if (r104 == null) goto L38;
        String r118 = r104.getBrief();
    L39:
        r116.append(r118);
        r116.append(", ");
        if (r104 == null) goto L56;
        List<Block> r119 = r104.getContentBlock();
        if (r119 == null) goto L56;
        ArrayList r120 = new ArrayList();
        Iterator<T> r121 = r119.iterator();
    L45:
        if (r121.hasNext() == false) goto L55;
        Object r122 = r121.next();
        BlockContent r123 = ((Block) r122).getContent();
        if (r123 == null) goto L49;
        CreationBlock r124 = r123.getCreationBlock();
    L50:
        if (r124 == null) goto L52;
        boolean r125 = true;
    L53:
        if (r125 == false) goto L45;
        r120.add(r122);
        goto L45
    L52:
        r125 = false;
        goto L53
    L49:
        r124 = null;
        goto L50
    L55:
        Integer r126 = Integer.valueOf(r120.size());
    L57:
        r116.append(r126);
        r105.i("yyytest!!", r116.toString());
        mza.a r127 = (mza.a) this.f355332a.f410652c.a(mza.a.class);
        if (r127 == null) goto L60;
        Fragment r128 = r127.getFragment();
    L61:
        if (r128 == null) goto L86;
        t1a.b r129 = s1a.a.g(r128);
        if (r129 == null) goto L86;
        u99.a r130 = (u99.a) r129.getAbility(u99.a.class);
        if (r130 == null) goto L86;
        if (r104 == null) goto L73;
        String r131 = r104.getMessageId();
        if (r131 == null) goto L73;
        String r132 = ((DouBaoContent) r102.f553338a).getLarkMessageId();
        if (r132 != null) goto L72;
        r132 = "";
    L72:
        r130.ZH(r131, r132);
    L73:
        if (r104 == null) goto L77;
        String r133 = r104.getReplyId();
        if (r133 == null) goto L77;
        r130.ZH(r133, r133);
    L77:
        i3b.d r134 = (i3b.d) this.f355332a.f410652c.a(i3b.d.class);
        if (r134 == null) goto L86;
        m2b.a r135 = r134.a();
        if (r135 == null) goto L86;
        Chat r136 = r135.getChat();
        if (r136 == null) goto L86;
        String r137 = r136.getId();
        if (r137 == null) goto L86;
        r130.Db(r137);
    L86:
        int r138 = ra8.a.f536852a;
        final hk9.a r139 = ra8.a.a(this.f355332a.getContext());
        FLogger.f375446a.i("yyytest!!", "update contentView = " + r139);
        com.ss.android.lark.blueprint.k r140 = r111.c(this.f355333b, IMMessageKeys$Slots.CONTENT, new com.larus.larkfeed.impl.lark.holder.content.a(r139));
        if (r104 == null) goto L89;
        List<Block> r141 = r104.getContentBlock();
    L90:
        if (r141 != null) goto L92;
        r141 = CollectionsKt.emptyList();
    L92:
        ArrayList r142 = new ArrayList();
        Iterator<T> r143 = r141.iterator();
    L94:
        if (r143.hasNext() == false) goto L96;
        Object r144 = r143.next();
        Block r145 = (Block) r144;
        Log.i("yyytest!!", "filterBlocks blockType = " + r145.getBlockType());
        this.f355335d.contains(Integer.valueOf(r145.getBlockType()));
        r142.add(r144);
        goto L94
    L96:
        ((hk9.a) r140.getView()).setTag(new a(r104, r110, r112, r142));
        ((hk9.a) r140.getView()).setOnLongClickListener(new j(this));
        Object r146 = r140.getView().getTag();
        if ((r146 instanceof a) == false) goto L99;
        a r147 = (a) r146;
    L100:
        if (r147 == null) goto L103;
        Message r148 = r147.f355339a;
        com.ss.android.lark.blueprint.m<y6b.a<?>> r149 = r147.f355340b;
        r101 = IFlowMainBot.f358419a.d8(r148, new z(this, r147.f355341c, r149), Boolean.FALSE);
    L103:
        this.f355336e = r101;
        kc8.f r150 = h(r104);
        ((hk9.a) r140.getView()).b(kc8.b.class, g(r140.getView()));
        l((hk9.a) r140.getView());
        int r151 = ra8.a.f536852a;
        ra8.a.d((hk9.a) r140.getView(), r142, r150, false);
        return;
    L99:
        r147 = null;
        goto L100
    L89:
        r141 = null;
        goto L90
    L60:
        r128 = null;
    L56:
        r126 = null;
        goto L57
    L38:
        r118 = null;
        goto L39
    L34:
        r117 = null;
    L30:
        r115 = null;
        goto L31
    L24:
        r113 = null;
        goto L25
    L20:
        r109 = null;
        goto L21
    L16:
        r108 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        update2(r100, r101, r102);
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void c(BlueprintCell r100, com.ss.android.lark.blueprint.q r101, Object r102, Object r103) {
        com.ss.android.lark.blueprint.i.a.b(this, r100, r101, (y6b.a) r102, r103);
    }
}
