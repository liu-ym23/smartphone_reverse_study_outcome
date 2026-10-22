package com.bytedance.ee.bear.document.restore.api;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.net.NetServiceExpandResult;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes16.dex */
public class RestoreFileResult extends NetServiceExpandResult<Data> {

    public static final class Data implements NonProguard {

        @SerializedName("task_id")
        public String taskId;

        public Data() {
        }
    }

    public static final class FailDataNoPermInfo implements NonProguard {
        public String del_operator_cn_name;
        public String del_operator_en_name;
        public String del_operator_id;
        public String space_id;
        public String space_name;

        public FailDataNoPermInfo() {
        }

        public boolean isValid() {
            if (TextUtils.isEmpty(this.del_operator_id) == false) goto L5;
        L9:
            return false;
        L5:
            if (TextUtils.isEmpty(this.del_operator_cn_name) == true) goto L7;
        L8:
            return true;
        L7:
            if (TextUtils.isEmpty(this.del_operator_en_name) == true) goto L9;
            goto L8
        }
    }

    public RestoreFileResult() {
    }
}
