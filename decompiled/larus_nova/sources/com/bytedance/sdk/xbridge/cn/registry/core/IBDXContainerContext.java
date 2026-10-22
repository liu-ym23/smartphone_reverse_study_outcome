package com.bytedance.sdk.xbridge.cn.registry.core;

import android.app.Activity;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Metadata;
import ue7.d;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rH&R\u0014\u0010\u0013\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXContainerContext;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "getService", "(Ljava/lang/Class;)Ljava/lang/Object;", "Landroid/view/View;", "getEngineView", "Landroid/app/Activity;", "getOwnerActivity", "", "eventName", "", "params", "", "sendEvent", "getContainerID", "()Ljava/lang/String;", "containerID", "getNamespace", "namespace", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", Keys.API_PARAM_KEY_PLATFORM_TYPE, "Lue7/d;", "getJsEventDelegate", "()Lue7/d;", "jsEventDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IBDXContainerContext {
    String getContainerID();

    View getEngineView();

    d getJsEventDelegate();

    String getNamespace();

    Activity getOwnerActivity();

    PlatformType getPlatformType();

    <T> T getService(Class<T> r100);

    void sendEvent(String r100, Map<String, ? extends Object> r101);
}
