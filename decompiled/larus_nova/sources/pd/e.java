package pd;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface e {
    b createAnnieComponent(Context r100, String r101, c r102);

    j createLynxComponent(Activity r100, String r101, h r102, boolean r103);

    g createWebViewRecord(Activity r100, String r101, i r102, boolean r103);

    void enqueueEvent(String r100, JSONObject r101);

    f getExternalJsBridgeMethodInjectorAdapter();

    boolean initAnnie();

    boolean isAnnieInit();

    void preloadResourceForLynx(String r100, boolean r101);

    void prerenderAnnieWithSchema(Context r100, String r101, String r102, Integer r103, String r104, d r105);

    JSONObject readGeckoFromChannel(String r100, String r101, String r102);

    void releasePrerender(String r100, String r101);

    <T> void sendEventToAllJsBridges(String r100, T r101);

    String tranceUrlToGeckoUrl(String r100, String r101, String r102);
}
