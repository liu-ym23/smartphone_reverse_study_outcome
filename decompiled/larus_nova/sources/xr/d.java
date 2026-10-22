package xr;

/* JADX INFO: loaded from: classes44.dex */
public interface d extends o {
    void addEventExtra(String r100, String r101, String r102, String r103);

    void addEventField(String r100, String r101, String r102, String r103);

    void addTrackExtra(String r100, String r101, String r102);

    void addTrackField(String r100, String r101, String r102);

    void endComponentFmp(String r100, String r101, long r102);

    void markActionEnd(String r100, String r101);

    void markActionStart(String r100, String r101, String r102, boolean r103);

    void markEventActionEnd(String r100, String r101, String r102);

    void markEventActionStart(String r100, String r101, String r102, String r103);

    void startComponentFmp(String r100, String r101);

    void startFmpTrack(String r100, String r101);

    void stopFmpTrack(String r100, String r101);
}
