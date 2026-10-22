package com.ss.lark.android.avatar.plugin;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.lark.android.avatar.launcher.AvatarPreviewLauncher;
import com.ss.lark.android.avatar.ui.AvatarSource;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/lark/android/avatar/plugin/AvatarPluginManager;", "Landroidx/lifecycle/LifecycleObserver;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "source", "Lcom/ss/lark/android/avatar/ui/AvatarSource;", "previewMode", "Lcom/ss/lark/android/avatar/launcher/AvatarPreviewLauncher$PreviewMode;", "isDefaultAvatar", "", "dependency", "Lcom/ss/lark/android/avatar/plugin/AvatarPluginManager$IDependency;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/ss/lark/android/avatar/ui/AvatarSource;Lcom/ss/lark/android/avatar/launcher/AvatarPreviewLauncher$PreviewMode;ZLcom/ss/lark/android/avatar/plugin/AvatarPluginManager$IDependency;)V", "()Z", "setDefaultAvatar", "(Z)V", "pluginMap", "", "", "Lcom/ss/lark/android/avatar/plugin/IAvatarPlugin;", "registerPlugins", "", "unRegisterPlugins", "registerDefaultAvatarPlugin", "getAvatarPlugin", "pluginName", "Builder", "IDependency", "avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarPluginManager implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AvatarSource f456633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f456634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f456635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, i> f456636d;

    public interface a {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void unRegisterPlugins() {
        Iterator r100 = ((LinkedHashMap) this.f456636d).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((i) r100.next()).unRegister();
        goto L4
    L6:
        ((LinkedHashMap) this.f456636d).clear();
    }

    public AvatarPluginManager(WeakReference<Context> r100, AvatarSource r101, AvatarPreviewLauncher.PreviewMode r102, boolean r110, a r111) {
        Intrinsics.checkNotNullParameter(r100, "contextRef");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "previewMode");
        Intrinsics.checkNotNullParameter(r111, "dependency");
        this.f456633a = r101;
        this.f456634b = r110;
        this.f456635c = r111;
        LinkedHashMap r112 = new LinkedHashMap();
        this.f456636d = r112;
        Context r103 = r100.get();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r101 == AvatarSource.SELF_AVATAR) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        Context r105 = r103;
        if (r105 == null) goto L18;
        b r106 = new b(r105, this.f456633a, this.f456634b, new AvatarPluginManager$registerDefaultAvatarPlugin$2$defaultAvatarPlugin$1(this), new AvatarPluginManager$registerDefaultAvatarPlugin$2$defaultAvatarPlugin$2(this));
        r112.put(b.class.getName(), r106);
        return;
    L18:
        return;
    L7:
        if (r102 != AvatarPreviewLauncher.PreviewMode.CURRENT) goto L9;
        r104 = true;
        goto L10
    }
}
