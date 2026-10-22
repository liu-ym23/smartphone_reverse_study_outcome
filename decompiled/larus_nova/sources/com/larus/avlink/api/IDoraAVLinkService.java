package com.larus.avlink.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import b98.d;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.avlink.gallery.view.s1;
import com.larus.avlink.model.FlowDoraScene;
import com.larus.avlink.model.FlowDoraSceneState;
import com.larus.dora.impl.device.manage.holder.a0;
import com.larus.dora.impl.device.manage.holder.b0;
import com.larus.dora.impl.device.manage.holder.c0;
import com.larus.dora.impl.device.manage.holder.d0;
import com.larus.dora.impl.device.manage.holder.y;
import com.larus.dora.impl.device.manage.holder.z;
import com.larus.dora.o.impl.album.ODoraAlbumCardView;
import com.larus.dora.o.impl.diary.settings.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import w88.e;
import w88.i;
import w88.j;
import w88.k;
import w88.l;
import w88.r;
import w88.s;
import w88.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J2\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J2\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J2\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u0010H&J2\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&J\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&J\"\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&J\u001c\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u001eH&J\u001c\u0010\u001f\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u001eH&J\u001c\u0010 \u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\u001c\u0010!\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\b\u0010\"\u001a\u00020\u0010H&J\u001c\u0010#\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\u001c\u0010$\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0010H'J\b\u0010'\u001a\u00020\u0010H&J\u001a\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020\u0003H&J\u001a\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u000bH&J\u0018\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH&J\u001a\u00103\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H&J\u0018\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0006H&J\u0017\u00108\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u0010H&J\b\u0010;\u001a\u00020\u0010H&J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u000bH&J\b\u0010>\u001a\u00020\u000bH&J\b\u0010?\u001a\u00020\u000bH&J\b\u0010@\u001a\u00020\u0010H&J\b\u0010A\u001a\u00020\u0010H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u000bH&J\b\u0010D\u001a\u00020\u000bH&J\u0012\u0010E\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J4\u0010F\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0H2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\b\u0010J\u001a\u00020\u0003H&J\b\u0010K\u001a\u00020LH&J\u0010\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020LH&J\u000e\u0010O\u001a\u00020PH¦@¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020SH¦@¢\u0006\u0002\u0010QJ\b\u0010T\u001a\u00020UH&J\n\u0010V\u001a\u0004\u0018\u00010\u000bH&J\b\u0010W\u001a\u00020\u0003H&J\u0010\u0010X\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0006H&J\u0010\u0010Y\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0006H&J\u0018\u0010Z\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0010H&J\u0010\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0006H&J\u0010\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u000bH&J\b\u0010a\u001a\u00020\u0003H&J\b\u0010b\u001a\u00020\u0010H&J\b\u0010c\u001a\u00020\u0003H&J\u0018\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000bH&J\u0010\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020\u000bH&J\b\u0010i\u001a\u00020\u0010H&J\n\u0010j\u001a\u0004\u0018\u00010\u000bH\u0016J\u0019\u0010k\u001a\u0004\u0018\u00010\u000b2\b\u0010l\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010mJ\b\u0010n\u001a\u00020\u0010H&J\b\u0010o\u001a\u00020\u000bH&J\u0010\u0010p\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020qH&J\u0010\u0010r\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020qH&J\u001c\u0010s\u001a\u00020\u00032\b\b\u0001\u0010e\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010t\u001a\u00020\u00102\b\b\u0001\u0010e\u001a\u00020\u0006H&J\u0017\u0010u\u001a\u0004\u0018\u00010\u00062\u0006\u0010v\u001a\u00020\u000bH&¢\u0006\u0002\u0010wJ\u0012\u0010x\u001a\u0004\u0018\u00010\u000b2\u0006\u0010y\u001a\u00020\u000bH&J<\u0010z\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0010\b\u0002\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0010\b\u0002\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&J\u001a\u0010}\u001a\u00020\u00032\u0010\b\u0002\u0010~\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019H&J\u001c\u0010\u007f\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\u001d\u0010\u0080\u0001\u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\u000f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060HH&J\u0012\u0010\u0082\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020\u000bH&J\u001b\u0010\u0084\u0001\u001a\u00020\u00032\u0007\u0010\u0085\u0001\u001a\u00020\u00062\u0007\u0010\u0086\u0001\u001a\u00020+H&J\u001a\u0010\u0087\u0001\u001a\u00020\u00032\u0007\u0010\u0088\u0001\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001b\u0010\u0089\u0001\u001a\u00020\u00032\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0006\u0010e\u001a\u00020\u000bH&J\u001c\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H&J\t\u0010\u0090\u0001\u001a\u00020\u0010H&J\t\u0010\u0091\u0001\u001a\u00020\u0010H&J\u001a\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u0006H¦@¢\u0006\u0003\u0010\u0095\u0001J\t\u0010\u0096\u0001\u001a\u00020\u0003H&J\u0012\u0010\u0097\u0001\u001a\u00020\u00032\u0007\u0010\u001d\u001a\u00030\u0098\u0001H&J\u0012\u0010\u0099\u0001\u001a\u00020\u00032\u0007\u0010\u001d\u001a\u00030\u0098\u0001H&J\u0011\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u00030\u009c\u00010\u009b\u0001H&J\u0011\u0010\u009d\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010\u009b\u0001H&J\u001c\u0010\u009f\u0001\u001a\u00030 \u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010¡\u0001\u001a\u00030¢\u0001H&J\u001a\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010\u009b\u00012\u0007\u0010¥\u0001\u001a\u00020\u0010H&J\u0010\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100\u009b\u0001H&J\u0019\u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010H2\u0007\u0010¥\u0001\u001a\u00020\u0010H&J\u0010\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030ª\u00010HH&J\t\u0010«\u0001\u001a\u00020\u0003H&J\t\u0010¬\u0001\u001a\u00020\u0010H&J\u001e\u0010\u00ad\u0001\u001a\u00020\u00032\u0013\u0010®\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u001eH&J\u0012\u0010¯\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0010H&J%\u0010±\u0001\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\t\u0010²\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010³\u0001\u001a\u00020\u000bH\u0016JU\u0010´\u0001\u001a\u00020\u00032\u000e\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u00010H2\u0013\u0010·\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u001e2%\u0010¸\u0001\u001a \u0012\u0016\u0012\u00140+¢\u0006\u000f\b¹\u0001\u0012\n\bº\u0001\u0012\u0005\b\b(»\u0001\u0012\u0004\u0012\u00020\u00030\u001eH&J\n\u0010¼\u0001\u001a\u00030½\u0001H&¨\u0006¾\u0001"}, d2 = {"Lcom/larus/avlink/api/IDoraAVLinkService;", "Lcom/larus/avlink/api/IDoraAVLinkServiceCommon;", "idleInit", "", "handleRecordWakeUp", "state", "", "mode", "query", "vuiId", "kw", "", "handleRecordWakeOff", "handleRecordWakeReject", "handleRecordPreCheck", "startRecordFromRecorderApp", "", "requestId", "isDeviceRecording", "guiStartRecord", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDeviceConnected", "sourceTag", "onSuccess", "Lkotlin/Function0;", "guiEndRecord", "guiEndOfflineRecord", "addRecordDurationListener", "listener", "Lkotlin/Function1;", "removeRecordDurationListener", "addRecordingUpdateListener", "removeRecordingUpdateListener", "isHardwareOfflineRecording", "addOfflineRecordingUpdateListener", "removeOfflineRecordingUpdateListener", "reportMicOccupyStatus", "isOccupy", "isMusicActive", "recordNotificationReceived", "notificationId", "clientReceiveTimestampMs", "", "discardPendingNotificationSummaries", "onProActiveSummaryReceivedFromIm", "summaryId", "biz", "onProActiveSummaryReceivedFromPush", "title", "content", "notifyDoraTakePicture", GearStrategyConsts.EV_QUALITY, "reportEnvObserveStatus", "status", "reason", "setPendingEnvObserveEndReason", "(Ljava/lang/Integer;)V", "enableVideoLiveAI", "isDoraCallDegrade", "isDoraSettingEntranceDegrade", "source", "postProcessorVersion", "videoStabilizerVersion", "isDoraNotifyDegrade", "isDoraGuideDegrade", "shareVideoFile", "videoFile", "getHost", "shareAlbumZip", "shareAlbumByIndex", "list", "", "onComplete", "clickGuideTimes", "getGalleryStoragePolicyConfig", "Lcom/larus/avlink/api/GalleryStoragePolicyConfig;", "updateGalleryStoragePolicyConfig", "config", "getGalleryStorageStats", "Lcom/larus/avlink/api/GalleryStorageStats;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupGalleryStorage", "Lcom/larus/avlink/api/GalleryStorageCleanupResult;", "getFaceSrModelState", "Lcom/larus/avlink/api/FaceSrModelState;", "getRecordText", "showRecordErrToast", "checkGAppUpdate", "enableGUpdate", "onRejectStartVUI", "onNaturalWakeupVadChanged", "isStart", "onNaturalWakeupFuzzyWakeup", "result", "setMockFilePath", "mockFilePath", "registerReceiveMessageListener", "isDoraG", "unRegisterReceiveMessageListener", "sendRecordMinutesText", "scene", "sendFuncChannel", "stopRecord", "stopReason", "isRecording", "getCurrentRecordingId", "getHardwareRecordingTitle", "productId", "(Ljava/lang/Integer;)Ljava/lang/String;", "isDoraGEnable", "getHookURL", "registerSceneStateChangeListener", "Lcom/larus/avlink/common/SceneStateChangeListener;", "unregisterSceneStateChangeListener", "updateSceneState", "isInScene", "getImageIdByMessageIdWithIntent", "messageId", "(Ljava/lang/String;)Ljava/lang/Integer;", "languageCodeToName", "code", "guiStartSimulInterpret", "onStartSi", "onBlockStartSi", "guiEndSimulInterpret", "onStopSi", "addTranslationStateListener", "removeTranslationStateListener", "getSupportedClientIntentType", "onPlayTTS", "text", "onLocalIntentReceived", "intentType", "intentId", "enableCameraMockPlayback", "dataSetPath", "bindFirstFeedShowView", "view", "Landroid/view/View;", "createMediaAlbumViewHelper", "Lcom/larus/avlink/api/IMediaAlbumViewHelper;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "requestP2PRTCVideoCallFromDeviceKey", "isMediaTransferOrProcessing", "getAlbumPreviewData", "Lcom/larus/avlink/api/DoraOAlbumPreviewData;", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerAlbumSync", "registerAlbumMediaChangeListener", "Lcom/larus/avlink/api/DoraOAlbumMediaChangeListener;", "unregisterAlbumMediaChangeListener", "observeAlbumSyncState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/avlink/api/DoraOAlbumSyncState;", "observeAlbumCountChange", "Lcom/larus/avlink/api/DoraOAlbumCount;", "createDiaryDetailContentView", "Lcom/larus/avlink/api/IDoraDiaryDetailContentView;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "observeSimulSubtitles", "Lcom/larus/avlink/api/DoraSimulSubtitleEvent;", "isTop", "observeSimulBudsState", "getSimulSubtitleHistory", "Lcom/larus/avlink/api/DoraSimulSubtitleItem;", "getSimulLanguages", "Lcom/larus/avlink/api/DoraSimulLanguage;", "restartSimulInterpretForSettingChange", "isEnvObserveSceneRunning", "getDiaryInsertPhotoEnabled", "callback", "setDiaryInsertPhotoEnabled", "enabled", "openDiaryBetaWeb", "date", "entry", "injectDatasetPacks", "items", "Lcom/larus/avlink/api/DatasetInjectItem;", "onEnqueued", "onAllProcessed", "Lkotlin/ParameterName;", "name", "endTimeMillis", "getDatasetInjectTiming", "Lcom/larus/avlink/api/DatasetInjectTiming;", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraAVLinkService extends r {
    void A0(String r100, String r101);

    void A1();

    void B0(@FlowDoraScene int r100, @FlowDoraSceneState int r101);

    Flow<e> B1();

    void C0(Function1<? super Boolean, Unit> r100);

    void C1(c0 r100);

    void D0(Context r100, Function0 r101, Function0 r102);

    void D1();

    List<Integer> E0();

    boolean E1(int r100);

    void F0();

    List<j> G0();

    Flow<i> H0();

    void I0(String r100, String r101);

    void J0(int r100);

    String K0(String r100);

    void L0(z r100);

    void M0(Context r100, boolean r101, d0 r102);

    void N0(Integer r100);

    void O0(Function1<? super Boolean, Unit> r100);

    boolean P0();

    void Q0();

    boolean R0();

    void S0(d r100);

    void T0(a0 r100);

    void U0(b0 r100);

    void V0(Context r100, List r101, s1 r102);

    void W0(f r100);

    List<l> X0(boolean r100);

    boolean Y0();

    boolean Z0();

    void a(String r100);

    void a1(String r100, long r101);

    boolean b();

    void b1(int r100, int r101);

    boolean c1(@FlowDoraScene int r100);

    boolean d();

    void d1(boolean r100);

    String e();

    void e1(int r100);

    void f(String r100);

    boolean f1(String r100);

    void g(int r100, long r101);

    void g1(a0 r100);

    String getHost();

    void h1(z r100);

    void i(boolean r100);

    boolean i1(Context r100, String r101, String r102);

    void idleInit();

    boolean isRecording();

    Object j1(Continuation r100);

    boolean k1();

    u l1(Context r100, LifecycleOwner r101);

    void m1(ODoraAlbumCardView.d r100);

    void n1(boolean r100);

    boolean o1(String r100);

    boolean p1();

    String postProcessorVersion();

    void q1(ODoraAlbumCardView.d r100);

    void r1();

    s s1(Context r100, Fragment r101);

    void t1(y r100);

    String u0();

    String u1(Integer r100);

    void v0(d r100);

    void v1(View r100, String r101);

    String videoStabilizerVersion();

    Flow<k> w0(boolean r100);

    void w1();

    void x0(Function0<Unit> r100);

    boolean x1();

    void y0(y r100);

    Integer y1(String r100);

    Flow<Boolean> z0();

    boolean z1();
}
