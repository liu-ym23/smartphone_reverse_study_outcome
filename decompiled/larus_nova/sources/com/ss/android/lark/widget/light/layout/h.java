package com.ss.android.lark.widget.light.layout;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f446160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f446161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f446162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.widget.light.viewstub.f f446163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f446164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f446165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f446166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Layout.Alignment f446167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f446168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f446169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f446170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f446171m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f446159a, r101.f446159a) == true) goto L12;
        return false;
    L12:
        if (this.f446160b == r101.f446160b) goto L15;
        return false;
    L15:
        if (this.f446161c == r101.f446161c) goto L18;
        return false;
    L18:
        if (this.f446162d == r101.f446162d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f446163e, r101.f446163e) == true) goto L24;
        return false;
    L24:
        if (this.f446164f == r101.f446164f) goto L27;
        return false;
    L27:
        if (Float.compare(this.f446165g, r101.f446165g) == 0) goto L30;
        return false;
    L30:
        if (this.f446166h == r101.f446166h) goto L33;
        return false;
    L33:
        if (this.f446167i == r101.f446167i) goto L36;
        return false;
    L36:
        if (Float.compare(this.f446168j, r101.f446168j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.f446169k, r101.f446169k) == 0) goto L42;
        return false;
    L42:
        if (this.f446170l == r101.f446170l) goto L45;
        return false;
    L45:
        if (this.f446171m == r101.f446171m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f446159a.hashCode() * 31) + this.f446160b) * 31;
        int r101 = 1231;
        if (this.f446161c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f446162d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((((((((((((r103 + r104) * 31) + this.f446163e.hashCode()) * 31) + this.f446164f) * 31) + Float.floatToIntBits(this.f446165g)) * 31) + this.f446166h) * 31) + this.f446167i.hashCode()) * 31) + Float.floatToIntBits(this.f446168j)) * 31) + Float.floatToIntBits(this.f446169k)) * 31;
        if (this.f446170l == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f446171m == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TextLayoutBuildConfig(context=" + this.f446159a + ", maxWidth=" + this.f446160b + ", isFlag=" + this.f446161c + ", isSingleLine=" + this.f446162d + ", spanViewCoordinator=" + this.f446163e + ", textColor=" + this.f446164f + ", textSize=" + this.f446165g + ", extraWidth=" + this.f446166h + ", textAlignment=" + this.f446167i + ", spacingExtra=" + this.f446168j + ", textSpacingMultiplier=" + this.f446169k + ", canCacheLayout=" + this.f446170l + ", shouldWarmText=" + this.f446171m + ')';
    }

    public final Context getContext() {
        return this.f446159a;
    }

    public final void a(TextLayoutBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "textLayoutBuilder");
        r100.f446127c.f446150s = this.f446163e;
        r100.j((int) this.f446165g);
        r100.i(this.f446164f);
        r100.f(this.f446160b);
        r100.l(this.f446169k);
        boolean r101 = this.f446162d;
        TextLayoutBuilder.a r102 = r100.f446127c;
        TextUtils.TruncateAt r103 = null;
        if (r102.f446144m == r101) goto L5;
        r102.f446144m = r101;
        r100.f446128d = null;
    L5:
        int r104 = h18.e.f483540a;
        r100.m(h18.e.b(this.f446159a, 0));
        if (this.f446162d == false) goto L8;
        r103 = TextUtils.TruncateAt.END;
    L8:
        r100.d(r103);
        r100.f446131g = this.f446171m;
        r100.c(this.f446167i);
        r100.f446129e = new a();
        r100.k(this.f446168j);
        r100.f446130f = this.f446170l;
        r100.f446127c.f446134c = this.f446166h;
        if (idb.f.a().isCurrentEnable("disable_rich_text_refactor_unexpect_build") == false) goto L12;
        r100.a();
        return;
    }

    public h(Context r110, int r111, int r112, float r210, int r211) {
        if ((r211 & 2) == 0) goto L5;
        int r100 = Integer.MAX_VALUE;
    L6:
        Layout.Alignment r101 = null;
        if ((r211 & 16) == 0) goto L9;
        com.ss.android.lark.widget.light.viewstub.f.f446339a.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.lark.widget.light.viewstub.e r102 = new com.ss.android.lark.widget.light.viewstub.e(r110);
    L11:
        if ((r211 & 32) == 0) goto L13;
        int r103 = UIUtils.getColor(r110, R.color.text_title);
    L15:
        if ((r211 & 64) == 0) goto L17;
        float r104 = UIUtils.dp2px(r110, 17.0f);
    L19:
        if ((r211 & 128) == 0) goto L21;
        int r105 = UIUtils.dp2px(r110, 2.5f);
    L23:
        if ((r211 & 256) == 0) goto L25;
        r101 = Layout.Alignment.ALIGN_NORMAL;
    L25:
        Layout.Alignment r113 = r101;
        float r114 = 0.0f;
        if ((r211 & 512) == 0) goto L28;
        float r115 = UIHelper.dp2px(2.5f);
    L30:
        if ((r211 & 1024) == 0) goto L32;
        r114 = 1.0f;
    L32:
        boolean r116 = true;
        if ((r211 & 2048) == 0) goto L35;
        boolean r117 = true;
    L37:
        if ((r211 & 4096) != 0) goto L40;
        r116 = false;
    L40:
        this(r110, r100, false, false, r102, r103, r104, r105, r113, r115, r114, r117, r116);
        return;
    L35:
        r117 = false;
        goto L37
    L28:
        r115 = 0.0f;
        goto L30
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r100 = r111;
        goto L6
    }

    public h(Context r100, int r101, boolean r102, boolean r103, com.ss.android.lark.widget.light.viewstub.f r104, int r105, float r106, int r107, Layout.Alignment r110, float r111, float r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "spanViewCoordinator");
        Intrinsics.checkNotNullParameter(r110, "textAlignment");
        this.f446159a = r100;
        this.f446160b = r101;
        this.f446161c = r102;
        this.f446162d = r103;
        this.f446163e = r104;
        this.f446164f = r105;
        this.f446165g = r106;
        this.f446166h = r107;
        this.f446167i = r110;
        this.f446168j = r111;
        this.f446169k = r112;
        this.f446170l = r113;
        this.f446171m = r114;
    }
}
