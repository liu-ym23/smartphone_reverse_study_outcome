package eb1;

import com.google.gson.annotations.SerializedName;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Leb1/b;", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Leb1/a;", "recordAudioList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("audio_paths")
    private CopyOnWriteArrayList<a> recordAudioList;

    public final void a() {
        this.recordAudioList.clear();
    }

    public b() {
        this.recordAudioList = new CopyOnWriteArrayList();
    }

    public final CopyOnWriteArrayList<a> b() {
        return this.recordAudioList;
    }

    public final void c(CopyOnWriteArrayList<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordAudioList = r100;
    }
}
