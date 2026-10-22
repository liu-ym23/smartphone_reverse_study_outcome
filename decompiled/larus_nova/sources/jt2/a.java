package jt2;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f500286a;

    public a(d r100) {
        this.f500286a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ALogger.d("ttlive_cny_stay_time_task_message", GsonProtectorUtils.toJson(GsonHelper.get(), this.f500286a));
    }
}
