package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResource;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAssertResInterceptor;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/ChameleonResProvider;", "", "()V", "TAG", "", "interceptors", "", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAbsResInterceptor;", "getInterceptors", "()Ljava/util/List;", "setInterceptors", "(Ljava/util/List;)V", "getResource", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", DocumentType.DOCX_SYNC_BLOCK_NAME, "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonResProvider {
    public static final ChameleonResProvider INSTANCE = null;
    public static final String TAG = "CML_TAG_ChameleonResProvider";
    private static List<? extends ChameleonAbsResInterceptor> interceptors;

    private ChameleonResProvider() {
    }

    static {
        INSTANCE = new ChameleonResProvider();
        interceptors = CollectionsKt.listOf(new ChameleonAssertResInterceptor());
    }

    public final List<ChameleonAbsResInterceptor> getInterceptors() {
        return interceptors;
    }

    public final void setInterceptors(List<? extends ChameleonAbsResInterceptor> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        interceptors = r100;
    }

    public final ChameleonResource getResource(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        Iterator<T> r104 = interceptors.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        ChameleonAbsResInterceptor r105 = (ChameleonAbsResInterceptor) r104.next();
        if (r105.shouldIntercept(r100, r101) == false) goto L4;
        return r105.getResource(r100, r101, r102, r103);
    L9:
        Log.e(TAG, "getResource, no interceptor match");
        return new ChameleonResource(null, null, 3, null);
    }

    public static /* synthetic */ ChameleonResource getResource$default(ChameleonResProvider r100, Context r101, ChameleonConfig r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r104 = null;
    L6:
        return r100.getResource(r101, r102, r103, r104);
    }
}
