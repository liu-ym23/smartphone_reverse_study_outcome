package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StatusBarPlugin f414472a;

    public c(StatusBarPlugin r100) {
        this.f414472a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        StatusBarPlugin r102 = this.f414472a;
        Intrinsics.checkNotNull(r101);
        r102.f414449k = r101.intValue();
        if (r101.intValue() != 2) goto L14;
        ITitlebarComponent r103 = this.f414472a.f414446h;
        if (r103 == null) goto L7;
        TitleTheme r104 = r103.getTheme();
    L8:
        if (r104 == null) goto L15;
        StatusBarPlugin r105 = this.f414472a;
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
