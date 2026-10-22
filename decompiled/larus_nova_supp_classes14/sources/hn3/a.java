package hn3;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Type a = null;
    public static final Type b = null;
    public static final Type c = null;

    /* JADX INFO: renamed from: hn3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"hn3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0132a extends TypeToken<List<? extends String>> {
        public C0132a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"hn3/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"hn3/a$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c extends TypeToken<List<? extends String>> {
        public c() {
        }
    }

    static {
        Type r0 = new c().getType();
        Intrinsics.checkNotNull(r0);
        a = r0;
        Type r1 = new C0132a().getType();
        Intrinsics.checkNotNull(r1);
        b = r1;
        Type r2 = new b().getType();
        Intrinsics.checkNotNull(r2);
        c = r2;
    }
}
