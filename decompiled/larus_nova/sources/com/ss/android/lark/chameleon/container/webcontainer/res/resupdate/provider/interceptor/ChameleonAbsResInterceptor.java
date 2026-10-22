package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResource;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u0010\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAbsResInterceptor;", "", "()V", "defaultResFetcher", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonDefaultResFetcher;", "getDefaultResource", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", DocumentType.DOCX_SYNC_BLOCK_NAME, "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "", "getResource", "shouldIntercept", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ChameleonAbsResInterceptor {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_ChameleonAbsResInterceptor";
    private final ChameleonDefaultResFetcher defaultResFetcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/provider/interceptor/ChameleonAbsResInterceptor$Companion;", "", "()V", "TAG", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract ChameleonResource getResource(Context r100, ChameleonConfig r101, boolean r102, String r103);

    public abstract boolean shouldIntercept(Context r100, ChameleonConfig r101);

    public ChameleonAbsResInterceptor() {
        this.defaultResFetcher = new ChameleonDefaultResFetcher();
    }

    public ChameleonResource getDefaultResource(Context r100, ChameleonConfig r101, boolean r102, String r103) {
        if (r102 == false) goto L4;
        String r104 = this.defaultResFetcher.syncGetResource(r101, r100, r103);
    L6:
        if (r101 == null) goto L10;
        ResConfig r105 = r101.getResConfig();
        if (r105 == null) goto L10;
        String r106 = r105.getResVersion();
    L12:
        return new ChameleonResource(r104, r106);
    L10:
        r106 = null;
        goto L12
    L4:
        r104 = this.defaultResFetcher.asyncGetResource(r101, r100, r103);
        goto L6
    }

    public static /* synthetic */ ChameleonResource getDefaultResource$default(ChameleonAbsResInterceptor r100, Context r101, ChameleonConfig r102, boolean r103, String r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 8) == 0) goto L7;
        r104 = null;
    L7:
        return r100.getDefaultResource(r101, r102, r103, r104);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDefaultResource");
    }

    public static /* synthetic */ ChameleonResource getResource$default(ChameleonAbsResInterceptor r100, Context r101, ChameleonConfig r102, boolean r103, String r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 8) == 0) goto L7;
        r104 = null;
    L7:
        return r100.getResource(r101, r102, r103, r104);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResource");
    }
}
