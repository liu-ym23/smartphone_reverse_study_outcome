package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentMentionAuthorize$ResponseData implements NonProguard {
    private int fail_count;
    private List<String> fail_owners;
    private int success_count;

    public CommentMentionAuthorize$ResponseData() {
    }

    public String toString() {
        return "CommentMentionAuthorize#ResponseData@" + hashCode() + "{success_count: " + this.success_count + ", fail_count: " + this.fail_count + ", fail_owners: " + this.fail_owners + "}";
    }

    public int getFail_count() {
        return this.fail_count;
    }

    public List<String> getFail_owners() {
        return this.fail_owners;
    }

    public int getSuccess_count() {
        return this.success_count;
    }

    public void setFail_count(int r1) {
        this.fail_count = r1;
    }

    public void setFail_owners(List<String> r1) {
        this.fail_owners = r1;
    }

    public void setSuccess_count(int r1) {
        this.success_count = r1;
    }
}
