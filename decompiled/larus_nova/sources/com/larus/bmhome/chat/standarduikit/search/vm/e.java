package com.larus.bmhome.chat.standarduikit.search.vm;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.v1;
import com.larus.bmhome.chat.layout.holder.menu.item.n0;
import com.larus.bmhome.chat.layout.holder.menu.item.p;
import com.larus.bmhome.chat.layout.holder.menu.item.x;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.y;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.SearchVideoItem;
import com.larus.nova.R;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.VideoParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc8.b f309770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f309772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f309773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Integer> f309774e;

    public static final class a implements t0 {
        public a() {
        }

        @Override // com.larus.bmhome.chat.layout.holder.helper.t0
        public final void b(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "keys");
        }

        @Override // com.larus.bmhome.chat.layout.holder.helper.t0
        public final List<ot8.a> a(Context r100, Message r101, Function0<Message> r102, q0 r103, BotModel r104, wc9.e r105, q0.a r106, JSONObject r107) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r104, "chatBot");
            ArrayList r108 = new ArrayList();
            r108.add(new y(x.a(r101), p.a(r101)));
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            r108.add(new i0(0, ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_1, null, R.color.larus_neutral_transparent_1))));
            r108.add(n0.a());
            r108.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r100, r104, false, 8));
            v1.a(r108);
            v1.b(r108, r106);
            return com.larus.bmhome.chat.layout.holder.helper.e.b(r108);
        }
    }

    public e(kc8.b r100) {
        this.f309770a = r100;
        this.f309771b = LazyKt.lazy(new b(this));
        this.f309772c = LazyKt.lazy(new c(this));
        this.f309774e = new LinkedHashSet();
    }

    public final PrefetchRecommendVideoParam a(boolean r310, int r311, List<SearchVideoItem> r312, SearchVideoItem r313, final Message r314, boolean r410, OuterFallbackInfo r411) {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isOversea() == false) goto L6;
        return null;
    L6:
        if (r100.isPlugin() == false) goto L8;
        return null;
    L8:
        String r101 = r314.getMessageId();
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
        return null;
    L17:
        if (r311 == 0) goto L20;
        if (r310 == false) goto L20;
        return null;
    L20:
        if (r410 == false) goto L22;
        VideoParam.RecommendType r103 = VideoParam.RecommendType.Search;
    L24:
        if (r103 == VideoParam.RecommendType.Search) goto L27;
        return null;
    L27:
        if (Intrinsics.areEqual(this.f309773d, r314.getMessageId()) == false) goto L30;
        if (r310 == false) goto L30;
        return null;
    L30:
        List<SearchVideoItem> r104 = r312;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L32:
        if (r106.hasNext() == false) goto L34;
        SearchVideoItem r107 = (SearchVideoItem) r106.next();
        r105.add(new MediaEntity(null, r107.itemId, null, null, null, null, null, null, null, null, null, null, r107.sourceFrom, null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));
        goto L32
    L34:
        this.f309773d = r314.getMessageId();
        CachedVideosPreloadFrom r110 = CachedVideosPreloadFrom.BIND_PULL_API;
        String r108 = r314.getMessageId();
        String r109 = r314.getReplyId();
        String r111 = r313.itemId;
        if (r111 != null) goto L37;
        r111 = "";
    L37:
        List r112 = CollectionsKt.listOf(r111);
        ArrayList r113 = new ArrayList();
        Iterator r114 = r105.iterator();
    L39:
        if (r114.hasNext() == false) goto L43;
        String r115 = ((MediaEntity) r114.next()).getItem_id();
        if (r115 == null) goto L39;
        r113.add(r115);
        goto L39
    L43:
        kc8.b r116 = this.f309770a;
        if (r116 == null) goto L50;
        kc8.y r117 = r116.f502425a;
        if (r117 == null) goto L50;
        q0 r118 = r117.f502643x;
        if (r118 == null) goto L50;
        List<Message> r119 = r118.getCurrentList();
    L51:
        boolean r120 = xc8.m.b(r314, r119);
        kc8.b r121 = this.f309770a;
        if (r121 == null) goto L58;
        kc8.y r122 = r121.f502425a;
        if (r122 == null) goto L58;
        q0 r123 = r122.f502643x;
        if (r123 == null) goto L58;
        List<Message> r124 = r123.getCurrentList();
    L59:
        String r125 = xc8.m.a(r124);
        return new PrefetchRecommendVideoParam(r108, r109, Boolean.valueOf(r410), r112, 0, r110, r113, new d(r314, this), Boolean.valueOf(r120), r125, false, null, r411, false, null, 27648, null);
    L58:
        r124 = null;
    L50:
        r119 = null;
        goto L51
    L22:
        r103 = VideoParam.RecommendType.Non;
        goto L24
    L11:
        if (r101.length() == 0) goto L14;
        r102 = false;
        goto L15
    }
}
