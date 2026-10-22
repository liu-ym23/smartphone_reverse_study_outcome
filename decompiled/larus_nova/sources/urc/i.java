package urc;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.VariableType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f551409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f551410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Pair<VariableType, Object>> f551411d;

    public i(String r100, List r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "parameters");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        this.f551408a = r100;
        this.f551409b = r101;
        this.f551410c = r102;
        this.f551411d = new LinkedHashMap();
    }
}
