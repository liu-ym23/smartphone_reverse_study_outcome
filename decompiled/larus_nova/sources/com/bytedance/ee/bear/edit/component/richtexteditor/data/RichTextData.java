package com.bytedance.ee.bear.edit.component.richtexteditor.data;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class RichTextData implements NonProguard {
    private a config;
    private String content;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f226039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f226040b;

        public a() {
        }

        public final String toString() {
            return "Config{mode='" + this.f226039a + "', lang='" + this.f226040b + "'}";
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

    public void setConfig(a r100) {
        this.config = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }
}
