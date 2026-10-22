package p99;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import q99.i;

/* JADX INFO: loaded from: classes27.dex */
public abstract class d extends c {

    public static final class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f528327b;

        @Override // p99.d
        public final void f(q99.e r100) {
            Intrinsics.checkNotNullParameter(r100, "delivery");
        }

        @Override // p99.d
        public final void g(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // p99.d
        public final void h() {
        }

        @Override // p99.d
        public final void i(boolean r100) {
        }

        @Override // p99.d
        public final void j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "newSectionId");
        }

        @Override // p99.d
        public final void k(String r100) {
        }

        @Override // p99.d
        public final i e() {
            return this.f528327b;
        }

        public a(i r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            super(new n99.a.C6908a());
            this.f528327b = r100;
        }
    }

    public abstract i e();

    public abstract void f(q99.e r100);

    public abstract void g(Message r100);

    public abstract void h();

    public abstract void i(boolean r100);

    public abstract void j(String r100);

    public abstract void k(String r100);

    public d(n99.a r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteGateway");
        super(r100);
    }
}
