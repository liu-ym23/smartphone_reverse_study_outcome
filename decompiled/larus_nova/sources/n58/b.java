package n58;

import com.larus.audio.audiov3.asr.AsrCallBackType;

/* JADX INFO: loaded from: classes24.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r110, String r111, AsrCallBackType r112, String r113, String r114, long r210, String r211, String r212, int r213) {
            if ((r213 & 16) == 0) goto L5;
            long r100 = 0;
        L7:
            if ((r213 & 32) == 0) goto L9;
            String r115 = "";
        L11:
            if ((r213 & 512) == 0) goto L13;
            String r116 = null;
        L14:
            r110.a(r111, r112, r113, r114, r100, r115, 0, null, null, r116);
            return;
        L13:
            r116 = r212;
            goto L14
        L9:
            r115 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    void a(String r100, AsrCallBackType r101, String r102, String r103, long r104, String r105, int r106, String r107, String r110, String r111);

    void b(String r100, String r101);
}
