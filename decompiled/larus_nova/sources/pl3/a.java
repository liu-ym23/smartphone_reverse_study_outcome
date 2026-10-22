package pl3;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f529753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type f529754b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Type f529755c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Type f529756d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Type f529757e = null;

    /* JADX INFO: renamed from: pl3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"pl3/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C7209a extends TypeToken<HashMap<String, String>> {
        public C7209a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"pl3/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<Map<String, ? extends Boolean>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"pl3/a$c", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c extends TypeToken<HashMap<String, String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"pl3/a$d", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/live/profit/vip/b;", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d extends TypeToken<HashMap<String, com.bytedance.android.live.profit.vip.b>> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"pl3/a$e", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e extends TypeToken<HashMap<String, String>> {
        public e() {
        }
    }

    static {
        Type r100 = new d().getType();
        Intrinsics.checkNotNull(r100);
        f529753a = r100;
        Type r101 = new C7209a().getType();
        Intrinsics.checkNotNull(r101);
        f529754b = r101;
        Type r102 = new b().getType();
        Intrinsics.checkNotNull(r102);
        f529755c = r102;
        Type r103 = new c().getType();
        Intrinsics.checkNotNull(r103);
        f529756d = r103;
        Type r104 = new e().getType();
        Intrinsics.checkNotNull(r104);
        f529757e = r104;
    }
}
