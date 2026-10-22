package com.larksuite.component.universe_design.shadow;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001:\u0004PQRSB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u00103\u001a\u0002042\b\b\u0001\u00105\u001a\u00020\nJ\u0018\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0014J0\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\u0012\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\nH\u0016J\u001c\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J$\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\"\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH\u0016J\u0012\u0010H\u001a\u00020I2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020EH\u0014J\b\u0010K\u001a\u00020IH\u0014J\u001a\u0010L\u001a\u0002042\b\u0010M\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\nH\u0002J\"\u0010N\u001a\u0002042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010O\u001a\u000204H\u0002R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010.\u001a\u00060/R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b0\u00101¨\u0006T"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;", "shadowSize", "getShadowSize", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;", "setShadowSize", "(Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;)V", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;", "shadowDirection", "getShadowDirection", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;", "setShadowDirection", "(Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;)V", "shadowColor", "getShadowColor", "()I", "setShadowColor", "(I)V", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "shadowRadius", "getShadowRadius", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setShadowRadius", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "shadowPaint", "Landroid/graphics/Paint;", "getShadowPaint", "()Landroid/graphics/Paint;", "shadowPaint$delegate", "Lkotlin/Lazy;", "shadowRect", "Landroid/graphics/RectF;", "shadowView", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$UDShadowView;", "getShadowView", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$UDShadowView;", "shadowView$delegate", "applyStyle", "", "styleId", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "generateLayoutParams", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$LayoutParams;", "lp", "generateDefaultLayoutParams", "checkChildrenCountBeforeAddView", "view", "applyAttrs", "setUpPaint", "LayoutParams", "Size", "Direction", "UDShadowView", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDShadowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Size f285223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Direction f285224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f285225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDDimension f285226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f285227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f285228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f285229g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;", "", "x", "", "y", "<init>", "(Ljava/lang/String;III)V", "getX$universe_ui_shadow_release", "()I", "getY$universe_ui_shadow_release", UserProfileEvent.POSITION_NONE, "UP", "DOWN", "LEFT", "RIGHT", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Direction extends Enum<Direction> {
        public static final Direction DOWN = null;
        public static final Direction LEFT = null;
        public static final Direction NONE = null;
        public static final Direction RIGHT = null;
        public static final Direction UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f285230a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285231b = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f285232x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final int f285233y;

        public static EnumEntries<Direction> getEntries() {
            return f285231b;
        }

        static {
            Direction r100 = new Direction(UserProfileEvent.POSITION_NONE, 0, 0, 0);
            NONE = r100;
            Direction r101 = new Direction("UP", 1, 0, -1);
            UP = r101;
            Direction r102 = new Direction("DOWN", 2, 0, 1);
            DOWN = r102;
            Direction r103 = new Direction("LEFT", 3, -1, 0);
            LEFT = r103;
            Direction r104 = new Direction("RIGHT", 4, 1, 0);
            RIGHT = r104;
            Direction[] r105 = {r100, r101, r102, r103, r104};
            f285230a = r105;
            f285231b = EnumEntriesKt.enumEntries(r105);
        }

        public static Direction[] values() {
            return (Direction[]) f285230a.clone();
        }

        public final int getX$universe_ui_shadow_release() {
            return this.f285232x;
        }

        public final int getY$universe_ui_shadow_release() {
            return this.f285233y;
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public Direction(String r100, int r101, int r102, int r103) {
            super(r100, r101);
            this.f285232x = r102;
            this.f285233y = r103;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\tH\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006,"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "hasLeftMarginSet", "", "getHasLeftMarginSet$universe_ui_shadow_release", "()Z", "setHasLeftMarginSet$universe_ui_shadow_release", "(Z)V", "hasTopMarginSet", "getHasTopMarginSet$universe_ui_shadow_release", "setHasTopMarginSet$universe_ui_shadow_release", "hasRightMarginSet", "getHasRightMarginSet$universe_ui_shadow_release", "setHasRightMarginSet$universe_ui_shadow_release", "hasBottomMarginSet", "getHasBottomMarginSet$universe_ui_shadow_release", "setHasBottomMarginSet$universe_ui_shadow_release", "applyAttrs", "", PerfLog.PARAM_KEY_CONTEXT_ID, "setMargins", "left", "top", "right", "bottom", "setMarginStart", "start", "setMarginEnd", "end", "Companion", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f285234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f285235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f285236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f285237d;

        public static final class a {
        }

        static {
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginEnd(int r100) {
            super.setMarginEnd(r100);
            if (getLayoutDirection() != 0) goto L5;
            this.f285236c = true;
            return;
        L5:
            this.f285234a = true;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginStart(int r100) {
            super.setMarginStart(r100);
            if (getLayoutDirection() != 0) goto L5;
            this.f285234a = true;
            return;
        L5:
            this.f285236c = true;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, "c");
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical});
            if (r102.getDimensionPixelSize(0, -1) < 0) goto L5;
            this.f285235b = true;
            this.f285234a = true;
            this.f285236c = true;
            this.f285237d = true;
        L32:
            r102.recycle();
            return;
        L5:
            int r103 = r102.getDimensionPixelSize(7, -1);
            int r104 = r102.getDimensionPixelSize(8, -1);
            if (r103 < 0) goto L9;
            this.f285234a = true;
            this.f285236c = true;
        L14:
            if (r104 < 0) goto L17;
            this.f285235b = true;
            this.f285237d = true;
            goto L32
        L17:
            if (r102.getDimensionPixelSize(2, -1) < 0) goto L20;
            this.f285235b = true;
        L20:
            if (r102.getDimensionPixelSize(4, -1) < 0) goto L22;
            this.f285237d = true;
        L22:
            int r105 = r102.getDimensionPixelSize(5, -1);
            int r106 = r102.getDimensionPixelSize(6, -1);
            if (getLayoutDirection() != 0) goto L28;
            if (r105 < 0) goto L26;
            this.f285234a = true;
        L26:
            if (r106 < 0) goto L32;
            this.f285236c = true;
            goto L32
        L28:
            if (r105 < 0) goto L30;
            this.f285236c = true;
        L30:
            if (r106 < 0) goto L32;
            this.f285234a = true;
            goto L32
        L9:
            if (r102.getDimensionPixelSize(1, -1) < 0) goto L12;
            this.f285234a = true;
        L12:
            if (r102.getDimensionPixelSize(3, -1) < 0) goto L14;
            this.f285236c = true;
            goto L14
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMargins(int r100, int r101, int r102, int r103) {
            super.setMargins(r100, r101, r102, r103);
            this.f285235b = true;
            this.f285234a = true;
            this.f285236c = true;
            this.f285237d = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;", "", "blur", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "offset", "<init>", "(Ljava/lang/String;ILcom/larksuite/component/universe_design/dimension/UDDimension;Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "getBlur$universe_ui_shadow_release", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getOffset$universe_ui_shadow_release", UserProfileEvent.POSITION_NONE, "S1", "S2", "S3", "S4", "S5", ExifInterface.LATITUDE_SOUTH, "M", "L", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Size extends Enum<Size> {

        @Deprecated(message = "pleace replace with S4", replaceWith = @ReplaceWith(expression = "S4", imports = {}))
        public static final Size L = null;

        @Deprecated(message = "pleace replace with S3", replaceWith = @ReplaceWith(expression = "S3", imports = {}))
        public static final Size M = null;
        public static final Size NONE = null;

        @Deprecated(message = "pleace replace with S2", replaceWith = @ReplaceWith(expression = "S2", imports = {}))
        public static final Size S = null;
        public static final Size S1 = null;
        public static final Size S2 = null;
        public static final Size S3 = null;
        public static final Size S4 = null;
        public static final Size S5 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Size[] f285238a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285239b = null;
        private final UDDimension blur;
        private final UDDimension offset;

        public static EnumEntries<Size> getEntries() {
            return f285239b;
        }

        static {
            Size r100 = new Size(UserProfileEvent.POSITION_NONE, 0, new UDDimension.Dp(0), new UDDimension.Dp(0));
            NONE = r100;
            Size r101 = new Size("S1", 1, new UDDimension.Dp(4), new UDDimension.Dp(2));
            S1 = r101;
            Size r102 = new Size("S2", 2, new UDDimension.Dp(6), new UDDimension.Dp(2));
            S2 = r102;
            Size r103 = new Size("S3", 3, new UDDimension.Dp(8), new UDDimension.Dp(4));
            S3 = r103;
            Size r104 = new Size("S4", 4, new UDDimension.Dp(16), new UDDimension.Dp(6));
            S4 = r104;
            Size r110 = new Size("S5", 5, new UDDimension.Dp(36), new UDDimension.Dp(8));
            S5 = r110;
            Size r111 = new Size(ExifInterface.LATITUDE_SOUTH, 6, new UDDimension.Dp(6), new UDDimension.Dp(2));
            S = r111;
            Size r105 = new Size("M", 7, new UDDimension.Dp(8), new UDDimension.Dp(4));
            M = r105;
            Size r106 = new Size("L", 8, new UDDimension.Dp(16), new UDDimension.Dp(6));
            L = r106;
            Size[] r112 = {r100, r101, r102, r103, r104, r110, r111, r105, r106};
            f285238a = r112;
            f285239b = EnumEntriesKt.enumEntries(r112);
        }

        public static Size[] values() {
            return (Size[]) f285238a.clone();
        }

        public final UDDimension getBlur$universe_ui_shadow_release() {
            return this.blur;
        }

        public final UDDimension getOffset$universe_ui_shadow_release() {
            return this.offset;
        }

        public static Size valueOf(String r100) {
            return (Size) r27.a.a(Size.class, r100);
        }

        public Size(String r100, int r101, UDDimension.Dp r102, UDDimension.Dp r103) {
            super(r100, r101);
            this.blur = r102;
            this.offset = r103;
        }
    }

    public final class a extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDShadowLayout f285240a;

        @Override // android.view.View
        public final void onDraw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            if (this.f285240a.getChildAt(1) == null) goto L5;
            UDShadowLayout r101 = this.f285240a;
            float r102 = r101.getShadowRadius().toPixels(getContext());
            r100.drawRoundRect(r101.f285228f, r102, r102, UDShadowLayout.a(r101));
        L5:
            super.onDraw(r100);
        }

        public a(UDShadowLayout r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f285240a = r100;
            super(r101);
            if (Build.VERSION.SDK_INT >= 28) goto L6;
            setLayerType(1, null);
            return;
        }
    }

    private final Paint getShadowPaint() {
        return (Paint) this.f285227e.getValue();
    }

    private final a getShadowView() {
        return (a) this.f285229g.getValue();
    }

    public final void e() {
        float r100 = this.f285223a.getBlur$universe_ui_shadow_release().toPixels(getContext());
        float r101 = this.f285223a.getOffset$universe_ui_shadow_release().toPixels(getContext());
        getShadowPaint().setShadowLayer(r100, this.f285224b.getX$universe_ui_shadow_release() * r101, r101 * this.f285224b.getY$universe_ui_shadow_release(), this.f285225c);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public final int getShadowColor() {
        return this.f285225c;
    }

    public final Direction getShadowDirection() {
        return this.f285224b;
    }

    public final UDDimension getShadowRadius() {
        return this.f285226d;
    }

    public final Size getShadowSize() {
        return this.f285223a;
    }

    public UDShadowLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ Paint a(UDShadowLayout r100) {
        return r100.getShadowPaint();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        d(r100, getChildCount());
        super.addView(r100);
    }

    public final void c(int r100) {
        b(null, 0, r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "lp");
        return new LayoutParams(r100);
    }

    public final void setShadowColor(int r100) {
        if (r100 == this.f285225c) goto L6;
        this.f285225c = r100;
        e();
        invalidate();
        return;
    }

    public final void setShadowDirection(Direction r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100 == this.f285224b) goto L6;
        this.f285224b = r100;
        e();
        requestLayout();
        return;
    }

    public final void setShadowRadius(UDDimension r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f285226d = r100;
        invalidate();
    }

    public final void setShadowSize(Size r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100 == this.f285223a) goto L6;
        this.f285223a = r100;
        e();
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public UDShadowLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        d(r100, getChildCount());
        super.addView(r100, r101);
    }

    public final void d(View r100, int r101) {
        boolean r102 = true;
        if (getChildCount() >= 2) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L18;
        if (r101 != 0) goto L13;
        if (r101 == 0) goto L10;
    L12:
        r102 = false;
        goto L13
    L10:
        if ((r100 instanceof a) == false) goto L12;
    L13:
        if (r102 == false) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("Must not add view at 0 in UDShadowLayout!".toString());
    L18:
        throw new IllegalArgumentException("UDShadowLayout can host only one direct child".toString());
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        View r100 = getChildAt(1);
        if (r100 == null) goto L21;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larksuite.component.universe_design.shadow.UDShadowLayout.LayoutParams");
        LayoutParams r102 = (LayoutParams) r101;
        float r103 = this.f285223a.getBlur$universe_ui_shadow_release().toPixels(getContext());
        float r104 = this.f285223a.getOffset$universe_ui_shadow_release().toPixels(getContext());
        int r105 = 0;
        if (r102.f285235b == false) goto L7;
        int r106 = 0;
    L8:
        int r107 = r106 + 0;
        if (r102.f285237d == false) goto L11;
        int r108 = 0;
    L12:
        int r109 = r107 + r108;
        if (r102.f285234a == false) goto L15;
        int r112 = 0;
    L16:
        int r113 = r112 + 0;
        if (r102.f285236c == true) goto L20;
        r105 = Math.max(0, (int) (r103 + (r104 * this.f285224b.getX$universe_ui_shadow_release())));
    L20:
        int r114 = r113 + r105;
        measureChildWithMargins(r100, r110, r114, r111, r109);
        setMeasuredDimension(((((r100.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r102).leftMargin) + ((ViewGroup.MarginLayoutParams) r102).rightMargin) + getPaddingLeft()) + getPaddingRight()) + r114, ((((r100.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r102).topMargin) + ((ViewGroup.MarginLayoutParams) r102).bottomMargin) + getPaddingTop()) + getPaddingBottom()) + r109);
        goto L21
    L15:
        r112 = Math.max(0, (int) (r103 - (this.f285224b.getX$universe_ui_shadow_release() * r104)));
        goto L16
    L11:
        r108 = Math.max(0, (int) ((this.f285224b.getY$universe_ui_shadow_release() * r104) + r103));
        goto L12
    L7:
        r106 = Math.max(0, (int) (r103 - (this.f285224b.getY$universe_ui_shadow_release() * r104)));
    L21:
        getShadowView().measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101) {
        d(r100, r101);
        super.addView(r100, r101);
    }

    public UDShadowLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, com.larus.nova.R.style.UDShadow_None);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        d(r100, getChildCount());
        super.addView(r100, r101, r102);
    }

    public final void b(AttributeSet r100, int r101, int r102) {
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{com.larus.nova.R.attr.ud_shadow_color, com.larus.nova.R.attr.ud_shadow_direction, com.larus.nova.R.attr.ud_shadow_radius, com.larus.nova.R.attr.ud_shadow_size}, r101, r102);
        int r104 = r103.getInt(3, this.f285223a.ordinal());
        setShadowSize(Size.values()[r104]);
        int r105 = r103.getInt(1, this.f285224b.ordinal());
        setShadowDirection(Direction.values()[r105]);
        setShadowColor(r103.getColor(0, this.f285225c));
        setShadowRadius(new UDDimension.a(r103.getDimensionPixelSize(2, (int) this.f285226d.toPixels(getContext()))));
        r103.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        d(r100, r101);
        super.addView(r100, r101, r102);
    }

    public UDShadowLayout(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
        this.f285223a = Size.NONE;
        this.f285224b = Direction.NONE;
        this.f285226d = new UDDimension.Dp(0);
        this.f285227e = LazyKt.lazy(UDShadowLayout$shadowPaint$2.INSTANCE);
        this.f285228f = new RectF();
        this.f285229g = LazyKt.lazy(new UDShadowLayout$shadowView$2(this));
        addView(getShadowView(), 0, new LayoutParams(-1, -1));
        e();
        b(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        r105.layout(0, 0, r105.getMeasuredWidth(), r105.getMeasuredHeight());
        View r106 = getChildAt(1);
        if (r106 == null) goto L14;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.larksuite.component.universe_design.shadow.UDShadowLayout.LayoutParams");
        LayoutParams r108 = (LayoutParams) r107;
        float r109 = this.f285223a.getBlur$universe_ui_shadow_release().toPixels(getContext());
        float r110 = this.f285223a.getOffset$universe_ui_shadow_release().toPixels(getContext());
        if (r108.f285235b == false) goto L7;
        int r111 = getPaddingTop();
        int r112 = ((ViewGroup.MarginLayoutParams) r108).topMargin;
    L8:
        int r113 = r111 + r112;
        if (r108.f285234a == false) goto L11;
        int r114 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r108).leftMargin;
    L12:
        r106.layout(r114, r113, r106.getMeasuredWidth() + r114, r106.getMeasuredHeight() + r113);
        float r115 = r114;
        float r116 = r113;
        this.f285228f.set(r115, r116, r106.getMeasuredWidth() + r115, r106.getMeasuredHeight() + r116);
        return;
    L11:
        r114 = Math.max(0, (int) (r109 - (r110 * this.f285224b.getX$universe_ui_shadow_release()))) + getPaddingLeft();
        goto L12
    L7:
        r111 = getPaddingTop();
        r112 = Math.max(0, (int) (r109 - (this.f285224b.getY$universe_ui_shadow_release() * r110)));
        goto L8
    }
}
