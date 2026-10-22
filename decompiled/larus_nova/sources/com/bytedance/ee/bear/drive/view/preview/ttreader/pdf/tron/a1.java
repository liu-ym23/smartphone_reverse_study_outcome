package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class a1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f225317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f225318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Long> f225319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TTPdfReader f225320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DrivePreviewAiResourceContextVM f225321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BubbleMenuVM f225322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.view.widget.a f225324h;

    public a1(Ref.BooleanRef r100, Ref.BooleanRef r101, Ref.ObjectRef<Long> r102, TTPdfReader r103, DrivePreviewAiResourceContextVM r104, BubbleMenuVM r105, com.bytedance.ee.bear.drive.view.widget.a r106, com.bytedance.ee.bear.drive.view.widget.a r107) {
        this.f225317a = r100;
        this.f225318b = r101;
        this.f225319c = r102;
        this.f225320d = r103;
        this.f225321e = r104;
        this.f225322f = r105;
        this.f225323g = r106;
        this.f225324h = r107;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Long r101 = (Long) r100;
        v0.a(this.f225317a, this.f225318b, this.f225319c, this.f225320d, this.f225321e, this.f225322f, this.f225323g, this.f225324h);
    }
}
