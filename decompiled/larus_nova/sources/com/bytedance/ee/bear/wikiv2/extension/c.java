package com.bytedance.ee.bear.wikiv2.extension;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import xp5.g;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public msb.a f240696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a.b f240697c;

    public c(AppCompatActivity r100) {
        super(r100);
    }

    @Override // xp5.g
    public final void k(Intent r100) {
        m(r100);
    }

    @Override // xp5.g
    public final void l(Bundle r100) {
        m(getActivity().getIntent());
    }

    public final void m(Intent r100) {
        if (r100 != null) goto L5;
    L16:
        tt5.a.h("MultiTaskExtension", "URL not support multitask! ");
        return;
    L5:
        if (Boolean.valueOf(!fx4.a.a(r100.getStringExtra("url"))).booleanValue() == false) goto L16;
        StringBuilder r101 = new StringBuilder("init multitask. multitaskHelper?=");
        if (this.f240696b != null) goto L10;
        boolean r102 = true;
    L11:
        r101.append(r102);
        tt5.a.h("MultiTaskExtension", r101.toString());
        msb.a r103 = this.f240696b;
        if (r103 != null) goto L14;
        r100.putExtra("clear_res", false);
        a r104 = new a(getActivity(), r100);
        r104.f240694b = new b(this);
        this.f240696b = msb.a.a(r104);
        r100.putExtra("clear_res", true);
        return;
    L14:
        a r105 = new a(getActivity(), r100);
        r105.f240694b = new b(this);
        r103.getClass();
        this.f240696b = msb.a.d(r105);
        return;
    L10:
        r102 = false;
        goto L11
    }
}
