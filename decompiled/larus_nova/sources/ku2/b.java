package ku2;

import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000bR\u001a\u0010\t\u001a\u00020\u00048VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lku2/b;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/h1;", "Lku2/a;", "", "getPosition", "()I", "getPosition$annotations", "()V", "position", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface b extends vh7.e<h1>, h1, ku2.a {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f506187a = null;

        public a() {
        }

        static {
            f506187a = new a();
        }
    }

    /* JADX INFO: renamed from: ku2.b$b, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class C6613b {
    }

    static {
        Companion = a.f506187a;
    }

    @Override // com.bytedance.android.live.base.model.message.h1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.h1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ JsonObject extra();

    /* synthetic */ int getContainerType();

    /* synthetic */ JsonObject getExtra();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ String getH5Url();

    /* synthetic */ String getLynxUrl();

    /* synthetic */ int getOperationType();

    @FieldName(name = "position")
    int getPosition();
}
