package com.larus.larkfeed.impl.gallery;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements kza.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkImageView f355219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.common_ui.dialog.l0 f355220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f355221c;

    @Override // kza.j
    public final void onLoadSuccess() {
        FLogger.f375446a.i("LarkImageView", "loadOrigin success");
        LarkImageView r100 = this.f355219a;
        com.larus.common_ui.dialog.l0 r101 = this.f355220b;
        int r102 = LarkImageView.f355169o;
        r100.d(r101);
        Function1<Boolean, Unit> r103 = this.f355221c;
        if (r103 == null) goto L6;
        r103.invoke(Boolean.TRUE);
        return;
    }

    @Override // kza.j
    public final void a(String r100) {
        FLogger.f375446a.i("LarkImageView", "loadOrigin failed, errorCode: -1, errorMsg: ".concat(r100));
        LarkImageView r101 = this.f355219a;
        com.larus.common_ui.dialog.l0 r102 = this.f355220b;
        int r103 = LarkImageView.f355169o;
        r101.d(r102);
        Function1<Boolean, Unit> r104 = this.f355221c;
        if (r104 == null) goto L6;
        r104.invoke(Boolean.FALSE);
        return;
    }

    public h(LarkImageView r100, com.larus.common_ui.dialog.l0 r101, f0 r102) {
        this.f355219a = r100;
        this.f355220b = r101;
        this.f355221c = r102;
    }
}
