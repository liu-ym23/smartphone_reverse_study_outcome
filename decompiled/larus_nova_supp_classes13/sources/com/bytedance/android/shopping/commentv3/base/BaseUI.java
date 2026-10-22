package com.bytedance.android.shopping.commentv3.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.android.ec.core.arch.state.LivedataKt;
import com.bytedance.android.ec.core.utils.a0;
import com.bytedance.android.ec.core.utils.b0;
import com.bytedance.android.shopping.commentv3.base.a;
import com.bytedance.android.shopping.commentv3.base.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/base/BaseUI;", "Lcom/bytedance/android/shopping/commentv3/base/b;", "State", "Lcom/bytedance/android/shopping/commentv3/base/a;", "Logic", "Lcom/bytedance/android/shopping/commentv3/base/LifecycleUI;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseUI<State extends b, Logic extends com.bytedance.android.shopping.commentv3.base.a<State>> extends LifecycleUI {
    public Logic a;
    public final MediatorLiveData<State> b;

    public static final class a {
    }

    static {
    }

    public BaseUI() {
        this.b = new MediatorLiveData();
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public void onCreate() {
        super.onCreate();
        Logic r0 = this.a;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        dm.a.b r1 = dm.a.a;
        dm.a.a(getClass().getSimpleName()).i("onCreate");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public void onDestroy() {
        super.onDestroy();
        dm.a.b r0 = dm.a.a;
        dm.a.a(getClass().getSimpleName()).i("onDestroy");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onPause() {
        super.onPause();
        Logic r0 = this.a;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        dm.a.b r1 = dm.a.a;
        dm.a.a(getClass().getSimpleName()).i("onPause");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onResume() {
        super.onResume();
        Logic r0 = this.a;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        dm.a.b r1 = dm.a.a;
        dm.a.a(getClass().getSimpleName()).i("onResume");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onStart() {
        super.onStart();
        dm.a.b r0 = dm.a.a;
        dm.a.a(getClass().getSimpleName()).i("onStart");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onStop() {
        super.onStop();
        dm.a.b r0 = dm.a.a;
        dm.a.a(getClass().getSimpleName()).i("onStop");
    }

    public static MediatorLiveData f(MediatorLiveData r1, final KProperty1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$childLiveData");
        Intrinsics.checkNotNullParameter(r2, "child");
        int r0 = b0.a;
        Function1<Object, Object> r3 = new BaseUI$childLiveData$1(r2);
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r3, "switchMapFunction");
        LiveData r4 = Transformations.map(r1, new a0(r3));
        Intrinsics.checkNotNullParameter(r4, "$this$distinctUntilChanged");
        MediatorLiveData r5 = new MediatorLiveData();
        r5.addSource(r4, new LivedataKt.transformationsDistinctUntilChanged.1(r5));
        return r5;
    }
}
