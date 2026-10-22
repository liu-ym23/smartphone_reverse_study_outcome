package r61;

import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: classes47.dex */
public interface b {
    t61.a b();

    void c(t61.a r100);

    void dismiss();

    DataCenter getDataCenter();

    o getRoomContext();

    void hide();

    void i(t71.a r100);

    g<c> j();

    boolean o();

    void show();

    void t(g<? extends c> r100);

    Collection<t71.a> u();

    Disposable x(long r100);
}
