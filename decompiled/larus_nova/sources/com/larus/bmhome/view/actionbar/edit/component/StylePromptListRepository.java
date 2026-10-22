package com.larus.bmhome.view.actionbar.edit.component;

import com.bytedance.keva.Keva;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class StylePromptListRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StylePromptListRepository f316186a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f316187b = null;

    public StylePromptListRepository() {
    }

    static {
        f316186a = new StylePromptListRepository();
        f316187b = new LinkedHashSet();
    }

    public static void d(String r100) {
        Set<String> r101 = f316187b;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c(String r100, List r101) {
        if ((!r101.isEmpty()) == false) goto L13;
        Lazy r102 = n2.f316413a;
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r101, "promptList");
        String r103 = "style_prompt_list_" + r100;
        FLogger.f375446a.i("StylePromptListCacheStore", "storeDisk, cacheKey=" + r103 + " promptListSize=" + r101.size());
        ((Keva) n2.f316413a.getValue()).storeString(r103, HttpExtKt.f360123f.toJson(r101));     // Catch: Exception -> L7
    L9:
        Lazy r104 = n2.f316413a;
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        String r105 = "style_prompt_list_" + r100;
        FLogger.f375446a.i("StylePromptListCacheStore", "clearMemoryCache, cacheKey=" + r105);
        ((ConcurrentHashMap) n2.f316414b.getValue()).remove(r105);
        n2.a(r100);
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("StylePromptListCacheStore", "save cache error=" + e.getMessage());
        goto L9
    }

    public final Object a(String r100, Continuation<? super StylePromptListApi.GetStylePromptListData> r101) {
        if ((r101 instanceof StylePromptListRepository$fetchPromptListFromRemote$1) == false) goto L7;
        StylePromptListRepository$fetchPromptListFromRemote$1 r102 = (StylePromptListRepository$fetchPromptListFromRemote$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        dm9.a r108 = (dm9.a) r104;
        if ((r108 instanceof dm9.a.b) == false) goto L32;
        dm9.a.b r109 = (dm9.a.b) r108;
        StylePromptListApi.GetStylePromptListData r110 = (StylePromptListApi.GetStylePromptListData) r109.f469231a.getData();
        if (r110 == null) goto L22;
        List<StylePromptListApi.StylePromptInfo> r111 = r110.getPromptList();
    L23:
        List<StylePromptListApi.StylePromptInfo> r112 = r111;
        if (r112 != null) goto L26;
    L29:
        if (r107 == false) goto L42;
        FLogger.f375446a.e("StylePromptListRepository", "fetchPromptListFromRemote success but return empty list");
        return null;
    L42:
        return (StylePromptListApi.GetStylePromptListData) r109.f469231a.getData();
    L26:
        if (r112.isEmpty() == true) goto L29;
        r107 = false;
        goto L29
    L22:
        r111 = null;
        goto L23
    L32:
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("fetchPromptListFromRemote failed, msg: ");
        if ((r108 instanceof dm9.a.C5690a) == false) goto L35;
        dm9.a.C5690a r115 = (dm9.a.C5690a) r108;
    L36:
        if (r115 == null) goto L38;
        String r116 = r115.f469229b;
    L39:
        r114.append(r116);
        r113.e("StylePromptListRepository", r114.toString());
        return null;
    L38:
        r116 = null;
        goto L39
    L35:
        r115 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        StylePromptListApi.a r117 = StylePromptListApi.f316183a;
        StylePromptListRepository$fetchPromptListFromRemote$resp$1 r118 = new StylePromptListRepository$fetchPromptListFromRemote$resp$1(r100, null);
        r102.label = 1;
        r117.getClass();
        r104 = BuildersKt.withContext(Dispatchers.getIO(), new StylePromptListApi$Companion$safeCall$2(r118, null), r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new StylePromptListRepository$fetchPromptListFromRemote$1(this, r101);
        goto L8
    }

    public final Object b(String r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof StylePromptListRepository$preload$1) == false) goto L7;
        StylePromptListRepository$preload$1 r102 = (StylePromptListRepository$preload$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L28:
        StylePromptListApi.GetStylePromptListData r107 = (StylePromptListApi.GetStylePromptListData) r104;     // Catch: Throwable -> L14
        if (r107 == null) goto L34;
        List<StylePromptListApi.StylePromptInfo> r108 = r107.getPromptList();     // Catch: Throwable -> L14
        if (r108 != null) goto L33;
        r108 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
    L33:
        c(r100, CollectionsKt.filterNotNull(r108));     // Catch: Throwable -> L14
    L34:
        d(r100);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        n2.a(r100);
        Set<String> r109 = f316187b;
        monitor-enter(r109);
        boolean r110 = r109.add(r100);     // Catch: Throwable -> L38
        monitor-exit(r109);
        if (r110 == false) goto L24;
        r102.L$0 = r100;     // Catch: Throwable -> L14
        r102.label = 1;     // Catch: Throwable -> L14
        r104 = a(r100, r102);     // Catch: Throwable -> L14
        if (r104 != r105) goto L28;
        return r105;
    L24:
        return Unit.INSTANCE;
    L38:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        d(r100);
        throw th;
    L7:
        r102 = new StylePromptListRepository$preload$1(this, r101);
        goto L8
    }
}
