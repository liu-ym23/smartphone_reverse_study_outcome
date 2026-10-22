package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.ss.android.lark.custom.repeat.entity.CalendarDate;
import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import com.ss.android.lark.custom.repeat.widget.childview.ControlChildViewClickableLayout;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import mab.f;
import mab.g;
import oab.e;

/* JADX INFO: loaded from: classes35.dex */
public class CustomRepeatBottomContainer extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f420331s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f420332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f420333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mab.d f420334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f420335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f420336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f420337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f420338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f420339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f420340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String[] f420341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f420342k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f420343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public rab.d f420344m;

    @BindView(AVMDLDataLoader.KeyIsPreloadInfoRecordMaxCnt)
    ControlChildViewClickableLayout mChooseRepeatWeeksViewGroup;

    @BindView(7468)
    GridView mCustomRepeatMonthly;

    @BindView(7470)
    GridView mCustomRepeatWeekly;

    @BindView(7743)
    View mMonthlyTabContainer;

    @BindView(8092)
    WheelView mRepeatWeekNoWheelView;

    @BindView(8093)
    WheelView mRepeatWeeksWheelView;

    @BindView(7948)
    TextView mSwitchDate;

    @BindView(7949)
    TextView mSwitchWeek;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CustomRepeatParams$DayOfWeek f420345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CalendarDate f420346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public nab.a f420347p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f420348q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f420349r;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomRepeatBottomContainer f420350a;

        public a(CustomRepeatBottomContainer r100) {
            this.f420350a = r100;
        }

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final String b(String r100) {
            int r101 = CastIntegerProtector.parseInt(r100) - 1;     // Catch: Exception -> L8
            if (r101 < 0) goto L11;
            String[] r102 = this.f420350a.f420340i;     // Catch: Exception -> L8
            if (r101 >= r102.length) goto L12;
            return r102[r101];
        L12:
            return r100;
        L11:
            return r100;
        L13:
            return r100;
        }

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final void a(boolean r100, int r101) {
            if (r100 == false) goto L4;
            this.f420350a.f420339h.d(r101 + 1);
            return;
        L4:
            this.f420350a.f420339h.g(r101 + 1);
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomRepeatBottomContainer f420351a;

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final String b(String r100) {
            return r100;
        }

        public b(CustomRepeatBottomContainer r100) {
            this.f420351a = r100;
        }

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final void a(boolean r100, int r101) {
            int r102 = c.f420352a[this.f420351a.f420345n.ordinal()];
            if (r102 != 1) goto L5;
            if (r101 < 0) goto L30;
            if (r101 >= 7) goto L31;
            if (r100 == false) goto L20;
            this.f420351a.f420339h.c((r101 + 1) % 7);
            return;
        L20:
            this.f420351a.f420339h.h((r101 + 1) % 7);
            return;
        L31:
            return;
        L30:
            return;
        L5:
            if (r102 == 2) goto L11;
            if (r101 < 0) goto L22;
            if (r101 >= 7) goto L23;
            if (r100 == false) goto L10;
            this.f420351a.f420339h.c(r101 % 7);
            return;
        L10:
            this.f420351a.f420339h.h(r101 % 7);
            return;
        L23:
            return;
        L22:
            return;
        L11:
            if (r101 < 0) goto L26;
            if (r101 >= 7) goto L27;
            if (r100 == false) goto L15;
            this.f420351a.f420339h.c((r101 + 6) % 7);
            return;
        L15:
            this.f420351a.f420339h.h((r101 + 6) % 7);
            return;
        L27:
            return;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420352a = null;

        static {
            int[] r100 = new int[CustomRepeatParams$DayOfWeek.values().length];
            f420352a = r100;
            r100[CustomRepeatParams$DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f420352a[CustomRepeatParams$DayOfWeek.SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface d {
        void a(boolean r100, int r101);

        String b(String r100);
    }

    public final void b() {
        e r100 = this.f420339h;
        if (r100 == null) goto L6;
        r100.b(this.f420337f);
        this.f420339h.a(this.f420338g);
        this.f420339h.e(this.f420337f + this.f420338g);
        return;
    }

    public final void c() {
        g r100 = this.f420333b;
        if (r100 == null) goto L9;
        int r101 = 0;
    L5:
        boolean[] r102 = r100.f512736a;
        if (r101 >= r102.length) goto L8;
        r102[r101] = false;
        r101 = r101 + 1;
        goto L5
    L8:
        r100.notifyDataSetChanged();
    L9:
        mab.d r103 = this.f420334c;
        if (r103 == null) goto L16;
        int r104 = 0;
    L12:
        boolean[] r105 = r103.f512736a;
        if (r104 >= r105.length) goto L15;
        r105[r104] = false;
        r104 = r104 + 1;
        goto L12
    L15:
        r103.notifyDataSetChanged();
    L16:
        WheelView r106 = this.mRepeatWeekNoWheelView;
        if (r106 == null) goto L19;
        r106.setCurrentItem(this.f420342k);
    L19:
        WheelView r107 = this.mRepeatWeeksWheelView;
        if (r107 == null) goto L22;
        r107.setCurrentItem(this.f420343l);
    L22:
        this.f420338g = this.f420336e.b(this.f420343l);
        this.f420337f = this.f420335d.b(this.f420342k);
    }

    public final void e() {
        this.mMonthlyTabContainer.setVisibility(0);
        this.mCustomRepeatWeekly.setVisibility(8);
        if (this.f420332a == false) goto L8;
        e r100 = this.f420339h;
        if (r100 == null) goto L7;
        r100.i();
    L7:
        a(this.f420334c, this.f420348q);
        return;
    L8:
        b();
        e r101 = this.f420339h;
        if (r101 == null) goto L11;
        r101.f();
    L11:
        a(this.f420334c, this.f420348q);
    }

    public final void f() {
        this.mCustomRepeatWeekly.setVisibility(0);
        this.mMonthlyTabContainer.setVisibility(8);
        a(this.f420333b, this.f420349r);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        g r100 = new g(getContext(), (int) getResources().getDimension(R.dimen.dp_225), this.f420345n);
        this.f420333b = r100;
        this.mCustomRepeatWeekly.setAdapter(r100);
        this.mCustomRepeatWeekly.setOnItemClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.a(this));
        this.f420340i = getContext().getResources().getStringArray(R.array.custom_repeat_days);
        this.f420341j = getContext().getResources().getStringArray(R.array.weekly);
        mab.d r101 = new mab.d(getContext(), (int) getResources().getDimension(R.dimen.dp_250));
        this.f420334c = r101;
        this.mCustomRepeatMonthly.setAdapter(r101);
        this.mCustomRepeatMonthly.setOnItemClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.b(this));
        this.mSwitchDate.setOnClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.c(this));
        this.mSwitchWeek.setOnClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.d(this));
        this.mRepeatWeekNoWheelView.setLineSpacingMultiplier(3.0f);
        this.mRepeatWeekNoWheelView.setTextColorCenter(getContext().getResources().getColor(R.color.text_caption));
        this.mRepeatWeekNoWheelView.setTextColorOut(getContext().getResources().getColor(R.color.text_disable));
        f r102 = new f(Arrays.asList(UIHelper.getStringArray(R.array.week_no)));
        this.f420335d = r102;
        this.mRepeatWeekNoWheelView.setAdapter(r102);
        this.mRepeatWeekNoWheelView.setOnItemSelectedListener(new rab.c(this));
        this.mRepeatWeeksWheelView.setLineSpacingMultiplier(3.0f);
        this.mRepeatWeeksWheelView.setTextColorCenter(getContext().getResources().getColor(R.color.text_caption));
        this.mRepeatWeeksWheelView.setTextColorOut(getContext().getResources().getColor(R.color.text_disable));
        f r103 = new f(Arrays.asList(UIHelper.getStringArray(R.array.weekly)));
        this.f420336e = r103;
        this.mRepeatWeeksWheelView.setAdapter(r103);
        this.mRepeatWeeksWheelView.setOnItemSelectedListener(new rab.a(this));
        this.mChooseRepeatWeeksViewGroup.setChildViewClickable(!this.f420347p.f518488d);
        this.mChooseRepeatWeeksViewGroup.setOnTouchListener(new rab.b(this));
    }

    public CustomRepeatBottomContainer(Context r100) {
        super(r100);
        this.f420332a = true;
        this.f420342k = 1;
        this.f420343l = 1;
        this.f420345n = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.f420347p = new nab.a();
        this.f420348q = new a(this);
        this.f420349r = new b(this);
    }

    public void setCustomRepeatData(nab.a r100) {
        this.f420347p = r100;
        this.f420334c.f512741f = Boolean.valueOf(r100.f518488d);
        this.f420333b.f512752i = Boolean.valueOf(r100.f518487c);
        this.f420333b.f512753j = Boolean.valueOf(r100.f518489e);
        this.mChooseRepeatWeeksViewGroup.setChildViewClickable(!this.f420347p.f518488d);
    }

    public void setFirstDayOfWeek(CustomRepeatParams$DayOfWeek r100) {
        this.f420345n = r100;
        g r101 = this.f420333b;
        r101.f512751h = r100;
        r101.c();
        r101.d();
    }

    public void setOnCheckedListener(e r100) {
        this.f420339h = r100;
    }

    public CustomRepeatBottomContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f420332a = true;
        this.f420342k = 1;
        this.f420343l = 1;
        this.f420345n = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.f420347p = new nab.a();
        this.f420348q = new a(this);
        this.f420349r = new b(this);
    }

    public final void a(mab.c r100, d r101) {
        if (this.f420339h != null) goto L5;
        return;
    L5:
        int r102 = r100.getCount();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L12;
        if (r100.b(r104) == false) goto L10;
        r103.add(Integer.valueOf(r104));
        r101.a(true, r104);
    L11:
        r104 = r104 + 1;
        goto L6
    L10:
        r101.a(false, r104);
        goto L11
    L12:
        Collections.sort(r103);
        StringBuilder r105 = new StringBuilder();
        Iterator r106 = r103.iterator();
    L14:
        if (r106.hasNext() == false) goto L19;
        int r107 = ((Integer) r106.next()).intValue();
        if (r101 != null) goto L17;
        r105.append(r100.a(r107));
        r105.append(" ");
        goto L14
    L17:
        r105.append(r101.b(r100.a(r107)));
        r105.append(" ");
        goto L14
    L19:
        this.f420339h.e(r105.toString());
    }

    public final void d(CalendarDate r100, RepeatMode r101) {
        this.f420346o = r100;
        boolean r102 = false;
        if (this.f420333b == null) goto L40;
        if (r101 != null) goto L7;
    L11:
        boolean r103 = false;
    L12:
        int r104 = r100.getWeeklyDayIndex(this.f420345n);
        g r105 = this.f420333b;
        r105.f512738c = r104;
        if (this.f420347p.f518489e == true) goto L15;
        if (r103 == false) goto L15;
    L17:
        if (this.f420333b == null) goto L40;
        if (r101 == null) goto L40;
        if (r101.getRepeatType() != 8) goto L40;
        if (CollectionUtils.isNotEmpty(r101.getCustomerByWeekList()) == false) goto L40;
        Iterator<Integer> r106 = r101.getCustomerByWeekList().iterator();
    L26:
        if (r106.hasNext() == false) goto L40;
        int r107 = r106.next().intValue();
        int r108 = c.f420352a[this.f420345n.ordinal()];
        if (r108 != 1) goto L30;
        r107 = (r107 + 6) % 7;
    L34:
        if (r107 != r104) goto L38;
        if (this.f420333b.b(r104) == true) goto L26;
    L38:
        this.f420333b.e(r107);
        goto L26
    L30:
        if (r108 != 2) goto L34;
        r107 = (r107 + 1) % 7;
    L15:
        r105.e(r104);
        goto L17
    L7:
        if (r101.getRepeatType() != 8) goto L11;
        if (CollectionUtils.isNotEmpty(r101.getCustomerByWeekList()) == false) goto L11;
        r103 = true;
    L40:
        if (this.f420334c == null) goto L72;
        if (r101 != null) goto L44;
    L48:
        int r109 = r100.getMonthDay() - 1;
        mab.d r110 = this.f420334c;
        r110.f512738c = r109;
        if (this.f420347p.f518489e == true) goto L51;
        if (r102 == false) goto L51;
    L53:
        if (this.f420347p.f518488d == true) goto L72;
        if (this.f420334c == null) goto L72;
        if (r101 == null) goto L72;
        if (r101.getRepeatType() != 9) goto L72;
        if (CollectionUtils.isNotEmpty(r101.getCustomerByMonthDayList()) == false) goto L72;
        Iterator<Integer> r111 = r101.getCustomerByMonthDayList().iterator();
    L64:
        if (r111.hasNext() == false) goto L72;
        int r112 = r111.next().intValue() - 1;
        if (r112 != r109) goto L70;
        if (this.f420334c.b(r109) == true) goto L64;
    L70:
        this.f420334c.c(r112);
    L51:
        r110.c(r109);
        goto L53
    L44:
        if (r101.getRepeatType() != 9) goto L48;
        if (CollectionUtils.isNotEmpty(r101.getCustomerByMonthDayList()) == false) goto L48;
        r102 = true;
    L72:
        if (this.mRepeatWeekNoWheelView == null) goto L75;
        int r113 = ((int) Math.ceil(r100.getMonthDay() / 7.0f)) - 1;
        this.f420342k = r113;
        this.mRepeatWeekNoWheelView.setCurrentItem(r113);
    L75:
        if (this.mRepeatWeeksWheelView == null) goto L77;
        int r114 = r100.getWeekDay() - 1;
        this.f420343l = r114;
        this.mRepeatWeeksWheelView.setCurrentItem(r114);
    L77:
        this.f420338g = this.f420336e.b(this.f420343l);
        this.f420337f = this.f420335d.b(this.f420342k);
    }
}
