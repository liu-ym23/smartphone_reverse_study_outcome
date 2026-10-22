package androidx.camera.camera2.internal;

import androidx.camera.core.CameraState;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraStateMachine {
    private static final String TAG = "CameraStateMachine";
    private final CameraStateRegistry mCameraStateRegistry;
    private final MutableLiveData<CameraState> mCameraStates;

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.CameraStateMachine$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraInternal$State = null;

        static {
            int[] r0 = new int[CameraInternal.State.values().length];
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State = r0;
            r0[CameraInternal.State.PENDING_OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.OPENING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.OPEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.CONFIGURED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.CLOSING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.RELEASING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.CLOSED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$androidx$camera$core$impl$CameraInternal$State[CameraInternal.State.RELEASED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    private CameraState onCameraPendingOpen() {
        if (this.mCameraStateRegistry.isCameraClosing() == false) goto L6;
        return CameraState.create(CameraState.Type.OPENING);
    L6:
        return CameraState.create(CameraState.Type.PENDING_OPEN);
    }

    public LiveData<CameraState> getStateLiveData() {
        return this.mCameraStates;
    }

    public CameraStateMachine(CameraStateRegistry r2) {
        this.mCameraStateRegistry = r2;
        MutableLiveData<CameraState> r3 = new MutableLiveData();
        this.mCameraStates = r3;
        r3.postValue(CameraState.create(CameraState.Type.CLOSED));
    }

    public void updateState(CameraInternal.State r4, CameraState.StateError r5) {
        switch(AnonymousClass1.$SwitchMap$androidx$camera$core$impl$CameraInternal$State[r4.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        CameraState r0 = CameraState.create(CameraState.Type.CLOSED, r5);
    L11:
        Logger.d(TAG, "New public camera state " + r0 + " from " + r4 + " and " + r5);
        if (Objects.equals((CameraState) this.mCameraStates.getValue(), r0) == true) goto L15;
        Logger.d(TAG, "Publishing new public camera state " + r0);
        this.mCameraStates.postValue(r0);
        return;
    L15:
        return;
    L7:
        r0 = CameraState.create(CameraState.Type.CLOSING, r5);
        goto L11
    L8:
        r0 = CameraState.create(CameraState.Type.OPEN, r5);
        goto L11
    L9:
        r0 = CameraState.create(CameraState.Type.OPENING, r5);
        goto L11
    L10:
        r0 = onCameraPendingOpen();
        goto L11
    L5:
        throw new IllegalStateException("Unknown internal camera state: " + r4);
    }
}
