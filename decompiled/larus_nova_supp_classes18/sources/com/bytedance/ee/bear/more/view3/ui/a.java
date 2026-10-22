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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.l;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a extends k {
    public static final /* synthetic */ int m = 0;
    public final String e;
    public final int f;
    public final int g;
    public final boolean h;
    public final String i;
    public final View.OnClickListener j;
    public final Function2<Context, Integer, Drawable> k;
    public final boolean l;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.view3.ui.a$a, reason: collision with other inner class name */
    public static final class C0125a {
    }

    static {
    }

    public final int i(int r3, int r4) {
        if (this.d != ItemUIStyle.DOUBAO) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r3;
    L8:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    public final void g(AppCompatImageView r8, TextView r9, ImageView r10) {
        Intrinsics.checkNotNullParameter(r8, "iconView");
        Intrinsics.checkNotNullParameter(r9, "titleView");
        h0 r1 = this.c;
        if (r1 == null) goto L5;
        Integer r3 = r1.a;
    L6:
        boolean r4 = false;
        if (r3 == null) goto L9;
    L58:
        int r0 = this.f;
        if (r1 == null) goto L63;
        Integer r2 = r1.a;
        if (r2 == null) goto L63;
        r0 = r2.intValue();
    L63:
        r8.setImageResource(r0);
    L64:
        String r5 = this.e;
        Intrinsics.checkNotNullParameter(r5, "baselineTitle");
        h0 r6 = this.c;
        if (r6 == null) goto L70;
        String r7 = r6.d;
        if (r7 == null) goto L70;
        r5 = r7;
    L70:
        r9.setText(r5);
        int r11 = this.g;
        h0 r12 = this.c;
        if (r12 == null) goto L75;
        Integer r13 = r12.b;
        if (r13 == null) goto L75;
        r11 = r13.intValue();
    L75:
        h0 r14 = this.c;
        if (r14 == null) goto L80;
        Integer r15 = r14.c;
        if (r15 == null) goto L80;
        int r16 = r15.intValue();
    L82:
        if (this.h == false) goto L89;
        if (r4 == false) goto L85;
        r8.setImageTintList(null);
    L86:
        r9.setTextColor(ContextCompat.getColor(r9.getContext(), 2131106622));
        if (r10 == null) goto L95;
        l.c(r10, r11);
        return;
    L95:
        return;
    L85:
        l.c(r8, r11);
        goto L86
    L89:
        l.c(r8, r16);
        r9.setTextColor(ContextCompat.getColor(r9.getContext(), 2131106610));
        if (r10 == null) goto L97;
        l.c(r10, r16);
        return;
    L97:
        return;
    L80:
        r16 = 2131102416;
        goto L82
    L9:
        if (this.k == null) goto L58;
        ViewGroup.LayoutParams r17 = r8.getLayoutParams();
        if (r17 == null) goto L22;
        Integer r18 = Integer.valueOf(r17.width);
        if (r18.intValue() <= 0) goto L16;
        boolean r19 = true;
    L17:
        if (r19 == true) goto L20;
        r18 = null;
    L20:
        if (r18 == null) goto L22;
        int r20 = r18.intValue();
    L23:
        ViewGroup.LayoutParams r21 = r8.getLayoutParams();
        if (r21 == null) goto L34;
        Integer r22 = Integer.valueOf(r21.height);
        if (r22.intValue() <= 0) goto L28;
        boolean r23 = true;
    L29:
        if (r23 == true) goto L32;
        r22 = null;
    L32:
        if (r22 == null) goto L34;
        int r24 = r22.intValue();
    L35:
        int r25 = Math.max(r20, r24);
        if (r25 > 0) goto L93;
        Resources r26 = r8.getResources();
        r25 = RangesKt.coerceAtLeast((int) (24 * WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics()).density), 1);
    L93:
        Drawable r27 = (Drawable) this.k.invoke(r8.getContext(), Integer.valueOf(r25));     // Catch: Throwable -> L41
    L43:
        if (r27 != null) goto L50;
        int r28 = this.f;
        h0 r29 = this.c;
        if (r29 == null) goto L49;
        Integer r30 = r29.a;
        if (r30 == null) goto L49;
        r28 = r30.intValue();
    L49:
        r8.setImageResource(r28);
        goto L64
    L50:
        boolean r31 = DowngradeSettingUtil.a("downgradeDocsKnowledgeAIIconDrawableCache");
        if (r31 == false) goto L53;
        tt5.a.h("UIBaseMoreItem", "icon drawable cache downgrade hit, key=downgradeDocsKnowledgeAIIconDrawableCache");
    L53:
        if (r31 == false) goto L55;
    L56:
        r8.setImageDrawable(r27);
    L57:
        r4 = this.l;
        goto L64
    L55:
        if (r8.getDrawable() == r27) goto L57;
    L41:
        th = move-exception;
        tt5.a.e("UIBaseMoreItem", "bind custom more icon fail, id=" + this.a, th, false);
        r27 = null;
        goto L43
    L28:
        r23 = false;
    L34:
        r24 = 0;
        goto L35
    L16:
        r19 = false;
    L22:
        r20 = 0;
        goto L23
    L5:
        r3 = null;
        goto L6
    }

    public static void h(View r1, boolean r2, String r3, View.OnClickListener r4, View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r2 == false) goto L6;
        if (r4 == null) goto L17;
        r4.onClick(r1);
        return;
    L17:
        return;
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r3.length() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r3, "reason");
        Toast.showFailureText(r1.getContext(), r3, 0);
        return;
    L14:
        if (r5 == null) goto L20;
        r5.onClick(r1);
        return;
    L20:
        return;
    L11:
        r6 = false;
        goto L12
    }

    public /* synthetic */ a(String r11, String r12, int r13, int r14, boolean r15, String r16, View.OnClickListener r17) {
        this(r11, r12, r13, r14, r15, r16, r17, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, String r3, int r4, int r5, boolean r6, String r7, View.OnClickListener r8, Function2<? super Context, ? super Integer, ? extends Drawable> r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "title");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
    }
}
