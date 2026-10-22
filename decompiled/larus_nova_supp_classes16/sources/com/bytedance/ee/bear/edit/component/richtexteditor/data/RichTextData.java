package com.bytedance.ee.bear.edit.component.richtexteditor.data;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RichTextData implements NonProguard {
    private a config;
    private String content;

    public static class a {
        public String a;
        public String b;

        public a() {
        }

        public final String toString() {
            return "Config{mode='" + this.a + "', lang='" + this.b + "'}";
        }
    }

    public RichTextData() {
    }

    public String toString() {
        return "RichTextData{content='" + this.content + "', config=" + this.config + '}';
    }

    public a getConfig() {
        return this.config;
    }

    public String getContent() {
        return this.content;
    }

    public void setConfig(a r1) {
        this.config = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }
}
