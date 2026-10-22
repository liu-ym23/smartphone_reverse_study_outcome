package com.bytedance.ee.bear.middleground.record.viewhistory;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.widgets.tagview.DisplayTagInfoV1;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecordListResult extends Result {
    public String nextPageToken;
    public List<a> users;
    public int uv;
    public int uvHidden;

    public static class a {
        public String a;
        public String b;
        public String c;
        public DisplayName d;
        public DisplayTagInfoV1 e;
        public String f;
        public String g;
        public long h;
        public int i;
        public boolean j;
        public boolean k;

        public a() {
        }
    }

    public RecordListResult() {
    }
}
