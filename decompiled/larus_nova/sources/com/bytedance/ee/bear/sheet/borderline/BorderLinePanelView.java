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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class BorderLinePanelView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BorderStyleAdapter f237368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonColorSchemeView f237369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BorderLineData f237370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f237371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f237372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f237373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f237374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f237375h;

    public class a implements CommonColorSchemeView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BorderLinePanelView f237376a;

        public a(BorderLinePanelView r100) {
            this.f237376a = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
        public final void G30(String r100) {
            BorderLinePanelView r101 = this.f237376a;
            r101.c(r101.f237373f, r100, "color");
        }

        @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
        public final void Kr(String r100) {
            BorderLinePanelView r101 = this.f237376a;
            r101.c(r101.f237373f, SheetSelectColorData.findDefaultColor(r101.f237370c.getBorderLineParam().getColor(), r100), "color");
        }
    }

    public interface b {
        void P30(String r100, String r101, String r102);
    }

    public final void a() {
        this.f237373f = null;
        this.f237374g = null;
        BorderLineData r100 = this.f237370c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getBorderLineParam() == null) goto L9;
        BorderStyleAdapter r101 = this.f237368a;
        r101.f237378a = this.f237370c.getBorderLineParam().getBorder();
        r101.f237379b = null;
        r101.notifyDataSetChanged();
        this.f237369b.a(b(this.f237370c.getBorderLineParam().getColor()), null);
        return;
    }

    public BorderLinePanelView(Context r100) {
        this(r100, null);
    }

    public static CommonColorSchemeView.ColorScheme[] b(SheetSelectColorData.ColorScheme[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        CommonColorSchemeView.ColorScheme[] r101 = new CommonColorSchemeView.ColorScheme[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = new CommonColorSchemeView.ColorScheme(r100[r102].getTopicColor(), r100[r102].getDefaultColor(), r100[r102].getColorList());
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public void setBorderLineData(BorderLineData r100) {
        this.f237370c = r100;
        this.f237371d = r100.getBorderLineParam().getDefaultValue().getBorder();
        this.f237372e = r100.getBorderLineParam().getDefaultValue().getColor();
        BorderStyleAdapter r101 = this.f237368a;
        String[] r102 = r100.getBorderLineParam().getBorder();
        String r103 = this.f237373f;
        r101.f237378a = r102;
        r101.f237379b = r103;
        r101.notifyDataSetChanged();
        this.f237369b.a(b(r100.getBorderLineParam().getColor()), this.f237374g);
    }

    public void setDelegate(b r100) {
        this.f237375h = r100;
    }

    public BorderLinePanelView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public BorderLinePanelView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.sheet_border_line_panel_view, this, true);
        RecyclerView r103 = (RecyclerView) findViewById(R.id.border_recycler_view);
        BorderStyleAdapter r104 = new BorderStyleAdapter();
        this.f237368a = r104;
        r103.setAdapter(r104);
        r103.setLayoutManager(new GridLayoutManager(getContext(), 4));
        r103.addItemDecoration(new BorderStyleDecoration());
        r104.f237380c = new e(this);
        CommonColorSchemeView r105 = (CommonColorSchemeView) findViewById(R.id.color_scheme_view);
        this.f237369b = r105;
        r105.setDelegate(new a(this));
    }

    public final void c(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = this.f237371d;
    L5:
        this.f237373f = r100;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        r101 = this.f237372e;
    L8:
        this.f237374g = r101;
        BorderLineData r103 = this.f237370c;
        if (r103 != null) goto L11;
    L13:
        b r104 = this.f237375h;
        if (r104 == null) goto L17;
        r104.P30(this.f237373f, this.f237374g, r102);
        return;
    L17:
        return;
    L11:
        if (r103.getBorderLineParam() == null) goto L13;
        BorderStyleAdapter r105 = this.f237368a;
        String[] r106 = this.f237370c.getBorderLineParam().getBorder();
        String r107 = this.f237373f;
        r105.f237378a = r106;
        r105.f237379b = r107;
        r105.notifyDataSetChanged();
        this.f237369b.a(b(this.f237370c.getBorderLineParam().getColor()), this.f237374g);
        goto L13
    }
}
