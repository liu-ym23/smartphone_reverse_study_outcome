package com.ss.android.lark.url.card.data;

import hac.b;
import hac.c;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/url/card/data/UrlCardLocalDataStore;", "Ljava/io/Serializable;", "<init>", "()V", "value", "", "cacheData", "getCacheData", "()Ljava/lang/String;", "put", "", "version", "data", "Companion", "url-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlCardLocalDataStore implements Serializable {
    public static final a Companion = null;
    private String cacheData;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UrlCardLocalDataStore() {
    }

    public final String getCacheData() {
        return this.cacheData;
    }

    public final void put(String r100, String r101) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        String r102 = this.cacheData;
        if (r102 == null) goto L8;
        JSONObject r103 = new JSONObject(r102);
    L9:
        r103.put(r100, new JSONObject(r101));
        this.cacheData = r103.toString();
        return;
    L8:
        r103 = new JSONObject();
    L11:
        b r104 = b.f484427a;
        c.a("UrlCardLocalDataStore", "put data version or data is null");
    }
}
