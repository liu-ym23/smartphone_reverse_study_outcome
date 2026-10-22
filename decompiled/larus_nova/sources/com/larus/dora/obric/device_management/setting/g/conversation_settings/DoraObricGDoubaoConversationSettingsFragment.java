package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.ailab.AiLabViewModel;
import com.larus.dora.impl.device.settings.lab.LabSettingsViewModel;
import com.larus.dora.impl.device.settings.lab.RTCTransportMode;
import com.larus.dora.obric.device_management.setting.common.auto_disconnect.DoraObricDoubaoAutoDisconnectViewModel;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \u008e\u00012\u00020\u0001:\u0004\u008d\u0001\u008e\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u000207H\u0016J\b\u0010;\u001a\u000207H\u0016J\u0010\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020$H\u0016J\b\u0010>\u001a\u00020?H\u0016J\n\u0010@\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010A\u001a\u00020\u001aH\u0002J\b\u0010B\u001a\u00020\u001aH\u0002J\b\u0010C\u001a\u00020\u001aH\u0002J\b\u0010D\u001a\u000207H\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001d0FH\u0002J\u0010\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0014\u0010I\u001a\u000207*\u00020\u001e2\u0006\u0010J\u001a\u00020?H\u0002J\f\u0010K\u001a\u000207*\u00020\u001eH\u0002J\u0010\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020\u001eH\u0002J\u0010\u0010N\u001a\u0002072\u0006\u0010M\u001a\u00020\u001eH\u0002J\f\u0010O\u001a\u000207*\u00020\u001eH\u0002J\f\u0010P\u001a\u000207*\u00020\u001eH\u0002J\u0010\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020?H\u0002J\b\u0010S\u001a\u00020?H\u0002J\f\u0010T\u001a\u00020?*\u00020?H\u0002J\b\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u000207H\u0002J\b\u0010W\u001a\u000207H\u0002J\b\u0010X\u001a\u000207H\u0002J\u0010\u0010Y\u001a\u0002072\u0006\u0010Z\u001a\u00020 H\u0002J\u0010\u0010[\u001a\u0002072\u0006\u0010Z\u001a\u00020 H\u0002J\u0010\u0010\\\u001a\u0002072\u0006\u0010Z\u001a\u00020 H\u0002J\u0010\u0010]\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\u0010\u0010`\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\u0010\u0010a\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\b\u0010a\u001a\u000207H\u0002J\u0010\u0010b\u001a\u0002072\u0006\u0010Z\u001a\u00020^H\u0002J\b\u0010b\u001a\u000207H\u0002J6\u0010c\u001a\u0002072\u0006\u0010d\u001a\u00020$2\u0006\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020i0FH\u0002J\b\u0010j\u001a\u00020$H\u0002J\u0010\u0010j\u001a\u00020$2\u0006\u0010Z\u001a\u00020^H\u0002J,\u0010k\u001a\u0002072\u0006\u0010H\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020$2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u0002070nH\u0002J\u0010\u0010o\u001a\u0002072\u0006\u0010p\u001a\u00020$H\u0002J\u0010\u0010q\u001a\u0002072\u0006\u0010r\u001a\u00020\u001eH\u0002J&\u0010s\u001a\u0002072\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010t\u001a\u00020i2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020i0FH\u0002J\u0010\u0010v\u001a\u00020?2\u0006\u0010w\u001a\u00020iH\u0002J\f\u0010x\u001a\u00020i*\u00020yH\u0002J\u0010\u0010z\u001a\u0002072\u0006\u0010{\u001a\u00020|H\u0002J\u0010\u0010}\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0010\u0010~\u001a\u00020?2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0010\u0010\u007f\u001a\u00020?2\u0006\u0010{\u001a\u00020|H\u0002J\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010$*\u00020 H\u0002¢\u0006\u0003\u0010\u0081\u0001J\t\u0010\u0082\u0001\u001a\u00020|H\u0002J\t\u0010\u0083\u0001\u001a\u00020|H\u0002J\t\u0010\u0084\u0001\u001a\u00020|H\u0002J\r\u0010\u0085\u0001\u001a\u000207*\u00020\u001eH\u0002J\u000e\u0010\u0086\u0001\u001a\u000207*\u00030\u0087\u0001H\u0002J\u000e\u0010\u0088\u0001\u001a\u000207*\u00030\u0089\u0001H\u0002J\r\u0010\u008a\u0001\u001a\u00020|*\u00020|H\u0002J\u000e\u0010\u008b\u0001\u001a\u00020|*\u00030\u008c\u0001H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b-\u0010*¨\u0006\u008f\u0001"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/conversation_settings/DoraObricGDoubaoConversationSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/setting/common/auto_disconnect/DoraObricDoubaoAutoDisconnectViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/setting/common/auto_disconnect/DoraObricDoubaoAutoDisconnectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "aiLabViewModel", "Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "getAiLabViewModel", "()Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "aiLabViewModel$delegate", "labSettingsViewModel", "Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "getLabSettingsViewModel", "()Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "labSettingsViewModel$delegate", "contentContainer", "Landroid/widget/LinearLayout;", "autoStopTimePopover", "Lcom/obric/oui/popover/v2/OPopover;", "rtcTransportPopover", "pageMaskView", "Landroid/view/View;", "itemViews", "", "Lcom/larus/dora/obric/device_management/setting/g/conversation_settings/DoraObricGDoubaoConversationSettingsFragment$DoubaoConversationSettingItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "latestAiLabState", "Lcom/larus/dora/impl/device/ailab/AiLabState;", "latestLabState", "Lcom/larus/dora/impl/device/settings/lab/LabEnvSettings;", "showConversationStartEndSoundRow", "", "showNaturalWakeupRow", "isVideoStreamSelectorEnabled", "isDataSavingVisible", "isRTCTransportVisible", "isCurrentGDeviceType", "()Z", "isCurrentGDeviceType$delegate", "showAutoStopTimeRow", "getShowAutoStopTimeRow", "showAutoStopTimeRow$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onStop", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "renderSettings", "conversationSettingItems", "", "buildSettingItem", MapController.ITEM_LAYER_TAG, "bindNaturalWakeupTitle", "title", "expandTitleContainerWidth", "bindSwitchItem", "itemView", "bindAutoStopTimeItem", "bindVideoStreamEnd", "bindDataSavingEnd", "buildSupportiveText", "text", "getVideoStreamSupportiveText", "removeTrailingPeriod", "observeAiLabState", "observeLabState", "observeAutoStopTime", "bindCurrentState", "bindAiLabState", "state", "bindVoiceWake", "bindConversationStartEndSound", "bindLabState", "Lcom/larus/dora/impl/device/settings/lab/LabEnvSettings$Success;", "bindAllowDoubaoViewImages", "bindNaturalWakeup", "bindDataSaving", "bindRTCTransport", "updateRTCTransportMode", "bluetoothRTCEnable", "p2pRTCEnable", "isP2PRTCRuntimeSupported", "isUserSelectMode", "selectableModes", "Lcom/larus/dora/impl/device/settings/lab/RTCTransportMode;", "shouldShowRTCTransport", "bindSwitch", "checked", "onCheckedChange", "Lkotlin/Function1;", "updateVoiceWake", "isChecked", "showAutoStopTimeMenu", "anchor", "showRTCTransportMenu", "currentMode", "modes", "getRTCTransportModeText", "mode", "toRTCTransportMode", "Lcom/larus/dora/impl/core/settingsconfig/DoraXLinkTransportMode;", "updateAutoStopTimeText", "time", "", "titleFor", "descriptionFor", "autoStopTimeText", "voiceWakeEnabled", "(Lcom/larus/dora/impl/device/ailab/AiLabState;)Ljava/lang/Boolean;", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyCardStyle", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "applySupportiveTextStyle", "Landroid/widget/TextView;", "dp", CloudControlInf.SP, "", "DoubaoConversationSettingItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGDoubaoConversationSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f340267w = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f340268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f340269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f340270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f340271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.obric.oui.popover.v2.c f340272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.obric.oui.popover.v2.c f340273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f340274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<DoubaoConversationSettingItem, OCardListItem> f340275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.larus.dora.impl.device.ailab.u f340276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.dora.impl.device.settings.lab.c f340277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f340278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f340279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f340280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f340281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f340282t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f340283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f340284v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/conversation_settings/DoraObricGDoubaoConversationSettingsFragment$DoubaoConversationSettingItem;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_WAKE", "AUTO_STOP_TIME", "CONVERSATION_START_END_SOUND", "ALLOW_DOUBAO_VIEW_IMAGES", "NATURAL_WAKEUP", "VIDEO_STREAM", "DATA_SAVING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DoubaoConversationSettingItem extends Enum<DoubaoConversationSettingItem> {
        public static final DoubaoConversationSettingItem ALLOW_DOUBAO_VIEW_IMAGES = null;
        public static final DoubaoConversationSettingItem AUTO_STOP_TIME = null;
        public static final DoubaoConversationSettingItem CONVERSATION_START_END_SOUND = null;
        public static final DoubaoConversationSettingItem DATA_SAVING = null;
        public static final DoubaoConversationSettingItem NATURAL_WAKEUP = null;
        public static final DoubaoConversationSettingItem VIDEO_STREAM = null;
        public static final DoubaoConversationSettingItem VOICE_WAKE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DoubaoConversationSettingItem[] f340285a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f340286b = null;

        public static EnumEntries<DoubaoConversationSettingItem> getEntries() {
            return f340286b;
        }

        static {
            DoubaoConversationSettingItem r100 = new DoubaoConversationSettingItem("VOICE_WAKE", 0);
            VOICE_WAKE = r100;
            DoubaoConversationSettingItem r101 = new DoubaoConversationSettingItem("AUTO_STOP_TIME", 1);
            AUTO_STOP_TIME = r101;
            DoubaoConversationSettingItem r102 = new DoubaoConversationSettingItem("CONVERSATION_START_END_SOUND", 2);
            CONVERSATION_START_END_SOUND = r102;
            DoubaoConversationSettingItem r103 = new DoubaoConversationSettingItem("ALLOW_DOUBAO_VIEW_IMAGES", 3);
            ALLOW_DOUBAO_VIEW_IMAGES = r103;
            DoubaoConversationSettingItem r104 = new DoubaoConversationSettingItem("NATURAL_WAKEUP", 4);
            NATURAL_WAKEUP = r104;
            DoubaoConversationSettingItem r105 = new DoubaoConversationSettingItem("VIDEO_STREAM", 5);
            VIDEO_STREAM = r105;
            DoubaoConversationSettingItem r110 = new DoubaoConversationSettingItem("DATA_SAVING", 6);
            DATA_SAVING = r110;
            DoubaoConversationSettingItem[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f340285a = r111;
            f340286b = EnumEntriesKt.enumEntries(r111);
        }

        public static DoubaoConversationSettingItem[] values() {
            return (DoubaoConversationSettingItem[]) f340285a.clone();
        }

        public static DoubaoConversationSettingItem valueOf(String r100) {
            return (DoubaoConversationSettingItem) r27.a.a(DoubaoConversationSettingItem.class, r100);
        }

        public DoubaoConversationSettingItem(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f340287a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f340288b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f340289c = null;

        static {
            int[] r100 = new int[DoubaoConversationSettingItem.values().length];
            r100[DoubaoConversationSettingItem.VIDEO_STREAM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[DoubaoConversationSettingItem.DATA_SAVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L59:
            r100[DoubaoConversationSettingItem.AUTO_STOP_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L45:
            r100[DoubaoConversationSettingItem.VOICE_WAKE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L35:
            r100[DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L49:
            r100[DoubaoConversationSettingItem.NATURAL_WAKEUP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L12:
            f340287a = r100;
            int[] r101 = new int[RTCTransportMode.values().length];
            r101[RTCTransportMode.OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L37:
            r101[RTCTransportMode.BLUETOOTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L51:
            r101[RTCTransportMode.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L16:
            f340288b = r101;
            int[] r102 = new int[DoraXLinkTransportMode.values().length];
            r102[DoraXLinkTransportMode.OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r102[DoraXLinkTransportMode.BLUETOOTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L39:
            r102[DoraXLinkTransportMode.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L20:
            f340289c = r102;
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "ai_lab";
    }

    public final AiLabViewModel ea0() {
        return (AiLabViewModel) this.f340269g.getValue();
    }

    public final LabSettingsViewModel fa0() {
        return (LabSettingsViewModel) this.f340270h.getValue();
    }

    public final DoraObricDoubaoAutoDisconnectViewModel ha0() {
        return (DoraObricDoubaoAutoDisconnectViewModel) this.f340268f.getValue();
    }

    public final void ja0() {
        LinearLayout r100 = this.f340271i;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f340282t = ka0();
        this.f340281s = fa0().isDataSavingEntranceVisible();
        List r101 = CollectionsKt.mutableListOf(new DoubaoConversationSettingItem[]{DoubaoConversationSettingItem.VOICE_WAKE});
        if (this.f340279q == false) goto L9;
        r101.add(DoubaoConversationSettingItem.NATURAL_WAKEUP);
    L9:
        if (((Boolean) this.f340284v.getValue()).booleanValue() == false) goto L12;
        r101.add(DoubaoConversationSettingItem.AUTO_STOP_TIME);
    L12:
        if (this.f340278p == false) goto L14;
        r101.add(DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND);
    L14:
        List r102 = r101;
        r102.add(DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES);
        if (this.f340282t == false) goto L18;
        r102.add(DoubaoConversationSettingItem.VIDEO_STREAM);
    L18:
        if (this.f340281s == false) goto L20;
        r102.add(DoubaoConversationSettingItem.DATA_SAVING);
    L20:
        ((LinkedHashMap) this.f340275m).clear();
        r100.removeAllViews();
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L22:
        if (r103.hasNext() == false) goto L131;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        DoubaoConversationSettingItem r107 = (DoubaoConversationSettingItem) r105;
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-1, -2);
        if (r104 <= 0) goto L29;
        r108.topMargin = da0(16);
    L29:
        final OCardListItem r109 = new OCardListItem(requireContext(), null, 6, 0);
        this.f340275m.put(r107, r109);
        r109.setCardType(0);
        OCardListItem.h(r109, 0);
        r109.setShowCardBg(true);
        r109.p(false);
        int[] r110 = b.f340287a;
        switch(r110[r107.ordinal()]) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            default: goto L32;
        };
    L33:
        String r111 = getString(R.string.larus_dora_newwakeup_title_cn);
    L40:
        r109.setTitle(r111);
        r109.s(true);
        if (r107 != DoubaoConversationSettingItem.NATURAL_WAKEUP) goto L69;
        OCardListItem.j(r109, 0);
        LinearLayout r112 = r109.getTitleContainer();
        ViewGroup.LayoutParams r113 = r109.getTitleContainer().getLayoutParams();
        if ((r113 instanceof ConstraintLayout.LayoutParams) == false) goto L45;
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
    L46:
        if (r114 == null) goto L48;
        ((ViewGroup.MarginLayoutParams) r114).width = 0;
        r114.W = false;
        r114.L = 0;
        r112.setLayoutParams(r114);
    L48:
        View r115 = r109.c();
        if ((r115 instanceof ViewGroup) == false) goto L51;
        OTextView r116 = (OTextView) ((ViewGroup) r115).findViewById(R.id.custom_title_text);
    L52:
        if (r116 == null) goto L54;
        r116.setText(r111);
        r116.setMaxLines(1);
    L54:
        View r117 = r109.c();
        if ((r117 instanceof ViewGroup) == false) goto L57;
        ViewGroup r118 = (ViewGroup) r117;
    L58:
        if (r118 == null) goto L67;
        ImageView r119 = (ImageView) r118.findViewById(R.id.custom_title_icon);
        if (r119 == null) goto L67;
        r119.setContentDescription(null);
        r119.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r119.setImageResource(R.drawable.larus_dora_obric_conversation_ic_beta);
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L64;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
    L65:
        if (r121 == null) goto L67;
        r121.width = da0(34);
        r121.height = da0(20);
        r121.setMarginStart(da0(4));
        r119.setLayoutParams(r121);
        goto L67
    L64:
        r121 = null;
    L67:
        r109.s(false);
        goto L69
    L57:
        r118 = null;
        goto L58
    L51:
        r116 = null;
        goto L52
    L45:
        r114 = null;
    L69:
        switch(r110[r107.ordinal()]) {
            case 1: goto L78;
            case 2: goto L77;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L72;
            default: goto L71;
        };
    L72:
        String r122 = getString(R.string.larus_dora_obric_conversation_natural_wake_desc_cn);
    L79:
        r109.setSubTitle(r122);
        r109.getSubTitleView().setMaxLines(5);
        int r123 = r110[r107.ordinal()];
        if (r123 == 1) goto L95;
        if (r123 == 2) goto L92;
        if (r123 == 3) goto L84;
        r109.q(true);
        r109.setDefaultCustomEndView(1);
        r109.m(true);
        r109.r(false);
    L99:
        ViewGroup.LayoutParams r124 = r109.getCardContainer().getLayoutParams();
        if ((r124 instanceof ViewGroup.MarginLayoutParams) == false) goto L102;
        ViewGroup.MarginLayoutParams r125 = (ViewGroup.MarginLayoutParams) r124;
    L103:
        if (r125 == null) goto L105;
        r125.setMarginStart(0);
        r125.setMarginEnd(0);
        r125.leftMargin = 0;
        r125.rightMargin = 0;
        r109.getCardContainer().setLayoutParams(r125);
    L105:
        r109.getCardContainer().setPadding(da0(8), da0(8), da0(8), da0(8));
        r109.getContentContainer().setPadding(0, 0, da0(4), 0);
        r109.getTitleContainer().setGravity(16);
        r109.getTitleContainer().setPadding(da0(12), da0(10), da0(8), da0(10));
        OTextView r126 = r109.getTitleView();
        r126.setGravity(8388627);
        r126.setMaxLines(1);
        r126.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r126, la0(22.0f));
        r126.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
        OTextView r127 = r109.getSubTitleView();
        r127.setGravity(8388627);
        r127.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r127, la0(16.0f));
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if ((r128 instanceof ViewGroup.MarginLayoutParams) == false) goto L108;
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
    L109:
        if (r129 == null) goto L111;
        r129.topMargin = da0(2);
        r127.setLayoutParams(r129);
    L111:
        r109.o(false);
        Drawable r130 = r109.getCardContainer().getBackground();
        if ((r130 instanceof GradientDrawable) == false) goto L114;
        GradientDrawable r131 = (GradientDrawable) r130;
    L115:
        if (r131 == null) goto L117;
        r131.setCornerRadius(da0(20));
    L117:
        Drawable r132 = r109.getContentContainer().getBackground();
        if ((r132 instanceof GradientDrawable) == false) goto L120;
        GradientDrawable r133 = (GradientDrawable) r132;
    L121:
        if (r133 == null) goto L123;
        r133.setCornerRadius(da0(12));
    L123:
        r100.addView(r109, r108);
        int r134 = r110[r107.ordinal()];
        if (r134 != 1) goto L126;
        r100.addView(ca0(ia0(getString(R.string.larus_dora_lab_bluetooth_rtc_desc_cn))));
    L130:
        r104 = r106;
        goto L22
    L126:
        if (r134 != 2) goto L130;
        r100.addView(ca0(ia0(getString(R.string.larus_dora_lab_data_saving_desc_cn))));
        goto L130
    L120:
        r133 = null;
        goto L121
    L114:
        r131 = null;
        goto L115
    L108:
        r129 = null;
        goto L109
    L102:
        r125 = null;
        goto L103
    L84:
        r109.q(true);
        r109.setDefaultCustomEndView(3);
        r109.m(true);
        r109.k(Y90(ha0().getAutoStopTime().getValue().intValue()), da0(80));
        OTextView r135 = r109.getEndDetail();
        if (r135 == null) goto L87;
        X90(r135);
    L87:
        r109.setTailIcon(R.drawable.oic_chevron_up_down);
        ImageView r136 = r109.getTailIconView();
        r136.setImageTintList(ContextCompat.getColorStateList(r136.getContext(), R.color.oui_basic_text_3b));
        r136.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
        if (r137 == null) goto L90;
        r137.width = da0(20);
        r137.height = da0(20);
    L91:
        r136.setLayoutParams(r137);
        r109.r(true);
        r109.setOnContentClickListener(new j(this, r109));
        goto L99
    L90:
        r137 = null;
        goto L91
    L92:
        r109.q(false);
        r109.setDefaultCustomEndView(1);
        r109.m(true);
        r109.r(false);
        r109.setOnContentClickListener(null);
        OSwitch r138 = r109.getEndSwitch();
        if (r138 == null) goto L99;
        r138.setOnCheckedChangeListener(new m(this));
        goto L99
    L95:
        r109.q(false);
        r109.setDefaultCustomEndView(3);
        r109.m(true);
        r109.k("", da0(96));
        OTextView r139 = r109.getEndDetail();
        if (r139 == null) goto L98;
        X90(r139);
    L98:
        r109.setDefaultTailIcon(0);
        r109.r(false);
        r109.setOnContentClickListener(null);
        goto L99
    L73:
        r122 = getString(R.string.larus_dora_obric_conversation_photo_qa_desc_cn);
        goto L79
    L74:
        r122 = getString(R.string.larus_dora_obric_conversation_start_end_sound_desc_cn);
        goto L79
    L75:
        r122 = getString(R.string.larus_dora_obric_conversation_voice_wake_desc_cn);
        goto L79
    L76:
        r122 = getString(R.string.larus_dora_obric_conversation_auto_stop_desc_cn);
        goto L79
    L77:
        r122 = ia0(getString(R.string.larus_dora_lab_data_saving_desc_cn));
        goto L79
    L78:
        r122 = ia0(getString(R.string.larus_dora_lab_bluetooth_rtc_desc_cn));
        goto L79
    L71:
        throw new NoWhenBranchMatchedException();
    L34:
        r111 = getString(R.string.larus_dora_lab_allow_doubao_see_photo_cn);
        goto L40
    L35:
        r111 = getString(R.string.larus_dora_conversation_start_and_end_sound_cn);
        goto L40
    L36:
        r111 = getString(R.string.larus_dora_ai_voice_wake_switch_cn);
        goto L40
    L37:
        r111 = getString(R.string.larus_dora_auto_stop_time_cn);
        goto L40
    L38:
        r111 = getString(R.string.larus_dora_lab_data_saving_cn);
        goto L40
    L39:
        r111 = getString(R.string.larus_dora_lab_bluetooth_rtc_cn);
        goto L40
    L32:
        throw new NoWhenBranchMatchedException();
    L131:
        com.larus.dora.impl.device.ailab.u r140 = this.f340276n;
        ba0(r140);
        if ((r140 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L134;
        com.larus.dora.impl.device.ailab.u.b r141 = (com.larus.dora.impl.device.ailab.u.b) r140;
    L135:
        if (r141 == null) goto L137;
        aa0(DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND, r141.f333578e, new l(this));
    L137:
        com.larus.dora.impl.device.settings.lab.c r142 = this.f340277o;
        if ((r142 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L140;
        com.larus.dora.impl.device.settings.lab.c.b r143 = (com.larus.dora.impl.device.settings.lab.c.b) r142;
    L141:
        if (r143 == null) goto L147;
        aa0(DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES, r143.f334578j, new k(this));
        aa0(DoubaoConversationSettingItem.NATURAL_WAKEUP, r143.f334575g, new p(this));
        Z90(r143);
        OCardListItem r144 = (OCardListItem) ((LinkedHashMap) this.f340275m).get(DoubaoConversationSettingItem.DATA_SAVING);
        if (r144 == null) goto L147;
        OSwitch r145 = r144.getEndSwitch();
        if (r145 == null) goto L147;
        r145.setChecked(r143.f334590v);
    L147:
        na0(ha0().getAutoStopTime().getValue().intValue());
        com.larus.dora.impl.device.settings.lab.c r146 = fa0().getEnvStateFlow().getValue();
        if ((r146 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L150;
        com.larus.dora.impl.device.settings.lab.c.b r147 = (com.larus.dora.impl.device.settings.lab.c.b) r146;
    L151:
        if (r147 == null) goto L154;
        Z90(r147);
    L154:
        com.larus.dora.impl.device.settings.lab.c r148 = fa0().getEnvStateFlow().getValue();
        if ((r148 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L157;
        com.larus.dora.impl.device.settings.lab.c.b r149 = (com.larus.dora.impl.device.settings.lab.c.b) r148;
    L158:
        if (r149 == null) goto L174;
        OCardListItem r150 = (OCardListItem) ((LinkedHashMap) this.f340275m).get(DoubaoConversationSettingItem.DATA_SAVING);
        if (r150 == null) goto L172;
        OSwitch r151 = r150.getEndSwitch();
        if (r151 == null) goto L173;
        r151.setChecked(r149.f334590v);
        return;
    L173:
        return;
    L172:
        return;
    L174:
        return;
    L157:
        r149 = null;
        goto L158
    L150:
        r147 = null;
        goto L151
    L140:
        r143 = null;
        goto L141
    L134:
        r141 = null;
        goto L135
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r100 = this.f340272j;
        if (r100 == null) goto L5;
        W90(r100);
    L5:
        this.f340272j = null;
        com.obric.oui.popover.v2.c r101 = this.f340273k;
        if (r101 == null) goto L8;
        W90(r101);
    L8:
        this.f340273k = null;
        this.f340271i = null;
        this.f340274l = null;
        ((LinkedHashMap) this.f340275m).clear();
        super.onDestroyView();
    }

    public DoraObricGDoubaoConversationSettingsFragment() {
        final Function0<Fragment> r100 = new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f340268f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricDoubaoAutoDisconnectViewModel.class), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$viewModels$default$2(r100), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f340269g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AiLabViewModel.class), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.f340270h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LabSettingsViewModel.class), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$3(this), new DoraObricGDoubaoConversationSettingsFragment$special$$inlined$activityViewModels$default$4(this));
        this.f340275m = new LinkedHashMap();
        this.f340276n = com.larus.dora.impl.device.ailab.u.a.f333573a;
        this.f340277o = com.larus.dora.impl.device.settings.lab.c.a.f334568a;
        this.f340280r = true;
        this.f340283u = LazyKt.lazy(new n());
        this.f340284v = LazyKt.lazy(new o(this));
    }

    public final boolean ka0() {
        com.larus.dora.impl.device.settings.lab.c r100 = fa0().getEnvStateFlow().getValue();
        if ((r100 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L5;
        com.larus.dora.impl.device.settings.lab.c.b r101 = (com.larus.dora.impl.device.settings.lab.c.b) r100;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        com.larus.dora.impl.core.settingsconfig.c.f332267a.getClass();
        if (com.larus.dora.impl.core.settingsconfig.c.j() == true) goto L12;
        return false;
    L12:
        if (r101.f334583o == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ea0().load();
        fa0().forceUpdateEnable();
        ha0().refreshAutoStopTime();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        com.larus.dora.impl.device.ailab.u r100 = this.f340276n;
        if ((r100 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L6;
        boolean r101 = ((com.larus.dora.impl.device.ailab.u.b) r100).f333574a;
    L11:
        DoraBuryPointManager r102 = DoraBuryPointManager.f331862a;
        Pair[] r103 = new Pair[2];
        String r104 = "on";
        if (r101 == false) goto L14;
        Object r105 = "on";
    L15:
        r103[0] = TuplesKt.to("voice_wakeup", r105);
        if (ea0().isMultiUserModeEnabled() == true) goto L19;
        r104 = "off";
    L19:
        r103[1] = TuplesKt.to("multi_user_mode", r104);
        r102.L("dora_ai_lab_settings", MapsKt.mapOf(r103));
        return;
    L14:
        r105 = "off";
        goto L15
    L6:
        if ((r100 instanceof com.larus.dora.impl.device.ailab.u.c) == false) goto L9;
        r101 = ((com.larus.dora.impl.device.ailab.u.c) r100).f333580a;
        goto L11
    L9:
        if (Intrinsics.areEqual(r100, com.larus.dora.impl.device.ailab.u.a.f333573a) == false) goto L22;
        r101 = false;
        goto L11
    L22:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.f340274l;
    }

    public static void W90(com.obric.oui.popover.v2.c r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    }

    public static String ia0(String r100) {
        String r101 = StringsKt.trimEnd(r100).toString();
        Character r102 = StringsKt.lastOrNull(r101);
        if (r102 != null) goto L6;
    L7:
        if (r102 != null) goto L10;
    L11:
        if (r102 != null) goto L14;
        return r101;
    L14:
        if (r102.charValue() == '.') goto L16;
        return r101;
    L16:
        return StringsKt.trimEnd(StringsKt.dropLast(r101, 1)).toString();
    L10:
        if (r102.charValue() == 65294) goto L16;
    L6:
        if (r102.charValue() == 12290) goto L16;
        goto L7
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r100) {
        super.V90(r100);
        if (r100 == false) goto L6;
        ea0().load();
        fa0().forceUpdateEnable();
        ha0().refreshAutoStopTime();
        return;
    }

    public final void X90(OTextView r100) {
        r100.setTextColor(v19.c.a(R.attr.larus_neutral_50, requireContext(), R.color.larus_neutral_50));
        r100.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r100, la0(18.0f));
    }

    public final String Y90(int r100) {
        String r101 = String.valueOf(r100);
        return StringsKt.replace$default(StringsKt.replace$default(getString(R.string.larus_dora_obric_conversation_auto_stop_seconds_cn), "{time}", r101, false, 4, null), "%s", r101, false, 4, null);
    }

    public final void Z90(com.larus.dora.impl.device.settings.lab.c.b r100) {
        com.larus.dora.impl.core.settingsconfig.c r101 = com.larus.dora.impl.core.settingsconfig.c.f332267a;
        r101.getClass();
        boolean r102 = true;
        if (com.larus.dora.impl.core.settingsconfig.c.j() == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L14;
        r101.getClass();
        if (com.larus.dora.impl.core.settingsconfig.c.b().f332270b.contains("p2p") == false) goto L14;
        if (r100.f334585q == false) goto L14;
        boolean r104 = true;
    L15:
        boolean r105 = r100.f334581m;
        boolean r106 = r100.f334582n;
        boolean r107 = r100.f334584p;
        r101.getClass();
        boolean r108 = com.larus.dora.impl.core.settingsconfig.c.g();
        List r109 = com.larus.dora.impl.core.settingsconfig.c.i(r104);
        final ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r111 = r109.iterator();
    L17:
        if (r111.hasNext() == false) goto L19;
        r110.add(ma0((DoraXLinkTransportMode) r111.next()));
        goto L17
    L19:
        final OCardListItem r112 = (OCardListItem) ((LinkedHashMap) this.f340275m).get(DoubaoConversationSettingItem.VIDEO_STREAM);
        if (r112 == null) goto L39;
        com.larus.dora.impl.core.settingsconfig.c.f332267a.getClass();
        final RTCTransportMode r113 = ma0(com.larus.dora.impl.core.settingsconfig.c.d(r105, r106, r107));
        if (this.f340280r == false) goto L28;
        if (r108 == false) goto L28;
        if ((!r110.isEmpty()) == false) goto L28;
    L29:
        r112.k(ga0(r113), da0(96));
        OTextView r114 = r112.getEndDetail();
        if (r114 == null) goto L32;
        X90(r114);
    L32:
        r112.r(r102);
        if (r102 == false) goto L35;
        View.OnClickListener r115 = new h(this, r112, r113, r110);
    L36:
        r112.setOnContentClickListener(r115);
        r112.setEnabled(this.f340280r);
        return;
    L35:
        r115 = null;
    L28:
        r102 = false;
        goto L29
    L39:
        return;
    L14:
        r104 = false;
        goto L15
    L5:
        if (r100.f334583o == false) goto L7;
        r103 = true;
        goto L8
    }

    public final void ba0(com.larus.dora.impl.device.ailab.u r100) {
        if ((r100 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L6;
        Boolean r101 = Boolean.valueOf(((com.larus.dora.impl.device.ailab.u.b) r100).f333574a);
    L11:
        if (r101 == null) goto L16;
        boolean r102 = r101.booleanValue();
        aa0(DoubaoConversationSettingItem.VOICE_WAKE, r102, new i(this));
        return;
    L16:
        return;
    L6:
        if ((r100 instanceof com.larus.dora.impl.device.ailab.u.c) == false) goto L9;
        r101 = Boolean.valueOf(((com.larus.dora.impl.device.ailab.u.c) r100).f333580a);
        goto L11
    L9:
        if (Intrinsics.areEqual(r100, com.larus.dora.impl.device.ailab.u.a.f333573a) == false) goto L15;
        r101 = null;
        goto L11
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final View ca0(String r100) {
        OSectionSupportiveText r101 = new OSectionSupportiveText(requireContext(), null, 6, 0);
        r101.setPadding(da0(20), 0, da0(20), 0);
        r101.setSectionDes(r100);
        TextView r102 = (TextView) r101.findViewById(R.id.section_des);
        if (r102 == null) goto L5;
        r102.setTextColor(v19.c.a(R.attr.larus_neutral_50, requireContext(), R.color.larus_neutral_50));
        r102.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r102, la0(16.0f));
        r102.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
    L5:
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r101;
    }

    public final int da0(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final String ga0(RTCTransportMode r100) {
        int r101 = b.f340288b[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = R.string.larus_dora_g_ble_transfer_cn;
    L14:
        return getString(r102);
    L5:
        if (r101 != 2) goto L7;
        r102 = R.string.larus_dora_g_bt_transfer_cn;
        goto L14
    L7:
        if (r101 != 3) goto L10;
        r102 = R.string.larus_dora_g_wifi_transfer_cn;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final int la0(float r100) {
        Resources r101 = getResources();
        return (int) TypedValue.applyDimension(2, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final RTCTransportMode ma0(DoraXLinkTransportMode r100) {
        int r101 = b.f340289c[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return RTCTransportMode.WIFI;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return RTCTransportMode.BLUETOOTH;
    L13:
        return RTCTransportMode.OFF;
    }

    public final void na0(int r100) {
        Map<DoubaoConversationSettingItem, OCardListItem> r101 = this.f340275m;
        DoubaoConversationSettingItem r102 = DoubaoConversationSettingItem.AUTO_STOP_TIME;
        OCardListItem r103 = (OCardListItem) ((LinkedHashMap) r101).get(r102);
        if (r103 == null) goto L5;
        r103.k(Y90(r100), da0(80));
    L5:
        OCardListItem r104 = (OCardListItem) ((LinkedHashMap) this.f340275m).get(r102);
        if (r104 == null) goto L11;
        OTextView r105 = r104.getEndDetail();
        if (r105 == null) goto L12;
        X90(r105);
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ja0();
        Lifecycle.State r112 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAiLabState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAiLabState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAiLabState$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeLabState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeLabState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeLabState$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r112, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDoubaoConversationSettingsFragment$observeAutoStopTime$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r112, null, this), 3, null);
    }

    public final void aa0(DoubaoConversationSettingItem r100, boolean r101, final Function1<? super Boolean, Unit> r102) {
        OCardListItem r103 = (OCardListItem) ((LinkedHashMap) this.f340275m).get(r100);
        if (r103 == null) goto L8;
        OSwitch r104 = r103.getEndSwitch();
        if (r104 == null) goto L9;
        r104.setOnCheckedChangeListener(null);
        r104.setChecked(r101);
        r104.setOnCheckedChangeListener(new e(r102));
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Context r113 = requireContext();
        OFloatingTitleBar r114 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r114.setClipChildren(false);
        r114.setClipToPadding(false);
        r114.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        r114.setCenterTitle(getString(R.string.larus_dora_obric_conversation_nav_title_cn));
        r114.R(false);
        OFloatingTitleBar.k(r114, null, 6).setOnClickListener(new com.larus.dora.obric.device_management.setting.g.conversation_settings.b(this));
        Context r115 = requireContext();
        LinearLayout r100 = new LinearLayout(r115);
        r100.setOrientation(1);
        r100.setClipChildren(false);
        r100.setClipToPadding(false);
        r100.setPadding(da0(12), da0(16), da0(12), da0(24));
        this.f340271i = r100;
        NestedScrollView r101 = new NestedScrollView(r115);
        r101.setClipChildren(true);
        r101.setClipToPadding(false);
        r101.setOverScrollMode(2);
        r101.setFillViewport(true);
        r101.addView(this.f340271i, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r113, r114, r101, v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay), new com.larus.dora.obric.device_management.setting.g.conversation_settings.a(this));
    }
}
