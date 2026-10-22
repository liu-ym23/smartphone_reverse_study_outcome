package com.larus.uaigc.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.api.x;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zd9.h;

/* JADX INFO: loaded from: classes31.dex */
public final class DataConverterKt {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((String) r100, (String) r101);
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((String) r100, (String) r101);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<Map<String, ? extends x>> {
        public c() {
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            CreationTask r102 = (CreationTask) r100;
            int r103 = 0;
            if (r102 == null) goto L7;
            Integer r104 = r102.index;
            if (r104 == null) goto L7;
            int r105 = r104.intValue();
        L8:
            Integer r106 = Integer.valueOf(r105);
            CreationTask r107 = (CreationTask) r101;
            if (r107 == null) goto L14;
            Integer r108 = r107.index;
            if (r108 == null) goto L14;
            r103 = r108.intValue();
        L14:
            return ComparisonsKt.compareValues(r106, Integer.valueOf(r103));
        L7:
            r105 = 0;
            goto L8
        }
    }

    public static final String h(int r100) {
        if (r100 != 1) goto L5;
        return "image";
    L5:
        if (r100 != 2) goto L7;
        return CreativeScene.IMAGE_TO_IMAGE;
    L7:
        if (r100 != 4) goto L9;
        return "music";
    L9:
        if (r100 != 5) goto L11;
        return CreativeScene.AVATAR_IMAGE;
    L11:
        if (r100 != 6) goto L13;
        return "video";
    L13:
        if (r100 == 7) goto L15;
        return "";
    L15:
        return CreativeScene.AI_BEAUTIFY_IMAGE;
    }

    public static final String b(BotModel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getBotType();
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L20:
        return "other_default";
    L11:
        if (r101.intValue() != 0) goto L20;
        BotCreatorInfo r102 = r100.getBotCreatorInfo();
        if (r102 == null) goto L15;
        String r103 = r102.getId();
    L17:
        if (Intrinsics.areEqual(r103, AccountService.f365697a.getUserId()) == false) goto L19;
        return "self_created";
    L19:
        return "others_created";
    L15:
        r103 = null;
        goto L17
    L6:
        if (r101.intValue() != 1) goto L8;
        return "default";
    }

