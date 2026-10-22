package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.CornerType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolViewHolder;", "Lef3/b;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolListAdapter extends ListAdapter<ToolVO, ToolViewHolder> implements ef3.b {
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.a a;
    public final h b;
    public List<ToolVO> c;
    public RecyclerView d;
    public final int e;
    public final boolean f;
    public final ToolListAdapter$scroller$1 g;
    public final Function0<Boolean> h;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ ToolListAdapter b;

        public b(RecyclerView r1, ToolListAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ToolListAdapter r0 = this.b;
            if (r0.f == false) goto L18;
            com.bytedance.android.shopping.mall.homepage.card.headercard.a r1 = r0.i;
            if (r1.e == false) goto L7;
            return;
        L7:
            if (r1.f == false) goto L24;
            Map<String, Object> r2 = r1.h.A1.getGlobalProps();
            int r3 = 0;
        L11:
            if (r3 >= 5) goto L25;
            ToolVO r4 = r0.A2(r3);
            ECMallFeed r5 = r0.i.h;
            if (r4 == null) goto L16;
            String r6 = r4.getComponentId();
            if (r6 == null) goto L16;
        L17:
            r5.V(r6);
            Single.fromCallable(new e(r0, r3, r4, r2)).subscribeOn(Schedulers.single()).subscribe();
            r3 = r3 + 1;
        L16:
            r6 = "";
            goto L17
        L25:
            return;
        L24:
            return;
        L18:
            ToolListAdapter.y2(r0, this.a);
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

    static {
    }

    @Override // ef3.b
    public final void onRelease() {
    }

    @Override // ef3.b
    public final void p() {
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter$scroller$1] */
    public ToolListAdapter(com.bytedance.android.shopping.mall.homepage.card.headercard.a r6) {
        Intrinsics.checkNotNullParameter(r6, "mallContext");
        super(new ToolDiffCallback());
        this.i = r6;
        this.a = new com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.a(r6);
        this.b = new h(r6);
        Intrinsics.checkNotNullParameter(72, "dp");
        int r1 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.e = com.bytedance.android.ec.hybrid.list.util.c.c(72, r6.getContext(), true);
        int r0 = s93.c.a;
        Object r2 = 1;
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L10;
        yj.g r4 = r3.getHostAB();
        if (r4 == null) goto L10;
        Object r5 = r4.a("ec_mall_tool_list_report_by_item_size", r2);
        if (r5 == null) goto L10;
        r2 = r5;
    L10:
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_tool_list_report_by_item_size, Value: " + r2);
        if (((Number) r2).intValue() != 1) goto L13;
        boolean r8 = true;
    L14:
        this.f = r8;
        this.g = new ToolListAdapter$scroller$1(this);
        kjc.c r9 = new kjc.c();
        if (5 != kjc.a.a()) goto L18;
        r9.a.a = new ToolListAdapter$$special$$inlined$call$lambda$1(this);
        r9.b = true;
    L18:
        if (r9.b == true) goto L20;
        r9.a.a = null;
    L20:
        this.h = (Function0) r9.a.a;
        r6.a(this);
        return;
    L13:
        r8 = false;
        goto L14
    }

    public final ToolVO A2(int r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (r3 < getItemCount()) goto L6;
        return null;
    L6:
        return (ToolVO) super.getItem(r3);
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    @Override // ef3.b
    public final void N2(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r2, "cardView");
    }

    public final /* bridge */ /* synthetic */ Object getItem(int r1) {
        return A2(r1);
    }

    public static final void y2(ToolListAdapter r8, RecyclerView r9) {
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r0 = r8.i;
        if (r0.e == false) goto L5;
        return;
    L5:
        if (r0.f == false) goto L43;
        Map<String, Object> r1 = r0.h.A1.getGlobalProps();
        RecyclerView.LayoutManager r2 = r9.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == true) goto L10;
        r2 = null;
    L10:
        LinearLayoutManager r3 = (LinearLayoutManager) r2;
        if (r3 == null) goto L40;
        int r4 = r3.findFirstVisibleItemPosition();
        int r5 = r3.findLastVisibleItemPosition();
        if (r4 < 0) goto L41;
        if (r5 < 0) goto L42;
        int r6 = r5 + 1;
    L16:
        if (r4 >= r6) goto L44;
        RecyclerView.ViewHolder r7 = r9.findViewHolderForAdapterPosition(r4);
        RecyclerView r10 = r8.d;
        if (r10 == null) goto L27;
        int r11 = r10.getWidth();
        if (r7 == null) goto L27;
        int r12 = r7.itemView.getLeft();
        int r13 = r7.itemView.getRight();
        if ((r13 - r12) <= 0) goto L27;
        if (r13 <= 0) goto L27;
        if (r12 >= r11) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == false) goto L35;
        ToolVO r15 = r8.A2(r4);
        ECMallFeed r16 = r8.i.h;
        if (r15 == null) goto L33;
        String r17 = r15.getComponentId();
        if (r17 == null) goto L33;
    L34:
        r16.V(r17);
        Single.fromCallable(new g(r4, r15, r8, r1)).subscribeOn(Schedulers.single()).subscribe();
    L33:
        r17 = "";
    L35:
        r4 = r4 + 1;
    L27:
        r14 = false;
        goto L28
    L44:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    }

    public final void B2(String r7, Function1<? super Boolean, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "componentID");
        Intrinsics.checkNotNullParameter(r8, "callback");
        RecyclerView r0 = this.d;     // Catch: Exception -> L33
        Integer r1 = null;
        if (r0 == null) goto L6;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();     // Catch: Exception -> L33
    L8:
        if ((r2 instanceof LinearLayoutManager) == true) goto L11;
        r8.invoke(Boolean.FALSE);     // Catch: Exception -> L33
        return;
    L11:
        List<ToolVO> r3 = this.c;     // Catch: Exception -> L33
        if (r3 == null) goto L26;
        Iterator<ToolVO> r4 = r3.iterator();     // Catch: Exception -> L33
        int r5 = 0;
    L15:
        if (r4.hasNext() == false) goto L24;
        ToolVO r6 = r4.next();     // Catch: Exception -> L33
        if (r6 == null) goto L19;
        String r9 = r6.getComponentId();     // Catch: Exception -> L33
    L21:
        if (Intrinsics.areEqual(r9, r7) == true) goto L25;
        r5 = r5 + 1;     // Catch: Exception -> L33
    L25:
        r1 = Integer.valueOf(r5);     // Catch: Exception -> L33
        goto L26
    L19:
        r9 = null;
        goto L21
    L24:
        r5 = -1;
    L26:
        if (r1 != null) goto L28;
    L31:
        r8.invoke(Boolean.FALSE);     // Catch: Exception -> L33
        return;
    L28:
        if (r1.intValue() < 0) goto L31;
        ((LinearLayoutManager) r2).scrollToPositionWithOffset(r1.intValue(), 0);     // Catch: Exception -> L33
        r8.invoke(Boolean.TRUE);     // Catch: Exception -> L33
        return;
    L6:
        r2 = null;
    L33:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r8.invoke(Boolean.FALSE);
    }

    public final void C2(final List<ToolVO> r2, final ToolVO r3) {
        ECHybridExtensionsKt.f(new ToolListAdapter$setToolItemList$1(this, r2, r3));
    }

    /* JADX WARN: Type inference failed for: r9v6, types: [android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        ToolViewHolder r11 = (ToolViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        ToolVO r12 = A2(r10);
        if (r12 == null) goto L88;
        ((RecyclerView.ViewHolder) r11).itemView.setVisibility(0);
        r11.e = r12;
        r11.f.setTag(r12.getName());
        r11.f.getAnchorView().setTag("tool-list-anchor-" + r11.getAdapterPosition());
        r11.f.getAnchorViewRight().setTag("tool-list-anchor-" + r11.getAdapterPosition() + "-right");
        r11.f.getAnchorViewLeft().setTag("tool-list-anchor-" + r11.getAdapterPosition() + "-left");
        r11.f.getAnchorViewBottomLeft().setTag("tool-list-anchor-bottom-left-" + r11.getAdapterPosition());
        String r0 = r12.getDarkIcon();
        if (r0 == null) goto L9;
        d0.c(r11.b, r0, r11.g.k);
    L9:
        String r1 = r12.getTitle();
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
        r11.c.setText(r12.getTitle());
    L18:
        ToolVO.Corner r3 = r12.getCorner();
        kjc.c r4 = new kjc.c();
        String r6 = null;
        if (5 != kjc.a.a()) goto L26;
        kjc.b r5 = r4.a;
        Map<String, String> r13 = r12.getCornerExtra();
        if (r13 == null) goto L23;
        String r14 = b0.h(r13, "open_corner_animation", "0");
    L24:
        r5.a = Boolean.valueOf(Intrinsics.areEqual(r14, "1"));
        r4.b = true;
        goto L26
    L23:
        r14 = null;
    L26:
        if (r4.b == true) goto L28;
        r4.a.a = Boolean.FALSE;
    L28:
        r11.d.c = ((Boolean) r4.a.a).booleanValue();
        if (r3 == null) goto L31;
        String r15 = r3.getType();
    L33:
        if (Intrinsics.areEqual(r15, CornerType.TEXT.getValue()) == true) goto L35;
    L75:
        if (r3 == null) goto L78;
        r6 = r3.getType();
    L78:
        if (Intrinsics.areEqual(r6, CornerType.DOT.getValue()) == true) goto L80;
    L82:
        r11.d.y();
        return;
    L80:
        if (r3.getCanShow() == false) goto L82;
        r11.d.setMode(1);
        int r16 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r17 = com.bytedance.android.ec.hybrid.list.util.c.c(30, r11.a, true);
        int r7 = com.bytedance.android.ec.hybrid.list.util.c.c(1, r11.a, true);
        r11.d.setTranslationX(r17);
        r11.d.setTranslationY(r7);
        r11.d.setBadgeColor(ContextCompat.getColor(r11.a, 2131106126));
        r11.d.B();
        return;
    L35:
        if (r3.getCanShow() == false) goto L75;
        String r18 = r3.getText();
        if (r18 == null) goto L39;
        Integer r19 = StringsKt.toIntOrNull(r18);
    L41:
        if (r19 != null) goto L43;
    L49:
        String r110 = r3.getText();
        if (r110 != null) goto L52;
    L55:
        boolean r111 = true;
    L56:
        if (r111 == true) goto L74;
        r11.d.setMode(3);
        String r112 = r3.getText();
        if (r112 == null) goto L60;
        int r113 = r112.length();
    L61:
        if (r113 < 3) goto L63;
        int r114 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r115 = com.bytedance.android.ec.hybrid.list.util.c.c(17, r11.a, true);
    L64:
        String r8 = r3.getText();
        if (r8 == null) goto L67;
        int r20 = r8.length();
    L69:
        if (r20 <= 6) goto L73;
        if (r8 == null) goto L72;
        r6 = r8.substring(0, 6);
    L72:
        r8 = r6;
    L73:
        r11.d.setText(r8);
        r11.d.setTranslationX(r115);
        r11.d.setTranslationY(0.0f);
        r11.T3();
        r11.d.B();
        return;
    L67:
        r20 = 0;
        goto L69
    L63:
        int r116 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r115 = com.bytedance.android.ec.hybrid.list.util.c.c(27, r11.a, true);
        goto L64
    L60:
        r113 = 0;
        goto L61
    L74:
        r11.d.y();
        return;
    L52:
        if (r110.length() == 0) goto L55;
        r111 = false;
        goto L56
    L43:
        if (r19.intValue() <= 0) goto L49;
        if (r19.intValue() <= 99) goto L47;
        int r21 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r22 = com.bytedance.android.ec.hybrid.list.util.c.c(17, r11.a, true);
    L48:
        r11.d.setTranslationX(r22);
        r11.d.setTranslationY(0.0f);
        r11.T3();
        ?? r23 = r11.d;
        int r117 = r19.intValue();
        r23.setMode(2);
        r23.setCount(r117);
        r23.setVisibility(0);
        return;
    L47:
        int r24 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r22 = com.bytedance.android.ec.hybrid.list.util.c.c(27, r11.a, true);
        goto L48
    L39:
        r19 = null;
        goto L41
    L31:
        r15 = null;
        goto L33
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        int r9 = ToolViewHolder.j;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r10 = this.i;
        h r0 = this.b;
        Function0<Boolean> r1 = this.h;
        Intrinsics.checkNotNullParameter(r7, "container");
        Intrinsics.checkNotNullParameter(r10, "mallContext");
        Intrinsics.checkNotNullParameter(r0, "toolReporter");
        return new ToolViewHolder(new ToolItemView(r7.getContext(), null, 6, 0), r10, r0, r1);
    }

    public static final void z2(final ToolListAdapter r6, final List r7, final ToolVO r8) {
        r6.getClass();
        List r0 = r7;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L24;
        List<ToolVO> r9 = r6.c;
        if (r9 != null) goto L14;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == true) goto L33;
        r7 = r6.c;
        goto L24
    L33:
        r7 = (List) p.b().fromJson("[{\"name\":\"tool_order\",\"title\":\"我的订单\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/7b5e67848ba94584948a8af77c86ea82~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?type=fullscreen&hide_nav_bar=1&enable_pad_adapter=1&screen_size_adaptation=1&trans_status_bar=1&web_bg_color=ffffff&status_bar_color=black&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Ffalcon%2Fdouyin%2Fecommerce_orders_douyin%2Fapp_new%2Ftemplate.js%3Fenter_from%3Dmall_homepage_request%26tab_id%3D0&enter_from=mall_homepage_request&show_small_window=&api_migration_gray=1\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/6b0355f9df4b4d76b5344762976adf7f~tplv-5bio2hw93e-origin.png\",\"create_time\":1684218631,\"card_type\":0,\"resource_id\":\"79984\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"2\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_charge\",\"title\":\"手机充值\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/9ed2e11909434a2cb46a4ab687930a35~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_fxg_life_lynx%2Fpages%2Fphone%2Ftemplate.js&hide_nav_bar=1&trans_status_bar=1&status_bar_color=white&source=recharge_xtab_homepage&web_bg_color=ffffff\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/161fadf571174022aff7f86f604810df~tplv-5bio2hw93e-origin.png\",\"create_time\":1698292286,\"card_type\":0,\"resource_id\":\"96065\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"17\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1822838399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_customer_msg\",\"title\":\"客服消息\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/6f7be98067c348f99613f249d3790b3f~tplv-5bio2hw93e-origin.png\",\"link\":\"aweme://ecomcs_im/message_list?origin_enter_from=mall\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/f7044bb307b44ea2b61cfbde16b5bce7~tplv-5bio2hw93e-origin.png\",\"create_time\":1690461716,\"card_type\":0,\"resource_id\":\"87378\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"5\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_following_shop\",\"title\":\"关注店铺\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/4de1ad1e4c844845bb652325bb6e6deb~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_shop_subpage_dynamic%2Fapp%2Ffollowed_shop%2Ftemplate.js&status_bar_color=black&hide_nav_bar=1&add_safe_area_height=0&trans_status_bar=1&web_bg_color=%23ffffffff&top_level=1&window_floating=0&use_real_screen_height=1&enable_latch=1&entrance_location=101&enable_pad_adapter=1&screen_size_adaptation=1&initialProps=%5B%22storage%3AFOLLOW_SHOP_FULL_MODE%22%2C%22current_user%22%5D\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/473cdbc0519b4260bfcc23205a8a9237~tplv-5bio2hw93e-origin.png\",\"create_time\":1695801835,\"card_type\":0,\"resource_id\":\"93464\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"28\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1793375999,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_try\",\"title\":\"试用领取\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/3909ae3e8d154db18f37cd518dcb3ba0~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?enable_latch=1&hide_nav_bar=1&hide_status_bar=0&inject_config_channel=ecommerce_brand_new_product_trial_aweme&retention=0&status_bar_color=black&top_level=1&trans_status_bar=1&type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_brand_new_product_trial_aweme%2Fhome%2Ftemplate.js&web_bg_color=%23ffffffff&title_type=1&channel_scene=brand_try_introduce_home_tool\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/581947ff209d426ca0c6a4064234f83d~tplv-5bio2hw93e-origin.png\",\"create_time\":1697684469,\"card_type\":0,\"resource_id\":\"94941\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"29\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1917705599,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_fav\",\"title\":\"收藏\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/e9db5ba83a734940ba9976227f92324e~tplv-5bio2hw93e-origin.png\",\"link\":\"aweme://favorite?tab_name=goods&type=6\",\"tip\":{\"type\":0,\"data\":\"33\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/4a0096f64c4d4e9ea95d3b42e7dd8701~tplv-5bio2hw93e-origin.png\",\"create_time\":1684218596,\"card_type\":0,\"resource_id\":\"79982\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"9\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1793289599,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_comment\",\"title\":\"评价中心\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/e966578a920046bdaf5081543f589916~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_evaluation_aweme%2Flist%2Ftemplate.js%3Fenter_from%3Dcenter%26tab_id%3D&hide_nav_bar=1&hide_status_bar=0&status_bar_bg_color=white&load_taro=0&status_bar_color=black&trans_status_bar=1&enable_pad_adapter=1&container_bg_color=ffffff&screen_size_adaptation=1\",\"tip\":{\"type\":0,\"data\":\"1\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/ee801bb102a740fbae7e9c10ad34f19d~tplv-5bio2hw93e-origin.png\",\"create_time\":1694506683,\"card_type\":0,\"resource_id\":\"91383\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"3\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1793375999,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_coupon_notip\",\"title\":\"券红包\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/374cb285898643ad85a5fc6c5d709c9f~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_fe_promotion_coupon_centre_aweme%2Fhtml%2Fpages%2Fhome%2Findex.html%3Ftab%3Dcoupon%26enter_from%3Dorder_center&hide_nav_bar=1&hide_status_bar=0&trans_status_bar=1&use_wk_falcon=1&status_bar_color=black&web_bg_color=ffffff\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/6f5ebc1f71784ecdb9caf25e2dc41a8a~tplv-5bio2hw93e-origin.png\",\"create_time\":1684218499,\"card_type\":0,\"resource_id\":\"79981\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"6\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_cpay\",\"title\":\"抖音月付\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/43643daa62a240709ae9f6ffb364abc2~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://cjpay?canvas_mode=1&url=https%3A%2F%2Ff-cpay.snssdk.com%2Ffeoffline%2Fcpay%2Frouter.html%3Fcanvas_mode%3D1%26cpsource%3Ddyds_order_center_new\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/4caf7e97b3c044779889d1e9fa8ed56e~tplv-5bio2hw93e-origin.png\",\"create_time\":1684217986,\"card_type\":0,\"resource_id\":\"79972\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"10\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}}]", b0.getType(List.class, new Type[]{ToolVO.class}));     // Catch: Exception -> L22
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r7 = null;
        goto L24
    L14:
        if (r9.isEmpty() == true) goto L17;
        r10 = false;
    L24:
        List r3 = r7;
        if (r3 != null) goto L27;
    L28:
        r1 = true;
    L29:
        if (r1 == true) goto L35;
        r6.c = r7;
        kk.d.c(new ToolListAdapter$setToolItemListInner$1(r6, r7, r8));
        r6.submitList(r7);
        return;
    L35:
        return;
    L27:
        if (r3.isEmpty() == false) goto L29;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // ef3.b
    public final void Q0(boolean r1, Boolean r2, boolean r3) {
        if (r1 == true) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L11;
        if (r3 == false) goto L12;
        RecyclerView r4 = this.d;
        if (r4 == null) goto L13;
        r4.post(new b(r4, this));
        return;
    L13:
        return;
    L12:
        return;
    }
}
