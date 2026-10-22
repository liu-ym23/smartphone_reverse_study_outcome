package com.suite.lark.platform.feature.forward.doubao;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ$\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u001c\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/DoubaoForwardExecutorBridge;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "scene", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardScene;", "content", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;", "<init>", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardScene;Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onForward", "", "targets", "", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoInfo;", "note", "", "callback", "Lcom/suite/lark/platform/feature/forward/doubao/api/IDoubaoForwardExecutor$OnForwardExecuteCallback;", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoForwardExecutorBridge implements OnForwardContentListener {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ForwardScene f461236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ForwardDoubaoContent f461237b;

    public static final class a implements Parcelable.Creator<DoubaoForwardExecutorBridge> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoForwardExecutorBridge createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DoubaoForwardExecutorBridge(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoForwardExecutorBridge[] newArray(int r100) {
            return new DoubaoForwardExecutorBridge[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final boolean m(Activity r100, Map<String, ? extends ForwardTargetBaseInfoNew> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "result");
        return true;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final void onFailed(String r100) {
    }

    public DoubaoForwardExecutorBridge(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Serializable r101 = r100.readSerializable();
        Serializable r102 = null;
        if ((r101 instanceof ForwardScene) == true) goto L5;
        r101 = null;
    L5:
        ForwardScene r103 = (ForwardScene) r101;
        if (r103 != null) goto L8;
        r103 = ForwardScene.UNKNOWN;
    L8:
        Serializable r104 = r100.readSerializable();
        if ((r104 instanceof ForwardDoubaoContent) == false) goto L12;
        r102 = r104;
    L12:
        ForwardDoubaoContent r105 = (ForwardDoubaoContent) r102;
        if (r105 != null) goto L15;
        r105 = new ForwardDoubaoContent();
    L15:
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r105, "content");
        this.f461236a = r103;
        this.f461237b = r105;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.f461236a);
        r100.writeSerializable(this.f461237b);
    }
}
