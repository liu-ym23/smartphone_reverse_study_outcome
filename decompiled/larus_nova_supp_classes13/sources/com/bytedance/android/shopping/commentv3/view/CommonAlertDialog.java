package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.extensions.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/CommonAlertDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonAlertDialog extends AppCompatDialog {
    public View a;
    public TextView b;
    public TextView c;
    public View d;
    public View e;
    public TextView f;
    public View g;
    public TextView h;
    public final fc3.a i;
    public final Map<?, ?> j;
    public final Map<String, SlcCommonAction> k;
    public final Function1<Number, Integer> l;
    public final Function1<Number, Float> m;
    public final Function1<String, Unit> n;
    public final Function2<View, String, Unit> o;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonAlertDialog(Context r19, fc3.a r20, Map<?, ?> r21, Map<String, SlcCommonAction> r22, Function1<? super Number, Integer> r23, Function1<? super Number, Float> r24, Function1<? super String, Unit> r25, Function2<? super View, ? super String, Unit> r26) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r21, "fields");
        Intrinsics.checkNotNullParameter(r22, "nextActions");
        Intrinsics.checkNotNullParameter(r23, "slcDp");
        Intrinsics.checkNotNullParameter(r24, "slcSp");
        super(r19);
        this.i = r20;
        this.j = r21;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        setContentView(2131560410);
        this.a = findViewById(2131384822);
        this.b = (TextView) findViewById(2131388920);
        this.c = (TextView) findViewById(2131387558);
        this.d = findViewById(2131369197);
        this.e = findViewById(2131364437);
        this.f = (TextView) findViewById(2131365135);
        this.g = findViewById(2131364451);
        this.h = (TextView) findViewById(2131367674);
        View r7 = this.a;
        if (r7 == null) goto L7;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L7;
        r8.width = ((Number) r23.invoke(294)).intValue();
    L7:
        GradientDrawable r9 = new GradientDrawable();
        r9.setCornerRadius(((Number) r23.invoke(16)).intValue());
        int r10 = g1.a;
        r9.setColor(g1.a.a(getContext(), 2131109391));
        View r11 = this.a;
        if (r11 == null) goto L10;
        r11.setBackground(r9);
    L10:
        TextView r12 = this.b;
        if (r12 == null) goto L13;
        r12.setTextSize(((Number) r24.invoke(17)).floatValue());
    L13:
        TextView r13 = this.b;
        if (r13 == null) goto L16;
        nc3.b.b(r13, CollectionsKt.arrayListOf(new Integer[]{24, 0, 0, 0}), r23);
    L16:
        TextView r14 = this.c;
        if (r14 == null) goto L19;
        r14.setTextSize(((Number) r24.invoke(14)).floatValue());
    L19:
        TextView r15 = this.c;
        if (r15 == null) goto L22;
        nc3.b.b(r15, CollectionsKt.arrayListOf(new Integer[]{8, 20, 0, 20}), r23);
    L22:
        View r16 = this.d;
        if (r16 == null) goto L27;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L27;
        r17.height = ((Number) r23.invoke(Double.valueOf(0.5d))).intValue();
    L27:
        View r18 = this.d;
        if (r18 == null) goto L30;
        nc3.b.b(r18, CollectionsKt.arrayListOf(new Integer[]{24, 0, 0, 0}), r23);
    L30:
        View r27 = this.e;
        if (r27 == null) goto L35;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (r28 == null) goto L35;
        r28.height = ((Number) r23.invoke(48)).intValue();
    L35:
        TextView r29 = this.f;
        if (r29 == null) goto L38;
        r29.setTextSize(((Number) r24.invoke(15)).floatValue());
    L38:
        TextView r30 = this.h;
        if (r30 == null) goto L41;
        r30.setTextSize(((Number) r24.invoke(15)).floatValue());
    L41:
        View r5 = this.g;
        if (r5 == null) goto L46;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L46;
        r6.width = ((Number) r23.invoke(Double.valueOf(0.5d))).intValue();
    L46:
        TextView r4 = this.b;
        if (r4 == null) goto L49;
        f.e(r4, 500);
    L49:
        TextView r31 = this.h;
        if (r31 == null) goto L52;
        f.e(r31, 500);
    L52:
        Object r32 = r21.get("title");
        if ((r32 instanceof String) == true) goto L55;
        r32 = null;
    L55:
        String r33 = (String) r32;
        if (r33 == null) goto L60;
        TextView r34 = this.b;
        if (r34 == null) goto L60;
        r34.setText(r33);
    L60:
        Object r35 = r21.get("cancel_text");
        if ((r35 instanceof String) == true) goto L63;
        r35 = null;
    L63:
        String r36 = (String) r35;
        if (r36 == null) goto L68;
        TextView r37 = this.f;
        if (r37 == null) goto L68;
        r37.setText(r36);
    L68:
        Object r38 = r21.get("confirm_text");
        if ((r38 instanceof String) == true) goto L71;
        r38 = null;
    L71:
        String r39 = (String) r38;
        if (r39 == null) goto L76;
        TextView r40 = this.h;
        if (r40 == null) goto L76;
        r40.setText(r39);
    L76:
        Object r2 = r21.get("sub_title");
        if ((r2 instanceof String) == true) goto L79;
        r2 = null;
    L79:
        String r3 = (String) r2;
        if (r3 == null) goto L84;
        TextView r41 = this.c;
        if (r41 == null) goto L87;
        r41.setText(r3);
    L87:
        SlcCommonAction r42 = r22.get("show_action");
        if (r42 == null) goto L100;
        Window r43 = getWindow();
        if (r43 == null) goto L96;
        View r44 = r43.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L97;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r45 = ThreadMethodProxy.currentThread();
        if (r45 == com.larus.home.impl.utils.c.a) goto L97;
        com.larus.home.impl.utils.c.a(r45, "getDecorView");
    L97:
        r20.a(new fc3.c(r42, r44, null, 12));
        if (r25 == 0) goto L100;
        Unit r1 = (Unit) r25.invoke("show_action");
        goto L100
    L96:
        r44 = null;
    L100:
        TextView r46 = this.f;
        if (r46 == null) goto L103;
        r46.setOnClickListener(new b(this));
    L103:
        TextView r47 = this.h;
        if (r47 == null) goto L106;
        r47.setOnClickListener(new c(this));
    L106:
        Window r48 = getWindow();
        if (r48 == null) goto L110;
        r48.setBackgroundDrawableResource(2131106784);
        return;
    L110:
        return;
    L84:
        TextView r49 = this.c;
        if (r49 == null) goto L87;
        r49.setVisibility(8);
        goto L87
    }
}
