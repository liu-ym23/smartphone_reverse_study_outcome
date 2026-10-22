package r90;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f536686a;

    public e(Ref.ObjectRef r100) {
        this.f536686a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.android.live.emoji.utils.a r101 = com.bytedance.android.live.emoji.utils.a.a();
        ArrayList r102 = (ArrayList) this.f536686a.element;
        r101.getClass();
        Gson r103 = com.bytedance.android.live.emoji.utils.d.f68953a;
        Intrinsics.checkNotNullParameter(r102, "o");
        String r104 = GsonProtectorUtils.toJson(com.bytedance.android.live.emoji.utils.d.f68953a, r102);
        r101.f68948a.edit().putString("recent_system_small_emojis", r104).commit();
        r100.onNext(Unit.INSTANCE);
        r100.onComplete();
    }
}
