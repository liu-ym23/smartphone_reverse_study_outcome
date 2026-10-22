package web;

import com.ss.android.lark.abtest.api.ABTestExperimentPlugin;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
@ABTestExperimentPlugin
public final class c implements hua.a {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // hua.a
    public final String getBizName() {
        return "Feed";
    }

    @Override // hua.a
    public final List<iua.a<?>> a() {
        ArrayList r100 = new ArrayList();
        r100.addAll(b.f559447b);
        return r100;
    }
}
