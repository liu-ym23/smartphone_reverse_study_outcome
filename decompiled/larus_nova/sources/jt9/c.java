package jt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJV\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0004\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0005\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0007\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/larus/settings/godzilla/GodzillaPluginConfig;", "", "isCustomerExtensionPluginEnable", "", "isBadParcelableExceptionPlugin", "isCursorWindowPluginEnable", "isUnsupportedOperationPluginEnable", "isBinderTranTooLargeExpEnable", "binderTranTooLargeBundleSizeThresholdBytes", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBinderTranTooLargeBundleSizeThresholdBytes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/settings/godzilla/GodzillaPluginConfig;", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("binder_tran_too_large_bundle_size_threshold_bytes")
    private final Integer binderTranTooLargeBundleSizeThresholdBytes;

    @SerializedName("is_bad_parcelable_exception_plugin_enable")
    private final Boolean isBadParcelableExceptionPlugin;

    @SerializedName("is_binder_tran_too_large_exp_enable")
    private final Boolean isBinderTranTooLargeExpEnable;

    @SerializedName("is_cursor_window_plugin_enable")
    private final Boolean isCursorWindowPluginEnable;

    @SerializedName("is_customer_extension_plugin_enable")
    private final Boolean isCustomerExtensionPluginEnable;

    @SerializedName("is_unsupported_operation_plugin_enable")
    private final Boolean isUnsupportedOperationPluginEnable;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.isCustomerExtensionPluginEnable, r101.isCustomerExtensionPluginEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isBadParcelableExceptionPlugin, r101.isBadParcelableExceptionPlugin) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isCursorWindowPluginEnable, r101.isCursorWindowPluginEnable) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isUnsupportedOperationPluginEnable, r101.isUnsupportedOperationPluginEnable) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isBinderTranTooLargeExpEnable, r101.isBinderTranTooLargeExpEnable) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.binderTranTooLargeBundleSizeThresholdBytes, r101.binderTranTooLargeBundleSizeThresholdBytes) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.isCustomerExtensionPluginEnable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isBadParcelableExceptionPlugin;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isCursorWindowPluginEnable;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isUnsupportedOperationPluginEnable;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isBinderTranTooLargeExpEnable;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.binderTranTooLargeBundleSizeThresholdBytes;
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
        return "GodzillaPluginConfig(isCustomerExtensionPluginEnable=" + this.isCustomerExtensionPluginEnable + ", isBadParcelableExceptionPlugin=" + this.isBadParcelableExceptionPlugin + ", isCursorWindowPluginEnable=" + this.isCursorWindowPluginEnable + ", isUnsupportedOperationPluginEnable=" + this.isUnsupportedOperationPluginEnable + ", isBinderTranTooLargeExpEnable=" + this.isBinderTranTooLargeExpEnable + ", binderTranTooLargeBundleSizeThresholdBytes=" + this.binderTranTooLargeBundleSizeThresholdBytes + ')';
    }

    public final Integer a() {
        return this.binderTranTooLargeBundleSizeThresholdBytes;
    }

    public final Boolean b() {
        return this.isBadParcelableExceptionPlugin;
    }

    public final Boolean c() {
        return this.isBinderTranTooLargeExpEnable;
    }

    public final Boolean d() {
        return this.isCursorWindowPluginEnable;
    }

    public final Boolean e() {
        return this.isCustomerExtensionPluginEnable;
    }

    public final Boolean f() {
        return this.isUnsupportedOperationPluginEnable;
    }

    public c(int r100) {
        Boolean r101 = Boolean.TRUE;
        this.isCustomerExtensionPluginEnable = r101;
        this.isBadParcelableExceptionPlugin = r101;
        this.isCursorWindowPluginEnable = r101;
        this.isUnsupportedOperationPluginEnable = r101;
        this.isBinderTranTooLargeExpEnable = r101;
        this.binderTranTooLargeBundleSizeThresholdBytes = null;
    }
}
