package ki4;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes15.dex */
public interface p<DATA, CURSOR> {
    Observable<Pair<CURSOR, List<DATA>>> a(int r100, CURSOR r101);
}
