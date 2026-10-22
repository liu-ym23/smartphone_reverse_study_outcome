package com.larus.larkfeed.impl;

import com.larus.im.bean.conversation.BotConversationType;
import com.larus.platform.model.camera.ICameraEventExt;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/larus/larkfeed/impl/SocialConversationPageFragment$startScan$1$1", "Lcom/larus/platform/model/camera/ICameraEventExt;", "enterPageEventExt", "Lorg/json/JSONObject;", "chatKey", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialConversationPageFragment$startScan$1$1 implements ICameraEventExt {
    public SocialConversationPageFragment$startScan$1$1() {
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject cameraItemShowEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public long chatKey() {
        return 0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject clickAlbumOnCapturePageEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject clickCameraButtonEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public ICameraEventExt copy() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject enterCameraEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    @BotConversationType
    public Integer getBotConversationType() {
        return 0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getBotId() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getChatType() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getClickFrom() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getConversationId() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject getExtraParams() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject leaveCameraConfirmEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject leaveCameraEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceFromType() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceMessageId() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public void setEnterPageEvent(String r100, String r101) {
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject enterPageEventExt() {
        JSONObject r100 = new JSONObject();
        r100.put("current_page", "scan");
        r100.put("previous_page", "chat_list");
        r100.put("enter_method", "plus_panel");
        return r100;
    }
}
