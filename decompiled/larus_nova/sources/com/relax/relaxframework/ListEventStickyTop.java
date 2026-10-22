package com.relax.relaxframework;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\u0007j\u0002`\t\u0012\n\u0010\n\u001a\u00060\u0007j\u0002`\t¢\u0006\u0002\u0010\u000bR\u001e\u0010\n\u001a\u00060\u0007j\u0002`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u00060\u0007j\u0002`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/relax/relaxframework/ListEventStickyTop;", "", "detail", "Lcom/relax/relaxframework/ListEventStickyTopDetail;", "type", "", "timestamp", "", PickerReporterConstants.KEY.TARGET, "Lcom/bytedance/rts/foundation/rptr;", "currentTarget", "(Lcom/relax/relaxframework/ListEventStickyTopDetail;Ljava/lang/String;JJJ)V", "getCurrentTarget", "()J", "setCurrentTarget", "(J)V", "getDetail", "()Lcom/relax/relaxframework/ListEventStickyTopDetail;", "setDetail", "(Lcom/relax/relaxframework/ListEventStickyTopDetail;)V", "getTarget", "setTarget", "getTimestamp", "setTimestamp", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListEventStickyTop {
    private long currentTarget;
    private ListEventStickyTopDetail detail;
    private long target;
    private long timestamp;
    private String type;

    public final long getCurrentTarget() {
        return this.currentTarget;
    }

    public final ListEventStickyTopDetail getDetail() {
        return this.detail;
    }

    public final long getTarget() {
        return this.target;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getType() {
        return this.type;
    }

    public final void setCurrentTarget(long r100) {
        this.currentTarget = r100;
    }

    public final void setDetail(ListEventStickyTopDetail r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.detail = r100;
    }

    public final void setTarget(long r100) {
        this.target = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public ListEventStickyTop(ListEventStickyTopDetail r100, String r101, long r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "detail");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.detail = r100;
        this.type = r101;
        this.timestamp = r102;
        this.target = r103;
        this.currentTarget = r104;
    }
}
