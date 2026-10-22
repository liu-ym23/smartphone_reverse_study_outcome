package com.ss.android.lark.rustinfrabridge.appstatesync.service;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public interface IAppStateSyncService {

    public static final enum ClientEvent extends Enum<ClientEvent> {
        public static final ClientEvent CHAT_MESSAGE_GOT = null;
        public static final ClientEvent ENTER_BACKGROUND = null;
        public static final ClientEvent ENTER_FOREGROUND = null;
        public static final ClientEvent FIRST_SCREEN_FINISHED = null;
        public static final ClientEvent IDLE_AFTER_FIRST_SCREEN = null;
        public static final ClientEvent MEMORY_WARNING = null;
        public static final ClientEvent TERMINATING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClientEvent[] f439680a = null;
        private long updateTime;
        private int value;

        static {
            ClientEvent r100 = new ClientEvent("ENTER_FOREGROUND", 0, 1);
            ENTER_FOREGROUND = r100;
            ClientEvent r101 = new ClientEvent("ENTER_BACKGROUND", 1, 2);
            ENTER_BACKGROUND = r101;
            ClientEvent r102 = new ClientEvent("TERMINATING", 2, 3);
            TERMINATING = r102;
            ClientEvent r103 = new ClientEvent("MEMORY_WARNING", 3, 4);
            MEMORY_WARNING = r103;
            ClientEvent r104 = new ClientEvent("FIRST_SCREEN_FINISHED", 4, 5);
            FIRST_SCREEN_FINISHED = r104;
            ClientEvent r110 = new ClientEvent("CHAT_MESSAGE_GOT", 5, 6);
            CHAT_MESSAGE_GOT = r110;
            ClientEvent r111 = new ClientEvent("IDLE_AFTER_FIRST_SCREEN", 6, 7);
            IDLE_AFTER_FIRST_SCREEN = r111;
            f439680a = new ClientEvent[]{r100, r101, r102, r103, r104, r110, r111};
        }

        public static ClientEvent[] values() {
            return (ClientEvent[]) f439680a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public long updateTime() {
            return this.updateTime;
        }

        public static ClientEvent forNumber(int r100) {
            switch(r100) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return IDLE_AFTER_FIRST_SCREEN;
        L8:
            return CHAT_MESSAGE_GOT;
        L10:
            return FIRST_SCREEN_FINISHED;
        L12:
            return MEMORY_WARNING;
        L14:
            return TERMINATING;
        L16:
            return ENTER_BACKGROUND;
        L18:
            return ENTER_FOREGROUND;
        }

        public static ClientEvent valueOf(String r100) {
            return (ClientEvent) a.a(ClientEvent.class, r100);
        }

        public ClientEvent updateTime(long r100) {
            this.updateTime = r100;
            return this;
        }

        public static ClientEvent valueOf(int r100) {
            return forNumber(r100);
        }

        public ClientEvent(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f439681a = null;
        final int nativeInt;
        private final String nativeName;

        static {
            NetworkType r100 = new NetworkType(UserProfileEvent.POSITION_NONE, 0, 0, "unvailable");
            NONE = r100;
            NetworkType r101 = new NetworkType("MOBILE", 1, 1, "mobile");
            MOBILE = r101;
            NetworkType r102 = new NetworkType("MOBILE_2G", 2, 2, "mobile_2g");
            MOBILE_2G = r102;
            NetworkType r103 = new NetworkType("MOBILE_3G", 3, 3, "mobile_3g");
            MOBILE_3G = r103;
            NetworkType r104 = new NetworkType("WIFI", 4, 4, "wifi");
            WIFI = r104;
            NetworkType r105 = new NetworkType("MOBILE_4G", 5, 5, "mobile_4g");
            MOBILE_4G = r105;
            NetworkType r110 = new NetworkType("UNKNOWN", 6, 6, "unknown");
            UNKNOWN = r110;
            f439681a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f439681a.clone();
        }

        public String getNativeName() {
            return this.nativeName;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType forNumber(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return UNKNOWN;
        L8:
            return MOBILE_4G;
        L10:
            return WIFI;
        L12:
            return MOBILE_3G;
        L14:
            return MOBILE_2G;
        L16:
            return MOBILE;
        L18:
            return NONE;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) a.a(NetworkType.class, r100);
        }

        public NetworkType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.nativeInt = r102;
            this.nativeName = r103;
        }
    }

    void a(boolean r100);

    void b();

    void c(boolean r100);
}
