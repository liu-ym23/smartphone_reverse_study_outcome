package m38;

import com.larus.account.base.model.AccountStatus;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import n38.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<j> f511794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static n38.a f511795b;

    /* JADX INFO: loaded from: classes3.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f511796a = null;

        static {
            int[] r100 = new int[AccountStatus.values().length];
            r100[AccountStatus.LOGGED_IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AccountStatus.LOGGED_OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f511796a = r100;
        }
    }

    static {
        f511794a = new CopyOnWriteArrayList();
    }
}
