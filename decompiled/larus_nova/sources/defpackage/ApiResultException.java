package defpackage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"LApiResultException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Lorg/json/JSONObject;", "getFormatData", "()Lorg/json/JSONObject;", "formatData", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "locallife-hybrid_release"}, k = 1, mv = {1, 4, 3})
public final class ApiResultException extends Exception {
    private final String type;

    public JSONObject getFormatData() {
        JSONObject r100 = new JSONObject();
        r100.put("error_type", this.type);
        StringBuilder r101 = new StringBuilder();
        Throwable r102 = getCause();
        Intrinsics.checkNotNull(r102);
        r101.append(r102.getClass().getSimpleName());
        r101.append(": ");
        Throwable r103 = getCause();
        Intrinsics.checkNotNull(r103);
        r101.append(r103.getMessage());
        r100.put("error_message", r101.toString());
        return r100;
    }

    public final String getType() {
        return this.type;
    }

    public ApiResultException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "cause");
        super(r100, r101);
        this.type = r100;
    }
}
