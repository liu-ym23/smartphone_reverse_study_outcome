package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import com.bytedance.android.shopping.commentv3.data.ComponentType;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentComponent;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.shopping.commentv3.data.b d;

    public static final class a {
    }

    static {
    }

    public b(com.bytedance.android.shopping.commentv3.data.b r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        super(ActionType.CACHE_UPDATE.getType());
        this.d = r2;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r18, fc3.a r19, fc3.c r20, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r21) {
        Intrinsics.checkNotNullParameter(r18, "eventContext");
        Intrinsics.checkNotNullParameter(r19, "actionContext");
        Intrinsics.checkNotNullParameter(r20, "handleActionParams");
        Intrinsics.checkNotNullParameter(r21, "completion");
        String r3 = com.bytedance.android.shopping.commentv3.event_chain.g.b(r18);
        if (r3 != null) goto L5;
        return;
    L5:
        Map<?, ?> r4 = com.bytedance.android.shopping.commentv3.event_chain.g.a(r18);
        if (r4 != null) goto L8;
        return;
    L8:
        Map r5 = r18.k;
        if (r5 == null) goto L11;
        long r8 = nc3.a.c(r5, "comment_id", 0);
    L12:
        Map r0 = r18.k;
        if (r0 == null) goto L17;
        Boolean r1 = nc3.a.a(r0, "notify_observer", Boolean.TRUE);
        if (r1 == null) goto L17;
        boolean r2 = r1.booleanValue();
    L18:
        CommentSliceComponent r6 = r20.d;
        if (r6 == null) goto L21;
        String r11 = r6.getSliceId();
    L23:
        if (Intrinsics.areEqual(r11, r3) == false) goto L40;
        Map<String, Object> r12 = r6.getData();
        if (r12 == null) goto L27;
        Map<String, ? extends Object> r13 = MapsKt.toMutableMap(r12);
    L28:
        if (r13 != null) goto L30;
    L33:
        boolean r14 = true;
    L34:
        if (r14 == true) goto L40;
        Iterator<Map.Entry<?, ?>> r15 = r4.entrySet().iterator();
    L37:
        if (r15.hasNext() == false) goto L39;
        Map.Entry<?, ?> r16 = r15.next();
        r13.put(String.valueOf(r16.getKey()), r16.getValue());
        goto L37
    L39:
        r6.setData(r13);
        goto L40
    L30:
        if (r13.isEmpty() == true) goto L33;
        r14 = false;
        goto L34
    L27:
        r13 = null;
    L40:
        com.bytedance.android.shopping.commentv3.data.b r17 = this.d;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r3, "sliceId");
        Intrinsics.checkNotNullParameter(r4, "incomingData");
        CommentDataCenter r110 = r17.h;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r3, "sliceId");
        Intrinsics.checkNotNullParameter(r4, "incomingData");
        lc3.b r111 = r110.r.d();
        if (r111 == null) goto L118;
        List<ICommentComponent> r112 = r111.a;
        if (r112 == null) goto L118;
        Iterator<T> r113 = r112.iterator();
        boolean r114 = false;
    L47:
        if (r113.hasNext() == false) goto L69;
        ICommentComponent r7 = (ICommentComponent) r113.next();
        if ((r7 instanceof CommentSliceComponent) == false) goto L47;
        CommentSliceComponent r9 = (CommentSliceComponent) r7;
        if (Intrinsics.areEqual(r9.getSliceId(), r3) == false) goto L47;
        Map<String, Object> r10 = r9.getData();
        if (r10 == null) goto L55;
        Map r22 = MapsKt.toMutableMap(r10);
    L56:
        if (r22 != null) goto L58;
    L61:
        boolean r23 = true;
    L62:
        if (r23 == true) goto L47;
        Iterator<Map.Entry<?, ?>> r24 = r4.entrySet().iterator();
    L65:
        if (r24.hasNext() == false) goto L67;
        Map.Entry<?, ?> r25 = r24.next();
        r22.put(String.valueOf(r25.getKey()), r25.getValue());
        goto L65
    L67:
        r114 = true;
        goto L47
    L58:
        if (r22.isEmpty() == true) goto L61;
        r23 = false;
        goto L62
    L55:
        r22 = null;
        goto L56
    L69:
        if (r114 == false) goto L77;
        lc3.b r26 = r110.r.d();
        if (r26 == null) goto L74;
        List r27 = r26.b;
        if (r27 == null) goto L74;
    L75:
        r110.r.f(new lc3.b(r112, r27, 12), r2);
    L74:
        r27 = new ArrayList();
    L77:
        if (StringsKt.startsWith$default(r3, ComponentType.COMMENT_BROWSE.getType(), false, 2, null) == false) goto L118;
        if (r4.containsKey("liked") == false) goto L118;
        if (r8 <= 0) goto L118;
        Object r28 = r4.get("liked");
        if ((r28 instanceof Boolean) == true) goto L85;
        r28 = null;
    L85:
        Boolean r29 = (Boolean) r28;
        if (r29 == null) goto L118;
        boolean r30 = r29.booleanValue();
        lc3.a r31 = (lc3.a) r110.m.getValue();
        if (r31 == null) goto L118;
        List<CommentNodeVO> r32 = r31.a;
        if (r32 == null) goto L118;
        lc3.a r33 = (lc3.a) r110.m.getValue();
        if (r33 == null) goto L118;
        FetchFrom r34 = r33.b;
        if (r34 == null) goto L118;
        Iterator<T> r35 = r32.iterator();
    L99:
        if (r35.hasNext() == false) goto L106;
        Object r36 = r35.next();
        if (((CommentNodeVO) r36).getId() != r8) goto L103;
        boolean r37 = true;
    L104:
        if (r37 == false) goto L99;
    L107:
        CommentNodeVO r38 = (CommentNodeVO) r36;
        if (r38 == null) goto L118;
        if (r38.getLiked() == false) goto L115;
        if (r30 == true) goto L115;
        r38.setLiked(false);
        r38.setLikes(r38.getLikes() - 1);
        r110.m.postValue(new lc3.a(r32, r34));
    L115:
        if (r38.getLiked() == true) goto L118;
        if (r30 == false) goto L118;
        r38.setLiked(true);
        r38.setLikes(r38.getLikes() + 1);
        r110.m.postValue(new lc3.a(r32, r34));
        goto L118
    L103:
        r37 = false;
        goto L104
    L106:
        r36 = null;
    L118:
        int r39 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r21.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L21:
        r11 = null;
    L17:
        r2 = true;
        goto L18
    L11:
        r8 = 0;
        goto L12
    }
}
