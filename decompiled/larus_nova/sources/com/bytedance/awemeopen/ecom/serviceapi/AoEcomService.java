package com.bytedance.awemeopen.ecom.serviceapi;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/ecom/serviceapi/AoEcomService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_ecom_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoEcomService extends IBdpService {
    void K1(Activity r100, String r101, Function0 r102, Function2 r103, Function1 r104);

    void e();

    String g();

    boolean isAvailable();

    void j(FragmentActivity r100, String r101);

    void w(Activity r100, String r101, Function0 r102, Function2 r103, Function1 r104);
}
