package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z0<T> implements Observer {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Ref.ObjectRef<Long> c;
    public final /* synthetic */ TTPdfReader d;
    public final /* synthetic */ DrivePreviewAiResourceContextVM e;
    public final /* synthetic */ BubbleMenuVM f;
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a g;
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a h;

    public z0(Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef<Long> r3, TTPdfReader r4, DrivePreviewAiResourceContextVM r5, BubbleMenuVM r6, com.bytedance.ee.bear.drive.view.widget.a r7, com.bytedance.ee.bear.drive.view.widget.a r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final void onChanged(Object r10) {
        Ref.BooleanRef r0 = this.a;
        r0.element = Intrinsics.areEqual((Boolean) r10, Boolean.TRUE);
        v0.a(this.b, this.a, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
