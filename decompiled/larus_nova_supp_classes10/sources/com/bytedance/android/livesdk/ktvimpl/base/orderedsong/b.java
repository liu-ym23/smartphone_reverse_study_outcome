package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ Disposable a(OrderedSongDataContext r0, boolean r1, Consumer r2, int r3) {
            if ((r3 & 2) == 0) goto L6;
            r1 = false;
        L6:
            return r0.observerKtvSingSongListChange(null, r1, r2);
        }
    }

    Disposable observerKtvSingSongListChange(LifecycleOwner r1, boolean r2, Consumer<List<MusicPanel>> r3);
}
