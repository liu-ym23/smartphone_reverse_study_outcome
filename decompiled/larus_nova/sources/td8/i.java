package td8;

import com.larus.bmhome.chat.component.list.ChatMessageListUpdateObserver;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Set<ChatMessageListUpdateObserver>> f545527c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f545528d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f545529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f545530b;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((td8.b) r100).stage().getOrder()), Integer.valueOf(((td8.b) r101).stage().getOrder()));
        }
    }

    static {
        new a();
        f545527c = LazyKt.lazy(new h());
        f545528d = new AtomicLong();
    }

    public i(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f545529a = r100;
        this.f545530b = LazyKt.lazy(new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [td8.g] */
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(final com.larus.bmhome.social.page.datasource.event.c<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Iterator r100 = ((List) this.f545530b.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        td8.b r101 = (td8.b) r100.next();
        r101.b();
        r110 = r101.a(r110);
        goto L4
    L7:
        if (f545527c.getValue().isEmpty() == true) goto L70;
        Long r102 = Long.valueOf(this.f545529a.b());
        if (r102.longValue() == 0) goto L12;
        boolean r103 = true;
    L13:
        Object r104 = null;
        if (r103 == true) goto L17;
        r102 = null;
    L17:
        if (r102 == null) goto L19;
        String r105 = "chat:" + r102.longValue();
    L59:
        final Lazy r106 = LazyKt.lazy(new f(r110));
        Iterator<T> r107 = f545527c.getValue().iterator();
    L61:
        if (r107.hasNext() == false) goto L70;
        ChatMessageListUpdateObserver r108 = (ChatMessageListUpdateObserver) r107.next();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L65
        r108.b(r105, new g(r106));     // Catch: Throwable -> L65
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L65
    L67:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L61;
        FLogger.f375446a.e("Pipeline", "notify message list observer failed, observer=".concat(r108.getClass().getSimpleName()), r112);
    L65:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L67
    L19:
        Long r114 = Long.valueOf(this.f545529a.o());
        if (r114.longValue() <= 0) goto L22;
        boolean r115 = true;
    L23:
        if (r115 == true) goto L26;
        r114 = null;
    L26:
        if (r114 == null) goto L28;
        r105 = "session:" + r114.longValue();
        goto L59
    L28:
        wc9.e r116 = this.f545529a.g();
        if (r116 == null) goto L38;
        String r117 = r116.f559198a;
        if (r117 == null) goto L38;
        if ((!StringsKt.isBlank(r117)) == true) goto L36;
        r117 = null;
    L36:
        if (r117 == null) goto L38;
        r105 = "conversation:".concat(r117);
    L38:
        Iterator<T> r118 = r110.f314033a.iterator();
    L40:
        if (r118.hasNext() == false) goto L51;
        Object r119 = r118.next();
        String r120 = ((xc8.b) r119).getMessage().getConversationId();
        if (r120 != null) goto L44;
    L47:
        boolean r121 = true;
    L49:
        if ((!r121) == false) goto L40;
        r104 = r119;
        goto L51
    L44:
        if (StringsKt.isBlank(r120) == true) goto L47;
        r121 = false;
    L51:
        xc8.b r122 = (xc8.b) r104;
        if (r122 == null) goto L58;
        Message r123 = r122.getMessage();
        if (r123 == null) goto L58;
        String r124 = r123.getConversationId();
        if (r124 == null) goto L58;
        r105 = "message:".concat(r124);
    L58:
        r105 = "update:" + f545528d.incrementAndGet();
        goto L59
    L22:
        r115 = false;
        goto L23
    L12:
        r103 = false;
    L70:
        return r110;
    }
}
