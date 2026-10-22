package com.bytedance.caijing.sdk.infra.base.api.abtest;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J9\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000e\u001a\u0002H\n2\u0006\u0010\u000f\u001a\u00020\bH&¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/abtest/ABTestService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "addExtraParameter", "", "parameter", "", "", "checkABSDKInstalled", "", "experimentKeyGetValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "type", "Ljava/lang/Class;", "defaultValue", "isExposure", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Z)Ljava/lang/Object;", "setting", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ABTestService extends ICJService {
    void addExtraParameter(Map<String, String> r100);

    boolean checkABSDKInstalled();

    <T> T experimentKeyGetValue(String r100, Class<T> r101, T r102, boolean r103);

    void setting(String r100);
}
