package vr9;

import android.content.Context;
import com.larus.podcast.api.PodcastClickSource;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f556935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f556936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f556937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f556938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f556939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PodcastClickSource f556940f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f556935a, r101.f556935a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f556936b, r101.f556936b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f556937c, r101.f556937c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f556938d, r101.f556938d) == true) goto L21;
        return false;
    L21:
        if (this.f556939e == r101.f556939e) goto L24;
        return false;
    L24:
        if (this.f556940f == r101.f556940f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f556935a.hashCode() * 31;
        CoroutineScope r101 = this.f556936b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f556937c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f556938d;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.f556939e == false) goto L17;
        int r110 = 1231;
    L19:
        return ((r109 + r110) * 31) + this.f556940f.hashCode();
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PodcastGenerateContext(context=" + this.f556935a + ", scope=" + this.f556936b + ", messageId=" + this.f556937c + ", conversationId=" + this.f556938d + ", needFullscreenPlayer=" + this.f556939e + ", clickSource=" + this.f556940f + ')';
    }

    public final Context getContext() {
        return this.f556935a;
    }

    public a(Context r100, CoroutineScope r101, String r102, String r103, PodcastClickSource r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "clickSource");
        this.f556935a = r100;
        this.f556936b = r101;
        this.f556937c = r102;
        this.f556938d = r103;
        this.f556939e = false;
        this.f556940f = r104;
    }
}
