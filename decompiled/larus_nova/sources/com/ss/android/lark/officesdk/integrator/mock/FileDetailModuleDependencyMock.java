package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.j0;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetail.dto.NetworkTypeListener;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;
import com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView;
import com.ss.android.lark.log.Log;
import java.util.List;
import ytb.f;
import ytb.g;
import ytb.h;
import ytb.i;
import ytb.j;
import ytb.k;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(hfb.b.class)
public class FileDetailModuleDependencyMock implements hfb.b {
    private static final String TAG = "FileDetailModuleDependencyMock";

    public class a implements hfb.b.l {
        public a() {
        }
    }

    public class b implements hfb.b.e {
        public b() {
        }
    }

    public class c implements hfb.b.f {
        public c() {
        }
    }

    public class d implements hfb.b.d {
        @Override // hfb.b.d
        public final void a() {
            Log.w(FileDetailModuleDependencyMock.TAG, "getMessagesByIds mocked");
        }

        @Override // hfb.b.d
        public final void b() {
            Log.w(FileDetailModuleDependencyMock.TAG, "getChatById mocked");
        }

        @Override // hfb.b.d
        public final void c() {
            Log.w(FileDetailModuleDependencyMock.TAG, "sendMessage mocked");
        }

        @Override // hfb.b.d
        public final void d() {
            Log.w(FileDetailModuleDependencyMock.TAG, "getLocalMessage mocked");
        }

        @Override // hfb.b.d
        public final void e() {
            Log.w(FileDetailModuleDependencyMock.TAG, "forwardFavoriteMessage mocked");
        }

        @Override // hfb.b.d
        public final void f() {
            Log.w(FileDetailModuleDependencyMock.TAG, "openChat mocked");
        }

        @Override // hfb.b.d
        public final void g() {
            Log.w(FileDetailModuleDependencyMock.TAG, "sendMessageWithRichText mocked");
        }

        @Override // hfb.b.d
        public final void h() {
            Log.w(FileDetailModuleDependencyMock.TAG, "openThread mocked");
        }

        @Override // hfb.b.d
        public final void i() {
            Log.w(FileDetailModuleDependencyMock.TAG, "forwardMessage mocked");
        }

        public d() {
        }
    }

    public class e implements hfb.b.InterfaceC6140b {
        public e() {
        }
    }

    public FileDetailModuleDependencyMock() {
    }

