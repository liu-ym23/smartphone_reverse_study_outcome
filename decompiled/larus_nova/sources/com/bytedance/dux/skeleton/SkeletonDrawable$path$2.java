package com.bytedance.dux.skeleton;

import android.graphics.Path;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Path;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SkeletonDrawable$path$2 extends Lambda implements Function0<Path> {
    public static final SkeletonDrawable$path$2 INSTANCE = null;

    static {
        INSTANCE = new SkeletonDrawable$path$2();
    }

    public SkeletonDrawable$path$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Path invoke() {
        return new Path();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Path invoke() {
        return invoke();
    }
}
