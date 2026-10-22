package tx9;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f547847a = null;

    static {
        f547847a = SetsKt.setOf(new String[]{"chat_id", "agent_mode", "card_source", "card_group_id", "card_id", "doc_id", "rich_media_type"});
    }

    public static final void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L9;
        Iterator<String> r102 = r101.keys();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        r100.putOpt(r103, r101.opt(r103));
        goto L7
    L12:
        return;
    }
}
