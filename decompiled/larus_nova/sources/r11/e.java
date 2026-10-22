package r11;

import com.bytedance.android.live.revlink.impl.config.LinkPerformanceSettingSerializableObjectImpl;
import com.bytedance.android.live.revlink.impl.config.LinkPerformanceSetting_ForeConfigSerializableObjectImpl;
import com.bytedance.android.live.revlink.impl.config.LinkPerformanceSetting_ResidentConfigSerializableObjectImpl;
import com.bytedance.android.live.revlink.impl.config.LinkPerformanceSetting_SceneConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(LinkPerformanceSettingSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lr11/e;", "Lvh7/j;", "b", "c", "d", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.j<e> {

    @JsonAdapter(LinkPerformanceSettingSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(LinkPerformanceSetting_ForeConfigSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/e$b;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.j<b> {

        @JsonAdapter(LinkPerformanceSetting_ForeConfigSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @FieldName(name = VideoThumbInfo.KEY_INTERVAL)
        long getInterval();

        @FieldName(name = "sample_count")
        int i();

        @FieldName(name = "duration")
        long p();
    }

    @JsonAdapter(LinkPerformanceSetting_ResidentConfigSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/e$c;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.j<c> {

        @JsonAdapter(LinkPerformanceSetting_ResidentConfigSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @FieldName(name = "sample_interval")
        long O6();

        @FieldName(name = VideoThumbInfo.KEY_INTERVAL)
        long getInterval();

        @FieldName(name = "sample_count")
        int i();

        @FieldName(name = "duration")
        long p();

        @FieldName(name = "recover_duration")
        long y7();
    }

    @JsonAdapter(LinkPerformanceSetting_SceneConfigSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/e$d;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface d extends vh7.j<d> {

        @JsonAdapter(LinkPerformanceSetting_SceneConfigSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @FieldName(name = "sample_count_audience")
        int D7();

        @FieldName(name = "monitor_delay")
        long H();

        @FieldName(name = "enable")
        boolean getEnable();

        @FieldName(name = VideoThumbInfo.KEY_INTERVAL)
        long getInterval();

        @FieldName(name = "sample_count")
        int i();

        @FieldName(name = "interval_audience")
        long w2();
    }

    @FieldName(name = "fps_threshold")
    float B1();

    @FieldName(name = "report_sample_count_anchor")
    long C3();

    @FieldName(name = "monitor_delay")
    long H();

    @FieldName(name = "im_degrade_enable")
    boolean J7();

    @FieldName(name = "effect_degrade_enable")
    boolean L0();

    @FieldName(name = "scene_config")
    d M();

    @FieldName(name = "degrade_enable")
    boolean V6();

    @FieldName(name = "ui_fps_threshold")
    float W();

    @FieldName(name = "report_sample_count_audience")
    long W5();

    @FieldName(name = "mem_threshold")
    long Y6();

    @FieldName(name = "mix_degrade_enable")
    boolean a6();

    @FieldName(name = "base_degrade_enable")
    boolean b3();

    @FieldName(name = "resident_config")
    c c9();

    @FieldName(name = "force_degrade_enable")
    boolean g2();

    @FieldName(name = "fore_monitor_delay")
    long g9();

    @FieldName(name = "feature_enable")
    boolean getEnable();

    @FieldName(name = "fore_con_config")
    b m4();

    @FieldName(name = "cpu_threshold")
    float w1();
}
