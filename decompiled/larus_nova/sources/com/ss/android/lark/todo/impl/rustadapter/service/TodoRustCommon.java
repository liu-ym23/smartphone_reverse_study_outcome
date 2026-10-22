package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.UDIcon;
import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.calendar.v1.GetParsedRruleTextRequest;
import com.bytedance.lark.pb.calendar.v1.GetParsedRruleTextResponse;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatRequest;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.lark.pb.todo.v1.GetTodoUsersByChatterIdsRequest;
import com.bytedance.lark.pb.todo.v1.GetTodoUsersByChatterIdsResponse;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoUserData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoRustCommon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TodoRustCommon f444251a = null;

    public static final class a implements RustLog.a<GetAnotherNameFormatResponse.FormatRule> {
        public a() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final /* bridge */ /* synthetic */ String a(GetAnotherNameFormatResponse.FormatRule r100) {
            return "";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            return GetAnotherNameFormatResponse.ADAPTER.decode(r100).rule;
        }
    }

    public static final class b<T> implements SdkSender.IParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f444252a = null;

        static {
            f444252a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            GetParsedRruleTextResponse r101 = GetParsedRruleTextResponse.ADAPTER.decode(r100);
            return new String[]{r101.parsed_rrule, r101.freq_part, r101.until_part};
        }
    }

    public static final class c implements RustLog.a<GetTodoUsersByChatterIdsResponse> {
        public c() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(GetTodoUsersByChatterIdsResponse r100) {
            GetTodoUsersByChatterIdsResponse r101 = r100;
            if (r101 == null) goto L8;
            List<TodoUser> r102 = r101.users;
            if (r102 == null) goto L8;
            String r103 = Integer.valueOf(r102.size()).toString();
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "NULL";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetTodoUsersByChatterIdsResponse.ADAPTER.decode(r100);
        }
    }

    static {
        f444251a = new TodoRustCommon();
    }

    public TodoRustCommon() {
    }

    public static String[] c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rRule");
        int r101 = k8c.a.f502137a;
        LanguageType r102 = k8c.a.f();
        GetParsedRruleTextRequest.Builder r103 = new GetParsedRruleTextRequest.Builder().rrule(r100).language_type(r102);
        String[] r104 = (String[]) SdkSender.syncSend(Command.GET_PARSED_RRULE_TEXT, r103, b.f444252a);
        if (r104 != null) goto L6;
        Log.e("Lark", "syncParsedRRuleTextRequest - get rules error");
        return new String[]{"", "", ""};
    L6:
        return r104;
    }

    public static UDIcon f(com.ss.android.lark.export.entity.preview.UDIcon r100) {
        Integer r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        ThemeColor r102 = r100.getThemeColor();
        if (r102 == null) goto L10;
        ThemeColor.Key r103 = r102.getKey();
        if (r103 == null) goto L10;
        ThemeColor.KeyType r104 = r103.getType();
    L11:
        if (r104 == null) goto L41;
        ThemeColor r105 = r100.getThemeColor();
        if (r105 == null) goto L17;
        ThemeColor.Key r106 = r105.getKey();
        if (r106 == null) goto L17;
        Integer r107 = r106.getValue();
    L18:
        if (r107 == null) goto L41;
        com.bytedance.lark.pb.basic.v1.ThemeColor.Key.Builder r108 = new com.bytedance.lark.pb.basic.v1.ThemeColor.Key.Builder();
        ThemeColor r109 = r100.getThemeColor();
        if (r109 == null) goto L27;
        ThemeColor.Key r110 = r109.getKey();
        if (r110 == null) goto L27;
        ThemeColor.KeyType r111 = r110.getType();
        if (r111 == null) goto L27;
        int r112 = r111.ordinal();
    L28:
        com.bytedance.lark.pb.basic.v1.ThemeColor.Key.Builder r113 = r108.type(com.bytedance.lark.pb.basic.v1.ThemeColor.KeyType.fromValue(r112));
        ThemeColor r114 = r100.getThemeColor();
        if (r114 == null) goto L33;
        ThemeColor.Key r115 = r114.getKey();
        if (r115 == null) goto L33;
        Integer r116 = Integer.valueOf(r115.getAlpha());
    L34:
        com.bytedance.lark.pb.basic.v1.ThemeColor.Key.Builder r117 = r113.alpha(r116);
        ThemeColor r118 = r100.getThemeColor();
        if (r118 == null) goto L39;
        ThemeColor.Key r119 = r118.getKey();
        if (r119 == null) goto L39;
        Integer r120 = r119.getValue();
    L40:
        com.bytedance.lark.pb.basic.v1.ThemeColor.Key r121 = r117.value(r120).build();
    L42:
        com.bytedance.lark.pb.basic.v1.ThemeColor.Builder r122 = new com.bytedance.lark.pb.basic.v1.ThemeColor.Builder();
        ThemeColor r123 = r100.getThemeColor();
        if (r123 == null) goto L45;
        String r124 = r123.getToken();
    L46:
        com.bytedance.lark.pb.basic.v1.ThemeColor.Builder r125 = r122.token(r124).key(r121);
        ThemeColor r126 = r100.getThemeColor();
        if (r126 == null) goto L50;
        r101 = r126.getValue();
    L50:
        return new UDIcon.Builder().color(r125.value(r101).build()).key(r100.getKey()).unicode(r100.getUnicode()).build();
    L45:
        r124 = null;
    L39:
        r120 = null;
    L33:
        r116 = null;
    L27:
        r112 = -1;
    L17:
        r107 = null;
    L41:
        r121 = null;
    L10:
        r104 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(Continuation<? super GetAnotherNameFormatResponse.FormatRule> r100) {
        if ((r100 instanceof TodoRustCommon$getAnotherNameFormatRule$1) == false) goto L7;
        TodoRustCommon$getAnotherNameFormatRule$1 r101 = (TodoRustCommon$getAnotherNameFormatRule$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        RustLog.b r106 = (RustLog.b) r103;
        if (r106.f444239b != null) goto L20;
        GetAnotherNameFormatResponse.FormatRule r107 = (GetAnotherNameFormatResponse.FormatRule) r106.f444238a;
        if (r107 == null) goto L24;
        return r107;
    L24:
        return GetAnotherNameFormatResponse.FormatRule.UNKNOWN;
    L20:
        return GetAnotherNameFormatResponse.FormatRule.UNKNOWN;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        int r108 = RustLog.f444237a;
        Command r109 = Command.GET_ANOTHER_NAME_FORMAT;
        GetAnotherNameFormatRequest.Builder r110 = new GetAnotherNameFormatRequest.Builder();
        a r111 = new a();
        String r112 = "isNameFormatRule:" + GetAnotherNameFormatResponse.FormatRule.UNKNOWN;
        r101.label = 1;
        r103 = RustLog.a(r109, r110, r111, r112, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new TodoRustCommon$getAnotherNameFormatRule$1(this, r100);
        goto L8
    }

    public static Object b(Map r110, Continuation r111) {
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r111), 1);
        r100.C();
        Map<String, Map<String, UrlCardPreviewEntity>> r112 = TodoDependencyHolder.a().urlPreviewDependency().c(r110, SyncDataStrategy.TRY_LOCAL);
        if (r112 != null) goto L5;
        r100.resumeWith(Result.m9449constructorimpl(null));
    L34:
        Object r113 = r100.B();
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        DebugProbesKt.probeCoroutineSuspended(r111);
    L37:
        return r113;
    L5:
        HashMap r101 = new HashMap();
        ArrayList r102 = new ArrayList(r112.size());
        Iterator<Map.Entry<String, Map<String, UrlCardPreviewEntity>>> r114 = r112.entrySet().iterator();
    L7:
        if (r114.hasNext() == false) goto L33;
        Map.Entry<String, Map<String, UrlCardPreviewEntity>> r103 = r114.next();
        HashMap r104 = new HashMap();
        Map<String, UrlCardPreviewEntity> r105 = r103.getValue();
        ArrayList r106 = new ArrayList(r105.size());
        Iterator<Map.Entry<String, UrlCardPreviewEntity>> r107 = r105.entrySet().iterator();
    L10:
        if (r107.hasNext() == false) goto L32;
        Map.Entry<String, UrlCardPreviewEntity> r108 = r107.next();
        UrlInlinePreviewEntity r109 = r108.getValue().getInlineEntity();
        URL.Builder r115 = new URL.Builder();
        Url r116 = r109.getUrl();
        if (r116 == null) goto L14;
        String r117 = r116.getUrl();
    L15:
        URL.Builder r118 = r115.url(r117);
        Url r119 = r109.getUrl();
        if (r119 == null) goto L18;
        String r120 = r119.getAndroidUrl();
    L19:
        URL.Builder r121 = r118.android(r120);
        Url r122 = r109.getUrl();
        if (r122 == null) goto L22;
        String r123 = r122.getIosUrl();
    L23:
        URL.Builder r124 = r121.ios(r123);
        Url r125 = r109.getUrl();
        if (r125 == null) goto L26;
        String r126 = r125.getPcUrl();
    L27:
        URL.Builder r127 = r124.pc(r126);
        Url r128 = r109.getUrl();
        if (r128 == null) goto L30;
        String r129 = r128.getWebUrl();
    L31:
        r106.add((UrlPreviewEntity) r104.put(r108.getKey(), new UrlPreviewEntity.Builder().is_sdk_preview(Boxing.boxBoolean(r109.isSdkPreview())).source_id(r109.getSourceId()).preview_id(r109.getPreviewId()).url(r127.web(r129).build()).need_reload(Boxing.boxBoolean(r109.getNeedReload())).server_icon_key(r109.getNetIconKey()).server_tag(r109.getNetUrlTag()).server_title(r109.getTitle()).ud_icon(f(r109.getUdIcon())).version(Boxing.boxInt(r109.getVersion())).build()));
        goto L10
    L30:
        r129 = null;
        goto L31
    L26:
        r126 = null;
        goto L27
    L22:
        r123 = null;
        goto L23
    L18:
        r120 = null;
        goto L19
    L14:
        r117 = null;
        goto L15
    L32:
        r102.add((Map) r101.put(r103.getKey(), r104));
        goto L7
    L33:
        r100.resumeWith(Result.m9449constructorimpl(r101));
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCommon$getPreviewEntityByURLNew$2$1] */
    public static Object d(String r100, Continuation r101) {
        final kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        TodoDependencyHolder.a().urlPreviewDependency().d(r100, new TodoRustCommon$getPreviewEntityByURLNew$2$1(r102));
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L5:
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(List<String> r100, Continuation<? super List<TodoUserData>> r101) {
        if ((r101 instanceof TodoRustCommon$getTodoUserByIds$1) == false) goto L7;
        TodoRustCommon$getTodoUserByIds$1 r102 = (TodoRustCommon$getTodoUserByIds$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        RustLog.b r107 = (RustLog.b) r104;
        if (r107.f444239b == null) goto L21;
        return null;
    L21:
        GetTodoUsersByChatterIdsResponse r108 = (GetTodoUsersByChatterIdsResponse) r107.f444238a;
        if (r108 == null) goto L28;
        List<TodoUser> r109 = r108.users;
        if (r109 == null) goto L28;
        List r110 = com.ss.android.lark.todo.impl.features.detail.viewmodel.data.b.c(r109, TodoUser.class, TodoUserData.class);
        if (r110 == null) goto L28;
        return r110;
    L28:
        return new ArrayList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        GetTodoUsersByChatterIdsRequest.Builder r111 = new GetTodoUsersByChatterIdsRequest.Builder().chatter_ids(r100);
        int r112 = RustLog.f444237a;
        Command r113 = Command.GET_TODO_USERS_BY_CHATTER_IDS;
        Intrinsics.checkNotNull(r111);
        c r114 = new c();
        String r115 = "id:" + r100.size();
        r102.label = 1;
        r104 = RustLog.a(r113, r111, r114, r115, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new TodoRustCommon$getTodoUserByIds$1(this, r101);
        goto L8
    }
}
