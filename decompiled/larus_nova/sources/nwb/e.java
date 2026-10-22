package nwb;

import com.ss.android.lark.officesdk.minutes.assembly.recording.common.InitMinutesRecordingTask;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class e implements b {
    @Inject
    public e() {
    }

    @Override // nwb.b
    public final List<j0c.b> a() {
        j0c.b r100 = InitMinutesRecordingTask.f433585b;
        return CollectionsKt.listOf(InitMinutesRecordingTask.f433585b);
    }
}
