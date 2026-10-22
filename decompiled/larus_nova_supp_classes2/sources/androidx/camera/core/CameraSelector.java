package androidx.camera.core;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import androidx.core.util.Preconditions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraSelector {
    public static final CameraSelector DEFAULT_BACK_CAMERA = null;
    public static final CameraSelector DEFAULT_FRONT_CAMERA = null;
    public static final int LENS_FACING_BACK = 1;
    public static final int LENS_FACING_EXTERNAL = 2;
    public static final int LENS_FACING_FRONT = 0;
    public static final int LENS_FACING_UNKNOWN = -1;
    private final LinkedHashSet<CameraFilter> mCameraFilterSet;
    private final String mPhysicalCameraId;

    public static final class Builder {
        private final LinkedHashSet<CameraFilter> mCameraFilterSet;
        private String mPhysicalCameraId;

        public CameraSelector build() {
            return new CameraSelector(this.mCameraFilterSet, this.mPhysicalCameraId);
        }

        public Builder() {
            this.mCameraFilterSet = new LinkedHashSet();
        }

        private Builder(LinkedHashSet<CameraFilter> r2) {
            this.mCameraFilterSet = new LinkedHashSet(r2);
        }

        public static Builder fromSelector(CameraSelector r1) {
            return new Builder(r1.getCameraFilterSet());
        }

        public Builder addCameraFilter(CameraFilter r2) {
            this.mCameraFilterSet.add(r2);
            return this;
        }

        public Builder requireLensFacing(int r3) {
            if (r3 == (-1)) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "The specified lens facing is invalid.");
            this.mCameraFilterSet.add(new LensFacingCameraFilter(r3));
            return this;
        L5:
            r0 = false;
            goto L6
        }

        public Builder setPhysicalCameraId(String r1) {
            this.mPhysicalCameraId = r1;
            return this;
        }
    }

    @Target({ElementType.TYPE, ElementType.TYPE_USE, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LensFacing {
    }

    static {
        DEFAULT_FRONT_CAMERA = new Builder().requireLensFacing(0).build();
        DEFAULT_BACK_CAMERA = new Builder().requireLensFacing(1).build();
    }

    public Integer getLensFacing() {
        Iterator<CameraFilter> r0 = this.mCameraFilterSet.iterator();
        Integer r1 = null;
    L4:
        if (r0.hasNext() == false) goto L15;
        CameraFilter r2 = r0.next();
        if ((r2 instanceof LensFacingCameraFilter) == false) goto L4;
        Integer r3 = Integer.valueOf(((LensFacingCameraFilter) r2).getLensFacing());
        if (r1 == null) goto L9;
        if (r1.equals(r3) == true) goto L4;
        throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
    L9:
        r1 = r3;
        goto L4
    L15:
        return r1;
    }

    public LinkedHashSet<CameraFilter> getCameraFilterSet() {
        return this.mCameraFilterSet;
    }

    public String getPhysicalCameraId() {
        return this.mPhysicalCameraId;
    }

    public LinkedHashSet<CameraInternal> filter(LinkedHashSet<CameraInternal> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<CameraInternal> r1 = r5.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().getCameraInfo());
        goto L4
    L6:
        List<CameraInfo> r2 = filter(r0);
        LinkedHashSet<CameraInternal> r3 = new LinkedHashSet();
        Iterator<CameraInternal> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        CameraInternal r4 = r6.next();
        if (r2.contains(r4.getCameraInfo()) == false) goto L8;
        r3.add(r4);
        goto L8
    L12:
        return r3;
    }

    public CameraInternal select(LinkedHashSet<CameraInternal> r2) {
        Iterator<CameraInternal> r3 = filter(r2).iterator();
        if (r3.hasNext() == false) goto L7;
        return r3.next();
    L7:
        throw new IllegalArgumentException("No available camera can be found");
    }

    public List<CameraInfo> filter(List<CameraInfo> r4) {
        List<CameraInfo> r0 = new ArrayList(r4);
        Iterator<CameraFilter> r1 = this.mCameraFilterSet.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0 = r1.next().filter(Collections.unmodifiableList(r0));
        goto L4
    L6:
        r0.retainAll(r4);
        return r0;
    }

    public CameraSelector(LinkedHashSet<CameraFilter> r1, String r2) {
        this.mCameraFilterSet = r1;
        this.mPhysicalCameraId = r2;
    }
}
