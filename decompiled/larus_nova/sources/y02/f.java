package y02;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface f<T> {
    void a(Function1<? super T, Unit> r100);

    int b();

    void c(com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a r100);

    void clear();

    boolean d(NormalGiftMessage r100);

    g<T> iterator();

    T pollFirst();

    void put(T r100);

    void putFirst(T r100);

    int size();
}
