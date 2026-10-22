package com.bytedance.ee.bear.drive.loader.download.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class Content {
    public static final Content EMPTY = null;
    private final Map<String, String> transcodeUrls;
    private final int type;

    static {
        EMPTY = new Content(0, new HashMap());
    }

    public String toString() {
        return "Content{type=" + this.type + ", transcodeUrls=" + this.transcodeUrls + '}';
    }

    public Map<String, String> getTranscodeUrls() {
        return this.transcodeUrls;
    }

    public int getType() {
        return this.type;
    }

    public Content(int r1, Map<String, String> r2) {
        this.type = r1;
        this.transcodeUrls = Collections.unmodifiableMap(r2);
    }
}
