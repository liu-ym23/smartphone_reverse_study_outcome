package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    Disposable observerKtvOrderedSongListChange(LifecycleOwner r1, boolean r2, Consumer<List<MusicPanel>> r3);
}
