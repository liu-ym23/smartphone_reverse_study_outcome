package com.larus.showcase.service;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.j1;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.model.showcase.RecommendCaseResponse;
import com.larus.showcase.api.CaseApi;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CaseRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CaseRepo f369269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, List<Message>> f369270b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, List<Message>> f369271c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Case> f369272d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Case> f369273e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Case> f369274f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f369275g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CopyOnWriteArrayList<j1> f369276h = null;

    public CaseRepo() {
    }

    static {
        f369269a = new CaseRepo();
        f369270b = new LruCache(50);
        f369271c = new LruCache(50);
        f369272d = new CopyOnWriteArrayList();
        f369273e = new CopyOnWriteArrayList();
        f369274f = new CopyOnWriteArrayList();
        f369275g = LazyKt.lazy(new a());
        f369276h = new CopyOnWriteArrayList();
    }

    public static Object d(Continuation r100) {
        return BuildersKt.withContext(RepoDispatcherDelegate.f307737b.g(), new CaseRepo$getCacheWholeCaseList$2(null), r100);
    }

    public static List e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caseId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return null;
    L9:
        List<Message> r102 = f369271c.get(r100);
        if (r102 == null) goto L12;
        return r102;
    L12:
        return f369270b.get(r100);
    L5:
        r101 = false;
        goto L6
    }

    public final Object c(Continuation<? super Unit> r110) {
        if ((r110 instanceof CaseRepo$fetchRecommendCaseList$1) == false) goto L7;
        CaseRepo$fetchRecommendCaseList$1 r100 = (CaseRepo$fetchRecommendCaseList$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        CaseRepo r104 = f369269a;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L19;
        if (r103 == 4) goto L18;
        if (r103 != 5) goto L17;
        Iterator r105 = (Iterator) r100.L$1;
        List<Case> r106 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L79:
        if (r105.hasNext() == false) goto L83;
        String r112 = ((Case) r105.next()).getCaseId();
        r100.L$0 = r106;
        r100.L$1 = r105;
        r100.label = 5;
        if (r104.i(r112, true, r100) != r102) goto L79;
        return r102;
    L83:
        List<Case> r107 = r106;
    L84:
        Iterator<j1> r113 = f369276h.iterator();
    L86:
        if (r113.hasNext() == false) goto L94;
        j1 r108 = r113.next();
        if (r107 != null) goto L90;
        List<Case> r109 = new ArrayList();
    L91:
        r108.av(r109);
        goto L86
    L90:
        r109 = r107;
    L94:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r107 = (List) r100.L$1;
        List<Case> r114 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L76:
        if (r114 == null) goto L84;
        Iterator r115 = r114.iterator();
        r106 = r107;
        r105 = r115;
        goto L79
    L19:
        List<Case> r116 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L48:
        dm9.a r117 = (dm9.a) r111;
        if ((r117 instanceof dm9.a.b) == false) goto L92;
        dm9.a.b r118 = (dm9.a.b) r117;
        if (r118.f469231a.isSuccess() == false) goto L92;
        RecommendCaseResponse r119 = (RecommendCaseResponse) r118.f469231a.getData();
        if (r119 == null) goto L57;
        List<Case> r120 = r119.getCaseList();
        if (r120 == null) goto L57;
        List<Case> r121 = CollectionsKt.filterNotNull(r120);
    L58:
        if (r121 == null) goto L69;
        Iterator r122 = r121.iterator();
    L61:
        if (r122.hasNext() == false) goto L69;
        Case r123 = (Case) r122.next();
        RecommendCaseResponse r124 = (RecommendCaseResponse) r118.f469231a.getData();
        if (r124 == null) goto L67;
        Map<String, String> r125 = r124.getExtra();
        if (r125 == null) goto L67;
        String r126 = r125.get("request_id");
    L68:
        r123.setRequestId(r126);
    L67:
        r126 = null;
    L69:
        r100.L$0 = r116;
        r100.L$1 = r121;
        r100.label = 4;
        Object r127 = BuildersKt.withContext(RepoDispatcherDelegate.f307737b.g(), new CaseRepo$saveRecommendCaseList$2(r121, null), r100);
        if (r127 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L73;
        r127 = Unit.INSTANCE;
    L73:
        if (r127 != r102) goto L75;
        return r102;
    L75:
        r114 = r116;
        r107 = r121;
    L57:
        r121 = null;
    L92:
        FLogger.f375446a.e("CaseRepo", "fetchRecommendCaseList error");
        goto L94
    L20:
        Iterator r128 = (Iterator) r100.L$1;
        List<Case> r129 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L36:
        if (r128.hasNext() == false) goto L40;
        String r130 = ((Case) r128.next()).getCaseId();
        r100.L$0 = r129;
        r100.L$1 = r128;
        r100.label = 2;
        if (r104.i(r130, true, r100) != r102) goto L36;
        return r102;
    L40:
        CopyOnWriteArrayList<Case> r131 = f369274f;
        r131.clear();
        r131.addAll(r129);
        Iterator<j1> r132 = f369276h.iterator();
    L42:
        if (r132.hasNext() == false) goto L44;
        r132.next().av(r129);
    L44:
        CaseApi.a r133 = CaseApi.f369255a;
        CaseRepo$fetchRecommendCaseList$result$1 r134 = new CaseRepo$fetchRecommendCaseList$result$1(null);
        r100.L$0 = r129;
        r100.L$1 = null;
        r100.label = 3;
        r133.getClass();
        r111 = CaseApi.a.a(r134, r100);
        if (r111 != r102) goto L47;
        return r102;
    L47:
        r116 = r129;
        goto L48
    L21:
        ResultKt.throwOnFailure(r111);
    L25:
        r129 = (List) r111;
        List<Case> r135 = r129;
        if (r135 != null) goto L28;
    L31:
        boolean r136 = true;
    L32:
        if (r136 == true) goto L44;
        if (r129 == null) goto L40;
        r128 = r129.iterator();
        goto L36
    L28:
        if (r135.isEmpty() == true) goto L31;
        r136 = false;
        goto L32
    L22:
        ResultKt.throwOnFailure(r111);
        FLogger.f375446a.i("CaseRepo", "fetchRecommendCaseList");
        r100.label = 1;
        r111 = BuildersKt.withContext(RepoDispatcherDelegate.f307737b.g(), new CaseRepo$getCacheRecommendCaseList$2(null), r100);
        if (r111 != r102) goto L25;
        return r102;
    L7:
        r100 = new CaseRepo$fetchRecommendCaseList$1(this, r110);
        goto L8
    }

    public final Object a(String r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof CaseRepo$clickCase$1) == false) goto L7;
        CaseRepo$clickCase$1 r101 = (CaseRepo$clickCase$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = false;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        dm9.a r106 = (dm9.a) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L66:
        if ((r106 instanceof dm9.a.b) == false) goto L71;
        if (((dm9.a.b) r106).f469231a.isSuccess() == false) goto L71;
        r105 = true;
    L71:
        return Boxing.boxBoolean(r105);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L41:
        dm9.a r112 = (dm9.a) r111;
        if ((r112 instanceof dm9.a.b) == true) goto L44;
    L46:
        boolean r107 = false;
    L47:
        if (r107 == false) goto L64;
        Case r108 = h(this, r100, true, 4);
        if (r108 == null) goto L51;
        r108.setStatus(Boxing.boxInt(1));
    L51:
        if (r108 == null) goto L64;
        if (f369274f.contains(r108) == false) goto L64;
        Iterator<j1> r109 = f369276h.iterator();
    L56:
        if (r109.hasNext() == false) goto L58;
        r109.next().av(f369274f);
        goto L56
    L58:
        ArrayList r113 = new ArrayList();
        r113.addAll(f369274f);
        r101.L$0 = r112;
        r101.label = 2;
        Object r114 = BuildersKt.withContext(RepoDispatcherDelegate.f307737b.g(), new CaseRepo$saveRecommendCaseList$2(r113, null), r101);
        if (r114 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        r114 = Unit.INSTANCE;
    L62:
        if (r114 != r103) goto L64;
        return r103;
    L64:
        r106 = r112;
        goto L66
    L44:
        if (((dm9.a.b) r112).f469231a.isSuccess() == false) goto L46;
        r107 = true;
        goto L47
    L16:
        ResultKt.throwOnFailure(r111);
        if (r100 != null) goto L19;
    L22:
        boolean r115 = true;
    L23:
        if (r115 == true) goto L25;
        Case r116 = g(r100, true, false);
        if (r116 == null) goto L34;
        Integer r117 = r116.getStatus();
        if (r117 == null) goto L34;
        if (r117.intValue() != 1) goto L34;
        boolean r118 = true;
    L35:
        if (r118 == true) goto L37;
        CaseApi.a r119 = CaseApi.f369255a;
        CaseRepo$clickCase$resp$1 r120 = new CaseRepo$clickCase$resp$1(r100, null);
        r101.L$0 = r100;
        r101.label = 1;
        r119.getClass();
        r111 = CaseApi.a.a(r120, r101);
        if (r111 != r103) goto L41;
        return r103;
    L37:
        return Boxing.boxBoolean(true);
    L34:
        r118 = false;
        goto L35
    L25:
        return Boxing.boxBoolean(false);
    L19:
        if (r100.length() == 0) goto L22;
        r115 = false;
    L7:
        r101 = new CaseRepo$clickCase$1(this, r110);
        goto L8
    }

    public final Object b(String r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof CaseRepo$deleteCase$1) == false) goto L7;
        CaseRepo$deleteCase$1 r102 = (CaseRepo$deleteCase$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L27:
        dm9.a r108 = (dm9.a) r104;
        boolean r109 = r108 instanceof dm9.a.b;
        if (r109 == true) goto L30;
    L32:
        boolean r110 = false;
    L33:
        if (r110 == false) goto L44;
        Case r111 = h(this, r100, true, 4);
        if (r111 == null) goto L37;
        r111.setStatus(Boxing.boxInt(2));
    L37:
        if (r111 == null) goto L44;
        if (f369274f.contains(r111) == false) goto L44;
        Iterator<j1> r112 = f369276h.iterator();
    L42:
        if (r112.hasNext() == false) goto L44;
        r112.next().av(f369274f);
    L44:
        if (r109 == false) goto L49;
        if (((dm9.a.b) r108).f469231a.isSuccess() == false) goto L49;
        r107 = true;
    L49:
        return Boxing.boxBoolean(r107);
    L30:
        if (((dm9.a.b) r108).f469231a.isSuccess() == false) goto L32;
        r110 = true;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 != null) goto L17;
    L20:
        boolean r113 = true;
    L21:
        if (r113 == true) goto L23;
        CaseApi.a r114 = CaseApi.f369255a;
        CaseRepo$deleteCase$resp$1 r115 = new CaseRepo$deleteCase$resp$1(r100, null);
        r102.L$0 = r100;
        r102.label = 1;
        r114.getClass();
        r104 = CaseApi.a.a(r115, r102);
        if (r104 != r105) goto L27;
        return r105;
    L23:
        return Boxing.boxBoolean(false);
    L17:
        if (r100.length() == 0) goto L20;
        r113 = false;
    L7:
        r102 = new CaseRepo$deleteCase$1(this, r101);
        goto L8
    }

    public final Object j(String r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof CaseRepo$updateCreateTime$1) == false) goto L7;
        CaseRepo$updateCreateTime$1 r102 = (CaseRepo$updateCreateTime$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L27:
        dm9.a r108 = (dm9.a) r104;
        if ((r108 instanceof dm9.a.b) == true) goto L30;
    L32:
        if (r107 == false) goto L42;
        Case r109 = g(r100, true, true);
        if (r109 == null) goto L36;
        r109.setCreateTime(Boxing.boxLong(System.currentTimeMillis()));
        Iterator<j1> r110 = f369276h.iterator();
    L39:
        if (r110.hasNext() == false) goto L42;
        r110.next().av(f369274f);
        goto L39
    L36:
        return Unit.INSTANCE;
    L42:
        return Unit.INSTANCE;
    L30:
        if (((dm9.a.b) r108).f469231a.isSuccess() == false) goto L32;
        r107 = true;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 != null) goto L17;
    L20:
        boolean r111 = true;
    L21:
        if (r111 == true) goto L23;
        CaseApi.a r112 = CaseApi.f369255a;
        CaseRepo$updateCreateTime$resp$1 r113 = new CaseRepo$updateCreateTime$resp$1(r100, null);
        r102.L$0 = r100;
        r102.label = 1;
        r112.getClass();
        r104 = CaseApi.a.a(r113, r102);
        if (r104 != r105) goto L27;
        return r105;
    L23:
        return Unit.INSTANCE;
    L17:
        if (r100.length() == 0) goto L20;
        r111 = false;
    L7:
        r102 = new CaseRepo$updateCreateTime$1(this, r101);
        goto L8
    }

    public static Case g(String r210, boolean r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r210, "caseId");
        if (r210.length() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L9;
        return null;
    L9:
        Iterator<Case> r101 = f369274f.iterator();
    L11:
        if (r101.hasNext() == false) goto L15;
        Case r102 = r101.next();
        if (Intrinsics.areEqual(r102.getCaseId(), r210) == false) goto L11;
    L16:
        Case r103 = r102;
        if (r103 == null) goto L22;
        if (r211 == false) goto L21;
        CopyOnWriteArrayList<Case> r104 = f369274f;
        int r105 = r104.indexOf(r103);
        r104.remove(r103);
        Case r106 = Case.copy$default(r103, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, 32767, null);
        r104.add(r105, r106);
        return r106;
    L21:
        return r103;
    L22:
        if (r212 == false) goto L24;
        return null;
    L24:
        Iterator<Case> r107 = f369272d.iterator();
    L26:
        if (r107.hasNext() == false) goto L30;
        Case r108 = r107.next();
        if (Intrinsics.areEqual(r108.getCaseId(), r210) == false) goto L26;
    L31:
        Case r109 = r108;
        if (r109 == null) goto L37;
        if (r211 == false) goto L36;
        CopyOnWriteArrayList<Case> r110 = f369272d;
        int r111 = r110.indexOf(r109);
        r110.remove(r109);
        Case r112 = Case.copy$default(r109, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, 32767, null);
        r110.add(r111, r112);
        return r112;
    L36:
        return r109;
    L37:
        return null;
    L30:
        r108 = null;
        goto L31
    L15:
        r102 = null;
        goto L16
    L5:
        r100 = false;
        goto L7
    }

    public static Object k(List r100, boolean r101, Continuation r102) {
        Object r103 = BuildersKt.withContext(RepoDispatcherDelegate.f307737b.g(), new CaseRepo$updateWholeCase2Cache$2(r100, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final Object f(String r100, boolean r101, Continuation<? super List<Message>> r102) {
        if ((r102 instanceof CaseRepo$getCaseMessageListByRemote$1) == false) goto L7;
        CaseRepo$getCaseMessageListByRemote$1 r103 = (CaseRepo$getCaseMessageListByRemote$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        List<Message> r108 = null;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L33:
        dm9.a r109 = (dm9.a) r105;
        if ((r109 instanceof dm9.a.b) == false) goto L51;
        dm9.a.b r110 = (dm9.a.b) r109;
        if (r110.f469231a.isSuccess() == false) goto L51;
        List r111 = (List) r110.f469231a.getData();
        if (r111 == null) goto L40;
        r108 = kr9.a.a(r111);
    L40:
        if (r101 == false) goto L46;
        LruCache<String, List<Message>> r112 = f369271c;
        if (r108 != null) goto L44;
        List<Message> r113 = new ArrayList();
    L45:
        List<Message> r114 = r112.put(r100, r113);
        goto L51
    L44:
        r113 = r108;
        goto L45
    L46:
        LruCache<String, List<Message>> r115 = f369270b;
        if (r108 != null) goto L49;
        List<Message> r116 = new ArrayList();
    L50:
        List<Message> r117 = r115.put(r100, r116);
        goto L51
    L49:
        r116 = r108;
    L51:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        boolean r118 = false;
        if (r100 != null) goto L17;
    L20:
        boolean r119 = true;
    L21:
        if (r119 == false) goto L23;
        return null;
    L23:
        List r120 = e(r100);
        List r121 = r120;
        if (r121 != null) goto L26;
    L27:
        r118 = true;
    L28:
        if (r118 == true) goto L30;
        return r120;
    L30:
        CaseApi.a r122 = CaseApi.f369255a;
        CaseRepo$getCaseMessageListByRemote$resp$1 r123 = new CaseRepo$getCaseMessageListByRemote$resp$1(r100, null);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        r103.label = 1;
        r122.getClass();
        r105 = CaseApi.a.a(r123, r103);
        if (r105 != r106) goto L33;
        return r106;
    L26:
        if (r121.isEmpty() == false) goto L28;
    L17:
        if (r100.length() == 0) goto L20;
        r119 = false;
    L7:
        r103 = new CaseRepo$getCaseMessageListByRemote$1(this, r102);
        goto L8
    }

    public final Object i(String r100, boolean r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof CaseRepo$preFetchCaseMessageListByRemote$1) == false) goto L7;
        CaseRepo$preFetchCaseMessageListByRemote$1 r103 = (CaseRepo$preFetchCaseMessageListByRemote$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        List<Message> r108 = null;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L34:
        dm9.a r109 = (dm9.a) r105;
        if ((r109 instanceof dm9.a.b) == false) goto L51;
        dm9.a.b r110 = (dm9.a.b) r109;
        if (r110.f469231a.isSuccess() == false) goto L51;
        List r111 = (List) r110.f469231a.getData();
        if (r111 == null) goto L41;
        r108 = kr9.a.a(r111);
    L41:
        if (r101 == false) goto L46;
        LruCache<String, List<Message>> r112 = f369271c;
        if (r108 != null) goto L45;
        r108 = new ArrayList();
    L45:
        List<Message> r113 = r112.put(r100, r108);
        goto L51
    L46:
        LruCache<String, List<Message>> r114 = f369270b;
        if (r108 != null) goto L49;
        r108 = new ArrayList();
    L49:
        List<Message> r115 = r114.put(r100, r108);
    L51:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r100 != null) goto L17;
    L20:
        boolean r116 = true;
    L21:
        if (r116 == false) goto L25;
        return Unit.INSTANCE;
    L25:
        if (e(r100) != null) goto L27;
        if (r101 == false) goto L30;
        List<Message> r117 = f369271c.put(r100, new ArrayList());
    L31:
        CaseApi.a r118 = CaseApi.f369255a;
        CaseRepo$preFetchCaseMessageListByRemote$resp$1 r119 = new CaseRepo$preFetchCaseMessageListByRemote$resp$1(r100, null);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        r103.label = 1;
        r118.getClass();
        r105 = CaseApi.a.a(r119, r103);
        if (r105 != r106) goto L34;
        return r106;
    L30:
        List<Message> r120 = f369270b.put(r100, new ArrayList());
        goto L31
    L27:
        return Unit.INSTANCE;
    L17:
        if (r100.length() == 0) goto L20;
        r116 = false;
    L7:
        r103 = new CaseRepo$preFetchCaseMessageListByRemote$1(this, r102);
        goto L8
    }

    public static /* synthetic */ Case h(CaseRepo r100, String r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.getClass();
        return g(r101, r102, false);
    }
}
