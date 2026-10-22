package rra;

import com.ss.android.agilelogger.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ora.a {
    public a() {
    }

    @Override // ora.a
    public final String a(Object r100) {
        String r101 = (String) r100;
        if (r101 == null) goto L19;
        if (r101.trim().length() == 0) goto L19;
    L15:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:".concat(r101), e);
    L7:
        if (r101.startsWith("{") == false) goto L10;
        return new JSONObject(r101).toString(4);
    L10:
        if (r101.startsWith("[") == false) goto L14;
        return new JSONArray(r101).toString(4);
    L14:
        throw new FormatException("JSON should start with { or [, but found ".concat(r101));     // Catch: Exception -> L15
    L19:
        throw new FormatException("JSON empty.");
    }
}
