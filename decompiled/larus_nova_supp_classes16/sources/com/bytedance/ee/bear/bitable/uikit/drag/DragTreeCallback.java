package com.bytedance.ee.bear.bitable.uikit.drag;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0003GHIB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0011J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\"\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0002J0\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0'2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000bH\u0016J\"\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0002J \u0010-\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\tH\u0002J \u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u000bH\u0002J\u0018\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000bH\u0002J@\u0010;\u001a\u00020\u00172\u0006\u00108\u001a\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u001eH\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010A\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000bH\u0002J\u0010\u0010E\u001a\u00020\u00172\b\u0010F\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "mOnDragChangedCallbackListener", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$OnDragChangedCallbackListener;", "mDropOverPosition", "", "mDropTargetViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "treeLayoutParam", "Lcom/bytedance/ee/bear/bitable/uikit/drag/TreeLayoutParam;", "mDragIntent", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragIntent;", "mSelectViewHolder", "mSelectViewHolderCaptureBitmap", "Landroid/graphics/Bitmap;", "getDragIntent", "onSelectedChanged", "", "viewHolder", "actionState", "buildSelectedBitmap", "recycleSelectedBitmap", "getMovementFlags", "onMove", "", "target", "selectPos", "dropViewHolder", "curY", "fromPosition", "chooseDropTarget", "selected", "dropTargets", "", "curX", "onSwiped", "direction", "onChooseDropTarget", "targetViewHolder", "canMoveToParent", "parentPosition", "callbackListener", "getParentPos", "dropPosition", "dragOffsetLevel", "isInLegalRange", "position", "onDropOverRunnable", "Ljava/lang/Runnable;", "saveLayerAlpha", "c", "Landroid/graphics/Canvas;", "alpha", "onChildDraw", "dX", "", "dY", "isCurrentlyActive", "onDrawDropUI", "getMoveThreshold", "canDrawDropOverLine", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$DropOverLineType;", "itemPosition", "setOnDragChangedCallbackListener", "onDragChangedCallbackListener", "OnDragChangedCallbackListener", "DropOverLineType", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragTreeCallback extends ItemTouchHelper.Callback {
    public final RecyclerView a;
    public b b;
    public int c;
    public RecyclerView.ViewHolder d;
    public final hv4.b e;
    public final hv4.a f;
    public RecyclerView.ViewHolder g;
    public Bitmap h;
    public final c i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$DropOverLineType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "TOP", "BOTTOM", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DropOverLineType extends Enum<DropOverLineType> {
        public static final DropOverLineType BOTTOM = null;
        public static final DropOverLineType NONE = null;
        public static final DropOverLineType TOP = null;
        public static final /* synthetic */ DropOverLineType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DropOverLineType> getEntries() {
            return b;
        }

        static {
            DropOverLineType r0 = new DropOverLineType("NONE", 0);
            NONE = r0;
            DropOverLineType r1 = new DropOverLineType("TOP", 1);
            TOP = r1;
            DropOverLineType r3 = new DropOverLineType("BOTTOM", 2);
            BOTTOM = r3;
            DropOverLineType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DropOverLineType[] values() {
            return (DropOverLineType[]) a.clone();
        }

        public static DropOverLineType valueOf(String r1) {
            return (DropOverLineType) r27.a.a(DropOverLineType.class, r1);
        }

        public DropOverLineType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        int E1(int r1);

        void H0(RecyclerView.ViewHolder r1, int r2);

        int P1(int r1);

        Pair<Integer, Integer> c0(int r1, int r2);

        void c2(Canvas r1, RecyclerView.ViewHolder r2, hv4.a r3, int r4, DropOverLineType r5);

        void e1(RecyclerView.ViewHolder r1, hv4.a r2);

        int getMaxLevel();

        void s2(RecyclerView.ViewHolder r1, int r2);

        void t(int r1);

        int x(int r1);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DragTreeCallback a;

        public c(DragTreeCallback r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("SwipeDragTreeCallback", "onExpanedRunnable, pos:" + this.a.c);     // Catch: Throwable -> L6
            DragTreeCallback r0 = this.a;     // Catch: Throwable -> L6
            b r1 = r0.b;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.t(r0.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final float getMoveThreshold(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        return 0.0f;
    }

    public final boolean onMove(RecyclerView r2, RecyclerView.ViewHolder r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        Intrinsics.checkNotNullParameter(r4, "target");
        return false;
    }

    public final void onSwiped(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "viewHolder");
    }

    public DragTreeCallback(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r2;
        this.c = -100;
        this.e = new hv4.b();
        this.f = new hv4.a();
        this.i = new c(this);
    }

    public final int getMovementFlags(RecyclerView r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    public final void onSelectedChanged(RecyclerView.ViewHolder r5, int r6) {
        super.onSelectedChanged(r5, r6);
        if (r5 == null) goto L5;
        int r0 = r5.getBindingAdapterPosition();
    L6:
        if (r6 != 0) goto L8;
        RecyclerView.ViewHolder r7 = this.g;
        if (r7 == null) goto L26;
        r7.setIsRecyclable(true);
    L26:
        this.d = null;
        j.e(this.i);
        this.c = -100;
        b r8 = this.b;
        if (r8 == null) goto L29;
        r8.e1(this.g, this.f);
    L29:
        Bitmap r9 = this.h;
        if (r9 != null) goto L32;
    L34:
        this.h = null;
        this.g = null;
        return;
    L32:
        if (r9.isRecycled() == true) goto L34;
        r9.recycle();
        goto L34
    L8:
        if (r6 != 2) goto L38;
        if (r5 == null) goto L12;
        r5.setIsRecyclable(false);
    L12:
        this.g = r5;
        b r10 = this.b;
        if (r10 == null) goto L15;
        r10.s2(r5, r0);
    L15:
        RecyclerView.ViewHolder r11 = this.g;
        if (r11 == null) goto L20;
        View r12 = r11.itemView;
        if (r12 == null) goto L20;
        Bitmap r1 = Bitmap.createBitmap(r12.getWidth(), r12.getHeight(), Bitmap.Config.ARGB_8888);
        r12.draw(new Canvas(r1));
        this.h = r1;
    L20:
        b r13 = this.b;
        if (r13 == null) goto L36;
        r13.H0(r5, r0);
        return;
    L36:
        return;
    L38:
        return;
    L5:
        r0 = -1;
        goto L6
    }

    public final RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder r19, List<? extends RecyclerView.ViewHolder> r20, int r21, int r22) {
        RecyclerView.ViewHolder r1 = r19;
        Intrinsics.checkNotNullParameter(r1, "selected");
        Intrinsics.checkNotNullParameter(r20, "dropTargets");
        RecyclerView.ViewHolder r3 = super.chooseDropTarget(r19, r20, r21, r22);
        int r4 = r1.itemView.getHeight() + r22;
        int r5 = r1.itemView.getHeight() / 4;
        if (r3 == null) goto L5;
    L9:
        r1 = r3;
    L10:
        this.d = r1;
        tt5.a.h("SwipeDragTreeCallback", "chooseDropTargetEntry targetViewHolder:" + r1);
        RecyclerView.ViewHolder r6 = this.g;
        int r7 = -1;
        if (r6 == null) goto L13;
        int r8 = r6.getAdapterPosition();
    L14:
        if (r8 < 0) goto L68;
        if (r1 != null) goto L18;
        int r9 = r8;
    L28:
        if (this.c == r9) goto L30;
        boolean r16 = true;
    L31:
        this.c = r9;
        if (r9 != r8) goto L34;
        boolean r10 = true;
    L35:
        b r13 = this.b;
        if (r13 == null) goto L53;
        hv4.a r11 = this.f;
        int r12 = r13.x(r8);
        hv4.b r14 = this.e;
        int r17 = ((r21 - r14.a) / r14.b) + 1;
        int r18 = this.c;
        r11.update(r8, r12, r17, r18, r13.x(r18), r13.c0(this.c, r8));
        hv4.a r23 = this.f;
        int r24 = this.c;
        int r26 = r23.h;
        if (r26 != 1) goto L40;
        r7 = r24;
    L45:
        r23.e = r7;
        hv4.a r27 = this.f;
        int r28 = r27.e;
        if (r28 >= 0) goto L49;
    L50:
        boolean r29 = true;
    L52:
        r27.i = r29;
        goto L53
    L49:
        if ((r13.x(r28) + r13.P1(r8)) <= r13.getMaxLevel()) goto L50;
        r29 = false;
        goto L52
    L40:
        if (r24 == (-1)) goto L45;
        r7 = r13.E1(r24);
    L43:
        if (r26 >= 0) goto L45;
        r7 = r13.E1(r7);
        r26 = r26 + 1;
    L53:
        tt5.a.h("SwipeDragTreeCallback", "onChooseDropTarget dragIntent:" + this.f + " curY:" + r22);
        if (r16 == false) goto L68;
        j.e(this.i);
        if (r10 == true) goto L68;
        int r2 = this.c;
        if (r2 < 0) goto L65;
        RecyclerView.Adapter r30 = this.a.getAdapter();
        if (r30 == null) goto L62;
        int r31 = r30.getItemCount();
    L63:
        if (r2 > r31) goto L65;
        boolean r110 = true;
    L66:
        if (r110 == false) goto L68;
        j.d(this.i, 500);
        goto L68
    L62:
        r31 = 0;
    L65:
        r110 = false;
        goto L66
    L34:
        r10 = false;
        goto L35
    L30:
        r16 = false;
        goto L31
    L18:
        r9 = r1.getAdapterPosition();
        if (r9 != 0) goto L28;
        RecyclerView.ViewHolder r32 = this.g;
        if (r32 == null) goto L28;
        View r33 = r32.itemView;
        if (r33 == null) goto L28;
        if (r22 > (((-r33.getHeight()) / 3) * 2)) goto L28;
        r9 = -1;
    L68:
        return r1;
    L13:
        r8 = -1;
        goto L14
    L5:
        if (r4 > (r1.itemView.getBottom() + r5)) goto L9;
        if (r4 < (r1.itemView.getTop() - r5)) goto L9;
        tt5.a.h("SwipeDragTreeCallback", "chooseDropTarget self viewHolder.");
        goto L10
    }

    public final void onChildDraw(Canvas r13, RecyclerView r14, RecyclerView.ViewHolder r16, float r17, float r18, int r19, boolean r110) {
        Intrinsics.checkNotNullParameter(r13, "c");
        Intrinsics.checkNotNullParameter(r14, "recyclerView");
        Intrinsics.checkNotNullParameter(r16, "viewHolder");
        Bitmap r1 = this.h;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L12;
        tt5.a.k("SwipeDragTreeCallback", "onChildDraw isSelectBitmapValidate is false, can't draw origin item.");
    L12:
        if (r19 != 2) goto L18;
        if (r2 == false) goto L18;
        int r3 = r13.save();
        r13.saveLayerAlpha(new RectF(0.0f, 0.0f, r13.getWidth(), r13.getHeight()), 127);
        if (r1 == null) goto L17;
        r13.drawBitmap(r1, r16.itemView.getLeft(), r16.itemView.getTop(), null);
    L17:
        r13.restoreToCount(r3);
        tt5.a.h("SwipeDragTreeCallback", "onChildDraw top:" + r16.itemView.getTop());
    L18:
        RecyclerView.ViewHolder r4 = this.d;
        if (r4 == null) goto L34;
        int r5 = r4.getAdapterPosition();
        int r6 = this.c;
        if (r6 != (-1)) goto L25;
        if (r5 != 0) goto L25;
        DropOverLineType r7 = DropOverLineType.TOP;
    L28:
        DropOverLineType r8 = r7;
        tt5.a.h("SwipeDragTreeCallback", "onDrawDropUI mDropOverPos:" + this.c + " itemPos:" + r5 + " parentPos:" + this.f.e + " dropOverLineType:" + r8);
        if (r8 == DropOverLineType.NONE) goto L34;
        hv4.b r9 = this.e;
        hv4.a r10 = this.f;
        int r11 = r10.h * r9.b;
        b r12 = this.b;
        if (r12 == null) goto L34;
        r12.c2(r13, r4, r10, r11, r8);
    L25:
        if (r6 != r5) goto L27;
        r7 = DropOverLineType.BOTTOM;
        goto L28
    L27:
        r7 = DropOverLineType.NONE;
    L34:
        super.onChildDraw(r13, r14, r16, r17, r18, r19, r110);
        return;
    L5:
        if (r1.isRecycled() == true) goto L7;
        r2 = true;
        goto L9
    }
}
