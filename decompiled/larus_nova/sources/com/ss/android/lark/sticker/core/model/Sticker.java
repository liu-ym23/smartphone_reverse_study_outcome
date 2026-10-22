package com.ss.android.lark.sticker.core.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class Sticker implements Serializable, Comparable {
    private String key;
    private int position;
    private long updateTime;

    public Sticker() {
    }

    public String getKey() {
        return this.key;
    }

    public int getPosition() {
        return this.position;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        if ((r100 instanceof Sticker) == false) goto L12;
        Sticker r101 = (Sticker) r100;
        if (getPosition() >= r101.getPosition()) goto L9;
        return -1;
    L9:
        if (getPosition() <= r101.getPosition()) goto L12;
        return 1;
    L12:
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L20;
        Sticker r101 = (Sticker) r100;
        if (this.position == r101.position) goto L13;
        return false;
    L13:
        String r102 = this.key;
        String r103 = r101.key;
        if (r102 != null) goto L21;
        if (r103 == null) goto L22;
        return false;
    L22:
        return true;
    L21:
        return r102.equals(r103);
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public Sticker(String r100, int r101, long r102) {
        this.key = r100;
        this.position = r101;
        this.updateTime = r102;
    }
}
