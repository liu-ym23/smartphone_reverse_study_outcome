package it6;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends jt6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f495721a = null;

    static {
        f495721a = new a();
    }

    @Override // jt6.b, jt6.a
    public final void log(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "action");
    }

    public a() {
    }

    @Override // jt6.a
    public final JSONObject a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILiveService r101 = TTLiveService.getLiveService();
        if (r101 == null) goto L7;
        ILiveAdService r102 = (ILiveAdService) r101.liveAdService(ILiveAdService.class);
        if (r102 == null) goto L7;
        return r102.getCurrentRoomInfo(r100);
    L7:
        return null;
    }
}
