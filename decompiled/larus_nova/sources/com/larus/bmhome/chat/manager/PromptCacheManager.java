package com.larus.bmhome.chat.manager;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class PromptCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f306675a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f306676b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f306677c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f306678d;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/manager/PromptCacheManager$CachePrompt;", "", "time", "", Constants.EXTRA_KEY_TOPICS, "", "", "<init>", "(JLjava/util/List;)V", "getTime", "()J", "getTopics", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("time")
        private final long time;

        @SerializedName(Constants.EXTRA_KEY_TOPICS)
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<String> topics;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.time == r101.time) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.topics, r101.topics) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.time;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            List<String> r102 = this.topics;
            if (r102 != null) goto L5;
            int r103 = 0;
        L7:
            return r101 + r103;
        L5:
            r103 = r102.hashCode();
            goto L7
        }

        public final String toString() {
            return "CachePrompt(time=" + this.time + ", topics=" + this.topics + ')';
        }

        public a() {
            this(0, new ArrayList());
        }

        public final long a() {
            return this.time;
        }

        public final List<String> b() {
            return this.topics;
        }

        public a(long r100, List<String> r101) {
            this.time = r100;
            this.topics = r101;
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((a) r101).a()), Long.valueOf(((a) r100).a()));
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/manager/PromptCacheManager$cacheUnClickedPromptTopic$prompts$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/manager/PromptCacheManager$CachePrompt;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends a>> {
        public c() {
        }
    }

    static {
        f306675a = new Gson();
        f306676b = Keva.getRepo("prompt_cache");
        f306677c = z2.f365865a.promptCacheMaxSize();
        new String[]{"#E5FFE7", "#E5FFFA", "#E5F5FF", "#EEEBFF", "#FFEBF1", "#FFF0DB", "#FFFECC"};
        new String[]{"#415841", "#415854", "#414F58", "#454158", "#584149", "#5C4F3D", "#605F39"};
    }

    public static String c() {
        return "key_cached_prompt_".concat(AccountService.f365697a.getSecUserId());
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        if (f306678d == false) goto L5;
        return;
    L5:
        f306678d = true;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PromptCacheManager$fetchSuggestCard$1(r100, null), 3, null);
    }

    public static void a(Long r110, List r111) {
        Intrinsics.checkNotNullParameter(r111, Constants.EXTRA_KEY_TOPICS);
        if (r110 == null) goto L102;
        r110.longValue();
        String r100 = c();
        Keva r101 = f306676b;
        String r102 = r101.getString(r100, "");
        ArrayList r103 = new ArrayList();
        if (r102 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L83;
        r103.add(new a(r110.longValue(), CollectionsKt.toMutableList(r111)));
        r101.storeString(r100, GsonProtectorUtils.toJson(f306675a, r103));
        return;
    L83:
        List r105 = (List) GsonProtectorUtils.fromJson(f306675a, r102, new c().getType());     // Catch: JsonSyntaxException -> L15
    L16:
        Iterator r106 = r103.iterator();
        int r107 = 0;
    L18:
        if (r106.hasNext() == false) goto L26;
        if (((a) r106.next()).a() != r110.longValue()) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == true) goto L27;
        r107 = r107 + 1;
    L27:
        if (r107 <= (-1)) goto L46;
        List<String> r109 = ((a) ListProtector.get(r103, r107)).b();
        if (r109 == null) goto L42;
        List<String> r112 = r109;
        if ((r112 instanceof Collection) == true) goto L33;
    L35:
        Iterator<T> r113 = r112.iterator();
    L37:
        if (r113.hasNext() == false) goto L41;
        if (((ArrayList) r111).contains((String) r113.next()) == true) goto L37;
    L41:
        boolean r114 = true;
    L43:
        if (r114 == false) goto L45;
        return;
    L45:
        ListProtector.remove(r103, r107);
        ListProtector.add(r103, r107, new a(r110.longValue(), CollectionsKt.toMutableList(r111)));
    L48:
        if (r103.size() <= 1) goto L50;
        CollectionsKt.sortWith(r103, new b());
    L50:
        final LinkedHashSet r115 = new LinkedHashSet();
        Iterator r116 = r103.iterator();
        int r117 = 0;
    L52:
        if (r116.hasNext() == false) goto L63;
        a r118 = (a) r116.next();
        List<String> r119 = r118.b();
        if (r119 == null) goto L56;
        CollectionsKt.removeAll(r119, new n0(r115));
    L56:
        List<String> r120 = r118.b();
        if (r120 == null) goto L59;
        int r121 = r120.size();
    L60:
        r117 = r117 + r121;
        List<String> r122 = r118.b();
        if (r122 == null) goto L52;
        r115.addAll(r122);
        goto L52
    L59:
        r121 = 0;
        goto L60
    L63:
        int r123 = f306677c;
        if (r117 <= r123) goto L81;
        int r124 = r117 - r123;
        int r125 = r103.size() - 1;
        int r126 = 0;
    L66:
        if (r126 >= r124) goto L81;
        if (r125 < 0) goto L81;
        List<String> r127 = ((a) ListProtector.get(r103, r125)).b();
        if (r127 != null) goto L71;
    L74:
        boolean r128 = true;
    L75:
        if (r128 == false) goto L76;
        r125 = r125 - 1;
        goto L66
    L76:
        List<String> r129 = ((a) ListProtector.get(r103, r125)).b();
        if (r129 == null) goto L79;
        String r130 = (String) CollectionsKt.removeFirstOrNull(r129);
    L79:
        r126 = r126 + 1;
        goto L66
    L71:
        if (r127.isEmpty() == true) goto L74;
        r128 = false;
    L81:
        CollectionsKt.removeAll(r103, new o0());
        f306676b.storeString(r100, GsonProtectorUtils.toJson(f306675a, r103));
        return;
    L33:
        if (r112.isEmpty() == false) goto L35;
    L42:
        r114 = false;
        goto L43
    L46:
        Intrinsics.checkNotNull(r105);
        r103.addAll(r105);
        r103.add(new a(r110.longValue(), CollectionsKt.toMutableList(r111)));
        goto L48
    L22:
        r108 = false;
        goto L23
    L26:
        r107 = -1;
    L15:
        r105 = CollectionsKt.emptyList();
        goto L16
    L7:
        if (r102.length() == 0) goto L10;
        r104 = false;
        goto L11
    }
}
