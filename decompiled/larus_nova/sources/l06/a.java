package l06;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import i06.b;
import i06.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f506868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f506869b = null;

    static {
        f506868a = Keva.getRepoSync("precise_exposure_repo", 1);
        f506869b = new ArrayList();
        new LinkedHashMap();
    }

    public static void a() {
        Keva r100 = f506868a;
        String[] r101 = r100.getStringArray("__client_exp_vids", new String[0]);
        String[] r102 = r100.getStringArray("__exposed_vids", new String[0]);
        ArrayList r103 = new ArrayList();
        CollectionsKt.addAll(r103, r101);
        CollectionsKt.addAll(r103, r102);
        if (b.a().f487890d.a() == null) goto L5;
        CollectionsKt.addAll(r103, r100.getStringArray("{__exposed_vids_for_current_user}_{" + b() + '}', new String[0]));
    L5:
        CollectionsKt.joinToString$default(r103, ",", null, null, 0, null, null, 62, null);
        if (b.a().f487890d.a() == null) goto L9;
        b.a().f487890d.a().c();
        return;
    }

    public static String b() {
        c r100 = b.a().f487890d.a();
        if (r100 == null) goto L7;
        String r101 = r100.getCurrentUid();
        if (r101 == null) goto L7;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return "";
    L11:
        if (Intrinsics.areEqual("0", r101) == false) goto L14;
        return "";
    L14:
        return r101;
    L7:
        r101 = "";
        goto L9
    }
}
