package vh7;

import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public interface g {

    public static class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Logger f554985a;

        public a() {
            this.f554985a = Logger.getLogger("ModelX");
        }

        @Override // vh7.g
        public void error(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f554985a.log(Level.SEVERE, r100);
        }
    }

    void error(String r100);
}
