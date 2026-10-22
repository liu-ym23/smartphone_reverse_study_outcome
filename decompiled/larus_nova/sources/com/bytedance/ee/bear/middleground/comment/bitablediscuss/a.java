package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.trace.CopyContentTypeString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.bytedance.ee.bear.middleground.comment.card.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ye5.a f230707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MediatorLiveData<List<CommentBean.CommentDetail>> f230708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData<CommentBean> f230709o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f230710p;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.bitablediscuss.a$a, reason: collision with other inner class name */
    public static final class C3301a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f230711a;

        public C3301a(a r100) {
            this.f230711a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.checkNotNullParameter((List) r100, "it");
            a.t(this.f230711a);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f230712a;

        public b(a r100) {
            this.f230712a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.checkNotNullParameter((List) r100, "it");
            a.t(this.f230712a);
        }
    }

    public a(ye5.a r100) {
        this.f230707m = r100;
        MediatorLiveData<List<CommentBean.CommentDetail>> r101 = new MediatorLiveData();
        this.f230708n = r101;
        this.f230709o = new MutableLiveData();
        this.f230710p = new b(this);
        C3301a r102 = new C3301a(this);
        if (r100 == null) goto L8;
        LiveData<List<String>> r103 = r100.getCurrentDiscussIds();
        if (r103 == null) goto L9;
        r101.addSource(r103, r102);
        return;
    L9:
        return;
    }

    public static final void t(a r110) {
        r110.getClass();
        ArrayList r100 = new ArrayList();
        MutableLiveData<List<CommentBean>> r101 = r110.f230964f;
        String r102 = null;
        if (r101 == null) goto L5;
        List<CommentBean> r103 = r101.getValue();
    L6:
        List<CommentBean> r104 = r103;
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        Pair r106 = TuplesKt.to(null, r100);
    L63:
        r110.f230708n.setValue((List<CommentBean.CommentDetail>) r106.getSecond());
        r110.f230709o.setValue((CommentBean) r106.getFirst());
        return;
    L15:
        ye5.a r107 = r110.f230707m;
        if (r107 != null) goto L18;
        r106 = TuplesKt.to(null, r100);
        goto L63
    L18:
        List<String> r108 = r107.getCurrentDiscussIds().getValue();
        String r109 = r110.f230707m.getCurrentRecordId();
        List<String> r111 = r108;
        if (r111 != null) goto L21;
    L24:
        boolean r112 = true;
    L25:
        if (r112 == false) goto L27;
        r106 = TuplesKt.to(null, r100);
        goto L63
    L27:
        Iterator<CommentBean> r113 = r103.iterator();
        CommentBean r114 = null;
    L29:
        if (r113.hasNext() == false) goto L62;
        CommentBean r115 = r113.next();
        if (r108.contains(r115.getComment_id()) == false) goto L29;
        CommentBean.Extra r116 = r115.getExtra();
        if (r116 == null) goto L36;
        int r117 = r116.getVisibility();
    L37:
        Object r118 = r115.getBizParams().get("notify_extra");
        if (r118 != null) goto L40;
    L42:
        String r119 = r102;
        String r120 = r119;
        String r121 = r120;
    L44:
        if (TextUtils.isEmpty(r119) == false) goto L46;
        r119 = r109;
    L46:
        List<CommentBean.CommentDetail> r122 = r115.getComment_list();
        if (r122 != null) goto L49;
    L52:
        boolean r123 = true;
    L53:
        if (r123 == true) goto L61;
        int r124 = r115.getComment_list().size();
        int r125 = 0;
    L55:
        if (r125 >= r124) goto L61;
        Object r126 = ListProtector.get(r115.getComment_list(), r125);
        CommentBean.CommentDetail r127 = (CommentBean.CommentDetail) r126;
        CommentBean.CommentDetail.BitableExtraEntity r128 = new CommentBean.CommentDetail.BitableExtraEntity();
        if (r125 != 0) goto L59;
        boolean r129 = true;
    L60:
        r128.setMainComment(r129);
        r128.setVisibility(r117);
        r128.setTableId(r120);
        r128.setViewId(r121);
        r128.setRecordId(r119);
        r127.setBitableExtra(r128);
        r127.setComment_id(r115.getComment_id());
        r127.setCommentUUID(r115.getCommentUUID());
        r100.add(r126);
        r125 = r125 + 1;
        goto L55
    L59:
        r129 = false;
    L61:
        r114 = r115;
        r102 = null;
        goto L29
    L49:
        if (r122.isEmpty() == true) goto L52;
        r123 = false;
        goto L53
    L40:
        if ((r118 instanceof JSONObject) == false) goto L42;
        JSONObject r130 = (JSONObject) r118;
        r120 = r130.getString(CopyContentTypeString.TABLE);
        r121 = r130.getString("view");
        r119 = r130.getString("record");
        goto L44
    L36:
        r117 = 0;
        goto L37
    L62:
        r106 = TuplesKt.to(r114, r100);
        goto L63
    L21:
        if (r111.isEmpty() == true) goto L24;
        r112 = false;
        goto L25
    L9:
        if (r104.isEmpty() == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final CommentBean u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;
        if (r101 == null) goto L16;
        List<CommentBean> r102 = r101.getValue();
        if (r102 == null) goto L17;
        Iterator<CommentBean> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        CommentBean r104 = r103.next();
        if (TextUtils.equals(r100, r104.getComment_id()) == false) goto L8;
        return r104;
    L18:
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    public final int v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        List<CommentBean.CommentDetail> r102 = this.f230708n.getValue();
        int r103 = -1;
        if (r102 == null) goto L18;
        int r104 = r102.size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L25;
        if (TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r102, r105)).getComment_id(), r100) == false) goto L17;
        if (((CommentBean.CommentDetail) ListProtector.get(r102, r105)).getBitableExtra().isMainComment() == false) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L24;
        r103 = r105;
    L24:
        return r105;
    L15:
        if (TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r102, r105)).getReply_id(), r101) == true) goto L24;
    L17:
        r105 = r105 + 1;
        goto L5
    L25:
        return r103;
    L18:
        return -1;
    }
}
