package sk1;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.LiveRoomIDData;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f542333a = null;

    static {
        f542333a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Response<LiveRoomIDData>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.onNext(new Response());
        r100.onComplete();
    }
}
