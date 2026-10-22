package j76;

import com.airbnb.lottie.LottieComposition;
import com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class i implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f497602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.airbnb.lottie.g f497603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LottieComposition f497604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LynxBytedLottieView f497605d;

    public /* synthetic */ i(ReadableMap r100, q r101, LottieComposition r102, LynxBytedLottieView r103) {
        this.f497602a = r100;
        this.f497603b = r101;
        this.f497604c = r102;
        this.f497605d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        ReadableMap r100 = this.f497602a;
        com.airbnb.lottie.g r110 = this.f497603b;
        LottieComposition r111 = this.f497604c;
        LynxBytedLottieView r112 = this.f497605d;
        int r101 = LynxBytedLottieView.C;
        Intrinsics.checkNotNullParameter(r100, "$map");
        Intrinsics.checkNotNullParameter(r110, "$callback");
        Intrinsics.checkNotNullParameter(r111, "$composition");
        Intrinsics.checkNotNullParameter(r112, "this$0");
        ReadableMapKeySetIterator r113 = r100.keySetIterator();
        HashMap r114 = new HashMap();
        if (r100.size() != 0) goto L5;
        r110.onSuccess("");
        return new com.airbnb.lottie.l("");
    L5:
        AtomicInteger r102 = new AtomicInteger(r100.size());
    L7:
        if (r113.hasNextKey() == false) goto L13;
        String r103 = r113.nextKey();
        String r104 = r100.getString(r103);
        com.airbnb.lottie.h r105 = r111.getImages().get(r103);
        if (r105 == null) goto L7;
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        ?? r107 = r105.f24782e + r104;
        r106.element = r107;
        r112.Y(r112.W(r107), r103, r105, new p(r114, r102, r110, r111, r112, r100, r106));
        r113 = r113;
        r110 = r110;
        r111 = r111;
        r102 = r102;
        goto L7
    L13:
        return new com.airbnb.lottie.l("");
    }
}
