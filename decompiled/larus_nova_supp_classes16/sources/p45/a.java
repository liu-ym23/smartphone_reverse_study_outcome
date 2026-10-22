package p45;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.chameleon.AbsChameleonService;
import h18.f;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends AbsChameleonService {
    public static final String c = null;
    public static final String d = null;
    public b a;
    public final C0270a b;

    /* JADX INFO: renamed from: p45.a$a, reason: collision with other inner class name */
    public class C0270a implements mw4.a.InterfaceC0257a {
        public final /* synthetic */ a a;

        @Override // mw4.a.InterfaceC0257a
        public final void onChanged() {
            a r0 = this.a;
            b r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.a == null) goto L9;
            JSONObject r2 = JSON.parseObject(a.e(r0));
            tt5.a.b("DarkModeWebService", "DarkModeWebService onChanged callback = " + r2);
            this.a.a.a.b(r2);
            return;
        }

        public C0270a(a r1) {
            this.a = r1;
        }
    }

    public class b implements i {
        public m a;
        public final /* synthetic */ a b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(a r1) {
            this.b = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            if (r5 != null) goto L6;
            tt5.a.d("JSDarkModeHandler", "JSDarkModeHandler handle, callback is null");
            return;
        L6:
            this.a = r5;
            AppCompatDelegate.getDefaultNightMode();
            JSONObject r0 = JSON.parseObject(a.e(this.b));
            tt5.a.b("JSDarkModeHandler", "DarkModeWebService handle callback = " + r0);
            r5.b(r0);
        }
    }

    static {
        c = String.format("{\"%s\":\"%s\"}", new Object[]{"theme", "light"});
        d = String.format("{\"%s\":\"%s\"}", new Object[]{"theme", "dark"});
    }

    public a() {
        this.b = new C0270a(this);
    }

    public static String e(a r1) {
        r1.getClass();
        Activity r2 = AppLifecycle.a.a.f();
        if (r2 != null) goto L5;
    L9:
        Context r3 = eu5.b.a;
    L11:
        if (f.a(r3) == false) goto L14;
        return d;
    L14:
        return c;
    L5:
        if (r2.isFinishing() == true) goto L9;
        boolean r0 = r2.isDestroyed();
        r3 = r2;
        if (r0 == true) goto L9;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        ((mw4.a) org.koin.java.a.a(mw4.a.class)).b(this.b);
        b r3 = new b(this);
        this.a = r3;
        bindBridgeHandlerAutoUnbind("biz.util.theme", r3);
    }

    public final void onDetachFromWeb(k r2) {
        super.onDetachFromWeb(r2);
        this.a = null;
        ((mw4.a) org.koin.java.a.a(mw4.a.class)).a(this.b);
    }
}
