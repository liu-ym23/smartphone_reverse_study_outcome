package com.ss.android.lark.multitask.task;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t¢\u0006\u0004\b\u0006\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/multitask/task/RemoteActivityStarter;", "Lcom/ss/android/lark/multitask/task/AbsActivityTaskStarter;", "Lcom/ss/android/lark/multitask/task/RemoteTaskStarter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "<init>", "(Landroid/os/Parcel;)V", "activityClass", "Ljava/lang/Class;", "Landroidx/appcompat/app/AppCompatActivity;", "(Ljava/lang/Class;)V", "called", "", "start", "", "snapshot", "Lcom/ss/android/lark/multitask/task/TaskSnapshot;", KtvSubElement.CONTAINER, "Lcom/ss/android/lark/multitask/task/TaskContainer;", WidgetCostModule.TYPE_ON_START, "putExtras", "bundle", "Landroid/os/Bundle;", "writeToParcel", "flags", "", "describeContents", "CREATOR", "multitask_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RemoteActivityStarter extends com.ss.android.lark.multitask.task.a implements RemoteTaskStarter, Parcelable {
    public static final a CREATOR = null;

    public static final class a implements Parcelable.Creator<RemoteActivityStarter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RemoteActivityStarter createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RemoteActivityStarter(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RemoteActivityStarter[] newArray(int r100) {
            return new RemoteActivityStarter[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public RemoteActivityStarter(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Serializable r101 = r100.readSerializable();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<out androidx.appcompat.app.AppCompatActivity>");
        super((Class) r101);
    }

    public RemoteActivityStarter(Class<? extends AppCompatActivity> r100) {
        Intrinsics.checkNotNullParameter(r100, "activityClass");
        super(r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.f432836a);
    }
}
