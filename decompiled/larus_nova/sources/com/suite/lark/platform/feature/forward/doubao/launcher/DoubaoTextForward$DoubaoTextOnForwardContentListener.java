package com.suite.lark.platform.feature.forward.doubao.launcher;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/launcher/DoubaoTextForward$DoubaoTextOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "callback", "Lcom/suite/lark/platform/feature/forward/doubao/launcher/DoubaoTextForward$DoubaoTextForwardCallback;", "<init>", "(Lcom/suite/lark/platform/feature/forward/doubao/launcher/DoubaoTextForward$DoubaoTextForwardCallback;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DoubaoTextForward$DoubaoTextOnForwardContentListener implements OnForwardContentListener {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubaoTextForward$DoubaoTextForwardCallback f461358a;

    public static final class a implements Parcelable.Creator<DoubaoTextForward$DoubaoTextOnForwardContentListener> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoTextForward$DoubaoTextOnForwardContentListener createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DoubaoTextForward$DoubaoTextOnForwardContentListener(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoTextForward$DoubaoTextOnForwardContentListener[] newArray(int r100) {
            return new DoubaoTextForward$DoubaoTextOnForwardContentListener[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoTextForward$DoubaoTextOnForwardContentListener(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Serializable r101 = r100.readSerializable();
        if ((r101 instanceof DoubaoTextForward$DoubaoTextForwardCallback) == false) goto L5;
        DoubaoTextForward$DoubaoTextForwardCallback r102 = (DoubaoTextForward$DoubaoTextForwardCallback) r101;
    L6:
        this.f461358a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final void onFailed(String r100) {
        DoubaoTextForward$DoubaoTextForwardCallback r101 = this.f461358a;
        if (r101 == null) goto L6;
        r101.onFailed(null, r100);
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.f461358a);
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final boolean m(Activity r100, Map<String, ? extends ForwardTargetBaseInfoNew> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "result");
        DoubaoTextForward$DoubaoTextForwardCallback r103 = this.f461358a;
        if (r103 == null) goto L7;
        r103.onSuccess(r101);
        return true;
    L7:
        return true;
    }
}
