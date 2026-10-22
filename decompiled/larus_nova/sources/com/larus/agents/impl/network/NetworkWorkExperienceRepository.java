package com.larus.agents.impl.network;

import com.bytedance.retrofit2.SsResponse;
import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.experience.o;
import com.larus.agents.impl.experience.p;
import com.larus.agents.impl.experience.r;
import com.larus.agents.impl.experience.s;
import com.larus.agents.impl.experience.t;
import com.larus.agents.impl.experience.u;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class NetworkWorkExperienceRepository implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286703a = 0;

    public static final class a {
    }

    static {
    }

    public NetworkWorkExperienceRepository() {
    }

    public static boolean f(BizResponse r100) {
        SsResponse<String> r101 = r100.getSSResponse();
        if (r101 == null) goto L5;
        String r102 = r101.body();
    L6:
        boolean r103 = false;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L30;
        return true;
    L30:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L22
        JSONObject r106 = new JSONObject(r102);     // Catch: Throwable -> L22
        if (r106.has("error") == true) goto L18;
    L20:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L22
    L25:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L29;
        FLogger.f375446a.w("WorkExperienceRemote", "parse experience response envelope failed");
        r107 = Boolean.TRUE;
    L29:
        return ((Boolean) r107).booleanValue();
    L18:
        if (r106.isNull("error") == true) goto L20;
        r103 = true;
    L22:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L9:
        if (StringsKt.isBlank(r102) == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public static JSONObject j(p r100) {
        return new JSONObject().put("name", r100.f286681a).put("description", r100.f286682b).put("details", r100.f286683c).put("auto_optimize", r100.f286684d);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object e(Continuation<? super Result<Boolean>> r100) {
        if ((r100 instanceof NetworkWorkExperienceRepository$getEnabled$1) == false) goto L7;
        NetworkWorkExperienceRepository$getEnabled$1 r101 = (NetworkWorkExperienceRepository$getEnabled$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        dm9.a r107 = (dm9.a) r103;
        if ((r107 instanceof dm9.a.b) == false) goto L36;
        BizResponse<T> r108 = ((dm9.a.b) r107).f469231a;
        k r109 = (k) r108.getData();
        if (r109 == null) goto L24;
        n r110 = r109.a();
        if (r110 == null) goto L24;
        Boolean r111 = r110.a();
    L26:
        if (f(r108) == false) goto L28;
    L30:
        r106 = false;
    L31:
        if (r106 == false) goto L34;
        if (r111 == null) goto L34;
        return Result.m9449constructorimpl(r111);
    L34:
        g("get settings", r108.getCode());
        Result.Companion r112 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("get experience settings failed")));
    L28:
        if (r108.isSuccess() == false) goto L30;
    L24:
        r111 = null;
        goto L26
    L36:
        if ((r107 instanceof dm9.a.C5690a) == false) goto L40;
        return i((dm9.a.C5690a) r107, "get experience settings");
    L40:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        int r113 = l.f286705a;
        JSONObject r114 = new JSONObject();
        r101.label = 1;
        r103 = l.a("/alice/office/experience/manage/get_settings", k.class, r114, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new NetworkWorkExperienceRepository$getEnabled$1(this, r100);
        goto L8
    }

    public static void g(String r100, long r101) {
        FLogger.f375446a.w("WorkExperienceRemote", r100 + " experience failed, code=" + r101);
    }

    public static Object i(dm9.a.C5690a r100, String r101) {
        FLogger.f375446a.w("WorkExperienceRemote", r101 + " request error, code=" + r100.f469228a);
        Result.Companion r102 = Result.Companion;
        Throwable r103 = r100.f469230c;
        if (r103 != null) goto L6;
        r103 = new IllegalStateException(r101.concat(" request error"));
    L6:
        return Result.m9449constructorimpl(ResultKt.createFailure(r103));
    }

    @Override // com.larus.agents.impl.network.m
    public final Object a(p r100, Continuation<? super WorkExperienceMutationResult> r101) {
        return h("/alice/office/experience/manage/create", "create", c.class, j(r100), new g(), r101);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object b(final boolean r100, Continuation<? super WorkExperienceMutationResult> r101) {
        return h("/alice/office/experience/manage/update_settings", "update settings", k.class, new JSONObject().put("enabled", r100), new h(r100), r101);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object c(String r100, Continuation<? super Result<com.larus.agents.impl.experience.n>> r101) {
        if ((r101 instanceof NetworkWorkExperienceRepository$getDetail$1) == false) goto L7;
        NetworkWorkExperienceRepository$getDetail$1 r102 = (NetworkWorkExperienceRepository$getDetail$1) r101;
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
        if ((r108 instanceof dm9.a.b) == false) goto L48;
        BizResponse<T> r109 = ((dm9.a.b) r108).f469231a;
        if (f(r109) == false) goto L22;
    L24:
        r107 = false;
    L25:
        if (r107 == false) goto L46;
        c r110 = (c) r109.getData();
        if (r110 == null) goto L42;
        o r111 = r110.a();
        if (r111 == null) goto L42;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        u r112 = r111.c();
        if (r112 == null) goto L42;
        t r113 = r.a(r112);
        if (r113 == null) goto L42;
        String r114 = r111.a();
        if (r114 == null) goto L42;
        String r115 = r111.b();
        if (r115 != null) goto L41;
        r115 = "";
    L41:
        com.larus.agents.impl.experience.n r116 = new com.larus.agents.impl.experience.n(r113, r114, r115);
    L43:
        if (r116 != null) goto L53;
        Result.Companion r117 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("experience detail is empty")));
    L53:
        return Result.m9449constructorimpl(r116);
    L42:
        r116 = null;
        goto L43
    L46:
        g("get detail", r109.getCode());
        Result.Companion r118 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("get experience detail failed")));
    L22:
        if (r109.isSuccess() == false) goto L24;
    L48:
        if ((r108 instanceof dm9.a.C5690a) == false) goto L52;
        return i((dm9.a.C5690a) r108, "get experience detail");
    L52:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r119 = l.f286705a;
        JSONObject r120 = new JSONObject().put("experience_id", r100);
        r102.label = 1;
        r104 = l.a("/alice/office/experience/manage/get_detail", c.class, r120, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new NetworkWorkExperienceRepository$getDetail$1(this, r101);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object delete(String r100, Continuation<? super WorkExperienceMutationResult> r101) {
        return h("/alice/office/experience/manage/delete", "delete", b.class, new JSONObject().put("experience_id", r100), new f(), r101);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object d(int r100, String r101, Continuation<? super Result<s>> r102) {
        if ((r102 instanceof NetworkWorkExperienceRepository$list$1) == false) goto L7;
        NetworkWorkExperienceRepository$list$1 r103 = (NetworkWorkExperienceRepository$list$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        String r108 = null;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L25:
        dm9.a r109 = (dm9.a) r105;
        if ((r109 instanceof dm9.a.b) == false) goto L61;
        BizResponse<T> r110 = ((dm9.a.b) r109).f469231a;
        e r111 = (e) r110.getData();
        if (f(r110) == false) goto L30;
    L32:
        boolean r112 = false;
    L33:
        if (r112 == false) goto L59;
        if (r111 == null) goto L36;
        List<u> r113 = r111.b();
    L37:
        if (r113 == null) goto L59;
        if (r111.a() == null) goto L59;
        List<u> r114 = r111.b();
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L42:
        if (r116.hasNext() == false) goto L50;
        u r117 = (u) r116.next();
        if (r117 == null) goto L46;
        t r118 = r.a(r117);
    L47:
        if (r118 == null) goto L42;
        r115.add(r118);
        goto L42
    L46:
        r118 = null;
        goto L47
    L50:
        if (r115.size() == r111.b().size()) goto L53;
        g("list malformed item", r110.getCode());
        Result.Companion r119 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("list experiences contains malformed item")));
    L53:
        Result.Companion r120 = Result.Companion;
        String r121 = r111.c();
        if (r121 == null) goto L71;
        if ((!StringsKt.isBlank(r121)) == false) goto L71;
        r108 = r121;
    L71:
        return Result.m9449constructorimpl(new s(r115, r108, r111.a().booleanValue()));
    L36:
        r113 = null;
    L59:
        g("list", r110.getCode());
        Result.Companion r122 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("list experiences failed")));
    L30:
        if (r110.isSuccess() == false) goto L32;
        r112 = true;
        goto L33
    L61:
        if ((r109 instanceof dm9.a.C5690a) == false) goto L65;
        return i((dm9.a.C5690a) r109, "list experiences");
    L65:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        JSONObject r123 = new JSONObject().put("page_size", RangesKt.coerceIn(r100, 1, 100));
        if (r101 != null) goto L17;
    L22:
        int r124 = l.f286705a;
        Intrinsics.checkNotNull(r123);
        r103.label = 1;
        r105 = l.a("/alice/office/experience/manage/list", e.class, r123, r103);
        if (r105 != r106) goto L25;
        return r106;
    L17:
        if ((!StringsKt.isBlank(r101)) == true) goto L20;
        r101 = null;
    L20:
        if (r101 == null) goto L22;
        r123.put("page_token", r101);
    L7:
        r103 = new NetworkWorkExperienceRepository$list$1(this, r102);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object update(String r100, p r101, Continuation<? super WorkExperienceMutationResult> r110) {
        return h("/alice/office/experience/manage/update", "update", c.class, j(r101).put("experience_id", r100), new i(), r110);
    }

    public final <T> Object h(String r100, String r101, Class<T> r102, JSONObject r103, Function1<? super T, Boolean> r104, Continuation<? super WorkExperienceMutationResult> r110) {
        if ((r110 instanceof NetworkWorkExperienceRepository$mutation$1) == false) goto L7;
        NetworkWorkExperienceRepository$mutation$1 r105 = (NetworkWorkExperienceRepository$mutation$1) r110;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r111 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r104 = (Function1) r105.L$1;
        r101 = (String) r105.L$0;
        ResultKt.throwOnFailure(r111);
    L17:
        dm9.a r112 = (dm9.a) r111;
        if ((r112 instanceof dm9.a.b) == false) goto L43;
        BizResponse<T> r109 = ((dm9.a.b) r112).f469231a;
        if (r109.getCode() == 0) goto L32;
        long r113 = r109.getCode();
        if (r113 != 0) goto L25;
        WorkExperienceMutationResult r114 = WorkExperienceMutationResult.SUCCESS;
    L35:
        WorkExperienceMutationResult r115 = WorkExperienceMutationResult.SUCCESS;
        if (r114 == r115) goto L38;
    L40:
        if (r114 == r115) goto L48;
        g(r101, r109.getCode());
        return r114;
    L48:
        return r114;
    L38:
        if (r104.invoke(r109.getData()).booleanValue() == true) goto L40;
        r114 = WorkExperienceMutationResult.FAILURE;
        goto L40
    L25:
        if (r113 != 671020000) goto L28;
        r114 = WorkExperienceMutationResult.SECURITY_RISK;
        goto L35
    L28:
        if (r113 != 671000006) goto L30;
        r114 = WorkExperienceMutationResult.DUPLICATE_NAME;
        goto L35
    L30:
        r114 = WorkExperienceMutationResult.FAILURE;
        goto L35
    L32:
        if (f(r109) == false) goto L34;
        r114 = WorkExperienceMutationResult.FAILURE;
        goto L35
    L34:
        r114 = WorkExperienceMutationResult.SUCCESS;
        goto L35
    L43:
        if ((r112 instanceof dm9.a.C5690a) == false) goto L47;
        FLogger.f375446a.w("WorkExperienceRemote", r101 + " experience request error, code=" + ((dm9.a.C5690a) r112).f469228a);
        return WorkExperienceMutationResult.FAILURE;
    L47:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        int r116 = l.f286705a;
        r105.L$0 = r101;
        r105.L$1 = r104;
        r105.label = 1;
        r111 = l.a(r100, r102, r103, r105);
        if (r111 != r107) goto L17;
        return r107;
    L7:
        r105 = new NetworkWorkExperienceRepository$mutation$1(this, r110);
        goto L8
    }
}
