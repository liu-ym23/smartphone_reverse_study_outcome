package com.ss.android.lark.framework.larkwidget;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u00052\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0006BW\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00000\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00010\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00020\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00018\u0004H\u0016¢\u0006\u0002\u0010\u0013J?\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00018\u00042\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00018\u00012\b\u0010\u0018\u001a\u0004\u0018\u00018\u00022\b\u0010\u0019\u001a\u0004\u0018\u00018\u0003H&¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u000e\u001a$\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u0003\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/PropertyObserver4;", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "P3", "P4", ExifInterface.TAG_MODEL, "Landroidx/lifecycle/Observer;", "property1", "Lkotlin/reflect/KProperty1;", "property2", "property3", "property4", "<init>", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;)V", "lastValue", "Lcom/ss/android/lark/framework/larkwidget/Tuple4;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "onPropertyChanged", "data", "p1", "p2", "p3", "p4", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PropertyObserver4<P1, P2, P3, P4, Model> implements Observer<Model> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Model r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        throw null;
    }
}
