package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.n0;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.dualstream.AnchorV3DualStreamActivity;
import com.bytedance.android.shopping.anchorv3.dualstream.model.DualStreamParams;
import com.bytedance.android.shopping.anchorv3.utils.r;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.Mediatype;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryViewerPlayerBlockCompat;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public int a;
    public boolean b;
    public final AnchorV4VM c;
    public final AnchorV4CommentDisplay d;
    public final AnchorV4CommentMeta e;
    public final Context f;
    public final com.bytedance.android.shopping.anchorv4.containers.e g;

    public static final class a implements OnDismissListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ List b;
        public final /* synthetic */ VideoHolder c;
        public final /* synthetic */ View d;

        public final void onDismiss(int r2) {
            VideoHolder r3 = this.c;
            if (r3 == null) goto L5;
            r3.g();
        L5:
            c r4 = this.a;
            r4.a = 0;
            r4.b = true;
        }

        public a(c r1, List r2, VideoHolder r3, View r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b implements OnPageSelectedListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ List b;
        public final /* synthetic */ View c;

        public final void onPageSelected(int r20) {
            c r2 = this.a;
            if (r2.b == true) goto L78;
            r2.a++;
            AnchorV4CommentDisplay r3 = r2.d;
            Long r6 = null;
            if (r3 == null) goto L20;
            MediaScrollBoxComponent r4 = r3.getCommentMedias();
            if (r4 == null) goto L20;
            List r5 = r4.getMedias();
            if (r5 == null) goto L20;
            ArrayList r7 = new ArrayList();
            Iterator r8 = r5.iterator();
        L12:
            if (r8.hasNext() == false) goto L19;
            Object r9 = r8.next();
            if (((MediaBoxElement) r9).getType() != Mediatype.PHOTO.getType()) goto L16;
            boolean r10 = true;
        L17:
            if (r10 == false) goto L12;
            r7.add(r9);
            goto L12
        L16:
            r10 = false;
            goto L17
        L19:
            Integer r11 = Integer.valueOf(r7.size());
        L21:
            int r12 = k.f(r11);
            AnchorV4CommentDisplay r13 = r2.d;
            if (r13 == null) goto L37;
            MediaScrollBoxComponent r14 = r13.getCommentMedias();
            if (r14 == null) goto L37;
            List r15 = r14.getMedias();
            if (r15 == null) goto L37;
            ArrayList r16 = new ArrayList();
            Iterator r17 = r15.iterator();
        L29:
            if (r17.hasNext() == false) goto L36;
            Object r18 = r17.next();
            if (((MediaBoxElement) r18).getType() != Mediatype.VIDEO.getType()) goto L33;
            boolean r19 = true;
        L34:
            if (r19 == false) goto L29;
            r16.add(r18);
            goto L29
        L33:
            r19 = false;
            goto L34
        L36:
            Integer r21 = Integer.valueOf(r16.size());
        L38:
            int r22 = k.f(r21);
            AnchorV4CommentDisplay r23 = r2.d;
            if (r23 == null) goto L49;
            MediaScrollBoxComponent r24 = r23.getCommentMedias();
            if (r24 == null) goto L49;
            List r25 = r24.getMedias();
            if (r25 == null) goto L49;
            MediaBoxElement r26 = (MediaBoxElement) CollectionsKt.getOrNull(r25, r20);
            if (r26 == null) goto L49;
            if (r26.getType() != Mediatype.VIDEO.getType()) goto L49;
            String r27 = "video";
        L50:
            AnchorV4CommentMeta r28 = r2.e;
            if (r28 == null) goto L55;
            d r29 = r28.getTrackMeta();
            if (r29 == null) goto L55;
            Long r30 = r29.t();
        L56:
            AnchorV4CommentMeta r110 = r2.e;
            if (r110 == null) goto L61;
            d r111 = r110.getTrackMeta();
            if (r111 == null) goto L61;
            long r112 = r111.a();
        L63:
            if (r112 < 4) goto L65;
            boolean r113 = true;
        L66:
            int r114 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
            AnchorV4TrackerImpl r115 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.c);
            if (r115 == null) goto L78;
            Pair[] r116 = new Pair[10];
            r116[0] = TuplesKt.to("comment_module", "product_comment");
            AnchorV4CommentMeta r117 = r2.e;
            if (r117 == null) goto L73;
            d r118 = r117.getTrackMeta();
            if (r118 == null) goto L73;
            r6 = Long.valueOf(r118.d());
        L73:
            r116[1] = TuplesKt.to("comment_id", r6);
            r116[2] = TuplesKt.to("comment_rank", Integer.valueOf(r20 + 1));
            r116[3] = TuplesKt.to("picture_num", Integer.valueOf(r12));
            r116[4] = TuplesKt.to("video_num", Integer.valueOf(r22));
            r116[5] = TuplesKt.to("user_comment_level", r30);
            r116[6] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "comment_card");
            r116[7] = TuplesKt.to("content_type", r27);
            r116[8] = TuplesKt.to("slide_order", Integer.valueOf(r2.a));
            if (r113 == false) goto L76;
            String r1 = "1";
        L77:
            r116[9] = TuplesKt.to("show_selected_comment", r1);
            r115.c = MapsKt.mapOf(r116);
            AnchorV4TrackerImpl.b(r115, "comment_content_slide", false, null, false, null, 30);
            goto L78
        L76:
            r1 = "0";
            goto L77
        L65:
            r113 = false;
        L61:
            r112 = 0;
        L55:
            r30 = null;
        L49:
            r27 = "photo";
        L37:
            r21 = null;
        L20:
            r11 = null;
        L78:
            c r31 = this.a;
            if (r31.b == false) goto L92;
            r31.b = false;
            return;
        }

        public b(c r1, List r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public static StatTagItem b() {
        return new StatTagItem(1, 0, null, null, 0, false, null, 0, 254, null);
    }

    public static void g() {
        int r0 = ECSdk.a;
        IECUserTrackerService r1 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r1 == null) goto L8;
        of.a r2 = r1.getMarketingService();
        if (r2 == null) goto L9;
        r2.a("product_detail_click_comment", PostActionType.DO, "product_detail");
        return;
    L9:
        return;
    }

    public final Context getContext() {
        return this.f;
    }

    public final fj.d a(VideoModel r26) {
        String r0 = null;
        if (r26 != null) goto L5;
        return null;
    L5:
        String r2 = r26.getMainUrl();
        String r3 = r26.getBackupUrl();
        String r4 = r26.getVid();
        long r5 = r26.getWidth();
        long r7 = r26.getHeight();
        Integer r1 = r26.getDuration();
        if (r1 == null) goto L8;
        long r9 = r1.intValue();
    L9:
        ImageModel r6 = r26.getPosterImage();
        if (r6 == null) goto L17;
        ECUrlModel r8 = r6.getRemote();
        if (r8 == null) goto L17;
        List r10 = r8.getUrlList();
        if (r10 == null) goto L17;
        r0 = (String) CollectionsKt.firstOrNull(r10);
    L17:
        return new fj.d(r2, r3, r4, r5, r7, r9, r0, false, false, false, false, false, null, false, 0, null, null, 130944);
    L8:
        r9 = 0;
        goto L9
    }

    public final void f(int r10) {
        AnchorV4CommentMeta r0 = this.e;
        if (r0 == null) goto L9;
        AnchorV4CommentBusinessMeta r1 = r0.getBusinessMeta();
        if (r1 == null) goto L9;
        List<String> r2 = r1.getKolAwemeIdList();
        if (r2 == null) goto L9;
        String r3 = (String) CollectionsKt.getOrNull(r2, r10);
    L10:
        String r4 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        AnchorV4CommentMeta r5 = this.e;
        if (r5 == null) goto L20;
        AnchorV4CommentBusinessMeta r6 = r5.getBusinessMeta();
        if (r6 == null) goto L20;
        List<String> r7 = r6.getKolAuthorIdList();
        if (r7 == null) goto L20;
        String r8 = (String) CollectionsKt.getOrNull(r7, r10);
    L21:
        if (r8 == null) goto L24;
        r4 = r8;
    L24:
        AnchorV4CommentMeta r9 = this.e;
        if (r9 == null) goto L39;
        AnchorV4CommentBusinessMeta r11 = r9.getBusinessMeta();
        if (r11 == null) goto L40;
        String r12 = r11.getKolVideoPlaySchema();
        if (r12 != null) goto L32;
        return;
    L32:
        if (StringsKt.contains$default(r12, "#click_video_id", false, 2, null) == false) goto L37;
        Uri r13 = UriProtector.parse(StringsKt.replace$default(r12, "#click_video_id", r3, false, 4, null));
        JSONObject r14 = k.w(UriProtector.getQueryParameter(r13, "tracker"));
        if (r14 != null) goto L36;
        r14 = new JSONObject();
    L36:
        r14.put("kol_video_id", r3);
        r14.put("kol_author_id", r4);
        r14.put("kol_video_rank", r10 + 1);
        r14.put(SimilarProductParam.ENTER_FROM, "ec_goods_video_page");
        r12 = j1.d(r13, "tracker").buildUpon().appendQueryParameter("tracker", r14.toString()).build().toString();
    L37:
        p.a.openSchema(this.f, r12);
        return;
    L40:
        return;
    L39:
        return;
    L20:
        r8 = null;
    L9:
        r3 = null;
        goto L10
    }

    public final StatTagItem c(int r27, boolean r28) {
        AnchorV4CommentMeta r2 = this.e;
        String r3 = null;
        if (r28 == false) goto L8;
        if (r2 == null) goto L12;
        d r4 = r2.getTrackMeta();
        if (r4 == null) goto L12;
        List<String> r5 = r4.e();
    L13:
        AnchorV4CommentMeta r6 = this.e;
        if (r28 == false) goto L19;
        if (r6 == null) goto L23;
        d r7 = r6.getTrackMeta();
        if (r7 == null) goto L23;
        List<String> r8 = r7.h();
    L24:
        AnchorV4CommentMeta r9 = this.e;
        if (r28 == false) goto L30;
        if (r9 == null) goto L34;
        d r10 = r9.getTrackMeta();
        if (r10 == null) goto L34;
        List<String> r11 = r10.g();
    L35:
        AnchorV4CommentMeta r12 = this.e;
        if (r28 == false) goto L41;
        if (r12 == null) goto L45;
        AnchorV4CommentBusinessMeta r13 = r12.getBusinessMeta();
        if (r13 == null) goto L45;
        List<AnchorV4CommentTagStruct> r14 = r13.getTagJump();
    L46:
        long r15 = 0;
        if (r8 == null) goto L53;
        String r16 = (String) CollectionsKt.getOrNull(r8, r27);
        if (r16 == null) goto L53;
        Long r17 = StringsKt.toLongOrNull(r16);
        if (r17 == null) goto L53;
        long r18 = r17.longValue();
    L54:
        if (r11 == null) goto L60;
        String r19 = (String) CollectionsKt.getOrNull(r11, r27);
        if (r19 == null) goto L60;
        Long r20 = StringsKt.toLongOrNull(r19);
        if (r20 == null) goto L60;
        r15 = r20.longValue();
    L60:
        long r110 = r15;
        if (r14 == null) goto L65;
        AnchorV4CommentTagStruct r21 = (AnchorV4CommentTagStruct) CollectionsKt.getOrNull(r14, r27);
        if (r21 == null) goto L65;
        long r22 = r21.getStateId();
    L66:
        long r111 = r22;
        if (r5 == null) goto L69;
        r3 = (String) CollectionsKt.getOrNull(r5, r27);
    L69:
        String r1 = k.j(r3);
        return new StatTagItem(r111, r110, r1 + ' ' + r110, r1, r18, false, null, 0, 192, null);
    L65:
        r22 = 1;
    L53:
        r18 = 0;
    L45:
        r14 = null;
        goto L46
    L41:
        if (r12 == null) goto L45;
        AnchorV4CommentBusinessMeta r23 = r12.getBusinessMeta();
        if (r23 == null) goto L45;
        r14 = r23.getStoreTagJump();
    L34:
        r11 = null;
        goto L35
    L30:
        if (r9 == null) goto L34;
        d r24 = r9.getTrackMeta();
        if (r24 == null) goto L34;
        r11 = r24.q();
    L23:
        r8 = null;
        goto L24
    L19:
        if (r6 == null) goto L23;
        d r25 = r6.getTrackMeta();
        if (r25 == null) goto L23;
        r8 = r25.r();
    L12:
        r5 = null;
        goto L13
    L8:
        if (r2 == null) goto L12;
        d r26 = r2.getTrackMeta();
        if (r26 == null) goto L12;
        r5 = r26.o();
        goto L13
    }

    public final void e(boolean r13, int r14) {
        AnchorV4CommentMeta r0 = this.e;
        Integer r1 = null;
        if (r13 == false) goto L8;
        if (r0 == null) goto L12;
        d r2 = r0.getTrackMeta();
        if (r2 == null) goto L12;
        List<String> r3 = r2.e();
    L13:
        AnchorV4CommentMeta r4 = this.e;
        if (r13 == false) goto L19;
        if (r4 == null) goto L23;
        d r5 = r4.getTrackMeta();
        if (r5 == null) goto L23;
        List<String> r6 = r5.f();
    L24:
        AnchorV4CommentMeta r7 = this.e;
        if (r13 == false) goto L30;
        if (r7 == null) goto L34;
        d r15 = r7.getTrackMeta();
        if (r15 == null) goto L34;
        List<String> r16 = r15.h();
    L35:
        AnchorV4CommentMeta r8 = this.e;
        if (r8 == null) goto L40;
        d r9 = r8.getTrackMeta();
        if (r9 == null) goto L40;
        Long r10 = r9.t();
    L41:
        int r11 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r12 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r12 == null) goto L68;
        Pair[] r17 = new Pair[8];
        r17[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        if (r3 == null) goto L46;
        String r18 = (String) CollectionsKt.getOrNull(r3, r14);
    L47:
        r17[1] = TuplesKt.to("word_name", k.j(r18));
        r17[2] = TuplesKt.to("word_order", String.valueOf(r14));
        if (r6 == null) goto L50;
        String r19 = (String) CollectionsKt.getOrNull(r6, r14);
    L51:
        r17[3] = TuplesKt.to("comment_num", k.j(r19));
        if (r16 == null) goto L54;
        String r110 = (String) CollectionsKt.getOrNull(r16, r14);
    L55:
        r17[4] = TuplesKt.to("if_positive", k.j(r110));
        r17[5] = TuplesKt.to("user_comment_level", r10);
        AnchorV4CommentMeta r111 = this.e;
        if (r111 == null) goto L60;
        d r112 = r111.getTrackMeta();
        if (r112 == null) goto L60;
        String r113 = r112.k();
    L61:
        r17[6] = TuplesKt.to("comment_module", r113);
        AnchorV4CommentMeta r114 = this.e;
        if (r114 == null) goto L66;
        d r115 = r114.getTrackMeta();
        if (r115 == null) goto L66;
        r1 = r115.v();
    L66:
        r17[7] = TuplesKt.to("with_same_comment", r1);
        r12.c = MapsKt.mapOf(r17);
        AnchorV4TrackerImpl.b(r12, "comment_key_word_click", false, null, false, null, 30);
        return;
    L60:
        r113 = null;
        goto L61
    L54:
        r110 = null;
        goto L55
    L50:
        r19 = null;
        goto L51
    L46:
        r18 = null;
        goto L47
    L68:
        return;
    L40:
        r10 = null;
    L34:
        r16 = null;
        goto L35
    L30:
        if (r7 == null) goto L34;
        d r116 = r7.getTrackMeta();
        if (r116 == null) goto L34;
        r16 = r116.r();
    L23:
        r6 = null;
        goto L24
    L19:
        if (r4 == null) goto L23;
        d r20 = r4.getTrackMeta();
        if (r20 == null) goto L23;
        r6 = r20.p();
    L12:
        r3 = null;
        goto L13
    L8:
        if (r0 == null) goto L12;
        d r21 = r0.getTrackMeta();
        if (r21 == null) goto L12;
        r3 = r21.o();
        goto L13
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r29, Action r30, Object r31) {
        Object r8 = r31;
        Intrinsics.checkNotNullParameter(r29, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r30, "action");
        String r0 = r30.getId();
        boolean r11 = true;
        if (r0 == null) goto L511;
        String r4 = "";
        switch(r0.hashCode()) {
            case -1453019159: goto L505;
            case -961288383: goto L430;
            case -521721952: goto L424;
            case -492593892: goto L331;
            case -266569678: goto L275;
            case 446794081: goto L190;
            case 675898833: goto L178;
            case 749313716: goto L106;
            case 755913000: goto L90;
            case 1037656682: goto L74;
            case 1052585998: goto L49;
            case 1824322243: goto L9;
            default: goto L511;
        };
    L9:
        if (r0.equals("comment_good_goods_review") == false) goto L511;
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L15;
        j r3 = r2.getLiveWindowService();
        if (r3 == null) goto L15;
        r3.stopShowFloatInNextLifecycle();
    L15:
        CommonMeta r5 = this.c.commonMeta();
        if (r5 == null) goto L18;
        String r6 = r5.getSearchParams();
    L19:
        AnchorV4CommentMeta r7 = this.e;
        if (r7 == null) goto L511;
        AnchorV4CommentBusinessMeta r9 = r7.getBusinessMeta();
        if (r9 == null) goto L511;
        String r10 = r9.getKolReviewVideoLink();
        if (r10 == null) goto L511;
        n0 r12 = new n0(r10, false);
        if (k.c(r6) == false) goto L29;
        JSONObject r13 = new JSONObject();
        r13.put("search_params", new JSONObject(r6));
        Unit r14 = Unit.INSTANCE;
        r12.b("tracker", r13.toString());
    L29:
        r12.b(SimilarProductParam.ENTER_FROM, "kol_product_video");
        p r15 = p.a;
        String r16 = r12.c();
        Context r17 = this.f;
        if (r17 == null) goto L47;
        r15.d(r16, (Activity) r17);
        String r18 = new BtmItemBuilder("a1.b8094.c28779.d502730", Boolean.TRUE).withView(r29).createBtmId();
        int r19 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r20 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r20 == null) goto L511;
        Pair[] r21 = new Pair[3];
        AnchorV4CommentMeta r22 = this.e;
        if (r22 == null) goto L38;
        AnchorV4CommentBusinessMeta r23 = r22.getBusinessMeta();
        if (r23 == null) goto L38;
        String r24 = r23.getKolReviewVideoId();
    L39:
        r21[0] = TuplesKt.to("video_id", r24);
        AnchorV4CommentMeta r25 = this.e;
        if (r25 == null) goto L44;
        AnchorV4CommentBusinessMeta r26 = r25.getBusinessMeta();
        if (r26 == null) goto L44;
        Long r27 = Long.valueOf(r26.getKolReviewAuthorId());
    L45:
        r21[1] = TuplesKt.to("goods_author_id", String.valueOf(r27.longValue()));
        r21[2] = TuplesKt.to("btm_id", r18);
        r20.c = MapsKt.mapOf(r21);
        AnchorV4TrackerImpl.b(r20, "goods_video_entrance_click", false, null, false, null, 30);
    L44:
        r27 = null;
    L38:
        r24 = null;
        goto L39
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L18:
        r6 = null;
        goto L19
    L49:
        if (r0.equals("comment_buyer_show_media") == false) goto L511;
        String r28 = r30.getMeta();
        if (r28 == null) goto L55;
        Integer r32 = StringsKt.toIntOrNull(r28);
        if (r32 == null) goto L55;
        int r33 = r32.intValue();
    L56:
        AnchorV4CommentMeta r34 = this.e;
        if (r34 == null) goto L67;
        AnchorV4CommentBusinessMeta r35 = r34.getBusinessMeta();
        if (r35 == null) goto L67;
        List<String> r36 = r35.getBuyerShowMediaJump();
        if (r36 == null) goto L67;
        String r37 = (String) CollectionsKt.getOrNull(r36, r33);
        if (r37 == null) goto L67;
        Long r38 = StringsKt.toLongOrNull(r37);
        if (r38 == null) goto L67;
        long r39 = r38.longValue();
    L68:
        ECAnchorV3Helper r40 = ECAnchorV3Helper.a;
        CommonMeta r41 = this.c.commonMeta();
        if (r41 == null) goto L71;
        String r42 = r41.getProductId();
    L72:
        ECAnchorV3Helper.f(r42, Long.valueOf(r39), Integer.valueOf(r33), "product_detail", this.f);
        d(r29, CommentType.TYPE_BUYERS_SHOW, b());
        goto L511
    L71:
        r42 = null;
    L67:
        r39 = 0;
    L55:
        r33 = 0;
        goto L56
    L74:
        if (r0.equals("comment_product_tag") == false) goto L511;
        String r43 = r30.getMeta();
        if (r43 == null) goto L80;
        JSONObject r44 = k.w(r43);
        if (r44 == null) goto L80;
        int r45 = r44.optInt("index");
    L81:
        com.bytedance.android.shopping.anchorv4.containers.e r46 = this.g;
        if (r46 == null) goto L88;
        StatTagItem r110 = c(r45, true);
        CommonMeta r47 = this.c.commonMeta();
        if (r47 == null) goto L86;
        Integer r210 = r47.getProductCommentDataType();
    L87:
        com.bytedance.android.shopping.anchorv4.containers.e.a.a(r46, r110, 0, r210, null, 8);
        goto L88
    L86:
        r210 = null;
    L88:
        e(true, r45);
        g();
    L80:
        r45 = 0;
        goto L81
    L90:
        if (r0.equals("comment_product_title") == false) goto L511;
        StatTagItem r48 = b();
        AnchorV4CommentMeta r49 = this.e;
        if (r49 == null) goto L104;
        AnchorV4CommentBusinessMeta r50 = r49.getBusinessMeta();
        if (r50 == null) goto L104;
        if (r50.getHasProductComment() != true) goto L104;
        com.bytedance.android.shopping.anchorv4.containers.e r51 = this.g;
        if (r51 == null) goto L104;
        CommonMeta r52 = this.c.commonMeta();
        if (r52 == null) goto L102;
        Integer r211 = r52.getProductCommentDataType();
    L103:
        com.bytedance.android.shopping.anchorv4.containers.e.a.a(r51, r48, 0, r211, null, 8);
        goto L104
    L102:
        r211 = null;
    L104:
        d(r29, CommentType.TYPE_PRODUCT, r48);
        g();
        goto L511
    L106:
        if (r0.equals("comment_product_media") == false) goto L511;
        String r53 = r30.getMeta();
        if (r53 == null) goto L110;
        JSONObject r54 = k.w(r53);
    L111:
        AnchorV4CommentMeta r55 = this.e;
        if (r55 == null) goto L116;
        AnchorV4CommentBusinessMeta r56 = r55.getBusinessMeta();
        if (r56 == null) goto L116;
        List<AnchorV4CommentMediaMeta> r57 = r56.getCommentMediaJumpList();
    L117:
        if (r54 == null) goto L121;
        String r58 = r54.optString("comment_index");
        if (r58 == null) goto L121;
        Integer r59 = Integer.valueOf(CastIntegerProtector.parseInt(r58));
    L122:
        if (r54 == null) goto L126;
        String r60 = r54.optString("position");
        if (r60 == null) goto L126;
        Integer r61 = Integer.valueOf(CastIntegerProtector.parseInt(r60));
    L127:
        if (r57 == null) goto L149;
        if (r59 == null) goto L149;
        if (r61 == null) goto L149;
        int r62 = r61.intValue();
        int r63 = r59.intValue();
        AnchorV4CommentMediaMeta r64 = (AnchorV4CommentMediaMeta) CollectionsKt.getOrNull(r57, r63);
        if (r64 == null) goto L133;
        List<String> r65 = r64.getImageUrlList();
    L134:
        if (r65 != null) goto L136;
        r65 = CollectionsKt.emptyList();
    L136:
        AnchorV4CommentMediaMeta r66 = (AnchorV4CommentMediaMeta) CollectionsKt.getOrNull(r57, r63);
        if (r66 == null) goto L139;
        VideoModel r67 = r66.getVideo();
    L140:
        fj.d r68 = a(r67);
        if ((r8 instanceof com.bytedance.android.shopping.anchorv4.voavhs.base.elements.d) == true) goto L143;
        Object r69 = null;
    L144:
        com.bytedance.android.shopping.anchorv4.voavhs.base.elements.d r70 = (com.bytedance.android.shopping.anchorv4.voavhs.base.elements.d) r69;
        if (r70 == null) goto L147;
        VideoHolder r71 = r70.b;
    L148:
        h(r29, r65, r68, r71, r62);
        Unit r72 = Unit.INSTANCE;
    L150:
        if (r72 != null) goto L511;
        AnchorV4CommentMeta r73 = this.e;
        if (r73 == null) goto L158;
        AnchorV4CommentBusinessMeta r74 = r73.getBusinessMeta();
        if (r74 == null) goto L158;
        AnchorV4CommentMediaMeta r75 = r74.getCommentMediaJump();
        if (r75 == null) goto L158;
        List<String> r76 = r75.getImageUrlList();
    L159:
        if (r76 != null) goto L161;
        r76 = CollectionsKt.emptyList();
    L161:
        List<String> r77 = r76;
        AnchorV4CommentMeta r78 = this.e;
        if (r78 == null) goto L168;
        AnchorV4CommentBusinessMeta r79 = r78.getBusinessMeta();
        if (r79 == null) goto L168;
        AnchorV4CommentMediaMeta r80 = r79.getCommentMediaJump();
        if (r80 == null) goto L168;
        VideoModel r81 = r80.getVideo();
    L169:
        int r82 = k.r(r30.getMeta(), 0);
        fj.d r84 = a(r81);
        if ((r8 instanceof com.bytedance.android.shopping.anchorv4.voavhs.base.elements.d) == true) goto L172;
        r8 = null;
    L172:
        com.bytedance.android.shopping.anchorv4.voavhs.base.elements.d r85 = (com.bytedance.android.shopping.anchorv4.voavhs.base.elements.d) r8;
        if (r85 == null) goto L175;
        VideoHolder r86 = r85.b;
    L176:
        h(r29, r77, r84, r86, r82);
        Unit r87 = Unit.INSTANCE;
        goto L511
    L175:
        r86 = null;
    L168:
        r81 = null;
    L158:
        r76 = null;
        goto L159
    L147:
        r71 = null;
        goto L148
    L143:
        r69 = r8;
        goto L144
    L139:
        r67 = null;
        goto L140
    L133:
        r65 = null;
    L149:
        r72 = null;
    L126:
        r61 = null;
    L121:
        r59 = null;
    L116:
        r57 = null;
        goto L117
    L110:
        r54 = null;
        goto L111
    L178:
        if (r0.equals("comment_other_goods_tags") == false) goto L511;
        String r88 = r30.getMeta();
        if (r88 == null) goto L184;
        JSONObject r89 = k.w(r88);
        if (r89 == null) goto L184;
        int r90 = r89.optInt("index");
    L185:
        com.bytedance.android.shopping.anchorv4.containers.e r91 = this.g;
        if (r91 == null) goto L188;
        com.bytedance.android.shopping.anchorv4.containers.e.a.a(r91, c(r90, false), 1, null, null, 12);
    L188:
        e(false, r90);
        g();
    L184:
        r90 = 0;
        goto L185
    L190:
        if (r0.equals("comment_product_comment_detail") == false) goto L511;
        AnchorV4CommentMeta r92 = this.e;
        if (r92 == null) goto L204;
        AnchorV4CommentBusinessMeta r94 = r92.getBusinessMeta();
        if (r94 == null) goto L204;
        if (r94.getHasProductComment() != true) goto L204;
        com.bytedance.android.shopping.anchorv4.containers.e r95 = this.g;
        if (r95 == null) goto L204;
        StatTagItem r212 = b();
        CommonMeta r96 = this.c.commonMeta();
        if (r96 == null) goto L202;
        Integer r213 = r96.getProductCommentDataType();
    L203:
        com.bytedance.android.shopping.anchorv4.containers.e.a.a(r95, r212, 0, r213, null, 8);
        goto L204
    L202:
        r213 = null;
    L204:
        AnchorV4CommentMeta r97 = this.e;
        if (r97 == null) goto L273;
        AnchorV4CommentBusinessMeta r98 = r97.getBusinessMeta();
        if (r98 == null) goto L273;
        if (r98.getHasProductComment() != true) goto L273;
        AnchorV4CommentDisplay r99 = this.d;
        if (r99 == null) goto L226;
        MediaScrollBoxComponent r100 = r99.getCommentMedias();
        if (r100 == null) goto L226;
        List r101 = r100.getMedias();
        if (r101 == null) goto L226;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L218:
        if (r103.hasNext() == false) goto L225;
        Object r104 = r103.next();
        if (((MediaBoxElement) r104).getType() != Mediatype.PHOTO.getType()) goto L222;
        boolean r105 = true;
    L223:
        if (r105 == false) goto L218;
        r102.add(r104);
        goto L218
    L222:
        r105 = false;
        goto L223
    L225:
        Integer r106 = Integer.valueOf(r102.size());
    L227:
        int r107 = k.f(r106);
        AnchorV4CommentDisplay r108 = this.d;
        if (r108 == null) goto L243;
        MediaScrollBoxComponent r109 = r108.getCommentMedias();
        if (r109 == null) goto L243;
        List r111 = r109.getMedias();
        if (r111 == null) goto L243;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r111.iterator();
    L235:
        if (r113.hasNext() == false) goto L242;
        Object r114 = r113.next();
        if (((MediaBoxElement) r114).getType() != Mediatype.VIDEO.getType()) goto L239;
        boolean r115 = true;
    L240:
        if (r115 == false) goto L235;
        r112.add(r114);
        goto L235
    L239:
        r115 = false;
        goto L240
    L242:
        Integer r116 = Integer.valueOf(r112.size());
    L244:
        int r117 = k.f(r116);
        AnchorV4CommentMeta r118 = this.e;
        if (r118 == null) goto L249;
        d r119 = r118.getTrackMeta();
        if (r119 == null) goto L249;
        long r120 = r119.a();
    L251:
        if (r120 < 4) goto L253;
        boolean r121 = true;
    L254:
        AnchorV4CommentMeta r122 = this.e;
        if (r122 == null) goto L261;
        d r123 = r122.getTrackMeta();
        if (r123 == null) goto L261;
        Long r124 = r123.t();
        if (r124 == null) goto L261;
        String r125 = String.valueOf(r124.longValue());
    L262:
        int r126 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r127 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r127 == null) goto L273;
        Pair[] r128 = new Pair[7];
        r128[0] = TuplesKt.to("comment_module", "product_comment");
        d r129 = this.e.getTrackMeta();
        if (r129 == null) goto L267;
        Long r130 = Long.valueOf(r129.d());
    L268:
        r128[1] = TuplesKt.to("comment_id", String.valueOf(r130));
        String r131 = "1";
        r128[2] = TuplesKt.to("comment_rank", "1");
        r128[3] = TuplesKt.to("picture_num", String.valueOf(r107));
        r128[4] = TuplesKt.to("video_num", String.valueOf(r117));
        r128[5] = TuplesKt.to("user_comment_level", r125);
        if (r121 == true) goto L272;
        r131 = "0";
    L272:
        r128[6] = TuplesKt.to("show_selected_comment", r131);
        r127.c = MapsKt.mapOf(r128);
        AnchorV4TrackerImpl.b(r127, "single_comment_click", false, null, false, null, 30);
        goto L273
    L267:
        r130 = null;
    L261:
        r125 = null;
        goto L262
    L253:
        r121 = false;
    L249:
        r120 = 0;
    L243:
        r116 = null;
    L226:
        r106 = null;
    L273:
        d(r29, CommentType.TYPE_COMMENT_REGION, b());
        g();
        goto L511
    L275:
        if (r0.equals("kol_review_video_list") == false) goto L511;
        String r132 = r30.getMeta();
        if (r132 == null) goto L281;
        JSONObject r133 = k.w(r132);
        if (r133 == null) goto L281;
        int r134 = r133.optInt("index");
    L282:
        f(r134);
        AnchorV4CommentMeta r135 = this.e;
        if (r135 == null) goto L289;
        AnchorV4CommentBusinessMeta r136 = r135.getBusinessMeta();
        if (r136 == null) goto L289;
        List<String> r137 = r136.getKolAwemeIdList();
        if (r137 == null) goto L289;
        String r138 = (String) CollectionsKt.getOrNull(r137, r134);
    L290:
        if (r138 != null) goto L292;
        r138 = "";
    L292:
        AnchorV4CommentMeta r139 = this.e;
        if (r139 == null) goto L299;
        AnchorV4CommentBusinessMeta r140 = r139.getBusinessMeta();
        if (r140 == null) goto L299;
        List<String> r141 = r140.getKolAuthorIdList();
        if (r141 == null) goto L299;
        String r142 = (String) CollectionsKt.getOrNull(r141, r134);
    L300:
        if (r142 != null) goto L302;
        r142 = "";
    L302:
        AnchorV4CommentDisplay r143 = this.d;
        if (r143 == null) goto L309;
        List<KolReviewElement> r144 = r143.getKolReviewList();
        if (r144 == null) goto L309;
        KolReviewElement r145 = (KolReviewElement) CollectionsKt.getOrNull(r144, r134);
        if (r145 == null) goto L309;
        String r146 = r145.getElementType();
    L310:
        AnchorV4CommentMeta r147 = this.e;
        if (r147 == null) goto L317;
        AnchorV4CommentBusinessMeta r148 = r147.getBusinessMeta();
        if (r148 == null) goto L317;
        List<String> r149 = r148.getKolVideoTypeList();
        if (r149 == null) goto L317;
        String r150 = (String) CollectionsKt.getOrNull(r149, r134);
    L318:
        if (r150 == null) goto L321;
        r4 = r150;
    L321:
        int r151 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r152 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r152 == null) goto L511;
        Pair[] r153 = new Pair[6];
        r153[0] = TuplesKt.to("kol_video_id", r138);
        r153[1] = TuplesKt.to("kol_video_rank", Integer.valueOf(r134 + 1));
        r153[2] = TuplesKt.to("kol_author_id", r142);
        r153[3] = TuplesKt.to("kol_video_type", r146);
        AnchorV4CommentMeta r154 = this.e;
        if (r154 == null) goto L328;
        d r155 = r154.getTrackMeta();
        if (r155 == null) goto L328;
        Integer r156 = Integer.valueOf(r155.j());
    L329:
        r153[4] = TuplesKt.to("kol_all_video_cnt", Integer.valueOf(k.f(r156)));
        r153[5] = TuplesKt.to("video_type", r4);
        r152.c = MapsKt.mapOf(r153);
        AnchorV4TrackerImpl.b(r152, "kol_video_click", false, null, false, null, 30);
    L328:
        r156 = null;
    L317:
        r150 = null;
    L309:
        r146 = null;
    L299:
        r142 = null;
    L289:
        r138 = null;
    L281:
        r134 = 0;
        goto L282
    L331:
        if (r0.equals("click_askaround_module") == false) goto L511;
        String r157 = r30.getMeta();
        if (r157 != null) goto L335;
    L338:
        boolean r158 = true;
    L339:
        if (r158 == true) goto L511;
        String r159 = r30.getMeta();
        if (r159 == null) goto L346;
        JSONObject r160 = k.w(r159);
        if (r160 == null) goto L346;
        String r161 = r160.optString("index");
    L348:
        if (r161 == null) goto L381;
        int r162 = r161.hashCode();
        if (r162 == (-1605320314)) goto L367;
        if (r162 != 110371416) goto L381;
        if (r161.equals("title") == false) goto L381;
        p r163 = p.a;
        Context r164 = this.f;
        AnchorV4CommentMeta r165 = this.e;
        if (r165 == null) goto L364;
        AnchorV4CommentBusinessMeta r166 = r165.getBusinessMeta();
        if (r166 == null) goto L364;
        com.bytedance.android.shopping.anchorv4.voavhs.comment.a r167 = r166.getAskAroundLink();
        if (r167 == null) goto L364;
        String r168 = r167.b();
    L365:
        r163.openSchema(r164, r168);
    L407:
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"title", "askaround"}), r161) == false) goto L409;
        char r169 = 0;
    L410:
        int r170 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r171 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r171 == null) goto L511;
        Pair[] r172 = new Pair[5];
        r172[r169] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r172[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        AnchorV4CommentMeta r173 = this.e;
        if (r173 == null) goto L417;
        d r174 = r173.getTrackMeta();
        if (r174 == null) goto L417;
        Integer r175 = Integer.valueOf(r174.m());
    L418:
        r172[2] = TuplesKt.to("question_num", r175);
        CommonMeta r176 = this.c.commonMeta();
        if (r176 == null) goto L421;
        String r177 = r176.getProductId();
    L422:
        r172[3] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r177);
        r172[4] = TuplesKt.to("click_area", r161);
        r171.c = MapsKt.mapOf(r172);
        AnchorV4TrackerImpl.b(r171, "click_askaround_module", false, null, false, null, 30);
        goto L511
    L421:
        r177 = null;
    L417:
        r175 = null;
        goto L418
    L409:
        r169 = 0;
        r161 = String.valueOf(k.r(r161, 0) + 1);
    L364:
        r168 = null;
        goto L365
    L367:
        if (r161.equals("askaround") == false) goto L381;
        p r178 = p.a;
        Context r179 = this.f;
        AnchorV4CommentMeta r180 = this.e;
        if (r180 == null) goto L380;
        AnchorV4CommentBusinessMeta r181 = r180.getBusinessMeta();
        if (r181 == null) goto L380;
        com.bytedance.android.shopping.anchorv4.voavhs.comment.a r182 = r181.getAskAroundLink();
        if (r182 == null) goto L380;
        List<String> r183 = r182.a();
        if (r183 == null) goto L380;
        String r184 = (String) CollectionsKt.getOrNull(r183, 0);
        if (r184 == null) goto L380;
        r4 = r184;
    L380:
        r178.openSchema(r179, r4);
    L381:
        int r185 = k.r(r161, 0);
        p r186 = p.a;
        Context r187 = this.f;
        AnchorV4CommentMeta r188 = this.e;
        if (r188 == null) goto L390;
        AnchorV4CommentBusinessMeta r189 = r188.getBusinessMeta();
        if (r189 == null) goto L390;
        com.bytedance.android.shopping.anchorv4.voavhs.comment.a r190 = r189.getAskAroundLink();
        if (r190 == null) goto L390;
        List<String> r191 = r190.a();
        if (r191 == null) goto L390;
        String r192 = (String) CollectionsKt.getOrNull(r191, r185);
    L391:
        r186.openSchema(r187, r192);
        int r193 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r194 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r194 == null) goto L407;
        Pair[] r195 = new Pair[6];
        r195[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r195[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
        r195[2] = TuplesKt.to("askaround_module", "question");
        AnchorV4CommentMeta r196 = this.e;
        if (r196 == null) goto L400;
        d r197 = r196.getTrackMeta();
        if (r197 == null) goto L400;
        List<Long> r198 = r197.l();
        if (r198 == null) goto L400;
        Long r199 = (Long) CollectionsKt.getOrNull(r198, r185);
    L401:
        r195[3] = TuplesKt.to("question_id", Long.valueOf(k.h(r199)));
        CommonMeta r1100 = this.c.commonMeta();
        if (r1100 == null) goto L404;
        String r1101 = r1100.getProductId();
    L405:
        r195[4] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, k.j(r1101));
        r195[5] = TuplesKt.to("question_rank", Integer.valueOf(r185 + 1));
        r194.c = MapsKt.mapOf(r195);
        AnchorV4TrackerImpl.b(r194, "single_askaround_click", false, null, false, null, 30);
        goto L407
    L404:
        r1101 = null;
    L400:
        r199 = null;
    L390:
        r192 = null;
    L346:
        r161 = null;
        goto L348
    L335:
        if (r157.length() == 0) goto L338;
        r158 = false;
        goto L339
    L424:
        if (r0.equals("comment_other_goods_title") == false) goto L511;
        StatTagItem r200 = b();
        com.bytedance.android.shopping.anchorv4.containers.e r1102 = this.g;
        if (r1102 == null) goto L428;
        com.bytedance.android.shopping.anchorv4.containers.e.a.a(r1102, r200, 1, null, null, 12);
    L428:
        d(r29, CommentType.TYPE_SHOP, r200);
        g();
        goto L511
    L430:
        if (r0.equals("kol_review_video_full_view") == false) goto L511;
        String r201 = r30.getMeta();
        if (r201 == null) goto L436;
        JSONObject r202 = k.w(r201);
        if (r202 == null) goto L436;
        r202.optInt("index");
    L436:
        AnchorV4CommentDisplay r203 = this.d;
        if (r203 == null) goto L441;
        List<KolReviewElement> r204 = r203.getKolReviewList();
        if (r204 == null) goto L441;
        int r205 = r204.size();
    L442:
        if (r205 <= 1) goto L501;
        AnchorV4CommentMeta r206 = this.e;
        if (r206 == null) goto L448;
        AnchorV4CommentBusinessMeta r207 = r206.getBusinessMeta();
        if (r207 == null) goto L448;
        String r208 = r207.getKolVideoListSchema();
    L449:
        if (r208 == null) goto L501;
        AnchorV4CommentMeta r209 = this.e;
        if (r209 == null) goto L458;
        AnchorV4CommentBusinessMeta r214 = r209.getBusinessMeta();
        if (r214 == null) goto L458;
        String r215 = r214.getKolVideoListSchema();
        if (r215 == null) goto L458;
        JSONObject r216 = k.w(UriProtector.getQueryParameter(UriProtector.parse(r215), "tracker"));
        if (r216 == null) goto L458;
    L459:
        AnchorV4CommentMeta r217 = this.e;
        if (r217 == null) goto L464;
        d r218 = r217.getTrackMeta();
        if (r218 == null) goto L464;
        Integer r219 = Integer.valueOf(r218.j());
    L465:
        r216.put("kol_all_video_cnt", k.f(r219));
        Iterator r220 = this.c.getEventParams().entrySet().iterator();
    L467:
        if (r220.hasNext() == false) goto L469;
        Map.Entry r221 = (Map.Entry) r220.next();
        r216.put((String) r221.getKey(), r221.getValue());
        goto L467
    L469:
        AnchorV4CommentMeta r222 = this.e;
        if (r222 == null) goto L511;
        AnchorV4CommentBusinessMeta r223 = r222.getBusinessMeta();
        if (r223 == null) goto L511;
        String r224 = r223.getKolVideoListSchema();
        if (r224 == null) goto L511;
        p r225 = p.a;
        Context r226 = this.f;
        int r227 = p0.a;
        r225.openSchema(r226, p0.d(r224, "tracker", r216.toString()));
        LinkedHashMap r228 = new LinkedHashMap();
        List<String> r229 = this.e.getBusinessMeta().getKolAwemeIdList();
        if (r229 == null) goto L484;
        Iterator<T> r230 = r229.iterator();
        int r231 = 0;
    L479:
        if (r230.hasNext() == false) goto L484;
        Object r232 = r230.next();
        int r233 = r231 + 1;
        if (r231 >= 0) goto L483;
        CollectionsKt.throwIndexOverflow();
    L483:
        String r234 = String.valueOf(r233);
        r228.put(r234, (String) r232);
        r231 = r233;
    L484:
        int r235 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r236 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r236 == null) goto L511;
        Pair[] r237 = new Pair[4];
        r237[0] = TuplesKt.to("video_info", r228);
        AnchorV4CommentDisplay r238 = this.d;
        if (r238 == null) goto L491;
        List<KolReviewElement> r239 = r238.getKolReviewList();
        if (r239 == null) goto L491;
        Integer r240 = Integer.valueOf(r239.size());
    L492:
        r237[1] = TuplesKt.to("kol_video_cnt", Integer.valueOf(k.f(r240)));
        d r241 = this.e.getTrackMeta();
        if (r241 == null) goto L495;
        Integer r242 = Integer.valueOf(r241.j());
    L496:
        r237[2] = TuplesKt.to("kol_all_video_cnt", Integer.valueOf(k.f(r242)));
        d r243 = this.e.getTrackMeta();
        if (r243 == null) goto L499;
        String r244 = r243.u();
    L500:
        r237[3] = TuplesKt.to("video_group_type", r244);
        r236.c = MapsKt.mapOf(r237);
        AnchorV4TrackerImpl.b(r236, "kol_video_group_click", true, null, false, null, 28);
        goto L511
    L499:
        r244 = null;
        goto L500
    L495:
        r242 = null;
    L491:
        r240 = null;
    L464:
        r219 = null;
    L458:
        r216 = new JSONObject();
    L448:
        r208 = null;
    L501:
        if (r205 <= 0) goto L511;
        f(0);
    L441:
        r205 = 0;
        goto L442
    L505:
        if (r0.equals("comment_buyer_show") == false) goto L511;
        int r245 = AnchorV3DualStreamActivity.x;
        Context r246 = this.f;
        CommonMeta r247 = this.c.commonMeta();
        if (r247 == null) goto L509;
        String r248 = r247.getProductId();
    L510:
        AnchorV3DualStreamActivity.a.a(r246, new DualStreamParams(String.valueOf(r248)));
        d(r29, CommentType.TYPE_BUYERS_SHOW, b());
        goto L511
    L509:
        r248 = null;
    L511:
        r29.performAccessibilityAction(128, null);
        CommonMeta r249 = this.c.commonMeta();
        if (r249 == null) goto L518;
        String r250 = r249.getEntranceInfo();
        if (r250 == null) goto L518;
        JSONObject r251 = k.w(r250);
        if (r251 == null) goto L518;
        String r252 = r251.optString("log_extra");
    L519:
        CommonMeta r253 = this.c.commonMeta();
        if (r253 == null) goto L557;
        String r254 = h73.a.b(r253);
        if (r254 == null) goto L558;
        g r255 = AdLogUtils.a;
        CommonMeta r256 = this.c.commonMeta();
        if (r256 == null) goto L526;
        Map<String, ? extends Object> r257 = h73.a.a(r256);
    L527:
        Intrinsics.checkNotNullParameter(r254, "cid");
        if (r254.length() == 0) goto L531;
        r11 = false;
    L531:
        if (r11 == true) goto L561;
        ECAppInfoService r258 = ECAppInfoService.e;
        if (we.a.a == false) goto L536;
    L541:
        AdLogUtils.a().d("click_comment_card", null, Long.valueOf(CastLongProtector.parseLong(r254)), r252);
        return;
    L536:
        if (r258.n() == true) goto L541;
        g r1103 = AdLogUtils.a;
        if (r1103 == null) goto L559;
        r1103.d("product_detail_ad", "click_comment_card", "recommend", r254, r252, r257, null, "umeng");
        return;
    L559:
        return;
    L561:
        return;
    L526:
        r257 = null;
        goto L527
    L558:
        return;
    L557:
        return;
    L518:
        r252 = null;
        goto L519
    }

    public final void d(View r23, CommentType r24, StatTagItem r25) {
        int r1 = com.bytedance.android.shopping.anchorv4.voavhs.comment.b.a[r24.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L8;
        if (r1 == 3) goto L7;
        String r2 = "product_comment";
    L10:
        int r5 = com.bytedance.android.shopping.anchorv4.voavhs.comment.b.b[r24.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L20;
        AnchorV4CommentMeta r6 = this.e;
        if (r6 == null) goto L18;
        d r7 = r6.getTrackMeta();
        if (r7 == null) goto L18;
        Long r8 = Long.valueOf(r7.i());
    L19:
        long r9 = k.h(r8);
    L28:
        int r10 = com.bytedance.android.shopping.anchorv4.voavhs.comment.b.c[r24.ordinal()];
        if (r10 == 1) goto L45;
        if (r10 == 2) goto L38;
        AnchorV4CommentMeta r11 = this.e;
        if (r11 == null) goto L36;
        d r12 = r11.getTrackMeta();
        if (r12 == null) goto L36;
        Long r13 = Long.valueOf(r12.c());
    L37:
        long r14 = k.h(r13);
    L52:
        int r15 = com.bytedance.android.shopping.anchorv4.voavhs.comment.b.d[r24.ordinal()];
        String r16 = "";
        if ("".length() <= 0) goto L55;
        boolean r17 = true;
    L56:
        if (r17 == false) goto L58;
        r16 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("", Boolean.TRUE).withView(r23).build());
    L58:
        AnchorV4CommentMeta r18 = this.e;
        if (r18 == null) goto L63;
        d r19 = r18.getTrackMeta();
        if (r19 == null) goto L63;
        long r20 = r19.a();
    L65:
        if (r20 < 4) goto L67;
        boolean r21 = true;
    L68:
        int r22 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r110 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r110 == null) goto L87;
        Pair[] r26 = new Pair[8];
        r26[0] = TuplesKt.to("btm_id", r16);
        r26[1] = TuplesKt.to("comment_entrance", "comment_detail");
        r26[2] = TuplesKt.to("comment_module", r2);
        r26[3] = TuplesKt.to("key_word_num", Long.valueOf(r9));
        r26[4] = TuplesKt.to("comment_num", Long.valueOf(r14));
        AnchorV4CommentMeta r3 = this.e;
        if (r3 == null) goto L75;
        d r4 = r3.getTrackMeta();
        if (r4 == null) goto L75;
        String r27 = r4.k();
    L76:
        r26[5] = TuplesKt.to("comment_module", r27);
        AnchorV4CommentMeta r28 = this.e;
        if (r28 == null) goto L81;
        d r29 = r28.getTrackMeta();
        if (r29 == null) goto L81;
        Integer r30 = r29.v();
    L82:
        r26[6] = TuplesKt.to("with_same_comment", r30);
        if (r21 == false) goto L85;
        String r31 = "1";
    L86:
        r26[7] = TuplesKt.to("show_selected_comment", r31);
        r110.c = MapsKt.mapOf(r26);
        AnchorV4TrackerImpl.b(r110, "click_comment_card", false, null, false, null, 30);
        goto L87
    L85:
        r31 = "0";
    L81:
        r30 = null;
    L75:
        r27 = null;
    L87:
        int r32 = r.a;
        AnchorV4VM r33 = this.c;
        String r34 = r25.getTagName();
        Intrinsics.checkNotNullParameter(r33, "vm");
        Intrinsics.checkNotNullParameter("comment_detail", "entrance");
        Intrinsics.checkNotNullParameter(r34, "tag");
        HashMap r35 = new HashMap();
        r35.put("comment_entrance", "comment_detail");
        r35.put("comment_tag", r34);
        r.b("click_comment_card", r33, r35);
        return;
    L67:
        r21 = false;
    L63:
        r20 = 0;
        goto L65
    L55:
        r17 = false;
    L36:
        r13 = null;
        goto L37
    L38:
        AnchorV4CommentMeta r36 = this.e;
        if (r36 == null) goto L43;
        d r37 = r36.getTrackMeta();
        if (r37 == null) goto L43;
        Long r38 = Long.valueOf(r37.a());
    L44:
        r14 = k.h(r38);
    L43:
        r38 = null;
        goto L44
    L45:
        AnchorV4CommentMeta r39 = this.e;
        if (r39 == null) goto L50;
        d r40 = r39.getTrackMeta();
        if (r40 == null) goto L50;
        Long r41 = Long.valueOf(r40.n());
    L51:
        r14 = k.h(r41);
    L50:
        r41 = null;
    L18:
        r8 = null;
        goto L19
    L20:
        r9 = 0;
        goto L28
    L21:
        AnchorV4CommentMeta r42 = this.e;
        if (r42 == null) goto L26;
        d r43 = r42.getTrackMeta();
        if (r43 == null) goto L26;
        Long r44 = Long.valueOf(r43.s());
    L27:
        r9 = k.h(r44);
    L26:
        r44 = null;
        goto L27
    L7:
        r2 = "comment_region";
        goto L10
    L8:
        r2 = "selected_comment";
        goto L10
    L9:
        r2 = "shop_comment";
        goto L10
    }

    public c(AnchorV4VM r2, AnchorV4CommentDisplay r3, AnchorV4CommentMeta r4, Context r5, com.bytedance.android.shopping.anchorv4.containers.e r6) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.b = true;
    }

    public final void h(View r19, List<String> r20, fj.d r21, VideoHolder r22, int r23) {
        GalleryViewerPlayerBlockCompat r5 = new GalleryViewerPlayerBlockCompat(this.f);
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r20.iterator();
    L3:
        Long r9 = null;
        if (r7.hasNext() == false) goto L6;
        String r8 = (String) r7.next();
        int r10 = com.bytedance.android.ec.model.k.n;
        r6.add(com.bytedance.android.ec.model.k.a.c(r8, null));
        goto L3
    L6:
        Unit r11 = Unit.INSTANCE;
        r5.a(r6, false);
        if (r21 != null) goto L9;
    L13:
        r5.setOnDismissListener(new a(this, r20, r22, r19));
        r5.setOnPageSelectedListener(new b(this, r20, r19));
        if (r21 == null) goto L18;
        int r2 = r23 - 1;
        if (r2 < 0) goto L18;
    L19:
        r5.showAnimated(r2, r19);
        AnchorV4CommentDisplay r1 = this.d;
        if (r1 == null) goto L35;
        MediaScrollBoxComponent r3 = r1.getCommentMedias();
        if (r3 == null) goto L35;
        List r4 = r3.getMedias();
        if (r4 == null) goto L35;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r4.iterator();
    L27:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        if (((MediaBoxElement) r14).getType() != Mediatype.PHOTO.getType()) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == false) goto L27;
        r12.add(r14);
        goto L27
    L31:
        r15 = false;
        goto L32
    L34:
        Integer r16 = Integer.valueOf(r12.size());
    L36:
        int r17 = k.f(r16);
        AnchorV4CommentDisplay r18 = this.d;
        if (r18 == null) goto L52;
        MediaScrollBoxComponent r24 = r18.getCommentMedias();
        if (r24 == null) goto L52;
        List r25 = r24.getMedias();
        if (r25 == null) goto L52;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L44:
        if (r27.hasNext() == false) goto L51;
        Object r28 = r27.next();
        if (((MediaBoxElement) r28).getType() != Mediatype.VIDEO.getType()) goto L48;
        boolean r29 = true;
    L49:
        if (r29 == false) goto L44;
        r26.add(r28);
        goto L44
    L48:
        r29 = false;
        goto L49
    L51:
        Integer r30 = Integer.valueOf(r26.size());
    L53:
        int r31 = k.f(r30);
        AnchorV4CommentDisplay r32 = this.d;
        if (r32 == null) goto L64;
        MediaScrollBoxComponent r33 = r32.getCommentMedias();
        if (r33 == null) goto L64;
        List r34 = r33.getMedias();
        if (r34 == null) goto L64;
        MediaBoxElement r35 = (MediaBoxElement) CollectionsKt.getOrNull(r34, r23);
        if (r35 == null) goto L64;
        if (r35.getType() != Mediatype.VIDEO.getType()) goto L64;
        String r36 = "video";
    L65:
        AnchorV4CommentMeta r37 = this.e;
        if (r37 == null) goto L70;
        d r38 = r37.getTrackMeta();
        if (r38 == null) goto L70;
        Long r39 = r38.t();
    L71:
        AnchorV4CommentMeta r40 = this.e;
        if (r40 == null) goto L76;
        d r41 = r40.getTrackMeta();
        if (r41 == null) goto L76;
        long r110 = r41.a();
    L78:
        if (r110 < 4) goto L80;
        boolean r42 = true;
    L81:
        int r111 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r112 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r112 == null) goto L105;
        Pair[] r113 = new Pair[9];
        r113[0] = TuplesKt.to("comment_module", "product_comment");
        AnchorV4CommentMeta r43 = this.e;
        if (r43 == null) goto L88;
        d r44 = r43.getTrackMeta();
        if (r44 == null) goto L88;
        r9 = Long.valueOf(r44.d());
    L88:
        r113[1] = TuplesKt.to("comment_id", r9);
        r113[2] = TuplesKt.to("comment_rank", Integer.valueOf(1 + r23));
        r113[3] = TuplesKt.to("picture_num", Integer.valueOf(r17));
        r113[4] = TuplesKt.to("video_num", Integer.valueOf(r31));
        r113[5] = TuplesKt.to("user_comment_level", r39);
        r113[6] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "comment_card");
        r113[7] = TuplesKt.to("content_type", r36);
        if (r42 == false) goto L91;
        String r45 = "1";
    L92:
        r113[8] = TuplesKt.to("show_selected_comment", r45);
        r112.c = MapsKt.mapOf(r113);
        AnchorV4TrackerImpl.b(r112, "comment_content_click", false, null, false, null, 30);
        return;
    L91:
        r45 = "0";
        goto L92
    L105:
        return;
    L80:
        r42 = false;
    L76:
        r110 = 0;
    L70:
        r39 = null;
    L64:
        r36 = "photo";
    L52:
        r30 = null;
    L35:
        r16 = null;
    L18:
        r2 = r23;
        goto L19
    L9:
        if ((r22 instanceof ee3.c) == true) goto L11;
        VideoHolder r46 = null;
    L12:
        r5.b(r46);
        goto L13
    L11:
        r46 = r22;
        goto L12
    }
}
