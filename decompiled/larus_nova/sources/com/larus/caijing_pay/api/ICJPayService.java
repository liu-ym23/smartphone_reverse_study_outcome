package com.larus.caijing_pay.api;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.applet.impl.e0;
import com.bytedance.applet.impl.f0;
import com.larus.camera.impl.utils.n;
import com.larus.live.impl.ttlivesdk.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J`\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH&J|\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH&J^\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u000b2:\u0010\u0016\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH&J7\u0010\u0010\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\b2#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018H&Jh\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH\u0016J@\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010 \u001a\u00020!H&JP\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010 \u001a\u00020%H&¨\u0006&"}, d2 = {"Lcom/larus/caijing_pay/api/ICJPayService;", "", "routeSign", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", d.D, "", "", "onResult", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "pay", "service", "subway", AppConstants.BUNDLE_REFERER, "ext", "payType", "payFinishCallback", "papiId", "Lkotlin/Function1;", "", "isSuccess", "outerBDPay", "extraInfo", "startBytedCert", "userInfo", "themeData", "callback", "Lcom/larus/caijing_pay/api/BytedCertCallbackWrapper;", "doFaceLive", "identityCode", "identityName", "Lcom/larus/caijing_pay/api/FaceLiveCallbackWrapper;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICJPayService {
    void a(FragmentActivity r100, String r101, int r102, e0 r103);

    void b(Context r100, Map r101, n r102);

    void c(FragmentActivity r100, String r101, Map r102, f0 r103);

    void d(Context r100, Map r101, Map r102, k.c r103);

    void e(Context r100, int r101, String r102, String r103, Function2 r104);

    void f(Context r100, String r101, String r102, Map r103, Map r104, k.b r105);
}
