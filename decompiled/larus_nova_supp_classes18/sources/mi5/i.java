package mi5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements g {
    public final CompositeDisposable a;
    public boolean b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ IGetDataCallback<Boolean> a;
        public final /* synthetic */ i b;

        public b(IGetDataCallback<Boolean> r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            String r7 = new JSONObject(((Result) ((SimpleRequestResult) r6)).data.toString()).optString("allow_leader_view");     // Catch: Exception -> L16
            if (TextUtils.isEmpty(r7) == false) goto L7;
        L11:
            ay4.b.d("platform", 6).putBoolean("allow_leader_view", true);     // Catch: Exception -> L16
            IGetDataCallback<Boolean> r8 = this.a;     // Catch: Exception -> L16
            if (r8 == null) goto L14;
            r8.onSuccess(Boolean.TRUE);     // Catch: Exception -> L16
        L14:
            this.b.b = false;     // Catch: Exception -> L16
            return;
        L7:
            if (TextUtils.equals("false", r7) == false) goto L11;
            ay4.b.d("platform", 6).putBoolean("allow_leader_view", false);     // Catch: Exception -> L16
            IGetDataCallback<Boolean> r9 = this.a;     // Catch: Exception -> L16
            if (r9 == null) goto L14;
            r9.onSuccess(Boolean.FALSE);     // Catch: Exception -> L16
        L16:
            IGetDataCallback<Boolean> r10 = this.a;
            if (r10 == null) goto L19;
            r10.onError(new ErrorResult("getLeaderShareSetting error"));
        L19:
            this.b.b = false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ IGetDataCallback<Boolean> b;

        public c(i r1, IGetDataCallback<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.b = false;
            IGetDataCallback<Boolean> r5 = this.b;
            if (r5 == null) goto L6;
            r5.onError(new ErrorResult("getLeaderShareSetting error"));
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ IGetDataCallback<Boolean> b;

        public d(boolean r1, IGetDataCallback<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            SimpleRequestResult r4 = (SimpleRequestResult) r3;
            ay4.b.d("platform", 6).putBoolean("allow_leader_view", this.a);
            IGetDataCallback<Boolean> r5 = this.b;
            if (r5 == null) goto L6;
            r5.onSuccess(Boolean.valueOf(this.a));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ IGetDataCallback<Boolean> a;

        public e(IGetDataCallback<Boolean> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            IGetDataCallback<Boolean> r5 = this.a;
            if (r5 == null) goto L6;
            r5.onError(new ErrorResult("getLeaderShareSetting error"));
            return;
        }
    }

    static {
    }

    @Override // mi5.g
    public final void shutDown() {
        this.a.clear();
    }

    public i() {
        this.a = new CompositeDisposable();
        this.b = true;
    }

    @Override // mi5.g
    public final boolean getLeaderShareSetting(IGetDataCallback<Boolean> r7) {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/platform/common_setting/get");
        ((NetService.e) r1).c = 2;
        r1.b("scene", "allow_leader_view");
        this.a.add(r0.Vc(new ax4.f()).a(r1).subscribe(new b(r7, this), new c(this, r7)));
        return ay4.b.d("platform", 6).getBoolean("allow_leader_view", true);
    }

    @Override // mi5.g
    public final void updateLeaderShareSetting(boolean r8, IGetDataCallback<Boolean> r9) {
        if (this.b == false) goto L5;
        return;
    L5:
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/platform/common_setting/update");
        ((NetService.e) r1).c = 1;
        JSONObject r2 = new JSONObject();
        JSONArray r3 = new JSONArray();     // Catch: Exception -> L8
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L8
        r4.put("scene", "allow_leader_view");     // Catch: Exception -> L8
        r4.put("setting_value", r8);     // Catch: Exception -> L8
        r3.put(r4);     // Catch: Exception -> L8
        r2.put(BenefitStore.FROM_SETTINGS, r3);     // Catch: Exception -> L8
        ((NetService.e) r1).j = r2.toString();     // Catch: Exception -> L8
    L9:
        this.a.add(r0.Vc(new ax4.f()).a(r1).subscribe(new d(r8, r9), new e(r9)));
        return;
    L8:
        tt5.a.d("LeaderShareSettingImpl", "jsonObject error");
        goto L9
    }
}
