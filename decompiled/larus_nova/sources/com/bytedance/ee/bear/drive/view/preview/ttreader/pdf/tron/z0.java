package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class z0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f225459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f225460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Long> f225461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TTPdfReader f225462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DrivePreviewAiResourceContextVM f225463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BubbleMenuVM f225464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225466h;

    public z0(Ref.BooleanRef r100, Ref.BooleanRef r101, Ref.ObjectRef<Long> r102, TTPdfReader r103, DrivePreviewAiResourceContextVM r104, BubbleMenuVM r105, com.bytedance.ee.bear.drive.view.widget.a r106, com.bytedance.ee.bear.drive.view.widget.a r107) {
        this.f225459a = r100;
        this.f225460b = r101;
        this.f225461c = r102;
        this.f225462d = r103;
        this.f225463e = r104;
        this.f225464f = r105;
        this.f225465g = r106;
        this.f225466h = r107;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        Ref.BooleanRef r100 = this.f225459a;
        r100.element = Intrinsics.areEqual((Boolean) r110, Boolean.TRUE);
        v0.a(this.f225460b, this.f225459a, this.f225461c, this.f225462d, this.f225463e, this.f225464f, this.f225465g, this.f225466h);
    }
}
