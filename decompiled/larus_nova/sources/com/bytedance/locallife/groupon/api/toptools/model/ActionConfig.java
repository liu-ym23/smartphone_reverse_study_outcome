package com.bytedance.locallife.groupon.api.toptools.model;

import com.bytedance.locallife.common.utils.d;
import com.bytedance.locallife.common.utils.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001&B7\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J@\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/locallife/groupon/api/toptools/model/ActionConfig;", "", "", "Lcom/bytedance/locallife/groupon/api/toptools/model/PanelItemStruct;", "getDetailList", "", "component1", "()Ljava/lang/Integer;", "", "component2", "component3", "Lcom/bytedance/locallife/groupon/api/toptools/model/SwitchEntranceConfig;", "component4", "action", "jumpUrl", "subEntranceStr", "switchEntranceConfig", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/api/toptools/model/SwitchEntranceConfig;)Lcom/bytedance/locallife/groupon/api/toptools/model/ActionConfig;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Integer;", "getAction", "Ljava/lang/String;", "getJumpUrl", "()Ljava/lang/String;", "getSubEntranceStr", "Lcom/bytedance/locallife/groupon/api/toptools/model/SwitchEntranceConfig;", "getSwitchEntranceConfig", "()Lcom/bytedance/locallife/groupon/api/toptools/model/SwitchEntranceConfig;", "detailList", "Ljava/util/List;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/api/toptools/model/SwitchEntranceConfig;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class ActionConfig {
    public static final int ACTION_TYPE_LIST = 2;
    public static final int ACTION_TYPE_NORMAL = 1;
    public static final a Companion = null;

    @SerializedName("type")
    private final Integer action;
    private List<PanelItemStruct> detailList;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("sub_entrance_list_json")
    private final String subEntranceStr;

    @SerializedName("switch_entrance_config")
    private final SwitchEntranceConfig switchEntranceConfig;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/locallife/groupon/api/toptools/model/ActionConfig$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/locallife/groupon/api/toptools/model/PanelItemStruct;", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends PanelItemStruct>> {
        public b() {
        }
    }

    static {
        Companion = new a();
    }

    public ActionConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ActionConfig copy$default(ActionConfig r100, Integer r101, String r102, String r103, SwitchEntranceConfig r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.jumpUrl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.subEntranceStr;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.switchEntranceConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.action;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final String component3() {
        return this.subEntranceStr;
    }

    public final SwitchEntranceConfig component4() {
        return this.switchEntranceConfig;
    }

    public final ActionConfig copy(Integer r100, String r101, String r102, SwitchEntranceConfig r103) {
        return new ActionConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActionConfig) == true) goto L8;
        return false;
    L8:
        ActionConfig r101 = (ActionConfig) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subEntranceStr, r101.subEntranceStr) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.switchEntranceConfig, r101.switchEntranceConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final synchronized List<PanelItemStruct> getDetailList() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.detailList != null) goto L15;
        int r100 = j.f257151a;     // Catch: Throwable -> L18
        if (j.a(this.subEntranceStr) == false) goto L15;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        String r102 = this.subEntranceStr;     // Catch: Throwable -> L9
        Type r103 = new b().getType();     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl((List) GsonProtectorUtils.fromJson(d.b(), r102, r103));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == false) goto L14;
        r104 = null;
    L14:
        this.detailList = (List) r104;     // Catch: Throwable -> L18
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
    L15:
        List<PanelItemStruct> r106 = this.detailList;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r106;
    }

    public int hashCode() {
        Integer r100 = this.action;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.subEntranceStr;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        SwitchEntranceConfig r110 = this.switchEntranceConfig;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionConfig(action=" + this.action + ", jumpUrl=" + this.jumpUrl + ", subEntranceStr=" + this.subEntranceStr + ", switchEntranceConfig=" + this.switchEntranceConfig + ')';
    }

    public final Integer getAction() {
        return this.action;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getSubEntranceStr() {
        return this.subEntranceStr;
    }

    public final SwitchEntranceConfig getSwitchEntranceConfig() {
        return this.switchEntranceConfig;
    }

    public ActionConfig(Integer r100, String r101, String r102, SwitchEntranceConfig r103) {
        this.action = r100;
        this.jumpUrl = r101;
        this.subEntranceStr = r102;
        this.switchEntranceConfig = r103;
    }

    public /* synthetic */ ActionConfig(Integer r100, String r101, String r102, SwitchEntranceConfig r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
