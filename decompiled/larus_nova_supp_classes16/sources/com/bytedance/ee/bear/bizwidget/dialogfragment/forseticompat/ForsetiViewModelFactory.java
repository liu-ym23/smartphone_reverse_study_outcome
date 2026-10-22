package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016¢\u0006\u0002\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiViewModelFactory implements ViewModelProvider.Factory {
    public final FragmentActivity a;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public ForsetiViewModelFactory(FragmentActivity r1) {
        this.a = r1;
    }

    public final <T extends ViewModel> T create(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "modelClass");
        if (Intrinsics.areEqual(r4, ForsetiViewModel.class) == false) goto L7;
        return new ForsetiViewModel(new WeakReference(this.a));
    L7:
        throw new UnsupportedOperationException("module class:" + r4 + " not support");
    }
}
