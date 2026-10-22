package mab;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import java.util.Arrays;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String[] f512748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f512749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f512750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CustomRepeatParams$DayOfWeek f512751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f512752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f512753j;

    public final void c() {
        CustomRepeatParams$DayOfWeek r100 = this.f512751h;
        if (r100 != CustomRepeatParams$DayOfWeek.MONDAY) goto L6;
        this.f512748e = this.f512737b.getResources().getStringArray(R.array.custom_repeat_weekly);
        return;
    L6:
        if (r100 != CustomRepeatParams$DayOfWeek.SATURDAY) goto L8;
        this.f512748e = this.f512737b.getResources().getStringArray(R.array.saturday_first_repeat_weekly);
        return;
    L8:
        this.f512748e = this.f512737b.getResources().getStringArray(R.array.sunday_first_repeat_weekly);
    }

    public final void d() {
        CustomRepeatParams$DayOfWeek r100 = this.f512751h;
        if (r100 != CustomRepeatParams$DayOfWeek.MONDAY) goto L10;
        int r101 = 0;
    L5:
        int[] r102 = this.f512749f;
        if (r101 >= r102.length) goto L8;
        r102[r101] = r101;
        r101 = r101 + 1;
        goto L5
    L8:
        int[] r103 = this.f512750g;
        r103[0] = 5;
        r103[1] = 6;
        return;
    L10:
        if (r100 != CustomRepeatParams$DayOfWeek.SATURDAY) goto L16;
        int r104 = 0;
    L12:
        int[] r105 = this.f512749f;
        if (r104 >= r105.length) goto L15;
        r105[r104] = r104 + 2;
        r104 = r104 + 1;
        goto L12
    L15:
        int[] r106 = this.f512750g;
        r106[0] = 0;
        r106[1] = 1;
        return;
    L16:
        int r107 = 0;
    L17:
        int[] r108 = this.f512749f;
        if (r107 >= r108.length) goto L20;
        int r109 = r107 + 1;
        r108[r107] = r109;
        r107 = r109;
        goto L17
    L20:
        int[] r110 = this.f512750g;
        r110[0] = 0;
        r110[1] = 6;
    }

    @Override // mab.c, android.widget.Adapter
    public final int getCount() {
        if (this.f512748e != null) goto L12;
        CustomRepeatParams$DayOfWeek r100 = this.f512751h;
        if (r100 != CustomRepeatParams$DayOfWeek.MONDAY) goto L8;
        this.f512748e = this.f512737b.getResources().getStringArray(R.array.custom_repeat_weekly);
        goto L12
    L8:
        if (r100 != CustomRepeatParams$DayOfWeek.SATURDAY) goto L10;
        this.f512748e = this.f512737b.getResources().getStringArray(R.array.saturday_first_repeat_weekly);
        goto L12
    L10:
        this.f512748e = this.f512737b.getResources().getStringArray(R.array.sunday_first_repeat_weekly);
    L12:
        return this.f512748e.length;
    }

    @Override // mab.c
    public final String a(int r100) {
        if (r100 < 0) goto L7;
        String[] r101 = this.f512748e;
        if (r100 < r101.length) goto L6;
        return "";
    L6:
        return r101[r100];
    L7:
        return "";
    }

    @Override // mab.c
    public final boolean b(int r100) {
        if (r100 >= 0) goto L4;
        return false;
    L4:
        if (r100 < 7) goto L6;
        return false;
    L6:
        return this.f512736a[r100];
    }

    public final void e(int r110) {
        if (r110 < 0) goto L67;
        boolean[] r100 = this.f512736a;
        if (r110 >= r100.length) goto L68;
        boolean r101 = !r100[r110];
        r100[r110] = r101;
        boolean r102 = false;
        if (r110 != 7) goto L16;
        int[] r111 = this.f512749f;
        int r103 = this.f512738c;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L41;
        int r106 = r111[r105];
        if (this.f512753j.booleanValue() == false) goto L13;
        if (r106 != r103) goto L13;
    L14:
        r105 = r105 + 1;
    L13:
        this.f512736a[r106] = r101;
    L41:
        if (this.f512752i.booleanValue() == false) goto L53;
        int r112 = 0;
    L44:
        boolean[] r107 = this.f512736a;
        if (r112 >= r107.length) goto L50;
        if (r107[r112] == true) goto L51;
        r112 = r112 + 1;
    L51:
        if (r102 == false) goto L53;
        r107[this.f512738c] = true;
        goto L53
    L50:
        r102 = true;
    L53:
        notifyDataSetChanged();
        return;
    L16:
        if (r110 != 8) goto L25;
        int[] r113 = this.f512750g;
        int r108 = this.f512738c;
        int r109 = r113.length;
        int r114 = 0;
    L18:
        if (r114 >= r109) goto L41;
        int r115 = r113[r114];
        if (this.f512753j.booleanValue() == false) goto L23;
        if (r115 != r108) goto L23;
    L24:
        r114 = r114 + 1;
    L23:
        this.f512736a[r115] = r101;
        goto L24
    L25:
        int[] r116 = this.f512749f;
        int r117 = r116.length;
        int r118 = 0;
    L26:
        if (r118 >= r117) goto L31;
        if (this.f512736a[r116[r118]] == false) goto L29;
        r118 = r118 + 1;
        goto L26
    L29:
        boolean r119 = false;
    L32:
        r100[7] = r119;
        boolean[] r120 = this.f512736a;
        int[] r121 = this.f512750g;
        int r122 = r121.length;
        int r123 = 0;
    L33:
        if (r123 >= r122) goto L38;
        if (this.f512736a[r121[r123]] == false) goto L36;
        r123 = r123 + 1;
        goto L33
    L36:
        boolean r124 = false;
    L39:
        r120[8] = r124;
        goto L41
    L38:
        r124 = true;
        goto L39
    L31:
        r119 = true;
        goto L32
    L68:
        return;
    }

    public g(Context r100, int r101, CustomRepeatParams$DayOfWeek r102) {
        super(r100, 3, r101);
        this.f512749f = new int[5];
        this.f512750g = new int[2];
        Boolean r103 = Boolean.FALSE;
        this.f512752i = r103;
        this.f512753j = r103;
        boolean[] r104 = new boolean[this.f512748e.length];
        this.f512736a = r104;
        Arrays.fill(r104, false);
        this.f512751h = r102;
        c();
        d();
    }
}
