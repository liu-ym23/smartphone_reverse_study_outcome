package zz3;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.comment.AosCommentListContainer;
import com.bytedance.awemeopen.apps.framework.comment.CommentListView;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.bizmodels.utils.AwemeCheckUtilsKt;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.a0;
import r14.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends BaseElement<g, h, tz3.a, jz3.a> {
    public static final /* synthetic */ int m = 0;
    public final Activity g;
    public final o h;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b i;
    public jz3.a j;
    public AosCommentListContainer k;
    public final zz3.a l;

    public static final class a {
        public static CommentPageParam a(r14.c r6, String r7, FeedPageConfig r8) {
            Intrinsics.checkNotNullParameter(r6, "aweme");
            Intrinsics.checkNotNullParameter(r7, "sceneId");
            Intrinsics.checkNotNullParameter(r8, "pageConfig");
            CommentPageParam r0 = new CommentPageParam();
            String r1 = r6.c();
            Intrinsics.checkNotNullParameter(r1, "awemeId");
            r0.a = r1;
            r0.u = r6.i();
            User r2 = r6.f();
            String r3 = "";
            if (r2 == null) goto L6;
            String r4 = r2.u();
            if (r4 == null) goto L6;
        L7:
            Intrinsics.checkNotNullParameter(r4, "authorOpenId");
            r0.b = r4;
            boolean r5 = true;
            r0.c = !r6.l();
            j r9 = r6.L();
            if (r9 == null) goto L10;
            long r10 = r9.c();
        L11:
            r0.d = r10;
            User r11 = r6.f();
            if (r11 == null) goto L14;
            Integer r12 = Integer.valueOf(r11.n());
        L15:
            r0.e = r12;
            r0.f = Integer.valueOf(r6.U() ? 1 : 0);
            Intrinsics.checkNotNullParameter(r7, "eventType");
            r0.g = r7;
            a0 r13 = r6.d;
            if (r13 == null) goto L19;
            String r14 = r13.a();
            if (r14 == null) goto L19;
        L20:
            Intrinsics.checkNotNullParameter(r14, "imprId");
            r0.h = r14;
            String r15 = r6.u();
            if (r15 != null) goto L23;
            r15 = "";
        L23:
            Intrinsics.checkNotNullParameter(r15, "hostRawData");
            r0.k = r15;
            JSONObject r16 = r8.getHostExtraParams();
            if (r16 != null) goto L26;
            r16 = new JSONObject();
        L26:
            Intrinsics.checkNotNullParameter(r16, "hostExtraParams");
            r0.l = r16;
            String r17 = r8.getPreviousPage();
            if (r17 == null) goto L30;
            r3 = r17;
        L30:
            Intrinsics.checkNotNullParameter(r3, "previousPage");
            r0.j = r3;
            if (r6.W() == false) goto L33;
            String r18 = "origin";
        L34:
            Intrinsics.checkNotNullParameter(r18, "groupSource");
            r0.i = r18;
            r0.m = r8.getCommentBottomMargin();
            d14.a r19 = b14.a.a;
            r0.p = b14.a.a(l24.c.class).a(r6);
            r0.q = r8.isTeenagerModel();
            String r20 = r8.getHostEnterFrom();
            Intrinsics.checkNotNullParameter(r20, "hostEnterFrom");
            r0.r = r20;
            if (Intrinsics.areEqual(r8.getEnterAid(), r6.c()) == false) goto L37;
            String r21 = PinchEnterMethod.CLICK;
        L38:
            Intrinsics.checkNotNullParameter(r21, "actionType");
            r0.s = r21;
            User r22 = r6.f();
            if (r22 != null) goto L41;
        L43:
            r5 = false;
        L44:
            r0.t = r5;
            int r23 = com.bytedance.awemeopen.apps.framework.utils.e.c;
            r0.v = com.bytedance.awemeopen.apps.framework.utils.e.a.a(r6);
            return r0;
        L41:
            if (r22.R() != true) goto L43;
        L37:
            r21 = "draw";
            goto L38
        L33:
            r18 = "sdk";
        L19:
            r14 = "";
            goto L20
        L14:
            r12 = null;
            goto L15
        L10:
            r10 = 0;
        L6:
            r4 = "";
            goto L7
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements s24.b {
        public final pz3.d a;
        public final /* synthetic */ d b;

        public c(d r2) {
            this.b = r2;
            this.a = new pz3.d(96);
        }

        public final void a(float r2, float r3) {
            pz3.d r0 = this.a;
            r0.a = r2;
            r0.b = r3;
            r0.f = false;
            r0.g = true;
            this.b.h.getVideoScaling().setValue(this.a);
        }
    }

    /* JADX INFO: renamed from: zz3.d$d, reason: collision with other inner class name */
    public static final class C0195d implements com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0 {
        public final /* synthetic */ d a;

        @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0
        public final void onClose() {
            this.a.h.setCommentShowState(0);
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
            AoLogger.b("comment", new Object[]{"close comment"});
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0
        public final void onOpen() {
            this.a.h.setCommentShowState(1);
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
            AoLogger.b("comment", new Object[]{"open comment"});
        }

        public C0195d(d r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new h();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new f(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        AosCommentListContainer r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L10:
        if (r1 == false) goto L19;
        if (r0 == null) goto L20;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        r0.j.a();     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r0.j.e != 1) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
        r1 = true;
        goto L10
    L7:
        r4 = false;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        LifecycleOwner r0 = this.i.d;
        if (r0 == null) goto L7;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L7;
        r1.removeObserver(this.l);
    L7:
        AosCommentListContainer r2 = this.k;
        if (r2 == null) goto L12;
        CommentListView r3 = r2.g;
        if (r3 == null) goto L12;
        r3.u();
    L12:
        this.k = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        g r0 = g();
        Observer<Boolean> r1 = new zz3.c(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.a.c;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r5) {
        final jz3.a r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        if (AosExtConfig.b.getCommentConfig().a == true) goto L5;
    L17:
        j();
        return;
    L5:
        if (this.h.getPageConfig().getShowComment() == false) goto L17;
        if (this.h.getPageConfig().isTeenagerModel() == true) goto L17;
        p();
        this.j = r6;
        h r0 = h();
        j r1 = r6.a.L();
        if (r1 == null) goto L11;
        long r2 = r1.c();
    L12:
        r0.b(r2);
        this.i.d.getLifecycle().addObserver(this.l);
        CommentInputContentViewModel.a r3 = CommentInputContentViewModel.Companion;
        ViewModelStoreOwner r4 = this.i.e;
        r3.getClass();
        CommentInputContentViewModel r7 = CommentInputContentViewModel.a.a(r4);
        if (r7 == null) goto L19;
        MutableLiveData<Integer> r8 = r7.getPublishSuccessLiveData();
        if (r8 == null) goto L20;
        r8.observe(this.i.d, new zz3.b(this, r6));
        return;
    L20:
        return;
    L19:
        return;
    L11:
        Long r9 = 0L;
        AwemeCheckUtilsKt.a(r9, null, 3);
        r2 = r9.longValue();
        goto L12
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [zz3.a] */
    public d(Activity r2, o r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "pageOwner");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.l = new zz3.a(this);
    }
}
