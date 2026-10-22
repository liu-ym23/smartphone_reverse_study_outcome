package com.bytedance.android.shopping.commentv3.uitree.list;

import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.anchorv3.commentv2.model.CommentNpsVersion;
import com.bytedance.android.shopping.anchorv3.commentv2.model.EcCommentNpsExitReason;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import com.bytedance.android.shopping.commentv3.data.ComponentType;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentComponent;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.CommentAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements j {
    public final /* synthetic */ CommentListUI a;

    public c(CommentListUI r1) {
        this.a = r1;
    }

    public final void a(JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r9.optInt("version", CommentNpsVersion.DEFAULT.getVersion()) != CommentNpsVersion.NEW_NPS.getVersion()) goto L48;
        CommentListUI r0 = this.a;
        int r1 = CommentListUI.o;
        r0.getClass();
        int r10 = r9.optInt("reason", EcCommentNpsExitReason.INVALID_REASON.getReason());
        if (r10 != EcCommentNpsExitReason.SUBMIT.getReason()) goto L7;
    L8:
        String r11 = y53.a.a;
        long r2 = System.currentTimeMillis() + (m53.b.a("active", 30) * 86400000);
        q.a.e(y53.a.a, r2);
        CommentAdapter r12 = r0.k;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L11:
        Iterator r3 = ((ArrayList) r12.u).iterator();
        int r4 = 0;
    L13:
        if (r3.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((ICommentComponent) r3.next()).getComponentType(), ComponentType.COMMENT_NPS.getType()) == true) goto L19;
        r4 = r4 + 1;
    L19:
        if (r4 < 0) goto L21;
        ListProtector.remove(r12.u, r4);
        r12.notifyItemRemoved(r4);
    L21:
        com.bytedance.android.shopping.commentv3.data.b r13 = r0.e;
        if (r13 == null) goto L50;
        r13.j = false;
        CommentDataCenter r14 = r13.h;
        lc3.b r5 = r14.r.d();
        if (r5 == null) goto L27;
        Iterable r6 = r5.a;
        if (r6 == null) goto L27;
    L28:
        lc3.b r7 = r14.r.d();
        if (r7 == null) goto L32;
        List r8 = r7.b;
        if (r8 == null) goto L32;
    L33:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r6.iterator();
    L35:
        if (r16.hasNext() == false) goto L39;
        Object r17 = r16.next();
        if ((true ^ Intrinsics.areEqual(((ICommentComponent) r17).getComponentType(), ComponentType.COMMENT_NPS.getType())) == false) goto L35;
        r15.add(r17);
        goto L35
    L39:
        lc3.b r18 = new lc3.b(CollectionsKt.toMutableList(r15), r8, true, FetchFrom.REMOVE_NPS);
        r14.r.f(r18, false);
        return;
    L32:
        r8 = new ArrayList();
    L27:
        r6 = new ArrayList();
        goto L28
    L50:
        return;
    L18:
        r4 = -1;
        goto L19
    L7:
        if (r10 == EcCommentNpsExitReason.CLOSE.getReason()) goto L8;
        return;
    }
}
