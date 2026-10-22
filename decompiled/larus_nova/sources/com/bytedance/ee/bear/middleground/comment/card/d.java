package com.bytedance.ee.bear.middleground.comment.card;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public class d extends gn4.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f230960l = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.control.t f230961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f230962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f230963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<List<CommentBean>> f230964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f230965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f230966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f230967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f230968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f230969k;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f230970a;

        public b(d r100) {
            this.f230970a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveData<List<CommentBean>> r100 = this.f230970a.f230964f;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setValue(null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public d() {
        this.f230962d = "";
        this.f230966h = "";
        this.f230969k = "";
    }

    @Override // gn4.a
    public final void b() {
        super.b();
        com.bytedance.ee.util.ui.j.f(new b(this));
        tt5.a.h("Comment#CardDataViewModel", "onClear");
    }

    public final CommentBean e(Integer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;
        if (r101 == null) goto L10;
        List<CommentBean> r102 = r101.getValue();
        if (r102 == null) goto L10;
        int r103 = r102.size();
    L12:
        if (RangesKt.until(0, r103).contains(r100.intValue()) == false) goto L19;
        MutableLiveData<List<CommentBean>> r104 = this.f230964f;
        if (r104 == null) goto L20;
        List<CommentBean> r105 = r104.getValue();
        if (r105 != null) goto L18;
        return null;
    L18:
        return (CommentBean) ListProtector.get(r105, r100.intValue());
    L20:
        return null;
    L19:
        return null;
    L10:
        r103 = -1;
        goto L12
    }

    public final String f(Integer r100) {
        if (r100 != null) goto L17;
        return "";
    L17:
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;     // Catch: Exception -> L16
        if (r101 == null) goto L19;
        List<CommentBean> r102 = r101.getValue();     // Catch: Exception -> L16
        if (r102 == null) goto L20;
        CommentBean r103 = (CommentBean) ListProtector.get(r102, r100.intValue());     // Catch: Exception -> L16
        if (r103 == null) goto L21;
        String r104 = r103.getComment_id();     // Catch: Exception -> L16
        if (r104 != null) goto L15;
        return "";
    L15:
        return r104;
    L21:
        return "";
    L20:
        return "";
    L19:
        return "";
    L23:
        return "";
    }

    public final String g(int r100) {
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;
        if (r101 == null) goto L7;
        List<CommentBean> r102 = r101.getValue();
        if (r102 == null) goto L7;
        int r103 = r102.size();
    L8:
        if (r103 == 0) goto L10;
        HashMap r104 = new HashMap();
        r104.put("index", "(" + (r100 + 1));
        StringBuilder r105 = new StringBuilder();
        r105.append(r103);
        r105.append(')');
        r104.put("count", r105.toString());
        return xo5.a.d(eu5.b.f474075a, R.string.Doc_Comment_CommentCardTitle, r104);
    L10:
        return eu5.b.f474075a.getString(R.string.Doc_Facade_Comment);
    L7:
        r103 = 0;
        goto L8
    }

    public final int i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;
        if (r101 == null) goto L14;
        List<CommentBean> r102 = r101.getValue();
        if (r102 == null) goto L18;
        Iterator<CommentBean> r103 = r102.iterator();
        int r104 = 0;
    L9:
        if (r103.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(r103.next().getComment_id(), r100) == true) goto L17;
        r104 = r104 + 1;
        goto L9
    L17:
        return r104;
    L19:
        return -1;
    L18:
        return -1;
    L14:
        return -1;
    }

    public final int j(int r110) {
        MutableLiveData<List<CommentBean>> r100 = this.f230964f;
        if (r100 == null) goto L51;
        List<CommentBean> r101 = r100.getValue();
        if (r101 == null) goto L51;
        String r102 = this.f230962d;
        this.f230962d = "";
        Integer r103 = null;
        int r104 = -1;
        if (TextUtils.isEmpty(r102) == true) goto L28;
        Iterator<CommentBean> r105 = r101.iterator();
        int r106 = 0;
    L11:
        if (r105.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(r105.next().getComment_id(), r102) == true) goto L17;
        r106 = r106 + 1;
    L17:
        Integer r107 = Integer.valueOf(r106);
        if (r107.intValue() < 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == true) goto L24;
        r107 = null;
    L24:
        if (r107 == null) goto L28;
        return r107.intValue();
    L20:
        r108 = false;
        goto L21
    L16:
        r106 = -1;
    L28:
        if (TextUtils.isEmpty(this.f230969k) == true) goto L45;
        Iterator<CommentBean> r109 = r101.iterator();
        int r111 = 0;
    L31:
        if (r109.hasNext() == false) goto L36;
        if (Intrinsics.areEqual(r109.next().getComment_id(), this.f230969k) == true) goto L34;
        r111 = r111 + 1;
        goto L31
    L34:
        r104 = r111;
    L36:
        Integer r112 = Integer.valueOf(r104);
        if (r112.intValue() < 0) goto L39;
        boolean r113 = true;
    L40:
        if (r113 == false) goto L42;
        r103 = r112;
    L42:
        if (r103 == null) goto L45;
        return r103.intValue();
    L39:
        r113 = false;
    L45:
        if (r110 >= 0) goto L48;
        return 0;
    L48:
        if (r101.size() <= r110) goto L50;
        return r110;
    L50:
        return r101.size() - 1;
    L51:
        return 0;
    }

    public final boolean m(int r100) {
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;     // Catch: Exception -> L11
        if (r101 == null) goto L10;
        List<CommentBean> r102 = r101.getValue();     // Catch: Exception -> L11
        if (r102 == null) goto L10;
        CommentBean r103 = (CommentBean) ListProtector.get(r102, r100);     // Catch: Exception -> L11
        if (r103 == null) goto L10;
        return r103.isCanPerformAction();
    L10:
        return true;
    L11:
        return false;
    }

    public final boolean n(int r100) {
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;     // Catch: Exception -> L19
        if (r101 == null) goto L22;
        List<CommentBean> r102 = r101.getValue();     // Catch: Exception -> L19
        if (r102 == null) goto L23;
        CommentBean r103 = (CommentBean) ListProtector.get(r102, r100);     // Catch: Exception -> L19
        if (r103 == null) goto L24;
        List<CommentBean.CommentDetail> r104 = r103.getComment_list();     // Catch: Exception -> L19
        if (r104 == null) goto L25;
        CommentBean.CommentDetail r105 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r104);     // Catch: Exception -> L19
        if (r105 == null) goto L26;
        ErrorBean r106 = r105.getError();     // Catch: Exception -> L19
        if (r106 == null) goto L27;
        if (r106.isSuccess() == false) goto L18;
        return false;
    L18:
        return true;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L29:
        return false;
    }

    public final boolean o(int r100) {
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;
        if (r101 == null) goto L10;
        List<CommentBean> r102 = r101.getValue();
        if (r102 != null) goto L7;
        return false;
    L7:
        if (r102.size() != (r100 + 1)) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        MutableLiveData<List<CommentBean>> r101 = this.f230964f;
        if (r101 == null) goto L14;
        List<CommentBean> r102 = r101.getValue();
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        CommentBean r104 = (CommentBean) r103.next();
        if (r104.getComment_id().equals(r100) == false) goto L8;
        if (r104.getCommentType() != 1) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean r(int r100) {
        boolean r101 = false;
        MutableLiveData<List<CommentBean>> r102 = this.f230964f;     // Catch: Exception -> L12
        if (r102 == null) goto L11;
        List<CommentBean> r103 = r102.getValue();     // Catch: Exception -> L12
        if (r103 == null) goto L11;
        CommentBean r104 = (CommentBean) ListProtector.get(r103, r100);     // Catch: Exception -> L12
        if (r104 == null) goto L11;
        r101 = r104.isUnSubmitComment();     // Catch: Exception -> L12
    L11:
        return !r101;
    L15:
        return false;
    }

    public static int d(Resources r100, FragmentActivity r101) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        Intrinsics.checkNotNullParameter(r101, "activity");
        if (p(r100, r101) == false) goto L5;
        return 8;
    L5:
        return 0;
    }

    public static boolean p(Resources r100, FragmentActivity r101) {
        if (r100.getConfiguration().orientation == 2) goto L5;
    L9:
        return false;
    L5:
        if (com.bytedance.ee.util.ui.n.D(r101) == true) goto L9;
        if (ku5.c.k(r101) == true) goto L9;
        return true;
    }

    public final int h(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "replyId");
        if (TextUtils.isEmpty(r101) == true) goto L16;
        MutableLiveData<List<CommentBean>> r102 = this.f230964f;
        int r103 = 0;
        if (r102 == null) goto L15;
        List<CommentBean> r104 = r102.getValue();
        if (r104 == null) goto L15;
        int r105 = ((CommentBean) ListProtector.get(r104, r100)).getComment_list().size();
    L10:
        if (r103 >= r105) goto L20;
        if (Intrinsics.areEqual(r101, ((CommentBean.CommentDetail) ListProtector.get(((CommentBean) ListProtector.get(r104, r100)).getComment_list(), r103)).getReply_id()) == true) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r103;
    L20:
        return -1;
    L15:
        return 0;
    L16:
        return -1;
    }

    public final void k(String r100, com.bytedance.ee.bear.middleground.comment.control.t r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "dataControl");
        this.f230961c = r101;
        this.f230964f = r101.I();
    }

    public final boolean l(int r100, CommentAction r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        MutableLiveData<List<CommentBean>> r102 = this.f230964f;     // Catch: Exception -> L12
        if (r102 == null) goto L15;
        List<CommentBean> r103 = r102.getValue();     // Catch: Exception -> L12
        if (r103 == null) goto L16;
        CommentBean r104 = (CommentBean) ListProtector.get(r103, r100);     // Catch: Exception -> L12
        if (r104 == null) goto L17;
        return r104.isActionBlocked(r101);
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    L18:
        return false;
    }

    public final void s(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        com.bytedance.ee.bear.middleground.comment.control.t r102 = this.f230961c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataControl");
        r102 = null;
    L5:
        this.f230964f = r102.I();
        this.f230962d = r100;
        this.f230965g = r101;
    }
}
