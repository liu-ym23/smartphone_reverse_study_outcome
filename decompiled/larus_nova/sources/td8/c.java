package td8;

import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes25.dex */
public interface c {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List b(c r410, int r411, List r510, int r511) {
            if ((r511 & 1) == 0) goto L5;
            int r100 = 0;
        L7:
            if ((r511 & 4) == 0) goto L9;
            Object[] r110 = 0 == true ? 1 : 0;
            yc8.a r101 = new yc8.a(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, r110, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null));
        L11:
            return r410.b(r100, null, r101, r510);
        L9:
            r101 = null;
            goto L11
        L5:
            r100 = r411;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(c r410, int r510, xc8.b r511, xc8.b r512, List r513, int r514) {
            if ((r514 & 1) == 0) goto L5;
            int r100 = 0;
        L7:
            if ((r514 & 2) == 0) goto L9;
            xc8.b r101 = null;
        L11:
            if ((r514 & 4) == 0) goto L13;
            Object[] r110 = 0 == true ? 1 : 0;
            xc8.b r102 = new yc8.a(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, r110, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null));
        L15:
            if ((r514 & 8) == 0) goto L17;
            List r103 = new ArrayList();
        L19:
            return r410.a(r100, r101, r102, r103);
        L17:
            r103 = r513;
            goto L19
        L13:
            r102 = r512;
            goto L15
        L9:
            r101 = r511;
            goto L11
        L5:
            r100 = r510;
            goto L7
        }
    }

    boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103);

    List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r103);
}
