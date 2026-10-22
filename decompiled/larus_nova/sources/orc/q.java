package orc;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class q {
    public static final String a(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "name");
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{r100, r110}), HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
    }
}
