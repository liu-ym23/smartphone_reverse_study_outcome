package or2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRoomEventHub f524931a;

    public final MutableLiveData<Boolean> a() {
        return this.f524931a.getPlayPrepared();
    }

    public final MutableLiveData<Boolean> b() {
        return this.f524931a.getPlaying();
    }

    public final MutableLiveData<Boolean> c() {
        return this.f524931a.getStallEnd();
    }

    public final MutableLiveData<Boolean> d() {
        return this.f524931a.getStallStart();
    }

    @Override // or2.c
    public final MutableLiveData<String> getSeiUpdate() {
        return this.f524931a.getSeiUpdate();
    }

    public m(IRoomEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f524931a = r100;
    }
}
