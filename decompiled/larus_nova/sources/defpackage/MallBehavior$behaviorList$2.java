package defpackage;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.behavior.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/lynx/tasm/behavior/a;", AbsMethodDelegate.TAG_INVOKE, "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class MallBehavior$behaviorList$2 extends Lambda implements Function0<List<a>> {
    public static final MallBehavior$behaviorList$2 INSTANCE = null;

    static {
        INSTANCE = new MallBehavior$behaviorList$2();
    }

    public MallBehavior$behaviorList$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<a> invoke2() {
        return new ArrayList();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<a> invoke() {
        return invoke2();
    }
}
