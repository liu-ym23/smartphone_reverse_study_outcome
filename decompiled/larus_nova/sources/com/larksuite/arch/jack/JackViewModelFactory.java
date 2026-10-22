package com.larksuite.arch.jack;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/larksuite/arch/jack/JackViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class JackViewModelFactory implements ViewModelProvider.Factory {
    public JackViewModelFactory() {
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        if (JackViewModel.class.isAssignableFrom(r100) == false) goto L19;
        T r101 = r100.newInstance();     // Catch: InvocationTargetException -> L6 InstantiationException -> L9 IllegalAccessException -> L12 NoSuchMethodException -> L15
        Intrinsics.checkNotNull(r101);     // Catch: InvocationTargetException -> L6 InstantiationException -> L9 IllegalAccessException -> L12 NoSuchMethodException -> L15
        return r101;
    L12:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    L9:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    L15:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    L6:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r100, e);
    L19:
        throw new IllegalArgumentException("Custom ViewModel must be a subclass of LifeAwareViewModel.");
    }
}
