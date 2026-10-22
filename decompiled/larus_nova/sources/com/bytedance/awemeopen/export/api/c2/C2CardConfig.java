package com.bytedance.awemeopen.export.api.c2;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/bytedance/awemeopen/export/api/c2/C2CardConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "maxCount", "I", "getMaxCount", "()I", "setMaxCount", "(I)V", "", "hostEnterFrom", "Ljava/lang/String;", "getHostEnterFrom", "()Ljava/lang/String;", "setHostEnterFrom", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "hostExtraParams", "Lorg/json/JSONObject;", "getHostExtraParams", "()Lorg/json/JSONObject;", "setHostExtraParams", "(Lorg/json/JSONObject;)V", "backGroundColor", "getBackGroundColor", "setBackGroundColor", "", "shouldPaddingStatusBarHeight", "Z", "getShouldPaddingStatusBarHeight", "()Z", "setShouldPaddingStatusBarHeight", "(Z)V", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class C2CardConfig implements Parcelable {
    public static final String CONFIG_KEY = "C2_PAGE_CONFIG_KEY";
    public static final a CREATOR = null;
    private int backGroundColor;
    private String hostEnterFrom;
    private JSONObject hostExtraParams;
    private int maxCount;
    private boolean shouldPaddingStatusBarHeight;

    public static final class a implements Parcelable.Creator<C2CardConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final C2CardConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new C2CardConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final C2CardConfig[] newArray(int r100) {
            return new C2CardConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public C2CardConfig() {
        this.maxCount = Integer.MAX_VALUE;
        this.hostEnterFrom = "sdk_default";
        this.hostExtraParams = new JSONObject();
        this.shouldPaddingStatusBarHeight = true;
    }

    public final int getBackGroundColor() {
        return this.backGroundColor;
    }

    public final String getHostEnterFrom() {
        return this.hostEnterFrom;
    }

    public final JSONObject getHostExtraParams() {
        return this.hostExtraParams;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final boolean getShouldPaddingStatusBarHeight() {
        return this.shouldPaddingStatusBarHeight;
    }

    public C2CardConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.maxCount = r100.readInt();
        String r101 = r100.readString();
        if (r101 != null) goto L5;
        r101 = "sdk_default";
    L5:
        this.hostEnterFrom = r101;
        this.backGroundColor = r100.readInt();
        if (r100.readByte() == 0) goto L8;
        boolean r102 = true;
    L9:
        this.shouldPaddingStatusBarHeight = r102;
        String r103 = r100.readString();
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        this.hostExtraParams = new JSONObject(r103);
        return;
    L8:
        r102 = false;
        goto L9
    }

    public final void setBackGroundColor(int r100) {
        this.backGroundColor = r100;
    }

    public final void setHostEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostEnterFrom = r100;
    }

    public final void setHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostExtraParams = r100;
    }

    public final void setMaxCount(int r100) {
        this.maxCount = r100;
    }

    public final void setShouldPaddingStatusBarHeight(boolean r100) {
        this.shouldPaddingStatusBarHeight = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.maxCount);
        r100.writeString(this.hostEnterFrom);
        r100.writeInt(this.backGroundColor);
        r100.writeByte(this.shouldPaddingStatusBarHeight ? 1 : 0);
        r100.writeString(this.hostExtraParams.toString());
    }
}
