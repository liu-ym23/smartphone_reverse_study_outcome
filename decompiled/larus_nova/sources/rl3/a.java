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

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f538457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type f538458b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Type f538459c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Type f538460d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Type f538461e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Type f538462f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Type f538463g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Type f538464h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Type f538465i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Type f538466j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Type f538467k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Type f538468l = null;

    /* JADX INFO: renamed from: rl3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"rl3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C7500a extends TypeToken<Map<String, List<? extends String>>> {
        public C7500a() {
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
        Type r100 = new C7500a().getType();
        Intrinsics.checkNotNull(r100);
        f538457a = r100;
        Type r101 = new c().getType();
        Intrinsics.checkNotNull(r101);
        f538458b = r101;
        Type r102 = new l().getType();
        Intrinsics.checkNotNull(r102);
        f538459c = r102;
        Type r103 = new k().getType();
        Intrinsics.checkNotNull(r103);
        f538460d = r103;
        Type r104 = new b().getType();
        Intrinsics.checkNotNull(r104);
        f538461e = r104;
        Type r105 = new j().getType();
        Intrinsics.checkNotNull(r105);
        f538462f = r105;
        Type r106 = new f().getType();
        Intrinsics.checkNotNull(r106);
        f538463g = r106;
        Type r107 = new i().getType();
        Intrinsics.checkNotNull(r107);
        f538464h = r107;
        Type r108 = new h().getType();
        Intrinsics.checkNotNull(r108);
        f538465i = r108;
        Type r109 = new d().getType();
        Intrinsics.checkNotNull(r109);
        f538466j = r109;
        Type r110 = new e().getType();
        Intrinsics.checkNotNull(r110);
        f538467k = r110;
        Type r111 = new g().getType();
        Intrinsics.checkNotNull(r111);
        f538468l = r111;
    }
}
