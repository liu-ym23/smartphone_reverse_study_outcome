package com.bytedance.locallife.hybrid.xbridge.depend.runtime2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dux.panel.pad.Location;
import com.bytedance.dux.sheet.DuxActionSheet;
import com.bytedance.dux.toast.DuxToastV2;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.ies.bullet.ui.common.view.TitleBarRightBtn;
import com.bytedance.ies.xbridge.base.runtime.depend.ActionSheetBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.ActionSheetBuilderAction;
import com.bytedance.ies.xbridge.base.runtime.depend.DialogBuilder;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.PageTitleBar;
import com.bytedance.ies.xbridge.base.runtime.depend.ShowActionSheetListener;
import com.bytedance.ies.xbridge.base.runtime.depend.ToastBuilder;
import com.bytedance.ies.xbridge.utils.f;
import com.bytedance.ies.xbridge.utils.i;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.ttvideoengine.model.VideoRef;
import f46.g;
import g66.c;
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
public final class XHostStyleUIDependImpl implements IHostStyleUIDepend {

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShowActionSheetListener f259085a;

        public a(ShowActionSheetListener r100) {
            this.f259085a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            this.f259085a.onDismiss();
            i.a("actionSheet dismiss callback");
        }
    }

    public XHostStyleUIDependImpl() {
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean hideLoading(c r100) {
        Context r101 = (Context) d.b(r100, Context.class);
        if (r101 == null) goto L5;
        Activity r102 = f.f249557a.getActivity(r101);
        if (r102 == null) goto L9;
        e r103 = (e) d.b(r100, e.class);
        if (r103 != null) goto L15;
        return Boolean.FALSE;
    L15:
        if ((r103 instanceof BulletContainerView) == false) goto L22;
        if (r102.isFinishing() == true) goto L20;
        ((BulletContainerView) r103).s();
    L20:
        return Boolean.TRUE;
    L22:
        if ((r102 instanceof AbsBulletContainerActivity) == false) goto L32;
        AbsBulletContainerActivity r104 = (AbsBulletContainerActivity) r102;
        if (r104.isFinishing() == true) goto L30;
        BulletContainerView r105 = r104.f248176p;
        if (r105 == null) goto L30;
        r105.s();
    L30:
        return Boolean.TRUE;
    L32:
        return Boolean.FALSE;
    L9:
        return Boolean.FALSE;
    L5:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showDialog(DialogBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogBuilder");
        Activity r101 = f.f249557a.getActivity(r100.getContext());
        if (r101 == null) goto L5;
        boolean r102 = r100.getCancelOnTouchOutside();
        String r103 = r100.getPositiveBtnText();
        g.a r104 = new g.a(r101);
        r104.f475557a = r100.getTitle();
        r104.f475558b = r100.getMessage();
        DialogInterface.OnClickListener r105 = r100.getPositiveClickListener();
        r104.f475559c = r103;
        r104.f475561e = r105;
        r104.f475567k = false;
        if (r100.getNegativeBtnText() != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == false) goto L14;
        String r107 = r100.getNegativeBtnText();
        DialogInterface.OnClickListener r108 = r100.getNegativeClickListener();
        r104.f475560d = r107;
        r104.f475562f = r108;
        r104.f475568l = false;
    L14:
        if (r102 == false) goto L16;
        r104.f475563g = r100.getCancelListener();
    L16:
        AlertDialog r109 = new g(r104).a();
        r109.setCancelable(r102);
        r109.setCanceledOnTouchOutside(r102);
        return Boolean.TRUE;
    L9:
        if (r100.getNegativeClickListener() == null) goto L11;
        r106 = true;
        goto L12
    L5:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(c r100) {
        Context r101 = (Context) d.b(r100, Context.class);
        if (r101 == null) goto L5;
        Activity r102 = f.f249557a.getActivity(r101);
        if (r102 == null) goto L9;
        e r103 = (e) d.b(r100, e.class);
        if (r103 != null) goto L15;
        return Boolean.FALSE;
    L15:
        if ((r103 instanceof BulletContainerView) == false) goto L22;
        if (r102.isFinishing() == true) goto L20;
        ((BulletContainerView) r103).t();
    L20:
        return Boolean.TRUE;
    L22:
        if ((r102 instanceof AbsBulletContainerActivity) == false) goto L32;
        AbsBulletContainerActivity r104 = (AbsBulletContainerActivity) r102;
        if (r104.isFinishing() == true) goto L30;
        BulletContainerView r105 = r104.f248176p;
        if (r105 == null) goto L30;
        r105.t();
    L30:
        return Boolean.TRUE;
    L32:
        return Boolean.FALSE;
    L9:
        return Boolean.FALSE;
    L5:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "toastBuilder");
        String r101 = r100.getType();
        if (Intrinsics.areEqual(r101, "success") == false) goto L6;
        WeakReference<com.bytedance.dux.toast.e> r102 = DuxToastV2.f205818a;
        DuxToastV2.b(r100.getContext(), r100.getMessage(), VideoRef.VALUE_VIDEO_REF_CONST_DEPTH);
        return Boolean.TRUE;
    L6:
        if (Intrinsics.areEqual(r101, "error") == false) goto L9;
        WeakReference<com.bytedance.dux.toast.e> r103 = DuxToastV2.f205818a;
        DuxToastV2.b(r100.getContext(), r100.getMessage(), VideoRef.VALUE_VIDEO_REF_CONST_DEPTH);
        return Boolean.TRUE;
    L9:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
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
        r101.add(new DuxActionSheet.a(r108.getTitle(), r108.getSubtitle(), false, new XHostStyleUIDependImpl$showActionSheet$1$1(r111, r105)));
    L22:
        r105 = r113;
        goto L7
    L16:
        if (Intrinsics.areEqual(r108.getType(), "warn") == false) goto L22;
        String r109 = r108.getTitle();
        if (r109 == null) goto L21;
        r106 = r109;
    L21:
        Function2<View, DialogFragment, Unit> r114 = new XHostStyleUIDependImpl$showActionSheet$1$2(r111, r105);
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
        Intrinsics.checkNotNull(r117);
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

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(s56.f r100, c r101) {
        Intrinsics.checkNotNullParameter(null, "showLoadingParams");
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostStyleUIDepend
    public final void setPageNaviStyle(c r100, Activity r101, PageTitleBar r102) {
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
