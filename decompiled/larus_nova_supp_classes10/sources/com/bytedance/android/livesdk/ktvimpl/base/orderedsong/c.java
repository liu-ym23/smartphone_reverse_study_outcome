package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ Disposable a(OrderedSongDataContext r0, LifecycleOwner r1, Consumer r2, int r3) {
            if ((r3 & 1) == 0) goto L6;
            r1 = null;
        L6:
            return r0.observerKtvSongUniqueInfoListChange(r1, false, r2);
        }
    }

    Disposable observerKtvSongUniqueInfoListChange(LifecycleOwner r1, boolean r2, Consumer<List<SongUniqueInfo>> r3);
}
