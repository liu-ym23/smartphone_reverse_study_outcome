package com.larus.office.base.permission;

import com.larus.utils.logger.FLogger;
import com.ss.bduploader.BDAbstractUpload;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class r implements ut5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f360668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f360669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<NoPermissionFragment.a, Unit> f360670c;

    @Override // ut5.a
    public final void onResult(Boolean r100) {
        Boolean r101 = r100;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("applyPermission callback success: result=");
        r103.append(r101);
        r103.append(", token=");
        int r104 = com.larus.office.base.utils.f.f361173a;
        r103.append(com.larus.office.base.utils.f.b(this.f360668a));
        r103.append(", objType=");
        r103.append(this.f360669b);
        r102.i(com.ss.android.lark.widget.photopicker.gallery.NoPermissionFragment.TAG, r103.toString());
        this.f360670c.invoke(new NoPermissionFragment.a(Intrinsics.areEqual(r101, Boolean.TRUE), null, false, 6));
    }

    @Override // ut5.a
    public final void onError(int r100, Throwable r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("applyPermission callback error: token=");
        int r104 = com.larus.office.base.utils.f.f361173a;
        r103.append(com.larus.office.base.utils.f.b(this.f360668a));
        r103.append(", objType=");
        r103.append(this.f360669b);
        r103.append(", code=");
        r103.append(r100);
        r103.append(", msg=");
        Boolean r105 = null;
        if (r101 == null) goto L5;
        String r106 = r101.getMessage();
    L6:
        r103.append(r106);
        r102.e(com.ss.android.lark.widget.photopicker.gallery.NoPermissionFragment.TAG, r103.toString());
        if (r101 == null) goto L12;
        String r107 = r101.getMessage();
        if (r107 == null) goto L12;
        r105 = Boolean.valueOf(StringsKt.contains$default(r107, "http error, code = 429", false, 2, null));
    L12:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L14;
        r100 = BDAbstractUpload.KeyIsXQuicLibAvailable;
    L14:
        this.f360670c.invoke(new NoPermissionFragment.a(false, Integer.valueOf(r100), false, 4));
        return;
    L5:
        r106 = null;
        goto L6
    }

    public r(String r100, String r101, q r102) {
        this.f360668a = r100;
        this.f360669b = r101;
        this.f360670c = r102;
    }
}
