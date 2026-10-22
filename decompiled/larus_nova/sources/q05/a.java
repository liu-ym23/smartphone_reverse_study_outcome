package q05;

import androidx.appcompat.app.AppCompatDelegate;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.document.service.ContainerThemeWebService;
import h18.f;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends vv4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f531189c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f531190d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f531191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C7259a f531192b;

    /* JADX INFO: renamed from: q05.a$a, reason: collision with other inner class name */
    public class C7259a implements mw4.a.InterfaceC6863a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f531193a;

        @Override // mw4.a.InterfaceC6863a
        public final void onChanged() {
            b r100 = this.f531193a.f531191a;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.f531194a == null) goto L9;
            JSONObject r101 = JSON.parseObject(a.f531190d);
            tt5.a.b("DarkModeWebService", "DarkModeWebService onChanged callback = " + r101);
            this.f531193a.f531191a.f531194a.b(r101);
            return;
        }

        public C7259a(a r100) {
            this.f531193a = r100;
        }
    }

    public static class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f531194a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            if (r101 != null) goto L6;
            tt5.a.d("JSDarkModeHandler", "JSDarkModeHandler handle, callback is null");
            return;
        L6:
            this.f531194a = r101;
            int r102 = AppCompatDelegate.getDefaultNightMode();
            if (r102 != 1) goto L9;
            String r103 = a.f531189c;
        L16:
            JSONObject r104 = JSON.parseObject(r103);
            tt5.a.b("JSDarkModeHandler", "DarkModeWebService handle callback = " + r104);
            r101.b(r104);
            return;
        L9:
            if (r102 != 2) goto L11;
            r103 = a.f531190d;
            goto L16
        L11:
            if (f.a(eu5.b.f474075a) == false) goto L13;
            r103 = a.f531190d;
            goto L16
        L13:
            r103 = a.f531189c;
            goto L16
        }
    }

    static {
        f531189c = String.format("{\"%s\":\"%s\"}", new Object[]{"theme", "light"});
        f531190d = String.format("{\"%s\":\"%s\"}", new Object[]{"theme", "dark"});
    }

    public a() {
        this.f531192b = new C7259a(this);
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        ((mw4.a) org.koin.java.a.a(mw4.a.class)).b(this.f531192b);
        b r101 = new b();
        this.f531191a = r101;
        bindBridgeHandlerAutoUnbind(ContainerThemeWebService.THEME_CONFIG_JSB_NAME, r101);
    }

    @Override // vv4.a, vv4.m
    public final void onDetachFromWeb(k r100) {
        super.onDetachFromWeb(r100);
        this.f531191a = null;
        ((mw4.a) org.koin.java.a.a(mw4.a.class)).a(this.f531192b);
    }
}
