package com.larus.audio.call.tracer;

import com.larus.audio.call.RealtimeCallParam;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface c {

    public static final class a {
        public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
            Intrinsics.checkNotNullParameter(r100, "endType");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r102, "ownerInputLanguage");
            Intrinsics.checkNotNullParameter(r103, "ownerOutputLanguage");
            Intrinsics.checkNotNullParameter(r104, "guestInputLanguage");
            Intrinsics.checkNotNullParameter(r105, "guestOutputLanguage");
            Intrinsics.checkNotNullParameter(r106, "translateMode");
        }

        public static void c(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
            Intrinsics.checkNotNullParameter(r100, "startType");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r102, "ownerInputLanguage");
            Intrinsics.checkNotNullParameter(r103, "ownerOutputLanguage");
            Intrinsics.checkNotNullParameter(r104, "guestInputLanguage");
            Intrinsics.checkNotNullParameter(r105, "guestOutputLanguage");
            Intrinsics.checkNotNullParameter(r106, "translateMode");
        }

        public static /* synthetic */ void a(IRealtimeCallTracer r110, String r111, Integer r112, String r113, Long r114, Long r115, Long r116, Integer r117, int r210) {
            if ((r210 & 2) == 0) goto L5;
            Integer r100 = null;
        L7:
            if ((r210 & 4) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r210 & 8) == 0) goto L13;
            Long r102 = null;
        L15:
            if ((r210 & 16) == 0) goto L17;
            Long r103 = null;
        L19:
            if ((r210 & 64) == 0) goto L21;
            Long r118 = null;
        L23:
            if ((r210 & 128) == 0) goto L25;
            Integer r119 = null;
        L26:
            r110.V(r111, r100, r101, r102, r103, null, r118, r119);
            return;
        L25:
            r119 = r117;
            goto L26
        L21:
            r118 = r116;
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

    void N(RealtimeCallParam r100, String r101, String r102);

    void V(String r100, Integer r101, String r102, Long r103, Long r104, Long r105, Long r106, Integer r107);

    void X(String r100, RealtimeCallParam r101);

    void Y(long r100, long r101, long r102);

    void a(String r100, int r101);

    void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106);

    void onSessionStarted();

    void q0(String r100, boolean r101, String r102);

    void u(String r100, String r101, long r102, String r103, String r104, String r105, String r106, String r107, long r110);
}
