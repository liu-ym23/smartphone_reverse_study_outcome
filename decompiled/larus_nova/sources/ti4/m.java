package ti4;

import androidx.lifecycle.LiveData;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import com.bytedance.creativex.mediaimport.view.internal.MultiSelectStrategy;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes15.dex */
public interface m<DATA> {
    void addConfirmValidator(b<DATA> r100);

    void addPostSelectValidator(z<DATA> r100);

    void addPreSelectValidator(a0<DATA> r100);

    void cancel(DATA r100);

    Flow<Integer> cancelMultiple(List<? extends DATA> r100);

    void changeSelectState(DATA r100, MaterialSelectedState r101);

    LiveData<Boolean> getConfirmEnable();

    LiveData<c0> getListUIUpdate();

    LiveData<Pair<MultiSelectStrategy, MultiSelectStrategy>> getMultiSelectStrategyChanged();

    boolean getPreselected(DATA r100);

    int getSelectIndex(DATA r100);

    MaterialSelectedState getSelectState(DATA r100);

    boolean getSelectable(DATA r100);

    LiveData<List<DATA>> getSelectedMaterials();

    LiveData<Pair<List<DATA>, MaterialSelectedState>> getSelectionChanged();

    int getSelectionScrollPosition();

    boolean getSupportMultiSelect(DATA r100);

    void moveSelection(int r100, int r101, boolean r102, boolean r103);

    Observable<a<DATA>> observeSelectionConfirmed();

    Observable<Pair<List<DATA>, Boolean>> observeSelectionMultiConfirmed();

    void preCheckValid(DATA r100, boolean r101, Function1<? super Boolean, Unit> r102);

    void requestConfirm(String r100);

    LiveData<Boolean> selectDisabledEvent(ki4.a0 r100);

    LiveData<List<DATA>> selectListChangedEvent(ki4.a0 r100);

    Flow<Integer> selectMultiple(List<? extends DATA> r100);

    void selectSingle(DATA r100);
}
