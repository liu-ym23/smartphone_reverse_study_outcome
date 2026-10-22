package ig1;

import com.bytedance.android.livesdk.config.o1;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends e {
    @Override // ig1.b
    public final PublishSubject a() {
        return d(o1.f120874a.getValue().k(), TimeUnit.SECONDS);
    }

    public c() {
    }
}
