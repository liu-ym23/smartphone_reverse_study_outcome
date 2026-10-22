package com.larus.bmhome.chat.bubble.floating.source;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pc8.c;
import sc8.b;
import tx9.x1;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/GuidePcBubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", SendEventContainerMethodParamModel.EventKinds.onShow, "", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", SendEventContainerMethodParamModel.EventKinds.onClick, "pcGuideParams", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuidePcBubbleBannerSourceListener implements BubbleBannerSourceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297559a;

    public static final class a {
    }

    static {
    }

    public GuidePcBubbleBannerSourceListener() {
        this.f297559a = "pc_guide";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.f297559a;
    }

    public static JSONObject a(b r100) {
        c r101 = r100.f541389l;
        Object r102 = null;
        if (r101 == null) goto L27;
        String r103 = r101.f528565b;
        if (r103 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r103)) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L29;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L14
        Object r105 = Result.m9449constructorimpl(new JSONObject(r103));     // Catch: Throwable -> L14
    L16:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L20;
        FLogger.f375446a.w("GuidePcBubbleBannerSourceListener", "parse pc guide tracking failed, promptId=" + r100.f541379b, r106);
    L20:
        if (Result.m9455isFailureimpl(r105) == true) goto L24;
        r102 = r105;
    L24:
        return (JSONObject) r102;
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L29:
        return null;
    L27:
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        JSONObject r101 = a(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        x1.f(null, null, null, null, null, r101, 95);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        JSONObject r101 = a(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        x1.e(null, null, null, null, null, r101, 95);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(b r100, BubbleBannerDismissReason r101) {
        BubbleBannerSourceListener.a.b(r100, r101);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(b r100, sc8.a r101) {
        BubbleBannerSourceListener.a.a(r100, r101);
    }
}
