package com.bytedance.awemeopen.servicesapi.context;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import n48.d;
import q64.f;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/context/AoHostService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "HostType", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoHostService extends IBdpService {

    /* JADX INFO: loaded from: classes46.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/context/AoHostService$HostType;", "", "TOB", "TOC", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
    public static final enum HostType extends Enum<HostType> {
        public static final HostType TOB = null;
        public static final HostType TOC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HostType[] f198974a = null;

        public static HostType valueOf(String r100) {
            return (HostType) a.a(HostType.class, r100);
        }

        public static HostType[] values() {
            return (HostType[]) f198974a.clone();
        }

        static {
            HostType r100 = new HostType("TOB", 0);
            TOB = r100;
            HostType r101 = new HostType("TOC", 1);
            TOC = r101;
            f198974a = new HostType[]{r100, r101};
        }

        public HostType(String r100, int r101) {
            super(r100, r101);
        }
    }

    void A0(FragmentActivity r100, Bundle r101);

    void D();

    void J1();

    void N();

    float b();

    HostType f2();

    f g0();

    void g1();

    String getDeviceId();

    String getHostAid();

    String getHostAppName();

    Application getHostApplication();

    String getHostChannel();

    int getHostUpdateVersionCode();

    int getHostVersionCode();

    String getHostVersionName();

    String getInstallId();

    boolean hostIsDebug();

    void l0(Context r100, Bundle r101);

    d z1();
}
