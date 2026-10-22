package com.bytedance.pia.snapshot.storage;

import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.pia.core.utils.d;
import com.bytedance.pia.core.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements ISnapshotStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f266521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f266522b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Keva f266523c = null;

    public a() {
    }

    static {
        f266521a = new a();
        f266522b = Keva.getRepo("pia-snapshot-index-repo");
        f266523c = Keva.getRepo("pia-snapshot-content-repo");
    }

    public static void b(String r100) {
        Keva r101 = f266522b;
        r101.erase(r100);
        r101.erase(r100 + "_detail_id");
    }

    public static Keva c(String r100) {
        String r101 = r100 + "_detail_id";
        Keva r102 = f266522b;
        if (r102.contains(r100) == true) goto L5;
        return null;
    L5:
        if (r102.contains(r101) == false) goto L15;
        String r103 = r102.getString(r101, "");
        if (r103.length() <= 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L12;
        return null;
    L12:
        return Keva.getRepo(r103);
    L9:
        r104 = false;
        goto L10
    L15:
        return null;
    }

    public static ArrayList d(JSONObject r100) {
        ArrayList r101 = new ArrayList();
        if (r100.length() <= 0) goto L8;
        Iterator<String> r102 = r100.keys();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(r102.next());
    L8:
        CollectionsKt.sort(r101);
        return r101;
    }

    public static void e(String r100) {
        d.b("[SnapShot] remove all snapshots (Path = " + r100 + ')', null, 14);
        Keva r101 = c(r100);
        if (r101 == null) goto L9;
        Map<String, ?> r102 = r101.getAll();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Iterator<Map.Entry<String, ?>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        f266523c.erase(JSONObjectProtectorUtils.getString(new JSONObject((String) r103.next().getValue()), "content_UUID"));
        goto L6
    L8:
        r101.clear();
    L9:
        b(r100);
    }

    @Override // com.bytedance.pia.snapshot.storage.ISnapshotStore
    public d57.a query(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        String r100 = j.d(r110);
        Keva r101 = f266522b;
        if (r101.contains(r100) == true) goto L5;
        return null;
    L5:
        String[] r102 = r101.getStringArray(r100, null);
        if (r102 != null) goto L9;
        e(r100);
        return null;
    L9:
        int r103 = 0;
        if (r102.length != 0) goto L12;
        boolean r104 = true;
    L14:
        if ((!r104) == false) goto L16;
        String r105 = r100.concat("?");
    L17:
        int r106 = r102.length;
    L18:
        if (r103 >= r106) goto L26;
        String r107 = r102[r103];
        if (UriProtector.getQueryParameter(r110, r107) == null) goto L21;
        r105 = r105 + r107 + com.alipay.sdk.m.n.a.f25612h + UriProtector.getQueryParameter(r110, r107);
        if (r103 >= (r102.length - 1)) goto L25;
        r105 = r105 + Typography.amp;
    L25:
        r103 = r103 + 1;
        goto L18
    L21:
        return null;
    L26:
        Keva r111 = c(r100);
        if (r111 != null) goto L29;
    L48:
        return null;
    L29:
        if (r111.contains(r105) == false) goto L48;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L32
        Object r109 = Result.m9449constructorimpl(new JSONObject(r111.getString(r105, "")));     // Catch: Throwable -> L32
    L35:
        if (Result.m9452exceptionOrNullimpl(r109) != null) goto L47;
        JSONObject r112 = (JSONObject) r109;
        String r113 = JSONObjectProtectorUtils.getString(r112, "content_UUID");
        long r114 = JSONObjectProtectorUtils.getLong(r112, "expire_time");
        String r115 = JSONObjectProtectorUtils.getString(r112, "snapshot_version");
        int r116 = JSONObjectProtectorUtils.getInt(r112, "protocol_version");
        Object r117 = Result.m9449constructorimpl(new JSONObject(f266523c.getString(r113, "")));     // Catch: Throwable -> L39
    L42:
        if (Result.m9452exceptionOrNullimpl(r117) != null) goto L45;
        JSONObject r118 = (JSONObject) r117;
        return new d57.a(r105, r102, r118.optString("content"), r118.optString("head"), r115, r116, r114);
    L45:
        f266523c.erase(r113);
        r111.erase(r105);
        return null;
    L39:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L47:
        r111.erase(r105);
    L32:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L16:
        r105 = r100;
        goto L17
    L12:
        r104 = false;
        goto L14
    }

    public static String a(String r100, JSONObject r101, List r102) {
        if (r101.length() != 0) goto L5;
        return r100;
    L5:
        String r103 = r100.concat("?");
        int r104 = r102.size();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        r103 = r103 + ((String) ListProtector.get(r102, r105)) + com.alipay.sdk.m.n.a.f25612h + r101.opt((String) ListProtector.get(r102, r105));
        if (r105 >= (((ArrayList) r102).size() - 1)) goto L10;
        r103 = r103 + Typography.amp;
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        return r103;
    }

    public static boolean f(String r100, JSONObject r101, ArrayList r102) {
        Keva r103 = c(r100);
        if (r103 == null) goto L16;
        String r104 = a(r100, r101, r102);
        if (r103.contains(r104) == false) goto L20;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        Object r106 = Result.m9449constructorimpl(new JSONObject(r103.getString(r104, "")));     // Catch: Throwable -> L8
    L11:
        if (Result.m9452exceptionOrNullimpl(r106) != null) goto L21;
        String r107 = ((JSONObject) r106).optString("content_UUID");
        Keva r108 = f266523c;
        if (r108.contains(r107) == false) goto L22;
        r108.erase(r107);
        r103.erase(r104);
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L20:
        return false;
    L16:
        return false;
    }

    public static boolean g(String r110, JSONObject r111, ArrayList r112, String r113, String r114, long r115, String r116, int r117) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        Keva r101 = f266522b;     // Catch: Throwable -> L20
        if (r101.contains(r110) == true) goto L11;
        String[] r102 = new String[0];     // Catch: Throwable -> L20
        if ((!r112.isEmpty()) == false) goto L9;
        r102 = (String[]) r112.toArray(r102);     // Catch: Throwable -> L20
    L9:
        r101.storeStringArray(r110, r102);     // Catch: Throwable -> L20
        r101.storeString(r110.concat("_detail_id"), UUID.randomUUID().toString());     // Catch: Throwable -> L20
    L11:
        Keva r103 = c(r110);     // Catch: Throwable -> L20
        if (r103 == null) goto L17;
        String r104 = a(r110, r111, r112);     // Catch: Throwable -> L20
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L20
        r105.put("expire_time", r115);     // Catch: Throwable -> L20
        r105.put("snapshot_version", r116);     // Catch: Throwable -> L20
        r105.put("protocol_version", r117);     // Catch: Throwable -> L20
        r105.put("content_UUID", UUID.randomUUID().toString());     // Catch: Throwable -> L20
        String r106 = r105.optString("content_UUID");     // Catch: Throwable -> L20
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L20
        r107.put("content", r113);     // Catch: Throwable -> L20
        if (r114 == null) goto L16;
        r107.put("head", r114);     // Catch: Throwable -> L20
    L16:
        f266523c.storeString(r106, r107.toString());     // Catch: Throwable -> L20
        r103.storeString(r104, r105.toString());     // Catch: Throwable -> L20
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L20
    L22:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r109);
        if (r118 != null) goto L26;
        d.b("[SnapShot] save snapshot success", null, 14);
        return true;
    L26:
        d.p("[SnapShot] save snapshot failed. (Reason: " + r118.getMessage() + ')', null, null, 14);
        return false;
    L17:
        r108 = null;
    L20:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
