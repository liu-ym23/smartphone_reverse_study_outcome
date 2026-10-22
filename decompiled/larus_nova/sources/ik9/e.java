package ik9;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.mainbot.api.miniartifact.MiniArtifactTemplateParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f490284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MiniArtifactTemplateParams f490285b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f490284a, r101.f490284a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f490285b, r101.f490285b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f490284a.hashCode() * 31;
        MiniArtifactTemplateParams r101 = this.f490285b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MiniArtifactTemplateConfig(activity=" + this.f490284a + ", miniArtifactTemplateParams=" + this.f490285b + ')';
    }

    public final Activity getActivity() {
        return this.f490284a;
    }

    public e(FragmentActivity r100, MiniArtifactTemplateParams r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f490284a = r100;
        this.f490285b = r101;
    }
}
