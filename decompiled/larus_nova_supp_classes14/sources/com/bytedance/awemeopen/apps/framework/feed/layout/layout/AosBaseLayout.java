package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\r\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&R\"\u0010\u0011\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00048\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u0006/"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosBaseLayout;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/base/LifeCycleFrameLayout;", "Landroid/view/View;", "getView", "getVM", "()Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Landroid/os/Bundle;", "bundle", "", "setArguments", "d", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "getVm", "setVm", "(Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;)V", "vm", "e", "Landroid/view/View;", "getLayoutRootView", "()Landroid/view/View;", "setLayoutRootView", "(Landroid/view/View;)V", "layoutRootView", "f", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "", "g", "Z", "getDeliverHiddenChangedCache", "()Z", "setDeliverHiddenChangedCache", "(Z)V", "deliverHiddenChangedCache", "h", "getCreated", "setCreated", "created", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosBaseLayout<VM extends AosViewModel> extends LifeCycleFrameLayout {
    public VM d;
    public View e;
    public Bundle f;
    public boolean g;
    public boolean h;

    public abstract void e();

    public abstract int f();

    public boolean g() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout
    public View getView() {
        return this;
    }

    public abstract void h();

    public abstract void i();

    public void j() {
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public abstract Class<VM> m();

    public abstract void setArguments(Bundle r1);

    public final View getLayoutRootView() {
        View r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("layoutRootView");
        return null;
    }

    public final VM getVm() {
        VM r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    public final boolean o() {
        if (this.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        setLayoutRootView(LayoutInflater.from(getContext()).inflate(f(), this, true));
        ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
        r1.getClass();
        setVm((AosViewModel) new ViewModelProvider(this, r1).get(m()));
        j();
        k();
        e();
        h();
        if (l() == false) goto L5;
        getLayoutRootView().setPadding(getLayoutRootView().getPaddingLeft(), getLayoutRootView().getPaddingTop() + z04.c.a(getLayoutRootView().getContext()), getLayoutRootView().getPaddingRight(), getLayoutRootView().getPaddingBottom());
    L5:
        this.h = true;
    }

    public final VM getVM() {
        return (VM) getVm();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public void onDestroy() {
        super.onDestroy();
        i();
    }

    public final Bundle getBundle() {
        return this.f;
    }

    public final boolean getCreated() {
        return this.h;
    }

    public final boolean getDeliverHiddenChangedCache() {
        return this.g;
    }

    public AosBaseLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
    }

    public void c(boolean r1) {
        this.g = r1;
    }

    public final void setBundle(Bundle r1) {
        this.f = r1;
    }

    public final void setCreated(boolean r1) {
        this.h = r1;
    }

    public final void setDeliverHiddenChangedCache(boolean r1) {
        this.g = r1;
    }

    public final void setLayoutRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setVm(VM r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }
}
