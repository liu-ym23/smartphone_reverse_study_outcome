package com.bytedance.ee.bear.doc.follow.event;

import du5.b;

/* JADX INFO: loaded from: classes16.dex */
public class TitleChangedEvent implements ContentEvent {
    public String title;

    public String toString() {
        return "TitleChangedEvent{title='" + b.g(this.title) + "'}";
    }

    public TitleChangedEvent() {
    }

    public String getTitle() {
        return this.title;
    }

    public TitleChangedEvent(String r100) {
        this.title = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
