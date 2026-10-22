package g3b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class r implements com.ss.android.lark.biz.im.api.message.params.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g3b.a f479906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f479907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f479908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s f479909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message.SourceType f479910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f479911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f479912g;

    public static final class a implements h, j, i, m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f479913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f479914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f479915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t f479916d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Message.SourceType f479917e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f479918f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CharSequence f479919g;

        @Override // g3b.m
        public final void g() {
            this.f479916d.getClass();
        }

        @Override // g3b.m
        public final void h() {
            this.f479916d.getClass();
        }

        @Override // g3b.i
        public final void i() {
            this.f479915c.getClass();
        }

        public final void l() {
            this.f479914b.f479899a = true;
        }

        @Override // g3b.j
        public final boolean a() {
            return this.f479914b.f479900b;
        }

        @Override // g3b.h
        public final boolean c() {
            return this.f479913a.f479892a;
        }

        @Override // g3b.j
        public final EllipsizeFrameLayout.a e() {
            return this.f479914b.f479901c;
        }

        @Override // g3b.h
        public final boolean f() {
            return this.f479913a.f479893b;
        }

        @Override // g3b.h
        public final z9b.c j() {
            return this.f479913a.f479894c;
        }

        @Override // g3b.j
        public final boolean k() {
            return this.f479914b.f479899a;
        }

        public a() {
            this.f479913a = new b();
            this.f479914b = new g();
            this.f479915c = new e();
            this.f479916d = new t();
            this.f479917e = Message.SourceType.TYPE_FROM_UNKONWN;
        }

        public final void b(boolean r100) {
            this.f479913a.f479892a = false;
        }

        public final void d(boolean r100) {
            this.f479914b.f479900b = true;
        }

        public final void m(EllipsizeFrameLayout.a r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            g r101 = this.f479914b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            r101.f479901c = r100;
        }
    }

    public r(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f479906a = new g3b.a(r100);
        this.f479907b = new f(r100);
        this.f479908c = new d(r100);
        this.f479909d = new s(r100);
        this.f479910e = r100.f479917e;
        this.f479911f = r100.f479918f;
        this.f479912g = r100.f479919g;
    }
}
