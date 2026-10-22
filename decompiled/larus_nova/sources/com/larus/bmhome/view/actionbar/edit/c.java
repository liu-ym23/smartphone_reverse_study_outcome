package com.larus.bmhome.view.actionbar.edit;

import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
public interface c {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c r110, z0 r111, r r112, int r113, String r114, aq8.e r115, Integer r116, Function0 r117, int r118) {
            if ((r118 & 8) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r118 & 16) == 0) goto L9;
            aq8.e r101 = null;
        L11:
            if ((r118 & 32) == 0) goto L13;
            Integer r102 = null;
        L15:
            if ((r118 & 64) == 0) goto L17;
            Function0 r103 = null;
        L18:
            r110.onActionBarInstructionChanged(r111, r112, r113, r100, r101, r102, r103);
            return;
        L17:
            r103 = r117;
            goto L18
        L13:
            r102 = r116;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(c r110, boolean r111, boolean r112, boolean r113, ArrayList r114, boolean r115, boolean r116, int r117, int r118) {
            if ((r118 & 4) == 0) goto L5;
            boolean r100 = false;
        L7:
            if ((r118 & 8) == 0) goto L9;
            ArrayList r101 = new ArrayList();
        L11:
            if ((r118 & 16) == 0) goto L13;
            boolean r102 = false;
        L15:
            if ((r118 & 32) == 0) goto L17;
            boolean r103 = false;
        L19:
            if ((r118 & 64) == 0) goto L21;
            int r104 = 0;
        L22:
            r110.onMediaContainerStatusChanged(r111, r112, r100, r101, r102, r103, r104);
            return;
        L21:
            r104 = r117;
            goto L22
        L17:
            r103 = r116;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    void bindChatParam(ChatParam r100);

    d1<aq8.j> getActionBarInstructionChanged();

    d1<Boolean> getActionBarInstructionInputSendReady();

    Boolean getActionBarInstructionInputSendReadyState();

    String getActionBarName();

    String getActionBarType();

    i1<List<ResourceItemBean>> getAttachmentResources();

    d1<Unit> getAvatarBtnCancelFlow();

    d1<Boolean> getAvatarBtnClickFlow();

    ChatParam getChatParam();

    d1<String> getChosenAvatarInstructionFlow();

    i1<Boolean> getChosenAvatarInstructionStatus();

    d1<fq8.e> getChosenImgInspirationFlow();

    fq8.e getChosenImgInspirePrompt();

    p1 getChosenMsgInstruction();

    d1<p1> getChosenMsgInstructionFlow();

    d1<Pair<ConstraintLayout, Boolean>> getComponentVisibilityChangedFlow();

    List<w> getCurImageList();

    z0 getCurrentCustomActionBarItem();

    r getCurrentInstructionConf();

    r getCurrentInstructionUsuallyConfig();

    CoroutineScope getCurrentViewModelScope();

    Long getDefaultSelectedImageStyleId();

    d1<Triple<ab8.a, Integer, String>> getDigitalAvatarTemplateChooseFlow();

    Function0<Boolean> getDropDownSelectorClickInterceptor();

    i1<Boolean> getEnableOriginalRatioFlow();

    i1<ArrayList<Integer>> getHideInstructionFlow();

    String getHintStr(int r100, int r101);

    d1<List<w>> getImageListSelectorWithMoreRefreshFlow();

    d1<String> getInputBoxHintChanged();

    Map<String, ?> getInstructionDefaultParams();

    d1<com.larus.bmhome.actionbar.model.f> getInstructionDigitalAvatarTemplatePrompt();

    d1<Boolean> getInstructionFeatureDialogDismiss();

    d1<String> getInstructionFeatureSelectedForPrompt();

    d1<String> getInstructionFeatureUnSelectedForPrompt();

    String getInstructionInputBoxHint();

    d1<Boolean> getInstructionMusicTemplateDetailOpen();

    d1<bq8.a> getInstructionMusicTemplatePrompt();

    d1<m> getInstructionPhotoTemplatePrompt();

    r getInstructionRebuildStateConf();

    AttachmentInfo getInstructionReferenceImage();

    i1<Integer> getInstructionReferenceImageUploadStatus();

    i1<Integer> getInstructionSelectMenuPosition();

    d1<i0> getInstructionTabSelected();

    Integer getInstructionType();

    d1<String> getInstructionVideoTemplatePrompt();

    Flow<Unit> getJumpToCompleteVideoAvatarEvent();

    i1<Boolean> getMediaSelectedFlow();

    t1 getOptionParamFilterConf();

    d1<t1> getOptionParamFilterConfChanged();

    boolean getRatioCanBeEmpty();

    List<w> getRatioOptionList();

    d1<Unit> getResetImageStyleListFlow();

    d1<o> getSelectDurationFlow();

    i1<p> getSelectModelFlow();

    d1<q> getSelectRatioFlow();

    i1<p> getSelectVideoModelFlow();

    Map<Integer, Long> getSelectedClickRatioIdRegistry();

    Long getSelectedRatioId();

    Long getSelectedVideoModelId();

    i1<Long> getSelectedVideoStyle();

    String getTemplateType();

    Function0<Boolean> getVideoModelDropDownSelectorClickInterceptor();

    Function2<Long, Boolean, Boolean> getVideoModelSelectionInterceptor();

    Boolean isCreationActionBar();

    boolean isInVideoTab();

    void markInputSendReadyState(boolean r100);

    void onActionBarInstructionChanged(z0 r100, r r101, int r102, String r103, aq8.e r104, Integer r105, Function0<Unit> r106);

    void onAvatarBtnCancel();

    void onAvatarBtnClick(boolean r100);

    void onAvatarInstructionClicked(String r100);

    void onComponentVisibilityChanged(Object r100, boolean r101);

    void onDigitalAvatarTemplateChoose(ab8.a r100, int r101, String r102);

    void onFeatureOptionDialogDismiss();

    void onFeatureOptionSelected(w r100);

    void onFeatureOptionUnSelected(w r100);

    void onImgInspirationClick(fq8.e r100);

    void onInputBoxTextChanged(String r100);

    void onInputHintChanged(String r100, String r101);

    void onInstructionDigitalAvatarTemplateSelected(com.larus.bmhome.actionbar.model.f r100);

    void onInstructionImageTemplateSelected(TemplateInfo$TemplateInfo r100, Uri r101);

    void onInstructionMusicTemplateSelected(bq8.a r100);

    void onInstructionReferenceImageChanged(AttachmentInfo r100);

    void onInstructionReferenceImageUploadStatus(int r100);

    void onMediaContainerStatusChanged(boolean r100, boolean r101, boolean r102, ArrayList<Integer> r103, boolean r104, boolean r105, int r106);

    void onMsgInstructionClicked(p1 r100);

    void onMusicDetailDialogDismiss();

    void onMusicDetailDialogOpen();

    void onParamFilterConfChanged(t1 r100);

    void onTabSelected(i0 r100);

    void refreshImageListSelectorWithMore(List<w> r100);

    void selectDuration(long r100);

    void selectInstructionMenu(int r100);

    boolean selectModel(int r100, long r101);

    void selectRatio(int r100, long r101);

    void selectRatio(long r100);

    boolean selectVideoModel(long r100);

    void selectedVideoStyleItem(long r100);

    void setActionBarInstructionInputSendReady(boolean r100);

    void setActionBarName(String r100, String r101, String r102);

    void setChosenAvatarInstructionStatus(boolean r100);

    void setChosenImgInspirePrompt(fq8.e r100);

    void setChosenMsgInstruction(p1 r100);

    void setCreationActionBar(Boolean r100);

    void setCurImageList(List<w> r100);

    void setCurrentCustomActionBarItem(z0 r100);

    void setCurrentInstructionConfig(r r100);

    void setDefaultSelectedImageStyleId(Long r100);

    void setEnableResetTemplateCacheAfterDetach(boolean r100);

    void setImageStyleRadioSelected(boolean r100);

    void setMsgExtMap(Map<String, String> r100, String r101);

    void setOptionParamFilterConf(t1 r100);

    void setOriginalRatioEnable(boolean r100);

    void setRatioCanBeEmpty(boolean r100);

    void setRatioDropDownSelectorClickInterceptor(Function0<Boolean> r100);

    void setRatioOptionList(List<w> r100);

    void setSelectedRatioId(Long r100);

    void setVideoModelDropDownSelectorClickInterceptor(Function0<Boolean> r100);

    void setVideoModelSelectionInterceptor(Function2<? super Long, ? super Boolean, Boolean> r100);

    void syncVideoModel(long r100);

    void updateAttachmentResources(List<ResourceItemBean> r100);

    void updateInputBoxPlaceHolder(int r100, h1 r101);
}
