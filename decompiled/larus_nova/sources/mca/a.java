package mca;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a<T extends AppEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f513249a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "wrapped");
        this.f513249a = r100;
    }
}
