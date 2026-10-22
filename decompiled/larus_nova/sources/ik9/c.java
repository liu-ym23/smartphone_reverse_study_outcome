package ik9;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.mainbot.api.miniartifact.MiniArtifactListPageParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f490279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MiniArtifactListPageParams f490280b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f490279a, r101.f490279a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f490280b, r101.f490280b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f490279a.hashCode() * 31;
        MiniArtifactListPageParams r101 = this.f490280b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MiniArtifactListPageConfig(activity=" + this.f490279a + ", miniArtifactListPageParams=" + this.f490280b + ')';
    }

    public final Activity getActivity() {
        return this.f490279a;
    }

    public c(FragmentActivity r100, MiniArtifactListPageParams r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f490279a = r100;
        this.f490280b = r101;
    }
}
