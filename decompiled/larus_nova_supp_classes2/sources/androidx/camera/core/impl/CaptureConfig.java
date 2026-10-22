package androidx.camera.core.impl;

import android.util.Range;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CaptureConfig {
    public static final String CAPTURE_CONFIG_ID_TAG_KEY = "CAPTURE_CONFIG_ID_KEY";
    public static final int DEFAULT_ID = -1;
    public static final Config.Option<Integer> OPTION_JPEG_QUALITY = null;
    private static final Config.Option<Range<Integer>> OPTION_RESOLVED_FRAME_RATE = null;
    public static final Config.Option<Integer> OPTION_ROTATION = null;
    public static final int TEMPLATE_TYPE_NONE = -1;
    final List<CameraCaptureCallback> mCameraCaptureCallbacks;
    private final CameraCaptureResult mCameraCaptureResult;
    final Config mImplementationOptions;
    final boolean mPostviewEnabled;
    final List<DeferrableSurface> mSurfaces;
    private final TagBundle mTagBundle;
    final int mTemplateType;
    private final boolean mUseRepeatingSurface;

    public static final class Builder {
        private List<CameraCaptureCallback> mCameraCaptureCallbacks;
        private CameraCaptureResult mCameraCaptureResult;
        private MutableConfig mImplementationOptions;
        private MutableTagBundle mMutableTagBundle;
        private boolean mPostviewEnabled;
        private final Set<DeferrableSurface> mSurfaces;
        private int mTemplateType;
        private boolean mUseRepeatingSurface;

        public CaptureConfig build() {
            return new CaptureConfig(new ArrayList(this.mSurfaces), OptionsBundle.from(this.mImplementationOptions), this.mTemplateType, this.mPostviewEnabled, new ArrayList(this.mCameraCaptureCallbacks), this.mUseRepeatingSurface, TagBundle.from(this.mMutableTagBundle), this.mCameraCaptureResult);
        }

        public void clearSurfaces() {
            this.mSurfaces.clear();
        }

        public Range<Integer> getExpectedFrameRateRange() {
            return (Range) this.mImplementationOptions.retrieveOption(CaptureConfig.access$000(), StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
        }

        public Builder() {
            this.mSurfaces = new HashSet();
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mPostviewEnabled = false;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
        }

        public Config getImplementationOptions() {
            return this.mImplementationOptions;
        }

        public Set<DeferrableSurface> getSurfaces() {
            return this.mSurfaces;
        }

        public int getTemplateType() {
            return this.mTemplateType;
        }

        public boolean isUseRepeatingSurface() {
            return this.mUseRepeatingSurface;
        }

        private Builder(CaptureConfig r4) {
            HashSet r0 = new HashSet();
            this.mSurfaces = r0;
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mPostviewEnabled = false;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
            r0.addAll(r4.mSurfaces);
            this.mImplementationOptions = MutableOptionsBundle.from(r4.mImplementationOptions);
            this.mTemplateType = r4.mTemplateType;
            this.mCameraCaptureCallbacks.addAll(r4.getCameraCaptureCallbacks());
            this.mUseRepeatingSurface = r4.isUseRepeatingSurface();
            this.mMutableTagBundle = MutableTagBundle.from(r4.getTagBundle());
            this.mPostviewEnabled = r4.mPostviewEnabled;
        }

        public static Builder createFrom(UseCaseConfig<?> r3) {
            OptionUnpacker r0 = r3.getCaptureOptionUnpacker(null);
            if (r0 == null) goto L7;
            Builder r1 = new Builder();
            r0.unpack(r3, r1);
            return r1;
        L7:
            throw new IllegalStateException("Implementation is missing option unpacker for " + r3.getTargetName(r3.toString()));
        }

        public static Builder from(CaptureConfig r1) {
            return new Builder(r1);
        }

        public void addAllCameraCaptureCallbacks(Collection<CameraCaptureCallback> r2) {
            Iterator<CameraCaptureCallback> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            addCameraCaptureCallback(r3.next());
            goto L4
        }

        public void addAllTags(TagBundle r2) {
            this.mMutableTagBundle.addTagBundle(r2);
        }

        public void addCameraCaptureCallback(CameraCaptureCallback r2) {
            if (this.mCameraCaptureCallbacks.contains(r2) == false) goto L5;
            return;
        L5:
            this.mCameraCaptureCallbacks.add(r2);
        }

        public void addImplementationOptions(Config r6) {
            Iterator<Config.Option<?>> r0 = r6.listOptions().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            Config.Option<?> r1 = r0.next();
            Object r2 = this.mImplementationOptions.retrieveOption(r1, null);
            Object r3 = r6.retrieveOption(r1);
            if ((r2 instanceof MultiValueSet) == true) goto L7;
            if ((r3 instanceof MultiValueSet) == false) goto L11;
            r3 = ((MultiValueSet) r3).clone();
        L11:
            this.mImplementationOptions.insertOption(r1, r6.getOptionPriority(r1), r3);
            goto L4
        L7:
            ((MultiValueSet) r2).addAll(((MultiValueSet) r3).getAllItems());
            goto L4
        }

        public void addSurface(DeferrableSurface r2) {
            this.mSurfaces.add(r2);
        }

        public Object getTag(String r2) {
            return this.mMutableTagBundle.getTag(r2);
        }

        public boolean removeCameraCaptureCallback(CameraCaptureCallback r2) {
            return this.mCameraCaptureCallbacks.remove(r2);
        }

        public void removeSurface(DeferrableSurface r2) {
            this.mSurfaces.remove(r2);
        }

        public void setCameraCaptureResult(CameraCaptureResult r1) {
            this.mCameraCaptureResult = r1;
        }

        public void setExpectedFrameRateRange(Range<Integer> r2) {
            addImplementationOption(CaptureConfig.access$000(), r2);
        }

        public void setId(int r3) {
            this.mMutableTagBundle.putTag(CaptureConfig.CAPTURE_CONFIG_ID_TAG_KEY, Integer.valueOf(r3));
        }

        public void setImplementationOptions(Config r1) {
            this.mImplementationOptions = MutableOptionsBundle.from(r1);
        }

        public void setPostviewEnabled(boolean r1) {
            this.mPostviewEnabled = r1;
        }

        public void setPreviewStabilization(int r2) {
            if (r2 == 0) goto L5;
            addImplementationOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(r2));
            return;
        }

        public void setTemplateType(int r1) {
            this.mTemplateType = r1;
        }

        public void setUseRepeatingSurface(boolean r1) {
            this.mUseRepeatingSurface = r1;
        }

        public void setVideoStabilization(int r2) {
            if (r2 == 0) goto L5;
            addImplementationOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(r2));
            return;
        }

        public <T> void addImplementationOption(Config.Option<T> r2, T r3) {
            this.mImplementationOptions.insertOption(r2, r3);
        }

        public void addTag(String r2, Object r3) {
            this.mMutableTagBundle.putTag(r2, r3);
        }
    }

    public interface OptionUnpacker {
        void unpack(UseCaseConfig<?> r1, Builder r2);
    }

    static {
        OPTION_ROTATION = Config.Option.create("camerax.core.captureConfig.rotation", Integer.TYPE);
        OPTION_JPEG_QUALITY = Config.Option.create("camerax.core.captureConfig.jpegQuality", Integer.class);
        OPTION_RESOLVED_FRAME_RATE = Config.Option.create("camerax.core.captureConfig.resolvedFrameRate", Range.class);
    }

    public static CaptureConfig defaultEmptyCaptureConfig() {
        return new Builder().build();
    }

    public Range<Integer> getExpectedFrameRateRange() {
        Range<Integer> r0 = (Range) this.mImplementationOptions.retrieveOption(OPTION_RESOLVED_FRAME_RATE, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
        Objects.requireNonNull(r0);
        return r0;
    }

    public int getId() {
        Object r0 = this.mTagBundle.getTag(CAPTURE_CONFIG_ID_TAG_KEY);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return ((Integer) r0).intValue();
    }

    public int getPreviewStabilizationMode() {
        Integer r0 = (Integer) this.mImplementationOptions.retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0);
        Objects.requireNonNull(r0);
        return r0.intValue();
    }

    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    public int getVideoStabilizationMode() {
        Integer r0 = (Integer) this.mImplementationOptions.retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0);
        Objects.requireNonNull(r0);
        return r0.intValue();
    }

    public static /* synthetic */ Config.Option access$000() {
        return OPTION_RESOLVED_FRAME_RATE;
    }

    public List<CameraCaptureCallback> getCameraCaptureCallbacks() {
        return this.mCameraCaptureCallbacks;
    }

    public CameraCaptureResult getCameraCaptureResult() {
        return this.mCameraCaptureResult;
    }

    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isPostviewEnabled() {
        return this.mPostviewEnabled;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }

    public CaptureConfig(List<DeferrableSurface> r1, Config r2, int r3, boolean r4, List<CameraCaptureCallback> r5, boolean r6, TagBundle r7, CameraCaptureResult r8) {
        this.mSurfaces = r1;
        this.mImplementationOptions = r2;
        this.mTemplateType = r3;
        this.mCameraCaptureCallbacks = Collections.unmodifiableList(r5);
        this.mUseRepeatingSurface = r6;
        this.mTagBundle = r7;
        this.mCameraCaptureResult = r8;
        this.mPostviewEnabled = r4;
    }
}
