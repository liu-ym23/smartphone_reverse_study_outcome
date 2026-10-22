package mb8;

import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lb8.h;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mb8.a f512789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lb8.a f512790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f512791c;

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f512792a;

        @Override // lb8.h
        public final void b() {
            lb8.a r100 = this.f512792a.f512790b;
            if (r100 == null) goto L6;
            r100.b();
            return;
        }

        public a(c r100) {
            this.f512792a = r100;
        }

        @Override // lb8.h
        public final void a(ow8.a r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            lb8.a r101 = this.f512792a.f512790b;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // lb8.h
        public final void c(ow8.a r100, st8.a r101) {
            lb8.a r102 = this.f512792a.f512790b;
            if (r102 == null) goto L6;
            r102.c(r100, r101, LongClickSource.Thinking);
            return;
        }
    }

    public c() {
        this.f512791c = LazyKt.lazy(new b(this));
    }
}
