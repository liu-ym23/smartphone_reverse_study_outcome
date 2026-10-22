package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@AppConfig(key = PerfConfig.KEY)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/performance/PerfConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fps_collection_enable", "", "getFps_collection_enable", "()Z", "setFps_collection_enable", "(Z)V", "load_cost_enable", "getLoad_cost_enable", "setLoad_cost_enable", "editable_cost_enable", "getEditable_cost_enable", "setEditable_cost_enable", "send_comment_enable", "getSend_comment_enable", "setSend_comment_enable", "toString", "", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerfConfig implements NonProguard {
    public static final a Companion = null;
    public static final String KEY = "ccm_mobile_comment_performance_config";
    private boolean editable_cost_enable;
    private boolean fps_collection_enable;
    private boolean load_cost_enable;
    private boolean send_comment_enable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "PerfConfig(fps_collection_enable=" + this.fps_collection_enable + ", load_cost_enable=" + this.load_cost_enable + ", editable_cost_enable=" + this.editable_cost_enable + ", send_comment_enable=" + this.send_comment_enable + ')';
    }

    public PerfConfig() {
        this.send_comment_enable = true;
    }

    public final boolean getEditable_cost_enable() {
        return this.editable_cost_enable;
    }

    public final boolean getFps_collection_enable() {
        return this.fps_collection_enable;
    }

    public final boolean getLoad_cost_enable() {
        return this.load_cost_enable;
    }

    public final boolean getSend_comment_enable() {
        return this.send_comment_enable;
    }

    public final void setEditable_cost_enable(boolean r1) {
        this.editable_cost_enable = r1;
    }

    public final void setFps_collection_enable(boolean r1) {
        this.fps_collection_enable = r1;
    }

    public final void setLoad_cost_enable(boolean r1) {
        this.load_cost_enable = r1;
    }

    public final void setSend_comment_enable(boolean r1) {
        this.send_comment_enable = r1;
    }
}
