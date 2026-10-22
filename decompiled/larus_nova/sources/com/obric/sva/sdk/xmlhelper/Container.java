package com.obric.sva.sdk.xmlhelper;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class Container {
    private static final String TAG = null;
    private String mContainerName;
    private List<Item> mItems;

    public interface ADAConfigurationKey {
        public static final String ADA_CAR_NOISE = "Ada.car_noise";
        public static final String ADA_ENABLE = "Ada.enable";
        public static final String ADA_ENABLE_CAR_NOISE = "Ada.enable_car_noise";
        public static final String ADA_ENABLE_LEVEL = "Ada.enableLevel";
        public static final String ADA_ENABLE_MUSIC_NOISE = "Ada.enable_music_noise";
        public static final String ADA_ENABLE_PARTY_NOISE = "Ada.enable_party_noise";
        public static final String ADA_ENABLE_PITCH = "Ada.enablePitch";
        public static final String ADA_ENABLE_RADIO_NOISE = "Ada.enable_radio_noise";
        public static final String ADA_ENABLE_REVERB = "Ada.enableReverb";
        public static final String ADA_ENABLE_TEMPO = "Ada.enableTempo";
        public static final String ADA_MUSIC_NOISE = "Ada.music_noise";
        public static final String ADA_NOISE_SNR_VOP = "Ada.noise_snr_vop";
        public static final String ADA_NOISE_TYPE_VOP = "Ada.noise_type_vop";
        public static final String ADA_NUM_CLEAN_REPETITION = "Ada.numCleanRepetition";
        public static final String ADA_PARTY_NOISE = "Ada.party_noise";
        public static final String ADA_RADIO_NOISE = "Ada.radio_noise";
    }

    public interface ADAKWConfigurationKey {
        public static final String ADA_CAR_NOISE = "Ada.kw.car_noise";
        public static final String ADA_ENABLE = "Ada.kw.enable";
        public static final String ADA_ENABLE_CAR_NOISE = "Ada.kw.enable_car_noise";
        public static final String ADA_ENABLE_LEVEL = "Ada.kw.enableLevel";
        public static final String ADA_ENABLE_MUSIC_NOISE = "Ada.kw.enable_music_noise";
        public static final String ADA_ENABLE_PARTY_NOISE = "Ada.kw.enable_party_noise";
        public static final String ADA_ENABLE_PITCH = "Ada.kw.enablePitch";
        public static final String ADA_ENABLE_RADIO_NOISE = "Ada.kw.enable_radio_noise";
        public static final String ADA_ENABLE_REVERB = "Ada.kw.enableReverb";
        public static final String ADA_ENABLE_TEMPO = "Ada.kw.enableTempo";
        public static final String ADA_MUSIC_NOISE = "Ada.kw.music_noise";
        public static final String ADA_NOISE_SNR_VOP = "Ada.kw.noise_snr_vop";
        public static final String ADA_NOISE_TYPE_VOP = "Ada.kw.noise_type_vop";
        public static final String ADA_NUM_CLEAN_REPETITION = "Ada.kw.numCleanRepetition";
        public static final String ADA_PARTY_NOISE = "Ada.kw.party_noise";
        public static final String ADA_RADIO_NOISE = "Ada.kw.radio_noise";
    }

    public interface ADAUserConfigurationKey {
        public static final String ADA_CAR_NOISE = "Ada.user.car_noise";
        public static final String ADA_ENABLE = "Ada.user.enable";
        public static final String ADA_ENABLE_CAR_NOISE = "Ada.user.enable_car_noise";
        public static final String ADA_ENABLE_LEVEL = "Ada.user.enableLevel";
        public static final String ADA_ENABLE_MUSIC_NOISE = "Ada.user.enable_music_noise";
        public static final String ADA_ENABLE_PARTY_NOISE = "Ada.user.enable_party_noise";
        public static final String ADA_ENABLE_PITCH = "Ada.user.enablePitch";
        public static final String ADA_ENABLE_RADIO_NOISE = "Ada.user.enable_radio_noise";
        public static final String ADA_ENABLE_REVERB = "Ada.user.enableReverb";
        public static final String ADA_ENABLE_TEMPO = "Ada.user.enableTempo";
        public static final String ADA_MUSIC_NOISE = "Ada.user.music_noise";
        public static final String ADA_NOISE_SNR_VOP = "Ada.user.noise_snr_vop";
        public static final String ADA_NOISE_TYPE_VOP = "Ada.user.noise_type_vop";
        public static final String ADA_NUM_CLEAN_REPETITION = "Ada.user.numCleanRepetition";
        public static final String ADA_PARTY_NOISE = "Ada.user.party_noise";
        public static final String ADA_RADIO_NOISE = "Ada.user.radio_noise";
    }

    public interface EPDConfigurationKey {
        public static final String EPD_FORGETTING_FACTOR_NOISE = "EPD.forgettingFactorNoise";
        public static final String EPD_KEYWORD_THRESHOLD = "EPD.keyword_threshold";
        public static final String EPD_MIN_ENERGY_FRAME_RATIO = "EPD.minEnergyFrameRatio";
        public static final String EPD_MIN_NOISE_ENERGY = "EPD.minNoiseEnergy";
        public static final String EPD_MIN_SNR_LEAVE = "EPD.minSnrLeave";
        public static final String EPD_MIN_SNR_ONSET = "EPD.minSnrOnset";
        public static final String EPD_NUM_FRAMES_INHEAD = "EPD.numFramesInHead";
        public static final String EPD_NUM_FRAMES_INTAIL = "EPD.numFramesInTail";
        public static final String EPD_NUM_FRAME_TRANSIENT_FRAME = "EPD.numFrameTransientFrame";
        public static final String EPD_NUM_MAX_FRAMES = "EPD.numMaxFrames";
        public static final String EPD_NUM_MIN_FRAMES_INPHRASE = "EPD.numMinFramesInPhrase";
        public static final String EPD_NUM_MIN_FRAMES_INSPEECH = "EPD.numMinFramesInSpeech";
        public static final String EPD_NUM_MIN_FRAMES_INSPEECH_GAP = "EPD.numMaxFrameInSpeechGap";
        public static final String EPD_PRE_EMPHASIZING = "EPD.preEmphasize";
        public static final String EPD_SNR_FLOOR = "EPD.snrFloor";
        public static final String EPD_SNR_THRESHOLDS = "EPD.snrThresholds";
    }

    public interface SMLPDKConfigurationKey {
        public static final String TRAINING_CHECK_CHOPPED = "Training.checkChopped";
        public static final String TRAINING_CHECK_CLIPPED = "Training.checkClipped";
        public static final String TRAINING_CHOPPING_FRAME_THRESHOLD = "Training.choppingFrameThreshold";
        public static final String TRAINING_CLIPPING_RATIO_THRESHOLD = "Training.clippingRatioThreshold";
        public static final String TRAINING_ENABLE_FIRST_STAGE_EPD = "Training.enableFstageEpd";
        public static final String TRAINING_ENABLE_ZERO_PROCESSING_FOR_PDK_XS = "Training.enableZeroProcessingForPdkXS";
        public static final String TRAINING_NUMGUARDFRAMES_FOR_EPD = "Training.numGuardFramesForEPD";
        public static final String TRAINING_NUMGUARDFRAMES_FOR_FIRST_STAGE_EPD = "Training.numGuardFramesForFStageEPD";
        public static final String TRAINING_NUM_CLEAR_RECORDINGS = "Training.nCleanRecordings";
        public static final String TRAINING_NUM_CLIPPING_THRESHOLD = "Training.nClippingThreshold";
        public static final String TRAINING_NUM_ZEROS_PADDING_FRAMES = "Training.nZerosPaddingFrames";
        public static final String TRAINING_PCM_NORMALIZATION = "Training.doPcmNormalization";
        public static final String TRAINING_SNR_THRESHOLD_FOR_NOISY_SAMPLES = "Training.snrThresholdForNoisySamples";
    }

    public interface SMLUDKConfigurationKey {
        public static final String TRAINING_MAX_PHONEME_LENGTH = "Training.maxPhonemeLength";
        public static final String TRAINING_MIN_PHONEME_LENGTH = "Training.minPhonemeLength";
        public static final String TRAINING_NUMGUARDFRAMES_FOR_FIRST_STAGE_UV = "Training.numGuardFramesForFstageUV";
        public static final String TRAINING_NUMGUARDFRAMES_FOR_SECOND_STAGE_UV = "Training.numGuardFramesForSstageUV";
        public static final String TRAINING_NUMPOSTGUARDFRAMES_FOR_SECOND_STAGE_UDK = "Training.numPostGuardFramesForSstageUDK";
        public static final String TRAINING_NUMPREGUARDFRAMES_FOR_SECOND_STAGE_UDK = "Training.numPreGuardFramesForSstageUDK";
        public static final String TRAINING_PCM_NORMALIZATION = "Training.doPcmNormalization";
    }

    static {
        TAG = TextFieldImplKt.ContainerId;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("Container[name= " + getName() + "]{\n");
        Iterator<Item> r101 = this.mItems.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.append(r101.next().toString());
        r100.append("\n");
        goto L4
    L6:
        r100.append("}\n");
        return r100.toString();
    }

    public Container() {
        this.mContainerName = null;
        this.mItems = new ArrayList();
    }

    public List<Item> getItems() {
        return this.mItems;
    }

    public String getName() {
        return this.mContainerName;
    }

    public Container(String r100) {
        this.mContainerName = null;
        this.mItems = new ArrayList();
        this.mContainerName = r100;
    }

    public Item get(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<Item> r101 = this.mItems.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Item r102 = r101.next();
        if (r102.getName().equalsIgnoreCase(r100) == false) goto L7;
        return r102;
    L11:
        return null;
    }

    public Boolean getBoolean(String r100) {
        Item r101 = get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.getType().equals(Type.BOOLEAN) == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(Boolean.parseBoolean(r101.getValue()));
    }

    public float getFloat(String r100) {
        Item r101 = get(r100);
        if (r101 != null) goto L5;
        return Float.MIN_VALUE;
    L5:
        if (r101.getType().equals(Type.FLOAT) == true) goto L7;
        return Float.MIN_VALUE;
    L7:
        return CastFloatProtector.parseFloat(r101.getValue());
    }

    public int getInt(String r100) {
        Item r101 = get(r100);
        if (r101 != null) goto L5;
        return Integer.MIN_VALUE;
    L5:
        if (r101.getType().equals(Type.INTEGER) == false) goto L14;
        String r102 = r101.getValue().toLowerCase();
        if (r102.startsWith("0x") == false) goto L11;
        return new BigInteger(r102.substring(2), 16).intValue();
    L11:
        return CastIntegerProtector.parseInt(r101.getValue());
    L14:
        return Integer.MIN_VALUE;
    }

    public String getString(String r100) {
        Item r101 = get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.getType().equals(Type.STRING) == true) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    public void put(Item r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Item> r101 = this.mItems.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        Item r102 = r101.next();
        if (r102.getName().equalsIgnoreCase(r100.getName()) == false) goto L6;
        r102.setValue(r100.getValue());
        return;
    L11:
        this.mItems.add(r100);
    }

    public void setName(String r100) {
        this.mContainerName = r100;
    }
}
