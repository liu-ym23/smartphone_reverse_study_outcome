package com.ss.android.lark.contact.customized.myqrcode.view;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements ListenerParams.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeInviteExternalCardView f419334a;

    public b(OfficeInviteExternalCardView r100) {
        this.f419334a = r100;
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void a(Exception r100) {
        Log.i("Contact_InviteCardView", "onException: " + r100);
        Function2<? super Boolean, ? super DataSource, Unit> r101 = this.f419334a.f419321b;
        if (r101 == null) goto L6;
        r101.invoke(Boolean.FALSE, null);
        return;
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void b(Object r100, Object r101, DataSource r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "dataSource");
        Log.i("Contact_InviteCardView", "onResourceReady: " + r103);
        Function2<? super Boolean, ? super DataSource, Unit> r104 = this.f419334a.f419321b;
        if (r104 == null) goto L6;
        r104.invoke(Boolean.TRUE, r102);
        return;
    }
}
