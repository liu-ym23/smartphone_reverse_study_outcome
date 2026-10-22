package f3;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes43.dex */
public interface h<Result extends ResultModel> {

    public static final class a {
        public static /* synthetic */ void b(h r100, ResultModel r101) {
            r100.b(r101, "");
        }

        public static /* synthetic */ void a(h r100, String r101, f3.a r102, JsonObject r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = null;
        L11:
            r100.c(r101, 0, r102, r103);
        }
    }

    void a(String r100, Object r101);

    void b(Result r100, String r101);

    void c(String r100, int r101, f3.a r102, JsonObject r103);
}
