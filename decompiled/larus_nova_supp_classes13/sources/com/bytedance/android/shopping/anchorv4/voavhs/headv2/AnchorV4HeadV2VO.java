package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0083\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0003\u0012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001c\u0012\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e\u0012\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010:\u001a\u00020#\u0012\b\b\u0002\u0010;\u001a\u00020#\u0012\b\b\u0002\u0010<\u001a\u00020#\u0012\b\b\u0002\u0010=\u001a\u00020#\u0012\b\b\u0002\u0010>\u001a\u00020\u0006\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010#\u0012\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001e¢\u0006\u0004\bt\u0010uJ\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006J#\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001eHÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001eHÆ\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\"J\t\u0010$\u001a\u00020#HÆ\u0003J\t\u0010%\u001a\u00020#HÆ\u0003J\t\u0010&\u001a\u00020#HÆ\u0003J\t\u0010'\u001a\u00020#HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J\u0012\u0010-\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b/\u0010.J\u0017\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001eHÆ\u0003J\u008c\u0002\u0010D\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\u00062\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00032\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001c2\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010:\u001a\u00020#2\b\b\u0002\u0010;\u001a\u00020#2\b\b\u0002\u0010<\u001a\u00020#2\b\b\u0002\u0010=\u001a\u00020#2\b\b\u0002\u0010>\u001a\u00020\u00062\n\b\u0002\u0010?\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010#2\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\bD\u0010EJ\t\u0010F\u001a\u00020\u0011HÖ\u0001J\t\u0010G\u001a\u00020\u0006HÖ\u0001J\u0013\u0010J\u001a\u00020#2\b\u0010I\u001a\u0004\u0018\u00010HHÖ\u0003R\"\u0010K\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010S\u001a\u0004\bT\u0010UR\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010V\u001a\u0004\bW\u0010XR\"\u00104\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010V\u001a\u0004\bY\u0010XR\u001c\u00105\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010Z\u001a\u0004\b[\u0010\\R\u001c\u00106\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010]\u001a\u0004\b^\u0010_R(\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010`\u001a\u0004\ba\u0010bR(\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010`\u001a\u0004\bc\u0010bR\u001c\u00109\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010R\u001a\u0004\bd\u0010\"R\u001a\u0010:\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010L\u001a\u0004\be\u0010NR\u001a\u0010;\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010L\u001a\u0004\bf\u0010NR\u001a\u0010<\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010L\u001a\u0004\bg\u0010NR\u001a\u0010=\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010L\u001a\u0004\bh\u0010NR\u001a\u0010>\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010S\u001a\u0004\bi\u0010UR\u001c\u0010?\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010j\u001a\u0004\bk\u0010lR\u001c\u0010@\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010m\u001a\u0004\bn\u0010oR\u001c\u0010A\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010p\u001a\u0004\bq\u0010.R\u001c\u0010B\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010p\u001a\u0004\br\u0010.R(\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000200\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010`\u001a\u0004\bs\u0010b¨\u0006v"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/VOIdentifier;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/m;", "getHeaderTabs", "", "position", "subPosition", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideoData", "(ILjava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "getMultiPreviewCell", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "getVideoMedia", "(ILjava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "", "identifier", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "getCellStyle", "getLastScaleIndex", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantModel;", "component2", "component3", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "component4", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;", "component5", "", "component6", "component7", "component8", "()Ljava/lang/Integer;", "", "component9", "component10", "component11", "component12", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;", "component14", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component15", "component16", "()Ljava/lang/Boolean;", "component17", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "component18", "sizeType", "pendants", "cells", "previewMeta", "footer", "trackMeta", "actionMeta", "bottomHeight", "enableBottomFillBlur", "needSortPreview", "enableVideoCollection", "enableAIVideo", "changeKeyPosition", "containerConfig", "fakeVideoIcon", "enableLego26", "enablePreviewList", "actionMap", "copy", "(ILjava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZZZZILcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "toString", "hashCode", "", "other", "equals", "localIsFromJisoo", "Z", "getLocalIsFromJisoo", "()Z", "setLocalIsFromJisoo", "(Z)V", "localLastScaleCellIndex", "Ljava/lang/Integer;", "I", "getSizeType", "()I", "Ljava/util/List;", "getPendants", "()Ljava/util/List;", "getCells", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "getPreviewMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;", "getFooter", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;", "Ljava/util/Map;", "getTrackMeta", "()Ljava/util/Map;", "getActionMeta", "getBottomHeight", "getEnableBottomFillBlur", "getNeedSortPreview", "getEnableVideoCollection", "getEnableAIVideo", "getChangeKeyPosition", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;", "getContainerConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getFakeVideoIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Ljava/lang/Boolean;", "getEnableLego26", "getEnablePreviewList", "getActionMap", "<init>", "(ILjava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZZZZILcom/bytedance/android/shopping/anchorv4/voavhs/headv2/g;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadV2VO extends VOIdentifier implements Serializable {

    @SerializedName("action_map")
    private final Map<String, IAction> actionMap;

    @SerializedName("action_meta")
    private final Map<String, String> actionMeta;

    @SerializedName("bottom_height")
    private final Integer bottomHeight;

    @SerializedName("cells")
    private final List<HeaderContentModel> cells;

    @SerializedName("change_key_position")
    private final int changeKeyPosition;

    @SerializedName("container_config")
    private final g containerConfig;

    @SerializedName("enable_ai_video")
    private final boolean enableAIVideo;

    @SerializedName("enable_bottom_fill_blur")
    private final boolean enableBottomFillBlur;

    @SerializedName("enable_lego_26")
    private final Boolean enableLego26;

    @SerializedName("enable_preview_list")
    private final Boolean enablePreviewList;

    @SerializedName("enable_video_collection")
    private final boolean enableVideoCollection;

    @SerializedName("video_center_icon")
    private final ECUrlModel fakeVideoIcon;

    @SerializedName("footer")
    private final ScrollContainerFooter footer;
    private boolean localIsFromJisoo;
    private Integer localLastScaleCellIndex;

    @SerializedName("need_sort_preview")
    private final boolean needSortPreview;

    @SerializedName("pendants")
    private final List<HeaderPendantModel> pendants;

    @SerializedName("preview_meta")
    private final HeaderPreviewMeta previewMeta;

    @SerializedName("size_type")
    private final int sizeType;

    @SerializedName("track_meta")
    private final Map<String, String> trackMeta;

    public AnchorV4HeadV2VO() {
        this(0, null, null, null, null, null, null, null, false, false, false, false, 0, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4HeadV2VO copy$default(AnchorV4HeadV2VO r17, int r18, List r19, List r20, HeaderPreviewMeta r21, ScrollContainerFooter r22, Map r23, Map r24, Integer r25, boolean r26, boolean r27, boolean r28, boolean r29, int r30, g r31, ECUrlModel r32, Boolean r33, Boolean r34, Map r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        int r2 = r17.sizeType;
    L7:
        if ((r36 & 2) == 0) goto L9;
        List r3 = r17.pendants;
    L11:
        if ((r36 & 4) == 0) goto L13;
        List r4 = r17.cells;
    L15:
        if ((r36 & 8) == 0) goto L17;
        HeaderPreviewMeta r5 = r17.previewMeta;
    L19:
        if ((r36 & 16) == 0) goto L21;
        ScrollContainerFooter r6 = r17.footer;
    L23:
        if ((r36 & 32) == 0) goto L25;
        Map r7 = r17.trackMeta;
    L27:
        if ((r36 & 64) == 0) goto L29;
        Map r8 = r17.actionMeta;
    L31:
        if ((r36 & 128) == 0) goto L33;
        Integer r9 = r17.bottomHeight;
    L35:
        if ((r36 & 256) == 0) goto L37;
        boolean r10 = r17.enableBottomFillBlur;
    L39:
        if ((r36 & 512) == 0) goto L41;
        boolean r11 = r17.needSortPreview;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        boolean r12 = r17.enableVideoCollection;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        boolean r13 = r17.enableAIVideo;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        int r14 = r17.changeKeyPosition;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        g r15 = r17.containerConfig;
    L58:
        g r38 = r15;
        if ((r36 & 16384) == 0) goto L61;
        ECUrlModel r16 = r17.fakeVideoIcon;
    L62:
        ECUrlModel r39 = r16;
        if ((r36 & 32768) == 0) goto L65;
        Boolean r110 = r17.enableLego26;
    L66:
        Boolean r310 = r110;
        if ((r36 & 65536) == 0) goto L69;
        Boolean r111 = r17.enablePreviewList;
    L71:
        if ((r36 & 131072) == 0) goto L73;
        Map r1 = r17.actionMap;
    L75:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r38, r39, r310, r111, r1);
    L73:
        r1 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final int component1() {
        return this.sizeType;
    }

    public final boolean component10() {
        return this.needSortPreview;
    }

    public final boolean component11() {
        return this.enableVideoCollection;
    }

    public final boolean component12() {
        return this.enableAIVideo;
    }

    public final int component13() {
        return this.changeKeyPosition;
    }

    public final g component14() {
        return this.containerConfig;
    }

    public final ECUrlModel component15() {
        return this.fakeVideoIcon;
    }

    public final Boolean component16() {
        return this.enableLego26;
    }

    public final Boolean component17() {
        return this.enablePreviewList;
    }

    public final Map<String, IAction> component18() {
        return this.actionMap;
    }

    public final List<HeaderPendantModel> component2() {
        return this.pendants;
    }

    public final List<HeaderContentModel> component3() {
        return this.cells;
    }

    public final HeaderPreviewMeta component4() {
        return this.previewMeta;
    }

    public final ScrollContainerFooter component5() {
        return this.footer;
    }

    public final Map<String, String> component6() {
        return this.trackMeta;
    }

    public final Map<String, String> component7() {
        return this.actionMeta;
    }

    public final Integer component8() {
        return this.bottomHeight;
    }

    public final boolean component9() {
        return this.enableBottomFillBlur;
    }

    public final AnchorV4HeadV2VO copy(int r21, List<HeaderPendantModel> r22, List<HeaderContentModel> r23, HeaderPreviewMeta r24, ScrollContainerFooter r25, Map<String, String> r26, Map<String, String> r27, Integer r28, boolean r29, boolean r30, boolean r31, boolean r32, int r33, g r34, ECUrlModel r35, Boolean r36, Boolean r37, Map<String, ? extends IAction> r38) {
        return new AnchorV4HeadV2VO(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4HeadV2VO) == false) goto L42;
        AnchorV4HeadV2VO r4 = (AnchorV4HeadV2VO) r3;
        if (this.sizeType == r4.sizeType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pendants, r4.pendants) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cells, r4.cells) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewMeta, r4.previewMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.footer, r4.footer) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.trackMeta, r4.trackMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionMeta, r4.actionMeta) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bottomHeight, r4.bottomHeight) == true) goto L22;
        return false;
    L22:
        if (this.enableBottomFillBlur == r4.enableBottomFillBlur) goto L24;
        return false;
    L24:
        if (this.needSortPreview == r4.needSortPreview) goto L26;
        return false;
    L26:
        if (this.enableVideoCollection == r4.enableVideoCollection) goto L28;
        return false;
    L28:
        if (this.enableAIVideo == r4.enableAIVideo) goto L30;
        return false;
    L30:
        if (this.changeKeyPosition == r4.changeKeyPosition) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.containerConfig, r4.containerConfig) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.fakeVideoIcon, r4.fakeVideoIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableLego26, r4.enableLego26) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.enablePreviewList, r4.enablePreviewList) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.actionMap, r4.actionMap) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r0 = this.sizeType * 31;
        List<HeaderPendantModel> r1 = this.pendants;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        List<HeaderContentModel> r5 = this.cells;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        HeaderPreviewMeta r8 = this.previewMeta;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        ScrollContainerFooter r11 = this.footer;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        Map<String, String> r14 = this.trackMeta;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Map<String, String> r17 = this.actionMeta;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.bottomHeight;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.enableBottomFillBlur;
        ?? r24 = 1;
        ?? r25 = r23;
        if (r23 == false) goto L33;
        r25 = 1;
    L33:
        int r26 = (r22 + r25) * 31;
        boolean r27 = this.needSortPreview;
        ?? r28 = r27;
        if (r27 == false) goto L36;
        r28 = 1;
    L36:
        int r29 = (r26 + r28) * 31;
        boolean r30 = this.enableVideoCollection;
        ?? r31 = r30;
        if (r30 == false) goto L39;
        r31 = 1;
    L39:
        int r32 = (r29 + r31) * 31;
        boolean r33 = this.enableAIVideo;
        if (r33 == true) goto L43;
        r24 = r33;
    L43:
        int r34 = (((r32 + r24) * 31) + this.changeKeyPosition) * 31;
        g r35 = this.containerConfig;
        if (r35 == null) goto L46;
        int r36 = r35.hashCode();
    L47:
        int r37 = (r34 + r36) * 31;
        ECUrlModel r38 = this.fakeVideoIcon;
        if (r38 == null) goto L50;
        int r39 = r38.hashCode();
    L51:
        int r40 = (r37 + r39) * 31;
        Boolean r41 = this.enableLego26;
        if (r41 == null) goto L54;
        int r42 = r41.hashCode();
    L55:
        int r43 = (r40 + r42) * 31;
        Boolean r44 = this.enablePreviewList;
        if (r44 == null) goto L58;
        int r45 = r44.hashCode();
    L59:
        int r46 = (r43 + r45) * 31;
        Map<String, IAction> r47 = this.actionMap;
        if (r47 == null) goto L63;
        r2 = r47.hashCode();
    L63:
        return r46 + r2;
    L58:
        r45 = 0;
        goto L59
    L54:
        r42 = 0;
        goto L55
    L50:
        r39 = 0;
        goto L51
    L46:
        r36 = 0;
        goto L47
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4HeadV2VO(sizeType=" + this.sizeType + ", pendants=" + this.pendants + ", cells=" + this.cells + ", previewMeta=" + this.previewMeta + ", footer=" + this.footer + ", trackMeta=" + this.trackMeta + ", actionMeta=" + this.actionMeta + ", bottomHeight=" + this.bottomHeight + ", enableBottomFillBlur=" + this.enableBottomFillBlur + ", needSortPreview=" + this.needSortPreview + ", enableVideoCollection=" + this.enableVideoCollection + ", enableAIVideo=" + this.enableAIVideo + ", changeKeyPosition=" + this.changeKeyPosition + ", containerConfig=" + this.containerConfig + ", fakeVideoIcon=" + this.fakeVideoIcon + ", enableLego26=" + this.enableLego26 + ", enablePreviewList=" + this.enablePreviewList + ", actionMap=" + this.actionMap + ")";
    }

    public final List<m> getHeaderTabs() {
        List<HeaderPendantModel> r0 = this.pendants;
        if (r0 == null) goto L20;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((HeaderPendantModel) r2).getId(), "tab") == false) goto L6;
    L11:
        HeaderPendantModel r3 = (HeaderPendantModel) r2;
        if (r3 == null) goto L21;
        HeaderPendantNative r4 = r3.getNative();
        if (r4 != null) goto L16;
        return null;
    L16:
        return r4.getHeaderTabs();
    L21:
        return null;
    L10:
        r2 = null;
        goto L11
    L20:
        return null;
    }

    public final int getLastScaleIndex() {
        if (this.localLastScaleCellIndex != null) goto L22;
        this.localLastScaleCellIndex = -1;
        List<HeaderContentModel> r0 = this.cells;
        int r2 = 0;
        if (r0 == null) goto L7;
        int r1 = r0.size();
    L8:
        if (r2 >= r1) goto L22;
        List<HeaderContentModel> r3 = this.cells;
        if (r3 == null) goto L16;
        HeaderContentModel r4 = (HeaderContentModel) CollectionsKt.getOrNull(r3, r2);
        if (r4 == null) goto L16;
        i r5 = r4.getStyle();
        if (r5 == null) goto L16;
        Float r6 = r5.a();
    L17:
        if (r6 == null) goto L22;
        if (r6.floatValue() >= 1.0f) goto L22;
        this.localLastScaleCellIndex = Integer.valueOf(r2);
        r2 = r2 + 1;
    L16:
        r6 = null;
        goto L17
    L7:
        r1 = 0;
    L22:
        Integer r7 = this.localLastScaleCellIndex;
        if (r7 != null) goto L25;
        return -1;
    L25:
        return r7.intValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public String identifier() {
        return ComponentIDs.HEAD_SLIDES.getId();
    }

    public final Map<String, IAction> getActionMap() {
        return this.actionMap;
    }

    public final Map<String, String> getActionMeta() {
        return this.actionMeta;
    }

    public final Integer getBottomHeight() {
        return this.bottomHeight;
    }

    public final List<HeaderContentModel> getCells() {
        return this.cells;
    }

    public final int getChangeKeyPosition() {
        return this.changeKeyPosition;
    }

    public final g getContainerConfig() {
        return this.containerConfig;
    }

    public final boolean getEnableAIVideo() {
        return this.enableAIVideo;
    }

    public final boolean getEnableBottomFillBlur() {
        return this.enableBottomFillBlur;
    }

    public final Boolean getEnableLego26() {
        return this.enableLego26;
    }

    public final Boolean getEnablePreviewList() {
        return this.enablePreviewList;
    }

    public final boolean getEnableVideoCollection() {
        return this.enableVideoCollection;
    }

    public final ECUrlModel getFakeVideoIcon() {
        return this.fakeVideoIcon;
    }

    public final ScrollContainerFooter getFooter() {
        return this.footer;
    }

    public final boolean getLocalIsFromJisoo() {
        return this.localIsFromJisoo;
    }

    public final boolean getNeedSortPreview() {
        return this.needSortPreview;
    }

    public final List<HeaderPendantModel> getPendants() {
        return this.pendants;
    }

    public final HeaderPreviewMeta getPreviewMeta() {
        return this.previewMeta;
    }

    public final int getSizeType() {
        return this.sizeType;
    }

    public final Map<String, String> getTrackMeta() {
        return this.trackMeta;
    }

    public final i getCellStyle(int r2) {
        List<HeaderContentModel> r0 = this.cells;
        if (r0 == null) goto L7;
        HeaderContentModel r3 = (HeaderContentModel) CollectionsKt.getOrNull(r0, r2);
        if (r3 == null) goto L7;
        return r3.getStyle();
    L7:
        return null;
    }

    public final void setLocalIsFromJisoo(boolean r1) {
        this.localIsFromJisoo = r1;
    }

    public final HeaderContentModel getMultiPreviewCell(int r2, int r3) {
        List<HeaderContentModel> r0 = this.cells;
        if (r0 == null) goto L13;
        HeaderContentModel r4 = (HeaderContentModel) CollectionsKt.getOrNull(r0, r2);
        if (r4 == null) goto L13;
        r r5 = r4.getMultiPreview();
        if (r5 == null) goto L13;
        List<k> r6 = r5.a();
        if (r6 == null) goto L13;
        k r7 = (k) CollectionsKt.getOrNull(r6, r3);
        if (r7 == null) goto L13;
        return r7.a();
    L13:
        return null;
    }

    public final VideoModel getVideoData(int r3, Integer r4) {
        if (r4 != null) goto L20;
        List<HeaderContentModel> r5 = this.cells;
        if (r5 == null) goto L14;
        HeaderContentModel r6 = (HeaderContentModel) CollectionsKt.getOrNull(r5, r3);
        if (r6 == null) goto L14;
        HeaderMediaModel r7 = r6.getMedia();
        if (r7 == null) goto L14;
        VideoModel r8 = r7.getVideo();
        if (r8 == null) goto L14;
        return r8;
    L14:
        HeaderContentModel r9 = getMultiPreviewCell(r3, 0);
        if (r9 == null) goto L35;
        HeaderMediaModel r10 = r9.getMedia();
        if (r10 != null) goto L37;
        return null;
    L37:
        return r10.getVideo();
    L35:
        return null;
    L20:
        if (r4.intValue() >= 0) goto L28;
        List<HeaderContentModel> r11 = this.cells;
        if (r11 == null) goto L38;
        HeaderContentModel r12 = (HeaderContentModel) CollectionsKt.getOrNull(r11, r3);
        if (r12 == null) goto L39;
        HeaderMediaModel r13 = r12.getMedia();
        if (r13 != null) goto L41;
        return null;
    L41:
        return r13.getVideo();
    L39:
        return null;
    L38:
        return null;
    L28:
        HeaderContentModel r14 = getMultiPreviewCell(r3, r4.intValue());
        if (r14 == null) goto L42;
        HeaderMediaModel r15 = r14.getMedia();
        if (r15 != null) goto L33;
        return null;
    L33:
        return r15.getVideo();
    L42:
        return null;
    }

    public final HeaderMediaModel getVideoMedia(int r3, Integer r4) {
        if (r4 != null) goto L16;
        List<HeaderContentModel> r5 = this.cells;
        if (r5 == null) goto L12;
        HeaderContentModel r6 = (HeaderContentModel) CollectionsKt.getOrNull(r5, r3);
        if (r6 == null) goto L12;
        HeaderMediaModel r7 = r6.getMedia();
        if (r7 == null) goto L12;
        return r7;
    L12:
        HeaderContentModel r8 = getMultiPreviewCell(r3, 0);
        if (r8 != null) goto L28;
        return null;
    L28:
        return r8.getMedia();
    L16:
        if (r4.intValue() >= 0) goto L22;
        List<HeaderContentModel> r9 = this.cells;
        if (r9 == null) goto L29;
        HeaderContentModel r10 = (HeaderContentModel) CollectionsKt.getOrNull(r9, r3);
        if (r10 != null) goto L31;
        return null;
    L31:
        return r10.getMedia();
    L29:
        return null;
    L22:
        HeaderContentModel r11 = getMultiPreviewCell(r3, r4.intValue());
        if (r11 != null) goto L25;
        return null;
    L25:
        return r11.getMedia();
    }

    public static /* synthetic */ HeaderContentModel getMultiPreviewCell$default(AnchorV4HeadV2VO r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.getMultiPreviewCell(r1, r2);
    }

    public static /* synthetic */ VideoModel getVideoData$default(AnchorV4HeadV2VO r0, int r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getVideoData(r1, r2);
    }

    public static /* synthetic */ HeaderMediaModel getVideoMedia$default(AnchorV4HeadV2VO r0, int r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getVideoMedia(r1, r2);
    }

    public AnchorV4HeadV2VO(int r6, List<HeaderPendantModel> r7, List<HeaderContentModel> r8, HeaderPreviewMeta r9, ScrollContainerFooter r10, Map<String, String> r11, Map<String, String> r12, Integer r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, g r19, ECUrlModel r20, Boolean r21, Boolean r22, Map<String, ? extends IAction> r23) {
        this.sizeType = r6;
        this.pendants = r7;
        this.cells = r8;
        this.previewMeta = r9;
        this.footer = r10;
        this.trackMeta = r11;
        this.actionMeta = r12;
        this.bottomHeight = r13;
        this.enableBottomFillBlur = r14;
        this.needSortPreview = r15;
        this.enableVideoCollection = r16;
        this.enableAIVideo = r17;
        this.changeKeyPosition = r18;
        this.containerConfig = r19;
        this.fakeVideoIcon = r20;
        this.enableLego26 = r21;
        this.enablePreviewList = r22;
        this.actionMap = r23;
        VOIdentifier.scrollConfig$default(this, ComponentIDs.HEAD_SLIDES.getId(), 0, 2, null);
    }

    public /* synthetic */ AnchorV4HeadV2VO(int r20, List r21, List r22, HeaderPreviewMeta r23, ScrollContainerFooter r24, Map r25, Map r26, Integer r27, boolean r28, boolean r29, boolean r30, boolean r31, int r32, g r33, ECUrlModel r34, Boolean r35, Boolean r36, Map r37, int r38, DefaultConstructorMarker r39) {
        int r2 = 0;
        if ((r38 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r38 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        List r5 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        HeaderPreviewMeta r6 = null;
    L19:
        if ((r38 & 16) == 0) goto L21;
        ScrollContainerFooter r7 = null;
    L23:
        if ((r38 & 32) == 0) goto L25;
        Map r8 = null;
    L27:
        if ((r38 & 64) == 0) goto L29;
        Map r9 = null;
    L31:
        if ((r38 & 128) == 0) goto L33;
        Integer r10 = null;
    L35:
        if ((r38 & 256) == 0) goto L37;
        boolean r11 = true;
    L39:
        if ((r38 & 512) == 0) goto L41;
        boolean r12 = false;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        boolean r14 = false;
    L51:
        if ((r38 & 4096) != 0) goto L55;
        r2 = r32;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        g r15 = null;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        ECUrlModel r4 = null;
    L63:
        if ((r38 & 32768) == 0) goto L65;
        Boolean r16 = null;
    L67:
        if ((r38 & 65536) == 0) goto L69;
        Boolean r17 = null;
    L71:
        if ((r38 & 131072) == 0) goto L73;
        Map r0 = null;
    L74:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2, r15, r4, r16, r17, r0);
        return;
    L73:
        r0 = r37;
        goto L74
    L69:
        r17 = r36;
        goto L71
    L65:
        r16 = r35;
        goto L67
    L61:
        r4 = r34;
        goto L63
    L57:
        r15 = r33;
        goto L59
    L49:
        r14 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L29:
        r9 = r26;
        goto L31
    L25:
        r8 = r25;
        goto L27
    L21:
        r7 = r24;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r5 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
