package com.larus.slides.impl.select;

import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
public interface s<UIState, UIEvent, UIAction> {
    void dispatchUIAction(UIAction r100);

    d1<UIEvent> getUiEvent();

    i1<UIState> getUiState();
}
