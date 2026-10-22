package com.bytedance.ee.bear.doc.follow.event;

import du5.b;

/* JADX INFO: loaded from: classes16.dex */
public class OpenLinkEvent implements ContentEvent {
    public final String title;
    public final String url;

    public String toString() {
        return "OpenLinkEvent{title='" + b.g(this.title) + "', url='" + b.g(this.url) + "'}";
    }

    public OpenLinkEvent(String r100) {
        this("", r100);
    }

    public OpenLinkEvent(String r100, String r101) {
        this.title = r100;
        this.url = r101;
    }
}
