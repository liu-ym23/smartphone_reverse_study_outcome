package ne6;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = null;
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = null;
        L11:
            r100.monitorEvent(r101, r102, r103, r104);
        }
    }

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
