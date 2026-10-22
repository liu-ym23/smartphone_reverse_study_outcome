package kib;

import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.template.ForwardCallType;
import com.ss.android.lark.forwardv2.dto.template.ForwardLocation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f503662a = 0;

    /* JADX INFO: renamed from: kib.a$a, reason: collision with other inner class name */
    public static final class C6560a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f503663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ForwardTarget> f503664b;

        /* JADX INFO: renamed from: kib.a$b$a, reason: collision with other inner class name */
        public static final class C6561a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<String> f503665a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<? extends ForwardTarget> f503666b;

            public C6561a() {
                this.f503665a = new ArrayList();
                this.f503666b = new ArrayList();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, List<String> r101, ForwardCallType r102, ForwardLocation r103, List<? extends ForwardTarget> r104) {
            Intrinsics.checkNotNullParameter(r104, "targets");
            this.f503663a = r101;
            this.f503664b = r104;
        }
    }

    static {
    }
}
