package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class PlaybackStateCompatApi22 {
    private PlaybackStateCompatApi22() {
    }

    public static Bundle getExtras(Object r0) {
        return ((PlaybackState) r0).getExtras();
    }

    public static Object newInstance(int r8, long r9, long r11, float r13, long r14, CharSequence r16, long r17, List<Object> r19, long r20, Bundle r22) {
        PlaybackState.Builder r7 = new PlaybackState.Builder();
        r7.setState(r8, r9, r13, r17);
        r7.setBufferedPosition(r11);
        r7.setActions(r14);
        r7.setErrorMessage(r16);
        Iterator<Object> r0 = r19.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r7.addCustomAction((PlaybackState.CustomAction) r0.next());
        goto L4
    L6:
        r7.setActiveQueueItemId(r20);
        r7.setExtras(r22);
        return r7.build();
    }
}
