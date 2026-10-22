package com.larus.office.plugins.inputv2;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.ability.IAIChatInputPlugin;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.doc.sdk.impl.v2.plugins.input.ChatInputContainerPlugin;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.nova.R;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeInputParam;
import com.larus.office.OfficeSdkServiceImpl;
import com.larus.office.plugins.aiedit.AIEditPlugin;
import com.larus.office.plugins.input.data.OfficeDocArtifactInfo;
import com.larus.office.plugins.inputv2.component.feishu.FeishuFlowAIShowResult;
import com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationCachePromotionStore;
import com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationCoordinator;
import com.larus.office.plugins.inputv2.coordinator.runtime.integration.OfficeChatIntegrationCoordinator;
import com.larus.office.plugins.slides.orientation.SetFullscreenPlugin;
import com.larus.office.plugins.statistics.ReportEventPlugin;
import com.larus.office.plugins.titlebar.ActionBarVisibilityPlugin;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0002'o\b\u0000\u0018\u0000 Ö\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\b\u0012\u0004\u0012\u00020\f0\u000b2\u00020\r2\u00020\u000e:\u0002Ö\u0001B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010t\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\f2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u001c\u0010w\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\f2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0012\u0010x\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010y\u001a\u00020r2\u0006\u0010z\u001a\u00020{H\u0016J\u0010\u0010|\u001a\u00020r2\u0006\u0010}\u001a\u00020\u0010H\u0016J\u0018\u0010|\u001a\u00020r2\u0006\u0010~\u001a\u00020!2\u0006\u0010}\u001a\u00020\u0010H\u0016J\b\u0010\u007f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00102\u0007\u0010\u0081\u0001\u001a\u00020!H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020r2\u0007\u0010\u0083\u0001\u001a\u00020!H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0010H\u0016J\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u0086\u0001\u001a\u00020\u0010H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\t\u0010\u0089\u0001\u001a\u00020rH\u0016J\u001f\u0010\u008a\u0001\u001a\u00020r2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010!2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010!H\u0016J1\u0010\u008d\u0001\u001a\u00020r2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010!2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010!2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0003\u0010\u0090\u0001J\u0014\u0010\u0091\u0001\u001a\u00020r2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010!H\u0016J\u001b\u0010\u0092\u0001\u001a\u00020r2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016¢\u0006\u0003\u0010\u0094\u0001J\t\u0010\u0095\u0001\u001a\u00020rH\u0016J\t\u0010\u0096\u0001\u001a\u00020rH\u0016J\u0012\u0010\u0097\u0001\u001a\u00020r2\u0007\u0010\u0098\u0001\u001a\u00020\u0010H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020r2\u0007\u0010\u0083\u0001\u001a\u00020!H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020r2\u0007\u0010\u009b\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u009c\u0001\u001a\u00020rH\u0016J\t\u0010\u009d\u0001\u001a\u00020rH\u0016J,\u0010\u009e\u0001\u001a\u00020r2\u0007\u0010\u0081\u0001\u001a\u00020!2\u0006\u0010}\u001a\u00020\u00102\u0007\u0010\u009f\u0001\u001a\u00020\u00102\u0007\u0010 \u0001\u001a\u00020\u0010H\u0016J\u001b\u0010¡\u0001\u001a\u00020r2\u0007\u0010\u0083\u0001\u001a\u00020!2\u0007\u0010¢\u0001\u001a\u00020\u0010H\u0016J\u0013\u0010£\u0001\u001a\u00020r2\b\u0010¤\u0001\u001a\u00030\u0088\u0001H\u0016J\t\u0010¥\u0001\u001a\u00020rH\u0016J\n\u0010¦\u0001\u001a\u00030\u0088\u0001H\u0016J\t\u0010§\u0001\u001a\u00020rH\u0016J\u000b\u0010¨\u0001\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010©\u0001\u001a\u00020r2\u0007\u0010ª\u0001\u001a\u00020!H\u0016J\u0014\u0010«\u0001\u001a\u00020r2\t\u0010¬\u0001\u001a\u0004\u0018\u00010!H\u0016J\u000b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010!H\u0016J\u000b\u0010®\u0001\u001a\u0004\u0018\u00010!H\u0016J\t\u0010¯\u0001\u001a\u00020!H\u0016J\u0014\u0010°\u0001\u001a\u0004\u0018\u00010!2\u0007\u0010±\u0001\u001a\u00020\u0010H\u0016J\t\u0010²\u0001\u001a\u00020rH\u0016J\u0012\u0010³\u0001\u001a\u00020\u00102\u0007\u0010´\u0001\u001a\u00020!H\u0016J\t\u0010µ\u0001\u001a\u00020\u0010H\u0016J\u0011\u0010¶\u0001\u001a\u00020r2\u0006\u0010}\u001a\u00020\u0010H\u0016J\t\u0010·\u0001\u001a\u00020!H\u0016J\u0016\u0010¸\u0001\u001a\u00030\u0088\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016J\u0010\u0010»\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100¼\u0001H\u0016J\u0015\u0010½\u0001\u001a\u00020r2\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016J\n\u0010¾\u0001\u001a\u00030¿\u0001H\u0016J$\u0010À\u0001\u001a\u00020r2\u0019\u0010Á\u0001\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\t\u0012\u0007\u0012\u0002\b\u00030Ã\u00010Â\u0001H\u0016J\u0011\u0010Ä\u0001\u001a\u00020r2\u0006\u0010}\u001a\u00020\u0010H\u0002J\u0013\u0010Å\u0001\u001a\u00020r2\b\u0010¤\u0001\u001a\u00030Æ\u0001H\u0002J\u0013\u0010Ç\u0001\u001a\u00020r2\b\u0010¤\u0001\u001a\u00030Æ\u0001H\u0002J\u000b\u0010È\u0001\u001a\u0004\u0018\u00010!H\u0002J\t\u0010É\u0001\u001a\u00020rH\u0002J\u001b\u0010Ê\u0001\u001a\u00020r2\u0007\u0010Ë\u0001\u001a\u00020!2\u0007\u0010\u0083\u0001\u001a\u00020!H\u0002J\u0013\u0010Ì\u0001\u001a\u00020r2\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0002J\t\u0010Ï\u0001\u001a\u00020\u0010H\u0002J\u000b\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010Ñ\u0001\u001a\u00020\u00102\u0007\u0010Ò\u0001\u001a\u00020\u0010H\u0002J\u0013\u0010Ó\u0001\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010Ô\u0001\u001a\u00020r2\u0007\u0010\u0083\u0001\u001a\u00020!H\u0002J\t\u0010Õ\u0001\u001a\u00020rH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u00100\u00100*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b9\u0010:R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00101\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00101\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u00101\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u00101\u001a\u0004\bM\u0010NR\u001b\u0010P\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u00101\u001a\u0004\bR\u0010SR\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u00101\u001a\u0004\bW\u0010XR\u001b\u0010Z\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u00101\u001a\u0004\b\\\u0010]R\u001b\u0010_\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u00101\u001a\u0004\ba\u0010bR\u001b\u0010d\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u00101\u001a\u0004\bf\u0010gR\u001b\u0010i\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u00101\u001a\u0004\bk\u0010lR\u0010\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0004\n\u0002\u0010p¨\u0006×\u0001"}, d2 = {"Lcom/larus/office/plugins/inputv2/AIChatPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/office/plugins/input/OfficeAIChatPluginContract;", "Lcom/larus/office/plugins/input/OfficeAIChatDocxContract;", "Lcom/larus/office/plugins/input/OfficeAIChatSheetContract;", "Lcom/larus/office/plugins/input/OfficeAIChatSlidesContract;", "Lcom/larus/office/plugins/input/OfficeAIChatNavigationContract;", "Lcom/larus/office/plugins/input/OfficeAIChatStateContract;", "Lcom/larus/office/plugins/input/OfficeAIChatWindowContract;", "Lcom/larus/office/plugins/offline/OfficeOfflineDocChatContract;", "Lcom/larus/office/AIChatAbilityProvider;", "Lcom/bytedance/ee/bear/document/ability/IAIChatInputPlugin;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Lcom/larus/office/IHostStateListener;", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/EditPanel;", "enableFeishuFlowAIShow", "", "<init>", "(Z)V", "chatInputContainer", "Landroid/widget/FrameLayout;", "fullScreenChatContainer", "Landroid/view/ViewGroup;", "inputParams", "Lcom/larus/office/OfficeInputParam;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "editPanelManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/IEditPanelsManager;", "registeredEditPanelOwner", "Landroidx/lifecycle/LifecycleOwner;", "hostControlsRegistered", "offlineDocCardMessageId", "", "actionBarVisible", "deferredSlidesSelectionVisible", "Ljava/lang/Boolean;", "isDocEmpty", "fullScreenPageLifecycleCallbacks", "com/larus/office/plugins/inputv2/AIChatPluginV2$fullScreenPageLifecycleCallbacks$1", "Lcom/larus/office/plugins/inputv2/AIChatPluginV2$fullScreenPageLifecycleCallbacks$1;", "panelActive", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "answerStateCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;", "getAnswerStateCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeAnswerStateCoordinator;", "answerStateCoordinator$delegate", "Lkotlin/Lazy;", "sheetSelectionCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeSheetSelectionCoordinator;", "getSheetSelectionCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeSheetSelectionCoordinator;", "sheetSelectionCoordinator$delegate", "slidesCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeSlidesCoordinator;", "getSlidesCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeSlidesCoordinator;", "slidesCoordinator$delegate", "docArtifactCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeDocArtifactCoordinator;", "getDocArtifactCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/document/OfficeDocArtifactCoordinator;", "docArtifactCoordinator$delegate", "conversationCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/runtime/conversation/OfficeChatConversationCoordinator;", "getConversationCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/runtime/conversation/OfficeChatConversationCoordinator;", "conversationCoordinator$delegate", "windowCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/ui/OfficeChatWindowCoordinator;", "getWindowCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/ui/OfficeChatWindowCoordinator;", "windowCoordinator$delegate", "panelHeightCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/ui/OfficeChatPanelHeightCoordinator;", "getPanelHeightCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/ui/OfficeChatPanelHeightCoordinator;", "panelHeightCoordinator$delegate", "visibilityCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/ui/OfficeChatVisibilityCoordinator;", "getVisibilityCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/ui/OfficeChatVisibilityCoordinator;", "visibilityCoordinator$delegate", "inputCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/runtime/interaction/OfficeChatInputCoordinator;", "getInputCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/runtime/interaction/OfficeChatInputCoordinator;", "inputCoordinator$delegate", "trackCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/runtime/interaction/OfficeChatTrackCoordinator;", "getTrackCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/runtime/interaction/OfficeChatTrackCoordinator;", "trackCoordinator$delegate", "navigationCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/runtime/interaction/OfficeChatNavigationCoordinator;", "getNavigationCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/runtime/interaction/OfficeChatNavigationCoordinator;", "navigationCoordinator$delegate", "integrationCoordinator", "Lcom/larus/office/plugins/inputv2/coordinator/runtime/integration/OfficeChatIntegrationCoordinator;", "getIntegrationCoordinator", "()Lcom/larus/office/plugins/inputv2/coordinator/runtime/integration/OfficeChatIntegrationCoordinator;", "integrationCoordinator$delegate", "bridgeRegistry", "Lcom/larus/office/plugins/inputv2/OfficeChatBridgeRegistry;", "getBridgeRegistry", "()Lcom/larus/office/plugins/inputv2/OfficeChatBridgeRegistry;", "bridgeRegistry$delegate", "loadingCallback", "com/larus/office/plugins/inputv2/AIChatPluginV2$loadingCallback$1", "Lcom/larus/office/plugins/inputv2/AIChatPluginV2$loadingCallback$1;", "onAttachToHost", "", "host", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setChatInputVisibility", "visible", "source", "isActionBarVisible", "openFloatChatPanel", "from", "collapseChatPanel", "reason", "canEditForOfficeInputHint", "getInputParams", "isFloatChatAttached", "getFloatChatShowPercent", "", "enterStreamEditModeIfNeeded", "onSelectionChanged", "plainText", "wholeSelectedText", "onSheetSelectionChanged", "elementData", "spreadsheetVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "onSlidesSelectionChanged", "updateSlidesStructureVersion", "version", "(Ljava/lang/Integer;)V", "onSlidesRenderStarted", "onSlidesRenderFinished", "onSlidesOrientationChanged", "isLandscape", "onReferenceCacheCleared", "onDocStateChanged", "isEmpty", "notifyPanelHeightChanged", "setToAiEdit", "setChatInputVisible", "aiEditMode", "normalMode", "markAiEditTriggeredForCurrentAnswer", "applyToNextAnswer", "updateLoadingDocState", "state", "onAIEditStateIdle", "getAIEditState", "notifyInterruptConversation", "getLatestDocMessageId", "onOfflineDocRealTokenReady", "pageToken", "onOfflineDocCardMessageIdChanged", "messageId", "getCurrentScene", "getAttachedScene", "getDocViewType", "getCurrentModule", "isFromSendMsgStatus", "jumpToChatPageFromMorePanel", "shouldSuppressFlowMessagePush", "conversationId", "onBackPressed", "onActionButtonVisibilityChanged", "getPanelName", "getPanelHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getActive", "Landroidx/lifecycle/LiveData;", "requestNotFocus", "getKeyboardShowingStatusMode", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/KeyboardShowingStatusMode;", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onSlidesSelectionVisibilityChanged", "onInputReady", "Lcom/larus/business/floatchat/api/AIChatAbilityHostState;", "onInputNotReady", "resolveCurrentDefaultScene", "enterStreamEditFromInput", "requestExpandForOfficeAnswer", "documentType", "applyVisibilityResult", "result", "Lcom/larus/office/plugins/inputv2/coordinator/ui/OfficeChatVisibilityCoordinator$Result;", "isEmbeddedAIChatSuppressed", "resolveHostAbilityProvider", "resolveCurrentActionBarVisible", "fallbackIfUnavailable", "registerHostControls", "refreshHostRegistration", "unregisterHostControls", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIChatPluginV2 extends OfficeDocumentPlugin implements com.larus.office.plugins.input.q1, com.larus.office.plugins.input.m1, com.larus.office.plugins.input.r1, com.larus.office.plugins.input.s1, com.larus.office.plugins.input.o1, com.larus.office.plugins.input.u1, com.larus.office.plugins.input.w1, com.larus.office.plugins.offline.c, com.larus.office.a, IAIChatInputPlugin<ChameleonPluginHost>, com.larus.office.c, g45.a {
    private static final long AI_EDIT_FOCUS_DELAY_MS = 500;
    private static final String CHAT_PANEL_NAME = "chat_input";
    public static final a Companion = null;
    private static final String FROM_AI_EDIT = "ai_edit";
    private static final String FROM_CONVERSATION_RED_DOT = "office_conversation_red_dot";
    private static final String SOURCE_SLIDES_SELECTION = "slides_selection";
    private static final String TAG = "AIChatPluginV2";
    private boolean actionBarVisible;
    private final Lazy answerStateCoordinator$delegate;
    private final Lazy bridgeRegistry$delegate;
    private FrameLayout chatInputContainer;
    private final Lazy conversationCoordinator$delegate;
    private Boolean deferredSlidesSelectionVisible;
    private final Lazy docArtifactCoordinator$delegate;
    private g45.d editPanelManager;
    private final boolean enableFeishuFlowAIShow;
    private ViewGroup fullScreenChatContainer;
    private final AIChatPluginV2$fullScreenPageLifecycleCallbacks$1 fullScreenPageLifecycleCallbacks;
    private com.larus.office.h hostAbilityProvider;
    private boolean hostControlsRegistered;
    private final Lazy inputCoordinator$delegate;
    private OfficeInputParam inputParams;
    private final Lazy integrationCoordinator$delegate;
    private boolean isDocEmpty;
    private final b loadingCallback;
    private final Lazy navigationCoordinator$delegate;
    private String offlineDocCardMessageId;
    private final MutableLiveData<Boolean> panelActive;
    private final Lazy panelHeightCoordinator$delegate;
    private LifecycleOwner registeredEditPanelOwner;
    private final Lazy sheetSelectionCoordinator$delegate;
    private final Lazy slidesCoordinator$delegate;
    private final Lazy trackCoordinator$delegate;
    private final Lazy visibilityCoordinator$delegate;
    private final Lazy windowCoordinator$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements x2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIChatPluginV2 f362648a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            com.larus.office.h r100 = AIChatPluginV2.access$resolveHostAbilityProvider(this.f362648a);
            if (r100 == null) goto L5;
            r100.O7();
        L5:
            Handler r101 = com.larus.utils.t0.f375468a;
            final AIChatPluginV2 r102 = this.f362648a;
            r101.post(new z1(r102));
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            com.larus.office.h r100 = AIChatPluginV2.access$resolveHostAbilityProvider(this.f362648a);
            if (r100 == null) goto L5;
            r100.qj();
        L5:
            Handler r101 = com.larus.utils.t0.f375468a;
            final AIChatPluginV2 r102 = this.f362648a;
            r101.post(new y1(r102));
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onSSRLoadSuccess() {
            com.larus.office.h r100 = AIChatPluginV2.access$resolveHostAbilityProvider(this.f362648a);
            if (r100 == null) goto L6;
            r100.qj();
            return;
        }

        public b(AIChatPluginV2 r100) {
            this.f362648a = r100;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r100, Throwable r101) {
            FLogger.f375446a.e(AIChatPluginV2.TAG, "Office 文档加载失败, code=" + r100, r101);
            com.larus.office.h r102 = AIChatPluginV2.access$resolveHostAbilityProvider(this.f362648a);
            if (r102 == null) goto L5;
            r102.sk(r100);
        L5:
            Handler r103 = com.larus.utils.t0.f375468a;
            final AIChatPluginV2 r104 = this.f362648a;
            r103.post(new x1(r104));
        }
    }

    static {
        Companion = new a();
    }

    public AIChatPluginV2() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ g45.d A(AIChatPluginV2 r100) {
        return windowCoordinator_delegate$lambda$24$lambda$22(r100);
    }

    public static /* synthetic */ void A0(AIChatPluginV2 r100, String r101) {
        answerStateCoordinator_delegate$lambda$3$lambda$2$lambda$1(r100, r101);
    }

    public static /* synthetic */ OfficeInputParam B(AIChatPluginV2 r100) {
        return docArtifactCoordinator_delegate$lambda$12$lambda$9(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c B0(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.coordinator.runtime.interaction.f C(AIChatPluginV2 r100) {
        return navigationCoordinator_delegate$lambda$50(r100);
    }

    public static /* synthetic */ com.larus.office.h C0(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$54(r100);
    }

    public static /* synthetic */ Unit D(AIChatPluginV2 r100, String r101, boolean r102) {
        return bridgeRegistry_delegate$lambda$72$lambda$70(r100, r101, r102);
    }

    public static /* synthetic */ Context D0(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42$lambda$34(r100);
    }

    public static /* synthetic */ Unit E(AIChatPluginV2 r100, boolean r101) {
        return inputCoordinator_delegate$lambda$42$lambda$40(r100, r101);
    }

    public static /* synthetic */ OfficeInputParam E0(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42$lambda$36(r100);
    }

    public static /* synthetic */ com.larus.office.h G(AIChatPluginV2 r100) {
        return panelHeightCoordinator_delegate$lambda$29$lambda$27(r100);
    }

    public static /* synthetic */ Integer H(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$57(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.coordinator.document.e I(AIChatPluginV2 r100) {
        return sheetSelectionCoordinator_delegate$lambda$6(r100);
    }

    public static /* synthetic */ Context J(AIChatPluginV2 r100) {
        return conversationCoordinator_delegate$lambda$16$lambda$13(r100);
    }

    public static /* synthetic */ OfficeInputParam K(AIChatPluginV2 r100) {
        return sheetSelectionCoordinator_delegate$lambda$6$lambda$4(r100);
    }

    public static /* synthetic */ OfficeChatIntegrationCoordinator M(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68(r100);
    }

    public static /* synthetic */ com.bytedance.ee.bear.document.d N(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$55(r100);
    }

    public static /* synthetic */ OfficeChatBridgeRegistry O(AIChatPluginV2 r100) {
        return bridgeRegistry_delegate$lambda$72(r100);
    }

    public static /* synthetic */ FeishuFlowAIShowResult P(AIChatPluginV2 r100, no9.b r101) {
        return bridgeRegistry_delegate$lambda$72$lambda$71(r100, r101);
    }

    public static /* synthetic */ Unit Q(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42$lambda$41(r100);
    }

    public static /* synthetic */ OfficeInputParam R(AIChatPluginV2 r100) {
        return panelHeightCoordinator_delegate$lambda$29$lambda$25(r100);
    }

    public static /* synthetic */ Unit T(AIChatPluginV2 r100, String r101) {
        return windowCoordinator_delegate$lambda$24$lambda$23(r100, r101);
    }

    public static /* synthetic */ OfficeInputParam U(AIChatPluginV2 r100) {
        return trackCoordinator_delegate$lambda$45$lambda$43(r100);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.t V(AIChatPluginV2 r100) {
        return windowCoordinator_delegate$lambda$24$lambda$19(r100);
    }

    public static /* synthetic */ Unit W(AIChatPluginV2 r100, ChameleonPluginHost r101) {
        return integrationCoordinator_delegate$lambda$68$lambda$67(r100, r101);
    }

    public static /* synthetic */ OfficeInputParam X(AIChatPluginV2 r100) {
        return bridgeRegistry_delegate$lambda$72$lambda$69(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.adapter.g Y(AIChatPluginV2 r100) {
        return docArtifactCoordinator_delegate$lambda$12$lambda$8(r100);
    }

    public static /* synthetic */ OfficeInputParam Z(AIChatPluginV2 r100) {
        return visibilityCoordinator_delegate$lambda$33$lambda$30(r100);
    }

    public static /* synthetic */ boolean a(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$58(r100);
    }

    public static /* synthetic */ ChameleonPluginHost a0(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42$lambda$35(r100);
    }

    public static /* synthetic */ Unit b0(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42$lambda$39(r100);
    }

    public static /* synthetic */ com.larus.office.h c(AIChatPluginV2 r100) {
        return windowCoordinator_delegate$lambda$24$lambda$21(r100);
    }

    public static /* synthetic */ AIEditPlugin c0(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$61(r100);
    }

    public static /* synthetic */ qo9.f d(AIChatPluginV2 r100) {
        return visibilityCoordinator_delegate$lambda$33(r100);
    }

    public static /* synthetic */ OfficeInputParam d0(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$53(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.coordinator.document.c e(AIChatPluginV2 r100) {
        return answerStateCoordinator_delegate$lambda$3(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.adapter.g e0(AIChatPluginV2 r100) {
        return navigationCoordinator_delegate$lambda$50$lambda$49(r100);
    }

    public static /* synthetic */ g45.d f(AIChatPluginV2 r100) {
        return panelHeightCoordinator_delegate$lambda$29$lambda$28(r100);
    }

    public static /* synthetic */ ChameleonPluginHost f0(AIChatPluginV2 r100) {
        return panelHeightCoordinator_delegate$lambda$29$lambda$26(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.coordinator.document.d g(AIChatPluginV2 r100) {
        return docArtifactCoordinator_delegate$lambda$12(r100);
    }

    public static /* synthetic */ FrameLayout g0(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$52(r100);
    }

    public static /* synthetic */ boolean h(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$56(r100);
    }

    public static /* synthetic */ OfficeInputParam h0(AIChatPluginV2 r100) {
        return navigationCoordinator_delegate$lambda$50$lambda$48(r100);
    }

    public static /* synthetic */ ChameleonPluginHost i(AIChatPluginV2 r100) {
        return windowCoordinator_delegate$lambda$24$lambda$18(r100);
    }

    public static /* synthetic */ OfficeInputParam i0(AIChatPluginV2 r100) {
        return windowCoordinator_delegate$lambda$24$lambda$20(r100);
    }

    public static /* synthetic */ Unit j(AIChatPluginV2 r100, String r101) {
        return integrationCoordinator_delegate$lambda$68$lambda$64(r100, r101);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.adapter.g j0(AIChatPluginV2 r100) {
        return trackCoordinator_delegate$lambda$45$lambda$44(r100);
    }

    public static /* synthetic */ qo9.o k(AIChatPluginV2 r100) {
        return windowCoordinator_delegate$lambda$24(r100);
    }

    public static /* synthetic */ ChameleonPluginHost k0(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$51(r100);
    }

    public static /* synthetic */ tr4.a l(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$60(r100);
    }

    public static /* synthetic */ Unit l0(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$63(r100);
    }

    public static /* synthetic */ ChameleonPluginHost m(AIChatPluginV2 r100) {
        return navigationCoordinator_delegate$lambda$50$lambda$47(r100);
    }

    public static /* synthetic */ ChameleonPluginHost m0(AIChatPluginV2 r100) {
        return answerStateCoordinator_delegate$lambda$3$lambda$0(r100);
    }

    public static /* synthetic */ String n(AIChatPluginV2 r100) {
        return docArtifactCoordinator_delegate$lambda$12$lambda$11(r100);
    }

    public static /* synthetic */ Unit n0(AIChatPluginV2 r100, String r101) {
        return answerStateCoordinator_delegate$lambda$3$lambda$2(r100, r101);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.coordinator.document.f o(AIChatPluginV2 r100) {
        return slidesCoordinator_delegate$lambda$7(r100);
    }

    public static /* synthetic */ void p(AIChatPluginV2 r100) {
        setToAiEdit$lambda$76(r100);
    }

    public static /* synthetic */ CoroutineScope p0(AIChatPluginV2 r100) {
        return docArtifactCoordinator_delegate$lambda$12$lambda$10(r100);
    }

    public static /* synthetic */ OfficeChatConversationCoordinator q(AIChatPluginV2 r100) {
        return conversationCoordinator_delegate$lambda$16(r100);
    }

    public static /* synthetic */ com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h q0(AIChatPluginV2 r100) {
        return trackCoordinator_delegate$lambda$45(r100);
    }

    public static /* synthetic */ Context r(AIChatPluginV2 r100) {
        return navigationCoordinator_delegate$lambda$50$lambda$46(r100);
    }

    public static /* synthetic */ CoroutineScope r0(AIChatPluginV2 r100) {
        return conversationCoordinator_delegate$lambda$16$lambda$14(r100);
    }

    public static /* synthetic */ Unit s(AIChatPluginV2 r100, String r101, boolean r102) {
        return integrationCoordinator_delegate$lambda$68$lambda$62(r100, r101, r102);
    }

    public static /* synthetic */ Context s0(AIChatPluginV2 r100) {
        return windowCoordinator_delegate$lambda$24$lambda$17(r100);
    }

    public static /* synthetic */ qo9.c t(AIChatPluginV2 r100) {
        return panelHeightCoordinator_delegate$lambda$29(r100);
    }

    public static /* synthetic */ Unit t0(AIChatPluginV2 r100, com.larus.office.plugins.inputv2.adapter.g r101, long r102) {
        return integrationCoordinator_delegate$lambda$68$lambda$65(r100, r101, r102);
    }

    public static /* synthetic */ boolean u(AIChatPluginV2 r100) {
        return visibilityCoordinator_delegate$lambda$33$lambda$31(r100);
    }

    public static /* synthetic */ ViewGroup u0(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42$lambda$37(r100);
    }

    public static /* synthetic */ Unit v(boolean r100, AIChatPluginV2 r101, String r102) {
        return openFloatChatPanel$lambda$75(r100, r101, r102);
    }

    public static /* synthetic */ boolean v0(AIChatPluginV2 r100) {
        return visibilityCoordinator_delegate$lambda$33$lambda$32(r100);
    }

    public static /* synthetic */ Unit x(AIChatPluginV2 r100, com.larus.office.plugins.inputv2.adapter.g r101, String r102) {
        return integrationCoordinator_delegate$lambda$68$lambda$66(r100, r101, r102);
    }

    public static /* synthetic */ OfficeInputParam x0(AIChatPluginV2 r100) {
        return conversationCoordinator_delegate$lambda$16$lambda$15(r100);
    }

    public static /* synthetic */ Unit y0(AIChatPluginV2 r100) {
        return inputCoordinator_delegate$lambda$42$lambda$38(r100);
    }

    public static /* synthetic */ Unit z(AIChatPluginV2 r100) {
        return sheetSelectionCoordinator_delegate$lambda$6$lambda$5(r100);
    }

    public static /* synthetic */ OfficeInputParam z0(AIChatPluginV2 r100) {
        return integrationCoordinator_delegate$lambda$68$lambda$59(r100);
    }

    @Override // g45.a
    public String getPanelName() {
        return CHAT_PANEL_NAME;
    }

    @Override // com.bytedance.ee.bear.document.ability.IAIChatInputPlugin
    public boolean isActionBarVisible() {
        boolean r100 = resolveCurrentActionBarVisible(false);
        this.actionBarVisible = r100;
        return r100;
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
    }

    @Override // com.larus.office.c
    public void onChatListFoldStatusChanger(boolean r100) {
    }

    @Override // com.larus.office.c
    public boolean onMoreButtonClicked() {
        return false;
    }

    @Override // com.larus.office.c
    public void onNewOfficePageCreated() {
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public void onReferenceCleared() {
    }

    @Override // g45.a
    public void requestNotFocus(Context r100) {
    }

    private final com.larus.office.plugins.inputv2.coordinator.document.c getAnswerStateCoordinator() {
        return (com.larus.office.plugins.inputv2.coordinator.document.c) this.answerStateCoordinator$delegate.getValue();
    }

    private final OfficeChatBridgeRegistry getBridgeRegistry() {
        return (OfficeChatBridgeRegistry) this.bridgeRegistry$delegate.getValue();
    }

    private final OfficeChatConversationCoordinator getConversationCoordinator() {
        return (OfficeChatConversationCoordinator) this.conversationCoordinator$delegate.getValue();
    }

    private final com.larus.office.plugins.inputv2.coordinator.document.d getDocArtifactCoordinator() {
        return (com.larus.office.plugins.inputv2.coordinator.document.d) this.docArtifactCoordinator$delegate.getValue();
    }

    private final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c getInputCoordinator() {
        return (com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c) this.inputCoordinator$delegate.getValue();
    }

    private final OfficeChatIntegrationCoordinator getIntegrationCoordinator() {
        return (OfficeChatIntegrationCoordinator) this.integrationCoordinator$delegate.getValue();
    }

    private final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.f getNavigationCoordinator() {
        return (com.larus.office.plugins.inputv2.coordinator.runtime.interaction.f) this.navigationCoordinator$delegate.getValue();
    }

    private final qo9.c getPanelHeightCoordinator() {
        return (qo9.c) this.panelHeightCoordinator$delegate.getValue();
    }

    private final com.larus.office.plugins.inputv2.coordinator.document.e getSheetSelectionCoordinator() {
        return (com.larus.office.plugins.inputv2.coordinator.document.e) this.sheetSelectionCoordinator$delegate.getValue();
    }

    private final com.larus.office.plugins.inputv2.coordinator.document.f getSlidesCoordinator() {
        return (com.larus.office.plugins.inputv2.coordinator.document.f) this.slidesCoordinator$delegate.getValue();
    }

    private final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h getTrackCoordinator() {
        return (com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h) this.trackCoordinator$delegate.getValue();
    }

    private final qo9.f getVisibilityCoordinator() {
        return (qo9.f) this.visibilityCoordinator$delegate.getValue();
    }

    private final qo9.o getWindowCoordinator() {
        return (qo9.o) this.windowCoordinator$delegate.getValue();
    }

    private final String resolveCurrentDefaultScene() {
        OfficeInputParam r100 = this.inputParams;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getType();
    L7:
        if (Intrinsics.areEqual(r102, DocumentType.DOCX_NAME) == true) goto L9;
    L11:
        int r103 = a2.f362666a;
        OfficeInputParam r104 = this.inputParams;
        if (r104 == null) goto L14;
        String r105 = r104.getType();
    L15:
        if (r105 == null) goto L36;
        switch(r105.hashCode()) {
            case -899647262: goto L32;
            case 3016401: goto L28;
            case 3088960: goto L24;
            case 109403487: goto L20;
            default: goto L36;
        };
    L20:
        if (r105.equals(DocumentType.SHEET_NAME) == false) goto L36;
        r101 = "aisheet_detail";
        goto L36
    L24:
        if (r105.equals(DocumentType.DOCX_NAME) == false) goto L36;
        r101 = "doc_exist_content";
        goto L36
    L28:
        if (r105.equals("base") == false) goto L36;
        r101 = "base_detail";
        goto L36
    L32:
        if (r105.equals("slides") == false) goto L36;
        r101 = "aippt_new_detail";
    L36:
        return r101;
    L14:
        r105 = null;
        goto L15
    L9:
        if (this.isDocEmpty == false) goto L11;
        return "doc_create_empty";
    L5:
        r102 = null;
        goto L7
    }

    private final com.larus.office.h resolveHostAbilityProvider() {
        com.larus.office.h r100 = this.hostAbilityProvider;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ChameleonPluginHost r101 = getHost();
        if (r101 == null) goto L10;
        com.larus.office.h r102 = (com.larus.office.h) r101.getHostAbilityOrNull(com.larus.office.h.class);
        if (r102 == null) goto L10;
        this.hostAbilityProvider = r102;
        return r102;
    L10:
        return null;
    }

    private final void unregisterHostControls() {
        Object r100 = ServiceManager.get().getService(IOfficeSdkService.class);
        if ((r100 instanceof OfficeSdkServiceImpl) == false) goto L5;
        OfficeSdkServiceImpl r101 = (OfficeSdkServiceImpl) r100;
    L6:
        if (r101 == null) goto L8;
        r101.m(this);
    L8:
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c r102 = getInputCoordinator();
        fo9.a r103 = r102.f362954m;
        if (r103 == null) goto L11;
        r103.vP(r102.f362957p);
    L11:
        r102.f362954m = null;
        getWindowCoordinator().f534305g.d();
        com.larus.office.h r104 = this.hostAbilityProvider;
        if (r104 == null) goto L14;
        r104.V5(this);
    L14:
        com.larus.office.h r105 = this.hostAbilityProvider;
        if (r105 == null) goto L17;
        r105.Pj(this);
    L17:
        this.hostAbilityProvider = null;
        this.editPanelManager = null;
        this.registeredEditPanelOwner = null;
        this.hostControlsRegistered = false;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        OfficeInputParam r100 = this.inputParams;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    L10:
        return KeyboardShowingStatusMode.FOLLOW_KEYBOARD;
    L5:
        if (r100.getResourceType() != 9) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.larus.office.plugins.input.m1
    public void notifyInterruptConversation() {
        OfficeInputParam r100 = this.inputParams;
        if (r100 == null) goto L9;
        String r101 = r100.getConversationId();
        if (r101 == null) goto L10;
        IConversationRepoService.a.f(zh8.a.f572197b, r101, false, true, OmniBreakReason.OmniBreakReason_CHAT_CONTAINER_EXIT, 2);
        return;
    L10:
        return;
    }

    private final void enterStreamEditFromInput() {
        ChameleonPluginHost r100 = getHost();
        if (r100 == null) goto L8;
        AIEditPlugin r101 = (AIEditPlugin) r100.findPlugin(AIEditPlugin.class);
        if (r101 == null) goto L9;
        r101.enterStreamEditIfNeeded();
        return;
    L9:
        return;
    }

    private final boolean isEmbeddedAIChatSuppressed() {
        return getWindowCoordinator().f534305g.e();
    }

    @Override // com.larus.office.plugins.input.q1
    public boolean canEditForOfficeInputHint() {
        fo9.a r100 = getInputCoordinator().a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.canEdit() != true) goto L7;
        return true;
    }

    public void enterStreamEditModeIfNeeded() {
        ChameleonPluginHost r100 = getHost();
        if (r100 == null) goto L8;
        AIEditPlugin r101 = (AIEditPlugin) r100.findPlugin(AIEditPlugin.class);
        if (r101 == null) goto L9;
        r101.enterStreamEditIfNeeded();
        return;
    L9:
        return;
    }

    @Override // com.larus.office.plugins.input.m1
    public int getAIEditState() {
        return getAnswerStateCoordinator().f362778d;
    }

    @Override // com.larus.office.plugins.input.u1
    public String getAttachedScene() {
        String r100 = getCurrentScene();
        if (isFloatChatAttached() == true) goto L7;
        return null;
    L7:
        return r100;
    }

    @Override // com.larus.office.plugins.input.q1
    public String getCurrentScene() {
        OfficeChatConversationCoordinator r100 = getConversationCoordinator();
        com.larus.office.plugins.inputv2.adapter.g r101 = r100.f362817e;
        if (r101 == null) goto L9;
        jo9.g r102 = (jo9.g) r101.g(jo9.g.class);
        if (r102 == null) goto L9;
        String r103 = r102.getCurScene();
        if (r103 == null) goto L9;
    L10:
        if (r103 == null) goto L12;
        return r103;
    L12:
        return resolveCurrentDefaultScene();
    L9:
        r103 = r100.f362820h;
        goto L10
    }

    public String getDocViewType() {
        return getTrackCoordinator().f362975g;
    }

    public int getFloatChatShowPercent() {
        return getWindowCoordinator().f534317s;
    }

    @Override // com.larus.office.plugins.input.m1, com.larus.office.plugins.input.u1
    public String getLatestDocMessageId() {
        return getDocArtifactCoordinator().b();
    }

    public boolean isFloatChatAttached() {
        com.larus.office.plugins.inputv2.adapter.g r100 = getIntegrationCoordinator().f362872o;
        if (r100 == null) goto L10;
        Fragment r101 = r100.f362678a;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isAdded() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.larus.office.plugins.input.o1
    public void jumpToChatPageFromMorePanel() {
        getNavigationCoordinator().b();
    }

    @Override // com.larus.office.plugins.input.m1
    public void notifyPanelHeightChanged() {
        getPanelHeightCoordinator().c();
    }

    @Override // com.larus.office.plugins.input.m1
    public void onAIEditStateIdle() {
        com.larus.office.plugins.inputv2.coordinator.document.c r100 = getAnswerStateCoordinator();
        if (r100.f362778d == 0) goto L7;
        r100.f362778d = 0;
        return;
    }

    @Override // com.larus.office.c
    public boolean onBackPressed() {
        qo9.o r100 = getWindowCoordinator();
        if (r100.f534311m == false) goto L17;
        com.larus.office.plugins.inputv2.adapter.g r101 = r100.f534309k;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L18;
        com.larus.office.plugins.inputv2.adapter.g r103 = r100.f534309k;
        if (r103 == null) goto L15;
        r103.c("OfficeChatWindow");
    L15:
        return true;
    L18:
        return false;
    L7:
        if (r101.i() != true) goto L9;
        r102 = true;
        goto L10
    L17:
        return false;
    }

    @Override // com.larus.office.plugins.input.s1
    public void onSlidesRenderFinished() {
        getSlidesCoordinator().getClass();
    }

    @Override // com.larus.office.plugins.input.s1
    public void onSlidesRenderStarted() {
        getSlidesCoordinator().getClass();
    }

    @Override // com.larus.office.plugins.input.m1
    public void setToAiEdit() {
        getVisibilityCoordinator().b(FROM_AI_EDIT, true);
        com.larus.office.plugins.inputv2.adapter.g r100 = getIntegrationCoordinator().f362872o;
        if (r100 == null) goto L5;
        r100.o();
    L5:
        com.larus.utils.t0.d(new m0(this), 500);
    }

    @Override // g45.a
    public LiveData<Boolean> getActive() {
        return this.panelActive;
    }

    @Override // com.larus.office.plugins.input.u1
    public OfficeInputParam getInputParams() {
        return this.inputParams;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.office.plugins.inputv2.AIChatPluginV2$fullScreenPageLifecycleCallbacks$1] */
    public AIChatPluginV2(boolean r100) {
        this.enableFeishuFlowAIShow = r100;
        this.actionBarVisible = true;
        this.fullScreenPageLifecycleCallbacks = new AIChatPluginV2$fullScreenPageLifecycleCallbacks$1(this);
        this.panelActive = new MutableLiveData(Boolean.FALSE);
        this.answerStateCoordinator$delegate = LazyKt.lazy(new k(this));
        this.sheetSelectionCoordinator$delegate = LazyKt.lazy(new p(this));
        this.slidesCoordinator$delegate = LazyKt.lazy(new q(this));
        this.docArtifactCoordinator$delegate = LazyKt.lazy(new r(this));
        this.conversationCoordinator$delegate = LazyKt.lazy(new s(this));
        this.windowCoordinator$delegate = LazyKt.lazy(new t(this));
        this.panelHeightCoordinator$delegate = LazyKt.lazy(new u(this));
        this.visibilityCoordinator$delegate = LazyKt.lazy(new v(this));
        this.inputCoordinator$delegate = LazyKt.lazy(new x(this));
        this.trackCoordinator$delegate = LazyKt.lazy(new y(this));
        this.navigationCoordinator$delegate = LazyKt.lazy(new m(this));
        this.integrationCoordinator$delegate = LazyKt.lazy(new n(this));
        this.bridgeRegistry$delegate = LazyKt.lazy(new o(this));
        this.loadingCallback = new b(this);
    }

    public static final /* synthetic */ void access$enterStreamEditFromInput(AIChatPluginV2 r100) {
        r100.enterStreamEditFromInput();
    }

    public static final /* synthetic */ OfficeChatIntegrationCoordinator access$getIntegrationCoordinator(AIChatPluginV2 r100) {
        return r100.getIntegrationCoordinator();
    }

    public static final /* synthetic */ com.larus.office.plugins.inputv2.coordinator.document.e access$getSheetSelectionCoordinator(AIChatPluginV2 r100) {
        return r100.getSheetSelectionCoordinator();
    }

    public static final /* synthetic */ com.larus.office.plugins.inputv2.coordinator.document.f access$getSlidesCoordinator(AIChatPluginV2 r100) {
        return r100.getSlidesCoordinator();
    }

    public static final /* synthetic */ com.larus.office.h access$resolveHostAbilityProvider(AIChatPluginV2 r100) {
        return r100.resolveHostAbilityProvider();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.u1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.v1] */
    private static final com.larus.office.plugins.inputv2.coordinator.document.c answerStateCoordinator_delegate$lambda$3(final AIChatPluginV2 r100) {
        return new com.larus.office.plugins.inputv2.coordinator.document.c(new u1(r100), new v1(r100));
    }

    private static final ChameleonPluginHost answerStateCoordinator_delegate$lambda$3$lambda$0(AIChatPluginV2 r100) {
        return r100.getHost();
    }

    private final void applyVisibilityResult(qo9.f.a r100) {
        qo9.o r101 = getWindowCoordinator();
        r101.f534305g.a(r100.f534286b);
        qo9.o r102 = getWindowCoordinator();
        boolean r103 = r100.f534285a;
        String r104 = r100.f534288d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "reason");
        com.larus.office.plugins.inputv2.adapter.g r105 = r102.f534309k;
        boolean r106 = false;
        if (r105 == null) goto L11;
        int r107 = com.larus.office.plugins.inputv2.adapter.g.f362677s;
        String r108 = "更新输入框显隐失败, visible=" + r103;
        if (r105.f362693p == true) goto L11;
        r105.f362679b.s70(r103, false);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", r108, th);
    L11:
        com.larus.office.plugins.inputv2.adapter.g r109 = r102.f534309k;
        if (r109 != null) goto L14;
    L19:
        if (r103 == false) goto L21;
    L26:
        MutableLiveData<Boolean> r110 = this.panelActive;
        if (r100.f534285a == true) goto L29;
    L31:
        r110.setValue(Boolean.valueOf(r106));
        getPanelHeightCoordinator().d(r100.f534285a, r100.f534287c);
        return;
    L29:
        if (getInputCoordinator().f362956o == false) goto L31;
        r106 = true;
        goto L31
    L21:
        if (r102.f534311m == false) goto L26;
        com.larus.office.plugins.inputv2.adapter.g r111 = r102.f534309k;
        if (r111 == null) goto L25;
        r111.c("visibility_hidden#" + r104);
    L25:
        r102.h(false, "visibility_hidden#" + r104, false);
        goto L26
    L14:
        if (r109.i() == false) goto L19;
        va8.o r112 = (va8.o) r109.e(va8.o.class);
        if (r112 == null) goto L19;
        r112.CJ(r103, null, false);
        goto L19
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.a] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.office.plugins.inputv2.l] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.office.plugins.inputv2.w] */
    private static final OfficeChatBridgeRegistry bridgeRegistry_delegate$lambda$72(final AIChatPluginV2 r110) {
        return new OfficeChatBridgeRegistry(r110.enableFeishuFlowAIShow, new com.larus.office.plugins.inputv2.a(r110), new AIChatPluginV2$bridgeRegistry$2$2(r110.getVisibilityCoordinator()), new AIChatPluginV2$bridgeRegistry$2$3(r110), new l(r110), new AIChatPluginV2$bridgeRegistry$2$5(r110.getAnswerStateCoordinator()), new AIChatPluginV2$bridgeRegistry$2$6(r110.getTrackCoordinator()), new w(r110));
    }

    private static final OfficeInputParam bridgeRegistry_delegate$lambda$72$lambda$69(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.i1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.j1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.k1] */
    private static final OfficeChatConversationCoordinator conversationCoordinator_delegate$lambda$16(final AIChatPluginV2 r100) {
        return new OfficeChatConversationCoordinator(new i1(r100), new j1(r100), new k1(r100));
    }

    private static final Context conversationCoordinator_delegate$lambda$16$lambda$13(AIChatPluginV2 r100) {
        ChameleonPluginHost r101 = r100.getHost();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getContext();
    }

    private static final CoroutineScope conversationCoordinator_delegate$lambda$16$lambda$14(AIChatPluginV2 r100) {
        ChameleonPluginHost r101 = r100.getHost();
        if (r101 == null) goto L11;
        Fragment r102 = r101.getFragment();
        if (r102 == null) goto L11;
        LiveData<LifecycleOwner> r103 = r102.getViewLifecycleOwnerLiveData();
        if (r103 == null) goto L11;
        LifecycleOwner r104 = r103.getValue();
        if (r104 == null) goto L11;
        return LifecycleOwnerKt.getLifecycleScope(r104);
    L11:
        return null;
    }

    private static final OfficeInputParam conversationCoordinator_delegate$lambda$16$lambda$15(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.l1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.m1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.n1] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.office.plugins.inputv2.p1] */
    private static final com.larus.office.plugins.inputv2.coordinator.document.d docArtifactCoordinator_delegate$lambda$12(final AIChatPluginV2 r100) {
        return new com.larus.office.plugins.inputv2.coordinator.document.d(new l1(r100), new m1(r100), new n1(r100), new p1(r100));
    }

    private static final CoroutineScope docArtifactCoordinator_delegate$lambda$12$lambda$10(AIChatPluginV2 r100) {
        ChameleonPluginHost r101 = r100.getHost();
        if (r101 == null) goto L11;
        Fragment r102 = r101.getFragment();
        if (r102 == null) goto L11;
        LiveData<LifecycleOwner> r103 = r102.getViewLifecycleOwnerLiveData();
        if (r103 == null) goto L11;
        LifecycleOwner r104 = r103.getValue();
        if (r104 == null) goto L11;
        return LifecycleOwnerKt.getLifecycleScope(r104);
    L11:
        return null;
    }

    private static final String docArtifactCoordinator_delegate$lambda$12$lambda$11(AIChatPluginV2 r100) {
        return r100.offlineDocCardMessageId;
    }

    private static final com.larus.office.plugins.inputv2.adapter.g docArtifactCoordinator_delegate$lambda$12$lambda$8(AIChatPluginV2 r100) {
        return r100.getIntegrationCoordinator().f362872o;
    }

    private static final OfficeInputParam docArtifactCoordinator_delegate$lambda$12$lambda$9(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.z] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.a0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.b0] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.office.plugins.inputv2.c0] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.office.plugins.inputv2.d0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.office.plugins.inputv2.e0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.office.plugins.inputv2.f0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.office.plugins.inputv2.g0] */
    private static final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c inputCoordinator_delegate$lambda$42(final AIChatPluginV2 r110) {
        return new com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c(new z(r110), new a0(r110), new b0(r110), new c0(r110), new AIChatPluginV2$inputCoordinator$2$5(r110), new d0(r110), new e0(r110), new f0(r110), new g0(r110), new AIChatPluginV2$inputCoordinator$2$10(r110), new AIChatPluginV2$inputCoordinator$2$11(r110));
    }

    private static final Context inputCoordinator_delegate$lambda$42$lambda$34(AIChatPluginV2 r100) {
        return r100.getContext();
    }

    private static final ChameleonPluginHost inputCoordinator_delegate$lambda$42$lambda$35(AIChatPluginV2 r100) {
        return r100.getHost();
    }

    private static final OfficeInputParam inputCoordinator_delegate$lambda$42$lambda$36(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final ViewGroup inputCoordinator_delegate$lambda$42$lambda$37(AIChatPluginV2 r100) {
        return r100.fullScreenChatContainer;
    }

    private static final Unit inputCoordinator_delegate$lambda$42$lambda$38(AIChatPluginV2 r100) {
        r100.getWindowCoordinator().e("landscape_input_touched");
        return Unit.INSTANCE;
    }

    private static final Unit inputCoordinator_delegate$lambda$42$lambda$39(AIChatPluginV2 r100) {
        r100.getWindowCoordinator().e("landscape_input_focused");
        return Unit.INSTANCE;
    }

    private static final Unit inputCoordinator_delegate$lambda$42$lambda$41(AIChatPluginV2 r100) {
        qo9.f r101 = r100.getVisibilityCoordinator();
        r101.getClass();
        Intrinsics.checkNotNullParameter("permission", "reason");
        r101.a("permission");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.office.plugins.inputv2.f1] */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.larus.office.plugins.inputv2.r0] */
    /* JADX WARN: Type inference failed for: r13v1, types: [com.larus.office.plugins.inputv2.t0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.p0] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.office.plugins.inputv2.y0] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.office.plugins.inputv2.u0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.office.plugins.inputv2.z0] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.office.plugins.inputv2.v0] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.office.plugins.inputv2.a1] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.office.plugins.inputv2.g1] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.larus.office.plugins.inputv2.w0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.office.plugins.inputv2.b1] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.office.plugins.inputv2.x0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.office.plugins.inputv2.c1] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.office.plugins.inputv2.e1] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.office.plugins.inputv2.h1] */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.larus.office.plugins.inputv2.q0] */
    private static final OfficeChatIntegrationCoordinator integrationCoordinator_delegate$lambda$68(final AIChatPluginV2 r110) {
        return new OfficeChatIntegrationCoordinator(new com.larus.office.plugins.inputv2.coordinator.runtime.integration.h(new p0(r110), new y0(r110), new z0(r110), new a1(r110), new b1(r110), new c1(r110), new e1(r110), new f1(r110)), new com.larus.office.plugins.inputv2.coordinator.runtime.integration.e(r110.getConversationCoordinator(), r110.getTrackCoordinator(), new com.larus.office.plugins.inputv2.coordinator.runtime.integration.u(new g1(r110), r110.enableFeishuFlowAIShow, new com.larus.office.plugins.inputv2.coordinator.runtime.integration.u.a(new so9.a(new h1(r110)), r110.getAnswerStateCoordinator(), r110.getSheetSelectionCoordinator(), r110.getTrackCoordinator(), new q0(r110)), new com.larus.office.plugins.inputv2.coordinator.runtime.integration.u.b(new AIChatPluginV2$integrationCoordinator$2$12(r110), new r0(r110), new t0(r110)))), new com.larus.office.plugins.inputv2.coordinator.runtime.integration.f(new u0(r110)), new com.larus.office.plugins.inputv2.coordinator.runtime.integration.g(new v0(r110), new w0(r110), new x0(r110)));
    }

    private static final ChameleonPluginHost integrationCoordinator_delegate$lambda$68$lambda$51(AIChatPluginV2 r100) {
        return r100.getHost();
    }

    private static final FrameLayout integrationCoordinator_delegate$lambda$68$lambda$52(AIChatPluginV2 r100) {
        return r100.chatInputContainer;
    }

    private static final OfficeInputParam integrationCoordinator_delegate$lambda$68$lambda$53(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final com.larus.office.h integrationCoordinator_delegate$lambda$68$lambda$54(AIChatPluginV2 r100) {
        return r100.hostAbilityProvider;
    }

    private static final com.bytedance.ee.bear.document.d integrationCoordinator_delegate$lambda$68$lambda$55(AIChatPluginV2 r100) {
        return r100.getDocumentMetadata();
    }

    private static final boolean integrationCoordinator_delegate$lambda$68$lambda$56(AIChatPluginV2 r100) {
        return r100.getWindowCoordinator().f534305g.e();
    }

    private static final Integer integrationCoordinator_delegate$lambda$68$lambda$57(AIChatPluginV2 r100) {
        qo9.o r101 = r100.getWindowCoordinator();
        Integer r102 = r101.f534305g.L();
        if (r102 == null) goto L5;
        return r102;
    L5:
        return r101.f();
    }

    private static final boolean integrationCoordinator_delegate$lambda$68$lambda$58(AIChatPluginV2 r100) {
        com.bytedance.ee.bear.document.d r101 = r100.getDocumentMetadata();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getDocumentTypeValue());
    L9:
        if (r102 == null) goto L11;
        int r103 = com.larus.office.experiment.d.f362172a;
        return com.larus.office.experiment.d.a(r102.intValue());
    L11:
        return false;
    L5:
        OfficeInputParam r104 = r100.inputParams;
        if (r104 == null) goto L8;
        r102 = r104.getObjType();
        goto L9
    L8:
        r102 = null;
        goto L9
    }

    private static final OfficeInputParam integrationCoordinator_delegate$lambda$68$lambda$59(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final tr4.a integrationCoordinator_delegate$lambda$68$lambda$60(AIChatPluginV2 r100) {
        ChameleonPluginHost r101 = r100.getHost();
        if (r101 == null) goto L7;
        tr4.b r102 = (tr4.b) r101.getHostAbilityOrNull(tr4.b.class);
        if (r102 == null) goto L7;
        return r102.getBitableContext();
    L7:
        return null;
    }

    private static final AIEditPlugin integrationCoordinator_delegate$lambda$68$lambda$61(AIChatPluginV2 r100) {
        ChameleonPluginHost r101 = r100.getHost();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (AIEditPlugin) r101.findPlugin(AIEditPlugin.class);
    }

    private static final Unit integrationCoordinator_delegate$lambda$68$lambda$63(AIChatPluginV2 r100) {
        qo9.f r101 = r100.getVisibilityCoordinator();
        r101.getClass();
        Intrinsics.checkNotNullParameter("prepare_preview#biz.flowAI.show", "reason");
        r101.f534280e = true;
        r101.a("prepare_preview#biz.flowAI.show");
        r100.getWindowCoordinator().d("prepare_preview#biz.flowAI.show");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.q1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.r1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.s1] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.office.plugins.inputv2.t1] */
    private static final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.f navigationCoordinator_delegate$lambda$50(final AIChatPluginV2 r100) {
        return new com.larus.office.plugins.inputv2.coordinator.runtime.interaction.f(new q1(r100), new r1(r100), new s1(r100), new AIChatPluginV2$navigationCoordinator$2$4(r100), new t1(r100), new AIChatPluginV2$navigationCoordinator$2$6(r100));
    }

    private static final Context navigationCoordinator_delegate$lambda$50$lambda$46(AIChatPluginV2 r100) {
        Context r101 = r100.getContext();
        if (r101 != null) goto L11;
        ChameleonPluginHost r102 = r100.getHost();
        if (r102 == null) goto L9;
        Fragment r103 = r102.getFragment();
        if (r103 == null) goto L9;
        return r103.getContext();
    L9:
        return null;
    L11:
        return r101;
    }

    private static final ChameleonPluginHost navigationCoordinator_delegate$lambda$50$lambda$47(AIChatPluginV2 r100) {
        return r100.getHost();
    }

    private static final OfficeInputParam navigationCoordinator_delegate$lambda$50$lambda$48(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final com.larus.office.plugins.inputv2.adapter.g navigationCoordinator_delegate$lambda$50$lambda$49(AIChatPluginV2 r100) {
        return r100.getIntegrationCoordinator().f362872o;
    }

    private final void onInputNotReady(dw8.a r100) {
        FLogger.f375446a.i(TAG, "新版输入框 not-ready, generation=" + r100.f470326a);
        this.panelActive.setValue(Boolean.FALSE);
        getPanelHeightCoordinator().d(false, true);
        getWindowCoordinator().c("inner_not_ready");
    }

    private final void onInputReady(dw8.a r110) {
        FLogger.f375446a.i(TAG, "新版输入框 ready, generation=" + r110.f470326a);
        qo9.f r100 = getVisibilityCoordinator();
        r100.getClass();
        Intrinsics.checkNotNullParameter("ready", "reason");
        r100.a("ready");
        qo9.o r101 = getWindowCoordinator();
        boolean r102 = this.actionBarVisible;
        com.larus.office.plugins.inputv2.adapter.g r103 = r101.f534309k;
        if (r103 == null) goto L7;
        va8.k r104 = (va8.k) r103.e(va8.k.class);
        if (r104 == null) goto L7;
        r104.eV(r101.f534308j);
    L7:
        com.larus.office.plugins.inputv2.adapter.g r105 = r101.f534309k;
        if (r105 == null) goto L12;
        va8.g0 r106 = (va8.g0) r105.e(va8.g0.class);
        if (r106 == null) goto L12;
        r106.Iq(r102);
    L12:
        com.larus.office.plugins.inputv2.adapter.g r107 = r101.f534309k;
        if (r107 != null) goto L15;
    L32:
        FloatChatWindowState r108 = FloatChatWindowState.Collapsed;
    L33:
        r101.f534312n = r108;
        boolean r109 = false;
        if (r108 != FloatChatWindowState.Expanded) goto L36;
        boolean r111 = true;
    L37:
        r101.h(r111, "ready", true);
        OfficeChatConversationCoordinator r112 = getConversationCoordinator();
        String r113 = resolveCurrentDefaultScene();
        r112.f362820h = r113;
        com.larus.office.plugins.inputv2.adapter.g r114 = r112.f362817e;
        if (r114 == null) goto L42;
        jo9.g r115 = (jo9.g) r114.g(jo9.g.class);
        if (r115 == null) goto L42;
        r115.a5(r113);
    L42:
        getConversationCoordinator().f362823k.c();
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h r116 = getTrackCoordinator();
        OfficeInputParam r117 = r116.f362969a.invoke();
        if (r117 == null) goto L45;
        String r118 = r117.getType();
    L47:
        if (r118 == null) goto L66;
        int r119 = r118.hashCode();
        if (r119 == (-899647262)) goto L63;
        if (r119 == 3088960) goto L60;
        if (r119 != 109403487) goto L66;
        if (r118.equals(DocumentType.SHEET_NAME) == false) goto L66;
        String r120 = "SHEETAISidebar";
    L67:
        r116.c(r120);
        com.larus.office.plugins.inputv2.coordinator.document.e r121 = getSheetSelectionCoordinator();
        long r122 = r110.f470326a;
        if (r121.f362791d == false) goto L70;
        r121.a("input_ready#" + r122);
    L84:
        com.larus.office.plugins.inputv2.coordinator.document.f r123 = getSlidesCoordinator();
        r123.b();
        r123.a("input_ready");
        if (getVisibilityCoordinator().f534284i == false) goto L108;
        OfficeChatConversationCoordinator r124 = getConversationCoordinator();
        long r125 = getIntegrationCoordinator().f362871n;
        OfficeChatConversationCachePromotionStore r126 = r124.f362822j;
        if (r125 != r124.f362816d) goto L89;
        boolean r127 = true;
    L90:
        String r128 = r126.f362808d;
        if (r128 == null) goto L103;
        if (r127 == false) goto L102;
        OfficeInputParam r129 = r126.f362805a.invoke();
        if (r129 == null) goto L97;
        String r130 = r129.getConversationId();
    L99:
        if (Intrinsics.areEqual(r130, r128) == false) goto L102;
        r126.f362808d = null;
        r109 = true;
        goto L103
    L97:
        r130 = null;
    L102:
        r126.f362808d = null;
    L103:
        if (r109 == false) goto L109;
        openFloatChatPanel(FROM_CONVERSATION_RED_DOT);
        return;
    L109:
        return;
    L89:
        r127 = false;
        goto L90
    L108:
        return;
    L70:
        String r131 = "input_ready#" + r122;
        OfficeInputParam r132 = r121.f362788a.invoke();
        if (r132 == null) goto L73;
        String r133 = r132.getType();
    L75:
        if (Intrinsics.areEqual(r133, DocumentType.SHEET_NAME) == false) goto L84;
        String r134 = r121.f362795h;
        if (r134 == null) goto L84;
        if (Intrinsics.areEqual(r121.f362798k, r132.getResourceId()) == true) goto L83;
        r121.b("resource_changed#" + r131);
        goto L84
    L83:
        r121.f362791d = true;
        r121.f362792e = r134;
        r121.f362793f = r121.f362796i;
        r121.f362794g = r121.f362797j;
        r121.a("replay#" + r131);
        goto L84
    L73:
        r133 = null;
        goto L75
    L60:
        if (r118.equals(DocumentType.DOCX_NAME) == false) goto L66;
        r120 = "DOCAISidebar";
        goto L67
    L63:
        if (r118.equals("slides") == false) goto L66;
        r120 = "SLIDESAISidebar";
    L66:
        r120 = null;
        goto L67
    L45:
        r118 = null;
        goto L47
    L36:
        r111 = false;
        goto L37
    L15:
        if (r107.f362693p == false) goto L106;
        dw8.n r135 = null;
    L28:
        if (r135 == null) goto L32;
        r108 = r135.f470354b;
        if (r108 == null) goto L32;
    L106:
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L19
        Object r137 = Result.m9449constructorimpl(r107.f362679b.u6());     // Catch: Throwable -> L19
    L21:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L25;
        FLogger.f375446a.e("OfficeChatInputAdapter", "获取对话面板状态失败", r138);
    L25:
        if (Result.m9455isFailureimpl(r137) == false) goto L27;
        r137 = null;
    L27:
        r135 = (dw8.n) r137;
    L19:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final void onSlidesSelectionVisibilityChanged(boolean r100) {
        ChameleonPluginHost r101 = getHost();
        boolean r102 = true;
        if (r101 == null) goto L9;
        Fragment r103 = r101.getFragment();
        if (r103 == null) goto L9;
        if (r103.isAdded() != true) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L12;
        return;
    L12:
        ChameleonPluginHost r105 = getHost();
        if (r105 == null) goto L19;
        SetFullscreenPlugin r106 = (SetFullscreenPlugin) r105.findPlugin(SetFullscreenPlugin.class);
        if (r106 == null) goto L19;
        if (r106.isInFullScreenMode() != true) goto L19;
    L20:
        if (r102 == false) goto L23;
        this.deferredSlidesSelectionVisible = Boolean.valueOf(r100);
        return;
    L23:
        this.deferredSlidesSelectionVisible = null;
        getVisibilityCoordinator().b(SOURCE_SLIDES_SELECTION, r100);
        return;
    L19:
        r102 = false;
    L9:
        r104 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.h0] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.s0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.d1] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.office.plugins.inputv2.o1] */
    private static final qo9.c panelHeightCoordinator_delegate$lambda$29(final AIChatPluginV2 r100) {
        return new qo9.c(new h0(r100), new s0(r100), new d1(r100), new o1(r100));
    }

    private static final OfficeInputParam panelHeightCoordinator_delegate$lambda$29$lambda$25(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final ChameleonPluginHost panelHeightCoordinator_delegate$lambda$29$lambda$26(AIChatPluginV2 r100) {
        return r100.getHost();
    }

    private static final com.larus.office.h panelHeightCoordinator_delegate$lambda$29$lambda$27(AIChatPluginV2 r100) {
        return r100.hostAbilityProvider;
    }

    private static final g45.d panelHeightCoordinator_delegate$lambda$29$lambda$28(AIChatPluginV2 r100) {
        return r100.editPanelManager;
    }

    private final void refreshHostRegistration(String r100) {
        ChameleonPluginHost r101 = getHost();
        unregisterHostControls();
        registerHostControls(r101);
        FLogger.f375446a.i(TAG, "刷新宿主注册, reason=" + r100);
    }

    private final void registerHostControls(ChameleonPluginHost r100) {
        if (this.hostControlsRegistered == false) goto L5;
        return;
    L5:
        com.larus.office.h r101 = resolveHostAbilityProvider();
        Integer r102 = null;
        if (r101 != null) goto L10;
        if (r100 == null) goto L9;
        r101 = (com.larus.office.h) r100.getHostAbilityOrNull(com.larus.office.h.class);
        goto L10
    L9:
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        r101.R9(this);
        r101.S9(this);
        onActionButtonVisibilityChanged(resolveCurrentActionBarVisible(false));
    L13:
        this.hostAbilityProvider = r101;
        if (r100 == null) goto L16;
        g45.d r103 = (g45.d) r100.getHostAbilityOrNull(g45.d.class);
    L17:
        this.editPanelManager = r103;
        if (r100 == null) goto L32;
        Fragment r104 = r100.getFragment();
        if (r104 == null) goto L32;
        LiveData<LifecycleOwner> r105 = r104.getViewLifecycleOwnerLiveData();
        if (r105 == null) goto L32;
        LifecycleOwner r106 = r105.getValue();
        if (r106 == null) goto L32;
        if (this.registeredEditPanelOwner == r106) goto L32;
        this.registeredEditPanelOwner = r106;
        g45.d r107 = this.editPanelManager;
        if (r107 == null) goto L32;
        r107.registerEditPanel(r106, this);
    L32:
        if (isEmbeddedAIChatSuppressed() == true) goto L46;
        Object r108 = ServiceManager.get().getService(IOfficeSdkService.class);
        if ((r108 instanceof OfficeSdkServiceImpl) == false) goto L36;
        OfficeSdkServiceImpl r109 = (OfficeSdkServiceImpl) r108;
    L37:
        if (r109 == null) goto L46;
        OfficeInputParam r110 = this.inputParams;
        if (r110 == null) goto L41;
        String r111 = r110.getResourceId();
    L42:
        OfficeInputParam r112 = this.inputParams;
        if (r112 == null) goto L45;
        r102 = Integer.valueOf(r112.getResourceType());
    L45:
        r109.k(r111, r102, this);
        goto L46
    L41:
        r111 = null;
        goto L42
    L36:
        r109 = null;
    L46:
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c r113 = getInputCoordinator();
        fo9.a r114 = r113.a();
        if (r114 == null) goto L49;
        r114.D70(r113.f362957p);
    L49:
        getWindowCoordinator().b(r100);
        this.hostControlsRegistered = true;
        return;
    L16:
        r103 = null;
        goto L17
    L12:
        r101 = null;
        goto L13
    }

    private final boolean resolveCurrentActionBarVisible(boolean r100) {
        ChameleonPluginHost r101 = getHost();
        Boolean r102 = null;
        if (r101 == null) goto L7;
        ActionBarVisibilityPlugin r103 = (ActionBarVisibilityPlugin) r101.findPlugin(ActionBarVisibilityPlugin.class);
        if (r103 == null) goto L7;
        Boolean r104 = Boolean.valueOf(r103.isActionBarVisible());
    L8:
        com.larus.office.h r105 = resolveHostAbilityProvider();
        if (r105 == null) goto L11;
        r102 = Boolean.valueOf(r105.isActionBarVisible());
    L11:
        if (r104 != null) goto L16;
        if (r102 != null) goto L15;
        return r100;
    L15:
        return r102.booleanValue();
    L16:
        return r104.booleanValue();
    L7:
        r104 = null;
        goto L8
    }

    private static final void setToAiEdit$lambda$76(AIChatPluginV2 r100) {
        com.larus.office.plugins.inputv2.adapter.g r101 = r100.getIntegrationCoordinator().f362872o;
        if (r101 == null) goto L5;
        r101.o();
    L5:
        com.larus.office.plugins.inputv2.adapter.g r102 = r100.getIntegrationCoordinator().f362872o;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.i() == false) goto L16;
        va8.g0 r103 = (va8.g0) r102.e(va8.g0.class);
        if (r103 == null) goto L15;
        r103.BW();
        return;
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.k0] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.l0] */
    private static final com.larus.office.plugins.inputv2.coordinator.document.e sheetSelectionCoordinator_delegate$lambda$6(final AIChatPluginV2 r100) {
        return new com.larus.office.plugins.inputv2.coordinator.document.e(new k0(r100), new l0(r100));
    }

    private static final OfficeInputParam sheetSelectionCoordinator_delegate$lambda$6$lambda$4(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final Unit sheetSelectionCoordinator_delegate$lambda$6$lambda$5(AIChatPluginV2 r100) {
        r100.getPanelHeightCoordinator().c();
        return Unit.INSTANCE;
    }

    private static final com.larus.office.plugins.inputv2.coordinator.document.f slidesCoordinator_delegate$lambda$7(AIChatPluginV2 r100) {
        return new com.larus.office.plugins.inputv2.coordinator.document.f(new AIChatPluginV2$slidesCoordinator$2$1(r100), new AIChatPluginV2$slidesCoordinator$2$2(r100.getPanelHeightCoordinator()));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.i0] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.j0] */
    private static final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h trackCoordinator_delegate$lambda$45(final AIChatPluginV2 r100) {
        return new com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h(new i0(r100), new j0(r100), r100.getAnswerStateCoordinator());
    }

    private static final OfficeInputParam trackCoordinator_delegate$lambda$45$lambda$43(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final com.larus.office.plugins.inputv2.adapter.g trackCoordinator_delegate$lambda$45$lambda$44(AIChatPluginV2 r100) {
        return r100.getIntegrationCoordinator().f362872o;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.h] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.i] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.j] */
    private static final qo9.f visibilityCoordinator_delegate$lambda$33(final AIChatPluginV2 r100) {
        return new qo9.f(new h(r100), new i(r100), new j(r100), new AIChatPluginV2$visibilityCoordinator$2$4(r100));
    }

    private static final OfficeInputParam visibilityCoordinator_delegate$lambda$33$lambda$30(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final boolean visibilityCoordinator_delegate$lambda$33$lambda$31(AIChatPluginV2 r100) {
        fo9.a r101 = r100.getInputCoordinator().a();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.canRead() != true) goto L7;
        return true;
    }

    private static final boolean visibilityCoordinator_delegate$lambda$33$lambda$32(AIChatPluginV2 r100) {
        return r100.getWindowCoordinator().f534305g.e();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.office.plugins.inputv2.w1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.office.plugins.inputv2.b] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.office.plugins.inputv2.c] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.office.plugins.inputv2.d] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.office.plugins.inputv2.e] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.office.plugins.inputv2.f] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.office.plugins.inputv2.g] */
    private static final qo9.o windowCoordinator_delegate$lambda$24(final AIChatPluginV2 r110) {
        return new qo9.o(new w1(r110), new com.larus.office.plugins.inputv2.b(r110), new c(r110), new d(r110), new e(r110), new f(r110), new so9.d(), new g(r110));
    }

    private static final Context windowCoordinator_delegate$lambda$24$lambda$17(AIChatPluginV2 r100) {
        return r100.getContext();
    }

    private static final ChameleonPluginHost windowCoordinator_delegate$lambda$24$lambda$18(AIChatPluginV2 r100) {
        return r100.getHost();
    }

    private static final com.bytedance.ee.bear.browser.plugin.t windowCoordinator_delegate$lambda$24$lambda$19(AIChatPluginV2 r100) {
        return r100.getUIContainer();
    }

    private static final OfficeInputParam windowCoordinator_delegate$lambda$24$lambda$20(AIChatPluginV2 r100) {
        return r100.inputParams;
    }

    private static final com.larus.office.h windowCoordinator_delegate$lambda$24$lambda$21(AIChatPluginV2 r100) {
        return r100.hostAbilityProvider;
    }

    private static final g45.d windowCoordinator_delegate$lambda$24$lambda$22(AIChatPluginV2 r100) {
        return r100.editPanelManager;
    }

    @Override // com.larus.office.plugins.input.w1
    public void collapseChatPanel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        getWindowCoordinator().d(r100);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        OfficeChatBridgeRegistry r101 = getBridgeRegistry();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        r100.put(ChatInputContainerPlugin.BIZ_NOTIFY_STATE_CHANGED, new OfficeChatBridgeRegistry.b(r101));
        r100.put("biz.navigation.openFloatChat", new OfficeChatBridgeRegistry.f(r101));
        r100.put("biz.util.updateChatInputVisibility", new OfficeChatBridgeRegistry.g(r101));
        r100.put("biz.util.chatInputUI", new OfficeChatBridgeRegistry.c());
        r100.put("biz.notify.aiEditHappened", new OfficeChatBridgeRegistry.a(r101));
        if (r101.f362650a == false) goto L6;
        r100.put("biz.flowAI.show", new OfficeChatBridgeRegistry.e(r101));
        return;
    }

    public String getCurrentModule(boolean r100) {
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h r101 = getTrackCoordinator();
        OfficeInputParam r102 = r101.f362969a.invoke();
        if (r102 == null) goto L5;
        String r103 = r102.getType();
    L6:
        if (r103 == null) goto L58;
        int r104 = r103.hashCode();
        if (r104 == (-899647262)) goto L49;
        if (r104 == 3088960) goto L20;
        if (r104 == 109403487) goto L15;
        return null;
    L15:
        if (r103.equals(DocumentType.SHEET_NAME) == false) goto L63;
        if (r100 == false) goto L56;
        r101.c("SHEETAISidebar");
    L56:
        return ShareChannel.ASK_DOUBAO;
    L63:
        return null;
    L20:
        if (r103.equals(DocumentType.DOCX_NAME) == false) goto L59;
        String r105 = r101.f362972d;
        if (r100 == false) goto L26;
        int r106 = r101.f362974f + 1;
        r101.f362974f = r106;
        if (r106 < r101.f362973e) goto L26;
        r101.f362972d = null;
        r101.f362973e = 1;
        r101.f362974f = 0;
        r101.c("DOCAISidebar");
    L26:
        FLogger.f375446a.i("OfficeChatTrack", "获取 currentModule, module=" + r105 + ", fromSendStatus=" + r100 + ", callCount=" + r101.f362974f + ", messageCount=" + r101.f362973e);
        if (r105 == null) goto L56;
        int r107 = r105.hashCode();
        if (r107 == (-1309162249)) goto L44;
        if (r107 == 942033467) goto L40;
        if (r107 != 989204668) goto L56;
        if (r105.equals("recommend") == false) goto L56;
        String r108 = "doc_recommend_qa";
    L60:
        return r108;
    L40:
        if (r105.equals("meeting") == false) goto L56;
        r108 = "ai_meeting_notes_qa";
        goto L60
    L44:
        if (r105.equals("explain") == false) goto L56;
        r108 = "doc_ai_explain";
        goto L60
    L59:
        return null;
    L49:
        if (r103.equals("slides") == false) goto L64;
        if (r100 == false) goto L54;
        r101.c("SLIDESAISidebar");
    L54:
        if (r101.f362971c.f362780f == false) goto L56;
        return FROM_AI_EDIT;
    L64:
        return null;
    L58:
        return null;
    L5:
        r103 = null;
        goto L6
    }

    @Override // g45.a
    public int getPanelHeight(Context r100) {
        qo9.c r101 = getPanelHeightCoordinator();
        if (r101.f534263f == true) goto L7;
        return 0;
    L7:
        return r101.f534264g;
    }

    @Override // com.larus.office.c
    public void onActionButtonVisibilityChanged(boolean r100) {
        if (r100 == false) goto L6;
        Boolean r101 = this.deferredSlidesSelectionVisible;
        if (r101 == null) goto L6;
        boolean r102 = r101.booleanValue();
        this.deferredSlidesSelectionVisible = null;
        getVisibilityCoordinator().b(SOURCE_SLIDES_SELECTION, r102);
    L6:
        this.actionBarVisible = r100;
        com.larus.office.plugins.inputv2.adapter.g r103 = getWindowCoordinator().f534309k;
        if (r103 == null) goto L11;
        va8.g0 r104 = (va8.g0) r103.e(va8.g0.class);
        if (r104 == null) goto L11;
        r104.Iq(r100);
    L11:
        qo9.f r105 = getVisibilityCoordinator();
        r105.f534282g = r100;
        r105.a(VoiceInputFrom.ACTION_BAR);
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        getWindowCoordinator().b(r100);
        x2 r101 = getDocumentLoader();
        if (r101 == null) goto L6;
        r101.S3(this.loadingCallback);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        boolean r101 = false;
        if (r100.orientation != 2) goto L5;
        boolean r102 = true;
    L6:
        qo9.o r103 = getWindowCoordinator();
        int r104 = r100.orientation;
        int r105 = r103.f534313o;
        if (r105 == 0) goto L10;
        if (r105 == r104) goto L10;
        boolean r106 = true;
    L11:
        r103.f534313o = r104;
        if (r106 == true) goto L14;
    L19:
        qo9.f r107 = getVisibilityCoordinator();
        r107.getClass();
        Intrinsics.checkNotNullParameter("configuration", "reason");
        if (r107.f534283h == r102) goto L24;
        r107.f534283h = r102;
        r107.a("configuration");
        return;
    L24:
        return;
    L14:
        if (r103.f534312n != FloatChatWindowState.Collapsed) goto L16;
        r101 = true;
    L16:
        if (r101 == true) goto L19;
        FLogger.f375446a.i("OfficeChatWindow", "屏幕方向变化且对话框未收起，自动收起");
        r103.d("orientation_changed");
    L10:
        r106 = false;
        goto L11
    L5:
        r102 = false;
        goto L6
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        OfficeChatIntegrationCoordinator r101 = getIntegrationCoordinator();
        r101.e();
        r101.a("release");
        r101.f362867j = false;
        getConversationCoordinator().j();
        unregisterHostControls();
        getWindowCoordinator().f534305g.c();
        this.offlineDocCardMessageId = null;
        getDocArtifactCoordinator().f362787e = null;
        com.larus.office.plugins.inputv2.coordinator.document.c r102 = getAnswerStateCoordinator();
        r102.f362778d = 0;
        r102.f362779e = false;
        r102.f362780f = false;
        r102.f362781g = false;
        com.larus.office.plugins.inputv2.coordinator.document.e r103 = getSheetSelectionCoordinator();
        r103.f362790c = null;
        Intrinsics.checkNotNullParameter("release", "reason");
        r103.f362791d = false;
        r103.f362792e = null;
        r103.f362793f = null;
        r103.f362794g = null;
        r103.b("release");
        com.larus.office.plugins.inputv2.coordinator.document.f r104 = getSlidesCoordinator();
        r104.f362801c = null;
        r104.f362802d = false;
        r104.f362803e = null;
        r104.f362804f = null;
        r104.f362799a.invoke(Boolean.TRUE);
        this.deferredSlidesSelectionVisible = null;
        x2 r105 = getDocumentLoader();
        if (r105 == null) goto L5;
        r105.S(this.loadingCallback);
    L5:
        this.chatInputContainer = null;
        this.fullScreenChatContainer = null;
        this.inputParams = null;
        this.isDocEmpty = false;
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h r106 = getTrackCoordinator();
        r106.f362972d = null;
        r106.f362973e = 1;
        r106.f362974f = 0;
        r106.f362975g = "read";
        qo9.f r107 = getVisibilityCoordinator();
        r107.f534280e = true;
        r107.f534281f.clear();
        r107.f534282g = true;
        r107.f534283h = false;
        r107.f534284i = false;
        super.onDetachFromHost(r100);
    }

    @Override // com.larus.office.plugins.input.m1
    public void onDocStateChanged(boolean r100) {
        this.isDocEmpty = r100;
        OfficeChatConversationCoordinator r101 = getConversationCoordinator();
        String r102 = resolveCurrentDefaultScene();
        r101.f362820h = r102;
        com.larus.office.plugins.inputv2.adapter.g r103 = r101.f362817e;
        if (r103 == null) goto L8;
        jo9.g r104 = (jo9.g) r103.g(jo9.g.class);
        if (r104 == null) goto L9;
        r104.a5(r102);
        return;
    L9:
        return;
    }

    @Override // com.larus.office.plugins.offline.c
    public void onOfflineDocCardMessageIdChanged(String r100) {
        this.offlineDocCardMessageId = r100;
    }

    @Override // com.larus.office.plugins.offline.c
    public void onOfflineDocRealTokenReady(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageToken");
        if (StringsKt.isBlank(r100) == false) goto L6;
        FLogger.f375446a.w(TAG, "独立离线插件返回空 token");
        return;
    L6:
        OfficeInputParam r101 = this.inputParams;
        if (r101 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r101.getResourceId(), r100) == true) goto L12;
    L14:
        r101.setResourceId(r100);
        if (Intrinsics.areEqual(r101.getType(), "slides") == false) goto L17;
        r101.setSlidesToken(r100);
    L17:
        r101.setFakeOfflineDoc(false);
        OfficeChatIntegrationCoordinator r102 = getIntegrationCoordinator();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "pageToken");
        com.larus.office.plugins.inputv2.adapter.g r103 = r102.f362872o;
        if (r103 == null) goto L31;
        Bundle r104 = r103.f362678a.getArguments();
        if (r104 == null) goto L23;
        r104.putString("key_doc_id", r100);
    L23:
        jo9.h r105 = (jo9.h) r103.g(jo9.h.class);
        if (r105 == null) goto L31;
        OfficeDocArtifactInfo r106 = r105.X4();
        if (r106 == null) goto L31;
        if (Intrinsics.areEqual(r106.getResourceId(), r100) == true) goto L31;
        r105.Gz(OfficeDocArtifactInfo.copy$default(r106, null, r100, 0, 5, null));
    L31:
        OfficeChatConversationCoordinator r107 = getConversationCoordinator();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "resourceId");
        if (StringsKt.isBlank(r100) == true) goto L39;
        r107.f362821i = r100;
        OfficeInputParam r108 = r107.f362815c.invoke();
        if (r108 == null) goto L37;
        String r109 = r108.getConversationId();
    L38:
        r107.m(r109);
        goto L39
    L37:
        r109 = null;
    L39:
        refreshHostRegistration("offline_create_real_token");
        return;
    L12:
        if (r101.isFakeOfflineDoc() == true) goto L14;
    }

    @Override // com.larus.office.plugins.input.m1
    public void onReferenceCacheCleared(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i(TAG, "清理 Office 引用, reason=" + r100);
        com.larus.office.plugins.inputv2.adapter.g r101 = getIntegrationCoordinator().f362872o;
        if (r101 == null) goto L5;
        r101.q(null);
    L5:
        if (r101 == null) goto L9;
        jo9.a r102 = (jo9.a) r101.g(jo9.a.class);
        if (r102 == null) goto L9;
        r102.Og(null, null);
    L9:
        com.larus.office.plugins.inputv2.coordinator.document.e r103 = getSheetSelectionCoordinator();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "reason");
        r103.f362791d = false;
        r103.f362792e = null;
        r103.f362793f = null;
        r103.f362794g = null;
        r103.b(r100);
        com.larus.office.plugins.inputv2.adapter.g r104 = r103.f362790c;
        if (r104 == null) goto L14;
        jo9.i r105 = (jo9.i) r104.g(jo9.i.class);
        if (r105 == null) goto L14;
        r105.mo8561if();
    L14:
        r103.f362789b.invoke();
    }

    @Override // com.larus.office.plugins.input.s1
    public void onSlidesOrientationChanged(boolean r100) {
        getVisibilityCoordinator().b("slides_orientation", !r100);
    }

    @Override // com.larus.office.plugins.input.s1
    public void onSlidesSelectionChanged(String r100) {
        com.larus.office.plugins.inputv2.coordinator.document.f r101 = getSlidesCoordinator();
        r101.f362802d = true;
        r101.f362803e = r100;
        r101.a("selection_changed");
    }

    public boolean openFloatChatPanel(final String r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        if (getInputCoordinator().f362956o == true) goto L7;
        FLogger.f375446a.i(TAG, "打开新版输入框失败, 尚未 ready, from=" + r110);
        return false;
    L7:
        if (getWindowCoordinator().f534317s >= 100) goto L9;
        final boolean r100 = true;
    L10:
        qo9.f r101 = getVisibilityCoordinator();
        String r102 = "open_float_chat#" + r110;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "reason");
        r101.f534280e = true;
        r101.a(r102);
        if (getVisibilityCoordinator().f534284i == true) goto L14;
        FLogger.f375446a.i(TAG, "打开新版输入框失败, 当前可见性门禁不允许, from=" + r110);
        return false;
    L14:
        final qo9.o r103 = getWindowCoordinator();
        boolean r104 = !Intrinsics.areEqual(r110, FROM_CONVERSATION_RED_DOT);
        Function0 r105 = new o0(r100, this, r110);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "from");
        Intrinsics.checkNotNullParameter(r105, "onExpanded");
        final com.larus.office.plugins.inputv2.adapter.g r106 = r103.f534309k;
        if (r106 == null) goto L21;
        Fragment r107 = r106.f362678a;
        if (r107 == null) goto L21;
        if (r107.isAdded() != true) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L24;
        return false;
    L24:
        if (r106.i() == false) goto L45;
        if (r104 == false) goto L28;
        r106.p(r110, false);
    L28:
        Intrinsics.checkNotNullParameter(r110, "reason");
        String r109 = "展开输入框失败, reason=" + r110;
        if (r106.f362693p == false) goto L42;
    L35:
        r105.invoke();
        if (r104 == false) goto L40;
        View r111 = r106.f362678a.getView();
        if (r111 == null) goto L40;
        r111.postDelayed(new qo9.n(r103, r106, r110), 100);
    L40:
        return true;
    L42:
        r106.f362679b.Vv();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", r109, th);
        goto L35
    L45:
        return false;
    L21:
        r108 = false;
        goto L22
    L9:
        r100 = false;
        goto L10
    }

    @Override // com.bytedance.ee.bear.document.ability.IAIChatInputPlugin
    public void setChatInputVisibility(boolean r100) {
        qo9.f r101 = getVisibilityCoordinator();
        r101.getClass();
        Intrinsics.checkNotNullParameter("host_request", "reason");
        r101.f534280e = r100;
        r101.a("host_request");
    }

    public boolean shouldSuppressFlowMessagePush(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        OfficeChatConversationCoordinator r101 = getConversationCoordinator();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        boolean r102 = false;
        if (StringsKt.isBlank(r100) == true) goto L36;
        OfficeInputParam r103 = r101.f362815c.invoke();
        String r104 = null;
        if (r103 == null) goto L8;
        String r105 = r103.getConversationId();
    L9:
        com.larus.office.plugins.inputv2.adapter.g r106 = r101.f362817e;
        if (r106 == null) goto L16;
        jo9.g r107 = (jo9.g) r106.g(jo9.g.class);
        if (r107 == null) goto L16;
        wc9.e r108 = r107.p1();
        if (r108 == null) goto L16;
        String r109 = r108.f559198a;
    L17:
        com.larus.office.plugins.inputv2.adapter.g r110 = r101.f362817e;
        if (r110 == null) goto L24;
        com.larus.bmhome.chat.component.cvs.y r111 = (com.larus.bmhome.chat.component.cvs.y) r110.e(com.larus.bmhome.chat.component.cvs.y.class);
        if (r111 == null) goto L24;
        wc9.e r112 = r111.h();
        if (r112 == null) goto L24;
        r104 = r112.f559198a;
    L24:
        List r113 = CollectionsKt.listOf(new String[]{r105, r109, r104});
        if ((r113 instanceof Collection) == true) goto L27;
    L29:
        Iterator r114 = r113.iterator();
    L31:
        if (r114.hasNext() == false) goto L35;
        if (Intrinsics.areEqual((String) r114.next(), r100) == false) goto L31;
        r102 = true;
    L35:
        FLogger.f375446a.i("OfficeChatConversation", "消息推送抑制=" + r102 + ", target=" + OfficeChatConversationCoordinator.l(r100) + ", params=" + OfficeChatConversationCoordinator.l(r105) + ", office=" + OfficeChatConversationCoordinator.l(r109) + ", chat=" + OfficeChatConversationCoordinator.l(r104));
        goto L36
    L27:
        if (r113.isEmpty() == false) goto L29;
    L16:
        r109 = null;
        goto L17
    L8:
        r105 = null;
    L36:
        return r102;
    }

    @Override // com.larus.office.plugins.input.m1
    public void updateLoadingDocState(int r100) {
        com.larus.office.plugins.inputv2.coordinator.document.c r101 = getAnswerStateCoordinator();
        r101.getClass();
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L10;
        FLogger.f375446a.i("OfficeAnswerState", "忽略未知 AI Edit state=" + r100);
        return;
    L10:
        if (r101.f362778d == r100) goto L15;
        r101.f362778d = r100;
        return;
    }

    @Override // com.larus.office.plugins.input.s1
    public void updateSlidesStructureVersion(Integer r100) {
        com.larus.office.plugins.inputv2.coordinator.document.f r101 = getSlidesCoordinator();
        r101.f362804f = r100;
        r101.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    public static final /* synthetic */ void access$applyVisibilityResult(AIChatPluginV2 r100, qo9.f.a r101) {
        r100.applyVisibilityResult(r101);
    }

    public static final /* synthetic */ void access$onInputNotReady(AIChatPluginV2 r100, dw8.a r101) {
        r100.onInputNotReady(r101);
    }

    public static final /* synthetic */ void access$onInputReady(AIChatPluginV2 r100, dw8.a r101) {
        r100.onInputReady(r101);
    }

    public static final /* synthetic */ void access$onSlidesSelectionVisibilityChanged(AIChatPluginV2 r100, boolean r101) {
        r100.onSlidesSelectionVisibilityChanged(r101);
    }

    private static final Unit answerStateCoordinator_delegate$lambda$3$lambda$2(final AIChatPluginV2 r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        com.larus.utils.t0.e(new n0(r100, r101));
        return Unit.INSTANCE;
    }

    private static final void answerStateCoordinator_delegate$lambda$3$lambda$2$lambda$1(AIChatPluginV2 r100, String r101) {
        r100.getWindowCoordinator().d(r101);
    }

    private static final FeishuFlowAIShowResult bridgeRegistry_delegate$lambda$72$lambda$71(AIChatPluginV2 r100, no9.b r101) {
        Intrinsics.checkNotNullParameter(r101, "request");
        com.larus.office.plugins.inputv2.adapter.g r102 = r100.getIntegrationCoordinator().f362872o;
        if (r102 == null) goto L10;
        no9.d r103 = (no9.d) r102.g(no9.d.class);
        if (r103 == null) goto L10;
        FeishuFlowAIShowResult r104 = r103.tG(r101);
        if (r104 == null) goto L10;
        return r104;
    L10:
        return FeishuFlowAIShowResult.NOT_READY;
    }

    private static final Unit inputCoordinator_delegate$lambda$42$lambda$40(AIChatPluginV2 r100, boolean r101) {
        qo9.e r102 = r100.getWindowCoordinator().f534307i;
        if (r102.f534274d == r101) goto L7;
        r102.f534274d = r101;
        r102.a();
    L7:
        return Unit.INSTANCE;
    }

    private static final Unit integrationCoordinator_delegate$lambda$68$lambda$64(AIChatPluginV2 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        qo9.f r102 = r100.getVisibilityCoordinator();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "reason");
        r102.a(r101);
        return Unit.INSTANCE;
    }

    private static final Unit integrationCoordinator_delegate$lambda$68$lambda$67(AIChatPluginV2 r100, ChameleonPluginHost r101) {
        Intrinsics.checkNotNullParameter(r101, "host");
        r100.registerHostControls(r101);
        OfficeInputParam r102 = r100.inputParams;
        if (r102 == null) goto L5;
        r102.setMessageId(r100.getDocArtifactCoordinator().b());
    L5:
        ReportEventPlugin r103 = (ReportEventPlugin) r101.findPlugin(ReportEventPlugin.class);
        if (r103 == null) goto L9;
        r103.reportEnterPage(r100.inputParams);
    L9:
        return Unit.INSTANCE;
    }

    private final void requestExpandForOfficeAnswer(String r100, String r101) {
        qo9.o r102 = getWindowCoordinator();
        com.larus.office.plugins.inputv2.adapter.g r103 = getInputCoordinator().f362953l;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L26:
        boolean r105 = false;
    L28:
        if (r102.f534313o != 2) goto L31;
        if (r105 == false) goto L31;
        r104 = true;
    L31:
        if (r104 == false) goto L34;
        FLogger.f375446a.i(TAG, "横屏输入中回答结束，保持对话框收起");
        return;
    L34:
        openFloatChatPanel(r100 + '#' + r101);
        return;
    L5:
        if (r103.i() == false) goto L22;
        va8.o r106 = (va8.o) r103.e(va8.o.class);
        if (r106 != null) goto L10;
    L12:
        boolean r107 = false;
    L13:
        va8.n r108 = (va8.n) r103.e(va8.n.class);
        if (r108 != null) goto L16;
    L18:
        boolean r109 = false;
    L19:
        if (r107 == true) goto L23;
        if (r109 == false) goto L22;
    L23:
        boolean r110 = true;
    L24:
        if (r110 != true) goto L26;
        r105 = true;
        goto L28
    L16:
        if (r108.w() != true) goto L18;
        r109 = true;
        goto L19
    L10:
        if (r106.n5() != true) goto L12;
        r107 = true;
    L22:
        r110 = false;
        goto L24
    }

    private static final Unit windowCoordinator_delegate$lambda$24$lambda$23(AIChatPluginV2 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        qo9.f r102 = r100.getVisibilityCoordinator();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "reason");
        r102.a(r101);
        return Unit.INSTANCE;
    }

    @Override // com.larus.office.plugins.input.m1
    public void markAiEditTriggeredForCurrentAnswer(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i(TAG, "忽略旧 AI Edit 标记入口, reason=" + r100 + ", applyToNextAnswer=" + r101);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r110, com.bytedance.ee.bear.browser.plugin.t r111) {
        super.onAttachToUIContainer(r110, r111);
        getIntegrationCoordinator().e();
        getIntegrationCoordinator().a("reattach_ui_container");
        getConversationCoordinator().j();
        unregisterHostControls();
        boolean r100 = false;
        this.isDocEmpty = false;
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h r101 = getTrackCoordinator();
        xu5.b.a r102 = null;
        r101.f362972d = null;
        r101.f362973e = 1;
        r101.f362974f = 0;
        r101.f362975g = "read";
        if (r110 == null) goto L7;
        com.larus.office.w r103 = (com.larus.office.w) r110.getHostAbilityOrNull(com.larus.office.w.class);
        if (r103 == null) goto L7;
        OfficeInputParam r104 = r103.f363627a;
    L8:
        this.inputParams = r104;
        if (r110 == null) goto L11;
        y3 r105 = (y3) r110.getHostAbilityOrNull(y3.class);
    L12:
        int r106 = b2.f362700a;
        OfficeInputParam r107 = this.inputParams;
        int r108 = a2.f362666a;
        if (this.enableFeishuFlowAIShow == false) goto L21;
        if (r107 != null) goto L16;
    L18:
        boolean r109 = false;
    L19:
        if (r109 == false) goto L21;
        boolean r112 = true;
    L23:
        if (r107 == null) goto L72;
        if (r105 == null) goto L72;
        String r113 = r105.getToken();
        if ((!StringsKt.isBlank(r113)) == false) goto L31;
        if (r112 == true) goto L31;
        r107.setResourceId(r113);
    L31:
        int r114 = r105.getDocumentTypeValue();
        if (r114 != 2) goto L34;
    L51:
        r107.setType(DocumentType.DOCX_NAME);
    L53:
        if (Intrinsics.areEqual(r107.getPreviousPage(), "ai_space_list") == false) goto L55;
    L60:
        boolean r115 = true;
    L61:
        String r116 = r107.getDriveOverrideCurrentPage();
        if (r116 != null) goto L64;
    L67:
        boolean r117 = true;
    L68:
        if (r117 == false) goto L71;
        if (r115 == false) goto L71;
        r107.setDriveOverrideCurrentPage("ai_space_detail");
    L71:
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("同步文档 metadata, hasToken=");
        r119.append(!StringsKt.isBlank(r113));
        r119.append(", deferTokenSync=");
        r119.append(r112);
        r119.append(", type=");
        r119.append(r107.getType());
        r119.append(", resourceType=");
        r119.append(r107.getResourceType());
        r118.i("OfficeInputParamMetadata", r119.toString());
        goto L72
    L64:
        if (r116.length() == 0) goto L67;
        r117 = false;
        goto L68
    L55:
        if (Intrinsics.areEqual(r107.getEnterFrom(), "ai_space_list") == true) goto L60;
        if (Intrinsics.areEqual(r107.getClickPreviousPage(), "ai_space_list") == true) goto L60;
        r115 = false;
        goto L61
    L34:
        if (r114 != 3) goto L36;
        r107.setType(DocumentType.SHEET_NAME);
        r107.setResourceType(12);
        if ((!StringsKt.isBlank(r113)) == false) goto L53;
        if (r112 == true) goto L53;
        r107.setSlidesToken(r113);
        goto L53
    L36:
        if (r114 != 8) goto L38;
        r107.setType("base");
        r107.setResourceType(15);
        goto L53
    L38:
        if (r114 == 22) goto L51;
        if (r114 != 30) goto L53;
        r107.setType("slides");
        r107.setResourceType(9);
        if ((!StringsKt.isBlank(r113)) == false) goto L53;
        if (r112 == true) goto L53;
        r107.setSlidesToken(r113);
    L72:
        qo9.o r120 = getWindowCoordinator();
        if (r120.f534305g.b() == true) goto L94;
        TitleBar r121 = r120.f534301c.invoke().getTitleBar();
        if (r121 == null) goto L94;
        BaseTitleBar r122 = r121.getTitleBarLayout();
        if (r122 == null) goto L94;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == false) goto L83;
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
    L84:
        if (r124 == null) goto L94;
        OfficeInputParam r125 = r120.f534302d.invoke();
        if (r125 == null) goto L89;
        int r126 = r125.getActionBarWidth();
    L91:
        if (r124.getMarginEnd() == r126) goto L94;
        r124.setMarginEnd(r126);
        r122.setLayoutParams(r124);
        FLogger.f375446a.i("OfficeChatWindow", "应用标题栏胶囊避让, marginEnd=" + r126);
        goto L94
    L89:
        r126 = i5.f();
        goto L91
    L83:
        r124 = null;
    L94:
        qo9.o r127 = getWindowCoordinator();
        r127.getClass();
        Intrinsics.checkNotNullParameter("attach_ui_container", "reason");
        OfficeInputParam r128 = r127.f534302d.invoke();
        if (r128 == null) goto L174;
        Integer r129 = r128.getHostChatThemeStyleResId();
        if (r129 == null) goto L174;
        int r130 = r129.intValue();
        ChameleonPluginHost r131 = r127.f534300b.invoke();
        if (r131 == null) goto L105;
        FragmentActivity r132 = r131.getActivity();
        if (r132 == null) goto L105;
        Resources.Theme r133 = r132.getTheme();
        if (r133 == null) goto L105;
        r133.applyStyle(r130, true);
    L105:
        FLogger.f375446a.i("OfficeChatWindow", "应用宿主 Chat theme, reason=attach_ui_container, styleResId=" + r130);
    L174:
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L112
        if (r111 == null) goto L109;
        ViewGroup r135 = r111.c(this);     // Catch: Throwable -> L112
    L110:
        Object r136 = Result.m9449constructorimpl(r135);     // Catch: Throwable -> L112
    L114:
        Throwable r137 = Result.m9452exceptionOrNullimpl(r136);
        if (r137 == null) goto L118;
        FLogger.f375446a.e(TAG, "获取新版输入框容器失败", r137);
    L118:
        if (Result.m9455isFailureimpl(r136) == false) goto L120;
        r136 = null;
    L120:
        ViewGroup r138 = (ViewGroup) r136;
        if (r138 != null) goto L124;
        FLogger.f375446a.e(TAG, "挂载新版输入框失败, pluginContainer 为空");
        this.chatInputContainer = null;
        this.inputParams = null;
        return;
    L124:
        r138.removeAllViews();
        View r139 = LayoutInflater.from(r138.getContext()).inflate(R.layout.larus_layout_office_ai_chat_input_v2, r138, false);
        r138.addView(r139);
        int r140 = R.id.office_chat_input_bg_mask;
        View r141 = ViewBindings.findChildViewById(r139, R.id.office_chat_input_bg_mask);
        if (r141 == null) goto L173;
        r140 = R.id.office_chat_input_container;
        FrameLayout r142 = (FrameLayout) ViewBindings.findChildViewById(r139, R.id.office_chat_input_container);
        if (r142 == null) goto L173;
        r140 = R.id.office_full_chat_input_container;
        FrameLayout r143 = (FrameLayout) ViewBindings.findChildViewById(r139, R.id.office_full_chat_input_container);
        if (r143 == null) goto L173;
        FrameLayout r144 = (FrameLayout) r139;
        this.chatInputContainer = r142;
        this.fullScreenChatContainer = r143;
        if (r110 == null) goto L133;
        com.larus.office.h r145 = (com.larus.office.h) r110.getHostAbilityOrNull(com.larus.office.h.class);
    L134:
        this.hostAbilityProvider = r145;
        this.actionBarVisible = resolveCurrentActionBarVisible(true);
        getVisibilityCoordinator().f534282g = this.actionBarVisible;
        if (this.enableFeishuFlowAIShow == false) goto L142;
        if (r110 == null) goto L142;
        Fragment r146 = r110.getFragment();
        if (r146 == null) goto L142;
        FragmentManager r147 = r146.getChildFragmentManager();
        if (r147 == null) goto L142;
        r147.registerFragmentLifecycleCallbacks(this.fullScreenPageLifecycleCallbacks, true);
    L142:
        final qo9.o r148 = getWindowCoordinator();
        if (r110 == null) goto L147;
        FragmentActivity r149 = r110.getActivity();
        if (r149 == null) goto L147;
        r102 = xu5.b.b(r149, null);
    L147:
        r148.f534310l = r141;
        r141.setOnClickListener(new qo9.g(r148));
        qo9.e r150 = r148.f534307i;
        if (r150.f534275e == false) goto L152;
        xu5.a r151 = r150.f534272b;
        if (r151 == null) goto L152;
        r151.resetState();
    L152:
        r150.f534273c = false;
        r150.f534274d = false;
        r150.f534275e = false;
        r150.f534272b = r102;
        Context r152 = r148.f534299a.invoke();
        if (r152 == null) goto L159;
        Resources r153 = r152.getResources();
        if (r153 == null) goto L159;
        Configuration r154 = r153.getConfiguration();
        if (r154 == null) goto L159;
        int r155 = r154.orientation;
    L160:
        r148.f534313o = r155;
        qo9.f r156 = getVisibilityCoordinator();
        if (getResources().getConfiguration().orientation != 2) goto L163;
        r100 = true;
    L163:
        r156.getClass();
        Intrinsics.checkNotNullParameter("attach_ui_container", "reason");
        if (r156.f534283h == r100) goto L168;
        r156.f534283h = r100;
        r156.a("attach_ui_container");
    L168:
        if (isEmbeddedAIChatSuppressed() == false) goto L170;
        registerHostControls(r110);
        getWindowCoordinator().b(r110);
        qo9.f r157 = getVisibilityCoordinator();
        r157.getClass();
        Intrinsics.checkNotNullParameter("attach_without_wrapper", "reason");
        r157.a("attach_without_wrapper");
    L170:
        getIntegrationCoordinator().h("attach_ui_container");
        return;
    L159:
        r155 = 0;
        goto L160
    L133:
        r145 = null;
    L173:
        throw new NullPointerException("Missing required view with ID: ".concat(r139.getResources().getResourceName(r140)));
    L109:
        r135 = null;
    L112:
        th = move-exception;
        Result.Companion r158 = Result.Companion;
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L114
    L16:
        if (r107.isFakeOfflineDoc() != true) goto L18;
        r109 = true;
    L21:
        r112 = false;
        goto L23
    L11:
        r105 = null;
    L7:
        r104 = null;
        goto L8
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        getIntegrationCoordinator().e();
        getIntegrationCoordinator().a("detach_ui_container");
        getConversationCoordinator().j();
        com.larus.office.plugins.inputv2.coordinator.document.e r102 = getSheetSelectionCoordinator();
        r102.getClass();
        Intrinsics.checkNotNullParameter("detach_ui_container", "reason");
        r102.f362791d = false;
        r102.f362792e = null;
        r102.f362793f = null;
        r102.f362794g = null;
        r102.b("detach_ui_container");
        com.larus.office.plugins.inputv2.coordinator.document.f r103 = getSlidesCoordinator();
        r103.f362802d = false;
        r103.f362803e = null;
        r103.f362804f = null;
        r103.f362799a.invoke(Boolean.TRUE);
        this.deferredSlidesSelectionVisible = null;
        getVisibilityCoordinator().b(SOURCE_SLIDES_SELECTION, true);
        if (this.enableFeishuFlowAIShow == false) goto L10;
        if (r100 == null) goto L10;
        Fragment r104 = r100.getFragment();
        if (r104 == null) goto L10;
        FragmentManager r105 = r104.getChildFragmentManager();
        if (r105 == null) goto L10;
        r105.unregisterFragmentLifecycleCallbacks(this.fullScreenPageLifecycleCallbacks);
    L10:
        unregisterHostControls();
        getPanelHeightCoordinator().b();
        qo9.o r106 = getWindowCoordinator();
        View r107 = r106.f534310l;
        if (r107 == null) goto L13;
        r107.setOnClickListener(null);
    L13:
        r106.f534310l = null;
        qo9.e r108 = r106.f534307i;
        if (r108.f534275e == false) goto L18;
        xu5.a r109 = r108.f534272b;
        if (r109 == null) goto L18;
        r109.resetState();
    L18:
        r108.f534272b = null;
        r108.f534273c = false;
        r108.f534274d = false;
        r108.f534275e = false;
        r106.f534313o = 0;
        this.chatInputContainer = null;
        this.fullScreenChatContainer = null;
        this.inputParams = null;
        super.onDetachFromUIContainer(r100, r101);
    }

    @Override // com.larus.office.plugins.input.m1
    public void onSelectionChanged(String r100, String r101) {
        com.larus.office.plugins.inputv2.adapter.g r102 = getIntegrationCoordinator().f362872o;
        if (r102 == null) goto L5;
        r102.q(r100);
    L5:
        if (r102 == null) goto L9;
        jo9.a r103 = (jo9.a) r102.g(jo9.a.class);
        if (r103 == null) goto L9;
        r103.Og(r100, r101);
    L9:
        getPanelHeightCoordinator().c();
    }

    @Override // com.larus.office.plugins.input.w1
    public void setChatInputVisibility(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        getVisibilityCoordinator().b(r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }

    public /* synthetic */ AIChatPluginV2(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }

    public static final /* synthetic */ void access$requestExpandForOfficeAnswer(AIChatPluginV2 r100, String r101, String r102) {
        r100.requestExpandForOfficeAnswer(r101, r102);
    }

    private static final Unit bridgeRegistry_delegate$lambda$72$lambda$70(AIChatPluginV2 r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        com.larus.office.plugins.input.m1.a.a(r100, r101, r102, false, 12);
        return Unit.INSTANCE;
    }

    private static final Unit integrationCoordinator_delegate$lambda$68$lambda$62(AIChatPluginV2 r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        r100.getVisibilityCoordinator().b(r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit integrationCoordinator_delegate$lambda$68$lambda$65(AIChatPluginV2 r110, com.larus.office.plugins.inputv2.adapter.g r111, long r112) {
        Intrinsics.checkNotNullParameter(r111, "adapter");
        com.larus.office.plugins.inputv2.coordinator.document.e r113 = r110.getSheetSelectionCoordinator();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r111, "adapter");
        r113.f362790c = r111;
        com.larus.office.plugins.inputv2.coordinator.document.f r114 = r110.getSlidesCoordinator();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r111, "adapter");
        r114.f362801c = r111;
        final qo9.o r115 = r110.getWindowCoordinator();
        r115.getClass();
        Intrinsics.checkNotNullParameter(r111, "adapter");
        r115.g();
        r115.f534309k = r111;
        qo9.p r100 = r115.f534318t;
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (r111.f362693p == false) goto L5;
    L11:
        dw8.m r101 = new dw8.m(new qo9.h(r115), new qo9.i(r115), new qo9.j(r115), new qo9.k(r115), true);
        if (r111.f362693p == false) goto L42;
    L18:
        qo9.c r116 = r110.getPanelHeightCoordinator();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r111, "adapter");
        Handler r102 = com.larus.utils.t0.f375468a;
        r102.removeCallbacks(r116.f534268k);
        r102.removeCallbacks(r116.f534269l);
        r116.f534266i = false;
        com.larus.office.plugins.inputv2.adapter.g r103 = r116.f534262e;
        if (r103 == null) goto L21;
        r103.u(r116.f534267j);
    L21:
        r116.f534262e = r111;
        r116.f534264g = 0;
        qo9.d r117 = r116.f534267j;
        Intrinsics.checkNotNullParameter(r117, "observer");
        if (r111.f362693p == false) goto L24;
    L30:
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.c r118 = r110.getInputCoordinator();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r111, "adapter");
        r118.c();
        r118.f362953l = r111;
        r118.f362955n = 0;
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.a r119 = r118.f362958q;
        Intrinsics.checkNotNullParameter(r119, "listener");
        if (r111.f362693p == false) goto L33;
    L36:
        r111.a(r118.f362959r);
        return Unit.INSTANCE;
    L33:
        if (r111.f362685h.add(r119) == false) goto L36;
        com.larus.office.plugins.inputv2.adapter.g.j(r119, r111.f362691n);
        r111.b();
        goto L36
    L24:
        if (r111.f362684g.add(r117) == false) goto L30;
        r111.f362679b.QL(r117);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r111.f362684g.remove(r117);
        FLogger.f375446a.e("OfficeChatInputAdapter", "注册窗口高度监听失败", th);
        goto L30
    L42:
        r111.f362679b.ZR(r101);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "更新 ChatHostConfig 失败", th);
        goto L18
    L5:
        if (r111.f362683f.add(r100) == false) goto L11;
        r111.f362679b.YI(r100);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r111.f362683f.remove(r100);
        FLogger.f375446a.e("OfficeChatInputAdapter", "注册窗口状态监听失败", th);
        goto L11
    }

    private static final Unit integrationCoordinator_delegate$lambda$68$lambda$66(AIChatPluginV2 r100, com.larus.office.plugins.inputv2.adapter.g r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        com.larus.office.plugins.inputv2.coordinator.document.e r103 = r100.getSheetSelectionCoordinator();
        if (r103.f362790c != r101) goto L5;
        r103.f362790c = null;
    L5:
        com.larus.office.plugins.inputv2.coordinator.document.f r104 = r100.getSlidesCoordinator();
        if (r104.f362801c != r101) goto L8;
        r104.f362801c = null;
    L8:
        r100.getInputCoordinator().c();
        qo9.o r105 = r100.getWindowCoordinator();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "reason");
        r105.g();
        r105.c(r102);
        r100.getPanelHeightCoordinator().b();
        com.larus.office.plugins.inputv2.coordinator.document.c r106 = r100.getAnswerStateCoordinator();
        r106.f362778d = 0;
        r106.f362779e = false;
        r106.f362780f = false;
        r106.f362781g = false;
        r100.panelActive.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private static final Unit openFloatChatPanel$lambda$75(boolean r100, AIChatPluginV2 r101, String r102) {
        if (r100 == false) goto L5;
        r101.getConversationCoordinator().i(r102);
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.larus.office.plugins.input.r1
    public void onSheetSelectionChanged(String r100, String r101, Integer r102) {
        com.larus.office.plugins.inputv2.coordinator.document.e r103 = getSheetSelectionCoordinator();
        r103.getClass();
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("选区变化, plainTextLen=");
        if (r101 == null) goto L5;
        Integer r106 = Integer.valueOf(r101.length());
    L6:
        r105.append(r106);
        r105.append(", version=");
        r105.append(r102);
        r104.i("OfficeSheetSelection", r105.toString());
        if (r100 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        r103.b("empty_selection");
    L15:
        r103.f362791d = true;
        r103.f362792e = r100;
        r103.f362793f = r101;
        r103.f362794g = r102;
        r103.a("selection_changed");
        return;
    L9:
        if (r100.length() == 0) goto L12;
        r107 = false;
        goto L13
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.larus.office.plugins.input.m1
    public void setChatInputVisible(String r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "from");
        com.larus.office.plugins.inputv2.coordinator.runtime.interaction.h r104 = getTrackCoordinator();
        r104.getClass();
        if (r101 == false) goto L6;
        if (r102 == true) goto L6;
        String r105 = "read";
    L7:
        r104.f362975g = r105;
        getVisibilityCoordinator().b(r100, r101);
        return;
    L6:
        r105 = "edit";
        goto L7
    }
}
