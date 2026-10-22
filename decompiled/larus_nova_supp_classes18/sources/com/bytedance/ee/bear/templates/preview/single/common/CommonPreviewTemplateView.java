package com.bytedance.ee.bear.templates.preview.single.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.workspace.NewBaseEntry;
import com.bytedance.ee.bear.workspace.NewBaseType;
import com.bytedance.ee.bear.workspace.WorkspaceAction;
import com.bytedance.ee.util.ui.l;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommonPreviewTemplateView {
    public static final Lazy<List<String>> i = null;
    public LinearLayout a;
    public LinearLayout b;
    public ImageView c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public CommonTemplateViewModel h;

    public static final class a {
    }

    public CommonPreviewTemplateView() {
    }

    static {
        i = LazyKt.lazy(CommonPreviewTemplateView$Companion$bitableSourceList$2.INSTANCE);
    }

    public final void c(boolean r3) {
        if (r3 == false) goto L6;
        l.c(this.d, 2131102418);
        TextView r4 = this.f;
        if (r4 == null) goto L10;
        r4.setTextColor(r4.getResources().getColor(2131106622));
        return;
    L10:
        return;
    L6:
        l.c(this.d, 2131102416);
        TextView r5 = this.f;
        if (r5 == null) goto L12;
        r5.setTextColor(r5.getResources().getColor(2131106610));
        return;
    }

    public final void d(boolean r3) {
        if (r3 == false) goto L6;
        l.c(this.c, 2131102418);
        TextView r4 = this.e;
        if (r4 == null) goto L10;
        r4.setTextColor(r4.getResources().getColor(2131106622));
        return;
    L10:
        return;
    L6:
        l.c(this.c, 2131102416);
        TextView r5 = this.e;
        if (r5 == null) goto L12;
        r5.setTextColor(r5.getResources().getColor(2131106610));
        return;
    }

    public final void e(int r4) {
        CommonTemplateViewModel r0 = this.h;
        if (r0 == null) goto L21;
        List<Item> r1 = r0.getTemplates();
        if (r1 == null) goto L22;
        int r2 = r1.size();
        boolean r3 = false;
        if (r4 < 0) goto L19;
        if (r4 >= r2) goto L19;
        if (r4 >= (r2 - 1)) goto L13;
        boolean r5 = true;
    L14:
        c(r5);
        if (r4 <= 0) goto L17;
        r3 = true;
    L17:
        d(r3);
        return;
    L13:
        r5 = false;
    L19:
        c(false);
        d(false);
        return;
    L22:
        return;
    }

    public static final void a(CommonPreviewTemplateView r7, Context r8, boolean r9) {
        r7.getClass();
        er5.b r0 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        WorkspaceAction r2 = WorkspaceAction.NewTo;
        NewBaseEntry r10 = NewBaseEntry.TemplateCenter;
        if (r9 == false) goto L5;
        NewBaseType r11 = NewBaseType.Form;
    L7:
        if ((28 & 64) == 0) goto L9;
        NewBaseType r5 = null;
    L11:
        if ((28 & 128) == 0) goto L13;
        NewBaseEntry r6 = null;
    L14:
        r0.e(r8, r2, null, null, r5, r6);
        return;
    L13:
        r6 = r10;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r11 = NewBaseType.App;
        goto L7
    }

    public final void b(Context r2, ViewGroup r3, CommonTemplateViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        this.h = r4;
        View r5 = LayoutInflater.from(r2).inflate(2131559898, r3, true);
        Intrinsics.checkNotNull(r5);
        this.a = (LinearLayout) r5.findViewById(2131378805);
        this.b = (LinearLayout) r5.findViewById(2131378768);
        this.c = (ImageView) r5.findViewById(2131388825);
        this.d = (ImageView) r5.findViewById(2131388824);
        this.e = (TextView) r5.findViewById(2131388890);
        this.f = (TextView) r5.findViewById(2131388885);
        this.g = (TextView) r5.findViewById(2131391666);
        CommonTemplateViewModel r6 = this.h;
        if (r6 == null) goto L9;
        MutableLiveData<Integer> r7 = r6.getCurrTemplatePos();
        if (r7 == null) goto L9;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L9;
        int r9 = r8.intValue();
    L10:
        e(r9);
        TextView r10 = this.g;
        if (r10 == null) goto L13;
        r10.setOnClickListener(new com.bytedance.ee.bear.templates.preview.single.common.a(this));
    L13:
        LinearLayout r11 = this.a;
        if (r11 == null) goto L16;
        r11.setOnClickListener(new b(this));
    L16:
        LinearLayout r12 = this.b;
        if (r12 == null) goto L20;
        r12.setOnClickListener(new c(this));
        return;
    L20:
        return;
    L9:
        r9 = 0;
        goto L10
    }
}
