package pc7;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.account.dialog.AccountButtonStyle;
import com.bytedance.sdk.account.dialog.Gravity;
import com.bytedance.sdk.account.twiceverify.TwiceVerifyActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.account.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f528539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f528540c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, b> f528541a;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f528542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f528543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f528544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f528545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f528546e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f528547f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f528548g;

        /* JADX INFO: renamed from: pc7.e$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC7179a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f528549a;

            public ViewOnClickListenerC7179a(a r100) {
                this.f528549a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                a r101 = this.f528549a;
                e r102 = r101.f528548g;
                b r103 = r101.f528547f;
                e r104 = e.f528539b;
                if (r102.g(r103) == false) goto L5;
                return;
            L5:
                a r105 = this.f528549a;
                r105.f528548g.d(r105.f528545d, 5, "open twice verify activity fail");
            }
        }

        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f528550a;

            public b(a r100) {
                this.f528550a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                a r101 = this.f528550a;
                r101.f528548g.d(r101.f528545d, 4, "open twice verify activity fail");
            }
        }

        public final void a() {
            Gravity r100 = Gravity.CENTER;
            String r101 = this.f528542a;
            String r102 = this.f528543b;
            hb7.a r103 = new hb7.a(this.f528544c, new b(this));
            String r104 = this.f528546e;
            ViewOnClickListenerC7179a r105 = new ViewOnClickListenerC7179a(this);
            AccountButtonStyle r106 = AccountButtonStyle.NORMAL;
            hb7.a r107 = new hb7.a(r104, r105, 0);
            if (com.bytedance.sdk.account.utils.b.f269536a.a(new hb7.b(r101, r102, r103, r107, false)) == true) goto L6;
            this.f528548g.d(this.f528545d, 3, "show dialog fail");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100, String r101, String r102, String r103, int r104, String r105, b r106) {
            this.f528548g = r100;
            this.f528542a = r101;
            this.f528543b = r102;
            this.f528544c = r103;
            this.f528545d = r104;
            this.f528546e = r105;
            this.f528547f = r106;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f528551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f528552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f528553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f528554d;

        public b() {
        }
    }

    static {
        f528540c = new AtomicInteger(0);
    }

    public static e c() {
        if (f528539b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f528539b != null) goto L9;
        f528539b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f528539b;
    }

    public e() {
        this.f528541a = new ConcurrentHashMap();
    }

    public static JSONObject f(JSONObject r100) {
        if (r100 != null) goto L5;
    L13:
        return new JSONObject("").optJSONObject("data");
    L10:
        e = move-exception;
        d.b(6, "TwiceVerifyManager", "", e);
        return null;
    L5:
        if (r100.has("data") == false) goto L13;
        return r100.optJSONObject("data");
    }

    public final b a(int r100) {
        b r101 = (b) ((ConcurrentHashMap) this.f528541a).get(Integer.valueOf(r100));
        if (r101 != null) goto L11;
        if (r100 > 0) goto L11;
        int r102 = f528540c.get();
    L6:
        if (r102 <= 0) goto L11;
        r101 = (b) ((ConcurrentHashMap) this.f528541a).get(Integer.valueOf(r102));
        if (r101 != null) goto L11;
        r102 = r102 - 1;
    L11:
        return r101;
    }

    public final JSONObject b(int r100) {
        d.a("TwiceVerifyManager", "getDecision");
        b r101 = a(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f528553c;
    }

    public final boolean g(b r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        JSONObject r100 = r110.f528553c;
        String r101 = r100.optString("schema");
        String r102 = r100.optString("url");
        r110.f528554d = r100.optJSONObject("biz_params");
        int r103 = com.bytedance.sdk.account.utils.d.f269537a;     // Catch: Throwable -> L29
        monitor-enter(com.bytedance.sdk.account.utils.d.class);     // Catch: Throwable -> L29
        int r104 = com.bytedance.sdk.account.utils.d.f269538b.size();     // Catch: Throwable -> L26
    L9:
        r104 = r104 - 1;     // Catch: Throwable -> L26
        if (r104 < 0) goto L17;
        Activity r105 = com.bytedance.sdk.account.utils.d.f269538b.get(r104);     // Catch: Throwable -> L26
        if (r105 == null) goto L9;
        if (r105.isFinishing() == true) goto L9;
        monitor-exit(com.bytedance.sdk.account.utils.d.class);     // Catch: Throwable -> L29
    L19:
        if (r105 == null) goto L25;
        boolean r106 = r105.isFinishing();     // Catch: Throwable -> L29
        Activity r107 = r105;
        if (r106 == false) goto L23;
        d.a("TwiceVerifyManager", "startTwiceVerify, " + r105.getLocalClassName() + " is finish, use applicationContext");     // Catch: Throwable -> L29
        r107 = r105.getApplicationContext();     // Catch: Throwable -> L29
    L23:
        d.b(3, "TwiceVerifyManager", "startTwiceVerify, startIntent", null);     // Catch: Throwable -> L29
        TwiceVerifyActivity.z1(r107, r101, r102, r100.toString(), r110.f528551a);     // Catch: Throwable -> L29
        return true;
    L25:
        d.a("TwiceVerifyManager", "startTwiceVerify, activity is null");     // Catch: Throwable -> L29
    L31:
        h(r110);
        return false;
    L17:
        r105 = com.bytedance.sdk.account.utils.d.b();     // Catch: Throwable -> L26
        monitor-exit(com.bytedance.sdk.account.utils.d.class);     // Catch: Throwable -> L29
        goto L19
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    }

    public final void h(b r100) {
        if (r100 != null) goto L6;
        d.a("TwiceVerifyManager", "resetStatus entity is null");
        return;
    L6:
        d.a("TwiceVerifyManager", "resetStatus " + r100.f528551a);
        ((ConcurrentHashMap) this.f528541a).remove(Integer.valueOf(r100.f528551a));
    }

    public final boolean i(JSONObject r110, g r111) {
        d.a("TwiceVerifyManager", "startTwiceVerify " + r110);
        if (r110 != null) goto L5;
        return false;
    L5:
        String r100 = r110.optString("schema");
        String r101 = r110.optString("url");
        if (TextUtils.isEmpty(r100) == false) goto L8;
    L36:
        d.a("TwiceVerifyManager", "startTwiceVerify, schema or url is empty, return");
        return false;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L36;
        int r102 = f528540c.addAndGet(1);
        b r103 = new b();
        r103.f528552b = r111;
        r103.f528553c = r110;
        r103.f528551a = r102;
        ((ConcurrentHashMap) this.f528541a).put(Integer.valueOf(r102), r103);
        int r112 = f.f528555a;
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L13
        f.a(r113, r110);     // Catch: Throwable -> L13
        com.bytedance.sdk.account.monitor.a.a("uc_verify_client_notify", r113);     // Catch: Throwable -> L13
    L15:
        boolean r114 = "dialog_verify".equalsIgnoreCase(r110.optString("account_flow", ""));
        JSONObject r104 = r110.optJSONObject("dialog_params");
        if (r104 == null) goto L18;
        String r105 = r104.optString("title");
        String r106 = r104.optString("description");
        String r107 = r104.optString("confirm_btn_text");
        String r108 = r104.optString("cancel_btn_text");
        String r109 = r105;
        String r115 = r107;
    L20:
        if (TextUtils.isEmpty(r106) == false) goto L22;
        String r116 = r110.optString("description");
    L24:
        if (TextUtils.isEmpty(r115) == false) goto L26;
        String r117 = k.c().getString(R.string.account_sdk_twice_verify_confirm);
    L28:
        if (TextUtils.isEmpty(r108) == false) goto L30;
        r108 = k.c().getString(R.string.account_sdk_twice_verify_cancel);
    L30:
        String r118 = r108;
        if (r114 == false) goto L35;
        new Handler(Looper.getMainLooper()).post(new a(this, r109, r116, r118, r102, r117, r103));
        return true;
    L35:
        return g(r103);
    L26:
        r117 = r115;
        goto L28
    L22:
        r116 = r106;
        goto L24
    L18:
        r106 = null;
        r108 = null;
        r115 = null;
        r109 = null;
    L13:
        th = move-exception;
        tb7.a.e("TwiceVerifyMonitorUtils", "uc_verify_client_notify report error, " + th.getMessage());
        goto L15
    }

    public final void d(int r100, int r101, String r102) {
        d.a("TwiceVerifyManager", "onTwiceVerifyError, afid=" + r100 + ", errorCode=" + r101 + ", errorMsg=" + r102);
        b r103 = a(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = f.f528555a;
        f.b(r103.f528553c, r101, r102, "");
        g r105 = r103.f528552b;
        h(r103);
        if (r105 == null) goto L9;
        r105.onFail();
        return;
    }

    public final void e(int r100, String r101, String r102, Map<String, Object> r103, Map<String, Object> r104) {
        d.a("TwiceVerifyManager", "onTwiceVerifySuccess, verifyWay=" + r101 + ", afid=" + r100);
        b r105 = a(r100);
        if (r105 != null) goto L5;
        return;
    L5:
        int r106 = f.f528555a;
        f.b(r105.f528553c, 0, "", r101);
        if (r105.f528552b == null) goto L47;
        HashMap r107 = new HashMap();
        JSONObject r108 = r105.f528554d;
        if (r108 == null) goto L17;
        Iterator<String> r109 = r108.keys();
    L11:
        if (r109.hasNext() == false) goto L17;
        String r110 = r109.next();
        if (TextUtils.isEmpty(r110) == true) goto L11;
        if (r105.f528554d.opt(r110) == null) goto L11;
        r107.put(r110, r105.f528554d.opt(r110).toString());
    L17:
        if (r104 != null) goto L19;
    L29:
        g r111 = r105.f528552b;
        h(r105);
        r111.b(r101, r102, r107, r103);
        return;
    L19:
        if (r104.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, Object>> r112 = r104.entrySet().iterator();
    L22:
        if (r112.hasNext() == false) goto L29;
        Map.Entry<String, Object> r113 = r112.next();
        String r114 = r113.getKey();
        Object r115 = r113.getValue();
        if (TextUtils.isEmpty(r114) == true) goto L22;
        if (r115 == null) goto L22;
        if (TextUtils.isEmpty(r115.toString()) == true) goto L22;
        r107.put(r113.getKey(), r115.toString());
        goto L22
    }
}
