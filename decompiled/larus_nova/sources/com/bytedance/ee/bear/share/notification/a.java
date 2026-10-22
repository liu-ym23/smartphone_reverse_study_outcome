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

/* JADX INFO: loaded from: classes18.dex */
public final class a extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShareNotifySetView f237260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IReminder f237261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f237262e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.share.notification.a$a, reason: collision with other inner class name */
    public static final class C3422a {
    }

    public static final class b implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f237263a;

        @Override // com.bytedance.ee.bear.share.newshare.g0
        public final boolean isVisible() {
            ShareParams r100 = this.f237263a.f237245b;
            if (r100 == null) goto L32;
            String r101 = r100.getFeedId();
            if (r101 == null) goto L36;
            IReminder r102 = this.f237263a.f237261d;
            if (r102 == null) goto L14;
            IBinder r103 = r102.asBinder();
            if (r103 == null) goto L14;
            if (r103.isBinderAlive() != true) goto L14;
            boolean r104 = true;
        L15:
            if (r104 == false) goto L33;
            this.f237263a.getClass();
            Intrinsics.checkNotNullParameter(r101, "feedId");
            if (TextUtils.isEmpty(r101) == false) goto L19;
        L21:
            boolean r105 = false;
        L22:
            if (r105 == false) goto L34;
            ShareParams r106 = this.f237263a.f237245b;
            if (r106 != null) goto L26;
        L28:
            boolean r107 = false;
        L29:
            if (r107 == true) goto L35;
            return true;
        L35:
            return false;
        L26:
            if (r106.getType() != 44) goto L28;
            r107 = true;
            goto L29
        L34:
            return false;
        L19:
            if (TextUtils.isDigitsOnly(r101) == false) goto L21;
            r105 = true;
            goto L22
        L33:
            return false;
        L14:
            r104 = false;
            goto L15
        L36:
            return false;
        L32:
            return false;
        }

        public b(a r100) {
            this.f237263a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        return z.g(this, b0.g.f237194b, null, null, CollectionsKt.listOf(this.f237262e), null, this.f237260c, 22);
    }

    public a() {
        this.f237262e = new b(this);
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.f237260c;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r100, ShareParams r101) {
        Intrinsics.checkNotNullParameter(r100, "shareProvider");
        Intrinsics.checkNotNullParameter(r101, "shareParams");
        super.f(r100, r101);
        Context r102 = getContext();
        if (r102 == null) goto L34;
        this.f237260c = new ShareNotifySetView(r102);
        com.bytedance.ee.bear.share.newshare.b r103 = c();
        if (r103 == null) goto L27;
        Bundle r104 = r103.getArguments();
        if (r104 == null) goto L27;
        ShareParams r105 = this.f237245b;
        if (r105 == null) goto L27;
        String r106 = r105.getFeedId();
        if (r106 == null) goto L27;
        Intrinsics.checkNotNullParameter(r106, "feedId");
        if (TextUtils.isEmpty(r106) == false) goto L17;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == false) goto L27;
        Bundle r108 = r104.getBundle("extra_reminder_binder");
        if (r108 == null) goto L24;
        BinderParcel r109 = (BinderParcel) r108.getParcelable("remind_binder");
    L25:
        if (r109 == null) goto L27;
        this.f237261d = IReminder.Stub.asInterface(r109.f236231a);
        goto L27
    L24:
        r109 = null;
        goto L25
    L17:
        if (TextUtils.isDigitsOnly(r106) == false) goto L19;
        r107 = true;
    L27:
        ShareNotifySetView r110 = this.f237260c;
        if (r110 == null) goto L30;
        r110.setMargin(0);
    L30:
        ShareNotifySetView r111 = this.f237260c;
        if (r111 == null) goto L35;
        r111.a(r101.getFeedId(), this.f237261d);
        return;
    L35:
        return;
    }
}
