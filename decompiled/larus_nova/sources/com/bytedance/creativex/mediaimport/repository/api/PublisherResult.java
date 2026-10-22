package com.bytedance.creativex.mediaimport.repository.api;

import com.alibaba.gaiax.model.GXAnimation;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class PublisherResult<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<DATA> f203619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Status f203620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f203621c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/api/PublisherResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", GXAnimation.STATE_END, "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status END = null;
        public static final Status RUNNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f203622a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f203623b = null;

        public static EnumEntries<Status> getEntries() {
            return f203623b;
        }

        static {
            Status r100 = new Status("RUNNING", 0);
            RUNNING = r100;
            Status r101 = new Status(GXAnimation.STATE_END, 1);
            END = r101;
            Status[] r102 = {r100, r101};
            f203622a = r102;
            f203623b = EnumEntriesKt.enumEntries(r102);
        }

        public static Status[] values() {
            return (Status[]) f203622a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PublisherResult) == true) goto L8;
        return false;
    L8:
        PublisherResult r101 = (PublisherResult) r100;
        if (Intrinsics.areEqual(this.f203619a, r101.f203619a) == true) goto L12;
        return false;
    L12:
        if (this.f203620b == r101.f203620b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f203621c, r101.f203621c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f203619a.hashCode() * 31) + this.f203620b.hashCode()) * 31;
        Throwable r101 = this.f203621c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PublisherResult(data=" + this.f203619a + ", status=" + this.f203620b + ", exception=" + this.f203621c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublisherResult(List<? extends DATA> r100, Status r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "status");
        this.f203619a = r100;
        this.f203620b = r101;
        this.f203621c = r102;
    }
}
