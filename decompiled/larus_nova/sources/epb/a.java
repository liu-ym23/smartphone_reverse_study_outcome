package epb;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passport.signinsdk_api.entity.DeviceId;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: epb.a$a, reason: collision with other inner class name */
    public interface InterfaceC5801a {
    }

    String getDeviceId();

    void getDeviceId(Context r100, IGetDataCallback<DeviceId> r101);

    String getDeviceIdFromLocal();

    void getDeviceIdWithTimeout(Context r100, IGetDataCallback<DeviceId> r101, long r102);

    String getInstallId();

    @Deprecated(message = "internal use")
    void setAppLogUriRuntime();
}
