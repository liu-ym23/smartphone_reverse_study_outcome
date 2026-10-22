package com.larus.login.impl.agegate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.account.base.model.NeutralAgeGatePage;
import com.larus.account.base.model.NeutralAgeGateStyle;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.RectangleButton;
import com.larus.common_ui.widget.datepicker.DatePicker;
import com.larus.common_ui.widget.datepicker.NumberPicker;
import com.larus.login.impl.databinding.LarusAgeGatePageBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/login/impl/agegate/AgeGateFragment;", "Lcom/larus/login/impl/agegate/BaseNeutralAgeGateFragment;", "<init>", "()V", "binding", "Lcom/larus/login/impl/databinding/LarusAgeGatePageBinding;", "isFromNonNeutralAgeGate", "", "showDebugInfo", "sdf", "Ljava/text/SimpleDateFormat;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "initDatePicker", "initTips", "updateDebugInfo", "Lcom/larus/common_ui/widget/datepicker/DatePicker;", "onReportTooMinAge", "computeYear", "", "onViewCreated", "view", "onBackPressed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgeGateFragment extends BaseNeutralAgeGateFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f357286l = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LarusAgeGatePageBinding f357287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f357288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f357289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SimpleDateFormat f357290k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.login.impl.agegate.BaseNeutralAgeGateFragment
    public final void V90() {
        LarusAgeGatePageBinding r100 = this.f357287h;
        if (r100 == null) goto L18;
        DatePicker r101 = r100.f357482b;
        if (r101 == null) goto L18;
        r101.getYear();
        Context r102 = getContext();
        if (r102 == null) goto L18;
        LarusAgeGatePageBinding r103 = this.f357287h;
        if (r103 == null) goto L13;
        TextView r104 = r103.f357485e;
        if (r104 == null) goto L13;
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r104.setText(String.format(r102.getString(R.string.larus_age_gate_error), Arrays.copyOf(new Object[]{Integer.valueOf(Y90())}, 1)));
    L13:
        LarusAgeGatePageBinding r106 = this.f357287h;
        if (r106 == null) goto L18;
        TextView r107 = r106.f357485e;
        if (r107 == null) goto L18;
        r107.setTextColor(ContextCompat.getColor(r102, R.color.larus_danger_50));
    L18:
        FragmentActivity r108 = getActivity();
        if (r108 == null) goto L21;
        t19.s r109 = t19.s.f544207a;
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        String r111 = String.format(r108.getString(R.string.larus_age_gate_error), Arrays.copyOf(new Object[]{Integer.valueOf(Y90())}, 1));
        r109.getClass();
        t19.s.t(r108, r111);
    L21:
        LarusAgeGatePageBinding r112 = this.f357287h;
        if (r112 == null) goto L27;
        RectangleButton r113 = r112.f357484d;
        if (r113 == null) goto L28;
        r113.a(false);
        return;
    L28:
        return;
    }

    public final int Y90() {
        Date r100 = new Date();
        LarusAgeGatePageBinding r101 = this.f357287h;
        if (r101 == null) goto L12;
        DatePicker r102 = r101.f357482b;
        if (r102 == null) goto L16;
        Date r103 = new Date(r102.getTimestamp());
        Calendar r104 = Calendar.getInstance();
        r104.setTime(r100);
        Calendar r105 = Calendar.getInstance();
        r105.setTime(r103);
        int r106 = r104.get(1);
        int r107 = r104.get(2);
        int r108 = r104.get(5);
        int r109 = r105.get(1);
        int r110 = r106 - r109;
        int r111 = r107 - r105.get(2);
        int r112 = r108 - r105.get(5);
        if (r111 < 0) goto L11;
        if (r111 != 0) goto L14;
        if (r112 < 0) goto L11;
        return r110;
    L14:
        return r110;
    L11:
        return r110 - 1;
    L16:
        return 0;
    L12:
        return 0;
    }

    public final DatePicker Z90() {
        LarusAgeGatePageBinding r100 = this.f357287h;
        if (r100 == null) goto L43;
        DatePicker r101 = r100.f357482b;
        if (r101 == null) goto L43;
        long r102 = r101.getTimestamp();
        LarusAgeGatePageBinding r103 = this.f357287h;
        if (r103 == null) goto L11;
        TextView r104 = r103.f357483c;
        if (r104 == null) goto L11;
        r104.setText("DEBUG REAL SELECTED: " + this.f357290k.format(Long.valueOf(r102)));
    L11:
        Calendar r105 = Calendar.getInstance();
        r105.setTime(new Date(r102));
        NumberPicker r106 = r101.getYearPicker();
        boolean r107 = true;
        if (r106 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L34;
        NumberPicker r109 = r101.getMonthPicker();
        if (r109 != null) goto L21;
    L23:
        boolean r110 = false;
    L24:
        if (r110 == false) goto L34;
        NumberPicker r111 = r101.getDayOfMonthPicker();
        if (r111 != null) goto L28;
    L30:
        boolean r112 = false;
    L31:
        if (r112 == false) goto L34;
        r107 = false;
        goto L34
    L28:
        if (r111.getCurrentNumber() != r105.get(5)) goto L30;
        r112 = true;
        goto L31
    L21:
        if (r109.getCurrentNumber() != (r105.get(2) + 1)) goto L23;
        r110 = true;
    L34:
        Context r113 = r101.getContext();
        if (r107 == false) goto L37;
        int r114 = R.color.larus_danger_50;
    L38:
        int r115 = ContextCompat.getColor(r113, r114);
        LarusAgeGatePageBinding r116 = this.f357287h;
        if (r116 == null) goto L45;
        TextView r117 = r116.f357483c;
        if (r117 == null) goto L46;
        r117.setTextColor(r115);
        return r101;
    L46:
        return r101;
    L45:
        return r101;
    L37:
        r114 = R.color.larus_neutral_100;
        goto L38
    L14:
        if (r106.getCurrentNumber() != r105.get(1)) goto L16;
        r108 = true;
    L43:
        return null;
    }

    @Override // com.larus.login.impl.agegate.BaseNeutralAgeGateFragment
    public final void onBackPressed() {
        BaseNeutralAgeGateFragment.T90("back", NeutralAgeGateStyle.ROLLER.getMobType(), NeutralAgeGatePage.FIRST_PAGE.getMobPage());
        S90();
    }

    public AgeGateFragment() {
        this.f357288i = true;
        this.f357289j = AppHost.f326268a.isTestChannel();
        this.f357290k = new SimpleDateFormat("yyyy/MM/dd");
    }

    @Override // com.larus.login.impl.agegate.BaseNeutralAgeGateFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = false;
        if (r101 == null) goto L5;
        r102 = r101.getBoolean("neutral_age_gate_is_from_non_neutral", false);
    L5:
        this.f357288i = r102;
    }

    @Override // com.larus.login.impl.agegate.BaseNeutralAgeGateFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        BaseNeutralAgeGateFragment.U90(NeutralAgeGateStyle.ROLLER.getMobType(), NeutralAgeGatePage.FIRST_PAGE.getMobPage());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_age_gate_page, r110, false);
        int r112 = R.id.date_picker;
        DatePicker r102 = (DatePicker) ViewBindings.findChildViewById(r101, R.id.date_picker);
        if (r102 == null) goto L69;
        r112 = R.id.debug_info;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.debug_info);
        if (r103 == null) goto L69;
        r112 = R.id.next_btn;
        RectangleButton r104 = (RectangleButton) ViewBindings.findChildViewById(r101, R.id.next_btn);
        if (r104 == null) goto L69;
        r112 = R.id.phone_back_button;
        ImageView r113 = (ImageView) ViewBindings.findChildViewById(r101, R.id.phone_back_button);
        if (r113 == null) goto L69;
        r112 = R.id.subTitle;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.subTitle)) == null) goto L69;
        r112 = R.id.tips;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.tips);
        if (r105 == null) goto L69;
        r112 = R.id.title_text;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.title_text)) == null) goto L69;
        this.f357287h = new LarusAgeGatePageBinding((ConstraintLayout) r101, r102, r103, r104, r113, r105);
        r113.setOnClickListener(new k(this));
        LarusAgeGatePageBinding r106 = this.f357287h;
        if (r106 == null) goto L19;
        RectangleButton r107 = r106.f357484d;
    L20:
        e1.d(r107, new l(this));
        Date r108 = new Date();
        Calendar r114 = Calendar.getInstance();
        r114.setTime(r108);
        r114.add(1, -1);
        Calendar r109 = Calendar.getInstance();
        r109.setTime(r108);
        r109.add(1, -15);
        Calendar r115 = Calendar.getInstance();
        r115.setTime(r108);
        r115.add(1, -18);
        r115.add(5, 1);
        Calendar r116 = Calendar.getInstance();
        r116.set(r114.getTime().getYear() + 1900, 11, 31);
        boolean r117 = this.f357288i;
        if (r117 == true) goto L24;
        r115 = null;
    L24:
        if (r117 == false) goto L26;
        r114 = r109;
    L26:
        LarusAgeGatePageBinding r118 = this.f357287h;
        if (r118 == null) goto L31;
        DatePicker r119 = r118.f357482b;
        if (r119 == null) goto L31;
        r119.b(r114.getTime(), r116);
    L31:
        LarusAgeGatePageBinding r120 = this.f357287h;
        if (r120 == null) goto L37;
        DatePicker r121 = r120.f357482b;
        if (r121 == null) goto L37;
        r121.setLowerBoundDate(r115);
    L37:
        if (this.f357289j == false) goto L44;
        LarusAgeGatePageBinding r122 = this.f357287h;
        if (r122 == null) goto L43;
        TextView r123 = r122.f357483c;
        if (r123 == null) goto L43;
        e1.x(r123);
    L43:
        Z90();
    L44:
        Context r124 = getContext();
        if (r124 == null) goto L55;
        LarusAgeGatePageBinding r125 = this.f357287h;
        if (r125 == null) goto L55;
        DatePicker r126 = r125.f357482b;
        if (r126 == null) goto L55;
        r126.getYear();
        LarusAgeGatePageBinding r127 = this.f357287h;
        if (r127 == null) goto L55;
        TextView r128 = r127.f357485e;
        if (r128 == null) goto L55;
        StringCompanionObject r129 = StringCompanionObject.INSTANCE;
        r128.setText(String.format(r124.getString(R.string.larus_age_gate_age), Arrays.copyOf(new Object[]{Integer.valueOf(Y90())}, 1)));
    L55:
        LarusAgeGatePageBinding r130 = this.f357287h;
        if (r130 == null) goto L60;
        RectangleButton r131 = r130.f357484d;
        if (r131 == null) goto L60;
        r131.a(false);
    L60:
        LarusAgeGatePageBinding r132 = this.f357287h;
        if (r132 == null) goto L65;
        DatePicker r133 = r132.f357482b;
        if (r133 == null) goto L65;
        r133.f328594h = new m(this);
    L65:
        if (r132 != null) goto L67;
        return null;
    L67:
        return r132.f357481a;
    L19:
        r107 = null;
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
