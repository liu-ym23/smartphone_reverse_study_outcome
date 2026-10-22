package uu8;

import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
public interface b<UIState, UIEvent, UIAction> {
    void dispatchUIAction(UIAction r100);

    d1<UIEvent> getUiEvent();

    i1<UIState> getUiState();
}
