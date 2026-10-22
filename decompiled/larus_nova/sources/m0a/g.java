package m0a;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.ugc.feed.impl.mapper.CreationFeedPlatformRepositoryAdapter;
import kotlin.jvm.internal.Intrinsics;
import zp9.s;

/* JADX INFO: loaded from: classes31.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f511528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f511529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o0a.a f511530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f511531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView.RecycledViewPool f511532e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f511528a, r101.f511528a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511529b, r101.f511529b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511530c, r101.f511530c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f511531d, r101.f511531d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f511532e, r101.f511532e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f511528a.hashCode() * 31;
        k r101 = this.f511529b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f511530c.hashCode()) * 31;
        s r105 = this.f511531d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        RecyclerView.RecycledViewPool r108 = this.f511532e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationFeedInitDependencyAndroid(repository=" + this.f511528a + ", actionInterceptor=" + this.f511529b + ", tracker=" + this.f511530c + ", creationMenusCreator=" + this.f511531d + ", sharedRecycledViewPool=" + this.f511532e + ')';
    }

    @Override // m0a.h
    public final o0a.a R0() {
        return this.f511530c;
    }

    @Override // m0a.h
    public final k a() {
        return this.f511529b;
    }

    @Override // m0a.h
    public final l b() {
        return this.f511528a;
    }

    public g(CreationFeedPlatformRepositoryAdapter r100, com.larus.ugc.feed.impl.mapper.b r101, o0a.a r102, s r103, RecyclerView.RecycledViewPool r104) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        this.f511528a = r100;
        this.f511529b = r101;
        this.f511530c = r102;
        this.f511531d = r103;
        this.f511532e = r104;
    }
}
