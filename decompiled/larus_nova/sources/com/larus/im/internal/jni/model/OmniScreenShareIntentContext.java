package com.larus.im.internal.jni.model;

import android.content.Intent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0082 ¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniScreenShareIntentContext;", "", "<init>", "()V", "retain", "", "intent", "Landroid/content/Intent;", "release", "", "handle", "retainIntent", "releaseIntent", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniScreenShareIntentContext {
    public static final OmniScreenShareIntentContext INSTANCE = null;

    static {
        INSTANCE = new OmniScreenShareIntentContext();
    }

    private OmniScreenShareIntentContext() {
    }

    private final native void releaseIntent(long r100);

    private final native long retainIntent(Intent r100);

    public final void release(long r100) {
        if (r100 == 0) goto L6;
        releaseIntent(r100);
        return;
    }

    public final long retain(Intent r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return retainIntent(r100);
    }
}
