package com.larus.bmhome.bigimg;

import com.larus.platform.model.GeoLocationInfo;

/* JADX INFO: loaded from: classes25.dex */
public interface t1 {

    public static final class a {
        public static /* synthetic */ t1 a(t1 r110, String r111, boolean r112, boolean r113, int r114) {
            GeoLocationInfo r100 = null;
            if ((r114 & 1) == 0) goto L5;
            String r101 = r110.getName();
        L7:
            if ((r114 & 2) == 0) goto L9;
            String r102 = r110.getPath();
        L11:
            if ((r114 & 4) == 0) goto L13;
            long r103 = r110.e();
        L15:
            if ((r114 & 8) == 0) goto L17;
            String r104 = r110.g();
        L19:
            if ((r114 & 16) == 0) goto L21;
            int r105 = r110.c();
        L23:
            if ((r114 & 32) == 0) goto L25;
            boolean r115 = r110.b();
        L27:
            if ((r114 & 64) == 0) goto L29;
            boolean r116 = r110.isSelected();
        L31:
            if ((r114 & 128) == 0) goto L33;
            boolean r117 = r110.d();
        L35:
            if ((r114 & 256) == 0) goto L37;
            int r118 = r110.getIndex();
        L39:
            if ((r114 & 512) == 0) goto L42;
            r100 = r110.a();
        L42:
            return r110.f(r101, r102, r103, r104, r105, r115, r116, r117, r118, r100);
        L37:
            r118 = 0;
            goto L39
        L33:
            r117 = false;
            goto L35
        L29:
            r116 = r113;
            goto L31
        L25:
            r115 = r112;
            goto L27
        L21:
            r105 = 0;
            goto L23
        L17:
            r104 = null;
            goto L19
        L13:
            r103 = 0;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = null;
            goto L7
        }
    }

    GeoLocationInfo a();

    boolean b();

    int c();

    boolean d();

    long e();

    t1 f(String r100, String r101, long r102, String r103, int r104, boolean r105, boolean r106, boolean r107, int r110, GeoLocationInfo r111);

    String g();

    int getIndex();

    int getMediaType();

    String getName();

    String getPath();

    boolean isSelected();
}
