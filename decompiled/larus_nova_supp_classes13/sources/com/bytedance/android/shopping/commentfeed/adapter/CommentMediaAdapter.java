package com.bytedance.android.shopping.commentfeed.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import bc3.a;
import bc3.b;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.DoubleColorBallStatusView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.ec.model.video.UrlModel;
import com.bytedance.android.ec.sdk.helper.c;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.api.video.d;
import com.bytedance.android.shopping.api.video.k;
import com.bytedance.android.shopping.api.video.m;
import com.bytedance.android.shopping.commentfeed.HorizontalRecyclerView;
import com.bytedance.android.shopping.commentfeed.view.CommentItemFragment;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentImageVH;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentVideoVH;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentVideoVHNew;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zb3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/adapter/CommentMediaAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentBaseViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentMediaAdapter extends RecyclerView.Adapter<CommentBaseViewHolder> {
    public final List<e> a;
    public int b;
    public final SparseArray<CommentBaseViewHolder> c;
    public final CommentItemFragment d;
    public final RecyclerView e;
    public final bc3.e f;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final int getItemViewType(int r2) {
        return ((e) ListProtector.get(this.a, r2)).getType();
    }

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
    public final void onBindViewHolder(RecyclerView.ViewHolder r33, int r34) {
        CommentBaseViewHolder r2 = (CommentBaseViewHolder) r33;
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.c.put(r34, r2);
        if ((r2 instanceof CommentImageVH) == true) goto L5;
        CommentBaseViewHolder r3 = null;
    L6:
        CommentImageVH r4 = (CommentImageVH) r3;
        if (r4 == null) goto L42;
        PromotionProductCommentPhotoDTO r9 = ((e) ListProtector.get(this.a, r34)).b();
        if (r9 == null) goto L41;
        r4.c.setVisibility(4);
        r4.d.a();
        DoubleColorBallStatusView r10 = r4.d;
        r10.setVisibility(0);
        r10.setECStatus(0);
        ViewGroup.LayoutParams r11 = r4.c.getLayoutParams();
        if (r9.getWidth() <= 0) goto L33;
        if (r9.getHeight() <= 0) goto L33;
        if (((r9.getHeight() * 1.0f) / r9.getWidth()) < 1.9573333f) goto L25;
        if ((r11 instanceof FrameLayout.LayoutParams) == true) goto L19;
        ViewGroup.LayoutParams r12 = null;
    L20:
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        if (r13 == null) goto L23;
        r13.gravity = 48;
    L23:
        r4.b.post(new a(r11, r4));
    L40:
        r4.c.setVisibility(0);
        r4.c.setLayoutParams(r11);
        y.d(r4.c, r9.getUrl());
        r4.c.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r9.getUrl())).setControllerListener(r4.e).build());
        goto L42
    L19:
        r12 = r11;
        goto L20
    L25:
        if ((r11 instanceof FrameLayout.LayoutParams) == true) goto L27;
        ViewGroup.LayoutParams r14 = null;
    L28:
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        if (r15 == null) goto L31;
        r15.gravity = 16;
    L31:
        r11.height = (int) (((k1.m(r4.a.getContext()) * 1.0f) * r9.getHeight()) / r9.getWidth());
        goto L40
    L27:
        r14 = r11;
    L33:
        if ((r11 instanceof FrameLayout.LayoutParams) == true) goto L35;
        ViewGroup.LayoutParams r16 = null;
    L36:
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
        if (r17 == null) goto L39;
        r17.gravity = 16;
    L39:
        r11.height = k1.m(r4.a.getContext());
        goto L40
    L35:
        r16 = r11;
        goto L36
    L41:
        r4.c.setVisibility(8);
        r4.d.a();
        Unit r5 = Unit.INSTANCE;
    L42:
        int r6 = r34 + 1;
        if (r6 >= ((ArrayList) this.a).size()) goto L50;
        PromotionProductCommentPhotoDTO r7 = ((e) ListProtector.get(this.a, r6)).b();
        if (r7 == null) goto L47;
        String r8 = r7.getUrl();
    L48:
        if (r8 == null) goto L50;
        ECUrlModel r18 = new ECUrlModel();
        ArrayList r19 = new ArrayList();
        r19.add(r8);
        Unit r20 = Unit.INSTANCE;
        r18.setUrlList(r19);
        y.n(r18, new wb3.a());
        goto L50
    L47:
        r8 = null;
    L50:
        boolean r21 = r2 instanceof CommentVideoVHNew;
        if (r21 == false) goto L148;
        if (r21 == true) goto L54;
        CommentBaseViewHolder r22 = null;
    L55:
        CommentVideoVHNew r23 = (CommentVideoVHNew) r22;
        if (r23 == null) goto L148;
        CommentItemFragment r110 = this.d;
        PromotionVideoInfo r111 = ((e) ListProtector.get(this.a, r34)).d();
        ECCommentVideo r112 = ((e) ListProtector.get(this.a, r34)).e();
        if (((ArrayList) this.a).size() == 1) goto L60;
    L62:
        boolean r113 = false;
    L63:
        Intrinsics.checkNotNullParameter(r110, "fragment");
        r23.j = r111;
        r23.l = r34;
        r23.k = r113;
        if (r112 == null) goto L66;
        Integer r114 = Integer.valueOf(r112.getHeight());
    L69:
        if (r114 == null) goto L71;
        int r115 = r114.intValue();
    L72:
        if (r112 == null) goto L74;
        Integer r24 = Integer.valueOf(r112.getWidth());
        Object r116 = "fragment";
    L78:
        if (r24 == null) goto L80;
        int r25 = r24.intValue();
    L81:
        ViewGroup.LayoutParams r117 = r23.e.getLayoutParams();
        d r26 = new d(false, true, 0, 0, false, 509);
        if (r112 == null) goto L104;
        ECUrlModel r118 = new ECUrlModel();
        UrlModel r119 = r112.getCover();
        if (r119 == null) goto L86;
        String r27 = r119.getUri();
    L87:
        r118.setUri(r27);
        UrlModel r28 = r112.getCover();
        if (r28 == null) goto L90;
        List r29 = r28.getUrlList();
    L91:
        r118.setUrlList(r29);
        r118.setWidth(r115);
        r118.setHeight(r25);
        UrlModel r30 = r112.getCover();
        if (r30 == null) goto L94;
        String r31 = r30.getUrlKey();
    L95:
        r118.setUrlKey(r31);
        UrlModel r32 = r112.getCover();
        if (r32 == null) goto L98;
        long r120 = r32.getSize();
    L99:
        r118.setSize(r120);
        UrlModel r35 = r112.getCover();
        if (r35 == null) goto L102;
        String r36 = r35.getFileHash();
    L103:
        r118.setFileHash(r36);
        r23.X3(null, r118);
        com.bytedance.android.shopping.api.video.e r37 = m.b(r112, r26);
        int r38 = r25;
        int r39 = r115;
    L114:
        if (r37 == null) goto L117;
        c.a.b(r23.b, "bind, VideoModel build success: " + r37);
        r23.d.w(ScaleType.CENTER_CROP);
        r23.d.b(r37);
    L117:
        if (((r39 * 1.0f) / r38) <= 1.9573333f) goto L131;
        ViewGroup.LayoutParams r40 = r23.d.getLayoutParams();
        if ((r40 instanceof ViewGroup.MarginLayoutParams) == true) goto L121;
        r40 = null;
    L121:
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) r40;
        if (r41 == null) goto L125;
        r41.bottomMargin = CommentVideoVHNew.o;
    L125:
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == true) goto L127;
        r117 = null;
    L127:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r117;
        if (r121 == null) goto L130;
        r121.bottomMargin = CommentVideoVHNew.o;
    L130:
        int r42 = 0;
    L144:
        if (r23.k == false) goto L146;
        r23.g.setVisibility(r42);
        r23.g.setProgress(r42);
        r23.g.post(new b(r23));
    L147:
        bc3.c r43 = new bc3.c(r23, r110);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r43, "listener");
        ((ArrayList) r110.m).add(r43);
    L150:
        boolean r44 = r2 instanceof CommentVideoVH;
        if (r44 == false) goto L168;
        if (r44 == true) goto L154;
        r2 = null;
    L154:
        CommentVideoVH r45 = (CommentVideoVH) r2;
        if (r45 == null) goto L169;
        CommentItemFragment r46 = this.d;
        PromotionVideoInfo r1 = ((e) ListProtector.get(this.a, r34)).d();
        if (((ArrayList) this.a).size() == 1) goto L159;
    L161:
        boolean r47 = false;
    L162:
        Intrinsics.checkNotNullParameter(r46, r116);
        r45.b = r1;
        r45.c = r47;
        if (r1 != null) goto L167;
        if (r47 == false) goto L166;
        throw null;
    L166:
        throw null;
    L167:
        throw null;
    L159:
        if (this.b != 1) goto L161;
        r47 = true;
        goto L162
    L169:
        return;
    L168:
        return;
    L146:
        r23.h.setVisibility(8);
        r23.g.setVisibility(8);
        goto L147
    L131:
        ViewGroup.LayoutParams r48 = r23.d.getLayoutParams();
        if ((r48 instanceof ViewGroup.MarginLayoutParams) == true) goto L134;
        r48 = null;
    L134:
        ViewGroup.MarginLayoutParams r49 = (ViewGroup.MarginLayoutParams) r48;
        r42 = 0;
        if (r49 == null) goto L138;
        r49.bottomMargin = 0;
    L138:
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == true) goto L140;
        r117 = null;
    L140:
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r117;
        if (r122 == null) goto L144;
        r122.bottomMargin = 0;
        goto L144
    L102:
        r36 = null;
        goto L103
    L98:
        r120 = 0;
        goto L99
    L94:
        r31 = null;
        goto L95
    L90:
        r29 = null;
        goto L91
    L86:
        r27 = null;
        goto L87
    L104:
        if (r111 == null) goto L112;
        r23.X3(r111.getPosterUrl(), null);
        k r50 = new k();
        String r51 = r111.getVideoId();
        Intrinsics.checkNotNullParameter(r51, "videoKey");
        r50.a = r51;
        String r52 = r111.getVideoId();
        Intrinsics.checkNotNullParameter(r52, "key");
        r50.b = r52;
        r50.a(r111.getMainUrl());
        r50.a(r111.getBackupUrl());
        r38 = r25;
        r50.e = r111.getHeight() * r111.getWidth();
        r50.f = r111.getDuration();
        com.bytedance.android.shopping.api.video.b r53 = r50.b();
        if (r53 == null) goto L150;
        String r54 = r111.getVideoId();
        Intrinsics.checkNotNullParameter(r54, "newVid");
        Intrinsics.checkNotNullParameter(r26, "options");
        r39 = r115;
        int r123 = (int) r111.getHeight();
        int r124 = (int) r111.getWidth();
        Intrinsics.checkNotNullParameter(r53, "playItem");
        ArrayList r125 = new ArrayList();
        r125.add(r53);
        if (r54 == null) goto L111;
        r37 = new com.bytedance.android.shopping.api.video.e(r54, 0, null, r125, null, r26, -1, 0.0f, null, r123, r124, null, null);
        goto L114
    L111:
        Objects.toString(r125);
    L113:
        r37 = null;
        goto L114
    L112:
        r38 = r25;
        r39 = r115;
        goto L113
    L80:
        r25 = 0;
        goto L81
    L74:
        r116 = "fragment";
        if (r111 == null) goto L77;
        r24 = Integer.valueOf((int) r111.getWidth());
        goto L78
    L77:
        r24 = null;
        goto L78
    L71:
        r115 = 0;
        goto L72
    L66:
        if (r111 == null) goto L68;
        r114 = Integer.valueOf((int) r111.getHeight());
        goto L69
    L68:
        r114 = null;
        goto L69
    L60:
        if (this.b != 1) goto L62;
        r113 = true;
        goto L63
    L54:
        r22 = r2;
    L148:
        r116 = "fragment";
        goto L150
    L5:
        r3 = r2;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 1) goto L6;
        return new CommentVideoVHNew(th.a.c(r3.getContext(), 2131560544, r3, false), this.f);
    L6:
        return new CommentImageVH(LayoutInflater.from(r3.getContext()).inflate(2131560539, r3, false));
    }

    public CommentMediaAdapter(CommentItemFragment r2, HorizontalRecyclerView r3, CommentItemFragment.c r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new ArrayList();
        this.c = new SparseArray();
    }
}
