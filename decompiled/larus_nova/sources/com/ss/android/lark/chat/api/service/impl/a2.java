package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsRequest;
import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsResponse;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesRequest;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesResponse;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchRequest;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchResponse;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageRequest;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageResponse;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Request;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Response;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a2 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f411568a;

    @Inject
    public a2(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f411568a = r100;
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void a(SetTranslateLanguageRequest.Builder r110, c2 r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMapper");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, SetTranslateLanguageResponse.ADAPTER, Command.SET_TRANSLATE_LANGUAGES_SETTING, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411568a.h(r100).a()).map(new y1(r111)), r112);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void b(TranslateMessagesV3Request.Builder r110, d2 r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMapper");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, TranslateMessagesV3Response.ADAPTER, Command.TRANSLATE_MESSAGES_V3, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411568a.h(r100).a()).map(new z1(r111)), r112);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void c(GetTranslateLanguagesRequest.Builder r110, f2 r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMapper");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetTranslateLanguagesResponse.ADAPTER, Command.GET_TRANSLATE_LANGUAGES_SETTING, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411568a.h(r100).a()).map(new w1(r111)), r112);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void d(TranslateMessageUrlPreviewsRequest.Builder r110, e2 r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMapper");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, TranslateMessageUrlPreviewsResponse.ADAPTER, Command.TRANSLATE_MESSAGE_URL_PREVIEW, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411568a.h(r100).a()).map(new v1(r111)), r112);
    }

    @Override // com.ss.android.lark.chat.api.service.impl.t0
    public final void e(SetAutoTranslateGlobalSwitchRequest.Builder r110, b2 r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMapper");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, SetAutoTranslateGlobalSwitchResponse.ADAPTER, Command.SET_AUTO_TRANSLATE_GLOBAL_SWITCH, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f411568a.h(r100).a()).map(new x1(r111)), r112);
    }
}
