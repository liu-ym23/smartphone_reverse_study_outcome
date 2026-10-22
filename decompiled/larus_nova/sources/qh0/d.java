package qh0;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;

/* JADX INFO: loaded from: classes46.dex */
public interface d<T> {

    public static final class a {
        public static /* synthetic */ void a(d r100) {
            r100.onResult(null);
        }
    }

    void b(BaseCheckException r100);

    void onResult(T r100);
}
