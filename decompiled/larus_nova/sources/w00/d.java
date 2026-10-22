package w00;

import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.scope.o;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements o, g00.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Integer> f557779a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public d() {
        this.f557779a = new LinkedHashSet();
    }

    @Override // g00.d
    public final void markEnterSceneFromJsb(int r100) {
        this.f557779a.add(Integer.valueOf(r100));
    }

    @Override // nz.v
    public final void markPopupShown(int r100) {
        com.bytedance.android.livesdk.sharedpref.e<HashSet<Integer>> r101 = com.bytedance.android.livesdk.sharedpref.b.f158123b0;
        r101.getValue().add(Integer.valueOf(r100));
        f.d(r101, r101.getValue());
        this.f557779a.remove(Integer.valueOf(r100));
    }

    @Override // g00.d
    public final boolean shouldShowGuidePromptBubble(int r100) {
        boolean r101 = com.bytedance.android.livesdk.sharedpref.b.f158123b0.getValue().contains(17);
        boolean r102 = this.f557779a.contains(17);
        if (r101 == true) goto L6;
        if (r102 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
