package com.ss.android.lark.widget.photo.preview.menu.action;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f446874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PhotoItem f446875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f446876d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f446877a;

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f446877a;     // Catch: Throwable -> L7
            File r101 = r100.f446875c.getPhotoState().getShowFile().getValue();     // Catch: Throwable -> L7
            if (r100.f446876d == null) goto L10;
            if (r101 == null) goto L14;
            String r102 = com.ss.android.photoeditor.util.b.b(r100.f446873a.getApplicationContext());     // Catch: Throwable -> L7
            r100.f446876d.a(r101.getAbsolutePath(), r102);     // Catch: Throwable -> L7
            return;
        L14:
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(h r100) {
            this.f446877a = r100;
        }
    }

    public interface b {
        void a(String r100, String r101);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String getId() {
        return "EDIT_IMAGE";
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String a() {
        return UIUtils.getString(this.f446873a, R.string.Lark_Legacy_Edit);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final boolean isValid() {
        PhotoItem r100 = this.f446875c;
        return com.ss.android.lark.widget.photopicker.utils.k.a(r100, r100.getPhotoState().getShowFile().getValue(), this.f446874b);
    }

    public h(Context r100, boolean r101, PhotoItem r102, b r103) {
        this.f446873a = r100;
        this.f446874b = r101;
        this.f446875c = r102;
        this.f446876d = r103;
    }
}
