package zp9;

import com.larus.platform.api.creation.UserCreation;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface r {

    public static final class a {
        public static void a(UserCreation r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "userCreation");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        }
    }

    void X0(String r100);

    void bZ(UserCreation r100);

    void i20(UserCreation r100, long r101, long r102, String r103);

    void yE(UserCreation r100);
}
