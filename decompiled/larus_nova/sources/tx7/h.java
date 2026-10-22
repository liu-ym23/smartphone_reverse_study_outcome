package tx7;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilderAction;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder;
import com.ivy.ivykit.api.bridge.inject.ShowActionSheetListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class h implements IHostStyleUIDepend {

    public static final class a implements ShowActionSheetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener f547833a;

        @Override // com.ivy.ivykit.api.bridge.inject.ShowActionSheetListener
        public final void onDismiss() {
            this.f547833a.onDismiss();
        }

        public a(com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener r100) {
            this.f547833a = r100;
        }

        @Override // com.ivy.ivykit.api.bridge.inject.ShowActionSheetListener
        public final void onSelect(int r100) {
            this.f547833a.onSelect(r100);
        }
    }

    public h() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final void setPageNaviStyle(IBDXBridgeContext r100, Activity r101, PageTitleBar r102) {
    }

    public static hx7.g a() {
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r100 = com.ivy.ivykit.api.bridge.b.f278301a;
        return (hx7.g) com.ivy.ivykit.api.bridge.b.a(hx7.g.class);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean hideLoading(IBDXBridgeContext r100) {
        if (r100 == null) goto L27;
        Activity r101 = r100.getOwnerActivity();
        if (r101 == null) goto L27;
        int r102 = vx7.a.f557494a;
        BulletContainerView r103 = (BulletContainerView) vx7.a.a(r100, BulletContainerView.class);
        if (r101.isFinishing() == true) goto L12;
        if (r103 == null) goto L12;
        r103.s();
        return Boolean.TRUE;
    L12:
        if ((r101 instanceof AbsBulletContainerActivity) == false) goto L21;
        AbsBulletContainerActivity r104 = (AbsBulletContainerActivity) r101;
        if (r104.isFinishing() == true) goto L20;
        BulletContainerView r105 = r104.f248176p;
        if (r105 == null) goto L20;
        r105.s();
    L20:
        return Boolean.TRUE;
    L21:
        hx7.g r106 = a();
        if (r106 == null) goto L25;
        r106.c(r101);
    L25:
        return Boolean.FALSE;
    L27:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showDialog(DialogBuilder r110) {
        Intrinsics.checkNotNullParameter(r110, "dialogBuilder");
        com.ivy.ivykit.api.bridge.inject.DialogBuilder r111 = new com.ivy.ivykit.api.bridge.inject.DialogBuilder(r110.getContext(), r110.getTitle(), r110.getMessage(), r110.getPositiveBtnText(), r110.getPositiveClickListener(), r110.getNegativeBtnText(), r110.getNegativeClickListener(), r110.getCancelListener(), r110.getCancelOnTouchOutside());
        hx7.g r100 = a();
        if (r100 != null) goto L7;
        Intrinsics.checkNotNullParameter(r110, "dialogBuilder");
        return null;
    L7:
        return Boolean.valueOf(r100.d(r111));
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(IBDXBridgeContext r100) {
        if (r100 == null) goto L27;
        Activity r101 = r100.getOwnerActivity();
        if (r101 == null) goto L27;
        int r102 = vx7.a.f557494a;
        BulletContainerView r103 = (BulletContainerView) vx7.a.a(r100, BulletContainerView.class);
        if (r101.isFinishing() == true) goto L12;
        if (r103 == null) goto L12;
        r103.t();
        return Boolean.TRUE;
    L12:
        if ((r101 instanceof AbsBulletContainerActivity) == false) goto L21;
        AbsBulletContainerActivity r104 = (AbsBulletContainerActivity) r101;
        if (r104.isFinishing() == true) goto L20;
        BulletContainerView r105 = r104.f248176p;
        if (r105 == null) goto L20;
        r105.t();
    L20:
        return Boolean.TRUE;
    L21:
        hx7.g r106 = a();
        if (r106 == null) goto L25;
        r106.a(r101);
    L25:
        return Boolean.FALSE;
    L27:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "toastBuilder");
        String r101 = r100.getMessage();
        if (r101 == null) goto L13;
        if (a() != null) goto L7;
        Toast.makeText(r100.getContext(), r101, 0).show();
        goto L13
    L7:
        Context r102 = r100.getContext();
        String r103 = r100.getType();
        com.ivy.ivykit.api.bridge.inject.ToastBuilder r104 = new com.ivy.ivykit.api.bridge.inject.ToastBuilder(r102, r100.getMessage(), r103, r100.getCustomIcon(), r100.getDuration(), r100.getIcon());
        r104.setExt(r100.getExt());
        if (r104.getMessage() == null) goto L13;
        hx7.g r105 = a();
        if (r105 == null) goto L13;
        r105.b(r104);
    L13:
        return Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r110, com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener r111) {
        Intrinsics.checkNotNullParameter(r110, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r111, "showActionSheetListener");
        Context r100 = r110.getContext();
        String r101 = r110.getTitle();
        String r102 = r110.getSubtitle();
        List<ActionSheetBuilderAction> r103 = r110.getActions();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        ActionSheetBuilderAction r106 = (ActionSheetBuilderAction) r105.next();
        r104.add(new com.ivy.ivykit.api.bridge.inject.ActionSheetBuilderAction(r106.getTitle(), r106.getSubtitle(), r106.getType()));
        goto L4
    L6:
        com.ivy.ivykit.api.bridge.inject.ActionSheetBuilder r107 = new com.ivy.ivykit.api.bridge.inject.ActionSheetBuilder(r100, r101, r102, r104);
        hx7.g r108 = a();
        if (r108 == null) goto L9;
        r108.e(r107, new a(r111));
        return Boolean.FALSE;
    L9:
        Intrinsics.checkNotNullParameter(r110, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r111, "showActionSheetListener");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(hd7.a r100, IBDXBridgeContext r101) {
        Intrinsics.checkNotNullParameter(null, "showLoadingParams");
        return null;
    }
}
