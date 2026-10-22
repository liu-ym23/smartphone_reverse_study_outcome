package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = null;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }

    public static final class Builder {
        private long mActions;
        private long mActiveItemId;
        private long mBufferedPosition;
        private final List<CustomAction> mCustomActions;
        private int mErrorCode;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }

        public Builder() {
            this.mCustomActions = new ArrayList();
            this.mActiveItemId = -1;
        }

        public Builder(PlaybackStateCompat r4) {
            ArrayList r0 = new ArrayList();
            this.mCustomActions = r0;
            this.mActiveItemId = -1;
            this.mState = r4.mState;
            this.mPosition = r4.mPosition;
            this.mRate = r4.mSpeed;
            this.mUpdateTime = r4.mUpdateTime;
            this.mBufferedPosition = r4.mBufferedPosition;
            this.mActions = r4.mActions;
            this.mErrorCode = r4.mErrorCode;
            this.mErrorMessage = r4.mErrorMessage;
            List<CustomAction> r1 = r4.mCustomActions;
            if (r1 == null) goto L5;
            r0.addAll(r1);
        L5:
            this.mActiveItemId = r4.mActiveItemId;
            this.mExtras = r4.mExtras;
        }

        public Builder addCustomAction(CustomAction r2) {
            if (r2 == null) goto L6;
            this.mCustomActions.add(r2);
            return this;
        L6:
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
        }

        public Builder setActions(long r1) {
            this.mActions = r1;
            return this;
        }

        public Builder setActiveQueueItemId(long r1) {
            this.mActiveItemId = r1;
            return this;
        }

        public Builder setBufferedPosition(long r1) {
            this.mBufferedPosition = r1;
            return this;
        }

        public Builder setErrorMessage(CharSequence r1) {
            this.mErrorMessage = r1;
            return this;
        }

        public Builder setExtras(Bundle r1) {
            this.mExtras = r1;
            return this;
        }

        public Builder setErrorMessage(int r1, CharSequence r2) {
            this.mErrorCode = r1;
            this.mErrorMessage = r2;
            return this;
        }

        public Builder addCustomAction(String r3, String r4, int r5) {
            return addCustomAction(new CustomAction(r3, r4, r5, null));
        }

        public Builder setState(int r8, long r9, float r11) {
            return setState(r8, r9, r11, SystemClock.elapsedRealtime());
        }

        public Builder setState(int r1, long r2, float r4, long r5) {
            this.mState = r1;
            this.mPosition = r2;
            this.mUpdateTime = r5;
            this.mRate = r4;
            return this;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = null;
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        public static final class Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }

            public Builder setExtras(Bundle r1) {
                this.mExtras = r1;
                return this;
            }

            public Builder(String r2, CharSequence r3, int r4) {
                if (TextUtils.isEmpty(r2) == true) goto L14;
                if (TextUtils.isEmpty(r3) == true) goto L12;
                if (r4 == 0) goto L10;
                this.mAction = r2;
                this.mName = r3;
                this.mIcon = r4;
                return;
            L10:
                throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
            L12:
                throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
            L14:
                throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public Object getCustomAction() {
            Object r0 = this.mCustomActionObj;
            if (r0 != null) goto L6;
            Object r1 = PlaybackStateCompatApi21.CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
            this.mCustomActionObj = r1;
            return r1;
        L6:
            return r0;
        }

        public String toString() {
            return "Action:mName='" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        public String getAction() {
            return this.mAction;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public CharSequence getName() {
            return this.mName;
        }

        public CustomAction(Parcel r2) {
            this.mAction = r2.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
            this.mIcon = r2.readInt();
            this.mExtras = r2.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public static CustomAction fromCustomAction(Object r5) {
            if (r5 == null) goto L5;
            CustomAction r0 = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(r5), PlaybackStateCompatApi21.CustomAction.getName(r5), PlaybackStateCompatApi21.CustomAction.getIcon(r5), PlaybackStateCompatApi21.CustomAction.getExtras(r5));
            r0.mCustomActionObj = r5;
            return r0;
        L5:
            return null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, r2, r3);
            r2.writeInt(this.mIcon);
            r2.writeBundle(this.mExtras);
        }

        public CustomAction(String r1, CharSequence r2, int r3, Bundle r4) {
            this.mAction = r1;
            this.mName = r2;
            this.mIcon = r3;
            this.mExtras = r4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static int toKeyCode(long r3) {
        if (r3 != 4) goto L7;
        return KEYCODE_MEDIA_PLAY;
    L7:
        if (r3 != 2) goto L11;
        return KEYCODE_MEDIA_PAUSE;
    L11:
        if (r3 != 32) goto L15;
        return 87;
    L15:
        if (r3 != 16) goto L19;
        return 88;
    L19:
        if (r3 != 1) goto L23;
        return 86;
    L23:
        if (r3 != 64) goto L27;
        return 90;
    L27:
        if (r3 != 8) goto L31;
        return 89;
    L31:
        if (r3 != 512) goto L34;
        return 85;
    L34:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Object getPlaybackState() {
        if (this.mStateObj != null) goto L16;
        if (this.mCustomActions == null) goto L10;
        ArrayList r1 = new ArrayList(this.mCustomActions.size());
        Iterator<CustomAction> r2 = this.mCustomActions.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        r1.add(r2.next().getCustomAction());
    L11:
        ArrayList r13 = r1;
        if (Build.VERSION.SDK_INT < 22) goto L14;
        this.mStateObj = PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, r13, this.mActiveItemId, this.mExtras);
        goto L16
    L14:
        this.mStateObj = PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, r13, this.mActiveItemId);
        goto L16
    L10:
        r1 = null;
    L16:
        return this.mStateObj;
    }

    public String toString() {
        return "PlaybackState {state=" + this.mState + ", position=" + this.mPosition + ", buffered position=" + this.mBufferedPosition + ", speed=" + this.mSpeed + ", updated=" + this.mUpdateTime + ", actions=" + this.mActions + ", error code=" + this.mErrorCode + ", error message=" + this.mErrorMessage + ", custom actions=" + this.mCustomActions + ", active item id=" + this.mActiveItemId + "}";
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public PlaybackStateCompat(Parcel r3) {
        this.mState = r3.readInt();
        this.mPosition = r3.readLong();
        this.mSpeed = r3.readFloat();
        this.mUpdateTime = r3.readLong();
        this.mBufferedPosition = r3.readLong();
        this.mActions = r3.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.mCustomActions = r3.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = r3.readLong();
        this.mExtras = r3.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = r3.readInt();
    }

    public static PlaybackStateCompat fromPlaybackState(Object r22) {
        Bundle r1 = null;
        if (r22 == null) goto L18;
        List<Object> r2 = PlaybackStateCompatApi21.getCustomActions(r22);
        if (r2 == null) goto L11;
        ArrayList r3 = new ArrayList(r2.size());
        Iterator<Object> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add(CustomAction.fromCustomAction(r4.next()));
        goto L8
    L10:
        ArrayList r18 = r3;
    L13:
        if (Build.VERSION.SDK_INT < 22) goto L15;
        r1 = PlaybackStateCompatApi22.getExtras(r22);
    L15:
        PlaybackStateCompat r5 = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(r22), PlaybackStateCompatApi21.getPosition(r22), PlaybackStateCompatApi21.getBufferedPosition(r22), PlaybackStateCompatApi21.getPlaybackSpeed(r22), PlaybackStateCompatApi21.getActions(r22), 0, PlaybackStateCompatApi21.getErrorMessage(r22), PlaybackStateCompatApi21.getLastPositionUpdateTime(r22), r18, PlaybackStateCompatApi21.getActiveQueueItemId(r22), r1);
        r5.mStateObj = r22;
        return r5;
    L11:
        r18 = null;
        goto L13
    L18:
        return null;
    }

    public long getCurrentPosition(Long r8) {
        long r0 = this.mPosition;
        float r2 = this.mSpeed;
        if (r8 == null) goto L5;
        long r3 = r8.longValue();
    L7:
        return Math.max(0, r0 + ((long) (r2 * r3)));
    L5:
        r3 = SystemClock.elapsedRealtime() - this.mUpdateTime;
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.mState);
        r3.writeLong(this.mPosition);
        r3.writeFloat(this.mSpeed);
        r3.writeLong(this.mUpdateTime);
        r3.writeLong(this.mBufferedPosition);
        r3.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, r3, r4);
        r3.writeTypedList(this.mCustomActions);
        r3.writeLong(this.mActiveItemId);
        r3.writeBundle(this.mExtras);
        r3.writeInt(this.mErrorCode);
    }

    public PlaybackStateCompat(int r4, long r5, long r7, float r9, long r10, int r12, CharSequence r13, long r14, List<CustomAction> r16, long r17, Bundle r19) {
        this.mState = r4;
        this.mPosition = r5;
        this.mBufferedPosition = r7;
        this.mSpeed = r9;
        this.mActions = r10;
        this.mErrorCode = r12;
        this.mErrorMessage = r13;
        this.mUpdateTime = r14;
        this.mCustomActions = new ArrayList(r16);
        this.mActiveItemId = r17;
        this.mExtras = r19;
    }
}
