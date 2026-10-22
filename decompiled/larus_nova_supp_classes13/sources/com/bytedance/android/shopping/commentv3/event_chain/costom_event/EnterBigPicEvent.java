package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentPageEvents;
import com.bytedance.android.shopping.commentv3.view.CommentGalleryDialog;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class EnterBigPicEvent extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final Lazy d;
    public final Context e;
    public final com.bytedance.android.shopping.commentv3.data.b f;
    public final LifecycleOwner g;

    public EnterBigPicEvent(Context r2, com.bytedance.android.shopping.commentv3.data.b r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        super(ActionType.ENTER_BIG_PIC.getType());
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.d = LazyKt.lazy(new EnterBigPicEvent$enterMultiModeCb$2(this));
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [android.app.Dialog, com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog, com.bytedance.android.shopping.commentv3.view.CommentGalleryDialog] */
    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r12, fc3.a r13, fc3.c r14, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "eventContext");
        Intrinsics.checkNotNullParameter(r13, "actionContext");
        Intrinsics.checkNotNullParameter(r14, "handleActionParams");
        Intrinsics.checkNotNullParameter(r15, "completion");
        this.c = r13;
        View r16 = r14.b;
        if (r16 != null) goto L5;
        int r17 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        com.bytedance.kmp.ec.yata.chain.event.b r18 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "targetView is null", null, null, 57);
    L70:
        r15.invoke(r18);
        return;
    L5:
        Map r19 = r12.k;
        if (r19 == null) goto L69;
        String r110 = nc3.a.e(r19, "comment_id", null);
        if (r110 == null) goto L69;
        Map r0 = r12.k;
        if (r0 == null) goto L68;
        int r1 = nc3.a.b(r0, "position", 0);
        Map r111 = r12.k;
        if (r111 == null) goto L67;
        Boolean r112 = nc3.a.a(r111, "is_append", null);
        if (r112 == null) goto L67;
        boolean r113 = r112.booleanValue();
        ?? r2 = new CommentGalleryDialog(this.e, this.g, this.f);
        r2.r = (Function0) this.d.getValue();
        lc3.a r4 = (lc3.a) this.f.h.m.getValue();
        if (r4 == null) goto L20;
        List r5 = r4.a;
        if (r5 == null) goto L20;
    L21:
        Intrinsics.checkNotNullParameter(r5, "comments");
        Intrinsics.checkNotNullParameter(r110, "commentId");
        Intrinsics.checkNotNullParameter(r16, FreqActions.ACTION_VIEW);
        List<cc3.c> r6 = r2.i(r5, FetchFrom.INIT);
        Iterator r7 = ((ArrayList) r6).iterator();
        int r8 = 0;
    L23:
        if (r7.hasNext() == false) goto L33;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        cc3.c r11 = (cc3.c) r9;
        if (Intrinsics.areEqual(String.valueOf(r11.c.getId()), r110) == false) goto L32;
        if (r11.b != r113) goto L32;
        int r20 = r8 + r1;
    L34:
        r2.t = r20;
        cc3.c r114 = (cc3.c) CollectionsKt.getOrNull(r6, r20);
        if (r114 == null) goto L39;
        com.bytedance.android.ec.model.k r115 = r114.a;
        if (r115 == null) goto L39;
        String r116 = r115.c;
    L41:
        if (r116 != null) goto L43;
    L46:
        boolean r21 = true;
    L47:
        if (r21 == false) goto L49;
    L51:
        r2.e(r2.t, r16);
        if (r2.u == false) goto L54;
    L66:
        t53.b r117 = t53.b.a;
        Context r118 = r2.getContext();
        r117.getClass();
        t53.e.c(new u53.c(), r118, null);
        int r119 = ic3.e.a;
        ic3.e.a.a(r2.v.b, EventName.SHOW.getEvent(), EntranceType.LIST_IMAGE_PREVIEW.getType(), new LinkedHashMap(), null, null, 240);
        int r120 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r18 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L70
    L54:
        if (r2.isShowing() == false) goto L66;
        r2.u = true;
        gc3.a r121 = r2.v.d;
        if (r121 == null) goto L66;
        r121.c++;
        if (r121.d == false) goto L66;
        r121.d = false;
        CommentPageEvents r122 = r121.a;
        if (r122 == null) goto L64;
        List<Map<String, Object>> r123 = r122.getOnDisappear();
    L65:
        r121.a(r123, null);
        goto L66
    L64:
        r123 = null;
        goto L65
    L49:
        if (y.k(UriProtector.parse(r116)) == false) goto L51;
        ECUrlModel r22 = new ECUrlModel();
        ArrayList r23 = new ArrayList();
        r23.add(r116);
        Unit r124 = Unit.INSTANCE;
        r22.setUrlList(r23);
        y.l(r22, -1, -1, new com.bytedance.android.shopping.commentv3.view.a(r2, r114));
        goto L51
    L43:
        if (r116.length() == 0) goto L46;
        r21 = false;
    L39:
        r116 = null;
    L32:
        r8 = r10;
        goto L23
    L33:
        r20 = 0;
    L20:
        r5 = new ArrayList();
    L67:
        int r125 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r18 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "is_append is null", null, null, 57);
        goto L70
    L68:
        int r126 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r18 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "position is null", null, null, 57);
    L69:
        int r127 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r18 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "comment_id is null", null, null, 57);
        goto L70
    }
}
