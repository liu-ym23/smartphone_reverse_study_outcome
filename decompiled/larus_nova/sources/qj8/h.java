package qj8;

import com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.FlowMarkdownCodeView;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowMarkdownCodeView f533390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f533391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a f533392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Boolean f533393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Long f533394e;

    public /* synthetic */ h(FlowMarkdownCodeView r100, m r101, com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a r102, Boolean r103, Long r104) {
        this.f533390a = r100;
        this.f533391b = r101;
        this.f533392c = r102;
        this.f533393d = r103;
        this.f533394e = r104;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        final FlowMarkdownCodeView r100 = this.f533390a;
        final m r101 = this.f533391b;
        final com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a r102 = this.f533392c;
        final Boolean r103 = this.f533393d;
        final Long r104 = this.f533394e;
        ki9.b r111 = (ki9.b) r110;
        int r105 = FlowMarkdownCodeView.f308980g;
        Intrinsics.checkNotNullParameter(r111, "$this$exposeX");
        Function0<String> r106 = new j(r100, r101);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r106, "cellId");
        r111.f503656a = r106;
        r111.a(CollectionsKt.listOf(new Integer[]{0, 1, 2}));
        r111.f503658c = 0.5f;
        r111.f503660e = true;
        Function0<Unit> r107 = new k(r100, r101, r102, r103, r104);
        Intrinsics.checkNotNullParameter(r107, "block");
        r111.f503657b = r107;
        return Unit.INSTANCE;
    }
}
