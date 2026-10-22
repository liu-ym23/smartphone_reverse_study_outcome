package re;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements td.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Pair<Integer, Integer>> f537402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<String> f537404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<String> f537409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537410l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537411m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537412n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData<Boolean> f537413o;

    @Override // td.e
    public final MutableLiveData<Boolean> getFirstFrame() {
        return this.f537403e;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getLiveEnd() {
        return this.f537411m;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayComplete() {
        return this.f537405g;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayPrepared() {
        return this.f537408j;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayResume() {
        return this.f537406h;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayerBlur() {
        return this.f537413o;
    }

    @Override // td.e
    public final MutableLiveData<String> getPlayerMediaError() {
        return this.f537409k;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayerMute() {
        return this.f537407i;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlaying() {
        return this.f537399a;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getReleased() {
        return this.f537401c;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getReset() {
        return this.f537412n;
    }

    @Override // td.e
    public final MutableLiveData<String> getSeiUpdate() {
        return this.f537404f;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getStopped() {
        return this.f537400b;
    }

    @Override // td.e
    public final MutableLiveData<Pair<Integer, Integer>> getVideoSizeChanged() {
        return this.f537402d;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> isSeiCropping() {
        return this.f537410l;
    }

    public e(IRoomEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "realHub");
        this.f537399a = r100.getPlaying();
        this.f537400b = r100.getStopped();
        this.f537401c = r100.getReleased();
        this.f537402d = r100.getVideoSizeChanged();
        this.f537403e = r100.getFirstFrame();
        this.f537404f = r100.getSeiUpdate();
        this.f537405g = r100.getPlayComplete();
        this.f537406h = r100.getPlayResume();
        this.f537407i = r100.getPlayerMute();
        this.f537408j = r100.getPlayPrepared();
        this.f537409k = r100.getPlayerMediaError();
        this.f537410l = r100.isSeiCropping();
        this.f537411m = r100.getRoomFinish();
        this.f537412n = new MutableLiveData();
        this.f537413o = new MutableLiveData();
    }
}
