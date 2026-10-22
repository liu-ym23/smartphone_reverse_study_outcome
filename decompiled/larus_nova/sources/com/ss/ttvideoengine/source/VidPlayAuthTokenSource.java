package com.ss.ttvideoengine.source;

import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class VidPlayAuthTokenSource implements StrategySource {
    public static final List<String> DEFAULT_SUPPORTED_ENCODE_TYPES = null;
    public static final String TAG = "VidPlayAuthTokenSource";
    private final int codecStrategy;
    private final String encodeType;
    private final String playAuthToken;
    private final Resolution resolution;
    private final List<String> supportedEncodeTypes;
    private final Object tag;
    private final String vid;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.VidPlayAuthTokenSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int codecStrategy;
        private String encodeType;
        private String playAuthToken;
        private Resolution resolution;
        private List<String> supportedEncodeTypes;
        private Object tag;
        private String vid;

        public Builder() {
        }

        public VidPlayAuthTokenSource build() {
            if (this.vid == null) goto L28;
            if (this.playAuthToken == null) goto L26;
            if (this.resolution != null) goto L9;
            this.resolution = Resolution.Standard;
        L9:
            List<String> r100 = this.supportedEncodeTypes;
            if (r100 == null) goto L18;
            String r101 = this.encodeType;
            if (r101 == null) goto L18;
            if (r100.contains(r101) == true) goto L18;
            throw new IllegalArgumentException("supportedEncodeTypes:" + this.supportedEncodeTypes + " must contains encodeType:" + this.encodeType);
        L18:
            List<String> r102 = this.supportedEncodeTypes;
            if (r102 != null) goto L21;
        L22:
            this.supportedEncodeTypes = VidPlayAuthTokenSource.DEFAULT_SUPPORTED_ENCODE_TYPES;
        L24:
            return new VidPlayAuthTokenSource(this, null);
        L21:
            if (r102.isEmpty() == false) goto L24;
        L26:
            throw new NullPointerException("playAuthToken is null");
        L28:
            throw new NullPointerException("vid is null");
        }

        public Builder(VidPlayAuthTokenSource r100) {
            this.vid = VidPlayAuthTokenSource.access$700(r100);
            this.playAuthToken = VidPlayAuthTokenSource.access$800(r100);
            this.encodeType = VidPlayAuthTokenSource.access$900(r100);
            this.resolution = VidPlayAuthTokenSource.access$1000(r100);
            this.codecStrategy = VidPlayAuthTokenSource.access$1100(r100);
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.vid;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.playAuthToken;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.encodeType;
        }

        public static /* synthetic */ List access$300(Builder r100) {
            return r100.supportedEncodeTypes;
        }

        public static /* synthetic */ Resolution access$400(Builder r100) {
            return r100.resolution;
        }

        public static /* synthetic */ int access$500(Builder r100) {
            return r100.codecStrategy;
        }

        public static /* synthetic */ Object access$600(Builder r100) {
            return r100.tag;
        }

        public Builder setCodecStrategy(int r100) {
            this.codecStrategy = r100;
            return this;
        }

        public Builder setEncodeType(String r100) {
            this.encodeType = r100;
            return this;
        }

        public Builder setPlayAuthToken(String r100) {
            if (r100 == null) goto L6;
            this.playAuthToken = r100;
            return this;
        L6:
            throw new NullPointerException("playAuthToken is null");
        }

        public Builder setResolution(Resolution r100) {
            this.resolution = r100;
            return this;
        }

        public Builder setSupportedEncodeTypes(List<String> r100) {
            if (r100 == null) goto L8;
            if (r100.isEmpty() == true) goto L8;
            this.supportedEncodeTypes = new ArrayList(r100);
            return this;
        L8:
            throw new IllegalArgumentException("supportedEncodeTypes can't be null or empty!");
        }

        public Builder setTag(Object r100) {
            this.tag = r100;
            return this;
        }

        public Builder setVid(String r100) {
            if (r100 == null) goto L6;
            this.vid = r100;
            return this;
        L6:
            throw new NullPointerException("vid is null");
        }
    }

    @Override // com.ss.ttvideoengine.source.Source
    public final /* synthetic */ boolean isCodecStrategyValid() {
        return Source.CC.$default$isCodecStrategyValid(this);
    }

    static {
        DEFAULT_SUPPORTED_ENCODE_TYPES = Collections.unmodifiableList(Arrays.asList(new String[]{"h264", "bytevc1", "bytevc2"}));
    }

    public List<String> supportedEncodeTypes() {
        return Collections.unmodifiableList(this.supportedEncodeTypes);
    }

    public String toString() {
        return "VidPlayAuthTokenSource{vid='" + this.vid + "', playAuthToken='" + this.playAuthToken + "', encodeType='" + this.encodeType + "', supportedEncodeTypes=" + this.supportedEncodeTypes + ", resolution=" + this.resolution + ", codecStrategy=" + this.codecStrategy + '}';
    }

    @Override // com.ss.ttvideoengine.source.Source
    public int codecStrategy() {
        return this.codecStrategy;
    }

    public String encodeType() {
        return this.encodeType;
    }

    public String playAuthToken() {
        return this.playAuthToken;
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
        return Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE;
    }

    @Override // com.ss.ttvideoengine.source.Source
    public String vid() {
        return this.vid;
    }

    private VidPlayAuthTokenSource(Builder r100) {
        this.vid = Builder.access$000(r100);
        this.playAuthToken = Builder.access$100(r100);
        this.encodeType = Builder.access$200(r100);
        this.supportedEncodeTypes = Builder.access$300(r100);
        this.resolution = Builder.access$400(r100);
        this.codecStrategy = Builder.access$500(r100);
        this.tag = Builder.access$600(r100);
    }

    public static /* synthetic */ Resolution access$1000(VidPlayAuthTokenSource r100) {
        return r100.resolution;
    }

    public static /* synthetic */ int access$1100(VidPlayAuthTokenSource r100) {
        return r100.codecStrategy;
    }

    public static /* synthetic */ String access$700(VidPlayAuthTokenSource r100) {
        return r100.vid;
    }

    public static /* synthetic */ String access$800(VidPlayAuthTokenSource r100) {
        return r100.playAuthToken;
    }

    public static /* synthetic */ String access$900(VidPlayAuthTokenSource r100) {
        return r100.encodeType;
    }

    public /* synthetic */ VidPlayAuthTokenSource(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
