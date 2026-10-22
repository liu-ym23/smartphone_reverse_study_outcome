package com.bytedance.live.photoviewer.transition;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import zj6.b;
import zj6.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/live/photoviewer/transition/TransitionPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "holder", "", "position", "", "onBindViewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V", "onViewAttachedToWindow", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "onViewDetachedFromWindow", "<init>", "()V", "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public abstract class TransitionPagerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f255714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f255715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f255716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f255717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<c> f255718e;

    public void onDestroy() {
    }

    public void y2(Configuration r100) {
    }

    public TransitionPagerAdapter() {
        this.f255718e = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(T r100) {
        super.onViewAttachedToWindow(r100);
        if (this.f255714a == false) goto L15;
        this.f255714a = false;
        View r101 = r100.itemView;
        if (r101 == null) goto L14;
        TransitionLayout r102 = (TransitionLayout) r101;
        Rect r103 = this.f255716c;
        if (r103 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        if (r102.f255703i.isRunning() == true) goto L15;
        r102.post(new b(r102, r103));
        goto L15
    L14:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.live.photoviewer.transition.TransitionLayout");
    L15:
        Iterator<T> r104 = this.f255718e.iterator();
    L17:
        if (r104.hasNext() == false) goto L23;
        c r105 = (c) r104.next();
        View r106 = r100.itemView;
        if (r106 == null) goto L22;
        ((TransitionLayout) r106).d(r105);
        goto L17
    L22:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.live.photoviewer.transition.TransitionLayout");
    L23:
        c r107 = this.f255717d;
        if (r107 == null) goto L30;
        View r108 = r100.itemView;
        if (r108 == null) goto L29;
        ((TransitionLayout) r108).d(r107);
        return;
    L29:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.live.photoviewer.transition.TransitionLayout");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(T r100) {
        super.onViewDetachedFromWindow(r100);
        Iterator<T> r101 = this.f255718e.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        c r102 = (c) r101.next();
        View r103 = r100.itemView;
        if (r103 == null) goto L9;
        ((TransitionLayout) r103).a(r102);
        goto L4
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.live.photoviewer.transition.TransitionLayout");
    L10:
        c r104 = this.f255717d;
        if (r104 == null) goto L17;
        View r105 = r100.itemView;
        if (r105 == null) goto L16;
        ((TransitionLayout) r105).a(r104);
        return;
    L16:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.live.photoviewer.transition.TransitionLayout");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(T r100, int r101) {
        if (this.f255714a == false) goto L9;
        Integer r102 = this.f255715b;
        if (r102 == null) goto L10;
        r102.intValue();
        return;
    L10:
        return;
    }
}
