package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.Artist;
import com.obric.capabilitykit.entity.app.Cover;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.Preview;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f563985a = null;

    static {
        f563985a = new f();
    }

    public f() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof MusicEntity) == false) goto L16;
        MusicEntity r101 = (MusicEntity) r100;
        int r102 = r101.getName().hashCode() + 0;
        List<Artist> r103 = r101.getArtists();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        Cover r104 = r101.getCover();
        if (r104 == null) goto L10;
        r102 = (r102 * 31) + r104.hashCode();
    L10:
        Preview r105 = r101.getPreview();
        if (r105 == null) goto L13;
        r102 = (r102 * 31) + r105.hashCode();
    L13:
        long r106 = r101.getDuration();
        return (r102 * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L16:
        throw new IllegalStateException("Check failed.".toString());
    }
}
