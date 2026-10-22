package hk8;

import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f485604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hk8.a f485605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f485606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f485607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f485608e;

    public static final class a implements gk8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f485609a;

        @Override // gk8.b
        public final void a() {
            hk8.a r100 = this.f485609a.f485605b;
            boolean r101 = false;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            return;
        L10:
            if (r100 == null) goto L16;
            Function0<Boolean> r103 = r100.f485599m;
            if (r103 == null) goto L16;
            if (r103.invoke().booleanValue() != true) goto L16;
            r101 = true;
        L16:
            if (r101 == false) goto L18;
            return;
        L18:
            e r104 = this.f485609a;
            r104.f485604a = !r104.f485604a;
            b r105 = r104.f485606c;
            if (r105 == null) goto L22;
            r105.a();
            return;
        L22:
            return;
        L5:
            if (r100.f485600n != true) goto L7;
            r102 = true;
            goto L8
        }

        public a(e r100) {
            this.f485609a = r100;
        }

        @Override // gk8.b
        public final void b(String r100, String r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "view");
            b r103 = this.f485609a.f485606c;
            if (r103 == null) goto L6;
            r103.b(r100, r101, r102);
            return;
        }
    }

    public e() {
        this.f485608e = LazyKt.lazy(new d(this));
    }
}
