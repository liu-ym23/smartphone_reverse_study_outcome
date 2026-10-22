package com.bytedance.creativex.mediaimport.repository.api;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import ki4.j0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class Aggregation extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f203604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Operator f203605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0 f203606d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/Aggregation$Operator;", "", "option", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOption", "()Ljava/lang/String;", "AND", "OR", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Operator extends Enum<Operator> {
        public static final Operator AND = null;
        public static final Operator OR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Operator[] f203607a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f203608b = null;
        private final String option;

        public static EnumEntries<Operator> getEntries() {
            return f203608b;
        }

        static {
            Operator r100 = new Operator("AND", 0, "AND");
            AND = r100;
            Operator r101 = new Operator("OR", 1, "OR");
            OR = r101;
            Operator[] r102 = {r100, r101};
            f203607a = r102;
            f203608b = EnumEntriesKt.enumEntries(r102);
        }

        public static Operator[] values() {
            return (Operator[]) f203607a.clone();
        }

        public final String getOption() {
            return this.option;
        }

        public static Operator valueOf(String r100) {
            return (Operator) r27.a.a(Operator.class, r100);
        }

        public Operator(String r100, int r101, String r102) {
            super(r100, r101);
            this.option = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Aggregation) == true) goto L8;
        return false;
    L8:
        Aggregation r101 = (Aggregation) r100;
        if (Intrinsics.areEqual(this.f203604b, r101.f203604b) == true) goto L12;
        return false;
    L12:
        if (this.f203605c == r101.f203605c) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f203606d, r101.f203606d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f203604b.hashCode() * 31) + this.f203605c.hashCode()) * 31) + this.f203606d.hashCode();
    }

    @Override // ki4.j0
    public final String[] a() {
        String[] r100 = this.f203604b.a();
        String[] r101 = this.f203606d.a();
        int r102 = r100.length + r101.length;
        String[] r103 = new String[r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103[r104] = "";
        r104 = r104 + 1;
        goto L3
    L5:
        System.arraycopy(r100, 0, r103, 0, r100.length);
        System.arraycopy(r101, 0, r103, r100.length, r101.length);
        return r103;
    }

    @Override // ki4.j0
    public final String b() {
        return "(" + this.f203604b + ' ' + this.f203605c.getOption() + ' ' + this.f203606d + ')';
    }

    @Override // ki4.j0
    public final j0 c() {
        j0 r100 = this.f203604b;
        Operator r101 = this.f203605c;
        j0 r102 = this.f203606d;
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "aggregationOperator");
        Intrinsics.checkNotNullParameter(r102, "second");
        return new Aggregation(r100, r101, r102);
    }

    public Aggregation(j0 r100, Operator r101, j0 r102) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "aggregationOperator");
        Intrinsics.checkNotNullParameter(r102, "second");
        this.f203604b = r100;
        this.f203605c = r101;
        this.f203606d = r102;
    }
}
