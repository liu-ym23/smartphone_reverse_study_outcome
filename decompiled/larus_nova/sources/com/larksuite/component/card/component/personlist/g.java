package com.larksuite.component.card.component.personlist;

import android.graphics.Color;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f283510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f283511b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f283512c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f283513d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f283514e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f283515f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f283516g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f283517h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f283518i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f283519j = 0;

    public g() {
    }

    static {
        f283510a = new g();
        f283511b = UIHelper.dp2px(16.0f);
        f283512c = UIHelper.dp2px(12.0f);
        f283513d = UIHelper.dp2px(4.0f);
        f283514e = UIHelper.dp2px(8.0f);
        UIHelper.dp2px(4.0f);
        f283515f = UIHelper.dp2px(32.0f);
        f283516g = UIHelper.dp2px(12.0f);
        f283517h = UIHelper.dp2px(10.0f);
        f283518i = UIHelper.dp2px(6.0f);
        f283519j = UIHelper.dp2px(3.0f);
    }

    public static int a(PersonListProps r100) {
        boolean r101 = false;
        Integer r102 = null;
        if (r100 == null) goto L15;
        PersonStyle r103 = r100.getStyles();
        if (r103 == null) goto L15;
        Integer r104 = Integer.valueOf(r103.getAvatarSpace());
        if (r104.intValue() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r104 = null;
    L13:
        if (r104 == null) goto L15;
        float r106 = zz7.b.j(UIHelper.dp2px(r104.intValue()));
    L29:
        return (int) r106;
    L9:
        r105 = false;
    L15:
        if (r100 == null) goto L27;
        PersonStyle r107 = r100.getStyles();
        if (r107 == null) goto L27;
        Integer r108 = Integer.valueOf(r107.getAvatarSize());
        int r109 = r108.intValue();
        if (r109 > 0) goto L21;
    L23:
        if (r101 == false) goto L25;
        r102 = r108;
    L25:
        if (r102 == null) goto L27;
        r102.intValue();
        r106 = zz7.b.j(f283519j);
        goto L29
    L21:
        if (r109 >= 32.0f) goto L23;
        r101 = true;
    L27:
        r106 = zz7.b.j(f283518i);
        goto L29
    }

    public static int b(PersonListProps r100) {
        if (r100 == null) goto L20;
        PersonStyle r101 = r100.getStyles();
        if (r101 == null) goto L20;
        String r102 = r101.getMoreColor();
        if (r102 == null) goto L20;
        if (r102.length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L20;
        return Color.parseColor(r102);
    L17:
        th = move-exception;
        Log.e("PersonListUtils", "parse more bg Color failed", th);
        goto L20
    L10:
        r103 = false;
    L20:
        return UIHelper.getColor(R.color.bg_filler);
    }

    public static int c(PersonListProps r100) {
        boolean r101 = false;
        Integer r102 = null;
        if (r100 == null) goto L15;
        PersonStyle r103 = r100.getStyles();
        if (r103 == null) goto L15;
        Integer r104 = Integer.valueOf(r103.getMoreMaxCount());
        if (r104.intValue() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r104 = null;
    L13:
        if (r104 == null) goto L15;
        return r104.intValue();
    L9:
        r105 = false;
    L15:
        if (r100 == null) goto L27;
        PersonStyle r106 = r100.getStyles();
        if (r106 == null) goto L27;
        Integer r107 = Integer.valueOf(r106.getAvatarSize());
        int r108 = r107.intValue();
        if (r108 > 0) goto L21;
    L23:
        if (r101 == false) goto L25;
        r102 = r107;
    L25:
        if (r102 == null) goto L27;
        r102.intValue();
        return 99;
    L21:
        if (r108 >= 32.0f) goto L23;
        r101 = true;
    L27:
        return 999;
    }

    public static int d(PersonListProps r100) {
        if (r100 == null) goto L14;
        PersonStyle r101 = r100.getStyles();
        if (r101 == null) goto L14;
        Integer r102 = Integer.valueOf(r101.getAvatarSize());
        if (r102.intValue() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L14;
        float r104 = zz7.b.j(UIHelper.dp2px(r102.intValue()));
    L16:
        return (int) r104;
    L8:
        r103 = false;
    L14:
        r104 = zz7.b.j(f283515f);
        goto L16
    }

    public static int e(PersonListProps r100) {
        boolean r101 = false;
        Integer r102 = null;
        if (r100 == null) goto L16;
        PersonStyle r103 = r100.getStyles();
        if (r103 == null) goto L16;
        Integer r104 = Integer.valueOf(r103.getMoreTextSize());
        if (r104.intValue() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r104 = null;
    L13:
        if (r104 == null) goto L16;
        return UIHelper.dp2px(r104.intValue());
    L9:
        r105 = false;
    L16:
        if (r100 == null) goto L30;
        PersonStyle r106 = r100.getStyles();
        if (r106 == null) goto L30;
        Integer r107 = Integer.valueOf(r106.getAvatarSize());
        int r108 = r107.intValue();
        if (r108 > 0) goto L22;
    L24:
        if (r101 == false) goto L26;
        r102 = r107;
    L26:
        if (r102 == null) goto L30;
        r102.intValue();
        return f283517h;
    L22:
        if (r108 >= 32.0f) goto L24;
        r101 = true;
    L30:
        return f283516g;
    }

    public static String f(PersonInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "person");
        String r101 = r100.getContent();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        String r103 = UIHelper.getString(R.string.Lark_CardCompt_UnknownUser);
        Intrinsics.checkNotNull(r103);
        return r103;
    L12:
        return r101;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static int g(PersonListProps r100) {
        if (r100 == null) goto L20;
        PersonStyle r101 = r100.getStyles();
        if (r101 == null) goto L20;
        String r102 = r101.getNameColor();
        if (r102 == null) goto L20;
        if (r102.length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L20;
        return Color.parseColor(r102);
    L17:
        th = move-exception;
        Log.e("PersonListUtils", "parse name Color failed", th);
        goto L20
    L10:
        r103 = false;
    L20:
        if (i(r100) == false) goto L23;
        return UIHelper.getColor(R.color.text_title);
    L23:
        return UIHelper.getColor(R.color.text_link_hover);
    }

    public static float h(PersonListProps r100) {
        if (r100 == null) goto L16;
        PersonStyle r101 = r100.getStyles();
        if (r101 == null) goto L16;
        Integer r102 = Integer.valueOf(r101.getNameSize());
        if (r102.intValue() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L16;
        return UIHelper.dp2px(zz7.b.j(r102.intValue()));
    L8:
        r103 = false;
    L16:
        if (i(r100) == false) goto L18;
        int r104 = UIHelper.dp2px(zz7.b.j(16));
    L20:
        return r104;
    L18:
        r104 = UIHelper.dp2px(zz7.b.j(14));
        goto L20
    }

    public static boolean i(PersonListProps r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L17;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (r100.getShowName() != true) goto L13;
        r102 = true;
        goto L14
    L17:
        return false;
    L5:
        if (r100.getShowAvatar() != true) goto L7;
        r101 = true;
        goto L8
    }
}
