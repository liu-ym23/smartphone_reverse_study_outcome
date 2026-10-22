package com.ss.ttvideoengine.source.strategy;

import android.text.TextUtils;
import com.ss.ttvideoengine.AppInfo;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.InfoWrapper;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.selector.BestResolution;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class CodecStrategy {
    public static final List<Dimension> COST_SAVING_FIRST_LIST = null;
    public static final List<Dimension> FALLBACK_LIST = null;
    public static final List<Dimension> HARDWARE_DECODE_FIRST_LIST = null;
    public static final int KEY_COST_SAVING_FIST = 1;
    public static final int KEY_HARDWARE_DECODE_FIRST = 2;
    public static final String TAG = "CodecStrategy";

    /* JADX INFO: renamed from: com.ss.ttvideoengine.source.strategy.CodecStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$Source$Type = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension = null;

        static {
            int[] r100 = new int[Source.Type.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type = r100;
            r100[Source.Type.DIRECT_URL_SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L20:
            $SwitchMap$com$ss$ttvideoengine$source$Source$Type[Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            int[] r101 = new int[Dimension.values().length];
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension = r101;
            r101[Dimension.BYTEVC1_HARDWARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.BYTEVC1_SOFTWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L32:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.BYTEVC2_SOFTWARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L22:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.H264_HARDWARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L28:
            $SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[Dimension.H264_SOFTWARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static final class Decoder {
        public static final int HARDWARE = 1;
        public static final int SOFTWARE = 0;

        public Decoder() {
        }

        private static boolean isSupportByteVC1HardwareDecode() {
            if (InfoWrapper.getByteVC1HardwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportByteVC1SoftwareCapability() {
            if (InfoWrapper.getByteVC1SoftwareCapabilityEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportByteVC1SoftwareDecode() {
            if (InfoWrapper.getByteVC1SoftwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportByteVC2SoftWareDecode() {
            if (InfoWrapper.getByteVC2SoftwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isSupportH264HardwareDecode() {
            if (InfoWrapper.getH264HardwareEnable() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static boolean isDeviceSupport(Dimension r100) {
            int r101 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[r100.ordinal()];
            if (r101 == 1) goto L26;
            if (r101 == 2) goto L24;
            if (r101 == 3) goto L18;
            if (r101 == 4) goto L16;
            if (r101 != 5) goto L14;
            return true;
        L14:
            throw new IllegalArgumentException("unsupported dimension! " + r100);
        L16:
            return isSupportH264HardwareDecode();
        L18:
            if (isSupportByteVC1SoftwareDecode() == true) goto L20;
            return false;
        L20:
            return isSupportByteVC2SoftWareDecode();
        L24:
            return isSupportByteVC1SoftwareDecode();
        L26:
            return isSupportByteVC1HardwareDecode();
        }

        private static boolean isSDKSupport(Dimension r100) {
            int r101 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$strategy$CodecStrategy$Dimension[r100.ordinal()];
            if (r101 != 1) goto L5;
            return true;
        L5:
            if (r101 == 2) goto L19;
            if (r101 == 3) goto L17;
            if (r101 != 4) goto L11;
            return true;
        L11:
            if (r101 != 5) goto L14;
            return true;
        L14:
            throw new IllegalArgumentException("unsupported dimension! " + r100);
        L17:
            return FeatureManager.hasPermission("bytevc2");
        L19:
            return isSupportByteVC1SoftwareCapability();
        }

        public static boolean isSupport(Dimension r100) {
            if (isDeviceSupport(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (isSDKSupport(r100) == false) goto L7;
            return true;
        }
    }

    public static final enum Dimension extends Enum<Dimension> {
        private static final /* synthetic */ Dimension[] $VALUES = null;
        public static final Dimension BYTEVC1_HARDWARE = null;
        public static final Dimension BYTEVC1_SOFTWARE = null;
        public static final Dimension BYTEVC2_SOFTWARE = null;
        public static final Dimension H264_HARDWARE = null;
        public static final Dimension H264_SOFTWARE = null;
        public final int decoder;
        public final String encodeType;

        static {
            Dimension r100 = new Dimension("BYTEVC1_HARDWARE", 0, 1, "bytevc1");
            BYTEVC1_HARDWARE = r100;
            Dimension r101 = new Dimension("BYTEVC1_SOFTWARE", 1, 0, "bytevc1");
            BYTEVC1_SOFTWARE = r101;
            Dimension r102 = new Dimension("BYTEVC2_SOFTWARE", 2, 0, "bytevc2");
            BYTEVC2_SOFTWARE = r102;
            Dimension r103 = new Dimension("H264_HARDWARE", 3, 1, "h264");
            H264_HARDWARE = r103;
            Dimension r104 = new Dimension("H264_SOFTWARE", 4, 0, "h264");
            H264_SOFTWARE = r104;
            $VALUES = new Dimension[]{r100, r101, r102, r103, r104};
        }

        public static Dimension[] values() {
            return (Dimension[]) $VALUES.clone();
        }

        public static Dimension valueOf(String r100) {
            return (Dimension) a.a(Dimension.class, r100);
        }

        private Dimension(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.decoder = r102;
            this.encodeType = r103;
        }
    }

    public static class ResolveResult {
        public Dimension correctedDimension;
        public final Dimension dimension;
        public final DirectUrlSource.UrlItem requestItem;
        public final StrategySource source;
        public final DirectUrlSource.UrlItem urlItem;

        public String toString() {
            return "ResolveResult{vid=" + this.source.vid() + ", sourceType=" + this.source.type() + ", dimension=" + this.dimension + ", correctedDimension=" + this.correctedDimension + ", urlItem=" + this.urlItem + ", requestItem=" + this.requestItem + '}';
        }

        public ResolveResult(VidPlayAuthTokenSource r100, Dimension r101) {
            this.source = r100;
            this.dimension = r101;
            this.urlItem = null;
            this.requestItem = null;
        }

        public ResolveResult(DirectUrlSource r100, Dimension r101, DirectUrlSource.UrlItem r102, DirectUrlSource.UrlItem r103) {
            this.source = r100;
            this.dimension = r101;
            this.urlItem = r102;
            this.requestItem = r103;
        }
    }

    public static final class SmartUrlVod {
        private static final Resolution SMART_URL_DEFAULT_RESOLUTION = null;

        public SmartUrlVod() {
        }

        public static String encodeType() {
            return "bytevc1";
        }

        static {
            SMART_URL_DEFAULT_RESOLUTION = Resolution.SuperHigh;
        }

        public static String getApiHost() {
            return AppInfo.getSmartUrlApiHost();
        }

        public static boolean isSettingsEnable() {
            if (InfoWrapper.getSmartUrlEnabled() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public static Resolution videoResolution() {
            return SMART_URL_DEFAULT_RESOLUTION;
        }

        public static Resolution findTargetResolution(IVideoModel r100) {
            return BestResolution.findDefaultResolution(r100, videoResolution());
        }

        public static boolean isEnable(DirectUrlSource r100) {
            if (r100.isSmartUrlValid() == true) goto L5;
        L7:
            return false;
        L5:
            if (isSettingsEnable() == false) goto L7;
            return true;
        }
    }

    static {
        Dimension r100 = Dimension.BYTEVC2_SOFTWARE;
        Dimension r101 = Dimension.BYTEVC1_HARDWARE;
        Dimension r102 = Dimension.BYTEVC1_SOFTWARE;
        Dimension r103 = Dimension.H264_HARDWARE;
        Dimension r110 = Dimension.H264_SOFTWARE;
        COST_SAVING_FIRST_LIST = Collections.unmodifiableList(Arrays.asList(new Dimension[]{r100, r101, r102, r103, r110}));
        HARDWARE_DECODE_FIRST_LIST = Collections.unmodifiableList(Arrays.asList(new Dimension[]{r101, r103, r100, r102, r110}));
        FALLBACK_LIST = Collections.unmodifiableList(Arrays.asList(new Dimension[]{r110, r103, r102, r101, r100}));
    }

    public CodecStrategy() {
    }

    public static boolean isCodecStrategyValid(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static String dump() {
        return "smartUrl=" + InfoWrapper.getSmartUrlEnabled() + ", 4_h=" + InfoWrapper.getH264HardwareEnable() + ", b_h=" + InfoWrapper.getByteVC1HardwareEnable() + ", b_s=" + InfoWrapper.getByteVC1SoftwareEnable() + ", b_s_cap=" + InfoWrapper.getByteVC1SoftwareCapabilityEnable() + ", b2_s=" + InfoWrapper.getByteVC2SoftwareEnable();
    }

    public static List<Dimension> dimensions(StrategySource r100) {
        int r101 = r100.codecStrategy();
        if (r101 != 1) goto L7;
        return supportedDimensions(r100, COST_SAVING_FIRST_LIST);
    L7:
        if (r101 != 2) goto L11;
        return supportedDimensions(r100, HARDWARE_DECODE_FIRST_LIST);
    L11:
        throw new IllegalArgumentException("unsupported strategy! " + r101);
    }

    public static List<Dimension> fallbackDimensions(StrategySource r100) {
        return supportedDimensions(r100, FALLBACK_LIST);
    }

    public static ResolveResult resolveFallback(StrategySource r100, List<Dimension> r101) {
        List<Dimension> r102 = fallbackDimensions(r100);
        Source.Type r103 = r100.type();
        int r104 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r103.ordinal()];
        if (r104 == 1) goto L11;
        if (r104 != 2) goto L9;
        return resolveVidPlayAuthToken((VidPlayAuthTokenSource) r100, r102, r101);
    L9:
        throw new IllegalArgumentException("unsupported type! " + r103);
    L11:
        return resolveDirectUrl((DirectUrlSource) r100, r102, r101);
    }

    public static ResolveResult resolveStartPlayback(StrategySource r100, boolean r101) {
        List<Dimension> r102 = dimensions(r100);
        Source.Type r103 = r100.type();
        int r104 = AnonymousClass1.$SwitchMap$com$ss$ttvideoengine$source$Source$Type[r103.ordinal()];
        if (r104 != 1) goto L5;
        DirectUrlSource r105 = (DirectUrlSource) r100;
        if (SmartUrlVod.isEnable(r105) == false) goto L16;
        if (r101 == false) goto L16;
        return resolveSmartUrl(r105, r102, null);
    L16:
        return resolveDirectUrl(r105, r102, null);
    L5:
        if (r104 != 2) goto L9;
        return resolveVidPlayAuthToken((VidPlayAuthTokenSource) r100, r102, null);
    L9:
        throw new IllegalArgumentException("unsupported type! " + r103);
    }

    private static List<Dimension> supportedDimensions(StrategySource r100, List<Dimension> r101) {
        if (r100.type() != Source.Type.VID_PLAY_AUTH_TOKEN_SOURCE) goto L5;
        List<String> r102 = ((VidPlayAuthTokenSource) r100).supportedEncodeTypes();
    L6:
        ArrayList r103 = new ArrayList();
        Iterator<Dimension> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L15;
        Dimension r105 = r104.next();
        if (Decoder.isSupport(r105) == false) goto L8;
        if (r102 == null) goto L14;
        if (r102.contains(r105.encodeType) == false) goto L8;
    L14:
        r103.add(r105);
        goto L8
    L15:
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    private static ResolveResult resolveDirectUrl(DirectUrlSource r100, List<Dimension> r101, List<Dimension> r102) {
        if (r100.allItems().isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<Dimension> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        Dimension r104 = r103.next();
        if (r102 == null) goto L12;
        if (r102.contains(r104) == true) goto L7;
    L12:
        DirectUrlSource.UrlItem r105 = r100.findItemByEncodeType(r104.encodeType);
        if (r105 == null) goto L7;
        return new ResolveResult(r100, r104, r105, null);
    L16:
        return null;
    }

    private static ResolveResult resolveSmartUrl(DirectUrlSource r100, List<Dimension> r101, List<Dimension> r102) {
        if (r100.allItems().isEmpty() == false) goto L5;
        return null;
    L5:
        ArrayList r103 = new ArrayList();
        Iterator<Dimension> r104 = r101.iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        Dimension r105 = r104.next();
        if (r102 == null) goto L12;
        if (r102.contains(r105) == true) goto L7;
    L12:
        r103.add(r105);
        goto L7
    L14:
        if (r103.isEmpty() == false) goto L16;
        return null;
    L16:
        Iterator r106 = r103.iterator();
    L18:
        if (r106.hasNext() == false) goto L27;
        Dimension r107 = (Dimension) r106.next();
        DirectUrlSource.UrlItem r108 = r100.findItemByEncodeType(r107.encodeType);
        if (r108 != null) goto L22;
        if (TextUtils.equals(r107.encodeType, SmartUrlVod.encodeType()) == false) goto L18;
        return new ResolveResult(r100, r107, null, r100.firstItem());
    L22:
        return new ResolveResult(r100, r107, r108, null);
    L27:
        return null;
    }

    private static ResolveResult resolveVidPlayAuthToken(VidPlayAuthTokenSource r100, List<Dimension> r101, List<Dimension> r102) {
        Iterator<Dimension> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        Dimension r104 = r103.next();
        if (r102 == null) goto L10;
        if (r102.contains(r104) == true) goto L4;
    L10:
        if (r100.encodeType() == null) goto L14;
        if (TextUtils.equals(r100.encodeType(), r104.encodeType) == false) goto L4;
    L14:
        return new ResolveResult(r100, r104);
    L15:
        return null;
    }

    public static Dimension resolveWithEncoderType(String r100, StrategySource r101, List<Dimension> r102) {
        Iterator<Dimension> r103 = dimensions(r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Dimension r104 = r103.next();
        if (r102 == null) goto L10;
        if (r102.contains(r104) == true) goto L4;
    L10:
        if (TextUtils.equals(r100, r104.encodeType) == false) goto L4;
        return r104;
    L12:
        return null;
    }
}
