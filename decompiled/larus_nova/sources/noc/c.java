package noc;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<InterfaceC6954c> f519993i;

    public static class a implements npb.a {
        public a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final String getTag() {
            return "ByteBenchHandler";
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            return new HashSet(Collections.singletonList(b.f519994a));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f519994a = null;

        static {
            f519994a = new c();
        }
    }

    /* JADX INFO: renamed from: noc.c$c, reason: collision with other inner class name */
    public interface InterfaceC6954c {
        void a();
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "bytebench";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "ByteBenchHandler";
    }

    public c() {
        this.f519993i = new CopyOnWriteArrayList();
        AbstractBaseSettingHandler.a r100 = this.f431105d;
        r100.c(new noc.a(this));
        r100.b(new noc.b());
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f431107f = r100;
    }
}
