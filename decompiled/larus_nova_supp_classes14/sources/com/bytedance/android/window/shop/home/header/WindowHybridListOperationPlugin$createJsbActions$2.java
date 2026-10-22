package com.bytedance.android.window.shop.home.header;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowHybridListOperationPlugin$createJsbActions$2 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public WindowHybridListOperationPlugin$createJsbActions$2(WindowHybridListOperationPlugin r8) {
        super(1, r8, WindowHybridListOperationPlugin.class, "updateHybridList", "updateHybridList(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        WindowHybridListOperationPlugin r0 = (WindowHybridListOperationPlugin) ((CallableReference) this).receiver;
        if (r0.b.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) >= 0) goto L6;
        return;
    L6:
        if (ECWindowJsbPlugin.g(r4, r0.c.getShopParam().getSecAuthorId()) == false) goto L11;
        Disposable r5 = Observable.create(new a(r4)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r0), c.a);
        r0.c.add(r5);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
