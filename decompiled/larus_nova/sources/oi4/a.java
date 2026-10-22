package oi4;

import com.bytedance.jedi.model.keyless.SimpleSingleFetcher;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.List;
import ki4.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends SimpleSingleFetcher<List<? extends z>> implements ki4.o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<z> f523389b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends z> r100) {
        Intrinsics.checkNotNullParameter(r100, ReportCardMonitorPlugin.CATEGORIES);
        this.f523389b = r100;
    }
}
