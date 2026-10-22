package com.bytedance.awemeopen.apps.framework.feed.ui.seekbar;

import android.widget.SeekBar;

/* JADX INFO: loaded from: classes14.dex */
public interface d {

    public interface a {
        void a();

        void b(SeekBar r100, boolean r101);

        void onProgressChanged(int r100);
    }

    void a();

    void addSeekBarChangeListener(a r100);

    void b();

    boolean c();

    void removeSeekBarChangeListener(a r100);
}
