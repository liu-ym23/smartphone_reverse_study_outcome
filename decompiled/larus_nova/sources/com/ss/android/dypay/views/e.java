package com.ss.android.dypay.views;

import android.graphics.Bitmap;
import android.text.TextUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f408512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f408513b;

    public e(f r100, String r101) {
        this.f408512a = r100;
        this.f408513b = r101;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        tta.e r100 = tta.c.f547570a;
        String r101 = this.f408513b;
        d r102 = new d(this);
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L31;
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        tta.h r105 = tta.c.f547571b;
        r105.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L20;
        Bitmap r106 = r105.f547587a.get(r101);
        if (r106 == null) goto L16;
        Boolean r107 = Boolean.valueOf(r106.isRecycled());
    L17:
        ?? r108 = r106;
        if (Intrinsics.areEqual(r107, Boolean.FALSE) == false) goto L20;
    L21:
        r104.element = r108;
        if (r108 != 0) goto L24;
    L32:
        tta.c.f547573d.post(new tta.d(r104, r101, r102));     // Catch: Throwable -> L28
    L28:
        Object r109 = r102.invoke(null);
    L29:
        Unit r110 = (Unit) r109;
        goto L31
    L24:
        if (r108.isRecycled() == true) goto L32;
        r109 = r102.invoke((Bitmap) r104.element);
        goto L29
    L16:
        r107 = null;
    L20:
        r108 = 0;
    L31:
        return Unit.INSTANCE;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
