package com.ss.android.lark.custom.repeat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.custom.repeat.databinding.ActivityChooseRepeatPageBinding;
import com.ss.android.lark.custom.repeat.entity.EventRecurrence;
import com.ss.android.lark.custom.repeat.entity.RruleListItem;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n*\u0001$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\f\u00100\u001a\u00020'*\u00020)H\u0002J8\u00101\u001a\u00020'2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u00105\u001a\u00020'*\u000206H\u0002J\u0006\u00107\u001a\u00020'J\f\u00108\u001a\u00020'*\u000206H\u0002J\b\u00109\u001a\u00020\bH\u0002J\b\u0010:\u001a\u00020\bH\u0002J\f\u0010;\u001a\u00020'*\u000206H\u0002J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020>H\u0002J\u001a\u0010?\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010 2\u0006\u0010A\u001a\u00020\u0016H\u0002J\u0012\u0010B\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0006H\u0002J\u0010\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006H\u0002J\b\u0010G\u001a\u00020'H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006H"}, d2 = {"Lcom/ss/android/lark/custom/repeat/ChooseRepeatFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "defaultRruleList", "", "", "mChosenIndex", "", "mRepeatAdapter", "Lcom/ss/android/lark/custom/repeat/adapter/RepeatAdapter;", "rruleList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/custom/repeat/entity/RruleListItem;", "Lcom/ss/android/lark/custom/repeat/entity/RruleList;", "inputRRule", "parsedInputRruleText", "firstDayOfWeek", "Lcom/ss/android/lark/custom/repeat/CustomRepeatParams$DayOfWeek;", "languageType", "Lcom/bytedance/lark/pb/basic/v1/LanguageType;", "isSingleInWeek", "", "isSingleInMonth", "isFixDefaultDate", "defaultDate", "Ljava/util/GregorianCalendar;", "bannedUnselectedStringId", "Ljava/lang/Integer;", "bannedSlideStringId", "selfDefineItemText", "mChooseCustomRepeatFragment", "Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment;", "fragmentStack", "Ljava/util/Stack;", "mCustomRepeatFragmentAction", "com/ss/android/lark/custom/repeat/ChooseRepeatFragment$mCustomRepeatFragmentAction$1", "Lcom/ss/android/lark/custom/repeat/ChooseRepeatFragment$mCustomRepeatFragmentAction$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "parseDataFromIntent", "initRruleList", "customRepeatRruleList", "customHideRepeat", "lastRrule", "initTitle", "Lcom/ss/android/lark/custom/repeat/databinding/ActivityChooseRepeatPageBinding;", "onBackPressed", "initList", "getIndexOfInputRrule", "getChosenIndex", "initListener", "showCustomRepeatFragment", "getDefaultCalendarDate", "Lcom/ss/android/lark/custom/repeat/entity/CalendarDate;", "showFragment", WidgetService.PARAM_FRAGMENT, "isFirstAdd", "hideFragment", "setResultWithRRule", "rrule", "getRepeatRuleShowStr", "rRule", "close", "custom-repeat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseRepeatFragment extends BaseFragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f420269v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f420270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f420271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public mab.e f420272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<RruleListItem> f420273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f420274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f420275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CustomRepeatParams$DayOfWeek f420276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LanguageType f420277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f420278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f420279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f420280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GregorianCalendar f420281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f420282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f420283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f420284r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ChooseCustomRepeatFragment f420285s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Stack<ChooseCustomRepeatFragment> f420286t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f420287u;

    public static final class a implements ChooseCustomRepeatFragment.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChooseRepeatFragment f420288a;

        @Override // com.ss.android.lark.custom.repeat.ChooseCustomRepeatFragment.b
        public final void onBackPressed() {
            ChooseRepeatFragment r100 = this.f420288a;
            r100.V90(r100.f420285s);
        }

        public a(ChooseRepeatFragment r100) {
            this.f420288a = r100;
        }

        @Override // com.ss.android.lark.custom.repeat.ChooseCustomRepeatFragment.b
        public final void a(EventRecurrence r100) {
            Intrinsics.checkNotNullParameter(r100, "customRRule");
            ChooseRepeatFragment.S90(this.f420288a, r100.toString());
        }
    }

    public final int T90() {
        Iterator<RruleListItem> r100 = this.f420273g.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L15;
        RruleListItem r102 = r100.next();
        if (Intrinsics.areEqual(r102.getRrule(), this.f420274h) == false) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L19;
        r101 = r101 + 1;
        goto L4
    L19:
        return r101;
    L8:
        if (Intrinsics.areEqual(r102.getParsedText(), this.f420275i) == true) goto L11;
        r103 = false;
        goto L12
    L15:
        return -1;
    }

    public final void onBackPressed() {
        if (this.f420286t.size() <= 0) goto L8;
        ChooseCustomRepeatFragment r100 = this.f420286t.peek();
        if (r100 == null) goto L7;
        V90(r100);
        return;
    L7:
        com.ss.android.lark.ui.component_container.a.d(this, null);
        return;
    L8:
        com.ss.android.lark.ui.component_container.a.d(this, null);
    }

    public ChooseRepeatFragment() {
        this.f420270d = CollectionsKt.listOf(new String[]{"", "FREQ=DAILY;INTERVAL=1", "FREQ=WEEKLY;INTERVAL=1", "FREQ=MONTHLY;INTERVAL=1", "FREQ=YEARLY;INTERVAL=1", "FREQ=WEEKLY;INTERVAL=1;BYDAY=MO,TU,WE,TH,FR"});
        this.f420273g = new ArrayList();
        this.f420274h = "";
        this.f420275i = "";
        this.f420276j = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.f420277k = LanguageType.UNKNOWN_LANGUAGE;
        this.f420286t = new Stack();
        this.f420287u = new a(this);
    }

    public final String U90(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L11;
        Context r102 = getActivity();
        if (r102 != null) goto L10;
        r102 = LarkContext.getApplication();
    L10:
        String r103 = r102.getResources().getString(R.string.Calendar_Detail_NoRepeat);
        Intrinsics.checkNotNull(r103);
        return r103;
    L11:
        String r104 = qab.b.a(r100, this.f420277k);
        Intrinsics.checkNotNull(r104);
        return r104;
    L5:
        r101 = false;
        goto L6
    }

    public final void V90(ChooseCustomRepeatFragment r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.f420265r.clearRule();
        r100.T90().c();
        getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out).hide(r100).commitAllowingStateLoss();
        if (this.f420286t.size() <= 0) goto L7;
        this.f420286t.pop();
    L7:
        getChildFragmentManager().executePendingTransactions();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        Bundle r111 = getArguments();
        if (r111 == null) goto L45;
        CustomRepeatParams$DayOfWeek r100 = (CustomRepeatParams$DayOfWeek) r111.get("custom_repeat_first_day_of_week");
        if (r100 != null) goto L7;
        r100 = CustomRepeatParams$DayOfWeek.SUNDAY;
    L7:
        this.f420276j = r100;
        this.f420278l = r111.getBoolean("custom_repeat_is_single_in_week");
        this.f420279m = r111.getBoolean("custom_repeat_is_single_in_month");
        this.f420280n = r111.getBoolean("custom_repeat_is_fixed_default_date");
        Object r101 = r111.get("custom_repeat_default_date");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.GregorianCalendar");
        this.f420281o = (GregorianCalendar) r101;
        this.f420282p = Integer.valueOf(r111.getInt("custom_repeat_banned_unselected_localize_id"));
        this.f420283q = Integer.valueOf(r111.getInt("custom_repeat_banned_select_localize_id"));
        this.f420284r = r111.getString("custom_repeat_self_define_item_text");
        LanguageType r102 = (LanguageType) r111.get("custom_repeat_language_type");
        if (r102 != null) goto L10;
        r102 = LanguageType.UNKNOWN_LANGUAGE;
    L10:
        this.f420277k = r102;
        Serializable r103 = r111.getSerializable("custom_repeat_rrule_list");
        if ((r103 instanceof ArrayList) == false) goto L13;
        ArrayList r104 = (ArrayList) r103;
    L14:
        ArrayList<String> r105 = r111.getStringArrayList("custom_hide_repeat");
        String r112 = r111.getString("custom_repeat_last_rrule");
        this.f420273g.clear();
        int r106 = 0;
        if (r104 != null) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L26;
        Iterator<T> r108 = this.f420270d.iterator();
    L24:
        if (r108.hasNext() == false) goto L27;
        String r109 = (String) r108.next();
        String r113 = U90(r109);
        this.f420273g.add(new RruleListItem(r109, r113, r113, null, 8, null));
    L27:
        if (r105 == null) goto L32;
        Iterator<T> r114 = r105.iterator();
    L30:
        if (r114.hasNext() == false) goto L32;
        final String r115 = (String) r114.next();
        CollectionsKt.removeAll(this.f420273g, new ChooseRepeatFragment$initRruleList$2$1(r115));
    L32:
        if (r112 != null) goto L34;
        r112 = "";
    L34:
        this.f420274h = r112;
        this.f420275i = U90(r112);
        if (T90() >= 0) goto L37;
        ArrayList<RruleListItem> r116 = this.f420273g;
        String r117 = this.f420274h;
        String r118 = this.f420275i;
        r116.add(new RruleListItem(r117, r118, r118, null, 8, null));
    L37:
        int r119 = T90();
        if (r119 == (-1)) goto L41;
        r106 = r119;
    L41:
        this.f420271e = r106;
        return;
    L26:
        this.f420273g.addAll(r104);
        goto L27
    L17:
        if (r104.isEmpty() == true) goto L20;
        r107 = false;
        goto L21
    L13:
        r104 = null;
        goto L14
    }

    public static final void S90(ChooseRepeatFragment r100, String r101) {
        FragmentActivity r102 = r100.getActivity();
        if (r102 == null) goto L7;
        Intent r103 = new Intent();
        r103.putExtra("custom_repeat_result_rrule", r101);
        r103.putExtra("custom_repeat_result_display_text", r100.U90(r101));
        r102.setResult(-1, r103);
        com.ss.android.lark.ui.component_container.a.d(r100, null);
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        boolean r100 = false;
        View r113 = r110.inflate(R.layout.activity_choose_repeat_page, r111, false);
        int r114 = R.id.ll_self_define_repeat;
        RelativeLayout r115 = (RelativeLayout) ViewBindings.findChildViewById(r113, R.id.ll_self_define_repeat);
        if (r115 == null) goto L29;
        r114 = R.id.lv_repeat_times;
        ListView r101 = (ListView) ViewBindings.findChildViewById(r113, R.id.lv_repeat_times);
        if (r101 == null) goto L29;
        r114 = R.id.repeat_fragment_container;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.repeat_fragment_container);
        if (r102 == null) goto L29;
        r114 = R.id.repeat_title_bar;
        CommonTitleBar r103 = (CommonTitleBar) ViewBindings.findChildViewById(r113, R.id.repeat_title_bar);
        if (r103 == null) goto L29;
        r114 = R.id.self_define_repeat_text;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r113, R.id.self_define_repeat_text);
        if (r116 == null) goto L29;
        RelativeLayout r117 = (RelativeLayout) r113;
        Intrinsics.checkNotNull(new ActivityChooseRepeatPageBinding(r117, r115, r101, r102, r103, r116));
        r103.setDividerVisible(false);
        r103.setLeftImageResource(R.drawable.ud_icon_left_outlined);
        r103.setTitle(R.string.Calendar_Edit_ChooseRepeat);
        r103.setLeftClickListener(new h(this));
        mab.e r118 = this.f420272f;
        if (r118 != null) goto L18;
        int r119 = T90();
        if (r119 != (-1)) goto L17;
        r119 = 0;
    L17:
        this.f420271e = r119;
        mab.e r120 = new mab.e(this.f420273g, this.f420271e, r117.getContext());
        this.f420272f = r120;
        r101.setAdapter(r120);
    L19:
        r101.setOnItemClickListener(new f(this));
        String r121 = this.f420284r;
        if (r121 != null) goto L22;
    L23:
        r100 = true;
    L24:
        if (r100 == true) goto L26;
        r116.setText(this.f420284r);
    L26:
        r115.setOnClickListener(new g(this));
        WindowInsetsUtils.g(r117, true, true);
        return r117;
    L22:
        if (r121.length() != 0) goto L24;
    L18:
        ArrayList<RruleListItem> r104 = this.f420273g;
        int r105 = this.f420271e;
        Intrinsics.checkNotNullParameter(r104, "rruleList");
        r118.f512744c.clear();
        r118.f512744c.addAll(r104);
        r118.f512742a = r105;
        r118.notifyDataSetChanged();
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
