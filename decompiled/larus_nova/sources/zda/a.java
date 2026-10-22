package zda;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f571485a = null;

    /* JADX INFO: renamed from: zda.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/obric/assistant/entity/IntentCardEntityParser$parseAppIntentMessage$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/obric/aiagent/assistant/idl/bean/AppIntentMessage;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C8445a extends TypeToken<AppIntentMessage> {
        public C8445a() {
        }
    }

    static {
        f571485a = new a();
    }

    public a() {
    }

    public static String b(String r100) {
        JsonObject r101 = GsonProtectorUtils.parse(new JsonParser(), r100).getAsJsonObject();
        JsonElement r102 = r101.get("data");
        if (r102 != null) goto L5;
    L18:
        JsonElement r103 = r101.get("dataV2");
        if (r103 == null) goto L42;
        if (r103.isJsonArray() == false) goto L23;
        JsonArray r104 = r103.getAsJsonArray();
    L24:
        if (r104 == null) goto L42;
        Iterator<JsonElement> r105 = r104.iterator();
    L27:
        if (r105.hasNext() == false) goto L42;
        JsonElement r106 = r105.next();
        a r107 = f571485a;
        Intrinsics.checkNotNull(r106);
        r107.getClass();
        if (r106.isJsonObject() == false) goto L31;
        JsonObject r108 = r106.getAsJsonObject();
    L32:
        if (r108 == null) goto L27;
        JsonElement r109 = r108.get("appEntity");
        if (r109 == null) goto L27;
        if (r109.isJsonObject() == false) goto L38;
        JsonObject r110 = r109.getAsJsonObject();
    L39:
        if (r110 == null) goto L27;
        a(r110, "createTime", "createTimeStamp");
        a(r110, "lastModifiedTime", "lastModifiedTimeStamp");
        goto L27
    L38:
        r110 = null;
        goto L39
    L31:
        r108 = null;
        goto L32
    L23:
        r104 = null;
    L42:
        return r101.toString();
    L5:
        if (r102.isJsonArray() == false) goto L7;
        JsonArray r111 = r102.getAsJsonArray();
    L8:
        if (r111 == null) goto L18;
        Iterator<JsonElement> r112 = r111.iterator();
    L11:
        if (r112.hasNext() == false) goto L18;
        JsonElement r113 = r112.next();
        a r114 = f571485a;
        Intrinsics.checkNotNull(r113);
        r114.getClass();
        if (r113.isJsonObject() == false) goto L15;
        JsonObject r115 = r113.getAsJsonObject();
    L16:
        if (r115 == null) goto L11;
        a(r115, "createTime", "createTimeStamp");
        a(r115, "lastModifiedTime", "lastModifiedTimeStamp");
        goto L11
    L15:
        r115 = null;
        goto L16
    L7:
        r111 = null;
        goto L8
    }

    public static AppEntity c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawJson");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(AppEntity.CREATOR.fromJson(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r102) != null) goto L19;
    L15:
        ResultKt.throwOnFailure(r102);
        return (AppEntity) r102;
    L19:
        Object r103 = Result.m9449constructorimpl(AppEntity.CREATOR.fromJsonKeepTimeStamp(r100));     // Catch: Throwable -> L12
    L14:
        r102 = r103;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static AppEntity d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "entityJson");
        return c(r100.toString());
    }

    public static AppIntentMessage e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawJson");
        Type r101 = new C8445a().getType();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((AppIntentMessage) EntityExtKt.a().fromJson(r100, r101));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r103) != null) goto L17;
    L15:
        ResultKt.throwOnFailure(r103);
        return (AppIntentMessage) r103;
    L17:
        Gson r104 = EntityExtKt.a();     // Catch: Throwable -> L12
        f571485a.getClass();     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl((AppIntentMessage) r104.fromJson(b(r100), r101));     // Catch: Throwable -> L12
    L14:
        r103 = r105;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static void a(JsonObject r100, String r101, String r102) {
        if (r100.has(r102) == false) goto L5;
        return;
    L5:
        JsonElement r103 = r100.get(r101);
        if (r103 == null) goto L32;
        Long r104 = null;
        Object r105 = null;
        if (r103.isJsonPrimitive() == false) goto L27;
        JsonPrimitive r106 = r103.getAsJsonPrimitive();
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L20
        if (r106.isNumber() == false) goto L15;
        Long r108 = Long.valueOf(r106.getAsLong());     // Catch: Throwable -> L20
    L18:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r109) == true) goto L26;
        r105 = r109;
    L26:
        r104 = (Long) r105;
        goto L27
    L15:
        if (r106.isString() == false) goto L17;
        r108 = StringsKt.toLongOrNull(r106.getAsString());     // Catch: Throwable -> L20
        goto L18
    L17:
        r108 = null;
    L20:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        if (r104 == null) goto L33;
        r100.addProperty(r102, Long.valueOf(r104.longValue()));
        return;
    L33:
        return;
    }
}
