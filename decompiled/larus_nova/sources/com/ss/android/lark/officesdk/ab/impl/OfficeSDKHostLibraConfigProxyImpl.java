package com.ss.android.lark.officesdk.ab.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import etb.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zpb.a;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(a.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/ab/impl/OfficeSDKHostLibraConfigProxyImpl;", "Lcom/ss/android/lark/librabridge/ILibraConfigProxy;", "<init>", "()V", "delegate", "Lcom/ss/android/lark/officesdk/ab/api/IOfficeSDKLibraConfig;", "getDelegate", "()Lcom/ss/android/lark/officesdk/ab/api/IOfficeSDKLibraConfig;", "getConfig", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "", "valueClass", "Ljava/lang/Class;", "withExposure", "", "(Ljava/lang/String;Ljava/lang/Class;Z)Ljava/lang/Object;", "ab-officesdk-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKHostLibraConfigProxyImpl implements a {
    public OfficeSDKHostLibraConfigProxyImpl() {
    }

    private final c getDelegate() {
        return (c) OfficeSDKManager.getHostGlobalService(c.class);
    }

    @Override // zpb.a
    public <T> T getConfig(String r100, Class<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueClass");
        c r103 = getDelegate();
        if (r103 != null) goto L7;
        return null;
    L7:
        return (T) r103.getConfig(r100, r101, r102);
    }
}
