package m0a;

import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o {
    public static final void a(UserCreationModelKmp r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<UserCreationKmp> r101 = r100.getCreationList();
        if (r101 == null) goto L8;
        UserCreationKmp r102 = (UserCreationKmp) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L8;
        String r103 = r102.getCreationId();
        if (r103 == null) goto L8;
    L9:
        r100.setModelId(r103);
        return;
    L8:
        r103 = "";
        goto L9
    }
}
