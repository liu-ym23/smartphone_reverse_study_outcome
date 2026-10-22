package com.larus.search.impl;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.search.api.LarkChatServiceProxy;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016JC\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/search/impl/LarkChatServiceProxyImpl;", "Lcom/larus/search/api/LarkChatServiceProxy;", "<init>", "()V", "handleLarkContactClick", "", "chatId", "", "chatterId", "handleLarkMessageClick", "localIndex", "", "openLarkChat", "showPosition", "", "source", "onSuccessLog", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Z", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkChatServiceProxyImpl implements LarkChatServiceProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f367421a = 0;

    public static final class a {
    }

    static {
    }

    public LarkChatServiceProxyImpl() {
    }

    @Override // com.larus.search.api.LarkChatServiceProxy
    public final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        if (StringsKt.isBlank(r100) == false) goto L9;
        if (StringsKt.isBlank(r101) == false) goto L9;
        FLogger.f375446a.w("LarkChatServiceProxy", "handleLarkContactClick: chatId & chatterId are blank");
        return false;
    L9:
        return c(r100, r101, null, "contact", null);
    }

    @Override // com.larus.search.api.LarkChatServiceProxy
    public final boolean b(final String r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        if (StringsKt.isBlank(r100) == false) goto L7;
        FLogger.f375446a.w("LarkChatServiceProxy", "handleLarkMessageClick: chatId is blank");
        return false;
    L7:
        return c(r100, "", Integer.valueOf((int) r101), "message", new x(r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.search.impl.LarkChatServiceProxyImpl$openLarkChat$1] */
    public static boolean c(final String r100, final String r101, Integer r102, final String r103, final Function0 r104) {
        Activity r105 = AppHost.f326268a.a().getCurrentActivity();
        if (r105 != null) goto L5;
        return false;
    L5:
        Object r106 = xp9.o.f564776a;
        dza.b r107 = 0;
        r107 = 0;
        if ((r106 instanceof OfficeSDKUserApi) == false) goto L8;
        OfficeSDKUserApi r108 = (OfficeSDKUserApi) r106;
    L9:
        if (r108 == null) goto L13;
        aza.d r109 = (aza.d) r108.getService(aza.d.class);
        if (r109 == null) goto L13;
        r107 = r109.P();
    L13:
        if (r107 != 0) goto L16;
        FLogger.f375446a.w("LarkChatServiceProxy", "openLarkChat: officeSdk chatService unavailable, source=".concat(r103));
        return false;
    L16:
        ChatBundle.a r110 = new ChatBundle.a();
        if (com.larus.utils.o0.d(r100) == false) goto L20;
        r110.f409934a = r100;
    L22:
        if (r102 == null) goto L24;
        r110.f409936c = r102.intValue();
    L24:
        r107.c(r105, new ChatBundle(r110), new LarkChatServiceProxyImpl$openLarkChat$1(r104, r100, r101, r103));
        return true;
    L20:
        if (com.larus.utils.o0.d(r101) == false) goto L22;
        r110.f409935b = r101;
        goto L22
    L8:
        r108 = null;
        goto L9
    }
}
