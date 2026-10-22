package com.obric.assistant.wakeup.bluetooth_headset.api;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceTypeEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNKNOWN", "TYPE_HEADSET", "TYPE_CARKIT", "TYPE_LOUDSPEAKER", "TYPE_WATCH", "TYPE_BAND", "TYPE_COMPUTER", "TYPE_SMART_PHONE", "TYPE_KEYBOARD", "TYPE_MOUSE", "TYPE_PERIPHERAL", "TYPE_EBIKE", "TYPE_GLASS", "TYPE_PAD", "TYPE_LAPTOP", "TYPE_MICROPHONE", "TYPE_TV", "TYPE_HEADPHONES", "TYPE_GAMEPAD", "TYPE_VR", "TYPE_CAMERA", "TYPE_PRINTER", "TYPE_SELFIESTICK", "TYPE_EVEHICLE", "TYPE_GIMBAL", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueDeviceTypeEnum extends Enum<BlueDeviceTypeEnum> {
    public static final a Companion = null;
    public static final BlueDeviceTypeEnum TYPE_BAND = null;
    public static final BlueDeviceTypeEnum TYPE_CAMERA = null;
    public static final BlueDeviceTypeEnum TYPE_CARKIT = null;
    public static final BlueDeviceTypeEnum TYPE_COMPUTER = null;
    public static final BlueDeviceTypeEnum TYPE_EBIKE = null;
    public static final BlueDeviceTypeEnum TYPE_EVEHICLE = null;
    public static final BlueDeviceTypeEnum TYPE_GAMEPAD = null;
    public static final BlueDeviceTypeEnum TYPE_GIMBAL = null;
    public static final BlueDeviceTypeEnum TYPE_GLASS = null;
    public static final BlueDeviceTypeEnum TYPE_HEADPHONES = null;
    public static final BlueDeviceTypeEnum TYPE_HEADSET = null;
    public static final BlueDeviceTypeEnum TYPE_KEYBOARD = null;
    public static final BlueDeviceTypeEnum TYPE_LAPTOP = null;
    public static final BlueDeviceTypeEnum TYPE_LOUDSPEAKER = null;
    public static final BlueDeviceTypeEnum TYPE_MICROPHONE = null;
    public static final BlueDeviceTypeEnum TYPE_MOUSE = null;
    public static final BlueDeviceTypeEnum TYPE_PAD = null;
    public static final BlueDeviceTypeEnum TYPE_PERIPHERAL = null;
    public static final BlueDeviceTypeEnum TYPE_PRINTER = null;
    public static final BlueDeviceTypeEnum TYPE_SELFIESTICK = null;
    public static final BlueDeviceTypeEnum TYPE_SMART_PHONE = null;
    public static final BlueDeviceTypeEnum TYPE_TV = null;
    public static final BlueDeviceTypeEnum TYPE_UNKNOWN = null;
    public static final BlueDeviceTypeEnum TYPE_VR = null;
    public static final BlueDeviceTypeEnum TYPE_WATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlueDeviceTypeEnum[] f394394a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394395b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static BlueDeviceTypeEnum a(int r100) {
            Iterator<BlueDeviceTypeEnum> r101 = BlueDeviceTypeEnum.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            BlueDeviceTypeEnum r102 = r101.next();
            if (r102.getValue() != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L12:
            BlueDeviceTypeEnum r104 = r102;
            if (r104 == null) goto L15;
            return r104;
        L15:
            return BlueDeviceTypeEnum.TYPE_UNKNOWN;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L12
        }
    }

    public static EnumEntries<BlueDeviceTypeEnum> getEntries() {
        return f394395b;
    }

    static {
        BlueDeviceTypeEnum r100 = new BlueDeviceTypeEnum("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r100;
        BlueDeviceTypeEnum r101 = new BlueDeviceTypeEnum("TYPE_HEADSET", 1, 1);
        TYPE_HEADSET = r101;
        BlueDeviceTypeEnum r102 = new BlueDeviceTypeEnum("TYPE_CARKIT", 2, 2);
        TYPE_CARKIT = r102;
        BlueDeviceTypeEnum r103 = new BlueDeviceTypeEnum("TYPE_LOUDSPEAKER", 3, 3);
        TYPE_LOUDSPEAKER = r103;
        BlueDeviceTypeEnum r104 = new BlueDeviceTypeEnum("TYPE_WATCH", 4, 4);
        TYPE_WATCH = r104;
        BlueDeviceTypeEnum r105 = new BlueDeviceTypeEnum("TYPE_BAND", 5, 5);
        TYPE_BAND = r105;
        BlueDeviceTypeEnum r110 = new BlueDeviceTypeEnum("TYPE_COMPUTER", 6, 6);
        TYPE_COMPUTER = r110;
        BlueDeviceTypeEnum r111 = new BlueDeviceTypeEnum("TYPE_SMART_PHONE", 7, 7);
        TYPE_SMART_PHONE = r111;
        BlueDeviceTypeEnum r112 = new BlueDeviceTypeEnum("TYPE_KEYBOARD", 8, 8);
        TYPE_KEYBOARD = r112;
        BlueDeviceTypeEnum r113 = new BlueDeviceTypeEnum("TYPE_MOUSE", 9, 9);
        TYPE_MOUSE = r113;
        BlueDeviceTypeEnum r114 = new BlueDeviceTypeEnum("TYPE_PERIPHERAL", 10, 10);
        TYPE_PERIPHERAL = r114;
        BlueDeviceTypeEnum r115 = new BlueDeviceTypeEnum("TYPE_EBIKE", 11, 11);
        TYPE_EBIKE = r115;
        BlueDeviceTypeEnum r106 = new BlueDeviceTypeEnum("TYPE_GLASS", 12, 12);
        TYPE_GLASS = r106;
        BlueDeviceTypeEnum r107 = new BlueDeviceTypeEnum("TYPE_PAD", 13, 13);
        TYPE_PAD = r107;
        BlueDeviceTypeEnum r108 = new BlueDeviceTypeEnum("TYPE_LAPTOP", 14, 14);
        TYPE_LAPTOP = r108;
        BlueDeviceTypeEnum r109 = new BlueDeviceTypeEnum("TYPE_MICROPHONE", 15, 15);
        TYPE_MICROPHONE = r109;
        BlueDeviceTypeEnum r116 = new BlueDeviceTypeEnum("TYPE_TV", 16, 16);
        TYPE_TV = r116;
        BlueDeviceTypeEnum r117 = new BlueDeviceTypeEnum("TYPE_HEADPHONES", 17, 17);
        TYPE_HEADPHONES = r117;
        BlueDeviceTypeEnum r118 = new BlueDeviceTypeEnum("TYPE_GAMEPAD", 18, 18);
        TYPE_GAMEPAD = r118;
        BlueDeviceTypeEnum r119 = new BlueDeviceTypeEnum("TYPE_VR", 19, 19);
        TYPE_VR = r119;
        BlueDeviceTypeEnum r120 = new BlueDeviceTypeEnum("TYPE_CAMERA", 20, 20);
        TYPE_CAMERA = r120;
        BlueDeviceTypeEnum r121 = new BlueDeviceTypeEnum("TYPE_PRINTER", 21, 21);
        TYPE_PRINTER = r121;
        BlueDeviceTypeEnum r122 = new BlueDeviceTypeEnum("TYPE_SELFIESTICK", 22, 22);
        TYPE_SELFIESTICK = r122;
        BlueDeviceTypeEnum r123 = new BlueDeviceTypeEnum("TYPE_EVEHICLE", 23, 23);
        TYPE_EVEHICLE = r123;
        BlueDeviceTypeEnum r124 = new BlueDeviceTypeEnum("TYPE_GIMBAL", 24, 24);
        TYPE_GIMBAL = r124;
        BlueDeviceTypeEnum[] r125 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124};
        f394394a = r125;
        f394395b = EnumEntriesKt.enumEntries(r125);
        Companion = new a();
    }

    public static BlueDeviceTypeEnum[] values() {
        return (BlueDeviceTypeEnum[]) f394394a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BlueDeviceTypeEnum valueOf(String r100) {
        return (BlueDeviceTypeEnum) r27.a.a(BlueDeviceTypeEnum.class, r100);
    }

    public BlueDeviceTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
