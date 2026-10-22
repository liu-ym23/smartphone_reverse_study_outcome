package qkb;

import com.ss.android.lark.abtest.api.ABTestExperimentPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
@ABTestExperimentPlugin
public final class c implements hua.a {
    public c() {
    }

    @Override // hua.a
    public final String getBizName() {
        return "LarkImage";
    }

    @Override // hua.a
    public final List<iua.a<?>> a() {
        return CollectionsKt.toMutableList(b.f533691c);
    }
}
