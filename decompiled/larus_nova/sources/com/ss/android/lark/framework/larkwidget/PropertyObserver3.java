package com.ss.android.lark.framework.larkwidget;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0005BC\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0003H\u0016¢\u0006\u0002\u0010\u0011J5\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00018\u00032\b\u0010\u0014\u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u00012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u0017R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/PropertyObserver3;", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "P3", ExifInterface.TAG_MODEL, "Landroidx/lifecycle/Observer;", "property1", "Lkotlin/reflect/KProperty1;", "property2", "property3", "<init>", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;)V", "lastValue", "Lkotlin/Triple;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "onPropertyChanged", "data", "p1", "p2", "p3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PropertyObserver3<P1, P2, P3, Model> implements Observer<Model> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Model r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        throw null;
    }
}
