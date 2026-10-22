package com.ss.android.lark.rustinfrabridge.netstate.api;

/* JADX INFO: loaded from: classes38.dex */
public interface NetworkLevelListener {

    public static final enum NetworkLevel extends Enum<NetworkLevel> {
        public static final NetworkLevel EVALUATING = null;
        public static final NetworkLevel EXCELLENT = null;
        public static final NetworkLevel NET_UNAVAILABLE = null;
        public static final NetworkLevel OFFLINE = null;
        public static final NetworkLevel SERVICE_UNAVAILABLE = null;
        public static final NetworkLevel WEAK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkLevel[] f439691a = null;
        private int status;

        static {
            NetworkLevel r100 = new NetworkLevel("EXCELLENT", 0, 1);
            EXCELLENT = r100;
            NetworkLevel r101 = new NetworkLevel("EVALUATING", 1, 2);
            EVALUATING = r101;
            NetworkLevel r102 = new NetworkLevel("WEAK", 2, 3);
            WEAK = r102;
            NetworkLevel r103 = new NetworkLevel("NET_UNAVAILABLE", 3, 4);
            NET_UNAVAILABLE = r103;
            NetworkLevel r104 = new NetworkLevel("SERVICE_UNAVAILABLE", 4, 5);
            SERVICE_UNAVAILABLE = r104;
            NetworkLevel r110 = new NetworkLevel("OFFLINE", 5, 6);
            OFFLINE = r110;
            f439691a = new NetworkLevel[]{r100, r101, r102, r103, r104, r110};
        }

        public static NetworkLevel[] values() {
            return (NetworkLevel[]) f439691a.clone();
        }

        public int getValue() {
            return this.status;
        }

        public static NetworkLevel forNumber(int r100) {
            switch(r100) {
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                case 6: goto L8;
                default: goto L4;
            };
        L4:
            return EXCELLENT;
        L6:
            return SERVICE_UNAVAILABLE;
        L8:
            return NET_UNAVAILABLE;
        L10:
            return WEAK;
        L12:
            return EVALUATING;
        L14:
            return EXCELLENT;
        }

        public static NetworkLevel valueOf(String r100) {
            return (NetworkLevel) r27.a.a(NetworkLevel.class, r100);
        }

        public NetworkLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    void a(NetworkLevel r100);
}
