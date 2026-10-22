package nd0;

import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f518745a = null;

    static {
        int[] r100 = new int[MultiLinkEventType.values().length];
        f518745a = r100;
        r100[MultiLinkEventType.SERVER_API_CALL.ordinal()] = 1;
        r100[MultiLinkEventType.MESSAGE_RECEIVED.ordinal()] = 2;
        r100[MultiLinkEventType.SDK_INTERFACE_CALL.ordinal()] = 3;
        r100[MultiLinkEventType.SDK_CALLBACK.ordinal()] = 4;
        r100[MultiLinkEventType.BUSSINESS_API_CALL.ordinal()] = 5;
    }
}
