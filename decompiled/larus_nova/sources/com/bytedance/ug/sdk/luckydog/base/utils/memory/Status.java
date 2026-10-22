package com.bytedance.ug.sdk.luckydog.base.utils.memory;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.systemopt.SysPowerKit;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public final class Status extends ProcFile {
    public static final Parcelable.Creator<Status> CREATOR = null;

    public static class a implements Parcelable.Creator<Status> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Status createFromParcel(Parcel r100) {
            return new Status(r100, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Status[] newArray(int r100) {
            return new Status[r100];
        }
    }

    public Status() {
        throw null;
    }

    static {
        CREATOR = new a();
    }

    public int getGid() {
        return CastIntegerProtector.parseInt(getValue("Gid").split("\\s+")[0]);
    L4:
        return -1;
    }

    public int getUid() {
        return CastIntegerProtector.parseInt(getValue(SysPowerKit.PWR_OVERUSE_UID).split("\\s+")[0]);
    L4:
        return -1;
    }

    public Status(String r100) throws IOException {
        super(r100);
    }

    public static Status get(int r100) throws IOException {
        return new Status(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(r100)}));
    }

    public String getValue(String r100) {
        String[] r101 = this.content.split("\n");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = r101[r103];
        if (r104.startsWith(r100 + ":") == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return r104.split(r100 + ":")[1].trim();
    L9:
        return null;
    }

    public Status(Parcel r100, a r101) {
        super(r100);
    }
}
