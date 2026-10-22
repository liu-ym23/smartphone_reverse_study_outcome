package com.bytedance.ee.bear.contract;

import android.app.Activity;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.util.deviceinfo.DeviceInfoDetector;
import io.reactivex.Single;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public interface b0 {
    long a();

    boolean b();

    void c();

    long d();

    String e();

    boolean f();

    DocDynamicConfig g();

    int getAppId();

    void getChannelId();

    String getDeviceId();

    DeviceInfoDetector.DeviceInfo getDeviceInfo();

    String getDeviceModel();

    String getPackageName();

    String getPlatform();

    String getTenantId();

    Activity getTopActivity();

    String getUid();

    int getVersionCode();

    String getVersionName();

    String h();

    String i();

    boolean isChinaMainlandGeo();

    void j(DocDynamicConfig r100);

    Activity k();

    String l();

    String m();

    Single<String> n();

    String o();

    String p();

    List<String> q();

    String r();

    boolean s();

    String t();

    void u();

    String[] v();

    String w();

    String x();
}
