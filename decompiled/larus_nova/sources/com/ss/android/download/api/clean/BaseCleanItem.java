package com.ss.android.download.api.clean;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class BaseCleanItem implements IJsonable, Parcelable {
    public static final Parcelable.Creator<BaseCleanItem> CREATOR = null;
    protected String absolutePath;
    private Drawable icon;
    boolean isCheck;
    private String name;
    protected long size;

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getSizeStr() {
        return getSizeStr(this.size);
    }

    @Override // com.ss.android.download.api.clean.IJsonable
    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("absolute_path", this.absolutePath);     // Catch: JSONException -> L5
        r100.putOpt("size", Long.valueOf(this.size));     // Catch: JSONException -> L5
        r100.putOpt("name", this.name);     // Catch: JSONException -> L5
        r100.putOpt("is_check", Boolean.valueOf(this.isCheck));     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public BaseCleanItem() {
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public BaseCleanItem(Parcel r100) {
        this.absolutePath = r100.readString();
        this.size = r100.readLong();
        this.name = r100.readString();
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.isCheck = r101;
    }

    private String getSizeStr(long r100) {
        DecimalFormat r101 = new DecimalFormat("0.00");
        if (r100 < 1073741824) goto L6;
        return r101.format(r100 / 1.0737418E9f) + "GB";
    L6:
        if (r100 < 1048576) goto L9;
        return r101.format(r100 / 1048576.0f) + "MB";
    L9:
        if (r100 < 1024) goto L12;
        return r101.format(r100 / 1024.0f) + "KB";
    L12:
        return r100 + "B";
    }

    @Override // com.ss.android.download.api.clean.IJsonable
    public void parse(JSONObject r100) {
        if (r100 == null) goto L5;
        this.absolutePath = r100.optString("absolute_path");
        this.size = r100.optLong("size");
        this.name = r100.optString("name");
        this.isCheck = r100.optBoolean("is_check");
        return;
    }

    public void setAbsolutePath(String r100) {
        this.absolutePath = r100;
    }

    public void setCheck(boolean r100) {
        this.isCheck = r100;
    }

    public void setDrawable(Drawable r100) {
        this.icon = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.absolutePath);
        r100.writeLong(this.size);
        r100.writeString(this.name);
        r100.writeInt(this.isCheck ? 1 : 0);
    }
}
