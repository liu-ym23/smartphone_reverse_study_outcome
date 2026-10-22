package lh0;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import ih0.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public interface c {

    public static final class a {
        public static void a(h r100, JsonObject r101) {
            Intrinsics.checkNotNullParameter(r100, "updateCallback");
            r100.a(UpdateLinkmicStatusResultModel.Code.Success, "", r101);
        }

        public static /* synthetic */ void b(c r100, h r101) {
            r100.a(r101, null);
        }
    }

    void a(h r100, JsonObject r101);
}
