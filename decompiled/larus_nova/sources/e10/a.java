package e10;

import com.bytedance.android.live.broadcastgame.api.model.l;
import e10.a.C5727a;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface a<DATA extends l, FILTER_CONTEXT extends C5727a> {

    /* JADX INFO: renamed from: e10.a$a, reason: collision with other inner class name */
    public static class C5727a {
        public C5727a() {
        }
    }

    List<DATA> filter(List<? extends DATA> r100);
}
