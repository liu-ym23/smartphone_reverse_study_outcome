package kza;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes34.dex */
public interface i {
    void a(boolean r100, boolean r101);

    boolean b();

    Object c();

    void d(FragmentActivity r100);

    void f(Context r100, l r101, com.larus.larkfeed.impl.gallery.e r102, boolean r103, boolean r104, GallerySource r105);

    Object g(Continuation<? super Boolean> r100);

    View getView();

    void i(com.larus.larkfeed.impl.gallery.g r100);

    void j(com.larus.larkfeed.impl.gallery.h r100);
}
