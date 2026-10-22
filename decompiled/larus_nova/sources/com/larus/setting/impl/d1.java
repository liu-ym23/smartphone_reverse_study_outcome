package com.larus.setting.impl;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.nova.R;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.setting.impl.databinding.LarusPageNotifySettingBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class d1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotifySettingsFragment f368125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f368126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LarusPageNotifySettingBinding f368127c;

    public /* synthetic */ d1(NotifySettingsFragment r100, int r101, LarusPageNotifySettingBinding r102) {
        this.f368125a = r100;
        this.f368126b = r101;
        this.f368127c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        NotifySettingsFragment r100 = this.f368125a;
        int r101 = this.f368126b;
        LarusPageNotifySettingBinding r102 = this.f368127c;
        List r111 = (List) r110;
        int r103 = NotifySettingsFragment.f367980j;
        Intrinsics.checkNotNullParameter(r111, "sections");
        LarusPageNotifySettingBinding r104 = r100.f367981e;
        if (r101 != r100.f367984h) goto L16;
        if (r104 != r102) goto L16;
        Context r105 = r104.f368177a.getContext();
        r104.f368178b.removeAllViews();
        Iterator r112 = r111.iterator();
    L8:
        if (r112.hasNext() == false) goto L19;
        zs9.c r106 = (zs9.c) r112.next();
        LinearLayout r107 = new LinearLayout(r105);
        r107.setOrientation(1);
        r107.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r107.setPadding(0, j19.c.c(8), 0, 0);
        TextView r108 = new TextView(r105);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-1, -2);
        r109.setMargins(0, 0, 0, j19.c.c(8));
        r108.setLayoutParams(r109);
        r108.setText(r106.f573499b);
        r108.setTextSize(16.0f);
        r108.setTextColor(r105.getResources().getColor(R.color.larus_neutral_50));
        r108.setPadding(j19.c.c(4), 0, j19.c.c(4), 0);
        Intrinsics.checkNotNull(r105);
        ItemGroup r113 = new ItemGroup(r105);
        r113.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Iterator<zs9.b> r114 = r106.f573500c.iterator();
    L11:
        if (r114.hasNext() == false) goto L13;
        zs9.b r115 = r114.next();
        int r116 = et9.d.f473956a;
        et9.d.a(FlowSettingsScene.NOTIFY, r113, r115);
        goto L11
    L13:
        r107.addView(r108);
        r107.addView(r113);
        r104.f368178b.addView(r107);
        goto L8
    L19:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    }
}
