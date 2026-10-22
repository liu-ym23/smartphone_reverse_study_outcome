package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.log.g;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/e;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentVH extends AbsFullSpanVH<e> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public e m;
    public final Lazy n;
    public final ViewGroup o;
    public final VisibleLogManager p;
    public final Context q;
    public final AnchorV4VM r;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV4CommentView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4CommentView r1 = (AnchorV4CommentView) r0;
        if (r1 == null) goto L9;
        r1.f.getClass();
        return;
    }

    public final void onPause() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV4CommentView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4CommentView r1 = (AnchorV4CommentView) r0;
        if (r1 == null) goto L9;
        r1.f.getClass();
        return;
    }

    public final void onResume() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV4CommentView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV4CommentView r1 = (AnchorV4CommentView) r0;
        if (r1 == null) goto L14;
        Rect r2 = new Rect();
        if (r1.f.getLocalVisibleRect(r2) == true) goto L10;
        r1.f.getClass();
        return;
    L10:
        if (NetworkUtils.isNetworkAvailable(r1.getContext()) == false) goto L15;
        r1.f.getClass();
        return;
    L15:
        return;
    }

    public final void onScan() {
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if (r1 == null) goto L573;
        AnchorV4CommentView r2 = (AnchorV4CommentView) r1;
        AnchorV4CommentDisplay r8 = ((e) getItem()).b;
        AnchorV4CommentMeta r9 = ((e) getItem()).c;
        if (r8 == null) goto L618;
        AnchorV4CommentMeta r3 = r2.B;
        char r14 = 0;
        Integer r7 = null;
        if (r3 == null) goto L101;
        AnchorV4CommentBusinessMeta r4 = r3.getBusinessMeta();
        if (r4 == null) goto L101;
        if (r4.getHasProductComment() != true) goto L101;
        AnchorV4CommentMeta r5 = r2.B;
        if (r5 == null) goto L18;
        d r6 = r5.getTrackMeta();
        if (r6 == null) goto L18;
        long r10 = r6.a();
    L20:
        if (r10 < 4) goto L22;
        boolean r16 = true;
    L23:
        AnchorV4CommentMeta r11 = r2.B;
        if (r11 == null) goto L28;
        d r12 = r11.getTrackMeta();
        if (r12 == null) goto L28;
        Long r17 = r12.t();
    L29:
        List<MultiCommentComponent> r13 = r8.getMultiComments();
        if (r13 == null) goto L69;
        Iterator<T> r18 = r13.iterator();
    L33:
        if (r18.hasNext() == false) goto L101;
        MultiCommentComponent r15 = (MultiCommentComponent) r18.next();
        if (r15 == null) goto L50;
        MediaScrollBoxComponent r19 = r15.getCommentMedias();
        if (r19 == null) goto L50;
        List r20 = r19.getMedias();
        if (r20 == null) goto L50;
        ArrayList r21 = new ArrayList();
        Iterator r22 = r20.iterator();
    L42:
        if (r22.hasNext() == false) goto L49;
        Object r23 = r22.next();
        if (((MediaBoxElement) r23).getType() != 0) goto L46;
        boolean r24 = true;
    L47:
        if (r24 == false) goto L42;
        r21.add(r23);
        goto L42
    L46:
        r24 = false;
        goto L47
    L49:
        Integer r25 = Integer.valueOf(r21.size());
    L51:
        int r26 = k.f(r25);
        if (r15 == null) goto L67;
        MediaScrollBoxComponent r27 = r15.getCommentMedias();
        if (r27 == null) goto L67;
        List r28 = r27.getMedias();
        if (r28 == null) goto L67;
        ArrayList r29 = new ArrayList();
        Iterator r30 = r28.iterator();
    L59:
        if (r30.hasNext() == false) goto L66;
        Object r31 = r30.next();
        if (((MediaBoxElement) r31).getType() != 1) goto L63;
        boolean r32 = true;
    L64:
        if (r32 == false) goto L59;
        r29.add(r31);
        goto L59
    L63:
        r32 = false;
        goto L64
    L66:
        Integer r33 = Integer.valueOf(r29.size());
    L68:
        r2.b(r26, k.f(r33), r16, r17, r2.g);
        r7 = r7;
    L67:
        r33 = r7;
    L50:
        r25 = r7;
        goto L51
    L69:
        MediaScrollBoxComponent r34 = r8.getCommentMedias();
        if (r34 == null) goto L83;
        List r35 = r34.getMedias();
        if (r35 == null) goto L83;
        ArrayList r36 = new ArrayList();
        Iterator r37 = r35.iterator();
    L75:
        if (r37.hasNext() == false) goto L82;
        Object r38 = r37.next();
        if (((MediaBoxElement) r38).getType() != 0) goto L79;
        boolean r39 = true;
    L80:
        if (r39 == false) goto L75;
        r36.add(r38);
        goto L75
    L79:
        r39 = false;
        goto L80
    L82:
        Integer r40 = Integer.valueOf(r36.size());
    L84:
        int r41 = k.f(r40);
        MediaScrollBoxComponent r42 = r8.getCommentMedias();
        if (r42 == null) goto L98;
        List r43 = r42.getMedias();
        if (r43 == null) goto L98;
        ArrayList r44 = new ArrayList();
        Iterator r45 = r43.iterator();
    L90:
        if (r45.hasNext() == false) goto L97;
        Object r46 = r45.next();
        if (((MediaBoxElement) r46).getType() != 1) goto L94;
        boolean r47 = true;
    L95:
        if (r47 == false) goto L90;
        r44.add(r46);
        goto L90
    L94:
        r47 = false;
        goto L95
    L97:
        Integer r48 = Integer.valueOf(r44.size());
    L99:
        r2.b(r41, k.f(r48), r16, r17, r2.d);
    L98:
        r48 = null;
    L83:
        r40 = null;
    L28:
        r17 = null;
        goto L29
    L22:
        r16 = false;
    L18:
        r10 = 0;
    L101:
        int r49 = 4;
        if (r8.getBuyersShowTitle() == null) goto L131;
        MediaScrollBoxComponent r50 = r8.getBuyersShowMedias();
        if (r50 == null) goto L131;
        List r51 = r50.getMedias();
        if (r51 == null) goto L131;
        Iterator r52 = r51.iterator();
        int r110 = 0;
    L109:
        if (r52.hasNext() == false) goto L131;
        Object r111 = r52.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L113;
        CollectionsKt.throwIndexOverflow();
    L113:
        MediaBoxElement r113 = (MediaBoxElement) r111;
        int r114 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r115 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r115 == null) goto L129;
        if (g.a(r2.j) == true) goto L119;
        r115 = null;
    L119:
        if (r115 == null) goto L129;
        Pair[] r53 = new Pair[r49];
        r53[r14] = TuplesKt.to("comment_module", "selected_comment");
        r53[1] = TuplesKt.to("comment_entrance", "comment_region");
        r53[2] = TuplesKt.to("comment_rank", Integer.valueOf(r112));
        AnchorV4CommentMeta r54 = r2.B;
        if (r54 == null) goto L127;
        d r55 = r54.getTrackMeta();
        if (r55 == null) goto L127;
        List<String> r56 = r55.b();
        if (r56 == null) goto L127;
        String r57 = (String) CollectionsKt.getOrNull(r56, r110);
    L128:
        r53[3] = TuplesKt.to("comment_id", k.j(r57));
        r115.c = MapsKt.mapOf(r53);
        AnchorV4TrackerImpl.b(r115, "single_comment_show", false, "buyers_show_" + r110, false, null, 24);
    L127:
        r57 = null;
    L129:
        r110 = r112;
        r49 = 4;
        r14 = 0;
    L131:
        if (r2.C == true) goto L169;
        if (g.a(r2) == false) goto L169;
        AnchorV4VM r58 = r2.A;
        if (r58 == null) goto L169;
        CommonMeta r59 = r58.commonMeta();
        if (r59 == null) goto L169;
        String r60 = h73.a.b(r59);
        if (r60 == null) goto L169;
        s83.g r61 = AdLogUtils.a;
        AnchorV4VM r62 = r2.A;
        if (r62 == null) goto L145;
        CommonMeta r63 = r62.commonMeta();
        if (r63 == null) goto L145;
        Map<String, ? extends Object> r310 = h73.a.a(r63);
    L146:
        AnchorV4VM r64 = r2.A;
        if (r64 == null) goto L151;
        CommonMeta r65 = r64.commonMeta();
        if (r65 == null) goto L151;
        String r66 = h73.a.c(r65);
    L152:
        Intrinsics.checkNotNullParameter(r60, "cid");
        if (r60.length() != 0) goto L155;
        boolean r67 = true;
    L156:
        if (r67 == true) goto L167;
        ECAppInfoService r68 = ECAppInfoService.e;
        if (we.a.a == false) goto L161;
    L166:
        AdLogUtils.a().d("show_comment_card", null, Long.valueOf(CastLongProtector.parseLong(r60)), r66);
        goto L167
    L161:
        if (r68.n() == true) goto L166;
        s83.g r311 = AdLogUtils.a;
        if (r311 == null) goto L167;
        r311.d("product_detail_ad", "show_comment_card", "recommend", r60, r66, r310, null, "umeng");
    L167:
        r2.C = true;
        goto L169
    L155:
        r67 = false;
    L151:
        r66 = null;
    L145:
        r310 = null;
    L169:
        AnchorV4CommentMeta r69 = r2.B;
        if (r69 == null) goto L222;
        AnchorV4CommentBusinessMeta r70 = r69.getBusinessMeta();
        if (r70 == null) goto L222;
        if (r70.getHasProductComment() != true) goto L222;
        AnchorV4CommentMeta r71 = r2.B;
        if (r71 == null) goto L180;
        d r72 = r71.getTrackMeta();
        if (r72 == null) goto L180;
        long r116 = r72.a();
        long r117 = 4;
    L182:
        if (r116 < r117) goto L184;
        boolean r73 = true;
    L185:
        int r118 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r74 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r74 == null) goto L222;
        if (g.a(r2) == true) goto L191;
        r74 = null;
    L191:
        if (r74 == null) goto L222;
        Pair[] r75 = new Pair[6];
        r75[0] = TuplesKt.to("comment_entrance", "comment_detail");
        AnchorV4CommentMeta r76 = r2.B;
        if (r76 == null) goto L197;
        d r77 = r76.getTrackMeta();
        if (r77 == null) goto L197;
        String r78 = r77.k();
    L198:
        r75[1] = TuplesKt.to("comment_module", r78);
        AnchorV4CommentMeta r79 = r2.B;
        if (r79 == null) goto L203;
        d r80 = r79.getTrackMeta();
        if (r80 == null) goto L203;
        Integer r81 = r80.v();
    L204:
        r75[2] = TuplesKt.to("with_same_comment", r81);
        AnchorV4CommentMeta r82 = r2.B;
        if (r82 == null) goto L209;
        d r84 = r82.getTrackMeta();
        if (r84 == null) goto L209;
        Long r85 = Long.valueOf(r84.i());
    L210:
        r75[3] = TuplesKt.to("key_word_num", Long.valueOf(k.h(r85)));
        AnchorV4CommentMeta r86 = r2.B;
        if (r86 == null) goto L215;
        d r87 = r86.getTrackMeta();
        if (r87 == null) goto L215;
        Long r88 = Long.valueOf(r87.c());
    L216:
        r75[4] = TuplesKt.to("comment_num", Long.valueOf(k.h(r88)));
        if (r73 == false) goto L219;
        String r89 = "1";
    L220:
        r75[5] = TuplesKt.to("show_selected_comment", r89);
        r74.c = MapsKt.mapOf(r75);
        AnchorV4TrackerImpl.b(r74, "show_comment_card", false, "product_comment", false, null, 24);
        goto L222
    L219:
        r89 = "0";
    L215:
        r88 = null;
    L209:
        r85 = null;
    L203:
        r81 = null;
    L197:
        r78 = null;
        goto L198
    L184:
        r73 = false;
    L180:
        r117 = 4;
        r116 = 0;
    L222:
        if (r8.getOtherGoodsReviewTitle() == null) goto L244;
        int r90 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r91 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r91 == null) goto L244;
        if (g.a(r2.o) == true) goto L229;
        r91 = null;
    L229:
        if (r91 == null) goto L244;
        Pair[] r92 = new Pair[4];
        r92[0] = TuplesKt.to("comment_entrance", "comment_region");
        r92[1] = TuplesKt.to("comment_module", "shop_comment");
        AnchorV4CommentMeta r94 = r2.B;
        if (r94 == null) goto L235;
        d r95 = r94.getTrackMeta();
        if (r95 == null) goto L235;
        Long r96 = Long.valueOf(r95.s());
    L236:
        r92[2] = TuplesKt.to("word_num", Long.valueOf(k.h(r96)));
        AnchorV4CommentMeta r97 = r2.B;
        if (r97 == null) goto L241;
        d r98 = r97.getTrackMeta();
        if (r98 == null) goto L241;
        Long r99 = Long.valueOf(r98.n());
    L242:
        r92[3] = TuplesKt.to("comment_num", Long.valueOf(k.h(r99)));
        r91.c = MapsKt.mapOf(r92);
        AnchorV4TrackerImpl.b(r91, "show_comment_card", false, "other_goods_comments", false, null, 24);
    L241:
        r99 = null;
    L235:
        r96 = null;
    L244:
        if (r8.getBuyersShowTitle() == null) goto L259;
        int r100 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r101 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r101 == null) goto L259;
        if (g.a(r2.i) == true) goto L251;
        r101 = null;
    L251:
        if (r101 == null) goto L259;
        Pair[] r102 = new Pair[4];
        r102[0] = TuplesKt.to("comment_entrance", "comment_region");
        r102[1] = TuplesKt.to("comment_module", "selected_comment");
        r102[2] = TuplesKt.to("key_word_num", 0);
        AnchorV4CommentMeta r103 = r2.B;
        if (r103 == null) goto L257;
        d r104 = r103.getTrackMeta();
        if (r104 == null) goto L257;
        Long r105 = Long.valueOf(r104.a());
    L258:
        r102[3] = TuplesKt.to("comment_num", Long.valueOf(k.h(r105)));
        r101.c = MapsKt.mapOf(r102);
        AnchorV4TrackerImpl.b(r101, "show_comment_card", false, "selected_comments", false, null, 24);
    L257:
        r105 = null;
    L259:
        TagsScrollBoxComponent r106 = r8.getCommentTags();
        if (r106 == null) goto L325;
        List r107 = r106.getButtonList();
        if (r107 == null) goto L325;
        if ((!r107.isEmpty()) != true) goto L325;
        AnchorV4CommentMeta r108 = r2.B;
        if (r108 == null) goto L270;
        d r109 = r108.getTrackMeta();
        if (r109 == null) goto L270;
        Long r119 = r109.t();
    L271:
        List r120 = r8.getCommentTags().getButtonList();
        if (r120 == null) goto L325;
        Iterator r121 = r120.iterator();
        int r122 = 0;
    L275:
        if (r121.hasNext() == false) goto L325;
        Object r210 = r121.next();
        int r211 = r122 + 1;
        if (r122 >= 0) goto L279;
        CollectionsKt.throwIndexOverflow();
    L279:
        TextWithOneIconElement r212 = (TextWithOneIconElement) r210;
        int r213 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r123 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r123 == null) goto L324;
        if (g.a(r2.c) == true) goto L285;
        r123 = null;
    L285:
        if (r123 == null) goto L324;
        Pair[] r0 = new Pair[8];
        r0[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        AnchorV4CommentMeta r124 = r2.B;
        if (r124 == null) goto L293;
        d r125 = r124.getTrackMeta();
        if (r125 == null) goto L293;
        List<String> r126 = r125.e();
        if (r126 == null) goto L293;
        String r127 = (String) ListProtector.get(r126, r122);
    L294:
        r0[1] = TuplesKt.to("word_name", k.j(r127));
        r0[2] = TuplesKt.to("word_order", String.valueOf(r122));
        AnchorV4CommentMeta r128 = r2.B;
        if (r128 == null) goto L301;
        d r129 = r128.getTrackMeta();
        if (r129 == null) goto L301;
        List<String> r130 = r129.f();
        if (r130 == null) goto L301;
        String r131 = (String) ListProtector.get(r130, r122);
    L302:
        r0[3] = TuplesKt.to("comment_num", k.j(r131));
        AnchorV4CommentMeta r132 = r2.B;
        if (r132 == null) goto L309;
        d r133 = r132.getTrackMeta();
        if (r133 == null) goto L309;
        List<String> r134 = r133.h();
        if (r134 == null) goto L309;
        String r135 = (String) ListProtector.get(r134, r122);
    L310:
        r0[4] = TuplesKt.to("if_positive", k.j(r135));
        r0[5] = TuplesKt.to("user_comment_level", r119);
        AnchorV4CommentMeta r136 = r2.B;
        if (r136 == null) goto L315;
        d r137 = r136.getTrackMeta();
        if (r137 == null) goto L315;
        String r138 = r137.k();
    L316:
        r0[6] = TuplesKt.to("comment_module", r138);
        AnchorV4CommentMeta r139 = r2.B;
        if (r139 == null) goto L321;
        d r140 = r139.getTrackMeta();
        if (r140 == null) goto L321;
        Integer r141 = r140.v();
    L322:
        r0[7] = TuplesKt.to("with_same_comment", r141);
        r123.c = MapsKt.mapOf(r0);
        AnchorV4TrackerImpl.b(r123, "comment_key_word_show", false, "comment_tags_" + r122, false, null, 24);
    L321:
        r141 = null;
    L315:
        r138 = null;
    L309:
        r135 = null;
    L301:
        r131 = null;
    L293:
        r127 = null;
    L324:
        r122 = r211;
        r121 = r121;
    L270:
        r119 = null;
    L325:
        TagsScrollBoxComponent r142 = r8.getOtherGoodsReviewTags();
        if (r142 == null) goto L372;
        List r143 = r142.getButtonList();
        if (r143 == null) goto L372;
        if ((!r143.isEmpty()) != true) goto L372;
        List r144 = r8.getOtherGoodsReviewTags().getButtonList();
        if (r144 == null) goto L372;
        Iterator r145 = r144.iterator();
        int r146 = 0;
    L335:
        if (r145.hasNext() == false) goto L372;
        Object r147 = r145.next();
        int r148 = r146 + 1;
        if (r146 >= 0) goto L339;
        CollectionsKt.throwIndexOverflow();
    L339:
        TextWithOneIconElement r149 = (TextWithOneIconElement) r147;
        int r150 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r151 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r151 == null) goto L371;
        if (g.a(r2.p) == true) goto L345;
        r151 = null;
    L345:
        if (r151 == null) goto L371;
        Pair[] r152 = new Pair[5];
        r152[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        AnchorV4CommentMeta r153 = r2.B;
        if (r153 == null) goto L353;
        d r154 = r153.getTrackMeta();
        if (r154 == null) goto L353;
        List<String> r155 = r154.o();
        if (r155 == null) goto L353;
        String r156 = (String) ListProtector.get(r155, r146);
    L354:
        r152[1] = TuplesKt.to("word_name", k.j(r156));
        r152[2] = TuplesKt.to("word_order", String.valueOf(r146));
        AnchorV4CommentMeta r157 = r2.B;
        if (r157 == null) goto L361;
        d r158 = r157.getTrackMeta();
        if (r158 == null) goto L361;
        List<String> r159 = r158.p();
        if (r159 == null) goto L361;
        String r160 = (String) ListProtector.get(r159, r146);
    L362:
        r152[3] = TuplesKt.to("comment_num", k.j(r160));
        AnchorV4CommentMeta r161 = r2.B;
        if (r161 == null) goto L369;
        d r162 = r161.getTrackMeta();
        if (r162 == null) goto L369;
        List<String> r163 = r162.r();
        if (r163 == null) goto L369;
        String r164 = (String) ListProtector.get(r163, r146);
    L370:
        r152[4] = TuplesKt.to("if_positive", k.j(r164));
        r151.c = MapsKt.mapOf(r152);
        AnchorV4TrackerImpl.b(r151, "comment_key_word_show", false, "other_goods_review_tags_" + r146, false, null, 24);
    L369:
        r164 = null;
    L361:
        r160 = null;
    L353:
        r156 = null;
    L371:
        r146 = r148;
    L372:
        String r165 = "";
        if (r8.getKolReviewTitle() == null) goto L397;
        int r166 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r167 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r167 == null) goto L397;
        if (g.a(r2.t) == true) goto L380;
        r167 = null;
    L380:
        if (r167 == null) goto L397;
        Pair[] r168 = new Pair[2];
        AnchorV4CommentMeta r169 = r2.B;
        if (r169 == null) goto L386;
        AnchorV4CommentBusinessMeta r170 = r169.getBusinessMeta();
        if (r170 == null) goto L386;
        String r171 = r170.getKolReviewVideoId();
    L387:
        if (r171 != null) goto L389;
        r171 = "";
    L389:
        r168[0] = TuplesKt.to("video_id", r171);
        AnchorV4CommentMeta r172 = r2.B;
        if (r172 == null) goto L394;
        AnchorV4CommentBusinessMeta r173 = r172.getBusinessMeta();
        if (r173 == null) goto L394;
        Long r174 = Long.valueOf(r173.getKolReviewAuthorId());
    L395:
        r168[1] = TuplesKt.to("goods_author_id", String.valueOf(r174));
        r167.c = MapsKt.mapOf(r168);
        AnchorV4TrackerImpl.b(r167, "goods_video_entrance_show", false, null, false, null, 28);
    L394:
        r174 = null;
    L386:
        r171 = null;
    L397:
        if (r8.getAskAroundTitle() == null) goto L418;
        int r175 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r176 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r176 == null) goto L418;
        if (g.a(r2.k) == true) goto L404;
        r176 = null;
    L404:
        if (r176 == null) goto L418;
        Pair[] r177 = new Pair[4];
        r177[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r177[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        AnchorV4CommentMeta r178 = r2.B;
        if (r178 == null) goto L410;
        d r179 = r178.getTrackMeta();
        if (r179 == null) goto L410;
        Integer r180 = Integer.valueOf(r179.m());
    L411:
        r177[2] = TuplesKt.to("question_num", Integer.valueOf(k.f(r180)));
        AnchorV4VM r181 = r2.A;
        if (r181 == null) goto L416;
        CommonMeta r182 = r181.commonMeta();
        if (r182 == null) goto L416;
        String r183 = r182.getProductId();
    L417:
        r177[3] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, k.j(r183));
        r176.c = MapsKt.mapOf(r177);
        AnchorV4TrackerImpl.b(r176, "show_askaround_module", false, null, false, null, 28);
    L416:
        r183 = null;
    L410:
        r180 = null;
    L418:
        List<LongContentLabelComponent> r184 = r8.getAskAroundItems();
        if (r184 != null) goto L421;
    L472:
        String r312 = r165;
        List<KolReviewElement> r185 = r8.getKolReviewList();
        if (r185 != null) goto L475;
    L509:
        List<KolReviewElement> r186 = r8.getKolReviewList();
        if (r186 != null) goto L512;
        return;
    L512:
        if (r186.isEmpty() == true) goto L617;
        Iterator<T> r187 = r8.getKolReviewList().iterator();
        int r188 = 0;
    L515:
        if (r187.hasNext() == false) goto L619;
        Object r189 = r187.next();
        int r190 = r188 + 1;
        if (r188 >= 0) goto L519;
        CollectionsKt.throwIndexOverflow();
    L519:
        KolReviewElement r191 = (KolReviewElement) r189;
        if (r9 == null) goto L526;
        AnchorV4CommentBusinessMeta r192 = r9.getBusinessMeta();
        if (r192 == null) goto L526;
        List<String> r193 = r192.getKolAwemeIdList();
        if (r193 == null) goto L526;
        String r194 = (String) CollectionsKt.getOrNull(r193, r188);
    L527:
        if (r194 != null) goto L529;
        r194 = r312;
    L529:
        if (r9 == null) goto L535;
        AnchorV4CommentBusinessMeta r195 = r9.getBusinessMeta();
        if (r195 == null) goto L535;
        List<String> r196 = r195.getKolAuthorIdList();
        if (r196 == null) goto L535;
        String r197 = (String) CollectionsKt.getOrNull(r196, r188);
    L536:
        if (r197 != null) goto L538;
        r197 = r312;
    L538:
        if (r9 == null) goto L544;
        AnchorV4CommentBusinessMeta r198 = r9.getBusinessMeta();
        if (r198 == null) goto L544;
        List<String> r199 = r198.getKolVideoTypeList();
        if (r199 == null) goto L544;
        String r200 = (String) CollectionsKt.getOrNull(r199, r188);
    L545:
        if (r200 != null) goto L547;
        r200 = r312;
    L547:
        String r201 = r191.getElementType();
        int r1100 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1101 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r1101 == null) goto L570;
        if (g.a(r2.s) == true) goto L553;
        r1101 = null;
    L553:
        if (r1101 == null) goto L570;
        Pair[] r1102 = new Pair[6];
        r1102[0] = TuplesKt.to("kol_video_id", r194);
        r1102[1] = TuplesKt.to("kol_video_rank", Integer.valueOf(r190));
        r1102[2] = TuplesKt.to("kol_author_id", r197);
        r1102[3] = TuplesKt.to("kol_video_type", r201);
        if (r9 == null) goto L559;
        d r202 = r9.getTrackMeta();
        if (r202 == null) goto L559;
        Integer r203 = Integer.valueOf(r202.j());
    L560:
        r1102[4] = TuplesKt.to("kol_all_video_cnt", Integer.valueOf(k.f(r203)));
        r1102[5] = TuplesKt.to("video_type", r200);
        r1101.c = MapsKt.mapOf(r1102);
        Action r204 = r191.getAction();
        if (r204 == null) goto L567;
        String r205 = r204.getMeta();
        if (r205 == null) goto L567;
        JSONObject r206 = k.w(r205);
        if (r206 == null) goto L567;
        String r214 = r206.optString("index");
    L568:
        AnchorV4TrackerImpl.b(r1101, "kol_video_show", false, r214, false, null, 24);
    L567:
        r214 = null;
    L559:
        r203 = null;
    L570:
        r188 = r190;
    L544:
        r200 = null;
    L535:
        r197 = null;
    L526:
        r194 = null;
        goto L527
    L619:
        return;
    L617:
        return;
    L475:
        if (r185.isEmpty() == true) goto L509;
        LinkedHashMap r207 = new LinkedHashMap();
        if (r9 == null) goto L489;
        AnchorV4CommentBusinessMeta r208 = r9.getBusinessMeta();
        if (r208 == null) goto L489;
        List<String> r209 = r208.getKolAwemeIdList();
        if (r209 == null) goto L489;
        Iterator<T> r215 = r209.iterator();
        int r216 = 0;
    L484:
        if (r215.hasNext() == false) goto L489;
        Object r217 = r215.next();
        int r218 = r216 + 1;
        if (r216 >= 0) goto L488;
        CollectionsKt.throwIndexOverflow();
    L488:
        r207.put(String.valueOf(r218), (String) r217);
        r216 = r218;
    L489:
        int r219 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r220 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r220 == null) goto L509;
        if (g.a(r2.y) == true) goto L495;
        r220 = null;
    L495:
        if (r220 == null) goto L509;
        Pair[] r221 = new Pair[4];
        r221[0] = TuplesKt.to("video_info", r207);
        r221[1] = TuplesKt.to("kol_video_cnt", Integer.valueOf(k.f(Integer.valueOf(r8.getKolReviewList().size()))));
        if (r9 == null) goto L501;
        d r222 = r9.getTrackMeta();
        if (r222 == null) goto L501;
        Integer r223 = Integer.valueOf(r222.j());
    L502:
        r221[2] = TuplesKt.to("kol_all_video_cnt", Integer.valueOf(k.f(r223)));
        if (r9 == null) goto L507;
        d r224 = r9.getTrackMeta();
        if (r224 == null) goto L507;
        String r225 = r224.u();
    L508:
        r221[3] = TuplesKt.to("video_group_type", r225);
        r220.c = MapsKt.mapOf(r221);
        AnchorV4TrackerImpl.b(r220, "kol_video_group_show", false, null, false, null, 28);
    L507:
        r225 = null;
    L501:
        r223 = null;
        goto L502
    L421:
        if (r184.isEmpty() == true) goto L472;
        LongContentLabelComponent r226 = (LongContentLabelComponent) CollectionsKt.firstOrNull(r8.getAskAroundItems());
        if (r226 == null) goto L431;
        Action r227 = r226.getAction();
        if (r227 == null) goto L431;
        String r228 = r227.getMeta();
        if (r228 == null) goto L431;
        JSONObject r229 = k.w(r228);
        if (r229 == null) goto L431;
        String r230 = r229.optString("index");
    L433:
        if ((!Intrinsics.areEqual(r230, "askaround")) == false) goto L472;
        Iterator r231 = r8.getAskAroundItems().iterator();
        int r1103 = 0;
    L436:
        if (r231.hasNext() == false) goto L472;
        Object r1104 = r231.next();
        int r1105 = r1103 + 1;
        if (r1103 >= 0) goto L440;
        CollectionsKt.throwIndexOverflow();
    L440:
        LongContentLabelComponent r1106 = (LongContentLabelComponent) r1104;
        int r1107 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1108 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.A);
        if (r1108 == null) goto L471;
        if (g.a(r2.l) == true) goto L446;
        r1108 = null;
    L446:
        if (r1108 == null) goto L471;
        Pair[] r232 = new Pair[6];
        r232[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r232[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        r232[2] = TuplesKt.to("askaround_module", "question");
        AnchorV4CommentMeta r233 = r2.B;
        if (r233 == null) goto L454;
        d r234 = r233.getTrackMeta();
        if (r234 == null) goto L454;
        List<Long> r235 = r234.l();
        if (r235 == null) goto L454;
        Long r236 = (Long) CollectionsKt.getOrNull(r235, r1103);
    L455:
        r232[3] = TuplesKt.to("question_id", Long.valueOf(k.h(r236)));
        AnchorV4VM r237 = r2.A;
        if (r237 == null) goto L460;
        CommonMeta r238 = r237.commonMeta();
        if (r238 == null) goto L460;
        String r239 = r238.getProductId();
    L461:
        r232[4] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, k.j(r239));
        r232[5] = TuplesKt.to("question_rank", Integer.valueOf(r1105));
        r1108.c = MapsKt.mapOf(r232);
        Action r240 = r1106.getAction();
        if (r240 == null) goto L468;
        String r241 = r240.getMeta();
        if (r241 == null) goto L468;
        JSONObject r242 = k.w(r241);
        if (r242 == null) goto L468;
        String r243 = r242.optString("index");
    L469:
        AnchorV4TrackerImpl.b(r1108, "single_askaround_show", false, r243, false, null, 24);
    L468:
        r243 = null;
    L460:
        r239 = null;
    L454:
        r236 = null;
    L471:
        r1103 = r1105;
        r231 = r231;
        r165 = r165;
    L431:
        r230 = null;
        goto L433
    L618:
        return;
    L573:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.comment.AnchorV4CommentView");
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r4) {
        e r5 = (e) r4;
        Intrinsics.checkNotNullParameter(r5, "item");
        this.m = r5;
        this.p.b(this, r5, 0);
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L15;
        ((AnchorV4CommentView) r0).setActionHub(this);
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if (r1 == null) goto L13;
        ((AnchorV4CommentView) r1).a(r5.b, this.r, r5.c);
        View r6 = ((RecyclerView.ViewHolder) this).itemView;
        if (r6 == null) goto L11;
        ExtensionsKt.e((ViewGroup) r6, this);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.comment.AnchorV4CommentView");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.comment.AnchorV4CommentView");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        ((c) this.n.getValue()).O0(r2, r3, r4);
    }

    public AnchorV4CommentVH(ViewGroup r5, VisibleLogManager r6, FragmentActivity r7, AnchorV4VM r8) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Intrinsics.checkNotNullParameter(r6, "logManager");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        super(new AnchorV4CommentView(r5.getContext(), null, 6), true);
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.n = LazyKt.lazy(new AnchorV4CommentVH$clickHandler$2(this));
    }
}
