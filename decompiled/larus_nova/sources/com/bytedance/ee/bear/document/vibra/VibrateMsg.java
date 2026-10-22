package com.bytedance.ee.bear.document.vibra;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class VibrateMsg implements NonProguard {
    public int strength;
    public int time;

    public VibrateMsg() {
    }

    public String toString() {
        return "VibrateMsg{time=" + this.time + ", strength=" + this.strength + '}';
    }
}
