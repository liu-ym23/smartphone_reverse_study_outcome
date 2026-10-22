package com.ss.android.lark.filedetail.impl.detail.menu;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenFileInfo f421624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f421625b;

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final void v() {
        OpenFileInfo r100 = this.f421624a;
        if (r100.forwardAsFile == false) goto L5;
        hfb.b.d r101 = a.f421619a;
        a.a(this.f421625b, r100);
        return;
    L5:
        final a.C4968a r102 = new a.C4968a(this.f421625b, r100);
        if (TextUtils.isEmpty(r102.f421621b.mMessageId) == true) goto L34;
        OpenFileInfo r103 = r102.f421621b;
        if (r103.mFavoriteMessage == null) goto L13;
        hfb.b.d r104 = a.f421619a;
        if (r104 == null) goto L29;
        r104.e();
        return;
    L29:
        return;
    L13:
        Message r105 = r103.mMessage;
        if (r105 != null) goto L20;
        hfb.b.d r106 = a.f421619a;
        if (r106 == null) goto L19;
        r106.d();
    L19:
        r105 = null;
    L20:
        if (r105 == null) goto L24;
        hfb.b.d r107 = a.f421619a;
        if (r107 == null) goto L31;
        String r108 = r102.f421621b.originMergeForwardId;
        r107.i();
        return;
    L31:
        return;
    L24:
        hfb.b.d r109 = a.f421619a;
        if (r109 == null) goto L33;
        CollectionsKt.listOf(r102.f421621b.mMessageId);
        new UIGetDataCallback(new FileMenuActionFactory$FileForward$onGetRemoteMessage$1(r102));
        r109.a();
        return;
    L33:
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final boolean w() {
        if (TextUtils.isEmpty(this.f421624a.threadId) == true) goto L5;
        hfb.b.d r100 = a.f421619a;
        if (r100 == null) goto L18;
        String r101 = this.f421624a.threadId;
        r100.h();
        return true;
    L18:
        return true;
    L5:
        if (this.f421624a.mJumpPosition != (-1)) goto L8;
        return false;
    L8:
        hfb.b.d r102 = a.f421619a;
        if (r102 == null) goto L16;
        r102.f();
        return true;
    L16:
        return true;
    }

    public c(OpenFileInfo r100, Context r101) {
        this.f421624a = r100;
        this.f421625b = r101;
    }
}
