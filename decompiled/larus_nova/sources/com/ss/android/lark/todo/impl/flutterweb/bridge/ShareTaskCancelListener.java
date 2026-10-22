package com.ss.android.lark.todo.impl.flutterweb.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.forwardv2.dto.template.IForwardCancelListener;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/ShareTaskCancelListener;", "Lcom/ss/android/lark/forwardv2/dto/template/IForwardCancelListener;", "<init>", "()V", "onCancel", "", "describeContents", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", RXScreenCaptureService.KEY_INDEX, "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareTaskCancelListener implements IForwardCancelListener {
    public static final Parcelable.Creator<IForwardCancelListener> CREATOR = null;

    public static final class a implements Parcelable.Creator<IForwardCancelListener> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IForwardCancelListener createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new ShareTaskCancelListener();
        }

        @Override // android.os.Parcelable.Creator
        public final IForwardCancelListener[] newArray(int r100) {
            return new ShareTaskCancelListener[r100];
        }
    }

    public static final class b {
    }

    public ShareTaskCancelListener() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.forwardv2.dto.template.IForwardCancelListener
    public final void onCancel() {
        Callback r100 = x.f444217a;
        Callback r101 = x.f444217a;
        if (r101 == null) goto L5;
        r101.success(null);
    L5:
        x.f444217a = null;
    }
}
