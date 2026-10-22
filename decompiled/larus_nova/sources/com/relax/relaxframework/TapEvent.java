package com.relax.relaxframework;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001Be\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\u0010\r\u001a\u00060\fj\u0002`\u000e\u0012\n\u0010\u000f\u001a\u00060\fj\u0002`\u000e¢\u0006\u0002\u0010\u0010R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u000f\u001a\u00060\fj\u0002`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\r\u001a\u00060\fj\u0002`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/relax/relaxframework/TapEvent;", "", "changedTouches", "Ljava/util/ArrayList;", "Lcom/relax/relaxframework/TouchEventDetailTouches;", "Lcom/bytedance/rts/foundation/RTSArray;", "touches", "detail", "Lcom/relax/relaxframework/TouchEventDetail;", "type", "", "timestamp", "", PickerReporterConstants.KEY.TARGET, "Lcom/bytedance/rts/foundation/rptr;", "currentTarget", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/relax/relaxframework/TouchEventDetail;Ljava/lang/String;JJJ)V", "getChangedTouches", "()Ljava/util/ArrayList;", "setChangedTouches", "(Ljava/util/ArrayList;)V", "getCurrentTarget", "()J", "setCurrentTarget", "(J)V", "getDetail", "()Lcom/relax/relaxframework/TouchEventDetail;", "setDetail", "(Lcom/relax/relaxframework/TouchEventDetail;)V", "getTarget", "setTarget", "getTimestamp", "setTimestamp", "getTouches", "setTouches", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TapEvent {
    private ArrayList<TouchEventDetailTouches> changedTouches;
    private long currentTarget;
    private TouchEventDetail detail;
    private long target;
    private long timestamp;
    private ArrayList<TouchEventDetailTouches> touches;
    private String type;

    public final ArrayList<TouchEventDetailTouches> getChangedTouches() {
        return this.changedTouches;
    }

    public final long getCurrentTarget() {
        return this.currentTarget;
    }

    public final TouchEventDetail getDetail() {
        return this.detail;
    }

    public final long getTarget() {
        return this.target;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ArrayList<TouchEventDetailTouches> getTouches() {
        return this.touches;
    }

    public final String getType() {
        return this.type;
    }

    public final void setChangedTouches(ArrayList<TouchEventDetailTouches> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.changedTouches = r100;
    }

    public final void setCurrentTarget(long r100) {
        this.currentTarget = r100;
    }

    public final void setDetail(TouchEventDetail r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.detail = r100;
    }

    public final void setTarget(long r100) {
        this.target = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public final void setTouches(ArrayList<TouchEventDetailTouches> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.touches = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public TapEvent(ArrayList<TouchEventDetailTouches> r100, ArrayList<TouchEventDetailTouches> r101, TouchEventDetail r102, String r103, long r104, long r105, long r110) {
        Intrinsics.checkNotNullParameter(r100, "changedTouches");
        Intrinsics.checkNotNullParameter(r101, "touches");
        Intrinsics.checkNotNullParameter(r102, "detail");
        Intrinsics.checkNotNullParameter(r103, "type");
        this.changedTouches = r100;
        this.touches = r101;
        this.detail = r102;
        this.type = r103;
        this.timestamp = r104;
        this.target = r105;
        this.currentTarget = r110;
    }
}
