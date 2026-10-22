package com.ss.android.lark.todo.impl.features.detail.at.view;

import android.text.TextUtils;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtSelectAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements AtSelectAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAtView f442818a;

    public e(TodoAtView r100) {
        this.f442818a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtSelectAdapter.b
    public final void a(f8c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        this.f442818a.S5();
        if (TextUtils.isEmpty(r100.f475939d) == true) goto L6;
        String r101 = r100.f475939d;
    L16:
        this.f442818a.getDependency().b(r100.f475937b, r101);
        return;
    L6:
        if (TextUtils.isEmpty(r100.f475940e) == true) goto L11;
        if (this.f442818a.f442795j != GetAnotherNameFormatResponse.FormatRule.NAME_FIRST) goto L11;
        r101 = r100.f475938c + '(' + r100.f475940e + ')';
    L11:
        if (TextUtils.isEmpty(r100.f475940e) == false) goto L13;
    L15:
        r101 = r100.f475938c;
        goto L16
    L13:
        if (this.f442818a.f442795j != GetAnotherNameFormatResponse.FormatRule.ANOTHER_NAME_FIRST) goto L15;
        r101 = r100.f475940e + '(' + r100.f475938c + ')';
        goto L16
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtSelectAdapter.b
    public final String b(f8c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        if (TextUtils.isEmpty(r100.f475939d) == true) goto L12;
        if (this.f442818a.f442795j != GetAnotherNameFormatResponse.FormatRule.ANOTHER_NAME_FIRST) goto L10;
        if (TextUtils.isEmpty(r100.f475940e) == true) goto L10;
        return r100.f475939d + '(' + r100.f475940e + ')';
    L10:
        return r100.f475939d + '(' + r100.f475938c + ')';
    L12:
        if (TextUtils.isEmpty(r100.f475940e) == true) goto L19;
        if (this.f442818a.f442795j != GetAnotherNameFormatResponse.FormatRule.ANOTHER_NAME_FIRST) goto L17;
        return r100.f475940e + '(' + r100.f475938c + ')';
    L17:
        return r100.f475938c + '(' + r100.f475940e + ')';
    L19:
        return r100.f475938c;
    }
}
