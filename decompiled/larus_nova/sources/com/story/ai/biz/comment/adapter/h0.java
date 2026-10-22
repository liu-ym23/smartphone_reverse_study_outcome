package com.story.ai.biz.comment.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.ExpandableTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.model.comment.CommentContent;
import com.larus.platform.model.comment.CommentInfo;
import com.larus.platform.model.comment.LikeInfo;
import com.larus.platform.model.comment.UserInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.story.ai.biz.comment.CommentComponent;
import com.story.ai.biz.comment.model.CommentListItem;
import com.story.ai.biz.comment.model.CommentPublishState;
import com.story.ai.biz.comment.model.CommentSection;
import com.story.ai.biz.comment.view.CommentLikeView;
import com.story.ai.biz.comment.viewmodel.CommentViewModel;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes38.dex */
public final class h0 extends dnc.a<CommentSection> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f459813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f459814e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentViewModel f459815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f459816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f459817c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f459818a = null;

        static {
            int[] r100 = new int[CommentPublishState.values().length];
            r100[CommentPublishState.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommentPublishState.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f459818a = r100;
        }
    }

    @Override // dnc.a
    public final int c() {
        return R.layout.larus_comment_list_item_layout;
    }

    static {
        int r100 = m0.f375450a;
        f459814e = m0.b(AppHost.f326268a.getApplication().getApplicationContext()) - i5.i();
    }

    @Override // dnc.a
    public final int b() {
        return CommentSection.CommentItemType.PARENT_COMMENT.ordinal();
    }

    public h0(CommentViewModel r100, CommentComponent.b r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f459815a = r100;
        this.f459816b = r101;
        this.f459817c = new b0();
    }

    public final void e(RecyclerView.ViewHolder r100, CommentListItem r101) {
        TextView r102 = (TextView) dnc.b.a(r100, R.id.tv_name);
        ArrayList r103 = new ArrayList();
        Context r104 = r102.getContext();
        if (r101.isCreator() == false) goto L6;
        int r105 = jnc.b.f499798a;
        Intrinsics.checkNotNull(r104);
        r103.add(jnc.b.b(r104));
    L6:
        if (r101.isSelfComment() == false) goto L8;
        int r106 = jnc.b.f499798a;
        Intrinsics.checkNotNull(r104);
        r103.add(jnc.b.c(r104));
    L8:
        CommentInfo r107 = r101.getCommentData();
        if (r107 == null) goto L13;
        UserInfo r108 = r107.h();
        if (r108 == null) goto L13;
        SpannableStringBuilder r109 = jnc.b.d(r102, r108, r103, true, new g0(this));
    L14:
        if (r109 == null) goto L17;
        ((TextView) dnc.b.a(r100, R.id.tv_name)).setMovementMethod(LinkMovementMethod.getInstance());
        r102.setText(r109);
        return;
    L17:
        return;
    L13:
        r109 = null;
        goto L14
    }

    @Override // dnc.a
    public final void a(RecyclerView.ViewHolder r110, CommentSection r210, int r211) {
        CommentSection r100 = r210;
        Intrinsics.checkNotNullParameter(r110, "holder");
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        long r101 = System.currentTimeMillis();
        String r102 = null;
        if ((r100 instanceof CommentListItem) == false) goto L6;
        CommentListItem r103 = (CommentListItem) r100;     // Catch: IllegalStateException -> L80
    L7:
        if (r103 == null) goto L86;
        e(r110, r103);     // Catch: IllegalStateException -> L80
        GenericDraweeView r104 = (GenericDraweeView) dnc.b.a(r110, R.id.img_header);     // Catch: IllegalStateException -> L80
        CommentInfo r105 = ((CommentListItem) r100).getCommentData();     // Catch: IllegalStateException -> L80
        if (r105 == null) goto L14;
        UserInfo r106 = r105.h();     // Catch: IllegalStateException -> L80
        if (r106 == null) goto L14;
        String r107 = r106.a();     // Catch: IllegalStateException -> L80
    L15:
        ImageLoaderKt.u(r104, r107, "comments_avatar");     // Catch: IllegalStateException -> L80
        final z r108 = new z(r110);     // Catch: IllegalStateException -> L80
        this.f459817c.getClass();     // Catch: IllegalStateException -> L80
        b0.a(r110, r103);     // Catch: IllegalStateException -> L80
        TextView r109 = (TextView) dnc.b.a(r110, R.id.tv_name);     // Catch: IllegalStateException -> L80
        r109.addOnAttachStateChangeListener(new i0());     // Catch: IllegalStateException -> L80
        r109.setOnTouchListener(new com.story.ai.biz.comment.view.b(new d0(this, r108)));     // Catch: IllegalStateException -> L80
        ExpandableTextView r111 = (ExpandableTextView) dnc.b.a(r110, R.id.tv_content);     // Catch: IllegalStateException -> L80
        if (r111.getCurrentState() == ((CommentListItem) r100).getTextExpandState()) goto L18;
        r111.setCurrentState(((CommentListItem) r100).getTextExpandState());     // Catch: IllegalStateException -> L80
    L18:
        r111.setOnTouchListener(new com.story.ai.biz.comment.view.b(new e0(this, r108)));     // Catch: IllegalStateException -> L80
        r111.setExpandListener(new j0(r100, this, r103, r110));     // Catch: IllegalStateException -> L80
        CommentInfo r112 = ((CommentListItem) r100).getCommentData();     // Catch: IllegalStateException -> L80
        String r113 = "";
        if (r112 == null) goto L25;
        CommentContent r114 = r112.e();     // Catch: IllegalStateException -> L80
        if (r114 == null) goto L25;
        String r115 = r114.a();     // Catch: IllegalStateException -> L80
        if (r115 == null) goto L25;
    L26:
        r111.f328458y = f459814e;     // Catch: IllegalStateException -> L80
        r111.setText(r115);     // Catch: IllegalStateException -> L80
        if (f459813d != 0) goto L29;
        int r116 = m0.f375450a;     // Catch: IllegalStateException -> L80
        int r117 = m0.b(r111.getContext());     // Catch: IllegalStateException -> L80
        f459813d = (int) (((r117 - i5.i()) / 2) - r111.getPaint().measureText(AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_load_more)));     // Catch: IllegalStateException -> L80
    L29:
        r111.setExtendRemianSpace(f459813d);     // Catch: IllegalStateException -> L80
        int r118 = b.f459818a[((CommentListItem) r100).getSendState().ordinal()];     // Catch: IllegalStateException -> L80
        if (r118 == 1) goto L41;
        if (r118 == 2) goto L40;
        CommentInfo r119 = ((CommentListItem) r100).getCommentData();     // Catch: IllegalStateException -> L80
        if (r119 == null) goto L42;
        Long r120 = r119.g();     // Catch: IllegalStateException -> L80
        if (r120 == null) goto L42;
        String r121 = jnc.i.a(r120);     // Catch: IllegalStateException -> L80
        if (r121 == null) goto L42;
        r113 = r121;
    L42:
        dnc.b.c(r110, R.id.tv_send_time, r113);     // Catch: IllegalStateException -> L80
        if (((CommentListItem) r100).getSendState() != CommentPublishState.FAIL) goto L45;
        boolean r122 = true;
    L46:
        dnc.b.d(r110, R.id.tv_send_failed_label, r122);     // Catch: IllegalStateException -> L80
        if (((CommentListItem) r100).getSendState() != CommentPublishState.SUCCESS) goto L49;
        boolean r123 = true;
    L50:
        dnc.b.d(r110, R.id.tv_reply, r123);     // Catch: IllegalStateException -> L80
        CommentLikeView r124 = (CommentLikeView) dnc.b.a(r110, R.id.view_like_wapper);     // Catch: IllegalStateException -> L80
        CommentInfo r125 = ((CommentListItem) r100).getCommentData();     // Catch: IllegalStateException -> L80
        if (r125 == null) goto L57;
        LikeInfo r126 = r125.i();     // Catch: IllegalStateException -> L80
        if (r126 == null) goto L57;
        Long r127 = r126.a();     // Catch: IllegalStateException -> L80
        if (r127 == null) goto L57;
        long r128 = r127.longValue();     // Catch: IllegalStateException -> L80
    L58:
        long r129 = r128;
        CommentInfo r130 = ((CommentListItem) r100).getCommentData();     // Catch: IllegalStateException -> L80
        if (r130 == null) goto L68;
        LikeInfo r131 = r130.i();     // Catch: IllegalStateException -> L80
        if (r131 == null) goto L68;
        Integer r132 = r131.b();     // Catch: IllegalStateException -> L80
        if (r132 == null) goto L68;
        if (r132.intValue() != 1) goto L68;
        boolean r133 = true;
    L69:
        CommentInfo r134 = ((CommentListItem) r100).getCommentData();     // Catch: IllegalStateException -> L80
        if (r134 == null) goto L72;
        r102 = r134.d();     // Catch: IllegalStateException -> L80
    L72:
        String r135 = r102;
        rq9.d r136 = this.f459815a.getInitData$impl_mainlandRelease();     // Catch: IllegalStateException -> L80
        if (r136 != null) goto L75;
    L77:
        boolean r137 = false;
    L78:
        int r138 = CommentLikeView.f459948d;     // Catch: IllegalStateException -> L80
        r124.a(r135, r129, r133, r137, false);     // Catch: IllegalStateException -> L80
        ((View) dnc.b.a(r110, R.id.root)).setOnTouchListener(new f0(this, r108));     // Catch: IllegalStateException -> L80
    L82:
        long r139 = System.currentTimeMillis() - r101;
        FLogger.f375446a.d("ParentCommentItemProvider", "parent convert time:" + r139);
        return;
    L75:
        if (r136.h() != true) goto L77;
        r137 = true;
    L68:
        r133 = false;
    L57:
        r128 = 0;
        goto L58
    L49:
        r123 = false;
        goto L50
    L45:
        r122 = false;
        goto L46
    L40:
        r113 = StringsKt.replace$default(AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_botsComment_toast_comment_fail), "%s", "", false, 4, null);     // Catch: IllegalStateException -> L80
        goto L42
    L41:
        r113 = AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_botsComment_toast_comment_posting);     // Catch: IllegalStateException -> L80
    L25:
        r115 = "";
    L14:
        r107 = null;
        goto L15
    L86:
        return;
    L6:
        r103 = null;
    L80:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "ParentCommentItemProvider convert error");
        goto L82
    }
}
