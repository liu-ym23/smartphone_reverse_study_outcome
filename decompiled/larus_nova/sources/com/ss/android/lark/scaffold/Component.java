package com.ss.android.lark.scaffold;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.framework.larkwidget.Widget;
import com.ss.android.lark.framework.larkwidget.c;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0017J\u001c\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0014J)\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0017¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0007J'\u0010\u0011\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\bH\u0017¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0011\u001a\u0004\u0018\u0001H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/scaffold/Component;", "Lcom/ss/android/lark/framework/larkwidget/Widget;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/lark/scaffold/IComponent;", "<init>", "()V", "provideWidgetExport", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "provideComponents", "getWidgetExport", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "getSharedData", "Lcom/ss/android/lark/framework/larkwidget/WidgetSharedData;", "getComponent", "(Ljava/lang/Class;)Lcom/ss/android/lark/scaffold/IComponent;", "()Lcom/ss/android/lark/scaffold/IComponent;", "getFragment", "Landroidx/fragment/app/Fragment;", "requireFragment", "scaffold_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Component extends Widget implements IComponent {
    @Override // com.ss.android.lark.framework.larkwidget.Widget
    @Deprecated(level = DeprecationLevel.WARNING, message = "Replace with componentExports()", replaceWith = @ReplaceWith(expression = "provideComponent()", imports = {}))
    public Map<Class<? extends c>, c> z0() {
        return MapsKt.toMap(MapsKt.emptyMap());
    }

    public Component() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Replace with dependency injection")
    public final <T extends IComponent> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) super.u0(r100);
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    @Deprecated(level = DeprecationLevel.WARNING, message = "Replace with dependency injection")
    public final <T extends c> T u0(Class<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) super.u0(r100);
    }
}
