package com.bytedance.android.shopping.commentv3.uitree.root;

import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.ab.c;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentExtras;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentLogParams;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.base.BaseCommentLogic;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.ToastData;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.monitor.d;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jd3.j;
import jd3.p0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p53.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommentRootLogic extends BaseCommentLogic<com.bytedance.android.shopping.commentv3.uitree.root.a> {
    public long f;
    public boolean g;
    public boolean h;
    public final Lazy i;

    public static final class a<T> implements Observer {
        public final /* synthetic */ CommentRootLogic a;

        public a(CommentRootLogic r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            final ToastData r4 = (ToastData) r3;
            this.a.e(new CommentRootLogic$onCreate$$inlined$let$lambda$1$1(r4));
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CommentRootLogic a;

        public b(CommentRootLogic r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            e r4 = (e) r3;
            if (this.a.h == true) goto L6;
            new ic3.a("ec_comment_verify_problem", new LinkedHashMap()).post(null, null);
            this.a.h = true;
            return;
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.base.e
    public final void a() {
        com.bytedance.android.shopping.commentv3.data.b r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L5;
        r0.e(FetchFrom.INIT, null);
    L5:
        int r2 = kh3.a.a;
        ih3.a r3 = ih3.a.a;
        if (r3.h() != 1) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L35;
        int r5 = com.bytedance.android.shopping.anchorv3.track.b.a;
        com.bytedance.android.shopping.commentv3.data.b r6 = this.d;
        if (r6 == null) goto L18;
        CommentParams r7 = r6.a;
        if (r7 == null) goto L18;
        String r8 = r7.getSearchId();
    L19:
        com.bytedance.android.shopping.commentv3.data.b r9 = this.d;
        if (r9 == null) goto L26;
        CommentParams r10 = r9.a;
        if (r10 == null) goto L26;
        CommentLogParams r11 = r10.getLogParams();
        if (r11 == null) goto L26;
        ECAdLogExtra r12 = r11.getAdLogExtra();
    L27:
        Context r13 = getContext();
        int r14 = a63.a.a;
        int r15 = c.a;
        p0 r16 = new p0();
        r16.b = r8;
        r16.c = Boolean.TRUE;
        if (r12 == null) goto L30;
        String r17 = r12.getAdExtraData();
    L32:
        if (k.c(r17) == false) goto L34;
        r16.a = r17;
    L34:
        com.bytedance.android.shopping.anchorv3.track.c.b(r16, r13);
        goto L35
    L30:
        r17 = null;
    L26:
        r12 = null;
    L18:
        r8 = null;
    L35:
        com.bytedance.android.shopping.commentv3.data.b r18 = this.d;
        if (r18 == null) goto L38;
        CommentParams r19 = r18.a;
    L39:
        String r20 = "";
        if (r19 != null) goto L42;
    L50:
        if (r19 == null) goto L55;
        CommentLogParams r21 = r19.getLogParams();
        if (r21 == null) goto L55;
        String r22 = r21.getCommentEntrance();
        if (r22 == null) goto L55;
    L56:
        com.bytedance.android.shopping.commentv3.data.b r23 = this.d;
        if (r23 == null) goto L63;
        CommentParams r24 = r23.a;
        if (r24 == null) goto L63;
        CommentExtras r25 = r24.getCommentExtras();
        if (r25 == null) goto L63;
        r1 = r25.getCommentMonitorName();
    L63:
        if (r1 == null) goto L66;
        r20 = r1;
    L66:
        d.f(r20).i("comment_entrance", r22);
        com.bytedance.android.shopping.commentv3.base.c r26 = this.c;
        if (r26 == null) goto L74;
        Fragment r27 = r26.b;
        if (r27 == null) goto L75;
        com.bytedance.android.shopping.commentv3.data.b r28 = this.d;
        if (r28 == null) goto L76;
        a r29 = new a(this);
        Intrinsics.checkNotNullParameter(r27, "owner");
        Intrinsics.checkNotNullParameter(r29, "observer");
        CommentDataCenter r30 = r28.h;
        r30.getClass();
        Intrinsics.checkNotNullParameter(r27, "owner");
        Intrinsics.checkNotNullParameter(r29, "observer");
        r30.t.observe(r27, r29);
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L55:
        r22 = "";
        goto L56
    L42:
        if (r19.isFromProductDetail() != true) goto L50;
        Map r31 = r19.getExtraParams();
        if (r31 == null) goto L55;
        Object r32 = r31.get("comment_entrance");
        if (r32 == null) goto L55;
        r22 = r32.toString();
        if (r22 != null) goto L56;
    L38:
        r19 = null;
        goto L39
    L8:
        if (r3.h() == 2) goto L11;
        r4 = false;
        goto L12
    }

    @Override // com.bytedance.android.shopping.commentv3.base.e
    public final void b() {
        t53.b r0 = t53.b.a;
        long r1 = this.f;
        Context r3 = getContext();
        com.bytedance.android.shopping.commentv3.data.b r4 = this.d;
        fc3.a r5 = null;
        if (r4 == null) goto L5;
        Map<String, String> r6 = r4.g;
    L6:
        r0.getClass();
        int r2 = a63.a.a;
        int r7 = c.a;
        j r8 = new j();
        r8.k = String.valueOf(SystemClock.uptimeMillis() - r1);
        r8.m = "全部";
        if (r6 == null) goto L24;
        Iterator<Map.Entry<String, String>> r9 = r6.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L24;
        Map.Entry<String, String> r10 = r9.next();
        String r11 = r10.getKey();
        if ((r11 instanceof String) == false) goto L10;
        if (r11.length() <= 0) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L10;
        String r13 = r11;
        String r14 = r10.getValue();
        if (r14 == null) goto L22;
        String r15 = r14.toString();
        if (r15 == null) goto L22;
    L23:
        r8.appendParam(r13, r15);
    L22:
        r15 = "";
        goto L23
    L16:
        r12 = false;
    L24:
        t53.e.c(r8, r3, null);
        int r16 = ic3.e.a;
        com.bytedance.android.shopping.commentv3.base.c r17 = this.c;
        if (r17 == null) goto L27;
        r5 = r17.d;
    L27:
        ic3.e.a.a(r5, EventName.CLICK.getEvent(), EntranceType.COMMENT_PAGE.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(SystemClock.uptimeMillis() - this.f))}), null, null, 240);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public CommentRootLogic() {
        this.i = LazyKt.lazy(new CommentRootLogic$commentTitleApi$2(this));
    }

    @Override // com.bytedance.android.shopping.commentv3.base.e
    public final void c() {
        this.f = SystemClock.uptimeMillis();
        fc3.a r2 = null;
        if (o53.b.a() == false) goto L12;
        com.bytedance.android.shopping.commentv3.base.c r0 = this.c;
        if (r0 == null) goto L15;
        Fragment r1 = r0.b;
        if (r1 == null) goto L15;
        com.bytedance.android.shopping.commentv3.data.b r3 = this.d;
        if (r3 == null) goto L15;
        b r4 = new b(this);
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        CommentDataCenter r5 = r3.h;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        r5.s.observe(r1, r4);
    L15:
        if (this.g == true) goto L33;
        com.bytedance.android.shopping.commentv3.data.b r6 = this.d;
        if (r6 == null) goto L23;
        CommentParams r7 = r6.a;
        if (r7 == null) goto L23;
        CommentLogParams r8 = r7.getLogParams();
        if (r8 == null) goto L23;
        String r9 = r8.getCommentEntrance();
    L24:
        int r10 = ic3.e.a;
        com.bytedance.android.shopping.commentv3.base.c r11 = this.c;
        if (r11 == null) goto L27;
        fc3.a r12 = r11.d;
    L28:
        String r13 = EventName.SHOW.getEvent();
        EntranceType r14 = EntranceType.COMMENT_PAGE;
        ic3.e.a.a(r12, r13, r14.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("comment_entrance", r9)}), null, null, 240);
        com.bytedance.android.shopping.commentv3.base.c r15 = this.c;
        if (r15 == null) goto L31;
        r2 = r15.d;
    L31:
        ic3.e.a.a(r2, "enter_product_comment_list", r14.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("comment_entrance", r9)}), null, null, 240);
        this.g = true;
        return;
    L27:
        r12 = null;
    L23:
        r9 = null;
        goto L24
    L33:
        return;
    L12:
        if (this.h == true) goto L15;
        new ic3.a("ec_comment_verify_problem", new LinkedHashMap()).post(null, null);
        this.h = true;
        goto L15
    }
}
