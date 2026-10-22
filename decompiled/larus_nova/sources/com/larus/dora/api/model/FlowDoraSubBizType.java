package com.larus.dora.api.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraSubBizType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OLA_FRIEND", ExifInterface.LONGITUDE_EAST, "G1_G2", "LORY_B", FaceService.neutralLabel, "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowDoraSubBizType extends Enum<FlowDoraSubBizType> {
    public static final a Companion = null;

    @SerializedName("2")
    public static final FlowDoraSubBizType E = null;

    @SerializedName("3")
    public static final FlowDoraSubBizType G1_G2 = null;

    @SerializedName("5")
    public static final FlowDoraSubBizType H = null;

    @SerializedName("4")
    public static final FlowDoraSubBizType LORY_B = null;

    @SerializedName("1")
    public static final FlowDoraSubBizType OLA_FRIEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowDoraSubBizType[] f331753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331754b = null;
    private final int value;

    public static final class a {
        public static int a() {
            IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            Integer r101 = null;
            if (r100 == null) goto L5;
            DeviceService r102 = r100.device();
        L6:
            if (r102 == null) goto L9;
            r101 = Integer.valueOf(r102.y());
        L9:
            return b(r101);
        L5:
            r102 = null;
            goto L6
        }

        public a() {
        }

        public static int b(Integer r100) {
            boolean r101 = false;
            if (r100 != null) goto L6;
        L7:
            if (r100 != null) goto L10;
        L12:
            if (r100 != null) goto L15;
        L17:
            if (r100 != null) goto L20;
        L22:
            if (r100 != null) goto L25;
            return 0;
        L25:
            if (r100.intValue() == 17) goto L42;
            return 0;
        L42:
            return FlowDoraSubBizType.G1_G2.getValue();
        L20:
            if (r100.intValue() != 16) goto L22;
            return FlowDoraSubBizType.G1_G2.getValue();
        L15:
            if (r100.intValue() != 2) goto L17;
            return FlowDoraSubBizType.E.getValue();
        L10:
            if (r100.intValue() != 0) goto L12;
        L27:
            IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r102 == null) goto L34;
            DeviceService r103 = r102.device();
            if (r103 == null) goto L34;
            if (r103.f() != true) goto L34;
            r101 = true;
        L34:
            if (r101 == false) goto L36;
            FlowDoraSubBizType r104 = FlowDoraSubBizType.H;
        L38:
            return r104.getValue();
        L36:
            r104 = FlowDoraSubBizType.OLA_FRIEND;
            goto L38
        L6:
            if (r100.intValue() == 1) goto L27;
            goto L7
        }
    }

    public static EnumEntries<FlowDoraSubBizType> getEntries() {
        return f331754b;
    }

    static {
        FlowDoraSubBizType r100 = new FlowDoraSubBizType("OLA_FRIEND", 0, 1);
        OLA_FRIEND = r100;
        FlowDoraSubBizType r101 = new FlowDoraSubBizType(ExifInterface.LONGITUDE_EAST, 1, 2);
        E = r101;
        FlowDoraSubBizType r102 = new FlowDoraSubBizType("G1_G2", 2, 3);
        G1_G2 = r102;
        FlowDoraSubBizType r103 = new FlowDoraSubBizType("LORY_B", 3, 4);
        LORY_B = r103;
        FlowDoraSubBizType r104 = new FlowDoraSubBizType(FaceService.neutralLabel, 4, 5);
        H = r104;
        FlowDoraSubBizType[] r110 = {r100, r101, r102, r103, r104};
        f331753a = r110;
        f331754b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static FlowDoraSubBizType[] values() {
        return (FlowDoraSubBizType[]) f331753a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowDoraSubBizType valueOf(String r100) {
        return (FlowDoraSubBizType) r27.a.a(FlowDoraSubBizType.class, r100);
    }

    public FlowDoraSubBizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
