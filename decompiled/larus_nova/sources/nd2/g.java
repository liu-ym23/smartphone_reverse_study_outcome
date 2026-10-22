package nd2;

import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f518768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p.a f518769b;

    public g(d r100, p.a r101) {
        this.f518768a = r100;
        this.f518769b = r101;
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void c(MusicPanel r100, int r101) {
        this.f518769b.c(r100, r101);
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void a(MusicPanel r100, String r101, String r102) {
        this.f518769b.a(r100, r101, r102);
        ConcurrentHashMap<String, Boolean> r103 = this.f518768a.f518763a;
        if (r100 == null) goto L5;
        String r104 = String.valueOf(r100.c());
    L6:
        if (r103 == null) goto L10;
        TypeIntrinsics.asMutableMap(r103).remove(r104);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void b(MusicPanel r100, int r101, String r102) {
        this.f518769b.b(r100, r101, r102);
        ConcurrentHashMap<String, Boolean> r103 = this.f518768a.f518763a;
        if (r100 == null) goto L5;
        String r104 = String.valueOf(r100.c());
    L6:
        if (r103 == null) goto L10;
        TypeIntrinsics.asMutableMap(r103).remove(r104);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L5:
        r104 = null;
        goto L6
    }
}
