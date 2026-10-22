package d3c;

import com.ss.android.lark.abtest.api.ABTestExperimentPlugin;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
@ABTestExperimentPlugin
public final class c implements hua.a {
    public c() {
    }

    @Override // hua.a
    public final String getBizName() {
        return "Rust";
    }

    @Override // hua.a
    public final List<iua.a<?>> a() {
        return Collections.unmodifiableList(a.f466768a);
    }
}
