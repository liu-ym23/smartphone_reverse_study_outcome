package com.ss.android.lark.officesdk.api.service.capacity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/api/service/capacity/IOfficeAppBaseInfo;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "getAppIcon", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getDouBaoIcon", "getDouBaoLinearIcon", "isEnterpriseAccount", "", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeAppBaseInfo extends IOfficeSDKProtocol {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Drawable getDouBaoLinearIcon(IOfficeAppBaseInfo r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }

        public static boolean isEnterpriseAccount(IOfficeAppBaseInfo r100) {
            return false;
        }
    }

    Drawable getAppIcon(Context r100);

    Drawable getDouBaoIcon(Context r100);

    Drawable getDouBaoLinearIcon(Context r100);

    boolean isEnterpriseAccount();
}
