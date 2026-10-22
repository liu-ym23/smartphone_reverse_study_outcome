package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/KtvModeOrderedSongDataContext;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvModeOrderedSongDataContext extends OrderedSongDataContext {
    public static final a Companion = null;
    public static final String TAG = "KtvModeOrderedSongDataContext";

    public static final class a {
        @JvmStatic
        public final KtvModeOrderedSongDataContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(KtvModeOrderedSongDataContext.class);
            if ((r0 instanceof KtvModeOrderedSongDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (KtvModeOrderedSongDataContext) r0;
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final KtvModeOrderedSongDataContext getContext() {
        return Companion.getContext();
    }

    public KtvModeOrderedSongDataContext() {
    }
}
