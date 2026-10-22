package com.bytedance.ee.plugin.common.ttpdfreader;

import android.os.Bundle;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface IReaderSelectionClient {
    View getLeftIndicator();

    View getPopupMenu();

    View getRightIndicator();

    void onSelectionChanged(List<TTReaderSelectionInfo> r100, Bundle r101);
}
