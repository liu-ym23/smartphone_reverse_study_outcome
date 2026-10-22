package com.larus.home.impl.ug;

import com.bytedance.android.livesdk.schema.OpenDouyinActionHandler;
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f346291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f346292b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f346293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f346294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f346295e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f346296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f346297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f346298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f346299d;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f346296a, r101.f346296a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f346297b, r101.f346297b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f346298c, r101.f346298c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f346299d, r101.f346299d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f346296a.hashCode() * 31) + this.f346297b.hashCode()) * 31) + this.f346298c.hashCode()) * 31) + this.f346299d.hashCode();
        }

        public final String toString() {
            return "EventParams(currentPage=" + this.f346296a + ", previousPage=" + this.f346297b + ", chatType=" + this.f346298c + ", botId=" + this.f346299d + ')';
        }

        public /* synthetic */ a(int r100) {
            this("", "", "", "");
        }

        public static a a(a r100, String r101, int r102) {
            String r103 = null;
            if ((r102 & 1) == 0) goto L5;
            String r104 = r100.f346296a;
        L7:
            if ((r102 & 2) == 0) goto L10;
            r101 = r100.f346297b;
        L10:
            if ((r102 & 4) == 0) goto L12;
            String r105 = r100.f346298c;
        L14:
            if ((r102 & 8) == 0) goto L16;
            r103 = r100.f346299d;
        L16:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r104, "currentPage");
            Intrinsics.checkNotNullParameter(r101, "previousPage");
            Intrinsics.checkNotNullParameter(r105, "chatType");
            Intrinsics.checkNotNullParameter(r103, "botId");
            return new a(r104, r101, r105, r103);
        L12:
            r105 = null;
            goto L14
        L5:
            r104 = null;
            goto L7
        }

        public a(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "currentPage");
            Intrinsics.checkNotNullParameter(r101, "previousPage");
            Intrinsics.checkNotNullParameter(r102, "chatType");
            Intrinsics.checkNotNullParameter(r103, "botId");
            this.f346296a = r100;
            this.f346297b = r101;
            this.f346298c = r102;
            this.f346299d = r103;
        }
    }

    static {
        f346291a = MapsKt.mapOf(new Pair[]{TuplesKt.to(OpenDouyinActionHandler.SCHEMA, ShareChannel.DOUYIN), TuplesKt.to("snssdk2329", "awemelite"), TuplesKt.to("snssdk143", "news"), TuplesKt.to("snssdk35", "newslite"), TuplesKt.to("snssdk32", "video"), TuplesKt.to("snssdk1112", "live")});
        f346292b = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getIO()));
        f346295e = new a(0);
    }
}
