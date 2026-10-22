package l65;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a<T extends NonProguard> implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.e {
    public final Map<String, b> a;
    public boolean b;
    public boolean c;
    public py4.h d;
    public T e;

    /* JADX INFO: renamed from: l65.a$a, reason: collision with other inner class name */
    public class C0248a implements h {
        public long a;
        public final long b;
        public final /* synthetic */ a c;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            NonProguard r0 = this.c.j();
            a r1 = this.c;
            r1.getClass();
            String r3 = r1.getModule();
            Map<String, b> r4 = r1.a;
            if (r1.c == false) goto L5;
            String r2 = "BLOCK_PREVIEW";
        L6:
            b r5 = r4.get(r2);
            if (r5 == null) goto L9;
            String r6 = r5.b;
        L10:
            FollowModuleState r7 = new FollowModuleState(r3, r6, JSON.toJSONString(r0));
            if (this.c.d == null) goto L14;
            tt5.a.h("CCMFollow_vc_follow_module", "onStateChange: followModuleState=" + r7);
            this.c.d.b(r7);
        L14:
            if (this.c.e == null) goto L17;
            tt5.a.h("CCMFollow_vc_follow_module", "onStateChange: notify locationChanged. ");
            a r8 = this.c;
            r8.l(r8.e, r0);
            return;
        L17:
            return;
        L9:
            r6 = "";
            goto L10
        L5:
            r2 = "NOT_BLOCK_PREVIEW";
            goto L6
        }

        public final void b() {
            tt5.a.h("CCMFollow_vc_follow_module", "onStateChange");
            if ((SystemClock.uptimeMillis() - this.a) >= this.b) goto L5;
            return;
        L5:
            this.a = SystemClock.uptimeMillis();
            a();
        }

        public C0248a(a r3) {
            this(r3, 50);
        }

        public C0248a(a r3, long r4) {
            this.c = r3;
            this.a = SystemClock.uptimeMillis();
            this.b = r4;
        }
    }

    public abstract void h(T r1);

    public abstract a<T>.C0248a i();

    public abstract T j();

    public abstract void k(a<T>.C0248a r1);

    public abstract void l(T r1, T r2);

    public abstract Class<T> n();

    @Override // py4.g
    public final String getModule() {
        Map<String, b> r0 = this.a;
        if (this.c == false) goto L5;
        String r1 = "BLOCK_PREVIEW";
    L6:
        b r2 = r0.get(r1);
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2.a;
    L5:
        r1 = "NOT_BLOCK_PREVIEW";
        goto L6
    }

    public final boolean m() {
        if (this.b == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        tt5.a.b("CCMFollow_vc_follow_module", "name=" + getClass().getSimpleName() + ", intercepted");
    L10:
        return r0;
    L5:
        if (this.c == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void g() {
        NonProguard r0 = j();
        String r2 = getModule();
        Map<String, b> r3 = this.a;
        if (this.c == false) goto L5;
        String r4 = "BLOCK_PREVIEW";
    L6:
        b r5 = r3.get(r4);
        if (r5 == null) goto L9;
        String r6 = r5.b;
    L10:
        FollowModuleState r1 = new FollowModuleState(r2, r6, JSON.toJSONString(r0));
        tt5.a.b("CCMFollow_vc_follow_module", "downLoadStateChange: send state when load success followModuleState=" + r1);
        py4.h r7 = this.d;
        if (r7 == null) goto L14;
        r7.b(r1);
        return;
    L14:
        return;
    L9:
        r6 = "";
        goto L10
    L5:
        r4 = "NOT_BLOCK_PREVIEW";
        goto L6
    }

    public a(Map<String, b> r1) {
        this.a = r1;
        k(i());
    }

    @Override // py4.g
    public final void a(py4.h r1) {
        this.d = r1;
    }

    @Override // py4.g
    public final void b(FollowModuleState r3) {
        tt5.a.h("CCMFollow_vc_follow_module", "updatePresenterState. ");
        if (r3 != null) goto L5;
        this.e = null;
        return;
    L5:
        T r4 = (T) o(r3.data);
        this.e = r4;
        if (r4 == null) goto L10;
        l(r4, j());
        return;
    }

    @Override // py4.g
    public void c(FollowModuleState r5) {
        if (TextUtils.equals(r5.module, getModule()) == false) goto L17;
        String r0 = r5.actionType;
        Map<String, b> r2 = this.a;
        if (this.c == false) goto L7;
        String r3 = "BLOCK_PREVIEW";
    L8:
        b r4 = r2.get(r3);
        if (r4 == null) goto L11;
        String r6 = r4.b;
    L13:
        if (TextUtils.equals(r0, r6) == false) goto L17;
        tt5.a.h("CCMFollow_vc_follow_module", "setState: state=" + r5);
        NonProguard r7 = o(r5.data);
        if (r7 == null) goto L19;
        h(r7);
        return;
    L19:
        return;
    L11:
        r6 = "";
        goto L13
    L7:
        r3 = "NOT_BLOCK_PREVIEW";
    L17:
        tt5.a.k("CCMFollow_vc_follow_module", "setState: STATE is invalid state=" + r5);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r3) {
        tt5.a.h("CCMFollow_vc_follow_module", "onFollowStateChanged: followState: " + r3);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r1) {
        this.b = r1;
    }

    public final T o(String r9) {
        Class<T> r1 = n();
        Field[] r2 = r1.getDeclaredFields();
        JSONObject r4 = new JSONObject(r9);     // Catch: Exception -> L9
        int r5 = r2.length;     // Catch: Exception -> L9
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L11;
        if (r4.has(r2[r6].getName()) == true) goto L7;
        r6 = r6 + 1;
        goto L4
    L7:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L21;
        tt5.a.h("CCMFollow_vc_follow_module", "invalid state");
        return null;
    L21:
        return (T) JSON.parseObject(r9, r1);
    L18:
        e = move-exception;
        tt5.a.e("CCMFollow_vc_follow_module", "parseState: ", e, false);
        return null;
    L11:
        r3 = false;
    L9:
        e = move-exception;
        tt5.a.h("CCMFollow_vc_follow_module", "parse state error" + e.getMessage());
        goto L11
    }
}
