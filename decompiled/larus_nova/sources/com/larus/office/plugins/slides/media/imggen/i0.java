package com.larus.office.plugins.slides.media.imggen;

import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes30.dex */
public interface i0<UIState, UIEvent, UIAction> {
    void dispatchUIAction(UIAction r100);

    d1<UIEvent> getUiEvent();

    i1<UIState> getUiState();
}
