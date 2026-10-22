package com.larus.bmhome.chat.bubble.floating.source;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sc8.b;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\u0010\u001a\u00020\u0005*\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/MuseumExtensionBubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", SendEventContainerMethodParamModel.EventKinds.onShow, "", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "onDismiss", "reason", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerDismissReason;", SendEventContainerMethodParamModel.EventKinds.onClick, "toMuseumExtensionRawNotify", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MuseumExtensionBubbleBannerSourceListener implements BubbleBannerSourceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297560a;

    public static final class a {
    }

    static {
    }

    public MuseumExtensionBubbleBannerSourceListener() {
        this.f297560a = "museum_extend_pack";
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.f297560a;
    }

    public static String a(b r100) {
        JSONObject r101 = new JSONObject();
        Map<String, String> r102 = r100.f541390m;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.get("stage");
    L6:
        String r105 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r101.put("stage", r104);
        Map<String, String> r106 = r100.f541390m;
        if (r106 == null) goto L12;
        r103 = r106.get("museum");
    L12:
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r101.put("museum", r103);
        JSONObject r107 = new JSONObject();
        r107.put("banner_source", "museum_extend_pack");
        r107.put("ext", r101.toString());
        String r108 = r100.f541385h;
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        r107.put("button_text", r108);
        r107.put("priority", r100.f541387j);
        JSONObject r109 = new JSONObject();
        r109.put("auto_dismiss_seconds", r100.f541386i);
        Unit r110 = Unit.INSTANCE;
        r107.put("policy", r109.toString());
        r107.put("conversation_id", r100.f541380c);
        JSONObject r111 = new JSONObject();
        r111.put("scene", "museum_extension_banner");
        r111.put("title", r100.f541382e);
        String r112 = r100.f541383f;
        if (r112 != null) goto L20;
        r112 = "";
    L20:
        r111.put("content", r112);
        String r113 = r100.f541384g;
        if (r113 == null) goto L24;
        r105 = r113;
    L24:
        r111.put("icon", r105);
        r111.put("data", r107.toString());
        return r111.toString();
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return null;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = a(r100);
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[banner][general][show] promptId=");
        r103.append(r100.f541379b);
        r103.append(", conversationId=");
        r103.append(r100.f541380c);
        r103.append(", queryMessageId=");
        r103.append(r100.f541381d);
        r103.append(", stage=");
        Map<String, String> r104 = r100.f541390m;
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.get("stage");
    L6:
        r103.append(r106);
        r103.append(", museum=");
        Map<String, String> r107 = r100.f541390m;
        if (r107 == null) goto L9;
        r105 = r107.get("museum");
    L9:
        r103.append(r105);
        r103.append(", rawNotify=");
        r103.append(r101);
        r102.i("MuseumExtensionDebug", r103.toString());
        VoiceCallServiceDelegate.f377087a.h(r101);
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = a(r100);
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[banner][general][click] promptId=");
        r103.append(r100.f541379b);
        r103.append(", stage=");
        Map<String, String> r104 = r100.f541390m;
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.get("stage");
    L6:
        r103.append(r106);
        r103.append(", museum=");
        Map<String, String> r107 = r100.f541390m;
        if (r107 == null) goto L9;
        r105 = r107.get("museum");
    L9:
        r103.append(r105);
        r103.append(", rawNotify=");
        r103.append(r101);
        r102.i("MuseumExtensionDebug", r103.toString());
        VoiceCallServiceDelegate.f377087a.g(r101);
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(b r100, BubbleBannerDismissReason r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "reason");
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[banner][general][dismiss] promptId=");
        r103.append(r100.f541379b);
        r103.append(", reason=");
        r103.append(r101);
        r103.append(", stage=");
        Map<String, String> r104 = r100.f541390m;
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.get("stage");
    L6:
        r103.append(r106);
        r103.append(", museum=");
        Map<String, String> r107 = r100.f541390m;
        if (r107 == null) goto L9;
        r105 = r107.get("museum");
    L9:
        r103.append(r105);
        r102.i("MuseumExtensionDebug", r103.toString());
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(b r100, sc8.a r101) {
        BubbleBannerSourceListener.a.a(r100, r101);
    }
}
