package y02;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends y02.b<EffectMessage> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<EffectMessage> f565566c;

    public static final class a {
    }

    public static final class b implements g<EffectMessage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<EffectMessage> f565567a;

        @Override // y02.g
        public final boolean hasNext() {
            return this.f565567a.hasNext();
        }

        @Override // y02.g
        public final EffectMessage next() {
            return this.f565567a.next();
        }

        @Override // y02.g
        public final void remove() {
            this.f565567a.remove();
        }

        public b(c r100) {
            this.f565567a = ((ArrayList) r100.f565566c).iterator();
        }
    }

    static {
    }

    @Override // y02.f
    public final int b() {
        return ((ArrayList) this.f565566c).size();
    }

    @Override // y02.f
    public final void clear() {
        ((ArrayList) this.f565566c).clear();
    }

    @Override // y02.f
    public final g<EffectMessage> iterator() {
        return new b(this);
    }

    @Override // y02.f
    public final Object pollFirst() {
        if (((ArrayList) this.f565566c).size() != 0) goto L6;
        return null;
    L6:
        return (EffectMessage) ListProtector.remove(this.f565566c, 0);
    }

    @Override // y02.f
    public final int size() {
        return ((ArrayList) this.f565566c).size();
    }

    public c() {
        this.f565566c = new ArrayList();
        Intrinsics.checkNotNullParameter("EffectMsgQueue", "<set-?>");
        this.f565565b = "EffectMsgQueue";
    }

    @Override // y02.f
    public final void a(Function1<? super EffectMessage, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Iterator r101 = ((ArrayList) this.f565566c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y02.f
    public final boolean d(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter((EffectMessage) r100, "msg");
        return false;
    }

    @Override // y02.f
    public final void put(Object r100) {
        EffectMessage r101 = (EffectMessage) r100;
        Intrinsics.checkNotNullParameter(r101, "msg");
        ((ArrayList) this.f565566c).add(r101);
        e();
    }

    @Override // y02.f
    public final void putFirst(Object r100) {
        EffectMessage r101 = (EffectMessage) r100;
        Intrinsics.checkNotNullParameter(r101, "msg");
        ListProtector.add(this.f565566c, 0, r101);
        e();
    }
}
