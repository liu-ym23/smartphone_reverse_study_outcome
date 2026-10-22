package qx9;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.larus.im.ws.FlowWsConnectionState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f535171a = null;

        static {
            int[] r100 = new int[FlowWsConnectionState.values().length];
            r100[FlowWsConnectionState.CONNECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[FlowWsConnectionState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[FlowWsConnectionState.CONNECT_CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[FlowWsConnectionState.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[FlowWsConnectionState.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f535171a = r100;
        }
    }

    public static final xf9.a a(WsChannelMsg r110) {
        List<WsChannelMsg.MsgHeader> r100 = r110.getMsgHeaders();
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        List<WsChannelMsg.MsgHeader> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        WsChannelMsg.MsgHeader r104 = (WsChannelMsg.MsgHeader) r103.next();
        r102.add(new xf9.b(r104.getKey(), r104.getValue()));
        goto L7
    L9:
        int r105 = r110.getChannelId();
        int r106 = r110.getService();
        int r107 = r110.getMethod();
        byte[] r108 = r110.getPayload();
        if (r108 != null) goto L13;
        r108 = new byte[0];
    L13:
        return new xf9.a(r105, r106, r107, r108, r110.getSeqId(), r110.getUUID(), r102);
    }
}
