package com.bytedance.ee.bear.templates.bean;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SimpleTemplateRequest extends Result<SimpleTemplateInfo> {

    public static class Extra implements NonProguard {
        public String collectionId;

        public Extra() {
        }
    }

    public static class SimpleTemplateInfo implements NonProguard {
        public Extra extra;
        public long heat;
        public String id;
        public String name;
        public String token;
        public int type;

        public SimpleTemplateInfo() {
            this.extra = new Extra();
        }
    }

    public SimpleTemplateInfo toSimpleTemplateInfo() {
        return (SimpleTemplateInfo) ((Result) this).data;
    }

    public SimpleTemplateRequest() {
    }
}
