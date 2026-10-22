package wga;

import com.obric.assistant.spi.window.WindowOpenSource;

/* JADX INFO: loaded from: classes5.dex */
public interface b {
    void onScreenRotationChanged(int r100, int r101);

    void onWindowDismissed();

    void onWindowOpened(WindowOpenSource r100);

    void onWindowPreDismissed();

    void onWindowPreOpenClear();

    void onWindowPreOpened(WindowOpenSource r100);

    void onWindowPreStashed();

    void onWindowStashed();
}
