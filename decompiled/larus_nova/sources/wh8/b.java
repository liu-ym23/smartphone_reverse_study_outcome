package wh8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface b {

    public static final class a {
        public static void a(List r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            Intrinsics.checkNotNullParameter(r101, "changedConversations");
            Intrinsics.checkNotNullParameter("IMConversationUpdate", "source");
        }
    }

    void IJ(int r100);

    void R70(List r100, List r101);

    void Yo(List<wh8.a> r100);
}
