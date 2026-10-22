package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchResultBlock;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemReferenceListBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: classes25.dex */
public final class ReferenceListBlockView extends AbsBlockView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Block f302297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LarusBlockItemReferenceListBinding f302298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MessageReferenceAdapter f302299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Object> f302300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message f302301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BotModel f302302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f302303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f302304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f302305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f302306k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f302307l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, Boolean> f302308m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void c() {
        this.f302297b = null;
    }

    private final String getDataListIdentifier() {
        if (((ArrayList) this.f302300e).isEmpty() == false) goto L6;
        return "";
    L6:
        Object r100 = CollectionsKt.firstOrNull(this.f302300e);
        if ((r100 instanceof TextCard) == false) goto L11;
        return String.valueOf(((TextCard) r100).getId());
    L11:
        if ((r100 instanceof VideoCard) == false) goto L15;
        return String.valueOf(((VideoCard) r100).getId());
    L15:
        return String.valueOf(this.f302300e.hashCode());
    }

    public final ChatParam g() {
        String r100 = this.f302305j;
        String r101 = this.f302304i;
        LruCache<String, wc9.e> r102 = ko8.a.f504531a;
        return new ChatParam(null, null, r101, r100, ko8.a.e(ko8.a.f504535e), VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL);
    }

    public ReferenceListBlockView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f302300e = new ArrayList();
        this.f302307l = true;
    }

    public static String d(ReferenceListBlockView r100) {
        return r100.getDataListIdentifier();
    }

    public static oi8.n.a f(Object r100) {
        if ((r100 instanceof TextCard) == false) goto L7;
        TextCard r101 = (TextCard) r100;
        oi8.n.a r102 = new oi8.n.a(String.valueOf(r101.getId()), r101.getUrl(), r101.getDocId(), null);
    L9:
        return r102;
    L7:
        if ((r100 instanceof VideoCard) == false) goto L10;
        VideoCard r103 = (VideoCard) r100;
        r102 = new oi8.n.a(r103.getId(), r103.getMainSiteUrl(), r103.getItemId(), null);
        goto L9
    L10:
        return null;
    }

    public static Unit e(ReferenceListBlockView r210, boolean r211) {
        Message r100 = r210.f302301f;
        if (r100 == null) goto L11;
        int r101 = oi8.n.f523465a;
        ri8.c r102 = ri8.c.f537890a;
        String r103 = ri8.c.g(Boolean.valueOf(!r211));
        BotModel r104 = r210.f302302g;
        if (r104 == null) goto L7;
        String r105 = r104.getBotId();
    L8:
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        String r106 = r105;
        oi8.n.a(r100, r210.g(), null, 0, null, "simple_search", r106, r103, null, null, null, null, Boolean.TRUE, null, null, null, null, AbsBlockView.a.d(r210.f302297b), null, null, null, 3923732);
        goto L11
    L7:
        r105 = null;
    L11:
        Map<String, Boolean> r107 = r210.f302308m;
        if (r107 == null) goto L15;
        Boolean r108 = r107.put(r210.getDataListIdentifier(), Boolean.valueOf(r211));
    L15:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r100, Map<String, Object> r110) {
        this.f302297b = r100;
        Boolean r101 = null;
        if (r110 == null) goto L5;
        Object r102 = r110.get("block_view_extra_message");
    L7:
        if ((r102 instanceof Message) == false) goto L9;
        Message r103 = (Message) r102;
    L10:
        this.f302301f = r103;
        if (r110 == null) goto L13;
        Object r104 = r110.get("block_view_extra_bot_model");
    L15:
        if ((r104 instanceof BotModel) == false) goto L17;
        BotModel r105 = (BotModel) r104;
    L18:
        this.f302302g = r105;
        if (r110 == null) goto L21;
        Object r106 = r110.get("block_view_extra_mob_research_id");
    L23:
        if ((r106 instanceof String) == false) goto L25;
        String r107 = (String) r106;
    L26:
        this.f302303h = r107;
        if (r110 == null) goto L29;
        Object r108 = r110.get("block_view_extra_recycle_view");
    L31:
        if ((r108 instanceof RecyclerView) == false) goto L33;
        RecyclerView r109 = (RecyclerView) r108;
    L34:
        this.f302306k = r109;
        if (r110 == null) goto L37;
        Object r111 = r110.get("block_view_extra_fold_states");
    L39:
        if (TypeIntrinsics.isMutableMap(r111) == false) goto L41;
        Map<String, Boolean> r112 = (Map) r111;
    L42:
        this.f302308m = r112;
        if (r110 == null) goto L45;
        Object r113 = r110.get("block_view_extra_previous_page");
    L47:
        if ((r113 instanceof String) == false) goto L49;
        String r114 = (String) r113;
    L50:
        this.f302304i = r114;
        if (r110 == null) goto L53;
        Object r115 = r110.get("block_view_extra_current_page");
    L55:
        if ((r115 instanceof String) == false) goto L57;
        String r116 = (String) r115;
    L58:
        this.f302305j = r116;
        LarusBlockItemReferenceListBinding r117 = this.f302298c;
        if (r117 == null) goto L92;
        AbsBlockView.a.e(r117.f358491b, r100);
        we8.a.b(r117.f358492c, i5.o(), false, null, null, 12);
        TextView r118 = r117.f358492c;
        if (r100 == null) goto L67;
        BlockContent r119 = r100.getContent();
        if (r119 == null) goto L67;
        SearchResultBlock r120 = r119.getSearchResultBlock();
        if (r120 == null) goto L67;
        String r121 = r120.summary;
    L68:
        r118.setText(r121);
        ((ArrayList) this.f302300e).clear();
        if (r100 == null) goto L85;
        BlockContent r122 = r100.getContent();
        if (r122 == null) goto L85;
        SearchResultBlock r123 = r122.getSearchResultBlock();
        if (r123 == null) goto L85;
        List<Reference> r124 = r123.results;
        if (r124 == null) goto L85;
        Iterator<T> r125 = r124.iterator();
    L78:
        if (r125.hasNext() == false) goto L85;
        Reference r126 = (Reference) r125.next();
        TextCard r127 = r126.getTextCard();
        if (r127 == null) goto L82;
        ((ArrayList) this.f302300e).add(r127);
    L82:
        VideoCard r128 = r126.getVideoCard();
        if (r128 == null) goto L78;
        ((ArrayList) this.f302300e).add(r128);
    L85:
        MessageReferenceAdapter r129 = this.f302299d;
        if (r129 == null) goto L92;
        List<Object> r130 = this.f302300e;
        Map<String, Boolean> r131 = this.f302308m;
        if (r131 == null) goto L90;
        r101 = r131.get(getDataListIdentifier());
    L90:
        Intrinsics.checkNotNullParameter(r130, "list");
        r129.f297051b.clear();
        r129.f297051b.addAll(r130);
        r129.y2(r101);
        r129.notifyDataSetChanged();
    L67:
        r121 = null;
    L92:
        if (this.f302307l == false) goto L105;
        LarusBlockItemReferenceListBinding r132 = this.f302298c;
        if (r132 == null) goto L98;
        AtMostHeightRecyclerView r133 = r132.f358493d;
        if (r133 == null) goto L98;
        y6.d(r133, new j1(this), new k1(this), this.f302306k, new l1(this), 1);
    L98:
        ExposureTrackerExtKt.a(this, new m1(this, r100));
        this.f302307l = false;
        return;
    L105:
        return;
    L57:
        r116 = null;
        goto L58
    L53:
        r115 = null;
        goto L55
    L49:
        r114 = null;
        goto L50
    L45:
        r113 = null;
        goto L47
    L41:
        r112 = null;
        goto L42
    L37:
        r111 = null;
        goto L39
    L33:
        r109 = null;
        goto L34
    L29:
        r108 = null;
        goto L31
    L25:
        r107 = null;
        goto L26
    L21:
        r106 = null;
        goto L23
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View r100 = LayoutInflater.from(r110).inflate(R.layout.larus_block_item_reference_list, this, false);
        addView(r100);
        int r101 = R.id.deep_research_item_icon;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.deep_research_item_icon);
        if (r102 == null) goto L25;
        r101 = R.id.deep_research_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.deep_research_text);
        if (r103 == null) goto L25;
        r101 = R.id.research_reference_list;
        AtMostHeightRecyclerView r104 = (AtMostHeightRecyclerView) ViewBindings.findChildViewById(r100, R.id.research_reference_list);
        if (r104 == null) goto L25;
        this.f302298c = new LarusBlockItemReferenceListBinding((LinearLayout) r100, r102, r103, r104);
        this.f302299d = new MessageReferenceAdapter(false, new ArrayList(), new g1(this), r110, true, "default", false, false, new h1(this), 10, new i1(this));
        LarusBlockItemReferenceListBinding r105 = this.f302298c;
        if (r105 == null) goto L13;
        AtMostHeightRecyclerView r106 = r105.f358493d;
        if (r106 == null) goto L13;
        r106.setLayoutManager(new LinearLayoutManager(r110));
    L13:
        LarusBlockItemReferenceListBinding r107 = this.f302298c;
        if (r107 == null) goto L18;
        AtMostHeightRecyclerView r108 = r107.f358493d;
        if (r108 == null) goto L18;
        r108.setAdapter(this.f302299d);
    L18:
        LarusBlockItemReferenceListBinding r109 = this.f302298c;
        if (r109 == null) goto L26;
        AtMostHeightRecyclerView r112 = r109.f358493d;
        if (r112 == null) goto L27;
        r112.addItemDecoration(new ReferenceListBlockView$init$4(this));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
