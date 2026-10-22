package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper;
import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentBuilder;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.SyncReactionResultJsData;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements com.bytedance.ee.bear.middleground.comment.export.r {
    public final CommentBuilder a;
    public CommentStyle b;
    public final Map<CommentStyle, com.bytedance.ee.bear.middleground.comment.export.h> c;
    public final com.bytedance.ee.bear.middleground.comment.c d;
    public final List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> e;
    public final List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> f;
    public final List<Function2<Integer, Boolean, Unit>> g;
    public final List<Function2<Integer, Boolean, Unit>> h;

    public static final class a<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.y(this.a);
        }
    }

    public static final class a0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Integer, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a0(Function1<? super Integer, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.t(this.a);
        }
    }

    public static final class b<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<CommentInputRequest, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super CommentInputRequest, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.U(this.a);
        }
    }

    public static final class b0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Boolean> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b0(Function1<? super String, Boolean> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.M(this.a);
        }
    }

    public static final class c<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.H0(this.a);
        }
    }

    public static final class c0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function3<String, CommentInputRequest, Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c0(Function3<? super String, ? super CommentInputRequest, ? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.j1(this.a);
        }
    }

    public static final class d<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.X(this.a);
        }
    }

    public static final class d0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public d0(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.o1(this.a);
        }
    }

    public static final class e<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.A0(this.a);
        }
    }

    public static final class e0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ String a;

        public e0(String r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.m1(this.a);
        }
    }

    public static final class f<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.u1(this.a);
        }
    }

    public static final class f0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ boolean a;

        public f0(boolean r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.u(this.a);
        }
    }

    public static final class g<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function2<CharSequence, CommentInputRequest, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public g(Function2<? super CharSequence, ? super CommentInputRequest, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.Y(this.a);
        }
    }

    public static final class g0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ArrayList<String> c;

        public g0(String r1, boolean r2, ArrayList<String> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r4) {
            com.bytedance.ee.bear.middleground.comment.export.h r5 = (com.bytedance.ee.bear.middleground.comment.export.h) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            r5.k(this.a, this.b, this.c);
        }
    }

    public static final class h<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.W0(this.a);
        }
    }

    public static final class h0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        public h0(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r3) {
            com.bytedance.ee.bear.middleground.comment.export.h r4 = (com.bytedance.ee.bear.middleground.comment.export.h) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            r4.l0(this.a, this.b);
        }
    }

    public static final class i<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.D(this.a);
        }
    }

    public static final class i0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public i0(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.c1(this.a);
        }
    }

    public static final class j<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.bean.a a;

        public j(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.i1(this.a);
        }
    }

    public static final class j0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function2<String, String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public j0(Function2<? super String, ? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.g0(this.a);
        }
    }

    public static final class k<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.bean.a a;

        public k(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.T0(this.a);
        }
    }

    public static final class k0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function4<String, String, Integer, Integer, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public k0(Function4<? super String, ? super String, ? super Integer, ? super Integer, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.b1(this.a);
        }
    }

    public static final class l<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function2<String, Action, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public l(Function2<? super String, ? super Action, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.L0(this.a);
        }
    }

    public static final class l0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ String a;

        public l0(String r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.o(this.a);
        }
    }

    public static final class m<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public m(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.t0(this.a);
        }
    }

    public static final class m0<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ sbb.e a;

        public m0(sbb.e r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.s(this.a);
        }
    }

    public static final class n<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function0<Unit> a;

        public n(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.G(this.a);
        }
    }

    public static final class o<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public o(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.h1(this.a);
        }
    }

    public static final class p<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Integer, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public p(Function1<? super Integer, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.y0(this.a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.q$q, reason: collision with other inner class name */
    public static final class C0073q<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ tb5.m a;

        public C0073q(tb5.m r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.G0(this.a);
        }
    }

    public static final class r<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function0<Unit> a;

        public r(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.r0(this.a);
        }
    }

    public static final class s<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function0<Boolean> a;

        public s(Function0<Boolean> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.e1(this.a);
        }
    }

    public static final class t<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Boolean> a;

        /* JADX WARN: Multi-variable type inference failed */
        public t(Function1<? super String, Boolean> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.R(this.a);
        }
    }

    public static final class u<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function4<String, Integer, String, Integer, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public u(Function4<? super String, ? super Integer, ? super String, ? super Integer, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.z(this.a);
        }
    }

    public static final class v<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<CommentInputRequest, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public v(Function1<? super CommentInputRequest, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.t1(this.a);
        }
    }

    public static final class w<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function3<String, String, MentionUserState, Boolean> a;

        /* JADX WARN: Multi-variable type inference failed */
        public w(Function3<? super String, ? super String, ? super MentionUserState, Boolean> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.r1(this.a);
        }
    }

    public static final class x<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function2<String, Map<String, ? extends Object>, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public x(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.C0(this.a);
        }
    }

    public static final class y<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public y(Function1<? super String, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.L(this.a);
        }
    }

    public static final class z<T> implements com.bytedance.ee.bear.middleground.comment.s {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public z(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.export.h r3 = (com.bytedance.ee.bear.middleground.comment.export.h) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.q0(this.a);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void detach() {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).detach();
        goto L4
    }

    public final com.bytedance.ee.bear.middleground.comment.export.h n() {
        Map<CommentStyle, com.bytedance.ee.bear.middleground.comment.export.h> r0 = this.c;
        CommentStyle r1 = this.b;
        LinkedHashMap r2 = (LinkedHashMap) r0;
        Object r3 = r2.get(r1);
        Object r4 = r3;
        if (r3 != null) goto L14;
        CommentStyle r5 = this.b;
        CommentBuilder r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "commentStyle");
        r6.o = r5;
        int r7 = Comment.z0;
        Comment r8 = Comment.a.a(this.a);
        com.bytedance.ee.bear.middleground.comment.c r9 = this.d;
        com.bytedance.ee.bear.middleground.comment.uitls.p r10 = r8.r;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "config");
        Iterator r11 = ((ArrayList) r9.b).iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((com.bytedance.ee.bear.middleground.comment.s) r11.next()).a(r10);
        goto L6
    L8:
        r9.a.add(r10);
        Iterator r12 = ((ArrayList) this.e).iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        ((com.bytedance.ee.bear.middleground.comment.s) r12.next()).a(r8);
        goto L10
    L12:
        List<Function2<Integer, Boolean, Unit>> r13 = this.g;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r8.R = r13;
        List<Function2<Integer, Boolean, Unit>> r14 = this.h;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r8.S = r14;
        List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> r15 = this.f;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r8.O = r15;
        r2.put(r1, r8);
        r4 = r8;
    L14:
        return (com.bytedance.ee.bear.middleground.comment.export.h) r4;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void A() {
        n().A();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final int B() {
        return n().B();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.i F0() {
        return n().F0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void J() {
        n().J();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean a1() {
        return n().a1();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.p b() {
        return n().b();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function1<String, Unit> d1() {
        return n().d1();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void f0() {
        n().f0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function2<String, Action, Unit> getFilterData() {
        return n().getFilterData();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h() {
        n().h();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean i() {
        return n().i();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function1<String, Unit> l() {
        return n().l();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final CommentStyle n0() {
        return n().n0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function1<ScrollCommentBean, Unit> q() {
        return n().q();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Flowable<String> r() {
        return n().r();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t2() {
        n().t2();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.m u0() {
        return n().u0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void v2() {
        n().v2();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void v4() {
        n().v4();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.s w0() {
        return n().w0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Function2<CommentBottomPopupData, bf5.b, Unit> x0() {
        return n().x0();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final List<Function2<Integer, Boolean, Unit>> a() {
        return this.g;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final List<Function2<Integer, Boolean, Unit>> c() {
        return this.h;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final List<Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit>> f() {
        return this.f;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final com.bytedance.ee.bear.middleground.comment.export.j p0() {
        return this.d;
    }

    public q(CommentBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "commentBuilder");
        this.a = r2;
        this.b = r2.o;
        this.c = new LinkedHashMap();
        this.d = new com.bytedance.ee.bear.middleground.comment.c(0);
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void A0(Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().A0(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).A0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new e(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void C(boolean r2) {
        n().C(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void C0(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).C0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new x(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void D(Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().D(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).D(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new i(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void F(List<CommentBean> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        n().F(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Fa(CardCommentHeight r2) {
        Intrinsics.checkNotNullParameter(r2, "height");
        n().Fa(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void G(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).G(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new n(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void G0(tb5.m r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).G0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new C0073q(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void H0(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().H0(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).H0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final CommentBean K(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return n().K(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void L(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).L(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new y(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void L0(Function2<? super String, ? super Action, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().L0(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).L0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new l(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void M(Function1<? super String, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().M(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).M(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new b0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.r
    public final void M0(CommentStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "commentStyle");
        if (this.b != r2) goto L5;
        return;
    L5:
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean O(boolean r2) {
        return n().O(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Qa(FocusInputBean r2) {
        Intrinsics.checkNotNullParameter(r2, "focusInputBean");
        n().Qa(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void R(Function1<? super String, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().R(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).R(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new t(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void R0(SmartReplyDataForInsert r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        n().R0(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void S(CommentInputRequest r2) {
        n().S(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.r
    public final void S0(CommentStyle... r7) {
        Intrinsics.checkNotNullParameter(r7, "commentStyle");
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        CommentStyle r3 = r7[r2];
        com.bytedance.ee.bear.middleground.comment.export.h r4 = (com.bytedance.ee.bear.middleground.comment.export.h) ((LinkedHashMap) this.c).get(r3);
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L14;
        com.bytedance.ee.bear.middleground.comment.export.h r6 = (com.bytedance.ee.bear.middleground.comment.export.h) ((LinkedHashMap) this.c).get(r3);
        if (r6 == null) goto L14;
        r6.Q0(false, true);
    L14:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r4.O(false) != true) goto L9;
        r5 = true;
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void T0(com.bytedance.ee.bear.middleground.comment.export.bean.a r3) {
        n().T0(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).T0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new k(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void U(Function1<? super CommentInputRequest, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().U(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).U(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new b(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final CommentBean V(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return n().V(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void W0(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().W0(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).W0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new h(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void X(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().X(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).X(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new d(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Y(Function2<? super CharSequence, ? super CommentInputRequest, Unit> r3) {
        n().Y(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).Y(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new g(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final boolean Z0(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return n().Z0(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void a0(SyncReactionResultJsData r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        n().a0(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void b1(Function4<? super String, ? super String, ? super Integer, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().b1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).b1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new k0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void c1(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().c1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).c1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new i0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void d(List<CommentBean> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        n().d(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void destroy(boolean r3) {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).destroy(r3);
        goto L4
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void e(String r2) {
        n().e(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void e1(Function0<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().e1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).e1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new s(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void g0(Function2<? super String, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().g0(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).g0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new j0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h0(boolean r5) {
        if (n().O(false) == true) goto L10;
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r0.next();
        if (((com.bytedance.ee.bear.middleground.comment.export.h) r2.getValue()).O(false) == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) r2.getValue()).h0(r5);
    L10:
        n().h0(r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h1(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().h1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).h1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new o(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void h5(Function0<Boolean> r2) {
        n().h5(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void i1(com.bytedance.ee.bear.middleground.comment.export.bean.a r3) {
        n().i1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).i1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new j(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void j(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        n().j(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void j1(Function3<? super String, ? super CommentInputRequest, ? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().j1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).j1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void m1(String r3) {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).m1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new e0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void o(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).o(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new l0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void o1(Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).o1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new d0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void q0(Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).q0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new z(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void r0(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).r0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new r(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void r1(Function3<? super String, ? super String, ? super MentionUserState, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).r1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new w(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void s(sbb.e r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TYPE);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).s(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new m0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t(Function1<? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().t(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).t(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new a0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t0(Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).t0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new m(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void t1(Function1<? super CommentInputRequest, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().t1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).t1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new v(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void u(boolean r3) {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).u(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new f0(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void u1(Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().u1(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).u1(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new f(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final Flowable<AskOwnerModel$SendResult> w(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        return n().w(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void y(Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().y(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).y(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new a(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void y0(Function1<? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        n().y0(r3);
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).y0(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new p(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void z(Function4<? super String, ? super Integer, ? super String, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).z(r3);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new u(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void E(CommentInputRequest r2, ze5.c r3) {
        Intrinsics.checkNotNullParameter(r3, "callBack");
        n().E(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void K0(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "createId");
        n().K0(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Q0(boolean r5, boolean r6) {
        if (n().O(false) == true) goto L10;
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r0.next();
        if (((com.bytedance.ee.bear.middleground.comment.export.h) r2.getValue()).O(false) == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) r2.getValue()).Q0(r5, r6);
        goto L6
    L17:
        return;
    L10:
        n().Q0(r5, r6);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void Q6(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        n().Q6(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void g(String r2, DriveCommentWrapper.7 r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        n().g(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void l0(boolean r3, boolean r4) {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).l0(r3, r4);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new h0(r3, r4));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void m(List r2, e1 r3) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        n().m(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void X0(String r2, String r3, Boolean r4) {
        n().X0(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void k(String r3, boolean r4, ArrayList<String> r5) {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground.comment.export.h) ((Map.Entry) r0.next()).getValue()).k(r3, r4, r5);
        goto L4
    L6:
        List<com.bytedance.ee.bear.middleground.comment.s<com.bytedance.ee.bear.middleground.comment.export.h>> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new g0(r3, r4, r5));
        n().k(r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.h
    public final void i8(String r9, String r10, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r11, int r12, CommentBean r13, CommentImageShowSource r14) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r14, "source");
        n().i8(r9, r10, r11, r12, r13, r14);
    }
}
