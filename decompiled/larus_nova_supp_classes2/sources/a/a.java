package a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class a {
    public static final StackTraceElement a(Throwable r3, String r4) {
        StackTraceElement r5 = r3.getStackTrace()[0];
        return new StackTraceElement("_COROUTINE.".concat(r4), "_", r5.getFileName(), r5.getLineNumber());
    }
}
