package com.dtf.face.photinus;

import com.dtf.face.utils.ClientConfigUtil;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final class VideoWriter {

    public static final enum RequestType extends Enum<RequestType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestType[] f273644a = null;
        public static final RequestType rAddMovieFrame = null;
        public static final RequestType rCloseMoveFile = null;
        public static final RequestType rStartNewMovie = null;

        static {
            RequestType r100 = new RequestType("rStartNewMovie", 0);
            rStartNewMovie = r100;
            RequestType r101 = new RequestType("rAddMovieFrame", 1);
            rAddMovieFrame = r101;
            RequestType r102 = new RequestType("rCloseMoveFile", 2);
            rCloseMoveFile = r102;
            f273644a = new RequestType[]{r100, r101, r102};
        }

        public static RequestType[] values() {
            return (RequestType[]) f273644a.clone();
        }

        public static RequestType valueOf(String r100) {
            return (RequestType) a.a(RequestType.class, r100);
        }

        public RequestType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static byte[] b(byte[] r100, int r101, int r102) {
        int r103 = r101 * r102;
        int r104 = (r103 * 3) / 2;
        byte[] r105 = new byte[r104];
        int r106 = r103 - 1;
        int r107 = 0;
    L3:
        if (r106 < 0) goto L5;
        r105[r107] = r100[r106];
        r107 = r107 + 1;
        r106 = r106 - 1;
        goto L3
    L5:
        int r108 = r104 - 1;
    L6:
        if (r108 < r103) goto L8;
        int r109 = r107 + 1;
        r105[r107] = r100[r108];
        r107 = r109 + 1;
        r105[r109] = r100[r108 - 1];
        r108 = r108 - 2;
        goto L6
    L8:
        return r105;
    }

    public static byte[] a(byte[] r110, int r111, int r112, int r113) {
        int r100 = 0;
        if (r113 != 270) goto L28;
        int r114 = r111 * r112;
        int r101 = (r114 * 3) / 2;
        byte[] r102 = new byte[r101];
        if (r111 != 0) goto L9;
        if (r112 != 0) goto L9;
        r114 = 0;
        int r103 = 0;
    L10:
        int r104 = 0;
        int r105 = 0;
    L11:
        if (r104 >= r111) goto L16;
        int r106 = 0;
        int r107 = 0;
    L13:
        if (r106 >= r112) goto L15;
        r102[r105] = r110[r107 + r104];
        r105 = r105 + 1;
        r107 = r107 + r111;
        r106 = r106 + 1;
        goto L13
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        int r108 = 0;
    L17:
        if (r108 >= r111) goto L26;
        int r109 = r114;
        int r115 = 0;
    L19:
        if (r115 >= r103) goto L24;
        int r116 = r109 + r108;
        if (r116 >= (r101 - 2)) goto L24;
        r102[r105] = r110[r116];
        r102[r105 + 1] = r110[r116 + 1];
        r105 = r105 + 2;
        r109 = r109 + r111;
        r115 = r115 + 1;
    L24:
        r108 = r108 + 2;
        goto L17
    L26:
        return b(r102, r111, r112);
    L9:
        r103 = r112 >> 1;
        goto L10
    L28:
        if (r113 != 180) goto L42;
        if ((!"0".equals(ClientConfigUtil.c("VIDEO_USE_FRAME_DATA"))) == false) goto L40;
        int r117 = r111 * r112;
        int r118 = 0;
    L32:
        int r119 = r117 / 2;
        if (r118 >= r119) goto L36;
        byte r120 = r110[r118];
        int r121 = (r117 - 1) - r118;
        r110[r118] = r110[r121];
        r110[r121] = r120;
        r118 = r118 + 1;
    L36:
        if (r100 >= (r119 / 2)) goto L38;
        int r122 = r117 + r100;
        int r123 = ((r117 + r119) - 2) - r100;
        byte r124 = r110[r122];
        int r125 = r123 + 1;
        r110[r122] = r110[r125];
        r110[r125] = r124;
        int r126 = r122 + 1;
        byte r127 = r110[r126];
        r110[r126] = r110[r123];
        r110[r123] = r127;
        r100 = r100 + 2;
        goto L36
    L38:
        return r110;
    L40:
        return b(r110, r111, r112);
    L42:
        if (r113 != 90) goto L58;
        int r128 = r111 * r112;
        int r129 = (r128 * 3) / 2;
        byte[] r130 = new byte[r129];
        int r131 = r112 - 1;
        int r132 = r131 * r111;
        int r133 = 0;
        int r134 = 0;
    L44:
        if (r133 >= r111) goto L49;
        int r135 = r131;
        int r136 = r132;
    L46:
        if (r135 < 0) goto L48;
        r130[r134] = r110[r136 + r133];
        r134 = r134 + 1;
        r136 = r136 - r111;
        r135 = r135 - 1;
        goto L46
    L48:
        r133 = r133 + 1;
        goto L44
    L49:
        int r137 = r129 - 1;
        int r138 = r111 - 1;
    L50:
        if (r138 <= 0) goto L56;
        int r139 = r128;
        int r140 = 0;
    L53:
        if (r140 >= (r112 / 2)) goto L55;
        int r141 = r139 + r138;
        r130[r137] = r110[r141 - 1];
        int r142 = r137 - 1;
        r130[r142] = r110[r141];
        r137 = r142 - 1;
        r139 = r139 + r111;
        r140 = r140 + 1;
        goto L53
    L55:
        r138 = r138 - 2;
        goto L50
    L56:
        return r130;
    L58:
        if ((!"0".equals(ClientConfigUtil.c("VIDEO_USE_FRAME_DATA"))) == false) goto L64;
        int r143 = r111 * r112;
        int r144 = r143;
    L61:
        if (r144 >= ((r143 * 3) / 2)) goto L63;
        byte r145 = r110[r144];
        int r146 = r144 + 1;
        r110[r144] = r110[r146];
        r110[r146] = r145;
        r144 = r144 + 2;
        goto L61
    L63:
        return r110;
    L64:
        int r147 = r111 * r112;
        int r148 = (r147 * 3) / 2;
        byte[] r149 = new byte[r148];
    L65:
        if (r100 >= r147) goto L67;
        r149[r100] = r110[r100];
        r100 = r100 + 1;
    L67:
        if (r147 >= r148) goto L69;
        int r150 = r147 + 1;
        r149[r147] = r110[r150];
        r149[r150] = r110[r147];
        r147 = r147 + 2;
        goto L67
    L69:
        return r149;
    }
}
