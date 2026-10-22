package gx8;

/* JADX INFO: loaded from: classes26.dex */
public interface e {

    public static final class a {
        public static String a(e r100) {
            return r100.getEventType() + r100.getUploadName();
        }
    }

    String getEventType();

    String getUniqueKey();

    String getUploadName();
}
