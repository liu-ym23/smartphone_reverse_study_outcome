package com.bytedance.awemeopen.apps.framework.feed.ui.seekbar;

import android.widget.SeekBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface d {

    public interface a {
        void a();

        void b(SeekBar r1, boolean r2);

        void onProgressChanged(int r1);
    }

    void a();

    void addSeekBarChangeListener(a r1);

    void b();

    boolean c();

    void removeSeekBarChangeListener(a r1);
}
