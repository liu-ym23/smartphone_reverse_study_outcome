package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hg6.i;
import jc1.k;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import tc0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public Context a;
    public DataCenter b;
    public Boolean c;
    public String d;

    public a() {
    }

    public final q0 a() {
        Context r0 = this.a;
        if (r0 == null) goto L41;
        DataCenter r1 = this.b;
        if (r1 == null) goto L39;
        if (this.c == null) goto L37;
        if (this.d == null) goto L35;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L13:
        Boolean r3 = this.c;
        if (r3 == null) goto L16;
        boolean r4 = r3.booleanValue();
    L17:
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        String r2 = this.d;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L20:
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        if (i.a() == false) goto L29;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r5 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        IInteractService r6 = k.f(IInteractService.class);
        if (r6 == null) goto L27;
        com.bytedance.android.live.liveinteract.plantform.base.i r7 = r6.getLinkUserInfoCenter();
        if (r7 == null) goto L27;
        ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r7.getGuestInfo(d.b0(), c.h().f);
    L28:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r8, r2, r4);
        return r5;
    L27:
        r8 = null;
        goto L28
    L29:
        ALogger.d("KtvRoomDynamicEmojiDialog", "new instance voice chat dynamic from " + r2);
        KtvRoomDynamicEmojiDialog r9 = new KtvRoomDynamicEmojiDialog(r0, r1, r4);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        ((BaseDynamicEmojiDialog) r9).u = r2;
        tb6.c r10 = ((BaseDynamicEmojiDialog) r9).A;
        if (r10 == null) goto L33;
        r10.a();
        r10.d(r2);
    L33:
        return r9;
    L16:
        r4 = false;
        goto L17
    L35:
        throw new IllegalArgumentException("call setRequestPage() before call build()");
    L37:
        throw new IllegalArgumentException("call setShowExtraButton() before call build()");
    L39:
        throw new IllegalArgumentException("call setDataCenter() before call build()");
    L41:
        throw new IllegalArgumentException("call setContext() before call build()");
    }

    public final void b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }
}
