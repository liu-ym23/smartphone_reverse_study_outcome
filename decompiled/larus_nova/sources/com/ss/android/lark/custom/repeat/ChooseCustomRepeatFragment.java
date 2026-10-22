package com.ss.android.lark.custom.repeat;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.custom.repeat.entity.EventRecurrence;
import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import com.ss.android.lark.ui.CommonTitleBar;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ^2\u00020\u0001:\u0002^_B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0016J&\u0010B\u001a\u0004\u0018\u00010%2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u001a\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020%2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010K\u001a\u000201H\u0002J\b\u0010L\u001a\u000201H\u0002J\b\u0010M\u001a\u000201H\u0002J\u0006\u0010N\u001a\u000201J\b\u0010O\u001a\u000201H\u0002J \u0010P\u001a\u0012\u0012\u0004\u0012\u00020R0Qj\b\u0012\u0004\u0012\u00020R`S2\u0006\u0010T\u001a\u000207H\u0002J\b\u0010U\u001a\u000201H\u0002J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u000201H\u0002J\b\u0010X\u001a\u000201H\u0002J\b\u0010Y\u001a\u000201H\u0002J\u000e\u0010Z\u001a\u0002012\u0006\u0010A\u001a\u00020\u0007J\u0006\u0010[\u001a\u000204J\u0006\u0010\\\u001a\u000201J\b\u0010]\u001a\u000201H\u0002R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010!\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001e\u0010$\u001a\u0004\u0018\u00010%8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010+8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u0002070@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "action", "Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment$CustomRepeatFragmentAction;", "repeatData", "Lcom/ss/android/lark/custom/repeat/entity/CustomRepeatData;", "(Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment$CustomRepeatFragmentAction;Lcom/ss/android/lark/custom/repeat/entity/CustomRepeatData;)V", "customRepeatBottomContainerFromXml", "Lcom/ss/android/lark/custom/repeat/widget/bottom/container/CustomRepeatBottomContainer;", "getCustomRepeatBottomContainerFromXml", "()Lcom/ss/android/lark/custom/repeat/widget/bottom/container/CustomRepeatBottomContainer;", "setCustomRepeatBottomContainerFromXml", "(Lcom/ss/android/lark/custom/repeat/widget/bottom/container/CustomRepeatBottomContainer;)V", "customRepeatTitleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getCustomRepeatTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setCustomRepeatTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "wheelRepeatWeekNoFromXml", "Lcom/ss/android/lark/custom/repeat/widget/wheelview/WheelView;", "getWheelRepeatWeekNoFromXml", "()Lcom/ss/android/lark/custom/repeat/widget/wheelview/WheelView;", "setWheelRepeatWeekNoFromXml", "(Lcom/ss/android/lark/custom/repeat/widget/wheelview/WheelView;)V", "wheelRepeatWeeksFromXml", "getWheelRepeatWeeksFromXml", "setWheelRepeatWeeksFromXml", "customWheelRepeatNumFromXml", "getCustomWheelRepeatNumFromXml", "setCustomWheelRepeatNumFromXml", "customWheelRepeatFrequencyUnitFromXml", "getCustomWheelRepeatFrequencyUnitFromXml", "setCustomWheelRepeatFrequencyUnitFromXml", "bottomContainerDividerFromXml", "Landroid/view/View;", "getBottomContainerDividerFromXml", "()Landroid/view/View;", "setBottomContainerDividerFromXml", "(Landroid/view/View;)V", "tvRepeatRuleFromXml", "Landroid/widget/TextView;", "getTvRepeatRuleFromXml", "()Landroid/widget/TextView;", "setTvRepeatRuleFromXml", "(Landroid/widget/TextView;)V", "clearFromXmlViewCache", "", "onDestroyView", "isFromLocalRecover", "", "customRepeatAction", "repeatFreIndex", "", "repeatNumAdapter", "Lcom/ss/android/lark/custom/repeat/adapter/CustomNumericWheelAdapter;", "repeatFreAdapter", "Lcom/ss/android/lark/custom/repeat/adapter/StringWheelAdapter;", "repeatFreSingularAdapter", "repeatMode", "Lcom/ss/android/lark/custom/repeat/entity/RepeatMode;", "repeatModelTypes", "Landroid/util/SparseArray;", "customRepeatData", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "initWeekContainer", "initTitleBar", "refreshPickerViewData", "initData", "getPluralListByNum", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "number", "refreshBottomContainerData", "initListener", "refreshBottomContainer", "refreshRepeatRule", "initWheelView", "refreshData", "onBackPressed", "clear", "initRepeatModeAndRefresh", "Companion", "CustomRepeatFragmentAction", "custom-repeat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseCustomRepeatFragment extends Fragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f420250u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CustomRepeatBottomContainer f420251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonTitleBar f420252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WheelView f420253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WheelView f420254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WheelView f420255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WheelView f420256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f420257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f420258k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f420259l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f420260m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f420261n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public mab.b f420262o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public mab.f f420263p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public mab.f f420264q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RepeatMode f420265r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SparseArray<Integer> f420266s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final nab.a f420267t;

    public static final class a {
    }

    public interface b {
        void a(EventRecurrence r100);

        void onBackPressed();
    }

    static {
    }

    public final View S90() {
        View r100 = this.f420257j;
        if (r100 != null) goto L9;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.bottom_container_divider);
    L8:
        this.f420257j = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public final CustomRepeatBottomContainer T90() {
        View r100 = this.f420251d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.custom_repeat_bottom_container);
    L8:
        this.f420251d = (CustomRepeatBottomContainer) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CustomRepeatBottomContainer) r100;
    }

    public final CommonTitleBar U90() {
        View r100 = this.f420252e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.custom_repeat_title_bar);
    L8:
        this.f420252e = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public final WheelView V90() {
        View r100 = this.f420256i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.custom_wheel_repeat_frequency_unit);
    L8:
        this.f420256i = (WheelView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WheelView) r100;
    }

    public final WheelView W90() {
        View r100 = this.f420255h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.custom_wheel_repeat_num);
    L8:
        this.f420255h = (WheelView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WheelView) r100;
    }

    public final void Y90() {
        this.f420265r.setRepeatType(this.f420266s.get(0).intValue());
        RepeatMode r100 = this.f420265r;
        mab.b r101 = this.f420262o;
        mab.f r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repeatNumAdapter");
        r101 = null;
    L5:
        r100.setInterval(r101.b(0).intValue());
        this.f420261n = 0;
        WheelView r103 = V90();
        mab.f r104 = this.f420264q;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("repeatFreSingularAdapter");
    L9:
        r103.setAdapter(r102);
        W90().setCurrentItem(0);
        V90().setCurrentItem(0);
        ba0();
        return;
    L8:
        r102 = r104;
        goto L9
    }

    public final void Z90() {
        int r100 = this.f420261n;
        if (r100 != 0) goto L5;
        this.f420265r.setRepeatType(7);
        T90().setVisibility(8);
        S90().setVisibility(8);
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f420265r.setRepeatType(8);
        T90().setVisibility(0);
        S90().setVisibility(0);
        T90().f();
        return;
    L7:
        if (r100 != 2) goto L9;
        T90().setVisibility(0);
        S90().setVisibility(0);
        T90().e();
        return;
    L9:
        if (r100 == 3) goto L11;
        this.f420265r.setRepeatType(7);
        T90().setVisibility(8);
        S90().setVisibility(8);
        return;
    L11:
        T90().setVisibility(8);
        S90().setVisibility(8);
    }

    public final void ba0() {
        String r100 = qab.b.a(this.f420265r.toER().toString(), this.f420267t.f518493i);
        View r101 = this.f420258k;
        if (r101 != null) goto L9;
        View r102 = getView();
        if (r102 == null) goto L7;
        r101 = r102.findViewById(R.id.tv_repeat_rule);
    L8:
        this.f420258k = (TextView) r101;
        goto L9
    L7:
        r101 = null;
    L9:
        ((TextView) r101).setText(r100);
    }

    public ChooseCustomRepeatFragment() {
        this.f420265r = new RepeatMode();
        this.f420266s = new SparseArray();
        this.f420267t = new nab.a(0);
        this.f420259l = true;
    }

    public final void aa0() {
        T90().setCustomRepeatData(this.f420267t);
        T90().setFirstDayOfWeek(this.f420267t.f518486b);
        CustomRepeatBottomContainer r100 = T90();
        nab.a r101 = this.f420267t;
        r100.d(r101.f518490f, r101.f518485a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f420251d = null;
        this.f420252e = null;
        this.f420253f = null;
        this.f420254g = null;
        this.f420255h = null;
        this.f420256i = null;
        this.f420257j = null;
        this.f420258k = null;
    }

    public final ArrayList<String> X90(int r100) {
        ArrayList<String> r101 = new ArrayList();
        r101.add(qab.c.b(getContext(), R.plurals.Calendar_Plural_RRuleDay, r100));
        r101.add(qab.c.b(getContext(), R.plurals.Calendar_Plural_RRuleWeek, r100));
        r101.add(qab.c.b(getContext(), R.plurals.Calendar_Plural_RRuleMonth, r100));
        r101.add(qab.c.b(getContext(), R.plurals.Calendar_Plural_RRuleYear, r100));
        return r101;
    }

    public ChooseCustomRepeatFragment(ChooseRepeatFragment.a r100, nab.a r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "repeatData");
        RepeatMode r102 = new RepeatMode();
        this.f420265r = r102;
        this.f420266s = new SparseArray();
        this.f420267t = new nab.a(0);
        this.f420259l = false;
        this.f420260m = r100;
        this.f420267t = r101;
        r102.setIsSingleInWeek(r101.f518487c);
        r102.setIsSingleInMonth(r101.f518488d);
        r102.setWeekStartDay(r101.f518486b);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (this.f420259l == false) goto L5;
        return;
    L5:
        U90().setDividerVisible(false);
        U90().setLeftImageResource(R.drawable.ic_svg_titlebar_back_black);
        U90().setLeftClickListener(new d(this));
        U90().addAction(new e(this, getContext().getResources().getString(R.string.Calendar_Common_Done)));
        W90().setLineSpacingMultiplier(3.0f);
        W90().setTextColorCenter(qab.c.a(getContext(), R.color.text_title));
        V90().setLineSpacingMultiplier(3.0f);
        V90().setTextColorCenter(qab.c.a(getContext(), R.color.text_title));
        T90().setFirstDayOfWeek(this.f420267t.f518486b);
        W90().setOnItemSelectedListener(new c(this));
        V90().setOnItemSelectedListener(new com.ss.android.lark.custom.repeat.b(this));
        T90().setOnCheckedListener(new com.ss.android.lark.custom.repeat.a(this));
        this.f420262o = new mab.b();
        WheelView r102 = W90();
        mab.b r103 = this.f420262o;
        mab.f r104 = null;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("repeatNumAdapter");
        r103 = null;
    L8:
        r102.setAdapter(r103);
        this.f420263p = new mab.f(X90(2));
        this.f420264q = new mab.f(X90(1));
        WheelView r105 = V90();
        mab.f r106 = this.f420264q;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("repeatFreSingularAdapter");
    L12:
        r105.setAdapter(r104);
        this.f420266s.put(0, 1);
        this.f420266s.put(1, 2);
        this.f420266s.put(2, 4);
        this.f420266s.put(3, 5);
        Y90();
        aa0();
        return;
    L11:
        r104 = r106;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_choose_custom_repeat, null);
    }
}
