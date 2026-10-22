package com.bytedance.ee.bear.document.keyboard;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Keyboard implements NonProguard {
    private boolean active;

    public Keyboard() {
    }

    public String toString() {
        return "Keyboard{active=" + this.active + '}';
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean r1) {
        this.active = r1;
    }
}
