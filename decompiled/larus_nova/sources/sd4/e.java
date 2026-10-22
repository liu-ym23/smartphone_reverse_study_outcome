package sd4;

/* JADX INFO: loaded from: classes15.dex */
public abstract class e {
    private Object hostOnAppBackGroundListener;

    public e() {
    }

    public abstract void onAppBackground();

    public abstract void onAppForeground();

    public final Object getHostOnAppBackGroundListener() {
        return this.hostOnAppBackGroundListener;
    }

    public final void setHostOnAppBackGroundListener(Object r100) {
        this.hostOnAppBackGroundListener = r100;
    }
}
