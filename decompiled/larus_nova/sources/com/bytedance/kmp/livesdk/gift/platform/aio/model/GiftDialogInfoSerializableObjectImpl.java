package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kc6.o;
import kc6.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftDialogInfoSerializableObjectImpl;", "Lkc6/o;", "", "Lkc6/r;", "pageList", "Ljava/util/List;", "getPageList", "()Ljava/util/List;", "Q5", "(Ljava/util/List;)V", "", "", "logExtra", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "j6", "(Ljava/util/Map;)V", "", "localVersion", "Ljava/lang/Integer;", "getLocalVersion", "()Ljava/lang/Integer;", "z3", "(Ljava/lang/Integer;)V", "", "giftRequestReady", "Ljava/lang/Boolean;", "i9", "()Ljava/lang/Boolean;", "E1", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftDialogInfoSerializableObjectImpl implements o {

    @SerializedName("gift_request_ready")
    private Boolean giftRequestReady;

    @SerializedName("local_version")
    private Integer localVersion;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("page_list")
    private List<? extends r> pageList;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftDialogInfoSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftDialogInfoSerializableObjectImpl.class);
        }
    }

    public GiftDialogInfoSerializableObjectImpl() {
        this.pageList = d.a();
    }

    @Override // kc6.o
    public final List<r> getPageList() {
        return this.pageList;
    }

    @Override // kc6.o
    public final Boolean i9() {
        return this.giftRequestReady;
    }

    @Override // kc6.o
    public final void E1(Boolean r100) {
        this.giftRequestReady = r100;
    }

    @Override // kc6.o
    public final void Q5(List<? extends r> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageList = r100;
    }

    @Override // kc6.o
    public final void j6(Map<String, String> r100) {
        this.logExtra = r100;
    }

    @Override // kc6.o
    public final void z3(Integer r100) {
        this.localVersion = r100;
    }
}
