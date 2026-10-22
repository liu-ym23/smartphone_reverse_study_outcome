package si8;

import com.larus.bmhome.chat.search.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.o;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements pi8.a {
    public c() {
    }

    @Override // pi8.a
    public final o a(k r310, oi8.c r311) {
        Intrinsics.checkNotNullParameter(r310, "originData");
        ArrayList r100 = new ArrayList();
        com.larus.bmhome.chat.search.b r101 = r310.e();
        if (r101 == null) goto L7;
        com.larus.bmhome.chat.search.b.d r102 = r101.f();
        if (r102 == null) goto L7;
        List<VideoInfo> r103 = r102.a();
    L8:
        List<VideoInfo> r104 = r103;
        int r105 = 0;
        if (r104 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        Iterator r107 = CollectionsKt.take(r103, 4).iterator();
    L20:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        int r109 = r105 + 1;
        if (r105 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        VideoInfo r110 = VideoInfo.copy$default((VideoInfo) r108, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
        r110.setVideoInfoList(new ArrayList(r104));
        r110.setVideoIndex(r105);
        r100.add(r110);
        r105 = r109;
        goto L20
    L26:
        return new o(r100, true);
    L17:
        return new o(r100, true);
    L11:
        if (r104.isEmpty() == true) goto L14;
        r106 = false;
    L7:
        r103 = null;
        goto L8
    }
}
