package em5;

import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class e {
    public abstract boolean b();

    public abstract void c(PickerConfig r100);

    public e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public static Set a(ArrayList r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        SearchBaseInfo r103 = (SearchBaseInfo) r102.next();
        if ((r103 instanceof SearchChatterInfo) == false) goto L8;
        String r104 = ((SearchChatterInfo) r103).getP2pChatId();
    L9:
        r101.add(r104);
        goto L4
    L8:
        r104 = r103.getId();
        goto L9
    L11:
        return CollectionsKt.toSet(r101);
    }
}
