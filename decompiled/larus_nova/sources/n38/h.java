package n38;

import com.larus.account.base.model.LoginPlatform;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public interface h {

    public static final class a {
        public static /* synthetic */ void b(h r100, LoginPlatform r101, String r102) {
            r100.b(r101, r102, Boolean.FALSE);
        }

        public static /* synthetic */ void a(h r110, LoginPlatform r111, int r112, String r113, String r114, String r115, Integer r116, String r117, Map r210, int r211) {
            if ((r211 & 32) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r211 & 64) == 0) goto L9;
            Integer r101 = null;
        L11:
            if ((r211 & 128) == 0) goto L13;
            String r118 = null;
        L15:
            if ((r211 & 256) == 0) goto L17;
            Map r119 = null;
        L18:
            r110.a(r111, r112, r113, r114, r100, r101, r118, r119);
            return;
        L17:
            r119 = r210;
            goto L18
        L13:
            r118 = r117;
            goto L15
        L9:
            r101 = r116;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }
    }

    void a(LoginPlatform r100, int r101, String r102, String r103, String r104, Integer r105, String r106, Map r107);

    void b(LoginPlatform r100, String r101, Boolean r102);
}
