package mq1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;

/* JADX INFO: loaded from: classes8.dex */
public interface o {

    public static final class a {
        public static /* synthetic */ void a(o r100, int r101, int r110, int r111, String r112, int r113) {
            if ((r113 & 2) == 0) goto L5;
            int r102 = 0;
        L7:
            if ((r113 & 4) == 0) goto L9;
            int r103 = 0;
        L11:
            if ((r113 & 8) == 0) goto L13;
            r112 = "";
        L13:
            r100.h3(r101, r102, r103, r112, null);
            return;
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }
    }

    void Sa(Episode r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107);

    void T5(long r100);

    void a(long r100, String r101, Bundle r102);

    void h3(int r100, int r101, int r102, String r103, Object r104);

    void onInputStateChange(boolean r100);
}
