package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class l extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f308999a;

    public l() {
        this.f308999a = "live_tutor_main";
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final String getScene() {
        return this.f308999a;
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "vmData");
        o r101 = o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("item_content", r100.f309006a);
        r102.put("suggested_type", "live_tutor");
        r102.put("current_page", "chat");
        Message r103 = r100.f309014i;
        if (r103 == null) goto L5;
        String r104 = r103.getMessageId();
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "tutor_sug_card");
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "tutor_entrance");
        Unit r105 = Unit.INSTANCE;
        r101.reportEvent("live_tutor_click_button", r102);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final boolean c(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "vmData");
        String r101 = r100.f309006a;
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101.length() == 0) goto L8;
        return false;
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "vmData");
        o r101 = o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("item_content", r100.f309006a);
        r102.put("suggested_type", "live_tutor");
        r102.put("current_page", "chat");
        Message r103 = r100.f309014i;
        if (r103 == null) goto L5;
        String r104 = r103.getMessageId();
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "tutor_sug_card");
        Unit r105 = Unit.INSTANCE;
        r101.reportEvent("live_tutor_item_show", r102);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
