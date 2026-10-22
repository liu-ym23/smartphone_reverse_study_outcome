package com.bytedance.ee.bear.more.view3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.h0;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f235055m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f235056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f235057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f235058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f235059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f235060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View.OnClickListener f235061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function2<Context, Integer, Drawable> f235062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f235063l;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.view3.ui.a$a, reason: collision with other inner class name */
    public static final class C3372a {
    }

    static {
    }

    public final int i(int r100, int r101) {
        if (this.f234904d != ItemUIStyle.DOUBAO) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return r100;
    L8:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    public final void g(AppCompatImageView r100, TextView r101, ImageView r110) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Intrinsics.checkNotNullParameter(r101, "titleView");
        h0 r102 = this.f234903c;
        if (r102 == null) goto L5;
        Integer r103 = r102.f234975a;
    L6:
        boolean r104 = false;
        if (r103 == null) goto L9;
    L58:
        int r105 = this.f235057f;
        if (r102 == null) goto L63;
        Integer r106 = r102.f234975a;
        if (r106 == null) goto L63;
        r105 = r106.intValue();
    L63:
        r100.setImageResource(r105);
    L64:
        String r107 = this.f235056e;
        Intrinsics.checkNotNullParameter(r107, "baselineTitle");
        h0 r108 = this.f234903c;
        if (r108 == null) goto L70;
        String r109 = r108.f234978d;
        if (r109 == null) goto L70;
        r107 = r109;
    L70:
        r101.setText(r107);
        int r111 = this.f235058g;
        h0 r112 = this.f234903c;
        if (r112 == null) goto L75;
        Integer r113 = r112.f234976b;
        if (r113 == null) goto L75;
        r111 = r113.intValue();
    L75:
        h0 r114 = this.f234903c;
        if (r114 == null) goto L80;
        Integer r115 = r114.f234977c;
        if (r115 == null) goto L80;
        int r116 = r115.intValue();
    L82:
        if (this.f235059h == false) goto L89;
        if (r104 == false) goto L85;
        r100.setImageTintList(null);
    L86:
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.text_title));
        if (r110 == null) goto L95;
        l.c(r110, r111);
        return;
    L95:
        return;
    L85:
        l.c(r100, r111);
        goto L86
    L89:
        l.c(r100, r116);
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.text_disable));
        if (r110 == null) goto L97;
        l.c(r110, r116);
        return;
    L97:
        return;
    L80:
        r116 = R.color.icon_disable;
        goto L82
    L9:
        if (this.f235062k == null) goto L58;
        ViewGroup.LayoutParams r117 = r100.getLayoutParams();
        if (r117 == null) goto L22;
        Integer r118 = Integer.valueOf(r117.width);
        if (r118.intValue() <= 0) goto L16;
        boolean r119 = true;
    L17:
        if (r119 == true) goto L20;
        r118 = null;
    L20:
        if (r118 == null) goto L22;
        int r120 = r118.intValue();
    L23:
        ViewGroup.LayoutParams r121 = r100.getLayoutParams();
        if (r121 == null) goto L34;
        Integer r122 = Integer.valueOf(r121.height);
        if (r122.intValue() <= 0) goto L28;
        boolean r123 = true;
    L29:
        if (r123 == true) goto L32;
        r122 = null;
    L32:
        if (r122 == null) goto L34;
        int r124 = r122.intValue();
    L35:
        int r125 = Math.max(r120, r124);
        if (r125 > 0) goto L93;
        Resources r126 = r100.getResources();
        r125 = RangesKt.coerceAtLeast((int) (24 * WindowDisplayMetricsOverride.apply(r126, r126.getDisplayMetrics()).density), 1);
    L93:
        Drawable r127 = this.f235062k.invoke(r100.getContext(), Integer.valueOf(r125));     // Catch: Throwable -> L41
    L43:
        if (r127 != null) goto L50;
        int r128 = this.f235057f;
        h0 r129 = this.f234903c;
        if (r129 == null) goto L49;
        Integer r130 = r129.f234975a;
        if (r130 == null) goto L49;
        r128 = r130.intValue();
    L49:
        r100.setImageResource(r128);
        goto L64
    L50:
        boolean r131 = DowngradeSettingUtil.a("downgradeDocsKnowledgeAIIconDrawableCache");
        if (r131 == false) goto L53;
        tt5.a.h("UIBaseMoreItem", "icon drawable cache downgrade hit, key=downgradeDocsKnowledgeAIIconDrawableCache");
    L53:
        if (r131 == false) goto L55;
    L56:
        r100.setImageDrawable(r127);
    L57:
        r104 = this.f235063l;
        goto L64
    L55:
        if (r100.getDrawable() == r127) goto L57;
    L41:
        th = move-exception;
        tt5.a.e("UIBaseMoreItem", "bind custom more icon fail, id=" + this.f234901a, th, false);
        r127 = null;
        goto L43
    L28:
        r123 = false;
    L34:
        r124 = 0;
        goto L35
    L16:
        r119 = false;
    L22:
        r120 = 0;
        goto L23
    L5:
        r103 = null;
        goto L6
    }

    public static void h(View r100, boolean r101, String r102, View.OnClickListener r103, View.OnClickListener r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 == false) goto L6;
        if (r103 == null) goto L17;
        r103.onClick(r100);
        return;
    L17:
        return;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r102.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Toast.showFailureText(r100.getContext(), r102, 0);
        return;
    L14:
        if (r104 == null) goto L20;
        r104.onClick(r100);
        return;
    L20:
        return;
    L11:
        r105 = false;
        goto L12
    }

    public /* synthetic */ a(String r110, String r111, int r112, int r113, boolean r114, String r115, View.OnClickListener r116) {
        this(r110, r111, r112, r113, r114, r115, r116, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, int r102, int r103, boolean r104, String r105, View.OnClickListener r106, Function2<? super Context, ? super Integer, ? extends Drawable> r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        super(r100);
        this.f235056e = r101;
        this.f235057f = r102;
        this.f235058g = r103;
        this.f235059h = r104;
        this.f235060i = r105;
        this.f235061j = r106;
        this.f235062k = r107;
        this.f235063l = r110;
    }
}
