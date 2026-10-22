package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.ExtensionFragmentImpl;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\bH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J%\u0010#\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u0002H$\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\bJ\u0016\u0010)\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\rJ\u0016\u0010)\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020\rJ\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/facade/common/IExtensionHost;", "<init>", "()V", "extensionFragmentImpl", "Lcom/bytedance/ee/bear/facade/common/ExtensionFragmentImpl;", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onViewCreated", "view", "Landroid/view/View;", LiveCommonConstants.REASON_ON_DEDTROY, "onDetach", "handleInsets", "getInsetsConfig", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/InsetsConfig;", "registerBackPressHandler", "onBackPressed", "", "addExtension", "extension", "Lcom/bytedance/ee/bear/facade/common/BaseExtension;", "removeExtension", "findExtension", ExifInterface.GPS_DIRECTION_TRUE, "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "goBack", "goBackWithResult", "result", "requestKey", "", "onResume", "onPause", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseCCMForsetiFragment extends BaseFragment implements sa5.o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ExtensionFragmentImpl f216415e;

    public static final class a {
    }

    static {
    }

    public o U90() {
        return new o.a().a();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public boolean onBackPressed() {
        tt5.a.h("BaseCCMForsetiFragment", "onBackPressed");
        ExtensionFragmentImpl r100 = this.f216415e;
        if (r100 == null) goto L12;
        boolean r101 = false;
        if (r100 != null) goto L7;
    L9:
        if (r101 == false) goto L12;
        return true;
    L7:
        if (r100.a() != true) goto L9;
        r101 = true;
    L12:
        return super.onBackPressed();
    }

    public final void goBack() {
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L10;
        r100.g(null);
        if (getHost() == null) goto L16;
        getParentFragmentManager().beginTransaction().remove(this).commitNowAllowingStateLoss();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e("BaseCCMForsetiFragment", "dismiss error", th, false);
        return;
    L16:
        return;
    L10:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L18;
        r101.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f216415e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        tt5.a.h("BaseCCMForsetiFragment", "onPause: ");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        tt5.a.h("BaseCCMForsetiFragment", "onResume() called");
    }

    public BaseCCMForsetiFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public final void V90(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        com.suite.lark.component.navroute.forseti.g r101 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r101 == null) goto L5;
        r101.c(-1, r100);
        return;
    L5:
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L8;
        r102.setResult(-1, new Intent().putExtras(r100));
    L8:
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L13;
        r103.finish();
        return;
    }

    @Override // sa5.o
    public final void Xi(sa5.e r100) {
        ExtensionFragmentImpl r101 = this.f216415e;
        if (r101 == null) goto L6;
        r101.Xi(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        WeakReference r101 = new WeakReference(this);
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        this.f216415e = new ExtensionFragmentImpl(r101, CollectionsKt.listOf(new ta5.l(this)));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        o r101 = U90();
        com.ss.android.lark.insets.f r102 = WindowInsetsUtils.b(this);
        r102.c(r101.f216476a);
        r102.o(r101.f216477b);
        r102.f(r101.f216478c);
        r102.b(r101.f216479d);
        r102.i(r101.f216480e);
        FragmentBackPressedHelperKt.a(this, new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.a(this));
    }

    @Override // sa5.o
    public final sa5.e vb(Class r100) {
        ExtensionFragmentImpl r101 = this.f216415e;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.vb(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.setTag(R.id.extension_host, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r100, int r101, Intent r102) {
        ExtensionFragmentImpl r103 = this.f216415e;
        if (r103 == null) goto L8;
        Iterator r104 = ((ArrayList) r103.f541167a).iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        ((sa5.e) r104.next()).i(r100, r101, r102);
        goto L6
    L10:
        return;
    }
}
