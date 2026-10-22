package com.bytedance.ee.bear.sheet.borderline;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BorderLinePanelView extends LinearLayout {
    public final BorderStyleAdapter a;
    public final CommonColorSchemeView b;
    public BorderLineData c;
    public String d;
    public String e;
    public String f;
    public String g;
    public b h;

    public class a implements CommonColorSchemeView.a {
        public final /* synthetic */ BorderLinePanelView a;

        public a(BorderLinePanelView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
        public final void G30(String r4) {
            BorderLinePanelView r0 = this.a;
            r0.c(r0.f, r4, "color");
        }

        @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
        public final void Kr(String r4) {
            BorderLinePanelView r0 = this.a;
            r0.c(r0.f, SheetSelectColorData.findDefaultColor(r0.c.getBorderLineParam().getColor(), r4), "color");
        }
    }

    public interface b {
        void P30(String r1, String r2, String r3);
    }

    public final void a() {
        this.f = null;
        this.g = null;
        BorderLineData r1 = this.c;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getBorderLineParam() == null) goto L9;
        BorderStyleAdapter r2 = this.a;
        r2.a = this.c.getBorderLineParam().getBorder();
        r2.b = null;
        r2.notifyDataSetChanged();
        this.b.a(b(this.c.getBorderLineParam().getColor()), null);
        return;
    }

    public BorderLinePanelView(Context r2) {
        this(r2, null);
    }

    public static CommonColorSchemeView.ColorScheme[] b(SheetSelectColorData.ColorScheme[] r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        CommonColorSchemeView.ColorScheme[] r0 = new CommonColorSchemeView.ColorScheme[r6.length];
        int r1 = 0;
    L7:
        if (r1 >= r6.length) goto L9;
        r0[r1] = new CommonColorSchemeView.ColorScheme(r6[r1].getTopicColor(), r6[r1].getDefaultColor(), r6[r1].getColorList());
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public void setBorderLineData(BorderLineData r4) {
        this.c = r4;
        this.d = r4.getBorderLineParam().getDefaultValue().getBorder();
        this.e = r4.getBorderLineParam().getDefaultValue().getColor();
        BorderStyleAdapter r0 = this.a;
        String[] r1 = r4.getBorderLineParam().getBorder();
        String r2 = this.f;
        r0.a = r1;
        r0.b = r2;
        r0.notifyDataSetChanged();
        this.b.a(b(r4.getBorderLineParam().getColor()), this.g);
    }

    public void setDelegate(b r1) {
        this.h = r1;
    }

    public BorderLinePanelView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BorderLinePanelView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131564527, this, true);
        RecyclerView r6 = findViewById(2131364343);
        BorderStyleAdapter r7 = new BorderStyleAdapter();
        this.a = r7;
        r6.setAdapter(r7);
        r6.setLayoutManager(new GridLayoutManager(getContext(), 4));
        r6.addItemDecoration(new BorderStyleDecoration());
        r7.c = new e(this);
        CommonColorSchemeView r8 = (CommonColorSchemeView) findViewById(2131367181);
        this.b = r8;
        r8.setDelegate(new a(this));
    }

    public final void c(String r2, String r3, String r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        r2 = this.d;
    L5:
        this.f = r2;
        if (TextUtils.isEmpty(r3) == false) goto L8;
        r3 = this.e;
    L8:
        this.g = r3;
        BorderLineData r5 = this.c;
        if (r5 != null) goto L11;
    L13:
        b r6 = this.h;
        if (r6 == null) goto L17;
        r6.P30(this.f, this.g, r4);
        return;
    L17:
        return;
    L11:
        if (r5.getBorderLineParam() == null) goto L13;
        BorderStyleAdapter r7 = this.a;
        String[] r8 = this.c.getBorderLineParam().getBorder();
        String r0 = this.f;
        r7.a = r8;
        r7.b = r0;
        r7.notifyDataSetChanged();
        this.b.a(b(this.c.getBorderLineParam().getColor()), this.g);
        goto L13
    }
}
