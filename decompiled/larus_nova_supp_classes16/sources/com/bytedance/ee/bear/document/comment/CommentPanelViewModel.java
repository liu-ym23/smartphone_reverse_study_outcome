package com.bytedance.ee.bear.document.comment;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CommentPanelViewModel extends BaseEditPanelViewModel implements VcKeyboardChangeEventProducer {
    private static final String TAG = "Comment#CommentPanelViewModel";
    private com.bytedance.ee.bear.document.orientation.p atOrientationHandler;
    private int changeDefaultPanelHeight;
    private int changeMaxPanelHeight;
    private int changeMinPanelHeight;
    private boolean changePanelHeightFlag;
    private MutableLiveData<Boolean> changeShowHeight;
    private MutableLiveData<com.bytedance.ee.bear.middleground.comment.export.a> commentAnimationLiveData;
    private v2<ShowCardsJsData> commentCardRequest;
    private MutableLiveData<CommentInputRequest> commentInputRequest;
    private String copyUrlTemplate;
    private com.bytedance.ee.bear.document.orientation.p editOrientationHandler;
    private MutableLiveData<String> feedUpdate;
    private MutableLiveData<FocusInputBean> focusInputBean;
    private com.bytedance.ee.bear.document.orientation.p forceOrientationRequestHandler;
    private com.bytedance.ee.bear.document.orientation.p fullOrientationHandler;
    private com.bytedance.ee.bear.document.orientation.p inputOrientationHandler;
    private MutableLiveData<Boolean> isShowingComment;
    private MutableLiveData<Integer> panelHeight;
    private com.bytedance.ee.bear.document.orientation.p partOrientationHandler;
    private boolean supportLandscapeMode;
    private MutableLiveData<TranslateConfig> translateConfig;

    public static class CancelData implements Serializable {
        private String tmpId;
        private String type;

        public JSONObject toJSONObject() {
            JSONObject r0 = new JSONObject();
            r0.put("type", this.type);
            r0.put("tmpId", this.tmpId);
            return r0;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String r1) {
            this.type = r1;
        }

        public CancelData(String r1, String r2) {
            this.type = r1;
            this.tmpId = r2;
        }
    }

    public static /* synthetic */ boolean Mo() {
        return lambda$new$5();
    }

    public static /* synthetic */ boolean No(CommentPanelViewModel r0) {
        return r0.lambda$new$2();
    }

    public static /* synthetic */ boolean Oo() {
        return lambda$new$4();
    }

    public static /* synthetic */ boolean Po() {
        return lambda$new$3();
    }

    public static /* synthetic */ boolean Qo() {
        return lambda$new$0();
    }

    private static /* synthetic */ boolean lambda$new$0() {
        return false;
    }

    private static /* synthetic */ boolean lambda$new$1() {
        return true;
    }

    private static /* synthetic */ boolean lambda$new$3() {
        return true;
    }

    private static /* synthetic */ boolean lambda$new$4() {
        return true;
    }

    private static /* synthetic */ boolean lambda$new$5() {
        return true;
    }

    public static /* synthetic */ boolean yo() {
        return lambda$new$1();
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return FileUploadModel.FROM_COMMENT;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    public String toString() {
        return "CommentPanel";
    }

    private /* synthetic */ boolean lambda$new$2() {
        if (ku5.c.k(eu5.b.a) == false) goto L5;
    L7:
        return false;
    L5:
        if (isSupportLandscapeMode() == true) goto L7;
        return true;
    }

    public void closeCard() {
        JSONObject r0 = new JSONObject();
        r0.put("type", "show_cards");
        execJS("javascript:biz.comment.cancel", r0);
    }

    public void reset() {
        this.commentInputRequest.setValue(null);
        this.commentCardRequest.setValue(null);
        this.panelHeight.setValue(null);
        this.feedUpdate.setValue(null);
        this.translateConfig.setValue(null);
        this.focusInputBean.setValue(null);
        this.copyUrlTemplate = null;
        this.changePanelHeightFlag = false;
    }

    public CommentPanelViewModel() {
        this.copyUrlTemplate = null;
        this.partOrientationHandler = new f();
        this.fullOrientationHandler = new g();
        this.inputOrientationHandler = new h(this);
        this.atOrientationHandler = new i();
        this.editOrientationHandler = new j();
        this.forceOrientationRequestHandler = new k();
        this.changeDefaultPanelHeight = (int) (com.bytedance.ee.util.ui.n.t() * com.bytedance.ee.bear.facade.common.widget.d.q);
        this.changeMinPanelHeight = (int) (com.bytedance.ee.util.ui.n.t() * com.bytedance.ee.bear.facade.common.widget.d.p);
        this.changeMaxPanelHeight = (int) (com.bytedance.ee.util.ui.n.t() * com.bytedance.ee.bear.facade.common.widget.d.r);
        this.changePanelHeightFlag = false;
        this.supportLandscapeMode = false;
        this.isShowingComment = new MutableLiveData();
        this.changeShowHeight = new MutableLiveData();
        this.commentInputRequest = new MutableLiveData();
        this.commentCardRequest = new v2();
        this.panelHeight = new MutableLiveData();
        this.commentAnimationLiveData = new MutableLiveData();
        this.feedUpdate = new MutableLiveData();
        this.translateConfig = new MutableLiveData();
        this.focusInputBean = new MutableLiveData();
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        if (isSupportLandscapeMode() == false) goto L7;
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.NOT_LIMITED;
    L7:
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public com.bytedance.ee.bear.document.orientation.p getAtOrientationHandler() {
        return this.atOrientationHandler;
    }

    public int getChangeDefaultPanelHeight() {
        return this.changeDefaultPanelHeight;
    }

    public int getChangeMaxPanelHeight() {
        return this.changeMaxPanelHeight;
    }

    public int getChangeMinPanelHeight() {
        return this.changeMinPanelHeight;
    }

    public MutableLiveData<Boolean> getChangeShowHeight() {
        return this.changeShowHeight;
    }

    public MutableLiveData<com.bytedance.ee.bear.middleground.comment.export.a> getCommentAnimationLiveData() {
        return this.commentAnimationLiveData;
    }

    public LiveData<ShowCardsJsData> getCommentCardsRequest() {
        return this.commentCardRequest;
    }

    public LiveData<CommentInputRequest> getCommentInputRequest() {
        return this.commentInputRequest;
    }

    public String getCopyUrlTemplate() {
        return this.copyUrlTemplate;
    }

    public com.bytedance.ee.bear.document.orientation.p getEditOrientationHandler() {
        return this.editOrientationHandler;
    }

    public MutableLiveData<String> getFeedUpdate() {
        return this.feedUpdate;
    }

    public MutableLiveData<FocusInputBean> getFocusInputBean() {
        return this.focusInputBean;
    }

    public com.bytedance.ee.bear.document.orientation.p getForceOrientationRequestHandler() {
        return this.forceOrientationRequestHandler;
    }

    public com.bytedance.ee.bear.document.orientation.p getFullOrientationHandler() {
        return this.fullOrientationHandler;
    }

    public com.bytedance.ee.bear.document.orientation.p getInputOrientationHandler() {
        return this.inputOrientationHandler;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.FOLLOW_KEYBOARD;
    }

    public MutableLiveData<Integer> getPanelHeight() {
        return this.panelHeight;
    }

    public com.bytedance.ee.bear.document.orientation.p getPartOrientationHandler() {
        return this.partOrientationHandler;
    }

    public MutableLiveData<TranslateConfig> getTranslateConfig() {
        return this.translateConfig;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_SHOW;
    }

    public boolean isChangePanelHeightFlag() {
        return this.changePanelHeightFlag;
    }

    public MutableLiveData<Boolean> isShowingComment() {
        return this.isShowingComment;
    }

    public boolean isSupportLandscapeMode() {
        return this.supportLandscapeMode;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r1) {
        if (this.panelHeight.getValue() != null) goto L5;
        return 0;
    L5:
        return ((Integer) this.panelHeight.getValue()).intValue();
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r1) {
        super.onKeyboardStateChanged(r1);
    }

    public void setChangeDefaultPanelHeight(int r1) {
        this.changeDefaultPanelHeight = r1;
    }

    public void setChangeMaxPanelHeight(int r1) {
        this.changeMaxPanelHeight = r1;
    }

    public void setChangeMinPanelHeight(int r1) {
        this.changeMinPanelHeight = r1;
    }

    public void setChangePanelHeightFlag(boolean r1) {
        this.changePanelHeightFlag = r1;
    }

    public void setChangeShowHeight(boolean r2) {
        this.changeShowHeight.postValue(Boolean.valueOf(r2));
    }

    public void setCopyUrlTemplate(String r1) {
        this.copyUrlTemplate = r1;
    }

    public void setPanelHeight(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("height", Integer.valueOf(r3));
        execJS("javascript:lark.biz.util.setPanelHeight", r0);
    }

    public void setSupportLandscapeMode(boolean r1) {
        this.supportLandscapeMode = r1;
    }

    public void updateCommentCardsRequest(ShowCardsJsData r2) {
        getCommentCardsRequest().setValue(r2);
    }

    public void updateCommentInputRequest(CommentInputRequest r3) {
        tt5.a.h(TAG, "updateCommentInputRequest:" + r3);
        getCommentInputRequest().setValue(r3);
    }

    public void updateFocusInputBean(FocusInputBean r3) {
        tt5.a.h(TAG, "updateFocusInputBean:" + r3);
        getFocusInputBean().setValue(r3);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void execJS(String r1, JSONObject r2) {
        super.execJS(r1, r2);
    }

    public void getDetailReaction(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("referType", r3);
        r0.put("referKey", r4);
        execJS("javascript:window.lark.biz.reaction.getDetail", r0);
    }

    public JSONObject getInputCancelParam(boolean r3, String r4) {
        tt5.a.h(TAG, "clearInputRequest by cancel?" + r3);
        CommentInputRequest r5 = (CommentInputRequest) this.commentInputRequest.getValue();
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if (r6 == false) goto L11;
        String r7 = "whole_comment";
    L12:
        JSONObject r8 = new CancelData(r7, r4).toJSONObject();
        r8.put(JSEventListener.ACTION, "cancel");
        this.commentInputRequest.setValue(null);
        return r8;
    L11:
        r7 = "doc_comment";
        goto L12
    L5:
        if (r5.isForWhole() == false) goto L7;
        r6 = true;
        goto L9
    }

    public void setDetailPanelStatus(int r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("status", Integer.valueOf(r3));
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L7:
        execJS("javascript:window.lark.biz.reaction.setDetailPanelStatus", r0);
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L7;
        r0.put("referType", r4);
        r0.put("referKey", r5);
        goto L7
    }
}
