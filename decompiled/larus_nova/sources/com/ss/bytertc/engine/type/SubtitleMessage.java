package com.ss.bytertc.engine.type;

/* JADX INFO: loaded from: classes40.dex */
public class SubtitleMessage {
    public boolean definite;
    public String language;
    public SubtitleMode mode;
    public int sequence;
    public String text;
    public String userId;

    public SubtitleMessage(String r100, String r101, String r102, SubtitleMode r103, int r104, boolean r105) {
        this.userId = r100;
        this.text = r101;
        this.language = r102;
        this.mode = r103;
        this.sequence = r104;
        this.definite = r105;
    }

    public static SubtitleMessage create(String r100, String r101, String r110, int r111, int r112, boolean r113) {
        return new SubtitleMessage(r100, r101, r110, SubtitleMode.fromId(r111), r112, r113);
    }
}
