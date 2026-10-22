package i8a;

import com.lynx.tasm.service.IServiceProvider;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;

/* JADX INFO: loaded from: classes32.dex */
public interface e extends IServiceProvider {

    public interface a {
    }

    void cancelPreloadMedia(String r100, String r101);

    f fetchResourceAsync(String r100, LynxResourceServiceRequestParams r101, m r102);

    int isLocalResource(String r100);

    boolean isReady();

    void preloadMedia(String r100, String r101, String r102, long r103, a r104);
}
