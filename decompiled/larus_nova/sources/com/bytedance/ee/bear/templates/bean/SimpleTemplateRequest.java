package com.bytedance.ee.bear.templates.bean;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class SimpleTemplateRequest extends Result<SimpleTemplateInfo> {

    public static class Extra implements NonProguard {
        public String collectionId;

        public Extra() {
        }
    }

    public static class SimpleTemplateInfo implements NonProguard {
        public Extra extra;
        public long heat;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f238868id;
        public String name;
        public String token;
        public int type;

        public SimpleTemplateInfo() {
            this.extra = new Extra();
        }
    }

    public SimpleTemplateInfo toSimpleTemplateInfo() {
        return (SimpleTemplateInfo) this.data;
    }

    public SimpleTemplateRequest() {
    }
}
