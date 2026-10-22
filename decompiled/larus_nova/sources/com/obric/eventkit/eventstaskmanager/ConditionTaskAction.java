package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.IntentParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "component2", "intent", "params", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getIntent", "()Ljava/lang/String;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "getParams", "()Lcom/obric/capabilitykit/common/intent/IntentParams;", "<init>", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/IntentParams;)V", "(Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ConditionTaskAction implements Parcelable {
    public static final Parcelable.Creator<ConditionTaskAction> CREATOR = null;
    public static final b Companion = null;
    private final String intent;
    private final IntentParams params;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ConditionTaskAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskAction createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ConditionTaskAction r102 = new ConditionTaskAction(r100);
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskAction[] newArray(int r100) {
            return new ConditionTaskAction[r100];
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public ConditionTaskAction(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(TimerTaskKt.a(r100), (IntentParams) r100.readParcelable(IntentParams.class.getClassLoader()));
    }

    public ConditionTaskAction(String r100, IntentParams r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        this.intent = r100;
        this.params = r101;
    }

    public static /* synthetic */ ConditionTaskAction copy$default(ConditionTaskAction r100, String r101, IntentParams r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.intent;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.params;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.intent;
    }

    public final IntentParams component2() {
        return this.params;
    }

    public final ConditionTaskAction copy(String r100, IntentParams r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        return new ConditionTaskAction(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConditionTaskAction) == true) goto L8;
        return false;
    L8:
        ConditionTaskAction r101 = (ConditionTaskAction) r100;
        if (Intrinsics.areEqual(this.intent, r101.intent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final IntentParams getParams() {
        return this.params;
    }

    public int hashCode() {
        int r100 = this.intent.hashCode() * 31;
        IntentParams r101 = this.params;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ConditionTaskAction(intent=" + this.intent + ", params=" + this.params + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.intent);
        r100.writeParcelable(this.params, r101);
    }
}
