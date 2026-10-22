package hj4;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.init.task.AbTestInitiator;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f485423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f485424b;

    public final void a() {
        Set<String> r100 = d.f485428b;
        HashSet r101 = (HashSet) r100;
        if (r101.contains(this.f485423a) == true) goto L16;
        JSONObject r102 = new JSONObject();
        r102.put("params_for_special", "abtest_ab_sdk");     // Catch: JSONException -> L7
        r102.put("ab_sdk_version", this.f485424b);     // Catch: JSONException -> L7
        r102.put("trigger_vid", this.f485423a);     // Catch: JSONException -> L7
    L10:
        if (d.f485427a == null) goto L12;
        int r103 = AbTestInitiator.f350994g;
        IApplog.Companion r104 = IApplog.f287053a;
        Intrinsics.checkNotNull("abtest_ab_sdk_vid_exposure");
        r104.reportEvent("abtest_ab_sdk_vid_exposure", r102);
    L12:
        Set<String> r105 = d.f485428b;
        HashSet r106 = (HashSet) r105;
        r106.add(this.f485423a);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L10
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

    public b(String r100, String r101) {
        this.f485423a = r100;
        this.f485424b = r101;
    }
}
