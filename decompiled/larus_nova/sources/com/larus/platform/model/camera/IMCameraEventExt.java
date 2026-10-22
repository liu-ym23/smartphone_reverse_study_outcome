package com.larus.platform.model.camera;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u0005J\u0010\u0010%\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0010\u0010&\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0010\u0010'\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0010\u0010(\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u001c\u0010)\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020+H\u0016J\b\u0010/\u001a\u00020+H\u0016J\b\u00100\u001a\u00020+H\u0016J\b\u00101\u001a\u00020+H\u0016J\n\u00102\u001a\u0004\u0018\u00010+H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J\u000f\u00105\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u00106J\n\u00107\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00109\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020\u0001H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/platform/model/camera/IMCameraEventExt;", "Lcom/larus/platform/model/camera/ICameraEventExt;", "<init>", "()V", "botId", "", "botConversationType", "", "Ljava/lang/Integer;", "chatType", "conversationId", "chatKey", "", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "clickFrom", "actionBarKey", "actionBarInstructionType", "actionBarInstructionItemsTemplate", "onboardingItemId", "recoRequestId", "previousPage", "referenceFromType", "referenceMessageId", "extraParams", "setChatInfo", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;J)V", "setTemplateInfo", "setClickFrom", "setActionBarKey", "setActionBarInstructionType", "(Ljava/lang/Integer;)V", "setActionBarInstructionItemsTemplate", "setOnboardingItemId", "setRecoRequestId", "requestId", "setPreviousPage", "setExtraParams", "setReferenceFromType", "setReferenceMessageId", "setEnterPageEvent", "enterPageEventExt", "Lorg/json/JSONObject;", "enterCameraEventExt", "cameraItemShowEventExt", "clickCameraButtonEventExt", "leaveCameraEventExt", "leaveCameraConfirmEventExt", "clickAlbumOnCapturePageEventExt", "getExtraParams", "getConversationId", "getBotId", "getBotConversationType", "()Ljava/lang/Integer;", "getClickFrom", "getChatType", "getAllExtParams", "copy", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMCameraEventExt implements ICameraEventExt {
    private String actionBarInstructionItemsTemplate;
    private Integer actionBarInstructionType;
    private String actionBarKey;
    private Integer botConversationType;
    private String botId;
    private long chatKey;
    private String chatType;
    private String clickFrom;
    private String conversationId;
    private String extraParams;
    private String onboardingItemId;
    private String previousPage;
    private String recoRequestId;
    private String referenceFromType;
    private String referenceMessageId;
    private String templateId;
    private String templateType;

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        String r101 = this.botId;
        if (r101 == null) goto L5;
        r100.put("bot_id", r101);
    L5:
        String r102 = this.chatType;
        if (r102 == null) goto L8;
        r100.put("chat_type", r102);
    L8:
        String r103 = this.clickFrom;
        if (r103 == null) goto L11;
        r100.put("click_from", r103);
    L11:
        String r104 = this.templateId;
        if (r104 == null) goto L14;
        r100.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r104);
    L14:
        String r105 = this.templateType;
        if (r105 == null) goto L17;
        r100.put("action_bar_template_type", r105);
    L17:
        String r106 = this.actionBarKey;
        if (r106 == null) goto L20;
        r100.put("action_bar_key", r106);
    L20:
        Integer r107 = this.actionBarInstructionType;
        if (r107 == null) goto L23;
        r100.put("action_bar_instruction_type", r107.intValue());
    L23:
        String r108 = this.actionBarInstructionItemsTemplate;
        if (r108 == null) goto L26;
        r100.put("action_bar_instruction_items_template", r108);
    L26:
        String r109 = this.onboardingItemId;
        if (r109 == null) goto L29;
        r100.put("onboarding_item_id", r109);
    L29:
        String r110 = this.recoRequestId;
        if (r110 == null) goto L32;
        r100.put("reco_request_id", r110);
    L32:
        String r111 = this.referenceFromType;
        if (r111 == null) goto L35;
        r100.put("cited_from_user_type", r111);
    L35:
        String r112 = this.referenceMessageId;
        if (r112 == null) goto L38;
        r100.put("cited_message_id", r112);
    L38:
        JSONObject r113 = getExtraParams();
        if (r113 == null) goto L48;
        String r114 = r113.optString("common_venue_type");
        if (r114 == null) goto L48;
        if ((!StringsKt.isBlank(r114)) == true) goto L46;
        r114 = null;
    L46:
        if (r114 == null) goto L48;
        r100.put("common_venue_type", r114);
    L48:
        return r100;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public ICameraEventExt copy() {
        IMCameraEventExt r100 = new IMCameraEventExt();
        r100.botId = this.botId;
        r100.botConversationType = this.botConversationType;
        r100.chatType = this.chatType;
        r100.conversationId = this.conversationId;
        r100.clickFrom = this.clickFrom;
        r100.templateId = this.templateId;
        r100.templateType = this.templateType;
        r100.actionBarKey = this.actionBarKey;
        r100.actionBarInstructionType = this.actionBarInstructionType;
        r100.actionBarInstructionItemsTemplate = this.actionBarInstructionItemsTemplate;
        r100.onboardingItemId = this.onboardingItemId;
        r100.recoRequestId = this.recoRequestId;
        r100.chatKey = this.chatKey;
        r100.extraParams = this.extraParams;
        return r100;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject enterPageEventExt() {
        JSONObject r100 = new JSONObject();
        String r101 = this.botId;
        if (r101 == null) goto L5;
        r100.put("bot_id", r101);
    L5:
        String r102 = this.chatType;
        if (r102 == null) goto L8;
        r100.put("chat_type", r102);
    L8:
        String r103 = this.clickFrom;
        if (r103 == null) goto L11;
        r100.put("enter_method", r103);
    L11:
        String r104 = this.previousPage;
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L20;
        r100.put("previous_page", this.previousPage);
    L20:
        return r100;
    L14:
        if (r104.length() == 0) goto L17;
        r105 = false;
        goto L18
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject getExtraParams() {
        String r100 = this.extraParams;
        if (r100 != null) goto L9;
        return null;
    L9:
        return new JSONObject(r100);
    L11:
        return null;
    }

    public IMCameraEventExt() {
        this.botConversationType = 0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject cameraItemShowEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject clickAlbumOnCapturePageEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject clickCameraButtonEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject enterCameraEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject leaveCameraConfirmEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject leaveCameraEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public long chatKey() {
        return this.chatKey;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public Integer getBotConversationType() {
        return this.botConversationType;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getBotId() {
        return this.botId;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getChatType() {
        return this.chatType;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getClickFrom() {
        return this.clickFrom;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getConversationId() {
        return this.conversationId;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceFromType() {
        return this.referenceFromType;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceMessageId() {
        return this.referenceMessageId;
    }

    public final void setActionBarInstructionItemsTemplate(String r100) {
        this.actionBarInstructionItemsTemplate = r100;
    }

    public final void setActionBarInstructionType(Integer r100) {
        this.actionBarInstructionType = r100;
    }

    public final void setActionBarKey(String r100) {
        this.actionBarKey = r100;
    }

    public final void setClickFrom(String r100) {
        this.clickFrom = r100;
    }

    public final void setExtraParams(String r100) {
        this.extraParams = r100;
    }

    public final void setOnboardingItemId(String r100) {
        this.onboardingItemId = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setRecoRequestId(String r100) {
        this.recoRequestId = r100;
    }

    public final void setReferenceFromType(String r100) {
        this.referenceFromType = r100;
    }

    public final void setReferenceMessageId(String r100) {
        this.referenceMessageId = r100;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public void setEnterPageEvent(String r100, String r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        this.previousPage = r100;
    L11:
        if (r101 != null) goto L13;
    L14:
        r102 = true;
    L15:
        if (r102 == true) goto L18;
        this.clickFrom = r101;
        return;
    L18:
        return;
    L13:
        if (r101.length() != 0) goto L15;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final void setTemplateInfo(String r100, String r101) {
        this.templateId = r100;
        this.templateType = r101;
    }

    public final void setChatInfo(String r100, Integer r101, String r102, String r103, long r104) {
        this.botId = r100;
        this.botConversationType = r101;
        this.chatType = r102;
        this.conversationId = r103;
        this.chatKey = r104;
    }
}
