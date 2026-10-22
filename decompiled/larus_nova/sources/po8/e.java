package po8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements fh8.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f530105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DeepThinkFoldStatus f530106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function1<DeepThinkFoldStatus, Unit>> f530107c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f530108a = null;

        static {
            int[] r100 = new int[DeepThinkFoldStatus.values().length];
            r100[DeepThinkFoldStatus.HalfFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DeepThinkFoldStatus.CompleteFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f530108a = r100;
        }
    }

    @Override // fh8.d
    public final DeepThinkFoldStatus a() {
        DeepThinkFoldStatus r100 = this.f530106b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return DeepThinkFoldStatus.CompleteExpand;
    }

    @Override // fh8.d
    public final boolean b() {
        if (this.f530106b != DeepThinkFoldStatus.HalfFold) goto L5;
        return true;
    L5:
        return false;
    }

    public e() {
        this.f530105a = LazyKt.lazy(new d());
        this.f530107c = new ArrayList();
    }

    public final void c(DeepThinkFoldStatus r100) {
        DeepThinkFoldStatus r101 = this.f530106b;
        this.f530106b = r100;
        if (r101 == r100) goto L9;
        if (r101 == null) goto L11;
        Iterator r102 = ((ArrayList) this.f530107c).iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        ((Function1) r102.next()).invoke(r100);
        goto L7
    L12:
        return;
    L11:
        return;
    }
}
