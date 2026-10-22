package com.ss.android.lark.framework.larkwidget;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/PropertyObserver;", ExifInterface.TAG_MODEL, "Property", "Landroidx/lifecycle/Observer;", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lkotlin/reflect/KProperty1;", "<init>", "(Lkotlin/reflect/KProperty1;)V", "lastValue", "Ljava/lang/Object;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "onPropertyChanged", "data", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PropertyObserver<Model, Property> implements Observer<Model> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Model r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        throw null;
    }
}
