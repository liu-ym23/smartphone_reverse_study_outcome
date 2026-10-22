package yn;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568440a = 0;

    public static void a() {
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 == null) goto L8;
        com.bytedance.android.ec.adapter.api.j r102 = r101.getLiveWindowService();
        if (r102 == null) goto L9;
        r102.stopShowFloat();
        return;
    L9:
        return;
    }

    static {
    }
}
