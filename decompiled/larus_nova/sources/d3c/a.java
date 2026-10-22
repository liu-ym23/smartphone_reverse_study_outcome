package d3c;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<iua.a<?>> f466768a = null;

    /* JADX INFO: renamed from: d3c.a$a, reason: collision with other inner class name */
    public static final class C5624a extends iua.a<Boolean> {

        /* JADX INFO: renamed from: d3c.a$a$a, reason: collision with other inner class name */
        public static final class C5625a {
        }

        static {
        }

        @Override // iua.a
        public final boolean isSticky() {
            return true;
        }

        @Override // iua.a
        public final iua.b getLarkExperimentInfo() {
            return new iua.b("enableFeedOptimize", "rust optimize A/B test");
        }

        public C5624a() {
        }

        @Override // iua.a
        public final Boolean getDefault() {
            return Boolean.TRUE;
        }
    }

    static {
        ArrayList r100 = new ArrayList();
        f466768a = r100;
        r100.add(new C5624a());
    }
}
