package org.json.alipay;

/* JADX INFO: loaded from: classes42.dex */
public class JSONException extends Exception {
    public Throwable cause;

    public JSONException(String r100) {
        super(r100);
    }

    public JSONException(Throwable r100) {
        super(r100.getMessage());
        this.cause = r100;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
