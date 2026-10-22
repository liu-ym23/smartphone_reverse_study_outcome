package com.larus.browsertakeover.transport;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public interface BrowserTransport {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/browsertakeover/transport/BrowserTransport$EndpointMode;", "", "<init>", "(Ljava/lang/String;I)V", "BROWSER", "PAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EndpointMode extends Enum<EndpointMode> {
        public static final EndpointMode BROWSER = null;
        public static final EndpointMode PAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EndpointMode[] f319603a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319604b = null;

        public static EnumEntries<EndpointMode> getEntries() {
            return f319604b;
        }

        static {
            EndpointMode r100 = new EndpointMode("BROWSER", 0);
            BROWSER = r100;
            EndpointMode r101 = new EndpointMode("PAGE", 1);
            PAGE = r101;
            EndpointMode[] r102 = {r100, r101};
            f319603a = r102;
            f319604b = EnumEntriesKt.enumEntries(r102);
        }

        public static EndpointMode[] values() {
            return (EndpointMode[]) f319603a.clone();
        }

        public static EndpointMode valueOf(String r100) {
            return (EndpointMode) r27.a.a(EndpointMode.class, r100);
        }

        public EndpointMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/browsertakeover/transport/BrowserTransport$FrameSource;", "", "<init>", "(Ljava/lang/String;I)V", "CDP_SCREENCAST", "RTP_CDP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FrameSource extends Enum<FrameSource> {
        public static final FrameSource CDP_SCREENCAST = null;
        public static final FrameSource RTP_CDP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FrameSource[] f319605a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319606b = null;

        public static EnumEntries<FrameSource> getEntries() {
            return f319606b;
        }

        static {
            FrameSource r100 = new FrameSource("CDP_SCREENCAST", 0);
            CDP_SCREENCAST = r100;
            FrameSource r101 = new FrameSource("RTP_CDP", 1);
            RTP_CDP = r101;
            FrameSource[] r102 = {r100, r101};
            f319605a = r102;
            f319606b = EnumEntriesKt.enumEntries(r102);
        }

        public static FrameSource[] values() {
            return (FrameSource[]) f319605a.clone();
        }

        public static FrameSource valueOf(String r100) {
            return (FrameSource) r27.a.a(FrameSource.class, r100);
        }

        public FrameSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(JSONObject r100);

        void onConnected();

        void onDisconnected();

        void onError();

        void onMessage(String r100);
    }

    FrameSource a();

    void b(com.larus.browsertakeover.cdp.a r100);

    EndpointMode c();

    void disconnect();

    void release();

    boolean send(String r100);
}
