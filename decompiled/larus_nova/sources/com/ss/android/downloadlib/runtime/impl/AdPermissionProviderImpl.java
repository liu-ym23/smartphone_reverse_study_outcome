package com.ss.android.downloadlib.runtime.impl;

import android.app.Activity;
import android.content.Context;
import com.ss.android.download.api.common.DefaultPermissionChecker;
import com.ss.android.download.api.config.DownloadPermissionChecker;
import com.ss.android.download.api.runtime.IAdPermissionProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import t6.a;
import t6.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdPermissionProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdPermissionProvider;", "Landroid/app/Activity;", "activity", "", "requestCode", "", "", ComplianceResult.JsonKey.PERMISSIONS, "", "grantResults", "", "onRequestPermissionsResult", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "hasPermissions", "Ln6/a$a;", "callback", "requestPermission", "enableRuntime", "Z", "needDefaultFactory", "Lcom/ss/android/download/api/common/DefaultPermissionChecker;", "defaultPermissionChecker", "Lcom/ss/android/download/api/common/DefaultPermissionChecker;", "<init>", "(Z)V", "Companion", "download-impl_release"}, k = 1, mv = {1, 4, 0})
public final class AdPermissionProviderImpl implements IAdPermissionProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdPermissionProviderImpl";
    private final DefaultPermissionChecker defaultPermissionChecker;
    private final boolean enableRuntime;
    private final boolean needDefaultFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdPermissionProviderImpl$Companion;", "", "()V", "TAG", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
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

    public AdPermissionProviderImpl(boolean r100) {
        if (GlobalInfo.getDownloadPermissionChecker() != null) goto L5;
        boolean r101 = true;
    L6:
        this.needDefaultFactory = r101;
        this.defaultPermissionChecker = new DefaultPermissionChecker();
        this.enableRuntime = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.download.api.runtime.IAdPermissionProvider
    public boolean hasPermissions(Context r100, List<String> r101) {
        if (this.enableRuntime == false) goto L8;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "hasPermissions", "采用Runtime的能力,检查是否具有某个权限");
        b r102 = a.f544652a;
        n6.a r103 = (n6.a) a.C7690a.a(n6.a.class, null);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.a();
    L8:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "hasPermissions", "未开启Runtime能力,使用初始化注入能力检查权限");
        Iterator<T> r104 = r101.iterator();
        boolean r105 = true;
    L10:
        if (r104.hasNext() == false) goto L20;
        String r106 = (String) r104.next();
        if (this.needDefaultFactory == false) goto L16;
        if (this.defaultPermissionChecker.hasPermission(r100, r106) == true) goto L16;
    L19:
        r105 = false;
    L16:
        if (this.needDefaultFactory == true) goto L10;
        if (GlobalInfo.getDownloadPermissionChecker().hasPermission(r100, r106) == true) goto L10;
    L20:
        return r105;
    }

    @Override // com.ss.android.download.api.runtime.IAdPermissionProvider
    public boolean requestPermission(Activity r100, final List<String> r101, final n6.a.InterfaceC6895a r110) {
    L23:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "requestPermission", "申请权限过程中抛出异常,返回错误的结果");
        return false;
    L4:
        if (this.enableRuntime == false) goto L8;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "hasPermissions", "采用Runtime的能力,请求权限");     // Catch: Exception -> L23
        b r102 = a.f544652a;     // Catch: Exception -> L23
        n6.a r103 = (n6.a) a.C7690a.a(n6.a.class, null);     // Catch: Exception -> L23
        if (r103 == null) goto L26;
        r103.requestPermission();     // Catch: Exception -> L23
        return true;
    L26:
        return true;
    L8:
        TTDownloaderLogger r104 = TTDownloaderLogger.INSTANCE;     // Catch: Exception -> L23
        r104.innerLogD(TAG, "requestPermission", "未采用Runtime的能力,依然使用初始化注入的能力请求权限");     // Catch: Exception -> L23
        if (this.needDefaultFactory == false) goto L16;
        r104.innerLogD(TAG, "requestPermission", "初始化未注入权限申请能力,采用SDK内置的默认能力申请权限");     // Catch: Exception -> L23
        DefaultPermissionChecker r105 = this.defaultPermissionChecker;     // Catch: Exception -> L23
        Object[] r106 = r101.toArray(new String[0]);     // Catch: Exception -> L23
        if (r106 == null) goto L15;
        r105.requestPermission(r100, (String[]) r106, new AnonymousClass1(r110, r101));     // Catch: Exception -> L23
        return true;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L23
    L16:
        r104.innerLogD(TAG, "requestPermission", "使用初始化注入的权限申请能力申请权限");     // Catch: Exception -> L23
        DownloadPermissionChecker r107 = GlobalInfo.getDownloadPermissionChecker();     // Catch: Exception -> L23
        Object[] r108 = r101.toArray(new String[0]);     // Catch: Exception -> L23
        if (r108 == null) goto L22;
        r107.requestPermission(r100, (String[]) r108, new AnonymousClass2(r110, r101));     // Catch: Exception -> L23
        return true;
    L22:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L23
    }

    @Override // com.ss.android.download.api.runtime.IAdPermissionProvider
    public void onRequestPermissionsResult(Activity r100, int r101, List<String> r102, int[] r110) {
        if (this.needDefaultFactory == false) goto L9;
        DefaultPermissionChecker r103 = this.defaultPermissionChecker;
        Object[] r104 = r102.toArray(new String[0]);
        if (r104 == null) goto L8;
        r103.onRequestPermissionsResult(r100, r101, (String[]) r104, r110);
        return;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "onRequestPermissionsResult", "使用初始化注入的能力,暴露SDK内部Activity的onRequestPermissionsResult回调");
        DownloadPermissionChecker r105 = GlobalInfo.getDownloadPermissionChecker();
        Object[] r106 = r102.toArray(new String[0]);
        if (r106 == null) goto L14;
        r105.onRequestPermissionsResult(r100, r101, (String[]) r106, r110);
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
