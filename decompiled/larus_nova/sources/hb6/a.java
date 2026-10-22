package hb6;

import androidx.compose.foundation.ComposeFoundationFlags;
import com.bytedance.kmp.launcher.KmpLaunchStage;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {
    public a() {
    }

    @Override // hb6.b
    public final void run() {
        ComposeFoundationFlags.isPausableCompositionInPrefetchEnabled = true;
        com.larus.im.internal.delegate.a.f348188b.i("ComposeInitTask", "do compose init");
    }

    @Override // hb6.b
    public final KmpLaunchStage a() {
        return KmpLaunchStage.IMMEDIATE;
    }
}