    public static /* synthetic */ void a(String r100, String r101, String r102, String r103, Message.SourceType r104, OpenFileInfo r105, UIGetDataCallback r106) {
        lambda$getDriveDependency$0(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void b(FileDetailLaunchParams r100) {
        lambda$getMailDependency$7(r100);
    }

    public static /* synthetic */ String c() {
        return lambda$getDynamicDomainDependency$1();
    }

    public static /* synthetic */ void d(List r100, UIGetDataCallback r101) {
        lambda$getFavoriteDependency$4(r100, r101);
    }

    public static /* synthetic */ boolean e() {
        return lambda$getFeatureConfigDependency$5();
    }

    public static /* synthetic */ void f(Context r100, String r101) {
        lambda$getSearchDependency$6(r100, r101);
    }

    public static /* synthetic */ void g(Context r100, String r101) {
        lambda$getBrowserDependency$3(r100, r101);
    }

    private static /* synthetic */ Activity lambda$getAppStateDependency$2() {
        Log.w(TAG, "getTopActivity mocked");
        return null;
    }

    private static /* synthetic */ String lambda$getDynamicDomainDependency$1() {
        Log.w(TAG, "getSecurityWebHost mocked");
        return null;
    }

    private static /* synthetic */ boolean lambda$getFeatureConfigDependency$5() {
        Log.w(TAG, "isFileDownloadEnable mocked");
        return true;
    }

    public hfb.b.a getAppStateDependency() {
        Log.w(TAG, "getAppStateDependency mocked");
        return new ytb.e();
    }

    @Override // hfb.b
    public hfb.b.InterfaceC6140b getAuditDependency() {
        Log.w(TAG, "getAuditDependency mocked");
        return new e();
    }

    @Override // hfb.b
    public hfb.b.c getBrowserDependency() {
        Log.w(TAG, "getBrowserDependency mocked");
        return new g();
    }

    @Override // hfb.b
    public hfb.b.d getChatDependency() {
        Log.w(TAG, "getChatDependency mocked");
        return new d();
    }

    @Override // hfb.b
    public Context getContext() {
        Log.w(TAG, "getContext mocked");
        return null;
    }

    @Override // hfb.b
    public hfb.b.e getDownloadDependency() {
        Log.w(TAG, "getDownloadDependency mocked");
        return new b();
    }

    @Override // hfb.b
    public hfb.b.f getDownloadFileMonitorDependency() {
        Log.w(TAG, "getDownloadFileMonitorDependency mocked");
        return new c();
    }

    @Override // hfb.b
    public hfb.b.g getDriveDependency() {
        Log.w(TAG, "getDriveDependency mocked");
        return new j();
    }

    @Override // hfb.b
    public hfb.b.h getDynamicDomainDependency() {
        Log.w(TAG, "getDynamicDomainDependency mocked");
        return new f();
    }

    @Override // hfb.b
    public hfb.b.i getFavoriteDependency() {
        Log.w(TAG, "getFavoriteDependency mocked");
        return new ytb.d();
    }

    @Override // hfb.b
    public hfb.b.j getFeatureConfigDependency() {
        Log.w(TAG, "getFeatureConfigDependency mocked");
        return new k();
    }

    @Override // hfb.b
    public ForwardEnhancedView getForwardEnhancedView() {
        Log.w(TAG, "getForwardEnhancedView mocked");
        return null;
    }

    @Override // hfb.b
    public hfb.b.k getMailDependency() {
        Log.w(TAG, "getMailDependency mocked");
        return new i();
    }

    @Override // hfb.b
    public hfb.b.l getPushDependency() {
        Log.w(TAG, "getPushDependency mocked");
        return new a();
    }

    @Override // hfb.b
    public hfb.b.m getSearchDependency() {
        Log.w(TAG, "getSearchDependency mocked");
        return new h();
    }

    @Override // hfb.b
    public String getUserId() {
        Log.w(TAG, "getUserId mocked");
        return "";
    }

    @Override // hfb.b
    public boolean isFeishuBrand() {
        Log.w(TAG, "isFeishuBrand mocked");
        return false;
    }

    private static /* synthetic */ void lambda$getMailDependency$7(FileDetailLaunchParams r100) {
        Log.w(TAG, "openEmlFile mocked");
    }

    @Override // hfb.b
    public void addListenerToDriveSaveStateEventPush(j0 r100) {
        Log.w(TAG, "addListenerToDriveSaveStateEventPush mocked");
    }

    @Override // hfb.b
    public void addListenerToNetworkTypeDispatcher(NetworkTypeListener r100) {
        Log.w(TAG, "addListenerToNetworkTypeDispatcher mocked");
    }

    public boolean isFeatureGatingCurrentEnable(String r100) {
        Log.w(TAG, "isFeatureGatingCurrentEnable mocked");
        return false;
    }

    @Override // hfb.b
    public boolean isFeatureGatingEnable(String r100) {
        Log.w(TAG, "isFeatureGatingEnable mocked");
        return false;
    }

    @Override // hfb.b
    public void removeListenerToDriveSaveStateEventPush(j0 r100) {
        Log.w(TAG, "removeListenerToDriveSaveStateEventPush mocked");
    }

    @Override // hfb.b
    public void removeListenerToNetworkTypeDispatcher(NetworkTypeListener r100) {
        Log.w(TAG, "removeListenerToNetworkTypeDispatcher mocked");
    }

    @Override // hfb.b
    public void showFullQuotoDialog(FragmentActivity r100) {
        Log.w(TAG, "showFullQuotoDialog mocked");
    }

    private static /* synthetic */ void lambda$getBrowserDependency$3(Context r100, String r101) {
        Log.w(TAG, "openUrl mocked");
    }

    private static /* synthetic */ void lambda$getFavoriteDependency$4(List r100, IGetDataCallback r101) {
        Log.w(TAG, "putFavoriteItems mocked");
    }

    private static /* synthetic */ void lambda$getSearchDependency$6(Context r100, String r101) {
        Log.w(TAG, "goToSearch mocked");
    }

    public void execPreviewAction(String r100, String r101) {
        Log.w(TAG, "execPreviewAction mocked");
    }

    private static /* synthetic */ void lambda$getDriveDependency$0(String r100, String r101, String r102, String r103, Message.SourceType r104, OpenFileInfo r105, IGetDataCallback r106) {
        Log.w(TAG, "saveToNutStore mocked");
    }
}
