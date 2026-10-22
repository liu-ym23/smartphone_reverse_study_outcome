package ha;

import android.app.Application;
import com.bytedance.android.anniex.base.depend.ApplicationDepend;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.anniex.base.service.AnnieXServiceProvider;

/* JADX INFO: loaded from: classes43.dex */
public interface a {
    ApplicationDepend createApplicationDepend();

    DeviceDepend createDeviceDepend();

    AnnieXServiceProvider createServiceProvider(String r100);

    void initRelax(Application r100);
}
