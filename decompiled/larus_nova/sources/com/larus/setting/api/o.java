package com.larus.setting.api;

import android.os.Handler;
import com.larus.setting.api.data.SettingsItemAction;
import com.larus.utils.y;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o implements ltb.a<List<? extends mtb.f>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<List<zs9.c>, Unit> f367917a;

    @Override // ltb.a
    public final void onError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function1<? super List<zs9.c>, Unit> r100) {
        this.f367917a = r100;
    }

    @Override // ltb.a
    public final void onSuccess(List<? extends mtb.f> r100) {
        List<? extends mtb.f> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        final ArrayList r102 = new ArrayList();
        Iterator<? extends mtb.f> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L20;
        final mtb.f r104 = r103.next();
        int r105 = m.f367913a;
        DoubaoAddFriendSettingType r106 = r104.f515675a;
        int r107 = m.a.f367914a[r106.ordinal()];
        if (r107 != 1) goto L8;
        final String r108 = "group";
    L19:
        zs9.b r109 = new zs9.b();
        r109.f573491b = r104.f515676b;
        r109.f573496g = SettingsItemAction.TOGGLE;
        r109.f573494e = Boolean.valueOf(r104.f515678d);
        r109.f573493d = Integer.valueOf(r104.f515677c);
        r109.f573497h = new k(r104, r108);
        r102.add(r109);
        goto L4
    L8:
        if (r107 != 2) goto L10;
        r108 = "qrcode_and_link";
        goto L19
    L10:
        if (r107 != 3) goto L12;
        r108 = "profile";
        goto L19
    L12:
        if (r107 != 4) goto L15;
        r108 = "doc";
        goto L19
    L15:
        throw new NoWhenBranchMatchedException();
    L20:
        SoftReference<Handler> r110 = y.f375498a;
        final Function1<List<zs9.c>, Unit> r111 = this.f367917a;
        y.c(new n(r111, r102));
    }
}
