package ecc;

import android.content.Context;
import android.text.Layout;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.columns.entity.ColumnsCellData;
import com.ss.android.lark.widget.light.LKUILightTextView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mcc.l;
import mcc.o;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends ecc.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f472169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f472170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public mcc.b f472171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public mcc.g f472172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mcc.h f472173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public mcc.e f472174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public mcc.a f472175j;

    public static final class a {
    }

    static {
    }

    public b(Context r100, List<ColumnsCellData> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // ecc.a
    public final void a(Context r110, List<ColumnsCellData> r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<ColumnsCellData> r100 = r111;
        int r101 = 1;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        Log.e("SimpleColumnsDataAdapter", "columnsCellDatas is null or empty, stops add addLinearLayoutView.");
        return;
    L13:
        int r103 = r100.size();
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L46;
        ColumnsCellData r105 = (ColumnsCellData) ListProtector.get(r111, r104);
        Layout r112 = r105.getContentLayout();
        int r106 = r105.getCellWidth();
        LKUILightTextView r113 = new LKUILightTextView(r110);
        ViewGroup.LayoutParams r114 = new ViewGroup.LayoutParams(-2, -2);
        Log.i("SimpleColumnsDataAdapter", "cellWidth = " + r106);
        r114.width = r106;
        LinearLayout r115 = this.f472168c;
        if (r115 != null) goto L18;
    L20:
        boolean r116 = false;
    L22:
        if (r116 == false) goto L31;
        if (r104 != 0) goto L25;
        int r117 = UIUtils.dp2px(r110, 12.0f);
    L27:
        if (r104 != CollectionsKt.getIndices(r100).getLast()) goto L29;
        int r118 = 0;
    L30:
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(r106, -2);
        r119.setMargins(0, r117, 0, r118);
        r113.setLayoutParams(r119);
    L40:
        if (r112 == null) goto L42;
        r113.setContentLayout(r112);
    L42:
        r113.setPhoneSpanClickListener(new c(this));
        r113.setUrlSpanClickListener(new d(this));
        r113.setAtSpanClickListener(new e(this));
        r113.setImageSpanClickListener(new f(this));
        r113.setMediaSpanClickListener(new g(this));
        r113.setCodeBlockV2SpanCLickListener(new h(this));
        r113.setAbbreviationClickListener(new i(this));
        LinearLayout r107 = this.f472168c;
        if (r107 == null) goto L45;
        r107.addView(r113);
    L45:
        r104 = r104 + 1;
        r101 = 1;
        goto L14
    L29:
        r118 = UIUtils.dp2px(r110, 3.0f);
        goto L30
    L25:
        r117 = UIUtils.dp2px(r110, 3.0f);
        goto L27
    L31:
        int r120 = UIUtils.dp2px(r110, 12.0f);
        if (r104 != 0) goto L34;
        int r121 = 0;
    L36:
        if (r104 != CollectionsKt.getIndices(r100).getLast()) goto L38;
        int r108 = 0;
    L39:
        LinearLayout.LayoutParams r122 = new LinearLayout.LayoutParams(r106, -2);
        r122.setMargins(r121, r120, r108, 0);
        r113.setLayoutParams(r122);
        goto L40
    L38:
        r108 = UIUtils.dp2px(r110, 3.0f);
        goto L39
    L34:
        r121 = UIUtils.dp2px(r110, 3.0f);
        goto L36
    L18:
        if (r115.getOrientation() != r101) goto L20;
        r116 = true;
        goto L22
    L46:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }
}
