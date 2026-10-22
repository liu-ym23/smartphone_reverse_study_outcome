package kpb;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: kpb.a$a, reason: collision with other inner class name */
    public interface InterfaceC6597a extends b {
    }

    public interface b {
        String getString(String r100, String r101);

        void putString(String r100, String r101);

        void remove(String r100);
    }

    public interface c extends b {
    }

    InterfaceC6597a getLarkRepo();

    c getUserRepo();
}
