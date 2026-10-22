package tca;

import android.os.Parcelable;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f545491a = 0;

    static {
    }

    public static List b(AppIntentMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        List<Parcelable> r101 = com.obric.assistant.card.utils.c.d(r100);
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L20;
        Parcelable r104 = (Parcelable) r103.next();
        AppInfoEntity r105 = null;
        if ((r104 instanceof AppIntentCardData) == false) goto L11;
        AppIntentCardData r106 = (AppIntentCardData) r104;
    L12:
        if (r106 == null) goto L14;
        AppEntity r107 = r106.getAppEntity();
    L16:
        if ((r107 instanceof AppInfoEntity) == false) goto L18;
        r105 = (AppInfoEntity) r107;
    L18:
        if (r105 == null) goto L7;
        r102.add(r105);
        goto L7
    L14:
        r107 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L20:
        return r102;
    }

    public static int c(AppIntentMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L10;
        String r102 = r101.get("operate_type");
        if (r102 == null) goto L10;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 == null) goto L10;
        return r103.intValue();
    L10:
        return 0;
    }

    public static int a(int r100, AppInfoEntity r101) {
        Intrinsics.checkNotNullParameter(r101, "entity");
        int r102 = r101.getAppStatus();
        boolean r103 = r101.isExactMatch();
        if (r100 == 0) goto L16;
        if (r100 != 1) goto L23;
        if (r102 == 0) goto L23;
        if (r102 == 2) goto L29;
        if (r103 == true) goto L13;
        if (r102 == 4) goto L23;
    L13:
        if (r103 == false) goto L23;
        if (r102 != 3) goto L23;
    L22:
        return 1;
    L29:
        return 2;
    L23:
        return 0;
    L16:
        if (r102 == 1) goto L21;
        if (r102 == 2) goto L25;
        if (r102 == 3) goto L26;
        if (r102 != 4) goto L23;
        return 2;
    L26:
        return 2;
    L25:
        return 2;
    L21:
        if (r103 == false) goto L23;
        goto L22
    }
}
