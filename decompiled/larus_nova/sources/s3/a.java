package s3;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.datamanager.StorageInputParam;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import e3.d;
import k2.j;
import kotlin.jvm.internal.Intrinsics;
import u4.b;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: s3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7560a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f540421a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f540421a = r100;
        }
    }

    public static final u4.a a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        a0 r101 = r100.getContainerContext();
        if (r101 == null) goto L5;
        ContainerType r102 = r101.getContainerType();
    L6:
        if (r102 != null) goto L8;
        int r103 = -1;
    L10:
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L20;
        return null;
    L20:
        return (u4.a) r100.d(j.class);
    L21:
        return (u4.a) r100.d(WidgetContainer.class);
    L19:
        return (u4.a) r100.d(AppletRuntime.class);
    L8:
        r103 = C7560a.f540421a[r102.ordinal()];
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static final b b(d r100, StorageInputParam r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        u4.a r102 = a(r100);
        g r103 = g.f37637a;
        r103.d("AbsAIStorageMethod", "dataManager " + r102);
        if (r102 == null) goto L5;
        a6.a r104 = r102.getViewModel(r101.isShared(), r101.getGroupId());
    L6:
        r103.d("AbsAIStorageMethod", "viewModel " + r104);
        if (r104 != null) goto L9;
        return null;
    L9:
        return r104.getIStorage();
    L5:
        r104 = null;
        goto L6
    }
}
