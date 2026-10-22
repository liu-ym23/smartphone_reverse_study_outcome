package q8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.handler.MatchRegulate;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f532051a = null;

        static {
            int[] r100 = new int[MatchRegulate.values().length];
            r100[MatchRegulate.ACCURATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MatchRegulate.ANY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MatchRegulate.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f532051a = r100;
        }
    }

    boolean b(DecisionData.Action r100);

    List<i> getRules();
}
