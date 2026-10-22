package com.larus.doc.sdk.api;

import android.graphics.drawable.Drawable;
import androidx.fragment.app.FragmentActivity;
import com.larus.office.base.service.b;
import kotlin.Metadata;
import n39.c;
import n39.d;
import n39.f;
import n39.g;
import n39.h;
import n39.k;
import n39.l;
import n39.o;
import n39.r;
import vm9.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J6\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020\"H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\"H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\"H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\"H&J\b\u0010.\u001a\u00020\u0003H&J)\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u001d2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H&¢\u0006\u0002\u00105J\u0014\u00106\u001a\u0004\u0018\u0001072\b\b\u0002\u0010'\u001a\u00020\"H&J\u0012\u00108\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\"H&J\u001a\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020\"H&J\u001a\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u001d2\b\b\u0002\u0010'\u001a\u00020\"H&J\u0012\u0010=\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\"H&J\u0012\u0010>\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010@H&J\b\u0010A\u001a\u00020\u0003H&J\b\u0010B\u001a\u00020\u0003H&J\u001a\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020\"H&J\u001a\u0010E\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020\"H&J\u0012\u0010F\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010GH&¨\u0006H"}, d2 = {"Lcom/larus/doc/sdk/api/IDocSdkBaseService;", "", "addChatService", "", "service", "Lcom/larus/doc/sdk/api/IChatService;", "removeChatService", "addDocModeService", "Lcom/larus/doc/sdk/api/IDocModeService;", "removeDocModeService", "addTitleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "removeTitleBarService", "addLoadingDocStateService", "Lcom/larus/doc/sdk/api/ILoadingDocStateService;", "removeLoadingDocStateService", "addLoadingService", "Lcom/larus/office/base/page/ILoadingService;", "removeLoadingService", "addOperationService", "Lcom/larus/doc/sdk/api/ICommonOperationService;", "removeOperationService", "getPartialRewriteService", "Lcom/larus/doc/sdk/api/IPartialRewriteService;", "getToolbarService", "Lcom/larus/doc/sdk/api/IToolbarService;", "getVoiceInputService", "Lcom/larus/doc/sdk/api/IVoiceInputService;", "getBottomWindowHeight", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "setChatInputVisible", "from", "", "visible", "", "aiEditMode", "normalMode", "docLogicKeyForFindService", "setConversationId", "conversationId", "setArtifactMetaId", "artifactMetaId", "reportDocPageExit", "reason", "resetDocOpenTime", "startDocSnapshot", "inputViewHeight", "drawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;)V", "getDocInfoProvider", "Lcom/larus/doc/sdk/api/IDocInfoProvider;", "onMessageLoadingStart", "onMessageLoadingEnd", "isPartialEdit", "notifyAiThinkingStateChanged", "state", "onTitleClicked", "setHostAbilityProvider", "hostAbility", "Lcom/larus/office/base/page/IHostAbilityProvider;", "showPhotoPickerFragment", "hidePhotoPickerFragment", "reportToolbarItemClicked", "name", "reportToolbarItemShow", "isKeyboardShowing", "Landroid/app/Activity;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocSdkBaseService {
    void addChatService(c r100);

    void addDocModeService(g r100);

    void addLoadingDocStateService(k r100);

    void addLoadingService(vm9.c r100);

    void addOperationService(d r100);

    void addTitleBarService(b r100);

    int getBottomWindowHeight(FragmentActivity r100);

    f getDocInfoProvider(String r100);

    l getPartialRewriteService();

    o getToolbarService();

    r getVoiceInputService();

    void hidePhotoPickerFragment();

    void notifyAiThinkingStateChanged(int r100, String r101);

    void onMessageLoadingEnd(boolean r100, String r101);

    void onMessageLoadingStart(String r100);

    void onTitleClicked(String r100);

    void removeChatService(c r100);

    void removeDocModeService(g r100);

    void removeLoadingDocStateService(k r100);

    void removeLoadingService(vm9.c r100);

    void removeOperationService(d r100);

    void removeTitleBarService(b r100);

    void reportDocPageExit(String r100);

    void reportToolbarItemClicked(String r100, String r101);

    void reportToolbarItemShow(String r100, String r101);

    void resetDocOpenTime();

    void setArtifactMetaId(String r100);

    void setChatInputVisible(String r100, boolean r101, boolean r102, boolean r103, String r104);

    void setConversationId(String r100);

    void setHostAbilityProvider(a r100);

    void showPhotoPickerFragment();

    void startDocSnapshot(Integer r100, Drawable r101, h r102);
}
