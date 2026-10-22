package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.myqrcode.OfficeMyQrCodeActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f419276a = null;

    static {
        f419276a = new h();
    }

    public h() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Lazy r101 = OfficeContactPageUtils.f418959a;
        Context r102 = r100.getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("invite", "from");
        int r103 = OfficeMyQrCodeActivity.f419318a;
        OfficeMyQrCodeActivity.a.a(r102, "invite");
    }
}
