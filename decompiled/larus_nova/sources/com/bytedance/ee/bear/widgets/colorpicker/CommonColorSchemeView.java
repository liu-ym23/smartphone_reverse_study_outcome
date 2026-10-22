package com.bytedance.ee.bear.widgets.colorpicker;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ku5.c;

/* JADX INFO: loaded from: classes18.dex */
public class CommonColorSchemeView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonColorPicker f240174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f240175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectSpecificColorAdapter f240176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f240177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorScheme[] f240178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f240179f;

    public static class ColorScheme implements NonProguard {
        private String[] colorList;
        private String defaultColor;
        private String topicColor;

        public ColorScheme() {
        }

        public String[] getColorList() {
            return this.colorList;
        }

        public String getDefaultColor() {
            return this.defaultColor;
        }

        public String getTopicColor() {
            return this.topicColor;
        }

        public void setColorList(String[] r100) {
            this.colorList = r100;
        }

        public void setDefaultColor(String r100) {
            this.defaultColor = r100;
        }

        public void setTopicColor(String r100) {
            this.topicColor = r100;
        }

        public ColorScheme(String r100, String r101, String[] r102) {
            this.topicColor = r100;
            this.defaultColor = r101;
            this.colorList = r102;
        }
    }

    public static class SelectSpecificColorAdapter extends RecyclerView.Adapter<SpecificColorViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f240180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f240181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f240182c;

        public class SpecificColorViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f240183a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final View f240184b;

            public SpecificColorViewHolder(View r100) {
                super(r100);
                this.f240183a = r100.findViewById(R.id.outer_layer);
                this.f240184b = r100.findViewById(R.id.check_flag);
            }
        }

        public interface a {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            String[] r100 = this.f240180a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.length;
        }

        public SelectSpecificColorAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            SpecificColorViewHolder r102 = (SpecificColorViewHolder) r100;
            String r103 = this.f240180a[r101];
            if (TextUtils.isEmpty(r103) == true) goto L37;
            Context r104 = r102.itemView.getContext();
            Resources r105 = r104.getResources();
            if ((r104 instanceof Activity) == true) goto L8;
        L15:
            int r106 = n.v();
        L16:
            int r107 = (r106 - (r105.getDimensionPixelSize(R.dimen.space_kit_len_16) * 2)) / getItemCount();
            ViewGroup.LayoutParams r108 = r102.f240183a.getLayoutParams();
            if (r108 == null) goto L19;
            r108.width = r107;
            r102.f240183a.setLayoutParams(r108);
        L19:
            boolean r109 = r103.equalsIgnoreCase(this.f240181b);
            View r110 = r102.f240184b;
            int r111 = 0;
            if (r109 == false) goto L22;
            int r112 = 0;
        L23:
            r110.setVisibility(r112);
            if (r101 != 0) goto L27;
            r102.f240183a.setBackground(r105.getDrawable(R.drawable.common_specific_color_outer_left_layer));
        L30:
            GradientDrawable r113 = (GradientDrawable) r102.f240183a.getBackground().mutate();
            r113.setColor(ColorUtils.h(r103));
            if ("#ffffff".equalsIgnoreCase(r103) == false) goto L33;
        L34:
            r111 = r105.getDimensionPixelSize(R.dimen.space_kit_len_1);
        L35:
            r113.setStroke(r111, r105.getColor(R.color.lkui_N300));
            r102.f240183a.setOnClickListener(new b(this, r103));
            return;
        L33:
            if ("#ffffffff".equalsIgnoreCase(r103) == false) goto L35;
        L27:
            if (r101 != (getItemCount() - 1)) goto L29;
            r102.f240183a.setBackground(r105.getDrawable(R.drawable.common_specific_color_outer_right_layer));
            goto L30
        L29:
            r102.f240183a.setBackground(r105.getDrawable(R.drawable.common_specific_color_outer_middle_layer));
            goto L30
        L22:
            r112 = 8;
            goto L23
        L8:
            if (c.k(r104) == false) goto L15;
            View r114 = ((Activity) r104).getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r115 = ThreadMethodProxy.currentThread();
            if (r115 == com.larus.home.impl.utils.c.f346341a) goto L14;
            com.larus.home.impl.utils.c.a(r115, "getDecorView");
        L14:
            r106 = r114.getWidth();
            goto L16
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return new SpecificColorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.common_color_scheme_specific_item, null));
        }
    }

    public interface a {
        void G30(String r100);

        void Kr(String r100);
    }

    public CommonColorSchemeView(Context r100) {
        this(r100, null);
    }

    public void setDelegate(a r100) {
        this.f240177d = r100;
    }

    public void setSpecificColorPickerHeight(int r100) {
        ViewGroup.LayoutParams r101 = this.f240175b.getLayoutParams();
        r101.height = r100;
        this.f240175b.setLayoutParams(r101);
    }

    public void setTopicColorViewType(int r100) {
        this.f240174a.setViewType(r100);
    }

    public CommonColorSchemeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(ColorScheme[] r110, String r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.length == 0) goto L44;
        String[] r100 = new String[r110.length];
        int r101 = 0;
        String r102 = "";
        int r103 = 0;
        boolean r104 = false;
    L8:
        if (r103 >= r110.length) goto L26;
        r100[r103] = r110[r103].getTopicColor();
        if (TextUtils.isEmpty(r111) == true) goto L25;
        if (r110[r103].getColorList() == null) goto L25;
        if (r110[r103].getColorList().length == 0) goto L25;
        String[] r105 = r110[r103].getColorList();
        int r106 = r105.length;
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L25;
        if (r111.equalsIgnoreCase(r105[r107]) == false) goto L24;
        if (r100[r103].equalsIgnoreCase(this.f240179f) == false) goto L22;
    L23:
        r102 = r100[r103];
        SelectSpecificColorAdapter r108 = this.f240176c;
        r108.f240180a = r110[r103].getColorList();
        r108.f240181b = r111;
        r108.notifyDataSetChanged();
        r104 = true;
        goto L24
    L22:
        if (TextUtils.isEmpty(r102) == true) goto L23;
    L24:
        r107 = r107 + 1;
    L25:
        r103 = r103 + 1;
        goto L8
    L26:
        this.f240178e = r110;
        this.f240179f = r102;
        CommonColorPicker.SelectColorAdapter r112 = this.f240174a.f240159b;
        if (r112 == null) goto L29;
        r112.f240163a = r100;
        r112.f240164b = r102;
        r112.notifyDataSetChanged();
    L29:
        RecyclerView r113 = this.f240175b;
        if (r104 == true) goto L33;
        r101 = 8;
    L33:
        r113.setVisibility(r101);
        return;
    }

    public CommonColorSchemeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.common_color_scheme_view, this, true);
        CommonColorPicker r103 = (CommonColorPicker) findViewById(R.id.topic_color_picker);
        this.f240174a = r103;
        r103.setOnSelectColorListener(new dp5.a(this));
        RecyclerView r104 = (RecyclerView) findViewById(R.id.specific_colors_recycler_view);
        this.f240175b = r104;
        SelectSpecificColorAdapter r105 = new SelectSpecificColorAdapter();
        this.f240176c = r105;
        r105.f240182c = new dp5.b(this);
        r104.setAdapter(r105);
        LinearLayoutManager r106 = new LinearLayoutManager(getContext());
        r106.setOrientation(0);
        r104.setLayoutManager(r106);
    }
}
