package com.ss.android.lark.widget.photo.preview.video.pip;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f447421a;

    public d(FragmentActivity r100) {
        this.f447421a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f447421a.startActivity(new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS", UriProtector.parse("package:" + this.f447421a.getPackageName())));     // Catch: Exception -> L5
        return;
    L5:
        Log.e("PipModeProcessor", "start picture in picture settings failed.");
    }
}
