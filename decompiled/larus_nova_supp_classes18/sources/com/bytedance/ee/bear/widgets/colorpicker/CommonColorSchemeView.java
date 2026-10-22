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
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommonColorSchemeView extends LinearLayout {
    public final CommonColorPicker a;
    public final RecyclerView b;
    public final SelectSpecificColorAdapter c;
    public a d;
    public ColorScheme[] e;
    public String f;

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

        public void setColorList(String[] r1) {
            this.colorList = r1;
        }

        public void setDefaultColor(String r1) {
            this.defaultColor = r1;
        }

        public void setTopicColor(String r1) {
            this.topicColor = r1;
        }

        public ColorScheme(String r1, String r2, String[] r3) {
            this.topicColor = r1;
            this.defaultColor = r2;
            this.colorList = r3;
        }
    }

    public static class SelectSpecificColorAdapter extends RecyclerView.Adapter<SpecificColorViewHolder> {
        public String[] a;
        public String b;
        public a c;

        public class SpecificColorViewHolder extends RecyclerView.ViewHolder {
            public final View a;
            public final View b;

            public SpecificColorViewHolder(View r2) {
                super(r2);
                this.a = r2.findViewById(2131381755);
                this.b = r2.findViewById(2131365633);
            }
        }

        public interface a {
        }

        public final int getItemCount() {
            String[] r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.length;
        }

        public SelectSpecificColorAdapter() {
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
            SpecificColorViewHolder r9 = (SpecificColorViewHolder) r7;
            String r0 = this.a[r8];
            if (TextUtils.isEmpty(r0) == true) goto L37;
            Context r1 = ((RecyclerView.ViewHolder) r9).itemView.getContext();
            Resources r2 = r1.getResources();
            if ((r1 instanceof Activity) == true) goto L8;
        L15:
            int r3 = n.v();
        L16:
            int r4 = (r3 - (r2.getDimensionPixelSize(2131168315) * 2)) / getItemCount();
            ViewGroup.LayoutParams r5 = r9.a.getLayoutParams();
            if (r5 == null) goto L19;
            r5.width = r4;
            r9.a.setLayoutParams(r5);
        L19:
            boolean r6 = r0.equalsIgnoreCase(this.b);
            View r10 = r9.b;
            int r11 = 0;
            if (r6 == false) goto L22;
            int r12 = 0;
        L23:
            r10.setVisibility(r12);
            if (r8 != 0) goto L27;
            r9.a.setBackground(r2.getDrawable(2131233615));
        L30:
            GradientDrawable r13 = (GradientDrawable) r9.a.getBackground().mutate();
            r13.setColor(ColorUtils.h(r0));
            if ("#ffffff".equalsIgnoreCase(r0) == false) goto L33;
        L34:
            r11 = r2.getDimensionPixelSize(2131168297);
        L35:
            r13.setStroke(r11, r2.getColor(2131103453));
            r9.a.setOnClickListener(new b(this, r0));
            return;
        L33:
            if ("#ffffffff".equalsIgnoreCase(r0) == false) goto L35;
        L27:
            if (r8 != (getItemCount() - 1)) goto L29;
            r9.a.setBackground(r2.getDrawable(2131233617));
            goto L30
        L29:
            r9.a.setBackground(r2.getDrawable(2131233616));
            goto L30
        L22:
            r12 = 8;
            goto L23
        L8:
            if (c.k(r1) == false) goto L15;
            View r14 = ((Activity) r1).getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L14;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r15 = ThreadMethodProxy.currentThread();
            if (r15 == com.larus.home.impl.utils.c.a) goto L14;
            com.larus.home.impl.utils.c.a(r15, "getDecorView");
        L14:
            r3 = r14.getWidth();
            goto L16
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            return new SpecificColorViewHolder(LayoutInflater.from(r2.getContext()).inflate(2131559880, null));
        }
    }

    public interface a {
        void G30(String r1);

        void Kr(String r1);
    }

    public CommonColorSchemeView(Context r2) {
        this(r2, null);
    }

    public void setDelegate(a r1) {
        this.d = r1;
    }

    public void setSpecificColorPickerHeight(int r2) {
        ViewGroup.LayoutParams r0 = this.b.getLayoutParams();
        r0.height = r2;
        this.b.setLayoutParams(r0);
    }

    public void setTopicColorViewType(int r2) {
        this.a.setViewType(r2);
    }

    public CommonColorSchemeView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(ColorScheme[] r11, String r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.length == 0) goto L44;
        String[] r0 = new String[r11.length];
        int r1 = 0;
        String r2 = "";
        int r3 = 0;
        boolean r4 = false;
    L8:
        if (r3 >= r11.length) goto L26;
        r0[r3] = r11[r3].getTopicColor();
        if (TextUtils.isEmpty(r12) == true) goto L25;
        if (r11[r3].getColorList() == null) goto L25;
        if (r11[r3].getColorList().length == 0) goto L25;
        String[] r5 = r11[r3].getColorList();
        int r6 = r5.length;
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L25;
        if (r12.equalsIgnoreCase(r5[r7]) == false) goto L24;
        if (r0[r3].equalsIgnoreCase(this.f) == false) goto L22;
    L23:
        r2 = r0[r3];
        SelectSpecificColorAdapter r8 = this.c;
        r8.a = r11[r3].getColorList();
        r8.b = r12;
        r8.notifyDataSetChanged();
        r4 = true;
        goto L24
    L22:
        if (TextUtils.isEmpty(r2) == true) goto L23;
    L24:
        r7 = r7 + 1;
    L25:
        r3 = r3 + 1;
        goto L8
    L26:
        this.e = r11;
        this.f = r2;
        CommonColorPicker.SelectColorAdapter r13 = this.a.b;
        if (r13 == null) goto L29;
        r13.a = r0;
        r13.b = r2;
        r13.notifyDataSetChanged();
    L29:
        RecyclerView r14 = this.b;
        if (r4 == true) goto L33;
        r1 = 8;
    L33:
        r14.setVisibility(r1);
        return;
    }

    public CommonColorSchemeView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(2131559881, this, true);
        CommonColorPicker r4 = (CommonColorPicker) findViewById(2131389248);
        this.a = r4;
        r4.setOnSelectColorListener(new dp5.a(this));
        RecyclerView r5 = findViewById(2131387081);
        this.b = r5;
        SelectSpecificColorAdapter r6 = new SelectSpecificColorAdapter();
        this.c = r6;
        r6.c = new dp5.b(this);
        r5.setAdapter(r6);
        LinearLayoutManager r7 = new LinearLayoutManager(getContext());
        r7.setOrientation(0);
        r5.setLayoutManager(r7);
    }
}
