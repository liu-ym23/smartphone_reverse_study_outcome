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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0005)*+,-B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J0\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0007J%\u0010!\u001a\u00020\u00132\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mColorsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mSelectColorAdapter", "Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$SelectColorAdapter;", "mOnSelectColorListener", "Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$OnSelectColorListener;", "oldOrientation", "mViewType", "setRVLayoutManager", "", "recyclerView", "onLayout", "changed", "", "left", "top", "right", "bottom", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setViewType", ResourceData.KEY_TYPE, "setColorData", "colorList", "", "", "selectedColor", "([Ljava/lang/String;Ljava/lang/String;)V", "setOnSelectColorListener", "listener", "SelectColorAdapter", "SelectColorDecoration", "ViewType", "Companion", "OnSelectColorListener", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonColorPicker extends FrameLayout {
    public final RecyclerView a;
    public final SelectColorAdapter b;
    public c c;
    public int d;
    public int e;

    public static final class SelectColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {
        public String[] a;
        public String b;
        public c c;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$SelectColorAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/widgets/colorpicker/CommonColorPicker$SelectColorAdapter;Landroid/view/View;)V", "outerLayer", "getOuterLayer", "()Landroid/view/View;", "setOuterLayer", "(Landroid/view/View;)V", "centerLayer", "getCenterLayer", "setCenterLayer", "innerLayer", "getInnerLayer", "setInnerLayer", "isSelected", "", "()Z", "setSelected", "(Z)V", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ColorViewHolder extends RecyclerView.ViewHolder {
            public final View a;
            public final View b;
            public final View c;
            public boolean d;

            public ColorViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
                this.a = r2.findViewById(2131381755);
                this.b = r2.findViewById(2131365418);
                this.c = r2.findViewById(2131375313);
            }
        }

        public final int getItemCount() {
            String[] r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.length;
        }

        public SelectColorAdapter() {
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
            ColorViewHolder r12 = (ColorViewHolder) r10;
            Intrinsics.checkNotNullParameter(r12, "holder");
            if (this.a == null) goto L42;
            if (r11 >= 0) goto L6;
            return;
        L6:
            if (r11 >= getItemCount()) goto L44;
            String[] r0 = this.a;
            if (r0 == null) goto L11;
            String r13 = r0[r11];
        L13:
            if (TextUtils.isEmpty(r13) == true) goto L45;
            Resources r1 = ((RecyclerView.ViewHolder) r12).itemView.getContext().getResources();
            boolean r3 = true;
            r12.d = StringsKt.equals(r13, this.b, true);
            Drawable r2 = r12.a.getBackground().mutate();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable r4 = (GradientDrawable) r2;
            Drawable r5 = r12.b.getBackground().mutate();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable r6 = (GradientDrawable) r5;
            Drawable r7 = r12.c.getBackground().mutate();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable r8 = (GradientDrawable) r7;
            if (r12.d == false) goto L18;
            int r9 = 2131105548;
        L19:
            r4.setColor(r1.getColor(r9));
            int r14 = r1.getDimensionPixelSize(2131168326);
            if (r12.d == false) goto L22;
            int r15 = r1.getColor(2131100548);
        L23:
            r8.setStroke(r14, r15);
            Intrinsics.checkNotNull(r13);
            r8.setColor(ColorUtils.h(r13));
            if (r12.d == false) goto L26;
            int r16 = r1.getColor(2131105548);
        L27:
            r6.setColor(r16);
            if (r12.d == true) goto L39;
            Context r17 = ((RecyclerView.ViewHolder) r12).itemView.getContext();
            int r18 = ColorUtils.h(r13);
            boolean r19 = ColorUtils.b(r17);
            if (ColorUtils.e(r18) == false) goto L33;
            if (r19 == false) goto L33;
        L37:
            if (r3 == false) goto L39;
            r6.setStroke(r1.getDimensionPixelSize(2131168377), r1.getColor(2131103352));
        L40:
            r12.c.setOnClickListener(new com.bytedance.ee.bear.widgets.colorpicker.a(this, r13));
            return;
        L33:
            if (ColorUtils.g(r18) == false) goto L36;
            if (r19 == false) goto L37;
        L36:
            r3 = false;
        L39:
            r6.setStroke(0, null);
            goto L40
        L26:
            r16 = ColorUtils.h(r13);
            goto L27
        L22:
            Intrinsics.checkNotNull(r13);
            r15 = ColorUtils.h(r13);
            goto L23
        L18:
            r9 = 2131100548;
            goto L19
        L45:
            return;
        L11:
            r13 = null;
            goto L13
        L44:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            View r4 = LayoutInflater.from(r2.getContext()).inflate(2131559878, null);
            Intrinsics.checkNotNull(r4);
            return new ColorViewHolder(r4);
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
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a implements c {
        public final /* synthetic */ CommonColorPicker a;

        public a(CommonColorPicker r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorPicker.c
        public final void a(String r2) {
            c r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }
    }

    public static final class b {
    }

    public interface c {
        void a(String r1);
    }

    public final class d extends RecyclerView.ItemDecoration {
        public final /* synthetic */ CommonColorPicker a;

        public d(CommonColorPicker r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
            Intrinsics.checkNotNullParameter(r4, "outRect");
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "parent");
            Intrinsics.checkNotNullParameter(r7, "state");
            if (r6.getAdapter() != null) goto L5;
            return;
        L5:
            int r8 = this.a.getResources().getDimensionPixelSize(2131168345);
            int r9 = r6.getChildAdapterPosition(r5);
            int r0 = this.a.e;
            if (r0 != 0) goto L15;
            RecyclerView.Adapter r1 = r6.getAdapter();
            if (r1 == null) goto L10;
            int r2 = r1.getItemCount();
        L11:
            int r10 = (r6.getWidth() - (r8 * r2)) / (r2 - 1);
            if (r9 != 0) goto L14;
            r10 = 0;
        L14:
            r4.left = r10;
            r4.right = 0;
            return;
        L10:
            r2 = 0;
            goto L11
        L15:
            if (r0 != 1) goto L23;
            int r11 = ((r6.getWidth() - (r8 * 6)) / 6) / 2;
            r4.left = r11;
            r4.right = r11;
            if (r9 >= 6) goto L19;
            int r12 = 0;
        L20:
            r4.top = r12;
            r4.bottom = 0;
            return;
        L19:
            r12 = this.a.getResources().getDimensionPixelSize(2131168369);
            goto L20
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ CommonColorPicker a;

        public e(CommonColorPicker r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r0 = this.a.a;     // Catch: Throwable -> L13
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isAttachedToWindow() != true) goto L7;
        L8:
            if (r1 == false) goto L16;
            RecyclerView r2 = this.a.a;     // Catch: Throwable -> L13
            if (r2 == null) goto L20;
            r2.invalidateItemDecorations();     // Catch: Throwable -> L13
            return;
        L20:
            return;
        L16:
            return;
        L7:
            r1 = false;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    static {
    }

    public CommonColorPicker(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonColorPicker(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final void setRVLayoutManager(RecyclerView r6) {
        if (this.e != 0) goto L5;
        LinearLayoutManager r0 = new LinearLayoutManager(getContext());
        r0.setOrientation(0);
    L6:
        r6.setLayoutManager(r0);
        return;
    L5:
        r0 = new GridLayoutManager(getContext(), 6, 1, false);
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        int r0 = this.d;
        int r3 = r2.orientation;
        if (r0 == r3) goto L6;
        this.d = r3;
        j.c(new e(this));
        return;
    }

    public final void setOnSelectColorListener(c r1) {
        this.c = r1;
    }

    public final void setViewType(int r1) {
        this.e = r1;
        RecyclerView r2 = this.a;
        if (r2 == null) goto L6;
        setRVLayoutManager(r2);
        return;
    }

    public CommonColorPicker(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131559879, this, true);
        if (r4 == null) goto L5;
        this.e = r3.obtainStyledAttributes(r4, new int[]{2130975044}).getInteger(0, 0);
    L5:
        this.d = r3.getResources().getConfiguration().orientation;
        RecyclerView r6 = (RecyclerView) findViewById(2131367184);
        Intrinsics.checkNotNull(r6);
        setRVLayoutManager(r6);
        SelectColorAdapter r7 = new SelectColorAdapter();
        r7.c = new a(this);
        this.b = r7;
        r6.setAdapter(r7);
        this.a = r6;
    }

    public /* synthetic */ CommonColorPicker(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        RecyclerView r6 = this.a;
        boolean r7 = false;
        if (r6 != null) goto L5;
    L7:
        if (r7 == false) goto L12;
        RecyclerView r8 = this.a;
        if (r8 == null) goto L13;
        r8.addItemDecoration(new d(this));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r6.getItemDecorationCount() != 0) goto L7;
        r7 = true;
        goto L7
    }
}
