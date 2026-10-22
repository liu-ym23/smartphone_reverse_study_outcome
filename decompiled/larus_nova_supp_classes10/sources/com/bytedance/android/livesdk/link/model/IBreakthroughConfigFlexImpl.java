package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BreakthroughConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR#\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBreakthroughConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/m3;", "Lpy/k;", "mvpImage", "Lpy/k;", "getMvpImage", "()Lpy/k;", "setMvpImage", "(Lpy/k;)V", "", "Lcom/bytedance/android/livesdk/link/model/IBreakthroughConfig_IStageFlexImpl;", "stages$delegate", "Ljava/lang/Object;", "getStages", "()Ljava/util/List;", "stages", "", "highScoreThreshold$delegate", "getHighScoreThreshold", "()J", "highScoreThreshold", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBreakthroughConfigFlexImpl extends FlexModelBase<m3> implements m3, vh7.h {

    @SerializedName("high_score_threshold")
    protected long _$$highScoreThreshold;

    @SerializedName("stages")
    protected List<IBreakthroughConfig_IStageFlexImpl> _$$stages;

    @SerializedName("mvp_image")
    protected py.k mvpImage;

    public IBreakthroughConfigFlexImpl() {
        super(m3.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.m3
    public final long getHighScoreThreshold() {
        return this._$$highScoreThreshold;
    }

    @Override // com.bytedance.android.livesdk.link.model.m3
    public py.k getMvpImage() {
        return this.mvpImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.m3
    public final List<IBreakthroughConfig_IStageFlexImpl> getStages() {
        return this._$$stages;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IBreakthroughConfigFlexImpl(am3.g r6) {
        super(m3.class);
        this._$$stages = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$stages.add(new IBreakthroughConfig_IStageFlexImpl(r6));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.mvpImage = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$highScoreThreshold = r6.j();
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setMvpImage(py.k r1) {
        this.mvpImage = r1;
    }
}
