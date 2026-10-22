package rt2;

import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f539175a = null;

    static {
        int[] r100 = new int[LiveWsConnectState.values().length];
        f539175a = r100;
        r100[LiveWsConnectState.CONNECTING.ordinal()] = 1;
        r100[LiveWsConnectState.CONNECT_FAILED.ordinal()] = 2;
        r100[LiveWsConnectState.CONNECT_CLOSED.ordinal()] = 3;
        r100[LiveWsConnectState.CONNECTED.ordinal()] = 4;
    }
}
