package com.bytedance.jedi.ext.adapter;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "<init>", "()V", "SimpleViewHolderState", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public final class Factory implements ViewModelProvider.Factory {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/Factory$SimpleViewHolderState;", "Lcom/bytedance/jedi/arch/State;", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
    public static final class SimpleViewHolderState implements State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Unit f250953a;

        public SimpleViewHolderState() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof SimpleViewHolderState) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f250953a, ((SimpleViewHolderState) r100).f250953a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Unit r100 = this.f250953a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "SimpleViewHolderState(trigger=" + this.f250953a + ")";
        }

        public SimpleViewHolderState(int r100) {
            this.f250953a = Unit.INSTANCE;
        }
    }

    public static final class a extends JediViewModel<SimpleViewHolderState> {
        @Override // com.bytedance.jedi.arch.JediViewModel
        public SimpleViewHolderState defaultState() {
            return new SimpleViewHolderState(0);
        }

        public a() {
        }

        @Override // com.bytedance.jedi.arch.JediViewModel
        public /* bridge */ /* synthetic */ State defaultState() {
            return defaultState();
        }
    }

    public Factory() {
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
        return new a();
    }
}
