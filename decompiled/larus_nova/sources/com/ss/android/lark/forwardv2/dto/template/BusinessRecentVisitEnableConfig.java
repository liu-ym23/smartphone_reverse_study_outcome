package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.impl.IRemoteForwardDisableTargetHandler;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class BusinessRecentVisitEnableConfig implements Parcelable {
    public static final Parcelable.Creator<BusinessRecentVisitEnableConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f424818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRemoteForwardDisableTargetHandler f424819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<EntityItem> f424820c;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig$1, reason: invalid class name */
    class AnonymousClass1 extends IRemoteForwardDisableTargetHandler.Stub {
        final /* synthetic */ BusinessRecentVisitEnableConfig this$0;
        final /* synthetic */ com.ss.android.lark.forwardv2.dto.template.a val$mCustomDisableHandler;

        @Override // com.ss.android.lark.forwardv2.impl.IRemoteForwardDisableTargetHandler
        public boolean showSomeToast() throws RemoteException {
            a r100 = (a) this.val$mCustomDisableHandler;
            r100.getClass();
            return r100.f424821a.f424819b.showSomeToast();
        L5:
            e = move-exception;
            Log.e("BusinessRecentVisitEnableConfig", "showSomeToast", e);
            return false;
        }

        @Override // com.ss.android.lark.forwardv2.impl.IRemoteForwardDisableTargetHandler
        public boolean disableHandle(ForwardTarget r100) throws RemoteException {
            a r101 = (a) this.val$mCustomDisableHandler;
            r101.getClass();
            return r101.f424821a.f424819b.disableHandle(r100);
        L5:
            e = move-exception;
            Log.e("BusinessRecentVisitEnableConfig", "disableHandle", e);
            return false;
        }

        public AnonymousClass1(BusinessRecentVisitEnableConfig r100, com.ss.android.lark.forwardv2.dto.template.a r101) {
            this.this$0 = r100;
            this.val$mCustomDisableHandler = r101;
        }
    }

    public class a implements com.ss.android.lark.forwardv2.dto.template.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessRecentVisitEnableConfig f424821a;

        public a(BusinessRecentVisitEnableConfig r100) {
            this.f424821a = r100;
        }
    }

    public class b implements Parcelable.Creator<BusinessRecentVisitEnableConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitEnableConfig createFromParcel(Parcel r100) {
            return new BusinessRecentVisitEnableConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BusinessRecentVisitEnableConfig[] newArray(int r100) {
            return new BusinessRecentVisitEnableConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new b();
    }

    public final com.ss.android.lark.forwardv2.dto.template.a a() {
        if (this.f424818a != null) goto L8;
        if (this.f424819b == null) goto L8;
        this.f424818a = new a(this);
    L8:
        return this.f424818a;
    }

    public BusinessRecentVisitEnableConfig() {
        this.f424820c = new ArrayList();
    }

    public BusinessRecentVisitEnableConfig(Parcel r100) {
        ArrayList<EntityItem> r101 = new ArrayList();
        this.f424820c = r101;
        r100.readTypedList(r101, EntityItem.CREATOR);
        if (r100.readInt() <= 0) goto L6;
        this.f424819b = IRemoteForwardDisableTargetHandler.Stub.asInterface(r100.readStrongBinder());
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.f424820c);
        if (this.f424819b == null) goto L5;
        r100.writeInt(1);
        r100.writeStrongBinder(this.f424819b.asBinder());
        return;
    L5:
        r100.writeInt(0);
    }
}
