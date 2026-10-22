package com.ss.android.lark.profile.entity;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.f;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.t;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public class WorkStatus implements Serializable {
    private static final long serialVersionUID = -4077423738789762558L;
    public final String description;
    public final long endTime;
    public final boolean isCrossTenant;
    public final long startTime;
    public final Status status;

    public static final enum Status extends Enum<Status> {
        public static final Status ON_LEAVE = null;
        public static final Status ON_MEETING = null;
        public static final Status UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f438836a = null;
        private int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("ON_LEAVE", 1, 1);
            ON_LEAVE = r101;
            Status r102 = new Status("ON_MEETING", 2, 2);
            ON_MEETING = r102;
            f438836a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f438836a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static /* synthetic */ int access$000(Status r100) {
            return r100.value;
        }

        public static Status valueOf(int r100) {
            if (r100 != 1) goto L6;
            return ON_LEAVE;
        L6:
            if (r100 != 2) goto L9;
            return ON_MEETING;
        L9:
            return UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String toString() {
        return "WorkStatus{status=" + this.status + ", description='" + this.description + "', startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    }

    public WorkStatus() {
        this.status = Status.UNKNOWN;
        this.description = "";
        this.startTime = -1;
        this.endTime = -1;
        this.isCrossTenant = false;
    }

    public static boolean isInvalid(WorkStatus r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.status != Status.UNKNOWN) goto L10;
        Log.w("WorkStatus", "status is UNKNOWN ，" + r100.toString());
        return true;
    L10:
        if (r100.isCrossTenant == false) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof WorkStatus) == true) goto L5;
        return false;
    L5:
        WorkStatus r101 = (WorkStatus) r100;
        if (TextUtils.equals(this.description, r101.description) == true) goto L9;
        return false;
    L9:
        if (this.startTime == r101.startTime) goto L12;
        return false;
    L12:
        if (this.endTime == r101.endTime) goto L14;
        return false;
    L14:
        Status r102 = this.status;
        if (r102 != null) goto L17;
    L22:
        if (r102 == null) goto L24;
    L26:
        return false;
    L24:
        if (r101.status != null) goto L26;
        return true;
    L17:
        if (r101.status == null) goto L22;
        if (Status.access$000(r102) != Status.access$000(r101.status)) goto L27;
        return true;
    L27:
        return false;
    }

    public String getDisplayTextNoDuration(Context r100) {
        return a(r100, false);
    }

    public String getDisplayTextWithDuration(Context r100) {
        return a(r100, true);
    }

    public final String a(Context r100, boolean r110) {
        if (r110 == false) goto L10;
        long r101 = this.startTime * 1000;
        String[] r111 = t.f444778a;
        String r102 = f.a(UIUtils.getString(r100, R.string.Lark_Legacy_CommonEnShortDateFormat), r101, null, null);
        String r103 = f.a(UIUtils.getString(r100, R.string.Lark_Legacy_CommonEnShortDateFormat), this.endTime * 1000, null, null);
        if (TextUtils.equals(r102, r103) == false) goto L8;
        return r102 + " " + this.description;
    L8:
        return r102 + "-" + r103 + " " + this.description;
    L10:
        return this.description;
    }

    public WorkStatus(Status r100, String r101, long r102, long r103, boolean r104) {
        this.status = r100;
        this.description = r101;
        this.startTime = r102;
        this.endTime = r103;
        this.isCrossTenant = r104;
    }
}
