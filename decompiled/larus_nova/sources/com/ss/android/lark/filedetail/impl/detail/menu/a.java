package com.ss.android.lark.filedetail.impl.detail.menu;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hfb.b.d f421619a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.detail.menu.a$a, reason: collision with other inner class name */
    public static final class C4968a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f421620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OpenFileInfo f421621b;

        public final Context getContext() {
            return this.f421620a;
        }

        public C4968a(Context r100, OpenFileInfo r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f421620a = r100;
            this.f421621b = r101;
        }
    }

    public a() {
    }

    static {
        com.ss.android.lark.storage.a r100 = FileDetailModule.f421460a;
        hfb.b r101 = FileDetailModule.a.a();
        if (r101 == null) goto L5;
        hfb.b.d r102 = r101.getChatDependency();
    L6:
        f421619a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final void a(Context r110, OpenFileInfo r111) {
        String r100 = r111.mMessageId;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return;
    L12:
        if (r111.mFileContent != null) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r111.originMergeForwardId) == false) goto L17;
        String r103 = r111.mMessageId;
    L18:
        String r104 = r103;
        if (r104 != null) goto L21;
    L22:
        r101 = true;
    L23:
        if (r101 == false) goto L25;
        Log.e("FileDetailActivity", "forward messageId is invalid!");
        return;
    L25:
        int r105 = com.ss.android.lark.filedetail.impl.detail.templatefactory.b.f421646a;
        com.ss.android.lark.filedetail.impl.detail.templatefactory.b.a(r110, r111.mFileContent.getKey(), r111.mFileContent.getName(), r111.mFileContent.getSize(), false, r104);
        return;
    L21:
        if (r104.length() != 0) goto L23;
    L17:
        r103 = r111.originMergeForwardId;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
