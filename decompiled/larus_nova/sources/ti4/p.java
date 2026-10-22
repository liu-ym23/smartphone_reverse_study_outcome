package ti4;

import androidx.lifecycle.LiveData;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;

/* JADX INFO: loaded from: classes15.dex */
public interface p<DATA> extends o<DATA> {
    void changeToDefaultFolder();

    DATA getFolder(ki4.a r100);

    LiveData<Pair<DATA, Integer>> getSelectedFolder();

    LiveData<Map<ki4.a0, Class<? extends ki4.m>>> getSelectedGroupStrategies();

    Observable<Triple<DATA, Integer, Boolean>> observeFolderUpdated();

    void selectFolder(Pair<? extends DATA, Integer> r100);

    void updateFolder(String r100, ki4.a0 r101, ki4.r r102);
}
