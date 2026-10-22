package com.bytedance.android.shopping.commentv3.uitree.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.commentv3.base.BaseCommentUI;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.CommentAdapter;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.OffsetLayoutManager;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.CommentMediaViewHolder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/CommentListUI;", "Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/b;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/a;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/e;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListUI extends BaseCommentUI<b, com.bytedance.android.shopping.commentv3.uitree.list.a> implements e {
    public static final /* synthetic */ int o = 0;
    public RecyclerView i;
    public ImageView j;
    public CommentAdapter k;
    public final c l;
    public final Lazy m;
    public final int n;

    public static final class a<T> implements Observer {
        public final /* synthetic */ CommentListUI a;

        public a(CommentListUI r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            b r6 = (b) r5;
            if (r6 != null) goto L6;
            return;
        L6:
            if (r6.a.d != FetchFrom.INIT) goto L14;
            ImageView r0 = this.a.j;
            if (r0 == null) goto L14;
            if (r0.getVisibility() != 0) goto L14;
            ImageView r1 = this.a.j;
            if (r1 == null) goto L14;
            r1.setVisibility(8);
        L14:
            CommentListUI r2 = this.a;
            int r3 = CommentListUI.o;
            com.bytedance.android.shopping.commentv3.data.b r4 = r2.e;
            if (r4 != null) goto L17;
        L19:
            boolean r7 = false;
        L20:
            com.bytedance.android.shopping.commentv3.data.b r8 = this.a.e;
            if (r8 != null) goto L23;
        L28:
            CommentAdapter r9 = this.a.k;
            if (r9 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L31:
            lc3.b r10 = r6.a;
            r9.B2(r10.a, r7, r10.d);
        L33:
            if (r6.a.c == false) goto L38;
            RecyclerView r11 = this.a.i;
            if (r11 == null) goto L39;
            r11.post(new d(this));
            return;
        L39:
            return;
        L38:
            return;
        L23:
            if (r8.c() != true) goto L28;
            CommentAdapter r12 = this.a.k;
            if (r12 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L27:
            lc3.b r13 = r6.a;
            r12.B2(r13.b, r7, r13.d);
            goto L33
        L17:
            if (r4.b() != true) goto L19;
            r7 = true;
            goto L20
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.e
    public final void c() {
        RecyclerView r0 = this.i;
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof LinearLayoutManager) == false) goto L10;
        r1 = r2;
    L10:
        LinearLayoutManager r3 = (LinearLayoutManager) r1;
        if (r3 == null) goto L14;
        r3.scrollToPositionWithOffset(0, 0);
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final com.bytedance.android.shopping.commentv3.base.b o() {
        return new b(new lc3.b(null, null, 15));
    }

    public CommentListUI() {
        this.l = new c(this);
        this.m = LazyKt.lazy(CommentListUI$commentScrollListeners$2.INSTANCE);
        this.n = 10;
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI, com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onCreate() {
        super.onCreate();
        View r0 = this.c;
        Drawable r1 = null;
        if (r0 == null) goto L5;
        RecyclerView r2 = (RecyclerView) r0.findViewById(2131367387);
    L7:
        if ((r2 instanceof RecyclerView) == true) goto L9;
        r2 = null;
    L9:
        this.i = r2;
        View r3 = this.c;
        if (r3 == null) goto L12;
        ImageView r4 = (ImageView) r3.findViewById(2131367385);
    L14:
        if ((r4 instanceof ImageView) == true) goto L16;
        r4 = null;
    L16:
        this.j = r4;
        Context r5 = getContext();
        if (r5 == null) goto L49;
        int r6 = k1.m(getContext());
        if (r6 < 0) goto L49;
        com.bytedance.android.shopping.commentv3.data.b r7 = this.e;
        if (r7 == null) goto L27;
        boolean r8 = true;
        if (r7.c() != true) goto L27;
    L28:
        if (r8 == false) goto L30;
        int r9 = 2131234336;
    L31:
        int r10 = g1.a;
        Drawable r11 = g1.a.b(r5, r9);
        if ((r11 instanceof BitmapDrawable) == false) goto L35;
        r1 = r11;
    L35:
        BitmapDrawable r12 = (BitmapDrawable) r1;
        if (r12 == null) goto L49;
        Bitmap r13 = r12.getBitmap();
        if (r13 == null) goto L49;
        ImageView r14 = this.j;
        if (r14 == null) goto L44;
        r14.setImageBitmap(r13);
    L44:
        if (r13.getWidth() <= 0) goto L49;
        float r15 = r6 / r13.getWidth();
        ImageView r16 = this.j;
        if (r16 == null) goto L49;
        Matrix r17 = new Matrix();
        r17.setScale(r15, r15);
        Unit r18 = Unit.INSTANCE;
        r16.setImageMatrix(r17);
        goto L49
    L30:
        r9 = 2131234335;
    L27:
        r8 = false;
    L49:
        final RecyclerView r19 = this.i;
        if (r19 == null) goto L56;
        r19.setLayoutManager(new OffsetLayoutManager(r19, r19.getContext()));
        if (o53.b.a() == false) goto L54;
        jh.b.a r20 = jh.b.c;
        MonitorScenes r21 = MonitorScenes.EC_PRODUCT_COMMENT_PAGE;
        r20.getClass();
        jh.b.a.d(r21).c(r19);
    L55:
        final CommentAdapter r22 = new CommentAdapter(this.g, r19);
        r22.y2();
        r22.r = new CommentListUI$onCreate$$inlined$let$lambda$1(r22, this);
        r22.h = l(44);
        int r23 = l(12);
        int r24 = l(12);
        r22.j = 0;
        r22.l = r23;
        r22.k = 0;
        r22.i = r24;
        Unit r25 = Unit.INSTANCE;
        this.k = r22;
        r19.setAdapter(r22);
        r19.addOnScrollListener(new CommentListUI$onCreate$$inlined$let$lambda$2(r19, this));
        goto L56
    L54:
        jh.b.a r26 = jh.b.c;
        MonitorScenes r27 = MonitorScenes.EC_SHOP_COMMENT_PAGE;
        r26.getClass();
        jh.b.a.d(r27).c(r19);
    L56:
        this.b.observe(this, new a(this));
        ECLiveHybridUtil.m("nps_data_sync", this.l);
        return;
    L12:
        r4 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onDestroy() {
        super.onDestroy();
        List<CommentMediaViewHolder> r0 = CommentMediaViewHolder.j;
        CommentMediaViewHolder.a.a(true);
        ECLiveHybridUtil.p("nps_data_sync", this.l);
        if (o53.b.a() == false) goto L5;
        jh.b.a r1 = jh.b.c;
        String r2 = MonitorScenes.EC_PRODUCT_COMMENT_PAGE.getSceneName();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "sceneName");
        jh.b.b.remove(r2);
        return;
    L5:
        jh.b.a r3 = jh.b.c;
        String r4 = MonitorScenes.EC_SHOP_COMMENT_PAGE.getSceneName();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "sceneName");
        jh.b.b.remove(r4);
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.e
    public final void a(com.bytedance.android.shopping.commentv3.uitree.p000float.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((List) this.m.getValue()).add(r2);
    }
}
