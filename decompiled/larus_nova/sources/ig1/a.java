package ig1;

import com.bytedance.android.livesdk.config.lj;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends e {
    @Override // ig1.b
    public final PublishSubject a() {
        return d(lj.f120685a.getValue().a(), TimeUnit.SECONDS);
    }

    public a() {
    }
}
