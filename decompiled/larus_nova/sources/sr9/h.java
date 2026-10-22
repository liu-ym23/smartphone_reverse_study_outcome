package sr9;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class h implements com.larus.bmhome.instruction.helper.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f543242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function1<? super Uri, Unit> f543243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function1<? super List<? extends Uri>, Unit> f543244c;

    static {
        f543242a = new h();
    }

    public h() {
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void onDestroy() {
        f543243b = null;
        f543244c = null;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void b(Function1<? super Uri, Unit> r100) {
        f543243b = r100;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void c(Function1<? super List<? extends Uri>, Unit> r100) {
        f543244c = r100;
    }

    @Override // com.larus.bmhome.instruction.helper.f
    public final void a(FragmentActivity r100, boolean r101, int r102) {
        Function1<? super Uri, Unit> r103 = f543243b;
        if (r103 == null) goto L5;
        r103.invoke(null);
    L5:
        Function1<? super List<? extends Uri>, Unit> r104 = f543244c;
        if (r104 == null) goto L9;
        r104.invoke(CollectionsKt.emptyList());
        return;
    }
}
