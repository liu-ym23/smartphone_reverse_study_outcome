package com.ss.android.lark.officesdk.api.service.capacity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/api/service/capacity/NullAppBaseInfoImpl;", "Lcom/ss/android/lark/officesdk/api/service/capacity/IOfficeAppBaseInfo;", "<init>", "()V", "getAppIcon", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getDouBaoIcon", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NullAppBaseInfoImpl implements IOfficeAppBaseInfo {
    public NullAppBaseInfoImpl() {
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public Drawable getAppIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public Drawable getDouBaoIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public boolean isEnterpriseAccount() {
        return IOfficeAppBaseInfo.DefaultImpls.isEnterpriseAccount(this);
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public Drawable getDouBaoLinearIcon(Context r100) {
        return IOfficeAppBaseInfo.DefaultImpls.getDouBaoLinearIcon(this, r100);
    }
}
