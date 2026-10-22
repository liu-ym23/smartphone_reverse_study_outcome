package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.ExtensionFragmentImpl;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.ss.android.lark.insets.WindowInsetsUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\bH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J%\u0010#\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u0002H$\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\bJ\u0016\u0010)\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\rJ\u0016\u0010)\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020\rJ\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/facade/common/IExtensionHost;", "<init>", "()V", "extensionFragmentImpl", "Lcom/bytedance/ee/bear/facade/common/ExtensionFragmentImpl;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onViewCreated", "view", "Landroid/view/View;", "onDestroy", "onDetach", "handleInsets", "getInsetsConfig", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/InsetsConfig;", "registerBackPressHandler", "onBackPressed", "", "addExtension", "extension", "Lcom/bytedance/ee/bear/facade/common/BaseExtension;", "removeExtension", "findExtension", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "goBack", "goBackWithResult", TipCallBackData.RESULT, "requestKey", "", "onResume", "onPause", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseCCMForsetiFragment extends BaseFragment implements sa5.o {
    public ExtensionFragmentImpl e;

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
        ExtensionFragmentImpl r0 = this.e;
        if (r0 == null) goto L12;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L12;
        return true;
    L7:
        if (r0.a() != true) goto L9;
        r1 = true;
    L12:
        return super.onBackPressed();
    }

    public final void goBack() {
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L10;
        r0.g(null);
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
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L18;
        r1.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onDetach() {
        super.onDetach();
        this.e = null;
    }

    public final void onPause() {
        super.onPause();
        tt5.a.h("BaseCCMForsetiFragment", "onPause: ");
    }

    public void onResume() {
        super.onResume();
        tt5.a.h("BaseCCMForsetiFragment", "onResume() called");
    }

    public BaseCCMForsetiFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onDestroy() {
        super.onDestroy();
    }

    public final void V90(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L5;
        r0.c(-1, r4);
        return;
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L8;
        r1.setResult(-1, new Intent().putExtras(r4));
    L8:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L13;
        r5.finish();
        return;
    }

    @Override // sa5.o
    public final void Xi(sa5.e r2) {
        ExtensionFragmentImpl r0 = this.e;
        if (r0 == null) goto L6;
        r0.Xi(r2);
        return;
    }

    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        WeakReference r0 = new WeakReference(this);
        Intrinsics.checkNotNullParameter(this, "fragment");
        this.e = new ExtensionFragmentImpl(r0, CollectionsKt.listOf(new ta5.l(this)));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        o r4 = U90();
        com.ss.android.lark.insets.f r0 = WindowInsetsUtils.b(this);
        r0.c(r4.a);
        r0.o(r4.b);
        r0.f(r4.c);
        r0.b(r4.d);
        r0.i(r4.e);
        FragmentBackPressedHelperKt.a(this, new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.a(this));
    }

    @Override // sa5.o
    public final sa5.e vb(Class r2) {
        ExtensionFragmentImpl r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.vb(r2);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        r2.setTag(2131371995, this);
    }

    public void onActivityResult(int r3, int r4, Intent r5) {
        ExtensionFragmentImpl r0 = this.e;
        if (r0 == null) goto L8;
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((sa5.e) r1.next()).i(r3, r4, r5);
        goto L6
    L10:
        return;
    }
}
