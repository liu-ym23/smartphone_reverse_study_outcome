package com.ss.android.lark.chameleonv2.lkapi.widget.picker;

import android.util.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FileInfo;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FilePickerCloseResult;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import itb.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f411521a;

    @Override // itb.f
    public final void onCancel() {
        Callback r100 = this.f411521a.f411519a;
        if (r100 == null) goto L6;
        r100.success(new IWidget$FilePickerCloseResult(new ArrayList()));
        return;
    }

    public c(b r100) {
        this.f411521a = r100;
    }

    @Override // itb.f
    public final void onError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Callback r101 = this.f411521a.f411519a;
        if (r101 == null) goto L6;
        r101.error(new LKAPIError(-1, r100));
        return;
    }

    @Override // itb.f
    public final void onSuccess(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "filePaths");
        b r101 = this.f411521a;
        r101.getClass();
        ArrayList r102 = new ArrayList();
        Iterator<String> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();
        if (r104.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L4;
        VFSFile r106 = VFSFiles.f444819b.i(r104);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L13
        String[] r108 = FileUtils.f285888a;     // Catch: Throwable -> L13
        Object r109 = Result.m9449constructorimpl(Long.valueOf(r106.length()));     // Catch: Throwable -> L13
    L16:
        if (Result.m9452exceptionOrNullimpl(r109) == null) goto L19;
        r109 = Long.valueOf(new PolarisFileWrapper(r104).length());
    L19:
        long r110 = ((Number) r109).longValue();
        String r111 = FileUtils.l(r104);
        String r112 = r106.toUri().toString();
        Intrinsics.checkNotNull(r111);
        String r113 = String.valueOf(r110);
        LruCache<String, String> r114 = l0b.a.f506906a;
        Intrinsics.checkNotNullParameter(r112, "value");
        String r115 = UUID.randomUUID().toString();
        l0b.a.f506906a.put(r115, r112);
        r102.add(new IWidget$FileInfo(r115, r111, r113));
    L13:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L8:
        r105 = false;
        goto L9
    L20:
        Callback r117 = r101.f411519a;
        if (r117 == null) goto L31;
        r117.success(new IWidget$FilePickerCloseResult(r102));
        return;
    }
}
