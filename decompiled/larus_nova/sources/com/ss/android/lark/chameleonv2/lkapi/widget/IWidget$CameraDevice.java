package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$CameraDevice;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Back", "Front", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IWidget$CameraDevice extends Enum<IWidget$CameraDevice> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IWidget$CameraDevice[] $VALUES = null;
    public static final IWidget$CameraDevice Back = null;
    public static final a Companion = null;
    public static final IWidget$CameraDevice Front = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ IWidget$CameraDevice[] $values() {
        return new IWidget$CameraDevice[]{Back, Front};
    }

    public static EnumEntries<IWidget$CameraDevice> getEntries() {
        return $ENTRIES;
    }

    static {
        Back = new IWidget$CameraDevice("Back", 0, "back");
        Front = new IWidget$CameraDevice("Front", 1, NewBroadcastMonitor.CAPTURE.FRONT);
        IWidget$CameraDevice[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static IWidget$CameraDevice[] values() {
        return (IWidget$CameraDevice[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IWidget$CameraDevice valueOf(String r100) {
        return (IWidget$CameraDevice) r27.a.a(IWidget$CameraDevice.class, r100);
    }

    private IWidget$CameraDevice(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
