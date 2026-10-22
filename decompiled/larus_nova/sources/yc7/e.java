package yc7;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.js.spec.JsBridgeContext;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, d> f567225a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f567226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f567227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f567228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JsBridgeContext f567229d;

        public a(e r100, String r101, JSONObject r102, JsBridgeContext r103) {
            this.f567226a = r100;
            this.f567227b = r101;
            this.f567228c = r102;
            this.f567229d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f567226a.f567225a.get(this.f567227b);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f567228c, this.f567229d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public e() {
        this.f567225a = new ConcurrentHashMap();
    }

    public boolean a(String r100, JSONObject r101, JsBridgeContext r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (this.f567225a.get(r100) == null) goto L11;
        ConcurrentHashMap<String, List<ed7.a>> r103 = wc7.a.f559172a;
        wc7.a.f559178g.post(new a(this, r100, r101, r102));
        return true;
    L11:
        return false;
    }
}
