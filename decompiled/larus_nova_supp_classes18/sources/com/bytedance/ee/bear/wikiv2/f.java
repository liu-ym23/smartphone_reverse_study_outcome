package com.bytedance.ee.bear.wikiv2;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements bn4.a.a {
    public final /* synthetic */ WikiFragment a;
    public final /* synthetic */ BearUrl b;
    public final /* synthetic */ WikiInfo c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ ce5.a e;

    public static final class a implements Runnable {
        public final /* synthetic */ WikiFragment a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ BearUrl c;
        public final /* synthetic */ WikiInfo d;
        public final /* synthetic */ Bundle e;
        public final /* synthetic */ ce5.a f;

        public a(WikiFragment r1, boolean r2, BearUrl r3, WikiInfo r4, Bundle r5, ce5.a r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void a() {
            if (this.a.isAdded() == true) goto L6;
            return;
        L6:
            if (this.b == false) goto L37;
            WikiFragment r1 = this.a;
            String r3 = this.c.e;
            int r4 = WikiFragment.l;
            r1.getClass();
            if (r3 != null) goto L10;
        L13:
            boolean r2 = true;
        L14:
            if (r2 == false) goto L17;
            if (r3 != null) goto L34;
            r3 = "";
        L34:
            if (Intrinsics.areEqual(r3, this.c.e) == false) goto L36;
            BearUrl r0 = this.c;
        L38:
            FragmentTransaction r5 = this.a.getChildFragmentManager().beginTransaction();
            WikiFragment r6 = this.a;
            WikiInfo r7 = this.d;
            Bundle r8 = this.e;
            int r9 = WikiFragment.l;
            Fragment r10 = r6.aa0(r0, r7, r8);
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r10, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131393212) == true) goto L42;
            r5 = r5.replace(2131393212, r10);
        L42:
            r5.commitAllowingStateLoss();
            tt5.a.h("WikiFragment", "Load onSuccess. Type: " + r0.a + ", isBitableApp=" + this.b);
            this.a.W90(this.d, this.f);
            return;
        L36:
            r0 = p.a().Z(r3);
            goto L38
        L17:
            bn4.a r11 = (bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6);
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L26
            Uri r13 = UriProtector.parse(r3);     // Catch: Throwable -> L26
            r11.c();     // Catch: Throwable -> L26
            if (UriProtector.getQueryParameter(r13, "isbaseapp") == null) goto L21;
            String r14 = r3;
        L24:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L26
        L28:
            Object r16 = r3;
            if (Result.isFailure-impl(r15) == true) goto L32;
            r16 = r15;
        L32:
            r3 = (String) r16;
            goto L34
        L21:
            Uri.Builder r17 = r13.buildUpon();     // Catch: Throwable -> L26
            r11.c();     // Catch: Throwable -> L26
            r11.f();     // Catch: Throwable -> L26
            String r18 = r17.appendQueryParameter("isbaseapp", "1").build().toString();     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L26
            r14 = r18;
        L26:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L28
        L10:
            if (StringsKt.isBlank(r3) == true) goto L13;
            r2 = false;
            goto L14
        L37:
            r0 = this.c;
            goto L38
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onResult(boolean r10) {
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L9;
        r0.runOnUiThread(new a(this.a, r10, this.b, this.c, this.d, this.e));
        return;
    }

    public f(WikiFragment r1, BearUrl r2, WikiInfo r3, Bundle r4, ce5.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
