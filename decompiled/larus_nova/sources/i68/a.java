package i68;

import com.larus.audio.audiov3.task.sami.v2.x;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import h68.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements f {
    public a() {
    }

    @Override // h68.f
    public final x a(String r100, y58.a r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "asrConfig");
        x r102 = new x(r100);
        r102.k(r101);
        return r102;
    }
}
