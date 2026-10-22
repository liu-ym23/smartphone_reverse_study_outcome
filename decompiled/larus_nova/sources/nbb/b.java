package nbb;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;
import qbb.c;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f518595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f518596b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, obb.b> f518597c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Gson f518598d = null;

    static {
        f518595a = new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR);
        f518596b = "docs_icon";
        f518597c = new LruCache(20971520);
        f518598d = new Gson();
        MemoryCallbackManager.getInstance().registerMemoryCallback(new a());
    }

    public static com.ss.android.lark.storage.kv.repo.a b(UserSession r100) {
        c r101 = new c(r100);
        Intrinsics.checkNotNullParameter(r101, "userScopeView");
        r101.provideComponent();
        String r102 = r101.e9().f438138b;
        return com.ss.android.lark.storage.c.d(LarkContext.getApplication(), r102, f518595a, f518596b, null, 32);
    }

    public static obb.b a(String r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal token empty");
        return null;
    L6:
        obb.b r102 = f518597c.get(r100);
        if (r102 == null) goto L19;
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal cache");
        return r102;
    L19:
        obb.b r103 = (obb.b) f518598d.fromJson(b(r101).getString(r100, ""), obb.b.class);     // Catch: Exception -> L12
    L14:
        if (r103 == null) goto L17;
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal disk");
        f518597c.put(r100, r103);
        return r103;
    L17:
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal null");
        return null;
    L12:
        e = move-exception;
        Log.e("DOCS_ICON_DocMetaDataManager", "getMetaFromDisk error " + e.getMessage());
        r103 = null;
        goto L14
    }

    public static void c(String r100, obb.b r101, UserSession r102) {
        Intrinsics.checkNotNullParameter(r101, "metaInfo");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        Log.i("DOCS_ICON_DocMetaDataManager", "insertOrUpdateMetaInfo token null");
        return;
    L6:
        Log.i("DOCS_ICON_DocMetaDataManager", "insertOrUpdateMetaInfo token " + r101.getType() + ' ' + r101.f522640d);
        LruCache<String, obb.b> r103 = f518597c;
        obb.b r104 = r103.get(r100);
        r103.put(r100, r101);
        if (r104 != null) goto L9;
    L17:
        r101.f522643g = Long.valueOf(System.nanoTime());
        if (r100 == null) goto L27;
        b(r102).putString(r100, f518598d.toJson(r101));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        Log.e("DOCS_ICON_DocMetaDataManager", "insertOrUpdateMetaInfo error " + e.getMessage());
        return;
    L27:
        return;
    L9:
        if (Intrinsics.areEqual(r101.f522640d, r104.f522640d) == true) goto L11;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L17;
        return;
    L11:
        if (Intrinsics.areEqual(r101.f522641e, r104.f522641e) == false) goto L15;
        if (Intrinsics.areEqual(r101.f522645i, r104.f522645i) == false) goto L15;
        r105 = true;
        goto L16
    }
}
