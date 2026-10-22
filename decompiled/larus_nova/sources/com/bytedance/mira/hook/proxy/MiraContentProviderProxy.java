package com.bytedance.mira.hook.proxy;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.stub.BaseStubContentProvider;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MiraContentProviderProxy extends AbsObjectProxy {
    private static final String TAG = "MiraContentProviderProxy";
    private static Map<Object, Pair<String, String>> sProviderAuthMap;
    private Pair<String, String> mAuthPair;
    private Object mContentProviderHolder;

    /* JADX INFO: renamed from: com.bytedance.mira.hook.proxy.MiraContentProviderProxy$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CrudProviderMethod extends AbsMethodDelegate {
        private CrudProviderMethod() {
        }

        public /* synthetic */ CrudProviderMethod(AnonymousClass1 r100) {
            this();
        }

        private void stubCommonMethod(Object[] r100, String r101, Method r102) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.length > 0) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(r101) == true) goto L18;
            String r103 = "MiraContentProviderProxy << " + r102.getName() + ", ";
            int r104 = MethodUtils.getParameterTypeIndex(r102, Uri.class);
            if (r104 < 0) goto L10;
            Uri r105 = (Uri) r100[r104];
        L12:
            if (r105 == null) goto L14;
            r100[r104] = new Uri.Builder().scheme(r105.getScheme()).authority(r101).path(r105.getPath()).query(r105.getQuery()).fragment(r105.getFragment()).appendQueryParameter(BaseStubContentProvider.CodeConst.EXTRA_TARGET_AUTHORITY, r105.getAuthority()).build();
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r103 + "build uri = " + r100[r104]);
            return;
        L14:
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r103 + "uriIndex or targetUri invalid, uriIndex = " + r104 + ", targetUri = " + r105);
            return;
        L10:
            r105 = null;
            goto L12
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r100, Method r101, Object[] r102) {
            String r103 = "MiraContentProviderProxy >> " + r101.getName() + ", ";
            Pair r104 = (Pair) MiraContentProviderProxy.access$100().get(r100);
            if (r104 == null) goto L8;
            String r105 = (String) r104.first;
            String r106 = (String) r104.second;
            if (NotificationCompat.CATEGORY_CALL.equals(r101.getName()) == false) goto L7;
            stubCallMethod(r102, r105, r106, r101);
        L10:
            return super.beforeInvoke(r100, r101, r102);
        L7:
            stubCommonMethod(r102, r106, r101);
            goto L10
        L8:
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r103 + "authPair null");
            goto L10
        }

        private void stubCallMethod(Object[] r100, String r101, String r102, Method r103) {
            int r104 = MethodUtils.getParameterTypeIndex(r103, Bundle.class);
            if (r104 == (-1)) goto L10;
            Object r105 = r100[r104];
            if (r105 == null) goto L7;
            Bundle r106 = (Bundle) r105;
        L8:
            r106.putString(BaseStubContentProvider.CodeConst.EXTRA_STUB_AUTHORITY, r102);
            r106.putString(BaseStubContentProvider.CodeConst.EXTRA_TARGET_AUTHORITY, r101);
            goto L10
        L7:
            r106 = new Bundle();
            r100[r104] = r106;
        L10:
            if (OSUtil.isAndroidRHigher() == false) goto L15;
            if (r100.length <= 3) goto L15;
            r100[2] = r102;
        L19:
            MiraLogger.w(MiraLogger.TAG_PROVIDER, "MiraContentProviderProxy << " + r103.getName() + ", " + String.format("target_authority[%s] >>> stub_authority[%s]", new Object[]{r101, r102}));
            return;
        L15:
            if (OSUtil.isAndroidQHigher() == false) goto L19;
            if (r100.length <= 2) goto L19;
            r100[1] = r102;
            goto L19
        }
    }

    static {
        CrudProviderMethod r100 = new CrudProviderMethod(null);
        AbsObjectProxy.sDelegateMethods.put(NotificationCompat.CATEGORY_CALL, r100);
        AbsObjectProxy.sDelegateMethods.put("getType", r100);
        AbsObjectProxy.sDelegateMethods.put("query", r100);
        AbsObjectProxy.sDelegateMethods.put("insert", r100);
        AbsObjectProxy.sDelegateMethods.put("bulkInsert", r100);
        AbsObjectProxy.sDelegateMethods.put("delete", r100);
        AbsObjectProxy.sDelegateMethods.put("update", r100);
        AbsObjectProxy.sDelegateMethods.put("openFile", r100);
        AbsObjectProxy.sDelegateMethods.put("openAssetFile", r100);
        sProviderAuthMap = new ConcurrentHashMap();
    }

    @Override // com.bytedance.mira.hook.MiraHook
    public void onHookInstall() {
        Object r100 = FieldUtils.readField(this.mContentProviderHolder, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Exception -> L10
        if (r100 == null) goto L15;
        Pair<String, String> r101 = this.mAuthPair;     // Catch: Exception -> L10
        if (r101 == null) goto L8;
        sProviderAuthMap.put(r100, r101);     // Catch: Exception -> L10
    L8:
        setTarget(r100);     // Catch: Exception -> L10
        Object r102 = ProxyHelper.createProxy(r100, this);     // Catch: Exception -> L10
        FieldUtils.writeField(this.mContentProviderHolder, ShortVideoSegments.KEY_PROP_PROVIDER, r102);     // Catch: Exception -> L10
        MiraLogger.w(MiraLogger.TAG_PROVIDER, "MiraContentProviderProxy.hook");     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "MiraContentProviderProxy hook failed.", e);
    }

    public static /* synthetic */ Map access$100() {
        return sProviderAuthMap;
    }

    public MiraContentProviderProxy(Object r100, Pair<String, String> r101) {
        this.mContentProviderHolder = r100;
        this.mAuthPair = r101;
    }

    @Override // com.bytedance.mira.hook.proxy.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(r100, r101, r102);
    }
}
