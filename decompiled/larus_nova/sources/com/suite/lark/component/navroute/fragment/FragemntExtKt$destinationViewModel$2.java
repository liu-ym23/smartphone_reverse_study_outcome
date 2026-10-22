package com.suite.lark.component.navroute.fragment;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0014¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/suite/lark/component/navroute/fragment/FragemntExtKt$destinationViewModel$2", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FragemntExtKt$destinationViewModel$2 extends AbstractSavedStateViewModelFactory {
    public FragemntExtKt$destinationViewModel$2(FragmentActivity r100) {
        super(r100, null);
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public final <T extends ViewModel> T create(String r100, Class<T> r101, SavedStateHandle r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "modelClass");
        Intrinsics.checkNotNullParameter(r102, "handle");
        return new DestinationViewModel();
    }
}
