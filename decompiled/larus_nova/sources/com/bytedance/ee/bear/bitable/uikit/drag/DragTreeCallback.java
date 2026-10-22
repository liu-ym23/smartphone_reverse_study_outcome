package com.bytedance.ee.bear.bitable.uikit.drag;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0003GHIB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0011J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\"\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0002J0\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0'2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000bH\u0016J\"\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0002J \u0010-\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\tH\u0002J \u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u000bH\u0002J\u0018\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000bH\u0002J@\u0010;\u001a\u00020\u00172\u0006\u00108\u001a\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u001eH\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010A\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000bH\u0002J\u0010\u0010E\u001a\u00020\u00172\b\u0010F\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "mOnDragChangedCallbackListener", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$OnDragChangedCallbackListener;", "mDropOverPosition", "", "mDropTargetViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "treeLayoutParam", "Lcom/bytedance/ee/bear/bitable/uikit/drag/TreeLayoutParam;", "mDragIntent", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragIntent;", "mSelectViewHolder", "mSelectViewHolderCaptureBitmap", "Landroid/graphics/Bitmap;", "getDragIntent", "onSelectedChanged", "", "viewHolder", "actionState", "buildSelectedBitmap", "recycleSelectedBitmap", "getMovementFlags", "onMove", "", PickerReporterConstants.KEY.TARGET, "selectPos", "dropViewHolder", "curY", "fromPosition", "chooseDropTarget", "selected", "dropTargets", "", "curX", "onSwiped", "direction", "onChooseDropTarget", "targetViewHolder", "canMoveToParent", "parentPosition", "callbackListener", "getParentPos", "dropPosition", "dragOffsetLevel", "isInLegalRange", "position", "onDropOverRunnable", "Ljava/lang/Runnable;", "saveLayerAlpha", "c", "Landroid/graphics/Canvas;", "alpha", "onChildDraw", "dX", "", "dY", "isCurrentlyActive", "onDrawDropUI", "getMoveThreshold", "canDrawDropOverLine", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$DropOverLineType;", "itemPosition", "setOnDragChangedCallbackListener", "onDragChangedCallbackListener", "OnDragChangedCallbackListener", "DropOverLineType", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragTreeCallback extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f216118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f216119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f216120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.ViewHolder f216121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hv4.b f216122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hv4.a f216123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView.ViewHolder f216124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f216125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f216126i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$DropOverLineType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "TOP", "BOTTOM", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DropOverLineType extends Enum<DropOverLineType> {
        public static final DropOverLineType BOTTOM = null;
        public static final DropOverLineType NONE = null;
        public static final DropOverLineType TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DropOverLineType[] f216127a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f216128b = null;

        public static EnumEntries<DropOverLineType> getEntries() {
            return f216128b;
        }

        static {
            DropOverLineType r100 = new DropOverLineType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            DropOverLineType r101 = new DropOverLineType("TOP", 1);
            TOP = r101;
            DropOverLineType r102 = new DropOverLineType("BOTTOM", 2);
            BOTTOM = r102;
            DropOverLineType[] r103 = {r100, r101, r102};
            f216127a = r103;
            f216128b = EnumEntriesKt.enumEntries(r103);
        }

        public static DropOverLineType[] values() {
            return (DropOverLineType[]) f216127a.clone();
        }

        public static DropOverLineType valueOf(String r100) {
            return (DropOverLineType) r27.a.a(DropOverLineType.class, r100);
        }

        public DropOverLineType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        int E1(int r100);

        void H0(RecyclerView.ViewHolder r100, int r101);

        int P1(int r100);

        Pair<Integer, Integer> c0(int r100, int r101);

        void c2(Canvas r100, RecyclerView.ViewHolder r101, hv4.a r102, int r103, DropOverLineType r104);

        void e1(RecyclerView.ViewHolder r100, hv4.a r101);

        int getMaxLevel();

        void s2(RecyclerView.ViewHolder r100, int r101);

        void t(int r100);

        int x(int r100);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DragTreeCallback f216129a;

        public c(DragTreeCallback r100) {
            this.f216129a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("SwipeDragTreeCallback", "onExpanedRunnable, pos:" + this.f216129a.f216120c);     // Catch: Throwable -> L6
            DragTreeCallback r100 = this.f216129a;     // Catch: Throwable -> L6
            b r101 = r100.f216119b;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.t(r100.f216120c);     // Catch: Throwable -> L6
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

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final float getMoveThreshold(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        return 0.0f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
    }

    public DragTreeCallback(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f216118a = r100;
        this.f216120c = -100;
        this.f216122e = new hv4.b();
        this.f216123f = new hv4.a();
        this.f216126i = new c(this);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
        super.onSelectedChanged(r100, r101);
        if (r100 == null) goto L5;
        int r102 = r100.getBindingAdapterPosition();
    L6:
        if (r101 != 0) goto L8;
        RecyclerView.ViewHolder r103 = this.f216124g;
        if (r103 == null) goto L26;
        r103.setIsRecyclable(true);
    L26:
        this.f216121d = null;
        j.e(this.f216126i);
        this.f216120c = -100;
        b r104 = this.f216119b;
        if (r104 == null) goto L29;
        r104.e1(this.f216124g, this.f216123f);
    L29:
        Bitmap r105 = this.f216125h;
        if (r105 != null) goto L32;
    L34:
        this.f216125h = null;
        this.f216124g = null;
        return;
    L32:
        if (r105.isRecycled() == true) goto L34;
        r105.recycle();
        goto L34
    L8:
        if (r101 != 2) goto L38;
        if (r100 == null) goto L12;
        r100.setIsRecyclable(false);
    L12:
        this.f216124g = r100;
        b r106 = this.f216119b;
        if (r106 == null) goto L15;
        r106.s2(r100, r102);
    L15:
        RecyclerView.ViewHolder r107 = this.f216124g;
        if (r107 == null) goto L20;
        View r108 = r107.itemView;
        if (r108 == null) goto L20;
        Bitmap r109 = Bitmap.createBitmap(r108.getWidth(), r108.getHeight(), Bitmap.Config.ARGB_8888);
        r108.draw(new Canvas(r109));
        this.f216125h = r109;
    L20:
        b r110 = this.f216119b;
        if (r110 == null) goto L36;
        r110.H0(r100, r102);
        return;
    L36:
        return;
    L38:
        return;
    L5:
        r102 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder r110, List<? extends RecyclerView.ViewHolder> r210, int r211, int r212) {
        RecyclerView.ViewHolder r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "selected");
        Intrinsics.checkNotNullParameter(r210, "dropTargets");
        RecyclerView.ViewHolder r101 = super.chooseDropTarget(r110, r210, r211, r212);
        int r102 = r100.itemView.getHeight() + r212;
        int r103 = r100.itemView.getHeight() / 4;
        if (r101 == null) goto L5;
    L9:
        r100 = r101;
    L10:
        this.f216121d = r100;
        tt5.a.h("SwipeDragTreeCallback", "chooseDropTargetEntry targetViewHolder:" + r100);
        RecyclerView.ViewHolder r104 = this.f216124g;
        int r105 = -1;
        if (r104 == null) goto L13;
        int r106 = r104.getAdapterPosition();
    L14:
        if (r106 < 0) goto L68;
        if (r100 != null) goto L18;
        int r107 = r106;
    L28:
        if (this.f216120c == r107) goto L30;
        boolean r111 = true;
    L31:
        this.f216120c = r107;
        if (r107 != r106) goto L34;
        boolean r108 = true;
    L35:
        b r112 = this.f216119b;
        if (r112 == null) goto L53;
        hv4.a r109 = this.f216123f;
        int r113 = r112.x(r106);
        hv4.b r114 = this.f216122e;
        int r115 = ((r211 - r114.f487308a) / r114.f487309b) + 1;
        int r116 = this.f216120c;
        r109.update(r106, r113, r115, r116, r112.x(r116), r112.c0(this.f216120c, r106));
        hv4.a r117 = this.f216123f;
        int r118 = this.f216120c;
        int r119 = r117.f487304h;
        if (r119 != 1) goto L40;
        r105 = r118;
    L45:
        r117.f487301e = r105;
        hv4.a r120 = this.f216123f;
        int r121 = r120.f487301e;
        if (r121 >= 0) goto L49;
    L50:
        boolean r122 = true;
    L52:
        r120.f487305i = r122;
        goto L53
    L49:
        if ((r112.x(r121) + r112.P1(r106)) <= r112.getMaxLevel()) goto L50;
        r122 = false;
        goto L52
    L40:
        if (r118 == (-1)) goto L45;
        r105 = r112.E1(r118);
    L43:
        if (r119 >= 0) goto L45;
        r105 = r112.E1(r105);
        r119 = r119 + 1;
    L53:
        tt5.a.h("SwipeDragTreeCallback", "onChooseDropTarget dragIntent:" + this.f216123f + " curY:" + r212);
        if (r111 == false) goto L68;
        j.e(this.f216126i);
        if (r108 == true) goto L68;
        int r123 = this.f216120c;
        if (r123 < 0) goto L65;
        RecyclerView.Adapter r124 = this.f216118a.getAdapter();
        if (r124 == null) goto L62;
        int r125 = r124.getItemCount();
    L63:
        if (r123 > r125) goto L65;
        boolean r126 = true;
    L66:
        if (r126 == false) goto L68;
        j.d(this.f216126i, 500);
        goto L68
    L62:
        r125 = 0;
    L65:
        r126 = false;
        goto L66
    L34:
        r108 = false;
        goto L35
    L30:
        r111 = false;
        goto L31
    L18:
        r107 = r100.getAdapterPosition();
        if (r107 != 0) goto L28;
        RecyclerView.ViewHolder r127 = this.f216124g;
        if (r127 == null) goto L28;
        View r128 = r127.itemView;
        if (r128 == null) goto L28;
        if (r212 > (((-r128.getHeight()) / 3) * 2)) goto L28;
        r107 = -1;
    L68:
        return r100;
    L13:
        r106 = -1;
        goto L14
    L5:
        if (r102 > (r100.itemView.getBottom() + r103)) goto L9;
        if (r102 < (r100.itemView.getTop() - r103)) goto L9;
        tt5.a.h("SwipeDragTreeCallback", "chooseDropTarget self viewHolder.");
        goto L10
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onChildDraw(Canvas r110, RecyclerView r111, RecyclerView.ViewHolder r112, float r113, float r114, int r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "recyclerView");
        Intrinsics.checkNotNullParameter(r112, "viewHolder");
        Bitmap r100 = this.f216125h;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L12;
        tt5.a.k("SwipeDragTreeCallback", "onChildDraw isSelectBitmapValidate is false, can't draw origin item.");
    L12:
        if (r115 != 2) goto L18;
        if (r101 == false) goto L18;
        int r102 = r110.save();
        r110.saveLayerAlpha(new RectF(0.0f, 0.0f, r110.getWidth(), r110.getHeight()), 127);
        if (r100 == null) goto L17;
        r110.drawBitmap(r100, r112.itemView.getLeft(), r112.itemView.getTop(), null);
    L17:
        r110.restoreToCount(r102);
        tt5.a.h("SwipeDragTreeCallback", "onChildDraw top:" + r112.itemView.getTop());
    L18:
        RecyclerView.ViewHolder r103 = this.f216121d;
        if (r103 == null) goto L34;
        int r104 = r103.getAdapterPosition();
        int r105 = this.f216120c;
        if (r105 != (-1)) goto L25;
        if (r104 != 0) goto L25;
        DropOverLineType r106 = DropOverLineType.TOP;
    L28:
        DropOverLineType r107 = r106;
        tt5.a.h("SwipeDragTreeCallback", "onDrawDropUI mDropOverPos:" + this.f216120c + " itemPos:" + r104 + " parentPos:" + this.f216123f.f487301e + " dropOverLineType:" + r107);
        if (r107 == DropOverLineType.NONE) goto L34;
        hv4.b r108 = this.f216122e;
        hv4.a r109 = this.f216123f;
        int r117 = r109.f487304h * r108.f487309b;
        b r118 = this.f216119b;
        if (r118 == null) goto L34;
        r118.c2(r110, r103, r109, r117, r107);
    L25:
        if (r105 != r104) goto L27;
        r106 = DropOverLineType.BOTTOM;
        goto L28
    L27:
        r106 = DropOverLineType.NONE;
    L34:
        super.onChildDraw(r110, r111, r112, r113, r114, r115, r116);
        return;
    L5:
        if (r100.isRecycled() == true) goto L7;
        r101 = true;
        goto L9
    }
}