    public static final Map<String, UserCreationFromIM> d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "creationStatusInfo");
        LinkedHashMap r100 = new LinkedHashMap();
        JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L27
        ArrayList r111 = new ArrayList();     // Catch: Exception -> L27
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L27
    L5:
        if (r102.hasNext() == false) goto L8;
        r111.add(r102.next());     // Catch: Exception -> L27
        goto L5
    L8:
        if (r111.size() <= 1) goto L10;
        CollectionsKt.sortWith(r111, new b());     // Catch: Exception -> L27
    L10:
        Iterator r112 = r111.iterator();     // Catch: Exception -> L27
    L11:
        if (r112.hasNext() == false) goto L26;
        String r103 = (String) r112.next();     // Catch: Exception -> L27
        String r104 = r101.optString(r103);     // Catch: Exception -> L27
        Gson r105 = new Gson();     // Catch: Exception -> L27
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L16
        Object r107 = Result.m9449constructorimpl((UserCreationFromIM) r105.fromJson(r104, UserCreationFromIM.class));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r107) == false) goto L21;
        r107 = null;
    L21:
        UserCreationFromIM r108 = (UserCreationFromIM) r107;     // Catch: Exception -> L27
        if (r108 != null) goto L24;
        r108 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);     // Catch: Exception -> L27
    L24:
        r100.put(r103, r108);     // Catch: Exception -> L27
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Exception -> L27
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L27
        goto L19
    L26:
        return r100;
    L27:
        e = move-exception;
        FLogger.f375446a.e("ChatCreationPagerFragment", "There have something wrong when parse!!!e=" + e.getMessage());
        return new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Map<String, x> f(String r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        T r103 = 0;
        Object r104 = null;
        r104 = null;
        if (r100 == null) goto L20;
        h r105 = h.f571481a;     // Catch: Throwable -> L22
        if (StringsKt.isBlank(r100) == false) goto L30;
    L19:
        r103 = (Map) r104;     // Catch: Throwable -> L22
        goto L20
    L30:
        r105.getClass();     // Catch: Throwable -> L10
        Object r106 = Result.m9449constructorimpl(h.f571482b.fromJson(r100, new c().getType()));     // Catch: Throwable -> L10
    L12:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L22
        if (r107 == null) goto L16;
        c0 r108 = c0.f348199b;     // Catch: Throwable -> L22
        StringBuilder r109 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r107, "<this>");     // Catch: Throwable -> L22
        r109.append(ExceptionsKt.stackTraceToString(r107));     // Catch: Throwable -> L22
        r108.e("GsonHolder", r109.toString());     // Catch: Throwable -> L22
    L16:
        if (Result.m9455isFailureimpl(r106) == true) goto L19;
        r104 = r106;
        goto L19
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L22
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L20:
        r101.element = r103;     // Catch: Throwable -> L22
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Map<String, x> r111 = (Map) r101.element;
        if (r111 == null) goto L27;
        return r111;
    L27:
        return MapsKt.emptyMap();
    L22:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public static final Map<String, CreationTask> g(CreationMsgContentData r100) {
        if (r100 == null) goto L22;
        CreationInfo r101 = r100.creationInfo;
        if (r101 == null) goto L22;
        Map<String, CreationTask> r102 = r101.taskInfo;
        if (r102 == null) goto L22;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, CreationTask>> r104 = r102.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L23;
        Map.Entry<String, CreationTask> r105 = r104.next();
        CreationTask r106 = r105.getValue();
        if (r106 == null) goto L19;
        Integer r107 = r106.status;
        if (r107 == null) goto L19;
        if (r107.intValue() != 4) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L10;
        r103.put(r105.getKey(), r105.getValue());
    L19:
        r108 = false;
    L23:
        if (r103 == null) goto L48;
        Collection r109 = r103.values();
        if (r109 == null) goto L49;
        List r110 = CollectionsKt.toList(r109);
        if (r110 == null) goto L50;
        List r111 = CollectionsKt.sortedWith(r110, new d());
        if (r111 == null) goto L51;
        List r112 = r111;
        LinkedHashMap r113 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r112, 10)), 16));
        Iterator r114 = r112.iterator();
    L32:
        if (r114.hasNext() == false) goto L39;
        Object r115 = r114.next();
        CreationTask r116 = (CreationTask) r115;
        if (r116 == null) goto L36;
        String r117 = r116.f310760id;
    L37:
        r113.put(r117, r115);
        goto L32
    L36:
        r117 = null;
        goto L37
    L39:
        return r113;
    L51:
        return null;
    L50:
        return null;
    L49:
        return null;
    L48:
        return null;
    L22:
        r103 = null;
        goto L23
    }

    public static final String a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.append(r100);
        r102.append('-');
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.append(r101);
        return r102.toString();
    }

    public static final Map<String, UserCreationFromIM> c(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "creationStatusInfo");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        LinkedHashMap r100 = new LinkedHashMap();
        JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L27
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L27
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L27
    L5:
        if (r102.hasNext() == false) goto L8;
        r112.add(r102.next());     // Catch: Exception -> L27
        goto L5
    L8:
        if (r112.size() <= 1) goto L10;
        CollectionsKt.sortWith(r112, new a());     // Catch: Exception -> L27
    L10:
        Iterator r113 = r112.iterator();     // Catch: Exception -> L27
    L11:
        if (r113.hasNext() == false) goto L26;
        String r103 = (String) r113.next();     // Catch: Exception -> L27
        String r104 = r111 + '_' + r103;     // Catch: Exception -> L27
        String r105 = r101.optString(r103);     // Catch: Exception -> L27
        Gson r106 = new Gson();     // Catch: Exception -> L27
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L16
        Object r108 = Result.m9449constructorimpl((UserCreationFromIM) r106.fromJson(r105, UserCreationFromIM.class));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r108) == false) goto L21;
        r108 = null;
    L21:
        UserCreationFromIM r109 = (UserCreationFromIM) r108;     // Catch: Exception -> L27
        if (r109 != null) goto L24;
        r109 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);     // Catch: Exception -> L27
    L24:
        r100.put(r104, r109);     // Catch: Exception -> L27
    L16:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Exception -> L27
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L27
        goto L19
    L26:
        return r100;
    L27:
        e = move-exception;
        FLogger.f375446a.e("ChatCreationPagerFragment", "There have something wrong when parse!!!e=" + e.getMessage());
        return r100;
    }

    public static final Object e(String r100, String r101, Continuation<? super UserCreationFromIM> r102) {
        if ((r102 instanceof DataConverterKt$getLatestPublishCreation$1) == false) goto L7;
        DataConverterKt$getLatestPublishCreation$1 r103 = (DataConverterKt$getLatestPublishCreation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        String r108 = "";
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L30:
        String r109 = (String) r105;
        if (r109 != null) goto L33;
        r109 = "";
    L33:
        Map<String, UserCreationFromIM> r110 = d(r109);
        if (r101 == null) goto L38;
        r108 = r101;
    L38:
        return ((LinkedHashMap) r110).get(r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r100 != null) goto L17;
    L20:
        boolean r111 = true;
    L21:
        if (r111 == false) goto L24;
        return null;
    L24:
        IChatRepoService r112 = RepoDispatcherDelegate.f307737b.e();
        if (r100 != null) goto L27;
        r100 = "";
    L27:
        r103.L$0 = r101;
        r103.label = 1;
        r105 = r112.w1(r100, r103);
        if (r105 != r106) goto L30;
        return r106;
    L17:
        if (r100.length() == 0) goto L20;
        r111 = false;
    L7:
        r103 = new DataConverterKt$getLatestPublishCreation$1(r102);
        goto L8
    }
}
