package com.ss.android.vesdk;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.vesdk.runtime.TEConfigCenter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VEConfigCenter {
    private static final String TAG = "VEConfigCenter";
    private static boolean enablePreloadSo;
    public static VEABSetType mABSetType;
    private static final Object sByteBenchLock = null;
    private static volatile VEConfigCenter sInstance;
    private boolean mIsEnableByteBench;
    private final Map<String, ValuePkt> sConfigs;
    private final Map<String, ValuePkt> sModifiedConfigs;

    public static final enum ABType extends Enum<ABType> {
        public static final ABType FORCAMERA = null;
        public static final ABType FOREFFECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ABType[] f455530a = null;

        static {
            ABType r100 = new ABType("FOREFFECT", 0);
            FOREFFECT = r100;
            ABType r101 = new ABType("FORCAMERA", 1);
            FORCAMERA = r101;
            f455530a = new ABType[]{r100, r101};
        }

        public static ABType[] values() {
            return (ABType[]) f455530a.clone();
        }

        public static ABType valueOf(String r100) {
            return (ABType) r27.a.a(ABType.class, r100);
        }

        public ABType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ConfigType extends Enum<ConfigType> {
        public static final ConfigType CONFIG_TYPE_AB = null;
        public static final ConfigType CONFIG_TYPE_DEFAULT = null;
        public static final ConfigType CONFIG_TYPE_SETTINGS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ConfigType[] f455531a = null;

        static {
            ConfigType r100 = new ConfigType("CONFIG_TYPE_AB", 0);
            CONFIG_TYPE_AB = r100;
            ConfigType r101 = new ConfigType("CONFIG_TYPE_SETTINGS", 1);
            CONFIG_TYPE_SETTINGS = r101;
            ConfigType r102 = new ConfigType("CONFIG_TYPE_DEFAULT", 2);
            CONFIG_TYPE_DEFAULT = r102;
            f455531a = new ConfigType[]{r100, r101, r102};
        }

        public static ConfigType[] values() {
            return (ConfigType[]) f455531a.clone();
        }

        public static ConfigType valueOf(String r100) {
            return (ConfigType) r27.a.a(ConfigType.class, r100);
        }

        public ConfigType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DataType extends Enum<DataType> {
        private static final /* synthetic */ DataType[] $VALUES = null;
        public static final DataType BOOLEAN = null;
        public static final DataType FLOAT = null;
        public static final DataType INTEGER = null;
        public static final DataType LONG = null;
        public static final DataType STRING = null;

        private static /* synthetic */ DataType[] $values() {
            return new DataType[]{BOOLEAN, INTEGER, LONG, FLOAT, STRING};
        }

        static {
            BOOLEAN = new DataType("BOOLEAN", 0);
            INTEGER = new DataType("INTEGER", 1);
            LONG = new DataType("LONG", 2);
            FLOAT = new DataType("FLOAT", 3);
            STRING = new DataType("STRING", 4);
            $VALUES = $values();
        }

        public static DataType[] values() {
            return (DataType[]) $VALUES.clone();
        }

        public static DataType valueOf(String r100) {
            return (DataType) r27.a.a(DataType.class, r100);
        }

        private DataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class ValuePkt {
        private ABType abType;
        private ConfigType configType;
        private DataType dataType;
        private String description;
        private AtomicBoolean locked;
        private Object value;

        public <T> T getValueAndLock() {
            if (this.locked.get() == true) goto L6;
            this.locked.set(true);
        L6:
            return (T) this.value;
        }

        public String toString() {
            Object r100 = this.value;
            if (r100 != null) goto L7;
            return "";
        L7:
            return r100.toString();
        }

        public ABType getABType() {
            return this.abType;
        }

        public ConfigType getConfigType() {
            return this.configType;
        }

        public DataType getDataType() {
            return this.dataType;
        }

        public <T> T getValue() {
            return (T) this.value;
        }

        public static /* synthetic */ DataType access$000(ValuePkt r100) {
            return r100.dataType;
        }

        public static /* synthetic */ ABType access$100(ValuePkt r100) {
            return r100.abType;
        }

        public static /* synthetic */ Object access$200(ValuePkt r100) {
            return r100.value;
        }

        public static /* synthetic */ String access$300(ValuePkt r100) {
            return r100.description;
        }

        public static /* synthetic */ ConfigType access$400(ValuePkt r100) {
            return r100.configType;
        }

        public void setAbType(ABType r100) {
            this.abType = r100;
        }

        public ValuePkt updateValue(Object r100) {
            if (this.locked.get() == false) goto L6;
            toString();
            return this;
        L6:
            this.value = r100;
            return this;
        }

        public ValuePkt(DataType r100, Object r101, ConfigType r102, String r103) {
            this.locked = new AtomicBoolean(false);
            this.value = r101;
            this.dataType = r100;
            this.configType = r102;
            this.description = r103;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f455532a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f455533b = null;

        static {
            int[] r100 = new int[DataType.values().length];
            f455533b = r100;
            r100[DataType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L31:
            f455533b[DataType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L37:
            f455533b[DataType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L47:
            f455533b[DataType.LONG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L33:
            f455533b[DataType.INTEGER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L12:
            int[] r101 = new int[VEABSetType.values().length];
            f455532a = r101;
            r101[VEABSetType.VEABSetType_MobileUGCv2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L39:
            f455532a[VEABSetType.VEABSetType_MobileUGC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L45:
            f455532a[VEABSetType.VEABSetType_MobileEditor.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L29:
            f455532a[VEABSetType.VEABSetType_MobileEditorv2.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L41:
            f455532a[VEABSetType.VEABSetType_MobileQingYan.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
            return;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public void initByteBench() {
    }

    static {
        mABSetType = VEABSetType.VEABSetType_Default;
        sInstance = null;
        sByteBenchLock = new Object();
        enablePreloadSo = false;
    }

    private void addConfigsFromCamera() {
        JSONArray r100 = new JSONArray();
        int r101 = 0;
        JSONArray r102 = new JSONArray("[{\"key\" : \"ve_camera_type\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"camera type\"},{\"key\": \"ve_is_in_camera2_blocklist\",\"dataType\": 0,\"defaultVal\": true,\"description\": \"is in camera2 blocklist\"},{\"key\": \"ve_camera_wide_angle\",\"dataType\": 1,\"defaultVal\": -1,\"description\": \"wide angle\"},{\"key\": \"ve_camera_stablization\",\"dataType\": 1,\"defaultVal\": -1,\"description\": \"stablization\"},{\"key\": \"ve_camera_fps_range\",\"dataType\": 1,\"defaultVal\": 7,\"description\": \"camera lowest fps\"},{\"key\": \"ve_camera_focus_timeout\",\"dataType\": 1,\"defaultVal\": 2500,\"description\": \"camera focus timeout in ms\"},{\"key\": \"ve_camera_enable_previewing_fallback\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"camera enable previewing fallback\"},{\"key\":\"ve_enable_wide_fov_for_samsung\",\"dataType\":0,\"defaultVal\": false,\"description\": \"enable wide fov\"},{\"key\": \"ve_camera_open_close_sync\",\"dataType\": 0,\"defaultVal\": true,\"description\": \"camera open close sync\"},{\"key\": \"ve_force_close_camera_when_timeout\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"if force close camera when close time out\"},{\"key\": \"frame_rate_strategy\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"frame rate strategy\"},{\"key\": \"is_use_setrecordinghint\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"is use setrecordinghint\"},{\"key\": \"ve_camera_fps_max\",\"dataType\": 1,\"defaultVal\": 30,\"description\": \"camera fps max limit\"},{\"key\": \"ve_enable_open_camera1_optimize\",\"dataType\": 0,\"defaultVal\": true,\"description\": \"enable open camera1 optimize\"},{\"key\": \"ve_enable_open_camera1_crs\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable open camera1 crash\"},{\"key\": \"ve_enable_gc_for_camera_metadata\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"enable manual gc for camera metadata\"},{\"key\": \"ve_camera_scene_diff_fps_opt\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable camera scene diff fps opt\"},{\"key\": \"ve_enable_refactor_camera_focus\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable refactor camera focus\"},{\"key\": \"ve_enable_camera2_zsl_capture\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable camera2 zsl capture\"},{\"key\": \"ve_enable_yuv_buffer_capture_v2\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"enable camera yuv buffer capture\"},{\"key\": \"ve_enable_camera_capture_stream\",\"dataType\": 0,\"defaultVal\": true,\"description\": \"enable take picture via camera capture stream\"},{\"key\": \"ve_enable_camera_devices_cache\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable camera devices cache to optimize SelectCamera\"},{\"key\": \"ve_camera_ai_augmentation\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"ai augmentation\"},{\"key\": \"ve_enable_face_detection\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"enable face detection and strategy\"},{\"key\": \"ve_enable_camera_api2_detect\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable camera api2 detection\"},{\"key\": \"ve_disable_camera_hdr\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"disable camera hdr\"},{\"key\": \"ve_enable_camera_noise_reduce\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable noise reduce for vendor camera\"},{\"key\": \"ve_camera_need_proxy_camera_device\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"whether need to proxy camera device\"},{\"key\": \"ve_support_camera_multicam_zoom\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable camera2 multicam zoom\"},{\"key\": \"ve_camera_zoom_ratio_max\",\"dataType\": 2,\"defaultVal\": -1,\"description\": \"camera2 multicam zoom ratio max value\"},{\"key\": \"ve_camera_zoom_ratio_min\",\"dataType\": 2,\"defaultVal\": -1,\"description\": \"camera2 multicam zoom ratio min value\"},{\"key\": \"ve_enable_camera_preview_template\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"camera session template of video mode\"},{\"key\": \"ve_enable_camera2_deferred_surface\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable deferred surface to createCaptureSession\"},{\"key\": \"ve_enable_camera2_abort_session_capture\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable camera2 abort session capture\"},{\"key\": \"ve_enable_camera2_monitor_gyroscope\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable monitor gyroscope for camera2 focus\"},{\"key\": \"ve_enable_force_close_camera_opt\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"trigger close camera double check\"},{\"key\": \"ve_enable_camera2_session_close\",\"dataType\": 0,\"defaultVal\": true,\"description\": \"enable camera2 session close\"},{\"key\": \"ve_enable_collect_camera_capbilities\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable collect camera capbilities\"},{\"key\": \"ve_enable_camera_switch_camera1_optimize\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"ve enable camera switch camera1 optimize\"},{\"key\": \"ve_camera_capture_hdr\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"enable hdr when use capture mode\"},{\"key\": \"ve_support_dual_camera\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"Whether dual-camera is supported\"},{\"key\": \"ve_dual_camera_expansion_scheme\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"Whether to use dual-camera expansion scheme\"},{\"key\": \"key_camera_capture_mfnr\",\"dataType\": 1,\"defaultVal\": 0,\"description\": \"vendor mfnr algorithm type\"},{\"key\": \"ve_camera_disable_rdhw_record\",\"dataType\": 0,\"defaultVal\": false,\"description\": \"disable huawei record\"}]");     // Catch: Exception -> L8
        int r103 = 0;
    L5:
        if (r103 >= r102.length()) goto L36;
        r100.put(r102.get(r103));     // Catch: Exception -> L8
        r103 = r103 + 1;
    L36:
        JSONArray r104 = new JSONArray(r100.toString());     // Catch: JSONException -> L31
    L12:
        if (r101 >= r104.length()) goto L42;
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r104, r101);     // Catch: JSONException -> L31
        int r106 = JSONObjectProtectorUtils.getInt(r105, "dataType");     // Catch: JSONException -> L31
        String r107 = JSONObjectProtectorUtils.getString(r105, "description");     // Catch: JSONException -> L31
        if (r106 != 0) goto L17;
        boolean r108 = JSONObjectProtectorUtils.getBoolean(r105, "defaultVal");     // Catch: JSONException -> L31
        ValuePkt r109 = new ValuePkt(DataType.BOOLEAN, Boolean.valueOf(r108), ConfigType.CONFIG_TYPE_AB, r107);     // Catch: JSONException -> L31
    L24:
        ValuePkt r110 = r109;
    L28:
        if (r110 == null) goto L30;
        r110.setAbType(ABType.FORCAMERA);     // Catch: JSONException -> L31
        addConfig(JSONObjectProtectorUtils.getString(r105, "key"), r110);     // Catch: JSONException -> L31
    L30:
        r101 = r101 + 1;
        goto L12
    L17:
        if (r106 != 1) goto L19;
        int r111 = JSONObjectProtectorUtils.getInt(r105, "defaultVal");     // Catch: JSONException -> L31
        r109 = new ValuePkt(DataType.INTEGER, Integer.valueOf(r111), ConfigType.CONFIG_TYPE_AB, r107);     // Catch: JSONException -> L31
        goto L24
    L19:
        if (r106 != 2) goto L21;
        float r112 = (float) JSONObjectProtectorUtils.getDouble(r105, "defaultVal");     // Catch: JSONException -> L31
        r109 = new ValuePkt(DataType.FLOAT, Float.valueOf(r112), ConfigType.CONFIG_TYPE_AB, r107);     // Catch: JSONException -> L31
        goto L24
    L21:
        if (r106 == 3) goto L23;
        r110 = null;
        goto L28
    L23:
        String r113 = JSONObjectProtectorUtils.getString(r105, "defaultVal");     // Catch: JSONException -> L31
        r109 = new ValuePkt(DataType.STRING, r113, ConfigType.CONFIG_TYPE_AB, r107);     // Catch: JSONException -> L31
        goto L24
    L42:
        return;
    L31:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }

    public static VEConfigCenter getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(VEConfigCenter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new VEConfigCenter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VEConfigCenter.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void setConfigsDefaultValue() {
        Objects.toString(mABSetType);
        int r100 = a.f455532a[mABSetType.ordinal()];
        if (r100 != 1) goto L5;
        updateValue("ve_enable_titan_audio_graph_refactor", Boolean.TRUE);
        updateValue("ve_enable_readermanager_refactor", Boolean.TRUE);
        return;
    L5:
        if (r100 != 2) goto L7;
        updateValue("ve_enable_titan_audio_graph_refactor", Boolean.TRUE);
        updateValue("ve_enable_readermanager_refactor", Boolean.TRUE);
        updateValue("ve_enable_global_decoder_pool", 1);
        updateValue("ve_enable_audio_seek_async", Boolean.TRUE);
        updateValue("ve_record_audio_speed_opt", Boolean.TRUE);
        updateValue("veabtest_audio_backend_multi_thread_fix", Boolean.TRUE);
        updateValue("veabtest_fix_set_data_source_anr", 119);
        return;
    L7:
        if (r100 != 3) goto L9;
        updateValue("ve_enable_global_decoder_pool", 1);
        updateValue("veabtest_enable_seek_noise_opt", Boolean.TRUE);
        updateValue("veabtest_hook_image_copy", Boolean.TRUE);
        updateValue("ve_enable_image_preload", Boolean.TRUE);
        updateValue("veabtest_get_media_info_optimization", Boolean.TRUE);
        updateValue("veabtest_find_stream_info_optimization", Boolean.TRUE);
        updateValue("ve_enable_preview_size_change_opt1", Boolean.TRUE);
        updateValue("ve_enable_seek_parallel_decode", Boolean.TRUE);
        updateValue("ve_enable_seek_backward_drop_opt", Boolean.TRUE);
        updateValue("EnableImageTextureCache", Boolean.TRUE);
        updateValue("ve_anable_codec2_output_format_align_16", Boolean.TRUE);
        updateValue("ve_gif_decoder_cache", Boolean.TRUE);
        updateValue("ve_enable_encode_operating_rate", 120);
        updateValue("ve_enable_camera_switch_camera1_optimize", Boolean.TRUE);
        updateValue("ve_force_close_camera_when_timeout", Boolean.TRUE);
        updateValue("veabtest_hevc_seek_optimization", Boolean.TRUE);
        updateValue("ve_enable_decoder_schedule_opt_hw", 0);
        updateValue("ve_camera_output_and_update_strategy", 3);
        updateValue("ve_enable_titan_video_decode_opt", Boolean.TRUE);
        updateValue("ve_enable_decoder_dispatch", 2);
        updateValue("ve_enable_compile_hw_encoder_opt", Boolean.TRUE);
        updateValue("ve_enable_hw_decoder_support_rotate", Boolean.TRUE);
        updateValue("ve_enable_amazing_feature_handle_cache", Boolean.TRUE);
        updateValue("ve_enable_lv_audio_graph_refactor", Boolean.TRUE);
        updateValue("ve_enable_backend_dispatch", "{cpu: -1, gpu: -1, duration: 500}");
        updateValue("ve_enable_audio_reader_preload_reuse", Boolean.TRUE);
        updateValue("ve_enable_opt_hwencode_dts", Boolean.TRUE);
        updateValue("ve_camera_fps_range", 15);
        updateValue("ve_enable_forward_ongoingseek_opt", Boolean.TRUE);
        updateValue("use_byte264", Boolean.TRUE);
        updateValue("ve_enable_video_reader_hw_overload_fallback_opt", Boolean.TRUE);
        updateValue("ve_enable_seek_preload_drop_frame", Boolean.TRUE);
        updateValue("ve_titan_follow_shot_independent_thread", Boolean.TRUE);
        updateValue("ve_enable_effect_render_without_glreadpixels", Boolean.TRUE);
        updateValue("enable_android_hdr2sdr_support", Boolean.TRUE);
        updateValue("ve_enable_pip_resolution_opt", Boolean.TRUE);
        updateValue("ve_enable_render_encode_resolution_align4", Boolean.TRUE);
        updateValue("ve_enable_mpeg24vp89_hwdecoder2", Boolean.TRUE);
        updateValue("ve_enable_hwdecode_playback_dropframe_opt", Boolean.TRUE);
        updateValue("ve_small_window_double_thread_decode", Boolean.TRUE);
        updateValue("ve_enable_imageAlgorithmReuseAndOptForAmazing", Boolean.TRUE);
        updateValue("ve_retry_count", 50);
        updateValue("ve_enable_readermanager_refactor", Boolean.TRUE);
        updateValue("ve_titan_release_block_time_real", 0);
        updateValue("ve_enable_recorder_photo_delay_opt", Boolean.TRUE);
        return;
    L9:
        if (r100 != 4) goto L11;
        updateValue("ve_enable_preview_size_change_opt1", Boolean.TRUE);
        updateValue("ve_titan_release_block_time_real", 0);
        updateValue("ve_enable_recorder_photo_delay_opt", Boolean.TRUE);
        updateValue("ve_enable_readermanager_refactor", Boolean.TRUE);
        return;
    L11:
        if (r100 != 5) goto L23;
        updateValue("ve_enable_bytebench", Boolean.TRUE);
        updateValue("ve_enable_titan_audio_graph_refactor", Boolean.TRUE);
        updateValue("ve_titan_gpu_render_opt", Boolean.TRUE);
        updateValue("enable_render_lib", Boolean.TRUE);
        updateValue("crossplat_glbase_fbo", Boolean.TRUE);
        return;
    }

    public void clear() {
        this.sConfigs.clear();
    }

    public String exportRecordToJson() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, ValuePkt>> r101 = this.sConfigs.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L31;
        Map.Entry<String, ValuePkt> r102 = r101.next();
        if (r102.getValue().getABType().equals(ABType.FOREFFECT) == true) goto L4;
        if (r102.getKey().contains("camera") == true) goto L26;
        if (r102.getKey().contains("record") == true) goto L26;
        if (r102.getKey().equals("use_open_gl_three") == true) goto L26;
        if (r102.getKey().equals("frame_rate_strategy") == true) goto L26;
        if (r102.getKey().equals("video_duration_opt") == true) goto L26;
        if (r102.getKey().equals("ve_enable_oes_texture_shot_screen") == true) goto L26;
        if (r102.getKey().equals("ve_enable_wide_fov_for_samsung") == true) goto L26;
        if (r102.getKey().equals("ve_enable_stop_preview_optimize") == true) goto L26;
        if (r102.getKey().equals("ve_enable_refactor_audio") == false) goto L4;
    L26:
        r100.put(r102.getKey(), ValuePkt.access$200(r102.getValue()));     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L31:
        return r100.toString();
    }

    public String exportToJson() {
        JSONArray r100 = new JSONArray();
        Iterator<Map.Entry<String, ValuePkt>> r101 = this.sConfigs.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        Map.Entry<String, ValuePkt> r102 = r101.next();
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L11
        r103.put("key", r102.getKey());     // Catch: JSONException -> L11
        if (r102.getValue() == null) goto L9;
        r103.put("description", ValuePkt.access$300(r102.getValue()));     // Catch: JSONException -> L11
        r103.put("dataType", ValuePkt.access$000(r102.getValue()));     // Catch: JSONException -> L11
        r103.put("value", ValuePkt.access$200(r102.getValue()));     // Catch: JSONException -> L11
        r103.put("configType", ValuePkt.access$400(r102.getValue()));     // Catch: JSONException -> L11
    L9:
        r100.put(r103);     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        String r104 = r102.getKey();
        e.getMessage();
        return "";
    L15:
        return r100.toString();
    }

    private VEConfigCenter() {
        this.mIsEnableByteBench = false;
        this.sConfigs = new HashMap();
        this.sModifiedConfigs = new ConcurrentHashMap();
        initConfigCenter();
    }

    private void addConfigsFromEffect() {
        int r100 = 0;
        String r101 = (String) INVOKESTATIC_com_ss_android_vesdk_VEConfigCenter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bef.effectsdk.EffectABConfig").getDeclaredMethod("requestABInfoWithLicenseArray", new Class[]{String[].class, Boolean.TYPE}).invoke(null, new Object[]{new String[]{"ve_record", "ve_enigma", "ve_edit", "ve_edit|preview", "ve_edit|compile", "ve_mv", "ve_detector", "ve_image"}, Boolean.TRUE});     // Catch: Exception -> L5
    L30:
        JSONArray r102 = new JSONArray(r101);     // Catch: JSONException -> L25
    L9:
        if (r100 >= r102.length()) goto L35;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r102, r100);     // Catch: JSONException -> L25
        int r104 = JSONObjectProtectorUtils.getInt(r103, "dataType");     // Catch: JSONException -> L25
        String r105 = JSONObjectProtectorUtils.getString(r103, "description");     // Catch: JSONException -> L25
        if (r104 == 0) goto L21;
        if (r104 == 1) goto L20;
        if (r104 != 2) goto L16;
        ValuePkt r106 = new ValuePkt(DataType.FLOAT, Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r103, "defaultVal")), ConfigType.CONFIG_TYPE_AB, r105);     // Catch: JSONException -> L25
    L22:
        if (r106 == null) goto L24;
        r106.setAbType(ABType.FOREFFECT);     // Catch: JSONException -> L25
        addConfig(JSONObjectProtectorUtils.getString(r103, "key"), r106);     // Catch: JSONException -> L25
    L24:
        r100 = r100 + 1;
        goto L9
    L16:
        if (r104 == 3) goto L18;
        r106 = null;
        goto L22
    L18:
        r106 = new ValuePkt(DataType.STRING, JSONObjectProtectorUtils.getString(r103, "defaultVal"), ConfigType.CONFIG_TYPE_AB, r105);     // Catch: JSONException -> L25
        goto L22
    L20:
        r106 = new ValuePkt(DataType.INTEGER, Integer.valueOf(JSONObjectProtectorUtils.getInt(r103, "defaultVal")), ConfigType.CONFIG_TYPE_AB, r105);     // Catch: JSONException -> L25
        goto L22
    L21:
        r106 = new ValuePkt(DataType.BOOLEAN, Boolean.valueOf(JSONObjectProtectorUtils.getBoolean(r103, "defaultVal")), ConfigType.CONFIG_TYPE_AB, r105);     // Catch: JSONException -> L25
        goto L22
    L35:
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r101 = "";
        goto L30
    }

    private void emendCoconfig() {
        boolean r100 = getInstance().getValue("veabtest_unbind_agfx_and_glbase_fbo", false).booleanValue();
        boolean r101 = getInstance().getValue("enable_render_lib", false).booleanValue();
        boolean r102 = getInstance().getValue("crossplat_glbase_fbo", false).booleanValue();
        if (r100 == false) goto L7;
        if (r102 == false) goto L7;
        if (r101 == true) goto L7;
        return;
    L7:
        boolean r103 = getInstance().getValue("enable_render_lib", false).booleanValue();
        TEConfigCenter.a("crossplat_glbase_fbo", new ValuePkt(DataType.BOOLEAN, Boolean.valueOf(r103), ConfigType.CONFIG_TYPE_AB, "crossplat_glbase_fbo"));
    }

    public int syncConfigToNative() {
        VELogUtil.i(TAG, "syncConfigToNative...");
        if (getValue("ve_enable_ab_sync_opt", false).booleanValue() == false) goto L5;
        Map<String, ValuePkt> r100 = this.sModifiedConfigs;
    L6:
        VELogUtil.i(TAG, "configMap size = " + this.sConfigs.size() + " modified size = " + this.sModifiedConfigs.size() + " syncmap size = " + r100.size());
        Iterator<Map.Entry<String, ValuePkt>> r101 = r100.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L19;
        Map.Entry<String, ValuePkt> r102 = r101.next();
        if (ValuePkt.access$100(r102.getValue()) == ABType.FOREFFECT) goto L11;
        if (ValuePkt.access$100(r102.getValue()) == ABType.FORCAMERA) goto L8;
        TEConfigCenter.a(r102.getKey(), r102.getValue());
        if (r102.getKey() == "enable_render_lib") goto L18;
        if (r102.getKey() != "crossplat_glbase_fbo") goto L8;
    L18:
        VELogUtil.i(TAG, r102.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + r102.getValue());
        goto L8
    L11:
        updateEffectConfig(r102.getKey(), r102.getValue());
        goto L8
    L19:
        emendCoconfig();
        VELogUtil.i(TAG, "syncConfigToNative...end");
        return 0;
    L5:
        r100 = this.sConfigs;
        goto L6
    }

    private void initConfigCenter() {
        DataType r100 = DataType.STRING;
        ConfigType r101 = ConfigType.CONFIG_TYPE_AB;
        addConfig("wide_camera_id", new ValuePkt(r100, "-1", r101, "wide camera device id"));
        DataType r102 = DataType.BOOLEAN;
        Boolean r103 = Boolean.FALSE;
        addConfig("veabtest_fix_crash_opt", new ValuePkt(r102, r103, r101, "fix some crash"));
        addConfig("veabtest_new_event_trace", new ValuePkt(r102, r103, r101, "add new event trace"));
        addConfig("enable_android_hdr2sdr_support", new ValuePkt(r102, r103, r101, "enable android hdr2sdr support"));
        addConfig("enable_android_hdr_preview_support", new ValuePkt(r102, r103, r101, "enable android hdr preview support"));
        addConfig("veabtest_enable_hdr_flag_supported", new ValuePkt(r102, r103, r101, "lv/cc hdr flag for export"));
        addConfig("enable_android_hw_hdr_compile_support", new ValuePkt(r102, r103, r101, "enable android hw hdr compile support"));
        addConfig("crossplat_glbase_fbo", new ValuePkt(r102, r103, r101, "enable crossplat glbase fbo"));
        addConfig("vboost_compile", new ValuePkt(r102, r103, r101, "enable vboost compile"));
        DataType r104 = DataType.INTEGER;
        addConfig("use_open_gl_three", new ValuePkt(r104, 1, r101, "use GLES3.0"));
        addConfig("vesdk_max_cache_count", new ValuePkt(r104, 0, r101, "config max cache count for input decode frame"));
        addConfig("gpu_syncobject_type", new ValuePkt(r104, 0, ConfigType.CONFIG_TYPE_DEFAULT, "GPU SyncObject type: 0-glFence; 1-eglFence; 2-glFinish"));
        Boolean r105 = Boolean.TRUE;
        addConfig("compile_probe_use_byte264", new ValuePkt(r102, r105, r101, "compile_probe use libbyte264"));
        addConfig("compile_probe_crf", new ValuePkt(r104, -1, r101, "compile probe use crf"));
        addConfig("compile_probe_interval_frame", new ValuePkt(r104, -1, r101, "compile probe interval frame"));
        addConfig("compile_probe_sleep_time", new ValuePkt(r104, -1, r101, "compile probe sleep time"));
        addConfig("use_byte264", new ValuePkt(r102, r103, r101, "use libbyte264"));
        addConfig("aeabtest_v2api", new ValuePkt(r102, r103, r101, "use new audiosdk api"));
        addConfig("color_space", new ValuePkt(r102, r105, r101, "color space"));
        addConfig("vesdk_audiomix_replace", new ValuePkt(r102, r105, r101, "vesdk_audiomix_replace"));
        addConfig("ve_enable_audio_clipping_protection_gain", new ValuePkt(r102, r103, r101, "Enable audio clipping protection gain to replace climiter. Code is in TEAudioComposeUnit. Use case is for video compilation."));
        addConfig("ve_enable_audio_clipping_protection_gain_experiment", new ValuePkt(r102, r103, r101, "Enable audio clipping protection gain experiment. Use case is for video compilation."));
        DataType r110 = DataType.FLOAT;
        addConfig("ve_audio_clipping_protection_gain", new ValuePkt(r110, Float.valueOf(1.0f), r101, "Audio clipping protection gain to replace climiter. The value should be less than 1.0f and greater than 0.f. Code is in TEAudioComposeUnit. Use case is for video compilation."));
        Float r111 = Float.valueOf(0.0f);
        addConfig("ve_compilation_climiter_pre_gain_db", new ValuePkt(r110, r111, r101, "Add a pre-gain for climiter. The value should be in dB unit. Code is in TEAudioComposeUnit. Use case is for video compilation."));
        addConfig("enable_record_mpeg4", new ValuePkt(r102, r103, r101, "enable record mpeg4"));
        addConfig("ve_enable_record_hevc", new ValuePkt(r102, r103, r101, "enable record hevc"));
        addConfig("ve_record_codec_type", new ValuePkt(r104, 0, r101, "record codec type"));
        addConfig("vesdk_audio_hw_encoder", new ValuePkt(r102, r103, r101, "audio hw encoder"));
        Float r112 = Float.valueOf(-1.0f);
        addConfig("ve_recorder_fps_downgrade", new ValuePkt(r110, r112, r101, "Downgrading recorder fps."));
        addConfig("video_duration_opt", new ValuePkt(r102, r103, r101, "video_duration_opt"));
        addConfig("enable_render_lib", new ValuePkt(r102, r103, r101, "vesdk enable render lib"));
        addConfig("renderlib_fbo_opt", new ValuePkt(r102, r103, r101, "vesdk renderlib fbo opt"));
        addConfig("vesdk_use_agfxcontext", new ValuePkt(r102, r103, r101, "vesdk enable agfx ctx"));
        addConfig("ve_use_titan_recorder_engine", new ValuePkt(r102, r103, r101, "use titan recorder engine"));
        addConfig("enable_duet_gl_finish", new ValuePkt(r102, r103, r101, "enable duet glFinish"));
        addConfig("ve_enable_preload_effect_res", new ValuePkt(r102, r103, r101, "enable preload effect res"));
        addConfig("ve_disable_effect_internal_setting", new ValuePkt(r102, r103, r101, "disable effect internal setting"));
        addConfig("ve_enable_titan_auto_test_log", new ValuePkt(r102, r103, r101, "enable titan auto test log"));
        addConfig("ve_opt_first_frame", new ValuePkt(r102, r103, r101, "opt first frame"));
        addConfig("ve_opt_first_frame_bypass_effect_frame_cnt", new ValuePkt(r104, 3, r101, "opt first frame bypass effect frame cnt"));
        addConfig("ve_camera_frame_update_independent_thread", new ValuePkt(r102, r103, r101, "camera frame update independent thread"));
        addConfig("ve_set_camera_two_output", new ValuePkt(r102, r103, r101, "ve set camera two output"));
        addConfig("ve_enable_camera_metadata", new ValuePkt(r102, r103, r101, "enable camera metadata"));
        addConfig("ve_titan_gpu_render_opt", new ValuePkt(r102, r103, r101, "opt titan gpu render follow"));
        addConfig("ve_titan_init_and_start_opt", new ValuePkt(r102, r103, r101, "opt titan init and start follow"));
        addConfig("ve_downscale_render_and_record_origin_content", new ValuePkt(r104, 0, r101, "ve downscale render and record origin content"));
        addConfig("ve_camera_output_and_update_strategy", new ValuePkt(r104, 0, r101, "ve camera output and update strategy"));
        addConfig("ve_enable_three_buffer", new ValuePkt(r102, r103, r101, "enable 3 buffer"));
        addConfig("ve_async_detection", new ValuePkt(r102, r103, r101, "effect async detection"));
        addConfig("ve_retry_count", new ValuePkt(r104, 0, r101, "camera open retry"));
        addConfig("ve_retry_start_preview_count", new ValuePkt(r104, 0, r101, "start preview retry count"));
        addConfig("ve_enable_stop_preview_optimize", new ValuePkt(r102, r103, r101, "stop preview async optimize"));
        addConfig("ve_enable_compile_buffer_hw_encode", new ValuePkt(r102, r103, r101, "Android Hw encode compile "));
        addConfig("ve_enable_render_encode_resolution_align4", new ValuePkt(r102, r103, r101, "render and encode resolution can be align4"));
        addConfig("ve_small_window_double_thread_decode", new ValuePkt(r102, r103, r101, "ve small window double thread decode"));
        ConfigType r113 = ConfigType.CONFIG_TYPE_SETTINGS;
        addConfig("ve_camera_enable_previewing_fallback", new ValuePkt(r102, r103, r113, "camera enable previewing fallback"));
        addConfig("ve_enable_background_strategy", new ValuePkt(r102, r105, r113, "enable background strategy"));
        addConfig("ve_release_mic_timeout", new ValuePkt(r104, 0, r113, "release mic timeout"));
        addConfig("ve_enable_pin_refactor", new ValuePkt(r102, r103, r101, "dmt take pin refactor"));
        addConfig("ve_enable_engine_monitor_report", new ValuePkt(r102, r103, r101, "enable engine monitor report"));
        addConfig("ve_enable_hwdecode_dequeue_inputbuffer_opt", new ValuePkt(r102, r103, r101, "MediaCodec dequeue video inputBuffer opt"));
        addConfig("ve_async_set_sensor_data", new ValuePkt(r102, r103, r101, "Send sensor data to effect asynchronously."));
        addConfig("enable_remux_color_info", new ValuePkt(r102, r105, r101, "enable remux color info"));
        addConfig("remux_video_res", new ValuePkt(r104, -1, r101, "remux video res"));
        addConfig("ve_compile_report", new ValuePkt(r104, 0, r101, "compile report state"));
        addConfig("vesdk_gbu_trace_info", new ValuePkt(r104, 0, r101, "vesdk gbu pipeline trace info"));
        addConfig("ve_enable_compile_timeout_diagnosis", new ValuePkt(r102, r103, r101, "compile timeout diagnosis"));
        addConfig("ve_enable_refactor_audio", new ValuePkt(r102, r103, r101, "enable audio refactor"));
        addConfig("privacy_error_action", new ValuePkt(r104, 2, r101, "privacy_error_action"));
        addConfig("privacy_error_check_interval", new ValuePkt(r104, 1000, r101, "privacy_error_check_interval"));
        addConfig("privacy_error_check_threshold", new ValuePkt(r104, 3000, r101, "privacy_error_check_threshold"));
        addConfig("ve_enable_oes_texture_shot_screen", new ValuePkt(r102, r103, r101, "enable 2d texture shot screen"));
        addConfig("ve_enable_hwdecode_playback_dropframe_opt", new ValuePkt(r102, r103, r101, "hwdecode playback dropframe opt"));
        addConfig("ve_enable_upload_virtual_mem_size", new ValuePkt(r102, r103, r101, "enable upload virtual mem size"));
        addConfig("ve_enable_mpeg24vp89_hwdecoder2", new ValuePkt(r102, r103, r101, "enable mpeg24 vp89 hwdecoder"));
        addConfig("ve_enable_imageAlgorithmReuseAndOptForAmazing", new ValuePkt(r102, r103, r101, "imageAlgorithm Reuse and optForAmazing"));
        addConfig("byteVC1_10bit_hardware_encoder_timeout", new ValuePkt(r104, 10000, r101, "byteVC1 10bit hardware encoder timeout params"));
        addConfig("ve_enable_memory_mode", new ValuePkt(r102, r103, r101, "enable low memory mode"));
        addConfig("ve_low_memory_threshold", new ValuePkt(r104, 300, r101, "low memory mode threshold"));
        addConfig("ve_compile_codec_type", new ValuePkt(r104, 0, r101, "compile support bytevc1 encode"));
        addConfig("ve_compile_hw_bytevc1_max_pixel_count", new ValuePkt(r104, 8294400, r101, "compile bytevc1 max pixel count"));
        addConfig("ve_enable_sys_karaoke", new ValuePkt(r102, r103, r113, "enable sys karaoke"));
        addConfig("ve_enable_common_earback", new ValuePkt(r102, r105, r113, "enable common earback"));
        addConfig("ve_enable_aaduio", new ValuePkt(r102, r105, r113, "enable aaudio"));
        addConfig("ve_enable_pip_resolution_opt", new ValuePkt(r102, r103, r101, "enable pip resolution opt"));
        addConfig("ve_hardware_encode_fallback", new ValuePkt(r104, 0, r101, "config for hardware encode fallback to soft, DO NOT set NON-ZERO ON LINE"));
        addConfig("ve_asf_amount", new ValuePkt(r110, r112, r101, "ve_asf_amount"));
        addConfig("ve_asf_over_ratio", new ValuePkt(r110, r112, r101, "ve_asf_over_ratio"));
        addConfig("ve_asf_gpu_power_level", new ValuePkt(r104, 4, r101, "ve_asf_gpu_power_level"));
        addConfig("ve_asf_init_delay_frame_cnt", new ValuePkt(r104, 0, r101, "ve_asf_init_delay_frame_cnt"));
        addConfig("ve_asf_process_delay_frame_cnt", new ValuePkt(r104, 0, r101, "ve_asf_process_delay_frame_cnt"));
        addConfig("ve_duet_audio_delay_mt_opt", new ValuePkt(r110, r111, r101, "Duet audio delay mt optimize. 0 is no opt."));
        addConfig("ve_enable_optimize_audio_delay", new ValuePkt(r104, 0, r101, "opt audio delay when stop record"));
        addConfig("ve_enable_vboost", new ValuePkt(r102, r103, r101, "opt performance when open/close camera and stop record"));
        addConfig("ve_vboost_timeout", new ValuePkt(r104, 500, r113, "VBoost timeout"));
        addConfig("ve_enable_effect_render_without_glreadpixels", new ValuePkt(r102, r103, r101, "enable effect render without glreadpixels"));
        addConfig("ve_enable_global_decoder_pool", new ValuePkt(r104, 0, r101, "enable global decoder pool"));
        addConfig("ve_enable_decoder_dispatch", new ValuePkt(r104, 0, r101, "enable global dispatch for decoder tasks"));
        addConfig("ve_enable_decoder_dispatch2", new ValuePkt(r104, 0, r101, "enable global dispatch "));
        addConfig("ve_disable_ffmpeg_command", new ValuePkt(r102, r103, r101, "ve_disable_ffmpeg_command "));
        addConfig("ve_enable_decoder_schedule_opt_hw", new ValuePkt(r104, 0, r101, "enable decoder schedule for hw"));
        addConfig("ve_enable_fix_seek_last_frame", new ValuePkt(r102, r105, r101, "fix seek no last frame"));
        addConfig("ve_enable_first_reader_preload", new ValuePkt(r102, r103, r101, "first frame reader preload"));
        addConfig("ve_enable_first_reader_preload_preview", new ValuePkt(r102, r103, r101, "first frame reader preload for preview"));
        addConfig("ve_enable_readermanager_refactor", new ValuePkt(r102, r103, r101, "description tevideoreader manager refactor"));
        addConfig("ve_enable_readermanager_global", new ValuePkt(r102, r103, r101, "description tevideoreader manager global"));
        addConfig("ve_enable_video_frame_cache", new ValuePkt(r104, 0, r101, "andorid support video frame cache"));
        addConfig("ve_enable_schdule_device_capability_opt", new ValuePkt(r104, 0, r101, "description enable  device monitor opt"));
        addConfig("ve_enable_schdule_preload", new ValuePkt(r104, 0, r101, "ve_enable_schdule_preload"));
        addConfig("ve_hwdecode_support_rt_and_or", new ValuePkt(r102, r103, r101, "hw decode support real-time and operating-rate"));
        addConfig("ve_camera_enable_preview_fake_frame", new ValuePkt(r102, r103, r101, "ve camera enable preview fake frame"));
        addConfig("ve_camera_enable_preview_fake_frame_gaussian_blur", new ValuePkt(r102, r103, r101, "ve camera enable preview fake frame gaussian_blur"));
        addConfig("ve_camera_enable_preview_pure_color_background", new ValuePkt(r102, r103, r101, "ve_camera_enable_preview_pure_color_background"));
        addConfig("ve_camera_preview_pure_color_background_rgba", new ValuePkt(r104, 0, r101, "ve_camera_preview_pure_color_background_rgba"));
        addConfig("ve_mediacodec_resource_reasonable_distribute", new ValuePkt(r102, r103, r101, "mediacodec resource reasonable distribute"));
        addConfig("ve_aec_sample_rate_opt", new ValuePkt(r102, r103, r101, "aec sample rate opt"));
        addConfig("vesdk_ffmpeg_enable_video_timestamp_monotonic", new ValuePkt(r102, r103, r101, "enable ffmpeg video timestamp monotonic"));
        addConfig("ve_titan_release_block_time_real", new ValuePkt(r104, -1, r101, "Titan release block time"));
        addConfig("ve_shotscreen_delay_max_frame", new ValuePkt(r104, 20, r113, "shotscreen delay max frame"));
        addConfig("ve_shotscreen_delay_threshold", new ValuePkt(r104, 10, r113, "shotscreen delay light frame num threshold"));
        addConfig("ve_enable_audio_reader_preload_reuse", new ValuePkt(r102, r103, r101, "support audioReader preload and reuse"));
        addConfig("ve_enable_veimage_optimize_quality", new ValuePkt(r102, r103, r101, "VEImage enable optimize quality"));
        addConfig("ve_titan_follow_shot_independent_thread", new ValuePkt(r102, r103, r101, "follow shot independent thread."));
        addConfig("ve_titan_cross_plat_recorder_graph", new ValuePkt(r102, r103, r101, "enable cross platform recorder graph for titan."));
        addConfig("ve_enable_seek_preload_drop_frame", new ValuePkt(r102, r103, r101, "seek and preload drop frame"));
        addConfig("ve_enable_amazing_feature_handle_cache", new ValuePkt(r102, r103, r101, "amazing feature handle cache"));
        addConfig("ve_enable_image_preload", new ValuePkt(r102, r103, r101, "enable image preload when display"));
        addConfig("ve_ban_hw_extra_data_loop", new ValuePkt(r102, r103, r101, "Ban mediacodec sps/pps loop & some opt"));
        addConfig("ve_titan_max_count_of_render_frame_buffer", new ValuePkt(r104, 30, r101, "Set max count of titan`s frame buffer cache"));
        addConfig("ve_enable_amazing_feature_handle_preload", new ValuePkt(r102, r103, r101, "amazing feature handle preload"));
        addConfig("ve_enable_titan_audio_graph_refactor", new ValuePkt(r102, r103, r101, "enable titan audio graph refactor."));
        addConfig("ve_enable_bgm_mic_delay_opt", new ValuePkt(r102, r103, r101, "enable bgm mic delay opt"));
        addConfig("ve_enable_luma_detect_ec", new ValuePkt(r102, r103, r101, "enable luma detect ec"));
        addConfig("ve_enable_luma_detect", new ValuePkt(r102, r105, r101, "enable luma detect"));
        addConfig("ve_luma_detect_ec_exe_rate", new ValuePkt(r104, 15, r101, "luma detect ec execute rate"));
        addConfig("ve_titan_release_gpu_resource", new ValuePkt(r102, r103, r101, "titan release gpu resource."));
        addConfig("ve_enable_recorder_native_api", new ValuePkt(r102, r103, r101, "enable recorder native api"));
        addConfig("ve_anable_codec2_output_format_align_16", new ValuePkt(r102, r103, r101, "enable mediacodec output format align 16"));
        addConfig("ve_enable_titan_engine_monitor", new ValuePkt(r102, r103, r113, "enable titan engine monitor"));
        addConfig("vesdk_use_bytevcremux_in_publish", new ValuePkt(r102, r103, r101, "enable bytevc1 remux"));
        addConfig("ve_enable_forward_ongoingseek_opt", new ValuePkt(r102, r103, r101, "enable forward ongoingseek opt"));
        addConfig("ve_enable_video_reader_hw_overload_fallback_opt", new ValuePkt(r102, r103, r101, "enable video reader hw_overload fallback opt"));
        addConfig("enable_lens_smart_adjust", new ValuePkt(r102, r105, r101, "enable lens smart adjust"));
        addConfig("enable_lens_edit_async_process", new ValuePkt(r102, r103, r101, "enable lens async process"));
        addConfig("enable_lens_edit_params", new ValuePkt(r100, "", r101, "enable_lens_edit_params"));
        addConfig("ve_effect_memory_config", new ValuePkt(r100, "", r101, "effect memory info config"));
        addConfig("EnableImageTextureCache", new ValuePkt(r102, r103, r101, "EnableImageTextureCache"));
        addConfig("enable_frame_texture_cache", new ValuePkt(r104, 0, r101, "enable_frame_texture_cache"));
        addConfig("EnableImageTextureCacheForMultiTrack", new ValuePkt(r102, r103, r101, "EnableImageTextureCacheForMultiTrack"));
        addConfig("ve_enable_adaptive_encode_level", new ValuePkt(r102, r103, r101, "enable adaptive encode level"));
        addConfig("ve_enable_limit_min_encode_fps", new ValuePkt(r102, r105, r101, "enable limit min encode fps"));
        addConfig("ve_encoder_qp_range", new ValuePkt(r100, "", r101, "encoder qp range"));
        addConfig("ve_encoder_qp_range_for_recorder", new ValuePkt(r100, "", r101, "encoder qp range for recorder"));
        addConfig("ve_encoder_b_frame", new ValuePkt(r100, "", r101, "encoder b frame"));
        addConfig("veabtest_hdr_effect_optimization", new ValuePkt(r102, r103, r101, "description hdr video effect optimization, hdr2sdr effect sdr2hdr"));
        addConfig("ve_encoder_initial_qp", new ValuePkt(r100, "", r101, "encoder initial qp"));
        addConfig("ve_compile_remux_bitrate_json", new ValuePkt(r100, "", r101, "compile remux bitrate json"));
        addConfig("veabtest_remuxerror_fix_1280", new ValuePkt(r102, r105, r101, "veabtest remuxerror fix 1280"));
        addConfig("ve_enable_hw_decoder_support_rotate", new ValuePkt(r102, r103, r101, "enable hw decoder support rotate"));
        addConfig("ve_enable_uri_convert_android_q", new ValuePkt(r102, r105, r101, "enable uri convert android q"));
        addConfig("ve_enable_uri_convert_android_q_cache", new ValuePkt(r102, r105, r101, "enable uri convert android q cache"));
        addConfig("ve_titan_thread_pool_opt", new ValuePkt(r104, 0, r101, "enable titan thread pool opt."));
        addConfig("ve_compile_gl_fence_ab", new ValuePkt(r104, 0, r101, "compile glfence, 0 - glfinish; 1 - glfence & wait on server; 2 - glfence & wait on client"));
        addConfig("veabtest_enablePreviewQualityOpt", new ValuePkt(r102, r103, r101, "enable preview quality opt"));
        addConfig("veabtest_enableUpSamplingOpt", new ValuePkt(r102, r103, r101, "enable upsampling opt"));
        addConfig("veabtest_enableDownSamplingOpt", new ValuePkt(r102, r103, r101, "enable udownsampling render screen opt"));
        addConfig("veabtest_enableGradientCanvasOpt", new ValuePkt(r102, r103, r101, "enable gradient canvas opt"));
        addConfig("veabtest_enableCrossplatCanvasOpt", new ValuePkt(r102, r103, r101, "enable crossplat canvas opt"));
        addConfig("veabtest_enableCrossplatCanvasDownscaleOpt", new ValuePkt(r102, r103, r101, "enable crossplat canvas downscale opt"));
        addConfig("ve_enable_compile_hw_encoder_opt", new ValuePkt(r102, r103, r101, "enable hw compile encoder optimization"));
        addConfig("ve_onekey_cv_detect_frame", new ValuePkt(r104, 3, r101, "cv detect frame"));
        addConfig("ve_onekey_process_all_algo_params", new ValuePkt(r100, "", r101, "lens onekey all algo params"));
        addConfig("ve_onekey_detect_denoise_result", new ValuePkt(r104, -1, r101, "the detect result of denoise"));
        addConfig("ve_onekey_detect_scene_case_result", new ValuePkt(r104, -1, r101, "the detect result of scene case"));
        addConfig("ve_audio_source_type", new ValuePkt(r104, 1, r101, "set recorder audio source type"));
        addConfig("ve_enable_lv_audio_graph_refactor", new ValuePkt(r102, r103, r101, "enable lv audio graph refactor"));
        addConfig("ve_enable_odd_display", new ValuePkt(r104, 0, r101, "ve enable odd display"));
        addConfig("ve_enable_img_downsample_calculate_opt", new ValuePkt(r102, r103, r101, "ve enable img downsample calculate opt"));
        addConfig("ve_enable_sys_image_decoder", new ValuePkt(r102, r103, r101, "ve enable sys image decoder"));
        addConfig("ve_enable_recorder_veperformance", new ValuePkt(r104, 0, r101, "ve_enable_recorder_veperformance"));
        addConfig("ve_enable_editor_veperformance_android", new ValuePkt(r104, 0, r101, "ve_enable_editor_veperformance_android"));
        addConfig("ve_enable_fastlanczos_edit_display", new ValuePkt(r102, r103, r101, "ve enable fastlanczos edit display"));
        addConfig("ve_enable_bytebench", new ValuePkt(r102, r105, r101, "ve enable get result from bytebench"));
        addConfig("ve_enable_model_hot_update", new ValuePkt(r102, r103, r101, "enable model hot update"));
        addConfig("ve_compile_hide_ve_metadata", new ValuePkt(r102, r103, r101, "hide ve metadata"));
        addConfig("ve_enable_part_remux", new ValuePkt(r102, r103, r101, "enable part remux optimization"));
        addConfig("ve_enable_seek_parallel_decode", new ValuePkt(r102, r103, r101, "ve enable seek parallel decode"));
        addConfig("ve_enable_seek_backward_drop_opt", new ValuePkt(r102, r103, r101, "ve enable seek backward opt"));
        addConfig("ve_enable_veimage_gl_nearst", new ValuePkt(r104, 0, r101, "ve enable veimage gl nearst"));
        addConfig("ve_enable_veimage_lanczos_resample", new ValuePkt(r104, 0, r101, "ve enable veimage lanczos resample"));
        addConfig("ve_enable_veimage_publish_dp", new ValuePkt(r102, r103, r101, "ve enable veimage publish dp"));
        addConfig("ve_enable_veimage_smart_composition", new ValuePkt(r102, r103, r101, "ve enable veimage smart composition"));
        addConfig("ve_enable_veimage_smart_composition_lens_para", new ValuePkt(r100, "", r101, "ve enable veimage smart composition lens para"));
        addConfig("ve_enable_veimage_render_cache", new ValuePkt(r102, r105, r101, "ve enable veimage render cache"));
        addConfig("ve_enable_veimage_open_contrast", new ValuePkt(r102, r105, r101, "ve enable veimage open contrast"));
        addConfig("ve_enable_matting_optimize", new ValuePkt(r104, 0, r101, "ve enable matting optimize"));
        addConfig("ve_enable_veimage_compress_quality", new ValuePkt(r104, 100, r101, "ve nable veimage compress quality"));
        addConfig("ve_enable_fix_ve_image_event_track", new ValuePkt(r102, r105, r101, "ve enable fix ve image event track"));
        addConfig("ve_enable_android_webp_encode_opt", new ValuePkt(r102, r103, r101, "ve enable webp encode optimization"));
        addConfig("ve_enable_matting_use_hw", new ValuePkt(r104, 0, r101, "ve enable matting use hw"));
        addConfig("ve_enable_backend_dispatch", new ValuePkt(r100, "", r101, "ve_enable_backend_dispatch"));
        addConfig("ve_enable_matting_backend", new ValuePkt(r102, r103, r101, "ve_enable_matting_backend"));
        addConfig("ve_kernel_enable_new_thread_model", new ValuePkt(r102, r103, r101, "ve kernel: use the new thread model."));
        addConfig("ve_kernel_enable_new_thread_model_for_edit_compile", new ValuePkt(r102, r103, r101, "ve kernel: use the new thread model for edit and compile."));
        addConfig("ve_kernel_enable_config_new_thread_model_by_ab", new ValuePkt(r102, r103, r101, "ve kernel: use ab to config new thread model."));
        addConfig("ve_kernel_max_num_of_core_workers_in_new_thread_model", new ValuePkt(r104, 10, r101, "ve kernel: the max number of core workers in new thread model."));
        addConfig("ve_kernel_max_num_of_works_for_core_worker_in_new_thread_model", new ValuePkt(r104, 10, r101, "ve kernel: the max number of works for core worker in new thread model."));
        addConfig("ve_kernel_new_thread_model_thread_bound_name", new ValuePkt(r102, r103, r101, "ve kernel new thread model use thread bound name."));
        addConfig("ve_enable_high_gif_optimize", new ValuePkt(r104, 0, r101, "ve_enable_high_gif_optimize"));
        addConfig("ve_enable_global_preload", new ValuePkt(r104, 0, r101, "ve_enable_global_preload"));
        addConfig("ve_titan_hw_dec_res_min_side", new ValuePkt(r104, -1, r101, "If titan decode video`s min side >= this size will use hardware decoder"));
        addConfig("ve_enable_titan_multi_speed_opt", new ValuePkt(r102, r103, r101, "ve enable titan multi speed opt"));
        addConfig("ve_enable_aaudio_mic_record", new ValuePkt(r102, r103, r101, "enable aaudio mic recording"));
        addConfig("ve_enable_audio_track_play", new ValuePkt(r102, r103, r101, "enable audio track fallback solution"));
        addConfig("ve_enable_audio_track_adjustment", new ValuePkt(r104, 0, r101, "enable audio track av sync adjustment"));
        addConfig("ve_max_supported_effect_video_players", new ValuePkt(r104, 2, r101, "maximum video players supported in VideoPlayerInterface"));
        addConfig("ve_enable_aaudio_unit", new ValuePkt(r102, r103, r101, "enable audio rendering using aaudio in the editor"));
        addConfig("ve_enable_aaudio_for_audio_track", new ValuePkt(r102, r103, r101, "enable audio rendering using aaudio in the recorder instead of audiotrack"));
        addConfig("ve_enable_aaudio_for_opensl", new ValuePkt(r102, r103, r101, "enable audio rendering using aaudio in the recorder instead of opensl"));
        addConfig("ve_override_recorder_buffer_size", new ValuePkt(r104, 0, r101, "buffer size for recorder audio playback"));
        addConfig("ve_override_recorder_sample_count", new ValuePkt(r104, 0, r101, "audio organize samples count for recorder audio playback"));
        addConfig("ve_enable_always_on_audio_stream", new ValuePkt(r102, r103, r101, "send silence in place of stopping audio stream for recorder audio playback"));
        addConfig("ve_report_frequency", new ValuePkt(r104, 3, r101, "ve report frequency"));
        addConfig("ve_enable_titan_nv21_buffer_render_chain", new ValuePkt(r102, r103, r101, "enable titan nv21 buffer render chain"));
        addConfig("ve_enable_titan_opt_lanczos_screen", new ValuePkt(r102, r103, r101, "ve enable titan opt lanczos for screen"));
        addConfig("ve_content_adaptive_coding_mode", new ValuePkt(r104, -1, r101, "ve set content adaptive coding mode"));
        addConfig("ve_ffmpeg_codec_mem_reuse", new ValuePkt(r102, r103, r101, "ve use ffmpeg codec buffer pool in bytevc1 decode"));
        addConfig("ve_camera_prop_cache", new ValuePkt(r102, r103, r101, "read camera prop in cache for next use"));
        addConfig("ve_camera_preload_effect_algo", new ValuePkt(r102, r103, r101, "ve camera preload effect algo"));
        addConfig("ve_shot_screen_two_frame_opt", new ValuePkt(r104, 0, r101, "shot screen two frame opt"));
        addConfig("ve_titan_camera_cpu_opt", new ValuePkt(r102, r103, r101, "opt TECameraServer thread cpu"));
        addConfig("ve_recorder_encode_gop_size", new ValuePkt(r104, 0, r101, "override recorder encode gop size"));
        addConfig("ve_editor_first_frame_with_surface_opt", new ValuePkt(r102, r103, r101, "draw first frame when surface is ready"));
        addConfig("veabtest_compile_async_pipeline_processor", new ValuePkt(r102, r103, r101, "compile use async pipeline processor"));
        addConfig("ve_titan_init_thread_pool_opt", new ValuePkt(r102, r103, r101, "opt opengl create message in initthreadpool"));
        addConfig("veabtest_compile_hash_opt", new ValuePkt(r102, r103, r101, "compile hash opt"));
        addConfig("ve_titan_shot_screen_opt", new ValuePkt(r104, 0, r101, "shoot screen use bitmap but except shoot two frame"));
        addConfig("ve_effect_segment_and_filter_reuse", new ValuePkt(r102, r103, r101, "reuse effect segment and filter process"));
        addConfig("ve_enable_nth_preview_frame_callback", new ValuePkt(r104, -1, r101, "Enable the N-th preview frame callback"));
        addConfig("ve_applog_opt", new ValuePkt(r102, r103, r101, "applog opt"));
        addConfig("veabtest_applog_only_report_bussiness", new ValuePkt(r102, r103, r101, "enable report business only"));
        addConfig("ve_fix_mediacodec_decode_runloop", new ValuePkt(r102, r103, r101, "fix mediacodec decode runloop"));
        addConfig("ve_image_texture_size_opt", new ValuePkt(r104, 0, r101, "opt image size when decode"));
        addConfig("ve_fix_blend_only_texture", new ValuePkt(r102, r103, r101, "fix blend only texture"));
        addConfig("ve_editor_texture_opt", new ValuePkt(r102, r103, r101, "editor texture opt"));
        addConfig("ve_fix_canvas_clear", new ValuePkt(r102, r103, r101, "fix canvas clear"));
        addConfig("ve_editor_template_stat", new ValuePkt(r102, r103, r101, "editor template stat"));
        addConfig("ve_editor_video_anim_opt", new ValuePkt(r104, 0, r101, "opt video anim mem"));
        addConfig("ve_editor_video_anim_cache", new ValuePkt(r104, 0, r101, "opt video anim cache and fps"));
        addConfig("ve_editor_gbu_size_opt", new ValuePkt(r104, 0, r101, "opt editor gbu size"));
        addConfig("ve_editor_debug_canvas_red", new ValuePkt(r102, r103, r101, "render canvas with red color"));
        addConfig("ve_editor_debug_log", new ValuePkt(r102, r103, r101, "open ve debug log"));
        addConfig("ve_editor_get_display_image_size_opt", new ValuePkt(r102, r103, r101, "getDisplayImage size opt"));
        addConfig("ve_editor_texture_opt_two", new ValuePkt(r102, r103, r101, "editor texture opt two"));
        addConfig("veabtest_reuse_diff_size_texture", new ValuePkt(r102, r103, r101, "reuse texture with different size (resolution) in verenderer, android only"));
        addConfig("veabtest_mediacodec_fix_powervr", new ValuePkt(r102, r103, r101, "fix mtk driver bugs in mediacodec api, android only"));
        addConfig("veabtest_gles_render_experiment", new ValuePkt(r104, 0, r101, "used for gles driver debugging while some bugs unable to be reproduced locally, android only"));
        addConfig("veabtest_destroy_gl_context_with_mutex", new ValuePkt(r102, r103, r101, "use mutex to avoid parallel glcontext destroy, android only"));
        addConfig("veabtest_unbind_agfx_and_glbase_fbo", new ValuePkt(r102, r103, r101, "unbind agfx and glbase fbo ab, used for cc experiment only"));
        addConfig("veabtest_reuse_diff_size_texture_del_and_new", new ValuePkt(r104, 0, r101, "reuse texture with different size by delete-new, android cc only"));
        addConfig("ve_enable_camera_fps_double_check_in_image_mode", new ValuePkt(r102, r105, r101, "ve enable camera fps double check in image mode"));
        addConfig("ve_enable_encode_operating_rate", new ValuePkt(r104, 0, r101, "ve enable encode operating rate"));
        addConfig("ve_encode_support_operating_rate", new ValuePkt(r100, "", r101, "ve encode support operating rate"));
        addConfig("ve_decode_support_operating_rate", new ValuePkt(r100, "", r101, "ve decode support operating rate"));
        addConfig("ve_enable_record_encode_operating_rate", new ValuePkt(r104, 0, r101, "ve enable record encode operating rate"));
        addConfig("ve_enable_set_preview_surface_priority", new ValuePkt(r102, r103, r101, "ve enable set preview surface priority"));
        addConfig("ve_enable_editor_fake_frame_aspect", new ValuePkt(r102, r103, r101, "ve enable editor fake frame aspect"));
        addConfig("ve_enable_fix_detach_wav_format", new ValuePkt(r102, r105, r101, "ve enable fix detach wav format for detachAudioFromVideos"));
        addConfig("ve_enable_pass_effect_when_no_effect_filter", new ValuePkt(r102, r103, r101, "ve enable pass effect when no effect filter"));
        addConfig("ve_encode_color_space_bt601", new ValuePkt(r102, r103, r101, "ve encode color space bt601"));
        addConfig("ve_smartcodec_video_json_setting", new ValuePkt(r100, "", r101, "ve smartcodec video json setting"));
        addConfig("ve_crop_encode_operating_rate", new ValuePkt(r104, 0, r101, "ve crop encode operating rate"));
        addConfig("ve_enanle_titan_audio_decode_time_opt", new ValuePkt(r102, r103, r101, "ve enable titan audio decode time opt"));
        addConfig("ve_enable_recorder_bitratio_calibrate", new ValuePkt(r102, r103, r101, "ve enable recorder bitratio calibrate"));
        addConfig("ve_enable_encode_buffer_operating_rate", new ValuePkt(r102, r105, r101, "ve enable encode buffer operating rate"));
        addConfig("ve_enable_opt_hwdecode_moire", new ValuePkt(r102, r103, r101, "ve enable opt hw decode moire"));
        addConfig("ve_enable_recorder_effect_texture_pool", new ValuePkt(r102, r103, r101, "enable recorder effect bin texture pool"));
        addConfig("ve_enable_first_frame_opt_public", new ValuePkt(r102, r103, r101, "ve enable first frame opt of public api"));
        addConfig("ve_enable_opt_hwencode_dts", new ValuePkt(r102, r103, r101, "ve enable opt hw encode dts"));
        addConfig("ve_enable_preview_size_change_opt1", new ValuePkt(r102, r103, r101, "ve enable preview size change optimize solution 1"));
        addConfig("ve_gif_decoder_cache", new ValuePkt(r102, r103, r101, "ve gif decoder cache"));
        addConfig("ve_enable_titan_video_decode_opt", new ValuePkt(r102, r103, r101, "ve titan video decode opt"));
        addConfig("veabtest_enableFeaturePcmf32", new ValuePkt(r102, r103, r101, "ve set audio pipeline pcm format f32"));
        addConfig("ve_enable_export_pip_opt", new ValuePkt(r102, r103, r101, "ve enable export pip opt"));
        addConfig("veabtest_enableFeatureAudioEncodeSetCutOff", new ValuePkt(r102, r103, r101, "enable audio encode set cutoff 18k"));
        addConfig("veabtest_opt_canvas_by_check_filter", new ValuePkt(r102, r103, r101, "ve enable canvas by check filter"));
        addConfig("ve_enable_compile_param_dump", new ValuePkt(r102, r103, r101, "ve enable compile config dump"));
        addConfig("veabtest_enable_seek_noise_opt", new ValuePkt(r102, r103, r101, "enable seek noise opt"));
        addConfig("veabtest_enable_effect_super_resolution", new ValuePkt(r102, r103, r101, "enable effect super resolution"));
        addConfig("veabtest_enable_unifygraphstate", new ValuePkt(r102, r105, r101, "ve enable unify graph state"));
        addConfig("ve_enable_titan_audio_chain_reader_init", new ValuePkt(r102, r103, r101, "ve enable titan audio chain reader init"));
        addConfig("veabtest_hevc_seek_optimization", new ValuePkt(r102, r103, r101, "ve hevc seek optimization"));
        addConfig("veabtest_aboffline_performance", new ValuePkt(r102, r103, r101, "ve enable the AB offline key for performance"));
        addConfig("veabtest_aboffline_jy_android", new ValuePkt(r102, r103, r101, "ve enable the LV Android AB offline key for performance"));
        addConfig("ve_enable_cache_file_info_opt", new ValuePkt(r102, r103, r101, "ve enable cache file info opt"));
        addConfig("ve_enable_operating_rate_support_2k4k", new ValuePkt(r102, r103, r101, "ve enable operating rate support 2k4k"));
        addConfig("ve_enable_titan_multitrack_decode", new ValuePkt(r102, r103, r101, "ve enable multitrack decode"));
        addConfig("ve_enable_titan_sw_encode", new ValuePkt(r102, r103, r101, "ve enable sw encode"));
        addConfig("veabtest_enable_titan_async_stop", new ValuePkt(r102, r103, r101, "ve titan enable async stop"));
        addConfig("veabtest_enable_effect_output_tex_cache_opt", new ValuePkt(r102, r103, r101, "enable effectSDK output texture 3 buffer"));
        addConfig("veabtest_enable_follow_shot_gl_crash_fix", new ValuePkt(r102, r105, r101, "enable follow shot gl crash fix"));
        addConfig("veabtest_decode_av_sync", new ValuePkt(r102, r103, r101, "ve decode av sync"));
        addConfig("ve_enable_crossplat_logic_unify", new ValuePkt(r102, r105, r101, "ve enable crossplat logic unify"));
        addConfig("veabtest_get_media_info_optimization", new ValuePkt(r102, r103, r101, "ve enable get media info optimization"));
        addConfig("veabtest_find_stream_info_optimization", new ValuePkt(r102, r103, r101, "ve enable find stream info optimization"));
        addConfig("veabtest_media_mime_type_opt", new ValuePkt(r102, r103, r101, "ve enable get media mime type opt"));
        addConfig("ve_enable_recorder_encode_glcontext_reuse", new ValuePkt(r102, r105, r101, "ve enable recorder encode glcontext reuse"));
        addConfig("veabtest_enbale_readerunit_merge_fps_pts", new ValuePkt(r102, r103, r101, "ve enable merge byfps and bypts"));
        addConfig("ve_enable_realtime_camext_bin", new ValuePkt(r102, r105, r101, "ve enable realtime camext bin"));
        addConfig("ve_enable_error_code_opt", new ValuePkt(r102, r103, r101, "ve enable error code opt"));
        addConfig("ve_unify_new_compile_strategy", new ValuePkt(r102, r103, r101, "ve unify new compile strategy"));
        addConfig("ve_enable_result_opt", new ValuePkt(r102, r105, r101, "ve enable result opt"));
        addConfig("ve_enable_hw_decoder_use_surfacetexture_matrix", new ValuePkt(r102, r103, r101, "description hw decoder use surfacetexture matrix"));
        addConfig("veabtest_fixAudioDriveEOS", new ValuePkt(r102, r103, r101, "veabtest_fixAudioDriveEOS"));
        addConfig("veabtest_hook_image_copy", new ValuePkt(r102, r103, r101, "ve enable hook android::ImageCopy to fix crash on SM7325"));
        addConfig("ve_enable_resize_image_optimize", new ValuePkt(r102, r103, r101, "ve enable use libyuv::ARGBScale to scale rgba image"));
        addConfig("veabtest_enable_editor_matting", new ValuePkt(r102, r103, r101, "ve_enable_editor_matting"));
        addConfig("veabtest_matting_async_count", new ValuePkt(r104, 0, r101, "TEBachMattingProcessUnit async matting thread count"));
        addConfig("veabtest_matting_complete_segment", new ValuePkt(r102, r103, r101, "matting complete segment"));
        addConfig("ve_enable_algorithm_cache", new ValuePkt(r102, r103, r101, "ve enable algorithm pre cache"));
        addConfig("ve_update_rich_text_opt", new ValuePkt(r102, r103, r101, "ve update rich text api opt"));
        addConfig("veabtest_opt_alg_las_opt", new ValuePkt(r102, r103, r101, "optimaize lvs algorithm"));
        addConfig("ve_enable_commit_opt", new ValuePkt(r102, r103, r101, "ve enable commit opt"));
        addConfig("ve_enable_transition_opt", new ValuePkt(r102, r103, r101, "ve enable transition opt"));
        addConfig("ve_enable_track_effect", new ValuePkt(r102, r103, r101, "ve enable track effect"));
        addConfig("ve_enable_effects_atomic", new ValuePkt(r102, r103, r101, "ve enable effectsatomic"));
        addConfig("ve_enable_swing_clear_texture", new ValuePkt(r102, r105, r101, "ve_enable_swing_clear_texture"));
        addConfig("veabtest_report_predict_compile_file_info", new ValuePkt(r102, r103, r101, "veabtest_report_predict_compile_file_info"));
        addConfig("ve_enable_sw_encode_process_opt", new ValuePkt(r102, r103, r101, "ve_enable_editor_sw_encode_opt"));
        addConfig("veabtest_fix_anr_of_audio_player", new ValuePkt(r102, r103, r101, "fix anr of release engine"));
        addConfig("ve_enable_change_surface_opt", new ValuePkt(r102, r103, r101, "enable change surface optimize"));
        addConfig("veabtest_enbale_refresh_display_frame_opt", new ValuePkt(r102, r103, r101, "veabtest_enbale_refresh_display_frame_opt"));
        addConfig("ve_enable_seek_with_speed", new ValuePkt(r102, r103, r101, "ve_enable_seek_with_speed"));
        addConfig("ve_enable_hms_qr_scan", new ValuePkt(r102, r103, r101, "enable change hms qrcode scan"));
        addConfig("ve_enable_hms_scan_types", new ValuePkt(r104, 1, r101, "set hms scan types"));
        addConfig("ve_enable_hms_scan_zoom", new ValuePkt(r104, 5, r101, "enable hms scan zoom & reset max count"));
        addConfig("ve_enable_refresh_opt", new ValuePkt(r102, r103, r101, "ve refresh opt"));
        addConfig("veabtest_enable_switch_sticker", new ValuePkt(r102, r103, r101, "veabtest_enable_switch_sticker"));
        addConfig("veabtest_fix_large_audio_sample_anr", new ValuePkt(r102, r105, r101, "fix large audio sample anr"));
        addConfig("veabtest_audio_gbu_refactor_1", new ValuePkt(r102, r103, r101, "audio gbu refactor 1"));
        addConfig("veabtest_adjust_audio_effect_order", new ValuePkt(r102, r103, r101, "apply audio effect in the specified order"));
        addConfig("veabtest_optimizeAudioDelayOpt", new ValuePkt(r102, r103, r101, "veabtest_optimizeAudioDelayOpt"));
        addConfig("veabtest_export_audio_quality_opt", new ValuePkt(r102, r103, r101, "enable audio quality option when export"));
        addConfig("veabtest_RemoveUnusedCanvasHandler", new ValuePkt(r102, r103, r101, "veabtest_RemoveUnusedCanvasHandler"));
        addConfig("ve_enable_effect_delay_init", new ValuePkt(r102, r103, r101, "enable effect delay init"));
        addConfig("ve_enable_record_effect_lazy_loading", new ValuePkt(r102, r103, r101, "record effect lazy loading"));
        addConfig("veabtest_asyncCopyAndConcat", new ValuePkt(r102, r103, r101, "veabtest_asyncCopyAndConcat"));
        addConfig("ve_enable_recorder_simply_project", new ValuePkt(r102, r103, r101, "Recorder simply project switch"));
        addConfig("ve_hwencode_detect_duration", new ValuePkt(r104, 0, r101, "ve hwencode detect duration"));
        addConfig("ve_enable_sync_withorigin_frame", new ValuePkt(r102, r103, r101, "ve enable sync with origin preview frame"));
        addConfig("ve_distinguish_camera_type_for_rdhw", new ValuePkt(r102, r103, r101, "ve distinguish camera type for RDHW"));
        addConfig("ve_enable_record_hw_decode", new ValuePkt(r104, 0, r101, "ve enable record hw decode"));
        addConfig("veabtest_enable_audio_skip_samples_opt", new ValuePkt(r102, r103, r101, "enable audio skip_samples opt"));
        addConfig("ve_enable_camera_first_frame_opt", new ValuePkt(r102, r103, r101, "ve enable camera first frame display opt"));
        addConfig("ve_enable_recorder_photo_delay_opt", new ValuePkt(r102, r103, r101, "ve enable recorder photo delay opt"));
        addConfig("veabtest_enable_imagereader_refactor", new ValuePkt(r102, r103, r101, "ve enable imagereader refactor"));
        addConfig("ve_clip_effect_bin_filter_time_interval_bugfix", new ValuePkt(r102, r103, r101, "ve_clip_effect_bin_filter_time_interval_bugfix"));
        addConfig("veabtest_compile_progress_update_json", new ValuePkt(r100, "", r101, "veabtest_compile_progress_update_json"));
        addConfig("ve_enable_titan_audio_thread_opt", new ValuePkt(r102, r103, r101, "ve_enable_titan_audio_thread_opt"));
        addConfig("ve_enable_titan_gl_thread_delay", new ValuePkt(r102, r103, r101, "ve_enable_titan_gl_thread_delay_init"));
        addConfig("ve_titan_gl_thread_delay_level", new ValuePkt(r104, 7, r101, "ve_titan_gl_thread_delay_level"));
        addConfig("ve_titan_gl_thread_delay_frame", new ValuePkt(r104, 2, r101, "ve_titan_gl_thread_delay_frame"));
        addConfig("ve_titan_audio_thread_use_poolV2", new ValuePkt(r102, r103, r101, "ve_titan_audio_thread_use_poolV2"));
        addConfig("ve_titan_release_hold_thread", new ValuePkt(r102, r103, r101, "ve_titan_release_hold_thread"));
        addConfig("ve_titan_release_hold_level", new ValuePkt(r104, 133, r101, "ve_titan_release_hold_level"));
        addConfig("ve_kernel_memory_opt", new ValuePkt(r104, 0, r101, "ve_kernel_memory_opt"));
        addConfig("ve_titan_stop_release_opt", new ValuePkt(r102, r103, r101, "ve_titan_stop_release_opt"));
        addConfig("ve_titan_release_context_resource", new ValuePkt(r102, r103, r101, "ve_titan_release_context_resource"));
        addConfig("ve_enable_audioencode_cap_merge", new ValuePkt(r102, r103, r101, "ve enable audioencode cap merge"));
        addConfig("ve_titan_audio_opt", new ValuePkt(r102, r103, r101, "ve titan audio opt"));
        addConfig("ve_shared_egl_context_for_camera_texture_to_editor", new ValuePkt(r102, r103, r101, "ve_shared_egl_context_for_camera_texture_to_editor"));
        addConfig("ve_enable_ab_sync_opt", new ValuePkt(r102, r103, r101, "ve enable ab sync opt"));
        addConfig("ve_eanble_protect_track_context", new ValuePkt(r102, r103, r101, "ve_eanble_protect_track_context"));
        addConfig("ve_skip_lens_watermark_process", new ValuePkt(r102, r103, r101, "ve_skip_lens_watermark_process"));
        addConfig("ve_lens_invisible_watermark_opt", new ValuePkt(r104, 0, r101, "lens invisible watermark opt strategy"));
        addConfig("veabtest_enable_imagereader_refactor", new ValuePkt(r102, r103, r101, "ve enable imagereader refactor"));
        addConfig("ve_enable_record_canvas_size_opt", new ValuePkt(r102, r103, r101, "ve enable record canvas size opt"));
        addConfig("ve_sub_seq_opt", new ValuePkt(r102, r103, r101, "opt subsequence performance"));
        addConfig("ve_streaming_edit_undertake", new ValuePkt(r104, 1, r101, "ve streaming edit undertake"));
        addConfig("veabtest_heif_decode_by_libttheif", new ValuePkt(r102, r103, r101, "decode heif/heic use libttHeif"));
        addConfig("ve_enable_stream_edit_cache_bugfix", new ValuePkt(r102, r103, r101, "ve_enable_stream_edit_cache_bugfix"));
        addConfig("veabtest_force_render_effect_filter", new ValuePkt(r102, r103, r101, "veabtest_force_render_effect_filter"));
        addConfig("veabtest_enable_recover_composer_after_effect_ready", new ValuePkt(r102, r103, r101, "veabtest_enable_recover_composer_after_effect_ready"));
        addConfig("veabtest_disenable_recover_composer", new ValuePkt(r102, r103, r101, "veabtest_disenable_recover_composer"));
        addConfig("ve_enable_record_effect_filter_opt", new ValuePkt(r102, r103, r101, "ve_enable_record_effect_filter_opt"));
        addConfig("veabtest_audioBalancedGain", new ValuePkt(r102, r103, r101, "enable audio bgm balanced gain"));
        addConfig("ve_enable_image_decode_sharpness_opt", new ValuePkt(r102, r103, r101, "ve_enable_image_decode_sharpness_opt"));
        addConfig("ve_opensles_player_destroy_timeout_ms", new ValuePkt(r104, 0, r101, "ve_editor_open_sles_player_destroy_timeout_ms"));
        addConfig("veabtest_enable_jpeg_multi_thread_decode", new ValuePkt(r102, r103, r101, "ve enable jpeg multi-thread decode"));
        addConfig("veabtest_limit_android_os_version_for_powervr_gl_bugfix", new ValuePkt(r102, r103, r101, "trying to fix gl crash by limit some gl logic in vesdk"));
        addConfig("ve_enable_repair_decode_chain", new ValuePkt(r102, r103, r101, "ve enable repair decode chain"));
        addConfig("ve_enable_transform_unit_refactor", new ValuePkt(r102, r103, r101, "ve enable transform unit refactor"));
        addConfig("veabtest_jpeg_multi_thread_decode_count", new ValuePkt(r104, 0, r101, "ve jpeg multi-thread decode count"));
        addConfig("ve_enable_opt_avsyncunit_crash", new ValuePkt(r102, r105, r101, "fix avsyncunit crash"));
        addConfig("ve_enable_video_hw_native_encode", new ValuePkt(r102, r103, r101, "ve enable video hw native encode"));
        addConfig("veabtest_enable_android_png_decode_opt", new ValuePkt(r102, r103, r101, "enable android png decode optimization"));
        addConfig("veabtest_enable_android_jpg_decode_opt", new ValuePkt(r102, r103, r101, "enable android jpg decode optimization"));
        addConfig("veabtest_enable_compilation_refactor", new ValuePkt(r102, r103, r101, "ve enable compilation module refactor"));
        addConfig("veabtest_enable_bytevc1sw_upgrade", new ValuePkt(r102, r103, r101, "ve enable bytevc1 sw encoder upgrade"));
        addConfig("ve_camera_enable_surface_sharing", new ValuePkt(r102, r103, r101, "ve camera enable surface sharing"));
        addConfig("ve_enable_yuv_buffer_capture_block", new ValuePkt(r102, r103, r101, "camera2 capture yuv block list"));
        addConfig("ve_enable_yuv_buffer_capture_compat_mode", new ValuePkt(r102, r103, r101, "camera2 capture yuv compat mode"));
        addConfig("ve_preset_effect_opt", new ValuePkt(r102, r103, r101, "ve preset effect opt"));
        addConfig("ve_enable_get_mediainfo_timeout", new ValuePkt(r104, -1, r101, "ve_enable_get_mediainfo_timeout"));
        addConfig("ve_enable_risky_video_detection", new ValuePkt(r102, r103, r101, "enable risky video detection"));
        addConfig("veabtest_opt_darSize", new ValuePkt(r102, r103, r101, "enable opt get video size"));
        addConfig("ve_enable_enigma_optimization", new ValuePkt(r104, 0, r101, "enable enigma optimization"));
        addConfig("ve_enable_scan_optimization", new ValuePkt(r102, r103, r101, "enable scan optimization"));
        addConfig("ve_enable_global_render_resource", new ValuePkt(r104, 0, r101, "enable global render resource"));
        addConfig("ve_enable_swing_simplify", new ValuePkt(r102, r103, r101, "enable swing simplify"));
        addConfig("ve_enable_fix_photo_rotate_resolution", new ValuePkt(r102, r103, r101, "enable fix photo rotate resolution"));
        addConfig("ve_enable_copy_watermark_json", new ValuePkt(r102, r103, r101, "enable copy watermark json"));
        addConfig("veabtest_optAudioDuration", new ValuePkt(r102, r103, r101, "enable opt audio duration"));
        addConfig("ve_enable_rec_pixel_copy_strategy", new ValuePkt(r104, 0, r101, "enable recorder shot screen pixel copy strategy."));
        addConfig("veabtest_enable_infini_single_handle", new ValuePkt(r102, r103, r101, "infini single handle for hot update"));
        addConfig("veabtest_optimizeEditorMemory", new ValuePkt(r102, r103, r101, "opt editor memory"));
        addConfig("ve_enable_opt_get_images", new ValuePkt(r102, r103, r101, "ve enable opt get images"));
        addConfig("veabtest_delayInitStickerHandler", new ValuePkt(r102, r103, r101, "delay init sticker handler"));
        addConfig("veabtest_delayInitEffectHandler", new ValuePkt(r102, r103, r101, "delay init effect handler"));
        addConfig("veabtest_delayInitCanvasHandler", new ValuePkt(r102, r103, r101, "delay init canvas handler"));
        addConfig("veabtest_removeSendMsgDefaultParam", new ValuePkt(r102, r105, r101, "remove send msg default param"));
        addConfig("veabtest_enable_fix_AVSyncUnit2_stack_overflow", new ValuePkt(r102, r103, r101, "enable fix AVSyncUnit2 stack overflow"));
        addConfig("ve_enable_audio_play_refactor", new ValuePkt(r102, r103, r101, "veabtest_enable_audio_play_refactor"));
        addConfig("enable_unify_effect", new ValuePkt(r102, r103, r101, "enable_unify_effect"));
        addConfig("enable_unify_effect_frame_cache", new ValuePkt(r102, r105, r101, "enable_unify_effect_frame_cache"));
        addConfig("enable_video_first_frame_opt", new ValuePkt(r102, r103, r101, "enable_video_first_frame_opt"));
        addConfig("ve_audio_thread_priority", new ValuePkt(r104, 0, r101, "set audio thread priority"));
        addConfig("ve_blur_frame_when_switching_camera", new ValuePkt(r104, 0, r101, "ve_blur_frame_when_switching_camera"));
        addConfig("ve_enable_flash_getFrame_optimization", new ValuePkt(r102, r103, r101, "enable flash getFrame optimization"));
        addConfig("ve_record_audio_opt_v2", new ValuePkt(r102, r103, r101, "enable record audio opt v2"));
        addConfig("ve_record_audio_opt_v3", new ValuePkt(r102, r103, r101, "enable record audio opt v3"));
        addConfig("ve_record_audio_speed_opt", new ValuePkt(r102, r103, r101, "enable record audio speed opt"));
        addConfig("ve_enable_use_image_allocator", new ValuePkt(r102, r103, r101, "enable use image allocator"));
        addConfig("ve_enable_max_imagetexture_buffer_count", new ValuePkt(r104, 10, r101, "max imagetexture buffer count"));
        addConfig("ve_enable_max_free_imagetexture_buffer_count", new ValuePkt(r104, 10, r101, "max free imagetexture buffer count"));
        addConfig("ve_enable_renderlib_fix", new ValuePkt(r102, r105, r101, "ve enable renderlib fix"));
        addConfig("ve_enable_renderlib_fix_crash", new ValuePkt(r102, r105, r101, "ve enable renderlib fix crash"));
        addConfig("veabtest_fix_use_effect_in_filter_process_unit", new ValuePkt(r102, r103, r101, "fix useEffect in TEFilterProcessUnit"));
        addConfig("veabtest_cache_camera_manager", new ValuePkt(r102, r103, r101, "cache camera manager"));
        addConfig("enable_effect_segment_reuse_and_preload", new ValuePkt(r104, 0, r101, "enable_effect_segment_reuse_and_preload"));
        addConfig("enable_render_node_cache", new ValuePkt(r102, r103, r101, "enable_render_node_cache"));
        addConfig("enable_fix_crash_multi_clip_effect_bin", new ValuePkt(r102, r105, r101, "enable_fix_crash_multi_clip_effect_bin"));
        addConfig("veabtest_cache_frame_need_effect", new ValuePkt(r102, r103, r101, "first cached camera frame need effect"));
        addConfig("ve_enable_post_pending_task_that_require_gl_env", new ValuePkt(r102, r103, r101, "ve_enable_post_pending_task_that_require_gl_env"));
        addConfig("veabtest_core_fb_cache_anr_opt", new ValuePkt(r102, r103, r101, "veabtest_core_fb_cache_anr_opt"));
        addConfig("veabtest_clearFboCacheWhenUpdateTimeline", new ValuePkt(r102, r103, r101, "Clear FBO cache when update graph timeline to optimize memory"));
        addConfig("veabtest_safe_render_cache_when_multi_thread", new ValuePkt(r102, r103, r101, "veabtest_safe_render_cache_when_multi_thread"));
        addConfig("veabtest_enableLoopDecode", new ValuePkt(r102, r103, r101, "enable decode loop for template"));
        addConfig("ve_enable_recorder_disable_audio_capture_low_latency", new ValuePkt(r102, r103, r101, "disable recorder audio capture low latency"));
        addConfig("ve_recorder_mic_thread_priority", new ValuePkt(r104, 0, r101, "mic thread priority"));
        addConfig("ve_enable_cache_cpumodel", new ValuePkt(r102, r103, r101, "enable cache cpumodel"));
        addConfig("ve_enable_report_business", new ValuePkt(r102, r103, r101, "veabtest_enable_report_business"));
        addConfig("veabtest_enableMattingUnit2MultiAlgorithm", new ValuePkt(r102, r103, r101, "veabtest_enableMattingUnit2MultiAlgorithm"));
        addConfig("veabtest_quick_result_for_single_stream_capture", new ValuePkt(r102, r103, r101, "enable quick result for single stream capture"));
        addConfig("ve_media_info_pool_size", new ValuePkt(r104, 0, r101, "ve media info pool size"));
        addConfig("ve_enable_eis_ois_hw", new ValuePkt(r102, r103, r101, "veabtest_enable_eis_ois_hw"));
        addConfig("ve_camera_stabilization_mode", new ValuePkt(r104, -1, r101, "ve_camera_stabilization_mode"));
        addConfig("ve_enable_media_info_cache_key_opt", new ValuePkt(r102, r103, r101, "ve enable media info cache key opt"));
        addConfig("veabtest_remux_callback_opt", new ValuePkt(r102, r103, r101, "remux callback opt"));
        addConfig("ve_enable_effect_process_async_v2", new ValuePkt(r102, r103, r101, "Effect process async v2"));
        addConfig("ve_enable_effect_process_async_v2_encode_high_priority", new ValuePkt(r102, r103, r101, "Effect process async v2 encode high priority"));
        addConfig("ve_effect_process_async_v2_cache_size", new ValuePkt(r104, 3, r101, "Effect process async v2 cache size"));
        addConfig("ve_enable_audio_seek_async", new ValuePkt(r102, r103, r101, "audio seek async"));
        addConfig("veabtest_remux_callback_opt_cache_size", new ValuePkt(r104, -1, r101, "remux callback opt cache size"));
        addConfig("veabtest_remux_callback_opt_cache_max_size", new ValuePkt(r104, -1, r101, "remux callback opt cache max size"));
        addConfig("ve_check_audio_file_opt", new ValuePkt(r104, 0, r101, "check audio file opt"));
        addConfig("veabtest_fixCropAccuracy", new ValuePkt(r102, r103, r101, "fix crop accuracy to avoid useless crop"));
        addConfig("veabtest_glPassthroughOpt", new ValuePkt(r102, r103, r101, "enable passthrough opt"));
        addConfig("veabtest_transition_preload_opt", new ValuePkt(r102, r103, r101, "transition preload optimize"));
        addConfig("veabtest_transition_preload_time", new ValuePkt(r104, 1, r101, "transition preload time"));
        addConfig("veabtest_clearFboCacheWhenUpdateTimeline", new ValuePkt(r102, r103, r101, "veabtest_clearFboCacheWhenUpdateTimeline"));
        addConfig("ve_enable_camera2_zsl_capture_v2", new ValuePkt(r102, r103, r101, "ve enable camera2 zsl v2"));
        addConfig("ve_enable_camera2_single_picture_stream", new ValuePkt(r102, r103, r101, "ve enable camera2 single picture stream for preview & shot"));
        addConfig("ve_camera_zsl_strategy_focus_timeout", new ValuePkt(r104, 300, r101, "ve camera zsl strategy focus timeout."));
        addConfig("ve_dump_frame_frags", new ValuePkt(r104, 0, r101, "ve dump frame flags."));
        addConfig("ve_dump_frame_save_dir", new ValuePkt(r100, "", r101, "ve dump frame save dir."));
        addConfig("ve_enable_camera1_zsl_capture", new ValuePkt(r102, r103, r101, "ve enable camera1 zsl"));
        addConfig("ve_support_camera1_zsl", new ValuePkt(r102, r103, r101, "Support camera1 zsl flag"));
        addConfig("ve_support_camera2_zsl", new ValuePkt(r102, r103, r101, "Support camera2 zsl flag"));
        addConfig("ve_support_camera2_zsl_v2", new ValuePkt(r102, r103, r101, "Support camera2 zsl v2 flag"));
        addConfig("ve_enable_record_get_frame_mem_opt", new ValuePkt(r102, r103, r101, "Recorder get frame memory opt"));
        addConfig("enable_effect_segment_reuse_and_preload", new ValuePkt(r104, 0, r101, "enable_effect_segment_reuse_and_preload"));
        addConfig("enable_render_node_cache", new ValuePkt(r102, r103, r101, "enable_render_node_cache"));
        addConfig("enable_gl_source_bin_discard_useless_frame", new ValuePkt(r102, r103, r101, "enable_gl_source_bin_discard_useless_frame"));
        addConfig("ve_media_info_pool_size", new ValuePkt(r104, 0, r101, "ve media info pool size"));
        addConfig("ve_enable_stop_cam_repeating_before_capture", new ValuePkt(r102, r103, r101, "enable stop camera repeating before capture"));
        addConfig("ve_fix_get_picture_size", new ValuePkt(r102, r103, r101, "fix image mode get picture size return wrong value"));
        addConfig("veabtest_fix_common_algo_with_matting_msg", new ValuePkt(r102, r105, r101, "fix common algorithm with matting msg"));
        addConfig("veabtest_high_freq_render_flush", new ValuePkt(r104, 0, r101, "veabtest_high_freq_render_flush"));
        addConfig("ve_enable_render_without_avsync_when_no_audio_clips", new ValuePkt(r102, r103, r101, "enable render without avsync to fix low fps"));
        addConfig("veabtest_timeline_with_nle_model", new ValuePkt(r102, r103, r101, "veabtest_timeline_with_nle_model"));
        addConfig("veabtest_delay_report_camera_capacity", new ValuePkt(r102, r103, r101, "delay report camera capacity for bytebench"));
        addConfig("veabtest_delay_init_gyro", new ValuePkt(r102, r103, r101, "delay init gyro until focus at point when touch screen"));
        addConfig("ve_fix_get_frame", new ValuePkt(r102, r103, r101, "ve_fix_get_frame"));
        addConfig("enable_fix_crash_vebach_image_result", new ValuePkt(r102, r105, r101, "enable_fix_crash_vebach_image_result"));
        addConfig("veabtest_fix_recover_composer_when_width_height_changed", new ValuePkt(r102, r103, r101, "fix recover composer invalid when width height changed"));
        addConfig("veabtest_saveEffectSegmentRealTime", new ValuePkt(r102, r103, r101, "veabtest_saveEffectSegmentRealTime"));
        addConfig("veabtest_optimizeAdvanceEdit", new ValuePkt(r102, r103, r101, "opt advance edit abilities"));
        addConfig("EnableMultiThreadDecode", new ValuePkt(r102, r103, r101, "EnableMultiThreadDecode"));
        addConfig("ve_seek_precision_opt", new ValuePkt(r102, r103, r101, "seek precision opt"));
        addConfig("EnableSeekOpt", new ValuePkt(r102, r103, r101, "enable seek opt"));
        addConfig("veabtest_common_resource_finder_setter", new ValuePkt(r102, r103, r101, "enable setting ep common resource finder"));
        addConfig("veabtest_enable_nlemodel_optimize", new ValuePkt(r102, r103, r101, "NLEModel optimization, change NLE property container from map to vector"));
        addConfig("veabtest_video_animation_uses_effect_segment", new ValuePkt(r102, r103, r101, "veabtest_video_animation_uses_effect_segment"));
        addConfig("veabtest_fix_composer_filter_invalid", new ValuePkt(r102, r103, r101, "fix composer filter invalid"));
        addConfig("veabtest_enable_effect_reuse", new ValuePkt(r102, r103, r101, "enable effect reuse"));
        addConfig("veabtest_forceBeautyRunAlgorithm", new ValuePkt(r102, r103, r101, "Force run algorithm for beauty composer."));
        addConfig("veabtest_forceDisableGenderAlgorithm", new ValuePkt(r102, r103, r101, "Force Disable Effect Gender Detect Algorithm"));
        addConfig("veabtest_segment_bugfix_for_same_track_id", new ValuePkt(r102, r105, r101, "veabtest_segment_bugfix_for_same_track_id"));
        addConfig("veabtest_lazy_and_preload_effect_segment", new ValuePkt(r104, 0, r101, "veabtest_lazy_and_preload_effect_segment"));
        addConfig("ve_enable_record_oes22d_ahardwarebuffer", new ValuePkt(r102, r103, r101, "Enable OES to 2D AHardwareBuffer for Record"));
        addConfig("veabtest_mvp_renderer_use_amg_wrap_mode", new ValuePkt(r102, r103, r101, "veabtest_mvp_renderer_use_amg_wrap_mode"));
        addConfig("ve_enable_fix_read_audio_sample", new ValuePkt(r102, r103, r101, "ve_enable_fix_read_audio_sample"));
        addConfig("ve_enable_render_frame_mem_opt", new ValuePkt(r102, r103, r101, "Enable render frame api memory optimize"));
        addConfig("ve_enable_render_frame_effect_opt", new ValuePkt(r102, r103, r101, "Enable render frame api effect input ratio optimize"));
        addConfig("ve_enable_render_frame_async_fix", new ValuePkt(r102, r103, r101, "Enable render frame async fix"));
        addConfig("ve_enable_cam_close_anr_opt", new ValuePkt(r104, 0, r101, "Enable close camera ANR optimize"));
        addConfig("ve_enable_compile_image_with_origin", new ValuePkt(r102, r103, r101, "Enable compile image with decode origin frame"));
        addConfig("ve_vq_score_omni_opt_flags", new ValuePkt(r104, 0, r101, "vq_score_omni opt flags"));
        addConfig("ve_kernel_framebuffercache_lru_fix", new ValuePkt(r102, r103, r101, "framebuffercache lru fix"));
        addConfig("ve_kernel_framebuffercache_clear_by_threshold", new ValuePkt(r102, r103, r101, "framebuffercache add clear threshold"));
        addConfig("ve_kernel_framebuffercache_threshold_value", new ValuePkt(r104, Integer.valueOf(HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE), r101, "framebuffercache threshold value"));
        addConfig("ve_kernel_framebuffercache_clear_time", new ValuePkt(r104, 20000, r101, "framebuffercache clear time"));
        addConfig("veabtest_fixMainTrackUpdate", new ValuePkt(r102, r105, r101, "fix maintrack update"));
        addConfig("ve_enable_2d_engine_time_refactor", new ValuePkt(r102, r105, r101, "enable 2d engine time refactor"));
        addConfig("veabtest_AvoidStoppingWhenCanvasRatioChanges", new ValuePkt(r102, r103, r101, "veabtest_AvoidStoppingWhenCanvasRatioChanges"));
        addConfig("veabtest_EnablePipelineSizeOptInTransformUnit", new ValuePkt(r102, r103, r101, "veabtest_EnablePipelineSizeOptInTransformUnit"));
        addConfig("veabtest_fixNleDeleteClipProblem", new ValuePkt(r102, r105, r101, "Fix display problem if pause editor and delete the last video clip."));
        addConfig("veabtest_fix_filter_remove_fail", new ValuePkt(r102, r105, r101, "fix filter remove fail when maintrack updat"));
        addConfig("veabtest_decode_nontarget_stream_discard", new ValuePkt(r102, r103, r101, "decode nontarget stream discard"));
        addConfig("enable_effect_super_resolution_edit", new ValuePkt(r102, r103, r101, "enable effect super resolution in editor scene"));
        addConfig("veabtest_editor_effect_to_segment", new ValuePkt(r102, r103, r101, "switch editor effect to segment interface"));
        addConfig("veabtest_vrsr_unit_config", new ValuePkt(r100, "", r101, "vrsr unit config"));
        addConfig("ve_heif_enc_preset_index", new ValuePkt(r104, 0, r101, "heif enc preset"));
        addConfig("veabtest_fix_set_data_source_anr", new ValuePkt(r104, 0, r101, "fix set data source anr"));
        addConfig("veabtest_refactoreEffectSegment", new ValuePkt(r102, r103, r101, "Refactor effect segment"));
        addConfig("ve_enable_force_sw_decode", new ValuePkt(r102, r103, r101, "ve enable force sw decode"));
        addConfig("veabtest_enable_AutoTestStablizeMemoryUsage", new ValuePkt(r102, r103, r101, "reduce probability of unstable memory usage for auto test to improve accuracy of memory test"));
        addConfig("ve_enable_template_memory_degradation", new ValuePkt(r102, r103, r101, "ve_enable_template_memory_degradation"));
        addConfig("ve_template_cpu_memory_degradation_size", new ValuePkt(r104, 0, r101, "ve_template_cpu_memory_degradation_size"));
        addConfig("ve_template_gpu_memory_degradation_size", new ValuePkt(r104, 0, r101, "ve_template_gpu_memory_degradation_size"));
        addConfig("veabtest_native_opt_for_saliency_matting", new ValuePkt(r102, r103, r101, "veabtest_native_opt_for_saliency_matting"));
        addConfig("veabtest_MaxVideoReaderCount", new ValuePkt(r104, 8, r101, "veabtest_MaxVideoReaderCount"));
        addConfig("veabtest_uninit_effect_on_demand", new ValuePkt(r104, 0, r101, "veabtest_uninit_effect_on_demand"));
        addConfig("veabtest_hot_function_opt", new ValuePkt(r104, 0, r101, "veabtest_hot_function_opt"));
        addConfig("veabtest_autoSetResourceDuration", new ValuePkt(r102, r103, r101, "Auto set resource file duration for NLETrackSlot."));
        addConfig("ve_enable_multi_shotScreen", new ValuePkt(r102, r103, r101, "ve enable multi shotScreen"));
        addConfig("veabtest_fix_recordSpeedReset", new ValuePkt(r102, r105, r101, "fix speed reset when stop record"));
        addConfig("veabtest_dynamic_canvas_resolution", new ValuePkt(r102, r103, r101, "support dynamic canvas resolution"));
        addConfig("veabtest_enable_nle_api_property", new ValuePkt(r102, r103, r101, "enable new property for nle api"));
        addConfig("veabtest_force_algorithm_clip_changed", new ValuePkt(r102, r103, r101, "force algorithm when clip changed"));
        addConfig("veabtest_opt_stutter_rate_value", new ValuePkt(r102, r103, r101, "opt stutter rate value"));
        addConfig("ve_fix_multi_shotScreen_black", new ValuePkt(r102, r105, r101, "ve fix multi shotScreen black"));
        addConfig("veabtest_enableInfoStickerSegmentRiskyCode", new ValuePkt(r102, r105, r101, "Enable some risky code for info sticker segment"));
        addConfig("veabtest_enableBrushSegment", new ValuePkt(r102, r103, r101, "Use effect segment protocol to implement brush"));
        addConfig("veabtest_backend_support_skip_audio", new ValuePkt(r102, r105, r101, "skip recording audio for AI effect"));
        addConfig("veabtest_preload_effect_resource_opt", new ValuePkt(r102, r103, r101, "veabtest_preload_effect_resource_opt"));
        addConfig("veabtest_audio_allocator_mem_reuse", new ValuePkt(r102, r103, r101, "veabtest_audio_allocator_mem_reuse"));
        addConfig("veabtest_support_dolby_vision_mux", new ValuePkt(r102, r103, r101, "support dolby vision mux"));
        addConfig("veabtest_audio_backend_multi_thread_fix", new ValuePkt(r102, r103, r101, "veabtest_audio_backend_multi_thread_fix"));
        addConfig("veabtest_preset_preprocess_flow_opt", new ValuePkt(r102, r103, r101, "veabtest_preset_preprocess_flow_opt"));
        addConfig("veabtest_nle_message_async_callback", new ValuePkt(r102, r103, r101, "veabtest_nle_message_async_callback"));
        addConfig("veabtest_nle_main_func_with_lock", new ValuePkt(r102, r103, r101, "veabtest_nle_main_func_with_lock"));
        addConfig("veabtest_enable_ongoing_seek_opt", new ValuePkt(r102, r103, r101, "enable ongoing seek opt"));
        addConfig("veabtest_fixRefreshInvalid", new ValuePkt(r104, 0, r101, "veabtest_fixRefreshInvalid"));
        addConfig("veabtest_infoStickerSegmentPreloadType", new ValuePkt(r104, 0, r101, "veabtest_infoStickerSegmentPreloadType"));
        addConfigsFromEffect();
        addConfigsFromCamera();
        initByteBench();
    }

    public Map<String, ValuePkt> getConfigs() {
        return this.sConfigs;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_vesdk_VEConfigCenter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private int importFromJson(String r100) {
        new JSONArray(r100).toString();     // Catch: JSONException -> L4
        this.sConfigs.clear();     // Catch: JSONException -> L4
        return 0;
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static void setEnablePreloadSo(boolean r100) {
        enablePreloadSo = r100;
    }

    public ValuePkt getValue(String r100) {
        ValuePkt r101 = this.sConfigs.get(r100);
        if (((Boolean) this.sConfigs.get("ve_enable_bytebench").getValue()).booleanValue() == false) goto L5;
        t1.a.a().getClass();
    L5:
        return r101;
    }

    public Object removeConfig(String r100) {
        return this.sConfigs.remove(r100);
    }

    public void setABSetType(VEABSetType r100) {
        Objects.toString(r100);
        mABSetType = r100;
        int r101 = TEConfigCenter.f455882a;
        TEConfigCenter.nativeSetABSetType(r100.ordinal());
        setConfigsDefaultValue();
    }

    public void updateConfigToNative(String r100) {
        ValuePkt r101 = this.sConfigs.get(r100);
        if (r101 == null) goto L5;
        TEConfigCenter.a(r100, r101);
        return;
    }

    private void updateEffectConfig(String r100, ValuePkt r110) {
        if (r110.getABType() == ABType.FOREFFECT) goto L23;
        return;
    L23:
        Method r101 = INVOKESTATIC_com_ss_android_vesdk_VEConfigCenter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.vesdk.runtime.VEEffectConfig").getDeclaredMethod("setABConfigValue", new Class[]{String.class, Object.class, Integer.TYPE});     // Catch: Exception -> L19
        int r102 = a.f455533b[r110.getDataType().ordinal()];     // Catch: Exception -> L19
        if (r102 == 1) goto L17;
        if (r102 == 2) goto L16;
        if (r102 != 3) goto L10;
        r101.invoke(null, new Object[]{r100, r110.getValue(), 2});     // Catch: Exception -> L19
    L22:
        return;
    L10:
        if (r102 != 4) goto L12;
    L14:
        r101.invoke(null, new Object[]{r100, r110.getValue(), 1});     // Catch: Exception -> L19
        goto L22
    L12:
        if (r102 == 5) goto L14;
    L16:
        r101.invoke(null, new Object[]{r100, r110.getValue(), 3});     // Catch: Exception -> L19
        goto L22
    L17:
        r101.invoke(null, new Object[]{r100, r110.getValue(), 0});     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public int addConfig(String r100, ValuePkt r101) {
        if (this.sConfigs.containsKey(r100) == true) goto L5;
        setValue(r100, r101);
        return 0;
    L5:
        return -100;
    }

    public float getValue(String r100, float r101) {
        ValuePkt r102 = this.sConfigs.get(r100);
        if (((Boolean) this.sConfigs.get("ve_enable_bytebench").getValue()).booleanValue() == false) goto L5;
        t1.a.a().getClass();
    L5:
        if (r102 != null) goto L7;
    L10:
        return r101;
    L7:
        if (r102.getValue() == null) goto L10;
        return ((Float) r102.getValue()).floatValue();
    }

    public Boolean getValueIgnoreByteBench(String r100, boolean r101) {
        ValuePkt r102 = this.sConfigs.get(r100);
        if (r102 == null) goto L9;
        if (r102.getValue() == null) goto L9;
        return (Boolean) r102.getValue();
    L9:
        return Boolean.valueOf(r101);
    }

    public ValuePkt setValue(String r100, ValuePkt r101) {
        ValuePkt r102 = this.sConfigs.put(r100, r101);
        if (r102 != null) goto L5;
        Objects.toString(ValuePkt.access$100(r101));
    L7:
        if (ValuePkt.access$100(r101) == ABType.FOREFFECT) goto L9;
    L15:
        return r102;
    L9:
        if (r100.equals("enable_jnionload_pthreadonce") == false) goto L15;
        Boolean r103 = (Boolean) r101.getValue();
        INVOKESTATIC_com_ss_android_vesdk_VEConfigCenter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bef.effectsdk.EffectABConfig").getDeclaredMethod("enableJniOnloadThreadOnce", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{r103});     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r102.toString();
        Objects.toString(r101);
        goto L7
    }

    public Object updateValue(String r110, Object r111) {
        ValuePkt r100 = this.sConfigs.get(r110);
        if (r100 == null) goto L5;
        Object r101 = ValuePkt.access$200(r100);
        ValuePkt r102 = r100.updateValue(r111);
        if (ValuePkt.access$100(r100) != ABType.FOREFFECT) goto L16;
        if (r110.equals("enable_jnionload_pthreadonce") == false) goto L16;
        Objects.toString(r111);
        INVOKESTATIC_com_ss_android_vesdk_VEConfigCenter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bef.effectsdk.EffectABConfig").getDeclaredMethod("enableJniOnloadThreadOnce", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{r111});     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r101.equals(ValuePkt.access$200(r102)) == true) goto L18;
        this.sModifiedConfigs.put(r110, r100);
    L18:
        return r101;
    L5:
        return null;
    }

    public int getValue(String r100, int r101) {
        ValuePkt r102 = this.sConfigs.get(r100);
        if (((Boolean) this.sConfigs.get("ve_enable_bytebench").getValue()).booleanValue() == false) goto L5;
        t1.a.a().getClass();
    L5:
        if (r102 != null) goto L7;
    L10:
        return r101;
    L7:
        if (r102.getValue() == null) goto L10;
        return ((Integer) r102.getValue()).intValue();
    }

    public long getValue(String r100, long r101) {
        ValuePkt r102 = this.sConfigs.get(r100);
        if (((Boolean) this.sConfigs.get("ve_enable_bytebench").getValue()).booleanValue() == false) goto L5;
        t1.a.a().getClass();
    L5:
        if (r102 != null) goto L7;
    L10:
        return r101;
    L7:
        if (r102.getValue() == null) goto L10;
        return ((Long) r102.getValue()).longValue();
    }

    public Boolean getValue(String r100, boolean r101) {
        ValuePkt r102 = this.sConfigs.get(r100);
        if (((Boolean) this.sConfigs.get("ve_enable_bytebench").getValue()).booleanValue() == false) goto L5;
        t1.a.a().getClass();
    L5:
        if (r102 == null) goto L11;
        if (r102.getValue() == null) goto L11;
        return (Boolean) r102.getValue();
    L11:
        return Boolean.valueOf(r101);
    }

    public String getValue(String r100, String r101) {
        ValuePkt r102 = this.sConfigs.get(r100);
        if (((Boolean) this.sConfigs.get("ve_enable_bytebench").getValue()).booleanValue() == false) goto L5;
        t1.a.a().getClass();
    L5:
        if (r102 != null) goto L7;
    L10:
        return r101;
    L7:
        if (r102.getValue() == null) goto L10;
        return (String) r102.getValue();
    }
}
