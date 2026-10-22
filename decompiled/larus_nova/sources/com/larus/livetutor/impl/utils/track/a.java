package com.larus.livetutor.impl.utils.track;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static /* synthetic */ void b(LiveTutorTrackerService r100, String r110, String r111, String r112, String r113, Long r114, String r115, int r116) {
        if ((r116 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r116 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r116 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r116 & 16) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r116 & 32) == 0) goto L21;
        String r105 = null;
    L22:
        r100.g(r110, r101, r102, r103, r104, r105);
        return;
    L21:
        r105 = r115;
        goto L22
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }

    public static /* synthetic */ void a(LiveTutorTrackerService r110, String r111, String r112, String r113, Long r114, Long r115, Long r116, String r117, int r118) {
        if ((r118 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r118 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r118 & 8) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r118 & 16) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r118 & 32) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r118 & 64) == 0) goto L25;
        String r105 = null;
    L26:
        r110.f(r111, r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r117;
        goto L26
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
