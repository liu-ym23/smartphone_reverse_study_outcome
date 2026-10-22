package com.bytedance.awemeopen.export.api.pageconfig.series;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b3\u00104B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b3\u00105J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015¨\u00068"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/series/SeriesPageConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "fullScreen", "Z", "getFullScreen", "()Z", "setFullScreen", "(Z)V", "bottomMarginPxIfNotFullScreen", "I", "getBottomMarginPxIfNotFullScreen", "()I", "setBottomMarginPxIfNotFullScreen", "(I)V", "shouldPaddingStatusBarHeight", "getShouldPaddingStatusBarHeight", "setShouldPaddingStatusBarHeight", d.f25927q, "getShowBackButton", "setShowBackButton", "", "enterMethod", "Ljava/lang/String;", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "ignorePageStatusControl", "getIgnorePageStatusControl", "setIgnorePageStatusControl", "", "seriesId", "J", "getSeriesId", "()J", "setSeriesId", "(J)V", "currentIndex", "getCurrentIndex", "setCurrentIndex", "defaultLockIndex", "getDefaultLockIndex", "setDefaultLockIndex", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class SeriesPageConfig implements Parcelable {
    public static final a CREATOR = null;
    private int bottomMarginPxIfNotFullScreen;
    private int currentIndex;
    private int defaultLockIndex;
    private String enterMethod;
    private boolean fullScreen;
    private boolean ignorePageStatusControl;
    private long seriesId;
    private boolean shouldPaddingStatusBarHeight;
    private boolean showBackButton;

    public static final class a implements Parcelable.Creator<SeriesPageConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SeriesPageConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SeriesPageConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SeriesPageConfig[] newArray(int r100) {
            return new SeriesPageConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SeriesPageConfig() {
        this.fullScreen = true;
        this.bottomMarginPxIfNotFullScreen = MathKt.roundToInt(TypedValue.applyDimension(1, 34, INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_series_SeriesPageConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        this.shouldPaddingStatusBarHeight = true;
        this.showBackButton = true;
        this.enterMethod = RNParamRegisterEventHandler.SRC_OUTER;
        this.currentIndex = 1;
    }

    public final int getBottomMarginPxIfNotFullScreen() {
        return this.bottomMarginPxIfNotFullScreen;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final int getDefaultLockIndex() {
        return this.defaultLockIndex;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public final boolean getIgnorePageStatusControl() {
        return this.ignorePageStatusControl;
    }

    public final long getSeriesId() {
        return this.seriesId;
    }

    public final boolean getShouldPaddingStatusBarHeight() {
        return this.shouldPaddingStatusBarHeight;
    }

    public final boolean getShowBackButton() {
        return this.showBackButton;
    }

    public SeriesPageConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.fullScreen = r102;
        this.bottomMarginPxIfNotFullScreen = r100.readInt();
        this.enterMethod = r100.readString();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.showBackButton = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.ignorePageStatusControl = r104;
        this.seriesId = r100.readLong();
        this.currentIndex = r100.readInt();
        if (r100.readByte() != 0) goto L18;
        r101 = false;
    L18:
        this.shouldPaddingStatusBarHeight = r101;
        this.defaultLockIndex = r100.readInt();
        return;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_awemeopen_export_api_pageconfig_series_SeriesPageConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setBottomMarginPxIfNotFullScreen(int r100) {
        this.bottomMarginPxIfNotFullScreen = r100;
    }

    public final void setCurrentIndex(int r100) {
        this.currentIndex = r100;
    }

    public final void setDefaultLockIndex(int r100) {
        this.defaultLockIndex = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setFullScreen(boolean r100) {
        this.fullScreen = r100;
    }

    public final void setIgnorePageStatusControl(boolean r100) {
        this.ignorePageStatusControl = r100;
    }

    public final void setSeriesId(long r100) {
        this.seriesId = r100;
    }

    public final void setShouldPaddingStatusBarHeight(boolean r100) {
        this.shouldPaddingStatusBarHeight = r100;
    }

    public final void setShowBackButton(boolean r100) {
        this.showBackButton = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.fullScreen ? 1 : 0);
        r100.writeInt(this.bottomMarginPxIfNotFullScreen);
        r100.writeString(this.enterMethod);
        r100.writeByte(this.showBackButton ? 1 : 0);
        r100.writeByte(this.ignorePageStatusControl ? 1 : 0);
        r100.writeLong(this.seriesId);
        r100.writeInt(this.currentIndex);
        r100.writeByte(this.shouldPaddingStatusBarHeight ? 1 : 0);
        r100.writeInt(this.defaultLockIndex);
    }
}
