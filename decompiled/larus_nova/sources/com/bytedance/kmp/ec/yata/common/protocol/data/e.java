package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@@X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/a;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", ce.f26391f, "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "", "<set-?>", "isCustomError", "Z", "h", "()Z", RXScreenCaptureService.KEY_INDEX, "(Z)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public class e extends com.bytedance.kmp.ec.yata.common.protocol.data.a implements com.bytedance.kmp.ec.yata.common.platform.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f251551b = null;

    @SerializedName("is_custom_error")
    private boolean isCustomError;

    @SerializedName("yata_data")
    private final c yataData;

    public static final class a {
        public a() {
        }
    }

    static {
        f251551b = new a();
    }

    public e() {
        this(null);
    }

    public final void i() {
        this.isCustomError = true;
    }

    public final c g() {
        return this.yataData;
    }

    public final boolean h() {
        return this.isCustomError;
    }

    public e(c r100) {
        this.yataData = r100;
    }
}
