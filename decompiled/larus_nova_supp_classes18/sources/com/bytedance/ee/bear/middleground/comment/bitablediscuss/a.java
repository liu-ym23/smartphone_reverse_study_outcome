package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.middleground.comment.card.d {
    public final ye5.a m;
    public final MediatorLiveData<List<CommentBean.CommentDetail>> n;
    public final MutableLiveData<CommentBean> o;
    public final b p;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.bitablediscuss.a$a, reason: collision with other inner class name */
    public static final class C0054a<T> implements Observer {
        public final /* synthetic */ a a;

        public C0054a(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((List) r2, "it");
            a.t(this.a);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((List) r2, "it");
            a.t(this.a);
        }
    }

    public a(ye5.a r3) {
        this.m = r3;
        MediatorLiveData<List<CommentBean.CommentDetail>> r0 = new MediatorLiveData();
        this.n = r0;
        this.o = new MutableLiveData();
        this.p = new b(this);
        C0054a r1 = new C0054a(this);
        if (r3 == null) goto L8;
        LiveData<List<String>> r4 = r3.getCurrentDiscussIds();
        if (r4 == null) goto L9;
        r0.addSource(r4, r1);
        return;
    L9:
        return;
    }

    public static final void t(a r16) {
        r16.getClass();
        ArrayList r1 = new ArrayList();
        MutableLiveData<List<CommentBean>> r2 = r16.f;
        String r3 = null;
        if (r2 == null) goto L5;
        List r4 = (List) r2.getValue();
    L6:
        List r5 = r4;
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        Pair r7 = TuplesKt.to(null, r1);
    L63:
        r16.n.setValue(r7.getSecond());
        r16.o.setValue(r7.getFirst());
        return;
    L15:
        ye5.a r8 = r16.m;
        if (r8 != null) goto L18;
        r7 = TuplesKt.to(null, r1);
        goto L63
    L18:
        List r9 = (List) r8.getCurrentDiscussIds().getValue();
        String r10 = r16.m.getCurrentRecordId();
        List r11 = r9;
        if (r11 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == false) goto L27;
        r7 = TuplesKt.to(null, r1);
        goto L63
    L27:
        Iterator r13 = r4.iterator();
        CommentBean r14 = null;
    L29:
        if (r13.hasNext() == false) goto L62;
        CommentBean r15 = (CommentBean) r13.next();
        if (r9.contains(r15.getComment_id()) == false) goto L29;
        CommentBean.Extra r17 = r15.getExtra();
        if (r17 == null) goto L36;
        int r18 = r17.getVisibility();
    L37:
        Object r19 = r15.getBizParams().get("notify_extra");
        if (r19 != null) goto L40;
    L42:
        String r110 = r3;
        String r111 = r110;
        String r112 = r111;
    L44:
        if (TextUtils.isEmpty(r110) == false) goto L46;
        r110 = r10;
    L46:
        List<CommentBean.CommentDetail> r113 = r15.getComment_list();
        if (r113 != null) goto L49;
    L52:
        boolean r114 = true;
    L53:
        if (r114 == true) goto L61;
        int r115 = r15.getComment_list().size();
        int r116 = 0;
    L55:
        if (r116 >= r115) goto L61;
        Object r117 = ListProtector.get(r15.getComment_list(), r116);
        CommentBean.CommentDetail r20 = (CommentBean.CommentDetail) r117;
        CommentBean.CommentDetail.BitableExtraEntity r21 = new CommentBean.CommentDetail.BitableExtraEntity();
        if (r116 != 0) goto L59;
        boolean r22 = true;
    L60:
        r21.setMainComment(r22);
        r21.setVisibility(r18);
        r21.setTableId(r111);
        r21.setViewId(r112);
        r21.setRecordId(r110);
        r20.setBitableExtra(r21);
        r20.setComment_id(r15.getComment_id());
        r20.setCommentUUID(r15.getCommentUUID());
        r1.add(r117);
        r116 = r116 + 1;
        goto L55
    L59:
        r22 = false;
    L61:
        r14 = r15;
        r3 = null;
        goto L29
    L49:
        if (r113.isEmpty() == true) goto L52;
        r114 = false;
        goto L53
    L40:
        if ((r19 instanceof JSONObject) == false) goto L42;
        JSONObject r118 = (JSONObject) r19;
        r111 = r118.getString("table");
        r112 = r118.getString("view");
        r110 = r118.getString("record");
        goto L44
    L36:
        r18 = 0;
        goto L37
    L62:
        r7 = TuplesKt.to(r14, r1);
        goto L63
    L21:
        if (r11.isEmpty() == true) goto L24;
        r12 = false;
        goto L25
    L9:
        if (r5.isEmpty() == true) goto L12;
        r6 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public final CommentBean u(String r5) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        MutableLiveData<List<CommentBean>> r0 = this.f;
        if (r0 == null) goto L16;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        CommentBean r3 = (CommentBean) r2.next();
        if (TextUtils.equals(r5, r3.getComment_id()) == false) goto L8;
        return r3;
    L18:
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    public final int v(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        List r0 = (List) this.n.getValue();
        int r1 = -1;
        if (r0 == null) goto L18;
        int r2 = r0.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L25;
        if (TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r0, r3)).getComment_id(), r6) == false) goto L17;
        if (((CommentBean.CommentDetail) ListProtector.get(r0, r3)).getBitableExtra().isMainComment() == false) goto L15;
        if (TextUtils.isEmpty(r7) == true) goto L24;
        r1 = r3;
    L24:
        return r3;
    L15:
        if (TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r0, r3)).getReply_id(), r7) == true) goto L24;
    L17:
        r3 = r3 + 1;
        goto L5
    L25:
        return r1;
    L18:
        return -1;
    }
}
