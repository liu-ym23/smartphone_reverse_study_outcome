package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import cc3.l;
import cc3.m;
import cc3.n;
import com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog;
import com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.Direction;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.model.response.PromotionProductCommentAppendDTO;
import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.commentgallery.view.newcommentgallery.NewCommentGalleryAdapter;
import com.bytedance.android.shopping.commentgallery.view.newcommentgallery.NewCommentGalleryIndicator;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter;
import com.bytedance.android.shopping.gallery2.newgallery.NewGalleryViewer;
import com.bytedance.android.shopping.utils.f;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ic3.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p53.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/CommentGalleryDialog;", "Lcom/bytedance/android/shopping/gallery2/newgallery/NewGalleryViewer;", "", "onPause", "onResume", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGalleryDialog extends NewGalleryViewer {
    public static final /* synthetic */ int w = 0;
    public final NewCommentGalleryIndicator q;
    public Function0<Unit> r;
    public final HashSet<Integer> s;
    public int t;
    public boolean u;
    public final com.bytedance.android.shopping.commentv3.data.b v;

    public static final class a<T> implements Observer {
        public final /* synthetic */ CommentGalleryDialog a;

        public a(CommentGalleryDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            lc3.a r5 = (lc3.a) r4;
            if (r5 == null) goto L12;
            ArrayList r0 = new ArrayList();
            Iterator<T> r1 = r5.a.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            r0.add((CommentNodeVO) r1.next());
            goto L7
        L9:
            this.a.i(r0, r5.b);
            return;
        }
    }

    public static final class b implements n {
        public final /* synthetic */ CommentGalleryDialog a;

        @Override // cc3.n
        public final void a() {
            NewCommentGalleryIndicator r0 = this.a.q;
            r0.e.setVisibility(8);
            r0.f.setVisibility(8);
            r0.d.setVisibility(8);
            r0.g.setVisibility(8);
            r0.h.setVisibility(8);
        }

        @Override // cc3.n
        public final void b() {
            NewCommentGalleryIndicator r0 = this.a.q;
            r0.e.setVisibility(0);
            r0.f.setVisibility(0);
            r0.d.setVisibility(0);
            r0.g.setVisibility(0);
            r0.h.setVisibility(0);
        }

        public b(CommentGalleryDialog r1) {
            this.a = r1;
        }
    }

    public static final class c implements sh.b {
        public final /* synthetic */ CommentGalleryDialog a;

        public c(CommentGalleryDialog r1) {
            this.a = r1;
        }

        public final void a(Direction r9) {
            Intrinsics.checkNotNullParameter(r9, "direction");
            int r0 = e.a;
            e.a.a(this.a.v.b, EventName.STATE.getEvent(), EntranceType.LIST_IMAGE_PREVIEW_SCROLL.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scroll_direction", r9.getValue())}), null, null, 240);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L17:
        DialogLancet.afterDialogDismiss(this);
    L18:
        int r2 = 0;
        if (this.u == false) goto L24;
        this.u = false;
        gc3.a r1 = this.v.d;
        if (r1 == null) goto L24;
        r1.c = RangesKt.coerceAtLeast(r1.c - 1, 0);
        r1.b();
    L24:
        f.b = false;
        Iterator<Integer> r3 = this.s.iterator();
        int r10 = 1;
    L26:
        if (r3.hasNext() == false) goto L30;
        int r4 = Math.abs(r3.next().intValue() - this.t) + 1;
        if (r4 <= r10) goto L26;
        r10 = r4;
        goto L26
    L30:
        cc3.c r5 = this.q.getCurCommentGalleryModel();
        if (r5 == null) goto L100;
        lc3.a r6 = (lc3.a) this.v.h.m.getValue();
        if (r6 == null) goto L36;
        Iterable r7 = r6.a;
        if (r7 == null) goto L36;
    L37:
        Iterator r8 = r7.iterator();
        int r9 = 0;
        int r11 = 0;
    L39:
        if (r8.hasNext() == false) goto L47;
        Object r12 = r8.next();
        int r13 = r9 + 1;
        if (r9 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        if (((CommentNodeVO) r12).getId() != r5.c.getId()) goto L46;
        r11 = r9;
    L46:
        r9 = r13;
        goto L39
    L47:
        t53.b r14 = t53.b.a;
        if (r5.a.getType() != 8) goto L50;
        int r15 = 1;
    L51:
        int r16 = r11 + 1;
        CommentNodeVO r17 = r5.c;
        String r18 = "pic";
        if (this.v.c() == false) goto L54;
        String r19 = "pic";
    L55:
        Context r20 = getContext();
        r14.getClass();
        t53.b.e(r15, r16, r10, r17, r19, r20);
        int r21 = e.a;
        fc3.a r22 = this.v.b;
        String r110 = EventName.CLICK.getEvent();
        String r111 = EntranceType.LIST_IMAGE_PREVIEW_EXIT.getType();
        Pair[] r23 = new Pair[8];
        r23[0] = TuplesKt.to("comment_id", Long.valueOf(r5.c.getId()));
        if (r5.a.getType() != 8) goto L58;
        String r24 = "video";
    L59:
        r23[1] = TuplesKt.to("content_type", r24);
        r23[2] = TuplesKt.to("comment_rank", Integer.valueOf(r16));
        if (this.v.c() == true) goto L63;
        r18 = "list";
    L63:
        r23[3] = TuplesKt.to("comment_switch_type", r18);
        r23[4] = TuplesKt.to("show_num", Integer.valueOf(r10));
        List r25 = r5.c.getVideoInfo();
        if (r25 == null) goto L66;
        int r26 = r25.size();
    L67:
        r23[5] = TuplesKt.to("video_num", Integer.valueOf(r26));
        List r27 = r5.c.getImagesInfos();
        if (r27 == null) goto L70;
        r2 = r27.size();
    L70:
        r23[6] = TuplesKt.to("picture_num", Integer.valueOf(r2));
        r23[7] = TuplesKt.to("content_rank", Integer.valueOf(r16));
        Map r28 = MapsKt.mutableMapOf(r23);
        List r29 = r5.c.getTagsInfo();
        if (r29 == null) goto L82;
        Iterator r30 = r29.iterator();
    L74:
        if (r30.hasNext() == false) goto L78;
        Object r31 = r30.next();
        if (Intrinsics.areEqual(((i) r31).a, "2") == false) goto L74;
    L79:
        i r32 = (i) r31;
        if (r32 == null) goto L82;
        r28.put("user_comment_level", String.valueOf(r32.b));
        goto L82
    L78:
        r31 = null;
    L82:
        Unit r33 = Unit.INSTANCE;
        e.a.a(r22, r110, r111, r28, null, null, 240);
        return;
    L66:
        r26 = 0;
        goto L67
    L58:
        r24 = "picture";
        goto L59
    L54:
        r19 = "list";
        goto L55
    L50:
        r15 = 2;
    L36:
        r7 = new ArrayList();
        goto L37
    L100:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r34 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r34 == null) goto L17;
        com.bytedance.crash.d.d(r34, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L17
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        NewGalleryAdapter r0 = this.o;
        m r2 = null;
        if ((r0 instanceof NewCommentGalleryAdapter) == true) goto L8;
        r0 = null;
    L8:
        NewCommentGalleryAdapter r1 = (NewCommentGalleryAdapter) r0;
        if (r1 == null) goto L21;
        int r3 = r1.h;
        if (r3 < 0) goto L18;
        m r4 = r1.e.get(r3);
        if ((r4 instanceof m) == false) goto L17;
        r2 = r4;
    L17:
        r2 = r2;
    L18:
        if (r2 == null) goto L22;
        r2.k0();
        return;
    L22:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        NewGalleryAdapter r0 = this.o;
        m r2 = null;
        if ((r0 instanceof NewCommentGalleryAdapter) == true) goto L8;
        r0 = null;
    L8:
        NewCommentGalleryAdapter r1 = (NewCommentGalleryAdapter) r0;
        if (r1 == null) goto L21;
        int r3 = r1.h;
        if (r3 < 0) goto L18;
        m r4 = r1.e.get(r3);
        if ((r4 instanceof m) == false) goto L17;
        r2 = r4;
    L17:
        r2 = r2;
    L18:
        if (r2 == null) goto L22;
        r2.Q3();
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryViewer
    public final void c(int r1) {
        super.c(r1);
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryViewer
    public final void onPageSelected(int r4) {
        super.onPageSelected(r4);
        this.s.add(Integer.valueOf(r4));
        NewGalleryAdapter r0 = this.o;
        l r2 = null;
        if ((r0 instanceof NewCommentGalleryAdapter) == true) goto L5;
        r0 = null;
    L5:
        NewCommentGalleryAdapter r1 = (NewCommentGalleryAdapter) r0;
        if (r1 == null) goto L18;
        r1.h = r4;
        l r3 = (TransitionViewHolder) r1.e.get(r4);
        if (r3 != null) goto L11;
        r1.f = r4;
        return;
    L11:
        if ((r3 instanceof l) == false) goto L14;
        r2 = r3;
    L14:
        l r5 = r2;
        if (r5 == null) goto L20;
        r5.onPageSelected(r4);
        return;
    L20:
        return;
    }

    public final List<cc3.c> i(List<CommentNodeVO> r26, FetchFrom r27) {
        CommentGalleryDialog r12 = this;
        Intrinsics.checkNotNullParameter(r26, "comments");
        Intrinsics.checkNotNullParameter(r27, "from");
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        if (r12.v.c() == false) goto L5;
        String r1 = "pic";
    L6:
        String r16 = r1;
        Iterator<T> r17 = r26.iterator();
        int r0 = 0;
    L8:
        if (r17.hasNext() == false) goto L75;
        Object r2 = r17.next();
        int r18 = r0 + 1;
        if (r0 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        CommentNodeVO r10 = (CommentNodeVO) r2;
        List r3 = r10.getVideoInfo();
        if (r3 == null) goto L25;
        Iterator r20 = r3.iterator();
        int r8 = 0;
    L16:
        if (r20.hasNext() == false) goto L25;
        Object r4 = r20.next();
        int r21 = r8 + 1;
        if (r8 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        PromotionVideoInfo r5 = (PromotionVideoInfo) r4;
        String r6 = r5.getMainUrl();
        String r7 = r5.getBackupUrl();
        String r9 = r5.getVideoId();
        String r11 = r5.getPosterUrl();
        Integer r13 = Integer.valueOf((int) r5.getWidth());
        Integer r19 = Integer.valueOf((int) r5.getHeight());
        List r22 = r10.getVideoInfoV2();
        if (r22 == null) goto L23;
        ECCommentVideo r23 = (ECCommentVideo) CollectionsKt.getOrNull(r22, r8);
    L24:
        CommentNodeVO r28 = r10;
        ee3.b r24 = h(this, r6, r7, r9, r11, r13, r19, r18, r8, r16, r10, r23);
        r14.add(r24);
        r15.add(new cc3.c(r24, false, r28));
        r10 = r28;
        r8 = r21;
        goto L16
    L23:
        r23 = null;
    L25:
        CommentNodeVO r110 = r10;
        List r25 = r110.getImagesInfos();
        if (r25 == null) goto L34;
        Iterator r29 = r25.iterator();
        int r30 = 0;
    L29:
        if (r29.hasNext() == false) goto L34;
        Object r31 = r29.next();
        int r111 = r30 + 1;
        if (r30 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        PromotionProductCommentPhotoDTO r32 = (PromotionProductCommentPhotoDTO) r31;
        ee3.a r33 = g(Integer.valueOf(r32.getWidth()), Integer.valueOf(r32.getHeight()), r32.getUrl(), r32.getThumbnail(), r18, r30, r16, r110);
        r14.add(r33);
        r15.add(new cc3.c(r33, false, r110));
        r30 = r111;
    L34:
        List r34 = r110.getAppendComment();
        if (r34 == null) goto L74;
        Iterator r210 = r34.iterator();
    L38:
        if (r210.hasNext() == false) goto L74;
        PromotionProductCommentAppendDTO r211 = (PromotionProductCommentAppendDTO) r210.next();
        if (r211.getVideosV2() == null) goto L51;
        List r35 = r211.getVideosV2();
        if (r35 == null) goto L50;
        Iterator r212 = r35.iterator();
        int r36 = 0;
    L45:
        if (r212.hasNext() == false) goto L50;
        Object r37 = r212.next();
        int r213 = r36 + 1;
        if (r36 >= 0) goto L49;
        CollectionsKt.throwIndexOverflow();
    L49:
        ECCommentVideo r214 = (ECCommentVideo) r37;
        CommentNodeVO r112 = r110;
        ee3.b r38 = h(this, null, null, null, null, Integer.valueOf(r214.getWidth()), Integer.valueOf(r214.getHeight()), r18, r36, r16, r110, r214);
        r14.add(r38);
        r15.add(new cc3.c(r38, true, r112));
        r110 = r112;
        r36 = r213;
    L50:
        CommentNodeVO r113 = r110;
        boolean r114 = true;
    L64:
        List r39 = r211.getPhotos();
        if (r39 == null) goto L73;
        Iterator r40 = r39.iterator();
        int r41 = 0;
    L68:
        if (r40.hasNext() == false) goto L73;
        Object r42 = r40.next();
        int r115 = r41 + 1;
        if (r41 >= 0) goto L72;
        CollectionsKt.throwIndexOverflow();
    L72:
        PromotionProductCommentPhotoDTO r43 = (PromotionProductCommentPhotoDTO) r42;
        ee3.a r44 = g(Integer.valueOf(r43.getWidth()), Integer.valueOf(r43.getHeight()), r43.getUrl(), r43.getThumbnail(), r18, r41, r16, r113);
        r14.add(r44);
        r15.add(new cc3.c(r44, r114, r113));
        r41 = r115;
    L73:
        r110 = r113;
        goto L38
    L51:
        r113 = r110;
        r114 = true;
        List r45 = r211.getVideos();
        if (r45 == null) goto L64;
        Iterator r215 = r45.iterator();
        int r46 = 0;
    L55:
        if (r215.hasNext() == false) goto L64;
        Object r47 = r215.next();
        int r216 = r46 + 1;
        if (r46 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        PromotionVideoInfo r48 = (PromotionVideoInfo) r47;
        String r49 = r48.getMainUrl();
        String r50 = r48.getBackupUrl();
        String r51 = r48.getVideoId();
        String r52 = r48.getPosterUrl();
        Integer r53 = Integer.valueOf((int) r48.getWidth());
        Integer r54 = Integer.valueOf((int) r48.getHeight());
        List r55 = r211.getVideosV2();
        if (r55 == null) goto L62;
        ECCommentVideo r116 = (ECCommentVideo) CollectionsKt.getOrNull(r55, r46);
    L63:
        ee3.b r56 = h(this, r49, r50, r51, r52, r53, r54, r18, r46, r16, r113, r116);
        r14.add(r56);
        r15.add(new cc3.c(r56, true, r113));
        r46 = r216;
        goto L55
    L62:
        r116 = null;
    L74:
        r12 = this;
        r0 = r18;
        goto L8
    L75:
        CommentGalleryDialog r57 = r12;
        NewCommentGalleryIndicator r58 = r57.q;
        r58.getClass();
        Intrinsics.checkNotNullParameter(r15, "commentGalleryList");
        ((ArrayList) r58.i).clear();
        ((ArrayList) r58.i).addAll(r15);
        if (r27 == FetchFrom.LIKE_CLICKED) goto L78;
        NewGalleryAdapter r59 = r57.o;
        r59.b = r14;
        r59.notifyDataSetChanged();
    L78:
        return r15;
    L5:
        r1 = "list";
        goto L6
    }

    public CommentGalleryDialog(final Context r7, LifecycleOwner r8, com.bytedance.android.shopping.commentv3.data.b r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        super(r7, new NewCommentGalleryAdapter());
        this.v = r9;
        NewGalleryAdapter r1 = null;
        boolean r3 = false;
        NewCommentGalleryIndicator r0 = new NewCommentGalleryIndicator(r7, null, 6, 0);
        this.q = r0;
        this.s = new HashSet();
        b(r0);
        View r2 = this.n;
        Intrinsics.checkNotNullParameter(r2, "indicatorView");
        ((CommentPagePhotoViewerDialog) this).j.remove(r2);
        ((CommentPagePhotoViewerDialog) this).b.removeView(r2);
        r2.onDetach(((CommentPagePhotoViewerDialog) this).g, ((CommentPagePhotoViewerDialog) this).m);
        r0.setLoadMoreListener(new AnonymousClass1(this));
        r0.setBackListener(new AnonymousClass2(this));
        r0.setSwitchModeListener(new AnonymousClass3(this, r7));
        r0.setDiggCommentListener(new AnonymousClass4(this));
        a r10 = new a(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "owner");
        Intrinsics.checkNotNullParameter(r10, "observer");
        CommentDataCenter r4 = r9.h;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "owner");
        Intrinsics.checkNotNullParameter(r10, "observer");
        r4.m.observe(r8, r10);
        List<?> r11 = r9.h.c();
        if (r11 == null) goto L15;
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        Object r5 = r12.next();
        if ((r5 instanceof Map) == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L6;
    L16:
        if (r5 == null) goto L18;
        r3 = true;
    L18:
        if (r3 == true) goto L20;
        this.q.c.setVisibility(8);
    L20:
        NewGalleryAdapter r13 = this.o;
        if ((r13 instanceof NewCommentGalleryAdapter) == false) goto L24;
        r1 = r13;
    L24:
        NewCommentGalleryAdapter r14 = (NewCommentGalleryAdapter) r1;
        if (r14 == null) goto L27;
        b r15 = new b(this);
        Intrinsics.checkNotNullParameter(r15, "listener");
        r14.g = r15;
    L27:
        r8.getLifecycle().addObserver(this);
        ((ArrayList) ((CommentPagePhotoViewerDialog) this).e).add(new c(this));
        this.q.setExpandBtnClickListener(new AnonymousClass8(this));
        return;
    L10:
        if (Intrinsics.areEqual(((Map) r5).get("name"), "图/视频") == false) goto L12;
        r6 = true;
    L15:
        r5 = null;
        goto L16
    }

    public static ee3.a g(Integer r8, Integer r9, String r10, String r11, int r12, int r13, String r14, CommentNodeVO r15) {
        ee3.a r0 = new ee3.a();
        r0.p = 7;
        ((k) r0).g = r8;
        ((k) r0).h = r9;
        ((k) r0).b = r10;
        ((k) r0).c = r11;
        r0.o = ac3.b.a(r15, 2, r13, r12, r14, r15);
        return r0;
    }

    public static ee3.b h(CommentGalleryDialog r2, String r3, String r4, String r5, String r6, Integer r7, Integer r8, int r9, int r10, String r11, CommentNodeVO r12, ECCommentVideo r13) {
        r2.getClass();
        ee3.b r0 = new ee3.b();
        r0.p = 8;
        ((k) r0).b = r3;
        ((k) r0).d = r4;
        ((k) r0).e = r5;
        ((k) r0).f = r6;
        ((k) r0).g = r7;
        ((k) r0).h = r8;
        ((k) r0).l = null;
        r0.o = ac3.b.a(r12, 1, r10, r9, r11, r12);
        r0.q = r13;
        return r0;
    }
}
