package com.ss.android.lark.widget.photo.preview.authorization;

import com.larus.nova.R;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.intercept.ActionMenuType;
import com.ss.android.lark.widget.photo.preview.intercept.b;
import com.ss.android.lark.widget.photo.preview.intercept.c;
import com.ss.android.lark.widget.photo.preview.intercept.d;
import com.ss.android.lark.widget.photo.preview.menu.action.DownloadAuthorizationEventType;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.f;
import com.ss.android.lark.widget.photopicker.utils.l;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements com.ss.android.lark.widget.photo.preview.intercept.a {

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.authorization.a$a, reason: collision with other inner class name */
    public static final class C5409a {
    }

    static {
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.widget.photo.preview.intercept.a
    public final Object a(d r210, Continuation r211) {
        d r100 = r210;
        if ((r211 instanceof DownloadAuthorizationInterceptor$intercept$1) == false) goto L7;
        DownloadAuthorizationInterceptor$intercept$1 r101 = (DownloadAuthorizationInterceptor$intercept$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L121:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b r106 = (b) r101.L$1;
        com.ss.android.lark.widget.photo.preview.intercept.a.InterfaceC5410a r107 = (com.ss.android.lark.widget.photo.preview.intercept.a.InterfaceC5410a) r101.L$0;
        ResultKt.throwOnFailure(r103);
        b r108 = r106;
        r100 = r107;
        Object r109 = r103;
    L113:
        if (((Boolean) r109).booleanValue() == true) goto L115;
    L118:
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        r103 = r100.a(r108, r101);
        if (r103 != r104) goto L121;
        return r104;
    L115:
        return new c.b("authorization intercepted");
    L16:
        ResultKt.throwOnFailure(r103);
        r108 = r100.f446734d;
        if ((r108 instanceof b.C5411b) == false) goto L20;
        Object r110 = ((b.C5411b) r108).f446727a;
    L22:
        ActionMenuType r111 = ActionMenuType.DOWNLOAD;
        boolean r112 = false;
        if (r110 != r111) goto L25;
    L32:
        boolean r113 = true;
    L33:
        if (r113 == false) goto L118;
        r101.L$0 = r100;
        r101.L$1 = r108;
        r101.label = 1;
        j r114 = new j(IntrinsicsKt.intercepted(r101), 1);
        r114.C();
        PhotoItem r115 = r108.a();
        if (r115 == null) goto L39;
        MediaExtra r116 = r115.getMediaExtra();
        if (r116 == null) goto L39;
        String r117 = r116.getKey();
    L40:
        String r118 = "";
        if (r117 != null) goto L44;
        r117 = "";
    L44:
        if (r117.length() != 0) goto L46;
        r112 = true;
    L46:
        if (r112 == false) goto L53;
        if (r115 == null) goto L49;
        String r119 = l.a(r115);
    L50:
        if (r119 == null) goto L54;
        r118 = r119;
    L54:
        if (r115 == null) goto L56;
        MessageIdentity r120 = r115.getMessageIdentity();
    L57:
        if (r120 == null) goto L59;
        r120.getChatId();
    L59:
        if (r120 == null) goto L62;
        r120.getMessageId();
    L62:
        if ((r108 instanceof b.a) == false) goto L65;
        Object r121 = ((b.a) r108).getType();
    L67:
        DownloadAuthorizationEventType r122 = DownloadAuthorizationEventType.IMAGE_DOWNLOAD;
        if (r121 != r111) goto L70;
    L94:
        int r123 = StringsKt.indexOf$default(r118, ":", 0, false, 6, null);
        if (r123 == (-1)) goto L101;
        String r124 = r118.substring(r123);
        if (r124.length() <= 1) goto L100;
        r124.substring(1);
        goto L101
    L100:
        Log.e("DownloadAuthorizationInterceptor", "image key: " + r118 + " is invalid!");
    L101:
        int r125 = R.string.Lark_Audit_BlockedActionDownloadFullImage;
    L102:
        Log.i("AuthorizationServiceV2", "check download auth start at: " + System.currentTimeMillis());
        f.d r126 = f.a();
        if (r120 == null) goto L105;
        r120.getSenderId();
    L105:
        if (r120 == null) goto L107;
        r120.getSenderTenantId();
    L107:
        r108.getContext();
        Boxing.boxInt(r125);
        r126.m();
        r109 = r114.B();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L110;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L110:
        if (r109 != r104) goto L113;
        return r104;
    L70:
        if (Intrinsics.areEqual(r121, "DOWNLOAD_IMAGE") == true) goto L94;
        if (Intrinsics.areEqual(r121, "SAVE_VIDEO") == false) goto L79;
        r125 = R.string.Lark_Audit_BlockedActionDownloadVideo;
        if (r115 == null) goto L102;
        MediaExtra r127 = r115.getMediaExtra();
        if (r127 == null) goto L102;
        r127.getKey();
        goto L102
    L79:
        if (r115 == null) goto L81;
        Serializable r128 = r115.getLoadModel();
    L82:
        if (r128 == null) goto L101;
        if ((r128 instanceof EncryptImage) == false) goto L101;
        String r129 = ((EncryptImage) r128).getEncryptKey();
        int r130 = StringsKt.indexOf$default(r129, ":", 0, false, 6, null);
        if (r130 == (-1)) goto L101;
        String r131 = r129.substring(r130);
        if (r131.length() <= 1) goto L93;
        r131.substring(1);
        goto L101
    L93:
        Log.e("DownloadAuthorizationInterceptor", "image key: " + r129 + " is invalid!");
        goto L101
    L81:
        r128 = null;
        goto L82
    L65:
        if ((r108 instanceof b.C5411b) == false) goto L117;
        r121 = ((b.C5411b) r108).f446727a;
        goto L67
    L117:
        throw new NoWhenBranchMatchedException();
    L56:
        r120 = null;
        goto L57
    L49:
        r119 = null;
        goto L50
    L53:
        r118 = r117;
    L39:
        r117 = null;
        goto L40
    L25:
        if (Intrinsics.areEqual(r110, "DOWNLOAD_IMAGE") == true) goto L32;
        if (Intrinsics.areEqual(r110, "SAVE_IMAGE") == true) goto L32;
        if (Intrinsics.areEqual(r110, "SAVE_VIDEO") == true) goto L32;
        r113 = false;
        goto L33
    L20:
        if ((r108 instanceof b.a) == false) goto L123;
        r110 = ((b.a) r108).getType();
        goto L22
    L123:
        throw new NoWhenBranchMatchedException();
    L7:
        r101 = new DownloadAuthorizationInterceptor$intercept$1(this, r211);
        goto L8
    }
}
