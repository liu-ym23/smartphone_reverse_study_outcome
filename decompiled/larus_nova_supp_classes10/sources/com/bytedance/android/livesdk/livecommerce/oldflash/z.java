package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.app.Dialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public z(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Pair r11 = (Pair) r10;
        Dialog r0 = this.a.p;
        if (r0 != null) goto L5;
    L10:
        LiveFlashViewModel r1 = (LiveFlashViewModel) this.a.g;
        boolean r2 = true;
        if (r1 == null) goto L13;
        r1.setCanLogShowSku(true);
    L13:
        LiveFlashViewModel r3 = (LiveFlashViewModel) this.a.g;
        if (r3 == null) goto L16;
        String r4 = r3.getCategoryId();
    L17:
        if (r11 == null) goto L19;
        String r5 = (String) r11.getFirst();
    L21:
        if (Intrinsics.areEqual(r5, r4) == false) goto L46;
        AppCompatDialog r6 = this.a.Z90();
        if (r6 != null) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L46;
        LiveFlashViewModel r8 = (LiveFlashViewModel) this.a.g;
        if (r8 == null) goto L45;
        MutableLiveData<List<b>> r9 = r8.getFlashItemList();
        if (r9 == null) goto L45;
        LiveFlashNewFragment r12 = this.a;
        s r13 = r12.m;
        if (r13 == null) goto L43;
        LiveFlashViewModel r14 = (LiveFlashViewModel) r12.g;
        if (r14 == null) goto L38;
        String r15 = r14.getCategoryNames();
    L39:
        if (r11 == null) goto L41;
        xi2.v r16 = (xi2.v) r11.getSecond();
    L42:
        List<b> r17 = r13.a(r15, r16, true);
    L44:
        r9.setValue(r17);
        goto L45
    L41:
        r16 = null;
        goto L42
    L38:
        r15 = null;
        goto L39
    L43:
        r17 = null;
    L45:
        this.a.la0(false, false);
    L47:
        if (r11 == null) goto L64;
        xi2.v r18 = (xi2.v) r11.getSecond();
        if (r18 == null) goto L65;
        String r19 = r18.e();
        if (r19 != null) goto L53;
        return;
    L53:
        if (r19.length() > 0) goto L56;
        r2 = false;
    L56:
        if (r2 == false) goto L58;
        String r20 = r19;
    L59:
        if (r20 == null) goto L67;
        LiveFlashViewModel r110 = (LiveFlashViewModel) this.a.g;
        if (r110 == null) goto L68;
        r110.setTargetName(StringsKt.replace$default(r20, "*", "?", false, 4, null));
        return;
    L68:
        return;
    L67:
        return;
    L58:
        r20 = null;
        goto L59
    L65:
        return;
    L64:
        return;
    L25:
        if (r6.isShowing() != true) goto L27;
        r7 = true;
    L46:
        LiveFlashNewFragment.ra0(this.a);
        goto L47
    L19:
        r5 = null;
        goto L21
    L16:
        r4 = null;
        goto L17
    L5:
        if (r0.isShowing() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        LiveFlashNewFragment.ja0(r0);
        goto L10
    }
}
