package l65;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a<T extends NonProguard> implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, b> f507688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f507689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f507690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public py4.h f507691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f507692e;

    /* JADX INFO: renamed from: l65.a$a, reason: collision with other inner class name */
    public class C6654a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f507693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f507694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f507695c;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            NonProguard r100 = this.f507695c.j();
            a r101 = this.f507695c;
            r101.getClass();
            String r102 = r101.getModule();
            Map<String, b> r103 = r101.f507688a;
            if (r101.f507690c == false) goto L5;
            String r104 = "BLOCK_PREVIEW";
        L6:
            b r105 = r103.get(r104);
            if (r105 == null) goto L9;
            String r106 = r105.f507697b;
        L10:
            FollowModuleState r107 = new FollowModuleState(r102, r106, JSON.toJSONString(r100));
            if (this.f507695c.f507691d == null) goto L14;
            tt5.a.h("CCMFollow_vc_follow_module", "onStateChange: followModuleState=" + r107);
            this.f507695c.f507691d.b(r107);
        L14:
            if (this.f507695c.f507692e == null) goto L17;
            tt5.a.h("CCMFollow_vc_follow_module", "onStateChange: notify locationChanged. ");
            a r108 = this.f507695c;
            r108.l(r108.f507692e, r100);
            return;
        L17:
            return;
        L9:
            r106 = "";
            goto L10
        L5:
            r104 = "NOT_BLOCK_PREVIEW";
            goto L6
        }

        public final void b() {
            tt5.a.h("CCMFollow_vc_follow_module", "onStateChange");
            if ((SystemClock.uptimeMillis() - this.f507693a) >= this.f507694b) goto L5;
            return;
        L5:
            this.f507693a = SystemClock.uptimeMillis();
            a();
        }

        public C6654a(a r100) {
            this(r100, 50);
        }

        public C6654a(a r100, long r101) {
            this.f507695c = r100;
            this.f507693a = SystemClock.uptimeMillis();
            this.f507694b = r101;
        }
    }

    public abstract void h(T r100);

    public abstract a<T>.C6654a i();

    public abstract T j();

    public abstract void k(a<T>.C6654a r100);

    public abstract void l(T r100, T r101);

    public abstract Class<T> n();

    @Override // py4.g
    public final String getModule() {
        Map<String, b> r100 = this.f507688a;
        if (this.f507690c == false) goto L5;
        String r101 = "BLOCK_PREVIEW";
    L6:
        b r102 = r100.get(r101);
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102.f507696a;
    L5:
        r101 = "NOT_BLOCK_PREVIEW";
        goto L6
    }

    public final boolean m() {
        if (this.f507689b == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L10;
        tt5.a.b("CCMFollow_vc_follow_module", "name=" + getClass().getSimpleName() + ", intercepted");
    L10:
        return r100;
    L5:
        if (this.f507690c == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void g() {
        NonProguard r100 = j();
        String r101 = getModule();
        Map<String, b> r102 = this.f507688a;
        if (this.f507690c == false) goto L5;
        String r103 = "BLOCK_PREVIEW";
    L6:
        b r104 = r102.get(r103);
        if (r104 == null) goto L9;
        String r105 = r104.f507697b;
    L10:
        FollowModuleState r106 = new FollowModuleState(r101, r105, JSON.toJSONString(r100));
        tt5.a.b("CCMFollow_vc_follow_module", "downLoadStateChange: send state when load success followModuleState=" + r106);
        py4.h r107 = this.f507691d;
        if (r107 == null) goto L14;
        r107.b(r106);
        return;
    L14:
        return;
    L9:
        r105 = "";
        goto L10
    L5:
        r103 = "NOT_BLOCK_PREVIEW";
        goto L6
    }

    public a(Map<String, b> r100) {
        this.f507688a = r100;
        k(i());
    }

    @Override // py4.g
    public final void a(py4.h r100) {
        this.f507691d = r100;
    }

    @Override // py4.g
    public final void b(FollowModuleState r100) {
        tt5.a.h("CCMFollow_vc_follow_module", "updatePresenterState. ");
        if (r100 != null) goto L5;
        this.f507692e = null;
        return;
    L5:
        T r101 = (T) o(r100.data);
        this.f507692e = r101;
        if (r101 == null) goto L10;
        l(r101, j());
        return;
    }

    @Override // py4.g
    public void c(FollowModuleState r100) {
        if (TextUtils.equals(r100.module, getModule()) == false) goto L17;
        String r101 = r100.actionType;
        Map<String, b> r102 = this.f507688a;
        if (this.f507690c == false) goto L7;
        String r103 = "BLOCK_PREVIEW";
    L8:
        b r104 = r102.get(r103);
        if (r104 == null) goto L11;
        String r105 = r104.f507697b;
    L13:
        if (TextUtils.equals(r101, r105) == false) goto L17;
        tt5.a.h("CCMFollow_vc_follow_module", "setState: state=" + r100);
        NonProguard r106 = o(r100.data);
        if (r106 == null) goto L19;
        h(r106);
        return;
    L19:
        return;
    L11:
        r105 = "";
        goto L13
    L7:
        r103 = "NOT_BLOCK_PREVIEW";
    L17:
        tt5.a.k("CCMFollow_vc_follow_module", "setState: STATE is invalid state=" + r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r100) {
        tt5.a.h("CCMFollow_vc_follow_module", "onFollowStateChanged: followState: " + r100);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r100) {
        this.f507690c = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r100) {
        this.f507689b = r100;
    }

    public final T o(String r100) {
        Class<T> r101 = n();
        Field[] r102 = r101.getDeclaredFields();
        JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L9
        int r104 = r102.length;     // Catch: Exception -> L9
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L11;
        if (r103.has(r102[r105].getName()) == true) goto L7;
        r105 = r105 + 1;
        goto L4
    L7:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L21;
        tt5.a.h("CCMFollow_vc_follow_module", "invalid state");
        return null;
    L21:
        return (T) JSON.parseObject(r100, r101);
    L18:
        e = move-exception;
        tt5.a.e("CCMFollow_vc_follow_module", "parseState: ", e, false);
        return null;
    L11:
        r106 = false;
    L9:
        e = move-exception;
        tt5.a.h("CCMFollow_vc_follow_module", "parse state error" + e.getMessage());
        goto L11
    }
}
