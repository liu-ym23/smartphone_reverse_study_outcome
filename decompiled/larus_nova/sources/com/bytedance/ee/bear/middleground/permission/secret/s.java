package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.secret.SearchableStatus;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SecretLevel f234130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SecretLevelAdapter f234131b;

    public s(SecretLevel r100, SecretLevelAdapter r101) {
        this.f234130a = r100;
        this.f234131b = r101;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        Log.i(SecretLevelAdapter.y2(), "setSearchTipsStatus: onCheckedChanged, isChecked = " + r101);
        SecretLevel r102 = this.f234130a;
        if (r101 == false) goto L5;
        SearchableStatus r103 = SearchableStatus.SEARCHABLE;
    L6:
        r102.setSelectedSearch(Integer.valueOf(r103.getValue()));
        this.f234131b.f233949b.invoke(this.f234130a);
        return;
    L5:
        r103 = SearchableStatus.NOT_SEARCHABLE;
        goto L6
    }
}
