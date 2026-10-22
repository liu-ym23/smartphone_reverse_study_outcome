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
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f222671J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f222672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentActivity f222673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.export.h f222674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<Boolean, Unit> f222675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f222676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q1 f222677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommentRectF f222678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f222679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f222680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, g> f222681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f222682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<CommentRectF> f222683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f222684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, CommentBean> f222685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, CommentRectF> f222686o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.biz.comment.a f222687p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f85.a f222688q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.biz.comment.data.m f222689r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final g55.n f222690s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final q75.a f222691t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Set<com.bytedance.ee.bear.drive.biz.comment.d> f222692u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Set<p1.a> f222693v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public i f222694w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g85.f f222695x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f f222696y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f222697z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222698a = null;

        static {
            int[] r100 = new int[MentionUserState.values().length];
            f222698a = r100;
            r100[MentionUserState.PERMITTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f222698a[MentionUserState.NO_PERMISSION_UNSHARABLE_RESIGNED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f222698a[MentionUserState.NO_PERMISSION_SHARABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f222698a[MentionUserState.NO_PERMISSION_UNSHARABLE_ASK_OWNER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class b implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a1 f222699a;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            tt5.a.h("DRIVE_COMMENT_FLOW", "MG inputOpenListener invoke.");
            AbsPreviewView r100 = this.f222699a.f222677f.get();
            if (r100 == null) goto L7;
            r100.onCommentInputPanelOpen();
            return null;
        L7:
            return null;
        }

        public b(a1 r100) {
            this.f222699a = r100;
        }
    }

    public static class c implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Function1<Boolean, Unit>> f222700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<Boolean, Boolean> f222701b;

        public c() {
            this.f222700a = new HashSet();
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean r100) {
            Boolean r101 = r100;
            Function1<Boolean, Boolean> r102 = this.f222701b;
            if (r102 != null) goto L5;
        L7:
            Iterator r103 = ((HashSet) this.f222700a).iterator();
        L9:
            if (r103.hasNext() == false) goto L12;
            ((Function1) r103.next()).invoke(r101);
            goto L9
        L12:
            return Unit.INSTANCE;
        L5:
            if (Boolean.TRUE.equals(r102.invoke(r101)) == true) goto L7;
            return Unit.INSTANCE;
        }
    }

    public static class d implements com.bytedance.ee.bear.middleground.comment.export.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u55.b f222702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DriveMetaInfoVM f222703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FragmentActivity f222704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f85.a f222705d;

        public final void c() {
            DriveMetaInfoVM r100 = this.f222703b;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getLiveMetaInfo() != null) goto L7;
            return;
        L7:
            if (this.f222703b.getLiveMetaInfo().getValue() == null) goto L16;
            f85.a r101 = this.f222705d;
            if (r101 != null) goto L11;
            return;
        L11:
            if (((f85.a.C5868a) r101.f558532a) == null) goto L18;
            ((cj5.c) org.koin.java.a.a(cj5.c.class)).r3(this.f222704c, ((f85.a.C5868a) this.f222705d.f558532a).f558557a, sbb.e.f541301l.f541317b, this.f222703b.getLiveMetaInfo().getValue().f548839b, "", "from_banner");
            return;
        L18:
            return;
        }

        public final boolean d() {
            u55.b r100 = this.f222702a;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.f548841b.f234419a.canModifySecretLevel() == false) goto L16;
            DriveMetaInfoVM r101 = this.f222703b;
            if (r101 != null) goto L9;
            return false;
        L9:
            if (r101.getLiveMetaInfo() != null) goto L11;
            return false;
        L11:
            if (this.f222703b.getLiveMetaInfo().getValue() != null) goto L13;
            return false;
        L13:
            return fj5.a.e(this.f222703b.getLiveMetaInfo().getValue().f548839b);
        L16:
            return false;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.export.m
        public final boolean a() {
            if (d() == false) goto L6;
            FragmentActivity r100 = this.f222704c;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            FlowToast.a r101 = FlowToast.a(r100);
            r101.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r100, R.drawable.ud_icon_warning_outlined));
            r101.e(R.string.LarkCCM_Workspace_SecLeviI_Requird_Toast);
            UDToast.b r102 = new j1(this);
            Intrinsics.checkNotNullParameter(r102, "action");
            r101.b(R.string.LarkCCM_Workspace_Security_Button_Set, new com.larksuite.component.universe_design.toast.a(r102));
            r101.a().show();
            return false;
        L6:
            return true;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.export.m
        public final boolean b() {
            if (d() == false) goto L6;
            FragmentActivity r100 = this.f222704c;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            FlowToast.a r101 = FlowToast.a(r100);
            r101.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r100, R.drawable.ud_icon_warning_outlined));
            r101.e(R.string.LarkCCM_Workspace_SecLeviI_Requird_Toast);
            UDToast.b r102 = new k1(this);
            Intrinsics.checkNotNullParameter(r102, "action");
            r101.b(R.string.LarkCCM_Workspace_Security_Button_Set, new com.larksuite.component.universe_design.toast.a(r102));
            r101.a().show();
            return false;
        L6:
            return true;
        }

        public d(FragmentActivity r100, f85.a r101, u55.b r102, DriveMetaInfoVM r103) {
            this.f222704c = r100;
            this.f222705d = r101;
            this.f222702a = r102;
            this.f222703b = r103;
        }
    }

    public interface e {
        void a(Runnable r100);

        void cancel();
    }

    public static class f implements Function4<String, String, Integer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Function1<String, Unit>> f222706a;

        public f() {
            this.f222706a = new HashSet();
        }

        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(String r100, String r101, Integer r102, Integer r103) {
            String r104 = r100;
            Iterator r105 = ((HashSet) this.f222706a).iterator();
        L4:
            if (r105.hasNext() == false) goto L7;
            ((Function1) r105.next()).invoke(r104);
            goto L4
        L7:
            return Unit.INSTANCE;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f222707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f222708b;

        public g(int r100) {
            this.f222707a = r100;
            this.f222708b = SystemClock.elapsedRealtime();
        }
    }

    public interface h {
        void g(List<String> r100);
    }

    public interface i {
        void a(boolean r100, boolean r101);
    }

    public final synchronized Runnable F() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.T != this.P) goto L6;
        Runnable r100 = this.S;     // Catch: Throwable -> L10
    L7:
        f();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L6:
        r100 = null;
        goto L7
    }

    public final synchronized long e() {
        monitor-enter(this);
        this.P++;     // Catch: Throwable -> L6
        k();     // Catch: Throwable -> L6
        f();     // Catch: Throwable -> L6
        long r100 = this.P;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
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
        tt5.a.h("DriveCommentWrapper", "closeCommentImage, mComment: " + this.f222674c);
        com.bytedance.ee.bear.middleground.comment.export.h r100 = this.f222674c;
        if (r100 == null) goto L6;
        r100.v4();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void J1() {
        com.bytedance.ee.bear.middleground.comment.export.h r100 = this.f222674c;
        if (r100 != null) goto L5;
    L13:
        p();
        this.f222676e.cancel();
        return;
    L5:
        if (r100.O(false) == false) goto L13;
        monitor-enter(this);
        this.R = this.Q;     // Catch: Throwable -> L10
        monitor-exit(this);
        p();
        this.f222676e.cancel();
        r100.Q0(false, true);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final CommentRectF h() {
        if (this.f222677f.get() == null) goto L5;
        CommentRectF r100 = this.f222677f.get().hideCreateComment();
    L6:
        if (r100 != null) goto L9;
        tt5.a.h("DRIVE_COMMENT_FLOW", "send finish,current have'nt selected rect, set it as page rect");
        CommentRectF r101 = new CommentRectF();
        r101.f236774a = 3;
        return r101;
    L9:
        return r100;
    L5:
        tt5.a.h("DRIVE_COMMENT_FLOW", "mPreviewContainer.get() == null");
        r100 = null;
        goto L6
    }

    public final void i() {
        StringBuilder r100 = new StringBuilder("detach, self: ");
        r100.append(hashCode());
        r100.append(", mComment: ");
        com.bytedance.ee.bear.middleground.comment.export.h r101 = this.f222674c;
        if (r101 != null) goto L5;
        Object r102 = "null";
    L6:
        r100.append(r102);
        tt5.a.h("DriveCommentWrapper", r100.toString());
        monitor-enter(this);
        this.R = this.Q;     // Catch: Throwable -> L22
        monitor-exit(this);
        p();
        this.f222676e.cancel();
        tt5.a.h("DriveCommentWrapper", "destroyAuthorizeListener, mComment: " + this.f222674c);
        com.bytedance.ee.bear.middleground.comment.export.h r103 = this.f222674c;
        if (r103 == null) goto L14;
        r103.b().P();
    L14:
        com.bytedance.ee.bear.middleground.comment.export.h r104 = this.f222674c;
        if (r104 != null) goto L27;
    L20:
        this.f222683l.clear();
        this.f222684m = false;
        ((LinkedHashMap) this.f222685n).clear();
        ((ConcurrentHashMap) this.f222686o).clear();
        ((ConcurrentHashMap) this.f222681j).clear();
        this.f222689r.c();
        this.f222689r.f222761i.remove(this);
        this.f222689r.f222762j.remove(this);
        return;
    L27:
        r104.detach();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        tt5.a.f("DRIVE_PREVIEW_FLOW", e, false);
    L22:
        th = move-exception;
        throw th;
    L5:
        r102 = Integer.valueOf(r101.hashCode());
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final boolean isShowing() {
        com.bytedance.ee.bear.middleground.comment.export.h r100 = this.f222674c;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.O(false);
    }

    public final void k() {
        Disposable r100 = this.N;
        if (r100 != null) goto L5;
    L7:
        this.N = null;
        Disposable r101 = this.O;
        if (r101 != null) goto L10;
    L12:
        this.O = null;
        return;
    L10:
        if (r101.isDisposed() == true) goto L12;
        this.O.dispose();
        goto L12
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.N.dispose();
        goto L7
    }

    public final void l() {
        if (this.f222674c == null) goto L8;
        this.f222689r.i();
        if (this.f222688q == null) goto L7;
        tt5.a.h("DRIVE_COMMENT_FLOW", CommentJsRequestBean.ACTION_FETCH_COMMENT);
        this.f222674c.r().subscribe(new q(this), new r());
        return;
    L7:
        tt5.a.h("DRIVE_COMMENT_FLOW", "fetchComment is cache");
        return;
    L8:
        tt5.a.k("DriveCommentWrapper", "fetchComment() but mComment is null");
    }

    public final void o() {
        com.bytedance.ee.bear.middleground.comment.export.h r100 = this.f222674c;
        if (r100 != null) goto L5;
    L13:
        p();
        this.f222676e.cancel();
    L14:
        this.f222690s.a(0);
        return;
    L5:
        if (r100.O(false) == false) goto L13;
        monitor-enter(this);
        this.R = this.Q;     // Catch: Throwable -> L10
        monitor-exit(this);
        p();
        this.f222676e.cancel();
        r100.Q0(false, false);
    L10:
        th = move-exception;
        throw th;
    }

    public final void s() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((LinkedHashMap) this.f222685n).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (((ConcurrentHashMap) this.f222686o).containsKey(r102.getKey()) == false) goto L4;
        r100.add((CommentBean) r102.getValue());
        goto L4
    L8:
        boolean r103 = true;
        if (this.f222690s.f480049h == false) goto L67;
        q1 r104 = this.f222677f;
        if (r104 == null) goto L17;
        AbsPreviewView r105 = r104.get();
        if (r105 == null) goto L17;
        View r106 = r105.getView();
        if (r106 == null) goto L17;
        Context r107 = r106.getContext();
    L18:
        if (r107 != null) goto L20;
        r107 = LarkContext.getApplication();
    L20:
        Context r108 = r107;
        Iterator r109 = r100.iterator();
    L22:
        if (r109.hasNext() == false) goto L67;
        CommentBean r110 = (CommentBean) r109.next();
        if (r110 == null) goto L22;
        if (this.I != null) goto L29;
    L33:
        CommentRectF r111 = (CommentRectF) ((ConcurrentHashMap) this.f222686o).get(r110.getComment_id());
        if (r111 == null) goto L60;
        ArrayMap<String, Integer> r112 = com.bytedance.ee.bear.drive.biz.comment.data.c.f222739a;
        String r113 = r110.getQuote();
        String r114 = r111.f236783j;
        if (r113 == null) goto L60;
        if (TextUtils.isEmpty(r114) == true) goto L60;
        CommentQuote r115 = (CommentQuote) JSON.parseObject(r113, CommentQuote.class);     // Catch: Exception -> L42
    L44:
        if (r115 != null) goto L47;
        tt5.a.d("CommentDataUtils", "transformCommentQuoteType, failed to parse json to CommentQuote.");
        goto L60
    L47:
        if (TextUtils.equals("comment.quote.page", r115.getKey()) == false) goto L60;
        int r116 = r111.f236778e + 1;
        if (TextUtils.isEmpty(r114) == false) goto L120;
    L56:
        String r117 = "";
    L58:
        if (TextUtils.isEmpty(r117) == true) goto L60;
        r110.setQuote(r117);
        goto L60
    L120:
        r117 = JSON.toJSONString(new CommentQuote(com.bytedance.ee.bear.drive.biz.comment.data.c.f222740b.get(Integer.valueOf(R.string.Drive_Drive_QuoteText)), new String[]{String.valueOf(r116), r114}));     // Catch: Exception -> L54
    L54:
        e = move-exception;
        tt5.a.f("CommentDataUtils", e, false);
    L42:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "transformCommentQuoteType, error when parsing json to CommentQuote: ", e, false);
        r115 = null;
    L60:
        ArrayMap<String, Integer> r118 = com.bytedance.ee.bear.drive.biz.comment.data.c.f222739a;
        String r119 = r110.getQuote();
        if (r119 == null) goto L22;
        String r120 = com.bytedance.ee.bear.drive.biz.comment.data.c.b(r108, r119);
        if (r120 == null) goto L22;
        r110.setQuote(r120);
        goto L22
    L29:
        if (this.f222671J == null) goto L33;
        if (TextUtils.equals(r110.getComment_id(), this.I) == false) goto L33;
        tt5.a.h("DriveCommentWrapper", "mergeAndShowDriveAndMGComment, intent comment found, intentCommentId: " + this.I + ", intentReplyId: " + this.f222671J);
        r110.setCurrentReplyId(this.f222671J);
    L17:
        r107 = null;
    L67:
        if (this.f222683l != null) goto L69;
        ArrayList<CommentRectF> r121 = new ArrayList();
    L82:
        tt5.a.h("DRIVE_COMMENT_FLOW", "area comment show size = " + r121.size());
        com.bytedance.ee.bear.middleground.comment.export.h r122 = this.f222674c;
        if (r122 == null) goto L101;
        if (r122.O(false) == false) goto L101;
        if (r100.isEmpty() == false) goto L101;
        long r123 = SystemClock.elapsedRealtime();
        Iterator r124 = ((ConcurrentHashMap) this.f222681j).entrySet().iterator();
    L90:
        if (r124.hasNext() == false) goto L97;
        Map.Entry r125 = (Map.Entry) r124.next();
        if ((r123 - ((g) r125.getValue()).f222708b) < 10000) goto L98;
        if (((ConcurrentHashMap) this.f222681j).remove(r125.getKey(), r125.getValue()) == false) goto L90;
        tt5.a.h("DriveCommentWrapper", "[DriveCommentTrace] fakeCommentSyncTimeout, fakeCommentId=" + du5.b.i((String) r125.getKey()));
    L98:
        if (r103 == false) goto L101;
        return;
    L97:
        r103 = false;
    L101:
        if (this.f222674c != null) goto L124;
    L110:
        this.B = r100.size();
        tt5.a.h("DriveCommentWrapper", "mergeAndShowDriveAndMGComment, intentCommentSource: " + this.H + ", intentCommentId: " + this.I + ", intentReplyId: " + this.f222671J + ", intentImageIndex: " + this.K + ", intentCommentRequestGeneration: " + this.L);
        if (TextUtils.isEmpty(this.I) == true) goto L153;
        Long r126 = this.L;
        if (r126 != null) goto L117;
        Long r127 = Long.valueOf(e());
        y(this.H, this.I, this.f222671J, this.K, r127);
        B(this.I, this.f222671J, this.K, r127.longValue());
        return;
    L117:
        if (q(r126.longValue()) == false) goto L152;
        C(this.I, this.f222671J, this.K, r126.longValue());
        return;
    L152:
        return;
    L153:
        return;
    L124:
        Collections.sort(r100, this.f222687p);     // Catch: Exception -> L104
    L107:
        if (this.f222677f.get() == null) goto L109;
        this.f222677f.get().updateComment(r121);
    L109:
        tt5.a.h("DriveCommentWrapper", "result size = " + r100.size());
        this.f222674c.d(r100);
        this.E.getLiveCommentData().postValue(r100);
    L104:
        e = move-exception;
        tt5.a.f("DRIVE_COMMENT_FLOW", e, false);
        goto L107
    L69:
        tt5.a.h("DRIVE_COMMENT_FLOW", "filterIntersectionWithMiddleGround mSourceCommentRectFList size=" + this.f222683l.size());
        Map<String, CommentBean> r128 = this.f222685n;
        Map<String, CommentRectF> r129 = this.f222686o;
        r121 = new ArrayList();
        if (r128 == null) goto L81;
        if (r129 == null) goto L81;
        Iterator r130 = ((LinkedHashMap) r128).entrySet().iterator();
    L75:
        if (r130.hasNext() == false) goto L80;
        Map.Entry r131 = (Map.Entry) r130.next();
        CommentRectF r132 = (CommentRectF) ((ConcurrentHashMap) r129).get(r131.getKey());
        if (r132 == null) goto L75;
        r132.f236777d = com.bytedance.ee.bear.drive.biz.comment.f.b((CommentBean) r131.getValue());
        r121.add(r132);
        goto L75
    L80:
        Collections.sort(r121, new com.bytedance.ee.bear.drive.biz.comment.e());
    L81:
        tt5.a.b("DRIVE_COMMENT_FLOW", "filterIntersectionWithMiddleGround result=" + r121);
        goto L82
    }

    public final void t() {
        ((ConcurrentHashMap) this.f222686o).clear();
        ArrayList<CommentRectF> r100 = this.f222683l;
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        tt5.a.d("DriveCommentWrapper", "onDriveAreaCommentUpdate, mSourceCommentRectFList is null or empty, clear mDriveCommentAreaMap.");
    L9:
        s();
        return;
    L5:
        Iterator<CommentRectF> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        CommentRectF r102 = r101.next();
        tt5.a.h("DriveCommentWrapper", "onDriveAreaCommentUpdate, put into mDriveCommentAreaMap: " + r102.f236775b);
        ((ConcurrentHashMap) this.f222686o).put(r102.f236775b, r102);
        goto L7
    }

    public final void v() {
        com.bytedance.ee.bear.middleground.comment.export.h r100 = this.f222674c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(this.U.invoke()) == false) goto L7;
        Function0<Boolean> r101 = this.V;
    L8:
        r100.h5(r101);
        this.f222674c.v2();
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final void E(final int r100) {
        FragmentActivity r101 = this.f222673b;
        if (r101 == null) goto L6;
        r101.runOnUiThread(new x(this, r100));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void E7(String r100) {
        com.bytedance.ee.bear.middleground.comment.export.h r101 = this.f222674c;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.d1().invoke(r100);
        j(JSEventListener.SWITCHCARD);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void G7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.c r100) {
        ((HashSet) this.f222696y.f222706a).add(r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void H7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.C3210a r100) {
        ((HashSet) this.f222697z.f222700a).remove(r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void J7(String r100) {
        B(r100, null, -1, e());
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void K7(p65.a.C7155a r100) {
        ((HashSet) this.f222693v).add(r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void M7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.C3210a r100) {
        ((HashSet) this.f222697z.f222700a).add(r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void N7(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.c r100) {
        ((HashSet) this.f222696y.f222706a).remove(r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void O7(p65.a.C7155a r100) {
        ((HashSet) this.f222693v).remove(r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.data.m.a
    public final void a(final CommentRectF r100) {
        StringBuilder r101 = new StringBuilder("onAddFailure, update mSourceCommentRectFList, remove: ");
        if (r100 != null) goto L5;
        String r102 = null;
    L6:
        r101.append(r102);
        tt5.a.h("DriveCommentWrapper", r101.toString());
        this.f222683l.remove(r100);
        t();
        if (this.f222690s.f480049h == false) goto L18;
        Toast.cancelLoading();
        AbsPreviewView r103 = this.f222677f.get();
        if (r103 != null) goto L12;
        tt5.a.d("DriveCommentWrapper", "onAddFailure, usingNewUI, previewView is null.");
        return;
    L12:
        View r104 = r103.getView();
        if (r104 != null) goto L16;
        tt5.a.d("DriveCommentWrapper", "onAddFailure, usingNewUI, view of previewView is null.");
        return;
    L16:
        final Context r105 = r104.getContext();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        FlowToast.a r106 = FlowToast.a(r105);
        r106.e(R.string.CreationMobile_Error_Comment_UnableToSend);
        UDToast.b r107 = new o0(this, r105, r100);
        Intrinsics.checkNotNullParameter(r107, "action");
        r106.b(R.string.CreationMobile_Error_Comment_BtnTryAgain, new com.larksuite.component.universe_design.toast.a(r107));
        r106.f417630d = 4000;
        r106.a().show();
        return;
    L18:
        return;
    L5:
        r102 = r100.f236775b;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.data.m.b
    public final void b(ArrayList<CommentRectF> r100) {
        StringBuilder r101 = new StringBuilder("onDriveCommentDataReceived, replace mSourceCommentRectFList, size: ");
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        r101.append(r102);
        tt5.a.h("DriveCommentWrapper", r101.toString());
        this.f222683l = r100;
        t();
        return;
    L5:
        r102 = r100.size();
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.data.m.a
    public final void c(CommentRectF r100) {
        tt5.a.h("DRIVE_COMMENT_FLOW", "add area comment finish= comment =" + r100);
        com.bytedance.ee.bear.middleground.comment.export.h r101 = this.f222674c;
        if (r101 != null) goto L6;
        this.f222676e.cancel();
        return;
    L6:
        final String r102 = r100.f236775b;
        if (this.f222690s.f480049h == false) goto L11;
        Toast.cancelLoading();
        this.f222674c.d1().invoke(r102);
        D(r102, new r0(this, r102), e());
        return;
    L11:
        if (r101.i() == true) goto L13;
        return;
    L13:
        this.f222674c.d1().invoke(r102);
        if (this.f222677f.get() == null) goto L17;
        this.f222677f.get().showSelectedComment(r102);
        return;
    }

    public final void j(String r100) {
        tt5.a.h("DriveCommentWrapper", "disableIntentComment, source: " + this.H + ", commentId: " + this.I + ", replyId: " + this.f222671J + ", reason: " + r100);
        this.H = null;
        this.I = null;
        this.f222671J = null;
        this.K = -1;
        this.L = null;
    }

    public final void m(String r100) {
        FragmentActivity r101 = this.f222673b;
        if (r101 != null) goto L5;
    L19:
        tt5.a.d("DriveCommentWrapper", "goToProfileFullscreen, invalid state of activity, userId: " + r100);
        return;
    L5:
        if (r101.isDestroyed() == true) goto L19;
        long r102 = SystemClock.uptimeMillis();
        if ((r102 - this.M) >= 1000) goto L11;
        tt5.a.k("DriveCommentWrapper", "goToProfileFullscreen, open profile too fast, userId: " + r100);
        return;
    L11:
        tt5.a.h("DriveCommentWrapper", "goToProfileFullscreen, userId: " + r100);
        this.M = r102;
        f85.a r103 = this.f222688q;
        if (r103 == null) goto L16;
        w75.b r104 = r103.f558532a;
        if (((f85.a.C5868a) r104) == null) goto L16;
        String r105 = ((f85.a.C5868a) r104).f558558b;
    L17:
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).e(r100, r105);
        return;
    L16:
        r105 = null;
        goto L17
    }

    public final synchronized boolean n(long r100) {
        monitor-enter(this);
        Long r101 = this.L;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        if (r101.longValue() != r100) goto L9;
        boolean r102 = true;
    L10:
        monitor-exit(this);
        return r102;
    L9:
        r102 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean q(long r100) {
        monitor-enter(this);
        if (r100 != this.P) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void u(List<CommentBean> r100) {
        this.f222684m = true;
        ((LinkedHashMap) this.f222685n).clear();
        Iterator<CommentBean> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        CommentBean r102 = r101.next();
        this.f222685n.put(r102.getComment_id(), r102);
        goto L4
    L6:
        s();
    }

    public final void w(final long r100) {
        com.bytedance.ee.bear.middleground.comment.export.h r101 = this.f222674c;
        if (this.f222688q == null) goto L17;
        if (r101 == null) goto L19;
        Disposable r102 = r101.r().subscribe(new z(this, r100), new a0(this, r100));
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (r100 != this.P) goto L11;
        this.N = r102;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        r102.dispose();     // Catch: Throwable -> L14
        goto L12
    L19:
        return;
    }

    public final void x(boolean r100) {
        if (r100 == false) goto L4;
        this.f222674c.i1(new com.bytedance.ee.bear.middleground.comment.export.bean.a(com.bytedance.ee.util.ui.n.v(), 0.0f, false, true, false, new i1(this)));
        this.f222674c.T0(new com.bytedance.ee.bear.middleground.comment.export.bean.a(0.0f, com.bytedance.ee.util.ui.n.v(), true, false, false, new z0(this)));
        this.f222674c.p0().e(1);
        return;
    L4:
        this.f222674c.p0().e(0);
        this.f222674c.T0(null);
        this.f222674c.i1(null);
    }

    public static void d(final a1 r100, final List r101) {
        if (r100.f222674c != null) goto L6;
        tt5.a.d("DriveCommentWrapper", "requestPermissionFromOwner, mComment is null, targetUserIds: " + r101);
        return;
    L6:
        if (CollectionUtils.isEmpty(r101) == false) goto L8;
        tt5.a.d("DriveCommentWrapper", "requestPermissionFromOwner, targetUserIds is empty");
        return;
    L8:
        final boolean r102 = true;
        if (r101.size() > 1) goto L12;
        r102 = false;
    L12:
        Toast.cancelLoading();
        FragmentActivity r103 = r100.f222673b;
        if (r103 == null) goto L16;
        if (r102 == true) goto L16;
        Toast.showLoading(r100.f222673b, r103.getString(R.string.LarkCCM_Perm_PermissionRequesting_Mobile));
    L16:
        r100.f222674c.w(r101).subscribe(new p0(r100, r101, r102), new q0(r100, r101, r102));
    }

    public final synchronized void G(long r100, String r101) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r100 == this.P) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (n(r100) == false) goto L11;
        j(r101);     // Catch: Throwable -> L16
    L11:
        this.P++;     // Catch: Throwable -> L16
        k();     // Catch: Throwable -> L16
        e r102 = this.f222676e;     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        r102.cancel();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
    }

    public final void r(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        g r102 = (g) ((ConcurrentHashMap) this.f222681j).get(r100);
        if (r102 != null) goto L8;
        r102 = new g(r101);
        ((ConcurrentHashMap) this.f222681j).put(r100, r102);
    L10:
        if (r102.f222707a != 3) goto L13;
        ((ConcurrentHashMap) this.f222681j).remove(r100);
        return;
    L13:
        return;
    L8:
        r102.f222707a = r101 | r102.f222707a;
        goto L10
    }

    public final void z(u55.b r100, u55.a r101) {
        com.bytedance.ee.bear.middleground.comment.export.h r102 = this.f222674c;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L9;
        DocMetaInfo r103 = r101.f548839b;
        if (r103 == null) goto L9;
        String r104 = r103.getOwnerUid();
    L10:
        if (r100 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        r102.k(r104, r105, null);
        return;
    L12:
        if (r100.k() == false) goto L14;
        r105 = true;
    L9:
        r104 = null;
        goto L10
    }

    public final void A(CommentRectF r100, boolean r110, long r111) {
        com.bytedance.ee.bear.middleground.comment.export.h r101 = this.f222674c;
        if (r101 != null) goto L7;
        G(r111, "showComment rect comment is null");
        return;
    L7:
        if (r101.O(false) == true) goto L9;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("comment_view");
    L9:
        x(r110);
        if (r100 != null) goto L12;
    L26:
        l();
        g55.n r112 = this.f222690s;
        if (r112.f480049h == true) goto L30;
        r112.a(8);
    L30:
        if (this.f222674c.O(false) == true) goto L35;
        if (r100 == null) goto L33;
        String r102 = r100.f236775b;
    L34:
        D(r102, new u0(this), r111);
    L37:
        j("showCommentRect");
        return;
    L33:
        r102 = "";
        goto L34
    L35:
        if (r100 == null) goto L37;
        this.f222674c.d1().invoke(r100.f236775b);
        goto L37
    L12:
        if (this.f222690s.f480049h == false) goto L26;
        String r113 = r100.f236775b;
        String r103 = r100.f236776c;
        if (this.f222674c != null) goto L16;
        tt5.a.k("DriveCommentWrapper", "showFeedComment, mComment is null, commentId: " + r113 + ", replyId: " + r103);
        G(r111, "showFeedComment comment is null");
        return;
    L16:
        x(true);
        this.f222689r.i();
        y("Feed", r113, r103, -1, Long.valueOf(r111));
        if (r113 == null) goto L19;
        CommentBean r104 = this.f222674c.V(r113);
    L20:
        if (r104 != null) goto L22;
        B(r113, r103, -1, r111);
        return;
    L22:
        if (r103 == null) goto L24;
        r104.setCurrentReplyId(r103);
    L24:
        C(r113, r103, -1, r111);
        w(r111);
        return;
    L19:
        r104 = null;
        goto L20
    }

    public final void D(final String r100, final Runnable r110, final long r111) {
        com.bytedance.ee.bear.middleground.comment.export.h r101 = this.f222674c;
        if (r101 != null) goto L6;
        G(r111, "showMiddleGroundComment comment is null");
        return;
    L6:
        Runnable r102 = new b0(this, r111, r100, r110);
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (this.R >= 0) goto L11;
    L16:
        monitor-exit(this);
        boolean r103 = false;
    L18:
        if (r103 == false) goto L21;
        return;
    L21:
        if (r101.O(false) == false) goto L23;
        r102.run();
        return;
    L23:
        this.f222676e.a(r102);
        return;
    L11:
        if (r111 != this.P) goto L16;
        this.T = r111;     // Catch: Throwable -> L25
        this.S = r102;     // Catch: Throwable -> L25
        monitor-exit(this);
        r103 = true;
        goto L18
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.p1
    public final void L7(String r100, String r110, int r111) {
        long r101 = e();
        tt5.a.h("DriveCommentWrapper", "showCommentImage, commentId: " + r100 + ", replyId: " + r110 + ", imageIndex: " + r111 + ", mComment: " + this.f222674c);
        if (this.f222674c != null) goto L6;
        G(r101, "showCommentImage comment is null");
        return;
    L6:
        x(false);
        this.f222689r.i();
        y("CommentImage", r100, r110, r111, Long.valueOf(r101));
        if (r100 == null) goto L9;
        CommentBean r102 = this.f222674c.V(r100);
    L10:
        if (r102 != null) goto L12;
        B(r100, r110, r111, r101);
        return;
    L12:
        C(r100, r110, r111, r101);
        w(r101);
        return;
    L9:
        r102 = null;
        goto L10
    }

    public final void g(boolean r100, String r101, String r102) {
        com.bytedance.ee.bear.middleground.comment.export.h r103 = this.f222674c;
        if (r103 != null) goto L7;
        tt5.a.d("DriveCommentWrapper", "createNewComment() but mComment is null");
        return;
    L7:
        if (r103.u0() == null) goto L13;
        if (this.f222674c.u0().a() == true) goto L13;
        tt5.a.d("DriveCommentWrapper", "createNewComment() but mComment intercepted");
        return;
    L13:
        if (this.f222677f.get() == null) goto L15;
        String r104 = this.f222677f.get().getCommentQuote();
    L17:
        if (TextUtils.isEmpty(r104) == true) goto L24;
    L22:
        String r105 = "DriveCommentWrapper" + UUID.randomUUID().toString();
        CommentInputRequest r106 = new CommentInputRequest();
        r106.local_comment_id = r105;
        r106.is_whole = !r100;
        r106.isDrive = true;
        r106.quote = r104;
        r106.show_voice = true;
        r106.type = 0;
        r106.setNeed_loading(this.f222690s.f480049h);
        r106.inputHint = r101;
        r106.from = r102;
        this.f222678g = null;
        this.f222674c.l0(this.f222682k, r100);
        this.f222674c.S(r106);
        return;
    L24:
        r104 = JSON.toJSONString(new CommentQuote(com.bytedance.ee.bear.drive.biz.comment.data.c.f222740b.get(Integer.valueOf(R.string.Drive_Drive_FeedComment)), new String[0]));     // Catch: Exception -> L20
    L20:
        e = move-exception;
        tt5.a.f("CommentDataUtils", e, false);
        r104 = "";
        goto L22
    L15:
        r104 = null;
        goto L17
    }

    public final void B(final String r100, String r110, int r111, final long r112) {
        if (this.f222674c != null) goto L6;
        tt5.a.k("DriveCommentWrapper", "showComment, mComment is null, commentId: " + r100);
        G(r112, "showComment comment is null");
        return;
    L6:
        tt5.a.h("DriveCommentWrapper", "showComment, commentId: " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L10;
        A(null, false, r112);
        return;
    L10:
        if (this.f222688q == null) goto L28;
        Long r101 = this.L;
        if (TextUtils.isEmpty(this.I) == true) goto L16;
        if (r101 == null) goto L16;
        if (r101.longValue() != r112) goto L16;
    L17:
        tt5.a.h("DRIVE_COMMENT_FLOW", CommentJsRequestBean.ACTION_FETCH_COMMENT);
        Disposable r102 = this.f222674c.r().subscribe(new s(this, r100, r112), new t(this, r112));
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L20:
        if (r112 != this.P) goto L22;
        this.N = r102;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L22:
        r102.dispose();     // Catch: Throwable -> L25
    L16:
        y("Direct", r100, r110, r111, Long.valueOf(r112));
        goto L17
    L28:
        tt5.a.h("DRIVE_COMMENT_FLOW", "fetchComment is cache");
    }

    public final void C(final String r100, String r110, int r111, final long r112) {
        if (q(r112) == true) goto L6;
        return;
    L6:
        if (this.f222674c != null) goto L9;
        tt5.a.k("DriveCommentWrapper", "ShowCommentDirectly, mComment is null.");
        G(r112, "showCommentDirectly comment is null");
        return;
    L9:
        tt5.a.h("DriveCommentWrapper", "ShowCommentDirectly, commentId: " + r100 + ", replyId: " + r110 + ", imageIndex: " + r111);
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101 = null;
        if (r100 != null) goto L13;
        A(null, false, r112);
        return;
    L13:
        CommentBean r102 = this.f222674c.V(r100);
        if (r102 == null) goto L41;
        j("showCommentDirectly");
        if (r110 == null) goto L38;
        if (r111 < 0) goto L38;
        ArrayMap<String, Integer> r103 = com.bytedance.ee.bear.drive.biz.comment.data.c.f222739a;
        List<CommentBean.CommentDetail> r104 = r102.getComment_list();
        if (CollectionUtils.isEmpty(r104) == true) goto L33;
        Iterator<CommentBean.CommentDetail> r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L33;
        CommentBean.CommentDetail r106 = r105.next();
        if (r106 == null) goto L23;
        if (TextUtils.equals(r110, r106.getReply_id()) == false) goto L23;
        CommentBean.CommentDetail.ExtraEntity r107 = r106.getExtra();
        if (r107 == null) goto L33;
        r101 = r107.getImage_list();
    L33:
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r108 = r101;
        if (CollectionUtils.isEmpty(r108) == false) goto L36;
        tt5.a.d("DriveCommentWrapper", "ShowCommentDirectly - showCommentImageViewer, no images found");
        goto L38
    L36:
        tt5.a.d("DriveCommentWrapper", "ShowCommentDirectly - showCommentImageViewer, no images found");
        this.f222674c.i8(r100, r110, r108, r111, null, CommentImageShowSource.DRIVE);
        return;
    L38:
        D(r100, new j0(this), r112);
        return;
    L41:
        if (this.f222684m == true) goto L45;
        tt5.a.h("DriveCommentWrapper", "showCommentDirectly, isCommentBeanFetched: false, skip and wait.");
        return;
    L45:
        if (this.f222685n.containsKey(r100) == false) goto L48;
        tt5.a.h("DriveCommentWrapper", "showCommentDirectly, isCommentBeanFetched: true, but DataControl not updated, skip and wait.");
        return;
    L48:
        j("showCommentDirectly");
        if (this.f222674c.K(r100) == null) goto L53;
        G(r112, "comment resolved");
        tt5.a.h("DriveCommentWrapper", "ShowCommentDirectly, comment resolved, commentIt: ".concat(r100));
        FragmentActivity r109 = this.f222673b;
        if (r109 == null) goto L76;
        Toast.showText(r109, R.string.LarkCCM_Notifications_CommentResolved_toast);
        return;
    L76:
        return;
    L53:
        Flowable<String> r113 = this.f222674c.b().e(r100);
        boolean r114 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.comment.private_comment_permission");
        if (r113 == null) goto L67;
        if (r114 == false) goto L67;
        Disposable r115 = r113.subscribe(new s0(this, r100, r112), new t0(this, r112));
        monitor-enter(this);
    L64:
        th = move-exception;
        throw th;
    L59:
        if (r112 != this.P) goto L61;
        this.O = r115;     // Catch: Throwable -> L64
    L62:
        monitor-exit(this);
        return;
    L61:
        r115.dispose();     // Catch: Throwable -> L64
    L67:
        G(r112, "comment not found or query unavailable");
        tt5.a.h("DriveCommentWrapper", "ShowCommentDirectly, comment not found, queryFlowable null, commentId: ".concat(r100));
        E(R.string.LarkCCM_DocxIM_SharePart_CopyFail_Deleted_Toast);
    }

    public final void y(String r100, String r101, String r102, int r103, Long r104) {
        tt5.a.h("DriveCommentWrapper", "setIntentComment, source: " + r100 + ", commentId: " + r101 + ", replyId: " + r102 + ", imageIndex: " + r103 + ", requestGeneration: " + r104);
        this.H = r100;
        this.I = r101;
        this.f222671J = r102;
        this.K = r103;
        this.L = r104;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.drive.biz.comment.v0] */
    public a1(DriveCommentPlugin.d r100, DriveCommentPlugin.e r101, g55.n r102, DriveViewModel r103, Function0 r104, Function0 r105, DriveCommentPlugin.f r110) {
        this.f222678g = null;
        this.f222679h = Collections.synchronizedList(new ArrayList());
        this.f222680i = Collections.synchronizedList(new ArrayList());
        this.f222681j = new ConcurrentHashMap();
        this.f222683l = new ArrayList();
        this.f222684m = false;
        this.f222685n = new LinkedHashMap();
        ConcurrentHashMap r106 = new ConcurrentHashMap();
        this.f222686o = r106;
        this.f222687p = new com.bytedance.ee.bear.drive.biz.comment.a(r106);
        this.f222692u = new HashSet();
        this.f222693v = new HashSet();
        this.H = null;
        this.I = null;
        this.f222671J = null;
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
        this.f222672a = DevEnvUtil.isDebugMode(r100.getActivity());
        this.C = r100;
        this.U = r104;
        this.V = r105;
        this.f222676e = r110;
        this.F = r103;
        DriveCommentVM r107 = (DriveCommentVM) r100.a(DriveCommentVM.class);
        this.E = r107;
        this.f222689r = r107.getCommentDataManger();
        this.f222673b = r100.getActivity();
        this.f222677f = r101;
        this.A = (FrameLayout) r100.b();
        this.f222690s = r102;
        this.G = (DriveMGPermissionVM) r100.a(DriveMGPermissionVM.class);
        this.f222691t = o75.b.a().getDriveConfig();
        this.f222695x = o75.b.a().getMimeTypeManager();
        this.f222696y = new f();
        c r108 = new c();
        this.f222697z = r108;
        r108.f222701b = new w0(this);
    }
}
