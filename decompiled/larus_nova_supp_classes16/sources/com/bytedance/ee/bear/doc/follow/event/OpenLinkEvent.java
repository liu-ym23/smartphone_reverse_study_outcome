package com.bytedance.ee.bear.doc.follow.event;

import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OpenLinkEvent implements ContentEvent {
    public final String title;
    public final String url;

    public String toString() {
        return "OpenLinkEvent{title='" + b.g(this.title) + "', url='" + b.g(this.url) + "'}";
    }

    public OpenLinkEvent(String r2) {
        this("", r2);
    }

    public OpenLinkEvent(String r1, String r2) {
        this.title = r1;
        this.url = r2;
    }
}
