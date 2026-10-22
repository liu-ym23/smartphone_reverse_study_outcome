package uo0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import java.util.Map;
import ko0.c;
import w20.lc;

/* JADX INFO: loaded from: classes46.dex */
public interface a {
    OpenPlatformContext a();

    void b(OpenPlatformContext r100);

    Map c();

    Map<String, String> getCommonEventParams();

    c getMiniAppLiveCastEntranceInfo();

    void openLiveMicroApp(String r100, lc.a r101);
}
