package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/TranslateConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "autoShow", "getAutoShow", "setAutoShow", ResourceData.KEY_TYPE, "", "getType", "()I", "setType", "(I)V", "targetLang", "", "getTargetLang", "()Ljava/lang/String;", "setTargetLang", "(Ljava/lang/String;)V", "srcLang", "getSrcLang", "setSrcLang", "toString", "Companion", "Langes", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslateConfig implements NonProguard {
    public static final a Companion = null;
    public static final int NOT_SHOW = 1;
    public static final int SHOW_ALL = 3;
    public static final int SHOW_TRANSLATE = 2;

    @JSONField(name = "enable_auto_translate")
    private boolean autoShow;

    @JSONField(name = "enable_comment_translate")
    private boolean show;

    @JSONField(name = "src_lang")
    private String srcLang;

    @JSONField(name = "target_lang")
    private String targetLang;

    @JSONField(name = "display_type")
    private int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "TranslateConfig(show=" + this.show + ", autoShow=" + this.autoShow + ", type=" + this.type + ", targetLang='" + this.targetLang + "', srcLang='" + this.srcLang + "')";
    }

    public TranslateConfig() {
        this.type = 1;
        this.targetLang = "";
        this.srcLang = "";
    }

    public final boolean getAutoShow() {
        return this.autoShow;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getSrcLang() {
        return this.srcLang;
    }

    public final String getTargetLang() {
        return this.targetLang;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAutoShow(boolean r1) {
        this.autoShow = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setSrcLang(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.srcLang = r2;
    }

    public final void setTargetLang(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.targetLang = r2;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
