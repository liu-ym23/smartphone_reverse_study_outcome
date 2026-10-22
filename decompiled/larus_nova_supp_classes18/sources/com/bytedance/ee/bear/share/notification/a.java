package com.bytedance.ee.bear.share.notification;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.parcel.BinderParcel;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.g0;
import com.bytedance.ee.bear.share.newshare.z;
import com.ss.android.lark.doc.IReminder;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends z {
    public ShareNotifySetView c;
    public IReminder d;
    public final b e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.share.notification.a$a, reason: collision with other inner class name */
    public static final class C0175a {
    }

    public static final class b implements g0 {
        public final /* synthetic */ a a;

        @Override // com.bytedance.ee.bear.share.newshare.g0
        public final boolean isVisible() {
            ShareParams r0 = this.a.b;
            if (r0 == null) goto L32;
            String r1 = r0.getFeedId();
            if (r1 == null) goto L36;
            IReminder r2 = this.a.d;
            if (r2 == null) goto L14;
            IBinder r3 = r2.asBinder();
            if (r3 == null) goto L14;
            if (r3.isBinderAlive() != true) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == false) goto L33;
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "feedId");
            if (TextUtils.isEmpty(r1) == false) goto L19;
        L21:
            boolean r5 = false;
        L22:
            if (r5 == false) goto L34;
            ShareParams r6 = this.a.b;
            if (r6 != null) goto L26;
        L28:
            boolean r7 = false;
        L29:
            if (r7 == true) goto L35;
            return true;
        L35:
            return false;
        L26:
            if (r6.getType() != 44) goto L28;
            r7 = true;
            goto L29
        L34:
            return false;
        L19:
            if (TextUtils.isDigitsOnly(r1) == false) goto L21;
            r5 = true;
            goto L22
        L33:
            return false;
        L14:
            r4 = false;
            goto L15
        L36:
            return false;
        L32:
            return false;
        }

        public b(a r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        return z.g(this, b0.g.b, null, null, CollectionsKt.listOf(this.e), null, this.c, 22);
    }

    public a() {
        this.e = new b(this);
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r4, ShareParams r5) {
        Intrinsics.checkNotNullParameter(r4, "shareProvider");
        Intrinsics.checkNotNullParameter(r5, "shareParams");
        super.f(r4, r5);
        Context r6 = getContext();
        if (r6 == null) goto L34;
        this.c = new ShareNotifySetView(r6);
        com.bytedance.ee.bear.share.newshare.b r7 = c();
        if (r7 == null) goto L27;
        Bundle r8 = r7.getArguments();
        if (r8 == null) goto L27;
        ShareParams r1 = this.b;
        if (r1 == null) goto L27;
        String r2 = r1.getFeedId();
        if (r2 == null) goto L27;
        Intrinsics.checkNotNullParameter(r2, "feedId");
        if (TextUtils.isEmpty(r2) == false) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L27;
        Bundle r9 = r8.getBundle("extra_reminder_binder");
        if (r9 == null) goto L24;
        BinderParcel r10 = (BinderParcel) r9.getParcelable("remind_binder");
    L25:
        if (r10 == null) goto L27;
        this.d = IReminder.Stub.asInterface(r10.a);
        goto L27
    L24:
        r10 = null;
        goto L25
    L17:
        if (TextUtils.isDigitsOnly(r2) == false) goto L19;
        r3 = true;
    L27:
        ShareNotifySetView r11 = this.c;
        if (r11 == null) goto L30;
        r11.setMargin(0);
    L30:
        ShareNotifySetView r12 = this.c;
        if (r12 == null) goto L35;
        r12.a(r5.getFeedId(), this.d);
        return;
    L35:
        return;
    }
}
