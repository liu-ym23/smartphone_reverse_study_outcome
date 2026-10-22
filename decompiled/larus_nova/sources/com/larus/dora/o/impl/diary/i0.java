package com.larus.dora.o.impl.diary;

import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.chip.OChip;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
public final class i0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final List<String> f338539o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List<String> f338540p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f338541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f338542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f338543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f338544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f338545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l0 f338546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<String, Boolean, Unit> f338547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Integer, Unit> f338548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OSheet f338549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet<String> f338550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EditText f338551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OChipGroup f338552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f338553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f338554n;

    public static final class a {
    }

    static {
        f338539o = CollectionsKt.listOf(new String[]{"文笔流畅", "文笔优美", "逻辑清晰", "详略得当"});
        f338540p = CollectionsKt.listOf(new String[]{"文笔粗糙", "语句不通", "逻辑不清", "详略不当"});
    }

    public final int a(int r100) {
        Resources r101 = this.f338541a.getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100) + 0.5f);
    }

    public final void c(List<String> r100) {
        OChipGroup r101 = this.f338552l;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeAllViews();
        List<String> r102 = r100;
        this.f338550j.retainAll(CollectionsKt.toSet(r102));
        LayoutInflater r103 = LayoutInflater.from(this.f338541a);
        Iterator<T> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L12;
        final String r105 = (String) r104.next();
        View r106 = r103.inflate(R.layout.larus_dora_o_chip_feedback_reason, r101, false);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.obric.oui.chip.OChip");
        OChip r107 = (OChip) r106;
        r107.setText(r105);
        r107.setOnCheckedListener(new f0(this, r105));
        b(r107, false);
        if (this.f338550j.contains(r105) == false) goto L11;
        r107.performClick();
    L11:
        r101.addView(r107);
        goto L7
    }

    public final void d(int r100) {
        TextView r101 = this.f338553m;
        if (r101 == null) goto L6;
        r101.setText(this.f338541a.getString(R.string.dora_o_diary_feedback_input_count, new Object[]{Integer.valueOf(r100), 100}));
        return;
    }

    public final void b(OChip r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = R.color.oui_functional_blue_6;
    L5:
        if (r101 == false) goto L7;
        int r103 = R.color.oui_on_accent_default;
    L8:
        r100.setBackgroundColor(ContextCompat.getColor(this.f338541a, r102));
        r100.getTextView().setTextColor(ContextCompat.getColor(this.f338541a, r103));
        return;
    L7:
        r103 = R.color.oui_basic_text_1;
        goto L8
    L4:
        r102 = R.color.oui_basic_fill_element_2;
        goto L5
    }

    public i0(Context r110, LifecycleCoroutineScope r111, String r112, int r210, int r211, l0 r212, d r213, e r214) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "scope");
        Intrinsics.checkNotNullParameter(r112, "diaryId");
        Intrinsics.checkNotNullParameter(r212, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r213, "onToast");
        Intrinsics.checkNotNullParameter(r214, "onSubmitted");
        this.f338541a = r110;
        this.f338542b = r111;
        this.f338543c = r112;
        this.f338544d = r210;
        this.f338545e = r211;
        this.f338546f = r212;
        this.f338547g = r213;
        this.f338548h = r214;
        final OSheet r100 = new OSheet(r110, 0, false, 30);
        this.f338549i = r100;
        this.f338550j = new LinkedHashSet();
        OSheetBase.DefaultImpls.q(r100, OSheet.HeightMode.WRAP_HEIGHT);
        OSheet.Header r101 = OSheet.Header.MODAL;
        Context r102 = r100.getContext();
        if (r210 != 1) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        int r104 = R.string.larus_dora_personal_diary_like_reason_title_cn;
    L9:
        OSheetBase.DefaultImpls.o(r100, r101, null, r102.getString(r104), null, false, null, new g0(r100), 16134);
        LinearLayout r105 = new LinearLayout(r110);
        r105.setOrientation(1);
        r105.setPadding(a(12), a(4), a(12), a(16));
        View r106 = LayoutInflater.from(r110).inflate(R.layout.larus_dora_o_feedback_reason_group, r105, false);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.obric.oui.chip.OChipGroup");
        OChipGroup r107 = (OChipGroup) r106;
        this.f338552l = r107;
        if (r107 == null) goto L19;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r109 = (LinearLayout.LayoutParams) r108;
    L15:
        if (r109 == null) goto L17;
        r109.topMargin = a(8);
    L18:
        r107.setLayoutParams(r109);
        goto L19
    L17:
        r109 = null;
        goto L18
    L14:
        r109 = null;
    L19:
        r105.addView(this.f338552l);
        if (r210 != 1) goto L22;
        boolean r113 = true;
    L23:
        if (r113 == false) goto L25;
        List<String> r114 = f338539o;
    L26:
        c(r114);
        LinearLayout r115 = new LinearLayout(r110);
        r115.setOrientation(1);
        r115.setBackgroundResource(R.drawable.dora_o_bg_memory_card);
        r115.setPadding(a(20), a(16), a(20), a(12));
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-1, a(130));
        r116.topMargin = a(16);
        r115.setLayoutParams(r116);
        EditText r117 = new EditText(r110);
        r117.setHint(r117.getContext().getString(R.string.dora_o_diary_feedback_input_hint));
        r117.setBackground(null);
        r117.setPadding(0, 0, 0, 0);
        r117.setGravity(8388659);
        r117.setTextSize(15.0f);
        r117.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(100)});
        r117.setTextColor(ContextCompat.getColor(r117.getContext(), R.color.dora_o_text_primary));
        r117.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r117.addTextChangedListener(new j0(this));
        this.f338551k = r117;
        r115.addView(r117);
        LinearLayout r118 = new LinearLayout(r110);
        r118.setOrientation(0);
        r118.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView r119 = new TextView(r110);
        r119.setText(r119.getContext().getString(R.string.dora_o_diary_feedback_input_helper, new Object[]{100}));
        r119.setTextSize(12.0f);
        r119.setTextColor(ContextCompat.getColor(r119.getContext(), R.color.dora_o_text_secondary));
        r118.addView(r119, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView r120 = new TextView(r110);
        r120.setTextSize(12.0f);
        r120.setTextColor(ContextCompat.getColor(r120.getContext(), R.color.dora_o_text_secondary));
        this.f338553m = r120;
        r118.addView(r120);
        r115.addView(r118);
        r105.addView(r115);
        d(0);
        OSheetBase.DefaultImpls.j(r100, r105);
        OSheetBase.DefaultImpls.k(r100, null, false, null, r100.getContext().getString(R.string.dora_o_diary_feedback_submit), true, new h0(this));
        return;
    L25:
        r114 = f338540p;
        goto L26
    L22:
        r113 = false;
        goto L23
    L8:
        r104 = R.string.larus_dora_personal_diary_dislike_reason_title_cn;
        goto L9
    L5:
        r103 = false;
        goto L6
    }
}
