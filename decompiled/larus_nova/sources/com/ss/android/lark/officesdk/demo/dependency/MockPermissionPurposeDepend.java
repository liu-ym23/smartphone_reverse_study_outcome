package com.ss.android.lark.officesdk.demo.dependency;

import android.app.Activity;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(o0c.a.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/demo/dependency/MockPermissionPurposeDepend;", "Lcom/ss/android/lark/permission/rxPermission/IPermissionPurposeDepend;", "<init>", "()V", "newPermissionPurposeWindow", "Lcom/ss/android/lark/permission/rxPermission/IPermissionPurposeDepend$IPermissionPurposeWindow;", "activity", "Landroid/app/Activity;", "enablePurposeDialog", "", "getAppDisplayName", "", "isLarkPackage", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MockPermissionPurposeDepend implements o0c.a {

    public static final class a implements o0c.a.InterfaceC7000a {
        public a() {
        }

        @Override // o0c.a.InterfaceC7000a
        public final /* synthetic */ void dismiss() {
        }

        @Override // o0c.a.InterfaceC7000a
        public final /* synthetic */ void show() {
        }
    }

    public MockPermissionPurposeDepend() {
    }

    @Override // o0c.a
    public boolean enablePurposeDialog() {
        return false;
    }

    @Override // o0c.a
    public String getAppDisplayName() {
        return "";
    }

    @Override // o0c.a
    public boolean isLarkPackage() {
        return false;
    }

    @Override // o0c.a
    public o0c.a.InterfaceC7000a newPermissionPurposeWindow(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new a();
    }
}
