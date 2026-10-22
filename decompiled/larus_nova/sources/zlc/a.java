package zlc;

import android.text.TextUtils;
import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import ylc.f;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f572836a = 0;

    static {
    }

    @JvmStatic
    public static final String a(WebcastRoomDataSyncMessage r100) {
        if (r100 != null) goto L4;
        return "null";
    L4:
        return r100.syncKey + "|version." + r100.version;
    }

    @JvmStatic
    public static final String b(f r100) {
        if (r100 == null) goto L9;
        Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r101 = r100.f568370h;
        if (r101 == null) goto L9;
        Collection r102 = new ArrayList(r101.size());
        Iterator<Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a>> r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r104 = r103.next();
        r102.add(r104.getKey() + "|version." + r104.getValue().f458180a);
    L11:
        return TextUtils.join(",", r102);
    L9:
        r102 = CollectionsKt.emptyList();
        goto L11
    }
}
