package v19;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class s6 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f552610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.utils.n0 f552611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f552612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f552613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function2 f552614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function2 f552615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Set f552616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f552617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Function2 f552618i;

    public /* synthetic */ s6(RecyclerView r100, com.larus.utils.n0 r101, float r102, boolean r103, Function2 r104, Function2 r105, Set r106, boolean r107, Function2 r108) {
        this.f552610a = r100;
        this.f552611b = r101;
        this.f552612c = r102;
        this.f552613d = r103;
        this.f552614e = r104;
        this.f552615f = r105;
        this.f552616g = r106;
        this.f552617h = r107;
        this.f552618i = r108;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        RecyclerView r100 = this.f552610a;
        com.larus.utils.n0 r101 = this.f552611b;
        float r102 = this.f552612c;
        boolean r103 = this.f552613d;
        final Function2 r104 = this.f552614e;
        final Function2 r105 = this.f552615f;
        final Set r106 = this.f552616g;
        final boolean r107 = this.f552617h;
        final Function2 r108 = this.f552618i;
        y6.b(r100, r101, r102, r103, new m6(r104, r105, r106, r107, r108));
        return Unit.INSTANCE;
    }
}
