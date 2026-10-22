package wm4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.ss.android.lark.log.Log;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements vm4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f560268a;

    @Inject
    public a(@ApplicationContext Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f560268a = r100;
    }

    @Override // vm4.a
    public final void a(ImageView r100, int r101, FileEntry r102) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Intrinsics.checkNotNullParameter(r102, "fileEntry");
        long r103 = SystemClock.uptimeMillis();
        int r104 = rm4.a.f538544a;
        Drawable r105 = rm4.a.a(r102.f206015c, this.f560268a);
        Log.i("FilePickerV2", "load apk icon du:" + (SystemClock.uptimeMillis() - r103));
        if (r105 == null) goto L6;
        r100.setImageDrawable(r105);
        return;
    L6:
        r100.setImageResource(c.a(r102.f206013a));
    }
}
