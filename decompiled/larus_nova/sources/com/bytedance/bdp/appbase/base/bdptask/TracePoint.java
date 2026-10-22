package com.bytedance.bdp.appbase.base.bdptask;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001'B\u001f\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b#\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R$\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R$\u0010\u001e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/TracePoint;", "Landroid/os/Parcelable;", "", "getEventKey", "getEventKeyName", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "<set-?>", "time", "J", "getTime", "()J", "pointId", "getPointId", "pid", "I", "getPid", "()I", "pName", "Ljava/lang/String;", "getPName", "()Ljava/lang/String;", "tid", "getTid", "tName", "getTName", "trace", "sub", "event", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class TracePoint implements Parcelable {
    public static final a CREATOR = null;
    public static final int EVE_D = 4;
    public static final int EVE_I = 2;
    public static final int RUN = 1;
    public static final int SCH = 3;
    private static final AtomicLong SCH_ID = null;
    public final int event;
    private String pName;
    private int pid;
    private long pointId;

    /* JADX INFO: renamed from: sub, reason: collision with root package name */
    public final String f200479sub;
    private String tName;
    private int tid;
    private long time;
    public final String trace;

    public static final class a implements Parcelable.Creator<TracePoint> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TracePoint createFromParcel(Parcel r100) {
            return new TracePoint(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TracePoint[] newArray(int r100) {
            return new TracePoint[r100];
        }
    }

    @JvmStatic
    public static final String getEventName(int r100) {
        CREATOR.getClass();
        if (r100 != 1) goto L5;
        return "R";
    L5:
        if (r100 != 2) goto L7;
        return "I";
    L7:
        if (r100 != 3) goto L9;
        return ExifInterface.LATITUDE_SOUTH;
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "D";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
        SCH_ID = new AtomicLong(1000);
    }

    public final String getEventKey() {
        if (this.event != 3) goto L7;
        return getEventKeyName() + "#" + (System.currentTimeMillis() - this.time);
    L7:
        return getEventKeyName();
    }

    public final String getEventKeyName() {
        StringBuilder r100 = new StringBuilder();
        a r101 = CREATOR;
        int r102 = this.event;
        r101.getClass();
        if (r102 != 1) goto L5;
        String r103 = "R";
    L15:
        r100.append(r103);
        r100.append(".");
        r100.append(this.pointId);
        return r100.toString();
    L5:
        if (r102 != 2) goto L7;
        r103 = "I";
        goto L15
    L7:
        if (r102 != 3) goto L9;
        r103 = ExifInterface.LATITUDE_SOUTH;
        goto L15
    L9:
        if (r102 == 4) goto L11;
        r103 = "";
        goto L15
    L11:
        r103 = "D";
        goto L15
    }

    public static final /* synthetic */ AtomicLong access$getSCH_ID$cp() {
        return SCH_ID;
    }

    public final String getPName() {
        return this.pName;
    }

    public final int getPid() {
        return this.pid;
    }

    public final long getPointId() {
        return this.pointId;
    }

    public final String getTName() {
        return this.tName;
    }

    public final int getTid() {
        return this.tid;
    }

    public final long getTime() {
        return this.time;
    }

    public TracePoint(Parcel r100) {
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.readString();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this(r101, r103, r100.readInt());
        this.time = r100.readLong();
        this.pointId = r100.readLong();
        this.pid = r100.readInt();
        String r104 = r100.readString();
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.pName = r104;
        this.tid = r100.readInt();
        String r105 = r100.readString();
        if (r105 == null) goto L15;
        r102 = r105;
    L15:
        this.tName = r102;
    }

    @JvmStatic
    public static final boolean isEnable(int r100) {
        CREATOR.getClass();
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 == 3) goto L12;
        if (r100 == 4) goto L12;
        return false;
    L12:
        return k.f();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.trace);
        r100.writeString(this.f200479sub);
        r100.writeInt(this.event);
        r100.writeLong(this.time);
        r100.writeLong(this.pointId);
        r100.writeInt(this.pid);
        r100.writeString(this.pName);
        r100.writeInt(this.tid);
        r100.writeString(this.tName);
    }

    public TracePoint(String r100, String r101, int r102) {
        this.trace = r100;
        this.f200479sub = r101;
        this.event = r102;
        long r103 = 0;
        if (k.f() == false) goto L5;
        long r104 = System.currentTimeMillis();
    L6:
        this.time = r104;
        if (k.f() == false) goto L9;
        r103 = SCH_ID.getAndIncrement();
    L9:
        this.pointId = r103;
        int r105 = 0;
        if (k.f() == false) goto L12;
        int r106 = Process.myPid();
    L13:
        this.pid = r106;
        Application r107 = z84.a.a();
        String r108 = com.bytedance.bdp.bdpbase.util.i.f201342d;
        if (TextUtils.isEmpty(r108) == true) goto L17;
    L25:
        this.pName = r108;
        if (k.f() == false) goto L28;
        r105 = Process.myTid();
    L28:
        this.tid = r105;
        if (k.f() == false) goto L31;
        String r109 = ThreadMethodProxy.currentThread().getName();
    L32:
        this.tName = r109;
        return;
    L31:
        r109 = "";
        goto L32
    L17:
        if (com.bytedance.bdp.bdpbase.util.i.d(r107) == false) goto L19;
        com.bytedance.bdp.bdpbase.util.i.f201342d = AccountType.MAIN;
    L24:
        r108 = com.bytedance.bdp.bdpbase.util.i.f201342d;
        goto L25
    L19:
        String r110 = com.bytedance.bdp.bdpbase.util.i.c(r107);
        if (r110 == null) goto L24;
        String[] r111 = r110.split(":");
        if (r111.length <= 1) goto L24;
        com.bytedance.bdp.bdpbase.util.i.f201342d = r111[1];
        goto L24
    L12:
        r106 = 0;
        goto L13
    L5:
        r104 = 0;
        goto L6
    }
}
