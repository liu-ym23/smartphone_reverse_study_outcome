package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResource;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAssertResInterceptor;", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAbsResInterceptor;", "()V", "getResource", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ChameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", DocumentType.DOCX_SYNC_BLOCK_NAME, "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "", "shouldIntercept", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonAssertResInterceptor extends ChameleonAbsResInterceptor {
    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor
    public boolean shouldIntercept(Context r100, ChameleonConfig r101) {
        return true;
    }

    public ChameleonAssertResInterceptor() {
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor
    public ChameleonResource getResource(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        Log.i(ChameleonAbsResInterceptor.TAG, "getResource, use assert");
        return getDefaultResource(r100, r101, r102, r103);
    }
}
