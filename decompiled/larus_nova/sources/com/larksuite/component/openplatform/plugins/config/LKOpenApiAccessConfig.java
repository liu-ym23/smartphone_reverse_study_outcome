package com.larksuite.component.openplatform.plugins.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizDomain;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class LKOpenApiAccessConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<LKOpenApiAccessConfig> CREATOR = null;
    private LKOpenApiBizType mBizType;
    private LKOpenApiBizDomain mDomain;
    private boolean mPublicToJS;
    private String mScene;

    public class a implements Parcelable.Creator<LKOpenApiAccessConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LKOpenApiAccessConfig createFromParcel(Parcel r100) {
            return new LKOpenApiAccessConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LKOpenApiAccessConfig[] newArray(int r100) {
            return new LKOpenApiAccessConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "LKOpenApiAccessConfig{mDomain=" + this.mDomain + ", mBizType=" + this.mBizType + ", mScene='" + this.mScene + "', mPublicToJS=" + this.mPublicToJS + '}';
    }

    private LKOpenApiAccessConfig() {
    }

    public LKOpenApiBizType getBizType() {
        return this.mBizType;
    }

    public LKOpenApiBizDomain getDomain() {
        return this.mDomain;
    }

    public String getScene() {
        return this.mScene;
    }

    public boolean isPublicToJS() {
        return this.mPublicToJS;
    }

    public LKOpenApiAccessConfig(Parcel r100) {
        this.mScene = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.mPublicToJS = r101;
        Serializable r102 = r100.readSerializable();
        if (r102 == null) goto L9;
        this.mDomain = (LKOpenApiBizDomain) r102;
    L9:
        Serializable r103 = r100.readSerializable();
        if (r103 == null) goto L13;
        this.mBizType = (LKOpenApiBizType) r103;
        return;
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void updateDomain(LKOpenApiBizDomain r100) {
        this.mDomain = r100;
    }

    public /* synthetic */ LKOpenApiAccessConfig(a r100) {
        this();
    }

    public static /* synthetic */ LKOpenApiBizDomain access$102(LKOpenApiAccessConfig r100, LKOpenApiBizDomain r101) {
        r100.mDomain = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(LKOpenApiAccessConfig r100, boolean r101) {
        r100.mPublicToJS = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(LKOpenApiAccessConfig r100, String r101) {
        r100.mScene = r101;
        return r101;
    }

    public static /* synthetic */ LKOpenApiBizType access$402(LKOpenApiAccessConfig r100, LKOpenApiBizType r101) {
        r100.mBizType = r101;
        return r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mScene);
        r100.writeByte(this.mPublicToJS ? 1 : 0);
        r100.writeSerializable(this.mDomain);
        r100.writeSerializable(this.mBizType);
    }

    public static LKOpenApiAccessConfig createOpenApiConfig(LKOpenApiBizDomain r100, LKOpenApiBizType r101, String r102, boolean r103) {
        LKOpenApiBizDomain r104 = LKOpenApiBizDomain.ALL;
        LKOpenApiAccessConfig r105 = new LKOpenApiAccessConfig(null);
        access$102(r105, r100);
        access$202(r105, r103);
        access$302(r105, r102);
        access$402(r105, r101);
        return r105;
    }
}
