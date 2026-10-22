package com.larus.camera.impl.utils;

import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ttnet.org.chromium.net.NetError;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bf\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008c\u0001\u008d\u0001B\u0097\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020\n\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\b\b\u0002\u0010'\u001a\u00020\n\u0012\b\b\u0002\u0010(\u001a\u00020\n\u0012\b\b\u0002\u0010)\u001a\u00020\n\u0012\b\b\u0002\u0010*\u001a\u00020\n\u0012\b\b\u0002\u0010+\u001a\u00020\n\u0012\b\b\u0002\u0010,\u001a\u00020\n\u0012\b\b\u0002\u0010-\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020\n¢\u0006\u0004\b/\u00100J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\nHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\nHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010AJ\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010l\u001a\u00020\nHÆ\u0003J\t\u0010m\u001a\u00020\u0013HÆ\u0003J\t\u0010n\u001a\u00020\u0013HÆ\u0003J\t\u0010o\u001a\u00020\u0013HÆ\u0003J\t\u0010p\u001a\u00020\nHÆ\u0003J\t\u0010q\u001a\u00020\u0013HÆ\u0003J\t\u0010r\u001a\u00020\nHÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\u000f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\"HÆ\u0003J\t\u0010y\u001a\u00020\nHÆ\u0003J\t\u0010z\u001a\u00020\nHÆ\u0003J\t\u0010{\u001a\u00020\nHÆ\u0003J\t\u0010|\u001a\u00020\nHÆ\u0003J\t\u0010}\u001a\u00020\nHÆ\u0003J\t\u0010~\u001a\u00020\nHÆ\u0003J\t\u0010\u007f\u001a\u00020\nHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\nHÆ\u0003J²\u0003\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\nHÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0016\u0010\u0087\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001HÖ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0013HÖ\u0001J\n\u0010\u008b\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b:\u00108R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00102R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00102R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u00105R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bD\u00108R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bG\u0010FR\u0011\u0010\u0018\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bH\u0010FR\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bI\u00108R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010FR\u0011\u0010\u001b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bK\u00108R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00102R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u00105R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u00102R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00102R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00102R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010#\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bS\u00108R\u0011\u0010$\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bT\u00108R\u0011\u0010%\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bU\u00108R\u0011\u0010&\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bV\u00108R\u0011\u0010'\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bW\u00108R\u0011\u0010(\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bX\u00108R\u0011\u0010)\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bY\u00108R\u0011\u0010*\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bZ\u00108R\u0011\u0010+\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b[\u00108R\u0011\u0010,\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\\\u00108R\u0011\u0010-\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b]\u00108R\u0011\u0010.\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b^\u00108¨\u0006\u008e\u0001"}, d2 = {"Lcom/larus/camera/impl/utils/CameraData;", "Ljava/io/Serializable;", "scene", "", "captureMode", "captureModeList", "", "Lcom/larus/camera/api/params/CaptureMode;", "flashMode", "useFontCamera", "", PickerReporterConstants.KEY.TARGET, "switchTab", "eventExt", "Lcom/larus/platform/model/camera/ICameraEventExt;", "enableCaptureDetectModeList", "cameraNameUrl", "cameraName", "tipsShowOrder", "", "tips", "enableFocusFrame", "inputStyle", "albumLandingTabIndex", "addedAttachmentCount", "botSupportAlbumMultiTake", "albumMultiTakeMaxCount", "albumSupportOriginalImage", "albumInputText", "albumAttachmentUris", "albumInputSnapshotId", "albumInputSourceNodeId", "returnAlbumNodeId", "resultRoute", "Lcom/larus/camera/api/params/CameraResultRoute;", "larkScanScene", "enableCaptureTitle", "enableCaptureTips", "enableCaptureAlbum", "enableResultSuggestedAction", "enableResultMarkedTips", "mobilePreviewHostEnabled", "enableCameraAlbumQuickInput", "enableCameraAlbumUnifiedPreview", "enableCameraResultUnifiedVisual", "useUnifiedMediaCanvas", "disableCaptureDetect", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZLcom/larus/platform/model/camera/ICameraEventExt;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;ZIIIZIZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/camera/api/params/CameraResultRoute;ZZZZZZZZZZZZ)V", "getScene", "()Ljava/lang/String;", "getCaptureMode", "getCaptureModeList", "()Ljava/util/List;", "getFlashMode", "getUseFontCamera", "()Z", "getTarget", "getSwitchTab", "getEventExt", "()Lcom/larus/platform/model/camera/ICameraEventExt;", "getEnableCaptureDetectModeList", "getCameraNameUrl", "getCameraName", "getTipsShowOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTips", "getEnableFocusFrame", "getInputStyle", "()I", "getAlbumLandingTabIndex", "getAddedAttachmentCount", "getBotSupportAlbumMultiTake", "getAlbumMultiTakeMaxCount", "getAlbumSupportOriginalImage", "getAlbumInputText", "getAlbumAttachmentUris", "getAlbumInputSnapshotId", "getAlbumInputSourceNodeId", "getReturnAlbumNodeId", "getResultRoute", "()Lcom/larus/camera/api/params/CameraResultRoute;", "getLarkScanScene", "getEnableCaptureTitle", "getEnableCaptureTips", "getEnableCaptureAlbum", "getEnableResultSuggestedAction", "getEnableResultMarkedTips", "getMobilePreviewHostEnabled", "getEnableCameraAlbumQuickInput", "getEnableCameraAlbumUnifiedPreview", "getEnableCameraResultUnifiedVisual", "getUseUnifiedMediaCanvas", "getDisableCaptureDetect", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZLcom/larus/platform/model/camera/ICameraEventExt;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;ZIIIZIZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/camera/api/params/CameraResultRoute;ZZZZZZZZZZZZ)Lcom/larus/camera/impl/utils/CameraData;", "equals", "other", "", "hashCode", "toString", "Companion", "Manager", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraData implements Serializable {
    public static final a Companion = null;
    public static final String PARAM_CAMERA_DATA = "param_camera_data";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CameraData f322687a = null;
    private final int addedAttachmentCount;
    private final List<String> albumAttachmentUris;
    private final String albumInputSnapshotId;
    private final String albumInputSourceNodeId;
    private final String albumInputText;
    private final int albumLandingTabIndex;
    private final int albumMultiTakeMaxCount;
    private final boolean albumSupportOriginalImage;
    private final boolean botSupportAlbumMultiTake;
    private final String cameraName;
    private final String cameraNameUrl;
    private final String captureMode;
    private final List<CaptureMode> captureModeList;
    private final boolean disableCaptureDetect;
    private final boolean enableCameraAlbumQuickInput;
    private final boolean enableCameraAlbumUnifiedPreview;
    private final boolean enableCameraResultUnifiedVisual;
    private final boolean enableCaptureAlbum;
    private final List<String> enableCaptureDetectModeList;
    private final boolean enableCaptureTips;
    private final boolean enableCaptureTitle;
    private final boolean enableFocusFrame;
    private final boolean enableResultMarkedTips;
    private final boolean enableResultSuggestedAction;
    private final ICameraEventExt eventExt;
    private final String flashMode;
    private final int inputStyle;
    private final boolean larkScanScene;
    private final boolean mobilePreviewHostEnabled;
    private final CameraResultRoute resultRoute;
    private final String returnAlbumNodeId;
    private final String scene;
    private final boolean switchTab;
    private final String target;
    private final List<String> tips;
    private final Integer tipsShowOrder;
    private final boolean useFontCamera;
    private final boolean useUnifiedMediaCanvas;

    public static final class Manager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineScope f322688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StateFlowImpl f322689b;

        public final CameraData a() {
            return (CameraData) this.f322689b.getValue();
        }

        public Manager(LifecycleCoroutineScope r100) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            this.f322688a = r100;
            this.f322689b = j1.a(CameraData.access$getDEFAULT$cp());
        }

        public final void b(Bundle r510) {
            if (r510 != null) goto L5;
            return;
        L5:
            Serializable r100 = r510.getSerializable(CameraData.PARAM_CAMERA_DATA);
            if ((r100 instanceof CameraData) == false) goto L8;
            CameraData r101 = (CameraData) r100;
        L10:
            if (r101 == null) goto L13;
            FLogger.f375446a.i("CameraData", "[init] from PARAM_CAMERA_DATA: scene=" + r101.getScene() + ", enableResultSuggestedAction=" + r101.getEnableResultSuggestedAction() + ", enableCaptureDetectModeList=" + r101.getEnableCaptureDetectModeList() + ", captureMode=" + r101.getCaptureMode());
            c(r101);
            return;
        L13:
            Serializable r102 = r510.getSerializable("CAMERA_INPUT_PARAM");
            if ((r102 instanceof InputParam) == false) goto L16;
            InputParam r103 = (InputParam) r102;
        L17:
            if (r103 != null) goto L19;
            return;
        L19:
            InputParamExtra r104 = r103.getExtra();
            if (r104 == null) goto L24;
            String r105 = (String) r104.get("ENABLE_CAPTURE_TITLE");
            if (r105 == null) goto L24;
            boolean r310 = Boolean.parseBoolean(r105);
        L25:
            if (r104 == null) goto L29;
            String r106 = (String) r104.get("ENABLE_CAPTURE_TIPS");
            if (r106 == null) goto L29;
            boolean r311 = Boolean.parseBoolean(r106);
        L30:
            if (r104 == null) goto L34;
            String r107 = (String) r104.get("ENABLE_RESULT_SUGGESTED_ACTION");
            if (r107 == null) goto L34;
            boolean r410 = Boolean.parseBoolean(r107);
        L35:
            if (r104 == null) goto L39;
            String r108 = (String) r104.get("ENABLE_RESULT_MARKED_TIPS");
            if (r108 == null) goto L39;
            boolean r411 = Boolean.parseBoolean(r108);
        L40:
            if (r104 == null) goto L46;
            String r110 = (String) r104.get("ENABLE_CAMERA_ALBUM_QUICK_INPUT");
            if (r110 == null) goto L46;
            if (Boolean.parseBoolean(r110) != true) goto L46;
            boolean r412 = true;
        L47:
            if (r104 == null) goto L53;
            String r111 = (String) r104.get("ENABLE_CAMERA_ALBUM_UNIFIED_PREVIEW");
            if (r111 == null) goto L53;
            if (Boolean.parseBoolean(r111) != true) goto L53;
            boolean r413 = true;
        L54:
            if (r104 == null) goto L60;
            String r112 = (String) r104.get("ENABLE_CAMERA_RESULT_UNIFIED_VISUAL");
            if (r112 == null) goto L60;
            if (Boolean.parseBoolean(r112) != true) goto L60;
            boolean r414 = true;
        L61:
            String r113 = r103.getScene();
            String r114 = r103.getCaptureMode();
            List<CaptureMode> r115 = r103.getCaptureModeList();
            String r116 = r103.getFlashMode();
            boolean r117 = r103.isFrontCamera();
            String r118 = r103.getTarget();
            ICameraEventExt r119 = r103.getEventExt();
            List<String> r120 = r103.getEnableCaptureDetectModeList();
            if (r120 != null) goto L64;
            r120 = CollectionsKt.emptyList();
        L64:
            List<String> r210 = r120;
            String r211 = r103.getCameraNameUrl();
            String r212 = r103.getCameraName();
            Integer r213 = r103.getTipsShowOrder();
            List<String> r214 = r103.getTips();
            boolean r215 = r103.getEnableFocusFrame();
            int r216 = r103.getInputStyle();
            Integer r121 = r103.getAlbumLandingTabIndex();
            if (r121 == null) goto L67;
            int r217 = r121.intValue();
        L68:
            Integer r122 = r103.getAddedAttachmentCount();
            if (r122 == null) goto L71;
            int r218 = r122.intValue();
        L72:
            boolean r219 = r103.getSupportAlbumMultiTake();
            int r312 = r103.getAlbumMultiTakeMaxCount();
            boolean r313 = r103.getAlbumSupportOriginalImage();
            String r314 = r103.getAlbumInputText();
            List<String> r315 = r103.getAlbumAttachmentUris();
            InputParamExtra r123 = r103.getExtra();
            if (r123 == null) goto L75;
            String r109 = (String) r123.get("ALBUM_INPUT_SNAPSHOT_ID");
        L76:
            InputParamExtra r124 = r103.getExtra();
            if (r124 == null) goto L79;
            String r125 = (String) r124.get("ALBUM_INPUT_SOURCE_NODE_ID");
        L81:
            if (r125 != null) goto L83;
            String r316 = "";
        L84:
            InputParamExtra r126 = r103.getExtra();
            if (r126 == null) goto L87;
            String r127 = (String) r126.get("CAMERA_RETURN_ALBUM_NODE_ID");
        L88:
            if (r127 != null) goto L90;
            String r128 = "";
        L91:
            CameraResultRoute r317 = r103.getResultRoute();
            boolean r318 = r103.getLarkScanScene();
            boolean r415 = r103.getEnableCaptureAlbum();
            if (r104 == null) goto L98;
            String r129 = (String) r104.get("MOBILE_PREVIEW_HOST_ENABLED");
            if (r129 == null) goto L98;
            if (Boolean.parseBoolean(r129) != true) goto L98;
            boolean r416 = true;
        L99:
            if (r104 == null) goto L105;
            String r130 = (String) r104.get("USE_UNIFIED_MEDIA_CANVAS");
            if (r130 == null) goto L105;
            Boolean r131 = StringsKt.toBooleanStrictOrNull(r130);
            if (r131 == null) goto L105;
            boolean r132 = r131.booleanValue();
        L106:
            CameraData r133 = new CameraData(r113, r114, r115, r116, r117, r118, false, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r312, r313, r314, r315, r109, r316, r128, r317, r318, r310, r311, r415, r410, r411, r416, r412, r413, r414, r132, r103.getDisableCaptureDetect());
            FLogger.f375446a.i("CameraData", "[init] from InputParam: scene=" + r133.getScene() + ", enableResultSuggestedAction=" + r133.getEnableResultSuggestedAction() + ", enableCaptureDetectModeList=" + r133.getEnableCaptureDetectModeList() + ", captureMode=" + r133.getCaptureMode());
            c(r133);
            return;
        L105:
            r132 = z2.f365865a.getNewPreviewConfig().f365580c.f365581a;
        L98:
            r416 = false;
            goto L99
        L90:
            r128 = r127;
            goto L91
        L87:
            r127 = null;
            goto L88
        L83:
            r316 = r125;
            goto L84
        L79:
            r125 = null;
            goto L81
        L75:
            r109 = null;
            goto L76
        L71:
            r218 = 0;
            goto L72
        L67:
            r217 = 0;
        L60:
            r414 = false;
        L53:
            r413 = false;
        L46:
            r412 = false;
        L39:
            r411 = true;
        L34:
            r410 = true;
        L29:
            r311 = true;
        L24:
            r310 = true;
            goto L25
        L16:
            r103 = null;
            goto L17
        L8:
            r101 = null;
            goto L10
        }

        public final Job c(CameraData r100) {
            return BuildersKt.launch$default(this.f322688a, null, null, new CameraData$Manager$innerUpdate$1(this, r100, null), 3, null);
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraData copy$default(CameraData r110, String r111, String r112, List r210, String r211, boolean r212, String r213, boolean r214, ICameraEventExt r215, List r216, String r217, String r218, Integer r219, List r310, boolean r311, int r312, int r313, int r314, boolean r315, int r316, boolean r317, String r318, List r319, String r410, String r411, String r412, CameraResultRoute r413, boolean r414, boolean r415, boolean r416, boolean r417, boolean r418, boolean r419, boolean r510, boolean r511, boolean r512, boolean r513, boolean r514, boolean r515, int r516, int r517, Object r518) {
        if ((r516 & 1) == 0) goto L5;
        String r100 = r110.scene;
    L7:
        if ((r516 & 2) == 0) goto L9;
        String r101 = r110.captureMode;
    L11:
        if ((r516 & 4) == 0) goto L13;
        List r102 = r110.captureModeList;
    L15:
        if ((r516 & 8) == 0) goto L17;
        String r103 = r110.flashMode;
    L19:
        if ((r516 & 16) == 0) goto L21;
        boolean r104 = r110.useFontCamera;
    L23:
        if ((r516 & 32) == 0) goto L25;
        String r105 = r110.target;
    L27:
        if ((r516 & 64) == 0) goto L29;
        boolean r106 = r110.switchTab;
    L31:
        if ((r516 & 128) == 0) goto L33;
        ICameraEventExt r107 = r110.eventExt;
    L35:
        if ((r516 & 256) == 0) goto L37;
        List r113 = r110.enableCaptureDetectModeList;
    L39:
        if ((r516 & 512) == 0) goto L41;
        String r114 = r110.cameraNameUrl;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        String r115 = r110.cameraName;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        Integer r116 = r110.tipsShowOrder;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        List r117 = r110.tips;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        boolean r118 = r110.enableFocusFrame;
    L58:
        boolean r320 = r118;
        if ((r516 & 16384) == 0) goto L61;
        int r119 = r110.inputStyle;
    L62:
        int r321 = r119;
        if ((r516 & 32768) == 0) goto L65;
        int r120 = r110.albumLandingTabIndex;
    L66:
        int r322 = r120;
        if ((r516 & 65536) == 0) goto L69;
        int r121 = r110.addedAttachmentCount;
    L70:
        int r323 = r121;
        if ((r516 & 131072) == 0) goto L73;
        boolean r122 = r110.botSupportAlbumMultiTake;
    L74:
        boolean r324 = r122;
        if ((r516 & 262144) == 0) goto L77;
        int r123 = r110.albumMultiTakeMaxCount;
    L78:
        int r325 = r123;
        if ((r516 & 524288) == 0) goto L81;
        boolean r124 = r110.albumSupportOriginalImage;
    L82:
        boolean r326 = r124;
        if ((r516 & 1048576) == 0) goto L85;
        String r125 = r110.albumInputText;
    L86:
        String r327 = r125;
        if ((r516 & 2097152) == 0) goto L89;
        List r126 = r110.albumAttachmentUris;
    L90:
        List r328 = r126;
        if ((r516 & 4194304) == 0) goto L93;
        String r127 = r110.albumInputSnapshotId;
    L94:
        String r420 = r127;
        if ((r516 & 8388608) == 0) goto L97;
        String r128 = r110.albumInputSourceNodeId;
    L98:
        String r421 = r128;
        if ((r516 & 16777216) == 0) goto L101;
        String r129 = r110.returnAlbumNodeId;
    L102:
        String r422 = r129;
        if ((r516 & 33554432) == 0) goto L105;
        CameraResultRoute r130 = r110.resultRoute;
    L106:
        CameraResultRoute r423 = r130;
        if ((r516 & 67108864) == 0) goto L109;
        boolean r131 = r110.larkScanScene;
    L110:
        boolean r424 = r131;
        if ((r516 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        boolean r132 = r110.enableCaptureTitle;
    L114:
        boolean r425 = r132;
        if ((r516 & 268435456) == 0) goto L117;
        boolean r133 = r110.enableCaptureTips;
    L118:
        boolean r426 = r133;
        if ((r516 & 536870912) == 0) goto L121;
        boolean r134 = r110.enableCaptureAlbum;
    L122:
        boolean r427 = r134;
        if ((r516 & 1073741824) == 0) goto L125;
        boolean r135 = r110.enableResultSuggestedAction;
    L127:
        if ((r516 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r108 = r110.enableResultMarkedTips;
    L130:
        boolean r428 = r108;
        if ((r517 & 1) == 0) goto L133;
        boolean r109 = r110.mobilePreviewHostEnabled;
    L134:
        boolean r519 = r109;
        if ((r517 & 2) == 0) goto L137;
        boolean r136 = r110.enableCameraAlbumQuickInput;
    L138:
        boolean r520 = r136;
        if ((r517 & 4) == 0) goto L141;
        boolean r137 = r110.enableCameraAlbumUnifiedPreview;
    L142:
        boolean r521 = r137;
        if ((r517 & 8) == 0) goto L145;
        boolean r138 = r110.enableCameraResultUnifiedVisual;
    L146:
        boolean r522 = r138;
        if ((r517 & 16) == 0) goto L149;
        boolean r139 = r110.useUnifiedMediaCanvas;
    L150:
        boolean r523 = r139;
        if ((r517 & 32) == 0) goto L153;
        boolean r140 = r110.disableCaptureDetect;
    L155:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r428, r519, r520, r521, r522, r523, r140);
    L153:
        r140 = r515;
        goto L155
    L149:
        r139 = r514;
        goto L150
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r136 = r511;
        goto L138
    L133:
        r109 = r510;
        goto L134
    L129:
        r108 = r419;
        goto L130
    L125:
        r135 = r418;
        goto L127
    L121:
        r134 = r417;
        goto L122
    L117:
        r133 = r416;
        goto L118
    L113:
        r132 = r415;
        goto L114
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.scene;
    }

    public final String component10() {
        return this.cameraNameUrl;
    }

    public final String component11() {
        return this.cameraName;
    }

    public final Integer component12() {
        return this.tipsShowOrder;
    }

    public final List<String> component13() {
        return this.tips;
    }

    public final boolean component14() {
        return this.enableFocusFrame;
    }

    public final int component15() {
        return this.inputStyle;
    }

    public final int component16() {
        return this.albumLandingTabIndex;
    }

    public final int component17() {
        return this.addedAttachmentCount;
    }

    public final boolean component18() {
        return this.botSupportAlbumMultiTake;
    }

    public final int component19() {
        return this.albumMultiTakeMaxCount;
    }

    public final String component2() {
        return this.captureMode;
    }

    public final boolean component20() {
        return this.albumSupportOriginalImage;
    }

    public final String component21() {
        return this.albumInputText;
    }

    public final List<String> component22() {
        return this.albumAttachmentUris;
    }

    public final String component23() {
        return this.albumInputSnapshotId;
    }

    public final String component24() {
        return this.albumInputSourceNodeId;
    }

    public final String component25() {
        return this.returnAlbumNodeId;
    }

    public final CameraResultRoute component26() {
        return this.resultRoute;
    }

    public final boolean component27() {
        return this.larkScanScene;
    }

    public final boolean component28() {
        return this.enableCaptureTitle;
    }

    public final boolean component29() {
        return this.enableCaptureTips;
    }

    public final List<CaptureMode> component3() {
        return this.captureModeList;
    }

    public final boolean component30() {
        return this.enableCaptureAlbum;
    }

    public final boolean component31() {
        return this.enableResultSuggestedAction;
    }

    public final boolean component32() {
        return this.enableResultMarkedTips;
    }

    public final boolean component33() {
        return this.mobilePreviewHostEnabled;
    }

    public final boolean component34() {
        return this.enableCameraAlbumQuickInput;
    }

    public final boolean component35() {
        return this.enableCameraAlbumUnifiedPreview;
    }

    public final boolean component36() {
        return this.enableCameraResultUnifiedVisual;
    }

    public final boolean component37() {
        return this.useUnifiedMediaCanvas;
    }

    public final boolean component38() {
        return this.disableCaptureDetect;
    }

    public final String component4() {
        return this.flashMode;
    }

    public final boolean component5() {
        return this.useFontCamera;
    }

    public final String component6() {
        return this.target;
    }

    public final boolean component7() {
        return this.switchTab;
    }

    public final ICameraEventExt component8() {
        return this.eventExt;
    }

    public final List<String> component9() {
        return this.enableCaptureDetectModeList;
    }

    public final CameraData copy(String r410, String r411, List<CaptureMode> r412, String r413, boolean r414, String r415, boolean r416, ICameraEventExt r417, List<String> r510, String r511, String r512, Integer r513, List<String> r514, boolean r515, int r516, int r517, int r518, boolean r519, int r610, boolean r611, String r612, List<String> r613, String r614, String r615, String r616, CameraResultRoute r617, boolean r618, boolean r619, boolean r710, boolean r711, boolean r712, boolean r713, boolean r714, boolean r715, boolean r716, boolean r717, boolean r718, boolean r719) {
        Intrinsics.checkNotNullParameter(r410, "scene");
        Intrinsics.checkNotNullParameter(r411, "captureMode");
        Intrinsics.checkNotNullParameter(r412, "captureModeList");
        Intrinsics.checkNotNullParameter(r413, "flashMode");
        Intrinsics.checkNotNullParameter(r415, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r510, "enableCaptureDetectModeList");
        Intrinsics.checkNotNullParameter(r612, "albumInputText");
        Intrinsics.checkNotNullParameter(r613, "albumAttachmentUris");
        Intrinsics.checkNotNullParameter(r615, "albumInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r616, "returnAlbumNodeId");
        return new CameraData(r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraData) == true) goto L8;
        return false;
    L8:
        CameraData r101 = (CameraData) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.captureMode, r101.captureMode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.captureModeList, r101.captureModeList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.flashMode, r101.flashMode) == true) goto L21;
        return false;
    L21:
        if (this.useFontCamera == r101.useFontCamera) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L27;
        return false;
    L27:
        if (this.switchTab == r101.switchTab) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.eventExt, r101.eventExt) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.enableCaptureDetectModeList, r101.enableCaptureDetectModeList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.cameraNameUrl, r101.cameraNameUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.cameraName, r101.cameraName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tipsShowOrder, r101.tipsShowOrder) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L48;
        return false;
    L48:
        if (this.enableFocusFrame == r101.enableFocusFrame) goto L51;
        return false;
    L51:
        if (this.inputStyle == r101.inputStyle) goto L54;
        return false;
    L54:
        if (this.albumLandingTabIndex == r101.albumLandingTabIndex) goto L57;
        return false;
    L57:
        if (this.addedAttachmentCount == r101.addedAttachmentCount) goto L60;
        return false;
    L60:
        if (this.botSupportAlbumMultiTake == r101.botSupportAlbumMultiTake) goto L63;
        return false;
    L63:
        if (this.albumMultiTakeMaxCount == r101.albumMultiTakeMaxCount) goto L66;
        return false;
    L66:
        if (this.albumSupportOriginalImage == r101.albumSupportOriginalImage) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.albumInputText, r101.albumInputText) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.albumAttachmentUris, r101.albumAttachmentUris) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.albumInputSnapshotId, r101.albumInputSnapshotId) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.albumInputSourceNodeId, r101.albumInputSourceNodeId) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.returnAlbumNodeId, r101.returnAlbumNodeId) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.resultRoute, r101.resultRoute) == true) goto L87;
        return false;
    L87:
        if (this.larkScanScene == r101.larkScanScene) goto L90;
        return false;
    L90:
        if (this.enableCaptureTitle == r101.enableCaptureTitle) goto L93;
        return false;
    L93:
        if (this.enableCaptureTips == r101.enableCaptureTips) goto L96;
        return false;
    L96:
        if (this.enableCaptureAlbum == r101.enableCaptureAlbum) goto L99;
        return false;
    L99:
        if (this.enableResultSuggestedAction == r101.enableResultSuggestedAction) goto L102;
        return false;
    L102:
        if (this.enableResultMarkedTips == r101.enableResultMarkedTips) goto L105;
        return false;
    L105:
        if (this.mobilePreviewHostEnabled == r101.mobilePreviewHostEnabled) goto L108;
        return false;
    L108:
        if (this.enableCameraAlbumQuickInput == r101.enableCameraAlbumQuickInput) goto L111;
        return false;
    L111:
        if (this.enableCameraAlbumUnifiedPreview == r101.enableCameraAlbumUnifiedPreview) goto L114;
        return false;
    L114:
        if (this.enableCameraResultUnifiedVisual == r101.enableCameraResultUnifiedVisual) goto L117;
        return false;
    L117:
        if (this.useUnifiedMediaCanvas == r101.useUnifiedMediaCanvas) goto L120;
        return false;
    L120:
        if (this.disableCaptureDetect == r101.disableCaptureDetect) goto L122;
        return false;
    L122:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.scene.hashCode() * 31) + this.captureMode.hashCode()) * 31) + this.captureModeList.hashCode()) * 31) + this.flashMode.hashCode()) * 31;
        int r101 = 1231;
        if (this.useFontCamera == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.target.hashCode()) * 31;
        if (this.switchTab == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        ICameraEventExt r106 = this.eventExt;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r105 + r108) * 31) + this.enableCaptureDetectModeList.hashCode()) * 31;
        String r110 = this.cameraNameUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cameraName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.tipsShowOrder;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.tips;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        if (this.enableFocusFrame == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (((((((r121 + r122) * 31) + this.inputStyle) * 31) + this.albumLandingTabIndex) * 31) + this.addedAttachmentCount) * 31;
        if (this.botSupportAlbumMultiTake == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (((r123 + r124) * 31) + this.albumMultiTakeMaxCount) * 31;
        if (this.albumSupportOriginalImage == false) goto L41;
        int r126 = 1231;
    L42:
        int r127 = (((((r125 + r126) * 31) + this.albumInputText.hashCode()) * 31) + this.albumAttachmentUris.hashCode()) * 31;
        String r128 = this.albumInputSnapshotId;
        if (r128 != null) goto L45;
        int r129 = 0;
    L46:
        int r130 = (((((r127 + r129) * 31) + this.albumInputSourceNodeId.hashCode()) * 31) + this.returnAlbumNodeId.hashCode()) * 31;
        CameraResultRoute r131 = this.resultRoute;
        if (r131 == null) goto L50;
        r107 = r131.hashCode();
    L50:
        int r132 = (r130 + r107) * 31;
        if (this.larkScanScene == false) goto L53;
        int r133 = 1231;
    L54:
        int r134 = (r132 + r133) * 31;
        if (this.enableCaptureTitle == false) goto L57;
        int r135 = 1231;
    L58:
        int r136 = (r134 + r135) * 31;
        if (this.enableCaptureTips == false) goto L61;
        int r137 = 1231;
    L62:
        int r138 = (r136 + r137) * 31;
        if (this.enableCaptureAlbum == false) goto L65;
        int r139 = 1231;
    L66:
        int r140 = (r138 + r139) * 31;
        if (this.enableResultSuggestedAction == false) goto L69;
        int r141 = 1231;
    L70:
        int r142 = (r140 + r141) * 31;
        if (this.enableResultMarkedTips == false) goto L73;
        int r143 = 1231;
    L74:
        int r144 = (r142 + r143) * 31;
        if (this.mobilePreviewHostEnabled == false) goto L77;
        int r145 = 1231;
    L78:
        int r146 = (r144 + r145) * 31;
        if (this.enableCameraAlbumQuickInput == false) goto L81;
        int r147 = 1231;
    L82:
        int r148 = (r146 + r147) * 31;
        if (this.enableCameraAlbumUnifiedPreview == false) goto L85;
        int r149 = 1231;
    L86:
        int r150 = (r148 + r149) * 31;
        if (this.enableCameraResultUnifiedVisual == false) goto L89;
        int r151 = 1231;
    L90:
        int r152 = (r150 + r151) * 31;
        if (this.useUnifiedMediaCanvas == false) goto L93;
        int r153 = 1231;
    L94:
        int r154 = (r152 + r153) * 31;
        if (this.disableCaptureDetect == true) goto L99;
        r101 = 1237;
    L99:
        return r154 + r101;
    L93:
        r153 = 1237;
        goto L94
    L89:
        r151 = 1237;
        goto L90
    L85:
        r149 = 1237;
        goto L86
    L81:
        r147 = 1237;
        goto L82
    L77:
        r145 = 1237;
        goto L78
    L73:
        r143 = 1237;
        goto L74
    L69:
        r141 = 1237;
        goto L70
    L65:
        r139 = 1237;
        goto L66
    L61:
        r137 = 1237;
        goto L62
    L57:
        r135 = 1237;
        goto L58
    L53:
        r133 = 1237;
        goto L54
    L45:
        r129 = r128.hashCode();
        goto L46
    L41:
        r126 = 1237;
        goto L42
    L37:
        r124 = 1237;
        goto L38
    L33:
        r122 = 1237;
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "CameraData(scene=" + this.scene + ", captureMode=" + this.captureMode + ", captureModeList=" + this.captureModeList + ", flashMode=" + this.flashMode + ", useFontCamera=" + this.useFontCamera + ", target=" + this.target + ", switchTab=" + this.switchTab + ", eventExt=" + this.eventExt + ", enableCaptureDetectModeList=" + this.enableCaptureDetectModeList + ", cameraNameUrl=" + this.cameraNameUrl + ", cameraName=" + this.cameraName + ", tipsShowOrder=" + this.tipsShowOrder + ", tips=" + this.tips + ", enableFocusFrame=" + this.enableFocusFrame + ", inputStyle=" + this.inputStyle + ", albumLandingTabIndex=" + this.albumLandingTabIndex + ", addedAttachmentCount=" + this.addedAttachmentCount + ", botSupportAlbumMultiTake=" + this.botSupportAlbumMultiTake + ", albumMultiTakeMaxCount=" + this.albumMultiTakeMaxCount + ", albumSupportOriginalImage=" + this.albumSupportOriginalImage + ", albumInputText=" + this.albumInputText + ", albumAttachmentUris=" + this.albumAttachmentUris + ", albumInputSnapshotId=" + this.albumInputSnapshotId + ", albumInputSourceNodeId=" + this.albumInputSourceNodeId + ", returnAlbumNodeId=" + this.returnAlbumNodeId + ", resultRoute=" + this.resultRoute + ", larkScanScene=" + this.larkScanScene + ", enableCaptureTitle=" + this.enableCaptureTitle + ", enableCaptureTips=" + this.enableCaptureTips + ", enableCaptureAlbum=" + this.enableCaptureAlbum + ", enableResultSuggestedAction=" + this.enableResultSuggestedAction + ", enableResultMarkedTips=" + this.enableResultMarkedTips + ", mobilePreviewHostEnabled=" + this.mobilePreviewHostEnabled + ", enableCameraAlbumQuickInput=" + this.enableCameraAlbumQuickInput + ", enableCameraAlbumUnifiedPreview=" + this.enableCameraAlbumUnifiedPreview + ", enableCameraResultUnifiedVisual=" + this.enableCameraResultUnifiedVisual + ", useUnifiedMediaCanvas=" + this.useUnifiedMediaCanvas + ", disableCaptureDetect=" + this.disableCaptureDetect + ')';
    }

    static {
        Companion = new a();
        f322687a = new CameraData("default", "", CollectionsKt.emptyList(), "", false, "", false, null, CollectionsKt.emptyList(), null, null, null, null, false, 0, 0, 0, false, 0, false, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, NetError.ERR_TTNET_FT_INVALID_CONNECTION, 63, null);
    }

    public static final /* synthetic */ CameraData access$getDEFAULT$cp() {
        return f322687a;
    }

    public final int getAddedAttachmentCount() {
        return this.addedAttachmentCount;
    }

    public final List<String> getAlbumAttachmentUris() {
        return this.albumAttachmentUris;
    }

    public final String getAlbumInputSnapshotId() {
        return this.albumInputSnapshotId;
    }

    public final String getAlbumInputSourceNodeId() {
        return this.albumInputSourceNodeId;
    }

    public final String getAlbumInputText() {
        return this.albumInputText;
    }

    public final int getAlbumLandingTabIndex() {
        return this.albumLandingTabIndex;
    }

    public final int getAlbumMultiTakeMaxCount() {
        return this.albumMultiTakeMaxCount;
    }

    public final boolean getAlbumSupportOriginalImage() {
        return this.albumSupportOriginalImage;
    }

    public final boolean getBotSupportAlbumMultiTake() {
        return this.botSupportAlbumMultiTake;
    }

    public final String getCameraName() {
        return this.cameraName;
    }

    public final String getCameraNameUrl() {
        return this.cameraNameUrl;
    }

    public final String getCaptureMode() {
        return this.captureMode;
    }

    public final List<CaptureMode> getCaptureModeList() {
        return this.captureModeList;
    }

    public final boolean getDisableCaptureDetect() {
        return this.disableCaptureDetect;
    }

    public final boolean getEnableCameraAlbumQuickInput() {
        return this.enableCameraAlbumQuickInput;
    }

    public final boolean getEnableCameraAlbumUnifiedPreview() {
        return this.enableCameraAlbumUnifiedPreview;
    }

    public final boolean getEnableCameraResultUnifiedVisual() {
        return this.enableCameraResultUnifiedVisual;
    }

    public final boolean getEnableCaptureAlbum() {
        return this.enableCaptureAlbum;
    }

    public final List<String> getEnableCaptureDetectModeList() {
        return this.enableCaptureDetectModeList;
    }

    public final boolean getEnableCaptureTips() {
        return this.enableCaptureTips;
    }

    public final boolean getEnableCaptureTitle() {
        return this.enableCaptureTitle;
    }

    public final boolean getEnableFocusFrame() {
        return this.enableFocusFrame;
    }

    public final boolean getEnableResultMarkedTips() {
        return this.enableResultMarkedTips;
    }

    public final boolean getEnableResultSuggestedAction() {
        return this.enableResultSuggestedAction;
    }

    public final ICameraEventExt getEventExt() {
        return this.eventExt;
    }

    public final String getFlashMode() {
        return this.flashMode;
    }

    public final int getInputStyle() {
        return this.inputStyle;
    }

    public final boolean getLarkScanScene() {
        return this.larkScanScene;
    }

    public final boolean getMobilePreviewHostEnabled() {
        return this.mobilePreviewHostEnabled;
    }

    public final CameraResultRoute getResultRoute() {
        return this.resultRoute;
    }

    public final String getReturnAlbumNodeId() {
        return this.returnAlbumNodeId;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean getSwitchTab() {
        return this.switchTab;
    }

    public final String getTarget() {
        return this.target;
    }

    public final List<String> getTips() {
        return this.tips;
    }

    public final Integer getTipsShowOrder() {
        return this.tipsShowOrder;
    }

    public final boolean getUseFontCamera() {
        return this.useFontCamera;
    }

    public final boolean getUseUnifiedMediaCanvas() {
        return this.useUnifiedMediaCanvas;
    }

    public CameraData(String r110, String r111, List<CaptureMode> r112, String r113, boolean r114, String r115, boolean r116, ICameraEventExt r210, List<String> r211, String r212, String r213, Integer r214, List<String> r215, boolean r216, int r217, int r218, int r219, boolean r310, int r311, boolean r312, String r313, List<String> r314, String r315, String r316, String r317, CameraResultRoute r318, boolean r319, boolean r410, boolean r411, boolean r412, boolean r413, boolean r414, boolean r415, boolean r416, boolean r417, boolean r418, boolean r419, boolean r510) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        Intrinsics.checkNotNullParameter(r112, "captureModeList");
        Intrinsics.checkNotNullParameter(r113, "flashMode");
        Intrinsics.checkNotNullParameter(r115, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r211, "enableCaptureDetectModeList");
        Intrinsics.checkNotNullParameter(r313, "albumInputText");
        Intrinsics.checkNotNullParameter(r314, "albumAttachmentUris");
        Intrinsics.checkNotNullParameter(r316, "albumInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r317, "returnAlbumNodeId");
        this.scene = r110;
        this.captureMode = r111;
        this.captureModeList = r112;
        this.flashMode = r113;
        this.useFontCamera = r114;
        this.target = r115;
        this.switchTab = r116;
        this.eventExt = r210;
        this.enableCaptureDetectModeList = r211;
        this.cameraNameUrl = r212;
        this.cameraName = r213;
        this.tipsShowOrder = r214;
        this.tips = r215;
        this.enableFocusFrame = r216;
        this.inputStyle = r217;
        this.albumLandingTabIndex = r218;
        this.addedAttachmentCount = r219;
        this.botSupportAlbumMultiTake = r310;
        this.albumMultiTakeMaxCount = r311;
        this.albumSupportOriginalImage = r312;
        this.albumInputText = r313;
        this.albumAttachmentUris = r314;
        this.albumInputSnapshotId = r315;
        this.albumInputSourceNodeId = r316;
        this.returnAlbumNodeId = r317;
        this.resultRoute = r318;
        this.larkScanScene = r319;
        this.enableCaptureTitle = r410;
        this.enableCaptureTips = r411;
        this.enableCaptureAlbum = r412;
        this.enableResultSuggestedAction = r413;
        this.enableResultMarkedTips = r414;
        this.mobilePreviewHostEnabled = r415;
        this.enableCameraAlbumQuickInput = r416;
        this.enableCameraAlbumUnifiedPreview = r417;
        this.enableCameraResultUnifiedVisual = r418;
        this.useUnifiedMediaCanvas = r419;
        this.disableCaptureDetect = r510;
    }

    public /* synthetic */ CameraData(String r410, String r411, List r412, String r413, boolean r414, String r415, boolean r416, ICameraEventExt r510, List r511, String r512, String r513, Integer r514, List r515, boolean r516, int r517, int r518, int r519, boolean r610, int r611, boolean r612, String r613, List r614, String r615, String r616, String r617, CameraResultRoute r618, boolean r619, boolean r710, boolean r711, boolean r712, boolean r713, boolean r714, boolean r715, boolean r716, boolean r717, boolean r718, boolean r719, boolean r810, int r811, int r812, DefaultConstructorMarker r813) {
        if ((r811 & 512) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r811 & 1024) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r811 & 2048) == 0) goto L13;
        Integer r112 = null;
    L15:
        if ((r811 & 4096) == 0) goto L17;
        List r113 = null;
    L19:
        if ((r811 & 8192) == 0) goto L21;
        boolean r114 = false;
    L23:
        if ((r811 & 16384) == 0) goto L25;
        int r115 = 0;
    L27:
        if ((32768 & r811) == 0) goto L29;
        int r116 = 0;
    L31:
        if ((65536 & r811) == 0) goto L33;
        int r210 = 0;
    L35:
        if ((131072 & r811) == 0) goto L37;
        boolean r211 = false;
    L39:
        if ((262144 & r811) == 0) goto L41;
        int r212 = 0;
    L43:
        if ((524288 & r811) == 0) goto L45;
        boolean r213 = false;
    L47:
        if ((1048576 & r811) == 0) goto L49;
        String r214 = "";
    L51:
        if ((2097152 & r811) == 0) goto L53;
        List r215 = CollectionsKt.emptyList();
    L55:
        if ((4194304 & r811) == 0) goto L57;
        String r216 = null;
    L59:
        if ((8388608 & r811) == 0) goto L61;
        String r217 = "";
    L63:
        if ((16777216 & r811) == 0) goto L65;
        String r218 = "";
    L67:
        if ((33554432 & r811) == 0) goto L69;
        CameraResultRoute r219 = null;
    L71:
        if ((67108864 & r811) == 0) goto L73;
        boolean r310 = false;
    L75:
        if ((134217728 & r811) == 0) goto L77;
        boolean r311 = true;
    L79:
        if ((268435456 & r811) == 0) goto L81;
        boolean r312 = true;
    L83:
        if ((536870912 & r811) == 0) goto L85;
        boolean r313 = true;
    L87:
        if ((1073741824 & r811) == 0) goto L89;
        boolean r314 = true;
    L91:
        if ((r811 & Integer.MIN_VALUE) == 0) goto L93;
        boolean r315 = true;
    L95:
        if ((r812 & 1) == 0) goto L97;
        boolean r316 = false;
    L99:
        if ((r812 & 2) == 0) goto L101;
        boolean r317 = false;
    L103:
        if ((r812 & 4) == 0) goto L105;
        boolean r318 = false;
    L107:
        if ((r812 & 8) == 0) goto L109;
        boolean r319 = false;
    L111:
        if ((r812 & 16) == 0) goto L113;
        boolean r417 = false;
    L115:
        if ((r812 & 32) == 0) goto L117;
        boolean r418 = false;
    L118:
        this(r410, r411, r412, r413, r414, r415, r416, r510, r511, r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r417, r418);
        return;
    L117:
        r418 = r810;
        goto L118
    L113:
        r417 = r719;
        goto L115
    L109:
        r319 = r718;
        goto L111
    L105:
        r318 = r717;
        goto L107
    L101:
        r317 = r716;
        goto L103
    L97:
        r316 = r715;
        goto L99
    L93:
        r315 = r714;
        goto L95
    L89:
        r314 = r713;
        goto L91
    L85:
        r313 = r712;
        goto L87
    L81:
        r312 = r711;
        goto L83
    L77:
        r311 = r710;
        goto L79
    L73:
        r310 = r619;
        goto L75
    L69:
        r219 = r618;
        goto L71
    L65:
        r218 = r617;
        goto L67
    L61:
        r217 = r616;
        goto L63
    L57:
        r216 = r615;
        goto L59
    L53:
        r215 = r614;
        goto L55
    L49:
        r214 = r613;
        goto L51
    L45:
        r213 = r612;
        goto L47
    L41:
        r212 = r611;
        goto L43
    L37:
        r211 = r610;
        goto L39
    L33:
        r210 = r519;
        goto L35
    L29:
        r116 = r518;
        goto L31
    L25:
        r115 = r517;
        goto L27
    L21:
        r114 = r516;
        goto L23
    L17:
        r113 = r515;
        goto L19
    L13:
        r112 = r514;
        goto L15
    L9:
        r111 = r513;
        goto L11
    L5:
        r110 = r512;
        goto L7
    }
}
