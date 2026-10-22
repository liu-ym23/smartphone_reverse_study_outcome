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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableSuperAgentAtViewModel {
    public final FragmentActivity a;
    public final String b;
    public final or4.a c;
    public final String d;
    public final int e;
    public final Lazy f;
    public final MutableLiveData<List<AtObject>> g;
    public final MutableLiveData h;
    public final MutableLiveData<List<b>> i;
    public final MutableLiveData j;
    public final MutableLiveData<Boolean> k;
    public final MutableLiveData l;
    public final MutableLiveData<Boolean> m;
    public final MutableLiveData n;
    public final MutableLiveData<ViewMode> o;
    public final MutableLiveData p;
    public final AtomicInteger q;
    public boolean r;
    public Function1<? super bo4.a, Unit> s;
    public final e t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$Section;", "", "<init>", "(Ljava/lang/String;I)V", "USERS_AND_GROUPS", "TABLE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Section extends Enum<Section> {
        public static final Section TABLE = null;
        public static final Section USERS_AND_GROUPS = null;
        public static final /* synthetic */ Section[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Section> getEntries() {
            return b;
        }

        static {
            Section r0 = new Section("USERS_AND_GROUPS", 0);
            USERS_AND_GROUPS = r0;
            Section r1 = new Section("TABLE", 1);
            TABLE = r1;
            Section[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Section[] values() {
            return (Section[]) a.clone();
        }

        public static Section valueOf(String r1) {
            return (Section) r27.a.a(Section.class, r1);
        }

        public Section(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$ViewMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "USERS_ONLY", "TABLES_ONLY", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ViewMode extends Enum<ViewMode> {
        public static final ViewMode DEFAULT = null;
        public static final ViewMode TABLES_ONLY = null;
        public static final ViewMode USERS_ONLY = null;
        public static final /* synthetic */ ViewMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ViewMode> getEntries() {
            return b;
        }

        static {
            ViewMode r0 = new ViewMode("DEFAULT", 0);
            DEFAULT = r0;
            ViewMode r1 = new ViewMode("USERS_ONLY", 1);
            USERS_ONLY = r1;
            ViewMode r3 = new ViewMode("TABLES_ONLY", 2);
            TABLES_ONLY = r3;
            ViewMode[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ViewMode[] values() {
            return (ViewMode[]) a.clone();
        }

        public static ViewMode valueOf(String r1) {
            return (ViewMode) r27.a.a(ViewMode.class, r1);
        }

        public ViewMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "TableItem(id=" + this.a + ", name=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "name");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Section.values().length];
            r0[Section.USERS_AND_GROUPS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Section.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "keyword");
        MutableLiveData<Boolean> r1 = this.k;
        Boolean r2 = Boolean.TRUE;
        r1.setValue(r2);
        this.m.setValue(r2);
        ((AtFinderViewModel) this.f.getValue()).search(this.b, r9, this.d, this.e, "");
        int r3 = this.q.incrementAndGet();
        JSONObject r4 = new JSONObject();
        r4.put("baseId", this.b);
        if (r9.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        r4.put("keyword", r9);
    L8:
        or4.a r10 = this.c;
        if (r10 == null) goto L12;
        r10.a("javascript:window.lark.biz.bitable.getSuperAgentMentionTables", r4, new g(r3, this));
        return;
    L12:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public BitableSuperAgentAtViewModel(FragmentActivity r10, String r11, r r12) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter(r11, "baseId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Integer[]{0, 5, 6}), ",", null, null, 0, null, null, 62, null);
        this.e = 5;
        this.f = LazyKt.lazy(new BitableSuperAgentAtViewModel$delegate$2(this));
        MutableLiveData<List<AtObject>> r13 = new MutableLiveData();
        this.g = r13;
        this.h = r13;
        MutableLiveData<List<b>> r14 = new MutableLiveData();
        this.i = r14;
        this.j = r14;
        MutableLiveData<Boolean> r16 = new MutableLiveData();
        Boolean r17 = Boolean.FALSE;
        r16.setValue(r17);
        this.k = r16;
        this.l = r16;
        MutableLiveData<Boolean> r18 = new MutableLiveData();
        r18.setValue(r17);
        this.m = r18;
        this.n = r18;
        MutableLiveData<ViewMode> r19 = new MutableLiveData();
        r19.setValue(ViewMode.DEFAULT);
        this.o = r19;
        this.p = r19;
        this.q = new AtomicInteger(0);
        this.t = new e(this);
    }
}
