package com.bytedance.caijing.sdk.infra.base.api.alipay;

import android.app.Activity;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import faceverify.w;
import java.util.Map;
import kotlin.Metadata;
import zc4.a;
import zc4.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J:\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H&J&\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0006H&¨\u0006\u001e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/alipay/AliPayService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/app/Activity;", "activity", "", w.META_COLL_KEY_AUTH_INFO, "", "isShowLoading", "Lzc4/a;", "callback", "", "authAlipay", "scheme", "", "bizParams", "Lzc4/b;", "openAuthTaskExecute", "", "code", "isOk", "isDuplex", "isNotInstalled", "isSysErr", "", "createPayTask", "payTask", "getVersion", "url", "b", "executePay", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface AliPayService extends ICJService {
    void authAlipay(Activity r100, String r101, boolean r102, a r103);

    Object createPayTask(Activity r100);

    String executePay(Object r100, String r101, boolean r102);

    String getVersion(Object r100);

    boolean isDuplex(int r100);

    boolean isNotInstalled(int r100);

    boolean isOk(int r100);

    boolean isSysErr(int r100);

    void openAuthTaskExecute(Activity r100, String r101, Map<String, String> r102, b r103);
}
