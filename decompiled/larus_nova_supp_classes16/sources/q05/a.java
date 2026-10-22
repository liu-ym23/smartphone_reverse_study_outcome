package q05;

import androidx.appcompat.app.AppCompatDelegate;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import h18.f;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends vv4.a {
    public static final String c = null;
    public static final String d = null;
    public b a;
    public final C0275a b;

    /* JADX INFO: renamed from: q05.a$a, reason: collision with other inner class name */
    public class C0275a implements mw4.a.InterfaceC0257a {
        public final /* synthetic */ a a;

        @Override // mw4.a.InterfaceC0257a
        public final void onChanged() {
            b r0 = this.a.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.a == null) goto L9;
            JSONObject r1 = JSON.parseObject(a.d);
            tt5.a.b("DarkModeWebService", "DarkModeWebService onChanged callback = " + r1);
            this.a.a.a.b(r1);
            return;
        }

        public C0275a(a r1) {
            this.a = r1;
        }
    }

    public static class b implements i {
        public m a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            if (r5 != null) goto L6;
            tt5.a.d("JSDarkModeHandler", "JSDarkModeHandler handle, callback is null");
            return;
        L6:
            this.a = r5;
            int r0 = AppCompatDelegate.getDefaultNightMode();
            if (r0 != 1) goto L9;
            String r1 = a.c;
        L16:
            JSONObject r2 = JSON.parseObject(r1);
            tt5.a.b("JSDarkModeHandler", "DarkModeWebService handle callback = " + r2);
            r5.b(r2);
            return;
        L9:
            if (r0 != 2) goto L11;
            r1 = a.d;
            goto L16
        L11:
            if (f.a(eu5.b.a) == false) goto L13;
            r1 = a.d;
            goto L16
        L13:
            r1 = a.c;
            goto L16
        }
    }

    static {
        c = String.format("{\"%s\":\"%s\"}", new Object[]{"theme", "light"});
        d = String.format("{\"%s\":\"%s\"}", new Object[]{"theme", "dark"});
    }

    public a() {
        this.b = new C0275a(this);
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        ((mw4.a) org.koin.java.a.a(mw4.a.class)).b(this.b);
        b r3 = new b();
        this.a = r3;
        bindBridgeHandlerAutoUnbind("biz.util.theme", r3);
    }

    @Override // vv4.a, vv4.m
    public final void onDetachFromWeb(k r2) {
        super.onDetachFromWeb(r2);
        this.a = null;
        ((mw4.a) org.koin.java.a.a(mw4.a.class)).a(this.b);
    }
}
