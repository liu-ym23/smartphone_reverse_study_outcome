package com.ss.ttvideoengine.source;

import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.strategy.source.StrategySource;

/* JADX INFO: loaded from: classes35.dex */
public class VideoModelSource implements StrategySource {
    private final Resolution resolution;
    private final Object tag;
    private final String vid;
    private final IVideoModel videoModel;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.VideoModelSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Resolution resolution;
        private Object tag;
        private String vid;
        private IVideoModel videoModel;

        public Builder() {
        }

        public VideoModelSource build() {
            return new VideoModelSource(this, null);
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.vid;
        }

        public static /* synthetic */ IVideoModel access$100(Builder r100) {
            return r100.videoModel;
        }

        public static /* synthetic */ Resolution access$200(Builder r100) {
            return r100.resolution;
        }

        public static /* synthetic */ Object access$300(Builder r100) {
            return r100.tag;
        }

        public Builder setResolution(Resolution r100) {
            this.resolution = r100;
            return this;
        }

        public Builder setTag(Object r100) {
            this.tag = r100;
            return this;
        }

        public Builder setVid(String r100) {
            this.vid = r100;
            return this;
        }

        public Builder setVideoModel(IVideoModel r100) {
            this.videoModel = r100;
            return this;
        }
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return 0;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public final /* synthetic */ boolean isCodecStrategyValid() {
        return Source.CC.$default$isCodecStrategyValid(this);
    }

    public String toString() {
        return "VideoModelSource{vid='" + this.vid + "', videoModel=" + this.videoModel + ", resolution=" + this.resolution + '}';
    }

    public Resolution resolution() {
        return this.resolution;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Object tag() {
        return this.tag;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public Source.Type type() {
        return Source.Type.VIDEO_MODEL_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    public IVideoModel videoModel() {
        return this.videoModel;
    }

    private VideoModelSource(Builder r100) {
        this.vid = Builder.access$000(r100);
        this.videoModel = Builder.access$100(r100);
        this.resolution = Builder.access$200(r100);
        this.tag = Builder.access$300(r100);
    }

    public /* synthetic */ VideoModelSource(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
