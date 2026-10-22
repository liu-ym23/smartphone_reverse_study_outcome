package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class y0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f225449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f225450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Long> f225451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TTPdfReader f225452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DrivePreviewAiResourceContextVM f225453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BubbleMenuVM f225454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225456h;

    public y0(Ref.BooleanRef r100, Ref.BooleanRef r101, Ref.ObjectRef<Long> r102, TTPdfReader r103, DrivePreviewAiResourceContextVM r104, BubbleMenuVM r105, com.bytedance.ee.bear.drive.view.widget.a r106, com.bytedance.ee.bear.drive.view.widget.a r107) {
        this.f225449a = r100;
        this.f225450b = r101;
        this.f225451c = r102;
        this.f225452d = r103;
        this.f225453e = r104;
        this.f225454f = r105;
        this.f225455g = r106;
        this.f225456h = r107;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        Ref.BooleanRef r100 = this.f225449a;
        r100.element = Intrinsics.areEqual((Boolean) r110, Boolean.TRUE);
        v0.a(this.f225449a, this.f225450b, this.f225451c, this.f225452d, this.f225453e, this.f225454f, this.f225455g, this.f225456h);
    }
}
