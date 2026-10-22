package com.ss.android.lark.framework.larkwidget;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0004B/\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u000fJ+\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00018\u00022\b\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/PropertyObserver2;", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, ExifInterface.TAG_MODEL, "Landroidx/lifecycle/Observer;", "property1", "Lkotlin/reflect/KProperty1;", "property2", "<init>", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;)V", "lastValue", "Lkotlin/Pair;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "onPropertyChanged", "data", "p1", "p2", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PropertyObserver2<P1, P2, Model> implements Observer<Model> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Model r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        throw null;
    }
}
