package vg1;

import am2.x;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f554662h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IRoom f554663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HybridCard f554664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f554665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f554666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f554667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f554668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f554669g;

    /* JADX INFO: renamed from: vg1.a$a, reason: collision with other inner class name */
    public static final class C8001a {
        public static void a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessag");
            HashMap r102 = new HashMap();
            r102.put("error_code", String.valueOf(r100));
            r102.put("error_message", r101);
            j0.l().sendLog("livesdk_client_finish_load_failed", r102, new Object[]{IRoom.class, new x()});
        }
    }

    static {
    }

    public a() {
    }

    public final void a(String r100) {
        if (this.f554664b == null) goto L11;
        Function0<Unit> r101 = this.f554666d;
        if (r101 == null) goto L7;
        Unit r102 = r101.invoke();
    L7:
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r100), "url");
        ALogger.i("HybridManagerForVsEnd", "load-" + r103);
        HybridCard r104 = this.f554664b;
        if (r104 == null) goto L12;
        r104.load(r103, null);
        return;
    L12:
        return;
    }
}
