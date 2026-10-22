package com.bytedance.locallife.hybrid.xbridge.depend.runtime3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dux.dialog.alert.g;
import com.bytedance.dux.panel.pad.Location;
import com.bytedance.dux.sheet.DuxActionSheet;
import com.bytedance.dux.toast.DuxToastV2;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.ies.bullet.ui.common.view.TitleBarRightBtn;
import com.bytedance.ies.xbridge.utils.f;
import com.bytedance.ies.xbridge.utils.i;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilderAction;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import h16.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wu6.d;

/* JADX INFO: loaded from: classes21.dex */
public final class BDXHostStyleUIDependImpl implements IHostStyleUIDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259086a;

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShowActionSheetListener f259087a;

        public a(ShowActionSheetListener r100) {
            this.f259087a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            this.f259087a.onDismiss();
            i.a("actionSheet dismiss callback");
        }
    }

    public BDXHostStyleUIDependImpl() {
        this.f259086a = BDXHostStyleUIDependImpl.class.getSimpleName();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean hideLoading(IBDXBridgeContext r100) {
        if (r100 == null) goto L30;
        Activity r101 = r100.getOwnerActivity();
        if (r101 == null) goto L30;
        e r102 = (e) d.a(r100, e.class);
        if (r102 != null) goto L11;
        return Boolean.FALSE;
    L11:
        if ((r102 instanceof BulletContainerView) == false) goto L18;
        if (r101.isFinishing() == true) goto L16;
        ((BulletContainerView) r102).s();
    L16:
        return Boolean.TRUE;
    L18:
        if ((r101 instanceof AbsBulletContainerActivity) == false) goto L28;
        AbsBulletContainerActivity r103 = (AbsBulletContainerActivity) r101;
        if (r103.isFinishing() == true) goto L26;
        BulletContainerView r104 = r103.f248176p;
        if (r104 == null) goto L26;
        r104.s();
    L26:
        return Boolean.TRUE;
    L28:
        return Boolean.FALSE;
    L30:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showDialog(DialogBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogBuilder");
        Activity r101 = f.f249557a.getActivity(r100.getContext());
        if (r101 == null) goto L5;
        boolean r102 = r100.getCancelOnTouchOutside();
        String r103 = r100.getPositiveBtnText();
        if (r100.getNegativeBtnText() != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        g r105 = new g(r101);
        r105.f204939h = r100.getTitle();
        r105.f204940i = r100.getMessage();
        r105.f204949r = true;
        Intrinsics.checkNotNull(r103);
        DialogInterface.OnClickListener r106 = r100.getPositiveClickListener();
        Intrinsics.checkNotNullParameter(r103, "text");
        r105.f204945n = r103;
        r105.f204946o = r106;
        r105.f204947p = null;
        if (r104 == true) goto L15;
    L17:
        if (r102 == true) goto L19;
    L21:
        r105.f533770c = r102;
        r105.c();
        return Boolean.TRUE;
    L19:
        if (r100.getCancelListener() == null) goto L21;
        DialogInterface.OnCancelListener r107 = r100.getCancelListener();
        Intrinsics.checkNotNull(r107);
        Intrinsics.checkNotNullParameter(r107, "onCancelListener");
        r105.f533769b = r107;
        goto L21
    L15:
        if (TextUtils.isEmpty(r100.getNegativeBtnText()) == true) goto L17;
        String r108 = r100.getNegativeBtnText();
        Intrinsics.checkNotNull(r108);
        g.d(r105, r108, r100.getNegativeClickListener());
        goto L17
    L9:
        if (r100.getNegativeClickListener() == null) goto L11;
        r104 = true;
        goto L12
    L5:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(IBDXBridgeContext r100) {
        if (r100 == null) goto L30;
        Activity r101 = r100.getOwnerActivity();
        if (r101 == null) goto L30;
        e r102 = (e) d.a(r100, e.class);
        if (r102 != null) goto L11;
        return Boolean.FALSE;
    L11:
        if ((r102 instanceof BulletContainerView) == false) goto L18;
        if (r101.isFinishing() == true) goto L16;
        ((BulletContainerView) r102).t();
    L16:
        return Boolean.TRUE;
    L18:
        if ((r101 instanceof AbsBulletContainerActivity) == false) goto L28;
        AbsBulletContainerActivity r103 = (AbsBulletContainerActivity) r101;
        if (r103.isFinishing() == true) goto L26;
        BulletContainerView r104 = r103.f248176p;
        if (r104 == null) goto L26;
        r104.t();
    L26:
        return Boolean.TRUE;
    L28:
        return Boolean.FALSE;
    L30:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "toastBuilder");
        HostServiceUtilsKt.c().log(this.f259086a, "context:" + r100.getContext() + ", message:" + r100.getMessage() + ", type: " + r100.getType() + ", duration:" + r100.getDuration());
        if (Intrinsics.areEqual(r100.getType(), "success") == false) goto L5;
    L8:
        WeakReference<com.bytedance.dux.toast.e> r101 = DuxToastV2.f205818a;
        DuxToastV2.b(r100.getContext(), r100.getMessage(), 252);
        return Boolean.TRUE;
    L5:
        if (Intrinsics.areEqual(r100.getType(), "error") == true) goto L8;
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r110, final ShowActionSheetListener r111) {
        Intrinsics.checkNotNullParameter(r110, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r111, "showActionSheetListener");
        Context r100 = r110.getContext();
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        ArrayList<DuxActionSheet.a> r101 = new ArrayList();
        Location r102 = Location.CENTER;
        String r103 = r110.getTitle();
        String r104 = r110.getSubtitle();
        Iterator<T> r112 = r110.getActions().iterator();
        final int r105 = 0;
    L7:
        String r106 = "";
        if (r112.hasNext() == false) goto L23;
        Object r107 = r112.next();
        int r113 = r105 + 1;
        if (r105 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        ActionSheetBuilderAction r108 = (ActionSheetBuilderAction) r107;
        if (Intrinsics.areEqual(r108.getType(), "default") == false) goto L16;
        r101.add(new DuxActionSheet.a(r108.getTitle(), r108.getSubtitle(), false, new BDXHostStyleUIDependImpl$showActionSheet$1$1(r111, r105)));
    L22:
        r105 = r113;
        goto L7
    L16:
        if (Intrinsics.areEqual(r108.getType(), "warn") == false) goto L22;
        String r109 = r108.getTitle();
        if (r109 == null) goto L21;
        r106 = r109;
    L21:
        Function2<View, DialogFragment, Unit> r114 = new BDXHostStyleUIDependImpl$showActionSheet$1$2(r111, r105);
        Intrinsics.checkNotNullParameter(r106, "title");
        r101.add(new DuxActionSheet.a(r106, null, true, r114));
        goto L22
    L23:
        DuxActionSheet r115 = new DuxActionSheet();
        r115.f205614x = r101;
        r115.f205607q = r103;
        r115.f205608r = r104;
        r115.f205609s = null;
        r115.f205610t = null;
        r115.f205330j = false;
        r115.f205329i = false;
        r115.f205334n = false;
        r115.f205616z = false;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r115.f205335o = r102;
        a r116 = new a(r111);
        Intrinsics.checkNotNullParameter(r116, "listener");
        r115.f205615y.add(r116);
        FragmentManager r117 = ((FragmentActivity) r100).getSupportFragmentManager();
        LandscapeRestrictionOperation r118 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r115, "", r118);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r117, r115, r118) == true) goto L29;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L27:
        r115.show(r117, "");
    L29:
        return Boolean.TRUE;
    L5:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(hd7.a r100, IBDXBridgeContext r101) {
        Intrinsics.checkNotNullParameter(null, "showLoadingParams");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final void setPageNaviStyle(IBDXBridgeContext r100, Activity r101, PageTitleBar r102) {
        if ((r101 instanceof AbsBulletContainerActivity) == false) goto L17;
        AbsBulletContainerActivity r103 = (AbsBulletContainerActivity) r101;
        if (r102 == null) goto L7;
        r102.getTitle();
    L7:
        if (r102 == null) goto L9;
        r102.getTitleColor();
    L9:
        if (r102 == null) goto L11;
        r102.getNavBarColor();
    L11:
        if (r102 == null) goto L15;
        String r104 = r102.getNavBtnType();
        if (r104 == null) goto L15;
        TitleBarRightBtn.Companion.getClass();
        TitleBarRightBtn.a.a(r104);
    L15:
        r103.getClass();
        return;
    }
}
