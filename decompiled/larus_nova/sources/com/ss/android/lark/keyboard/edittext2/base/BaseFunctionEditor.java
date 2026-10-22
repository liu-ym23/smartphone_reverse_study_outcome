package com.ss.android.lark.keyboard.edittext2.base;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BaseFunctionEditor<T> implements com.ss.android.lark.keyboard.edittext2.base.a, b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f428957b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f428958a;

    public static final class a {
    }

    static {
    }

    public BaseFunctionEditor() {
    }

    public void P(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "targetEditable");
    }

    public void Q(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "targetEditable");
    }

    public abstract void S(SpannableStringBuilder r100, T r101, int r102);

    public void T(T r100, SpannableStringBuilder r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "text");
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final b getTarget() {
        b r100 = this.f428958a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PickerReporterConstants.KEY.TARGET);
        return null;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final Context context() {
        return getTarget().context();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428958a = r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
    }

    public void insert(T r100) {
        final SpannableStringBuilder r101 = new SpannableStringBuilder();
        R(r100, r101);
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        Log.i("BaseFunctionEditor", "insert: buffer is empty");
        return;
    L9:
        b r103 = getTarget();
        if ((r103 instanceof FunctionEditText) == false) goto L12;
        FunctionEditText r104 = (FunctionEditText) r103;
    L13:
        if (r104 == null) goto L16;
        r104.c(new AnonymousClass1(this, r101));
        return;
    L16:
        return;
    L12:
        r104 = null;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final <E extends com.ss.android.lark.keyboard.edittext2.base.a> E q(com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (E) getTarget().q(r100);
    }

    public final void R(T r100, SpannableStringBuilder r101) {
        Intrinsics.checkNotNullParameter(r101, "buffer");
        int r102 = r101.length();
        Log.d("BaseFunctionEditor", "onInsert: on start");
        S(r101, r100, r102);
        Log.d("BaseFunctionEditor", "onInsert: on end");
        T(r100, r101, r102, r101.length());
    }
}
