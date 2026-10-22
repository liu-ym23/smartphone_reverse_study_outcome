package com.bytedance.ee.bear.widgets.colorpicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0005)*+,-B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J0\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0007J%\u0010!\u001a\u00020\u00132\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mColorsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mSelectColorAdapter", "Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$SelectColorAdapter;", "mOnSelectColorListener", "Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$OnSelectColorListener;", "oldOrientation", "mViewType", "setRVLayoutManager", "", "recyclerView", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setViewType", "type", "setColorData", "colorList", "", "", "selectedColor", "([Ljava/lang/String;Ljava/lang/String;)V", "setOnSelectColorListener", "listener", "SelectColorAdapter", "SelectColorDecoration", "ViewType", "Companion", "OnSelectColorListener", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonColorPicker extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f240158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SelectColorAdapter f240159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f240160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f240161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f240162e;

    public static final class SelectColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f240163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f240164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f240165c;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$SelectColorAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$SelectColorAdapter;Landroid/view/View;)V", "outerLayer", "getOuterLayer", "()Landroid/view/View;", "setOuterLayer", "(Landroid/view/View;)V", "centerLayer", "getCenterLayer", "setCenterLayer", "innerLayer", "getInnerLayer", "setInnerLayer", "isSelected", "", "()Z", "setSelected", "(Z)V", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ColorViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f240166a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final View f240167b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final View f240168c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f240169d;

            public ColorViewHolder(View r100) {
                Intrinsics.checkNotNullParameter(r100, "itemView");
                super(r100);
                this.f240166a = r100.findViewById(R.id.outer_layer);
                this.f240167b = r100.findViewById(R.id.center_layer);
                this.f240168c = r100.findViewById(R.id.inner_layer);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            String[] r100 = this.f240163a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.length;
        }

        public SelectColorAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            ColorViewHolder r112 = (ColorViewHolder) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            if (this.f240163a == null) goto L42;
            if (r111 >= 0) goto L6;
            return;
        L6:
            if (r111 >= getItemCount()) goto L44;
            String[] r100 = this.f240163a;
            if (r100 == null) goto L11;
            String r113 = r100[r111];
        L13:
            if (TextUtils.isEmpty(r113) == true) goto L45;
            Resources r101 = r112.itemView.getContext().getResources();
            boolean r102 = true;
            r112.f240169d = StringsKt.equals(r113, this.f240164b, true);
            Drawable r103 = r112.f240166a.getBackground().mutate();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable r104 = (GradientDrawable) r103;
            Drawable r105 = r112.f240167b.getBackground().mutate();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable r106 = (GradientDrawable) r105;
            Drawable r107 = r112.f240168c.getBackground().mutate();
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable r108 = (GradientDrawable) r107;
            if (r112.f240169d == false) goto L18;
            int r109 = R.color.primary_fill_default;
        L19:
            r104.setColor(r101.getColor(r109));
            int r114 = r101.getDimensionPixelSize(R.dimen.space_kit_len_2);
            if (r112.f240169d == false) goto L22;
            int r115 = r101.getColor(R.color.bg_body);
        L23:
            r108.setStroke(r114, r115);
            Intrinsics.checkNotNull(r113);
            r108.setColor(ColorUtils.h(r113));
            if (r112.f240169d == false) goto L26;
            int r116 = r101.getColor(R.color.primary_fill_default);
        L27:
            r106.setColor(r116);
            if (r112.f240169d == true) goto L39;
            Context r117 = r112.itemView.getContext();
            int r118 = ColorUtils.h(r113);
            boolean r119 = ColorUtils.b(r117);
            if (ColorUtils.e(r118) == false) goto L33;
            if (r119 == false) goto L33;
        L37:
            if (r102 == false) goto L39;
            r106.setStroke(r101.getDimensionPixelSize(R.dimen.space_kit_len_half), r101.getColor(R.color.line_border_component));
        L40:
            r112.f240168c.setOnClickListener(new com.bytedance.ee.bear.widgets.colorpicker.a(this, r113));
            return;
        L33:
            if (ColorUtils.g(r118) == false) goto L36;
            if (r119 == false) goto L37;
        L36:
            r102 = false;
        L39:
            r106.setStroke(0, null);
            goto L40
        L26:
            r116 = ColorUtils.h(r113);
            goto L27
        L22:
            Intrinsics.checkNotNull(r113);
            r115 = ColorUtils.h(r113);
            goto L23
        L18:
            r109 = R.color.bg_body;
            goto L19
        L45:
            return;
        L11:
            r113 = null;
            goto L13
        L44:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.common_color_picker_item, null);
            Intrinsics.checkNotNull(r102);
            return new ColorViewHolder(r102);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$ViewType;", "", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ViewType {
        public static final a Companion = null;
        public static final int GRID = 1;
        public static final int LIST = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f240170a = null;

            static {
                f240170a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f240170a;
        }
    }

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonColorPicker f240171a;

        public a(CommonColorPicker r100) {
            this.f240171a = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorPicker.c
        public final void a(String r100) {
            c r101 = this.f240171a.f240160c;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }
    }

    public static final class b {
    }

    public interface c {
        void a(String r100);
    }

    public final class d extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonColorPicker f240172a;

        public d(CommonColorPicker r100) {
            this.f240172a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            if (r102.getAdapter() != null) goto L5;
            return;
        L5:
            int r104 = this.f240172a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_44);
            int r105 = r102.getChildAdapterPosition(r101);
            int r106 = this.f240172a.f240162e;
            if (r106 != 0) goto L15;
            RecyclerView.Adapter r107 = r102.getAdapter();
            if (r107 == null) goto L10;
            int r108 = r107.getItemCount();
        L11:
            int r109 = (r102.getWidth() - (r104 * r108)) / (r108 - 1);
            if (r105 != 0) goto L14;
            r109 = 0;
        L14:
            r100.left = r109;
            r100.right = 0;
            return;
        L10:
            r108 = 0;
            goto L11
        L15:
            if (r106 != 1) goto L23;
            int r110 = ((r102.getWidth() - (r104 * 6)) / 6) / 2;
            r100.left = r110;
            r100.right = r110;
            if (r105 >= 6) goto L19;
            int r111 = 0;
        L20:
            r100.top = r111;
            r100.bottom = 0;
            return;
        L19:
            r111 = this.f240172a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_8);
            goto L20
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonColorPicker f240173a;

        public e(CommonColorPicker r100) {
            this.f240173a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = this.f240173a.f240158a;     // Catch: Throwable -> L13
            if (r100 == null) goto L7;
            boolean r101 = true;
            if (r100.isAttachedToWindow() != true) goto L7;
        L8:
            if (r101 == false) goto L16;
            RecyclerView r102 = this.f240173a.f240158a;     // Catch: Throwable -> L13
            if (r102 == null) goto L20;
            r102.invalidateItemDecorations();     // Catch: Throwable -> L13
            return;
        L20:
            return;
        L16:
            return;
        L7:
            r101 = false;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    static {
    }

    public CommonColorPicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonColorPicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final void setRVLayoutManager(RecyclerView r100) {
        if (this.f240162e != 0) goto L5;
        LinearLayoutManager r101 = new LinearLayoutManager(getContext());
        r101.setOrientation(0);
    L6:
        r100.setLayoutManager(r101);
        return;
    L5:
        r101 = new GridLayoutManager(getContext(), 6, 1, false);
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        int r101 = this.f240161d;
        int r102 = r100.orientation;
        if (r101 == r102) goto L6;
        this.f240161d = r102;
        j.c(new e(this));
        return;
    }

    public final void setOnSelectColorListener(c r100) {
        this.f240160c = r100;
    }

    public final void setViewType(int r100) {
        this.f240162e = r100;
        RecyclerView r101 = this.f240158a;
        if (r101 == null) goto L6;
        setRVLayoutManager(r101);
        return;
    }

    public CommonColorPicker(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.common_color_picker_view, this, true);
        if (r101 == null) goto L5;
        this.f240162e = r100.obtainStyledAttributes(r101, new int[]{R.attr.view_type}).getInteger(0, 0);
    L5:
        this.f240161d = r100.getResources().getConfiguration().orientation;
        RecyclerView r103 = (RecyclerView) findViewById(R.id.colors_recycler_view);
        Intrinsics.checkNotNull(r103);
        setRVLayoutManager(r103);
        SelectColorAdapter r104 = new SelectColorAdapter();
        r104.f240165c = new a(this);
        this.f240159b = r104;
        r103.setAdapter(r104);
        this.f240158a = r103;
    }

    public /* synthetic */ CommonColorPicker(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        RecyclerView r105 = this.f240158a;
        boolean r106 = false;
        if (r105 != null) goto L5;
    L7:
        if (r106 == false) goto L12;
        RecyclerView r107 = this.f240158a;
        if (r107 == null) goto L13;
        r107.addItemDecoration(new d(this));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r105.getItemDecorationCount() != 0) goto L7;
        r106 = true;
        goto L7
    }
}
