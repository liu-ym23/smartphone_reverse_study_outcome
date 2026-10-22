package com.bytedance.ee.bear.bitable.filter.parse;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \r*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/parse/SafeDeserializer;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SafeDeserializer<T> implements JsonDeserializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Gson> f211884a = null;

    public static final class a {
    }

    public SafeDeserializer() {
    }

    static {
        f211884a = LazyKt.lazy(SafeDeserializer$Companion$gson$2.INSTANCE);
    }

    @Override // com.google.gson.JsonDeserializer
    public final T deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        return (T) f211884a.getValue().fromJson(r100, r101);
    L4:
        e = move-exception;
        tt5.a.b("SafeDeserializer", "deserialize " + e + ". json:" + r100 + ". type:" + r101);
        return null;
    }
}
