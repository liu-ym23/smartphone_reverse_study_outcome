package com.ss.android.lark.screenprotect.screenshot;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes38.dex */
public final class ShareScreenshotUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShareScreenshotUtil f439806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, b> f439807b = null;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/screenprotect/screenshot/ShareScreenshotUtil$ForwardListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "lkEventId", "", "<init>", "(I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "describeContents", "CREATOR", "screen-protect_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ForwardListener implements OnForwardContentListener {
        public static final a CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f439808a;

        public static final class a implements Parcelable.Creator<ForwardListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ForwardListener createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new ForwardListener(r100.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final ForwardListener[] newArray(int r100) {
                return new ForwardListener[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public ForwardListener(int r100) {
            this.f439808a = r100;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final void onFailed(String r100) {
            int r101 = ScsLogger.f440428a;
            ScsLogger.c("SHARE_SS_ShareScreenshotUtil", "ForwardListener onFailed, e: " + r100);
            ShareScreenshotUtil r102 = ShareScreenshotUtil.f439806a;
            ShareScreenshotUtil.g(this.f439808a);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.writeInt(this.f439808a);
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final boolean m(Activity r100, Map<String, ? extends ForwardTargetBaseInfoNew> r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "result");
            ScsLogger.d("SHARE_SS_ShareScreenshotUtil", "ForwardListener onSuccess.");
            ShareScreenshotUtil r103 = ShareScreenshotUtil.f439806a;
            int r104 = this.f439808a;
            Map<Integer, b> r105 = ShareScreenshotUtil.f439807b;
            LinkedHashMap r106 = (LinkedHashMap) r105;
            b r107 = (b) r106.get(Integer.valueOf(r104));
            if (r107 == null) goto L7;
            j18.f<ShareScreenshotPlugin.ShareScreenshotResponseModel> r108 = r107.f439812c;
            if (r108 == null) goto L7;
            r108.callback(new ShareScreenshotPlugin.ShareScreenshotResponseModel());
        L7:
            ShareScreenshotUtil.d(r104);
            return true;
        }
    }

    public static final class a implements oib.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f439809a;

        @Override // oib.b
        public final void onClose() {
            ScsLogger.d("SHARE_SS_ShareScreenshotUtil", "CloseListener onClose.");
            ShareScreenshotUtil r100 = ShareScreenshotUtil.f439806a;
            ShareScreenshotUtil.f(this.f439809a);
        }

        public a(int r100) {
            this.f439809a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f439810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SoftReference<Bitmap> f439811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j18.f<ShareScreenshotPlugin.ShareScreenshotResponseModel> f439812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f439813d;

        public b() {
            throw null;
        }

        public final Context getContext() {
            return this.f439810a;
        }

        public b(Context r100, SoftReference r101, j18.f r102) {
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
            this.f439810a = r100;
            this.f439811b = r101;
            this.f439812c = r102;
            this.f439813d = "";
        }
    }

    public ShareScreenshotUtil() {
    }

    static {
        f439806a = new ShareScreenshotUtil();
        f439807b = new LinkedHashMap();
    }

    public static void c(j18.f r100) {
        ShareScreenshotPlugin.ShareScreenshotResponseModel r101 = new ShareScreenshotPlugin.ShareScreenshotResponseModel();
        r101.setApiErrNo(ShareScreenshotPlugin.a.f439803c);
        if (r100 == null) goto L6;
        r100.callback(r101);
        return;
    }

    public static void d(int r100) {
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, null, null, new ShareScreenshotUtil$clear$1(r100, null), 3, null);
    }

    public static Object e(Continuation r100) {
        Object r101 = BuildersKt.withContext(Dispatchers.getIO(), new ShareScreenshotUtil$reset$2(null), r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public static void f(int r100) {
        ShareScreenshotPlugin.ShareScreenshotResponseModel r101 = new ShareScreenshotPlugin.ShareScreenshotResponseModel();
        r101.setApiErrNo(ShareScreenshotPlugin.a.f439805e);
        Map<Integer, b> r102 = f439807b;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        b r104 = (b) r103.get(Integer.valueOf(r100));
        if (r104 == null) goto L7;
        j18.f<ShareScreenshotPlugin.ShareScreenshotResponseModel> r105 = r104.f439812c;
        if (r105 == null) goto L7;
        r105.callback(r101);
    L7:
        d(r100);
    }

    public static void g(int r100) {
        ShareScreenshotPlugin.ShareScreenshotResponseModel r101 = new ShareScreenshotPlugin.ShareScreenshotResponseModel();
        r101.setApiErrNo(ShareScreenshotPlugin.a.f439804d);
        Map<Integer, b> r102 = f439807b;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        b r104 = (b) r103.get(Integer.valueOf(r100));
        if (r104 == null) goto L7;
        j18.f<ShareScreenshotPlugin.ShareScreenshotResponseModel> r105 = r104.f439812c;
        if (r105 == null) goto L7;
        r105.callback(r101);
    L7:
        d(r100);
    }

    public static final Object a(ShareScreenshotUtil r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ShareScreenshotUtil$deleteImage$1) == false) goto L7;
        ShareScreenshotUtil$deleteImage$1 r103 = (ShareScreenshotUtil$deleteImage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        boolean r108 = ((Boolean) r105).booleanValue();
        if (r108 == false) goto L20;
        ScsLogger.d("SHARE_SS_ShareScreenshotUtil", "deleteImage success.");
    L22:
        return Boxing.boxBoolean(r108);
    L20:
        ScsLogger.c("SHARE_SS_ShareScreenshotUtil", "deleteImage fail!");
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r109 = Dispatchers.getIO();
        ShareScreenshotUtil$deleteImage$result$1 r110 = new ShareScreenshotUtil$deleteImage$result$1(r101, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r109, r110, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new ShareScreenshotUtil$deleteImage$1(r100, r102);
        goto L8
    }

    public static final Object b(ShareScreenshotUtil r100, Bitmap r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ShareScreenshotUtil$saveBitmapTemp$1) == false) goto L7;
        ShareScreenshotUtil$saveBitmapTemp$1 r103 = (ShareScreenshotUtil$saveBitmapTemp$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return (String) r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r108 = Dispatchers.getIO();
        ShareScreenshotUtil$saveBitmapTemp$path$1 r109 = new ShareScreenshotUtil$saveBitmapTemp$path$1(r101, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new ShareScreenshotUtil$saveBitmapTemp$1(r100, r102);
        goto L8
    }
}
