package zp9;

import com.larus.platform.api.creation.CreationFeedCacheEntity;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
public interface n {

    public static final class a {
        public static /* synthetic */ Object a(n r100, Long r101, Continuation r102) {
            return r100.a(1, null, r101, null, r102);
        }
    }

    Object a(int r100, String r101, Long r102, String r103, Continuation<? super Pair<c, ? extends dm9.a<?>>> r104);

    CreationFeedCacheEntity b();
}
