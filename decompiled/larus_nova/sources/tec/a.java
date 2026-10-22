package tec;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.GridLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import com.ss.android.lark.widget.table.newrefactor.TableCellData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mcc.h;
import mcc.l;
import mcc.o;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f545660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f545661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f545662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f545663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f545664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o f545665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public mcc.b f545666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public mcc.g f545667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f545668l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnClickListener f545669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View.OnLongClickListener f545670n;

    /* JADX INFO: renamed from: tec.a$a, reason: collision with other inner class name */
    public static final class C7716a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f545671a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f545672b = null;

        static {
            int[] r100 = new int[VerticalAlign.values().length];
            r100[VerticalAlign.VERTICAL_ALIGN_TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r100[VerticalAlign.VERTICAL_ALIGN_CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[VerticalAlign.VERTICAL_ALIGN_BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f545671a = r100;
            int[] r101 = new int[HorizontalAlign.values().length];
            r101[HorizontalAlign.HORIZONTAL_ALIGN_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r101[HorizontalAlign.HORIZONTAL_ALIGN_CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[HorizontalAlign.HORIZONTAL_ALIGN_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f545672b = r101;
        }
    }

    static {
    }

    public final void b() {
        GridLayout r100 = this.f545680c;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L21;
        View r103 = r100.getChildAt(r102);
        if ((r103 instanceof LKUILightTextView) == false) goto L10;
        LKUILightTextView r104 = (LKUILightTextView) r103;
    L11:
        if (r104 == null) goto L20;
        r104.setOnClickListener(this.f545669m);
        r104.setOnLongClickListener(this.f545670n);
        if (this.f545669m == null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        r104.setConsumeNonSpanClicks$linked_emoji_release(r105);
        goto L20
    L15:
        if (this.f545670n != null) goto L18;
        r105 = false;
    L20:
        r102 = r102 + 1;
        goto L6
    L10:
        r104 = null;
        goto L11
    }

    @Override // tec.g
    public final void a(Context r110, List<TableCellData> r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<TableCellData> r100 = r111;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        Log.e("SimpleTableDataAdapter", "tableCellDatas is null or empty, stops addGridLayoutView.");
        return;
    L13:
        int r102 = r100.size();
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L61;
        TableCellData r104 = (TableCellData) ListProtector.get(r111, r103);
        Layout r105 = r104.getContentLayout();
        LKUILightTextView r112 = new LKUILightTextView(r110);
        GridLayout.LayoutParams r113 = new GridLayout.LayoutParams(GridLayout.spec(r104.getRowIndex(), r104.getRowSpanOccupied()), GridLayout.spec(r104.getColumnIndex(), r104.getColumnSpanOccupied()));
        r113.setGravity(119);
        r113.width = r104.getCellWidth() * r104.getColumnSpanOccupied();
        r113.height = -2;
        if (r104.getColumnIndex() != 0) goto L22;
        if (r104.isLastRow() == false) goto L20;
        int r114 = R.drawable.tv_border_first_column_last_row;
    L25:
        r112.setBackgroundResource(r114);
        r112.setPadding(this.f545660d, this.f545661e, this.f545662f, this.f545663g);
        VerticalAlign r115 = r104.getVerticalAlign();
        if (r115 != null) goto L28;
        int r116 = -1;
    L29:
        int r117 = 3;
        if (r116 == 1) goto L36;
        if (r116 == 2) goto L35;
        if (r116 != 3) goto L36;
        int r118 = 80;
    L37:
        Log.i("SimpleTableDataAdapter", "verticalGravity = " + r118);
        HorizontalAlign r106 = r104.getHorizontalAlign();
        if (r106 != null) goto L40;
        int r119 = -1;
    L41:
        if (r119 == 1) goto L47;
        if (r119 == 2) goto L46;
        if (r119 != 3) goto L47;
        r117 = 5;
        goto L47
    L46:
        r117 = 1;
    L47:
        Log.i("SimpleTableDataAdapter", "horizontalGravity = " + r117);
        r112.setGravity(r118 | r117);
        r112.setTag("SimpleTableDataAdapter_richTextView_" + r103);
        r112.setMinimumHeight(UIUtils.dp2px(r110, 40.0f));
        if (r105 == null) goto L50;
        r112.setContentLayout(r105);
    L50:
        r112.setPhoneSpanClickListener(new tec.b(this));
        r112.setUrlSpanClickListener(new c(this));
        r112.setAtSpanClickListener(new d(this));
        r112.setImageSpanClickListener(new e(this));
        r112.setMediaSpanClickListener(new f(this));
        r112.setOnClickListener(this.f545669m);
        r112.setOnLongClickListener(this.f545670n);
        if (this.f545669m == null) goto L53;
    L56:
        boolean r107 = true;
    L57:
        r112.setConsumeNonSpanClicks$linked_emoji_release(r107);
        GridLayout r108 = this.f545680c;
        if (r108 == null) goto L60;
        r108.addView(r112, r113);
    L60:
        r103 = r103 + 1;
        goto L14
    L53:
        if (this.f545670n != null) goto L56;
        r107 = false;
        goto L57
    L40:
        r119 = b.f545672b[r106.ordinal()];
        goto L41
    L35:
        r118 = 16;
    L36:
        r118 = 48;
        goto L37
    L28:
        r116 = b.f545671a[r115.ordinal()];
        goto L29
    L20:
        r114 = R.drawable.tv_border_first_column;
        goto L25
    L22:
        if (r104.isLastRow() == false) goto L24;
        r114 = R.drawable.tv_border_last_row;
        goto L25
    L24:
        r114 = R.drawable.tv_border;
        goto L25
    L61:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    public a(Context r100, List<TableCellData> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f545660d = UIUtils.dp2px(r100, 11.0f);
        this.f545661e = UIUtils.dp2px(r100, 11.0f);
        this.f545662f = UIUtils.dp2px(r100, 11.0f);
        this.f545663g = UIUtils.dp2px(r100, 11.0f);
    }
}
