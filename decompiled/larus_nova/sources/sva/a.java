package sva;

import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import uva.b;
import uva.c;
import uva.d;
import uva.e;

/* JADX INFO: loaded from: classes34.dex */
public interface a {

    /* JADX INFO: renamed from: sva.a$a, reason: collision with other inner class name */
    public interface InterfaceC7662a {
    }

    void addConfigChangeListener(c r100);

    void addDeviceIdListener(d r100);

    void addEventListener(e r100);

    void addEventObserver(b r100);

    String addNetCommonParams(Context r100, String r101, boolean r102);

    void addSessionHook();

    void flush();

    String getAid();

    uva.a getDataObserver();

    String getDid();

    boolean getEncryptAndCompress();

    tva.a getEncryptor();

    JSONObject getHeader();

    String getIid();

    wva.a getNetConfig();

    String getSessionId();

    void getSsidGroup(Map<String, String> r100);

    String getUserUniqueID();

    void init(Context r100, vva.a r101);

    boolean isMigrate(Context r100);

    String methodGetUseNetConfig(String r100, Map<String, String> r101);

    void onEvent(String r100, String r101, String r102, Long r103, Long r104, JSONObject r105);

    void onEventV3(String r100, Bundle r101);

    void onEventV3(String r100, JSONObject r101);

    void onMiscEvent(String r100, JSONObject r101);

    void onPause(Context r100);

    void onResume(Context r100);

    void putCommonParams(Map<String, String> r100, boolean r101);

    Boolean removeConfigChangeListener(c r100);

    Boolean removeDeviceIdListener(d r100);

    void removeEventListener(e r100);

    void removeEventObserver(b r100);

    void setAbSdkVersion(String r100);

    void setAppLanguageAndRegion(String r100, String r101);

    void setAutoABConfig(Boolean r100);

    void setAutoActiveState(Boolean r100);

    void setCustomNetParams(String r100, String r101);

    void setETVerifyEnable(Boolean r100);

    void setEnableMigrateByFirstInstallTime(Boolean r100);

    void setEventReportEnable(Boolean r100);

    void setHeaderInfo(HashMap<String, Object> r100);

    void setHttpUrlPrefix(boolean r100);

    void setRegisterUriRuntime(String r100, boolean r101, boolean r102);

    void setResetAbVersionCallback(InterfaceC7662a r100);

    void setSendLogUrisRuntime(String[] r100);

    void setUidChangedListener(Runnable r100);

    void setUserUniqueID(String r100);

    void silenceInBackground(Boolean r100);
}
