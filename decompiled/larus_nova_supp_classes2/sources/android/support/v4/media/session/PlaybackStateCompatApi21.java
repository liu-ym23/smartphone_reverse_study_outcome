package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class PlaybackStateCompatApi21 {

    public static final class CustomAction {
        private CustomAction() {
        }

        public static String getAction(Object r0) {
            return ((PlaybackState.CustomAction) r0).getAction();
        }

        public static Bundle getExtras(Object r0) {
            return ((PlaybackState.CustomAction) r0).getExtras();
        }

        public static int getIcon(Object r0) {
            return ((PlaybackState.CustomAction) r0).getIcon();
        }

        public static CharSequence getName(Object r0) {
            return ((PlaybackState.CustomAction) r0).getName();
        }

        public static Object newInstance(String r1, CharSequence r2, int r3, Bundle r4) {
            PlaybackState.CustomAction.Builder r0 = new PlaybackState.CustomAction.Builder(r1, r2, r3);
            r0.setExtras(r4);
            return r0.build();
        }
    }

    private PlaybackStateCompatApi21() {
    }

    public static long getActions(Object r2) {
        return ((PlaybackState) r2).getActions();
    }

    public static long getActiveQueueItemId(Object r2) {
        return ((PlaybackState) r2).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object r2) {
        return ((PlaybackState) r2).getBufferedPosition();
    }

    public static List<Object> getCustomActions(Object r0) {
        return ((PlaybackState) r0).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object r0) {
        return ((PlaybackState) r0).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object r2) {
        return ((PlaybackState) r2).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object r0) {
        return ((PlaybackState) r0).getPlaybackSpeed();
    }

    public static long getPosition(Object r2) {
        return ((PlaybackState) r2).getPosition();
    }

    public static int getState(Object r0) {
        return ((PlaybackState) r0).getState();
    }

    public static Object newInstance(int r8, long r9, long r11, float r13, long r14, CharSequence r16, long r17, List<Object> r19, long r20) {
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
        return r7.build();
    }
}
