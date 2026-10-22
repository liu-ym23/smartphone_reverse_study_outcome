package or2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements d, o {
    public h() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // or2.d
    public final boolean M() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.M() != true) goto L7;
        return true;
    }

    @Override // or2.d
    public final String getCurrentResolution() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // or2.d
    public final boolean getHasFirstFrame() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.e() != true) goto L7;
        return true;
    }

    @Override // or2.d
    public final boolean getPlayPrepared() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 == null) goto L7;
        MutableLiveData<Boolean> r101 = r100.d().a();
        if (r101 == null) goto L7;
        Boolean r102 = r101.getValue();
    L9:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L7:
        r102 = null;
        goto L9
    }

    @Override // or2.d
    public final boolean isPlaying() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 == null) goto L7;
        MutableLiveData<Boolean> r101 = r100.d().b();
        if (r101 == null) goto L7;
        Boolean r102 = r101.getValue();
    L9:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L7:
        r102 = null;
        goto L9
    }

    @Override // or2.d
    public final void releaseEffect() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // or2.d
    public final String u2() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 == null) goto L7;
        JSONObject r101 = r100.f();
        if (r101 == null) goto L7;
        return r101.optString("url:");
    L7:
        return null;
    }

    @Override // or2.d
    public final k v5() {
        j r100 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b().a();
    }

    @Override // or2.d
    public final void eb(String r100) {
        j r101 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    @Override // or2.d
    public final void on(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resolution");
        j r101 = ((e) vh6.c.b(e.class)).getCurrentClient();
        if (r101 == null) goto L6;
        r101.k(r100);
        return;
    }
}
