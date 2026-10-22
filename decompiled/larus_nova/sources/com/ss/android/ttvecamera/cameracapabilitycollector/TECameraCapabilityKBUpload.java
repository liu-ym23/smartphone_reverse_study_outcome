package com.ss.android.ttvecamera.cameracapabilitycollector;

import com.ss.android.ttvecamera.TECameraMonitor;
import com.ss.android.ttvecamera.TELogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraCapabilityKBUpload implements TECameraCapabilityCollector.ITECameraCapabilityUploadStrategy {
    private static final String TAG = "TECameraCapabilityKBUpload";
    public static final Map<TECameraCapabilityCollector.Capability, TECameraCapabilityCollector.DataType> sNeedCollectCapabilityType = null;

    /* JADX INFO: renamed from: com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityKBUpload$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType = null;

        static {
            int[] r100 = new int[TECameraCapabilityCollector.Capability.values().length];
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability = r100;
            r100[TECameraCapabilityCollector.Capability.DEPTH_OUTPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L59:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.PREVIEW_SIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L41:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.PICTURE_SIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L55:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.FPS_RANGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L61:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.MANUAL_3A.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L45:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.HIGH_SPEED_VIDEO_FPS_RANGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L47:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.SUPPORT_APERTURES.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L67:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.LOGICAL_MULTI_CAMERA.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L39:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.SUPPORT_EXTENSIONS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L63:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[TECameraCapabilityCollector.Capability.FRONT_BACK_MULTICAM_COMBOS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L17:
            int[] r101 = new int[TECameraCapabilityCollector.DataType.values().length];
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType = r101;
            r101[TECameraCapabilityCollector.DataType.INTEGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L53:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L57:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L65:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L49:
            $SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[TECameraCapabilityCollector.DataType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
            return;
        }
    }

    public TECameraCapabilityKBUpload() {
    }

    static {
        HashMap r100 = new HashMap();
        sNeedCollectCapabilityType = r100;
        TECameraCapabilityCollector.Capability r101 = TECameraCapabilityCollector.Capability.DEPTH_OUTPUT;
        TECameraCapabilityCollector.DataType r102 = TECameraCapabilityCollector.DataType.STRING;
        r100.put(r101, r102);
        r100.put(TECameraCapabilityCollector.Capability.PREVIEW_SIZE, r102);
        r100.put(TECameraCapabilityCollector.Capability.PICTURE_SIZE, r102);
        r100.put(TECameraCapabilityCollector.Capability.FPS_RANGE, r102);
        r100.put(TECameraCapabilityCollector.Capability.MANUAL_3A, r102);
        r100.put(TECameraCapabilityCollector.Capability.HIGH_SPEED_VIDEO_FPS_RANGE, r102);
        r100.put(TECameraCapabilityCollector.Capability.SUPPORT_APERTURES, r102);
        r100.put(TECameraCapabilityCollector.Capability.LOGICAL_MULTI_CAMERA, r102);
        r100.put(TECameraCapabilityCollector.Capability.SUPPORT_EXTENSIONS, r102);
        r100.put(TECameraCapabilityCollector.Capability.FRONT_BACK_MULTICAM_COMBOS, r102);
    }

    private String convertCapabilityToString(TECameraCapabilityCollector.Capability r100) {
        switch(AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$Capability[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        TELogUtils.w(TAG, "key is null, capability is incorrect!");
        return null;
    L5:
        return TECameraMonitor.TE_RECORD_CAMERA_FRONT_BACK_MULTICAM_COMBOS;
    L6:
        return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_EXTENSIONS;
    L7:
        return TECameraMonitor.TE_RECORD_CAMERA_LOGICAL_MULTI_CAMERA_CAPACITY;
    L8:
        return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_APERTURES;
    L9:
        return TECameraMonitor.TE_RECORD_CAMERA_HIGH_SPEED_VIDEO_FPS_RANGE;
    L10:
        return TECameraMonitor.TE_RECORD_CAMERA_MANUAL_3A_CAPACITY;
    L11:
        return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_FPS_RANGE;
    L12:
        return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_PICTURE_SIZE;
    L13:
        return TECameraMonitor.TE_RECORD_CAMERA_SUPPORT_PREVIEW_SIZE;
    L14:
        return TECameraMonitor.TE_RECORD_CAMERA_DEPTH_CAPACITY;
    }

    @Override // com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector.ITECameraCapabilityUploadStrategy
    public TECameraCapabilityCollector.DataType getDataType(TECameraCapabilityCollector.Capability r100) {
        Map<TECameraCapabilityCollector.Capability, TECameraCapabilityCollector.DataType> r101 = sNeedCollectCapabilityType;
        if (r101.get(r100) != null) goto L6;
        return TECameraCapabilityCollector.DataType.UNKNOWN;
    L6:
        return r101.get(r100);
    }

    @Override // com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector.ITECameraCapabilityUploadStrategy
    public void upload(List<TECameraCapabilityCollector.CapabilityDescription> r100) {
        Iterator<TECameraCapabilityCollector.CapabilityDescription> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L26;
        TECameraCapabilityCollector.CapabilityDescription r102 = r101.next();
        String r103 = convertCapabilityToString(r102.identity);
        if (r103 == null) goto L4;
        int r104 = AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$cameracapabilitycollector$TECameraCapabilityCollector$DataType[r102.dataType.ordinal()];
        if (r104 == 1) goto L25;
        if (r104 == 2) goto L25;
        if (r104 != 3) goto L14;
        TECameraMonitor.perfDouble(r103, ((Double) r102.value).doubleValue());
        goto L4
    L14:
        if (r104 != 4) goto L16;
        if (((Boolean) r102.value).booleanValue() == false) goto L22;
        String r105 = "true";
    L23:
        TECameraMonitor.perfString(r103, r105);
        goto L4
    L22:
        r105 = "false";
        goto L23
    L16:
        if (r104 != 5) goto L4;
        TECameraMonitor.perfString(r103, (String) r102.value);
    L25:
        TECameraMonitor.perfLong(r103, ((Long) r102.value).longValue());
        goto L4
    }
}
