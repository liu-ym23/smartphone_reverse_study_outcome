package com.bytedance.caijing.sdk.infra.base.impl.container.xelement.keyboard;

import android.os.Handler;
import android.os.Looper;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import y6a.h;
import y6a.i;
import y6a.o;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/container/xelement/keyboard/CJKeyboardShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Ly6a/h;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "<init>", "()V", "cj-host-service-impl-container_release"}, k = 1, mv = {1, 6, 0})
public final class CJKeyboardShadowNode extends ShadowNode implements h, ICJTag {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Float f202546v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Float f202547w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Handler f202548x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f202549y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f202550z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJKeyboardShadowNode f202551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f202552b;

        public a(CJKeyboardShadowNode r100, int r101) {
            this.f202551a = r100;
            this.f202552b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CJKeyboardShadowNode r100 = this.f202551a;     // Catch: Throwable -> L9
            int r101 = this.f202552b;     // Catch: Throwable -> L9
            if (r101 < 0) goto L7;
            float r102 = r101;
            if (Intrinsics.areEqual(r100.f202546v, r102) == true) goto L14;
            r100.f202546v = Float.valueOf(r102);     // Catch: Throwable -> L9
            r100.q();     // Catch: Throwable -> L9
        L14:
            return;
        L7:
            r100.getClass();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJKeyboardShadowNode f202553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f202554b;

        public b(CJKeyboardShadowNode r100, int r101) {
            this.f202553a = r100;
            this.f202554b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CJKeyboardShadowNode r100 = this.f202553a;     // Catch: Throwable -> L9
            int r101 = this.f202554b;     // Catch: Throwable -> L9
            if (r101 < 0) goto L7;
            float r102 = r101;
            if (Intrinsics.areEqual(r100.f202546v, r102) == true) goto L14;
            r100.f202546v = Float.valueOf(r102);     // Catch: Throwable -> L9
            r100.q();     // Catch: Throwable -> L9
        L14:
            return;
        L7:
            r100.getClass();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "CJKeyboardShadowNode";
    }

    public CJKeyboardShadowNode() {
        this.f202550z = new Object();
        i(this);
    }

    public final void C(int r100) {
        Object r101 = this.f202550z;
        monitor-enter(r101);
        Handler r102 = this.f202548x;     // Catch: Throwable -> L10
        if (r102 != null) goto L7;
        this.f202549y = new a(this, r100);     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);
        return;
    L7:
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L10
        r102.post(new b(this, r100));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // y6a.h
    public final long c(LayoutNode r100, float r101, MeasureMode r102, float r103, MeasureMode r104) {
        Object r105 = this.f202550z;
        monitor-enter(r105);
        Float r106 = null;
        if (this.f202548x != null) goto L9;
        Looper r107 = Looper.myLooper();     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L27
        Handler r108 = new Handler(r107);     // Catch: Throwable -> L27
        this.f202548x = r108;     // Catch: Throwable -> L27
        if (this.f202549y == null) goto L9;
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L27
        a r109 = this.f202549y;     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L27
        r108.post(r109);     // Catch: Throwable -> L27
        this.f202549y = null;     // Catch: Throwable -> L27
    L9:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r105);
        ICJTag.DefaultImpls.i(this, "width: " + r101 + ", height: " + this.f202546v + ", height: " + r103);
        if (r100 == null) goto L16;
        o r111 = r100.f382209h;
        if (r111 == null) goto L16;
        r106 = Float.valueOf(r111.a());
    L16:
        Float r112 = this.f202546v;
        if (r112 == null) goto L19;
        Intrinsics.checkNotNull(r112);
        return i.a(r101, r112.floatValue());
    L19:
        if (r104 != MeasureMode.EXACTLY) goto L33;
        if (r106 == null) goto L33;
        if (r106.floatValue() <= 0.0f) goto L33;
        this.f202546v = Float.valueOf(r103);
        this.f202547w = Float.valueOf(r103);
        return i.a(r101, r103);
    L33:
        return i.a(r101, 0.0f);
    L27:
        th = move-exception;
        throw th;
    }
}
