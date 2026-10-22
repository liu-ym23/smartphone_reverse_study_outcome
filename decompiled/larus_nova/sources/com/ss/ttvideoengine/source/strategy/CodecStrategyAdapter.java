package com.ss.ttvideoengine.source.strategy;

import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.ttvideoengine.DirectUrlItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineImpl;
import com.ss.ttvideoengine.TTVideoEngineInternal;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.source.VideoModelSource;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import com.ss.ttvideoengine.utils.EngineException;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class CodecStrategyAdapter {
    public final String TAG;
    private final List<CodecStrategy.Dimension> mErrorDimensions;
    private CodecStrategy.ResolveResult mResolveResult;
    private SmartUrlFetcher mSmartUrlFetcher;
    private StrategySource mSource;
    private final SourceSetter mSourceSetter;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$Source$Type = null;

        static {
            int[] r100 = new int[Source.Type.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type = r100;
            r100[Source.Type.DIRECT_URL_SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type[Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type[Source.Type.VIDEO_MODEL_SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class PlayerSourceSetter implements SourceSetter {
        TTVideoEngineImpl mEngine;

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public int type() {
            return 0;
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public String createTag() {
            return TTVideoEngineInternal.logcatTag(this.mEngine) + "_CodecStrategy";
        }

        public void play() {
            this.mEngine.play();
        }

        public void stop() {
            this.mEngine.stop();
        }

        public PlayerSourceSetter(TTVideoEngineImpl r100) {
            this.mEngine = r100;
        }

        private void configPlayerWithDimension(CodecStrategy.Dimension r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            this.mEngine.setStringOption(1000, r100.encodeType);
            if (r100.decoder != 1) goto L12;
            this.mEngine.setIntOption(7, 1);
            if (TextUtils.equals(r100.encodeType, "bytevc1") == false) goto L10;
            this.mEngine.setAsyncInit(true, 1);
            return;
        L10:
            if (TextUtils.equals(r100.encodeType, "h264") == false) goto L15;
            this.mEngine.setAsyncInit(true, 0);
            return;
        L15:
            return;
        L12:
            this.mEngine.setIntOption(7, 0);
        }

        public void setEncodedKey(String r100) {
            this.mEngine.setEncodedKey(r100);
        }

        public static /* synthetic */ void access$000(PlayerSourceSetter r100, CodecStrategy.Dimension r101) {
            r100.configPlayerWithDimension(r101);
        }

        public void setStringOption(int r100, String r101) {
            this.mEngine.setStringOption(r100, r101);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setVideoModel(String r100, IVideoModel r101, Resolution r102) {
            TTVideoEngineLog.d(createTag(), "setVideoModel vid = " + r100 + ", videoModel = " + r101 + ", resolution = " + r102);
            this.mEngine.setVideoModel(r101);
            this.mEngine.configResolution(r102);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setDirectUrl(String r110, DirectUrlSource.UrlItem r111, CodecStrategy.Dimension r112, boolean r113) {
            TTVideoEngineLog.d(createTag(), "setDirectUrl vid = " + r110 + ", urlItem = " + r111 + ", dimension = " + r112 + ", isFetchSmartUrl = " + r113);
            if (r113 == true) goto L16;
            if (r111.getUrlExpiredTime() <= 0) goto L8;
        L11:
            this.mEngine.setDirectUrlUseDataLoader(new DirectUrlItem(r111.getUrls(), r111.getCacheKey(), r110, r111.getUrlExpiredTime(), r111.getUrlExpires(), r111.getFormat(), r111.getBitrate()));
        L13:
            if (r111.getPlayAuth() == null) goto L16;
            this.mEngine.setEncodedKey(r111.getPlayAuth());
            goto L16
        L8:
            if (r111.getUrlExpires() != null) goto L11;
            this.mEngine.setDirectUrlUseDataLoader(r111.getUrls(), r111.getCacheKey(), r110, r111.getFormat(), r111.getBitrate());
        L16:
            if (r112 == null) goto L18;
            configPlayerWithDimension(r112);
            this.mEngine.setIntOption(670, 0);
            return;
        L18:
            this.mEngine.setIntOption(670, 1);
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        public void setVideoID(String r100, String r101, Resolution r102, String r103, CodecStrategy.Dimension r104) {
            TTVideoEngineLog.d(createTag(), "setVideoID vid = " + r100 + ", playAuthToken = " + r101 + ", dimension = " + r104);
            this.mEngine.setVideoID(r100);
            this.mEngine.setPlayAuthToken(r101);
            if (r104 == null) goto L5;
            configPlayerWithDimension(r104);
            this.mEngine.setIntOption(670, 0);
        L7:
            if (r102 == null) goto L10;
            this.mEngine.configResolution(r102);
            return;
        L10:
            return;
        L5:
            if (r103 == null) goto L7;
            this.mEngine.setStringOption(1000, r103);
            this.mEngine.setIntOption(670, 1);
            goto L7
        }
    }

    public interface PreloadSourceSetter extends SourceSetter {

        /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter$PreloadSourceSetter$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static String $default$createTag(PreloadSourceSetter r100) {
                return "DataLoaderHelper_CodecStrategy";
            }

            public static int $default$type(PreloadSourceSetter r100) {
                return 1;
            }

            public static void $default$setVideoModel(PreloadSourceSetter r100, String r101, IVideoModel r102, Resolution r103) {
                TTVideoEngineLog.d(r100.createTag(), "setVideoModel vid = " + r101 + ", videoModel = " + r102 + ", resolution = " + r103);
            }

            public static void $default$setDirectUrl(PreloadSourceSetter r100, String r101, DirectUrlSource.UrlItem r102, CodecStrategy.Dimension r103, boolean r104) {
                TTVideoEngineLog.d(r100.createTag(), "setDirectUrl vid = " + r101 + ", urlItem = " + r102 + ", dimension = " + r103 + ", isFetchSmartUrl = " + r104);
            }

            public static void $default$setVideoID(PreloadSourceSetter r100, String r101, String r102, Resolution r103, String r104, CodecStrategy.Dimension r105) {
                TTVideoEngineLog.d(r100.createTag(), "setVideoID vid = " + r101 + ", playAuthToken = " + r102 + ", encodeType = " + r104 + ", dimension = " + r105);
            }
        }

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        String createTag();

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        void setDirectUrl(String r100, DirectUrlSource.UrlItem r101, CodecStrategy.Dimension r102, boolean r103);

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        void setVideoID(String r100, String r101, Resolution r102, String r103, CodecStrategy.Dimension r104);

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        void setVideoModel(String r100, IVideoModel r101, Resolution r102);

        @Override // com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter.SourceSetter
        int type();
    }

    public interface SourceSetter {
        public static final int TYPE_PLAYER = 0;
        public static final int TYPE_PRELOAD = 1;

        /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter$SourceSetter$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static String $default$createTag(SourceSetter r100) {
                return CodecStrategy.TAG;
            }

            public static void $default$setDirectUrl(SourceSetter r100, String r101, DirectUrlSource.UrlItem r102, CodecStrategy.Dimension r103, boolean r104) {
            }

            public static void $default$setVideoID(SourceSetter r100, String r101, String r102, Resolution r103, String r104, CodecStrategy.Dimension r105) {
            }

            public static void $default$setVideoModel(SourceSetter r100, String r101, IVideoModel r102, Resolution r103) {
            }

            public static int $default$type(SourceSetter r100) {
                return -1;
            }
        }

        String createTag();

        void setDirectUrl(String r100, DirectUrlSource.UrlItem r101, CodecStrategy.Dimension r102, boolean r103);

        void setVideoID(String r100, String r101, Resolution r102, String r103, CodecStrategy.Dimension r104);

        void setVideoModel(String r100, IVideoModel r101, Resolution r102);

        int type();
    }

    public void cancelFetchSmartUrlInfo() {
        if (this.mSmartUrlFetcher != null) goto L6;
        return;
    L6:
        if (this.mResolveResult != null) goto L8;
    L12:
        this.mSmartUrlFetcher.cancel();
        this.mSmartUrlFetcher = null;
        return;
    L8:
        if (this.mSource == null) goto L12;
        if (TTVideoEngineLog.d() == false) goto L12;
        TTVideoEngineLog.d(this.TAG, "cancelFetchSmartUrlInfo " + this.mSource.vid() + " " + this.mResolveResult.requestItem);
        goto L12
    }

    public boolean fallbackToDirectUrl() {
        SourceSetter r100 = this.mSourceSetter;
        if (r100 != null) goto L5;
        return false;
    L5:
        StrategySource r101 = this.mSource;
        if (r101 != null) goto L8;
    L10:
        DirectUrlSource r102 = null;
    L11:
        if (r102 != null) goto L13;
        return false;
    L13:
        CodecStrategy.ResolveResult r103 = CodecStrategy.resolveStartPlayback(r102, false);
        if (TTVideoEngineLog.d() == false) goto L16;
        TTVideoEngineLog.d(this.TAG, "fallbackToDirectUrl " + r102 + " " + r103);
    L16:
        if (r103 != null) goto L18;
        setupSource(r100, r102);
    L20:
        if (r100.type() != 0) goto L24;
        ((PlayerSourceSetter) r100).play();
        return true;
    L24:
        return true;
    L18:
        setupSource(r100, r103);
        goto L20
    L8:
        if (r101.type() != Source.Type.DIRECT_URL_SOURCE) goto L10;
        r102 = (DirectUrlSource) this.mSource;
        goto L11
    }

    public boolean isCodecStrategyValid() {
        StrategySource r100 = this.mSource;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isCodecStrategyValid();
    }

    public boolean isFetchSmartUrl() {
        StrategySource r100 = this.mSource;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.type() == Source.Type.DIRECT_URL_SOURCE) goto L8;
        return false;
    L8:
        if (CodecStrategy.SmartUrlVod.isEnable((DirectUrlSource) this.mSource) == false) goto L16;
        CodecStrategy.ResolveResult r101 = this.mResolveResult;
        if (r101 != null) goto L12;
        return false;
    L12:
        if (r101.requestItem == null) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public void release() {
        reset();
        this.mErrorDimensions.clear();
    }

    public void reset() {
        if (TTVideoEngineLog.d() == false) goto L5;
        TTVideoEngineLog.d(this.TAG, BasicTestActionHandler.TEST_ACTION_RESET);
    L5:
        cancelFetchSmartUrlInfo();
        this.mSource = null;
        this.mResolveResult = null;
    }

    public StrategySource getStrategySource() {
        return this.mSource;
    }

    public CodecStrategyAdapter(SourceSetter r100) {
        this.mErrorDimensions = new ArrayList();
        this.mSourceSetter = r100;
        this.TAG = createTag(r100);
    }

    public static String createTag(SourceSetter r100) {
        return r100.createTag();
    }

    private static String resolveVideoModelEncoderType(IVideoModel r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r101 = r100.getCodecs();
        if (r101 != null) goto L8;
        return null;
    L8:
        List r102 = Arrays.asList(r101);
        if (r102.contains("bytevc2") == false) goto L12;
        return "bytevc2";
    L12:
        if (r102.contains("bytevc1") == true) goto L17;
        return "h264";
    L17:
        return "bytevc1";
    }

    public void correctStrategy(IVideoModel r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SourceSetter r101 = this.mSourceSetter;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.type() != 0) goto L48;
        PlayerSourceSetter r102 = (PlayerSourceSetter) this.mSourceSetter;
        CodecStrategy.ResolveResult r103 = this.mResolveResult;
        if (r103 != null) goto L12;
        return;
    L12:
        StrategySource r104 = this.mSource;
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.isCodecStrategyValid() == true) goto L18;
        return;
    L18:
        String r105 = resolveVideoModelEncoderType(r100);
        if (r105 != null) goto L21;
        return;
    L21:
        CodecStrategy.Dimension r106 = r103.dimension;
        if (TextUtils.equals(r106.encodeType, r105) == false) goto L28;
        if (TTVideoEngineLog.d() == false) goto L46;
        TTVideoEngineLog.d(this.TAG, "correctStrategy result is [right] " + r106);
        return;
    L46:
        return;
    L28:
        if (TTVideoEngineLog.d() == false) goto L30;
        TTVideoEngineLog.d(this.TAG, "correctStrategy result is [wrong] " + r105 + " " + r106);
    L30:
        CodecStrategy.Dimension[] r107 = CodecStrategy.Dimension.values();
        int r108 = r107.length;
        int r109 = 0;
    L31:
        if (r109 >= r108) goto L36;
        if (TextUtils.equals(r107[r109].encodeType, r106.encodeType) == false) goto L35;
        this.mErrorDimensions.add(r106);
    L35:
        r109 = r109 + 1;
        goto L31
    L36:
        CodecStrategy.Dimension r110 = CodecStrategy.resolveWithEncoderType(r105, r104, this.mErrorDimensions);
        if (TTVideoEngineLog.d() == false) goto L39;
        TTVideoEngineLog.d(this.TAG, "correctStrategy corrected dimension = " + r110 + "; old = " + r106);
    L39:
        if (r110 != null) goto L41;
        return;
    L41:
        correctDimension(r102, r110);
        return;
    }

    public void fetchSmartUrlInfo(SmartUrlFetcher.Callback r100) {
        SmartUrlFetcher r101 = this.mSmartUrlFetcher;
        if (r101 == null) goto L6;
        r101.cancel();
        this.mSmartUrlFetcher = null;
    L6:
        if (this.mSource != null) goto L8;
        return;
    L8:
        CodecStrategy.ResolveResult r102 = this.mResolveResult;
        if (r102 != null) goto L11;
        return;
    L11:
        DirectUrlSource.UrlItem r103 = r102.requestItem;
        if (r103 != null) goto L15;
        return;
    L15:
        if (TTVideoEngineLog.d() == false) goto L17;
        TTVideoEngineLog.d(this.TAG, "fetchSmartUrlInfo " + this.mSource.vid() + " " + this.mResolveResult.requestItem);
    L17:
        this.mSmartUrlFetcher = new SmartUrlFetcher(r100);
        SmartUrlFetcher.RequestParams r104 = new SmartUrlFetcher.RequestParams();
        r104.videoId = this.mSource.vid();
        r104.playUrl = r103.getUrl();
        r104.cacheKey = r103.getCacheKey();
        r104.codec = CodecStrategy.SmartUrlVod.encodeType();
        r104.definition = CodecStrategy.SmartUrlVod.videoResolution().toString(VideoRef.TYPE_VIDEO);
        this.mSmartUrlFetcher.setRequestParams(r104);
        this.mSmartUrlFetcher.start();
    }

    public boolean interceptFallbackRetry(Error r100) {
        SourceSetter r101 = this.mSourceSetter;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.type() == 0) goto L8;
        return false;
    L8:
        PlayerSourceSetter r102 = (PlayerSourceSetter) this.mSourceSetter;
        StrategySource r103 = this.mSource;
        if (r103 != null) goto L12;
        return false;
    L12:
        if (r103.isCodecStrategyValid() == true) goto L14;
        return false;
    L14:
        CodecStrategy.ResolveResult r104 = this.mResolveResult;
        if (r104 != null) goto L18;
        return false;
    L18:
        if (this.mErrorDimensions.contains(r104.dimension) == true) goto L20;
        this.mErrorDimensions.add(r104.dimension);
    L20:
        CodecStrategy.ResolveResult r105 = CodecStrategy.resolveFallback(r103, this.mErrorDimensions);
        if (r105 != null) goto L27;
        if (TTVideoEngineLog.e() == false) goto L25;
        TTVideoEngineLog.e(this.TAG, "resolveFallback return null! " + r103 + " " + this.mErrorDimensions + " " + CodecStrategy.dump());
    L25:
        return false;
    L27:
        if (TTVideoEngineLog.d() == false) goto L29;
        TTVideoEngineLog.d(this.TAG, "resolveFallback " + r105 + " " + CodecStrategy.dump());
    L29:
        setupSource(r102, r105);
        r102.play();
        return true;
    }

    public void setStrategySource(StrategySource r100) throws EngineException {
        reset();
        if (r100 == null) goto L16;
        if (TTVideoEngineLog.d() == false) goto L7;
        TTVideoEngineLog.d(this.TAG, "setStrategySource " + r100);
        TTVideoEngineLog.d(this.TAG, "setStrategySource " + CodecStrategy.dump());
    L7:
        this.mSource = r100;
        if (r100.isCodecStrategyValid() == false) goto L13;
        CodecStrategy.ResolveResult r101 = CodecStrategy.resolveStartPlayback(r100, true);
        if (r101 == null) goto L12;
        setupSource(this.mSourceSetter, r101);
        return;
    L12:
        setupSource(this.mSourceSetter, r100);
        return;
    L13:
        setupSource(this.mSourceSetter, r100);
        return;
    L16:
        throw new EngineException(new Error(Error.SetStrategySource, Error.InvalidSource));
    }

    public CodecStrategyAdapter(TTVideoEngineImpl r100) {
        this(new PlayerSourceSetter(r100));
    }

    private void correctDimension(PlayerSourceSetter r100, CodecStrategy.Dimension r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        CodecStrategy.ResolveResult r102 = this.mResolveResult;
        if (r102 == null) goto L7;
        r102.correctedDimension = r101;
    L7:
        PlayerSourceSetter.access$000(r100, r101);
    }

    private void setupSource(SourceSetter r100, CodecStrategy.ResolveResult r110) {
        this.mResolveResult = r110;
        StrategySource r101 = r110.source;
        CodecStrategy.Dimension r102 = r110.correctedDimension;
        if (r102 != null) goto L6;
        r102 = r110.dimension;
    L6:
        CodecStrategy.Dimension r103 = r102;
        Source.Type r104 = r101.type();
        int r105 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r104.ordinal()];
        if (r105 != 1) goto L9;
        DirectUrlSource.UrlItem r106 = r110.urlItem;
        DirectUrlSource.UrlItem r107 = r110.requestItem;
        if (r106 == null) goto L16;
        r100.setDirectUrl(r101.vid(), r106, r103, false);
        return;
    L16:
        if (r107 == null) goto L20;
        r100.setDirectUrl(r101.vid(), r107, r103, true);
        return;
    L20:
        if (TTVideoEngineLog.d() == false) goto L25;
        TTVideoEngineLog.d(this.TAG, "setupSource CodecStrategy error:" + r110);
        return;
    L25:
        return;
    L9:
        if (r105 != 2) goto L12;
        VidPlayAuthTokenSource r108 = (VidPlayAuthTokenSource) r101;
        r100.setVideoID(r108.vid(), r108.playAuthToken(), r108.resolution(), null, r103);
        return;
    L12:
        throw new IllegalArgumentException("unsupported source type! " + r104);
    }

    private void setupSource(SourceSetter r100, StrategySource r101) {
        this.mResolveResult = null;
        Source.Type r102 = r101.type();
        int r103 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r102.ordinal()];
        if (r103 != 1) goto L5;
        DirectUrlSource.UrlItem r104 = ((DirectUrlSource) r101).firstItem();
        r100.setDirectUrl(r101.vid(), r104, null, false);
        return;
    L5:
        if (r103 != 2) goto L7;
        VidPlayAuthTokenSource r105 = (VidPlayAuthTokenSource) r101;
        r100.setVideoID(r101.vid(), r105.playAuthToken(), r105.resolution(), r105.encodeType(), null);
        return;
    L7:
        if (r103 != 3) goto L15;
        VideoModelSource r106 = (VideoModelSource) r101;
        r100.setVideoModel(r106.vid(), r106.videoModel(), r106.resolution());
        return;
    }
}
