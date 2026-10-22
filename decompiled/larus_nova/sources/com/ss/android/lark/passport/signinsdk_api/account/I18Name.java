package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class I18Name implements Serializable, Parcelable {
    public static final Parcelable.Creator<I18Name> CREATOR = null;

    @JSONField(name = "en_us")
    public String enUs;

    @JSONField(name = "ja_jp")
    public String jaJp;

    @JSONField(name = "zh_cn")
    public String zhCn;

    public class a implements Parcelable.Creator<I18Name> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final I18Name createFromParcel(Parcel r100) {
            return new I18Name(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final I18Name[] newArray(int r100) {
            return new I18Name[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public I18Name() {
    }

    public I18Name(Parcel r100) {
        this.zhCn = r100.readString();
        this.enUs = r100.readString();
        this.jaJp = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.zhCn);
        r100.writeString(this.enUs);
        r100.writeString(this.jaJp);
    }
}
