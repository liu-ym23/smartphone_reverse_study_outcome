package ms0;

import com.bytedance.android.live.preinit.setting.LiveSettingManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f515460a = null;

    static {
        f515460a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        Function1<Boolean, Unit> r102 = LiveSettingManager.INSTANCE.getSETTING_CALLBACK();
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(Boolean.TRUE);
        return;
    }
}
