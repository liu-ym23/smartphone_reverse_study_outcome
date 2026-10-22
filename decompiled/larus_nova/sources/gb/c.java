package gb;

import com.bytedance.android.anniex.solutions.card.util.DataTypeAdapter;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lgb/c;", "", "", "", "Lgb/a$d;", PrefetchTiming.JSB, "Ljava/util/Map;", "c", "()Ljava/util/Map;", "Lgb/a$c;", SlcCommonAction.KEY_ACTIONS, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, SendEventContainerMethodParamModel.EventKinds.onShow, "Lgb/a$c;", "e", "()Lgb/a$c;", "onHide", "d", "onViewLoad", "f", "data", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final Map<String, a.c> actions;

    @SerializedName("data")
    @JsonAdapter(DataTypeAdapter.class)
    private final Map<String, Object> data;

    /* JADX INFO: renamed from: jsb, reason: collision with root package name */
    @SerializedName(PrefetchTiming.JSB)
    private final Map<String, a.d> f480644jsb;

    @SerializedName("onHide")
    private final a.c onHide;

    @SerializedName(SendEventContainerMethodParamModel.EventKinds.onShow)
    private final a.c onShow;

    @SerializedName("onViewLoad")
    private final a.c onViewLoad;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f480644jsb, r101.f480644jsb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onShow, r101.onShow) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.onHide, r101.onHide) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.onViewLoad, r101.onViewLoad) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Map<String, a.d> r100 = this.f480644jsb;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, a.c> r104 = this.actions;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a.c r107 = this.onShow;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a.c r110 = this.onHide;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        a.c r113 = this.onViewLoad;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, Object> r116 = this.data;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public final String toString() {
        return "MetaContent(jsb=" + this.f480644jsb + ", actions=" + this.actions + ", onShow=" + this.onShow + ", onHide=" + this.onHide + ", onViewLoad=" + this.onViewLoad + ", data=" + this.data + ')';
    }

    public c() {
        this.f480644jsb = null;
        this.actions = null;
        this.onShow = null;
        this.onHide = null;
        this.onViewLoad = null;
        this.data = null;
    }

    public final Map<String, a.c> a() {
        return this.actions;
    }

    public final Map<String, Object> b() {
        return this.data;
    }

    public final Map<String, a.d> c() {
        return this.f480644jsb;
    }

    public final a.c d() {
        return this.onHide;
    }

    public final a.c e() {
        return this.onShow;
    }

    public final a.c f() {
        return this.onViewLoad;
    }
}
