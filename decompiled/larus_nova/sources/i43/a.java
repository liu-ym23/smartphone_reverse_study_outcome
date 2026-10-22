package i43;

import com.bytedance.android.shopping.base.event.EventActionImpl;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import l33.c;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends EventActionImpl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f488210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f488211d;

    public a(c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r101, "pageBtm");
        this.f488211d = r100;
        this.f488210c = new LinkedHashSet();
    }
}
