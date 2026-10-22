package com.ss.android.ugc.aweme.kiwi.presenter;

import android.content.Context;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ5\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\r\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/presenter/QContext;", "", "Landroidx/fragment/app/FragmentActivity;", ExifInterface.GPS_DIRECTION_TRUE, "activity", "()Landroid/support/v4/app/FragmentActivity;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Ljava/lang/Class;", "clazz", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "asyncVmOfFragment", "(Ljava/lang/Class;Landroid/support/v4/app/Fragment;)Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "vmOfFragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "(Ljava/lang/Class;Landroid/support/v4/app/Fragment;Landroid/arch/lifecycle/ViewModelProvider$Factory;)Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final class QContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f450890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public QUIManager f450891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f450892c;

    public final <T extends FragmentActivity> T a() {
        Context r100 = this.f450892c.getContext();
        if (r100 == null) goto L7;
        return (T) r100;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final Context c() {
        return this.f450892c.getContext();
    }

    public final QUIManager d() {
        QUIManager r100 = this.f450891b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uiManager");
    L5:
        return r100;
    }

    public final LifecycleOwner e() {
        Fragment r100 = this.f450890a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return a();
    }

    public QContext(View r100) {
        this.f450892c = r100;
    }

    public final <T extends QViewModel> T f(Class<T> r100) {
        Object r101 = this.f450892c.getContext();
        if (r101 == null) goto L7;
        return (T) new ViewModelProvider(a(), ((QViewModelOwner) r101).o6()).get(r100);
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner");
    }

    public final <T extends QViewModel> T g(Class<T> r100) {
        ActivityResultCaller r101 = this.f450890a;
        if (r101 == null) goto L10;
        QViewModelOwner r102 = (QViewModelOwner) r101;
        Fragment r103 = this.f450890a;
        if (r103 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return (T) new ViewModelProvider(r103, r102.o6()).get(r100);
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static QViewModel b(Class r100, Fragment r101) {
        return (QViewModel) new ViewModelProvider(r101, ((QViewModelOwner) r101).o6()).get(r100);
    L4:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static QViewModel h(Class r100, Fragment r101) {
        return (QViewModel) new ViewModelProvider(r101, ((QViewModelOwner) r101).o6()).get(r100);
    }
}
