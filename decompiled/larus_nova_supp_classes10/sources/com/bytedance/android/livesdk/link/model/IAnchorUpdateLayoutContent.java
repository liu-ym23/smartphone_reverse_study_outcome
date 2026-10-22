package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0004\u001b\u001c\u001d\u001eR\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011R6\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015`\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/h6;", "", "getUpdateLayoutType", "()I", "getUpdateLayoutType$annotations", "()V", "updateLayoutType", "getAnchorUILayout", "getAnchorUILayout$annotations", "anchorUILayout", "getAnchorLayoutRange", "getAnchorLayoutRange$annotations", "anchorLayoutRange", "", "getUpdateUserID", "()Ljava/lang/String;", "getUpdateUserID$annotations", "updateUserID", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLayoutDetails", "()Ljava/util/Map;", "getLayoutDetails$annotations", "layoutDetails", "AnchorLayoutRange", "AnchorUILayout", "AnchorUIOperationType", "UpdateAnchorLayoutType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAnchorUpdateLayoutContent extends vh7.e<com.bytedance.android.livesdk.message.model.h6>, com.bytedance.android.livesdk.message.model.h6 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent$AnchorLayoutRange;", "", "AnchorLayoutRangeMyRoom", "AnchorLayoutRangeAllRoom", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AnchorLayoutRange extends Enum<AnchorLayoutRange> {
        public static final AnchorLayoutRange AnchorLayoutRangeAllRoom = null;
        public static final AnchorLayoutRange AnchorLayoutRangeMyRoom = null;
        public static final /* synthetic */ AnchorLayoutRange[] a = null;

        static {
            AnchorLayoutRange r1 = new AnchorLayoutRange("AnchorLayoutRangeMyRoom", 0);
            AnchorLayoutRangeMyRoom = r1;
            AnchorLayoutRange r2 = new AnchorLayoutRange("AnchorLayoutRangeAllRoom", 1);
            AnchorLayoutRangeAllRoom = r2;
            a = new AnchorLayoutRange[]{r1, r2};
        }

        public static AnchorLayoutRange valueOf(String r1) {
            return (AnchorLayoutRange) r27.a.a(AnchorLayoutRange.class, r1);
        }

        public static AnchorLayoutRange[] values() {
            return (AnchorLayoutRange[]) a.clone();
        }

        public AnchorLayoutRange(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent$AnchorUILayout;", "", "AnchorUILayout2V2Equal", "AnchorUILayout1V3", "AnchorUILayoutSmall", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AnchorUILayout extends Enum<AnchorUILayout> {
        public static final AnchorUILayout AnchorUILayout1V3 = null;
        public static final AnchorUILayout AnchorUILayout2V2Equal = null;
        public static final AnchorUILayout AnchorUILayoutSmall = null;
        public static final /* synthetic */ AnchorUILayout[] a = null;

        static {
            AnchorUILayout r1 = new AnchorUILayout("AnchorUILayout2V2Equal", 0);
            AnchorUILayout2V2Equal = r1;
            AnchorUILayout r2 = new AnchorUILayout("AnchorUILayout1V3", 1);
            AnchorUILayout1V3 = r2;
            AnchorUILayout r3 = new AnchorUILayout("AnchorUILayoutSmall", 2);
            AnchorUILayoutSmall = r3;
            a = new AnchorUILayout[]{r1, r2, r3};
        }

        public static AnchorUILayout valueOf(String r1) {
            return (AnchorUILayout) r27.a.a(AnchorUILayout.class, r1);
        }

        public static AnchorUILayout[] values() {
            return (AnchorUILayout[]) a.clone();
        }

        public AnchorUILayout(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent$AnchorUIOperationType;", "", "OperationUnknown", "Operation1V3Enlarge", "OperationSmall", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AnchorUIOperationType extends Enum<AnchorUIOperationType> {
        public static final AnchorUIOperationType Operation1V3Enlarge = null;
        public static final AnchorUIOperationType OperationSmall = null;
        public static final AnchorUIOperationType OperationUnknown = null;
        public static final /* synthetic */ AnchorUIOperationType[] a = null;

        static {
            AnchorUIOperationType r1 = new AnchorUIOperationType("OperationUnknown", 0);
            OperationUnknown = r1;
            AnchorUIOperationType r2 = new AnchorUIOperationType("Operation1V3Enlarge", 1);
            Operation1V3Enlarge = r2;
            AnchorUIOperationType r3 = new AnchorUIOperationType("OperationSmall", 2);
            OperationSmall = r3;
            a = new AnchorUIOperationType[]{r1, r2, r3};
        }

        public static AnchorUIOperationType valueOf(String r1) {
            return (AnchorUIOperationType) r27.a.a(AnchorUIOperationType.class, r1);
        }

        public static AnchorUIOperationType[] values() {
            return (AnchorUIOperationType[]) a.clone();
        }

        public AnchorUIOperationType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLayoutContent$UpdateAnchorLayoutType;", "", "UpdateAnchorLayoutTypeUnknown", "EnlargeAllStream", "UnEnlargeAllStream", "EnlargeMyStream", "UnEnlargeMyStream", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum UpdateAnchorLayoutType extends Enum<UpdateAnchorLayoutType> {
        public static final UpdateAnchorLayoutType EnlargeAllStream = null;
        public static final UpdateAnchorLayoutType EnlargeMyStream = null;
        public static final UpdateAnchorLayoutType UnEnlargeAllStream = null;
        public static final UpdateAnchorLayoutType UnEnlargeMyStream = null;
        public static final UpdateAnchorLayoutType UpdateAnchorLayoutTypeUnknown = null;
        public static final /* synthetic */ UpdateAnchorLayoutType[] a = null;

        static {
            UpdateAnchorLayoutType r1 = new UpdateAnchorLayoutType("UpdateAnchorLayoutTypeUnknown", 0);
            UpdateAnchorLayoutTypeUnknown = r1;
            UpdateAnchorLayoutType r2 = new UpdateAnchorLayoutType("EnlargeAllStream", 1);
            EnlargeAllStream = r2;
            UpdateAnchorLayoutType r3 = new UpdateAnchorLayoutType("UnEnlargeAllStream", 2);
            UnEnlargeAllStream = r3;
            UpdateAnchorLayoutType r4 = new UpdateAnchorLayoutType("EnlargeMyStream", 3);
            EnlargeMyStream = r4;
            UpdateAnchorLayoutType r5 = new UpdateAnchorLayoutType("UnEnlargeMyStream", 4);
            UnEnlargeMyStream = r5;
            a = new UpdateAnchorLayoutType[]{r1, r2, r3, r4, r5};
        }

        public static UpdateAnchorLayoutType valueOf(String r1) {
            return (UpdateAnchorLayoutType) r27.a.a(UpdateAnchorLayoutType.class, r1);
        }

        public static UpdateAnchorLayoutType[] values() {
            return (UpdateAnchorLayoutType[]) a.clone();
        }

        public UpdateAnchorLayoutType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "anchor_layout_range")
    int getAnchorLayoutRange();

    @FieldName(name = "anchor_ui_layout")
    int getAnchorUILayout();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "layout_details")
    Map<String, com.bytedance.android.livesdk.link.model.bridge.g> getLayoutDetails();

    @FieldName(name = "layout_type")
    int getUpdateLayoutType();

    @FieldName(name = "update_open_user_id")
    String getUpdateUserID();
}
