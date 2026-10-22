package com.ss.android.photoeditor.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.photoeditor.util.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class ColorChoiceView extends LinearLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f449149m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f449150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f449151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f449152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f449153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f449154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f449155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f449156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<TextView, Integer> f449157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<ChoiceColor, TextView> f449158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<TextView, ChoiceColor> f449159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f449160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f449161l;

    public static final enum ChoiceColor extends Enum<ChoiceColor> {
        public static final ChoiceColor BLACK = null;
        public static final ChoiceColor BLUE = null;
        public static final ChoiceColor GREEN = null;
        public static final ChoiceColor PINK = null;
        public static final ChoiceColor RED = null;
        public static final ChoiceColor WHITE = null;
        public static final ChoiceColor YELLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChoiceColor[] f449162a = null;
        public final int ID;

        static {
            ChoiceColor r100 = new ChoiceColor("RED", 0, 1);
            RED = r100;
            ChoiceColor r101 = new ChoiceColor("WHITE", 1, 2);
            WHITE = r101;
            ChoiceColor r102 = new ChoiceColor("BLACK", 2, 3);
            BLACK = r102;
            ChoiceColor r103 = new ChoiceColor("GREEN", 3, 4);
            GREEN = r103;
            ChoiceColor r104 = new ChoiceColor("YELLOW", 4, 5);
            YELLOW = r104;
            ChoiceColor r110 = new ChoiceColor("BLUE", 5, 6);
            BLUE = r110;
            ChoiceColor r111 = new ChoiceColor("PINK", 6, 7);
            PINK = r111;
            f449162a = new ChoiceColor[]{r100, r101, r102, r103, r104, r110, r111};
        }

        public static ChoiceColor[] values() {
            return (ChoiceColor[]) f449162a.clone();
        }

        public static ChoiceColor valueOf(String r100) {
            return (ChoiceColor) r27.a.a(ChoiceColor.class, r100);
        }

        public ChoiceColor(String r100, int r101, int r102) {
            super(r100, r101);
            this.ID = r102;
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ColorChoiceView f449163a;

        public a(ColorChoiceView r100) {
            this.f449163a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = ColorChoiceView.f449149m;
            this.f449163a.c((TextView) r100);
        }
    }

    public interface b {
        void a(int r100, ChoiceColor r101);
    }

    public final void b() {
        LinearLayout.inflate(getContext(), R.layout.view_color_selector, this);
        this.f449158i = new HashMap();
        this.f449159j = new HashMap();
        this.f449150a = (TextView) findViewById(R.id.tv_paint_color_white);
        this.f449151b = (TextView) findViewById(R.id.tv_paint_color_black);
        this.f449152c = (TextView) findViewById(R.id.tv_paint_color_blue);
        this.f449153d = (TextView) findViewById(R.id.tv_paint_color_green);
        this.f449154e = (TextView) findViewById(R.id.tv_paint_color_yellow);
        this.f449155f = (TextView) findViewById(R.id.tv_paint_color_red);
        this.f449156g = (TextView) findViewById(R.id.tv_paint_color_pink);
        Map<ChoiceColor, TextView> r100 = this.f449158i;
        ChoiceColor r101 = ChoiceColor.WHITE;
        HashMap r102 = (HashMap) r100;
        r102.put(r101, this.f449150a);
        Map<ChoiceColor, TextView> r103 = this.f449158i;
        ChoiceColor r104 = ChoiceColor.BLACK;
        HashMap r105 = (HashMap) r103;
        r105.put(r104, this.f449151b);
        Map<ChoiceColor, TextView> r106 = this.f449158i;
        ChoiceColor r107 = ChoiceColor.BLUE;
        HashMap r108 = (HashMap) r106;
        r108.put(r107, this.f449152c);
        Map<ChoiceColor, TextView> r109 = this.f449158i;
        ChoiceColor r110 = ChoiceColor.GREEN;
        HashMap r111 = (HashMap) r109;
        r111.put(r110, this.f449153d);
        Map<ChoiceColor, TextView> r112 = this.f449158i;
        ChoiceColor r113 = ChoiceColor.YELLOW;
        HashMap r114 = (HashMap) r112;
        r114.put(r113, this.f449154e);
        Map<ChoiceColor, TextView> r115 = this.f449158i;
        ChoiceColor r116 = ChoiceColor.RED;
        HashMap r117 = (HashMap) r115;
        r117.put(r116, this.f449155f);
        Map<ChoiceColor, TextView> r118 = this.f449158i;
        ChoiceColor r119 = ChoiceColor.PINK;
        HashMap r120 = (HashMap) r118;
        r120.put(r119, this.f449156g);
        Map<TextView, ChoiceColor> r121 = this.f449159j;
        HashMap r122 = (HashMap) r121;
        r122.put(this.f449150a, r101);
        Map<TextView, ChoiceColor> r123 = this.f449159j;
        HashMap r124 = (HashMap) r123;
        r124.put(this.f449151b, r104);
        Map<TextView, ChoiceColor> r125 = this.f449159j;
        HashMap r126 = (HashMap) r125;
        r126.put(this.f449152c, r107);
        Map<TextView, ChoiceColor> r127 = this.f449159j;
        HashMap r128 = (HashMap) r127;
        r128.put(this.f449153d, r110);
        Map<TextView, ChoiceColor> r129 = this.f449159j;
        HashMap r130 = (HashMap) r129;
        r130.put(this.f449154e, r113);
        Map<TextView, ChoiceColor> r131 = this.f449159j;
        HashMap r132 = (HashMap) r131;
        r132.put(this.f449155f, r116);
        Map<TextView, ChoiceColor> r133 = this.f449159j;
        HashMap r134 = (HashMap) r133;
        r134.put(this.f449156g, r119);
        this.f449150a.setOnClickListener(this.f449161l);
        this.f449151b.setOnClickListener(this.f449161l);
        this.f449152c.setOnClickListener(this.f449161l);
        this.f449153d.setOnClickListener(this.f449161l);
        this.f449154e.setOnClickListener(this.f449161l);
        this.f449155f.setOnClickListener(this.f449161l);
        this.f449156g.setOnClickListener(this.f449161l);
        HashMap r135 = new HashMap();
        this.f449157h = r135;
        r135.put(this.f449150a, Integer.valueOf(j08.b.b(getResources().getColor(R.color.lkui_N00), 1.0f)));
        Map<TextView, Integer> r136 = this.f449157h;
        HashMap r137 = (HashMap) r136;
        r137.put(this.f449151b, Integer.valueOf(j08.b.b(getResources().getColor(R.color.lkui_N900), 1.0f)));
        Map<TextView, Integer> r138 = this.f449157h;
        HashMap r139 = (HashMap) r138;
        r139.put(this.f449152c, Integer.valueOf(j08.b.b(getResources().getColor(R.color.lkui_W500), 1.0f)));
        Map<TextView, Integer> r140 = this.f449157h;
        HashMap r141 = (HashMap) r140;
        r141.put(this.f449153d, Integer.valueOf(j08.b.b(getResources().getColor(R.color.lkui_T500), 1.0f)));
        Map<TextView, Integer> r142 = this.f449157h;
        HashMap r143 = (HashMap) r142;
        r143.put(this.f449154e, Integer.valueOf(j08.b.b(getResources().getColor(R.color.lkui_Y500), 1.0f)));
        Map<TextView, Integer> r144 = this.f449157h;
        HashMap r145 = (HashMap) r144;
        r145.put(this.f449155f, Integer.valueOf(j08.b.b(getResources().getColor(R.color.lkui_R500), 1.0f)));
        Map<TextView, Integer> r146 = this.f449157h;
        HashMap r147 = (HashMap) r146;
        r147.put(this.f449156g, Integer.valueOf(j08.b.b(getResources().getColor(R.color.lkui_C500), 1.0f)));
    }

    public ColorChoiceView(Context r100) {
        super(r100);
        this.f449161l = new a(this);
        b();
    }

    public final void a(int r100) {
        Iterator r101 = ((HashMap) this.f449157h).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        TextView r102 = (TextView) r101.next();
        if (((Integer) ((HashMap) this.f449157h).get(r102)).intValue() != r100) goto L4;
        c(r102);
        return;
    }

    public final void c(TextView r100) {
        int r101 = ((Integer) ((HashMap) this.f449157h).get(r100)).intValue();
        int r102 = d.b(22);
        int r103 = d.b(18);
        Iterator r104 = ((HashMap) this.f449157h).keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        TextView r105 = (TextView) r104.next();
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.width = r103;
        r106.height = r103;
        r105.setLayoutParams(r106);
        r105.setSelected(false);
        goto L4
    L6:
        ViewGroup.LayoutParams r107 = r100.getLayoutParams();
        r107.width = r102;
        r107.height = r102;
        r100.setLayoutParams(r107);
        r100.setSelected(true);
        b r108 = this.f449160k;
        if (r108 == null) goto L11;
        r108.a(r101, (ChoiceColor) ((HashMap) this.f449159j).get(r100));
        return;
    }

    public void setOnColorChangedListener(b r100) {
        this.f449160k = r100;
    }

    public ColorChoiceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449161l = new a(this);
        b();
    }

    public ColorChoiceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449161l = new a(this);
        b();
    }
}
