package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 {
    public final Fragment a;
    public final String b;
    public final e3 c;
    public final String d;
    public final WikiTreeCtrlView.c e;
    public final ViewModelStoreOwner f;
    public final String g;
    public boolean h;
    public final ce5.a i;

    public /* synthetic */ f1(Fragment r9, String r10, String r11, WikiTreeCtrlView.c r12, ce5.a r13) {
        this(r9, r10, r11, r12, null, null, r13);
    }

    public f1(Fragment r2, String r3, String r4, WikiTreeCtrlView.c r5, ViewModelStoreOwner r6, String r7, ce5.a r8) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r8, "userComponentAbility");
        this.b = "";
        this.e = new WikiTreeCtrlView.c();
        this.h = true;
        this.a = r2;
        this.b = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.i = r8;
    }

    public f1(Fragment r2, e3 r3, String r4, WikiTreeCtrlView.c r5, ViewModelStoreOwner r6, String r7, ce5.a r8) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r8, "userComponentAbility");
        this.b = "";
        this.e = new WikiTreeCtrlView.c();
        this.h = true;
        this.a = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.i = r8;
    }
}
