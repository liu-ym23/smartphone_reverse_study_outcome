package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.secret.SearchableStatus;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements UDCheckBox.c {
    public final /* synthetic */ SecretLevel a;
    public final /* synthetic */ SecretLevelAdapter b;

    public s(SecretLevel r1, SecretLevelAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(UDCheckBox r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "buttonView");
        Log.i(SecretLevelAdapter.y2(), "setSearchTipsStatus: onCheckedChanged, isChecked = " + r4);
        SecretLevel r5 = this.a;
        if (r4 == false) goto L5;
        SearchableStatus r6 = SearchableStatus.SEARCHABLE;
    L6:
        r5.setSelectedSearch(Integer.valueOf(r6.getValue()));
        this.b.b.invoke(this.a);
        return;
    L5:
        r6 = SearchableStatus.NOT_SEARCHABLE;
        goto L6
    }
}
