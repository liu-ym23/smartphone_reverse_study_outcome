package retrofit2;

/* JADX INFO: loaded from: classes41.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }

    public HttpException(Response<?> r100) {
        super(getMessage(r100));
        this.code = r100.code();
        this.message = r100.message();
        this.response = r100;
    }

    private static String getMessage(Response<?> r100) {
        u.a(r100, "response == null");
        return "HTTP " + r100.code() + " " + r100.message();
    }
}
