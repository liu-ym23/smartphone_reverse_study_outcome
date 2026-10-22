package wo1;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.jsb.BannerAccessibilityMethod$invoke$1;
import com.bytedance.android.livesdk.config.br;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends b<j, JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f560501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f560502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f560503c;

    public static final class a {
    }

    static {
    }

    public c(View r100, String r101) {
        this.f560503c = r101;
        this.f560501a = new WeakReference(r100);
        this.f560502b = br.f119893a.getValue();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        final j r102 = (j) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r103 = this.f560501a.get();
        ALogger.i("BannerAccessibilityMethod", "invoke: params=" + GsonProtectorUtils.toJson(GsonHelper.get(), r102) + " view=" + r103);
        if (r103 != null) goto L5;
        finishWithFailure(new Exception("view已被销毁"));
        return;
    L5:
        r3.e(r103, new BannerAccessibilityMethod$invoke$1(this, r102));
        if (Intrinsics.areEqual(r102.b(), Boolean.TRUE) == true) goto L8;
    L11:
        finishWithSuccess();
        return;
    L8:
        if (r103.getVisibility() != 0) goto L10;
        r103.sendAccessibilityEvent(128);
        goto L11
    L10:
        ALogger.i("BannerAccessibilityMethod", "view cannot request focus because it is invisible");
        finishWithFailure(new Exception("view cannot request focus because it is invisible"));
    }
}
