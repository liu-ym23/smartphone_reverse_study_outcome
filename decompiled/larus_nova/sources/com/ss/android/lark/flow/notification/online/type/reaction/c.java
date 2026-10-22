package com.ss.android.lark.flow.notification.online.type.reaction;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.x;
import com.larus.nova.R;
import com.ss.android.lark.flow.notification.online.type.reaction.entity.FlowReactionNotice;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class c extends atb.b<FlowReactionNotice, rhb.a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f423788h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlowReactionNotice f423789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f423790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f423791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f423792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f423793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f423794g;

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
    public final void k() {
    }

    @Override // atb.b
    public final Uri l() {
        return null;
    }

    @Override // atb.b
    public final boolean q() {
        return true;
    }

    @Override // atb.b
    public final String c() {
        FlowReactionNotice r100 = this.f423789b;
        int r101 = r100.state;
        if (r101 != 2) goto L5;
    L9:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.extra.f433058b != Notice.Extra.ChatType.GROUP) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L16;
        return UIHelper.getString(R.string.Lark_Legacy_P2pReaction);
    L16:
        return UIHelper.getString(R.string.Lark_Legacy_GroupReaction);
    L12:
        r102 = false;
        goto L13
    L5:
        if (r101 == 3) goto L9;
        return r100.content;
    }

    @Override // atb.b
    public final int g() {
        return ((int) (CastLongProtector.parseLong(this.f423789b.messageId) % 10001)) * 10001;
    }

    @Override // atb.b
    public final String h() {
        return this.f423789b.messageId;
    }

    @Override // atb.b
    public final int i() {
        int r100 = this.f423789b.state;
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
        FlowReactionNotice r100 = this.f423789b;
        int r101 = r100.state;
        if (r101 != 2) goto L6;
        return UIHelper.getString(R.string.Lark_Legacy_MessageIsrecalled);
    L6:
        if (r101 == 3) goto L13;
        String r102 = r100.title;
        if (TextUtils.isEmpty(r102) == true) goto L11;
        return r102;
    L11:
        return f423788h;
    L13:
        return UIHelper.getString(R.string.Lark_Legacy_MessageRemove);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // atb.b
    public final void p() {
        FlowReactionNotice r100 = (FlowReactionNotice) this.f16294a;
        this.f423789b = r100;
        Notice.Extra r101 = r100.extra;
        this.f423791d = r101.f433061e;
        this.f423790c = r100.messageId;
        this.f423792e = r101.f433067k;
        if (com.ss.android.lark.notification.export.entity.a.a(r100) == false) goto L5;
        int r102 = this.f423789b.extra.f433068l;
    L6:
        this.f423793f = r102;
        f423788h = UIHelper.mustacheFormat(R.string.Lark_Legacy_AppNameRelease);
        return;
    L5:
        r102 = this.f423789b.position;
        goto L6
    }

    @Override // atb.b
    public final String b() {
        if (x.c() == true) goto L6;
        return null;
    L6:
        return AbstractNotification.CHANNEL_TYPE.NORMAL;
    }

    @Override // atb.b
    public final String n() {
        return c();
    }

    public c(FlowReactionNotice r100) {
        super(r100);
        this.f423794g = LarkContext.getApplication();
    }

    @Override // atb.b
    public final PendingIntent j(Intent r100) {
        int r101 = (int) SystemClock.uptimeMillis();
        if (x.a() == false) goto L5;
        int r102 = 201326592;
    L7:
        return PendingIntent.getActivity(this.f423794g, r101, r100, r102);
    L5:
        r102 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L7
    }
}
