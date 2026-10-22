package com.bytedance.ee.bear.wikiv2.extension;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import xp5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends g {
    public msb.a b;
    public a.b c;

    public c(AppCompatActivity r1) {
        super(r1);
    }

    @Override // xp5.g
    public final void k(Intent r1) {
        m(r1);
    }

    @Override // xp5.g
    public final void l(Bundle r1) {
        m(getActivity().getIntent());
    }

    public final void m(Intent r6) {
        if (r6 != null) goto L5;
    L16:
        tt5.a.h("MultiTaskExtension", "URL not support multitask! ");
        return;
    L5:
        if (Boolean.valueOf(!fx4.a.a(r6.getStringExtra(ResourceData.KEY_URL))).booleanValue() == false) goto L16;
        StringBuilder r1 = new StringBuilder("init multitask. multitaskHelper?=");
        if (this.b != null) goto L10;
        boolean r3 = true;
    L11:
        r1.append(r3);
        tt5.a.h("MultiTaskExtension", r1.toString());
        msb.a r0 = this.b;
        if (r0 != null) goto L14;
        r6.putExtra("clear_res", false);
        a r2 = new a(getActivity(), r6);
        r2.b = new b(this);
        this.b = msb.a.a(r2);
        r6.putExtra("clear_res", true);
        return;
    L14:
        a r4 = new a(getActivity(), r6);
        r4.b = new b(this);
        r0.getClass();
        this.b = msb.a.d(r4);
        return;
    L10:
        r3 = false;
        goto L11
    }
}
