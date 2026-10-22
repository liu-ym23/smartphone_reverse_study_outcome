package og9;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f523210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f523211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f523212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f523213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.router.c f523214e;

    /* JADX INFO: renamed from: og9.a$a, reason: collision with other inner class name */
    public static final class C7052a {
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b implements n26.a.InterfaceC6883a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f523215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f523216b;

        @Override // n26.a.InterfaceC6883a
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "finalSchema");
            FLogger.f375446a.i("AnnieXRedirectInterceptor", "redirect success, url: " + this.f523215a.element + ", finalSchema: " + r100 + ", canRedirectInNewRoute: " + this.f523216b.f523212c);
            a r101 = this.f523216b;
            r101.f523211b = r100;
            if (r101.f523212c == false) goto L6;
            r101.c();
            return;
        }

        public b(Ref.ObjectRef<String> r100, a r101) {
            this.f523215a = r100;
            this.f523216b = r101;
        }

        @Override // n26.a.InterfaceC6883a
        public final void onFail(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.e("AnnieXRedirectInterceptor", "redirect fail, url: " + this.f523215a.element + " , code: " + r100 + ", msg: " + r101);
        }
    }

    static {
    }

    public final void c() {
        String r100 = this.f523211b;
        if (r100 != null) goto L5;
        return;
    L5:
        Context r101 = this.f523213d;
        if (r101 != null) goto L8;
        return;
    L8:
        com.bytedance.router.c r102 = this.f523214e;
        if (r102 != null) goto L11;
        return;
    L11:
        this.f523212c = false;
        i r103 = SmartRouter.buildRoute(r101, r100);
        int r104 = r102.f267534h;
        int r105 = r102.f267535i;
        r103.f267555d = r104;
        r103.f267556e = r105;
        r103.d();
    }

    public a() {
        this.f523210a = AppHost.f326268a.getApplication();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v22, types: [T, java.lang.String] */
    @Override // q97.a
    public final boolean b(com.bytedance.router.c r110) {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        if (r110 == null) goto L40;
        ?? r101 = r110.f267529c;
        if (r101 == 0) goto L40;
        r100.element = r101;
        if (StringsKt.contains$default(r101, "annie_redirect", false, 2, null) == false) goto L10;
    L12:
        FLogger r102 = FLogger.f375446a;
        r102.i("AnnieXRedirectInterceptor", "find redirect url: " + ((String) r100.element));
        Uri r103 = UriProtector.parse((String) r100.element);
        if (Intrinsics.areEqual(r103.getHost(), "annie_redirect") == true) goto L19;
        if (Intrinsics.areEqual(r103.getHost(), "webcast_redirect") == true) goto L19;
        r102.e("AnnieXRedirectInterceptor", "invalid redirect url: " + ((String) r100.element));
        return false;
    L19:
        if (Intrinsics.areEqual(r103.getHost(), "webcast_redirect") == false) goto L21;
        r100.element = r103.buildUpon().authority("annie_redirect").build().toString();
    L21:
        com.bytedance.android.anniex.assemble.a r104 = com.bytedance.android.anniex.assemble.a.f40251a;
        ((com.bytedance.ies.bullet.redirect.a) com.bytedance.android.anniex.assemble.a.f(this.f523210a)).d(new n26.a.b(AppHost.f326268a.getVersionName()));
        this.f523211b = null;
        this.f523213d = null;
        this.f523214e = r110;
        if (((com.bytedance.ies.bullet.redirect.a) com.bytedance.android.anniex.assemble.a.f(this.f523210a)).a((String) r100.element, new b(r100, this)) == true) goto L25;
        r102.e("AnnieXRedirectInterceptor", "redirect not handled, url: " + ((String) r100.element) + ' ');
        return false;
    L25:
        String r105 = this.f523211b;
        if (r105 != null) goto L28;
    L31:
        boolean r106 = true;
    L33:
        if (r106 == false) goto L35;
    L38:
        r102.i("AnnieXRedirectInterceptor", "redirect in new route, url: " + ((String) r100.element) + ", finalSchema: " + this.f523211b);
        this.f523212c = true;
        return true;
    L35:
        if (((com.bytedance.ies.bullet.redirect.a) com.bytedance.android.anniex.assemble.a.f(this.f523210a)).b(UriProtector.parse(this.f523211b)) == false) goto L38;
        r102.i("AnnieXRedirectInterceptor", "jump in current route, url: " + ((String) r100.element) + ", finalSchema: " + this.f523211b);
        r110.b(this.f523211b);
        return false;
    L28:
        if (r105.length() == 0) goto L31;
        r106 = false;
        goto L33
    L10:
        if (StringsKt.contains$default((CharSequence) r100.element, "webcast_redirect", false, 2, null) == true) goto L12;
        return false;
    L40:
        return false;
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("onInterceptRoute, url: ");
        if (r101 == null) goto L5;
        String r104 = r101.f267529c;
    L6:
        r103.append(r104);
        r102.i("AnnieXRedirectInterceptor", r103.toString());
        this.f523213d = r100;
        this.f523214e = r101;
        c();
        return true;
    L5:
        r104 = null;
        goto L6
    }
}
