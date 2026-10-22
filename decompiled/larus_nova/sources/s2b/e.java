package s2b;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.base.model.MessageContentFoldingControlParams;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f540353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b> f540354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f540355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f540356d;

    public interface a {
        void a(String r100);
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f540357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f540358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EllipsizeFrameLayout.a f540359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f540360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f540361e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f540362f;

        public b() {
            this.f540357a = true;
            this.f540358b = true;
            MessageContentFoldingControlParams r100 = (MessageContentFoldingControlParams) SettingManager.getInstance().get(MessageContentFoldingControlParams.class);
            this.f540359c = new EllipsizeFrameLayout.a(r100.b(), r100.a());
        }
    }

    public e() {
        this.f540356d = new HashMap();
        this.f540354b = new HashMap();
    }

    public final EllipsizeFrameLayout.a a(String r100) {
        b r101 = (b) ((HashMap) this.f540354b).get(r100);
        if (r101 != null) goto L5;
        MessageContentFoldingControlParams r102 = (MessageContentFoldingControlParams) SettingManager.getInstance().get(MessageContentFoldingControlParams.class);
        return new EllipsizeFrameLayout.a(r102.d(), r102.c());
    L5:
        return r101.f540359c;
    }

    public final void b(String r100) {
        if (((HashMap) this.f540354b).containsKey(r100) == true) goto L6;
        Map<String, b> r101 = this.f540354b;
        HashMap r102 = (HashMap) r101;
        r102.put(r100, new b());
        return;
    }

    public final boolean c(String r100) {
        b r101 = (b) ((HashMap) this.f540354b).get(r100);
        if (r101 != null) goto L5;
        return true;
    L5:
        return r101.f540357a;
    }

    public final void d(String r100) {
        a r101 = this.f540355c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void e(String r100) {
        b r101 = (b) ((HashMap) this.f540354b).get(r100);
        if (r101 != null) goto L6;
        r101 = new b();
        ((HashMap) this.f540354b).put(r100, r101);
    L6:
        if (r101.f540357a == false) goto L9;
        r101.f540357a = false;
        d(r100);
        return;
    }

    public final void i(String r100) {
        String r101 = this.f540353a;
        if (r101 != null) goto L6;
        this.f540353a = r100;
        d(r100);
        return;
    L6:
        if (r100.equals(r101) == false) goto L8;
        this.f540353a = null;
        d(r100);
        return;
    L8:
        this.f540353a = r100;
        d(r100);
        d(r101);
    }

    public final void g(String r100, boolean r101) {
        b r102 = (b) ((HashMap) this.f540354b).get(r100);
        if (r102 != null) goto L5;
        r102 = new b();
        ((HashMap) this.f540354b).put(r100, r102);
    L5:
        Boolean r103 = r102.f540362f;
        if (r103 != null) goto L8;
    L9:
        r102.f540362f = Boolean.valueOf(r101);
        d(r100);
        return;
    L8:
        if (r103.booleanValue() != r101) goto L9;
    }

    public final void h(String r100, boolean r101) {
        b r102 = (b) ((HashMap) this.f540354b).get(r100);
        if (r102 != null) goto L6;
        r102 = new b();
        ((HashMap) this.f540354b).put(r100, r102);
    L6:
        if (r102.f540358b == r101) goto L9;
        r102.f540358b = r101;
        d(r100);
        return;
    }

    public final void f(String r100, String r101, boolean r102) {
        b r103 = (b) ((HashMap) this.f540354b).get(r100);
        if (r103 != null) goto L6;
        r103 = new b();
        ((HashMap) this.f540354b).put(r100, r103);
    L6:
        if (r103.f540360d == r102) goto L9;
        r103.f540360d = r102;
        r103.f540361e = r101;
        d(r100);
        return;
    }
}
