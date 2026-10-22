package r42;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f536043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f536044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t> f536045c;

    public abstract boolean a();

    public abstract void b(vlc.d r100, aa2.e r101);

    public i(IRoom r100) {
        this.f536043a = g.d();
        this.f536045c = new ArrayList();
        if (r100 == null) goto L7;
        IRoomAuthStatus r101 = r100.getRoomAuthStatus();
        if (r101 == null) goto L7;
        r101.isEnableFirstFetchHistory();
    L7:
        if (r100 == null) goto L12;
        IRoomAuthStatus r102 = r100.getRoomAuthStatus();
        if (r102 == null) goto L13;
        r102.isEnableLoadMoreHistory();
        return;
    L13:
        return;
    }
}
