package com.bytedance.ee.bear.doc.follow.event;

import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public TitleChangedEvent(String r1) {
        this.title = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
