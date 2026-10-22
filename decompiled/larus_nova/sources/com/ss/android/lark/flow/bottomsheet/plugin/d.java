package com.ss.android.lark.flow.bottomsheet.plugin;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowStatusBarPlugin f422019a;

    public d(FlowStatusBarPlugin r100) {
        this.f422019a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        FlowStatusBarPlugin r102 = this.f422019a;
        Intrinsics.checkNotNull(r101);
        r102.f422010m = r101.intValue();
        if (r101.intValue() != 2) goto L14;
        ITitlebarComponent r103 = this.f422019a.f422007j;
        if (r103 == null) goto L7;
        TitleTheme r104 = r103.getTheme();
    L8:
        if (r104 == null) goto L15;
        FlowStatusBarPlugin r105 = this.f422019a;
        Integer r106 = r104.f415367b;
        if (r106 == null) goto L12;
        r105.F(r104.getType(), r106);
        return;
    L12:
        r105.F(r104.getType(), null);
        return;
    L15:
        return;
    L7:
        r104 = null;
        goto L8
    }
}
