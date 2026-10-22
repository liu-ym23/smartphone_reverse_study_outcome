package com.bytedance.creativex.mediaimport.view.internal.selector;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ti4.g0;
import yi4.a;
import yi4.b;
import yi4.c;

/* JADX INFO: loaded from: classes15.dex */
public final class MaterialSelectionItemMovedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f204089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<g0> f204090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<RecyclerView.ViewHolder, Long, ViewPropertyAnimator> f204091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<RecyclerView.ViewHolder, Long, ViewPropertyAnimator> f204092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f204093e;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rH\u0016J@\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/selector/MaterialSelectionItemMovedCallback$MaterialSelectorItemTouchCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "<init>", "(Lcom/bytedance/creativex/mediaimport/view/internal/selector/MaterialSelectionItemMovedCallback;)V", "recoverAnimateEnable", "", "fromPosition", "", "toPosition", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "from", RemoteMessageConst.TO, "onSelectedChanged", "", "viewHolder", "actionState", "clearView", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "isCurrentlyActive", "onSwiped", "p0", "p1", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MaterialSelectorItemTouchCallback extends ItemTouchHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f204094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f204095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f204096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MaterialSelectionItemMovedCallback f204097d;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onSwiped(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        public MaterialSelectorItemTouchCallback(MaterialSelectionItemMovedCallback r100) {
            this.f204097d = r100;
            this.f204095b = -1;
            this.f204096c = -1;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "viewHolder");
            int r102 = this.f204095b;
            if (r102 == (-1)) goto L9;
            int r103 = this.f204096c;
            if (r103 == (-1)) goto L9;
            if (r102 == r103) goto L8;
            this.f204097d.f204090b.onNext(new g0.c(r102, r103));
        L8:
            this.f204095b = -1;
            this.f204096c = -1;
        L9:
            super.clearView(r100, r101);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "holder");
            return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
            if (r101 == 0) goto L5;
            if (r100 == null) goto L5;
            MaterialSelectionItemMovedCallback r102 = this.f204097d;
            int r103 = r100.getAdapterPosition();
            r102.f204090b.onNext(new g0.a(r103));
        L5:
            super.onSelectedChanged(r100, r101);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "from");
            Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
            int r103 = r101.getAdapterPosition();
            int r104 = r102.getAdapterPosition();
            if (this.f204095b != (-1)) goto L6;
            this.f204095b = r103;
            this.f204096c = r104;
        L8:
            this.f204097d.f204090b.onNext(new g0.b(r103, r104));
            return true;
        L6:
            if (r103 != this.f204096c) goto L8;
            this.f204096c = r104;
            goto L8
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onChildDraw(Canvas r110, RecyclerView r210, RecyclerView.ViewHolder r211, float r212, float r213, int r214, boolean r215) {
            Intrinsics.checkNotNullParameter(r110, "c");
            Intrinsics.checkNotNullParameter(r210, "recyclerView");
            Intrinsics.checkNotNullParameter(r211, "viewHolder");
            View r100 = r211.itemView;
            double r101 = (((double) r100.getHeight()) * 0.25d) / ((double) 2);
            float r102 = r213;
            double r111 = (((double) r211.itemView.getTop()) - r101) + ((double) r102);
            double r112 = ((double) (r211.itemView.getHeight() * 1.25f)) + r111;
            if (r111 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
            float r103 = -((float) (((double) r211.itemView.getTop()) - r101));
        L5:
            r102 = r103;
        L10:
            if (this.f204097d.f204089a == true) goto L12;
            super.onChildDraw(r110, r210, r211, r212, r102, r214, r215);
            return;
        L12:
            if (r214 != 2) goto L17;
            if (r215 == false) goto L17;
            if (this.f204094a == true) goto L17;
            this.f204094a = true;
            this.f204097d.f204091c.invoke(r211, Long.valueOf(getAnimationDuration(r210, 8, r212, r102))).start();
            return;
        L17:
            if (r214 != 2) goto L22;
            if (r215 == true) goto L22;
            if (this.f204094a == false) goto L26;
            this.f204094a = false;
            this.f204097d.f204092d.invoke(r211, Long.valueOf(getAnimationDuration(r210, 8, r212, r102))).start();
            return;
        L26:
            return;
        L22:
            super.onChildDraw(r110, r210, r211, r212, r102, r214, r215);
            return;
        L7:
            if (r112 <= r210.getHeight()) goto L10;
            r103 = (float) (((double) r210.getBottom()) - (((double) r100.getBottom()) + r101));
            goto L5
        }
    }

    public MaterialSelectionItemMovedCallback(boolean r100, Function2<? super RecyclerView.ViewHolder, ? super Long, ? extends ViewPropertyAnimator> r101, Function2<? super RecyclerView.ViewHolder, ? super Long, ? extends ViewPropertyAnimator> r102) {
        this.f204089a = r100;
        this.f204090b = PublishSubject.create();
        Function2 r103 = r101;
        if (r101 != null) goto L5;
        r103 = new a();
    L5:
        this.f204091c = r103;
        Function2 r104 = r102;
        if (r102 != null) goto L8;
        r104 = new b();
    L8:
        this.f204092d = r104;
        this.f204093e = LazyKt.lazy(new c(this));
    }
}
