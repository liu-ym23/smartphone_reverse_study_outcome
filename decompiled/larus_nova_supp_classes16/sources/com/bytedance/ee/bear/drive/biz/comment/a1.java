package com.bytedance.ee.bear.drive.biz.comment;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.biz.comment.data.CommentQuote;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a1 implements p1, com.bytedance.ee.bear.drive.biz.comment.data.m.a, com.bytedance.ee.bear.drive.biz.comment.data.m.b {
    public FrameLayout A;
    public volatile int B;
    public m1 C;
    public h D;
    public final DriveCommentVM E;
    public final DriveViewModel F;
    public final DriveMGPermissionVM G;
    public String H;
    public String I;
    public String J;
    public int K;
    public Long L;
    public long M;
    public Disposable N;
    public Disposable O;
    public long P;
    public long Q;
    public long R;
    public Runnable S;
    public long T;
    public final Function0<Boolean> U;
    public final Function0<Boolean> V;
    public final b W;
    public final v0 X;
    public final boolean a;
    public FragmentActivity b;
    public com.bytedance.ee.bear.middleground.comment.export.h c;
    public Function1<Boolean, Unit> d;
    public final e e;
    public final q1 f;
    public CommentRectF g;
    public final List<String> h;
    public final List<String> i;
    public final Map<String, g> j;
    public boolean k;
    public ArrayList<CommentRectF> l;
    public boolean m;
    public final Map<String, CommentBean> n;
    public final Map<String, CommentRectF> o;
    public final com.bytedance.ee.bear.drive.biz.comment.a p;
    public f85.a q;
    public final com.bytedance.ee.bear.drive.biz.comment.data.m r;
    public final g55.n s;
    public final q75.a t;
    public final Set<com.bytedance.ee.bear.drive.biz.comment.d> u;
    public final Set<p1.a> v;
    public i w;
    public final g85.f x;
    public final f y;
    public final c z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MentionUserState.values().length];
            a = r0;
            r0[MentionUserState.PERMITTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[MentionUserState.NO_PERMISSION_UNSHARABLE_RESIGNED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[MentionUserState.NO_PERMISSION_SHARABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[MentionUserState.NO_PERMISSION_UNSHARABLE_ASK_OWNER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class b implements Function0<Unit> {
        public final /* synthetic */ a1 a;

        public final Object invoke() {
            tt5.a.h("DRIVE_COMMENT_FLOW", "MG inputOpenListener invoke.");
            AbsPreviewView r0 = this.a.f.get();
            if (r0 == null) goto L7;
            r0.onCommentInputPanelOpen();
            return null;
        L7:
            return null;
        }

        public b(a1 r1) {
            this.a = r1;
        }
    }

    public static class c implements Function1<Boolean, Unit> {
        public final Set<Function1<Boolean, Unit>> a;
        public Function1<Boolean, Boolean> b;

        public c() {
            this.a = new HashSet();
        }

        public final Object invoke(Object r3) {
            Boolean r4 = (Boolean) r3;
            Function1<Boolean, Boolean> r0 = this.b;
            if (r0 != null) goto L5;
        L7:
            Iterator r1 = ((HashSet) this.a).iterator();
        L9:
            if (r1.hasNext() == false) goto L12;
            ((Function1) r1.next()).invoke(r4);
            goto L9
        L12:
            return Unit.INSTANCE;
        L5:
            if (Boolean.TRUE.equals(r0.invoke(r4)) == true) goto L7;
            return Unit.INSTANCE;
        }
    }

    public static class d implements com.bytedance.ee.bear.middleground.comment.export.m {
        public final u55.b a;
        public final DriveMetaInfoVM b;
        public final FragmentActivity c;
        public final f85.a d;

        public final void c() {
            DriveMetaInfoVM r0 = this.b;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getLiveMetaInfo() != null) goto L7;
            return;
        L7:
            if (this.b.getLiveMetaInfo().getValue() == null) goto L16;
            f85.a r1 = this.d;
            if (r1 != null) goto L11;
            return;
        L11:
            if (((f85.a.C0229a) r1.a) == null) goto L18;
            ((cj5.c) org.koin.java.a.a(cj5.c.class)).r3(this.c, ((f85.a.C0229a) this.d.a).a, sbb.e.l.b, ((u55.a) this.b.getLiveMetaInfo().getValue()).b, "", "from_banner");
            return;
        L18:
            return;
        }

        public final boolean d() {
            u55.b r0 = this.a;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.b.a.canModifySecretLevel() == false) goto L16;
            DriveMetaInfoVM r1 = this.b;
            if (r1 != null) goto L9;
            return false;
        L9:
            if (r1.getLiveMetaInfo() != null) goto L11;
            return false;
        L11:
            if (this.b.getLiveMetaInfo().getValue() != null) goto L13;
            return false;
        L13:
            return fj5.a.e(((u55.a) this.b.getLiveMetaInfo().getValue()).b);
        L16:
            return false;
        }

        public final boolean a() {
            if (d() == false) goto L6;
            FragmentActivity r0 = this.c;
            Intrinsics.checkNotNullParameter(r0, "context");
            FlowToast.a r1 = FlowToast.a(r0);
            r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
            r1.e(2131889918);
            UDToast.b r2 = new j1(this);
            Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
            r1.b(2131889947, new com.larksuite.component.universe_design.toast.a(r2));
            r1.a().show();
            return false;
        L6:
            return true;
        }

        public final boolean b() {
            if (d() == false) goto L6;
            FragmentActivity r0 = this.c;
            Intrinsics.checkNotNullParameter(r0, "context");
            FlowToast.a r1 = FlowToast.a(r0);
            r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
            r1.e(2131889918);
            UDToast.b r2 = new k1(this);
            Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
            r1.b(2131889947, new com.larksuite.component.universe_design.toast.a(r2));
            r1.a().show();
            return false;
        L6:
            return true;
        }

        public d(FragmentActivity r1, f85.a r2, u55.b r3, DriveMetaInfoVM r4) {
            this.c = r1;
            this.d = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public interface e {
        void a(Runnable r1);

        void cancel();
    }

    public static class f implements Function4<String, String, Integer, Integer, Unit> {
        public final Set<Function1<String, Unit>> a;

        public f() {
            this.a = new HashSet();
        }

        public final Object invoke(Object r1, Object r2, Object r3, Object r4) {
            String r5 = (String) r1;
            String r6 = (String) r2;
            Integer r7 = (Integer) r3;
            Integer r8 = (Integer) r4;
            Iterator r9 = ((HashSet) this.a).iterator();
        L4:
            if (r9.hasNext() == false) goto L7;
            ((Function1) r9.next()).invoke(r5);
            goto L4
        L7:
            return Unit.INSTANCE;
        }
    }

    public static final class g {
        public int a;
        public final long b;

        public g(int r3) {
            this.a = r3;
            this.b = SystemClock.elapsedRealtime();
        }
    }

    public interface h {
        void g(List<String> r1);
    }

    public interface i {
        void a(boolean r1, boolean r2);
    }

    public final synchronized Runnable F() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.T != this.P) goto L6;
        Runnable r0 = this.S;     // Catch: Throwable -> L10
    L7:
        f();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L6:
        r0 = null;
        goto L7
    }

    public final synchronized long e() {
        monitor-enter(this);
        this.P++;     // Catch: Throwable -> L6
        k();     // Catch: Throwable -> L6
        f();     // Catch: Throwable -> L6
        long r0 = this.P;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void f() {
        monitor-enter(this);
        this.T = -1;     // Catch: Throwable -> L7
        this.S = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void p() {
        monitor-enter(this);
        this.P++;     // Catch: Throwable -> L6
        k();     // Catch: Throwable -> L6
        f();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final boolean F7() {
        if (this.B <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void I7() {
        tt5.a.h("DriveCommentWrapper", "closeCommentImage, mComment: " + this.c);
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 == null) goto L6;
        r0.v4();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void J1() {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L5;
    L13:
        p();
        this.e.cancel();
        return;
    L5:
        if (r0.O(false) == false) goto L13;
        monitor-enter(this);
        this.R = this.Q;     // Catch: Throwable -> L10
        monitor-exit(this);
        p();
        this.e.cancel();
        r0.Q0(false, true);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final CommentRectF h() {
        if (this.f.get() == null) goto L5;
        CommentRectF r0 = this.f.get().hideCreateComment();
    L6:
        if (r0 != null) goto L9;
        tt5.a.h("DRIVE_COMMENT_FLOW", "send finish,current have'nt selected rect, set it as page rect");
        CommentRectF r1 = new CommentRectF();
        r1.a = 3;
        return r1;
    L9:
        return r0;
    L5:
        tt5.a.h("DRIVE_COMMENT_FLOW", "mPreviewContainer.get() == null");
        r0 = null;
        goto L6
    }

    public final void i() {
        StringBuilder r0 = new StringBuilder("detach, self: ");
        r0.append(hashCode());
        r0.append(", mComment: ");
        com.bytedance.ee.bear.middleground.comment.export.h r1 = this.c;
        if (r1 != null) goto L5;
        Object r2 = "null";
    L6:
        r0.append(r2);
        tt5.a.h("DriveCommentWrapper", r0.toString());
        monitor-enter(this);
        this.R = this.Q;     // Catch: Throwable -> L22
        monitor-exit(this);
        p();
        this.e.cancel();
        tt5.a.h("DriveCommentWrapper", "destroyAuthorizeListener, mComment: " + this.c);
        com.bytedance.ee.bear.middleground.comment.export.h r3 = this.c;
        if (r3 == null) goto L14;
        r3.b().P();
    L14:
        com.bytedance.ee.bear.middleground.comment.export.h r4 = this.c;
        if (r4 != null) goto L27;
    L20:
        this.l.clear();
        this.m = false;
        ((LinkedHashMap) this.n).clear();
        ((ConcurrentHashMap) this.o).clear();
        ((ConcurrentHashMap) this.j).clear();
        this.r.c();
        this.r.i.remove(this);
        this.r.j.remove(this);
        return;
    L27:
        r4.detach();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        tt5.a.f("DRIVE_PREVIEW_FLOW", e, false);
    L22:
        th = move-exception;
        throw th;
    L5:
        r2 = Integer.valueOf(r1.hashCode());
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final boolean isShowing() {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.O(false);
    }

    public final void k() {
        Disposable r0 = this.N;
        if (r0 != null) goto L5;
    L7:
        this.N = null;
        Disposable r1 = this.O;
        if (r1 != null) goto L10;
    L12:
        this.O = null;
        return;
    L10:
        if (r1.isDisposed() == true) goto L12;
        this.O.dispose();
        goto L12
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.N.dispose();
        goto L7
    }

    public final void l() {
        if (this.c == null) goto L8;
        this.r.i();
        if (this.q == null) goto L7;
        tt5.a.h("DRIVE_COMMENT_FLOW", CommentJsRequestBean.ACTION_FETCH_COMMENT);
        this.c.r().subscribe(new q(this), new r());
        return;
    L7:
        tt5.a.h("DRIVE_COMMENT_FLOW", "fetchComment is cache");
        return;
    L8:
        tt5.a.k("DriveCommentWrapper", "fetchComment() but mComment is null");
    }

    public final void o() {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L5;
    L13:
        p();
        this.e.cancel();
    L14:
        this.s.a(0);
        return;
    L5:
        if (r0.O(false) == false) goto L13;
        monitor-enter(this);
        this.R = this.Q;     // Catch: Throwable -> L10
        monitor-exit(this);
        p();
        this.e.cancel();
        r0.Q0(false, false);
    L10:
        th = move-exception;
        throw th;
    }

    public final void s() {
        ArrayList r1 = new ArrayList();
        Iterator r0 = ((LinkedHashMap) this.n).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r0.next();
        if (((ConcurrentHashMap) this.o).containsKey(r2.getKey()) == false) goto L4;
        r1.add((CommentBean) r2.getValue());
        goto L4
    L8:
        boolean r3 = true;
        if (this.s.h == false) goto L67;
        q1 r4 = this.f;
        if (r4 == null) goto L17;
        AbsPreviewView r5 = r4.get();
        if (r5 == null) goto L17;
        View r6 = r5.getView();
        if (r6 == null) goto L17;
        Context r7 = r6.getContext();
    L18:
        if (r7 != null) goto L20;
        r7 = LarkContext.getApplication();
    L20:
        Context r8 = r7;
        Iterator r9 = r1.iterator();
    L22:
        if (r9.hasNext() == false) goto L67;
        CommentBean r10 = (CommentBean) r9.next();
        if (r10 == null) goto L22;
        if (this.I != null) goto L29;
    L33:
        CommentRectF r11 = (CommentRectF) ((ConcurrentHashMap) this.o).get(r10.getComment_id());
        if (r11 == null) goto L60;
        ArrayMap<String, Integer> r12 = com.bytedance.ee.bear.drive.biz.comment.data.c.a;
        String r13 = r10.getQuote();
        String r14 = r11.j;
        if (r13 == null) goto L60;
        if (TextUtils.isEmpty(r14) == true) goto L60;
        CommentQuote r16 = (CommentQuote) JSON.parseObject(r13, CommentQuote.class);     // Catch: Exception -> L42
    L44:
        if (r16 != null) goto L47;
        tt5.a.d("CommentDataUtils", "transformCommentQuoteType, failed to parse json to CommentQuote.");
        goto L60
    L47:
        if (TextUtils.equals("comment.quote.page", r16.getKey()) == false) goto L60;
        int r17 = r11.e + 1;
        if (TextUtils.isEmpty(r14) == false) goto L120;
    L56:
        String r18 = "";
    L58:
        if (TextUtils.isEmpty(r18) == true) goto L60;
        r10.setQuote(r18);
        goto L60
    L120:
        r18 = JSON.toJSONString(new CommentQuote((String) com.bytedance.ee.bear.drive.biz.comment.data.c.b.get(2131888441), new String[]{String.valueOf(r17), r14}));     // Catch: Exception -> L54
    L54:
        e = move-exception;
        tt5.a.f("CommentDataUtils", e, false);
    L42:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "transformCommentQuoteType, error when parsing json to CommentQuote: ", e, false);
        r16 = null;
    L60:
        ArrayMap<String, Integer> r19 = com.bytedance.ee.bear.drive.biz.comment.data.c.a;
        String r20 = r10.getQuote();
        if (r20 == null) goto L22;
        String r21 = com.bytedance.ee.bear.drive.biz.comment.data.c.b(r8, r20);
        if (r21 == null) goto L22;
        r10.setQuote(r21);
        goto L22
    L29:
        if (this.J == null) goto L33;
        if (TextUtils.equals(r10.getComment_id(), this.I) == false) goto L33;
        tt5.a.h("DriveCommentWrapper", "mergeAndShowDriveAndMGComment, intent comment found, intentCommentId: " + this.I + ", intentReplyId: " + this.J);
        r10.setCurrentReplyId(this.J);
    L17:
        r7 = null;
    L67:
        if (this.l != null) goto L69;
        ArrayList<CommentRectF> r22 = new ArrayList();
    L82:
        tt5.a.h("DRIVE_COMMENT_FLOW", "area comment show size = " + r22.size());
        com.bytedance.ee.bear.middleground.comment.export.h r23 = this.c;
        if (r23 == null) goto L101;
        if (r23.O(false) == false) goto L101;
        if (r1.isEmpty() == false) goto L101;
        long r110 = SystemClock.elapsedRealtime();
        Iterator r24 = ((ConcurrentHashMap) this.j).entrySet().iterator();
    L90:
        if (r24.hasNext() == false) goto L97;
        Map.Entry r26 = (Map.Entry) r24.next();
        if ((r110 - ((g) r26.getValue()).b) < 10000) goto L98;
        if (((ConcurrentHashMap) this.j).remove(r26.getKey(), r26.getValue()) == false) goto L90;
        tt5.a.h("DriveCommentWrapper", "[DriveCommentTrace] fakeCommentSyncTimeout, fakeCommentId=" + du5.b.i((String) r26.getKey()));
    L98:
        if (r3 == false) goto L101;
        return;
    L97:
        r3 = false;
    L101:
        if (this.c != null) goto L124;
    L110:
        this.B = r1.size();
        tt5.a.h("DriveCommentWrapper", "mergeAndShowDriveAndMGComment, intentCommentSource: " + this.H + ", intentCommentId: " + this.I + ", intentReplyId: " + this.J + ", intentImageIndex: " + this.K + ", intentCommentRequestGeneration: " + this.L);
        if (TextUtils.isEmpty(this.I) == true) goto L153;
        Long r27 = this.L;
        if (r27 != null) goto L117;
        Long r28 = Long.valueOf(e());
        y(this.H, this.I, this.J, this.K, r28);
        B(this.I, this.J, this.K, r28.longValue());
        return;
    L117:
        if (q(r27.longValue()) == false) goto L152;
        C(this.I, this.J, this.K, r27.longValue());
        return;
    L152:
        return;
    L153:
        return;
    L124:
        Collections.sort(r1, this.p);     // Catch: Exception -> L104
    L107:
        if (this.f.get() == null) goto L109;
        this.f.get().updateComment(r22);
    L109:
        tt5.a.h("DriveCommentWrapper", "result size = " + r1.size());
        this.c.d(r1);
        this.E.getLiveCommentData().postValue(r1);
    L104:
        e = move-exception;
        tt5.a.f("DRIVE_COMMENT_FLOW", e, false);
        goto L107
    L69:
        tt5.a.h("DRIVE_COMMENT_FLOW", "filterIntersectionWithMiddleGround mSourceCommentRectFList size=" + this.l.size());
        Map<String, CommentBean> r29 = this.n;
        Map<String, CommentRectF> r30 = this.o;
        r22 = new ArrayList();
        if (r29 == null) goto L81;
        if (r30 == null) goto L81;
        Iterator r31 = ((LinkedHashMap) r29).entrySet().iterator();
    L75:
        if (r31.hasNext() == false) goto L80;
        Map.Entry r111 = (Map.Entry) r31.next();
        CommentRectF r112 = (CommentRectF) ((ConcurrentHashMap) r30).get(r111.getKey());
        if (r112 == null) goto L75;
        r112.d = com.bytedance.ee.bear.drive.biz.comment.f.b((CommentBean) r111.getValue());
        r22.add(r112);
        goto L75
    L80:
        Collections.sort(r22, new com.bytedance.ee.bear.drive.biz.comment.e());
    L81:
        tt5.a.b("DRIVE_COMMENT_FLOW", "filterIntersectionWithMiddleGround result=" + r22);
        goto L82
    }

    public final void t() {
        ((ConcurrentHashMap) this.o).clear();
        ArrayList<CommentRectF> r0 = this.l;
        if (CollectionUtils.isEmpty(r0) == false) goto L5;
        tt5.a.d("DriveCommentWrapper", "onDriveAreaCommentUpdate, mSourceCommentRectFList is null or empty, clear mDriveCommentAreaMap.");
    L9:
        s();
        return;
    L5:
        Iterator<CommentRectF> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        CommentRectF r2 = r1.next();
        tt5.a.h("DriveCommentWrapper", "onDriveAreaCommentUpdate, put into mDriveCommentAreaMap: " + r2.b);
        ((ConcurrentHashMap) this.o).put(r2.b, r2);
        goto L7
    }

    public final void v() {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(this.U.invoke()) == false) goto L7;
        Function0<Boolean> r1 = this.V;
    L8:
        r0.h5(r1);
        this.c.v2();
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void E(final int r3) {
        FragmentActivity r0 = this.b;
        if (r0 == null) goto L6;
        r0.runOnUiThread(new x(this, r3));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void E7(String r2) {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.d1().invoke(r2);
        j(JSEventListener.SWITCHCARD);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void G7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.c r2) {
        ((HashSet) this.y.a).add(r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void H7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.C0154a r2) {
        ((HashSet) this.z.a).remove(r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void J7(String r7) {
        B(r7, null, -1, e());
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void K7(p65.a.C0271a r2) {
        ((HashSet) this.v).add(r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void M7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.C0154a r2) {
        ((HashSet) this.z.a).add(r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void N7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.c r2) {
        ((HashSet) this.y.a).remove(r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void O7(p65.a.C0271a r2) {
        ((HashSet) this.v).remove(r2);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.data.m.a
    public final void a(final CommentRectF r5) {
        StringBuilder r0 = new StringBuilder("onAddFailure, update mSourceCommentRectFList, remove: ");
        if (r5 != null) goto L5;
        String r1 = null;
    L6:
        r0.append(r1);
        tt5.a.h("DriveCommentWrapper", r0.toString());
        this.l.remove(r5);
        t();
        if (this.s.h == false) goto L18;
        Toast.cancelLoading();
        AbsPreviewView r2 = this.f.get();
        if (r2 != null) goto L12;
        tt5.a.d("DriveCommentWrapper", "onAddFailure, usingNewUI, previewView is null.");
        return;
    L12:
        View r3 = r2.getView();
        if (r3 != null) goto L16;
        tt5.a.d("DriveCommentWrapper", "onAddFailure, usingNewUI, view of previewView is null.");
        return;
    L16:
        final Context r4 = r3.getContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        FlowToast.a r6 = FlowToast.a(r4);
        r6.e(2131887328);
        UDToast.b r7 = new o0(this, r4, r5);
        Intrinsics.checkNotNullParameter(r7, JSEventListener.ACTION);
        r6.b(2131887322, new com.larksuite.component.universe_design.toast.a(r7));
        r6.d = 4000;
        r6.a().show();
        return;
    L18:
        return;
    L5:
        r1 = r5.b;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.data.m.b
    public final void b(ArrayList<CommentRectF> r3) {
        StringBuilder r0 = new StringBuilder("onDriveCommentDataReceived, replace mSourceCommentRectFList, size: ");
        if (r3 != null) goto L5;
        int r1 = 0;
    L6:
        r0.append(r1);
        tt5.a.h("DriveCommentWrapper", r0.toString());
        this.l = r3;
        t();
        return;
    L5:
        r1 = r3.size();
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.data.m.a
    public final void c(CommentRectF r4) {
        tt5.a.h("DRIVE_COMMENT_FLOW", "add area comment finish= comment =" + r4);
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L6;
        this.e.cancel();
        return;
    L6:
        final String r5 = r4.b;
        if (this.s.h == false) goto L11;
        Toast.cancelLoading();
        this.c.d1().invoke(r5);
        D(r5, new r0(this, r5), e());
        return;
    L11:
        if (r0.i() == true) goto L13;
        return;
    L13:
        this.c.d1().invoke(r5);
        if (this.f.get() == null) goto L17;
        this.f.get().showSelectedComment(r5);
        return;
    }

    public final void j(String r3) {
        tt5.a.h("DriveCommentWrapper", "disableIntentComment, source: " + this.H + ", commentId: " + this.I + ", replyId: " + this.J + ", reason: " + r3);
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = -1;
        this.L = null;
    }

    public final void m(String r9) {
        FragmentActivity r0 = this.b;
        if (r0 != null) goto L5;
    L19:
        tt5.a.d("DriveCommentWrapper", "goToProfileFullscreen, invalid state of activity, userId: " + r9);
        return;
    L5:
        if (r0.isDestroyed() == true) goto L19;
        long r2 = SystemClock.uptimeMillis();
        if ((r2 - this.M) >= 1000) goto L11;
        tt5.a.k("DriveCommentWrapper", "goToProfileFullscreen, open profile too fast, userId: " + r9);
        return;
    L11:
        tt5.a.h("DriveCommentWrapper", "goToProfileFullscreen, userId: " + r9);
        this.M = r2;
        f85.a r1 = this.q;
        if (r1 == null) goto L16;
        w75.b r3 = r1.a;
        if (((f85.a.C0229a) r3) == null) goto L16;
        String r4 = ((f85.a.C0229a) r3).b;
    L17:
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).e(r9, r4);
        return;
    L16:
        r4 = null;
        goto L17
    }

    public final synchronized boolean n(long r4) {
        monitor-enter(this);
        Long r0 = this.L;     // Catch: Throwable -> L12
        if (r0 == null) goto L9;
        if (r0.longValue() != r4) goto L9;
        boolean r5 = true;
    L10:
        monitor-exit(this);
        return r5;
    L9:
        r5 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean q(long r4) {
        monitor-enter(this);
        if (r4 != this.P) goto L7;
        boolean r5 = true;
    L8:
        monitor-exit(this);
        return r5;
    L7:
        r5 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void u(List<CommentBean> r4) {
        this.m = true;
        ((LinkedHashMap) this.n).clear();
        Iterator<CommentBean> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CommentBean r0 = r5.next();
        this.n.put(r0.getComment_id(), r0);
        goto L4
    L6:
        s();
    }

    public final void w(final long r5) {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (this.q == null) goto L17;
        if (r0 == null) goto L19;
        Disposable r1 = r0.r().subscribe(new z(this, r5), new a0(this, r5));
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (r5 != this.P) goto L11;
        this.N = r1;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        r1.dispose();     // Catch: Throwable -> L14
        goto L12
    L19:
        return;
    }

    public final void x(boolean r9) {
        if (r9 == false) goto L4;
        this.c.i1(new com.bytedance.ee.bear.middleground.comment.export.bean.a(com.bytedance.ee.util.ui.n.v(), 0.0f, false, true, false, new i1(this)));
        this.c.T0(new com.bytedance.ee.bear.middleground.comment.export.bean.a(0.0f, com.bytedance.ee.util.ui.n.v(), true, false, false, new z0(this)));
        this.c.p0().e(1);
        return;
    L4:
        this.c.p0().e(0);
        this.c.T0(null);
        this.c.i1(null);
    }

    public static void d(final a1 r4, final List r5) {
        if (r4.c != null) goto L6;
        tt5.a.d("DriveCommentWrapper", "requestPermissionFromOwner, mComment is null, targetUserIds: " + r5);
        return;
    L6:
        if (CollectionUtils.isEmpty(r5) == false) goto L8;
        tt5.a.d("DriveCommentWrapper", "requestPermissionFromOwner, targetUserIds is empty");
        return;
    L8:
        final boolean r1 = true;
        if (r5.size() > 1) goto L12;
        r1 = false;
    L12:
        Toast.cancelLoading();
        FragmentActivity r0 = r4.b;
        if (r0 == null) goto L16;
        if (r1 == true) goto L16;
        Toast.showLoading(r4.b, r0.getString(2131889694));
    L16:
        r4.c.w(r5).subscribe(new p0(r4, r5, r1), new q0(r4, r5, r1));
    }

    public final synchronized void G(long r4, String r6) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r4 == this.P) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (n(r4) == false) goto L11;
        j(r6);     // Catch: Throwable -> L16
    L11:
        this.P++;     // Catch: Throwable -> L16
        k();     // Catch: Throwable -> L16
        e r5 = this.e;     // Catch: Throwable -> L16
        if (r5 == null) goto L14;
        r5.cancel();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
    }

    public final void r(String r3, int r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        g r0 = (g) ((ConcurrentHashMap) this.j).get(r3);
        if (r0 != null) goto L8;
        r0 = new g(r4);
        ((ConcurrentHashMap) this.j).put(r3, r0);
    L10:
        if (r0.a != 3) goto L13;
        ((ConcurrentHashMap) this.j).remove(r3);
        return;
    L13:
        return;
    L8:
        r0.a = r4 | r0.a;
        goto L10
    }

    public final void z(u55.b r3, u55.a r4) {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 == null) goto L9;
        DocMetaInfo r5 = r4.b;
        if (r5 == null) goto L9;
        String r6 = r5.getOwnerUid();
    L10:
        if (r3 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        r0.k(r6, r7, null);
        return;
    L12:
        if (r3.k() == false) goto L14;
        r7 = true;
    L9:
        r6 = null;
        goto L10
    }

    public final void A(CommentRectF r9, boolean r10, long r11) {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L7;
        G(r11, "showComment rect comment is null");
        return;
    L7:
        if (r0.O(false) == true) goto L9;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("comment_view");
    L9:
        x(r10);
        if (r9 != null) goto L12;
    L26:
        l();
        g55.n r12 = this.s;
        if (r12.h == true) goto L30;
        r12.a(8);
    L30:
        if (this.c.O(false) == true) goto L35;
        if (r9 == null) goto L33;
        String r13 = r9.b;
    L34:
        D(r13, new u0(this), r11);
    L37:
        j("showCommentRect");
        return;
    L33:
        r13 = "";
        goto L34
    L35:
        if (r9 == null) goto L37;
        this.c.d1().invoke(r9.b);
        goto L37
    L12:
        if (this.s.h == false) goto L26;
        String r14 = r9.b;
        String r16 = r9.c;
        if (this.c != null) goto L16;
        tt5.a.k("DriveCommentWrapper", "showFeedComment, mComment is null, commentId: " + r14 + ", replyId: " + r16);
        G(r11, "showFeedComment comment is null");
        return;
    L16:
        x(true);
        this.r.i();
        y("Feed", r14, r16, -1, Long.valueOf(r11));
        if (r14 == null) goto L19;
        CommentBean r1 = this.c.V(r14);
    L20:
        if (r1 != null) goto L22;
        B(r14, r16, -1, r11);
        return;
    L22:
        if (r16 == null) goto L24;
        r1.setCurrentReplyId(r16);
    L24:
        C(r14, r16, -1, r11);
        w(r11);
        return;
    L19:
        r1 = null;
        goto L20
    }

    public final void D(final String r9, final Runnable r10, final long r11) {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L6;
        G(r11, "showMiddleGroundComment comment is null");
        return;
    L6:
        Runnable r7 = new b0(this, r11, r9, r10);
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (this.R >= 0) goto L11;
    L16:
        monitor-exit(this);
        boolean r12 = false;
    L18:
        if (r12 == false) goto L21;
        return;
    L21:
        if (r0.O(false) == false) goto L23;
        r7.run();
        return;
    L23:
        this.e.a(r7);
        return;
    L11:
        if (r11 != this.P) goto L16;
        this.T = r11;     // Catch: Throwable -> L25
        this.S = r7;     // Catch: Throwable -> L25
        monitor-exit(this);
        r12 = true;
        goto L18
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void L7(String r9, String r10, int r11) {
        long r6 = e();
        tt5.a.h("DriveCommentWrapper", "showCommentImage, commentId: " + r9 + ", replyId: " + r10 + ", imageIndex: " + r11 + ", mComment: " + this.c);
        if (this.c != null) goto L6;
        G(r6, "showCommentImage comment is null");
        return;
    L6:
        x(false);
        this.r.i();
        y("CommentImage", r9, r10, r11, Long.valueOf(r6));
        if (r9 == null) goto L9;
        CommentBean r0 = this.c.V(r9);
    L10:
        if (r0 != null) goto L12;
        B(r9, r10, r11, r6);
        return;
    L12:
        C(r9, r10, r11, r6);
        w(r6);
        return;
    L9:
        r0 = null;
        goto L10
    }

    public final void g(boolean r7, String r8, String r9) {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c;
        if (r0 != null) goto L7;
        tt5.a.d("DriveCommentWrapper", "createNewComment() but mComment is null");
        return;
    L7:
        if (r0.u0() == null) goto L13;
        if (this.c.u0().a() == true) goto L13;
        tt5.a.d("DriveCommentWrapper", "createNewComment() but mComment intercepted");
        return;
    L13:
        if (this.f.get() == null) goto L15;
        String r1 = this.f.get().getCommentQuote();
    L17:
        if (TextUtils.isEmpty(r1) == true) goto L24;
    L22:
        String r2 = "DriveCommentWrapper" + UUID.randomUUID().toString();
        CommentInputRequest r3 = new CommentInputRequest();
        r3.local_comment_id = r2;
        r3.is_whole = !r7;
        r3.isDrive = true;
        r3.quote = r1;
        r3.show_voice = true;
        r3.type = 0;
        r3.setNeed_loading(this.s.h);
        r3.inputHint = r8;
        r3.from = r9;
        this.g = null;
        this.c.l0(this.k, r7);
        this.c.S(r3);
        return;
    L24:
        r1 = JSON.toJSONString(new CommentQuote((String) com.bytedance.ee.bear.drive.biz.comment.data.c.b.get(2131888387), new String[0]));     // Catch: Exception -> L20
    L20:
        e = move-exception;
        tt5.a.f("CommentDataUtils", e, false);
        r1 = "";
        goto L22
    L15:
        r1 = null;
        goto L17
    }

    public final void B(final String r9, String r10, int r11, final long r12) {
        if (this.c != null) goto L6;
        tt5.a.k("DriveCommentWrapper", "showComment, mComment is null, commentId: " + r9);
        G(r12, "showComment comment is null");
        return;
    L6:
        tt5.a.h("DriveCommentWrapper", "showComment, commentId: " + r9);
        if (TextUtils.isEmpty(r9) == false) goto L10;
        A(null, false, r12);
        return;
    L10:
        if (this.q == null) goto L28;
        Long r0 = this.L;
        if (TextUtils.isEmpty(this.I) == true) goto L16;
        if (r0 == null) goto L16;
        if (r0.longValue() != r12) goto L16;
    L17:
        tt5.a.h("DRIVE_COMMENT_FLOW", CommentJsRequestBean.ACTION_FETCH_COMMENT);
        Disposable r13 = this.c.r().subscribe(new s(this, r9, r12), new t(this, r12));
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L20:
        if (r12 != this.P) goto L22;
        this.N = r13;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L22:
        r13.dispose();     // Catch: Throwable -> L25
    L16:
        y("Direct", r9, r10, r11, Long.valueOf(r12));
        goto L17
    L28:
        tt5.a.h("DRIVE_COMMENT_FLOW", "fetchComment is cache");
    }

    public final void C(final String r9, String r10, int r11, final long r12) {
        if (q(r12) == true) goto L6;
        return;
    L6:
        if (this.c != null) goto L9;
        tt5.a.k("DriveCommentWrapper", "ShowCommentDirectly, mComment is null.");
        G(r12, "showCommentDirectly comment is null");
        return;
    L9:
        tt5.a.h("DriveCommentWrapper", "ShowCommentDirectly, commentId: " + r9 + ", replyId: " + r10 + ", imageIndex: " + r11);
        List r0 = null;
        if (r9 != null) goto L13;
        A(null, false, r12);
        return;
    L13:
        CommentBean r1 = this.c.V(r9);
        if (r1 == null) goto L41;
        j("showCommentDirectly");
        if (r10 == null) goto L38;
        if (r11 < 0) goto L38;
        ArrayMap<String, Integer> r2 = com.bytedance.ee.bear.drive.biz.comment.data.c.a;
        List r3 = r1.getComment_list();
        if (CollectionUtils.isEmpty(r3) == true) goto L33;
        Iterator r4 = r3.iterator();
    L23:
        if (r4.hasNext() == false) goto L33;
        CommentBean.CommentDetail r5 = (CommentBean.CommentDetail) r4.next();
        if (r5 == null) goto L23;
        if (TextUtils.equals(r10, r5.getReply_id()) == false) goto L23;
        CommentBean.CommentDetail.ExtraEntity r6 = r5.getExtra();
        if (r6 == null) goto L33;
        r0 = r6.getImage_list();
    L33:
        List r7 = r0;
        if (CollectionUtils.isEmpty(r7) == false) goto L36;
        tt5.a.d("DriveCommentWrapper", "ShowCommentDirectly - showCommentImageViewer, no images found");
        goto L38
    L36:
        tt5.a.d("DriveCommentWrapper", "ShowCommentDirectly - showCommentImageViewer, no images found");
        this.c.i8(r9, r10, r7, r11, null, CommentImageShowSource.DRIVE);
        return;
    L38:
        D(r9, new j0(this), r12);
        return;
    L41:
        if (this.m == true) goto L45;
        tt5.a.h("DriveCommentWrapper", "showCommentDirectly, isCommentBeanFetched: false, skip and wait.");
        return;
    L45:
        if (this.n.containsKey(r9) == false) goto L48;
        tt5.a.h("DriveCommentWrapper", "showCommentDirectly, isCommentBeanFetched: true, but DataControl not updated, skip and wait.");
        return;
    L48:
        j("showCommentDirectly");
        if (this.c.K(r9) == null) goto L53;
        G(r12, "comment resolved");
        tt5.a.h("DriveCommentWrapper", "ShowCommentDirectly, comment resolved, commentIt: ".concat(r9));
        FragmentActivity r13 = this.b;
        if (r13 == null) goto L76;
        Toast.showText(r13, 2131889661);
        return;
    L76:
        return;
    L53:
        Flowable r14 = this.c.b().e(r9);
        boolean r16 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.comment.private_comment_permission");
        if (r14 == null) goto L67;
        if (r16 == false) goto L67;
        Disposable r17 = r14.subscribe(new s0(this, r9, r12), new t0(this, r12));
        monitor-enter(this);
    L64:
        th = move-exception;
        throw th;
    L59:
        if (r12 != this.P) goto L61;
        this.O = r17;     // Catch: Throwable -> L64
    L62:
        monitor-exit(this);
        return;
    L61:
        r17.dispose();     // Catch: Throwable -> L64
    L67:
        G(r12, "comment not found or query unavailable");
        tt5.a.h("DriveCommentWrapper", "ShowCommentDirectly, comment not found, queryFlowable null, commentId: ".concat(r9));
        E(2131889344);
    }

    public final void y(String r3, String r4, String r5, int r6, Long r7) {
        tt5.a.h("DriveCommentWrapper", "setIntentComment, source: " + r3 + ", commentId: " + r4 + ", replyId: " + r5 + ", imageIndex: " + r6 + ", requestGeneration: " + r7);
        this.H = r3;
        this.I = r4;
        this.J = r5;
        this.K = r6;
        this.L = r7;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.drive.biz.comment.v0] */
    public a1(DriveCommentPlugin.d r4, DriveCommentPlugin.e r5, g55.n r6, DriveViewModel r7, Function0 r8, Function0 r9, DriveCommentPlugin.f r10) {
        this.g = null;
        this.h = Collections.synchronizedList(new ArrayList());
        this.i = Collections.synchronizedList(new ArrayList());
        this.j = new ConcurrentHashMap();
        this.l = new ArrayList();
        this.m = false;
        this.n = new LinkedHashMap();
        ConcurrentHashMap r1 = new ConcurrentHashMap();
        this.o = r1;
        this.p = new com.bytedance.ee.bear.drive.biz.comment.a(r1);
        this.u = new HashSet();
        this.v = new HashSet();
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = -1;
        this.L = null;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = 0;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = -1;
        this.W = new b(this);
        this.X = new v0(this);
        this.a = DevEnvUtil.isDebugMode(r4.getActivity());
        this.C = r4;
        this.U = r8;
        this.V = r9;
        this.e = r10;
        this.F = r7;
        DriveCommentVM r11 = (DriveCommentVM) r4.a(DriveCommentVM.class);
        this.E = r11;
        this.r = r11.getCommentDataManger();
        this.b = r4.getActivity();
        this.f = r5;
        this.A = (FrameLayout) r4.b();
        this.s = r6;
        this.G = (DriveMGPermissionVM) r4.a(DriveMGPermissionVM.class);
        this.t = o75.b.a().getDriveConfig();
        this.x = o75.b.a().getMimeTypeManager();
        this.y = new f();
        c r12 = new c();
        this.z = r12;
        r12.b = new w0(this);
    }
}
