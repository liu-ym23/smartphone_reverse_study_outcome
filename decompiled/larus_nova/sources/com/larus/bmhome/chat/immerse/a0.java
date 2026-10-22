package com.larus.bmhome.chat.immerse;

import android.animation.AnimatorSet;
import com.bytedance.keva.Keva;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusPageChatImmersiveBinding f303254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatorSet f303255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Keva f303256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f303257d;

    public static final class a {
    }

    static {
    }

    public a0(LarusPageChatImmersiveBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        this.f303254a = r100;
        this.f303255b = new AnimatorSet();
        this.f303256c = Keva.getRepo("immers", 0);
    }
}
