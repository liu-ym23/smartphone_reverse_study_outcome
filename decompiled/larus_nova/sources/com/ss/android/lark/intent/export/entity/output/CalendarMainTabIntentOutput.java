package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import com.ss.android.lark.search.dto.info.CalendarResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/CalendarMainTabIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/intent/export/entity/output/ISDKCallback;", "result", "", "Lcom/ss/android/lark/search/dto/info/CalendarResult;", "msg", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getResult", "()Ljava/util/List;", "getMsg", "()Ljava/lang/String;", "callback", "R", "visitor", "Lcom/ss/android/lark/intent/export/entity/output/ISDKCallbackVisitor;", "(Lcom/ss/android/lark/intent/export/entity/output/ISDKCallbackVisitor;)Ljava/lang/Object;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarMainTabIntentOutput extends CommonSuccessIntentOutput implements ISDKCallback {
    public static final Parcelable.Creator<CalendarMainTabIntentOutput> CREATOR = null;
    private final String msg;
    private final List<CalendarResult> result;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CalendarMainTabIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarMainTabIntentOutput createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            ArrayList r102 = new ArrayList(r101);
            int r103 = 0;
        L3:
            if (r103 == r101) goto L6;
            r102.add(r100.readParcelable(CalendarMainTabIntentOutput.class.getClassLoader()));
            r103 = r103 + 1;
            goto L3
        L6:
            return new CalendarMainTabIntentOutput(r102, r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarMainTabIntentOutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarMainTabIntentOutput[] newArray(int r100) {
            return new CalendarMainTabIntentOutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarMainTabIntentOutput[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<CalendarResult> r102 = this.result;
        r100.writeInt(r102.size());
        Iterator<CalendarResult> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    L6:
        r100.writeString(this.msg);
    }

    public final String getMsg() {
        return this.msg;
    }

    public final List<CalendarResult> getResult() {
        return this.result;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.ISDKCallback
    public <R> R callback(ISDKCallbackVisitor<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        return r100.visit(this);
    }

    public CalendarMainTabIntentOutput(List<CalendarResult> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        super(Direction.MAIN_PAGE_CALENDAR, r101);
        this.result = r100;
        this.msg = r101;
    }

    public /* synthetic */ CalendarMainTabIntentOutput(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
