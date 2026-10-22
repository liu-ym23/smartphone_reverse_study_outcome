package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class i0 implements com.larus.bmhome.share.panel.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f324752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.share.panel.d f324753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.share.panel.d f324754c;

    @Override // com.larus.bmhome.share.panel.d
    public final void f() {
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void onDismiss() {
        this.f324753b.onDismiss();
        this.f324754c.onDismiss();
        h0 r100 = this.f324752a;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void e(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        h0 r101 = new h0(new Ref.BooleanRef(), r100);
        this.f324752a = r101;
        this.f324753b.e(r101);
        this.f324754c.e(r101);
    }

    public i0(yy8.a r100, com.larus.bmhome.share.panel.d r101) {
        this.f324753b = r100;
        this.f324754c = r101;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean d(String r100, String r101, Boolean r102) {
        boolean r103 = this.f324753b.d(r100, r101, r102);
        boolean r104 = this.f324754c.d(r100, r101, r102);
        if (r103 == false) goto L6;
        if (r104 == false) goto L6;
        boolean r105 = true;
    L7:
        FLogger.f375446a.i(com.bytedance.android.livesdk.action.instance.ShareAction.TAG, "mergedListener.enableInterceptClick: channel=" + r101 + ", primary=" + r103 + ", secondary=" + r104 + ", result=" + r105);
        return r105;
    L6:
        r105 = false;
        goto L7
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean b(Context r100, DialogFragment r101, View r102, jr9.a r110) {
        Intrinsics.checkNotNullParameter(r110, "shareItemConfig");
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("mergedListener.onInterceptClick: channel=");
        r104.append(r110.b());
        r104.append(", sharePanelDialog=");
        if (r101 == null) goto L5;
        boolean r105 = true;
    L6:
        r104.append(r105);
        r103.i(com.bytedance.android.livesdk.action.instance.ShareAction.TAG, r104.toString());
        boolean r106 = this.f324753b.b(r100, r101, r102, r110);
        r103.i(com.bytedance.android.livesdk.action.instance.ShareAction.TAG, "mergedListener.onInterceptClick: primary返回=" + r106);
        if (r106 == false) goto L9;
        return true;
    L9:
        boolean r107 = this.f324754c.b(r100, r101, r102, r110);
        r103.i(com.bytedance.android.livesdk.action.instance.ShareAction.TAG, "mergedListener.onInterceptClick: secondary返回=" + r107);
        return r107;
    L5:
        r105 = false;
        goto L6
    }
}
