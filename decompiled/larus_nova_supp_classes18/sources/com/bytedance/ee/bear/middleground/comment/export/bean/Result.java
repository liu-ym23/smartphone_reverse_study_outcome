package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/Result;", "DATA", "Ljava/io/Serializable;", "<init>", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", WikiFolderPushPlugin.DATA, "getData", "()Ljava/io/Serializable;", "setData", "(Ljava/io/Serializable;)V", "Ljava/io/Serializable;", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Result<DATA extends Serializable> implements Serializable {
    private int code;
    private DATA data;
    private String msg;

    public Result() {
    }

    public final int getCode() {
        return this.code;
    }

    public final DATA getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setData(DATA r1) {
        this.data = r1;
    }

    public final void setMsg(String r1) {
        this.msg = r1;
    }
}
