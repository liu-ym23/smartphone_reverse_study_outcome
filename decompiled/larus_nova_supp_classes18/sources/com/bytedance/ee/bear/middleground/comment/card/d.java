package com.bytedance.ee.bear.middleground.comment.card;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class d extends gn4.a {
    public static final /* synthetic */ int l = 0;
    public com.bytedance.ee.bear.middleground.comment.control.t c;
    public String d;
    public boolean e;
    public MutableLiveData<List<CommentBean>> f;
    public Integer g;
    public String h;
    public String i;
    public boolean j;
    public String k;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveData<List<CommentBean>> r0 = this.a.f;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setValue(null);     // Catch: Throwable -> L6
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
        this.d = "";
        this.h = "";
        this.k = "";
    }

    public final void b() {
        super.b();
        com.bytedance.ee.util.ui.j.f(new b(this));
        tt5.a.h("Comment#CardDataViewModel", "onClear");
    }

    public final CommentBean e(Integer r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        MutableLiveData<List<CommentBean>> r1 = this.f;
        if (r1 == null) goto L10;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L10;
        int r3 = r2.size();
    L12:
        if (RangesKt.until(0, r3).contains(r4.intValue()) == false) goto L19;
        MutableLiveData<List<CommentBean>> r5 = this.f;
        if (r5 == null) goto L20;
        List r6 = (List) r5.getValue();
        if (r6 != null) goto L18;
        return null;
    L18:
        return (CommentBean) ListProtector.get(r6, r4.intValue());
    L20:
        return null;
    L19:
        return null;
    L10:
        r3 = -1;
        goto L12
    }

    public final String f(Integer r3) {
        if (r3 != null) goto L17;
        return "";
    L17:
        MutableLiveData<List<CommentBean>> r1 = this.f;     // Catch: Exception -> L16
        if (r1 == null) goto L19;
        List r2 = (List) r1.getValue();     // Catch: Exception -> L16
        if (r2 == null) goto L20;
        CommentBean r4 = (CommentBean) ListProtector.get(r2, r3.intValue());     // Catch: Exception -> L16
        if (r4 == null) goto L21;
        String r5 = r4.getComment_id();     // Catch: Exception -> L16
        if (r5 != null) goto L15;
        return "";
    L15:
        return r5;
    L21:
        return "";
    L20:
        return "";
    L19:
        return "";
    L23:
        return "";
    }

    public final String g(int r5) {
        MutableLiveData<List<CommentBean>> r0 = this.f;
        if (r0 == null) goto L7;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r2 == 0) goto L10;
        HashMap r3 = new HashMap();
        r3.put("index", "(" + (r5 + 1));
        StringBuilder r6 = new StringBuilder();
        r6.append(r2);
        r6.append(')');
        r3.put("count", r6.toString());
        return xo5.a.d(eu5.b.a, 2131887610, r3);
    L10:
        return eu5.b.a.getString(2131887718);
    L7:
        r2 = 0;
        goto L8
    }

    public final int i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        MutableLiveData<List<CommentBean>> r0 = this.f;
        if (r0 == null) goto L14;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((CommentBean) r2.next()).getComment_id(), r5) == true) goto L17;
        r3 = r3 + 1;
        goto L9
    L17:
        return r3;
    L19:
        return -1;
    L18:
        return -1;
    L14:
        return -1;
    }

    public final int j(int r10) {
        MutableLiveData<List<CommentBean>> r0 = this.f;
        if (r0 == null) goto L51;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L51;
        String r2 = this.d;
        this.d = "";
        Integer r4 = null;
        int r5 = -1;
        if (TextUtils.isEmpty(r2) == true) goto L28;
        Iterator r3 = r1.iterator();
        int r7 = 0;
    L11:
        if (r3.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((CommentBean) r3.next()).getComment_id(), r2) == true) goto L17;
        r7 = r7 + 1;
    L17:
        Integer r6 = Integer.valueOf(r7);
        if (r6.intValue() < 0) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == true) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L28;
        return r6.intValue();
    L20:
        r8 = false;
        goto L21
    L16:
        r7 = -1;
    L28:
        if (TextUtils.isEmpty(this.k) == true) goto L45;
        Iterator r9 = r1.iterator();
        int r11 = 0;
    L31:
        if (r9.hasNext() == false) goto L36;
        if (Intrinsics.areEqual(((CommentBean) r9.next()).getComment_id(), this.k) == true) goto L34;
        r11 = r11 + 1;
        goto L31
    L34:
        r5 = r11;
    L36:
        Integer r12 = Integer.valueOf(r5);
        if (r12.intValue() < 0) goto L39;
        boolean r13 = true;
    L40:
        if (r13 == false) goto L42;
        r4 = r12;
    L42:
        if (r4 == null) goto L45;
        return r4.intValue();
    L39:
        r13 = false;
    L45:
        if (r10 >= 0) goto L48;
        return 0;
    L48:
        if (r1.size() <= r10) goto L50;
        return r10;
    L50:
        return r1.size() - 1;
    L51:
        return 0;
    }

    public final boolean m(int r2) {
        MutableLiveData<List<CommentBean>> r0 = this.f;     // Catch: Exception -> L11
        if (r0 == null) goto L10;
        List r1 = (List) r0.getValue();     // Catch: Exception -> L11
        if (r1 == null) goto L10;
        CommentBean r3 = (CommentBean) ListProtector.get(r1, r2);     // Catch: Exception -> L11
        if (r3 == null) goto L10;
        return r3.isCanPerformAction();
    L10:
        return true;
    L11:
        return false;
    }

    public final boolean n(int r3) {
        MutableLiveData<List<CommentBean>> r1 = this.f;     // Catch: Exception -> L19
        if (r1 == null) goto L22;
        List r2 = (List) r1.getValue();     // Catch: Exception -> L19
        if (r2 == null) goto L23;
        CommentBean r4 = (CommentBean) ListProtector.get(r2, r3);     // Catch: Exception -> L19
        if (r4 == null) goto L24;
        List<CommentBean.CommentDetail> r5 = r4.getComment_list();     // Catch: Exception -> L19
        if (r5 == null) goto L25;
        CommentBean.CommentDetail r6 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r5);     // Catch: Exception -> L19
        if (r6 == null) goto L26;
        ErrorBean r7 = r6.getError();     // Catch: Exception -> L19
        if (r7 == null) goto L27;
        if (r7.isSuccess() == false) goto L18;
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

    public final boolean o(int r4) {
        MutableLiveData<List<CommentBean>> r0 = this.f;
        if (r0 == null) goto L10;
        List r1 = (List) r0.getValue();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.size() != (r4 + 1)) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean q(String r4) {
        Intrinsics.checkNotNullParameter(r4, "commentId");
        MutableLiveData<List<CommentBean>> r0 = this.f;
        if (r0 == null) goto L14;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L14;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        CommentBean r3 = (CommentBean) r2.next();
        if (r3.getComment_id().equals(r4) == false) goto L8;
        if (r3.getCommentType() != 1) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean r(int r3) {
        boolean r0 = false;
        MutableLiveData<List<CommentBean>> r1 = this.f;     // Catch: Exception -> L12
        if (r1 == null) goto L11;
        List r2 = (List) r1.getValue();     // Catch: Exception -> L12
        if (r2 == null) goto L11;
        CommentBean r4 = (CommentBean) ListProtector.get(r2, r3);     // Catch: Exception -> L12
        if (r4 == null) goto L11;
        r0 = r4.isUnSubmitComment();     // Catch: Exception -> L12
    L11:
        return !r0;
    L15:
        return false;
    }

    public static int d(Resources r1, FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r1, "resource");
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (p(r1, r2) == false) goto L5;
        return 8;
    L5:
        return 0;
    }

    public static boolean p(Resources r1, FragmentActivity r2) {
        if (r1.getConfiguration().orientation == 2) goto L5;
    L9:
        return false;
    L5:
        if (com.bytedance.ee.util.ui.n.D(r2) == true) goto L9;
        if (ku5.c.k(r2) == true) goto L9;
        return true;
    }

    public final int h(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "replyId");
        if (TextUtils.isEmpty(r6) == true) goto L16;
        MutableLiveData<List<CommentBean>> r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L15;
        List r2 = (List) r0.getValue();
        if (r2 == null) goto L15;
        int r3 = ((CommentBean) ListProtector.get(r2, r5)).getComment_list().size();
    L10:
        if (r1 >= r3) goto L20;
        if (Intrinsics.areEqual(r6, ((CommentBean.CommentDetail) ListProtector.get(((CommentBean) ListProtector.get(r2, r5)).getComment_list(), r1)).getReply_id()) == true) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        return r1;
    L20:
        return -1;
    L15:
        return 0;
    L16:
        return -1;
    }

    public final void k(String r2, com.bytedance.ee.bear.middleground.comment.control.t r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "dataControl");
        this.c = r3;
        this.f = r3.I();
    }

    public final boolean l(int r3, CommentAction r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        MutableLiveData<List<CommentBean>> r1 = this.f;     // Catch: Exception -> L12
        if (r1 == null) goto L15;
        List r2 = (List) r1.getValue();     // Catch: Exception -> L12
        if (r2 == null) goto L16;
        CommentBean r5 = (CommentBean) ListProtector.get(r2, r3);     // Catch: Exception -> L12
        if (r5 == null) goto L17;
        return r5.isActionBlocked(r4);
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    L18:
        return false;
    }

    public final void s(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataControl");
        r0 = null;
    L5:
        this.f = r0.I();
        this.d = r2;
        this.g = r3;
    }
}
