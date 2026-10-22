package tv1;

import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DislikeApi f547664a;

    public c(DislikeApi r100) {
        this.f547664a = r100;
    }

    public final Observable a(long r110, String r111, String r112, String r113, String r114) {
        return this.f547664a.dislikeRoomSaasLegacy(r110, r111, r111, r112, "", r113, r114).map(new a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
