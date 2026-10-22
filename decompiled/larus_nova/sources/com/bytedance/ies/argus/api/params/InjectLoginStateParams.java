package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class InjectLoginStateParams extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SceneType f245666c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/api/params/InjectLoginStateParams$SceneType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "X_REQUEST", "PIA", "FOREST", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum SceneType extends Enum<SceneType> {
        public static final SceneType FOREST = null;
        public static final SceneType PIA = null;
        public static final SceneType X_REQUEST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SceneType[] f245667a = null;
        private final String value;

        public static SceneType valueOf(String r100) {
            return (SceneType) r27.a.a(SceneType.class, r100);
        }

        public static SceneType[] values() {
            return (SceneType[]) f245667a.clone();
        }

        static {
            SceneType r100 = new SceneType("X_REQUEST", 0, "xRequest");
            X_REQUEST = r100;
            SceneType r101 = new SceneType("PIA", 1, "pia");
            PIA = r101;
            SceneType r102 = new SceneType("FOREST", 2, "forest");
            FOREST = r102;
            f245667a = new SceneType[]{r100, r101, r102};
        }

        public final String getValue() {
            return this.value;
        }

        public SceneType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return d(r100);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        int r102 = CommonUtils.f246248a;
        JSONUtilsKt.d(r101, "source_url", CommonUtils.k(this.f245665b));
        JSONUtilsKt.d(r101, "origin_source_url", this.f245665b);
        JSONUtilsKt.d(r101, "scene_type", this.f245666c.getValue());
        return r101;
    }

    public InjectLoginStateParams(String r100, SceneType r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceUrl");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f245665b = r100;
        this.f245666c = r101;
    }
}
