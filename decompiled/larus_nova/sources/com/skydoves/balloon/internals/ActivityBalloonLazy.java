package com.skydoves.balloon.internals;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/skydoves/balloon/internals/ActivityBalloonLazy;", "Lcom/skydoves/balloon/Balloon$b;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Lazy;", "Lcom/skydoves/balloon/Balloon;", "Ljava/io/Serializable;", "", "isInitialized", "", "toString", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/reflect/KClass;", "factory", "Lkotlin/reflect/KClass;", "cached", "Lcom/skydoves/balloon/Balloon;", "getValue", "()Lcom/skydoves/balloon/Balloon;", "value", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lkotlin/reflect/KClass;)V", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final class ActivityBalloonLazy<T extends Balloon.b> implements Lazy<Balloon>, Serializable {
    private Balloon cached;
    private final Context context;
    private final KClass<T> factory;
    private final LifecycleOwner lifecycleOwner;

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.skydoves.balloon.internals.ActivityBalloonLazy$value$factory$1] */
    @Override // kotlin.Lazy
    public Balloon getValue() {
        Balloon r100 = this.cached;
        if (r100 != null) goto L6;
        final KClass<T> r101 = this.factory;
        Balloon r102 = ((Balloon.b) ((Class) new ActivityBalloonLazy$value$factory$1(r101).get()).newInstance()).a();
        this.cached = r102;
        return r102;
    L6:
        return r100;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.cached == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isInitialized() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return getValue().toString();
    }

    @Override // kotlin.Lazy
    public /* bridge */ /* synthetic */ Balloon getValue() {
        return getValue();
    }

    public ActivityBalloonLazy(Context r100, LifecycleOwner r101, KClass<T> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "factory");
        this.context = r100;
        this.lifecycleOwner = r101;
        this.factory = r102;
    }
}
