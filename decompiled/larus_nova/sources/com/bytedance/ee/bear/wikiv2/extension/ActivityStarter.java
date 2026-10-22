package com.bytedance.ee.bear.wikiv2.extension;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.multitask.task.RemoteActivityStarter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/extension/ActivityStarter;", "Lcom/ss/android/lark/multitask/task/RemoteActivityStarter;", "activityClass", "Ljava/lang/Class;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Ljava/lang/Class;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", WidgetCostModule.TYPE_ON_START, "", "snapshot", "Lcom/ss/android/lark/multitask/task/TaskSnapshot;", KtvSubElement.CONTAINER, "Lcom/ss/android/lark/multitask/task/TaskContainer;", "CREATOR", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityStarter extends RemoteActivityStarter {
    public static final a CREATOR = null;

    public static final class a implements Parcelable.Creator<ActivityStarter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityStarter createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Serializable r101 = r100.readSerializable();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<out androidx.appcompat.app.AppCompatActivity>");
            return new ActivityStarter((Class) r101);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityStarter[] newArray(int r100) {
            return new ActivityStarter[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ActivityStarter(Class<? extends AppCompatActivity> r100) {
        Intrinsics.checkNotNullParameter(r100, "activityClass");
        super(r100);
    }
}
