package ns1;

import com.bytedance.android.livesdk.config.blackframe.AudioBlackFrameOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes8.dex */
@JsonAdapter(AudioBlackFrameOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lns1/a;", "Lvh7/j;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends j<a> {

    /* JADX INFO: renamed from: ns1.a$a, reason: collision with other inner class name */
    @JsonAdapter(AudioBlackFrameOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C6967a {
    }

    @FieldName(name = "opt_height")
    int A1();

    @FieldName(name = "enable")
    boolean s7();

    @FieldName(name = "opt_width")
    int u7();
}
