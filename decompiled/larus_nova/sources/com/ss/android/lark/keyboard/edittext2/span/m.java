package com.ss.android.lark.keyboard.edittext2.span;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import sz7.q;

/* JADX INFO: loaded from: classes36.dex */
public final class m extends CharacterStyle implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f429227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f429228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f429229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f429230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpannableStringBuilder f429231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f429232f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f429233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f429234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f429235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f429236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f429237e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f429238f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f429239g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f429240h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f429241i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f429242j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f429243k;

        public final Context getContext() {
            return this.f429236d;
        }

        public /* synthetic */ a(Context r110, String r111, String r112, String r113) {
            this(r110, r111, r112, 0, r113, null, null, false);
        }

        public a(Context r100, String r101, String r102, int r103, String r104, String r105, String r106, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r102, "href");
            this.f429233a = UIHelper.getColor(R.color.text_link_normal);
            this.f429234b = UIHelper.getColor(R.color.text_link_normal);
            this.f429235c = UIHelper.getDimens(R.dimen.dp_14);
            this.f429237e = "";
            this.f429238f = "";
            if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L5;
            int r107 = R.drawable.ud_icon_link_copy_filled;
        L6:
            this.f429240h = r107;
            this.f429236d = r100;
            UDIconUtils.getIconDrawable(r100, r107, this.f429234b);
            this.f429237e = r101;
            this.f429238f = r102;
            this.f429239g = r104;
            if (r103 == 0) goto L9;
            this.f429240h = r103;
        L9:
            this.f429241i = r105;
            this.f429242j = r106;
            this.f429243k = r110;
            return;
        L5:
            r107 = R.drawable.ud_icon_link_copy_outlined;
            goto L6
        }
    }

    public final Context getContext() {
        return this.f429227a;
    }

    public m(a r110) {
        Context r100 = r110.getContext();
        String r101 = r110.f429237e;
        String r102 = r110.f429238f;
        int r103 = r110.f429233a;
        int r104 = r110.f429234b;
        this.f429227a = r100;
        this.f429228b = r101;
        this.f429229c = r102;
        this.f429230d = r103;
        q r105 = new q(r100, false);
        this.f429232f = r105;
        Drawable r111 = UDIconUtils.getIconDrawable(r100, r110.f429240h, r103, new UDDimension.a(r110.f429235c));
        String r106 = r110.f429239g;
        String r107 = r110.f429241i;
        String r108 = r110.f429242j;
        boolean r109 = r110.f429243k;
        if (r107 != null) goto L5;
    L8:
        boolean r112 = true;
    L9:
        if (r112 == true) goto L11;
        int r113 = 1;
        Integer[] r114 = sbb.d.f541292a;
        String r115 = r110.f429241i;
        if (r115 != null) goto L52;
        r115 = "";
    L52:
        BitmapDrawable r116 = new BitmapDrawable(sbb.d.a(r115));
        int r117 = r110.f429235c;
        r116.setBounds(0, 0, r117, r117);
        d r118 = new d(r116);
    L53:
        SpannableStringBuilder r119 = new SpannableStringBuilder("$" + r101 + " \u200b");
        this.f429231e = r119;
        r119.setSpan(r118, 0, r113, 33);
        Intrinsics.checkNotNull(r119);
        r119.setSpan(this, 0, r119.length(), 33);
        return;
    L11:
        if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L38;
        if (r109 == false) goto L28;
        if (r106 != null) goto L15;
    L18:
        boolean r120 = true;
    L19:
        if (r120 == false) goto L28;
        if (r108 != null) goto L22;
    L25:
        boolean r121 = true;
    L26:
        if (r121 == false) goto L35;
    L36:
        boolean r122 = false;
    L37:
        r105.f544019l = r122;
    L35:
        r122 = true;
        goto L37
    L22:
        if (r108.length() == 0) goto L25;
        r121 = false;
        goto L26
    L15:
        if (r106.length() == 0) goto L18;
        r120 = false;
    L28:
        if (r106 != null) goto L30;
    L33:
        boolean r123 = true;
    L34:
        if (r123 == true) goto L36;
    L30:
        if (r106.length() == 0) goto L33;
        r123 = false;
    L38:
        if (r109 == false) goto L47;
        if (r106 != null) goto L41;
    L44:
        boolean r124 = true;
    L45:
        if (r124 == false) goto L47;
        int r125 = r110.f429235c;
        r105.b(r108, r125, r125, r111, false, Integer.valueOf(r104));
        r113 = 1;
    L48:
        int r126 = r110.f429235c;
        r105.setBounds(0, 0, r126, r126);
        r118 = new d(r105);
        goto L53
    L41:
        if (r106.length() == 0) goto L44;
        r124 = false;
    L47:
        int r127 = r110.f429235c;
        r113 = 1;
        q.d(r105, r106, null, r127, r127, r111, false, Integer.valueOf(r104));
        goto L48
    L5:
        if (r107.length() == 0) goto L8;
        r112 = false;
        goto L9
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(this.f429230d);
        r100.setUnderlineText(false);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r100, int r101, Editable r102) {
        return f.a.a(this, r100, r101, r102);
    }
}
