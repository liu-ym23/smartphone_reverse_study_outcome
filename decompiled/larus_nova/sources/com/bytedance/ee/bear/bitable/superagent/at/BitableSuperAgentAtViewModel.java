package com.bytedance.ee.bear.bitable.superagent.at;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.bitable.superagent.r;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class BitableSuperAgentAtViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f215821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f215822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final or4.a f215823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f215824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f215825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f215826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<List<AtObject>> f215827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f215828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<List<b>> f215829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData f215830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<Boolean> f215831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData f215832l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData<Boolean> f215833m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MutableLiveData f215834n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData<ViewMode> f215835o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MutableLiveData f215836p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f215837q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f215838r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super bo4.a, Unit> f215839s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final e f215840t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$Section;", "", "<init>", "(Ljava/lang/String;I)V", "USERS_AND_GROUPS", "TABLE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Section extends Enum<Section> {
        public static final Section TABLE = null;
        public static final Section USERS_AND_GROUPS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Section[] f215841a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f215842b = null;

        public static EnumEntries<Section> getEntries() {
            return f215842b;
        }

        static {
            Section r100 = new Section("USERS_AND_GROUPS", 0);
            USERS_AND_GROUPS = r100;
            Section r101 = new Section("TABLE", 1);
            TABLE = r101;
            Section[] r102 = {r100, r101};
            f215841a = r102;
            f215842b = EnumEntriesKt.enumEntries(r102);
        }

        public static Section[] values() {
            return (Section[]) f215841a.clone();
        }

        public static Section valueOf(String r100) {
            return (Section) r27.a.a(Section.class, r100);
        }

        public Section(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$ViewMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "USERS_ONLY", "TABLES_ONLY", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ViewMode extends Enum<ViewMode> {
        public static final ViewMode DEFAULT = null;
        public static final ViewMode TABLES_ONLY = null;
        public static final ViewMode USERS_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ViewMode[] f215843a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f215844b = null;

        public static EnumEntries<ViewMode> getEntries() {
            return f215844b;
        }

        static {
            ViewMode r100 = new ViewMode("DEFAULT", 0);
            DEFAULT = r100;
            ViewMode r101 = new ViewMode("USERS_ONLY", 1);
            USERS_ONLY = r101;
            ViewMode r102 = new ViewMode("TABLES_ONLY", 2);
            TABLES_ONLY = r102;
            ViewMode[] r103 = {r100, r101, r102};
            f215843a = r103;
            f215844b = EnumEntriesKt.enumEntries(r103);
        }

        public static ViewMode[] values() {
            return (ViewMode[]) f215843a.clone();
        }

        public static ViewMode valueOf(String r100) {
            return (ViewMode) r27.a.a(ViewMode.class, r100);
        }

        public ViewMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f215845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f215846b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f215845a, r101.f215845a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f215846b, r101.f215846b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f215845a.hashCode() * 31) + this.f215846b.hashCode();
        }

        public final String toString() {
            return "TableItem(id=" + this.f215845a + ", name=" + this.f215846b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.f215845a = r100;
            this.f215846b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f215847a = null;

        static {
            int[] r100 = new int[Section.values().length];
            r100[Section.USERS_AND_GROUPS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Section.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f215847a = r100;
        }
    }

    static {
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        MutableLiveData<Boolean> r101 = this.f215831k;
        Boolean r102 = Boolean.TRUE;
        r101.setValue(r102);
        this.f215833m.setValue(r102);
        ((AtFinderViewModel) this.f215826f.getValue()).search(this.f215822b, r100, this.f215824d, this.f215825e, "");
        int r103 = this.f215837q.incrementAndGet();
        JSONObject r104 = new JSONObject();
        r104.put2("baseId", this.f215822b);
        if (r100.length() <= 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        r104.put2("keyword", r100);
    L8:
        or4.a r106 = this.f215823c;
        if (r106 == null) goto L12;
        r106.a("javascript:window.lark.biz.bitable.getSuperAgentMentionTables", r104, new g(r103, this));
        return;
    L12:
        return;
    L5:
        r105 = false;
        goto L6
    }

    public BitableSuperAgentAtViewModel(FragmentActivity r110, String r111, r r112) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "baseId");
        this.f215821a = r110;
        this.f215822b = r111;
        this.f215823c = r112;
        this.f215824d = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Integer[]{0, 5, 6}), ",", null, null, 0, null, null, 62, null);
        this.f215825e = 5;
        this.f215826f = LazyKt.lazy(new BitableSuperAgentAtViewModel$delegate$2(this));
        MutableLiveData<List<AtObject>> r113 = new MutableLiveData();
        this.f215827g = r113;
        this.f215828h = r113;
        MutableLiveData<List<b>> r114 = new MutableLiveData();
        this.f215829i = r114;
        this.f215830j = r114;
        MutableLiveData<Boolean> r115 = new MutableLiveData();
        Boolean r116 = Boolean.FALSE;
        r115.setValue(r116);
        this.f215831k = r115;
        this.f215832l = r115;
        MutableLiveData<Boolean> r117 = new MutableLiveData();
        r117.setValue(r116);
        this.f215833m = r117;
        this.f215834n = r117;
        MutableLiveData<ViewMode> r118 = new MutableLiveData();
        r118.setValue(ViewMode.DEFAULT);
        this.f215835o = r118;
        this.f215836p = r118;
        this.f215837q = new AtomicInteger(0);
        this.f215840t = new e(this);
    }
}
