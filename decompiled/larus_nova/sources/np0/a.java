package np0;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdk.config.l90;
import com.bytedance.android.livesdk.config.m90;
import com.bytedance.android.livesdk.config.ud0;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f519995a = 0;

    static {
    }

    public static void a(boolean r100) {
        if (ud0.f121363a.getValue().booleanValue() == false) goto L5;
        xs2.b.a().post(new ep0.a());
        return;
    L5:
        if (r100 == true) goto L26;
        l90 r101 = l90.f120661a;
        if (r101.getValue().a() != 1) goto L17;
        String r102 = r101.getValue().b();
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
        ((IBrowserService) k.n(IBrowserService.class)).sendEventToAllJsBridges("live_mini_app_close_choose_page", new JSONObject());
        return;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
    L17:
        Integer r104 = m90.f120737a.getValue();
        if (r104 != null) goto L21;
    L23:
        xs2.b.a().post(new d10.b(false));
        return;
    L21:
        if (r104.intValue() != 1) goto L23;
        xs2.b.a().post(new ep0.a());
        return;
    }
}
