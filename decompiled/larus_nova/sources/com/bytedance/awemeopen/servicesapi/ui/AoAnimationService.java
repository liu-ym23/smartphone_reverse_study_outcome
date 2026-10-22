package com.bytedance.awemeopen.servicesapi.ui;

import android.content.Context;
import com.bytedance.awemeopen.infra.plugs.lotties.f;
import com.bytedance.awemeopen.infra.plugs.lotties.i;
import com.bytedance.awemeopen.infra.plugs.lotties.j;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoAnimationService extends IBdpService {
    i A2(InputStream r100, String r101);

    f D2(Context r100, String r101);

    i F1(Context r100, int r101);

    i K(ZipInputStream r100, String r101);

    f R(Context r100, String r101);

    i W(Context r100, String r101);

    i X1(Context r100, String r101);

    f b2(String r100, String r101);

    f c1(Context r100, int r101);

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "false", imports = {}))
    boolean f();

    i i1(String r100, String r101);

    f j0(ZipInputStream r100, String r101);

    j p0();

    f w0(InputStream r100, String r101);
}
