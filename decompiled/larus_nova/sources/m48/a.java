package m48;

import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements qr9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q54.b f511893a;

    @Override // qr9.c
    public final void a() {
        this.f511893a.a();
    }

    public a(q54.b r100) {
        Intrinsics.checkNotNullParameter(r100, "iAosPreloader");
        this.f511893a = r100;
    }

    @Override // qr9.c
    public final void b(List<pr9.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        List<pr9.a> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        pr9.a r104 = (pr9.a) r103.next();
        String r105 = r104.f530386a;
        boolean r106 = r104.f530387b;
        r102.add(new q54.a(r105, r104.f530388c, r106, r104.f530389d, MediaPlayer.MEDIA_PLAYER_OPTION_AV_RENDER_SERIES));
        goto L4
    L6:
        this.f511893a.b(r102, false);
    }
}
