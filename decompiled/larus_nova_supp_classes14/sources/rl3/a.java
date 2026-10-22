package rl3;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.cache.LruCache;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Type a = null;
    public static final Type b = null;
    public static final Type c = null;
    public static final Type d = null;
    public static final Type e = null;
    public static final Type f = null;
    public static final Type g = null;
    public static final Type h = null;
    public static final Type i = null;
    public static final Type j = null;
    public static final Type k = null;
    public static final Type l = null;

    /* JADX INFO: renamed from: rl3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"rl3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0163a extends TypeToken<Map<String, List<? extends String>>> {
        public C0163a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c extends TypeToken<Map<String, ? extends String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$d", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d extends TypeToken<Map<String, ? extends String>> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$e", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e extends TypeToken<Map<String, ? extends String>> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$f", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f extends TypeToken<Map<String, ? extends String>> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"rl3/a$g", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/core/cache/LruCache;", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class g extends TypeToken<LruCache<String, Boolean>> {
        public g() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$h", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/core/cache/LruCache;", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class h extends TypeToken<LruCache<String, String>> {
        public h() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"rl3/a$i", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/core/cache/LruCache;", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class i extends TypeToken<LruCache<String, Boolean>> {
        public i() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$j", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/core/cache/LruCache;", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class j extends TypeToken<LruCache<String, String>> {
        public j() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rl3/a$k", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class k extends TypeToken<HashMap<String, String>> {
        public k() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"rl3/a$l", "Lcom/google/gson/reflect/TypeToken;", "Lkotlin/Pair;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class l extends TypeToken<Pair<? extends String, ? extends IBaseUser>> {
        public l() {
        }
    }

    static {
        Type r0 = new C0163a().getType();
        Intrinsics.checkNotNull(r0);
        a = r0;
        Type r1 = new c().getType();
        Intrinsics.checkNotNull(r1);
        b = r1;
        Type r2 = new l().getType();
        Intrinsics.checkNotNull(r2);
        c = r2;
        Type r3 = new k().getType();
        Intrinsics.checkNotNull(r3);
        d = r3;
        Type r4 = new b().getType();
        Intrinsics.checkNotNull(r4);
        e = r4;
        Type r5 = new j().getType();
        Intrinsics.checkNotNull(r5);
        f = r5;
        Type r6 = new f().getType();
        Intrinsics.checkNotNull(r6);
        g = r6;
        Type r7 = new i().getType();
        Intrinsics.checkNotNull(r7);
        h = r7;
        Type r8 = new h().getType();
        Intrinsics.checkNotNull(r8);
        i = r8;
        Type r9 = new d().getType();
        Intrinsics.checkNotNull(r9);
        j = r9;
        Type r10 = new e().getType();
        Intrinsics.checkNotNull(r10);
        k = r10;
        Type r11 = new g().getType();
        Intrinsics.checkNotNull(r11);
        l = r11;
    }
}
