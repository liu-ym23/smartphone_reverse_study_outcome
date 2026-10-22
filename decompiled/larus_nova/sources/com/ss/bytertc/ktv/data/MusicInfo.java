package com.ss.bytertc.ktv.data;

/* JADX INFO: loaded from: classes40.dex */
public class MusicInfo {
    public int climaxEndTime;
    public int climaxStartTime;
    public int duration;
    public boolean enableScore;
    public LyricStatus lyricStatus;
    public String musicId;
    public String musicName;
    public String posterUrl;
    public String singer;
    public long updateTimestamp;
    public String vendorId;
    public String vendorName;

    public String toString() {
        return "Music{musicId='" + this.musicId + "', musicName='" + this.musicName + "', singer='" + this.singer + "', vendorId='" + this.vendorId + "', vendorName='" + this.vendorName + "', updateTimestamp=" + this.updateTimestamp + ", posterUrl='" + this.posterUrl + "', lyricStatus=" + this.lyricStatus + ", duration=" + this.duration + ", enableScore=" + this.enableScore + ", climaxStartTime=" + this.climaxStartTime + ", climaxEndTime=" + this.climaxEndTime + '}';
    }

    public MusicInfo(String r100, String r101, String r102, String r103, String r104, long r105, String r106, LyricStatus r107, int r110, boolean r111, int r112, int r113) {
        this.musicId = r100;
        this.musicName = r101;
        this.singer = r102;
        this.vendorId = r103;
        this.vendorName = r104;
        this.updateTimestamp = r105;
        this.posterUrl = r106;
        this.lyricStatus = r107;
        this.duration = r110;
        this.enableScore = r111;
        this.climaxStartTime = r112;
        this.climaxEndTime = r113;
    }
}
