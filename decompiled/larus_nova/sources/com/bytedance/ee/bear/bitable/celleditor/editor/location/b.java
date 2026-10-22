package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import android.webkit.ValueCallback;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f209410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationEditorModel f209411b;

    public b(c r100, LocationEditorModel r101) {
        this.f209410a = r100;
        this.f209411b = r101;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        a r101 = this.f209410a.f209413e;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.celleditor.editor.location.LocationEditorActionHandler");
        r101.f(this.f209411b.getLocation(), false);
        if (((Boolean) r100).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.f209411b.getValue() == null) goto L9;
        UDToast.show(this.f209410a.f209412d.getContext(), R.string.Bitable_Field_LocationUpdated);
        return;
    }
}
