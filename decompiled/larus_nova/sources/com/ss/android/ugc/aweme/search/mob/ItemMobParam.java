package com.ss.android.ugc.aweme.search.mob;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/ItemMobParam;", "", "<init>", "()V", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class ItemMobParam {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Companion f453297v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f453298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f453299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f453300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f453301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f453302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f453303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f453304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f453305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f453306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Aweme, String> f453307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, ? extends Function1<? super Aweme, String>> f453308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f453309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f453310m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f453311n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, String> f453312o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f453313p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f453314q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f453315r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f453316s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f453317t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f453318u;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/ItemMobParam$Companion;", "", "", "CARD_TYPE_AWEME_MIX", "Ljava/lang/String;", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        @AllowImpl
        public static ItemMobParam a() {
            return new ItemMobParam(0);
        }
    }

    static {
        f453297v = new Companion(0);
    }

    public /* synthetic */ ItemMobParam(int r100) {
        this();
    }

    private ItemMobParam() {
        this.f453298a = "";
        this.f453299b = "";
        this.f453300c = new ArrayList();
        this.f453301d = "";
        this.f453302e = "";
        this.f453303f = "";
        new LogPbBean();
        this.f453304g = "";
        this.f453305h = -1;
        this.f453306i = "";
        ItemMobParam$searchResultIdProvider$1 r100 = ItemMobParam$searchResultIdProvider$1.INSTANCE;
        ItemMobParam$listItemIdProvider$1 r101 = ItemMobParam$listItemIdProvider$1.INSTANCE;
        ItemMobParam$searchThirdItemIdProvider$1 r102 = ItemMobParam$searchThirdItemIdProvider$1.INSTANCE;
        ItemMobParam$searchResultPageProvider$1 r103 = ItemMobParam$searchResultPageProvider$1.INSTANCE;
        ItemMobParam$searchRequestIdProvider$1 r104 = ItemMobParam$searchRequestIdProvider$1.INSTANCE;
        new LinkedHashMap();
        this.f453308k = MapsKt.emptyMap();
        this.f453309l = -1;
        this.f453310m = -1;
        this.f453311n = -1;
        this.f453312o = new LinkedHashMap();
        new LinkedHashMap();
    }

    @AllowImpl
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        this.f453301d = r100;
    }

    @AllowImpl
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "logPbStr");
        this.f453304g = r100;
    }

    @AllowImpl
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "searchKeyword");
        this.f453299b = r100;
    }
}
