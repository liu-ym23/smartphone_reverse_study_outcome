package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/AnimaxFrameArrayParams;", "", "frames", "Ljava/util/ArrayList;", "", "Lcom/bytedance/rts/foundation/RTSArray;", "(Ljava/util/ArrayList;)V", "getFrames", "()Ljava/util/ArrayList;", "setFrames", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnimaxFrameArrayParams {
    private ArrayList<Integer> frames;

    public final ArrayList<Integer> getFrames() {
        return this.frames;
    }

    public AnimaxFrameArrayParams(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "frames");
        this.frames = r100;
    }

    public final void setFrames(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.frames = r100;
    }
}
