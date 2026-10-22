package com.obric.capabilitykit.common;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.livehostapi.business.IHostShare;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/TaskStateInfo;", "Landroid/os/Parcelable;", "state", "Lcom/obric/capabilitykit/common/TaskState;", "content", "", IHostShare.ShareType.SCREENSHOT, "Landroid/graphics/Bitmap;", "ext", "", "(Lcom/obric/capabilitykit/common/TaskState;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/util/Map;)V", "getContent", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getScreenshot", "()Landroid/graphics/Bitmap;", "setScreenshot", "(Landroid/graphics/Bitmap;)V", "getState", "()Lcom/obric/capabilitykit/common/TaskState;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskStateInfo implements Parcelable {
    public static final Parcelable.Creator<TaskStateInfo> CREATOR = null;
    private final String content;
    private Map<String, String> ext;
    private Bitmap screenshot;
    private final TaskState state;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<TaskStateInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TaskStateInfo createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            TaskState r101 = TaskState.valueOf(r110.readString());
            String r102 = r110.readString();
            Bitmap r103 = (Bitmap) r110.readParcelable(TaskStateInfo.class.getClassLoader());
            if (r110.readInt() != 0) goto L5;
            LinkedHashMap r104 = null;
        L9:
            TaskStateInfo r105 = new TaskStateInfo(r101, r102, r103, r104);
            int r106 = Math.min(r100, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L10:
            if (r108 > r106) goto L12;
            r108 = r108 + 1;
        L12:
            if (r108 > r100) goto L14;
            joa.a.d(r110, r107);
            r108 = r108 + 1;
            goto L12
        L14:
            return r105;
        L5:
            int r109 = r110.readInt();
            LinkedHashMap r111 = new LinkedHashMap(r109);
            int r112 = 0;
        L6:
            if (r112 == r109) goto L8;
            r111.put(r110.readString(), r110.readString());
            r112 = r112 + 1;
            goto L6
        L8:
            r104 = r111;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final TaskStateInfo[] newArray(int r100) {
            return new TaskStateInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskStateInfo(TaskState r100, String r101, Bitmap r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.state = r100;
        this.content = r101;
        this.screenshot = r102;
        this.ext = r103;
    }

    public /* synthetic */ TaskStateInfo(TaskState r100, String r101, Bitmap r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskStateInfo copy$default(TaskStateInfo r100, TaskState r101, String r102, Bitmap r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.screenshot;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final TaskState component1() {
        return this.state;
    }

    public final String component2() {
        return this.content;
    }

    public final Bitmap component3() {
        return this.screenshot;
    }

    public final Map<String, String> component4() {
        return this.ext;
    }

    public final TaskStateInfo copy(TaskState r100, String r101, Bitmap r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return new TaskStateInfo(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskStateInfo) == true) goto L8;
        return false;
    L8:
        TaskStateInfo r101 = (TaskStateInfo) r100;
        if (this.state == r101.state) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.screenshot, r101.screenshot) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    public final TaskState getState() {
        return this.state;
    }

    public int hashCode() {
        int r100 = this.state.hashCode() * 31;
        String r101 = this.content;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Bitmap r105 = this.screenshot;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.ext;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    public final void setScreenshot(Bitmap r100) {
        this.screenshot = r100;
    }

    public String toString() {
        return "TaskStateInfo(state=" + this.state + ", content=" + this.content + ", screenshot=" + this.screenshot + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.state.name());
        r100.writeString(this.content);
        r100.writeParcelable(this.screenshot, r101);
        Map<String, String> r102 = this.ext;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L7
    }
}
