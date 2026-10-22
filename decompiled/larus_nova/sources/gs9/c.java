package gs9;

import com.larus.profile.api.bean.UserCreationModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f482461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function4<Integer, String, Boolean, List<UserCreationModel>, Unit> f482462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f482463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f482464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f482465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f482466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f482467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f482468h;

    public c(Function0 r100, int r101, String r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "dismissCallback");
        Intrinsics.checkNotNullParameter("", "initCursor");
        Intrinsics.checkNotNullParameter(r102, "visitId");
        this.f482461a = r100;
        this.f482462b = null;
        this.f482463c = r101;
        this.f482464d = "";
        this.f482465e = false;
        this.f482466f = r102;
        this.f482467g = r103;
        this.f482468h = r104;
    }
}
