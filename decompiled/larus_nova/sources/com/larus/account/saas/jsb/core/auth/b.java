package com.larus.account.saas.jsb.core.auth;

import android.os.Bundle;
import b48.i;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import com.ss.ttm.player.MediaPlayer;
import kotlin.text.StringsKt;
import y38.u;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x38.g<FlowAccountThirdPartyAuthCore.a> f286383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i.a f286384b;

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r110) {
        com.larus.account.saas.runtime.internal.delegate.a r100 = com.larus.account.saas.runtime.internal.delegate.a.f286466a;
        StringBuilder r101 = new StringBuilder("douyin auth error, errorCode=");
        String r102 = null;
        if (r110 == null) goto L5;
        String r103 = r110.platformErrorCode;
    L6:
        r101.append(r103);
        r101.append(", errorMsg=");
        if (r110 == null) goto L9;
        r102 = r110.platformErrorMsg;
    L9:
        r101.append(r102);
        r100.d("FlowAccountThirdPartyAuthCore", r101.toString());
        x38.g<FlowAccountThirdPartyAuthCore.a> r104 = this.f286383a;
        String r105 = this.f286384b.f17630a;
        if (r110 == null) goto L16;
        String r111 = r110.platformErrorCode;
        if (r111 == null) goto L16;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L16;
        int r113 = r112.intValue();
    L17:
        r104.onSuccess(new FlowAccountThirdPartyAuthCore.a("douyin", r105, "", null, null, null, null, Integer.valueOf(r113), MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY));
        return;
    L16:
        r113 = -1;
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r110) {
        if (r110 == null) goto L4;
        String r111 = r110.getString("auth_code");
    L5:
        if (r111 != null) goto L7;
        r111 = "";
    L7:
        String r100 = r111;
        this.f286383a.onSuccess(new FlowAccountThirdPartyAuthCore.a("douyin", this.f286384b.f17630a, r100, null, null, null, null, null, 504));
        return;
    L4:
        r111 = null;
        goto L5
    }

    public b(u r100, i.a r101) {
        this.f286383a = r100;
        this.f286384b = r101;
    }
}
