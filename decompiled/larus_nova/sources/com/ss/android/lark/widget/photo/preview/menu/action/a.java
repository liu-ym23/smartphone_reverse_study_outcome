package com.ss.android.lark.widget.photo.preview.menu.action;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhotoItem f446836b;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.menu.action.a$a, reason: collision with other inner class name */
    public static final class C5413a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f446837a = null;

        static {
            f446837a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("CopyImageAction", "CopyImageAction: invoke");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String getId() {
        return "COPY_IMAGE";
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String a() {
        return this.f446835a.getString(R.string.Lark_Legacy_Copy);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final boolean isValid() {
        int r100 = this.f446836b.getType();
        MessageIdentity r101 = this.f446836b.getMessageIdentity();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        return false;
    L11:
        if (r100 != 4) goto L13;
    L21:
        return false;
    L13:
        if (r100 == 5) goto L21;
        if (r100 == 7) goto L21;
        if (this.f446836b.getMessageIdentity() != null) goto L22;
        return false;
    L22:
        return true;
    L5:
        if (r101.isHideCopy() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final Runnable getAction() {
        return b.f446837a;
    }

    public a(Context r100, PhotoItem r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "photoItem");
        this.f446835a = r100;
        this.f446836b = r101;
    }
}
