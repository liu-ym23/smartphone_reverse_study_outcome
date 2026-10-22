package r80;

import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import j40.i0;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f536502c;

    @Override // r80.c, com.bytedance.android.live.core.utils.screen.b
    public final boolean isFoldScreen() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L7;
        return r100.isFoldDevice();
    L7:
        return super.isFoldScreen();
    }

    public l() {
        this.f536502c = "UnifiedProcessBrand";
    }

    @Override // r80.c, com.bytedance.android.live.core.utils.screen.b
    public final int a(Configuration r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (isFoldScreen() == true) goto L8;
        return -1;
    L8:
        ALogger.d(this.f536502c, k.f536501a);
        float r101 = (r100.screenHeightDp * 1.0f) / r100.screenWidthDp;
        ALogger.i(this.f536502c, "HegightDp:" + r100.screenHeightDp + ",WidthDp:" + r100.screenWidthDp + ",ratio:" + r101);
        i0 r102 = i0.f497237a;
        Map<String, Float> r103 = r102.getValue().a();
        if (r103 == null) goto L17;
        String r104 = Build.MODEL;
        if (r103.containsKey(r104) != true) goto L17;
        Map<String, Float> r105 = r102.getValue().a();
        if (r105 == null) goto L17;
        Float r106 = r105.get(r104);
        if (r106 == null) goto L17;
        float r107 = r106.floatValue();
    L19:
        if (r101 >= r107) goto L21;
        return 1;
    L21:
        if (r101 > 1.5f) goto L25;
        return 0;
    L25:
        return 1;
    L17:
        r107 = 0.75f;
        goto L19
    }
}
