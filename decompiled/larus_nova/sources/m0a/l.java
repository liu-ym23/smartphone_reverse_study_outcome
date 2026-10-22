package m0a;

import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
public interface l {
    Object a(int r100, String r101, Long r102, String r103, Continuation<? super Pair<CommonCreationFeedDataKmp, ? extends j<Unit>>> r104);

    CreationFeedCacheEntityKmp b();

    Object c(CreationFeedCacheEntityKmp r100, Continuation<? super Unit> r101);
}
