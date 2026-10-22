package com.ss.android.lark.filedetail.impl.detail;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.FileDetailFragment;
import com.ss.android.lark.filedetail.impl.open.FileOpenUtils;
import com.ss.android.lark.filedetail.impl.open.OpenFileParams;
import com.ss.android.lark.filedetailapi.container.IFileDetailPlugin;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileContent f421630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileTransmissionPresenter.b f421631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f421632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OpenFileParams f421633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FileTransmissionPresenter f421634e;

    public final void b() {
        if (this.f421630a.isEncrypted() == true) goto L11;
        FileTransmissionPresenter.b r100 = this.f421631b;
        if (r100 == null) goto L7;
        UICallbackExecutor.executeDelayed(((FileDetailFragment.c) r100).f421545a.L, 300);
    L7:
        FileContent r101 = this.f421630a;
        String r102 = r101.getFilePath();
        r101.getName();
        String r103 = sfb.c.a(r102);
        String r104 = FileOpenUtils.a(r103);
        VFSFile r105 = sfb.c.b().i(r103);
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r101.setFilePath(r104);
        r105 = sfb.c.b().i(r104);
    L10:
        UICallbackExecutor.execute(new j(this, r101, r105));
        return;
    L11:
        FileContent r106 = this.f421630a;
        String r107 = r106.getFilePath();
        String r108 = r106.getName();
        DecryptFileProcessor.f421551e.getValue().a(this.f421634e.f421585l, r107, r108, new n(this, r106));
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static void a(p r100, final FileContent r101, File r102) {
        String r103 = r100.f421634e.f421587n;
        String r104 = "";
        if (r103 != null) goto L5;
        r101.setMime("");
    L7:
        if (com.ss.android.lark.filedetail.impl.open.c.b(r100.f421634e.d(), r100.f421632c, r101, r100.f421633d) == false) goto L9;
        return;
    L9:
        if (r100.f421633d.isSecret() == false) goto L26;
        final FileTransmissionPresenter r105 = r100.f421634e;
        final OpenFileParams r106 = r100.f421633d;
        r105.getClass();
        String r107 = r101.getFilePath();
        if (r107 == null) goto L14;
        r104 = r107;
    L14:
        Iterator r108 = ((ArrayList) FileDetailController.f421565b).iterator();
    L16:
        if (r108.hasNext() == false) goto L25;
        IFileDetailPlugin r109 = (IFileDetailPlugin) r108.next();
        if ((r109 instanceof gfb.a) == true) goto L19;
        if (r109.canPreview(FileUtils.k(r104)) == false) goto L16;
        FileDetailController.f421566c = r109;
        goto L25
    L19:
        FileUtils.k(r104);
        if (((gfb.a) r109).canPreview() == false) goto L16;
        FileDetailController.f421566c = r109;
    L25:
        UICallbackExecutor.post(new h(r105, r101, r106));
        return;
    L26:
        r100.f421634e.f(r100.f421632c, r102, r101.getMime(), r100.f421634e.f421582i);
        return;
    L5:
        r101.setMime(r103);
        goto L7
    }

    public p(FileTransmissionPresenter r100, FileContent r101, FileDetailFragment.c r102, Context r103, OpenFileParams r104) {
        this.f421634e = r100;
        this.f421630a = r101;
        this.f421631b = r102;
        this.f421632c = r103;
        this.f421633d = r104;
    }
}
