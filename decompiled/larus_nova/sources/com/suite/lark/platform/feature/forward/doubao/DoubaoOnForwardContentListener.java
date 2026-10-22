package com.suite.lark.platform.feature.forward.doubao;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.suite.lark.platform.feature.forward.doubao.api.entity.DoubaoForwardCommonConfig;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/DoubaoOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "callback", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoForwardCommonConfig$ForwardContentListener;", "<init>", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoForwardCommonConfig$ForwardContentListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DoubaoOnForwardContentListener implements OnForwardContentListener {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubaoForwardCommonConfig.ForwardContentListener f461250a;

    public static final class a implements Parcelable.Creator<DoubaoOnForwardContentListener> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoOnForwardContentListener createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Serializable r101 = r100.readSerializable();
            if ((r101 instanceof DoubaoForwardCommonConfig.ForwardContentListener) == false) goto L5;
            DoubaoForwardCommonConfig.ForwardContentListener r102 = (DoubaoForwardCommonConfig.ForwardContentListener) r101;
        L6:
            if (r102 == null) goto L10;
            return new DoubaoOnForwardContentListener(r102);
        L10:
            throw new IllegalArgumentException("Required value was null.".toString());
        L5:
            r102 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoOnForwardContentListener[] newArray(int r100) {
            return new DoubaoOnForwardContentListener[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoOnForwardContentListener(DoubaoForwardCommonConfig.ForwardContentListener r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f461250a = r100;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final void onFailed(String r100) {
        this.f461250a.onFailed(null, r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.f461250a);
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final boolean m(Activity r100, Map<String, ? extends ForwardTargetBaseInfoNew> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "result");
        DoubaoForwardCommonConfig.ForwardContentListener r103 = this.f461250a;
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator<T> r105 = r101.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L19;
        Map.Entry r106 = (Map.Entry) r105.next();
        Object r107 = r106.getKey();
        ForwardTargetBaseInfoNew r108 = (ForwardTargetBaseInfoNew) r106.getValue();
        npc.c r109 = new npc.c();
        String r110 = r108.f425268a;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f520073a = r110;
        String r111 = r108.f425270c;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r109.f520074b = r111;
        String r112 = r108.f425269b;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r109.f520075c = r112;
        if ((r108 instanceof ForwardTargetChatterInfo) == false) goto L9;
        r109.f520077e = 1;
    L17:
        r104.put(r107, r109);
        goto L4
    L9:
        if ((r108 instanceof ForwardTargetShieldP2PChatInfo) == false) goto L12;
        r109.f520077e = 1;
        goto L17
    L12:
        if ((r108 instanceof ForwardTargetGroupChatInfo) == false) goto L15;
        r109.f520077e = 2;
        goto L17
    L15:
        if ((r108 instanceof ForwardTargetThreadInfo) == false) goto L17;
        r109.f520077e = 3;
        String r113 = ((ForwardTargetThreadInfo) r108).f425298h;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r109.f520076d = r113;
        goto L17
    L19:
        return r103.onSuccess(r104);
    }
}
