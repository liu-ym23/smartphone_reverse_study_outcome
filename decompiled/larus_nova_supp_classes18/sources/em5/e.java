package em5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class e {
    public abstract boolean b();

    public abstract void c(PickerConfig r1);

    public e(b r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
    }

    public static Set a(ArrayList r3) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        SearchChatterInfo r1 = (SearchBaseInfo) r4.next();
        if ((r1 instanceof SearchChatterInfo) == false) goto L8;
        String r2 = r1.getP2pChatId();
    L9:
        r0.add(r2);
        goto L4
    L8:
        r2 = r1.getId();
        goto L9
    L11:
        return CollectionsKt.toSet(r0);
    }
}
