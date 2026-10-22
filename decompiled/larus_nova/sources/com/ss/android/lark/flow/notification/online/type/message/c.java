package com.ss.android.lark.flow.notification.online.type.message;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends atb.b<Notice, qhb.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Notice f423779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f423780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f423781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Notice.Extra.ChatType f423782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f423783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f423784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f423785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f423786i;

    @Override // atb.b
    public final void d() {
    }

    @Override // atb.b
    public final void e() {
    }

    @Override // atb.b
    public final void f() {
    }

    @Override // atb.b
    public final PendingIntent j(Intent r100) {
        return null;
    }

    @Override // atb.b
    public final void k() {
    }

    @Override // atb.b
    public final Uri l() {
        return null;
    }

    @Override // atb.b
    public final String c() {
        Notice r100 = this.f423779b;
        String r101 = r100.content;
        boolean r102 = r100.extra.f433073q;
        if (r102 == false) goto L6;
        r101 = null;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r101;
    L8:
        Notice r103 = this.f423779b;
        int r104 = r103.state;
        if (r104 != 2) goto L13;
        return UIHelper.getString(R.string.Lark_Legacy_MessageIsrecalled);
    L13:
        if (r104 == 3) goto L15;
        String r105 = r103.content;
        if (r103.extra.f433062f == true) goto L32;
        if (r102 == true) goto L21;
        return r105;
    L21:
        if (this.f423782e != Notice.Extra.ChatType.GROUP) goto L28;
        if (r() == false) goto L26;
        return UIHelper.getString(R.string.Lark_Legacy_GroupAtMe);
    L26:
        return UIHelper.getString(R.string.Lark_Legacy_NewGroupMessage);
    L28:
        if (r() == false) goto L31;
        return UIHelper.getString(R.string.Lark_Legacy_SomeoneAtYou);
    L31:
        return UIHelper.getString(R.string.Lark_Legacy_NewMessage);
    L32:
        return UIHelper.getString(R.string.Lark_Legacy_EncryptMessageReceived);
    L15:
        return UIHelper.getString(R.string.Lark_Legacy_MessageIsrecalled);
    }

    @Override // atb.b
    public final int i() {
        int r100 = this.f423779b.state;
        if (r100 != 1) goto L6;
        return 0;
    L6:
        if (r100 != 2) goto L8;
    L11:
        return 1;
    L8:
        if (r100 == 3) goto L11;
        return 0;
    }

    @Override // atb.b
    public final String o() {
        String r100 = this.f423779b.title;
        if (r100 == null) goto L9;
        if (r100.isEmpty() == true) goto L9;
        return this.f423779b.title;
    L9:
        return UIHelper.getString(R.string.Lark_Legacy_AppNameRelease);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final void p() {
        Notice r100 = (Notice) this.f16294a;
        this.f423779b = r100;
        this.f423780c = r100.messageId;
        Notice.Extra r101 = r100.extra;
        this.f423781d = r101.f433057a;
        this.f423782e = r101.f433058b;
        Notice.Extra.ChatMode r102 = r101.f433060d;
        this.f423783f = r101.f433061e;
        this.f423784g = r101.f433067k;
        if (com.ss.android.lark.notification.export.entity.a.a(r100) == false) goto L5;
        int r103 = this.f423779b.extra.f433068l;
    L6:
        this.f423785h = r103;
        return;
    L5:
        r103 = this.f423779b.position;
        goto L6
    }

    public final boolean r() {
        if (this.f423779b.type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean s() {
        Notice.Extra.ChatType r100 = this.f423779b.extra.f433058b;
        if (r100 != null) goto L7;
        thb.a.a("FlowMessageNotificationDataPacker", "notice chat type is null！");
        return false;
    L7:
        if (r100 != Notice.Extra.ChatType.GROUP) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // atb.b
    public final String b() {
        if (r() == false) goto L6;
        return AbstractNotification.CHANNEL_TYPE.AT;
    L6:
        return AbstractNotification.CHANNEL_TYPE.NORMAL;
    }

    @Override // atb.b
    public final int g() {
        if (r() == false) goto L9;
        if (s() == false) goto L9;
        return dtb.c.b(this.f423779b, this.f423780c);
    L9:
        return dtb.c.b(this.f423779b, this.f423781d);
    }

    @Override // atb.b
    public final String n() {
        return UIHelper.getString(R.string.Lark_Legacy_NewMessage);
    }

    @Override // atb.b
    public final boolean q() {
        return r();
    }

    @Override // atb.b
    public final String h() {
        return this.f423780c;
    }

    public c(Notice r100) {
        super(r100);
        this.f423786i = LarkContext.getApplication();
    }
}
